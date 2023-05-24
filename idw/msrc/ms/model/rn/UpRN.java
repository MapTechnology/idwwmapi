package ms.model.rn;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.SQLGrammarException;
import org.jfree.util.Log;
 
import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.dao.agramkow.DAOGenericoAgramkow;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsIhm;
import idw.model.pojos.MsMs;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsMsihm;
import idw.model.pojos.MsPerfilandon;
import idw.model.pojos.MsPtColeta;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUpOp;
import idw.model.pojos.MsUpihm;
import idw.model.pojos.MsUpopLeituras;
import idw.model.pojos.MsUsr;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.agramkow.FailcodeLanguages;
import idw.model.pojos.agramkow.ResultsHeader;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.AcaoRN;
import idw.model.rn.AreaRN;
import idw.model.rn.CIPRN;
import idw.model.rn.CausaRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.JustificativaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ResumoRetornoRegistrosRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.VerificaDefeitoRN;
import idw.model.rn.cp.ObtemOPSingleton;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.monitorizacao.MonitorizacaoVisaoMaquinaRN;
import idw.model.rn.monitorizacao.ObjetoNaTelaFactory;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DadosProdutoSADTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.ErroInsersoraDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.MontagensDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO; 
import idw.webservices.rest.idw.v2.dto.IhmUpDTO2;
import idw.webservices.rest.idw.v2.dto.ListaPTsDTO;
import idw.webservices.rest.idw.v2.dto.ListaUPsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.PtDTO2;
import idw.webservices.rest.idw.v2.dto.UpDTO2; 
import injetws.model.IwsFacade;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrConexoesInjet;
import injetws.model.pojos.PrUp;
import injetws.model.rn.InfoRN;
import injetws.model.rn.ParadaRN;
import injetws.model.rn.ProducaoRN;
import injetws.model.rn.UtilRN;
import injetws.model.rn.injet.InjetInfoRN;
import injetws.model.rn.injet.InjetParadaRN;
import injetws.model.rn.injet.InjetRefugoRN;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsUpDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.agramkowsql.AgramkowSqlRN;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.excessao.UpDesconhecidoException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.ListaUPDTO;
import ms.model.dto.ResultadoMSDTO;
import ms.model.dto.UpDTO;
import ms.model.dto.UpIhmDTO;
import ms.util.ConversaoTipos;

public class UpRN extends UpDTO implements IDao {
	/**
	 *
	 */
	private static final long serialVersionUID = 8669450877287141345L;
	private transient DAOGenerico daoPdba = null;
	private transient DAOGenericoInjet daoInjet = null;
	
	private boolean usarTransacao = true;

	// Alessandre: aqui, nao iniciar o daoInjet quando nao for necessario. Nao
	// eh necessario qdo o idw funcionar independente do injet

	public UpRN() {
		if (daoPdba == null)
			daoPdba = new DAOGenerico();
		if (daoInjet == null && Stubdelegate.getInstancia().isInjetAtivo() == true)
			daoInjet = new DAOGenericoInjet();
	}

