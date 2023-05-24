package idw.model.rn.consolidacao.planejamento;

import java.math.BigDecimal;
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
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolsplog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.model.rn.consolidacao.alerta.ConsolidacaoFimAlerta;
import idw.model.rn.consolidacao.cip.ConsolidacaoFimCIP;
import idw.model.rn.consolidacao.parada.ConsolidacaoFimParada;
import idw.model.rn.consolidacao.producao.ConsolidacaoProducao;
import idw.model.rn.consolidacao.variacaoritmo.ConsolidacaoFimVariacaoRitmo;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimPlanejamento extends ConsolidacaoProducao implements IConsolidacao {

	
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
			NumeroSerieIrregularException {
		
		
		Date dtHrFimPlanejamento = msEvt.getDthrEvento();

		Validate.notNull(omPt, "Posto de trablaho esta nulo");
		Validate.notNull(dtHrFimPlanejamento, "Inicio do ciclo esta nulo");

		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");

		
		/* Atualiza entrada da op em omptcp
		 * 
		 */
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmPtcp a");
		q.append("where a.omPt = :ompt");
		q.append("and a.ppCp = :ppcp");
		
		q.defineParametro("ompt", omPt);
		q.defineParametro("ppcp", omPt.getPpCp());
		
		OmPtcp omptcp = (OmPtcp) q.uniqueResult();
		if (omptcp == null) {
			omptcp = new OmPtcp();
			omptcp.setOmPt(omPt);
			omptcp.setPpCp(omPt.getPpCp());
			omptcp.setQtCiclos(0);
			omptcp.setQtCiclosregulagem(0);
		}
		omptcp.setDthrSaida(msEvt.getDthrEvento());
		getDao().makePersistent(omptcp);

		ConsolidacaoPlanejamento consolidacaoPlanejamento = new ConsolidacaoPlanejamento(getDao());
		consolidacaoPlanejamento.setFimPpCpentsai(omPt.getPpCp(), omPt, msEvt.getDthrEvento());
		
		// Se a configuracao marcar que o IHM troca op entao marcar o PT como sem OP, assim todos os eventos seguintes devem ficar fora
		boolean isIhmtrocaop = false;
		if (omPt.getOmTppt() != null && omPt.getOmTppt().getIsIhmtrocaop() != null)
			isIhmtrocaop = omPt.getOmTppt().getIsIhmtrocaop();
		else if (omcfg.getIsIhmtrocaop() != null)
			isIhmtrocaop = omcfg.getIsIhmtrocaop();
		
		if (isIhmtrocaop == true) {
			TempoRealRN trn = new TempoRealRN(getDao());

			// Seta real-time com SEM PLANEJAMENTO
			DwRt dwRt = trn.obtemDwRt(log, idLog, identacao, omPt, dwCalsems, omPt.getPpCp(), dtHrFimPlanejamento, null);
			
			// Salva stFuncionamento pois na squencia o Finalizar parada pode ser chamado e nao se pode perder a situacao da maquina
			// que será usada no momento da entrada da nova op que devera iniciar um ciclo ou uma parada ao entrar a op
			Byte stFuncionamento = dwRt.getStFuncionamento();
			
			TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwRt, dtHrFimPlanejamento);
			
			/* Finalizar parada em aberto
			 * 
			 */
			DwConsolpalog dwConsolpalog = null;
			FolhaRN folhaRN = new FolhaRN(this.getDao());
			DwFolha dwFolha = folhaRN.getDwFolhaAtiva(omPt.getPpCp());
			dwConsolpalog = this.getUltimaParadaFromDwConsolpalog(omPt);			
			if (dwConsolpalog != null && dwConsolpalog.isAberta()) {
				ConsolidacaoFimParada rn = new ConsolidacaoFimParada(getDao());
				rn.consolidarFimParada(omPt, dwconsolpt, omcfg, log, idLog, identacao, dtHrFimPlanejamento, dwConsolpalog);
				dwRt.setStFuncionamento(stFuncionamento);
				getDao().makePersistent(dwRt);
			}
			
			
			
			/*
			 * Finalizar o CIP em aberto
			 */
			ConsolidacaoFimCIP ciprn = new ConsolidacaoFimCIP();
			ciprn.setDao(getDao());
			try {
				ciprn.executarConsolidacao(omPt, dwconsolpt, dwCalsems, msEvt, omcfg, log, idLog, identacao);
			} catch (CicloJaContabilizadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			/* Finalinzar alertas em aberto
			 * 
			 */
			ConsolidacaoFimAlerta rn = new ConsolidacaoFimAlerta(getDao());
			rn.setDao(getDao());
			// Obter a lista de alertas em aberto
			List<DwConsolallog> dwConsolallogs = getDwConsolalComAlertaAberto(omPt);
			if (dwConsolallogs != null && dwConsolallogs.isEmpty() == false)
				rn.fecharAlertasTodosOsPeriodos(dwConsolallogs, dwCalsems, omPt, omPt.getPpCp(), dwFolha, omcfg, msEvt.getDwPepro(), dtHrFimPlanejamento, log, idLog, identacao);

			
			
			omPt.setIsSemop(true);
			// Alessandre em 27-10-16 comentei a linha abaixo pois o impacto de remover pode ser grande tem q ser revisto
			//omPt.setPpCp(null);
			getDao().makePersistent(omPt);
			
			
			
			/*
			 * Consolidacao fim variacao de ritmo
			 */
			ConsolidacaoFimVariacaoRitmo vrn = new ConsolidacaoFimVariacaoRitmo();
			vrn.setDao(getDao());
			try {
				vrn.executarConsolidacao(omPt, dwconsolpt, dwCalsems, msEvt, omcfg, log, idLog, identacao);
			} catch (CicloJaContabilizadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			/* Gerar um registro de inicio de periodo sem op
			 * 
			 */
			DwConsolsplog splog = new DwConsolsplog();
			splog.setDthrFim(null);
			splog.setDthrInicio(msEvt.getDthrEvento());
			splog.setIdConsolsplog(null);
			splog.setOmPt(omPt);
			
			getDao().makePersistent(splog);
			
			
			
			
			/* Mudar o status da OP para suspensa ou concluida conforme a quantidade de produtos que faltam ser produzidos 
			 * 
			 */
			PpCp ppcp = omPt.getPpCp();
			boolean isProducaoCumprida = true;
			for (PpCpproduto prod : ppcp.getPpCpprodutos()) {
				BigDecimal producao = prod.getPcsProducaobruta();
				if (producao == null)
					producao = BigDecimal.ZERO;
				if (prod.getPcsProducaorefugada() != null)
					producao = producao.subtract(prod.getPcsProducaorefugada());
				if (producao.intValue() < prod.getPcsProducaoplanejada().intValue())
					isProducaoCumprida = false;
			}
			if (isProducaoCumprida == false) {
				ppcp.setStCp(PpCpTemplate.StCp.SUSPENSA.getValue());
			} else {
				ppcp.setStCp(PpCpTemplate.StCp.CONCLUIDA.getValue());
			}
			ppcp.setDthrFinalreal(dtHrFimPlanejamento);
			getDao().makePersistent(ppcp);
			
			dwRt.setIsSemplanejamento(true);
			dwRt.setIsAlerta(false);
			
			this.getDao().makePersistent(dwRt);

		}
	}
}
