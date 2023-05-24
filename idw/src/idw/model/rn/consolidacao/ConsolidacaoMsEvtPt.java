package idw.model.rn.consolidacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
import org.hibernate.exception.LockAcquisitionException;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MsEvtDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.pojos.template.MsEvtTemplate.StEvt;
import idw.model.pojos.template.MsEvtTemplate.TpProcessado;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.consolidacao.parada.ConsolidacaoParadaAberta;
import idw.protocolomap.ProtocoloMapFacade;
import idw.util.IdwLogger;
import ms.util.UtilsThreads;

/**
 *
 * @author Milton Siqueira
 *
 */
final class ConsolidacaoMsEvtPt implements Runnable {

	private static final int TOTAL_EVT_PENDENTES_PARA_PR_ST_CONSOLIDANDO = 30;
	private static final int IDENTENCAO_LOG = 0;
	private final OmPt detachedOmPt;
	private final IdwLogger log;
	private int idLog;
	private final int qtEventosParaProcessar;
	private final String cdPt;

	ConsolidacaoMsEvtPt(OmPt omPt, int qtEventosParaProcessar) {
		super();
		this.detachedOmPt = omPt;
		this.cdPt = omPt.getCdPt();
		this.log = new IdwLogger("Consolidacao" + cdPt);
		this.idLog = log.getIdAleatorio();
		this.qtEventosParaProcessar = qtEventosParaProcessar;
	}

	@Override
	public void run() {

		try {

			final DAOGenerico dao = new DAOGenerico();

			try {

				dao.iniciaSessao();

				List<Long> idsEvts = getEventosPendentesProcessamentoMarcandoPtIsConsolPendente(dao, cdPt);

				ConsolidacaoMsEvtPtEvento consolidacaoMsEvtPtEvento = new ConsolidacaoMsEvtPtEvento(dao, this.log);

				int totalEventosParaProcessar = idsEvts.size();
				int sequencialEvento = 0;

				for (Long idEvt : idsEvts) {

					tratarEventoPendenteProcessamento(
							dao, idEvt, consolidacaoMsEvtPtEvento,
							totalEventosParaProcessar, sequencialEvento);
					
					UtilsThreads.pausaNaThread(2l);

				}

				ConsolidacaoParadaAberta consolidacaoParadaAberta = new ConsolidacaoParadaAberta(dao, this.cdPt);
				consolidacaoParadaAberta.consolidar();

			} finally {
				dao.finalizaSessao();
			}

			UtilsThreads.pausaNaThread(ControleConsolidacaoMsEvt.DELAY_FIM_CONSOLIDACAO_PT_MILISEG);

		} catch (Exception e) {
			// Exception para não deixar vazar excessão fora da thread.
			// Se ela fosse vazada para fora, ela passaria a ser ignorada pelo seu pool de threads.
			// leia em javadoc
			// {@link ScheduledExecutorService#scheduleWithFixedDelay(Runnable, long, long, java.util.concurrent.TimeUnit)}
			if (e.getMessage().contains("Qtde do pacote") || e.getMessage().contains("Evento inválido")) {
				log.info(e.getMessage());
			} else
				e.printStackTrace();
		}

	}

