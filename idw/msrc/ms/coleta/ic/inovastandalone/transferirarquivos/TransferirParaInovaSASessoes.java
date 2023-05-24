package ms.coleta.ic.inovastandalone.transferirarquivos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmHomopt;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwTParadaRN;
import idw.model.rn.InicializacaoRN;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.UsuarioRN;
import idw.webservices.dto.AlertaDTO;
import idw.webservices.dto.AlertasDTO;
import idw.webservices.dto.DwTAcoes;
import idw.webservices.dto.DwTCausaDTO;
import idw.webservices.dto.DwTCausasDTO;
import idw.webservices.dto.DwTJustDTO;
import idw.webservices.dto.DwTJustsDTO;
import idw.webservices.dto.DwTRefugoDTO;
import idw.webservices.dto.DwTRefugosDTO;
import idw.webservices.dto.DwTRitmoDTO;
import idw.webservices.dto.DwTRitmosDTO;
import idw.webservices.dto.TurnoAtualDTO;
import ms.coleta.dto.SessaoUPDTO;
import ms.coleta.dto.TAndonSADTO;
import ms.model.MsFacade;
import ms.model.rn.SessaoRN;
import ms.model.rn.UpRN;

public class TransferirParaInovaSASessoes extends TransferirParaInovaSAFactory{
	
