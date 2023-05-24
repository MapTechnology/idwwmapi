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

public class ServicoIniciaNovaParada implements IServico {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		MsEvt retorno = null;

		log.iniciaAvaliacao("Servico INICIA NOVA PARADA " + mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());

		log.info("Servi�o INICIA NOVA PARADA");

		mensagem.getEventoColetado().setTipoEvento(ServicoFactory._INICIA_NOVA_PARADA);
		
		// Envia para clientes registrados
		log.info("Mandando REINICIO PARADA para clientes REGISTRADOS");
		//Stubedelegate.getInstancia().enviaMensagemParaClientesRegistradosComExcessaoDaOrigem(mensagemEnviada);
//		Stubedelegate.getInstancia().enviaMensagemParaClientesRegistrados(mensagemEnviada);
		// Se a UP estiver trabalhando, entao informar que foi para parada
		if (mensagem.getEventoColetado().getIcUpDTO().getUpDTO().isUpTrabalhando() == true) {
			// Chama web-service de inicio de parada
			EventoColetado ev = mensagem.getEventoColetado();

			retorno = MsFacade.getInstancia().inicioParada(sessao, ev);
			// Seta true para Up trabalhando
			mensagem.getEventoColetado().getIcUpDTO().getUpDTO().setUpTrabalhando(false);
			
			// Inicializa c�digo de parada n�o informada
			// Alessandre em 21-03-16 comentei a definicao da parada default, pois no PC ao iniciar a parada sempre
			// vinha como 999
			//mensagem.getDadosIcDTO().setCdParadaUP(mensagem.getEventoColetado().getIcUpDTO().getIdIcUp(), "999999");
		} else {
			if (mensagem.getEventoColetado().getIcUpDTO().getUpDTO().isParadaRegulagem() == false) {
				// Chama web-service de final de parada
				EventoColetado ev = mensagem.getEventoColetado();
				
				Stubedelegate.getInstancia().finalParada(ev);

				// Chama web-service de inicio de nova parada
				retorno = MsFacade.getInstancia().inicioParada(sessao, ev);
				mensagem.getEventoColetado().getIcUpDTO().getUpDTO().setUpTrabalhando(false);
				// Se for uma parada persistente, o ws inicioParada deve detectar essa situacao e lancar novamente o mesmo motivo
			}
		}
		
		log.paraAvaliacao();
		log.info("Servi�o INICIA NOVA PARADA - FIM - " + log.getAvaliacaoCompleta());

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
				log.info("Chamando servi�o para mensagem " + mensagemAndon.getServico() + " em " + DataHoraRN.getDataHoraAtual());
				ServicoFactory.getInstancia().executaServico(sessao, mensagemAndon);
				log.info("Servi�o para mensagem " + mensagemAndon.getServico() + " finalizou em " + DataHoraRN.getDataHoraAtual());
			} catch (ServicoFalhouException e) {
				// TODO Aqui devemos salvar o evento pendente e ficar tentando
				log.info("Salvando evento pois o mesmo nao foi processado");
			}
		}
		
		//return null;
		return retorno;
	}
}
