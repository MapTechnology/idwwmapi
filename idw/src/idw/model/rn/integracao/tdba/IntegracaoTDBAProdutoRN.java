package idw.model.rn.integracao.tdba;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.PpCliente;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ProdutoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.ProdutoDTO;

public class IntegracaoTDBAProdutoRN extends AIntegracaoTDBA {

	public IntegracaoTDBAProdutoRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	@Override
	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append("select id, idempresa, idarea, cd_produto, ds_produto, tp_produto, tp_interacao, unidade_medida, valor_unitario, peso_bruto, peso_liquido, apontar_ERP from mi_produto_idw where st_registro = 0 order by id");

		List<Object> lista = q.querySQL().list();

		// Abrir DAO com session
		DAOGenerico daoSessao = new DAOGenerico();

		BigInteger id = BigInteger.ZERO;
		
		try {

			daoSessao.iniciaConexaoBanco();

			for (Object linha : lista) {
				Date dthr = DataHoraRN.getDataHoraAtual();
				Object[] registro = (Object[]) linha;

				id = (BigInteger) registro[0];
				// String idEmpresa = registro[1].toString();
				String idArea = registro[2].toString().trim();
				String cdproduto = registro[3].toString();
				String dsproduto = registro[4].toString();
				Short tpProduto = (Short) registro[5];
				Short tpinteracao = (Short) registro[6];
				Integer unidadeMonetaria = (Integer) registro[7];
				BigDecimal valorMonetario = (BigDecimal) registro[8];
				BigDecimal pesoBruto = (BigDecimal) registro[9];
				BigDecimal pesoLiquido = (BigDecimal) registro[10];
				Integer isApontarERP = (Integer) registro[11];

				if (tpinteracao == 0) {
					// Inclusao
					incluirProduto(daoSessao, id, cdproduto, dsproduto, idArea, tpProduto, unidadeMonetaria, valorMonetario, pesoBruto, pesoLiquido, isApontarERP);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;

				} else if (tpinteracao == 1) {
					// Alteracao
					alterarProduto(daoSessao, id, cdproduto, dsproduto, idArea, tpProduto, unidadeMonetaria, valorMonetario, pesoBruto, pesoLiquido, isApontarERP);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else if (tpinteracao == 2) {
					// exclusao
					excluirProduto(daoSessao, id, cdproduto);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else {
					// tipo interacao desconhecido
					atualizarResultado(id, 2, "tipo interação desconhecido. validos 0-2", "mi_produto_idw");
				}

				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_produto_idw");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "Produto erro desconhecido " + e.getMessage(), "mi_produto_idw");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;
	}

	private void incluirProduto(DAOGenerico daoSessao, BigInteger id, String cdproduto, String dsproduto, String idArea, Short tpProduto, Integer unidadeMonetaria, BigDecimal valorMonetario, BigDecimal pesoBruto, BigDecimal pesoLiquido, Integer isApontarERP) {
		ProdutoRN rn = new ProdutoRN(daoSessao);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa produto. Se nao existir marcar como erro na importacao
		OmProduto omproduto;
		try {
			omproduto = rn.getOmProduto(cdproduto);
		} catch (RegistroDesconhecidoException e) {
			omproduto = null;
		}
		if (omproduto != null) {
			atualizarResultado(id, 2, "Produto " + cdproduto + " já existe no idw.", "mi_produto_idw");
		} else {
			// Incluir dados do cliente
			omproduto = new OmProduto();
			omproduto.setIdProduto(0l);
			omproduto.setCdProduto(cdproduto);
			omproduto.setDtRevisao(DataHoraRN.getDataHoraAtual());
			omproduto.setDsProduto(dsproduto);
			omproduto.setTpProduto(OmProdutoTemplate.TpProduto.PRODUTO_FINAL.getId());
			omproduto.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			omproduto.setOmUsrByIdUsrstativo(omproduto.getOmUsrByIdUsrrevisao());
			omproduto.setGPesoBruto(pesoBruto);
			omproduto.setGPesoLiquido(pesoLiquido);
			omproduto.setVlCustounit(valorMonetario);
			omproduto.setOmProgrp(new OmProgrp());
			omproduto.getOmProgrp().setCdProgrp("");
			omproduto.setTpSemiacabado(null);
			omproduto.setPpCliente(null);


			ProdutoDTO dto = new ProdutoDTO();
			dto.setProduto(omproduto);
			
			ProdutoDTO retorno = rn.setProdutoDTO(dto);

			if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Produto " + cdproduto + " incluido com sucesso.", "mi_produto_idw");
				qtItensImportados++;
			} else {
				atualizarResultado(id, 2, "Produto " + cdproduto + " com erro " + retorno.getDescricaoResultado(retorno.getResultadoEvento()), "mi_produto_idw");
			}
			
			daoERP.flushReiniciandoTransacao();
		}
	}

	private void alterarProduto(DAOGenerico daoSessao, BigInteger id, String cdproduto, String dsproduto, String idArea, Short tpProduto, Integer unidadeMonetaria, BigDecimal valorMonetario, BigDecimal pesoBruto, BigDecimal pesoLiquido, Integer isApontarERP) {
		ProdutoRN rn = new ProdutoRN(daoSessao);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa produto. Se nao existir marcar como erro na importacao
		OmProduto omproduto;
		try {
			omproduto = rn.getOmProduto(cdproduto);
		} catch (RegistroDesconhecidoException e) {
			omproduto = null;
		}
		if (omproduto == null) {
			atualizarResultado(id, 2, "Produto " + cdproduto + " NÃO existe no idw.", "mi_produto_idw");
		} else {
			// Alteração dados do produto
			omproduto.setDtRevisao(DataHoraRN.getDataHoraAtual());
			omproduto.setDsProduto(dsproduto);
			omproduto.setTpProduto(OmProdutoTemplate.TpProduto.PRODUTO_FINAL.getId());
			omproduto.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			omproduto.setOmUsrByIdUsrstativo(omproduto.getOmUsrByIdUsrrevisao());
			omproduto.setGPesoBruto(pesoBruto);
			omproduto.setGPesoLiquido(pesoLiquido);
			omproduto.setVlCustounit(valorMonetario);
			omproduto.setOmProgrp(null);
			omproduto.setTpSemiacabado(null);
			omproduto.setPpCliente(null);


			ProdutoDTO dto = new ProdutoDTO();
			dto.setProduto(omproduto);
			
			ProdutoDTO retorno = rn.setProdutoDTO(dto);

			if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Produto " + cdproduto + " alterado com sucesso.", "mi_produto_idw");
				qtItensImportados++;
			} else {
				atualizarResultado(id, 2, "Produto " + cdproduto + " com erro " + retorno.getDescricaoResultado(retorno.getResultadoEvento()), "mi_produto_idw");
			}
		}
	}

	private void excluirProduto(DAOGenerico daoSessao, BigInteger id, String cdproduto) {
		ProdutoRN rn = new ProdutoRN(daoSessao);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa produto. Se nao existir marcar como erro na importacao
		OmProduto omproduto;
		try {
			omproduto = rn.getOmProduto(cdproduto);
		} catch (RegistroDesconhecidoException e) {
			omproduto = null;
		}
		if (omproduto == null) {
			atualizarResultado(id, 2, "Produto " + cdproduto + " NÃO existe no idw.", "mi_produto_idw");
		} else {
			try {
				rn.desativarProduto(omproduto.getIdProduto(), DataHoraRN.getDataHoraAtual(), omcfg.getOmUsrimpprog());
				
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Produto " + cdproduto + " excluido com sucesso.", "mi_produto_idw");
				qtItensImportados++;
			} catch (RegistroJaDesativadoException e) {
				atualizarResultado(id, 2, "Produto " + cdproduto + " já excluído no idw.", "mi_produto_idw");
			} catch (Exception e) {
				e.printStackTrace();
				atualizarResultado(id, 2, "Produto " + cdproduto + " com erro desconhecido. " + e.getMessage(), "mi_produto_idw");
			}
		}
	}

}
