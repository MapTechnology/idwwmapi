package idw.model.rn.integracao.tdba;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ProdutoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.FolhaDTO;
import idw.webservices.dto.FolhasDTO;

public class IntegracaoTDBAFolhaRN extends AIntegracaoTDBA {

	public IntegracaoTDBAFolhaRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	@Override
	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append(
				"select id, cd_ferramenta, revisao, cd_produto, reduzido_estrutura, producaoBrutaPorCiclo, producaoLiquidaPorCiclo, peso_bruto, peso_liquido, tp_interacao from mi_ferramenta_produto where st_registro = 0 order by id");

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
				String cdferramenta = registro[1].toString().trim();
				String revisao = registro[2].toString().trim();
				String cdproduto = registro[3].toString();
				String idreduzido = registro[4].toString();

				Integer producaoBrutaPorCiclo = (Integer) registro[5];
				Integer producaoLiquidaPorCiclo = (Integer) registro[6];
				BigDecimal pesoBruto = (BigDecimal) registro[7];
				BigDecimal pesoLiquido = (BigDecimal) registro[8];

				Short tpinteracao = (Short) registro[9];

				if (tpinteracao == 0) {
					// Inclusao
					incluirFolhaProcesso(daoSessao, id, cdferramenta, revisao, cdproduto, idreduzido, producaoBrutaPorCiclo,
							producaoLiquidaPorCiclo, pesoBruto, pesoLiquido);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;

				} else if (tpinteracao == 1) {
					// Alteracao
					alterarFolhaProcesso(daoSessao, id, cdferramenta, revisao, cdproduto, idreduzido, producaoBrutaPorCiclo, producaoLiquidaPorCiclo, pesoBruto, pesoLiquido);

					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else if (tpinteracao == 2) {
					// exclusao
					excluirFolhaProcesso(daoSessao, id, cdferramenta, revisao, cdproduto, idreduzido, producaoBrutaPorCiclo, producaoLiquidaPorCiclo, pesoBruto, pesoLiquido);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else {
					// tipo interacao desconhecido
					atualizarResultado(id, 2, "tipo interação desconhecido. validos 0-2", "mi_ferramenta_produto");
				}

				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_ferramenta_produto");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "Ferramenta x Produto erro desconhecido " + e.getMessage(), "mi_ferramenta_produto");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;
	}

	private void incluirFolhaProcesso(DAOGenerico daoSessao, BigInteger id, String cdferramenta, String revisao, String cdproduto,
			String idreduzido, Integer producaoBrutaPorCiclo, Integer producaoLiquidaPorCiclo, BigDecimal pesoBruto,
			BigDecimal pesoLiquido) {

		FolhaRN rn = new FolhaRN(daoSessao);
		omcfg = Util.getConfigGeral(daoSessao.getSession());
		DwFolha dwfolha = rn.pesquisaFolhaByCdEStSemRota(cdferramenta + "-" + revisao);
		if (dwfolha != null) {
			DwFolharap dwfolharap = null;
			boolean isExiste = false;
			// verifica se o produto em questao existe na composicao da estrutura da ferramenta. Se nao existir, incluir. Se existir
			// mensagem
			for (DwFolharap dwfolharapAux : dwfolha.getDwFolharaps()) {
				dwfolharap = dwfolharapAux;
				for (DwFolharapcom dwfolharapcom : dwfolharapAux.getDwFolharapcoms()) {
					if (dwfolharapcom.getOmProduto().getCdProduto().equals(cdproduto)
							|| dwfolharapcom.getIdredzproduto().equals((byte) idreduzido.charAt(0))) {
						isExiste = true;
					}
				}
			}
			if (isExiste) {
				atualizarResultado(id, 2, "Folha de processo " + cdferramenta + "-" + revisao + " já existe no idw.",
						"mi_ferramenta_produto");
				return;
			}

			// Pesquisar produto
			ProdutoRN prn = new ProdutoRN(daoSessao);
			OmProduto omproduto;
			try {
				omproduto = prn.getOmProduto(cdproduto);
			} catch (RegistroDesconhecidoException e) {
				atualizarResultado(id, 2,
						"Folha de processo " + cdferramenta + "-" + revisao + " nao incluida pois produto " + cdproduto + " desconhecido.",
						"mi_ferramenta_produto");
				return;
			}

			// Se nao existir a folha rap, incluir
			if (dwfolharap == null) {

				// pesquisar rap
				DwRapRN rrn = new DwRapRN(daoSessao);
				rrn.setCdRap(cdferramenta);
				DwRap dwrap = rrn.pesquisarDwRapByCdRap();
				if (dwrap == null) {
					atualizarResultado(id, 2, "Folha de processo " + cdferramenta + "-" + revisao + " não incluida pois ferramenta "
							+ cdferramenta + " desconhecida", "mi_ferramenta_produto");
					return;
				}

				dwfolharap = new DwFolharap();
				dwfolharap.setIdFolharap(null);
				dwfolharap.setDwRap(dwrap);
				dwfolharap.setDwFolha(dwfolha);
				dwfolha.getDwFolharaps().add(dwfolharap);
			}

			// incluir o novo produto na estrutura
			DwFolharapcom dwfolharapcom = new DwFolharapcom();
			dwfolharapcom.setIdFolharapcom(null);
			dwfolharapcom.setDwFolharap(dwfolharap);
			dwfolharapcom.setIdredzproduto((byte) idreduzido.charAt(0));
			dwfolharapcom.setOmProduto(omproduto);
			dwfolharapcom.setQtTotal(new BigDecimal(producaoBrutaPorCiclo));
			dwfolharapcom.setQtAtiva(new BigDecimal(producaoLiquidaPorCiclo));

			dwfolharap.getDwFolharapcoms().add(dwfolharapcom);

			daoSessao.makePersistent(dwfolha);

			atualizarResultado(id, 1, "Ferramenta x produto " + cdferramenta + "-" + revisao + " incluido com sucesso.",
					"mi_ferramenta_produto");
			qtItensImportados++;

		} else {
			dwfolha = new DwFolha();
			dwfolha.setIdFolha(null);
			dwfolha.setCdFolha(cdferramenta + "-" + revisao);
			dwfolha.setDsFolha(dwfolha.getCdFolha());
			dwfolha.setRevisao(1l);
			dwfolha.setSegSetup(3600);
			dwfolha.setSegCiclopadrao(BigDecimal.ZERO);
			dwfolha.setSegCiclominimo(BigDecimal.ZERO);
			dwfolha.setSegCiclotimeout(new BigDecimal(200));

			// pesquisa ferramenta
			DwRapRN rrn = new DwRapRN(daoSessao);
			rrn.setCdRap(cdferramenta);
			DwRap dwrap = rrn.pesquisarDwRapByCdRap();
			if (dwrap == null) {
				atualizarResultado(id, 2, "Folha de processo " + cdferramenta + "-" + revisao + " não incluida pois ferramenta "
						+ cdferramenta + " desconhecida", "mi_ferramenta_produto");
				return;
			}

			// pesquisa produto
			ProdutoRN prn = new ProdutoRN(daoSessao);
			OmProduto omproduto;
			try {
				omproduto = prn.getOmProduto(cdproduto);
			} catch (RegistroDesconhecidoException e) {
				atualizarResultado(id, 2,
						"Folha de processo " + cdferramenta + "-" + revisao + " nao incluida pois produto " + cdproduto + " desconhecido.",
						"mi_ferramenta_produto");
				return;
			}

			// Pesquisa o GT
			OmGt omgt = omcfg.getOmGtimpcic();

			// Pesquisar tipo de posto CIC
			IntegracaoTDBAPostoRN irn = new IntegracaoTDBAPostoRN(this.dao, this.daoERP);
			OmTppt omtppt = irn.getOmTppt(daoSessao, (short) 0 /* CIC */);
			if (omtppt == null) {
				atualizarResultado(id, 2, "Tipo posto CIC  não encontrado", "mi_ferramenta_produto");
				return;
			}

			DwFolharap dwfolharap = new DwFolharap();
			dwfolharap.setIdFolharap(null);
			dwfolharap.setDwRap(dwrap);
			dwfolharap.setDwFolha(dwfolha);
			dwfolha.getDwFolharaps().add(dwfolharap);

			dwfolha.setOmGt(omgt);
			dwfolha.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			dwfolha.setOmUsrByIdUsrstativo(dwfolha.getOmUsrByIdUsrrevisao());
			dwfolha.setOmTppt(omtppt);

			DwFolharapcom dwfolharapcom = new DwFolharapcom();
			dwfolharapcom.setIdFolharapcom(null);
			dwfolharapcom.setDwFolharap(dwfolharap);
			dwfolharapcom.setIdredzproduto((byte) idreduzido.charAt(0));
			dwfolharapcom.setOmProduto(omproduto);
			dwfolharapcom.setQtTotal(new BigDecimal(producaoBrutaPorCiclo));
			dwfolharapcom.setQtAtiva(new BigDecimal(producaoLiquidaPorCiclo));

			dwfolharap.getDwFolharapcoms().add(dwfolharapcom);

			FolhaDTO dto = new FolhaDTO();
			dto.setFolha(dwfolha);

			dto = rn.setFolhaSemCadastroEtapaDTO(dto);

			if (dto.getResultadoEvento() == dto.getEVENTO_BEM_SUCEDIDO()) {
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Ferramenta x produto " + cdferramenta + "-" + revisao + " incluido com sucesso.",
						"mi_ferramenta_produto");
				qtItensImportados++;
			} else {
				atualizarResultado(id, 2, "Folha processo " + cdferramenta + "-" + revisao + " erro " + dto.getDescricaoResultado(),
						"mi_ferramenta_produto");
			}
		}
	}

