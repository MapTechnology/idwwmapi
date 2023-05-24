package ms.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolvaritmolog;
import idw.model.pojos.DwConsolvaritmologcau;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTParada;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsPerfilandon;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.AbstractRN;
import idw.model.rn.AlertaRN;
import idw.model.rn.CIPRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.LoginRN;
import idw.model.rn.PTRN;
import idw.model.rn.ParadaRN;
import idw.model.rn.TurnoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DadosProdutoSADTO;
import idw.webservices.dto.StatusProdutoSADTO;
import idw.webservices.dto.TurnoAtualDTO;
import ms.coleta.dto.AndonSADTO;
import ms.coleta.dto.SessaoAlertaDTO;
import ms.coleta.dto.SessaoAlertasDTO;
import ms.coleta.dto.SessaoAndonDTO;
import ms.coleta.dto.SessaoCalendarioDTO;
import ms.coleta.dto.SessaoCfgDTO;
import ms.coleta.dto.SessaoICDTO;
import ms.coleta.dto.SessaoOPDTO;
import ms.coleta.dto.SessaoParadaDTO;
import ms.coleta.dto.SessaoRefugoDTO;
import ms.coleta.dto.SessaoUPDTO;
import ms.coleta.dto.SessaoUsuarioDTO;
import ms.coleta.dto.SessaoUsuariosDTO;
import ms.coleta.dto.SessaoVarRitmoDTO;
import ms.coleta.dto.TAndonSADTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.UpDTO;

public class SessaoRN extends AbstractRN<DAOGenerico> {

	private IdwLogger log = null;

	public SessaoRN() {
		super(new DAOGenerico());
	}
	
	public SessaoRN(DAOGenerico dao) {
		super(dao);
	}
	
	public void ordenaListaIcUpDTOPorUrlConexao(List<IcUpDTO> icups) {
		Collections.sort(icups, new Comparator<IcUpDTO>() {
	        @Override
	        public int compare(IcUpDTO up2, IcUpDTO up1)
	        {
	            return  up2.getUrlConexao().compareTo(up1.getUrlConexao());
	        }
	    });
	}
	
	public Long getQtdeEventosPendentes(List<IcUpDTO> icups) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select count(*)");
		q.append("from MsEvt a");
		q.append("where a.msMsicup.idMsicup in (:up)");
		q.append("and a.stEvt = 0");
		
