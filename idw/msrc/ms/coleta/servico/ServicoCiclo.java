package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsIcTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoCiclo implements IServico {
	
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		Stubedelegate.getInstancia().addContador();

		String cdUp = "desc";
		
		if (mensagem.getEventoColetado().getIcUpDTO() != null && mensagem.getEventoColetado().getIcUpDTO().getUpDTO() != null) {
			cdUp = mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up();
		} else if (mensagem.getEventoColetado().getIdUpPdba() != null){
			log.info(idLog, identacao, "Alerta 1 - up esta nulo");
			cdUp = mensagem.getEventoColetado().getIdUpPdba();
		}
		
		log.iniciaAvaliacao(idLog, "Servico Ciclo para " + cdUp);
		log.info(idLog, identacao, "INICIO - Servi�o CICLO em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + " - " + Stubedelegate.getInstancia().getContador());
		
		// Envia informa��o para os clientes registrados que querem receber
		// informacoes
		// sobre o ciclo
//		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);

		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		
		// Envia para clientes registrados
	//	log.info(idLog, 9, "Mandando CICLO para clientes REGISTRADOS");
	//	Stubedelegate.getInstancia().enviaMensagemParaClientesRegistrados(idLog, 9, mensagemEnviada);

		// Parar a thread de verificacao da parada automatica. Isso � feito antes do processamento efetivo do ciclo, pois caso o processamento do ciclo
		// seja demorado o impacto ou mesmo o inicio irregular de uma parda automatica nao ir� acontecer
		// Alessandre: O trecho abaixo foi comentado pq a parada automatica faz parte do driver
//		if (mensagem.getEventoColetado() != null && mensagem.getEventoColetado().getIcUpDTO() != null) {
//			mensagem.getEventoColetado().getIcUpDTO().getUpDTO().finalizaVerificacaoParadaAutomatica();
//		}
		/* ::BETOSENOJ rever este trecho
		 * Alessandre: Descomentei o trecho abaixo em 20-09-12 pois desejo receber o inicio do ciclo em msEvt. Beto me disse q foi comentado pq na bic soh
		 * chegava inicio de ciclo
		 * 
		 * inicio de ciclo: se em msUp.idEvtCiclo estiver vazio, mas o problema eh que o trecho abaixo nao esta lendo o banco antes de chamar a UPRN
		 * falta verificar se a parada fecha ciclo, se ciclo fecha parada
		 *
		 */
 		if (mensagem.getEventoColetado().getIcUpDTO().getUpDTO().isUpParada() == true) {
			// Se o motivo da parada requer uma confirmacao para ser finalizada,
			// entao descartar o ciclo
			if (mensagem.getEventoColetado().getIcUpDTO().getUpDTO().isParadaRequerConfirmacaoParaFinalizar() == false) {
				// Chama web-service de inicio de ciclo

				// A linha abaixo para fechar a parada foi removida, pois isso
				// j� est� na RN de inicioCiclo
				// Stubedelegate.getInstancia().finalParada(ev);

				// Chama web-service de inicio de ciclo
				log.iniciaAvaliacao(idLog, "Chamando Stubedelegate.getInstancia().inicioCiclo()");
				
				UpRN upRN = new UpRN();
				try {
					upRN.iniciaConexaoBanco(sessao);
					log.info(idLog, 0, "SERVICOCICLO PQ????");
					upRN.inicioCiclo(idLog, identacao, ev);
				} catch (Exception e){
					log.info("Ocorreu excessao abaixo", e);
				} finally {
					log.iniciaAvaliacao("finalizaConexaoBanco");
					upRN.finalizaConexaoBanco(log);
					log.paraAvaliacao();
					log.info(idLog, identacao, log.getAvaliacaoCompleta());
				}

				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
				
				
				mensagem.getDadosIcDTO().setaDataHoraInicioCicloUP(mensagem.getEventoColetado().getIcUpDTO().getIdIcUp(), ev.getDthrEvento());
				
				// Seta true para Up trabalhando
				mensagem.getEventoColetado().getIcUpDTO().getUpDTO().setUpTrabalhando(true);
				log.info("Maquina parada = " + mensagem.getEventoColetado().getIcUpDTO().getUpDTO().isUpParada());
			} else {
				// Gerar log que o sinal de inicio de ciclo foi descartado
				log.info(idLog, 9, "Sinal de ciclo foi descartado");
			}
		} else {
			
			// TODO: Alessandre-Indentifiquei que alguns servicos chamam o stubedelegate que ira fazer acesso a UpRN e outros (como esse aqui)
			// esta chamando a UpRN sem passar pelo stubeDelegate. Alem disso a RN esta sendo inicializada nesse else qto no if acima
			
			log.iniciaAvaliacao(idLog, "Chamando Stubedelegate.getInstancia().finalCiclo()");
			UpRN upRN = new UpRN();
			try {
				upRN.iniciaConexaoBanco(sessao);
				upRN.finalCiclo(idLog, identacao, ev);
			} catch (Exception e){
				log.info( "Excess�o abaixo: ", e);
				e.printStackTrace();
			} finally {
				log.iniciaAvaliacao("finalizaConexaoBanco");
				upRN.finalizaConexaoBanco(log);
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			}				

			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
			
			// Seta o valor de eficiencia do ultimo ciclo
			try {
				mensagem.getDadosIcDTO().calculaValorEficienciaUltimoCicloUP(mensagem.getEventoColetado().getIcUpDTO().getIdIcUp(), ev.getDthrEvento());
			} catch (NullPointerException e){
				e.printStackTrace();
			}
			//Salvar nova data e hora do in�cio de ciclo
			try {
				mensagem.getDadosIcDTO().setaDataHoraInicioCicloUP(mensagem.getEventoColetado().getIcUpDTO().getIdIcUp(), ev.getDthrEvento());
			} catch (NullPointerException e){
				e.printStackTrace();
			}
		}

 		// Se o tipo do IC for 3 (sem thread ativada, entao a parada automatica dever� ser vista pelo proprio IHM)
 		if (mensagem.getEventoColetado().getIcUpDTO().getIc().getTp_ic() != MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue()) {
			// Define o inicio ou final do ciclo no MsUpDTO para fins de deteccao da parada automatica		
			mensagem.getEventoColetado().getIcUpDTO().getUpDTO().setLog(log);
 		}
 		
		if(mensagem.getDadosIcDTO().getStAndonConfiguravelAtivo()) {
			//Criando o evento de andon e a respectiva mensagem para que o servi�o posssa ser chamado corretamente.
			EventoColetado eventoColetado = new EventoColetado();
			//n�mero do servi�o de andon � 4 para que o servi�o seja buscado corretamente na lista se servi�os dispon�veis
			eventoColetado.setTipoEvento(4);
			eventoColetado.setIcUpDTO(mensagem.getEventoColetado().getIcUpDTO());
			MensagemRecebida mensagemAndon = new MensagemRecebida(eventoColetado);
			mensagemAndon.setDadosIcDTO(mensagem.getDadosIcDTO());
			mensagemAndon.setLog(mensagem.getLog());
			
			mensagemAndon.setIc(mensagem.getIc());
			try {
				log.info(idLog, 9, "INICIO - Chamando servi�o para mensagem " + mensagemAndon.getDescricaoServico() + " em " + DataHoraRN.getDataHoraAtualFormatada());
				ServicoFactory.getInstancia().executaServico(sessao, mensagemAndon);
				log.info(idLog, 9, "FIM - Servi�o para mensagem " + mensagemAndon.getDescricaoServico() + " finalizou em " + DataHoraRN.getDataHoraAtualFormatada());
			} catch (ServicoFalhouException e) {
				// TODO Aqui devemos salvar o evento pendente e ficar tentando
				log.info(idLog, 9, "Salvando evento pois o mesmo nao foi processado NAO est� implementado.");
			}
		}
		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, 0, "FIM - Servi�o CICLO em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + log.getAvaliacaoCompleta());
		
		return null;
	}
}