	private void alterarFolhaProcesso(DAOGenerico daoSessao, BigInteger id, String cdferramenta, String revisao, String cdproduto,
			String idreduzido, Integer producaoBrutaPorCiclo, Integer producaoLiquidaPorCiclo, BigDecimal pesoBruto,
			BigDecimal pesoLiquido) {

		FolhaRN rn = new FolhaRN(daoSessao);
		omcfg = Util.getConfigGeral(daoSessao.getSession());
		DwFolha dwfolha = rn.pesquisaFolhaByCdEStSemRota(cdferramenta + "-" + revisao);

		if (dwfolha == null) {
			atualizarResultado(id, 2, "Folha de processo " + cdferramenta + "-" + revisao + " não existe no idw.", "mi_ferramenta_produto");
			return;
		}

		DwFolharapcom dwfolharapcom = null;
		boolean isExiste = false;
		// verifica se o produto em questao existe na composicao da estrutura da ferramenta. Se nao existir, incluir. Se existir mensagem
		for (DwFolharap dwfolharapAux : dwfolha.getDwFolharaps()) {
			for (DwFolharapcom dwfolharapcomAux : dwfolharapAux.getDwFolharapcoms()) {
				if (dwfolharapcomAux.getOmProduto().getCdProduto().equals(cdproduto)) {
					dwfolharapcom = dwfolharapcomAux;
					isExiste = true;
				}
			}
		}
		if (isExiste == false) {
			atualizarResultado(id, 2, "Folha de processo " + cdferramenta + "-" + revisao + " não existe no idw.", "mi_ferramenta_produto");
			return;
		}

		dwfolharapcom.setIdredzproduto((byte) idreduzido.charAt(0));
		dwfolharapcom.setQtTotal(new BigDecimal(producaoBrutaPorCiclo));
		dwfolharapcom.setQtAtiva(new BigDecimal(producaoLiquidaPorCiclo));

		// Chamar o metodo de alteracao da folha
		FolhaDTO dto = new FolhaDTO();
		dto.setFolha(dwfolha);

		dto = rn.setFolhaSemCadastroEtapaDTO(dto);

		if (dto.getResultadoEvento() == dto.getEVENTO_BEM_SUCEDIDO()) {
			// Marcar como importado com sucesso
			atualizarResultado(id, 1, "Ferramenta x produto " + cdferramenta + "-" + revisao + " alterado com sucesso.", "mi_ferramenta_produto");
			qtItensImportados++;
		} else {
			atualizarResultado(id, 2, "Folha processo " + cdferramenta + "-" + revisao + " erro " + dto.getDescricaoResultado(),
					"mi_ferramenta_produto");
		}

	}

	
	// O metodo aparagara apenas o produto indicado na folha de processo. se exisitr apenas o produto na folha, entao toda a folha será excluida
	// ou seja, para apagar 1 produto de uma folha que tem mais de 1 sera feita uma alteracao na folha. Uma nova folha sera salva com a exclusao
	// do produto em questão.
	private void excluirFolhaProcesso(DAOGenerico daoSessao, BigInteger id, String cdferramenta, String revisao, String cdproduto,
			String idreduzido, Integer producaoBrutaPorCiclo, Integer producaoLiquidaPorCiclo, BigDecimal pesoBruto,
			BigDecimal pesoLiquido) {
		
		FolhaRN rn = new FolhaRN(daoSessao);
		omcfg = Util.getConfigGeral(daoSessao.getSession());
		DwFolha dwfolha = rn.pesquisaFolhaByCdEStSemRota(cdferramenta + "-" + revisao);

		if (dwfolha == null) {
			atualizarResultado(id, 2, "Folha de processo " + cdferramenta + "-" + revisao + " não existe no idw.", "mi_ferramenta_produto");
			return;
		}
		DwFolharap dwfolharap = null;
		
		Set<DwFolharapcom> listaDwfolharapcom = new HashSet<>(0);
		boolean isExiste = false;
		// verifica se o produto em questao existe na composicao da estrutura da ferramenta. Se nao existir, incluir. Se existir mensagem
		for (DwFolharap dwfolharapAux : dwfolha.getDwFolharaps()) {
			for (DwFolharapcom dwfolharapcomAux : dwfolharapAux.getDwFolharapcoms()) {
				if (dwfolharapcomAux.getOmProduto().getCdProduto().equals(cdproduto)) {
					dwfolharap = dwfolharapAux;
					isExiste = true;
				} else {
					listaDwfolharapcom.add(dwfolharapcomAux);
				}
			}
		}
		if (isExiste == false) {
			atualizarResultado(id, 2, "Folha de processo " + cdferramenta + "-" + revisao + " não existe no idw.", "mi_ferramenta_produto");
			return;
		}

		if (listaDwfolharapcom.isEmpty()) {
			FolhaDTO dto = new FolhaDTO();
			dto.setFolha(dwfolha);
			FolhasDTO folhasDTO = new FolhasDTO();
			folhasDTO.setFolhas(new ArrayList<FolhaDTO>());
			folhasDTO.getFolhas().add(dto);
			folhasDTO = rn.removeFolhasDTO(folhasDTO);
			
			if (folhasDTO.getFolhas().get(0).getResultadoEvento() == dto.getEVENTO_BEM_SUCEDIDO()) {
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Ferramenta x produto " + cdferramenta + "-" + revisao + " excluido com sucesso.", "mi_ferramenta_produto");
				qtItensImportados++;
			} else {
				atualizarResultado(id, 2, "Folha processo " + cdferramenta + "-" + revisao + " erro " + folhasDTO.getFolhas().get(0).getDescricaoResultado(), "mi_ferramenta_produto");
			}

		
		
		} else {
			// Chamar o metodo de alteracao da folha
			FolhaDTO dto = new FolhaDTO();
			DwFolha dwfolhaAux = new DwFolha();
			dwfolhaAux.setIdFolha(dwfolha.getIdFolha());
			dto.setFolha(dwfolhaAux);
			
			FolhasDTO folhas = rn.getFolhasDTO(dto);
			
			
			dto = folhas.getFolhas().get(0);
			
			DwFolharap rapAux = dto.getFolha().getDwFolharaps().iterator().next();
			
			rapAux.setDwFolharapcoms(listaDwfolharapcom);
			
			dto.getFolha().setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			dto.getFolha().setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
			
			
			dto = rn.setFolhaSemCadastroEtapaDTO(dto);
	
			if (dto.getResultadoEvento() == dto.getEVENTO_BEM_SUCEDIDO()) {
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Ferramenta x produto " + cdferramenta + "-" + revisao + " alterado com sucesso.", "mi_ferramenta_produto");
				qtItensImportados++;
			} else {
				atualizarResultado(id, 2, "Folha processo " + cdferramenta + "-" + revisao + " erro " + dto.getDescricaoResultado(), "mi_ferramenta_produto");
			}
		}
	}





