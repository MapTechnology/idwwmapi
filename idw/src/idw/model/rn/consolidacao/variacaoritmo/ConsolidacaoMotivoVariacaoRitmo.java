package idw.model.rn.consolidacao.variacaoritmo;

import java.util.List;

import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolvaritmolog;
import idw.model.pojos.DwConsolvaritmologcau;
import idw.model.pojos.DwConsolvaritmooco;
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.rn.DataHoraRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoMotivoVariacaoRitmo extends ConsolidacaoFimVariacaoRitmo implements IConsolidacao {

	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt,
			OmCfg omcfg, IdwLogger log, int idLog, int identacao)
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException,
					RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException,
					NumeroSerieIrregularException, CicloJaContabilizadoException {
		
		// Encontra usuario logado no momento no pt
		List<DwConsolmolog> mologs = getDwConsolmologComLoginAbertoByCdUp(omPt.getCdPt());
		
		OmUsr omusr = null;

		if (mologs != null) {
			for (DwConsolmolog molog : mologs) {
				omusr = molog.getOmUsr();
			}
		}

		// Encontra o dwTritmo
		DwTRitmo dwtritmoNovo = pesquisarDwTRitmo(omPt, msEvt.getCdJustificativa());
		DwTRitmo dwtritmoAnterior = null;

		
		// Pesquisar DwConsolVaritmolog
		List<DwConsolvaritmolog> logs = pesquisarDwConsolvaritmologEmAberto(omPt);
		
		/* Se existir log em aberto entao gerar em dw_consolpalogcau e sair sem fazer mais nada,pq a consolidacao do fim ritmo q ir� ocnsolidar final
		 *  
		 */
		if (logs != null && logs.size() > 0) {
			incluirCausa(logs, msEvt, omusr, dwtritmoNovo);
			return;
		}
		

		DwConsolvaritmolog varlog = pesquisarDwConsolvaritmologFechada(omPt);
		// Se nao tiver nenhum log, retornar
		if (varlog == null)
			return;
		

		
		/*
		 * Como o ritmo est� fechado, devemos no trecho abaixo alterar a ultima causa informada para a causa corrente
		 */
		DwConsolvaritmologcau ultCau = null;
		for (DwConsolvaritmologcau causa : varlog.getDwConsolvaritmologcaus()) {
			if (ultCau == null)
				ultCau = causa;
			else if (DataHoraRN.after(causa.getDthrVaritmo(), ultCau.getDthrVaritmo()))
				ultCau = causa;
		}
		if (ultCau != null) {
			dwtritmoAnterior = ultCau.getDwTRitmo();
			ultCau.setDwTRitmo(dwtritmoNovo);
			getDao().makePersistent(ultCau);
		}
		

		/*
		 * Modificar dwConsolvaritmo e DwConsolVaritmoCau considerando o novo codigo de de ritmo informado.
		 */
		// verificar se o novo motivo ja existe nos filhos de dwConsolid.dwConsol.dwConsolvaritmos
		// se existir transferir a ocorrencia para o motivo em questao
		// se nao existir, simplesmente modificar o registro para o novo motivo
		for (DwConsolvaritmooco oco : varlog.getDwConsolvaritmoocos()) {
			if (oco.getDwConsolvaritmo().getDwTRitmo().getCdTritmo().equals(dwtritmoAnterior.getCdTritmo())) {
				oco.getDwConsolvaritmo().setDwTRitmo(dwtritmoNovo);
				getDao().makePersistent(oco.getDwConsolvaritmo());
			}
		}
	}

	/*
	 * O objetivo desse metodo � incluir no pojo dw_consolvaritmologcau pois o ritmo ainda esta em aberto
	 */
	private void incluirCausa(List<DwConsolvaritmolog> logs, MsEvt msevt, OmUsr omusr, DwTRitmo dwtritmo) {
		for (DwConsolvaritmolog log : logs) {
			DwConsolvaritmologcau causa = new DwConsolvaritmologcau();
			causa.setDwConsolvaritmolog(log);
			causa.setDwTRitmo(dwtritmo);
			causa.setIdConsolvartimologcau(null);
			causa.setOmUsr(omusr);
			causa.setDthrVaritmo(msevt.getDthrEvento());
	
			getDao().makePersistent(causa);
		}		
	}
	

}
