package idw.model.rn.consolidacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.commons.lang3.math.NumberUtils;

import idw.model.pojos.OmPt;
import idw.model.rn.PTRN;
import idw.protocolomap.ProtocoloMapFacade;
import idw.util.IdwLogger;
import ms.coleta.tcp.UtilsTcp;
import ms.util.UtilsThreads;

/**
 * Controla a execução das threads de consolidação dos postos de trabalho
 *
 * @author Milton Siqueira
 * @see ConsolidacaoMsEvtPt
 * @see ConsolidacaoMsEvtPtEvento
 */
public final class ControleConsolidacaoMsEvt {

	private static final int TIMEOUT_TERMINATION_THREADS_CONSOLIDACAO = 5;
	public static final int DEFAULT_EVENTOS_PARA_PROCESSAR = 50;
	public static final int MAX_EVENTOS_PARA_PROCESSAR = 2000;
	public static final int MIN_EVENTOS_PARA_PROCESSAR = 1;

	public static final int DEFAULT_THREADS_POOL_PT = 10;
	public static final int MAX_THREADS_POOL_PT = 50;
	public static final int MIN_THREADS_POOL_PT = 1;

	private final int qtThreadsPt;
	private final int qtEventosParaProcessar;

	public static final long DELAY_FIM_CONSOLIDACAO_PT_MILISEG = 100;
	public static final long DELAY_FIM_TRATAMENTO_CADA_EVENTO_MILISEG = 50;

	private static final int DELAY_ANTES_INICIAR_THREAD_PT_MILISEG = 20;
	private static final int DELAY_A_CADA_EXECUCAO_MILISEG = 200;
	private static final int DELAY_ANTES_ADICIONAR_THREADS_PT_MILISEG = 5000;
	private static final int DELAY_ADICIONAR_THREADS_PT_MILISEG = 60000;

	private static final String CONSOLIDACAO_THREAD_NAME_PATTERN = "ConsolidacaoPT-%d";
	private static final String LISTA_PTS_THREAD_NAME_PATTERN = "ListarPtParaThreadConsolidacao-%d";

	private final ScheduledExecutorService poolListarPts = Executors.newSingleThreadScheduledExecutor(
			new BasicThreadFactory.Builder()
					.namingPattern(LISTA_PTS_THREAD_NAME_PATTERN)
					.build());

	private final ScheduledExecutorService poolConsolidarMsEvt;

	private final Map<String, ScheduledFuture<?>> threadsPt = new HashMap<String, ScheduledFuture<?>>();

	private final IdwLogger log = new IdwLogger("ControleConsolidacaoMsEvt");

	public ControleConsolidacaoMsEvt(String strQtThreadsPt, String strQtEventosParaProcessar) {
		this(NumberUtils.toInt(strQtThreadsPt, DEFAULT_THREADS_POOL_PT),
				NumberUtils.toInt(strQtEventosParaProcessar, DEFAULT_EVENTOS_PARA_PROCESSAR));
	}

	public ControleConsolidacaoMsEvt(int qtThreadsPt, int qtEventosParaProcessar) {

		this.qtThreadsPt = getValorValidoQtThreadsPt(qtThreadsPt);
		this.qtEventosParaProcessar = getValorValidoQtEventosParaProcessar(qtEventosParaProcessar);

		log.info(getClass().getSimpleName() + " criado com qtThreadsPt=" + this.qtThreadsPt + " e qtEventosParadaProcessar="
				+ this.qtEventosParaProcessar);

		poolConsolidarMsEvt = Executors.newScheduledThreadPool(
				this.qtThreadsPt,
				new BasicThreadFactory.Builder().namingPattern(CONSOLIDACAO_THREAD_NAME_PATTERN).build());
	}

	private int getValorValidoQtEventosParaProcessar(int qtEventosParaProcessar) {
		if (qtEventosParaProcessar < MIN_EVENTOS_PARA_PROCESSAR) {
			qtEventosParaProcessar = MIN_EVENTOS_PARA_PROCESSAR;
		} else if (qtEventosParaProcessar > MAX_EVENTOS_PARA_PROCESSAR) {
			qtEventosParaProcessar = MAX_EVENTOS_PARA_PROCESSAR;
		}
		return qtEventosParaProcessar;
	}