	public UpRN(DAOGenerico dao, DAOGenericoInjet daoInjet) {
		this.daoPdba = dao;
		this.daoInjet = daoInjet;
	}

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		iniciaConexaoBanco(sessao, null, 0, 0);
	}

	public void iniciaConexaoBanco(Session sessao, IdwLogger log, int idLog, int identacao) {
		try {
			if (log != null)
				log.info(idLog, identacao, "Abrindo conexao para idw");

			if (sessao != null) {
				daoPdba.setSession(sessao);
			} else {
				daoPdba.iniciaSessao();
				daoPdba.iniciaTransacao();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (daoInjet != null && Stubdelegate.getInstancia().isInjetAtivo() == true) {
				if (log != null)
					log.info(idLog, identacao, "Abrindo conexao para injet");
				daoInjet.iniciaSessao();
				daoInjet.iniciaTransacao();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Esse metodo esta depreciado porque deve ser substituido pelo metodo que
	// recebe o log
	@Override
	@Deprecated
	public void finalizaConexaoBanco() {
		daoPdba.finalizaTransacao();
		daoPdba.finalizaSessao();
		try {
			if (daoInjet != null && Stubdelegate.getInstancia().isInjetAtivo() == true) {
				daoInjet.finalizaTransacao();
				daoInjet.finalizaSessao();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}

	public void finalizaConexaoBanco(IdwLogger log) {
		try {
			daoPdba.finalizaTransacao();
			daoPdba.finalizaSessao();
		} catch (Exception e) {
			log.error(e);
		}
		try {
			if (daoInjet != null && Stubdelegate.getInstancia().isInjetAtivo() == true) {
				daoInjet.finalizaTransacao();
				daoInjet.finalizaSessao();
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public DAOGenerico getDaoPdba() {
		return this.daoPdba;
	}

	public void setDaoPdba(DAOGenerico dao) {
		this.daoPdba = dao;
	}

	public DAOGenericoInjet getDaoInjet() {
		return this.daoInjet;
	}

	public void setDaoInjet(DAOGenericoInjet dao) {
		this.daoInjet = dao;
	}

	public void setUpDTO(UpDTO updto) {
		this.setIdUp(updto.getIdUp());
		this.setCd_up(updto.getCd_up());
		this.setIdTppt(updto.getIdTppt());
		this.setIdUpPDBA(updto.getIdUpPDBA());
		this.setDs_up(updto.getDs_up());
		this.setRevisao(updto.getRevisao());
		this.setDthrRevisao(updto.getDthrRevisao());
		this.setStAtivo(updto.getStAtivo());
		this.setDthrStativo(updto.getDthrStativo());
		this.setLoginUsuario(updto.getLoginUsuario());
		this.setUpihmColetados(updto.getUpihmColetados());
		this.setCdBc(updto.getCdBc());
	}

	public IwsConsultaDTO consultaIHMInjet(MensagemRecebida mensagem, EventoColetado evento) {
		InfoRN iRN = new InfoRN(daoInjet, daoPdba);

		UpRN u = new UpRN();
		u.setDaoPdba(daoPdba);
		IwsConsultaDTO consulta = null;
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			try {
				consulta = iRN.setTr_Consula(evento.getLog(), 0, evento.getCdconsulta(), evento.getIcUpDTO().getUpDTO().getIdUpPDBA(),
						DataHoraRN.getDataHoraAtual());
				return consulta;
			} catch (SemSGBDException e) {
				consulta = null;
			}
		}
		return consulta;
	}

	public boolean apagaUltimoRefugo(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();

		OmPt pt = new OmPt();
		PTRN ptrn = new PTRN(daoPdba);
		if (evento.getIcUpDTO().getUpDTO().getCd_up() != null) {
			try {
				pt = ptrn.getOmPt(evento.getIcUpDTO().getUpDTO().getCd_up());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				return false;
			}
		}
		if (pt != null) {
			// Encontrar DwRt para se usado como base dos dados
			TempoRealRN rn = new TempoRealRN(getDaoPdba());
			DwRt dwrt = null;
			dwrt = rn.getUltimoDwRt(pt.getIdPt());
			if (dwrt != null && dwrt.getPpCp() != null) {
				evento.setCdop(dwrt.getPpCp().getCdCp());
			}
		}

		// Se o injet estiver ativo entao incluir o evento
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			// Pesquisar o ultimo refugo, pois o APK nao esta enviando o cdrefugo
			IwsRefugoDTO dto = IwsFacade.getInstancia().getInfoUltimoRefugo(evento.getIcUpDTO().getUpDTO().getIdUpPDBA());

			IwsFacade.getInstancia().setTr_ApagaUltimoRefugo(
					dto.getCdRefugo(),
					dto.getIdReduzidaProd(),
					dto.getDthrUltRefugo(),
					String.valueOf(dto.getMilissegundos()),
					evento.getIcUpDTO().getUpDTO().getIdUpPDBA(),
					evento.getDthrEvento());
		}

		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		MsEvt msevt = null;
		// Antes de finalizar, procurar o msevt de inicio do alerta.
		// Diferentemente do inicio da parada que possui apenas um inicio
		// podemos ter varios alertas em aberto, por isso, nao guardamos em
		// memoria seu inicio
		msevt = eventoRN.pesquisarMsEvtUltimoEventoAberto(evento, MsTpevtTemplate.Type.MOTIVO_REFUGO.getId());

		eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.CANCELAMENTO_REFUGO.getId(), msevt);

		return true;

	}

	public boolean validaSeUpEstaSendoUsada(String cdUp, BigDecimal idic) {

		MsMsicup msmsicup = new MsMsicup();
		MapQuery q = new MapQuery(getDaoPdba().getSession());

		q.append("select distinct msicup");
		q.append("from MsMsicup msicup ");
		q.append("join fetch msicup.msIc msic");
		q.append("join fetch msicup.msMs msms");
		q.append("join fetch msicup.msUp msup");
		q.append("where msic.stAtivo = 1");
		q.append("and msms.stAtivo = 1");
		q.append("and msup.cdUp = :cdup");
		q.append("and msic.idIc <> :idic");

		q.defineParametro("cdup", cdUp);
		q.defineParametro("idic", idic);
		q.setMaxResults(1);

		msmsicup = (MsMsicup) q.uniqueResult();

		getDaoPdba().commitaTransacao(getDaoPdba().getSession());

		if (msmsicup == null) {
			return false;
		} else {
			return true;
		}

	}

	// remove a alerta
	public MsEvt pararAlerta(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();

		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		MsEvt msevt = null;
		// Antes de finalizar, procurar o msevt de inicio do alerta.
		// Diferentemente do inicio da parada que possui apenas um inicio
		// podemos ter varios alertas em aberto, por isso, nao guardamos em
		// memoria seu inicio
		msevt = eventoRN.pesquisarMsEvtUltimoEventoAberto(evento, MsTpevtTemplate.Type.INICIO_ALERTA.getId());

		return eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.FIM_ALERTA.getId(), msevt);
	}

	// inicia um novo alerta
	public MsEvt iniciarAlerta(EventoColetado evento) throws ServicoFalhouException {
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();

		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		return eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.INICIO_ALERTA.getId(), null);
	}

	// Verifica se o Refugo pede causa ou acao
	public IwsRefugoDTO verificaCausaAcaoRefugo(EventoColetado evento) {

		IwsRefugoDTO refugo = null;
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			InjetRefugoRN refugoRN = new InjetRefugoRN(daoInjet);
			try {
				refugo = refugoRN.getTr_TabValidaCodRefugo(evento.getIcUpDTO().getUpDTO().getCd_up(), evento.getCdrefugo());
			} catch (RegistroDesconhecidoException e) {
				Log.info(e);
			}

		} else {
			idw.model.rn.RefugoRN refugoRN = new idw.model.rn.RefugoRN(daoPdba);
			OmPt pt = new OmPt();
			PTRN ptrn = new PTRN(daoPdba);
			if (evento.getIcUpDTO().getUpDTO().getCd_up() != null) {
				try {
					pt = ptrn.getOmPt(evento.getIcUpDTO().getUpDTO().getCd_up());
				} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
					return refugo;
				}
			}
			OmTppt omtppt = new OmTppt();
			omtppt.setIdTppt(pt.getOmTppt().getIdTppt());
			DwTRefugo retornoDwtRefugo = null;

			String cdRefugo = "";
			if (!evento.getCdrefugo().equals("") || evento.getCdrefugo() != null) {
				boolean zeroEsq = false;
				for (int i = 0; i < evento.getCdrefugo().length(); i++) {
					if (!zeroEsq) {
						if (evento.getCdrefugo().charAt(i) != '0') {
							cdRefugo += evento.getCdrefugo().charAt(i);
							zeroEsq = true;
						}
					} else {
						cdRefugo += evento.getCdrefugo().charAt(i);
					}
				}
			}

			try {
				retornoDwtRefugo = refugoRN.getDwTRefugo(cdRefugo, omtppt);
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				return refugo;
			}
			if (retornoDwtRefugo != null) {
				refugo = new IwsRefugoDTO();
				refugo.setIsRefugoValido(true);
				refugo.setCdRefugo(retornoDwtRefugo.getCdTrefugo());
				refugo.setIdRefugo(retornoDwtRefugo.getIdTrefugo().intValue());
				refugo.setPedeAcao(retornoDwtRefugo.getIsRequerAcao());
				refugo.setPedeCausa(retornoDwtRefugo.getIsRequerCausa());
				refugo.setPedeJust(false);
			}
		}
		return refugo;
	}

	public IwsParadaDTO validaParada(EventoColetado evento) {
		IwsParadaDTO parada = null;

		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			InjetParadaRN pRN = new InjetParadaRN(daoInjet, daoPdba);
			try {
				if (IwsFacade.getInstancia().isCdParadaPadraoInjet() == true) {
					evento.setCdparada(UtilRN.setZeroEsquerda(evento.getCdparada()));
				}
				parada = pRN.getTr_TabParadaSetaCod(evento.getLog(), 0, evento.getIcUpDTO().getUpDTO().getIdUpPDBA(), evento.getCdparada());
				return parada;
			} catch (RegistroDesconhecidoException e) {
				return parada;

			}

		} else {
			idw.model.rn.ParadaRN paradaRN = new idw.model.rn.ParadaRN(daoPdba);
			OmPt pt = new OmPt();
			PTRN ptrn = new PTRN(daoPdba);
			if (evento.getIcUpDTO().getUpDTO().getCd_up() != null) {
				try {
					pt = ptrn.getOmPt(evento.getIcUpDTO().getUpDTO().getCd_up());
				} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
					return parada;
				}
			}
			OmTppt omtppt = new OmTppt();
			omtppt.setIdTppt(pt.getOmTppt().getIdTppt());
			DwTParada retornoDwtParada = null;

			// Comentado pois nao pode retirar os zeros a esquerda quando for IDW.
			// Codigos com zero a esquerda sao possiveis cadastros do sistema.
			/*
			 * String cdParada = ""; if (!evento.getCdparada().equals("") || evento.getCdparada() != null) { boolean zeroEsq = false; for
			 * (int i = 0; i < evento.getCdparada().length(); i++) { if (!zeroEsq) { if (evento.getCdparada().charAt(i) != '0') { cdParada
			 * += evento.getCdparada().charAt(i); zeroEsq = true; } } else { cdParada += evento.getCdparada().charAt(i); } } }
			 */
			try {
				retornoDwtParada = paradaRN.getDwTParada(evento.getCdparada(), omtppt);
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				return parada;
			}

			if (retornoDwtParada != null) {

				// Se for uma parada valida, verificar se eh possivel alterar a parada atual da maquina
				// Obtem parada atual do pt
				ConsolidaRN crn = new ConsolidaRN(getDaoPdba());
				DwConsolpalog dwconsolpalog = crn.getUltimaParadaFromDwConsolpalog(pt);

				if (dwconsolpalog != null && dwconsolpalog.getDwTParada() != null
						&& dwconsolpalog.getDwTParada().getIsPermitecorrecao() != null
						&& dwconsolpalog.getDwTParada().getIsPermitecorrecao() == false)
					return parada;

				parada = new IwsParadaDTO();
				parada.setCdParada(retornoDwtParada.getCdTparada());
				parada.setDsParada(retornoDwtParada.getDsTparada());
				parada.setIdParada(retornoDwtParada.getIdTparada().toString());
				parada.setIsRegulagem(false); // parada.setIsRegulagem(retornoDwtParada.getIsRegulagem());
				parada.setIsExcessoPesa(false);
				parada.setIsParadaAutomatica(false);
				parada.setIsPedeAcao(retornoDwtParada.getIsRequerAcao());
				parada.setIsPedeCausa(retornoDwtParada.getIsRequerCausa());
				parada.setIsPedeFechamento(false);// parada.setIsPedeFechamento(retornoDwtParada.getIsRegulagem());
				parada.setIsPedeJust(retornoDwtParada.getIsRequerJust());
				parada.setIsPedeLocal(false);
				parada.setIsPeriodoSemConexao(retornoDwtParada.getIsSemConexao());
				parada.setIsPersistente(false);
				parada.setIsPesaCalculo(retornoDwtParada.getIsPesa());
				parada.setIsPesaMeanTime(false);
				parada.setIsPodeAlterarCdPar(retornoDwtParada.getIsPermitecorrecao());
				parada.setQtMinimaTecnicos(0);
				if (retornoDwtParada.getQtTec() != null && retornoDwtParada.getQtTec() >= 1) {
					parada.setIsTecnicoArea(true);
					if (retornoDwtParada.getQtTec() == 2)
						parada.setQtMinimaTecnicos(1);
					else if (retornoDwtParada.getQtTec() == 3)
						parada.setQtMinimaTecnicos(3);
				}

			}

			return parada;
		}
	}

	public boolean validaAcao(String idup, String cdacao) {
		InjetInfoRN iInfoRN = new InjetInfoRN(daoInjet, daoPdba);
		try {
			return iInfoRN.validaAcao(cdacao);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validaCausa(String idup, String cdcausa) {
		InjetInfoRN iInfoRN = new InjetInfoRN(daoInjet, daoPdba);
		try {
			return iInfoRN.validaCausa(cdcausa);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean validaJustificativa(String idup, String cdjust) {
		InjetInfoRN iInfoRN = new InjetInfoRN(daoInjet, daoPdba);
		try {
			return iInfoRN.validaJustificativa(cdjust);
		} catch (Exception e) {
			return false;
		}

	}

	public MsEvt inserirNovoRefugo(EventoColetado evento) throws ServicoFalhouException {
		IwsRefugoDTO refugo = null;
		MsEvt retorno = null;
		IdwLogger log = evento.getLog();
		int idLog = evento.getIdLog();
		int identacao = evento.getIdentacao();

		idw.model.rn.RefugoRN refugoRN = new idw.model.rn.RefugoRN(daoPdba);
		OmPt pt = new OmPt();
		PTRN ptrn = new PTRN(daoPdba);
		if (evento.getIcUpDTO().getUpDTO().getCd_up() != null) {
			try {
				pt = ptrn.getOmPt(evento.getIcUpDTO().getUpDTO().getCd_up());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				return retorno;
			}
		}
		OmTppt omtppt = new OmTppt();
		omtppt.setIdTppt(pt.getOmTppt().getIdTppt());
		DwTRefugo retornoDwtRefugo = null;

		if (evento.getCdrefugo() != null && evento.getCdrefugo().trim().equals("") == false) {
			try {
				retornoDwtRefugo = refugoRN.getDwTRefugo(evento.getCdrefugo(), omtppt);
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				log.info(idLog, 0, "Não existe o codigo de refugo " + evento.getCdrefugo());
				retornoDwtRefugo = null;
			}
		}

		if (retornoDwtRefugo == null) {
			OmCfg omcfg = Util.getConfigGeral(getDaoPdba().getSession());
			retornoDwtRefugo = omcfg.getDwTRefugo();
			// Luiz - 20180521 comentei essa linha, pois nao faz sentido setar o cdTREFUGO de um objeto nulo em um objeto que possui um
			// codigo de refugo valido
			// evento.setCdrefugo(retornoDwtRefugo.getCdTrefugo());
		}

		if (retornoDwtRefugo != null) {
			refugo = new IwsRefugoDTO();
			refugo.setCdRefugo(retornoDwtRefugo.getCdTrefugo());
			refugo.setIdRefugo(retornoDwtRefugo.getIdTrefugo().intValue());
			refugo.setIsAbate(true);
			refugo.setIsConverte(false);
			refugo.setIsRefugoValido(true);
			refugo.setDthrUltRefugo(null);
			refugo.setMilissegundos(0l);
			refugo.setPedeAcao(retornoDwtRefugo.getIsRequerAcao());
			refugo.setPedeCausa(retornoDwtRefugo.getIsRequerCausa());
			refugo.setPedeJust(false);
			refugo.setStRefugoCau(null);
		}

		// Se o injet estiver ativo entao incluir o evento
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			IwsFacade.getInstancia().setTr_LancaEventoRefugo(
					evento.getCdrefugo(),
					evento.getCdcausa(),
					evento.getCdacao(),
					evento.getQtde(),
					evento.getIcUpDTO().getUpDTO().getIdUpPDBA(),
					evento.getIdRdzProduto(),
					evento.getDthrEvento());
		}

		/*
		 * Alessandre em 16-02-17 comentei o if abaixo pois nao faz sentido pegar o cdCp por ultimo consolidado para usar como referencia
		 * para a OP if(pt != null){ //Encontrar DwRt para se usado como base dos dados ConsolidaRN rn = new ConsolidaRN(getDaoPdba()); DwRt
		 * dwrt = null; dwrt = rn.getUltimoDwRt(pt.getIdPt()); if (dwrt != null) { evento.setCdop(dwrt.getPpCp().getCdCp()); } }
		 */

		// Inclui tambem o registro de final de refugo em MsEvt
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		log.iniciaAvaliacao(idLog, "incluirEvento refugo");
		retorno = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.MOTIVO_REFUGO.getId(), null);
		log.paraAvaliacao();

		return retorno;
	}

	public MsEvt iniciarNovaOP(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		PTRN rn = new PTRN(getDaoPdba());
		OmPt ompt = rn.pesquisarPtByCdPtStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());

		try {
			// A pesquisa abaixo serve apenas para descobrir se existe a UP
			pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());

			if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
				IwsCpDTO cpEntrada = new IwsCpDTO();
				if (ompt.getTpSessao() == 1) {
					cpEntrada.setCdmolde(evento.getCdmolde());
					cpEntrada.setStCriacaoCP(Integer.toString(IwsUpDTO.TIPO_CP_MOLDE));
				}
				if (ompt.getTpSessao() == 0) {
					cpEntrada.setNrop(evento.getCdop());
					cpEntrada.setStCriacaoCP(Integer.toString(IwsUpDTO.TIPO_CP_OP));
				}
				if (ompt.getTpSessao() == 2) {
					cpEntrada.setCdProduto(evento.getCdproduto());
					cpEntrada.setStCriacaoCP(Integer.toString(IwsUpDTO.TIPO_CP_PRODUTO));
				}
				// 2019-09-26 Ailton: Existem casos no Injet que os tipos de sessao do ompt e do Injet divergem
				// Nesses casos especiais, considerar o tpSessao enviado no evento

				IwsFacade.getInstancia().planejamento(evento.getIcUpDTO().getUpDTO().getIdUpPDBA(), cpEntrada,
						DataHoraRN.getDataHoraAtual());
			}
		} catch (RegistroDesconhecidoException e) {

		}

		/*
		 * Quando vem do standalone o tipo da sessa esta null, qdo ocorrer pegar a configurada no ompt
		 *
		 */
		if (evento.getTpSessao() == null || evento.getTpSessao().equals("")) {
			evento.setTpSessao(ConversaoTipos.converterParaString(ompt.getTpSessao()));
		}

		/*
		 * Verificar se o tipo da sessao requer que uma nova OP seja criada ou que seja localizada de alguma forma diferente
		 *
		 */
		PpCp ppcp = ObtemOPSingleton.getInstancia().obtem(evento, getDaoPdba());

		if (ppcp == null) {
			log.info("UpRN: iniciarNovaOP falhou devido a (ppcp == null); Origem do evento: " + evento.getOrigem() + " cdop="
					+ evento.getCdop());
			return null;
		}

		if (ppcp.getNrop().equals(evento.getCdop()) == false)
			evento.setCdop(ppcp.getNrop());

		// Alessandre: comentei o trecho abaixo em 04-6-13 pois nao devemos
		// gerar aqui para o PDBA. A geracao do evento para o PDBA
		// ocorre em ProducaoParaPdba que eh chamado pelo webservice
		/*
		 * Alessanre: descomentei o trecho abaixo em 4-6-13 pois ele eh necessario qdo o IHM for o Android
		 */
		MsUp msUp = null;
		try {
			msUp = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (RegistroDesconhecidoException e) {
			msUp = pesquisarMsUpPorIdUp(new BigDecimal(evento.getIcUpDTO().getUpDTO().getCd_up()));
			if (msUp == null) {
				log.info("UpRN: iniciarNovaOP falhou devido a (msUp == null); Origem do evento: " + evento.getOrigem());
				return null;
			}
		}

		// Lancar evento de inicio de planejamento
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		MsEvt msevt = null;
		log.iniciaAvaliacao("incluirEvento");
		msevt = eventoRN.incluirEvento(log, 0, 0, evento, MsTpevtTemplate.Type.ENTRADA_PLANEJAMENTO.getId(), null);

		// O evnto de entrada de OP sera usado para referencia ao inicio de ciclo ou INICIO DE PARADA
		msUp.setMsEvtByIdEvtiniciociclo(msevt);
		msUp.setMsEvtByIdEvtinicioparada(msevt);

		if (msevt != null) {
			msUp.setNrop(msevt.getNrop());
		} else {
			msUp.setNrop(evento.getCdop());
		}

		getDaoPdba().makePersistent(msUp);

		MsPtColeta coleta = ompt.getMsPtColeta();

		if (coleta == null) {
			coleta = new MsPtColeta();
			coleta.setIdPt(ompt.getIdPt());
			coleta.setOmPt(ompt);
			getDaoPdba().getSession().save(coleta);
		}
		if (msevt != null) {
			coleta.setNrop(msevt.getNrop());
		} else {
			coleta.setNrop(evento.getCdop());
		}
		getDaoPdba().makePersistent(coleta);

		if (msevt != null)
			log.paraAvaliacao(msevt.getIdEvt());

		log.info(log.getAvaliacaoCompleta());

		return msevt;
	}

	/*
	 * private boolean isTpSessaoValido(EventoColetado evento, String omptTpSessao) { if (omptTpSessao != null) { // se forem iguais, usar o
	 * vindo do ompt if (omptTpSessao.equals(evento.getTpSessao())) return false;
	 * 
	 * switch(evento.getTpSessao()) { case "1": // IwsUpDTO.TIPO_CP_MOLDE if (evento.getCdmolde() != null &&
	 * !evento.getCdmolde().equals("")) return true; break; case "2": // IwsUpDTO.TIPO_CP_OP if (evento.getCdop() != null &&
	 * !evento.getCdop().equals("")) return true; break; case "3": // IwsUpDTO.TIPO_CP_PRODUTO if (evento.getCdproduto() != null &&
	 * !evento.getCdproduto().equals("")) return true; break; case "4": // IwsUpDTO.TIPO_CP_MOLDE_ESTRUTURA_COM_OPCRIACAONOMASTER if
	 * (evento.getCdmolde() != null && !evento.getCdmolde().equals("") && evento.getCdestrutura() != null &&
	 * !evento.getCdestrutura().equals("") && evento.getQtdeciclos() != null && !evento.getQtdeciclos().equals("")) return true; break; case
	 * "5": // IwsUpDTO.TIPO_CP_PRODUTO_ESTRUTURA_COM_OPCRIACAONOMASTER if (evento.getCdproduto() != null &&
	 * !evento.getCdproduto().equals("") && evento.getCdestrutura() != null && !evento.getCdestrutura().equals("") && evento.getQtdeciclos()
	 * != null && !evento.getQtdeciclos().equals("")) return true; break; case "6": // IwsUpDTO.TIPO_CP_PRODUTO_MONTAGEM if
	 * (evento.getCdproduto() != null && !evento.getCdproduto().equals("")) return true; break; case "7": //
	 * IwsUpDTO.TIPO_CP_PRODUTO_OP_COM_OPCRIACAOMASTER if (evento.getCdproduto() != null && !evento.getCdproduto().equals("") &&
	 * evento.getQtdeciclos() != null && !evento.getQtdeciclos().equals("")) return true; break; case "8": //
	 * IwsUpDTO.TIPO_CP_MOLDE_PRODUTO_QTCICLOS if (evento.getCdmolde() != null && !evento.getCdmolde().equals("") && evento.getCdproduto()
	 * != null && !evento.getCdproduto().equals("") && evento.getQtdeciclos() != null && !evento.getQtdeciclos().equals("")) return true;
	 * break;
	 * 
	 * }
	 * 
	 * 
	 * return false; } return true; }
	 */

	public void iniciarNovaOpRestoLinha(EventoColetado evento) {
		PTRN ptrn = new PTRN(getDaoPdba());

		// Verificar se o PT aponta paradas para o grupo de trabalho, se sim o motivo de parada apontado deve refletir tb nos outros pts que
		// estiverem PARADOS
		OmPt omPt;
		try {
			omPt = ptrn.getOmPt(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
			omPt = null;
		}

		if (omPt != null && omPt.getIsTrocaopgt() != null && omPt.getIsTrocaopgt() == true) {
			// Obtem a lista dos outros PTs do Gt atualmente paraddos
			List<OmPt> listapts = ptrn.pesquisarPtComColetaByGt(omPt.getOmGt(), omPt);
			for (OmPt ompt : listapts) {
				// Se for o mesmo PT nao precisa fazer de novo
				if (ompt.equals(omPt))
					continue;

				IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(ompt.getCdPt());

				// Alessandre em 21-12-18 caso nao encontre a UP a mesma pode estar em outro servidor, nesse caso vamos inicializar IcUpDTO
				if (icupdto == null) {
					MapQuery q = new MapQuery(ptrn.getDaoSession());
					q.append("select a");
					q.append("from MsMsicup a");
					q.append("join a.msMs b");
					q.append("join a.msUp c");
					q.append("where c.stAtivo = 1");
					q.append("and b.stAtivo = 1");
					q.append("and c.cdUp = :cd");
					q.defineParametro("cd", ompt.getCdPt());
					q.setMaxResults(1);
					MsMsicup icup = (MsMsicup) q.uniqueResult();

					// Pesquisar MSmsicup
					icupdto = new IcUpDTO();
					UpDTO updto = new UpDTO();
					updto.setCd_up(ompt.getCdPt());

					icupdto.setUpDTO(updto);
					if (icup != null)
						icupdto.setIdIcUp(icup.getIdMsicup().intValue());
				}

				evento.setIcUpDTO(icupdto);

				iniciarNovaOP(evento);
			}
		}

	}

	public void finalizarOPRestoLinha(IdwLogger log, int idLog, int identacao, EventoColetado evento) {

		// Verificar se o PT aponta paradas para o grupo de trabalho, se sim o motivo de parada apontado deve refletir tb nos outros pts que
		// estiverem PARADOS
		PTRN ptrn = new PTRN(getDaoPdba());

		OmPt omPt;
		try {
			omPt = ptrn.getOmPt(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
			omPt = null;
		}

		if (omPt != null && omPt.getIsTrocaopgt() != null && omPt.getIsTrocaopgt() == true) {
			// Obtem a lista dos outros PTs do Gt atualmente paraddos
			List<OmPt> listapts = ptrn.pesquisarPtComColetaByGt(omPt.getOmGt(), omPt);
			for (OmPt ompt : listapts) {
				// Se for o mesmo PT nao precisa fazer de novo
				if (ompt.equals(omPt))
					continue;

				IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(ompt.getCdPt());
				evento.setIcUpDTO(icupdto);

				// Alessandre em 21-12-18 caso nao encontre a UP a mesma pode estar em outro servidor, nesse caso vamos inicializar IcUpDTO
				if (icupdto == null) {
					MapQuery q = new MapQuery(ptrn.getDaoSession());
					q.append("select a");
					q.append("from MsMsicup a");
					q.append("join a.msMs b");
					q.append("join a.msUp c");
					q.append("where c.stAtivo = 1");
					q.append("and b.stAtivo = 1");
					q.append("and c.cdUp = :cd");
					q.defineParametro("cd", ompt.getCdPt());
					q.setMaxResults(1);
					MsMsicup icup = (MsMsicup) q.uniqueResult();

					// Pesquisar MSmsicup
					icupdto = new IcUpDTO();
					UpDTO updto = new UpDTO();
					updto.setCd_up(ompt.getCdPt());

					icupdto.setUpDTO(updto);
					if (icup != null)
						icupdto.setIdIcUp(icup.getIdMsicup().intValue());

					evento.setIcUpDTO(icupdto);
				}

				finalizarOP(log, idLog, identacao, evento);
			}
		}

	}

	public MsEvt finalizarOP(IdwLogger log, int idLog, int identacao, EventoColetado evento) {

		MsEvt retorno = null;
		try {
			// A pesquisa abaixo serve apenas para descobrir se existe a UP
			pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				IwsFacade.getInstancia().fimPlanejamento(evento.getIcUpDTO().getUpDTO().getIdUpPDBA(), DataHoraRN.getDataHoraAtual());
		} catch (RegistroDesconhecidoException e) {
		}

		PTRN rn = new PTRN(getDaoPdba());
		OmPt ompt = rn.pesquisarPtByCdPtStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());

		MsPtColeta coleta = ompt.getMsPtColeta();

		if (coleta == null) {
			coleta = new MsPtColeta();
			coleta.setIdPt(ompt.getIdPt());
			coleta.setOmPt(ompt);
			getDaoPdba().getSession().save(coleta);
		}
		coleta.setNrop(null);
		coleta.setDthrIparada(null);
		coleta.setDthrFparada(null);
		coleta.setDwTAcao(null);
		coleta.setDwTCausa(null);
		coleta.setDwTJust(null);
		coleta.setDwTParada(null);
		getDaoPdba().makePersistent(coleta);

		// Inclui tambem o registro de finalizacao do planejamento para o IDW
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		retorno = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.FINAL_SAIDA_PLANEJAMENTO.getId(), null);

		return retorno;
	}

	public static void main(String[] args) {
		PTRN rn = new PTRN();
		rn.iniciaConexaoBanco();
		UpRN uprn = new UpRN(rn.getDao(), null);
		EventoColetado evento = new EventoColetado();
		IcUpDTO icupdto = new IcUpDTO();
		UpDTO updto = new UpDTO();
		icupdto.setIdIcUp(3845);
		updto.setCd_up("000005");
		icupdto.setUpDTO(updto);
		evento.setCdparada("000009");
		evento.setIcUpDTO(icupdto);
		evento.setCdconsulta("017");
		evento.setLog(new IdwLogger("teste"));
		evento.setDthrEvento(new Date());

		// uprn.corrigeParada(evento);
		uprn.consultaGenericaINOVASA(evento);

		uprn.finalizaConexaoBanco();

	}

	public MsEvt corrigeParada(EventoColetado evento) {
		// Inclui tambem o registro motivo de parada em MsEvt
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());

		IdwLogger log = evento.getLog();
		int idLog = evento.getIdLog();
		int identacao = evento.getIdentacao();

		// Esse bloco inicio eh executo para evitar que o Injet altere um codigo de parada que nao permite alteracao
		MsUp msup = null;
		// Alessandre: em 31-01-15 substitui a linha abaixo pela seguinte pois em algumas situacoes em que o idUp pesquisado estï¿½
		// incorrendo pegando-se assim o valor errado
		// de referencia para o inicio do ciclo, causando assim tempos duplicados para um turno
		// msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());
		try {
			msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (RegistroDesconhecidoException e1) {
			msup = null;
		}

		// Lancar o evento somente se a ultima parada permitir correcao e nao requerer cancelamento

		PTRN prn = new PTRN(getDaoPdba());
		idw.model.rn.ParadaRN parn = new idw.model.rn.ParadaRN(getDaoPdba());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(msup.getCdUp());
		} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
			log.info(idLog, 0, "PT " + msup.getCdUp());
			return null;
		}
		/*
		 * Alessandre: em 11-11-2015 ao inves de usar DwConsolpalog sera necessario usar o proprio msevt. Isso pq, no standalone pode
		 * ocorrer chegar no mesmo arquivo o inicio da parada e o motivo, nao dando tempo de consolidar o inicio da parada e se a penultima
		 * parada nao permitir correcao entao o motivo atual nao entrara no sistema
		 *
		 * Alexandre: em 23-05-2016 adicionei a proxima linha ao comentario pois estava com warning de unused. ConsolidaRN crn = new
		 * ConsolidaRN(getDaoPdba());
		 * 
		 * DwConsolpalog dwconsolpalog = crn.getUltimaParadaFromDwConsolpalog(ompt); if (dwconsolpalog != null &&
		 * dwconsolpalog.getDwTParada().getIsPermitecorrecao() != null && dwconsolpalog.getDwTParada().getIsPermitecorrecao() == false) {
		 * log.info(idLog, 0, "nao permite corrigir a parada para motivo " + dwconsolpalog.getDwTParada().getCdTparada()); return false; }
		 */
		// Obtem o ultimo evento de inicio de parada para o clp
		MsEvt msevtUltimaparadaLancada = eventoRN.pesquisarMsEvtUltimaParada(msup.getCdUp());

		// Obtem o ultimo motivo de parada informado
		MsEvt msevtUltimoMotivoParadaLancado = eventoRN.pesquisarMsEvtUltimaMotivoParada(msup.getCdUp());
		DwTParada dwtparada = null;

		// Se o ultimo motivo for superior ao inicio da parada, entao avalia se o motivo permite correcao
		if (msevtUltimaparadaLancada != null && msevtUltimoMotivoParadaLancado != null
				&& msevtUltimoMotivoParadaLancado.getDthrEvento().compareTo(msevtUltimaparadaLancada.getDthrEvento()) > 1) {
			// Obtem o codigo da parada para avaliar se permite ou nao correcao
			try {
				dwtparada = parn.getDwTParada(msevtUltimaparadaLancada.getCdParada(), ompt.getOmTppt(), true);
				// Se existir avalia se pode-se corrigir
				if (dwtparada != null && dwtparada.getIsPermitecorrecao() != null && dwtparada.getIsPermitecorrecao() == false) {
					log.info(idLog, 0, "nao permite corrigir a parada para motivo " + dwtparada.getCdTparada());

					return null;
				}
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
			}
		}

		if (Stubdelegate.getInstancia().isInjetAtivo() == true && evento.isChamarInjetWs() == true) {

			// Colocar zeros a esquerda para o codigo de parada
			if (IwsFacade.getInstancia().isCdParadaPadraoInjet() == true) {
				evento.setCdparada(UtilRN.setZeroEsquerda(evento.getCdparada()));
			}

			if (evento.getCdacao() != null && evento.getCdacao().equals("") == false) {
				evento.setCdacao(UtilRN.setZeroEsquerda(evento.getCdacao()));
			}
			if (evento.getCdcausa() != null && evento.getCdcausa().equals("") == false) {
				evento.setCdcausa(UtilRN.setZeroEsquerda(evento.getCdcausa()));
			}
			if (evento.getCdjustificativa() != null && evento.getCdjustificativa().equals("") == false) {
				evento.setCdjustificativa(UtilRN.setZeroEsquerda(evento.getCdjustificativa()));
			}

			InjetParadaRN injparRN = new InjetParadaRN(getDaoInjet(), getDaoPdba());

			if (evento.getCdtec1() != null && evento.getCdtec1().equals("") == false)
				if (IwsFacade.getInstancia().getTr_ValidaLoginSenha(evento.getCdtec1(), evento.getSenhaTec1(),
						IwsAutenticacaoDTO.AVALIAR_TEC_1) == false)
					return null;

			if (evento.getCdtec2() != null && evento.getCdtec2().equals("") == false)
				if (IwsFacade.getInstancia().getTr_ValidaLoginSenha(evento.getCdtec2(), evento.getSenhaTec2(),
						IwsAutenticacaoDTO.AVALIAR_TEC_2) == false)
					return null;

			if (evento.getCdtecResponsavel() != null && evento.getCdtecResponsavel().equals("") == false)
				if (IwsFacade.getInstancia().getTr_ValidaLoginSenha(evento.getCdtecResponsavel(), evento.getSenhaTecResponsavel(),
						IwsAutenticacaoDTO.AVALIAR_TEC_RESP) == false)
					return null;

			IwsParadaDTO paradadto = injparRN.validaApontamento(
					evento.getLog(), 0,
					evento.getIcUpDTO().getUpDTO().getIdUpPDBA(),
					evento.getCdparada(), evento.getCdcausa(),
					evento.getCdacao(),
					evento.getCdjustificativa(),
					evento.getCdtec1(), evento.getCdtec2(), evento.getCdtecResponsavel(), null);

			IwsFacade.getInstancia().setTr_paradaMotivo(
					evento.getIcUpDTO().getUpDTO().getIdUpPDBA(),
					DataHoraRN.getDataHoraAtual(),
					evento.getCdparada(),
					evento.getCdacao(),
					evento.getCdcausa(),
					evento.getCdjustificativa(),
					evento.getCdtecResponsavel(),
					evento.getCdtec1(),
					evento.getCdtec2(),
					null,
					paradadto.getIsRegulagem(),
					null);
		}

		/*
		 * Salva tambem o inicio da parada em Ms_Pt_Coleta para servir como referencia ao servico de heartbeat pois o heartbeat estava
		 * usando a ultima parada consolidada e a consolidacao pode demorar, entao o heartbeat iria enviar uma parada errada para o coletor
		 * INOVA
		 */
		MsPtColeta coleta = ompt.getMsPtColeta();

		if (coleta == null) {
			coleta = new MsPtColeta();
			coleta.setIdPt(ompt.getIdPt());
			coleta.setOmPt(ompt);
			getDaoPdba().getSession().save(coleta);
		}

		DwTAcao dwtacao = null;
		DwTCausa dwtcausa = null;
		DwTJust dwtjust = null;
		OmUsr omusrTecnicoUm = null;
		OmUsr omusrTecnicoDois = null;
		OmUsr omusrTecnicoResp = null;

		try {
			dwtparada = parn.getDwTParada(evento.getCdparada(), ompt.getOmTppt(), true);
		} catch (idw.model.excessoes.RegistroDesconhecidoException e1) {
			dwtparada = null;
		}

		if (evento.getCdacao() != null && evento.getCdacao().equals("") == false) {
			AcaoRN arn = new AcaoRN(getDaoPdba());
			try {
				dwtacao = arn.getDwTAcao(evento.getCdacao(), ompt.getOmTppt());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				dwtacao = null;
			}
		}
		if (evento.getCdcausa() != null && evento.getCdcausa().equals("") == false) {
			CausaRN crn = new CausaRN(getDaoPdba());
			try {
				dwtcausa = crn.getDwTCausa(evento.getCdcausa(), ompt.getOmTppt());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				dwtcausa = null;
			}
		}
		if (evento.getCdjustificativa() != null && evento.getCdjustificativa().equals("") == false) {
			JustificativaRN jrn = new JustificativaRN(getDaoPdba());
			try {
				dwtjust = jrn.getDwTJust(evento.getCdjustificativa(), ompt.getOmTppt());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				dwtjust = null;
			}
		}
		UsuarioRN urn = new UsuarioRN(getDaoPdba());

		if (evento.getCdtec1() != null && evento.getCdtec1().equals("") == false)
			try {
				omusrTecnicoUm = urn.getOmUsr(evento.getCdtec1());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				omusrTecnicoUm = null;
			}

		if (evento.getCdtec2() != null && evento.getCdtec2().equals("") == false)
			try {
				omusrTecnicoDois = urn.getOmUsr(evento.getCdtec2());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				omusrTecnicoDois = null;
			}

		if (evento.getCdtecResponsavel() != null && evento.getCdtecResponsavel().equals("") == false)
			try {
				omusrTecnicoResp = urn.getOmUsr(evento.getCdtecResponsavel());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				omusrTecnicoResp = null;
			}

		coleta.setDwTParada(dwtparada);
		coleta.setDwTAcao(dwtacao);
		coleta.setDwTCausa(dwtcausa);
		coleta.setDwTJust(dwtjust);
		coleta.setOmUsrByIdUsrTecnicoUm(omusrTecnicoUm);
		coleta.setOmUsrByIdUsrTecnicoDois(omusrTecnicoDois);
		coleta.setOmUsrByIdUsrTecnicoResp(omusrTecnicoResp);

		getDaoPdba().makePersistent(coleta);

		log.iniciaAvaliacao(idLog, "incluirEvento corrigeParada");
		MsEvt msevt = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.MOTIVO_PARADA.getId(),
				msup.getMsEvtByIdEvtinicioparada());
		if (msevt != null)
			log.info(idLog, identacao, "evento incluido id=" + msevt.getIdEvt() + " no corrige parada");
		log.mostrarAvaliacaoCompleta();
		return msevt;
	}

	public MsEvt inicioCiclo(int idLog, int identacao, EventoColetado evento) throws ServicoFalhouException {
		IdwLogger log = evento.getLog();

		MsUp msup = null;

		log.iniciaAvaliacao(idLog, "pesquisarMsUpPorCdUpStAtivo-inicioCiclo");
		// Alessandre: em 31-01-15 substitui a linha abaixo pela seguinte pois em algumas situacoes em que o idUp pesquisado estï¿½
		// incorrendo pegando-se assim o valor errado
		// de referencia para o inicio do ciclo, causando assim tempos duplicados para um turno
		// msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());
		try {
			msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (RegistroDesconhecidoException e1) {
			msup = null;
		}

		if (msup != null)
			log.info(idLog, identacao, "Encontrou msUp com id = " + msup.getIdUp() + " em id_icup = " + evento.getIcUpDTO().getIdIcUp());
		else
			log.info(idLog, identacao, "Nao encontrou msUp com id = " + evento.getIcUpDTO().getUpDTO().getIdUp());

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		PrUp prup = null;
		try {
			if (msup != null && Stubdelegate.getInstancia().isInjetAtivo()) {
				log.iniciaAvaliacao(idLog, "pesquisarPrUpPorCdMaquinaStAtiva");
				log.info(idLog, 0, "chamando pesquisarPrUpPorCdMaquinaStAtiva");
				prup = pesquisarPrUpPorCdMaquinaStAtiva(msup.getCdUp());
				log.info(idLog, 0, "fim pesquisarPrUpPorCdMaquinaStAtiva");
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			}
		} catch (RegistroDesconhecidoException e) {
			prup = null;
		} catch (SQLGrammarException e) {
			// Essa excessao ocorre quando prup nao existir na base
			prup = null;

			// Alessandre: 04-10-12, vou colocar uma OP generica por enquanto
			// para a coleta do insert, mas apenas se nao vier nenhuma definida
			if (evento.getCdop() == null || evento.getCdop().equals("") == true)
				evento.setCdop("op");
		}

		if (prup != null && prup.getNrop() != null) {
			// Quando o alerta eh finalizado pelo Concentrador em C# nao serï¿½
			// necessario incluir no injetws pois isso foi feito
			// em passos anteriores
			if (evento.isChamarInjetWs() == true) {
				log.iniciaAvaliacao(idLog, "setTr_CicloInicio");
				ProducaoRN producaoRN = new ProducaoRN(daoInjet, daoPdba);

				producaoRN.setTr_CicloInicio(evento.getLog(), 0, prup.getIdup().toString(), evento.getDthrEvento(), "");
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			}

			// Alessandre: Inclui em 19-09-12 o nroOp de pr up para ser incluido
			// no MsEvt. Quando formos remover o pdba devemos corrigir essa
			// situacao
			// para obter a OP carregada de outra forma. Acredito que ms_up deva
			// sumir para dar lugar a omPt e la termos a op carregada
			evento.setCdop(prup.getNrop());
		}
		// Inclui tambem o registro de inicio de ciclo em MsEvt
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		MsEvt msevt = null;
		log.iniciaAvaliacao(idLog, "incluirEvento");
		msevt = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.INICIO_CICLO.getId(), null);

		if (msup != null && msevt != null) {
			msup.setMsEvtByIdEvtiniciociclo(msevt);
			msup.setSequencial(evento.getSequencial());
			evento.getIcUpDTO().getUpDTO().setIdEvtInicioCiclo(msevt.getIdEvt(), msevt.getDthrEvento());
			getDaoPdba().makePersistent(msup);
		} else {
			log.info(idLog, identacao, "A associacao de inicio do ciclo com a UP nï¿½o foi realizada pois msup ï¿½ null");
		}
		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		return msevt;
	}

	public MsEvt finalCiclo(int idLog, int identacao, EventoColetado evento) throws ServicoFalhouException, SemSGBDException {
		IdwLogger log = evento.getLog();

		MsUp msup = null;

		log.iniciaAvaliacao(idLog, "pesquisarMsUpPorCdUpStAtivo ou pesquisarMsUpPorIdUp");
		// Alessandre: em 31-01-15 substitui a linha abaixo pela seguinte pois em algumas situacoes em que o idUp pesquisado esta incorreto,
		// pegando-se assim o valor errado
		// de referencia para o inicio do ciclo, causando tempos duplicados para um turno
		// msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());
		try {
			if (evento.getIcUpDTO() == null) {
				log.info(idLog, identacao, "evento.geticupdto null");
				throw new ServicoFalhouException(null);
			} else if (evento.getIcUpDTO().getUpDTO() == null)
				log.info(idLog, identacao, "evento.geticupdto.getupdto null");

			if (evento.getIcUpDTO().getUpDTO().getCd_up() != null)
				msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
			else
				msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());

		} catch (RegistroDesconhecidoException e1) {
			log.paraAvaliacao();
			throw new ServicoFalhouException(e1);
		}

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		log.info(idLog, identacao, "isChamarInjetWs = " + evento.isChamarInjetWs());

		if (msup.getMsEvtByIdEvtiniciociclo() != null)
			log.info(idLog, identacao, "msUp.msevtIniciociclo = " + msup.getMsEvtByIdEvtiniciociclo().getIdEvt() + " dtevento = "
					+ DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(msup.getMsEvtByIdEvtiniciociclo().getDthrEvento()));

		if (evento.isChamarInjetWs() == true) {
			PrUp prup = null;
			try {
				log.iniciaAvaliacao(idLog, "pesquisarPrUpPorCdMaquinaStAtiva");
				prup = pesquisarPrUpPorCdMaquinaStAtiva(msup.getCdUp());

				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			} catch (RegistroDesconhecidoException e) {
				prup = null;

			} catch (SQLGrammarException e) {
				// Essa excessao ocorre quando prup nao existir na base

				prup = null;

				// Alessandre: 04-10-12, vou colocar uma OP generica por enquanto
				// para a coleta do insert
				// Alessandre: 04-10-12, vou colocar uma OP generica por enquanto
				// para a coleta do insert, mas apenas se nao vier nenhuma definida
				if (evento.getCdop() == null || evento.getCdop().equals("") == true)
					evento.setCdop("op");
			}

			if (prup != null && prup.getNrop() != null) {
				// Quando o alerta eh finalizado pelo Concentrador em C# nao serï¿½
				// necessario incluir no injetws pois isso foi feito
				// em passos anteriores
				log.iniciaAvaliacao(idLog, "setTr_CicloFim");
				log.info(idLog, identacao, "Chamando setTr_CicloFim mas com o IDW ativo nao deveria chamar");
				ProducaoRN producaoRN = new ProducaoRN(daoInjet, daoPdba);
				producaoRN.setTr_CicloFim(evento.getLog(), 0, prup.getIdup().toString(), evento.getDthrEvento(), evento.getPacoteCiclo());
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			}
			// Alessandre: Inclui em 19-09-12 o nroOp de pr up para ser incluido
			// no MsEvt. Quando formos remover o pdba devemos corrigir essa
			// situacao
			// para obter a OP carregada de outra forma. Acredito que ms_up deva
			// sumir para dar lugar a omPt e la termos a op carregada
			evento.setCdop(prup.getNrop());
		}

		// Inclui tambem o registro de final de ciclo em MsEvt
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		MsEvt msevt = null;
		log.iniciaAvaliacao(idLog, "incluirEvento");

		// Alessandre em 25-02-15 alem de salvar em msUp.iniciodeciclo vou tambem colocar em memoria a informacao do idEvt de inicio de
		// ciclo
		// isso pq por algum motivo nao conhecido a referencia do inicio de ciclo esta vindo antiga apesa de uma ref mais atual ter sido
		// salva no banco
		if (evento.getIcUpDTO().getUpDTO().getIdEvtInicioCiclo() == null && msup.getMsEvtByIdEvtiniciociclo() != null) {
			evento.getIcUpDTO().getUpDTO().setIdEvtInicioCiclo(msup.getMsEvtByIdEvtiniciociclo().getIdEvt(),
					msup.getMsEvtByIdEvtiniciociclo().getDthrEvento());
		}
		MsEvt msbase = msup.getMsEvtByIdEvtiniciociclo();

		/*
		 * Alessandre em 3-3-15 o objetivo do codigo abaixo era resolver o problema de se pesquisar um msevt antigo ja tendo um novo
		 * disponivel Para tanto se guardava na memeoria o ultimo idEvt incluido o problema eh que esse id pode ter falhado sua insercao.
		 * Assim desativei esse codigo. A solucao para se ter em memoria um id valido seria soh alterar a memoria apos a transacao ser
		 * fechada e qdo o injet estiver ativo isse eh complicado de implementar. Assim vou avaliar se o problema de ler um antigo continua
		 * Se sim terei que retornar a esse ponto e encontrar outro caminho. Em 6-3-15 voltei com o codigo e criei uma gambi. Se o comit
		 * falhar o idEvtInicioCiclo tera o anterior a falha pois criei em UPDTO o idEvtInicioCicloAnteriorAoFlush
		 */
		if (evento.getIcUpDTO().getUpDTO().getIdEvtInicioCiclo() != null && msbase != null) {
			if (evento.getIcUpDTO().getUpDTO().getIdEvtInicioCiclo() > msbase.getIdEvt()) {
				log.info(idLog, identacao, "A ref de inicio de ciclo da memoria eh maior que o de msup "
						+ evento.getIcUpDTO().getUpDTO().getIdEvtInicioCiclo() + " > " + msbase.getIdEvt());
				// Se o valor de memoria for diferente do valor salvo entao usar o valor de memoria
				try {
					msbase = getDaoPdba().findById(MsEvt.class, evento.getIcUpDTO().getUpDTO().getIdEvtInicioCiclo(), true);
				} catch (ObjectNotFoundException e) {
					try {
						msbase = getDaoPdba().findById(MsEvt.class, msup.getMsEvtByIdEvtiniciociclo().getIdEvt(), true);
					} catch (Exception e2) {
						log.info("excessao ", e2);
						e2.printStackTrace();
						throw new ServicoFalhouException(e2);
					}
				} catch (Exception e) {
					log.info("excessao ", e);
					e.printStackTrace();
					throw new ServicoFalhouException(e);
				}
				// Se nao existir pegar o ultimo lancamento ou de fim de ciclo ou de inicio de ciclo
				if (msbase == null) {
					log.info(idLog, identacao, "Nao encontrou o msevt com id = " + evento.getIcUpDTO().getUpDTO().getIdEvtInicioCiclo());
					// Lancando uma excessao para repetir todo o processo
					throw new ServicoFalhouException(null);
				} else {
					log.info(idLog, identacao, "Encontrou o idEvt = " + msbase.getIdEvt());
				}
			}
		}

		// Se houver identificacao do inicio do ciclo, entao lancar o evento
		// como FIM de CICLO
		if (msbase != null) {

			/*
			 * Alessandre em 19-07-17 para os ciclos efetivos iremos alterar omptcp com a quantidade de ciclos igual ao do coletor
			 *
			 */
			PTRN prn = new PTRN(getDaoPdba());
			OmPt ompt;
			try {
				ompt = prn.getOmPt(msup.getCdUp());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				ompt = null;
			}

			/*
			 * Alessandre em 26-06-17 em conversa com o beto sobre Concentradro C# como driver para o IDW verificamos a necessidade de
			 * recusar os ciclos com tempo inferior ao ciclo minimo. O INovaSA já faz isso, mas é necessário fazer para os outros tipos de
			 * coleta, se a parada fechar o ciclo Alessandre em 14-08-17 na verdade deixaremos apenas para as maquinas ciclicas esse filtro,
			 * pois os outros tipos de pts como insert, inline nao teremos sujeira no sinal eletrico, logo o ciclo nao pode ser descartado
			 */
			if (isCicloComTempoMinimo(msup.getCdUp(), msbase.getDthrEvento(), evento.getDthrEvento(), log, idLog, identacao) == false
					&& ompt != null && ompt.getOmTppt().isMaquinaCiclica()) {
				evento.setEventoApenasInformativo(true);
			} else {
				evento.setEventoApenasInformativo(false);
			}
			msevt = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.FIM_CICLO.getId(), msbase);

			if (evento.isEventoApenasInformativo() == false && msevt != null) {
				CpRN crn = new CpRN(getDaoPdba());
				PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(msevt.getNrop(), ompt.getCdPt());
				OmPtcp omptcp = null;
				try {
					if (ompt != null && ppcp != null)
						omptcp = prn.getOmPtCpByIdPtEIdCp(ompt.getIdPt(), ppcp.getIdCp());
				} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
					omptcp = null;
				}
				MsPtColeta coleta = ompt.getMsPtColeta();

				if (coleta == null) {
					coleta = new MsPtColeta();
					coleta.setIdPt(ompt.getIdPt());
					coleta.setOmPt(ompt);
					getDaoPdba().getSession().save(coleta);
				}

				if (omptcp != null) {
					/*
					 * Se estiver parada por regulagem contar o ciclo como regulagem
					 *
					 */
					if (coleta.getIsParada() != null && coleta.getIsParada() && coleta.getDwTParada() != null
							&& coleta.getDwTParada().getIsRegulagem() != null && coleta.getDwTParada().getIsRegulagem()) {
						if (omptcp.getQtCiclosregulagem() == null)
							omptcp.setQtCiclosregulagem(1);
						else
							omptcp.setQtCiclosregulagem(omptcp.getQtCiclosregulagem() + 1);
					} else {
						if (omptcp.getQtCiclos() == null)
							omptcp.setQtCiclos(1);
						else
							omptcp.setQtCiclos(omptcp.getQtCiclos() + 1);
					}
					getDaoPdba().makePersistent(omptcp);
				}

				/*
				 * Se estiver parada e nao for de regulage, finaliza a parada
				 *
				 */
				if (coleta.getIsParada() != null && coleta.getIsParada() && coleta.getDwTParada() != null
						&& coleta.getDwTParada().getIsRegulagem() != null && coleta.getDwTParada().getIsRegulagem() == false) {
					coleta.setDthrFparada(evento.getDthrEvento());
					coleta.setIsParada(false);
					getDaoPdba().makePersistent(coleta);
				}
			}
		} else {
			// Nao se sabia qual era o ultimo ciclo, entao, ao inves de lancar
			// FIM de CICLO se lanca INICIO DE CICLO
			log.info(idLog, identacao, "LANCANDO INICIO CICLO PARA idmsUp = " + msup.getIdUp().longValue() + " cdUp=" + msup.getCdUp()
					+ " idEvtiniciociclo=" + msup.getMsEvtByIdEvtiniciociclo());
			msevt = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.INICIO_CICLO.getId(), null);
		}

		// Se o ciclo incluido foi apenas de log (nao atingiu o tempo minimo entao nao se deve setar o inicio do ciclo
		if (msevt != null && evento.isEventoApenasInformativo() == false) {
			log.info(idLog, identacao, "Setando inicio de ciclo para up " + msup.getCdUp() + " com idEvt = " + msevt.getIdEvt());
			msup.setMsEvtByIdEvtiniciociclo(msevt);
			evento.getIcUpDTO().getUpDTO().setIdEvtInicioCiclo(msevt.getIdEvt(), msevt.getDthrEvento());
		} else {
			log.info(idLog, identacao, "MsEvt null. Nao setou inicio de ciclo para a up " + msup.getCdUp());
		}

		msup.setSequencial(null); // sempre joga null para a sequencia pois qdo
									// encontrar um PRODSTART sequencial tera a
									// sequencia da placa.
		getDaoPdba().makePersistent(msup);

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		return msevt;
	}

	private boolean isParadaFechaCiclo(OmPt ompt) {
		return (ompt.getIsParadaFechaciclo() != null && ompt.getIsParadaFechaciclo());
	}

	private boolean isCicloComTempoMinimo(String cdup, Date dthrInicio, Date dthrFim, IdwLogger log, int idLog, int identacao) {
		boolean isRetorno = false;

		PTRN ptrn = new PTRN(getDaoPdba());

		OmPt ompt = ptrn.pesquisarPtByCdPtStAtivo(cdup);

		FolhaRN frn = new FolhaRN(ptrn.getDao());
		BigDecimal cicloMinimo = null;
		try {
			if (ompt != null && ompt.getPpCp() != null && ompt.getPpCp().getDwFolha() != null)
				cicloMinimo = frn.getCicloMinimoFromDwFolha(ompt.getPpCp().getDwFolha(), ompt);
		} catch (SemCicloPadraoException | NullPointerException e) {
			cicloMinimo = null;
		}
		if (cicloMinimo == null)
			cicloMinimo = BigDecimal.ZERO;

		int tempoCiclo = DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrInicio, dthrFim);
		if (tempoCiclo >= cicloMinimo.intValue()) {
			isRetorno = true;
		}
		log.info(idLog, identacao,
				isRetorno + "?Lancar ciclo de " + tempoCiclo + " pois eh superior ao ciclo minimo " + cicloMinimo + " inicio "
						+ DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrInicio) + " - "
						+ DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFim));
		return isRetorno;
	}

	public MsEvt inicioParada(EventoColetado evento) throws ServicoFalhouException {

		IdwLogger log = evento.getLog();
		int idLog = evento.getIdLog();
		int identacao = evento.getIdentacao();

		MsUp msup = null;

		log.iniciaAvaliacao(idLog, "pesquisarMsUpPorCdUpStAtivo-inicioParada");
		// Alessandre: em 31-01-15 substitui a linha abaixo pela seguinte pois em algumas situacoes em que o idUp pesquisado estï¿½
		// incorrendo pegando-se assim o valor errado
		// de referencia para o inicio do ciclo, causando assim tempos duplicados para um turno
		// msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());
		try {
			msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (RegistroDesconhecidoException e1) {
			msup = null;
		}

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		PrUp prup = null;
		if (evento.isChamarInjetWs() == true) {
			try {
				log.iniciaAvaliacao(idLog, "pesquisarPrUpPorCdMaquinaStAtiva");
				prup = pesquisarPrUpPorCdMaquinaStAtiva(msup.getCdUp());
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			} catch (RegistroDesconhecidoException e) {
				prup = null;
			} catch (SQLGrammarException e) {
				// Essa excessao ocorre quando prup nao existir na base
				prup = null;

				// Alessandre: 04-10-12, vou colocar uma OP generica por enquanto
				// para a coleta do insert
				// Alessandre: 04-10-12, vou colocar uma OP generica por enquanto
				// para a coleta do insert, mas apenas se nao vier nenhuma definida
				if (evento.getCdop() == null || evento.getCdop().equals("") == true)
					evento.setCdop("op");
			}
		}

		if (prup != null && prup.getNrop() != null) {

			// Quando o alerta eh finalizado pelo Concentrador em C# nao serï¿½
			// necessario incluir no injetws pois isso foi feito
			// em passos anteriores
			if (evento.isChamarInjetWs() == true) {
				log.iniciaAvaliacao(idLog, "setTr_paradaInicio");
				ParadaRN paradaRN = new ParadaRN(daoInjet, daoPdba);

				paradaRN.setTr_paradaInicio(evento.getLog(), 0, prup.getIdup().toString() /* idUp */,
						evento.getDthrEvento() /* dthrInicio */,
						true /* isParadaAutomatica */,
						false /* isParadaPersistente */, false /* isParPeriodSemConex */);
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			}

			// Alessandre: Inclui em 19-09-12 o nroOp de pr up para ser incluido
			// no MsEvt. Quando formos remover o pdba devemos corrigir essa
			// situacao
			// para obter a OP carregada de outra forma. Acredito que ms_up deva
			// sumir para dar lugar a omPt e la termos a op carregada
			evento.setCdop(prup.getNrop());
		}

		/*
		 * Salva tambem o inicio da parada em Ms_Pt_Coleta para servir como referencia ao servico de heartbeat pois o heartbeat estava
		 * usando a ultima parada consolidada e a consolidacao pode demorar, entao o heartbeat iria enviar uma parada errada para o coletor
		 * INOVA
		 */
		PTRN prn = new PTRN(getDaoPdba());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(msup.getCdUp());
		} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
			ompt = null;
		}

		// Inclui tambem o registro de inicio de parada em MsEvt
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		MsEvt msevt = null;
		log.iniciaAvaliacao(idLog, "setTr_paradaInicio");

		msevt = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.INICIO_PARADA.getId(), null);
		msup.setMsEvtByIdEvtinicioparada(msevt);

		if (isParadaFechaCiclo(ompt)) {
			log.info(idLog, identacao, "Limpando referencia de ciclo para " + ompt.getCdPt());
			msup.setMsEvtByIdEvtiniciociclo(null);
		}

		getDaoPdba().makePersistent(msup);

		if (ompt != null) {
			MsPtColeta coleta = ompt.getMsPtColeta();

			if (coleta == null) {
				coleta = new MsPtColeta();
				coleta.setIdPt(ompt.getIdPt());
				coleta.setOmPt(ompt);
				getDaoPdba().getSession().save(coleta);
			}
			if (coleta.getNrop() != null && coleta.getNrop().equals("") == false) {
				coleta.setDthrIparada(evento.getDthrEvento());
				coleta.setIsParada(true);
			}

			coleta.setDthrFparada(null);
			coleta.setDwTParada(null);
			coleta.setDwTAcao(null);
			coleta.setDwTCausa(null);
			coleta.setDwTJust(null);
			coleta.setOmUsrByIdUsrTecnicoUm(null);
			coleta.setOmUsrByIdUsrTecnicoDois(null);
			coleta.setOmUsrByIdUsrTecnicoResp(null);

			getDaoPdba().makePersistent(coleta);
		}

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		return msevt;

	}

	public MsEvt finalParada(EventoColetado evento) throws ServicoFalhouException {
		IdwLogger log = evento.getLog();
		int idLog = evento.getIdLog();
		int identacao = evento.getIdentacao();
		// DAOGenerico daoPdba = new DAOGenerico();
		// DAOGenericoInjet daoInjet = new DAOGenericoInjet();

		MsUp msup = null;

		log.iniciaAvaliacao(idLog, "pesquisarMsUpPorCdUpStAtivo-finalParada");
		// Alessandre: em 31-01-15 substitui a linha abaixo pela seguinte pois em algumas situacoes em que o idUp pesquisado estï¿½
		// incorrendo pegando-se assim o valor errado
		// de referencia para o inicio do ciclo, causando assim tempos duplicados para um turno
		// msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());
		try {
			msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (RegistroDesconhecidoException e1) {
			msup = null;
		}

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		PrUp prup = null;
		if (evento.isChamarInjetWs() == true) {
			try {
				log.iniciaAvaliacao(idLog, "pesquisarPrUpPorCdMaquinaStAtiva");
				prup = pesquisarPrUpPorCdMaquinaStAtiva(msup.getCdUp());
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			} catch (RegistroDesconhecidoException e) {
				prup = null;
			} catch (SQLGrammarException e) {
				// Essa excessao ocorre quando prup nao existir na base
				prup = null;

				// Alessandre: 04-10-12, vou colocar uma OP generica por enquanto
				// para a coleta do insert
				// Alessandre: 04-10-12, vou colocar uma OP generica por enquanto
				// para a coleta do insert, mas apenas se nao vier nenhuma definida
				if (evento.getCdop() == null || evento.getCdop().equals("") == true)
					evento.setCdop("op");
			}
		}
		if (prup != null && prup.getNrop() != null) {
			// Quando a parada eh finalizado pelo Concentrador em C# nao serï¿½
			// necessario incluir no injetws pois isso foi feito
			// em passos anteriores
			if (evento.isChamarInjetWs() == true) {
				log.iniciaAvaliacao(idLog, "setTr_paradaFim");
				ParadaRN paradaRN = new ParadaRN(daoInjet, daoPdba);
				paradaRN.setTr_paradaFimWS(evento.getLog(), 0, prup.getIdup().toString(), evento.getDthrEvento());
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			}

			// Alessandre: Inclui em 19-09-12 o nroOp de pr up para ser incluido
			// no MsEvt. Quando formos remover o pdba devemos corrigir essa
			// situacao
			// para obter a OP carregada de outra forma. Acredito que ms_up deva
			// sumir para dar lugar a omPt e la termos a op carregada
			evento.setCdop(prup.getNrop());
		}

		// Inclui tambem o registro de final de parada em MsEvt
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		log.iniciaAvaliacao(idLog, "incluirEvento");
		MsEvt msevt = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.FIM_PARADA.getId(),
				msup.getMsEvtByIdEvtinicioparada());

		// Alessandre: Comentei a linha abaixo pois ao final da parada nao quero
		// limpar o inicio da mesmo
		// irei usar o inicio para o proximo lancamento de correcao de parada
		// msup.setMsEvtByIdEvtinicioparada(null);

		getDaoPdba().makePersistent(msup);

		/*
		 * Salva tambem o inicio da parada em Ms_Pt_Coleta para servir como referencia ao servico de heartbeat pois o heartbeat estava
		 * usando a ultima parada consolidada e a consolidacao pode demorar, entao o heartbeat iria enviar uma parada errada para o coletor
		 * INOVA
		 */
		PTRN prn = new PTRN(getDaoPdba());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(msup.getCdUp());
		} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
			ompt = null;
		}

		if (ompt != null) {
			MsPtColeta coleta = ompt.getMsPtColeta();

			if (coleta == null) {
				coleta = new MsPtColeta();
				coleta.setIdPt(ompt.getIdPt());
				coleta.setOmPt(ompt);
				getDaoPdba().getSession().save(coleta);
			}

			coleta.setDthrFparada(evento.getDthrEvento());
			coleta.setIsParada(false);
			getDaoPdba().makePersistent(coleta);
		}

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());
		return msevt;
	}

	public MsMsihm pesquisarMsMsihmPorIdMSIdIHM(MsIhm msihm, MsMs msms) {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from MsMsihm msmsihm ");
		q.append("where msmsihm.msIhm.idIhm = :idihm ");
		q.append("and msmsihm.msMs.idMs = :idms ");

		q.defineParametro("idihm", msihm.getIdIhm());
		q.defineParametro("idms", msms.getIdMs());

		MsMsihm msmsihm = (MsMsihm) q.uniqueResult();

		return msmsihm;
	}

	public MsUpihm pesquisarMsUpihm(MsUp msup, MsIhm msihm) {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from MsUpihm msupihm");
		q.append("where msupihm.msIhm.idIhm = :idihm ");
		q.append("and msupihm.msUp.idUp = :idup ");

		q.defineParametro("idihm", msihm.getIdIhm());
		q.defineParametro("idup", msup.getIdUp());

		MsUpihm retorno = (MsUpihm) q.uniqueResult();

		return retorno;
	}

	public MsUp pesquisarMsUpPorIdUp(BigDecimal idUp) {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msup from MsUp msup ");
		q.append("where msup.idUp = :idup ");

		q.defineParametro("idup", idUp);

		MsUp msup = (MsUp) q.uniqueResult();

		return msup;
	}

	public MsUp pesquisarMsUpPorIdUpPdba(String iduppdba) {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msup from MsUp msup ");
		q.append("where msup.iduppdba = :idup ");
		q.append("and msup.stAtivo = 1");

		q.defineParametro("idup", iduppdba);
		q.setMaxResults(1);

		MsUp msup = (MsUp) q.uniqueResult();

		return msup;
	}

	public IcUpDTO pesquisarIcUpDtoPorIdUpPdba(String iduppdba) throws RegistroDesconhecidoException {
		IcUpDTO retorno = null;
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msmsicup ");
		q.append("from MsMsicup msmsicup ");
		q.append("join fetch msmsicup.msUp msup");
		q.append("join fetch msmsicup.msIc msic");
		q.append("join fetch msmsicup.msMs msms");
		q.append("where msup.iduppdba = :iduppdba ");
		q.append("and msup.stAtivo = 1");
		q.append("and msic.stAtivo = 1");
		q.append("and msms.stAtivo = 1");

		q.defineParametro("iduppdba", iduppdba);
		q.setMaxResults(1);

		MsMsicup msmsicup = (MsMsicup) q.uniqueResult();

		if (msmsicup == null) {
			throw new RegistroDesconhecidoException();
		}
		PTRN rn = new PTRN(getDaoPdba());
		OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msmsicup.getMsUp().getCdUp());
		retorno = new IcUpDTO(msmsicup, ompt);

		return retorno;
	}

	public MsUp pesquisarMsUpPorCdUpStAtivo(String cdUp) throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msup");
		q.append("from MsUp msup ");
		q.append("where msup.cdUp = :cdup and msup.stAtivo = :stativo");
		q.append("order by msup.idUp desc");

		q.defineParametro("cdup", cdUp);
		q.defineParametro("stativo", BigDecimal.ONE);
		q.setMaxResults(1);

		MsUp msup = (MsUp) q.uniqueResult();

		if (msup == null) {
			throw new RegistroDesconhecidoException();
		}
		return msup;
	}

	public List<MsUp> pesquisarListaMsUpPorUrlConexaoIC(String urlConexaoIC) {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select distinct msup");
		q.append("from MsUp msup ");
		q.append("join fetch msup.msMsicups msicup");
		q.append("join fetch msicup.msIc msic");
		q.append("join fetch msicup.msMs msms");
		q.append("where msic.urlConexao = :urlconexao and msup.stAtivo = 1 and msic.stAtivo = 1");
		q.append("and msms.stAtivo = 1");

		q.defineParametro("urlconexao", urlConexaoIC);

		return q.list();
	}

	public List<MsUp> pesquisarListaMsUpPorCdIC(String cd) {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select distinct msup");
		q.append("from MsUp msup ");
		q.append("join fetch msup.msMsicups msicup");
		q.append("join fetch msicup.msIc msic");
		q.append("join fetch msicup.msMs msms");
		q.append("where msic.cdIc = :cd and msup.stAtivo = 1 and msic.stAtivo = 1");
		q.append("and msms.stAtivo = 1");

		q.defineParametro("cd", cd);

		return q.list();
	}

	public List<MsUp> pesquisarListaMsUpPorUrlConexaoIhm(String urlConexaoIHM) {
		MapQuery q = new MapQuery(daoPdba.getSession());
		
		q.append("select distinct msup");
		q.append("from MsUp msup ");
		q.append("join fetch msup.msMsicups msicup");
		q.append("join fetch msup.msUpihms msupihm");
		q.append("join fetch msupihm.msIhm msihm");
		q.append("join fetch msicup.msMs msms");
		q.append("where msihm.urlConexao like :urlconexao and msup.stAtivo = 1");
		q.append("and msms.stAtivo = 1");
		q.append("and msicup.isAtivo = 1");

		q.defineParametro("urlconexao", "%" + urlConexaoIHM + "%");

		return q.list();
	}

	public MsUp pesquisaUmMsUpPorCdUpComCdBcNotNull(String cdUp)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(daoPdba.getSession());
		// Exclui MSUP onde cdbc=NULL. Alessandre: em 29-8-13 Pq???????

		q.append("from MsUp msup ");
		q.append("where msup.cdUp = :cdup ");
		q.append("order by msup.idUp desc");

		q.defineParametro("cdup", cdUp);
		q.setMaxResults(1);

		MsUp msup = null;

		msup = (MsUp) q.uniqueResult();

		if (msup == null)
			throw new RegistroDesconhecidoException();

		return msup;
	}

	public MsUp pesquisaUmMsUpPorDsUpComCdUpDiffComCdBcNotNulleAtivo(String cdUp, String dsUp) throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(daoPdba.getSession());
		q.append("select msup");
		q.append("from MsUp msup ");
		q.append("where msup.cdUp <> :cdup ");
		q.append("and msup.stAtivo = :stativo");
		q.append("and msup.dsUp = :dsup");
		q.append("and msup.cdBc is not null");
		q.append("order by msup.idUp desc");

		q.defineParametro("cdup", cdUp);
		q.defineParametro("dsup", dsUp);
		q.defineParametro("stativo", BigDecimal.ONE);
		q.setMaxResults(1);

		MsUp msup = null;

		msup = (MsUp) q.uniqueResult();

		if (msup == null)
			throw new RegistroDesconhecidoException();

		return msup;
	}

	public List<MsUp> pesquisarTodosMsUpAtivos() {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from MsUp msup ");
		q.append("where msup.stAtivo = 1");

		return q.list();
	}

	public PrUp pesquisarPrUpPorIdUp(BigDecimal idUp)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(getDaoPdba().getSession());

		q.append("from PrUp prup ");
		q.append("where prup.idup = :idup and prup.stativa = '1' ");

		q.defineParametro("idup", idUp);

		PrUp prup = (PrUp) q.uniqueResult();

		if (prup == null)
			throw new RegistroDesconhecidoException();

		return prup;
	}

	public PrUp pesquisarPrUpPorCdMaquinaStAtiva(String cdMaquina)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from PrUp prup ");
		// Luiz - 20180522 mudei cdmaq para maqestendido para funcionar o ihm Android na Honda
		q.append("where prup.cdmaqestendido = :cdmaquina and prup.stativa = '1' ");

		q.defineParametro("cdmaquina", cdMaquina);
		q.setMaxResults(1);

		PrUp prup = (PrUp) q.uniqueResult();

		if (prup == null)
			throw new RegistroDesconhecidoException();

		return prup;
	}

	public PrUp pesquisarPrUpPorCdMaquina(String cdMaquina)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from PrUp prup ");
		q.append("where prup.cdmaquina = :cdmaquina ");

		q.defineParametro("cdmaquina", cdMaquina);
		q.setMaxResults(1);

		PrUp prup = (PrUp) q.uniqueResult();

		if (prup == null)
			throw new RegistroDesconhecidoException();

		return prup;
	}

	public List<PrUp> pesquisarListaPrUp() {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from PrUp prup ");
		q.append("where prup.stativa = '1' ");

		return q.list();
	}

	public ListaUPDTO getTodosUPDTO() {
		List<MsUp> listamsup = null;
		ArrayList<UpDTO> listaupdto = new ArrayList<UpDTO>();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		ListaUPDTO listaupDTO = new ListaUPDTO();
		UpDTO upDTO = null;

		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msup from MsUp msup ");
		q.append("where msup.stAtivo = 1");

		listamsup = q.list();

		if (listamsup != null) {
			PTRN rn = new PTRN(getDaoPdba());
			for (MsUp msup : listamsup) {
				OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());
				upDTO = null;
				upDTO = new UpDTO();
				upDTO.setIdUp(msup.getIdUp());
				upDTO.setCd_up(msup.getCdUp());
				if (ompt != null && ompt.getOmTppt() != null)
					upDTO.setIdTppt(ompt.getOmTppt().getIdTppt());
				else
					upDTO.setIdTppt(0l);

				upDTO.setIdUpPDBA(msup.getIduppdba());
				upDTO.setCdBc(msup.getCdBc());

				listaupdto.add(upDTO);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		} else {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
		}

		listaupDTO.setListaUPDTO(listaupdto);
		listaupDTO.setResultadoDTO(resultadoDTO);

		return listaupDTO;
	}

	// Lista para o modelo de combo do UP
	public ListaUPDTO getListaMsUP() {
		List<MsUp> listaMsUp;
		ArrayList<UpDTO> listaUpDtoRetorno = new ArrayList<UpDTO>();
		MapQuery query = new MapQuery(daoPdba.getSession());
		query.append("SELECT msup ");
		query.append("FROM MsUp msup");
		query.append("WHERE msup.stAtivo = 1");
		listaMsUp = query.list();
		if (listaMsUp != null) {
			PTRN rn = new PTRN(daoPdba);
			for (MsUp msup : listaMsUp) {
				OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());
				UpDTO updto = new UpDTO();
				updto.setIdUp(msup.getIdUp());
				updto.setCd_up(msup.getCdUp());
				if (ompt != null && ompt.getOmTppt() != null)
					updto.setIdTppt(ompt.getOmTppt().getIdTppt());
				else
					updto.setIdTppt(0l);

				updto.setIdUpPDBA(msup.getIduppdba());
				updto.setCdBc(msup.getCdBc());
				updto.setDs_up(msup.getDsUp());
				listaUpDtoRetorno.add(updto);
			}

		}
		ListaUPDTO listaUpDto = new ListaUPDTO();
		listaUpDto.setListaUPDTO(listaUpDtoRetorno);
		return listaUpDto;
	}

	public ListaUPDTO getListaUpDTO() throws UpDesconhecidoException {
		List<MsUp> lista = null;
		ArrayList<UpDTO> listaupdto = new ArrayList<UpDTO>();
		ListaUPDTO listaUpDTO = new ListaUPDTO();
		UpDTO upDTO = null;
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

		lista = pesquisarListaMsUp();
		if (lista.isEmpty()) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
		} else {
			PTRN rn = new PTRN(daoPdba);
			for (MsUp msup : lista) {
				OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());
				upDTO = null;
				upDTO = new UpDTO(msup, ompt);

				upDTO.setUpihmColetados(new ArrayList<UpIhmDTO>());

				for (MsUpihm msupihm : msup.getMsUpihms()) {
					UpIhmDTO upihmdto = new UpIhmDTO(msupihm);

					upDTO.getUpihmColetados().add(upihmdto);
				}

				listaupdto.add(upDTO);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}

		listaUpDTO.setResultadoDTO(resultadoDTO);
		listaUpDTO.setListaUPDTO(listaupdto);

		return listaUpDTO;
	}

	private List<MsUp> pesquisarListaMsUp() {

		Date dthrRevisao1 = null;
		Date dthrRevisao2 = null;
		Date dthrStAtivo1 = null;
		Date dthrStAtivo2 = null;

		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select distinct msup ");
		q.append("from MsUp msup ");
		q.append("left join fetch msup.msUpihms ");
		q.append("where msup.stAtivo = :stativo ");

		if (this.getCd_up() != null && !this.getCd_up().equals("")) {
			q.append("and msup.cdUp like :cdup ");
		}
		if (this.getDs_up() != null && !this.getDs_up().equals("")) {
			q.append("and msup.dsUp = :dsup ");
		}

		if (this.getRevisao() != null && this.getRevisao().intValue() > 0) {
			q.append("and msup.revisao = :revisao ");
		}

		if (this.getDthrStativo() != null) {
			dthrStAtivo1 = DataHoraRN.setHoraNaData(this.getDthrStativo(), 0,
					0, 0);
			dthrStAtivo2 = DataHoraRN.setHoraNaData(this.getDthrStativo(), 23,
					59, 59);

			q.append("and msup.dthrStativo between :dthrstativo1 and :dthrstativo2 ");
		}
		if (this.getDthrRevisao() != null) {
			dthrRevisao1 = DataHoraRN.setHoraNaData(this.getDthrRevisao(), 0,
					0, 0);
			dthrRevisao2 = DataHoraRN.setHoraNaData(this.getDthrRevisao(), 23,
					59, 59);
			q.append("and msup.dthrRevisao between :dthrrevisao1 and :dthrrevisao2 ");
		}

		q.defineParametro("cdup", this.getCd_up());
		q.defineParametro("dsup", this.getDs_up());
		if (this.getRevisao() != null)
			q.defineParametro("revisao", this.getRevisao());

		if (this.getStAtivo() == null) {
			q.defineParametro("stativo", BigDecimal.ONE);
		} else {
			q.defineParametro("stativo", this.getStAtivo());
		}

		if (this.getDthrStativo() != null) {
			q.defineParametro("dthrstativo1", dthrStAtivo1);
			q.defineParametro("dthrstativo2", dthrStAtivo2);
		}
		if (this.getDthrRevisao() != null) {
			q.defineParametro("dthrrevisao1", dthrRevisao1);
			q.defineParametro("dthrrevisao2", dthrRevisao2);
		}

		return q.list();
	}

	public ListaUPDTO salvarUpDTO() {
		MsUp msupAtual = null;
		MsUp msupNova = new MsUp();
		MsUsr msusrLogado = null;

		UpDTO updto = new UpDTO();
		ArrayList<UpDTO> lista = new ArrayList<UpDTO>();
		ListaUPDTO retorno = new ListaUPDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

		Date data = new Date();

		if (this.getCd_up() == null || this.getCd_up().equals("")) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDUP_DESCONHECIDO);
			retorno.setResultadoDTO(resultadoDTO);
			return retorno;
		}

		// Pesquisar OmPt
		PTRN rn = new PTRN(getDaoPdba());
		OmPt ompt = rn.pesquisarPtByCdPtStAtivo(this.getCd_up());
		Long idtppt = 0l;

		/*
		 * Alessandre em 07-04-22 acrescentei a regra para nao permitir salvar uma UP que não tenha um PT correspondente
		 * 
		 */
		if (ompt == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDIC_DESCONHECIDO);
			retorno.setResultadoDTO(resultadoDTO);
			return retorno;
		}

		if (ompt != null && ompt.getOmTppt() != null)
			idtppt = ompt.getOmTppt().getIdTppt();

		// Obtem usuario logado
		msusrLogado = pesquisarMsUsr();

		if (msusrLogado == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_USUARIO_DESCONHECIDO);
			retorno.setResultadoDTO(resultadoDTO);
			return retorno;
		}

		/*
		 * Se o id da Up tiver sido enviado entao eh uma alteracao
		 *
		 */
		boolean isAlteracao = getIdUp() != null && getIdUp().equals(BigDecimal.ZERO) == false;

		try {
			// Alessandre> em 29-08-13 mudei o metodo de pesquisa pois estava
			// duplicando msup, visto que o metodo anterior buscava msmmsicup e
			// nao precisava
			if (isAlteracao)
				msupAtual = pesquisarMsUpPorIdUp(getIdUp());
			else {
				msupAtual = pesquisarMsUpPorCdUpStAtivo(this.getCd_up());
				if (msupAtual != null) {
					resultadoDTO.setIdMensagem(resultadoDTO.ERRO_IC_JA_CADASTRADO);
					retorno.setResultadoDTO(resultadoDTO);
					return retorno;
				}
			}
		} catch (RegistroDesconhecidoException e) {
			msupAtual = null;
		}

		msupNova.setCdUp(this.getCd_up());
		msupNova.setCdBc(this.getCdBc());
		msupNova.setMsUsr(msusrLogado);

		// Salva dados sobre licenciamento
		if (msupAtual != null) {
			msupNova.setIsLicenciada(msupAtual.getIsLicenciada());
			msupNova.setIduppdba(msupAtual.getIduppdba());
			msupNova.setMsEvtByIdEvtiniciociclo(msupAtual.getMsEvtByIdEvtiniciociclo());
			msupNova.setMsEvtByIdEvtinicioparada(msupAtual.getMsEvtByIdEvtinicioparada());
			msupNova.setNrop(msupAtual.getNrop());
		}

		if (this.getDs_up() != null) {
			msupNova.setDsUp(this.getDs_up());
		}
		if (this.getUpihmColetados() != null) {
			msupNova.setMsUpihms(new HashSet<MsUpihm>());

			for (UpIhmDTO upihmDTO : this.getUpihmColetados()) {
				MsUpihm msupihm;
				msupihm = null;
				msupihm = new MsUpihm();

				msupihm.setMsIhm(consultarMsIhmPorIdIhm(upihmDTO.getIhm()));
				msupihm.setMsUp(msupNova);

				if (upihmDTO.getDthrCadastro() != null) {
					msupihm.setDthrCadastro(upihmDTO.getDthrCadastro());
				} else {
					msupihm.setDthrCadastro(data);
				}
				msupNova.getMsUpihms().add(msupihm);
			}
		}

		daoPdba.iniciaTransacao();
		daoPdba.inclusaoDescartandoOriginal(msupAtual, msupNova);

		// Altera o novo idUp em ms_msicup
		// Alessandre> em 29-08-13 alterando o idUp antigo para o idUp novo em
		// msicup
		if (msupAtual != null) {
			for (MsMsicup msmsicup : msupAtual.getMsMsicups()) {
				msmsicup.setMsUp(msupNova);
				daoPdba.makePersistent(msmsicup);
			}
		}
		daoPdba.finalizaTransacao();

		// Prepara retorno
		updto.setIdUp(msupNova.getIdUp());
		updto.setCd_up(msupNova.getCdUp());
		updto.setIdTppt(idtppt);
		updto.setDs_up(msupNova.getDsUp());
		updto.setIdUpPDBA(msupNova.getIduppdba());
		updto.setRevisao(msupNova.getRevisao());
		updto.setDthrRevisao(msupNova.getDthrRevisao());
		updto.setDthrStativo(msupNova.getDthrStativo());
		updto.setStAtivo(msupNova.getStAtivo());
		updto.setCdBc(msupNova.getCdBc());

		updto.setUpihmColetados(new ArrayList<UpIhmDTO>());

		for (MsUpihm msupihm : msupNova.getMsUpihms()) {
			UpIhmDTO upihmdto = new UpIhmDTO(msupihm);

			updto.getUpihmColetados().add(upihmdto);
		}

		resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);

		lista.add(updto);
		retorno.setListaUPDTO(lista);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}

	public MsUp pesquisarMsUpTrazendoMsicupPorCdUpStativo(String cdMaquina)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msup ");
		q.append("from MsUp msup ");
		// Alessandre: em 29-8-13 removi o lef e inclui outro join para pegar
		// apenas os ms ativos e ups em ms
		q.append("join fetch msup.msMsicups msmsicup ");
		q.append("join fetch msmsicup.msMs msms ");
		q.append("where msup.cdUp = :cdup ");
		q.append("and msup.stAtivo = 1 ");
		q.append("and msms.stAtivo = 1 ");

		q.defineParametro("cdup", cdMaquina);
		q.setMaxResults(1);

		MsUp retorno = (MsUp) q.uniqueResult();

		if (retorno == null)
			throw new RegistroDesconhecidoException();

		return retorno;
	}

	private MsIhm consultarMsIhmPorIdIhm(IhmDTO ihmdto) {
		if (ihmdto == null || ihmdto.getIdIhm() == null)
			return null;
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msihm from MsIhm msihm ");
		q.append("where msihm.idIhm = :idihm ");

		q.defineParametro("idihm", new BigDecimal(ihmdto.getIdIhm()));
		q.setMaxResults(1);

		return (MsIhm) q.uniqueResult();
	}

	private MsUsr pesquisarMsUsr() {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msusr ");
		q.append("from MsUsr msusr ");
		q.append("where msusr.login = :login ");
		q.append("and msusr.stAtivo = 1 ");

		q.defineParametro("login", this.getLoginUsuario());
		q.setMaxResults(1);

		return (MsUsr) q.uniqueResult();
	}

	public ListaUPDTO removeUpDTO() {
		ListaUPDTO listaUpDTO = null;
		listaUpDTO = removeRegistro();
		return listaUpDTO;
	}

	public ListaUPDTO removeUpsDTO(ListaUPDTO lista) {
		ListaUPDTO listaUpDTO = new ListaUPDTO();
		listaUpDTO.setListaUPDTO(new ArrayList<UpDTO>());
		for (UpDTO dto : lista.getListaUPDTO()) {
			setUpDTO(dto);
			ListaUPDTO temp = removeRegistro();
			if (temp != null && temp.getListaUPDTO() != null)
				listaUpDTO.getListaUPDTO().addAll(temp.getListaUPDTO());
			if (temp != null && temp.getResultadoDTO() != null)
				listaUpDTO.setResultadoDTO(temp.getResultadoDTO());
		}

		return listaUpDTO;
	}

	private ListaUPDTO removeRegistro() {
		List<MsUp> listaMsup = null;
		UpDTO updto = new UpDTO();
		ArrayList<UpDTO> lista = new ArrayList<UpDTO>();
		ListaUPDTO listaUpDTO = new ListaUPDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		Date data = null;

		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select msup from MsUp msup ");
		q.append("left join fetch msup.msUpihms ");
		q.append("where msup.idUp = :idup ");

		q.defineParametro("idup", this.getIdUp());

		listaMsup = q.list();

		MsUp msup = null;

		if (listaMsup != null && listaMsup.size() > 0) {
			msup = listaMsup.get(0);
			
		} else {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDUP_DESCONHECIDO);
			listaUpDTO.setResultadoDTO(resultadoDTO);
			return listaUpDTO;
		}

		if (msup.getStAtivo().equals(BigDecimal.ZERO)) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			listaUpDTO.setResultadoDTO(resultadoDTO);
			return listaUpDTO;
			
		} else {
			msup.setStAtivo(BigDecimal.ZERO);
			data = new Date();
			msup.setDthrStativo(data);
			
			if (usarTransacao) {
				daoPdba.iniciaTransacao();
				daoPdba.makePersistent(msup);				
			}

			PTRN rn = new PTRN(getDaoPdba());
			OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());

			updto.setIdUp(msup.getIdUp());
			updto.setCd_up(msup.getCdUp());
			if (ompt != null && ompt.getOmTppt() != null)
				updto.setIdTppt(ompt.getOmTppt().getIdTppt());
			else
				updto.setIdTppt(0l);

			updto.setDs_up(msup.getDsUp());
			updto.setIdUpPDBA(msup.getIduppdba());
			updto.setRevisao(msup.getRevisao());
			updto.setDthrRevisao(msup.getDthrRevisao());
			updto.setDthrStativo(msup.getDthrStativo());
			updto.setStAtivo(msup.getStAtivo());
			updto.setCdBc(msup.getCdBc());

			updto.setUpihmColetados(new ArrayList<UpIhmDTO>());
			for (MsUpihm msupihm : msup.getMsUpihms()) {
				UpIhmDTO upihmdto = new UpIhmDTO(msupihm);

				updto.getUpihmColetados().add(upihmdto);
			}

			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
			
			if (usarTransacao) {
				daoPdba.commitaTransacao(daoPdba.getSession());	
			}
			
		}

		lista.add(updto);
		listaUpDTO.setListaUPDTO(lista);
		listaUpDTO.setResultadoDTO(resultadoDTO);

		return listaUpDTO;
	}

	public ListaUPDTO getTodosPrUp() {
		List<PrUp> listaPrUp = null;

		ListaUPDTO listaUpDTO = new ListaUPDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("select prup ");
		q.append("from PrUp prup ");
		q.append("where prup.stativa = 1");

		listaPrUp = q.list();

		if (listaPrUp == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
		} else {
			listaUpDTO.setPrUps(new ArrayList<PrUp>());
			for (PrUp prup : listaPrUp) {
				PrUp prUpnovo = new PrUp();

				prUpnovo.setIdup(prup.getIdup());
				prUpnovo.setCdmaqestendido(prup.getCdmaqestendido());
				listaUpDTO.getPrUps().add(prUpnovo);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}
		listaUpDTO.setResultadoDTO(resultadoDTO);

		return listaUpDTO;
	}

	/**
	 * @param idLog
	 * @param cdIc
	 * @param evento
	 */
	public void icHeartBeat(int idLog, String cdIc, EventoColetado evento) {

		IdwLogger log = evento.getLog();
		/*
		 * Alessandre: comentei o trecho abaixo em 23-5-13 pois o heartbeat para o pdba esta sendo feito no HeartBeatPdbaMsEvtRN que eh
		 * chamado pelo webservice via concentrador em C# InfoRN infoRN = new InfoRN(IwsFacade.getLog(), daoInjet, daoPdba);
		 *
		 * log.iniciaAvaliacao(idLog, "setTr_IcHeartBeat"); try { infoRN.setUpBeat(urlIC, evento.getDthrEvento()); } catch (Exception e) {
		 * e.printStackTrace(); } log.paraAvaliacao(); log.info(idLog, evento.getIdentacao(), log.getAvaliacaoCompleta());
		 */

		// Executa tambem o heartbeat em DwRt
		ConsolidaRN crn = new ConsolidaRN(getDaoPdba());
		TempoRealRN rn = new TempoRealRN(getDaoPdba());
		log.info(idLog, evento.getIdentacao(), "Heartbeat para o IC " + cdIc);
		// Obtem lista de OmPts que o IC esta gerenciando
		List<MsUp> listaups = null;
		// 180606F&A .if. Especialização para permitir Heartbeat por UP (única UP especificada) - até o momento só havia para todas Ups de
		// um IC
		// 180606F&A .if. Para usar esta especialização, evento.origem deve ser setado com "HEARTBEAT_POR_UP" no post do HeartBeat.
		if (evento != null && evento.getOrigem() != null && evento.getOrigem().equals("HEARTBEAT_POR_UP")) {
			MsUp msup = new MsUp();
			try {
				if (evento != null && evento.getIcUpDTO() != null && evento.getIcUpDTO().getUpDTO() != null
						&& evento.getIcUpDTO().getUpDTO().getCd_up() != null) {
					msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
					log.info(idLog, evento.getIdentacao(), "Heartbeat para o UP " + evento.getIcUpDTO().getUpDTO().getCd_up());
				} else {
					msup = null;
				}
			} catch (RegistroDesconhecidoException e) {
				log.error("[RegistroDesconhecidoException] UpRN.icHeartBeat pesquisarMsUpPorCdUpStAtivo nao executado");
				msup = null;
			}
			listaups = new ArrayList<MsUp>();
			if (msup != null) {
				listaups.add(msup);
			}
		} else { // 180606F&A else [restante deste bloco = antigo]
			listaups = pesquisarListaMsUpPorCdIC(cdIc);
			if (listaups.size() <= 0) {
				listaups = pesquisarListaMsUpPorUrlConexaoIC(cdIc);
			}
		}

		PTRN ptrn = new PTRN(getDaoPdba());

		for (MsUp msup : listaups) {
			boolean jaChequeiLogin = false;
			boolean isLogado = false;
			OmPt ompt = ptrn.pesquisarPtByCdPtStAtivo(msup.getCdUp());

			if (ompt == null) {
				log.info(idLog, evento.getIdentacao(), "NAO Encontrou o pt " + msup.getCdUp());
				continue;
			} else {
				log.info(idLog, evento.getIdentacao(), "Encontrou o pt " + msup.getCdUp());
			}

			if (evento.getQtdEventosPendentes() != null) {
				int qtEvtPen = Integer.valueOf(evento.getQtdEventosPendentes());
				if (qtEvtPen > 10) {
					ompt.setQtEventosnoclp(qtEvtPen);
					ompt.setIsConsolpendente(true);
				} else {
					ompt.setQtEventosnoclp(0);
					ompt.setIsConsolpendente(false);
				}
				getDaoPdba().makePersistent(ompt);
			}

			// Salva o heartbeat no MsPtColeta
			MsPtColeta coleta = ompt.getMsPtColeta();
			if (coleta == null) {
				coleta = new MsPtColeta();
				coleta.setIdPt(ompt.getIdPt());
				coleta.setOmPt(ompt);
				getDaoPdba().getSession().save(coleta);
			}
			coleta.setDthrHeartbeat(evento.getDthrEvento());
			getDaoPdba().makePersistent(coleta);

			/*
			 * Alessandre em 04-04-22 comentei todo o trecho abaixo, pois acredito que a tratativa do logout fique em MsRN 355
			 * 
			 * 
			 * 
			 * //Luiz 20200129 - Incrementei o trecho para efetuar logout automático no fim do turno. TurnoAtualDTO dwTurnoAtual =
			 * IdwFacade.getInstancia().getTurnoAtualDTO(ompt, evento.getDthrEvento()); Date dataHrFimDoTurno =
			 * dwTurnoAtual.getDtHrFTurno(); //Luiz 20200131 - Subtrai alguns segundos da dataHrFimDoTurno para que a regra de logout seja
			 * processada apenas nos intervalos de tempo entre o fim do turno subtraido e o fim do turno. Date dataHrFimDoTurnoSubtraido =
			 * DataHoraRN.subtraiSegundosDaData(dataHrFimDoTurno, 60); //if(DataHoraRN.between(evento.getDthrEvento(),
			 * dataHrFimDoTurnoSubtraido, dataHrFimDoTurno) == true) { if(DataHoraRN.between(evento.getDthrEvento(),
			 * dataHrFimDoTurnoSubtraido, dataHrFimDoTurno) == true){ //Luiz 20200131 - Checo se existe login
			 * log.info("Estou no ultimo minuto do turno e vou verificar os horarios dos logins do pt: "+ ompt.getCdPt() + "e id do pt: "+
			 * ompt.getIdPt()); List<DwConsolmolog> lope = crn.getDwConsolmologComLoginAberto(ompt.getIdPt()); jaChequeiLogin = true; if
			 * (lope != null && lope.size() > 0){ Date dataHrComToleranciaParaLogOut = dwTurnoAtual.getDtHrFTurnoComPreTolerancia();
			 * isLogado = true; for(DwConsolmolog logado : lope) { log.info("Encontrei o login: "+ logado.getOmUsr().getLogin());
			 * if(DataHoraRN.between(logado.getDthrIlogin(), dataHrComToleranciaParaLogOut, dataHrFimDoTurno) == false) {
			 * log.info("O login: " + logado.getOmUsr().getLogin() +
			 * " está logado a mais de 15 minutos do fim do turno. Tentarei efetuar o logout");
			 * evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(msup.getCdUp()));
			 * evento.setLogin(logado.getOmUsr().getLogin()); evento.setTipoEvento(ServicoFactory._LOGOUT); MensagemRecebida mensagem = new
			 * MensagemRecebida(evento); mensagem.setLog(log); try { ServicoFactory.getInstancia().executaServico(null,mensagem); } catch
			 * (ServicoFalhouException e) { // TODO Auto-generated catch block log.info(e.getMessage()); e.printStackTrace(); } } } } else {
			 * log.info("Nao encontrei nenhum login para o pt: "+ ompt.getCdPt()); } } else {
			 * log.info("Ainda não estou entre o ultimo minuto e o fim do turno: "+dataHrFimDoTurnoSubtraido.toString()+
			 * " e fim do turno hora: "+dataHrFimDoTurno); }
			 * 
			 * 
			 */

			// DataHoraRN.subtraiMinutosNaData(dataFimDoTurno, );

			DwRt dwrt = rn.obtemDwRtParaHeartBeat(evento.getDthrEvento(), ompt, log, idLog, 0, null);
			if (dwrt != null) {
				// Alessandre me 04-02-15 subsitui o trecho abaixo para evitar o SNAPSHOT avaliando
				/*
				 * Alessandre em 24-11-15 comentei o update e descomentei o trecho seguinte que havia comentado em 04-02-15 pois o update
				 * nao esta alterando o registro por algum motivo MapQuery q = new MapQuery(getDaoPdba().getSession());
				 * q.append("update DwRt dwrt set isOffline=false, dthrHeartbeat = :data where idRt = :id");
				 * q.defineParametroTimestamp("data", evento.getDthrEvento()); q.defineParametro("id", dwrt.getIdRt());
				 * q.query().executeUpdate();
				 */

				dwrt.setDthrHeartbeat(evento.getDthrEvento());
				dwrt.setIsOffline(false);

				// Verificar se o PT possui planejamento. Se possuir entao setar semPlanejamento false;
				// O sem planejamento true esta sendo setado no obtemDwRtParaHeartBeat para casos em que eventos futuros chegaram
				// e se deseja remover o planejamento. Mas se o pT tiver um planejamento carregado entao setar para false
				if ((ompt.getIsSemop() != null && ompt.getIsSemop() == true) || ompt.getIsSemop() == null || ompt.getPpCp() == null)
					dwrt.setIsSemplanejamento(true);
				else
					dwrt.setIsSemplanejamento(false);
				// Verifica se existe operador logado
				if (jaChequeiLogin == true) {
					dwrt.setIsOperador(isLogado);
				} else {
					List<DwConsolmolog> lope = crn.getDwConsolmologComLoginAberto(ompt.getIdPt());
					if (lope != null && lope.size() > 0)
						dwrt.setIsOperador(true);
					else
						dwrt.setIsOperador(false);

					getDaoPdba().makePersistent(dwrt);
				}

				/*
				 * Alessandre em 08-05-17 Se tiver OP carregada gerar um dwconsolid para turno e hora. A hora a fim de gerar o grafico de
				 * tendencia de parada quando houver uma parada em aberto de muitas horas
				 */
				if (dwrt.getIsSemplanejamento() == false) {
					// crn.obtemConsolIdTurno(log, idLog, ompt, dwrt.getPpCp(), folha, oTurnoAtualDTO, msevt, dwrt);
					// crn.obtemConsolIdHora(omPt, ppCp, dwFolha, dtHrRef, turnoAtualDTO, dwpepro);
				}

				log.info(idLog, evento.getIdentacao(),
						"Heart-beat em dwrt " + dwrt.getIdRt() + " as " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dwrt.getDthrHeartbeat())
								+ " dthrevento=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(evento.getDthrEvento()));
			}
		}
	}

	public List<Object> getCdBcs() {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("Select prbcdb.idmasterbridgecollecdatabase from PrBridgeCollectorDatabase prbcdb ");

		return q.list();
	}

	public List<PrConexoesInjet> getPrConexoesInjet() {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from PrConexoesInjet prconinjet");

		return q.list();
	}

	public void trataEventos(int idLog, IcDTO msIcDTO)
			throws ServicoFalhouException {

		// adicionar o tratamento de msevt
	}

	public void lancaMedicaoParametro(IdwLogger log, int idLog, int identacao, EventoColetado evento) {

		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		eventoRN.incluirEvento(log, idLog, identacao, evento,
				MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId(), null); // validar
																		// o
																		// tipo
																		// do
																		// evento
																		// para
																		// evento
																		// RN
	}

	public void lancaMaquinaOffLine(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();

		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());

		eventoRN.incluirEvento(log, idLog, identacao, evento,
				MsTpevtTemplate.Type.MAQUINA_OFFLINE.getId(), null); // validar
																		// o
																		// tipo
																		// do
																		// evento
																		// para
																		// evento
																		// RN
	}

	public void lancaMaquinaOnLine(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();

		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		eventoRN.incluirEvento(log, idLog, identacao, evento,
				MsTpevtTemplate.Type.MAQUINA_ONLINE.getId(), null); // validar o
																	// tipo do
																	// evento
																	// para
																	// evento RN
	}

	public void insereErroInsersora(int idLog, int identacao, EventoColetado evento) throws ServicoFalhouException {
		IdwLogger log = evento.getLog();

		MsUp msup = null;

		log.iniciaAvaliacao(idLog, "pesquisarMsUpPorCdUpStAtivo-insereErro");
		// Alessandre: em 31-01-15 substitui a linha abaixo pela seguinte pois em algumas situacoes em que o idUp pesquisado estï¿½
		// incorrendo pegando-se assim o valor errado
		// de referencia para o inicio do ciclo, causando assim tempos duplicados para um turno
		// msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());
		try {
			msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
		} catch (RegistroDesconhecidoException e1) {
			msup = null;
		}

		if (msup != null)
			log.info(idLog, identacao, "Encontrou msUp com id = " + msup.getIdUp() + " em id_icup = " + evento.getIcUpDTO().getIdIcUp());
		else
			log.info(idLog, identacao, "Nï¿½o encontrou msUp com id = " + evento.getIcUpDTO().getUpDTO().getIdUp());

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

		// Inclui tambem o registro de erroinsersora em MsEvt
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());
		log.iniciaAvaliacao(idLog, "incluirEvento");
		eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.PERDA_MATERIA_PRIMA.getId(), null);

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());

	}

	public void regristrarPassagem(String cdPt, String cdOp, String cb, Date dthr, String qtde)
			throws ServicoFalhouException, SemSGBDException, ParseException {
		EventoColetado ev = new EventoColetado();
		IdwLogger log = new IdwLogger("registraPassagemViaWS");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		IcUpDTO icup = Stubedelegate.getInstancia().getMsthread().getIcUp(cdPt);

		if (icup != null) {
			ev.setCb(cb);
			ev.setCdop(cdOp);
			ev.setUp(cdPt);
			ev.setQtde(qtde);
			ev.setIcUpDTO(icup);
			ev.setDthrEvento(dthr);
			ev.setLog(log);

			registrarPassagem(idLog, identacao, ev);
		} else {
			log.error("regristrarPassagem nao executado por causa do icUP = NULL");
		}

	}

	public void regristrarTesteSimples(String cdPt, String cdOp, String cb, Date dthr, Integer stTeste, String qtde)
			throws ServicoFalhouException, SemSGBDException, ParseException {
		EventoColetado ev = new EventoColetado();
		IdwLogger log = new IdwLogger("registraPassagemViaWS");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		IcUpDTO icup = Stubedelegate.getInstancia().getMsthread().getIcUp(cdPt);

		ev.setCb(cb);
		ev.setCdop(cdOp);
		ev.setUp(cdPt);
		ev.setIcUpDTO(icup);
		ev.setQtde(qtde);
		ev.setIsCbConforme(stTeste != null && stTeste == 1);
		ev.setDthrEvento(dthr);
		ev.setLog(log);

		if (ev.getIsCbConforme() == false)
			ev.setCddefeito("DEF");

		registrarPassagem(idLog, identacao, ev);

	}

	public void regristrarTesteDefeito(String cdPt, String cdOp, String cb, Date dthr, String cdDefeito, String qtde,
			String cdAreaResponsavel, String posicoesMecanicas, Long seqbigint)
			throws ServicoFalhouException, SemSGBDException, ParseException {

		EventoColetado ev = new EventoColetado();

		IdwLogger log = new IdwLogger("registraPassagemViaWS");

		int idLog = log.getIdAleatorio();
		int identacao = 0;

		IcUpDTO icup = Stubedelegate.getInstancia().getMsthread().getIcUp(cdPt);

		ev.setCb(cb);
		ev.setCdop(cdOp);
		ev.setUp(cdPt);
		ev.setIcUpDTO(icup);
		ev.setIsCbConforme(false);
		ev.setCddefeito(cdDefeito);
		ev.setDthrEvento(dthr);
		ev.setQtde(qtde);
		ev.setLog(log);
		ev.setCdarearesponsavel(cdAreaResponsavel);
		ev.setOrigem(posicoesMecanicas);

		if (seqbigint != null && seqbigint.longValue() > 0L) {
			ev.setSeqbigint(seqbigint);
		}

		registrarPassagem(idLog, identacao, ev);

	}

	/*
	 * O registro da passagem deve inserir em msEvt para posterior processamento
	 */
	public MsEvt registrarPassagem(int idLog, int identacao, EventoColetado evento) throws ServicoFalhouException, SemSGBDException {

		IdwLogger log = evento.getLog();

		MsUp msup = null;
		MsEvt retorno = null;

		// Alessandre: em 31-01-15 substitui a linha abaixo pela seguinte pois em algumas situacoes em que o idUp pesquisado esta incorreto,
		// pegando-se assim o valor errado
		// de referencia para o inicio do ciclo, causando tempos duplicados para um turno
		// msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());
		try {
			if (evento.getIcUpDTO() == null || evento.getIcUpDTO().getUpDTO() == null)
				throw new RegistroDesconhecidoException();

			if (evento.getIcUpDTO().getUpDTO().getCd_up() != null)
				msup = pesquisarMsUpPorCdUpStAtivo(evento.getIcUpDTO().getUpDTO().getCd_up());
			else
				msup = pesquisarMsUpPorIdUp(evento.getIcUpDTO().getUpDTO().getIdUp());

		} catch (RegistroDesconhecidoException e1) {
			log.info(idLog, identacao, "Nao encontrou msicup em msthread");
			throw new ServicoFalhouException(e1);
		}

		// Encontrar omPt para verificar se o evento de passagem sera lancado. Será lancado somente se um NS unico. Senao somente o ciclo
		// deve ser lancado com a qtde
		PTRN ptrn = new PTRN(getDaoPdba());
		VerificaDefeitoRN drn = new VerificaDefeitoRN();
		drn.setDao(getDaoPdba());

		OmPt ompt = null;

		try {
			ompt = ptrn.getOmPt(msup.getCdUp());
			log.info(idLog, identacao, "Encontrou em pt a up " + msup.getCdUp());
		} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
			log.info(idLog, identacao, "PT " + msup.getCdUp() + " desconhecido.");
			throw new ServicoFalhouException(e);
		}

		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoPdba().getSession());

		// O ciclo soh nao sera lancado se for um NS valido que nao permite lancar o ciclo
		/* Alessandre em 11-07-18 se o teste foi com falha então o ciclo nao deve ser lancado */
		boolean isLancarCiclo;
		if (evento.getIsCbConforme() != null && evento.getIsCbConforme() == false)
			isLancarCiclo = false;
		else
			isLancarCiclo = true;

		// Se for para lancar passagem (avaliando ompt) entao lancar

		/*
		 * Alessandre 30-06-17 Viqua. O campo ompt.isSolicitaQtde esta sendo usado para indicar se a passagem vai ser lancada ou nao
		 * entretanto, o campo serve para indicar se o evento de ciclo vai lancar ou nao a qtde produzida durante o ciclo. as máquinas
		 * ciclicas por default sempre vao lancar a producao do ciclo. Mas no teste da viqua o inova via c# lanca ciclo e passagem tambem, e
		 * com o if abaixo a passagem nunca esta sendo lancada. Assim acrescentei tambem o teste se o posto for ciclico Dessa forma a
		 * passagem sera lancada sempre para esse tipo de posto
		 */
		if ((ompt.getIsSolicitaqtde() != null && ompt.getIsSolicitaqtde() == false) || ompt.getIsSolicitaqtde() == null
				|| ompt.getOmTppt().isMaquinaCiclica()) {

			// Pesquisa se existe um evento do posto para a OP com o CB ja lancado
			MsEvt msevt = eventoRN.pesquisarMsEvtByCBeUP(evento.getCb(), new BigDecimal(evento.getIcUpDTO().getIdIcUp()), evento.getCdop());

			// Incluir a passagem
			retorno = eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.PASSAGEM.getId(), null);

			// O teste abaixo eh feito pq quando for maquina ciclica, ou seja inova, o inova vai mandar um final de ciclo
			if (msevt != null || ompt.getOmTppt().isMaquinaCiclica())
				isLancarCiclo = false;

			// TODO: continuar implementacao
			// Ailton 2019-09-17: Se o evento de passagem foi lancado no msevt, se verifica a qtde de materia prima disponivel
			// caso atinja a qtde <= 0, lanca-se um inicio de parada
			// if (retorno != null)
			// verificaMPDisponivel(ompt, retorno, log, idLog, identacao);

		}

		if (isLancarCiclo) {
			log.info(idLog, identacao,
					"lancando ciclo para cb=" + evento.getCb() + " id=" + evento.getIcUpDTO().getIdIcUp() + " cdop=" + evento.getCdop());
			evento.setTipoEvento(MsTpevtTemplate.Type.FIM_CICLO.getId());
			evento.setMontagem(null); // Limpa montagem se houver alguma
			// Alessandre em 08-3-17 comentei a linha abaixo pois vou colocar na consolidacao um filtro para evitar
			// q o mesmo ciclo seja consolidado 2x
			// evento.setCb(null); // Limpa o NS pois nao quero perder o ciclo se o NS nao tiver um produto valido
			finalCiclo(idLog, identacao, evento);
		} else {
			log.info(idLog, identacao, "NS nao valido PARA CICLO com dados op = " + evento.getCdop() + " ns = " + evento.getNumeroSerie()
					+ " produto = " + evento.getCdproduto() + " cb=" + evento.getCb());
		}

		/*
		 * Verificar se um evento de perda de componente deve ser lancado. Uma perda será lancada apenas se a passagem tiver um codigo de
		 * defeito que esteja precadastrado com o flag para lancamento dessa perda de componente
		 */
		List<DefeitoDTO> defeitos = evento.getDefeitos();

		if (defeitos != null && defeitos.isEmpty() == false) {

			for (DefeitoDTO defeito : defeitos) {
				if (defeito.getCdDefeito() != null && defeito.getCdDefeito().equals("") == false) {
					// Verifica se dw_t_defeito esta marcado como lanca defeito
					DwTDefeito dwtdefeito = drn.getTDefeito(ompt.getOmTppt(), defeito.getCdDefeito());
					if (dwtdefeito != null && dwtdefeito.getIsLancarperdamp() != null && dwtdefeito.getIsLancarperdamp()) {
						log.info(idLog, identacao, "lancando perda de mp para o cb=" + evento.getCb());
						evento.setTipoEvento(MsTpevtTemplate.Type.PERDA_MATERIA_PRIMA.getId());
						evento.setMontagem(null);
						evento.setDefeitos(null);

						ErroInsersoraDTO erro = new ErroInsersoraDTO();
						erro.setTipoErro(defeito.getCdDefeito());
						erro.setComponente(defeito.getCb());
						erro.setQtErro("1");
						evento.setErroInsersora(erro);
						insereErroInsersora(idLog, identacao, evento);
					}
				}
			}
		}

		if (evento.getCddefeito() != null && evento.getCddefeito().equals("") == false) {
			// Verifica se dw_t_defeito esta marcado como lanca defeito
			DwTDefeito dwtdefeito = drn.getTDefeito(ompt.getOmTppt(), evento.getCddefeito());

			if (dwtdefeito != null && dwtdefeito.getIsLancarperdamp() != null && dwtdefeito.getIsLancarperdamp()) {
				log.info(idLog, identacao, "lancando perda de mp para o cb=" + evento.getCb());
				evento.setTipoEvento(MsTpevtTemplate.Type.PERDA_MATERIA_PRIMA.getId());
				evento.setMontagem(null);
				evento.setDefeitos(null);
				ErroInsersoraDTO erro = new ErroInsersoraDTO();
				erro.setTipoErro(evento.getCddefeito());
				erro.setComponente(evento.getCb());
				erro.setQtErro("1");
				evento.setErroInsersora(erro);
				insereErroInsersora(idLog, identacao, evento);
			}
		}

		return retorno;
	}

	// TODO: continuar a implementacao
	/*
	 * private void verificaMPDisponivel(OmPt ompt, MsEvt msevt, IdwLogger log, int idLog, int identacao) { DwNserie dwnseriedb = new
	 * DwNserie(); dwnseriedb.setCb(msevt.getCb()); dwnseriedb.setCbserial(msevt.getCbserial()); dwnseriedb.setDwEst(null);
	 * dwnseriedb.setIdNserie(0l); dwnseriedb.setNs(msevt.getCb()); //dwnseriedb.setOmProduto(omProduto);
	 * 
	 * List<OmAlimrea> lista = obtemAlimreaASerConsumido(ompt);
	 * 
	 * if (lista != null) { BigDecimal producaoPorCiclo = BigDecimal.ONE;
	 * 
	 * // Devido a dificuldades tecnicas, o abaixo nao esta sendo utilizado // producaoPorCiclo = folhaRN.getPcsPorCicloAtivas(dwFolha);
	 * 
	 * // Se a producao por ciclo encontrada for diferente da qtde enviada no msevt.qtde, utilizar msevt.qtde, pois a mesma pode ter a //
	 * qtde de codigos de barras identificados if (msevt.getQtde() != null && producaoPorCiclo.compareTo(msevt.getQtde()) != 0) {
	 * producaoPorCiclo = msevt.getQtde(); }
	 * 
	 * // Ordena a lista de omalimrea das mais antigas as mais receentes. Ou seja, as mais antigas devem ser consumidas 1o que as mais //
	 * recentes Collections.sort(lista, new Comparator<OmAlimrea>() {
	 * 
	 * @Override public int compare(OmAlimrea o1, OmAlimrea o2) { //return o1.getIdAlimrea().compareTo(o2.getIdAlimrea()) * -1; //return
	 * o1.getCbRap().compareTo(o2.getCbRap()) * -1; return o1.getCbRap().compareTo(o2.getCbRap()) * -1; } });
	 * 
	 * 
	 * // tem uma situacao em que a realimentacao inclui varias vezes para o mesmo feeder por exemplo a placa, e estava consumindo para
	 * todas as realimentacoes // tenho q consumir apenas a mais antiga com saldo e nao considerar as outras // A olucao sera criar um vetor
	 * com os feeder ja consumidos na interacao
	 * 
	 * List<String> feederJaConsumidos = new ArrayList<>(); BigDecimal qtdeRestanteParaConsumo = null;
	 * 
	 * for (OmAlimrea omalimrea : lista) {
	 * 
	 * // Avalia se o feeder já foi consumido, se sim nao precisa mais consumir. if (feederJaConsumidos.contains(omalimrea.getCbRap()) ||
	 * omalimrea.getQtAlimentada() == null || omalimrea.getQtAlimentada() <= 0 ) { continue; } BigDecimal qtdeConsumidaPorNS =
	 * omalimrea.getOmMapapa().getQtUsada(); // Se o CB comecar com NS significa que foi gerado automaticamente, nesse caso nao faremos a
	 * divisao abaixo if (msevt.getCb().trim().substring(0, 2).equals("NS") == false) qtdeConsumidaPorNS =
	 * qtdeConsumidaPorNS.divide(producaoPorCiclo);
	 * 
	 * BigDecimal qtdeConsumidaTotal = omalimrea.getQtUsada(); BigDecimal qtdeConsumidaTotalAnterior = omalimrea.getQtUsada(); if
	 * (qtdeConsumidaTotal == null) { qtdeConsumidaTotal = BigDecimal.ZERO; log.info(idLog, identacao,
	 * "qtdeConsumidaTotal null, assumindo 0"); } // Caso tenha sobrado algum valor a ser consumido do processamento anterior entao
	 * utiliza-lo como referencia if (qtdeRestanteParaConsumo != null) { qtdeConsumidaPorNS = qtdeRestanteParaConsumo;
	 * qtdeRestanteParaConsumo = null; }
	 * 
	 * qtdeConsumidaTotal = qtdeConsumidaTotal.add(qtdeConsumidaPorNS);
	 * 
	 * // Pode ocorrer da quantidade a ser consumida seja maior que a alimentada, nesse caso, devemos consumir ate o limite da alimentacao e
	 * o que sobrar // * utlizar para a proxima alimentacao
	 * 
	 * if (qtdeConsumidaTotal.compareTo(new BigDecimal(omalimrea.getQtAlimentada())) > 0) { // Calcular o que falta ser consumido. Essa
	 * quantidade deve ser consumida na proxima realimentacao qtdeRestanteParaConsumo = qtdeConsumidaTotal.subtract(new
	 * BigDecimal(omalimrea.getQtAlimentada()));
	 * 
	 * // Consome o total alimentado qtdeConsumidaTotal = new BigDecimal(omalimrea.getQtAlimentada());
	 * 
	 * // Remove o feeder da relacao dos ja consummidos para consumir novamente na proxima reailmentacao dispoinivel
	 * feederJaConsumidos.remove(omalimrea.getCbRap()); } log.info(idLog, identacao, "qtAlimentada=" + omalimrea.getQtAlimentada() +
	 * " qtUsadaAnterior=" + omalimrea.getQtUsada() + " qtde=" + qtdeConsumidaPorNS + " novaQtUsada=" + qtdeConsumidaTotal);
	 * 
	 * //omalimrea.setQtUsada(qtdeConsumidaTotal);
	 * 
	 * BigDecimal qtAtualAnterior = omalimrea.getQtAtual(); BigDecimal qtAtual = new BigDecimal(omalimrea.getQtAlimentada());
	 * log.info(idLog, identacao, "qtAtual=" + qtAtual); qtAtual = qtAtual.subtract(omalimrea.getQtUsada()); log.info(idLog, identacao,
	 * "qtAtual=" + qtAtual);
	 * 
	 * if (omalimrea.getQtPerdida() != null) { qtAtual = qtAtual.subtract(omalimrea.getQtPerdida()); log.info(idLog, identacao, "qtAtual=" +
	 * qtAtual); }
	 * 
	 * // omalimrea.setQtAtual(qtAtual);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * private List<OmAlimrea> obtemAlimreaASerConsumido(OmPt ompt) { List<OmAlimrea> retorno = new ArrayList<>();
	 * 
	 * MapQuery qAlim = new MapQuery(daoPdba.getSession());
	 * 
	 * // Obtem a ultima alimentacao qAlim.append("select a"); qAlim.append("from OmAlim a"); qAlim.append("join a.omMapa b");
	 * qAlim.append("join b.omPt c"); qAlim.append("where c = :ompt"); qAlim.append("and a.tpAlim = 3"); // alimnetacao
	 * qAlim.append("and a.stAlim = 1"); // sucesso qAlim.append("order by a.idAlim desc");
	 * 
	 * qAlim.setMaxResults(1);
	 * 
	 * 
	 * // Obtem as leituras da ultima alimentacao que tenham saldo para consumo // Nao se pode pegar as realimentacoes, apenas o q tem saldo
	 * // e desconsiderar as leituras com erro MapQuery qAlimrea1 = new MapQuery(daoPdba.getSession()); qAlimrea1.append("select a");
	 * qAlimrea1.append("from OmAlimrea a"); qAlimrea1.append("where a.omAlim = :omalim"); qAlimrea1.append("and a.stLeitura <> 2"); //
	 * lelitura com erro qAlimrea1.append("and a.qtAtual is not null and a.qtAtual > 0"); // qtAtual sera null na 1a vez que processar uma
	 * passagem
	 * 
	 * MapQuery qAlimrea2 = new MapQuery(daoPdba.getSession()); qAlimrea2.append("select a2"); qAlimrea2.append("from OmAlimrea a2");
	 * qAlimrea2.append("where a2.omAlim = :omalim"); qAlimrea2.append("and a2.stLeitura <> 2"); // lelitura com erro
	 * qAlimrea2.append("and a2.qtAtual is null and a2.omMapapa.omPa.	idPa not in (");
	 * qAlimrea2.append("select a3.omMapapa.omPa.idPa from OmAlimrea a3 where a3.omAlim = :omalim and a3.stLeitura <> 2 and ");
	 * qAlimrea2.append("a3.qtAtual is not null and a3.qtAtual > 0 )");
	 * 
	 * 
	 * List<OmPt> listapts = new ArrayList<>(); listapts.add(ompt); for (OmPtcnc cnc : ompt.getOmPtcncsForIdPt()) {
	 * listapts.add(cnc.getOmPtByIdPtFilho()); }
	 * 
	 * for (OmPt omptAux : listapts) { qAlim.defineParametro("ompt", omptAux); OmAlim omalim = (OmAlim) qAlim.uniqueResult(); if (omalim ==
	 * null) continue;
	 * 
	 * 
	 * qAlimrea1.defineParametro("omalim", omalim); List<OmAlimrea> lista = qAlimrea1.list();
	 * 
	 * // * A lista contem as alimentacoes e realimentações que faltam ser consumidas // * Se houver uma alimentacao que ainda nao foi
	 * totalmente consumida e existe uma realimentacao tambem, desconsiderar o omalimrea da realimentacao
	 * qAlimrea2.defineParametro("omalim", omalim); List<OmAlimrea> lista2 = qAlimrea2.list();
	 * 
	 * 
	 * retorno.addAll(lista); retorno.addAll(lista2); }
	 * 
	 * return retorno; }
	 */

	private class ProducaoDTO {
		private double producaoLiquida;
		private double producaoRefugada;

		public double getProducaoLiquida() {
			return producaoLiquida;
		}

		public void setProducaoLiquida(double producaoLiquida) {
			this.producaoLiquida = producaoLiquida;
		}

		public double getProducaoRefugada() {
			return producaoRefugada;
		}

		public void setProducaoRefugada(double producaoRefugada) {
			this.producaoRefugada = producaoRefugada;
		}

	};

	private ProducaoDTO getProducaoDaOPDuranteCIP(OmPt ompt, PpCp ppcp) {
		ProducaoDTO retorno = new ProducaoDTO();

		MapQuery q = new MapQuery(daoPdba.getSession());
		q.append("select dwConsol ");
		q.append("from DwConsolid dwConsolid");
		q.append("join dwConsolid.dwConsols dwConsol");
		q.append("where dwConsolid.omPt.idPt = :idPt");
		q.append("and dwConsolid.ppCp.idCp = :idCp");
		q.append("and dwConsolid.tpId = 1");
		q.append("and dwConsolid.dwPepro.idPepro = 2");
		q.append("order by dwConsolid.dthrIturno desc");

		q.defineParametro("idPt", ompt.getIdPt());
		q.defineParametro("idCp", ppcp.getIdCp());

		q.setMaxResults(1);

		DwConsol dwConsol = null;

		try {
			dwConsol = (DwConsol) q.uniqueResult();
		} catch (Exception e) {
			dwConsol = null;
		}

		if (dwConsol != null) {
			if (dwConsol.getPcsProducaoBruta() != null)
				retorno.setProducaoLiquida(dwConsol.getPcsProducaoBruta().doubleValue()); // acho q producaoliquida deveria ser bruta
			if (dwConsol.getPcsProducaoRefugada() != null)
				retorno.setProducaoRefugada(dwConsol.getPcsProducaoRefugada().doubleValue());
		}

		return retorno;

	}

	public ConsultaInovaSADTO consultaGenericaINOVASA(EventoColetado evento) {
		OmPt ompt = new OmPt();
		PTRN ptrn = new PTRN(daoPdba);
		FolhaRN frn = null;
		CIPRN ciprn = null;
		if (evento.getUp() != null) {
			try {
				ompt = ptrn.getOmPt(evento.getUp());
			} catch (idw.model.excessoes.RegistroDesconhecidoException e) {
				return null;
			}
		}

		Date dtHrAtual = new Date();

		TurnoRN turnoRN = new TurnoRN(daoPdba);
		TurnoAtualDTO turnoAtual = turnoRN.getTurnoAtualDTOComClone(ompt, dtHrAtual);
		Date dtreferencia = turnoAtual.getDtReferencia();

		MonitorizacaoVisaoMaquinaRN rn = new MonitorizacaoVisaoMaquinaRN();
		rn.setDao(daoPdba);

		boolean isTurnoAtual = true;

		OmObj omobj = new OmObj();
		omobj.setOmPt(ompt);
		omobj.setTpObj(omobj.getTIPO_OBJ_PT());
		OmGt omgt = new OmGt();
		omgt.setIdGt(0l);
		omgt.setCdGt("");
		omgt.setDsGt("");
		omobj.setOmGtByIdGt(omgt);
		OmCfg omcfg = Util.getConfigGeral(daoPdba.getSession());

		ConsultaInovaSADTO retorno = new ConsultaInovaSADTO();
		Integer filtroOP; // TURNO_ULTIMA_OP=0, TURNO=1, ULTIMA_OP=2
		DwConsolidTemplate.TpId tpId; // HORA((byte)0),TURNO((byte)1),MES((byte)2),ACUMULADO((byte)3)

		DetalheMonitorizacaoPTInsertRN myRn = new DetalheMonitorizacaoPTInsertRN();
		myRn.setDao(ptrn.getDao());
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		DetalheMonitorizacaoPTInjetDTO injetDTO = null;

		// TODO: APAGAR OS SYSOUT APOS TESTAR TODOS OS TIPOS DE PREENCHIMENTO DE RETORNO
		int cdConsulta = 0;
		try {
			cdConsulta = Integer.parseInt(evento.getCdconsulta());
		} catch (NumberFormatException e) {
			cdConsulta = -1;
		}

		switch (cdConsulta) {
		case ServicoFactory._PROD_LIQ_EFI_REAL_TURNO:
			filtroOP = 0;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			break;

		case ServicoFactory._PROD_LIQ_EFI_REAL_OP:
			filtro.setOmPt(ompt);
			filtro.setFiltroOp(0);
			filtro.setPpCp(ompt.getPpCp());
			if (ompt.getPpCp() != null && ompt.getPpCp().getCdCp() != null)
				filtro.setCdCp(ompt.getPpCp().getCdCp());
			filtro.setTpId(FiltroDetalhePTInjetDTO.CONSOLIDACAO_MAQUINA_ACUMULADO);
			filtro.setDwTurno(turnoAtual.getDwturno());
			filtro.setDtReferencia(turnoAtual.getDtReferencia());

			injetDTO = myRn.getDetalheMonitorizacaoPtInjetDTO(filtro);

			retorno.setProducaoLiquida(injetDTO.getQtdPecasBoas());
			retorno.setEfiRealizacao(injetDTO.getEfiRealizacao());
			break;

		case ServicoFactory._QTD_REF_INDI_REF_TURNO:
			filtroOP = 0;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			break;

		case ServicoFactory._QTD_REF_INDI_REF_OP:
			filtro.setOmPt(ompt);
			filtro.setFiltroOp(0);
			filtro.setPpCp(ompt.getPpCp());
			if (ompt.getPpCp() != null && ompt.getPpCp().getCdCp() != null)
				filtro.setCdCp(ompt.getPpCp().getCdCp());
			filtro.setTpId(FiltroDetalhePTInjetDTO.CONSOLIDACAO_MAQUINA_ACUMULADO);
			filtro.setDwTurno(turnoAtual.getDwturno());
			filtro.setDtReferencia(turnoAtual.getDtReferencia());

			injetDTO = myRn.getDetalheMonitorizacaoPtInjetDTO(filtro);

			retorno.setProducaoRefugada(injetDTO.getQtdRefugadas());
			retorno.setIndiceRefugos(injetDTO.getIndiceRefugos());

			break;

		case ServicoFactory._A_PRDZR_NUM_OP_MLD_OR_EST_OR_CDPROD:
			filtroOP = 2;
			tpId = DwConsolidTemplate.TpId.ACUMULADO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			retorno.setUltimaOp(ompt.getPpCp().getPpCpprodutos().iterator().next().getNrDoc());
			Double saldoAProduzir = 0d;
			if (ompt.getPpCp() != null && (ompt.getIsSemop() != null ? ompt.getIsSemop() == false : true)) {
				frn = new FolhaRN(daoPdba);
				List<DadosProdutoSADTO> listaDeProdutos = frn.getDadosDeProdutoDaOPStandAlone(ompt.getPpCp().getIdCp(), ompt.getIdPt());

				for (DadosProdutoSADTO p : listaDeProdutos) {
					if (p.getPcsProducaoplanejada() != null)
						saldoAProduzir += p.getPcsProducaoplanejada().doubleValue();
					if (p.getPcsProducaobruta() != null)
						saldoAProduzir -= p.getPcsProducaobruta().doubleValue();
					if (p.getPcsProducaorefugada() != null)
						saldoAProduzir += p.getPcsProducaorefugada().doubleValue();
				}
			}
			retorno.setSaldoAProduzir(saldoAProduzir);

			break;

		case ServicoFactory._CICLO_MED_CICLO_PAD_TURNO:
			filtro.setOmPt(ompt);
			filtro.setFiltroOp(0);
			filtro.setPpCp(ompt.getPpCp());
			if (ompt.getPpCp() != null && ompt.getPpCp().getCdCp() != null)
				filtro.setCdCp(ompt.getPpCp().getCdCp());
			filtro.setDwTurno(turnoAtual.getDwturno());
			filtro.setDtReferencia(turnoAtual.getDtReferencia());
			filtro.setTpId(FiltroDetalhePTInjetDTO.CONSOLIDACAO_MAQUINA_TURNO);

			injetDTO = myRn.getDetalheMonitorizacaoPtInjetDTO(filtro);

			retorno.setCicloMedio(injetDTO.getCiclosCicMedio());
			retorno.setCicloPadrao(injetDTO.getCiclosCicPadrao());

			break;

		case ServicoFactory._INDC_PAR_TURNO_INDC_PAR_OP:
			filtroOP = 0;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(
					retorno,
					omobj,
					omcfg,
					evento.getLog(),
					dtreferencia,
					turnoAtual.getDwturno(),
					rn,
					tpId,
					isTurnoAtual,
					filtroOP);
			Double indiceParadasPorTurno = retorno.getIndiceParadas();

			retorno = new ConsultaInovaSADTO();
			filtroOP = 2;
			tpId = DwConsolidTemplate.TpId.ACUMULADO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(
					retorno,
					omobj,
					omcfg,
					evento.getLog(),
					dtreferencia,
					turnoAtual.getDwturno(),
					rn,
					tpId,
					isTurnoAtual,
					filtroOP);

			retorno.setIndiceParadasPorOP(retorno.getIndiceParadas());
			retorno.setIndiceParadasPorTurno(indiceParadasPorTurno);

			break;

		case ServicoFactory._PRODLIQ_EFI_REAL_TODAS_OP:
			filtroOP = 1;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			break;

		case ServicoFactory._PRODLIQ_EFI_REAL_TODAS_ACU:
			filtroOP = 1;
			tpId = DwConsolidTemplate.TpId.ACUMULADO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			break;

		case ServicoFactory._EFI_CICLO_TURNO_E_OP:
			filtroOP = 0;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);
			Double efiCiclosTurno = retorno.getEfiCiclos();

			retorno = new ConsultaInovaSADTO();
			filtroOP = 2;
			tpId = DwConsolidTemplate.TpId.ACUMULADO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);
			retorno.setEfiCiclosOP(retorno.getEfiCiclos());
			retorno.setEfiCiclosTurno(efiCiclosTurno);

			break;

		case ServicoFactory._TIME_INTERV_META_PROD_HR:

			filtro.setOmPt(ompt);
			filtro.setFiltroOp(0);
			filtro.setPpCp(ompt.getPpCp());
			filtro.setCdCp(ompt.getPpCp().getCdCp());
			filtro.setDthrIhora(DataHoraRN.getDataHoraInicial(dtHrAtual));
			filtro.setDthrFhora(DataHoraRN.getDataHoraFinal(dtHrAtual));
			filtro.setDwTurno(turnoAtual.getDwturno());
			filtro.setDtReferencia(turnoAtual.getDtReferencia());
			filtro.setTpId(FiltroDetalhePTInjetDTO.CONSOLIDACAO_MAQUINA_HORA);

			injetDTO = myRn.getDetalheMonitorizacaoPtInjetDTO(filtro);

			SimpleDateFormat sdf1 = new SimpleDateFormat("kk");
			String horaAtual = sdf1.format(dtHrAtual);
			String intervaloHora = horaAtual + ":00:00 - " + horaAtual + ":59:59";

			retorno.setMetaProdHora(injetDTO.getMetaHora());
			retorno.setIntervaloHora(intervaloHora);

			break;

		case ServicoFactory._PRODLIQ_EFI_REAL_HR:
			filtro.setOmPt(ompt);
			filtro.setFiltroOp(0);
			filtro.setPpCp(ompt.getPpCp());
			filtro.setCdCp(ompt.getPpCp().getCdCp());
			filtro.setDthrIhora(DataHoraRN.getDataHoraInicial(dtHrAtual));
			filtro.setDthrFhora(DataHoraRN.getDataHoraFinal(dtHrAtual));
			filtro.setDwTurno(turnoAtual.getDwturno());
			filtro.setDtReferencia(turnoAtual.getDtReferencia());
			filtro.setTpId(FiltroDetalhePTInjetDTO.CONSOLIDACAO_MAQUINA_HORA);

			injetDTO = myRn.getDetalheMonitorizacaoPtInjetDTO(filtro);

			retorno.setProducaoLiquida(injetDTO.getQtdPecasBoas());
			retorno.setEfiRealizacao(injetDTO.getEfiRealizacao());

			break;

		case ServicoFactory._TURNO_DTHR_ATUAL: // TODO: NAO IMPLEMENTADA
			if (turnoAtual.getDwturno() != null)
				retorno.setDsTurno(turnoAtual.getDwturno().getDsTurno());
			else
				retorno.setDsTurno("");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
			retorno.setDthrAtual(sdf2.format(dtHrAtual));

			break;

		case ServicoFactory._QTD_REF_INDI_REF_TODAS_OP:
			filtroOP = 1;
			tpId = DwConsolidTemplate.TpId.ACUMULADO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			break;

		case ServicoFactory._IND_PAR_TURNO_TODAS_OP_E_ATUAL:
			filtroOP = 0;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);
			Double indiceParadas = retorno.getIndiceParadas();

			retorno = new ConsultaInovaSADTO();
			filtroOP = 2;
			tpId = DwConsolidTemplate.TpId.ACUMULADO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);
			retorno.setIndiceParadasPorOP(retorno.getIndiceParadas());
			retorno.setIndiceParadasPorTurno(indiceParadas);

			break;

		case ServicoFactory._EFI_CICLO_TURNO_TODAS_OP_E_ATUAL:
			filtroOP = 0;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);
			Double efiCiclos = retorno.getEfiCiclos();

			retorno = new ConsultaInovaSADTO();
			filtroOP = 2;
			tpId = DwConsolidTemplate.TpId.ACUMULADO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);
			retorno.setEfiCiclosOP(retorno.getEfiCiclos());
			retorno.setEfiCiclosTurno(efiCiclos);

			break;

		case ServicoFactory._COD_E_DES_ULTIMA_PAR: // TODO: JA TEM A TELA DE PARADA
			if (ompt.getMsPtColeta() != null && ompt.getMsPtColeta().getDwTParada() != null) {
				retorno.setUltimaParada(ompt.getMsPtColeta().getDwTParada().getCdTparada());
				retorno.setDsUltimaParada(ompt.getMsPtColeta().getDwTParada().getDsTparada());
			} else if (omcfg != null && omcfg.getDwTParada() != null) {
				retorno.setUltimaParada(omcfg.getDwTParada().getCdTparada());
				retorno.setDsUltimaParada(omcfg.getDwTParada().getDsTparada());
			}
			break;

		case ServicoFactory._PRODUTOS_DA_OP: // TODO: NAO IMPLEMENTADA
			List<String> listaProd = new ArrayList<String>();
			try {
				frn = new FolhaRN(daoPdba);
				List<DadosProdutoSADTO> listaDeProdutosOP = frn.getDadosDeProdutoDaOPStandAlone(ompt.getPpCp().getIdCp(), ompt.getIdPt());
				for (DadosProdutoSADTO p : listaDeProdutosOP) {
					listaProd.add(p.getCdProduto());
				}
			} catch (Exception e) {

			}
			retorno.setListaProdutos(listaProd);
			break;
		case ServicoFactory._CIP_DTHR_DURATION: // TODO: NAO IMPLEMENTADA
			retorno.setCIP(false);

			try {
				ciprn = new CIPRN(daoPdba);
				DwConsolciplog ciplog = ciprn.getUltimoCIPByOmPt(ompt);

				if (ciplog != null && ciplog.getDthrFcip() == null && ciplog.getDthrIcip() != null) {
					String cipDthrIni = DataHoraRN.dateToStringDDMMYYYYHHMMSS(ciplog.getDthrIcip());

					int intCipDuration = DataHoraRN.getQuantidadeMinutosNoPeriodo(ciplog.getDthrIcip(), dtHrAtual);
					String cipDuration = new String();

					if (intCipDuration >= 60) {
						intCipDuration /= 60;
						cipDuration = intCipDuration + "h";
					} else {
						cipDuration = intCipDuration + "m";
					}

					retorno.setCipDthrIni(cipDthrIni);
					retorno.setCipDuration(cipDuration);
					retorno.setCIP(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
				retorno.setCIP(false);
			}

			break;
		case ServicoFactory._CIP_DTHR_PROD_REF:

			try {
				filtroOP = 0;
				tpId = DwConsolidTemplate.TpId.TURNO;
				ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(),
						rn, tpId, isTurnoAtual, filtroOP);
				if (retorno.isCIP() == true) {
					ciprn = new CIPRN(daoPdba);
					DwConsolciplog ciplog = ciprn.getUltimoCIPByOmPt(ompt);
					if (ciplog != null && ciplog.getDthrFcip() == null && ciplog.getDthrIcip() != null) {
						String cipDthrIni = new String();
						cipDthrIni = DataHoraRN.dateToStringDDMMYYYYHHMMSS(ciplog.getDthrIcip());
						retorno.setCipDthrIni(cipDthrIni);

						ProducaoDTO prodDTO = getProducaoDaOPDuranteCIP(ompt, ompt.getPpCp());

						if (prodDTO != null) {
							retorno.setProducaoLiquida(prodDTO.getProducaoLiquida());
							retorno.setProducaoRefugada(prodDTO.getProducaoRefugada());
						}

					} else {
						retorno.setCIP(false);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				retorno.setCIP(false);
			}

			break;

		case ServicoFactory._OEE_TURNO:
			filtroOP = 0;
			tpId = DwConsolidTemplate.TpId.TURNO;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			break;

		case ServicoFactory._OEE_ULTIMA_HR:
			filtroOP = 2;
			tpId = DwConsolidTemplate.TpId.HORA;
			ObjetoNaTelaFactory.getInstancia(omobj).criar(retorno, omobj, omcfg, evento.getLog(), dtreferencia, turnoAtual.getDwturno(), rn,
					tpId, isTurnoAtual, filtroOP);

			break;

		case ServicoFactory._PERFIL_ANDON:
			// 2019-08-05: Ailton
			// se cdConsulta for "25", trata-se de uma consulta ao perfil do Andon
			IcRN icRn = new IcRN();
			try {
				icRn.iniciaConexaoBanco(null);
				MsPerfilandon msPerfilandon = icRn.getListaAndonSADTOByCdIc(evento.getIcUpDTO().getIc().getCd_ic());
				retorno.setMsPerfilAndon(msPerfilandon);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				icRn.finalizaConexaoBanco();
			}

			break;

		default:
			retorno = null;
			break;
		}

		return retorno;
	}

	public PpCp obtemPpCpAnteriorAoAtualDoPT(OmPt ompt) {
		PpCp retorno = new PpCp();

		MapQuery q = new MapQuery(daoPdba.getSession());
		q.append("select ppcp");
		q.append("from DwRt dwrt ");
		q.append("join dwrt.ppCp ppcp");
		q.append("where dwrt.omPt.cdPt = :cdPt");
		q.append("AND ((dwrt.isSemplanejamento=:issemplanejamento AND ppcp.idCp=:idCp) OR (ppcp.idCp <> :idCp))");
		q.append("order by dwrt.dthrHeartbeat desc, dwrt.dthrEvento desc");

		q.defineParametro("cdPt", ompt.getCdPt());
		q.defineParametro("idCp", ompt.getPpCp().getIdCp());
		q.defineParametro("issemplanejamento", true);

		q.setMaxResults(1);

		try {
			retorno = (PpCp) q.uniqueResult();
		} catch (Exception e) {
			retorno = null;
		}

		return retorno;
	}

	public void registrarMontagem(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde)
			throws ServicoFalhouException, SemSGBDException, ParseException {
		registrarMontagem(cdPt, cdOp, cb, dthr, lista, qtde, true, null);
	}

	public void registrarMontagem(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde, boolean isCbConforme,
			String cdDefeito) throws ServicoFalhouException, SemSGBDException, ParseException {

		EventoColetado ev = new EventoColetado();
		IdwLogger log = new IdwLogger("registrarMontagem");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		IcUpDTO icup = Stubedelegate.getInstancia().getMsthread().getIcUp(cdPt);
		if (icup != null) {
			ev.setCb(cb);
			ev.setCdop(cdOp);
			ev.setUp(cdPt);
			ev.setQtde(qtde);
			ev.setIcUpDTO(icup);
			ev.setIsCbConforme(true);
			ev.setDthrEvento(dthr);
			ev.setLog(log);
			ev.setMontagem(lista.getListaMontagem());
			ev.setIsCbConforme(isCbConforme);

			registrarPassagem(idLog, identacao, ev);
		}
	}

	/*
	 * Metodo que registra dados do posto de embalagem
	 * 
	 */
	public void registrarMontagemAntecipada(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde,
			Boolean isFechouAntecipadamente, String reSupervisor, String cbSerial) throws ServicoFalhouException, SemSGBDException {

		EventoColetado ev = new EventoColetado();
		IdwLogger log = new IdwLogger("registrarMontagem");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		boolean isCbConforme = true;

		StringBuilder men = new StringBuilder();
		men.append("registrarMontagemAntecipada para pt=");
		men.append(cdPt);
		men.append(" para op=");
		men.append(cdOp);
		men.append(" para cb=");
		men.append(cb);
		log.info(idLog, 0, men.toString());

		IcUpDTO icup = Stubedelegate.getInstancia().getMsthread().getIcUp(cdPt);
		if (icup != null) {
			ev.setCb(cb);
			ev.setCdop(cdOp);
			ev.setUp(cdPt);
			ev.setQtde(qtde);
			ev.setIcUpDTO(icup);

			ev.setDthrEvento(dthr);
			ev.setLog(log);
			ev.setMontagem(lista.getListaMontagem());
			ev.setIsCbConforme(isCbConforme);
			ev.setCbserial(cbSerial);

			ev.setIsMontagemFechadaAntecipadamente(isFechouAntecipadamente);
			ev.setLogin(reSupervisor);

			registrarPassagem(idLog, identacao, ev);
		} else
			log.info(idLog, 0, "Nao encontrou icupdto para cdpt" + cdPt);

		log.info(idLog, 0, "Fim registrarMontagem");

		// Monta o paete temporario. Assim, se o IHM reiniciar ele pode obter o q ja estava sendo montado
		MontagemDTO dto = new MontagemDTO();
		dto.setCb(cb);

		// Alessandre em 17-02-21 comentei pq queria salvar a montagem no banco ao inves de local no hd mas decidir continuar com a montagem
		// local
		// registrarMontagemCorrente(cdPt, cdOp, dto);

	}

	/*
	 * Registra o pallete que estsa sendo preenchido. Qdo finliazar o preenchimento os dados sao apagados ou quando a embalagem entrar esse
	 * registro eh carregado para a OP escolhida
	 */
	public void registrarMontagemCorrente(String cdpt, String cdop, MontagemDTO montagem) {
		/*
		 * Pesquisa MsUpOp do posto e op. Se nao houver, incluir
		 * 
		 */
		MapQuery q = new MapQuery(getDaoPdba().getSession());

		q.append("select a");
		q.append("from MsUpOp a");
		q.append("where a.cdUp = :cdup");
		q.append("and a.nrop = :cdop");
		q.defineParametro("cdup", cdpt);
		q.defineParametro("cdop", cdop);

		q.setMaxResults(1);
		MsUpOp msupop = (MsUpOp) q.uniqueResult();
		if (msupop == null) {
			msupop = new MsUpOp();
			msupop.setCdUp(cdpt);
			msupop.setDthrCadastro(DataHoraRN.getDataHoraAtual());
			msupop.setIdUpOp(null);
			msupop.setNrop(cdop);

			getDaoPdba().makePersistent(msupop);
		}
		MsUpopLeituras leitura = new MsUpopLeituras();
		leitura.setCbprincipal(montagem.getCb());
		leitura.setIdUpopLeituras(null);
		leitura.setMsUpOp(msupop);
		leitura.setDthrLeitura(DataHoraRN.getDataHoraAtual());
		leitura.setCb1(montagem.getSerial());
		getDaoPdba().makePersistent(leitura);
	}

	private DwTDefeito createDwTDefeito(String cdDefeito, String dsDefeito, OmPt omPt, OmCfg omcfg) {
		DwTDefeito dwtdefeito;
		dwtdefeito = new DwTDefeito();
		dwtdefeito.setCdTdefeito(cdDefeito);
		dwtdefeito.setDsTdefeito(dsDefeito);
		dwtdefeito.setDtRevisao(DataHoraRN.getDataHoraAtual());
		dwtdefeito.setDtStativo(dwtdefeito.getDtRevisao());
		dwtdefeito.setIsRequeracao(false);
		dwtdefeito.setOmTppt(omPt.getOmTppt());
		dwtdefeito.setRevisao(1l);
		dwtdefeito.setStAtivo((byte) 1);
		dwtdefeito.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
		dwtdefeito.setOmUsrByIdUsrstativo(dwtdefeito.getOmUsrByIdUsrrevisao());
		return dwtdefeito;
	}

	private DwTArea createDwTArea(String cdarea, String dsarea, OmCfg omcfg) {
		DwTArea dwt;
		dwt = new DwTArea();
		dwt.setCdArea(cdarea);
		dwt.setDsArea(dsarea);
		dwt.setDtRevisao(DataHoraRN.getDataHoraAtual());
		dwt.setDtStativo(dwt.getDtRevisao());
		dwt.setRevisao(1l);
		dwt.setStAtivo((byte) 1);
		dwt.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
		dwt.setOmUsrByIdUsrstativo(dwt.getOmUsrByIdUsrrevisao());
		return dwt;
	}

	public void cadastrarDefeito(String cdPt, String cdDefeito, String dsDefeito) {

		VerificaDefeitoRN drn = new VerificaDefeitoRN();
		drn.setDao(daoPdba);

		OmPt ompt = new OmPt();
		PTRN ptrn = new PTRN(daoPdba);
		try {
			ompt = ptrn.getOmPt(cdPt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		OmCfg omcfg = new OmCfg(); // TODO: obter de Omcfg
		OmUsr omu = new OmUsr();
		omu.setId(1L);
		omcfg.setOmUsrimpprog(omu);

		DwTDefeito dwtdefeito = drn.getTDefeito(ompt.getOmTppt(), cdDefeito);
		if (dwtdefeito == null) {
			dwtdefeito = createDwTDefeito(cdDefeito, dsDefeito, ompt, omcfg);
			daoPdba.makePersistent(dwtdefeito);
		}

	}

	public void cadastrarArea(String cdArea, String ds) {

		AreaRN rn = new AreaRN();
		rn.setDao(daoPdba);

		OmCfg omcfg = new OmCfg(); // TODO: obter de Omcfg
		OmUsr omu = new OmUsr();
		omu.setId(1L);
		omcfg.setOmUsrimpprog(omu);

		DwTArea dw = rn.getTArea(cdArea);
		if (dw == null) {
			dw = createDwTArea(cdArea, ds, omcfg);
			daoPdba.makePersistent(dw);
		}

	}

	public void regristrarTesteDefeitoAgramkow(String cdPt, String cdOp, String cb, Date dthr, String qtde)
			throws ServicoFalhouException, SemSGBDException, ParseException {

		Calendar calPesquisar = new GregorianCalendar();
		calPesquisar.setTime(dthr);
		calPesquisar.add(Calendar.DAY_OF_MONTH, AgramkowSqlRN.NUM_DIAS_A_PARTIR_DATA_ATUAL);

		Calendar calDtHrTeste = new GregorianCalendar();
		Date dthrTeste = new Date();
		calDtHrTeste.setTime(dthr);
		dthrTeste = calDtHrTeste.getTime();

		// Obtém lista de Eventos de Testes com Defeitos a partir da base de dados A'Gramkow

		Long seqno = 1L;
		// Line line = new Line();
		String seqnoString = "";
		Long seqnoLong = 0L;
		List<Object> listaseqno;
		listaseqno = new ArrayList<Object>();
		List<ResultsHeader> lista;
		List<ResultsHeader> listaTratar = new ArrayList<ResultsHeader>();
		List<ResultsHeader> listaOriginal = new ArrayList<ResultsHeader>();

		String cdArea = "";
		String dsArea = "";
		String cdDef = "";
		String dsDef = "";
		String dsPosMec = "";
		// String cdOrigem = "";

		PTRN ptrn = new PTRN(getDaoPdba());
		OmPt omptTeste = new OmPt();
		String cdPtTeste = "";
		boolean isEncontrouPtTeste = false;

		DAOGenericoAgramkow daoagramkow = new DAOGenericoAgramkow();
		AgramkowSqlRN agramkowsqlrn = new AgramkowSqlRN(daoagramkow);
		try {
			agramkowsqlrn.iniciaConexaoBanco();

			lista = agramkowsqlrn.getResultsHeaderList(calPesquisar.getTime(), cb);
			if (lista != null && lista.size() > 0) {
				listaOriginal.addAll(lista);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				agramkowsqlrn.finalizaConexaoBanco();
			} catch (Exception e2) {
				e2.printStackTrace();
				agramkowsqlrn.finalizaConexaoBanco();
			}
		}
		agramkowsqlrn.finalizaConexaoBanco();
		agramkowsqlrn = null;
		daoagramkow = null;

		// Neste ponto há lista de eventos de defeitos A'Gramkow.

		// Fim consulta A'Gramkow

		// Prepara lista de SeqNO a confrontar com a base IDW (os já consolidados no IDW)
		if (listaOriginal != null && listaOriginal.size() > 0) {
			for (ResultsHeader i : listaOriginal) {
				if (i != null && i.getId() != null && i.getId().getSeqno() != null && i.getId().getServer() != null)
					seqnoString = (i.getId().getServer().toString()) + (i.getId().getSeqno().toString());
				seqnoLong = Long.valueOf(seqnoString);

				listaseqno.add(seqnoLong);
			}
		}

		// Confronta SeqNOs com IDW e prepara lista a TRATAR ( a efetivamente registrar defeitos )
		List<DwPassagem> passagensinlist = new ArrayList<DwPassagem>();
		if (listaseqno != null && listaseqno.size() > 0) {
			passagensinlist = getDwPassagensInList(cb, listaseqno);
		}
		if (listaOriginal != null && listaOriginal.size() > 0) {
			if (passagensinlist != null && passagensinlist.size() > 0) {
				for (ResultsHeader i : listaOriginal) {
					if (i != null && i.getId() != null && i.getId().getSeqno() != null && i.getId().getServer() != null)
						seqnoString = (i.getId().getServer().toString()) + (i.getId().getSeqno().toString());
					seqnoLong = Long.valueOf(seqnoString);

					boolean isJaApontado = false;
					for (DwPassagem p : passagensinlist) {
						if (p != null && p.getSequencial() != null) {
							if (p.getSequencial().equals(seqnoLong)) {
								isJaApontado = true;
								break;
							}
						}
					}
					if (!isJaApontado) {
						listaTratar.add(i);
					}
				}

			} else {// tratar todos mesmo, pois nao encontrado nenhum ja processado idw
				listaTratar.addAll(listaOriginal);
			}

		}

		// Efetivamente registrar defeitos (iteração para cada evento de defeito a registrar no IDW)
		for (ResultsHeader i : listaTratar) {

			if (i != null && i.getId() != null && i.getId().getSeqno() != null && i.getId().getServer() != null)
				seqnoString = (i.getId().getServer().toString()) + (i.getId().getSeqno().toString());
			seqnoLong = Long.valueOf(seqnoString);

			seqno = seqnoLong;

			cdArea = "";
			dsArea = "";
			cdDef = "";
			dsDef = "";
			dsPosMec = "";
			cdPtTeste = "";

			// Cadastro AREA
			// cadastra area se já não existir
			if (i.getAreas() != null && i.getAreas().getId() != null && i.getAreas().getName() != null
					&& i.getAreas().getId().getServer() != null) {
				// cdArea = i.getAreas().getId().getServer().toString() + i.getAreas().getId().getAreaId().toString();
				cdArea = i.getAreas().getId().getServer().toString() + "-" + i.getAreas().getId().getAreaId().toString();
				dsArea = i.getAreas().getName();

				this.cadastrarArea(cdArea, dsArea);
			}

			// omPtTESTE:
			// Aqui tenta localizar no IDW um pt cadastrado equivalente ao Posto do Teste Agramkow (do evento de defeito)
			// Caso não localize no IDW, aqui será feito registro do evento de defeito para o cdPt do posto Verificacao mesmo.
			// Importante 1! cadastrar no IDW os Pts equivalentes ao Testes A'Gramkow na forma: Units.ID.server+'-'+Units.ID.idUnit.
			// Exemplo de cdPt esperado , conforme padrões Agramkow adaptados para IDW: "0-12" (Units: server=0, id=12).
			// A descrição deveria usar o Units.Descriptor (recomendável).
			// Importante 2! caso não seja encontrado cdPtTeste equivalente IDW, o cdDef a seguir terá uma outra forma mais complexa de
			// composição! Isso porque ele fará referência ao Device e Unit também.
			isEncontrouPtTeste = false;
			cdPtTeste = cdPt;
			omptTeste = null;
			omptTeste = new OmPt();
			if (i.getUnits() != null && i.getUnits().getId() != null && i.getUnits().getId().getServer() != null
					&& i.getUnits().getId().getUnitId() != null && !i.getUnits().getId().getUnitId().equals("")) {
				omptTeste = ptrn.pesquisarPtByCdPtStAtivo(
						i.getUnits().getId().getServer().toString() + "-" + i.getUnits().getId().getUnitId().toString());
			}

			if (omptTeste != null && omptTeste.getCdPt() != null && !omptTeste.getCdPt().equals("")) {
				isEncontrouPtTeste = true;
				cdPtTeste = omptTeste.getCdPt();
			}
			omptTeste = null;

			// Cadastro DEFEITO
			// cadastra defeito se já não existir
			if (i.getFailcodes() != null && i.getFailcodes().getId() != null) {

				if (isEncontrouPtTeste) {

					cdDef = i.getFailcodes().getId().getServer().toString() + "-" + i.getFailcodes().getId().getDeviceId().toString() + "-"
							+ i.getFailcodes().getId().getId().toString();
					if (i.getFailcodes().getFailcodeLanguageses() != null && i.getFailcodes().getFailcodeLanguageses().size() > 0) {
						for (FailcodeLanguages ling : i.getFailcodes().getFailcodeLanguageses()) {
							if (ling != null && ling.getDescriptor() != null) {
								dsDef = ling.getDescriptor();
								break;
							}
						}
					}
					if (dsDef == null || dsDef.equals("")) {
						if (i.getFailcodes().getDescriptor() != null) {
							dsDef = i.getFailcodes().getDescriptor();
						}
					}
					if (i.getDevices() != null && i.getDevices().getDescriptor() != null) {
						dsDef = dsDef + " [" + i.getDevices().getDescriptor() + "]";
					}
					if (dsDef != null && dsDef.length() > 100) {
						dsDef = dsDef.substring(0, 100);
					}

				} else { // if !isEncontrouPtTeste:

					cdDef = i.getFailcodes().getId().getServer().toString() + "-" + i.getFailcodes().getId().getDeviceId().toString() + "-"
							+ i.getFailcodes().getId().getId().toString() + "-" + i.getUnits().getId().getUnitId().toString();
					if (i.getFailcodes().getFailcodeLanguageses() != null && i.getFailcodes().getFailcodeLanguageses().size() > 0) {
						for (FailcodeLanguages ling : i.getFailcodes().getFailcodeLanguageses()) {
							if (ling != null && ling.getDescriptor() != null) {
								dsDef = ling.getDescriptor();
								break;
							}
						}
					}
					if (dsDef == null || dsDef.equals("")) {
						if (i.getFailcodes().getDescriptor() != null) {
							dsDef = i.getFailcodes().getDescriptor();
						}
					}
					if (i.getUnits() != null && i.getUnits().getDescriptor() != null) {
						dsDef = dsDef + " - " + i.getUnits().getDescriptor().toString();
					}
					if (i.getDevices() != null && i.getDevices().getDescriptor() != null) {
						dsDef = dsDef + "[" + i.getDevices().getDescriptor() + "]";
					}
					if (dsDef != null && dsDef.length() > 100) {
						dsDef = dsDef.substring(0, 100);
					}

				}

				this.cadastrarDefeito(cdPtTeste, cdDef, dsDef);
			}

			// na data que realmente ocorreu o evento de defeito no A'Gramkow
			calDtHrTeste.setTime(dthr);
			if (i.getDateTested() != null) {
				calDtHrTeste.setTime(i.getDateTested());
			}
			dthrTeste = calDtHrTeste.getTime();

			dsPosMec = "";
			if (i.getLimitsDescriptor() != null) {
				dsPosMec = i.getLimitsDescriptor();
			}

			this.regristrarTesteDefeito(cdPtTeste, cdOp, cb, dthrTeste, cdDef, "1", cdArea, dsPosMec, seqno);

		}

	}

	public List<DwPassagem> getDwPassagensInList(String bc, List<Object> lista) {
		MapQuery q = new MapQuery(this.daoPdba.getSession());

		List<DwPassagem> list = new ArrayList<DwPassagem>();

		q.append("select p  ");
		q.append("from DwPassagem p ");
		q.append("join p.dwNserie n ");
		q.append("where  ");
		q.append("n.cb = :bc ");
		q.append("and p.sequencial is not null ");
		q.append("and p.sequencial in :lista ");
		q.defineParametro("bc", bc);
		q.defineListaParametro("lista", lista);

		list = q.list();
		return list;
	}

	public ListaUPDTO salvarUpDTOSemMsUsr() {
		MsUp msupAtual = null;
		MsUp msupNova = new MsUp();
		MsUsr msusrLogado = null;

		UpDTO updto = new UpDTO();
		ArrayList<UpDTO> lista = new ArrayList<UpDTO>();
		ListaUPDTO retorno = new ListaUPDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

		Date data = new Date();

		if (this.getCd_up() == null || this.getCd_up().equals("")) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDUP_DESCONHECIDO);
			retorno.setResultadoDTO(resultadoDTO);
			return retorno;
		}

		// Pesquisar OmPt
		PTRN rn = new PTRN(getDaoPdba());
		
		// Usar essa linha para forçar um erro NÃO TRATADO
		// PTRN rn = new PTRN();
		
		OmPt ompt = rn.pesquisarPtByCdPtStAtivo(this.getCd_up());
		Long idtppt = 0l;
		
		// Usar essa linha para forçar um erro TRATADO
		// ompt = null;
		
		if (ompt == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDIC_DESCONHECIDO);
			retorno.setResultadoDTO(resultadoDTO);
			return retorno;
		}

		if (ompt != null && ompt.getOmTppt() != null)
			idtppt = ompt.getOmTppt().getIdTppt();

		// Obtem usuario logado

		/*
		 * msusrLogado = pesquisarMsUsr();
		 * 
		 * 
		 * if (msusrLogado == null) { resultadoDTO.setIdMensagem(resultadoDTO.ERRO_USUARIO_DESCONHECIDO);
		 * retorno.setResultadoDTO(resultadoDTO); return retorno; }
		 */

		/*
		 * Se o id da Up tiver sido enviado entao eh uma alteracao
		 *
		 */
		boolean isAlteracao = getIdUp() != null && getIdUp().equals(BigDecimal.ZERO) == false;

		try {
			// Alessandre> em 29-08-13 mudei o metodo de pesquisa pois estava
			// duplicando msup, visto que o metodo anterior buscava msmmsicup e
			// nao precisava
			if (isAlteracao)
				msupAtual = pesquisarMsUpPorIdUp(getIdUp());
			else {
				msupAtual = pesquisarMsUpPorCdUpStAtivo(this.getCd_up());
				if (msupAtual != null) {
					resultadoDTO.setIdMensagem(resultadoDTO.ERRO_IC_JA_CADASTRADO);
					retorno.setResultadoDTO(resultadoDTO);
					return retorno;
				}
			}
		} catch (RegistroDesconhecidoException e) {
			msupAtual = null;
		}

		msupNova.setCdUp(this.getCd_up());
		msupNova.setCdBc(this.getCdBc());
		msupNova.setMsUsr(msusrLogado);

		// Salva dados sobre licenciamento
		if (msupAtual != null) {
			msupNova.setIsLicenciada(msupAtual.getIsLicenciada());
			msupNova.setIduppdba(msupAtual.getIduppdba());
			msupNova.setMsEvtByIdEvtiniciociclo(msupAtual.getMsEvtByIdEvtiniciociclo());
			msupNova.setMsEvtByIdEvtinicioparada(msupAtual.getMsEvtByIdEvtinicioparada());
			msupNova.setNrop(msupAtual.getNrop());
		}

		if (this.getDs_up() != null) {
			msupNova.setDsUp(this.getDs_up());
		}
		if (this.getUpihmColetados() != null) {
			msupNova.setMsUpihms(new HashSet<MsUpihm>());

			for (UpIhmDTO upihmDTO : this.getUpihmColetados()) {
				MsUpihm msupihm;
				msupihm = null;
				msupihm = new MsUpihm();

				msupihm.setMsIhm(consultarMsIhmPorIdIhm(upihmDTO.getIhm()));
				msupihm.setMsUp(msupNova);

				if (upihmDTO.getDthrCadastro() != null) {
					msupihm.setDthrCadastro(upihmDTO.getDthrCadastro());
				} else {
					msupihm.setDthrCadastro(data);
				}
				msupNova.getMsUpihms().add(msupihm);
			}
		}

		daoPdba.iniciaTransacao();
		daoPdba.inclusaoDescartandoOriginal(msupAtual, msupNova);

		// Altera o novo idUp em ms_msicup
		// Alessandre> em 29-08-13 alterando o idUp antigo para o idUp novo em
		// msicup
		if (msupAtual != null) {
			for (MsMsicup msmsicup : msupAtual.getMsMsicups()) {
				msmsicup.setMsUp(msupNova);
				daoPdba.makePersistent(msmsicup);
			}
		}
		daoPdba.finalizaTransacao();

		// Prepara retorno
		updto.setIdUp(msupNova.getIdUp());
		updto.setCd_up(msupNova.getCdUp());
		updto.setIdTppt(idtppt);
		updto.setDs_up(msupNova.getDsUp());
		updto.setIdUpPDBA(msupNova.getIduppdba());
		updto.setRevisao(msupNova.getRevisao());
		updto.setDthrRevisao(msupNova.getDthrRevisao());
		updto.setDthrStativo(msupNova.getDthrStativo());
		updto.setStAtivo(msupNova.getStAtivo());
		updto.setCdBc(msupNova.getCdBc());

		updto.setUpihmColetados(new ArrayList<UpIhmDTO>());

		for (MsUpihm msupihm : msupNova.getMsUpihms()) {
			UpIhmDTO upihmdto = new UpIhmDTO(msupihm);

			updto.getUpihmColetados().add(upihmdto);
		}

		resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);

		lista.add(updto);
		retorno.setListaUPDTO(lista);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}

	public MsUp pesquisaUmMsUpPorCdUp(String cdUp)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(daoPdba.getSession());

		q.append("from MsUp msup ");
		q.append("where msup.cdUp = :cdup ");
		q.append("order by msup.idUp desc");

		q.defineParametro("cdup", cdUp);
		q.setMaxResults(1);

		MsUp msup = null;

		msup = (MsUp) q.uniqueResult();

		if (msup == null)
			throw new RegistroDesconhecidoException();

		return msup;
	}

	
	
	@SuppressWarnings("unused")
	public ListaUPsDTO getUPsDTO(FiltroPesquisaDTO filtro, DAOGenerico dao) {
		ListaUPsDTO retorno = new ListaUPsDTO();
		retorno.setItems(new ArrayList<UpDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select DISTINCT t ");
		q.append("from MsUp t ");
		//q.append("left join fetch t.msUpihms ihm ");
		q.append("where t.stAtivo = 1 ");

		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")) {
			q.append("AND (");
			q.append(" upper(t.cdUp) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsUp) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase()+ "%'");
			q.append(")");
		}

		q.append(" AND t.cdUp IN (SELECT sqt.cdPt FROM OmPt sqt WHERE sqt.stAtivo = 1 AND sqt.omTppt.cdTppt = 'CIC' AND sqt.tpSessao IN (0, 1, 2))");
		
		q.append("ORDER BY t.cdUp");

		List<MsUp> lista = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		for (MsUp reg : lista) {
			
			UpDTO2 dto = new UpDTO2();
			dto.setIdUP(reg.getIdUp().intValue());
			dto.setCdUP(reg.getCdUp());
			dto.setDsUP(reg.getDsUp());
			dto.setCdUsrRev(reg.getMsUsr().getCdUsr());
			dto.setIhms(new ArrayList<IhmUpDTO2>());
			dto.setStRegistro(reg.getStAtivo().intValue());
			
			for (MsUpihm up : reg.getMsUpihms()) {
				if (up.getMsIhm() != null) {
					IhmUpDTO2 ihm = new IhmUpDTO2();
					ihm.setCdIHM(up.getMsIhm().getCdIhm());
					ihm.setUrlConexao(up.getMsIhm().getUrlConexao());

					dto.getIhms().add(ihm);
				}
			}

			Collections.sort(dto.getIhms(), comparaCodigo);
			retorno.getItems().add(dto);
		}			
		
 		if (lista.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(dao);
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, lista.size()));
 			resRN = null;
 		}
		
 		 q = null;
		lista = null;

		return retorno;
	}

	public UpDTO2 getUPByCd(String cdUP, DAOGenerico dao) {
		UpDTO2 retorno = new UpDTO2();
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select DISTINCT t ");
		q.append("from MsUp t ");
		//q.append("left join fetch t.msUpihms ihm ");
		q.append("where t.cdUp = :cdUp");
		q.append(" and t.stAtivo = 1 ");
		
 		q.defineParametro("cdUp", cdUP);
 		
 		List<MsUp> lista =  q.list();
 		if (lista.size() > 0) {
 			retorno = new UpDTO2();
 			retorno.setIdUP(lista.get(0).getIdUp().intValue());
 			retorno.setCdUP(lista.get(0).getCdUp());
 			retorno.setDsUP(lista.get(0).getDsUp());
 			retorno.setCdUsrRev(lista.get(0).getMsUsr().getCdUsr());
 			retorno.setIhms(new ArrayList<IhmUpDTO2>());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 			for(MsUpihm up : lista.get(0).getMsUpihms()) {
 				if (up.getMsIhm() != null) {
 					IhmUpDTO2 ihm = new IhmUpDTO2();
 					ihm.setCdIHM(up.getMsIhm().getCdIhm());
 					ihm.setUrlConexao(up.getMsIhm().getUrlConexao());
 					
 					retorno.getIhms().add(ihm);
 				}
 			}
 		}
 		
 		Collections.sort(retorno.getIhms(), comparaCodigo);
		
		return retorno;
	}

	
	public MsUp getUPByCdPt(String cdPt) {
		MsUp retorno = null;
		
		daoPdba.iniciaSessao(); 
		 
		// espera-se que exista uma up com código igual ao pt 
		MapQuery q = new MapQuery(daoPdba.getSession());
		q.append("select t ");
		q.append("from MsUp t "); 
		q.append("where t.cdUp = :cdUp");
		q.append(" and t.stAtivo = 1 ");
		
 		q.defineParametro("cdUp", cdPt);
 		
 		List<MsUp> lista =  q.list();
 		if (lista.size() > 0) {
 			retorno = lista.get(0);
 		}
 		
 		daoPdba.finalizaSessao();
		
		return retorno;
	}
	
	
	//comparators 
	private static final Comparator<IhmUpDTO2> comparaCodigo = new Comparator<IhmUpDTO2>() {
		@Override
		public int compare(IhmUpDTO2 o1, IhmUpDTO2 o2) {
			return o1.getCdIHM().compareTo(o2.getCdIHM());
		}
	};
	

	public ListaUPDTO removeUpDTOSemTransacao() {
		ListaUPDTO listaUpDTO = null;
		usarTransacao = false;
		listaUpDTO = removeRegistro();
		usarTransacao = true;
		return listaUpDTO;
	}
	
	// Ricardo: 05/03/2023
	public IcUpDTO pesquisarIcUpDtoPorIdUp(BigDecimal idup) throws RegistroDesconhecidoException {
		IcUpDTO retorno = null;
		MapQuery q = new MapQuery(daoPdba.getSession());
		
		q.append("select msmsicup ");
		q.append("from MsMsicup msmsicup ");
		q.append("join fetch msmsicup.msUp msup");
		q.append("join fetch msmsicup.msIc msic");
		q.append("join fetch msmsicup.msMs msms");
		q.append("where msup.idUp = :idup ");
		q.append("and msup.stAtivo = 1");
		q.append("and msic.stAtivo = 1");
		q.append("and msms.stAtivo = 1");

		q.defineParametro("idup", idup);
		q.setMaxResults(1);

		MsMsicup msmsicup = (MsMsicup) q.uniqueResult();

		if (msmsicup == null) {
			throw new RegistroDesconhecidoException();
		}
		PTRN rn = new PTRN(getDaoPdba());
		OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msmsicup.getMsUp().getCdUp());
		retorno = new IcUpDTO(msmsicup, ompt);
		
		retorno.getIc().setCdPerfilAndon(msmsicup.getMsIc().getMsPerfilandon().getCdPerfilandon());
		
		return retorno;
	}
	
}
