package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoIniciarCIPInovaSA implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		log.iniciaAvaliacao("Servico INICIA CIP INOVASA " + mensagem.getEventoColetado().getIdUpPdba());

		log.info("Servico INICIA CIP INOVASA - INI");
		
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setTipoEvento(ServicoFactory._INICIAR_CIP_INOVASA);
	    
		MsEvt retorno = null;
	    retorno = Stubedelegate.getInstancia().iniciarCIP(ev);
		
	    MensagemEnviada m = new MensagemEnviada(mensagem);
	    m.setCipIniciado(retorno != null);
	    
    	Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		    	 	    	 
    	log.paraAvaliacao();
		log.info("Servico INICIA CIP INOVASA - FIM " + log.getAvaliacaoCompleta());
		
		return retorno;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCdtecResponsavel(evtArgs.get("1"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
