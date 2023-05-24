package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoFimParada implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao(idLog, "Servico FIM PARADA " + mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());
		log.info(idLog, identacao, "Servico FIM PARADA - INI");

		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);

		MsEvt msevt;
		
		UpRN upRN = new UpRN();
		try {
			upRN.iniciaConexaoBanco();
			msevt = upRN.finalParada(ev);
		} catch (Exception e) {
			msevt = null;
			log.info("Ocorreu excessao abaixo", e);
		} finally {
			upRN.finalizaConexaoBanco(log);
		}

		if(mensagem.getDadosIcDTO().getStAndonConfiguravelAtivo()) {
			//Criando o evento de andon e a respectiva mensagem para que o servico posssa ser chamado corretamente.
			EventoColetado eventoColetado = new EventoColetado();
			//numero do servico de andon eh 4 para que o servico seja buscado corretamente na lista se servicos disponiveis
			eventoColetado.setTipoEvento(4);
			eventoColetado.setIcUpDTO(mensagem.getEventoColetado().getIcUpDTO());
			MensagemRecebida mensagemAndon = new MensagemRecebida(eventoColetado);
			mensagemAndon.setDadosIcDTO(mensagem.getDadosIcDTO());
			mensagemAndon.setLog(mensagem.getLog());
			
			mensagemAndon.setIc(mensagem.getIc());
			try {
				log.info(idLog, identacao, "Chamando servico para mensagem " + mensagemAndon.getServico() + " em " + DataHoraRN.getDataHoraAtual());
				ServicoFactory.getInstancia().executaServico(sessao, mensagemAndon);
				log.info(idLog, identacao, "Servico para mensagem " + mensagemAndon.getServico() + " finalizou em " + DataHoraRN.getDataHoraAtual());
			} catch (ServicoFalhouException e) {
				// TODO Aqui devemos salvar o evento pendente e ficar tentando
				log.info(idLog, identacao, "Salvando evento pois o mesmo nao foi processado");
			}
		}
		
		// Envia informacao para os clientes registrados que querem receber
		// informacoes
		// sobre o final da parada
		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);

		log.info(idLog, 9, "Mandando FIMPARADA para clientes REGISTRADOS");
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);

		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, identacao, "Servico FIM PARADA - FIM " + log.getAvaliacaoCompleta());
		
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