		List<Object> listaups = new ArrayList<>();
		String idsups = "";
		for (IcUpDTO updto : icups) {
			listaups.add(new BigDecimal(updto.getIdIcUp()));
			idsups += updto.getIdIcUp().toString() + " - ";
		}
		q.defineListaParametro("up", listaups);
		List<Object> lcount = q.list();
		Long ncount = (Long) lcount.get(0);
		return ncount;
	}
	
	public SessaoICDTO montaSessaoIC(String cdIc, List<IcUpDTO> icups) {
		try {
			
			/*
			 * Verifica se ao menos 1 UP tem eventos pendentes de consolidacao. Se sim retornar null em SessaoICDTO
			 */
			//Alessandre em 17-10-16 comentei a linha pois estava sem uso Long ncount = getQtdeEventosPendentes(icups);
			
			//Ordena UPs por UrlConexao
			ordenaListaIcUpDTOPorUrlConexao(icups);
			
			//Pega a Configuracao Geral, Andon do IC, 
			SessaoICDTO sessaoIC = new SessaoICDTO();
			sessaoIC.setCfgDefault(getSessaoCfgDTO(icups));
			sessaoIC.setAndon(getSessaoAndonDTO(cdIc));
			sessaoIC.setUps(getSessaoUPDTOs(icups));
			

			return sessaoIC;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<SessaoUPDTO> getSessaoUPDTOs(List<IcUpDTO> icups) {
		List<SessaoUPDTO> sessoes = new ArrayList<SessaoUPDTO>();
		//Monta Sessao das UPs
		for(IcUpDTO icup : icups) {
			try{
				sessoes.add(getSessaoUPDTO(icup));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sessoes;
	}
	
	public SessaoAndonDTO getSessaoAndonDTO(String cdIc) {
		SessaoAndonDTO andonDTO = null;
		
		DAOGenerico dao = new DAOGenerico();
		dao.setSession(this.getDaoSession());
		IcRN icrn = new IcRN(dao);
		MsPerfilandon perfilAndon = icrn.getListaAndonSADTOByCdIc(cdIc);
		
		if(perfilAndon != null) {
			andonDTO = new SessaoAndonDTO();
			TAndonSADTO listaAndonDTO = null;
			List<AndonSADTO> listaAndonSADTO = new ArrayList<AndonSADTO>();
			
			long idPerfilAndon = perfilAndon.getIdPerfilandon();
			listaAndonDTO = icrn.getAndonsSA(perfilAndon.getIdPerfilandon());
			if(listaAndonDTO != null)
				listaAndonSADTO.addAll(listaAndonDTO.getListaAndonSA());
			
			andonDTO.setListaAndonSA(listaAndonSADTO);
			andonDTO.setIdAndon(idPerfilAndon);
		}
		
		return andonDTO;
	}
	
	/* Esse metodo inicializara os dados default de codigos para o IC
	 * Ser eleito uma UP como referencia para se pegar os codigos
	 * Preferencialmente todas as ups devem ser do mesmo tipo para evitar que a descricao no coletor apareca diferente
	 */
	private SessaoCfgDTO getSessaoCfgDTO(List<IcUpDTO> icups) {


		String cdup = icups.get(0).getUpDTO().getCd_up();
		
		criaLog("SessaoCfg_"+cdup);

		OmPt ompt = getOmPt(cdup);
		
		ParadaRN prn = new ParadaRN(getDao());
		
		OmCfg omcfg = Util.getConfigGeral(this.getDaoSession());
		SessaoCfgDTO cfg = new SessaoCfgDTO();
		//idcfg
		cfg.setIdCfg(omcfg.getIdCfg());
		if (omcfg.getIsLogonobrigatorio() != null)
			cfg.setLoginObrigatorio(omcfg.getIsLogonobrigatorio());
		else
			cfg.setLoginObrigatorio(false);
		cfg.setMascaraCb(omcfg.getMascaracb());
		cfg.setRequerTecnicoFimCIP(omcfg.getIsRequerTecnicoFimCip());
		cfg.setRequerTecnicoInicioCIP(omcfg.getIsRequerTecnicoInicioCip());
		if(omcfg.getDwTParada() != null) {
			DwTParada dwtparada;
			try {
				dwtparada = prn.getDwTParada(omcfg.getDwTParada().getCdTparada(), ompt.getOmTppt());
			} catch (RegistroDesconhecidoException e) {
				dwtparada = null;
			}
			if (dwtparada != null) {
				cfg.setCdParadaDefault(dwtparada.getCdTparada());
				cfg.setDsParadaDefault(dwtparada.getDsTparada());
			} else {
				cfg.setCdParadaDefault(omcfg.getDwTParada().getCdTparada());
				cfg.setDsParadaDefault(omcfg.getDwTParada().getDsTparada());
			}
		}
		if(omcfg.getDwTParadaByIdTparadacip() != null) {
			DwTParada dwtparada;
			try {
				dwtparada = prn.getDwTParada(omcfg.getDwTParadaByIdTparadacip().getCdTparada(), ompt.getOmTppt());
			} catch (RegistroDesconhecidoException e) {
				dwtparada = null;
			}
			if (dwtparada != null) {
				cfg.setCdParadaCIPDefault(dwtparada.getCdTparada());
				cfg.setDsParadaCIPDefault(dwtparada.getDsTparada());
			} else {
				cfg.setCdParadaCIPDefault(omcfg.getDwTParadaByIdTparadacip().getCdTparada());
				cfg.setDsParadaCIPDefault(omcfg.getDwTParadaByIdTparadacip().getDsTparada());
			}
		}
		if(omcfg.getDwTAlerta() != null) {
			cfg.setCdAlertaCIPDefault(omcfg.getDwTAlerta().getCdTalerta());
		}
		if(omcfg.getDwTRitmo() != null) {
			cfg.setCdRitmoDefault(omcfg.getDwTRitmo().getCdTritmo());
			cfg.setDsRitmoDefault(omcfg.getDwTRitmo().getDsTritmo());
		}
		return cfg;
	}
	
	private void preencheSessaoUPDTO(SessaoUPDTO sessaoUP, OmPt ompt) {
		try {
			sessaoUP.setIdPt(ompt.getIdPt());
			sessaoUP.setRevisaoPt(ompt.getRevisao());
			sessaoUP.setCdPt(ompt.getCdPt());
			sessaoUP.setDsSessao(ompt.getDsSessao());
			
			/* Alessandre em 12-01-17 o cadastro do PT foi modificado para incluir novos tipos de sesao para compatibilizar o idw com o injet
			 * e reaproveitar o conentrador em C# Assim o tipo de sessao 1 (criar op por folha)  do inovaSA passou a ser o 3. O 1 virou recuparar
			 * op pela ferramente e o 2 recuperar op por produto. Para evitar uma manuten��o no firmaeew foi acrescentado o if abaixo
			 * para deixar em 1 qq tipo de sessao diferente de 0. Pelo meno ate o inovaSA implementar esses novos tipos de sessao
			 */
			if(ompt.getTpSessao() != null && ompt.getTpSessao().equals((byte) 0))
				sessaoUP.setTpSessao(ompt.getTpSessao());
			else
				sessaoUP.setTpSessao((byte) 1);
			
			if(ompt.getIsHabilitaCip() != null)
				sessaoUP.setCipHabilitado(ompt.getIsHabilitaCip());
			if(ompt.getIsHabilitaVaritmo() != null)
				sessaoUP.setVarRitmoHabilitado(ompt.getIsHabilitaVaritmo());
			if(ompt.getPercVaritmo() != null)
				sessaoUP.setToleranciaVarRitmo(ompt.getPercVaritmo().floatValue());
			if(ompt.getQtVaritmo() != null)
				sessaoUP.setDebounceVarRitmo(ompt.getQtVaritmo());
			if(ompt.getIsParadaFechaciclo() != null)
				sessaoUP.setParadaFechaCiclo(ompt.getIsParadaFechaciclo());
			
			//idtppt
			if(ompt.getOmTppt() != null)
				sessaoUP.setIdTppt(ompt.getOmTppt().getIdTppt());
			
			//idgt
			if(ompt.getOmGt() != null) {
				sessaoUP.setIdGt(ompt.getOmGt().getIdGt());
				sessaoUP.setDsGt(ompt.getOmGt().getDsCurta());
			}
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado ao pegar SessaoUPDTO para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
	}
	
	public SessaoCalendarioDTO getSessaoCalendarioDTO(OmPt ompt) {
		List<DwCalsem> dwCalsems = getDwCalSems(ompt);
		
		List<Date> proximasViradasTurno = getProximasViradasTurno(ompt, dwCalsems);
		
		DwCal dwcal = getDwCal(ompt);
		SessaoCalendarioDTO calendario = new SessaoCalendarioDTO();
		calendario.setViradasDeTurno(proximasViradasTurno);
		if(dwcal != null)
			calendario.setIdCal(dwcal.getIdCal());
		return calendario;
	}
	
	private OmPt getOmPt(String cdUp) {
		log.iniciaAvaliacao("Gerar Status - UP - getOmPt");
		PTRN ptrn = new PTRN();
		ptrn.setDaoSession(this.getDaoSession());
		OmPt ompt = null;
		try {
			ompt = ptrn.getOmPt(cdUp, true);
		} catch (RegistroDesconhecidoException e1) {
			log.debug("CriarArquivoStatusSessao - ompt nao encontado(CdUp="+cdUp+")");
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - UP - getOmPt
		}			
		return ompt;
	}
	
	public MsMsicup getMsMsIcUp(Integer id) {
		log.iniciaAvaliacao("Gerar Status - UP - getMsMsIcUp");
		MsRN msrn = new MsRN();
		msrn.setSession(this.getDaoSession());
		MsMsicup msicup = null;
		try {
			if(id != null)
				msicup = msrn.pesquisarMsMsIcupById(new BigDecimal(id));
		} finally {
			log.mostrarAvaliacaoCompleta();
		}			
		return msicup;
	}
	
	public MsUp getMsUp(String cdUp) {
		log.iniciaAvaliacao("Gerar Status - UP - getMsUp");
		UpRN uprn = new UpRN();
		uprn.iniciaConexaoBanco(this.getDaoSession());
		MsUp msup = null;
		try {
			msup = uprn.pesquisarMsUpPorCdUpStAtivo(cdUp);
		} catch (injetws.model.excessoes.RegistroDesconhecidoException e) {
			log.debug("CriarArquivoStatusSessao - msup nao encontado(CdUp="+cdUp+")");
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - UP - getOmPt
		}
		return msup;
	}
	
	public List<DwCalsem> getDwCalSems(OmPt ompt) {
		log.iniciaAvaliacao("Gerar Status - UP - getCalendarioSemanalComTurnosIndefinidosParaPt");
		TurnoRN trn = new TurnoRN();
		trn.setDaoSession(this.getDaoSession());
		List<DwCalsem> dwCalsems = null;
		try {
			dwCalsems = trn.getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, DataHoraRN.getDataHoraAtual());
		} catch (SemCalendarioException e1) {
			dwCalsems = null;
		} catch (Exception e) {
			String exceptionErr = "Erro nao esperado ao pegar Calendario Semanal para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - UP - getCalendarioSemanalComTurnosIndefinidosParaPt
		}
		return dwCalsems;
	}
	
	public List<Date> getProximasViradasTurno(OmPt ompt, List<DwCalsem> dwCalsems) {
		log.iniciaAvaliacao("Gerar Status - UP - getTurnoAtualDTOsPeriodo");
		TurnoRN trn = new TurnoRN();
		trn.setDaoSession(this.getDaoSession());
		List<Date> proximasViradasTurno = new ArrayList<>();
		try {
			if (dwCalsems != null) {
				List<TurnoAtualDTO> proximosturnos = trn.getTurnoAtualDTOsPeriodo(dwCalsems, DataHoraRN.getDataHoraAtual(), 
						DataHoraRN.adicionaDiasDaData(DataHoraRN.getDataHoraAtual(), 7), log, 0, 0);
		
				Collections.sort(proximosturnos, new Comparator<TurnoAtualDTO>() {
					@Override
					public int compare(TurnoAtualDTO o1, TurnoAtualDTO o2) {
						return o1.getDtHrFTurno().compareTo(o2.getDtHrFTurno());
					}
				});
				for (TurnoAtualDTO dto : proximosturnos) {
					proximasViradasTurno.add(dto.getDtHrFTurno());
				}
			}
		} catch (Exception e) {
			String exceptionErr = "Erro nao esperado ao pegar Proximas Viradas Turno para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - UP - getTurnoAtualDTOsPeriodo
		}
		return proximasViradasTurno;
	}
	
	public DwCal getDwCal(OmPt ompt) {
		log.iniciaAvaliacao("Gerar Status - UP - getDwCalPtOuDefault");
		TurnoRN trn = new TurnoRN();
		trn.setDaoSession(this.getDaoSession());
		DwCal dwcal = null;
		try {
			dwcal = trn.getDwCalPtOuDefault(ompt, DataHoraRN.getDataHoraAtual());
		} catch (NullPointerException | SemCalendarioException e) {
			dwcal = Util.getConfigGeral(this.getDaoSession()).getDwCal();
		} catch (Exception e) {
			String exceptionErr = "Erro nao esperado em getDwCal para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - UP - getDwCalPtOuDefault
		}
		return dwcal;
	}
	
	public DwFolha getUltimaFolhaOmPt(OmPt ompt) {
		log.iniciaAvaliacao("Gerar Status - UP - getUltimaFolhaOmPt");
		DwFolha ultimaFolha = null;
		EventoRN evrn = new EventoRN();
		evrn.setSession(this.getDaoSession());
		try {
			ultimaFolha = evrn.obtemDwFolhaDaUltimaOPQueSaiuDeMaquina(ompt);
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getUltimaFolhaOmPt->obtemDwFolhaDaUltimaOPQueSaiuDeMaquina para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - UP - obtemDwFolhaDaPenultimaPT
		}
		return ultimaFolha;
	}
	
	public List<DwConsolmolog> getUsuariosLogados(OmPt ompt) {
		LoginRN loginRN = new LoginRN();
		loginRN.setSession(this.getDaoSession());
		List<DwConsolmolog> res = null;
		try{
			res = loginRN.getUsrsLoginPt(ompt.getIdPt());
		} catch (Exception e){
			String exceptionErr = "Erro nao esperado em getUsuariosLogados para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
		return res;
	}
	
	public SessaoUsuariosDTO getSessaoUsuariosDTO(OmPt ompt) {
		List<DwConsolmolog> listaConcolmolog = getUsuariosLogados(ompt);
		SessaoUsuariosDTO usuarios = new SessaoUsuariosDTO();
		try {
			if(listaConcolmolog != null && listaConcolmolog.size() > 0){
				
				List<SessaoUsuarioDTO> listaUsuarios = new ArrayList<SessaoUsuarioDTO>();

				usuarios.setMaiorIdConsolmolog(-1l);
				for(DwConsolmolog item : listaConcolmolog){
					if(item.getOmUsr() != null) {
						SessaoUsuarioDTO sessaoUsuarioDTO = new SessaoUsuarioDTO();
						sessaoUsuarioDTO.setCdUsuario(item.getOmUsr().getCdUsr());
						sessaoUsuarioDTO.setDsNome(item.getOmUsr().getDsNome());
						sessaoUsuarioDTO.setIdGrupoUsuario(item.getOmUsr().getOmUsrgrp().getId());
						sessaoUsuarioDTO.setDthrILogin(item.getDthrIlogin());
						if(item.getIdConsolmolog() > usuarios.getMaiorIdConsolmolog())
							usuarios.setMaiorIdConsolmolog(item.getIdConsolmolog());
						listaUsuarios.add(sessaoUsuarioDTO);
					}
				}
				usuarios.setListaUsuarios(listaUsuarios);
			}
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getSessaoUsuariosDTO para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
		return usuarios;
	}
	
	public List<DwConsolallog> getAlertasEmAberto(OmPt ompt) {
		AlertaRN alertaRN = new AlertaRN();
		alertaRN.setDaoSession(this.getDaoSession());
		List<DwConsolallog> res = null;
		try{
			res = alertaRN.getAlertasDTOAbertosByCdPt(ompt.getCdPt());
		} catch (Exception e){
			String exceptionErr = "Erro nao esperado em getAlertasEmAberto para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
		return res;
	}
	
	public SessaoAlertasDTO getSessaoAlertasDTO(OmPt ompt) {
		SessaoAlertasDTO alertas = new SessaoAlertasDTO();
		List<DwConsolallog> alertasDTO = getAlertasEmAberto(ompt);
		
		try {
			if(alertasDTO != null && alertasDTO.size() > 0){
				List<SessaoAlertaDTO> listaAlertas = new ArrayList<SessaoAlertaDTO>();
				for(DwConsolallog item : alertasDTO){
					SessaoAlertaDTO sessaoAlerta = new SessaoAlertaDTO();
					sessaoAlerta.setCdAlerta(item.getDwTAlerta().getCdTalerta());
					sessaoAlerta.setDsAlerta(item.getDwTAlerta().getDsTalerta());
					sessaoAlerta.setDthrIAlerta(item.getDthrIalerta());
					boolean isTimeout = item.getDwTAlerta().getIsTimeout() == null ? false : item.getDwTAlerta().getIsTimeout();
					sessaoAlerta.setTimeout(isTimeout);
					boolean isAutomatico = item.getDwTAlerta().getIsAutomatico() == null ? false : item.getDwTAlerta().getIsAutomatico();
					sessaoAlerta.setAutomatico(isAutomatico);
					sessaoAlerta.setIdTppt(item.getDwTAlerta().getOmTppt().getIdTppt());
					if(item.getIdConsolallog() > alertas.getMaiorIdConsolallog())
						alertas.setMaiorIdConsolallog(item.getIdConsolallog());
					listaAlertas.add(sessaoAlerta);
				}
				alertas.setListaAlertas(listaAlertas);
			}
		} catch (Exception e){
			String exceptionErr = "Erro nao esperado em getSessaoAlertasDTO para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
		return alertas;
	}
	
	public Long getIdUltimoEvtLancadoOP(IcUpDTO icup, MsUp msup) {
		log.iniciaAvaliacao("Gerar Status - OP - pesquisarMsEvtUltimoEventoLancadoRelativoAOP");
		EventoRN evrn = new EventoRN();
		evrn.setSession(this.getDaoSession());
		MsEvt ultimoEventLancadoOP = evrn.pesquisarUltimoEventoLancadoRelativoAOP(icup, msup);
		log.mostrarAvaliacaoCompleta();//Gerar Status - OP - pesquisarMsEvtUltimoEventoLancadoRelativoAOP
		Long res = -1l;
		if(ultimoEventLancadoOP != null)
			res = ultimoEventLancadoOP.getIdEvt();
		return res;
	}
	
	public static void main(String[] args) {
		SessaoRN rn = new SessaoRN();
		PTRN ptrn = new PTRN();
		rn.criaLog("teste");
		rn.iniciaConexaoBanco();
		ptrn.setDao(rn.getDao());
		OmPt ompt;
		PpCp ppcp;
		OmPtcp omPtcp;
		MsUp msup;
		
		try {
			ompt = ptrn.getOmPt("1014");
		} catch (RegistroDesconhecidoException e) {
			ompt = new OmPt();
		}
		ppcp = ompt.getPpCp();
		
		msup = rn.getMsUp(ompt.getCdPt());
		omPtcp = rn.getOmPtCp(ompt, ppcp);
		
		UpDTO updto = new UpDTO();
		updto.setCd_up(ompt.getCdPt());
		
		IcUpDTO icup = new IcUpDTO();
		icup.setIdIcUp(null);
		icup.setUpDTO(updto);

		SessaoOPDTO dto = rn.getSessaoOPDTO(ompt, ppcp, omPtcp, icup, msup);
	}
	
	private SessaoOPDTO getSessaoOPDTO(OmPt ompt, PpCp ppcp, OmPtcp omPtcp, IcUpDTO icup, MsUp msup) {
		SessaoOPDTO sessaoOPDTO = null;
		if(ompt.getIsSemop() != null && ompt.getIsSemop() != true && ppcp != null && omPtcp != null) {

			try {
				Long idUltimoEvtLancadoOP = getIdUltimoEvtLancadoOP(icup, msup);
				
				double cicloPadrao = 0d;
				int qtPacoteCiclo = 0;
				int qtFatorContagem = 0;
				FolhaRN frn = new FolhaRN();
				frn.setDaoSession(this.getDaoSession());
				
				DwFolha dwfolha = frn.getDwFolhaAtiva(ppcp);
				
				try {
					cicloPadrao = frn.getCicloPadraoFromDwFolhacisOuDwFolha(dwfolha, ppcp.getOmPt()).doubleValue();
				} catch (Exception e) {
				}
				
				try {
					qtPacoteCiclo = frn.getPacoteCicloFromDwFolha(dwfolha, ppcp.getOmPt());
				} catch (Exception e) {
				}
				
				try {
					qtFatorContagem = frn.getFatorContagemFromDwFolha(dwfolha, ppcp.getOmPt()).intValue();
				} catch (Exception e) {
				}
				
				double qtdPcsPorCiclo = 1d;
				try{
					qtdPcsPorCiclo = frn.getPcsPorCicloAtivasFromDwFolha(dwfolha).doubleValue();
				} catch(Exception e) {
				}
				
				double cicloTimeout = 0d;
				if(dwfolha != null && dwfolha.getSegCiclotimeout() != null)
					cicloTimeout = dwfolha.getSegCiclotimeout().doubleValue();
				
				double cicloMinimo = 0d;
				if(dwfolha != null && dwfolha.getSegCiclominimo() != null)
					cicloMinimo = dwfolha.getSegCiclominimo().doubleValue();

				List<DadosProdutoSADTO> listaProdutos = getListaProdutosDTO(ppcp, dwfolha);
				TurnoAtualDTO turnoAtual = getTurnoAtualDTO(ompt);
				Date date = DataHoraRN.getDataHoraInicial(DataHoraRN.getDataHoraAtual());
				List<StatusProdutoSADTO> listaProdutosHoraTurnoStatus = getListaProdutosHoraTurnoStatus(ompt, ppcp, turnoAtual, date);
				List<DadosProdutoSADTO> listaProdutosHoraTurno = getListaProdutosHoraTurno(listaProdutos, listaProdutosHoraTurnoStatus);
				
				long producaoBrutaTotal = 0l;
				long producaoRefugadaTotal = 0l;
				if(listaProdutos != null) {
					for(DadosProdutoSADTO produto : listaProdutos) {
						if(produto != null) {
							if(produto.getPcsProducaobruta() != null) {
								producaoBrutaTotal += produto.getPcsProducaobruta().longValue();
							}
							if(produto.getPcsProducaorefugada() != null){
								producaoRefugadaTotal += produto.getPcsProducaorefugada().longValue();
							}
						}
					}
				}
				
				Integer qtCiclos = 0;
				if(omPtcp != null) {
					if(omPtcp.getQtCiclos() != null)
						qtCiclos += omPtcp.getQtCiclos();
					if(omPtcp.getQtCiclosregulagem() !=  null)
						qtCiclos += omPtcp.getQtCiclosregulagem();
				}
				
				DwConsolciplog ciplog = getUltimoCipLogOPAtual(omPtcp);
				boolean isAlertaCipJaAberto = getAlertaCipOPAtual(ciplog) != null;
				String cipStatus = getCipStatus(ciplog);
				
				
				BigDecimal producaoPlanejada = BigDecimal.ZERO;
				String cdproduto = null;
				for (PpCpproduto p : ppcp.getPpCpprodutos()) {
					if(p.getPcsProducaoplanejada() != null)
						producaoPlanejada.add(p.getPcsProducaoplanejada());
					if (p.getOmProduto() != null && cdproduto == null)
						cdproduto = p.getOmProduto().getCdProduto();
				}
				
				if(cdproduto == null)
					cdproduto = "desconhecido";

				String nrop;
				try{
					nrop = ppcp.getNrop();
				} catch(Exception e) {
					nrop = ppcp.getCdCp().substring(0 , (ppcp.getCdCp().length()-1) );
				}
				String filial;
				try {
					filial = ppcp.getOmGt().getCdGt();
				} catch (Exception e) {
					filial = "";
				}
				
				boolean isFinalSerie = false;
				if(ppcp.getIsFinalserie() != null)
					isFinalSerie = ppcp.getIsFinalserie();
				
				sessaoOPDTO = new SessaoOPDTO();
				sessaoOPDTO.setUltimoIdEvtOP(idUltimoEvtLancadoOP);
				sessaoOPDTO.setDthrIOp(ppcp.getDthrInicio());
				sessaoOPDTO.setCdFolha(dwfolha.getCdFolha());
				sessaoOPDTO.setIdFolha(dwfolha.getIdFolha());
				if(dwfolha.getSegSetup() != null)
					sessaoOPDTO.setTempoSetup(dwfolha.getSegSetup());
				sessaoOPDTO.setCicloPadrao(cicloPadrao);
				sessaoOPDTO.setCicloMinimo(cicloMinimo);
				sessaoOPDTO.setCicloTimeout(cicloTimeout);
				sessaoOPDTO.setQtFatorContagem(qtFatorContagem);
				sessaoOPDTO.setQtPacoteCiclo(qtPacoteCiclo);
				sessaoOPDTO.setQtdPcsPorCiclo(qtdPcsPorCiclo);
				sessaoOPDTO.setQtdeRef(producaoRefugadaTotal);
				sessaoOPDTO.setQtdePro(producaoBrutaTotal);
				sessaoOPDTO.setProducaoPlanejada(producaoPlanejada);
				sessaoOPDTO.setQtdeCiclos(qtCiclos);	
				sessaoOPDTO.setQtdProdutos(listaProdutos.size());
				sessaoOPDTO.setDwConsolciplog(ciplog);
				if(ciplog != null)
					sessaoOPDTO.setDthrICip(ciplog.getDthrIcip());
				sessaoOPDTO.setListaProdutos(listaProdutos);
				sessaoOPDTO.setListaProdutosHoraTurno(listaProdutosHoraTurno);
				sessaoOPDTO.setCipStatus(cipStatus);
				sessaoOPDTO.setNrop(nrop);
				sessaoOPDTO.setFilial(filial);
				sessaoOPDTO.setCdproduto(cdproduto);
				sessaoOPDTO.setFinalSerie(isFinalSerie);
				sessaoOPDTO.setAlertaCipJaAberto(isAlertaCipJaAberto);
				
				
			} catch (Exception e) {
				String exceptionErr = "Erro nao esperado em getSessaoOPDTO para Pt";
				if(ompt!= null) {
					exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
				}
				exceptionErr += "e Cp";
				if(ppcp!= null) {
					exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
				}
				log.debug(exceptionErr);
				e.printStackTrace();
				log.debug(e.getMessage());
			}
		}
		return sessaoOPDTO;
	}
	
	private OmPtcp getOmPtCp(OmPt ompt, PpCp ppcp) {
		log.iniciaAvaliacao("Gerar Status - OP - getOmPtCpByIdPtEIdCp");
		PTRN ptrn = new PTRN();
		ptrn.setDaoSession(this.getDaoSession());
		OmPtcp omPtcp = null;
		try {
			omPtcp = ptrn.getOmPtCpByIdPtEIdCp(ompt.getIdPt(), ppcp.getIdCp());
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getOmPtCp para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			exceptionErr += " e Cp";
			if(ppcp!=null) {
				exceptionErr += "("+ppcp.getIdCp()+")=" + ppcp.getCdCp();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - OP - getOmPtCpByIdPtEIdCp
		}
		return omPtcp;
	}
	
	public DwConsolciplog getUltimoCipLogOPAtual(OmPtcp omptcp) {
		log.iniciaAvaliacao("Gerar Status - OP - getUltimoCIPByOmPt");
		DwConsolciplog ciplog = null;
		try {
			if(omptcp != null && omptcp.getDthrEntrada() != null && omptcp.getOmPt() != null) {
				CIPRN cipRN = new CIPRN();
				cipRN.setDaosession(this.getDaoSession());
				ciplog = cipRN.getUltimoCIPByOmPtEDthr(omptcp.getOmPt(), omptcp.getDthrEntrada());
			}
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getUltimoCipLogOPAtual->getUltimoCIPByOmPtEDthr para Pt";
			if(omptcp.getOmPt()!=null) {
				exceptionErr += "("+omptcp.getOmPt().getIdPt()+")=" + omptcp.getOmPt().getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - OP - getUltimoCIPByOmPt
		}
		return ciplog;
	}
	
	private DwConsolallog getAlertaCipOPAtual(DwConsolciplog ciplog) {
		log.iniciaAvaliacao("Gerar Status - OP - getAlertaCipOPAtual");
		if(ciplog == null || ciplog.getDthrIcip() == null || ciplog.getDthrFcip() != null)
			return null;
		
		OmCfg cfg = Util.getConfigGeral(getDaoSession());
		
		AlertaRN alertaRN = new AlertaRN();
		alertaRN.setDaoSession(this.getDaoSession());
		
		DwConsolallog alertaCip = null; 
		
		try {
			alertaCip = alertaRN.getUltimoAlertaAbertoApos(ciplog.getOmPt().getIdPt(), cfg.getDwTAlerta().getCdTalerta(), ciplog.getDthrIcip());
		} catch(Exception e) {
			e.printStackTrace();
			String exceptionErr = "Erro nao esperado em getAlertaCipOPAtual->getUltimoAlertaAbertoApos para Pt";
			if(ciplog.getOmPt()!=null) {
				exceptionErr += "("+ciplog.getOmPt().getIdPt()+")=" + ciplog.getOmPt().getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
			log.info("Excessao", e);
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - OP - getUltimoCIPByOmPt
		}
		return alertaCip;
	}
	
	private List<DadosProdutoSADTO> getListaProdutosDTO(PpCp ppcp, DwFolha dwfolha) {
		List<DadosProdutoSADTO> listaProdutos = new ArrayList<DadosProdutoSADTO>();
		//cria a lista de produtos
		for(PpCpproduto produtoPojo : ppcp.getPpCpprodutos()) {
			DadosProdutoSADTO produtoDTO = new DadosProdutoSADTO();
			produtoDTO.setCdProduto(produtoPojo.getOmProduto().getCdProduto());
			produtoDTO.setIdProduto(produtoPojo.getOmProduto().getIdProduto());
			
			if(produtoPojo.getPcsProducaobruta() == null)
				produtoPojo.setPcsProducaobruta(BigDecimal.ZERO);
			produtoDTO.setPcsProducaobruta(produtoPojo.getPcsProducaobruta());
			
			if(produtoPojo.getPcsProducaorefugada() == null)
				produtoPojo.setPcsProducaorefugada(BigDecimal.ZERO);
			produtoDTO.setPcsProducaorefugada(produtoPojo.getPcsProducaorefugada());

			if(produtoPojo.getPcsProducaoplanejada() == null)
				produtoPojo.setPcsProducaoplanejada(BigDecimal.ZERO);
			
			produtoDTO.setPcsProducaoplanejada(produtoPojo.getPcsProducaoplanejada());
			produtoDTO.setQtAtiva(BigDecimal.ONE);
			produtoDTO.setQtTotal(BigDecimal.ONE);
			listaProdutos.add(produtoDTO);
		}
		
		//pega a qtd por ciclo dos produtos cadastrados em dwfolhaiac
		if(dwfolha.getDwFolhaiacs() != null) {
			for(DwFolhaiac folhaiac : dwfolha.getDwFolhaiacs()) {
				if(folhaiac.getOmProduto() != null) {
					for(DadosProdutoSADTO produtoDTO : listaProdutos)
					 if(folhaiac.getOmProduto().getIdProduto() == produtoDTO.getIdProduto()) {
						 //IAC nao trabalha com cavidades, replicar valor
						 //IAC nao trabalha com idreduzido, logo nao devemos seta-lo
						 produtoDTO.setQtAtiva(folhaiac.getQtAtiva());
						 produtoDTO.setQtTotal(folhaiac.getQtAtiva());
					 }
				}
			}
		}
		
		//pega a qtd por ciclo dos produtos cadastrados em dwfolharapcom
		if(dwfolha.getDwFolharaps() != null) {
			for(DwFolharap folharap : dwfolha.getDwFolharaps()) {
				for(DwFolharapcom folharapcom : folharap.getDwFolharapcoms()) {
					if(folharapcom.getOmProduto() != null) {
						for(DadosProdutoSADTO produtoDTO : listaProdutos) {
							if(produtoDTO.getIdProduto() == folharapcom.getOmProduto().getIdProduto()) {
								produtoDTO.setQtAtiva(folharapcom.getQtAtiva());
								produtoDTO.setQtTotal(folharapcom.getQtTotal());
								produtoDTO.setIdredzproduto(folharapcom.getIdredzproduto());
								break;
							}
						}
					}
				}
			}
		}
		
		return listaProdutos;
	}
	
	public TurnoAtualDTO getTurnoAtualDTO(OmPt ompt) {
		log.iniciaAvaliacao("Gerar Status - OP - getTurnoAtualDTOSemClone");
		TurnoRN trn = new TurnoRN();
		trn.setDaoSession(this.getDaoSession());
		Date date = new Date();
		TurnoAtualDTO turnoAtual = null;
		try {
			turnoAtual = trn.getTurnoAtualDTOSemClone(ompt, date);
		} catch (SemCalendarioException e) {
			String exceptionErr = "Erro nao esperado em getTurnoAtualDTO para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - OP - getTurnoAtualDTOSemClone
		}
		return turnoAtual;
	}
	
	public List<StatusProdutoSADTO> getListaProdutosHoraTurnoStatus(OmPt ompt, PpCp ppcp, TurnoAtualDTO turnoAtual, Date date) {
		log.iniciaAvaliacao("Gerar Status - OP - getStatusDeProdutoDaOPStandAlone");
		List<StatusProdutoSADTO> listaProdutosHoraTurno = new ArrayList<StatusProdutoSADTO>();
		FolhaRN frn = new FolhaRN();
		frn.setDaoSession(this.getDaoSession());
		//pega a lista de producao dos produtos por hora/turno
		try{
			listaProdutosHoraTurno = frn.getStatusDeProdutoDaOPStandAlone(ompt.getIdPt(), ppcp.getIdCp(), turnoAtual.getIdTurno(), date);
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getListaProdutosHoraTurnoStatus para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			if(ppcp!=null) {
				exceptionErr += " e Cp";
				exceptionErr += "("+ppcp.getIdCp()+")=" + ppcp.getCdCp();
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - OP - getStatusDeProdutoDaOPStandAlone
		}
		return listaProdutosHoraTurno;
	}
	
	public List<DadosProdutoSADTO> getListaProdutosHoraTurno(List<DadosProdutoSADTO> listaProdutos, List<StatusProdutoSADTO> listaProdutosHoraTurnoStatus) {
		//clona a lista de produtos
		List<DadosProdutoSADTO> listaProdutosHoraTurno = new ArrayList<DadosProdutoSADTO>();
		for(DadosProdutoSADTO prod : listaProdutos) {
			DadosProdutoSADTO prodClone = new DadosProdutoSADTO(prod);
			prodClone.setPcsProducaobruta(new BigDecimal(0l));
			prodClone.setPcsProducaorefugada(new BigDecimal(0l));
			listaProdutosHoraTurno.add(prodClone);
		}
		
		//copia a producao bruta e refugada da lista hora/turno pra lista clonada
		for(StatusProdutoSADTO prodHoraTurno : listaProdutosHoraTurnoStatus) {
			for(DadosProdutoSADTO prodClone : listaProdutosHoraTurno) {
				if(prodHoraTurno.getCdProduto().equals(prodClone.getCdProduto())) {
					prodClone.setPcsProducaobruta(prodHoraTurno.getPcsProducaobruta());
					prodClone.setPcsProducaorefugada(prodHoraTurno.getPcsProducaorefugada());
					break;
				}
			}
		}
		return listaProdutosHoraTurno;
	}
	
	public String getCipStatus(DwConsolciplog ciplog) {
		String cipStatus = "0";
		if(ciplog == null || 
				(ciplog.getDthrIcip() == null && ciplog.getDthrFcip() == null))
			cipStatus = "0";
		else if(ciplog.getDthrIcip() != null && ciplog.getDthrFcip() == null)
			cipStatus = "1";
		else if(ciplog.getDthrIcip() != null && ciplog.getDthrFcip() != null)
			cipStatus = "2";
		return cipStatus;
	}
	
	public DwConsolpalog getUltimaParadaFromDwRt(OmPt ompt) {
		log.iniciaAvaliacao("Gerar Status - Parada - getUltimaParadaFromDwConsolpalog");
		
		ConsolidaRN consolRN = new ConsolidaRN();
		consolRN.setDaoSession(this.getDaoSession());
		DwConsolpalog dwConsolpalog = null;
		try{
			dwConsolpalog = consolRN.getUltimaParadaFromDwRt(ompt);
		} catch(Exception e){
			log.debug("CriarArquivoStatusSessao - getUltimaParadaFromDwConsolpalog(IdPt="+ompt.getIdPt()+")");
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - Parada - getUltimaParadaFromDwConsolpalog
		}
		return dwConsolpalog;
	}
	
	public SessaoParadaDTO getSessaoParadaDTO(OmPt ompt) {
		DwConsolpalog dwConsolpalog = getUltimaParadaFromDwRt(ompt);
		
		SessaoParadaDTO sessaoParada = null;
		try {
			if(dwConsolpalog != null && dwConsolpalog.getDwTParada() != null){
				sessaoParada = new SessaoParadaDTO();
				sessaoParada.setIdConsolpalog(dwConsolpalog.getIdConsolpalog());
				sessaoParada.setDthrIParada(dwConsolpalog.getDthrIparada());
				sessaoParada.setParado(dwConsolpalog.getDthrFparada() == null ? true : false);
				sessaoParada.setIdTppt(dwConsolpalog.getDwTParada().getOmTppt().getIdTppt());
				sessaoParada.setIdTParada(dwConsolpalog.getDwTParada().getIdTparada());
				sessaoParada.setCdParada(dwConsolpalog.getDwTParada().getCdTparada());
				sessaoParada.setDsParada(dwConsolpalog.getDwTParada().getDsTparada());
				if(dwConsolpalog.getDwTParada().getIsRequerCausa() != null)
					sessaoParada.setRequerCausa(dwConsolpalog.getDwTParada().getIsRequerCausa());
				if(dwConsolpalog.getDwTParada().getIsRequerAcao() != null)
					sessaoParada.setRequerAcao(dwConsolpalog.getDwTParada().getIsRequerAcao());
				if(dwConsolpalog.getDwTParada().getIsRequerJust() != null)
					sessaoParada.setRequerJustificativa(dwConsolpalog.getDwTParada().getIsRequerJust());
				if(dwConsolpalog.getDwTParada().getQtTec() != null)
					sessaoParada.setQtdTecnico(dwConsolpalog.getDwTParada().getQtTec());
				if(dwConsolpalog.getDwTParada().getIsPermitecorrecao() != null)
					sessaoParada.setPermiteCorrecao(dwConsolpalog.getDwTParada().getIsPermitecorrecao());
				if(dwConsolpalog.getDwTParada().getIsPesa() != null)
					sessaoParada.setPesaEficiencia(dwConsolpalog.getDwTParada().getIsPesa());
				if(dwConsolpalog.getDwTParada().getIsRegulagem() != null)
					sessaoParada.setRegulagem(dwConsolpalog.getDwTParada().getIsRegulagem());
				if(dwConsolpalog.getDwTParada().getSegTimeoutalerta() != null)
					sessaoParada.setTimeoutAlerta(dwConsolpalog.getDwTParada().getSegTimeoutalerta().doubleValue());
				else
					sessaoParada.setTimeoutAlerta(0d);
				if(dwConsolpalog.getDwTParada().getDwTAlerta() != null)
					sessaoParada.setCdAlerta(dwConsolpalog.getDwTParada().getDwTAlerta().getCdTalerta());
				if(dwConsolpalog.getDwTParada().getSegExtrapolacao() != null)
					sessaoParada.setExtrapolacao(dwConsolpalog.getDwTParada().getSegExtrapolacao().doubleValue());
				else
					sessaoParada.setExtrapolacao(0d);
				if(dwConsolpalog.getDwTParada().getDwTParadaextra() != null)
					sessaoParada.setCdParadaExtra(dwConsolpalog.getDwTParada().getDwTParadaextra().getCdTparada());
			}
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getSessaoParadaDTO para Pt";
			if(dwConsolpalog.getOmPt()!= null) {
				exceptionErr += "("+dwConsolpalog.getOmPt().getIdPt()+")=" + dwConsolpalog.getOmPt().getCdPt();
			}
			exceptionErr += " e ConsolPaLog";
			if(dwConsolpalog!=null) {
				exceptionErr += "("+dwConsolpalog.getIdConsolpalog()+")=";
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
		return sessaoParada;
	}
	
	public DwConsolrelog getUltimoRefugoFromConsolrelog(OmPt ompt, PpCp ppcp) {
		log.iniciaAvaliacao("Gerar Status - Refugo - getUltimoRefugoFromConsolrelog");
		ConsolidaRN consolRN = new ConsolidaRN();
		consolRN.setDaoSession(this.getDaoSession());
		DwConsolrelog dwConsolrelog = null;
		try{
			dwConsolrelog = consolRN.getUltimoRefugoFromDwConsolrelog(ompt, ppcp);
		} catch(Exception e){
			log.debug("CriarArquivoStatusSessao - Exception em ultimoRefugo(IdPt="+ompt.getIdPt()+")");
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - Refugo - getUltimoRefugoFromDwConsolrelog, getUltimoRefugoFromDwPassagem
		}
		return dwConsolrelog;
	}
	
	public DwPassagem getUltimoRefugoFromPassagem(OmPt ompt, PpCp ppcp) {
		log.iniciaAvaliacao("Gerar Status - Refugo - getUltimoRefugoFromPassagem");
		ConsolidaRN consolRN = new ConsolidaRN();
		consolRN.setDaoSession(this.getDaoSession());
		DwPassagem dwPassagem = null;
		try{
			dwPassagem = consolRN.getUltimoRefugoFromDwPassagem(ompt, ppcp);
		} catch(Exception e){
			log.debug("CriarArquivoStatusSessao - Exception em getUltimoRefugoFromPassagem(IdPt="+ompt.getIdPt()+")");
		} finally {
			log.mostrarAvaliacaoCompleta();//Gerar Status - Refugo - getUltimoRefugoFromDwConsolrelog, getUltimoRefugoFromDwPassagem
		}
		return dwPassagem;
	}
	
	public SessaoRefugoDTO getSessaoRefugoDTO(OmPt ompt, PpCp ppcp) {
		DwConsolrelog dwConsolrelog = getUltimoRefugoFromConsolrelog(ompt, ppcp);
		DwPassagem dwPassagem = getUltimoRefugoFromPassagem(ompt, ppcp);
		
		SessaoRefugoDTO sessaoRefugo = null;
		/*24/11/2015 - Alexandre - Retirei a verificacao de passagem != null, pois em maquinas ciclicas nao tem passagem
		* isso fazia nao gerar ultimo refugo para o coletor
		*/
		try {
			if(dwConsolrelog != null && dwConsolrelog.getIsCancelado() == null){
				sessaoRefugo = new SessaoRefugoDTO();
				sessaoRefugo.setIdConsolrelog(dwConsolrelog.getIdConsolrelog());
				sessaoRefugo.setCdProduto(dwConsolrelog.getOmProduto().getCd());
				sessaoRefugo.setDthrRefugo(dwConsolrelog.getDthrRefugo());
				if(dwConsolrelog.getPcsAutoProducaorefugada() != null)
					sessaoRefugo.setQtd(dwConsolrelog.getPcsAutoProducaorefugada().intValue());
				else
					sessaoRefugo.setQtd(0);
				if(dwPassagem != null && dwPassagem.getDwNserie() != null && dwPassagem.getDwNserie().getCb() != null)
					sessaoRefugo.setCb(dwPassagem.getDwNserie().getCb());
				sessaoRefugo.setIdTMotivo(dwConsolrelog.getDwTRefugo().getIdTrefugo());
				sessaoRefugo.setCdRefugo(dwConsolrelog.getDwTRefugo().getCdTrefugo());
				sessaoRefugo.setDsRefugo(dwConsolrelog.getDwTRefugo().getDsTrefugo());
				sessaoRefugo.setIdTppt(dwConsolrelog.getDwTRefugo().getOmTppt().getIdTppt());
			}
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getSessaoRefugoDTO para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			exceptionErr += " e PpCp";
			if(ppcp!=null) {
				exceptionErr += "("+ppcp.getIdCp()+")=";
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
		return sessaoRefugo;
	}
	
	public DwConsolvaritmolog getUltimoVarRitmo(OmPt ompt) {
		ConsolidaRN consolRN = new ConsolidaRN();
		consolRN.setDaoSession(this.getDaoSession());
		DwConsolvaritmolog res = null;
		try {
			res = consolRN.getUltimoVarRitmoFromDwConsolvaritmolog(ompt);
		} catch(Exception e) {
			log.debug("CriarArquivoStatusSessao - Exception em getUltimoVarRitmo(IdPt="+ompt.getIdPt()+")");
		}
		return res;
	}
	
	public DwRtcic getCicloDeInicioDaVariacaoDeRitmo(DwConsolvaritmolog dwConsolvaritmolog, OmPt ompt, PpCp ppcp) {
		ConsolidaRN consolRN = new ConsolidaRN();
		consolRN.setDaoSession(this.getDaoSession());
		DwRtcic res = null;
		try {
			res = consolRN.getUltimoCicloFechadoAntesDaDataFromDwRtCic(dwConsolvaritmolog.getDthrIvaritmo(), ompt, ppcp);
		} catch(Exception e) {
			log.debug("CriarArquivoStatusSessao - Exception em getCicloDeInicioDaVariacaoDeRitmo(IdPt="+ompt.getIdPt()+")");
		}
		return res;
	}
	
	public SessaoVarRitmoDTO getSessaoVarRitmoDTO(OmPt ompt, PpCp ppcp) {
		DwConsolvaritmolog dwConsolritmolog = null;
		DwRtcic dwRtcic = null;
		if(ppcp != null) {
			dwConsolritmolog = getUltimoVarRitmo(ompt);
			if(dwConsolritmolog != null)
				dwRtcic = getCicloDeInicioDaVariacaoDeRitmo(dwConsolritmolog, ompt, ppcp);
		}
		
		SessaoVarRitmoDTO sessaoVarRitmo = null;
		try{
			if(dwConsolritmolog != null) {
				sessaoVarRitmo = new SessaoVarRitmoDTO();
				sessaoVarRitmo.setIdConsolRitmolog(dwConsolritmolog.getIdConsolvaritmolog());
				
				DwConsolvaritmologcau dwconsolvarritmologcau = null;
				if(dwConsolritmolog != null && dwConsolritmolog.getDwConsolvaritmologcaus().isEmpty() == false) {
					for(DwConsolvaritmologcau causa : dwConsolritmolog.getDwConsolvaritmologcaus()) {
						if(dwconsolvarritmologcau == null || DataHoraRN.after(causa.getDthrVaritmo(), dwconsolvarritmologcau.getDthrVaritmo()))
							dwconsolvarritmologcau = causa;
					}
				}
				
				if(dwconsolvarritmologcau != null && dwconsolvarritmologcau.getDwTRitmo() != null) {
					if(dwconsolvarritmologcau.getDwTRitmo().getIdTritmo() != null) {
						sessaoVarRitmo.setIdTRitmo(dwconsolvarritmologcau.getDwTRitmo().getIdTritmo());
					}
					if(dwconsolvarritmologcau.getDwTRitmo().getCdTritmo() != null) {
						sessaoVarRitmo.setCdVarRitmo(dwconsolvarritmologcau.getDwTRitmo().getCdTritmo());
					}
		
					if(dwconsolvarritmologcau.getDwTRitmo().getDsTritmo() != null) {
						sessaoVarRitmo.setDsVarRitmo(dwconsolvarritmologcau.getDwTRitmo().getDsTritmo());
					}
				}
				if(dwConsolritmolog != null) {
					if(dwConsolritmolog.getDthrIvaritmo() != null) {
						sessaoVarRitmo.setDthrIVarRitmo(dwConsolritmolog.getDthrIvaritmo());
					}
					
					if(dwConsolritmolog.getDthrFvaritmo() != null) {
						sessaoVarRitmo.setDthrFVarRitmo(dwConsolritmolog.getDthrFvaritmo());
						sessaoVarRitmo.setVarRitmoAberto(false);
					} else {
						sessaoVarRitmo.setVarRitmoAberto(true);
					}
					
					if(dwRtcic != null && dwRtcic.getSegDuracao() != null) {
						sessaoVarRitmo.setDuracao(dwRtcic.getSegDuracao().floatValue()*1000);
					} else {
						sessaoVarRitmo.setDuracao(0.0f);
					}
				}
			}
		} catch(Exception e) {
			String exceptionErr = "Erro nao esperado em getSessaoVarRitmoDTO para Pt";
			if(ompt!= null) {
				exceptionErr += "("+ompt.getIdPt()+")=" + ompt.getCdPt();
			}
			exceptionErr += " e PpCp";
			if(ppcp!=null) {
				exceptionErr += "("+ppcp.getIdCp()+")=";
			}
			log.debug(exceptionErr);
			log.debug(e.getStackTrace());
		}
		return sessaoVarRitmo;
	}
	
	public void criaLog(String nomeLog) {
		if(log == null || !log.getNomeLog().equals(nomeLog))
			log = new IdwLogger(nomeLog);
	}
	
	public SessaoUPDTO getSessaoUPDTO(String cdUp) {
		criaLog("Sessao_"+cdUp);
		UpDTO updto = new UpDTO();
		updto.setCd_up(cdUp);
		
		IcUpDTO icup = new IcUpDTO();
		icup.setIdIcUp(null);
		icup.setUpDTO(updto);
		
		return getSessaoUPDTO(icup);
	}
	
	private SessaoUPDTO getSessaoUPDTO(IcUpDTO icup) {
		String cdUp = icup.getUpDTO().getCd_up();
		
		criaLog("Sessao_"+cdUp);
		
		log.iniciaAvaliacao("getSessaoUPDTO");
		log.info("\n");
		log.info("getSessaoUPDTO - INI");
		
		OmPt ompt = getOmPt(cdUp);
		MsUp up = getMsUp(cdUp);
		PpCp ppcp = ompt.getPpCp();
		OmPtcp omPtcp = getOmPtCp(ompt, ppcp);
		return getSessaoUPDTO(ompt, up, icup, ppcp, omPtcp);
	}
	
	private SessaoUPDTO getSessaoUPDTO(OmPt ompt, MsUp msup, IcUpDTO icup, PpCp ppcp, OmPtcp omPtcp) {
		if(ompt == null || msup == null)
			return null;
		
		criaLog("Sessao_"+ompt.getCdPt());
		
		log.iniciaAvaliacao("Gerar Status - UP");
		SessaoUPDTO sessaoUP = new SessaoUPDTO();
		preencheSessaoUPDTO(sessaoUP, ompt);
		
		SessaoCalendarioDTO calendario = getSessaoCalendarioDTO(ompt);
		sessaoUP.setCalendario(calendario);
		
		DwFolha ultimaFolha = getUltimaFolhaOmPt(ompt);
		if(ultimaFolha != null)
			sessaoUP.setUltimaFolha(ultimaFolha.getIdFolha());
		log.mostrarAvaliacaoCompleta();//Gerar Status - UP
		
		log.iniciaAvaliacao("Gerar Status - Usuarios");
		SessaoUsuariosDTO usuarios = getSessaoUsuariosDTO(ompt);
		sessaoUP.setUsuarios(usuarios);
		log.mostrarAvaliacaoCompleta();//Gerar Status - Usuarios
		
		log.iniciaAvaliacao("Gerar Status - Alertas");
		SessaoAlertasDTO alertas = getSessaoAlertasDTO(ompt);
		sessaoUP.setAlertas(alertas);
		log.mostrarAvaliacaoCompleta();//Gerar Status - Alertas
		
		log.iniciaAvaliacao("Gerar Status - OP");
		SessaoOPDTO sessaoOPDTO = getSessaoOPDTO(ompt, ppcp, omPtcp, icup, msup);
		sessaoUP.setOpDTO(sessaoOPDTO);
		log.mostrarAvaliacaoCompleta();//Gerar Status - OP

		log.iniciaAvaliacao("Gerar Status - Parada");
		SessaoParadaDTO sessaoParada = getSessaoParadaDTO(ompt);
		sessaoUP.setParada(sessaoParada);
		log.mostrarAvaliacaoCompleta();//Gerar Status - Parada
		
		log.iniciaAvaliacao("Gerar Status - Refugo");
		SessaoRefugoDTO sessaoRefugo = getSessaoRefugoDTO(ompt, ppcp);
		sessaoUP.setRefugo(sessaoRefugo);
		log.mostrarAvaliacaoCompleta();//Gerar Status - Refugo
		
		log.iniciaAvaliacao("Gerar Status - VarRitmo");
		SessaoVarRitmoDTO sessaoVarRitmo = getSessaoVarRitmoDTO(ompt, ppcp);
		sessaoUP.setVarRitmo(sessaoVarRitmo);
		log.mostrarAvaliacaoCompleta();//Gerar Status - VarRitmo

		//log.paraAvaliacao();//getSessaoUPDTO
		log.mostrarAvaliacaoCompleta();//Gerar Status - UP
		//log.info("getSessaoUPDTO - FIM - " + log.getAvaliacaoCompleta());
		
		return sessaoUP;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
}
