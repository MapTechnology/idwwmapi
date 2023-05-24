package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsCpDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoNovaOp implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
	
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._NOVA_OP);
		
		log.iniciaAvaliacao("Servico NOVA OP " + ev.getIdUpPdba());
		log.info("Servico NOVA OP - INI");
		
	    MsEvt msevt = Stubedelegate.getInstancia().iniciarNovaOp(ev);
	    
	    
	    
	    // msevt pode ser null se a op nao foi criada ou encontrada
		
	    MensagemEnviada m = new MensagemEnviada(mensagem);
	    IwsCpDTO cpDTO = new IwsCpDTO();

	    m.setCp(cpDTO);
	    
    	Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		    	 	    	 
    	log.paraAvaliacao();
		log.info("Servico NOVA OP - FIM " + log.getAvaliacaoCompleta());
		
		
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
