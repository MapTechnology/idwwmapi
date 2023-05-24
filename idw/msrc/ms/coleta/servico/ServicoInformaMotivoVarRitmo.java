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

public class ServicoInformaMotivoVarRitmo implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
	
		IdwLogger log = mensagem.getLog();
		int identacao = mensagem.getIdentacao();
		int idLog = mensagem.getIdLog();
		log.iniciaAvaliacao("Servico INFORMA MOTIVO VAR RITMO INOVASA " + mensagem.getEventoColetado().getIdUpPdba());

		log.info("Servico INFORMA MOTIVO VAR RITMO - INI");
	   
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setTipoEvento(ServicoFactory._MOTIVO_VARRITMO);
	    
		boolean retorno = false;
	    retorno = Stubedelegate.getInstancia().informaMotivoVarRitmo(ev);
		
	    MensagemEnviada m = new MensagemEnviada(mensagem);
	    m.setMotivoVarRitmoAlterado(retorno);
	    
    	Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		    	 	    	 
    	log.paraAvaliacao();
		log.info("Servico INFORMA MOTIVO VAR RITMO - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCdjustificativa((evtArgs.get("1")));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
