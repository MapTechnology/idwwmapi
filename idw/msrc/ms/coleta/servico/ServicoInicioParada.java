package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.IdwFacade;
import idw.model.pojos.MsEvt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;

public class ServicoInicioParada implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		
		log.iniciaAvaliacao(idLog, "Servico Parada " + ev.getIcUpDTO().getUpDTO().getCd_up());
		log.info(idLog, identacao, "Servico INICIO PARADA - INI");

		MsEvt msevt = null;

		// O objetivo do if abaixo eh evitar q o codigo execute se o idw nao estiver ativo
		if (IdwFacade.getInstancia().isIDWAtivo() == true) {
			// Trecho substituindo o trecho acima
			// Chama web-service de iniTcio de parada
			log.iniciaAvaliacao(idLog, "Chamando Stubedelegate.getInstancia().inicioParada()");
			msevt = MsFacade.getInstancia().inicioParada(sessao, ev);
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
		}
		
		// Seta false para Up trabalhando
		ev.getIcUpDTO().getUpDTO().setUpTrabalhando(false);

		// Inicializa código de parada não informada
		if (ev.getCdparada() != null && ev.getCdparada().equals("") == false){
			mensagem.getDadosIcDTO().setCdParadaUP(ev.getIcUpDTO().getIdIcUp(), ev.getCdparada());
		}else{
			mensagem.getDadosIcDTO().setCdParadaUP(ev.getIcUpDTO().getIdIcUp(), "999999");
		}
		
		if(mensagem.getDadosIcDTO().getStAndonConfiguravelAtivo()) {
			//Criando o evento de andon e a respectiva mensagem para que o servi�o posssa ser chamado corretamente.
			EventoColetado eventoColetado = new EventoColetado();
			//número do serviço de andon é 4 para que o serviço seja buscado corretamente na lista se serviços disponíveis
			eventoColetado.setTipoEvento(4);
			eventoColetado.setIcUpDTO(ev.getIcUpDTO());
			MensagemRecebida mensagemAndon = new MensagemRecebida(eventoColetado);
			mensagemAndon.setDadosIcDTO(mensagem.getDadosIcDTO());
			mensagemAndon.setLog(mensagem.getLog());
			
			mensagemAndon.setIc(mensagem.getIc());
			try {
				log.info(idLog, identacao, "Chamando serviço para mensagem " + mensagemAndon.getServico() + " em " + DataHoraRN.getDataHoraAtual());
				ServicoFactory.getInstancia().executaServico(sessao, mensagemAndon);
				log.info(idLog, identacao, "Serviço para mensagem " + mensagemAndon.getServico() + " finalizou em " + DataHoraRN.getDataHoraAtual());
			} catch (ServicoFalhouException e) {
				// TODO Aqui devemos salvar o evento pendente e ficar tentando
				log.info(idLog, identacao, "Salvando evento pois o mesmo nao foi processado");
			}
		}
		

		// Envia para clientes registrados
		// Envia informação para os clientes registrados que querem receber
		// informacoes
		// sobre i uucuci da parada
		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);
		log.info(idLog, identacao, "Mandando PARADA para clientes REGISTRADOS");
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);

		// Finaliza servico
		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, identacao, "Servico INICIO PARADA - FIM " + log.getAvaliacaoCompleta());
		
		return msevt;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
