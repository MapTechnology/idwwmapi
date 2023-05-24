package idw.model.rn.consolidacao.planejamento;

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
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolsplog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;
import ms.model.rn.UpRN;

public class ConsolidacaoInicioPlanejamento extends ConsolidaRN implements IConsolidacao {

	@Override
	public void executarConsolidacao(
			OmPt omPt, 
			DwConsolpt dwconsolpt,
			List<DwCalsem> dwCalsems, 
			MsEvt msEvt, 
			OmCfg omcfg, 
			IdwLogger log,
			int idLog, 
			int identacao) 
					
					throws 
			
			SemCalendarioException,
			SemSGBDException, SemCicloPadraoException,
			SemPlanejamentoException, RegistroDesconhecidoException,
			EventoInvalidoException, ReprocessarMsEvtException,
			NumeroSerieIrregularException, CicloJaContabilizadoException {
		
		
		// Para o IDW carregar a OP significa setar em ompt.setIsSemop como false e em msup.nrop a op escolhida
		omPt.setIsSemop(false);
		getDao().makePersistent(omPt);
		
		UpRN uprn = new UpRN(getDao(), null);
		MsUp msup;
		try {
			msup = uprn.pesquisarMsUpPorCdUpStAtivo(omPt.getCdPt());
		} catch (injetws.model.excessoes.RegistroDesconhecidoException e1) {
			throw new SemPlanejamentoException();
		}
		msup.setNrop(msEvt.getNrop());
		getDao().makePersistent(msup);
		
		// O trecho abaixo foi incluido para mudar o status para inicia da OP que entrar em coletor
		// Localiza a op
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		ppCp.setStCp(PpCpTemplate.StCp.INICIADA.getValue());
		ppCp.setDthrFinalreal(null);
		ppCp.mudarDthrIniciorealIfNull(msEvt.getDthrEvento());
		getDao().makePersistent(ppCp);
		
		/* Atualiza entrada da op em omptcp
		 * 
		 */
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmPtcp a");
		q.append("where a.omPt = :ompt");
		q.append("and a.ppCp = :ppcp");
		
		q.defineParametro("ompt", omPt);
		q.defineParametro("ppcp", ppCp);
		
		OmPtcp omptcp = (OmPtcp) q.uniqueResult();
		if (omptcp == null) {
			omptcp = new OmPtcp();
			omptcp.setOmPt(omPt);
			omptcp.setPpCp(ppCp);
			omptcp.setQtCiclos(0);
			omptcp.setQtCiclosregulagem(0);
		}
		omptcp.setDthrEntrada(msEvt.getDthrEvento());
		getDao().makePersistent(omptcp);
		
		ConsolidacaoPlanejamento consolidacaoPlanejamento = new ConsolidacaoPlanejamento(getDao());
		consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, msEvt.getDthrEvento());
		
		// Pega a folha ativa
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		final DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");
		
		// Devemos tambem inserir em dwconsolid senao da erro na ficha da maquina
		DwConsolid id = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, msEvt.getDthrEvento(), omcfg, msEvt.getDwPepro());

		
		// Seta real-time com SEM PLANEJAMENTO
		DwRt dwrt = id.getDwRt();
		if (omPt.getMsPtColeta() != null && omPt.getMsPtColeta().getIsParada() != null && omPt.getMsPtColeta().getIsParada())
			dwrt.setStFuncionamento(DwRtTemplate.StFuncionamento.PARADA.getId());
		else
			dwrt.setStFuncionamento(DwRtTemplate.StFuncionamento.PRODUZINDO.getId());
		
		dwrt.setIsSemplanejamento(false);
		
		TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwrt, msEvt.getDthrEvento());
		
		getDao().makePersistent(dwrt);
		
		// Obter tambe o id para acumulado e hora a fim de nao dar erro nos graficos de e qdo a ficha mudar para op ou acumulado
		this.obtemConsolIdAcumulado(omPt, dwCalsems, ppCp, dwFolha, msEvt.getDthrEvento());
		this.obtemConsolIdHora(omPt, dwCalsems, ppCp, dwFolha, msEvt.getDthrEvento(), omcfg, msEvt.getDwPepro());
		
		/*
		 * Localizar o registro de periodos sem planejamento e atualizar com a data final
		 * 
		 */
		DwConsolsplog splog = pesquisarDwConsolsplogEmAberto(omPt);
		if (splog != null) {
			splog.setDthrFim(msEvt.getDthrEvento());
		}
	}

	private DwConsolsplog pesquisarDwConsolsplogEmAberto(OmPt omPt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolsplog a");
		q.append("where a.omPt = :ompt");
		q.append("order by a.idConsolsplog desc");
		
		q.setMaxResults(1);
		q.defineParametro("ompt", omPt);
		
		return (DwConsolsplog) q.uniqueResult();
	}
}
