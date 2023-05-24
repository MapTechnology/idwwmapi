package idw.model.rn.consolidacao.variacaoritmo;

import java.util.List;

import idw.model.dao.MapQuery;
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
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoInicioVariacaoRitmo extends ConsolidacaoMotivoVariacaoRitmo implements IConsolidacao {

	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt,
			OmCfg omcfg, IdwLogger log, int idLog, int identacao)
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException,
					RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException,
					NumeroSerieIrregularException, CicloJaContabilizadoException {

		// Antes de incluir verificar se ja nao existe
		DwConsolvaritmolog ritmolog = null;

		ritmolog = pesquisarDwConsolvaritmologUnicoEmAberto(omPt);
		
		// Inicializar DwConsolVaRitmoLog
		if (ritmolog == null) {
			ritmolog = new DwConsolvaritmolog();
			ritmolog.setDthrFvaritmo(null);
			ritmolog.setDthrIvaritmo(msEvt.getDthrEvento());
			ritmolog.setIdConsolvaritmolog(null);
			ritmolog.setOmPt(omPt);
			
			getDao().makePersistent(ritmolog);
			
			/* Lancar o motivo default */
			// Encontra o dwTritmo
			DwTRitmo dwtritmo = null;
			
			if (omcfg.getDwTRitmo() != null)
				dwtritmo = pesquisarDwTRitmo(omPt, omcfg.getDwTRitmo().getCdTritmo());
			else
				return;// sai sem incluir ua causa
			
			// Encontra usuario logado no momento no pt
			List<DwConsolmolog> mologs = getDwConsolmologComLoginAbertoByCdUp(omPt.getCdPt());
			
			OmUsr omusr = null;

			if (mologs != null) {
				for (DwConsolmolog molog : mologs) {
					omusr = molog.getOmUsr();
				}
			}
			
			DwConsolvaritmologcau causa = new DwConsolvaritmologcau();
			causa.setDwConsolvaritmolog(ritmolog);
			causa.setDwTRitmo(dwtritmo);
			causa.setIdConsolvartimologcau(null);
			causa.setOmUsr(omusr);
			causa.setDthrVaritmo(msEvt.getDthrEvento());

			getDao().makePersistent(causa);

		}
	}
	
	public DwConsolvaritmolog pesquisarDwConsolvaritmologUnicoEmAberto(OmPt ompt) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwConsolvaritmolog a");
		q.append("where a.omPt = :ompt");
		q.append("and a.dthrFvaritmo is null");
		
		q.defineParametro("ompt", ompt);
		q.setMaxResults(1);
		
		return (DwConsolvaritmolog) q.uniqueResult();
	}

}
