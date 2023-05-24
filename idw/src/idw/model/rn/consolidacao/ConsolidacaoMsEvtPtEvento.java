package idw.model.rn.consolidacao;

import java.util.Date;
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.StaleStateException;
import org.hibernate.exception.LockAcquisitionException;
import org.hibernate.exception.SQLGrammarException;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolptDAO;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.excessoes.SemSessaoHibernateException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsTpevt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.pojos.template.MsEvtTemplate.TpProcessado;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import injetws.model.excessoes.SemSGBDException;

/**
 * 
 * @author Milton Siqueira
 *
 */
public class ConsolidacaoMsEvtPtEvento {

	private static final int LIMITE_DTHR_EVENTO_ACIMA_DTHR_ATUAL_EM_MINUTOS = 100;
	
	private final DAOGenerico dao;
	private final IdwLogger log;
	private final TurnoRN turnoRN;
	private final ConsolidaRN consolidaRN;

	public ConsolidacaoMsEvtPtEvento(DAOGenerico dao, IdwLogger log) {
		this.dao = dao;
		this.log = log;
		this.turnoRN = new TurnoRN(dao);
		this.consolidaRN = new ConsolidaRN(dao);
	}
	
	/**
	 * 
	 * @param msEvt
	 * @return {@link TpProcessado}
	 * @throws ReprocessarMsEvtException
	 * @throws EventoInvalidoException
	 */
	public MsEvtTemplate.TpProcessado consolidarMsEvt(MsEvt msEvt, OmPt omPt,  int idLog, int identacao) throws ReprocessarMsEvtException, EventoInvalidoException {

		try {

			validarDthrEvento(msEvt);
			
			OmCfg omCfg = Util.getConfigGeral(dao.getSession());
			if (omCfg == null) {
				throw new ReprocessarMsEvtException("OmCfg não encontrado");
			}

			List<DwCalsem> dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(omPt, msEvt.getDthrEvento());

			// Se o PT estiver sem OP e se o sistema esta configura para considerar que o IHM troca op entao o evento deve ser descartado
			boolean isPtTrocaOp = false;
			if (omPt.getOmTppt() != null && omPt.getOmTppt().getIsIhmtrocaop() != null)
				isPtTrocaOp = omPt.getOmTppt().getIsIhmtrocaop();
			else if (omCfg.getIsIhmtrocaop() != null)
				isPtTrocaOp = omCfg.getIsIhmtrocaop();

			if (isPtTrocaOp == true &&
					omPt.getIsSemop() != null &&
					omPt.getIsSemop() == true &&
					msEvt.getMsTpevt().getIdTpevt().intValue() != MsTpevtTemplate.Type.ENTRADA_PLANEJAMENTO.getId() &&
					msEvt.getMsTpevt().getIdTpevt().intValue() != MsTpevtTemplate.Type.INICIO_LOGIN.getId() &&
					msEvt.getMsTpevt().getIdTpevt().intValue() != MsTpevtTemplate.Type.FIM_LOGIN.getId() &&
					msEvt.getMsTpevt().getIdTpevt().intValue() != MsTpevtTemplate.Type.PASSAGEM.getId()
					) {

				throw new EventoInvalidoException(msEvt, "PT sem OP");

			}

			DwConsolptDAO dwConsolptDAO = new DwConsolptDAO(dao.getSession());
			DwConsolpt dwConsolpt = dwConsolptDAO.getDwConsolptSeNaoEncontraCria(omPt);

			/*
			 * Alessandre 29-01-14. Antes de mandar processar o registro, vou verificar se a UP esta parada em regulagem. Se estiver, entao
			 * vou descartar o msevt colocando o motivo como parada em regulagem. Somente quando for um msevt de fimdeparada sendo a parada
			 * a regulagem, ou quanto for um evento de motivo de parada eh que o mesmo serah processado.
			 */
			/*
			 * Alessandre 18-2-14 alguns eventos devem ser processados mesmo que esteja em parada de regulagem, como por exemplo login
			 * logout e refugo. O if abaixo retira o login e logout da lista de eventos bloqueados pela regulagem
			 * 
			 * em 11-11-15 foi incluido o evento parametro de medicao
			 * em 19-04-17 foi incluido o evento saida de planejamento para o inova do injet, pois o standalone mandaria um fim parada antes
			 */
			boolean isEventoEmRegulagem = false;
			if (msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.INICIO_LOGIN.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.FIM_LOGIN.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.INICIO_ALERTA.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.FIM_ALERTA.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.CANCELAMENTO_REFUGO.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.FINAL_SAIDA_PLANEJAMENTO.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.MOTIVO_REFUGO.getId() &&
					msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.FIM_CIP.getId()
					) {


				log.info(idLog, identacao, "Entrou na verificar de parada regulagem");

				DwConsolpalog dwconsolpalog = null;
				dwconsolpalog = consolidaRN.getUltimaParadaFromDwConsolpalog(omPt);

				// Se está parada
				if (dwconsolpalog != null && dwconsolpalog.isAberta() && dwconsolpalog.getDwTParada() != null) {

					// Se está em regulagem
					if (dwconsolpalog.getDwTParada().getIsRegulagem() != null && dwconsolpalog.getDwTParada().getIsRegulagem().equals(true)) {
						// Nesse ponto ja sei que a ultima parada esta em aberto e que eh de regulagem. Nesse caso deixarei passar para
						// processamento qq evento
						// que seja diferente de inicio ou fim de ciclo, pois durante uma simulacao nao existem paradas, nem perda de
						// componentes
						//
						// Na verdade percebemos que pode haver perda de componente sim. Entao qq evento será bloqueado com excessao das
						// paradas
						// Substitui abaixo o conteudo pois aparentemente falhou o if
						// Alessandre 23-5-14 vou desconsiderar novamente o final de parada e inicio de parada como eventos para finalizar a
						// parada de regulagem
						// pq na insert a maquina manda o final de parada. A regulagem soh será finalizada quando chegar um motivo diferente
						// de parada
						// soh passa adiante o evento motivo de parada
						// if (msEvt.getMsTpevt().getIdTpevt().equals(3l /*MsTpevtTemplate.Type.INICIO_PARADA.getId()*/) == false &&
						// msEvt.getMsTpevt().getIdTpevt().equals(4l /*MsTpevtTemplate.Type.FIM_PARADA.getId()*/) == false &&

						// Alterar o motivo de parada para fim de parada para finalizar a regulagem somente para as SMDs.
						if ((msEvt.getMsTpevt().getIdTpevt().equals(9l /* MsTpevtTemplate.Type.MOTIVO_PARADA.getId() */) == true || 
								msEvt.getMsTpevt().getIdTpevt().equals(4l /* MsTpevtTemplate.Type.FIM_PARADA */) == true) && 
								msEvt.getCdParada() != null && msEvt.getCdParada().equals("999") && 
								omPt.getOmTppt().getId().equals(OmTpptTemplate.Type.IAC.getId()) ) {
							// Nesse caso transformo o motivo de parada em um evento de final de parada. Isso tudo pq o IHM nem sempre teria
							// considicao
							// de mandar um evento nova parada
							// TODO conversar com Alessandre sobre trecho
							log.info(idLog, 5, "TpEvt alterado de " + msEvt.getMsTpevt().getIdTpevt() + " para " + MsTpevtTemplate.Type.FIM_PARADA.getId());
							msEvt.setMsTpevt(dao.findById(MsTpevt.class, (long) MsTpevtTemplate.Type.FIM_PARADA.getId(), false));

							// Se for maquina ciclicla e for um final de parada entao processar o evento para garantir que a parada seja
							// finalizada
						} else if (
								omPt.getOmTppt().getIdTppt() != OmTpptTemplate.Type.IAC.getId() && 
								( 
										msEvt.getMsTpevt().getIdTpevt() == MsTpevtTemplate.Type.FIM_PARADA.getId() == true
								) ) {
							// nao tem nada aqui somente prosseguir no codigo ou negar o if acima
							// Alessandre em 18-08-17 acrescentei o fim de cip nesse if para que o mesmo possa ser consolidado
							// mesmo estando em regulagem
							
						} else if (msEvt.getMsTpevt().getIdTpevt() == MsTpevtTemplate.Type.INICIO_CICLO.getId()) {
							/*
							 * Alessandre em 09/06/16 foram incluidos os eventos de inicio e fim de ciclo para serem processados durante a
							 * regulagem entretanto eles ter�o um tratamento diferenciado, serao salvos em um dwconsolid que tenha o dwPePro
							 * = 3 (regulagem) e stAtivo = 0, assim essa consolidacao de produ��o n�o ser� considerada junto com as outras
							 * consolidacoes de turno
							 */
							ConsolidacaoFactory.getInstancia().executarConsolidacaoEmRegulagem(dao, omPt, dwConsolpt, dwCalsems, msEvt, omCfg, log, idLog, identacao);
							isEventoEmRegulagem = true;
						} else if (msEvt.getMsTpevt().getIdTpevt() == MsTpevtTemplate.Type.FIM_CICLO.getId()) {
							ConsolidacaoFactory.getInstancia().executarConsolidacaoEmRegulagem(dao, omPt, dwConsolpt, dwCalsems, msEvt, omCfg, log, idLog, identacao);
							isEventoEmRegulagem = true;
						} else {
							throw new EventoInvalidoException(msEvt, "Descartado pois parada de regulagem em aberto para up");
						}

						// Todos os outros eventos devem passar e preferencialmente remover a maquina da situacao de parada por regulagem.
						// Em geral sera um evento
						// de parada 140000

					}
				}

			}


			
			if (MsTpevtTemplate.Type.MAQUINA_OFFLINE.equals(msEvt.getMsTpevt().getIdTpevt())) {
				consolidaRN.consolidarMaquinaOnOff(omPt, dwConsolpt, dwCalsems, msEvt, omCfg, log, false, idLog, identacao);

			} else if (MsTpevtTemplate.Type.MAQUINA_ONLINE.equals(msEvt.getMsTpevt().getIdTpevt())) {
				consolidaRN.consolidarMaquinaOnOff(omPt, dwConsolpt, dwCalsems, msEvt, omCfg, log, true, idLog, identacao);

			} else if (MsTpevtTemplate.Type.INICIO_TURNO.equals(msEvt.getMsTpevt().getIdTpevt())) {

			} else if (MsTpevtTemplate.Type.FINAL_TURNO.equals(msEvt.getMsTpevt().getIdTpevt())) {

			} else if (isEventoEmRegulagem == false) {
				log.info(idLog, identacao, "Nao esta em regulagem vou executar a consolidacao especializada");
				// Executa consolida��oo da coleta conforme o conteúdo de msEvt.getMsTpevt().getIdTpevt()
				ConsolidacaoFactory.getInstancia().executarConsolidacao(dao, omPt, dwConsolpt, dwCalsems, msEvt, omCfg, log, idLog, identacao);
			}

			log.info(idLog, identacao, "Vou retornar consolidado com sucesso");

			// Marca evento como lido
			if (isEventoEmRegulagem) {
				return TpProcessado.PROCESSADO_REGULAGEM;
			} else {
				return TpProcessado.PROCESSADO_NORMAL;
			}

		} catch (SQLGrammarException | StaleStateException | LockAcquisitionException | SemSGBDException | 
				SemSessaoHibernateException | NonUniqueResultException e) {
			e.printStackTrace();
			throw new ReprocessarMsEvtException(e);
			
		} catch (ReprocessarMsEvtException | EventoInvalidoException e) {
			e.printStackTrace();
			throw e;

			// TODO milton rever disparo destes exceptions, talvez não sejam necessários
		} catch (InstantiationException | IllegalAccessException | SemCalendarioException | SemCicloPadraoException | 
				SemPlanejamentoException | RegistroDesconhecidoException | 
				NumeroSerieIrregularException | CicloJaContabilizadoException e) {
			e.printStackTrace();
			throw new EventoInvalidoException(msEvt, e.getMessage(), e);

		} catch (Exception e) {

			if ( 	(e != null && e.getMessage() != null && e.getMessage().contains("Qtde do pacote")) || 
					(e != null && e.getMessage() != null && e.getMessage().contains("MsEvt[Evento")))
				System.out.println("conslidarMsEvt:" + e.getMessage());
			else
				e.printStackTrace();
			
			log.info(idLog, identacao, e);

			String mensagemErro = e.getMessage();
			if (mensagemErro == null) {
				mensagemErro = montarMensagemErro(e);				
			} else {
			
				// TODO milton - criar expception específico para a situação abaixo, onde tem "ppCp" e "nulo" na mensagem
				// Se o erro for diferente de ppCp n�o pode ser nulo entao marcar como erro
				// se for o ppCp n�o pode ser nulo, entao deixar o stEvt como 0 para ser processado novamente
				// isso serve para o caso do INjet em que a OP ainda nao foi importada
				// Como o erro de ppcp nulo esta sem padr�o, entao utilizei as palavra ppCp e null juntas. Caso nao ocorram o evento eh
				// rejeitado
				// caso ocorram juntas o evento eh deixado para nova tentativa de processamento.
				// Se existir a string ppCp nulo no erro entao mandar reprocessar
				if (mensagemErro.indexOf("ppCp") >= 0 && mensagemErro.indexOf("nulo") >= 0 && msEvt.getNrop().equals("op") == false) {
					// o throws abaixo garante que o evento seja reprocessado e nao se siga em diante para os outros eventos
					throw new ReprocessarMsEvtException(e);
				}
				// TODO milton - descobrir o exception especifico para para este evento, para tratar em outro catch
				if (mensagemErro.indexOf("Snapshot isolation transaction aborted due to update conflict") >= 0) {
					// o throws abaixo garante que o evento seja reprocessado e nao se siga em diante para os outros eventos
					throw new ReprocessarMsEvtException(e);
				}
			}
			
			throw new EventoInvalidoException(msEvt, mensagemErro, e);

		}
	}

