package idw.model.rn.consolidacao.cip;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.MapQuery;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolcipoco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.model.rn.consolidacao.parada.ConsolidacaoFimParada;
import idw.model.rn.consolidacao.parada.ConsolidacaoInicioParada;
import idw.util.IdwLogger;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimCIP extends ConsolidaRN implements IConsolidacao {

	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt,
			OmCfg omcfg, IdwLogger log, int idLog, int identacao)
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException,
					RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException,
					NumeroSerieIrregularException, CicloJaContabilizadoException {
				
		TempoRealRN trn = new TempoRealRN(getDao());
		// Obtem ultimo dwrt para o PT
		DwRt dwrt = trn.obtemDwRtParaHeartBeatSemClonarTurnoDTO(msEvt.getDthrEvento(), omPt, log, msEvt.getDwPepro());
		
		Validate.notNull(dwrt, "dwrt desconhecido");

		// Setar o dwrt a flag isCIP = true
		dwrt.setIsCip(false);
		getDao().makePersistent(dwrt);
		
		omPt.setIsCipAtivado(false);
		getDao().makePersistent(omPt);
		
		// Encontra usuario se o mesmo tiver sido passado
		UsuarioRN urn = new UsuarioRN(getDao());
		OmUsr omusr = null;
		if (msEvt.getCdTecresp() != null && msEvt.getCdTecresp().trim().equals("") == false)
			omusr = urn.getOmUsr(msEvt.getCdTecresp());

		if (omusr == null && msEvt.getLogin() != null && msEvt.getLogin().equals("") == false)
			omusr = urn.getOmUsr(msEvt.getLogin());
		
		// Fechar log em aberto
		DwConsolid dwconsolid = getUltimoDwConsolidTurnoDwRtPpCp(omPt.getIdPt());
		
		// Encontra a ultima parada anterior ao CIP
		DwConsolpalog palog = getUltimaParadaFromDwConsolpalog(omPt);
		
		
		
		/* Alessandre em 04-05-22 se tiver parada em aberto, fechar
		 * 
		 */
		boolean isParadaAberta = false; //caso não tratado NULL no retorno para palog, gera erro em finalizacao de OP por exemplo
		if (palog!=null) {
			isParadaAberta = palog.isAberta();}
		
		if (isParadaAberta) {
			ConsolidacaoFimParada frn = new ConsolidacaoFimParada(getDao());
			frn.executarConsolidacao(omPt, dwconsolpt, dwCalsems, msEvt, omcfg, log, idLog, identacao);
		}
		
		
		
		
		// Pesquisar CIP em aberto
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolciplog a");
		q.append("where a.dthrFcip is null");
		q.append("and a.omPt = :ompt");
		
		q.defineParametro("ompt", omPt);
		
		List<DwConsolciplog> lista = q.list();
		for (DwConsolciplog cip : lista) {
			cip.setDwConsolidByIdConsolidFim(dwconsolid);
			cip.setDthrFcip(msEvt.getDthrEvento());
			cip.setOmUsrByIdUsrSaida(omusr);
			cip.setDwConsolpalogByIdConsolpalogSaida(palog);
			getDao().makePersistent(cip);
		}
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");

		// consolidar em DwConsolCIPoco todos os periodos
		fecharCIPTurnos(lista, dwCalsems, omPt, ppCp, dwFolha, omcfg, msEvt.getDwPepro(), msEvt.getDthrEvento(), log, idLog, identacao);
		
		
		
		if(isParadaAberta) {
			/* Na precisa pois o msevt nao existe
			EventoRN ern = new EventoRN();
			ern.setDao(getDao());
			DwPepro dwPepro = ern.pesquisarDwPeproById(new BigDecimal(DwPeproTemplate.Type.NORMAL.getId()));
			msEvt.setDwPepro(dwPepro);*/
			ConsolidacaoInicioParada irn = new ConsolidacaoInicioParada(getDao());
			irn.executarConsolidacao(omPt, dwconsolpt, dwCalsems, msEvt, omcfg, log, idLog, identacao);
		}
	}
	
	private void fecharCIPTurnos(List<DwConsolciplog> cips, List<DwCalsem> dwCalsems, OmPt omPt, PpCp ppCp, 
			DwFolha dwFolha, OmCfg omcfg, DwPepro dwPepro, Date dthrFalerta, IdwLogger log, int idLog, int identacao) 
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		for (DwConsolciplog ciplog : cips) {
			TurnoRN turnoRN = new TurnoRN(getDao());

			// Pega os períodos com os turnos
			//List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.obtemTurnosPeriodo(omPt.getIdPt(), dwconsolallog.getDthrIalerta(), dwconsolallog.getDthrFalerta(), null, 0, 0, omcfg);
			List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, ciplog.getDthrIcip(), ciplog.getDthrFcip());
			for(TurnoAtualDTO turnoAtual: listaTurnoAtualDTO){
				Date dthrIRef = (DataHoraRN.before(ciplog.getDthrIcip(), turnoAtual.getDtHrITurnoComTolerancia()) ? turnoAtual.getDtHrITurnoComTolerancia() : ciplog.getDthrIcip());
				Date dthrFRef = (DataHoraRN.before(ciplog.getDthrFcip(), turnoAtual.getDtHrFTurnoComTolerancia()) ? ciplog.getDthrFcip() : turnoAtual.getDtHrFTurnoComTolerancia());

				boolean isUltimoPeriodo = (DataHoraRN.equals(dthrFRef, turnoAtual.getDtHrFTurnoComTolerancia()));
				log.info(idLog, identacao, "Ultimo periodo = " + isUltimoPeriodo + " dthrFRef = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFRef) + " dthrFTurnoComTolerancia=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(turnoAtual.getDtHrFTurnoComTolerancia()));

				DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, dthrIRef, omcfg, dwPepro);

				// Pega dwConsol
				DwConsol dwConsol = null;
				for(DwConsol item:dwConsolid.getDwConsols()){
					dwConsol = item;
					break;
				}

				// Atualiza dwConsolcipoco
				DwConsolcipoco oco = this.getDwConsolcipoco(dwConsol, dthrIRef);
				if(oco == null){
					oco = new DwConsolcipoco();
					oco.setIdConsolcipoco(null);
					oco.setDwConsol(dwConsol);
				}
				oco.setDwConsolciplog(ciplog);
				oco.setDthrIcip(dthrIRef);
				oco.setDthrFcip(dthrFRef);
				this.getDao().makePersistent(oco);
			}
		}
	}
	
	private DwConsolcipoco getDwConsolcipoco(DwConsol dwconsol, Date dthrRef) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolcipoco a");
		q.append("where a.dwConsol = :dwconsol");
		q.append("and a.dthrIcip = :dt");
		q.setMaxResults(1);
		q.defineParametro("dwconsol", dwconsol);
		q.defineParametro("dt", dthrRef);
		return (DwConsolcipoco) q.uniqueResult();
	}
}
