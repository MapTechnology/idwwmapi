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

public class ServicoIniciarVarRitmo implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		log.iniciaAvaliacao("Servico INICIA VAR RITMO " + mensagem.getEventoColetado().getIdUpPdba());

		log.info("Servico INICIA VAR RITMO - INI");
	   
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setTipoEvento(ServicoFactory._INICIO_VARIACAO_RITMO);
	    
		boolean retorno = false;
	    retorno = Stubedelegate.getInstancia().iniciarVarRitmo(ev);
		
	    MensagemEnviada m = new MensagemEnviada(mensagem);
	    m.setVarRitmoIniciado(retorno);
	    
    	Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		    	 	    	 
    	log.paraAvaliacao();
		log.info("Servico INICIA VAR RITMO - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