	private String montarMensagemErro(Exception e) {
		String mensagemErro;
		StringBuilder sb = new StringBuilder();
		sb.append(e.getClass().getName());				
		for (StackTraceElement el : e.getStackTrace()) {
			sb.append(";").append(el.toString());					
		}
		mensagemErro = sb.toString();
		return mensagemErro;
	}

	private void validarDthrEvento(MsEvt msEvt) throws EventoInvalidoException {
		Date dthrEvento = msEvt.getDthrEvento();
		if (dthrEvento == null) {
			throw new EventoInvalidoException(msEvt, "msEvt.getDthrEvento() não pode ser nula");
		} else if (msEvt.getMsTpevt().getIdTpevt() != MsTpevtTemplate.Type.PASSAGEM.getId() ) {
			Date dthrAtual = DataHoraRN.getDataHoraAtual();
			Date dthrLimite = DataHoraRN.adicionaMinutosNaData(dthrAtual, LIMITE_DTHR_EVENTO_ACIMA_DTHR_ATUAL_EM_MINUTOS);
			if (DataHoraRN.after(dthrEvento, dthrLimite)) {
				throw new EventoInvalidoException(msEvt, "msEvt.getDthrEvento() não pode ser superior que " + LIMITE_DTHR_EVENTO_ACIMA_DTHR_ATUAL_EM_MINUTOS + " minutos. " + "msEvt.getDthrEvento() == " + dthrEvento + " dtHrAtual == " + dthrAtual);
			} else {
				Date dthrEventoAnterior = msEvt.getDthrEventoanterior();
				if (dthrEventoAnterior != null) {
					if (DataHoraRN.after(dthrEventoAnterior, dthrEvento)) {
						throw new EventoInvalidoException(msEvt, "msEvt.getDthrEventoanterior() não pode ser superior a msEvt.getDthrEvento(). " + "msEvt.getDthrEventoanterior() == " + dthrEventoAnterior + "  msEvt.getDthrEvento() == " + dthrEvento);
					}
				}
			}
		}
	}
	
}