	public boolean integrarCiclos(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append(
				"select id, cd_ferramenta, revisao, cd_posto, temp_ciclo from mi_tempo_ciclo where st_registro = 0 order by id");

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
				String cdferramenta = registro[1].toString().trim();
				String revisao = registro[2].toString().trim();
				String cdposto = registro[3].toString();

				BigDecimal tempoCiclo = (BigDecimal) registro[4];

				// Inclusao
				incluirFolhaCiclo(daoSessao, id, cdferramenta, revisao, cdposto, tempoCiclo);
				// se falhou alguma importacao setar retorno como false
				if (getStregistro() != 1)
					retorno = false;


				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_tempo_ciclo");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "Ferramenta x Posto erro desconhecido " + e.getMessage(), "mi_tempo_ciclo");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;
	}

	private void incluirFolhaCiclo(DAOGenerico daoSessao, BigInteger id, String cdferramenta, String revisao, String cdposto,
			BigDecimal tempoCiclo) {
		
		
		FolhaRN rn = new FolhaRN(daoSessao);
		omcfg = Util.getConfigGeral(daoSessao.getSession());
		DwFolha dwfolha = rn.pesquisaFolhaByCdEStSemRota(cdferramenta + "-" + revisao);
		if (dwfolha == null) {
			atualizarResultado(id, 2, "Ferramenta x Posto folha desconhecida " + cdferramenta + "-" + revisao, "mi_tempo_ciclo");
			return;
		}
		
		// Verifica se existe o cdposto
		PTRN prn = new PTRN(daoSessao);
		OmPt ompt;
		try {
			ompt = prn.getOmPt(cdposto);
		} catch (RegistroDesconhecidoException e) {
			ompt = null;
		}
		if (ompt == null) {
			atualizarResultado(id, 2, "Ferramenta x Posto posto desconhecido " + cdposto, "mi_tempo_ciclo");
			return;
		}
		
		
		// Verifica se ja existe em dwFolhacic
		DwFolhacic dwfolhacic;
		try {
			dwfolhacic = rn.getFolhacic(dwfolha, ompt);
		} catch (SemCicloPadraoException e) {
			dwfolhacic = null;
		}
		if (dwfolhacic != null) {
			atualizarResultado(id, 2, "Ferramenta x Posto tempo ciclo já cadastrado" , "mi_tempo_ciclo");
			return;
		}
		
		// Se nao tem ciclo padrao definido entao definir o 1o ou se o ciclo proposto ja eh o padrao da folha
		if (dwfolha.getSegCiclopadrao().compareTo(BigDecimal.ZERO) == 0 ||
				dwfolha.getSegCiclopadrao().compareTo(tempoCiclo) == 0
				) {
			dwfolha.setSegCiclopadrao(tempoCiclo);
			daoSessao.makePersistent(dwfolha);
			qtItensImportados++;
			atualizarResultado(id, 1, "Ferramenta x Posto importado com sucesso", "mi_tempo_ciclo");
			return;
		}
		
		// Se chegar nesse ponto é porque a folha tem um ciclo padrao definido e é diferente do ciclo padrao proposto para esse posto
		// nesse caso devemos incluir um novo registro em dwfolhacic
		
		// pesquisar a folha clonando
		FolhaDTO dto = new FolhaDTO();
		DwFolha dwfolhaAux = new DwFolha();
		dwfolhaAux.setIdFolha(dwfolha.getIdFolha());
		dto.setFolha(dwfolhaAux);
		
		FolhasDTO folhas = rn.getFolhasDTO(dto);
		dto = folhas.getFolhas().get(0);

		
		// incluir em dwfolhacic
		dwfolhacic = new DwFolhacic();
		dwfolhacic.setIdFolhacic(null);
		dwfolhacic.setOmPt(ompt);
		dwfolhacic.setSegCiclopadrao(tempoCiclo);
		dto.getFolha().getDwFolhacics().add(dwfolhacic);
		
		// salvar a folha, alterando a revisao
		dto = rn.setFolhaSemCadastroEtapaDTO(dto);

		if (dto.getResultadoEvento() == dto.getEVENTO_BEM_SUCEDIDO()) {
			// Marcar como importado com sucesso
			atualizarResultado(id, 1, "Ferramenta x posto " + cdferramenta + "-" + revisao + " incluido com sucesso.", "mi_tempo_ciclo");
			qtItensImportados++;
		} else {
			atualizarResultado(id, 2, "Folha ciclo " + cdferramenta + "-" + revisao + " erro " + dto.getDescricaoResultado(), "mi_tempo_ciclo");
		}
		
		
	}

}
