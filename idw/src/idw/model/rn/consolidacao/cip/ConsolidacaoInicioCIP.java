package idw.model.rn.consolidacao.cip;

import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoInicioCIP extends ConsolidaRN implements IConsolidacao {

	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt,
			OmCfg omcfg, IdwLogger log, int idLog, int identacao)
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException,
					RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException,
					NumeroSerieIrregularException, CicloJaContabilizadoException {

		log.info(idLog, identacao, "Consolidando Inicio de cip");
		
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		Validate.notNull(ppCp, "ppCp eh nulo");
		TempoRealRN trn = new TempoRealRN(getDao());

		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");
		
		/* Verifica se já existe um CIP em aberto
		 * 
		 */
		Validate.isTrue(!omPt.getIsCipAtivado(), "CIP ja aberto");

		// Pega ConsolId
		DwConsolid dwconsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, msEvt.getDthrEvento(), omcfg, msEvt.getDwPepro());
		
		DwRt dwRt = trn.obtemDwRtParaHeartBeatSemClonarTurnoDTO(msEvt.getDthrEvento(), omPt, log, msEvt.getDwPepro());
		dwRt.setIsCip(true);
		getDao().makePersistent(dwRt);
		
		
		omPt.setIsCipAtivado(true);
		getDao().makePersistent(omPt);

		// Encontra usuario se o mesmo tiver sido passado
		UsuarioRN urn = new UsuarioRN(getDao());
		OmUsr omusr = null;
		if (msEvt.getCdTecresp() != null && msEvt.getCdTecresp().trim().equals("") == false)
			omusr = urn.getOmUsr(msEvt.getCdTecresp());
		
		if (omusr == null && msEvt.getLogin() != null) {
			omusr = urn.getOmUsr(msEvt.getLogin());
		}
		// Encontra a ultima parada anterior ao CIP
		DwConsolpalog palog = getUltimaParadaFromDwConsolpalog(omPt);
		
		// Iniciar nova instancia em dw_consolciplog
		DwConsolciplog cip = new DwConsolciplog();
		cip.setDthrFcip(null);
		cip.setDthrIcip(msEvt.getDthrEvento());
		cip.setIdConsolciplog(null);
		cip.setOmPt(omPt);
		cip.setOmUsrByIdUsrEntrada(omusr);
		cip.setDwConsolidByIdConsolidInicio(dwconsolid);
		cip.setDwConsolpalogByIdConsolpalogEntrada(palog);
		getDao().makePersistent(cip);
		log.info(idLog, identacao, "incluindo dwconsolciplog id=" + cip.getIdConsolciplog());
	}

}