	private void tratarEventoPendenteProcessamento(
			final DAOGenerico dao, Long idEvt, ConsolidacaoMsEvtPtEvento consolidacaoMsEvtPtEvento,
			int totalEventosParaProcessar, int sequencialEvento) throws InterruptedException {
		Date dthriprocessaserver = DataHoraRN.getDataHoraAtual();

		try {
			log.iniciaAvaliacao("RESUMO FINAL:");

			Transaction tx = null;

			try {

				tx = dao.getSession().beginTransaction();

				/* Alessandre em 06-10-21 comentei o trecho abaixo para substitui pela chamada do ProtocoloMap
				MsEvtDAO msEvtDAO = new MsEvtDAO(dao.getSession());
				MsEvt msEvt = msEvtDAO.getMsEvt(idEvt);
				*/
				MsEvt msEvt = ProtocoloMapFacade.getInstancia().pesquisarMsEvt(idEvt, dao);
				
				idLog = log.getIdAleatorio(); // Assim cada evento tera um id aleatorio no log

				log.info(idLog, IDENTENCAO_LOG, "Processando o evento " + msEvt.getMsTpevt().getDsTpevt() + ": " + msEvt.getIdEvt() + " para pt " + cdPt);

				OmPt omPt = getOmPt(dao);

				TpProcessado tpProcessado = consolidacaoMsEvtPtEvento.consolidarMsEvt(msEvt, omPt, idLog, 5);

				// Alessandre em 06-10-21 a linha abaixo foi comentada por causa do ProtocoloMap e substituido pelo chamado de REST
				//msEvt.setResultadoProcessamento(tpProcessado.getStEvt(), dthriprocessaserver, DataHoraRN.getDataHoraAtual(), null);
				
				ProtocoloMapFacade.getInstancia().setResultadoProcessamento(idEvt, tpProcessado.getStEvt(), dthriprocessaserver, DataHoraRN.getDataHoraAtual(), null, dao);
				

				log.info(idLog, IDENTENCAO_LOG, "FIM Processando - Vou comitar para " + msEvt.getMsTpevt().getDsTpevt() + ": " + msEvt.getIdEvt() + " para pt " + cdPt);

				tx.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					log.info(idLog, IDENTENCAO_LOG, "Rollback devido " + e.getMessage());
					tx.rollback();
				}
				throw e; // Esse throw deve enviar para o catch abaixo

			} finally {
				dao.clear();
			}

		} catch (ReprocessarMsEvtException | LockAcquisitionException | StaleStateException e) {
			// Esse catch visa capturar algumas excessoes que caso ocorram nao podem marcar o msevt como processado ou rejeitado
			// ou seja, o msevt deve ser reprocessado na proxima tentativa
			// StaleStateException ocorre quando, por exemplo, se tentou fazer um update e o registro nao existe mais
			log.info(idLog, IDENTENCAO_LOG, "Evento de id " + idEvt + " devera ser reprocessado. Consolidacao interrompida.");
			throw new RuntimeException(e);

		} catch (Exception e) {
			// Alessandre em 24-03-17 comentei a linha abaixo para evitar
			// o crescimento exagerado do log do tomcat.
			// Substitui pela linha seguinte e.printStackTrace();
			if (e instanceof SemCicloPadraoException || (e != null && e.getMessage() != null && e.getMessage().contains("Evento"))) {
				log.info(idLog, IDENTENCAO_LOG, "trataEventoPendente: " + e.getMessage());
			} else {
				e.printStackTrace();
				log.info(idLog, IDENTENCAO_LOG, "Exception:", e);
			}

			String errorMsg = null;
			if (e instanceof EventoInvalidoException) {
				errorMsg = ((EventoInvalidoException) e).getMsgAux();
			} else {
				errorMsg = e.getMessage();
			}
			
			// Alessandre comentei a linha abaixo em 06-10-21 por causa do protocolo MAP
//			setMsEvt(idEvt, StEvt.REJEITADO, dthriprocessaserver, dao, errorMsg);
			
			ProtocoloMapFacade.getInstancia().setResultadoProcessamento(idEvt, StEvt.REJEITADO, dthriprocessaserver, DataHoraRN.getDataHoraAtual(), errorMsg, dao);
			
			

			log.info(idLog, IDENTENCAO_LOG, idEvt + " Evento rejeitado. ", e);

		} finally {

			sequencialEvento++;
			log.mostrarAvaliacaoCompleta(idLog, IDENTENCAO_LOG);
		}
		
		// Mesmo usando o shutdownNow no pool de threads, ela permanecia ativa até terminar de processar toda a lista
		if (Thread.currentThread().isInterrupted()) {
			throw new InterruptedException();
		}