	private int getValorValidoQtThreadsPt(int qtThreadsPt) {
		if (qtThreadsPt < MIN_THREADS_POOL_PT) {
			return MIN_THREADS_POOL_PT;
		} else if (qtThreadsPt > MAX_THREADS_POOL_PT) {
			return MAX_THREADS_POOL_PT;
		}
		return qtThreadsPt;
	}

	public int getQtEventosParaProcessar() {
		return qtEventosParaProcessar;
	}

	public int getQtThreadsPt() {
		return qtThreadsPt;
	}

	private Runnable adicionarThreadConsolidacaoDosPts = new Runnable() {

		@Override
		public void run() {
			PTRN ptRN = new PTRN();
			try {
				ptRN.iniciaConexaoBanco();

				/*
				 * Alessandre em 06-10-21 o trecho abaixo foi comentado String cdMs =
				 * Stubedelegate.getInstancia().getMsthread().getMsdto().getCd_ms(); List<OmPt> pts =
				 * ptRN.pesquisarPtStAtivoComMsUpByCdMs(cdMs);
				 */
				List<Object> ups = ProtocoloMapFacade.getInstancia().pesquisarUps(UtilsTcp.getMACAddress());

				// Se nao existir ups para o ms, entao sair sem fazer nada
				if (ups != null && !ups.isEmpty()) {
					List<OmPt> pts = ptRN.pesquisarPtStAtivoComCds(ups);

					// Varre a lista de PTs e acrescenta as threds que nao existem no pool
					for (OmPt item : pts) {

						if (threadsPt.containsKey(item.getCdPt()) == false) {

							OmPt omPt = new OmPt();
							omPt.setId(item.getIdPt());
							omPt.setCdPt(item.getCdPt());
							Runnable consolidacaoMsEvtPt = new ConsolidacaoMsEvtPt(omPt, qtEventosParaProcessar);

							ScheduledFuture<?> tarefaSchedulada = addThreadNoPoolDeThreads(consolidacaoMsEvtPt);

							threadsPt.put(omPt.getCdPt(), tarefaSchedulada);

							log.info("Thread de consolidacao para o PT  " + omPt.getCdPt() + " criada.");

						}

						UtilsThreads.pausaNaThread(2l);

					}

					// Apos acrescentar as novas threads, varre as thread para averiguar se alguma foi desativada, se sim, parar a thread
					Iterator<String> icdpt = threadsPt.keySet().iterator();
					while (icdpt.hasNext()) {
						String cdpt = icdpt.next();
						boolean isExiste = false;
						for (OmPt ompt : pts) {
							if (ompt.getCdPt().equals(cdpt))
								isExiste = true;
						}
						if (isExiste == false) {
							// Obtem o ScheduledFuture
							ScheduledFuture<?> tarefaAgendada = threadsPt.get(cdpt);
							tarefaAgendada.cancel(true);

							// remove a execucao da thread
							icdpt.remove();
							log.info("Removendo consolidação do pt " + cdpt);
						}
					}
				} else {
					log.info("sem ups para o ms");
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Erro ao tentar adicionar threads de consolidacao do PT", e);
			} finally {
				try {
					ptRN.finalizaConexaoBanco();
				} catch (Exception e) {
					log.info("Erro tentar finalizar a conexão", e);
				}
			}
			log.info("Finalizou avaliação");
		}
	};

	public void iniciar() {
		poolListarPts.scheduleWithFixedDelay(adicionarThreadConsolidacaoDosPts, DELAY_ANTES_ADICIONAR_THREADS_PT_MILISEG,
				DELAY_ADICIONAR_THREADS_PT_MILISEG, TimeUnit.MILLISECONDS);
	}

	private ScheduledFuture<?> addThreadNoPoolDeThreads(Runnable runnable) {
		return poolConsolidarMsEvt.scheduleWithFixedDelay(runnable, DELAY_ANTES_INICIAR_THREAD_PT_MILISEG, DELAY_A_CADA_EXECUCAO_MILISEG,
				TimeUnit.MILLISECONDS);
	}

	public void finalizar() throws InterruptedException {
		poolListarPts.shutdownNow();
		log.info("Interrompe pool da thread de adicionar threads de consolidacao de PT");
		poolConsolidarMsEvt.shutdownNow();
		log.info("Interrompe pool de threads de consolidacao de PT");

		// Timeout para finalização das threads
		poolConsolidarMsEvt.awaitTermination(TIMEOUT_TERMINATION_THREADS_CONSOLIDACAO, TimeUnit.SECONDS);

	}
}
