package idw.model.rn.consolidacao.parada;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DwConsolidDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpalogtec;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.pojos.template.DwConsolpalogtecTemplate;
import idw.model.rn.AcaoRN;
import idw.model.rn.CausaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.JustificativaRN;
import idw.model.rn.ParadaRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoMotivoParada extends ConsolidacaoParada implements
		IConsolidacao {
	
	private static String TAG = ConsolidacaoMotivoParada.class.getSimpleName();
	
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt,
			List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log,
			int idLog, int identacao) throws SemCalendarioException,
			SemSGBDException, SemCicloPadraoException,
			SemPlanejamentoException, RegistroDesconhecidoException, EventoInvalidoException {

		Validate.notNull(omPt, "Posto de trabalho esta nulo");		
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");
		
		DwConsolpalog dwConsolpalog = getDwConsolpalog(omPt, msEvt, log);
		
		DwConsolidDAO dwConsolidDAO = new DwConsolidDAO(getDaoSession());		
		DwConsolid ultimoDwConsolidParada = dwConsolidDAO.getUltimoDwConsolidParada(dwConsolpalog, TpId.TURNO);
		
		Validate.notNull(ultimoDwConsolidParada, "ultima parada desconhecida");
		
		PpCp ppCp = ultimoDwConsolidParada.getPpCp();
		DwFolha dwFolha = ultimoDwConsolidParada.getDwFolha();
		DwPepro dwPepro = ultimoDwConsolidParada.getDwPepro();
		
		Date dtHrInicioParada = dwConsolpalog.getDthrIparada();
		
		ppCp.mudarDthrIniciorealIfNull(dtHrInicioParada);
		
		DwTParada dwTParadaNova = getDwTParada(omPt, msEvt);

		DwTParada dwTParada = dwConsolpalog.getDwTParada();

		setRequisicoesParada(omPt, msEvt, log, idLog, dwConsolpalog);
		
		// Só ajusta os tempos se os código forem diferente
		if(!dwTParada.getIdTparada().equals(dwTParadaNova.getIdTparada())){

			Date dtHrIParadaRef = dwConsolpalog.getDthrIparada();
			Date dtHrFParadaRef = (dwConsolpalog.isAberta() ? dwConsolpalog.getDthrFparadaAb() : dwConsolpalog.getDthrFparada());
			if (dtHrFParadaRef == null) {
				dtHrFParadaRef = dtHrIParadaRef;
			}
			ConsolidacaoPeriodoParada consolidacaoPeriodoParada = 
					new ConsolidacaoPeriodoParada(log, idLog, identacao, this, omcfg, dwconsolpt, ppCp, dwFolha, dwPepro, false);

			// Desfaz a consolidacao da parada do ANTIGO motivo, pois o antigo pode ter sido com peso ou sem peso etc
//			consolidarTempoParada(true, true, omPt, dwconsolpt, dwCalsems, ppCp, dwFolha, omcfg, log, idLog, identacao, dwPepro,
//					dwConsolpalog, dtHrIParadaRef, dtHrFParadaRef);
			log.info(idLog, identacao, "Desfazendo a consolidacao da parada que estava em aberta");
			consolidacaoPeriodoParada.consolidar(true, dtHrIParadaRef, dtHrFParadaRef, dwConsolpalog, null, "ConsolidacaoMotivoParada");
			
			// Ajusta para novo motivo de parada
			dwConsolpalog.setDwTParada(dwTParadaNova);

			log.info(idLog, identacao, "Reconsolidando a parada");
			// Reconsolida a parada considerando o NOVO motivo
//			consolidarTempoParada(false, true, omPt, dwconsolpt, dwCalsems, ppCp, dwFolha, omcfg, log, idLog, identacao, dwPepro,
//					dwConsolpalog, dtHrIParadaRef, dtHrFParadaRef);
			consolidacaoPeriodoParada.consolidar(false, dtHrIParadaRef, dtHrFParadaRef, dwConsolpalog, null, "ConsolidacaoMotivoParada");
			
		}


	}

	private DwTParada getDwTParada(OmPt omPt, MsEvt msEvt) throws RegistroDesconhecidoException, EventoInvalidoException {
		
		String cdParada = msEvt.getCdParada();
		if (cdParada == null || cdParada.isEmpty()) {
			throw new EventoInvalidoException(msEvt, "CdParada vazio");
		}

		try {
			ParadaRN paradaRN = new ParadaRN();
			paradaRN.setDaoSession(this.getDao().getSession());
			DwTParada dwTParadaNovo = paradaRN.getDwTParada(cdParada, omPt.getOmTppt());
			return dwTParadaNovo;
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException("Parada nao encontrada. Parada:" + cdParada + " idOmTppt:" + omPt.getOmTppt().getIdTppt());
		}
	}

	private void setRequisicoesParada(OmPt omPt, MsEvt msEvt, IdwLogger log, int idLog, DwConsolpalog dwConsolpalog)
			throws RegistroDesconhecidoException {
		setCausaParada(omPt, msEvt, dwConsolpalog);
		setAcaoParada(omPt, msEvt, dwConsolpalog);
		setJustParada(omPt, msEvt, dwConsolpalog);
		setTecnicosParada(msEvt, log, idLog, dwConsolpalog);
	}

	private void setJustParada(OmPt omPt, MsEvt msEvt, DwConsolpalog dwConsolpalog) throws RegistroDesconhecidoException {
		String cdJust = msEvt.getCdJustificativa();
		DwTJust dwTJust = getDwTJust(omPt, cdJust);
		dwConsolpalog.setDwTJust(dwTJust);
	}

	private void setAcaoParada(OmPt omPt, MsEvt msEvt, DwConsolpalog dwConsolpalog) throws RegistroDesconhecidoException {
		String cdAcao = msEvt.getCdAcao();
		DwTAcao dwTAcao = getDwTAcao(omPt, cdAcao);
		dwConsolpalog.setDwTAcao(dwTAcao);
	}

	private void setCausaParada(OmPt omPt, MsEvt msEvt, DwConsolpalog dwConsolpalog) throws RegistroDesconhecidoException {
		String cdCausa = msEvt.getCdCausa();
		DwTCausa dwTCausa = getDwTCausa(omPt, cdCausa);
		dwConsolpalog.setDwTCausa(dwTCausa);
	}

	private void setTecnicosParada(MsEvt msEvt, IdwLogger log, int idLog, DwConsolpalog dwConsolpalog) throws RegistroDesconhecidoException {
		
		Map<Long, OmUsr> novosTecnicosParada = new HashMap<Long, OmUsr>();

		guardaTecnico(novosTecnicosParada, msEvt.getCdTec1(), "Tecnico 1");
		guardaTecnico(novosTecnicosParada, msEvt.getCdTec2(), "Tecnico 2");
		guardaTecnico(novosTecnicosParada, msEvt.getCdTecresp(), "Tecnico responsavel");

		for(DwConsolpalogtec dwConsolpalogtec: dwConsolpalog.getDwConsolpalogtecs()){

			// Se não houver técnicos para a parada 
			// ou se não técnico que estava na parada, não estiver na lista dos novos apontados
			Long idUsr = dwConsolpalogtec.getOmUsr().getIdUsr();
			if(novosTecnicosParada.isEmpty() || !novosTecnicosParada.containsKey(idUsr)){
				this.getDao().getSession().delete(dwConsolpalogtec);
			} else {
				// Remove da lista de tecnicos para inclusao, pois ele já fazia parte da parada
				novosTecnicosParada.remove(idUsr);
			}

		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.getDao().getSession());
		// Inclui os que est�o faltando
		// Removi o loop e fiz por tecnico para poder salvar tpUsuario mesmo que o mesmo tecnico se log 3 vezes
		if (msEvt.getCdTec1() != null && msEvt.getCdTec1().trim().equals("") == false) {
			OmUsr omUsr = usuarioRN.getOmUsr(msEvt.getCdTec1());

			DwConsolpalogtec dwConsolpalogtec = new DwConsolpalogtec();
			dwConsolpalogtec.setDwConsolpalog(dwConsolpalog);
			dwConsolpalogtec.setOmUsr(omUsr);
			dwConsolpalogtec.setIdConsolpalogtec(null);
			
			dwConsolpalogtec.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TEC1.getValue());
			
			getDao().makePersistent(dwConsolpalogtec);
		}
		
		if (msEvt.getCdTec2() != null && msEvt.getCdTec2().trim().equals("") == false) {
			OmUsr omUsr = usuarioRN.getOmUsr(msEvt.getCdTec2());

			DwConsolpalogtec dwConsolpalogtec = new DwConsolpalogtec();
			dwConsolpalogtec.setDwConsolpalog(dwConsolpalog);
			dwConsolpalogtec.setOmUsr(omUsr);
			dwConsolpalogtec.setIdConsolpalogtec(null);
			
			dwConsolpalogtec.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TEC2.getValue());
			
			getDao().makePersistent(dwConsolpalogtec);
		}

		if (msEvt.getCdTecresp() != null && msEvt.getCdTecresp().trim().equals("") == false) {
			OmUsr omUsr = usuarioRN.getOmUsr(msEvt.getCdTecresp());

			DwConsolpalogtec dwConsolpalogtec = new DwConsolpalogtec();
			dwConsolpalogtec.setDwConsolpalog(dwConsolpalog);
			dwConsolpalogtec.setOmUsr(omUsr);
			dwConsolpalogtec.setIdConsolpalogtec(null);
			
			dwConsolpalogtec.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TECRESP.getValue());
			
			getDao().makePersistent(dwConsolpalogtec);
		}
	
	}

	private void guardaTecnico(Map<Long, OmUsr> tecnicosParada, String cdTec, String log) throws RegistroDesconhecidoException {
		if(cdTec != null && !cdTec.isEmpty()) {
			OmUsr omUsrTec = getOmUsrTecnico(cdTec, log);
			if(omUsrTec != null){
				tecnicosParada.put(omUsrTec.getIdUsr(), omUsrTec);
			}
		}
	}

	private OmUsr getOmUsrTecnico(String cdTec, String strTec) throws RegistroDesconhecidoException {
		OmUsr omUsrTec = null;
		if(cdTec != null && !cdTec.isEmpty()){
			try {
				UsuarioRN usuarioRN = new UsuarioRN();
				usuarioRN.setDaoSession(this.getDao().getSession());
				omUsrTec = usuarioRN.getOmUsr(cdTec);
			} catch (RegistroDesconhecidoException e) {
				throw new RegistroDesconhecidoException(strTec + " nao encontrado. Usuario:" + cdTec);
			}
		}
		return omUsrTec;
	}

	private DwTJust getDwTJust(OmPt omPt, String cdJust) throws RegistroDesconhecidoException {
		DwTJust dwTJust = null;
		if(cdJust != null && !cdJust.isEmpty()){
			try {
				JustificativaRN justRN = new JustificativaRN();
				justRN.setDaoSession(this.getDao().getSession());
				dwTJust = justRN.getDwTJust(cdJust, omPt.getOmTppt());
			} catch (RegistroDesconhecidoException e) {
				throw new RegistroDesconhecidoException("Justificava não encontrada. Justificativa:" + cdJust + " idOmTppt:" + omPt.getOmTppt().getIdTppt());
			}
		}
		return dwTJust;
	}

	private DwTAcao getDwTAcao(OmPt omPt, String cdAcao) throws RegistroDesconhecidoException {
		DwTAcao dwTAcao = null;
		if(cdAcao != null && cdAcao.isEmpty() == false){
			try {
				AcaoRN acaoRN = new AcaoRN();
				acaoRN.setDaoSession(this.getDao().getSession());
				dwTAcao = acaoRN.getDwTAcao(cdAcao, omPt.getOmTppt());
			} catch (RegistroDesconhecidoException e) {
				throw new RegistroDesconhecidoException("Acao nao encontrada. Acao:" + cdAcao + " idOmTppt:" + omPt.getOmTppt().getIdTppt());
			}
		}
		return dwTAcao;
	}

	private DwTCausa getDwTCausa(OmPt omPt, String cdCausa) throws RegistroDesconhecidoException {
		DwTCausa dwTCausa = null;
		if(cdCausa != null && !cdCausa.isEmpty()){
			try {
				CausaRN causaRN = new CausaRN();
				causaRN.setDaoSession(this.getDao().getSession());
				dwTCausa = causaRN.getDwTCausa(cdCausa, omPt.getOmTppt());
			} catch (RegistroDesconhecidoException e) {
				throw new RegistroDesconhecidoException("Causa não encontrada. Causa:" + cdCausa + " idOmTppt:" + omPt.getOmTppt().getIdTppt());
			}
		}
		return dwTCausa;
	}

	private DwConsolpalog getDwConsolpalog(OmPt omPt, MsEvt msEvt, IdwLogger log) throws EventoInvalidoException {
		Date dtHrInicioParada = msEvt.getDthrEventoanterior();
		
		if (dtHrInicioParada == null) {
			log.info(TAG + " dtHrInicioParada == null, irá buscar a última parada máquina");
		}
		DwConsolpalog dwConsolpalog = this.obtemDwConsolpalog(omPt.getIdPt(), dtHrInicioParada);

		/*
		 * Caso não encontre, tentará usar a última parada da máquina.
		 * Este tratamento será temporário até que o uso da data/hora de início de parada, 
		 * para buscar a parada que será corrigida, se mostre estável.
		 * Esta busca era feita sempre pegando a última parada da máquina, não importando se era a correta,
		 * e não foi uma abordagem correta, e acabou entrando por um descuido.
		 * TODO remover trecho que busca parada apenas pela ultima da maquina, assim que o uso da data/hora 
		 * de inicio de parada se mostre est 
		 */
		if (dtHrInicioParada != null && dwConsolpalog == null) {
			log.info(TAG + " Parada não encontrada com inicio " + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dtHrInicioParada));
			dwConsolpalog = this.obtemDwConsolpalog(omPt.getIdPt(), null);
		}
		
		if (dwConsolpalog == null) {
			throw new EventoInvalidoException(msEvt, TAG + " Não foi encontrada última parada para a máquina");
		}
		log.info(TAG + " sera utilizada a parada " +  DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolpalog.getDthrIparada()));

		return dwConsolpalog;
	}
	
}