		UtilsThreads.pausaNaThread(ControleConsolidacaoMsEvt.DELAY_FIM_TRATAMENTO_CADA_EVENTO_MILISEG);

	}

	private List<Long> getEventosPendentesProcessamentoMarcandoPtIsConsolPendente(DAOGenerico dao, String cdUp) {
		Transaction tx = null;

		try {

			tx = dao.getSession().beginTransaction();

			/* Alessandre em 06-10-21 comentei o trecho abaixo pois o metodo ja recebe o valor cdUp
			String cdUp = null;
			UpRN uprn = new UpRN(dao, null);
			try {
				MsUp msup = uprn.pesquisarMsUpPorCdUpStAtivo(detachedOmPt.getCdPt());
				cdUp = msup.getCdUp();
			} catch (injetws.model.excessoes.RegistroDesconhecidoException e) {
				throw new RuntimeException("Não encontrou MsUP ativo para cdPt=" + detachedOmPt.getCdPt());
			} */

			try {
				marcarPtIsConsolPendente(cdUp, dao);
			} catch (ReprocessarMsEvtException e) {
				log.info(idLog, IDENTENCAO_LOG, "Evento deverá ser reprocessado."
						+ " Consolidação interrompida. " + e.getMessage());
				throw new RuntimeException(e);
			}

			/* Alessandre em 06-10-21 comentei o trecho abaixo para entrar a chamada do ProtocoloMap
			MsEvtDAO msEvtDAO = new MsEvtDAO(dao.getSession());
			List<Long> idsEvts = msEvtDAO.getIdsEventosPendentesProcessamento(cdUp, qtEventosParaProcessar);
			 */
			List<Long> idsEvts = ProtocoloMapFacade.getInstancia().getIdsEventosPendentesProcessamento(cdUp, qtEventosParaProcessar, dao);
			
			tx.commit();

			return idsEvts;

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			throw new RuntimeException(e);

		} finally {
			dao.clear();
		}

	}

	private void setMsEvt(Long idEvt, MsEvtTemplate.StEvt stEvt, Date dthriprocessaserver, DAOGenerico dao, String messageErro) {
		Transaction tx = null;

		try {

			tx = dao.getSession().beginTransaction();

			MsEvtDAO msEvtDAO = new MsEvtDAO(dao.getSession());
			
			msEvtDAO.setStEvt(idEvt, stEvt, dthriprocessaserver, messageErro);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			dao.clear();
		}
	}

	private OmPt getOmPt(DAOGenerico dao) throws ReprocessarMsEvtException {
		OmPt omPt = null;
		try {
			PTRN ptRN = new PTRN(dao);
			omPt = ptRN.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			throw new ReprocessarMsEvtException("Não encontrou cdPt=" + cdPt + " ativo");
		}
		return omPt;
	}

	private void marcarPtIsConsolPendente(String cdUP, DAOGenerico dao) throws ReprocessarMsEvtException {
		OmPt omPt = getOmPt(dao);
		MsEvtDAO msEvtDAO = new MsEvtDAO(dao.getSession());
		long totalEventos = msEvtDAO.totalEventosPendentesProcessamento(dao.getSession(), cdUP);
		omPt.setIsConsolpendente(isPtConsolidando(totalEventos));
		if (omPt.getIsConsolpendente()) {
			log.info("Pt " + omPt.getCdPt() + " com muitos eventos para processar, marcado como 'pendente consolidação'."
					+ " Total eventos pendentes: " + totalEventos + "."
					+ " Processa a cada " + qtEventosParaProcessar + " eventos");
		}
	}

	private boolean isPtConsolidando(long totalEventos) {
		return totalEventos >= TOTAL_EVT_PENDENTES_PARA_PR_ST_CONSOLIDANDO;
	}

	// Metodo para debugar eventos especificos
	public static void main(String[] args) {
		IdwLogger log = new IdwLogger("teste");

		try {

			final DAOGenerico dao = new DAOGenerico();

			try {

				try {

					dao.iniciaSessao();

					OmPt ompt = dao.findById(OmPt.class, (long) 148, false);
					ConsolidacaoMsEvtPt rn = new ConsolidacaoMsEvtPt(ompt, 1);

					List<Long> idsEvts = new ArrayList<>();
					idsEvts.add((long) 402943);

					ConsolidacaoMsEvtPtEvento consolidacaoMsEvtPtEvento = new ConsolidacaoMsEvtPtEvento(dao, log);

					int totalEventosParaProcessar = idsEvts.size();
					int sequencialEvento = 0;

					for (Long idEvt : idsEvts) {

						rn.tratarEventoPendenteProcessamento(dao, idEvt, consolidacaoMsEvtPtEvento,
								totalEventosParaProcessar, sequencialEvento);

					}

				} finally {
					dao.finalizaSessao();
				}

				Thread.sleep(ControleConsolidacaoMsEvt.DELAY_FIM_CONSOLIDACAO_PT_MILISEG);

			} catch (InterruptedException e) {
				log.info("Thread " + Thread.currentThread().getName() + " interrompida");
			} catch (Exception e) {
				log.info(e);
			}

		} catch (Exception e) {

			// Exception para não deixar vazar excessão fora da thread.
			// Se ela fosse vazada para fora, ela passaria a ser ignorada pelo
			// seu pool de threads.
			// leia em javadoc {@link
			// ScheduledExecutorService#scheduleWithFixedDelay(Runnable, long,
			// long, java.util.concurrent.TimeUnit)}
			e.printStackTrace();

		}
	}

}
