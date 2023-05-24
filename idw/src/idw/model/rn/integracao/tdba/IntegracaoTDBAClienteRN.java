package idw.model.rn.integracao.tdba;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.PpCliente;
import idw.model.pojos.template.PpClienteTemplate;
import idw.model.rn.ClienteRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PpClienteRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.PpClienteDTO;

public class IntegracaoTDBAClienteRN extends AIntegracaoTDBA {

	public IntegracaoTDBAClienteRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	@Override
	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append(
				"select id, idempresa, idarea, cd_cliente, ds_cliente, tp_interacao from mi_cliente_idw where st_registro = 0 order by id");

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
				String cdcliente = registro[3].toString();
				String dscliente = registro[4].toString();
				Short tpinteracao = (Short) registro[5];

				if (tpinteracao == 0) {
					// Inclusao
					incluirCliente(daoSessao, id, cdcliente, dscliente, idArea);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;

				} else if (tpinteracao == 1) {
					// Alteracao
					alterarCliente(daoSessao, id, cdcliente, dscliente, idArea);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else if (tpinteracao == 2) {
					// exclusao
					excluirCliente(daoSessao, id, cdcliente);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else {
					// tipo interacao desconhecido
					atualizarResultado(id, 2, "tipo interação desconhecido. validos 0-2", "mi_cliente_idw");
				}

				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_cliente_idw");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "Cliente erro desconhecido " + e.getMessage(), "mi_cliente_idw");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;

	}

	private void incluirCliente(DAOGenerico daoSessao, BigInteger id, String cdcliente, String dscliente, String idArea) {
		PpClienteRN rn = new PpClienteRN(daoSessao);
		ClienteRN crn = new ClienteRN(daoSessao);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		PpCliente ppcliente = crn.pesquisarByCdClienteEStAtivo(cdcliente);
		if (ppcliente != null) {
			atualizarResultado(id, 2, "Cliente " + cdcliente + " já existe no idw.", "mi_cliente_idw");
		} else {
			// Incluir dados do cliente
			ppcliente = new PpCliente();
			ppcliente.setIdCliente(null);
			ppcliente.setCdCliente(cdcliente);
			ppcliente.setDtRevisao(DataHoraRN.getDataHoraAtual());
			ppcliente.setNmCliente(dscliente);
			ppcliente.setTpCliente(PpClienteTemplate.TpCliente.PESSOA_JURIDICA.getValue());
			ppcliente.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			ppcliente.setOmUsrByIdUsrstativo(ppcliente.getOmUsrByIdUsrrevisao());
			PpClienteDTO clientedto = new PpClienteDTO();
			clientedto.setPpCliente(ppcliente);
			PpClienteDTO retorno = rn.setPpClienteDTO(clientedto);

			// no momento nao existe um retorno com erro para esse metodo
//			if (retorno) {
//				
//			}
			// Marcar como importado com sucesso
			atualizarResultado(id, 1, "Cliente " + cdcliente + " incluido com sucesso.", "mi_cliente_idw");
			qtItensImportados++;
		}
	}


	private void alterarCliente(DAOGenerico daoSessao, BigInteger id, String cdcliente, String dscliente, String idArea) {
		PpClienteRN rn = new PpClienteRN(daoSessao);
		ClienteRN crn = new ClienteRN(daoSessao);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		PpCliente ppcliente = crn.pesquisarByCdClienteEStAtivo(cdcliente);
		if (ppcliente == null) {
			atualizarResultado(id, 2, "Cliente " + cdcliente + " NÃO existe no idw.", "mi_cliente_idw");
		} else {
			ppcliente.setNmCliente(dscliente);
			ppcliente.setTpCliente(PpClienteTemplate.TpCliente.PESSOA_JURIDICA.getValue());
			ppcliente.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			ppcliente.setOmUsrByIdUsrstativo(ppcliente.getOmUsrByIdUsrrevisao());
			PpClienteDTO clientedto = new PpClienteDTO();
			clientedto.setPpCliente(ppcliente);
			rn.setPpClienteDTO(clientedto);
			
			// Marcar como importado com sucesso
			atualizarResultado(id, 1, "Cliente " + cdcliente + " alterado com sucesso.", "mi_cliente_idw");
			qtItensImportados++;
		}

	}




	private void excluirCliente(DAOGenerico daoSessao, BigInteger id, String cdcliente) {
		PpClienteRN rn = new PpClienteRN(daoSessao);
		ClienteRN crn = new ClienteRN(daoSessao);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		PpCliente ppcliente = crn.pesquisarByCdClienteEStAtivo(cdcliente);
		if (ppcliente == null) {
			atualizarResultado(id, 2, "Cliente " + cdcliente + " NÃO existe no idw.", "mi_cliente_idw");
		} else {
			try {
				rn.desativarCliente(ppcliente.getIdCliente(), DataHoraRN.getDataHoraAtual(), omcfg.getOmUsrimpprog());
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Cliente " + cdcliente + " excluido com sucesso.", "mi_cliente_idw");
				qtItensImportados++;
			} catch (RegistroJaDesativadoException e) {
				atualizarResultado(id, 2, "Cliente " + cdcliente + " já estava excluido.", "mi_cliente_idw");
			} catch (Exception e) {
				e.printStackTrace();
				atualizarResultado(id, 2, "Cliente " + cdcliente + " erro desconhecido. " + e.getMessage(), "mi_cliente_idw");
			}
			
		}
	}
}