	@Override
	public void criarArquivo() {
		
		DwCal dwcal = null;
		//List<ColetaParametroDTO> parametrosColetadosDTO = new ArrayList<ColetaParametroDTO>();
		InicializacaoRN rn = new InicializacaoRN();
		rn.setSession(session);

		TurnoRN trn = new TurnoRN();
		trn.setDaoSession(session);

		PTRN ptrn = new PTRN();
		ptrn.setDaoSession(session);

		OmPt ompt;

		if(msmsicup == null || msmsicup.getMsIc() == null || msmsicup.getMsIc().getUrlConexao() == null) {
			log.debug("TransferirParaInovaSASessoes.criarArquivo() - msmsicup == null || msmsicup.getMsIc() == null || msmsicup.getMsIc().getUrlConexao() == null");
			return;
		}
			
		if(msmsicup.getMsUp() == null || msmsicup.getMsUp().getCdUp() == null) {
			log.debug("TransferirParaInovaSASessoes.criarArquivo() - msmsicup.getMsUp() == null || msmsicup.getMsUp().getCdUp() == null");
			return;
		}
		
		try {
			ompt = ptrn.getOmPt(msmsicup.getMsUp().getCdUp(), true);
			/*System.out.println(msmsicup.getMsIc().getUrlConexao()+"cd pt"
					+ msmsicup.getMsUp().getCdUp());*/
		} catch (RegistroDesconhecidoException e1) {

			//System.out.println("registro desconhecido" + msmsicup.getMsIc().getUrlConexao()+"cd pt" + msmsicup.getMsUp().getCdUp());
			log.debug("TransferirParaInovaSASessoes.criarArquivo() - ompt nao encontado(CdUp="+msmsicup.getMsUp().getCdUp()+")");
			return;
		}
		
		UpRN uprn = new UpRN();
		uprn.iniciaConexaoBanco(session);
		PpCp ppcpAnt = null;
		if(ompt.getPpCp() != null)
			ppcpAnt = uprn.obtemPpCpAnteriorAoAtualDoPT(ompt);

		if (dwcal == null) {
			try {
				dwcal = trn.getDwCalPtOuDefault(ompt, DataHoraRN.getDataHoraAtual());
			} catch (NullPointerException | SemCalendarioException e) {
				dwcal = getOmCfg().getDwCal();
			}
		}
		/*
		 * Encontrando as viradas de turno dos proximos 7 dias
		 */
		List<DwCalsem> dwCalsems = null;
		try {
			dwCalsems = trn.getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, DataHoraRN.getDataHoraAtual());
		} catch (SemCalendarioException e1) {
			dwCalsems = null;
		}
		List<Date> proximasViradasTurno = new ArrayList<>();
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
		
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e) {
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/sessao/";

		String fileName = "sessao" + msmsicup.getUrlConexao() + ".ini";

		log.info("Gerando arquivo em " + dir+fileName);
		
		ArquivoSessoes sessoes = new ArquivoSessoes();
		sessoes.setLog(log);
		sessoes.setProximasViradasDeTurno(proximasViradasTurno);
		sessoes.setOmpt(ompt);
		sessoes.setOmcfg(getOmCfg());
		sessoes.setDwcal(dwcal);
		sessoes.setMsmsicup(msmsicup);
		sessoes.setPpcpAnterior(ppcpAnt);
		sessoes.gerarArquivo(dir, fileName);

		DAOGenerico dao = new DAOGenerico();
		dao.setSession(session);
		CpRN cprn = new CpRN(dao);
		
		log.iniciaAvaliacao("Gerar REG - OP");
		
		// Pesquisar as CPs do PT
		//Alexandre: em 24/05/2016 Manuel solicitou que fossem enviadas apenas as OPs com inicio em ate 2 meses atras.
		//Para reduzir o tamanho da Sessao enviada ao coletor.
		List<PpCp> listaPpCps = cprn.pesquisarCpsAtivasRecentesDoPt(msmsicup.getMsUp().getCdUp());
		
		if(listaPpCps != null && listaPpCps.isEmpty() == false) {
			for (PpCp ppcp : listaPpCps) {
				TransferirParaInovaSAOps oprn = new TransferirParaInovaSAOps();
				oprn.setDiretorioDestino(getDiretorioDestino());
				oprn.setLog(log);
				oprn.setOmCfg(getOmCfg());
				oprn.setSession(session);
				oprn.setMsmsicup(msmsicup);
				oprn.setOmpt(ompt);
				oprn.setPpcp(ppcp);
				oprn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Usuarios");
		
		// Gerar os operadores do pt
		if (ompt.getOmHomopts() != null && ompt.getOmHomopts().size() > 0) {
			for (OmHomopt homopt : ompt.getOmHomopts()) {
				OmUsr omusr = homopt.getOmUsrByIdUsrhomologado();
				TransferirParaInovaSAUsuario hrn = new TransferirParaInovaSAUsuario();
				hrn.setDiretorioDestino(getDiretorioDestino());
				hrn.setOmusr(omusr);
				hrn.setLog(log);
				hrn.setOmCfg(getOmCfg());
				hrn.setSession(session);
				hrn.setMsmsicup(msmsicup);
				hrn.criarArquivo();
				Thread.yield();
			}
		} else {
			UsuarioRN usuRN = new UsuarioRN();
			usuRN.setDaoSession(session);
			List<OmUsr> listaomusr = usuRN.getTodosOmUsrAtivosComDireitoOperador();
			for (OmUsr omusr : listaomusr) {
				TransferirParaInovaSAUsuario hrn = new TransferirParaInovaSAUsuario();
				hrn.setDiretorioDestino(getDiretorioDestino());
				hrn.setOmusr(omusr);
				hrn.setLog(log);
				hrn.setOmCfg(getOmCfg());
				hrn.setSession(session);
				hrn.setMsmsicup(msmsicup);
				hrn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();

		log.iniciaAvaliacao("Gerar REG - Paradas");
		
		DwTParadaRN dwtparadarn = new DwTParadaRN();
		dwtparadarn.setDaoSession(session);
		List<DwTParada> listaDwtParada=null;
		try {
			listaDwtParada  = dwtparadarn.getParadabyTppt(ompt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//Gerar arquivos de parada para o inova standalone
		TransferirParaInovaSAParadas prn = null;
		if(listaDwtParada != null) {
			for (DwTParada dwtparada : listaDwtParada) {
				prn = new TransferirParaInovaSAParadas();
				prn.setDiretorioDestino(getDiretorioDestino());
				prn.setDwtparada(dwtparada);
				prn.setLog(log);
				prn.setOmCfg(getOmCfg());
				prn.setSession(session);
				prn.setMsmsicup(msmsicup);
				prn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Alertas");

		AlertasDTO alertasDTO = null;
		try {
			alertasDTO  = IdwFacade.getInstancia().getTAlertasDTO(ompt.getOmTppt().getIdTppt());
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(alertasDTO != null) {
			//Gerar arquivos de alerta para o inova standalone
			for (AlertaDTO alerta : alertasDTO.getListaAlertasDTO()) {
				TransferirParaInovaSAAlertas arn = new TransferirParaInovaSAAlertas();
				arn.setDiretorioDestino(getDiretorioDestino());
				arn.setDwtalerta(alerta.getDwTAlerta());
				arn.setLog(log);
				arn.setOmCfg(getOmCfg());
				arn.setSession(session);
				arn.setMsmsicup(msmsicup);
				arn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Refugos");

		DwTRefugosDTO refugoDTO = null;
		try {
			refugoDTO  = IdwFacade.getInstancia().getRefugosDTO(ompt.getOmTppt().getIdTppt());
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(refugoDTO != null) {
			//Gerar arquivos de refugo para o inova standalone
			for (DwTRefugoDTO refugo : refugoDTO.getDwTRefugos()) {
				TransferirParaInovaSARefugos rrn = new TransferirParaInovaSARefugos();
				rrn.setDiretorioDestino(getDiretorioDestino());
				rrn.setDwtrefugo(refugo.getDwTRefugo());
				rrn.setLog(log);
				rrn.setOmCfg(getOmCfg());
				rrn.setSession(session);
				rrn.setMsmsicup(msmsicup);
				rrn.setOmpt(ompt);
				rrn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Causas");

		DwTCausasDTO causasDTO = null;
		try {
			causasDTO  = IdwFacade.getInstancia().getTCausa(ompt.getOmTppt().getIdTppt());
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(causasDTO != null) {
			//Gerar arquivos de causa para o inova standalone
			for (DwTCausaDTO causa : causasDTO.getListaCausasDTO()) {
				TransferirParaInovaSACausas carn = new TransferirParaInovaSACausas();
				carn.setDiretorioDestino(getDiretorioDestino());
				carn.setDwtcausa(causa.getDwTCausa());
				carn.setLog(log);
				carn.setOmCfg(getOmCfg());
				carn.setSession(session);
				carn.setMsmsicup(msmsicup);
				carn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Acoes");

		DwTAcoes acoesDTO = null;
		try {
			acoesDTO  = IdwFacade.getInstancia().getDwAcao(ompt.getOmTppt().getIdTppt());
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(acoesDTO != null) {
			//Gerar arquivos de acoes para o inova standalone
			for (DwTAcao acao : acoesDTO.getListaDwTAcoes()) {
				TransferirParaInovaSAAcoes acrn = new TransferirParaInovaSAAcoes();
				acrn.setDiretorioDestino(getDiretorioDestino());
				acrn.setDwtacao(acao);
				acrn.setLog(log);
				acrn.setOmCfg(getOmCfg());
				acrn.setSession(session);
				acrn.setMsmsicup(msmsicup);
				acrn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Justificativas");
		
		DwTJustsDTO justsDTO = null;
		try {
			justsDTO  = IdwFacade.getInstancia().getTJustificativa(ompt.getOmTppt().getIdTppt());
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(justsDTO != null) {
			//Gerar arquivos de acoes para o inova standalone
			for (DwTJustDTO just : justsDTO.getListaJustsDTO()) {
				TransferirParaInovaSAJustificativas jurn = new TransferirParaInovaSAJustificativas();
				jurn.setDiretorioDestino(getDiretorioDestino());
				jurn.setDwtjust(just.getDwTJust());
				jurn.setLog(log);
				jurn.setOmCfg(getOmCfg());
				jurn.setSession(session);
				jurn.setMsmsicup(msmsicup);
				jurn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Andon");
		
		//Gerar arquivos de andon para o inova standalone
		TAndonSADTO andonDTO = null;
		if(msmsicup.getMsIc().getMsPerfilandon() != null){
			try {
				andonDTO  = MsFacade.getInstancia().getAndonsSA(msmsicup.getMsIc().getMsPerfilandon().getIdPerfilandon());
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(andonDTO != null) {
				TransferirParaInovaSAAndon anrn = new TransferirParaInovaSAAndon();
				anrn.setDiretorioDestino(getDiretorioDestino());
				anrn.setLog(log);
				anrn.setOmCfg(getOmCfg());
				anrn.setIdPerfilAndon(msmsicup.getMsIc().getMsPerfilandon().getIdPerfilandon());
				anrn.setListaAndon(andonDTO);
				anrn.setMsmsicup(msmsicup);
				anrn.setSession(session);
				anrn.criarArquivo();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
		log.iniciaAvaliacao("Gerar REG - Motivo VarRitmo");
		
		DwTRitmosDTO ritmosDTO = null;
		try {
			ritmosDTO  = IdwFacade.getInstancia().getTRitmos(ompt.getOmTppt().getIdTppt());
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(ritmosDTO != null) {
			//Gerar arquivos de motivos de variacao de ritmos para o inova standalone
			for (DwTRitmoDTO ritmo : ritmosDTO.getListaRitmosDTO()) {
				TransferirParaInovaSARitmos ritrn = new TransferirParaInovaSARitmos();
				ritrn.setDiretorioDestino(getDiretorioDestino());
				ritrn.setDwtritmo(ritmo.getDwTRitmo());
				ritrn.setLog(log);
				ritrn.setOmCfg(getOmCfg());
				ritrn.setSession(session);
				ritrn.setMsmsicup(msmsicup);
				ritrn.criarArquivo();
				Thread.yield();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
	}

	@Override
	public void criarArquivoStatus() {
		
		log.iniciaAvaliacao("criarArquivoStatus("+msmsicup.getMsUp().getCdUp()+")");
		
		SessaoRN sessaoRN = new SessaoRN();
		sessaoRN.setDaoSession(session);
		SessaoUPDTO sessaoUP = sessaoRN.getSessaoUPDTO(msmsicup.getMsUp().getCdUp());
		
		if(sessaoUP.getOpDTO() != null) {
			try {
				TransferirParaInovaSAOps op = new TransferirParaInovaSAOps();
				op.setSession(session);
				op.setMsmsicup(msmsicup);
				op.setLog(log);
				op.setDiretorioDestino(getDiretorioDestino());
				op.setSessaoUP(sessaoUP);
				op.criarArquivoStatus();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(sessaoUP.getUsuarios() != null && sessaoUP.getUsuarios().getListaUsuarios() != null && sessaoUP.getUsuarios().getListaUsuarios().isEmpty() == false){
			try {
				TransferirParaInovaSAUsuario operadores = new TransferirParaInovaSAUsuario();
				operadores.setSession(session);
				operadores.setMsmsicup(msmsicup);
				operadores.setLog(log);
				operadores.setSessaoUP(sessaoUP);
				operadores.setDiretorioDestino(getDiretorioDestino());
				operadores.criarArquivoStatus();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(sessaoUP.getAlertas() != null && sessaoUP.getAlertas().getListaAlertas() != null && sessaoUP.getAlertas().getListaAlertas().isEmpty() == false){
			try{
				TransferirParaInovaSAAlertas alerta = new TransferirParaInovaSAAlertas();
				alerta.setSession(session);
				alerta.setMsmsicup(msmsicup);
				alerta.setLog(log);
				alerta.setDiretorioDestino(getDiretorioDestino());
				alerta.setSessaoUP(sessaoUP);
				alerta.criarArquivoStatus();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(sessaoUP.getParada() != null){
			try{
				TransferirParaInovaSAParadas parada = new TransferirParaInovaSAParadas();
				parada.setSession(session);
				parada.setMsmsicup(msmsicup);
				parada.setLog(log);
				parada.setDiretorioDestino(getDiretorioDestino());
				parada.setSessaoUP(sessaoUP);
				parada.criarArquivoStatus();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		/*24/11/2015 - Alexandre - Retirei a verificacao de passagem != null, pois em maquinas ciclicas nao tem passagem
		* isso fazia nao gerar ultimo refugo para o coletor
		*/
		if(sessaoUP.getRefugo() != null){
			try{
				TransferirParaInovaSARefugos refugo = new TransferirParaInovaSARefugos();
				refugo.setSession(session);
				refugo.setMsmsicup(msmsicup);
				refugo.setLog(log);
				refugo.setDiretorioDestino(getDiretorioDestino());
				refugo.setSessaoUP(sessaoUP);
				refugo.criarArquivoStatus();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(sessaoUP.getOpDTO() != null && sessaoUP.getVarRitmo() != null) {
			try{
				TransferirParaInovaSARitmos ritmo = new TransferirParaInovaSARitmos();
				ritmo.setSession(session);
				ritmo.setMsmsicup(msmsicup);
				ritmo.setLog(log);
				ritmo.setDiretorioDestino(getDiretorioDestino());
				ritmo.setSessaoUP(sessaoUP);
				ritmo.criarArquivoStatus();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		log.mostrarAvaliacaoCompleta();
		
	}
	

}
