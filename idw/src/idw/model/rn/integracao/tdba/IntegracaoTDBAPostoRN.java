package idw.model.rn.integracao.tdba;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.GTRN;
import idw.model.rn.PTRN;
import idw.model.rn.TpptRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.PtDTO;

public class IntegracaoTDBAPostoRN extends AIntegracaoTDBA {

	public IntegracaoTDBAPostoRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append("select id, idempresa, idarea, cd_posto, ds_posto, tp_posto, tp_interacao from mi_posto_idw where st_registro = 0 order by id");

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
//				String idEmpresa = registro[1].toString();
				String idArea = registro[2].toString().trim();
				String cdposto = registro[3].toString();
				String dsposto = registro[4].toString();
				Short tpposto = (Short) registro[5];
				Short tpinteracao = (Short) registro[6];

				if (tpinteracao == 0) {
					// Inclusao
					incluirPosto(daoSessao, id, cdposto, dsposto, idArea, tpposto);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
					
				} else if (tpinteracao == 1) {
					// Alteracao
					alterarPosto(daoSessao, id, cdposto, dsposto, idArea, tpposto);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else if (tpinteracao == 2) {
					// exclusao
					excluirPosto(daoSessao, id, cdposto);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else {
					// tipo interacao desconhecido
					atualizarResultado(id, 2, "tipo interaçãoo desconhecido. validos 0-2", "mi_posto_idw");
				}

				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_posto_idw");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "Posto erro desconhecido " + e.getMessage(), "mi_posto_idw");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;
	}

	/*
	 * Metodo para inclusao do posto
	 * 
	 */
	private void incluirPosto(DAOGenerico daoSessao, BigInteger id, String cdposto, String dsposto, String idArea, Short tpposto) {
		PTRN rn = new PTRN(daoSessao);
		GTRN grn = new GTRN();
		grn.setDao(daoSessao);
		grn.setSession(daoSessao.getSession());

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdposto);
		} catch (RegistroDesconhecidoException e) {
			ompt = null;
		}
		if (ompt != null) {
			atualizarResultado(id, 2, "Posto " + cdposto + " já existe no idw.", "mi_posto_idw");
		} else {
			// Incluir dados no posto
			ompt = new OmPt();
			ompt.setIdPt(null);
			ompt.setCdPt(cdposto);
			ompt.setDtRevisao(DataHoraRN.getDataHoraAtual());
			ompt.setDsCurta(cdposto);
			ompt.setDsPt(dsposto);
			ompt.setTpImpprog((byte) 1);
			ompt.setTpSessao((byte) 1);

			OmGt omgt = grn.getOmGtByCdGt(idArea);
			if (omgt == null) {
				atualizarResultado(id, 2, "Posto " + cdposto + " não encontrou grupo " + idArea, "mi_posto_idw");
			} else {
				
				// Avaliar o tipo do posto.
				OmTppt omtppt;

				omtppt = getOmTppt(daoSessao, tpposto);

				if (omtppt == null) {
					atualizarResultado(id, 2, "Posto " + cdposto + " não encontrou tipo posto " + tpposto, "mi_posto_idw");
				} else {
					ompt.setOmGt(omgt);
					ompt.setOmTppt(omtppt);
					ompt.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
					ompt.setOmUsrByIdUsrstativo(ompt.getOmUsrByIdUsrrevisao());
					PtDTO pt = new PtDTO();
					pt.setPt(ompt);
					PtDTO retorno = rn.setPtDTO(pt);
					if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
						// Marcar como importado com sucesso
						atualizarResultado(id, 1, "Posto " + cdposto + " incluido com sucesso.", "mi_posto_idw");
						qtItensImportados++;
					} else {
						atualizarResultado(id, 2, "Posto " + cdposto + " erro " + retorno.getResultadoEvento(), "mi_posto_idw");
					}
				}
			}
		}

	}

	public OmTppt getOmTppt(DAOGenerico daoSessao, Short tpposto) {
		String cdtppt;
		if (tpposto == 0) {
			// posto ciclico
			cdtppt = "CIC"; // poderia vim da configuracao geral, mas ainda nao existe la
		} else
			cdtppt = "";

		TpptRN rn = new TpptRN(daoSessao);

		OmTppt retorno = rn.getOmTpptByCd(cdtppt);

		return retorno;
	}

	/*
	 * Metodo para alteracao do posto. Altera apenas o grupo de trabalho e o tipo
	 */
	private void alterarPosto(DAOGenerico daoSessao, BigInteger id, String cdposto, String dsposto, String idArea, Short tpposto) {
		PTRN rn = new PTRN(daoSessao);
		GTRN grn = new GTRN();
		grn.setDao(daoSessao);
		grn.setSession(daoSessao.getSession());

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdposto);
		} catch (RegistroDesconhecidoException e) {
			ompt = null;
		}
		if (ompt == null) {
			atualizarResultado(id, 2, "Posto " + cdposto + " NÃO existe no idw.", "mi_posto_idw");
		} else {
			// Alterar dados no posto
			ompt.setDsPt(dsposto);
			ompt.setTpImpprog((byte) 1);
			ompt.setTpSessao((byte) 1);

			OmGt omgt = grn.getOmGtByCdGt(idArea);
			if (omgt == null) {
				atualizarResultado(id, 2, "Posto " + cdposto + " não encontrou grupo " + idArea, "mi_posto_idw");
			} else {
				
				// Avaliar o tipo do posto.
				OmTppt omtppt;

				omtppt = getOmTppt(daoSessao, tpposto);

				if (omtppt == null) {
					atualizarResultado(id, 2, "Posto " + cdposto + " não encontrou tipo posto " + tpposto, "mi_posto_idw");
				} else {
					ompt.setOmGt(omgt);
					ompt.setOmTppt(omtppt);
					ompt.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
					ompt.setOmUsrByIdUsrstativo(ompt.getOmUsrByIdUsrrevisao());
					PtDTO pt = new PtDTO();
					pt.setPt(ompt);
					PtDTO retorno = rn.setPtDTO(pt);
					if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
						atualizarResultado(id, 2, "Posto " + cdposto + " erro " + retorno.getResultadoEvento(), "mi_posto_idw");
					} else {
						// Marcar como importado com sucesso
						atualizarResultado(id, 1, "Posto " + cdposto + " alterado com sucesso.", "mi_posto_idw");
						qtItensImportados++;
					}
				}
			}
		}
	}

	/*
	 * Metodo para exclusao do posto de trabalho
	 */
	private void excluirPosto(DAOGenerico daoSessao, BigInteger id, String cdposto) {
		PTRN rn = new PTRN(daoSessao);

		// pesquisa PT. Se nao existir marcar como erro na importacao
		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdposto);
		} catch (RegistroDesconhecidoException e) {
			ompt = null;
		}
		if (ompt == null) {
			atualizarResultado(id, 2, "Posto " + cdposto + " não existe no idw.", "mi_posto_idw");
		} else {
			// Marcar como excluido
			try {
				rn.desativarOmPt(ompt.getIdPt(), DataHoraRN.getDataHoraAtual(), omcfg.getOmUsrimpprog());
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Posto " + cdposto + " excluido com sucesso.", "mi_posto_idw");
				qtItensImportados++;
			} catch (RegistroJaDesativadoException e) {
				atualizarResultado(id, 2, "Posto " + cdposto + " já excluído no idw.", "mi_posto_idw");
			} catch (Exception e) {
				e.printStackTrace();
				atualizarResultado(id, 2, "Posto " + cdposto + " com erro desconhecido. " + e.getMessage(), "mi_posto_idw");
			}
		}
	}

}
