package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;

public class ServicoParada implements IServico {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		log.iniciaAvaliacao(idLog, "INICIO Servico Parada " + mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());
		log.info(idLog, identacao, "Servi�o PARADA");
		// Envia informa��o para os clientes registrados que querem receber
		// informacoes
		// sobre o ciclo
//		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);

		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);

		// Envia para clientes registrados
//		log.info("		Mandando PARADA para clientes REGISTRADOS");
//		Stubedelegate.getInstancia().enviaMensagemParaClientesRegistrados(mensagemEnviada);
				
		// Se a UP estiver trabalhando, entao informar que foi para parada
		if (mensagem.getEventoColetado().getIcUpDTO().getUpDTO().isUpTrabalhando() == true) {
			// Chama web-service de inicio de parada
			log.iniciaAvaliacao(idLog, "Chamando Stubedelegate.getInstancia().inicioParada()");
			MsFacade.getInstancia().inicioParada(sessao, ev);
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());

			// Seta true para Up trabalhando
			mensagem.getEventoColetado().getIcUpDTO().getUpDTO().setUpTrabalhando(false);
			
			// Inicializa c�digo de parada n�o informada
			mensagem.getDadosIcDTO().setCdParadaUP(mensagem.getEventoColetado().getIcUpDTO().getIdIcUp(), "999999");
		} else {
			if (mensagem.getEventoColetado().getIcUpDTO().getUpDTO().isParadaRegulagem() == false) {
				// Chama web-service de final de parada
				log.iniciaAvaliacao(idLog, "Chamando Stubedelegate.getInstancia().finalParada()");
				Stubedelegate.getInstancia().finalParada(ev);
				log.paraAvaliacao();
				log.info(idLog, identacao, log.getAvaliacaoCompleta());

				// Chama web-service de inicio de nova parada
				MsFacade.getInstancia().inicioParada(sessao, ev);

				// Se for uma parada persistente, o ws inicioParada deve detectar essa situacao e lancar novamente o mesmo motivo
			}
		}

		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, identacao, "FIM - Servi�o PARADA - " + log.getAvaliacaoCompleta());

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
				log.info(idLog, identacao, "Chamando servi�o para mensagem " + mensagemAndon.getServico() + " em " + DataHoraRN.getDataHoraAtual());
				ServicoFactory.getInstancia().executaServico(sessao, mensagemAndon);
				log.info(idLog, identacao, "Servi�o para mensagem " + mensagemAndon.getServico() + " finalizou em " + DataHoraRN.getDataHoraAtual());
			} catch (ServicoFalhouException e) {
				// TODO Aqui devemos salvar o evento pendente e ficar tentando
				log.info(idLog, identacao, "Salvando evento pois o mesmo nao foi processado");
			}
		}
		
		return null;
	}
}
