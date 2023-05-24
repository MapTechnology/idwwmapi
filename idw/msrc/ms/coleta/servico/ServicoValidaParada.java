package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsParadaDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoValidaParada implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		//ev.setCdparada(UtilRN.setZeroEsquerda(ev.getCdparada()));
		
		log.iniciaAvaliacao("Servico VALIDA PARADA " + ev.getIdUpPdba());
		log.info("Servico VALIDA PARADA - INI");
		
		IwsParadaDTO parada = Stubedelegate.getInstancia().validaParada(ev);
		
		MensagemEnviada m = new MensagemEnviada(mensagem);
	    m.setParada(parada);
	    m.setFlagmotivoparada(mensagem.getFlagMotivoParada().equals("")? false : true);
	    
    	Stubedelegate.getInstancia().enviaMensagemParaIhmSolicitante(mensagem.getIp(), m);
		    	 	    	 
    	log.paraAvaliacao();
		log.info("Servico VALIDA PARADA - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}
}
