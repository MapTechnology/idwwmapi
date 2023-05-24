package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import injetws.model.rn.UtilRN;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoValidaRefugo implements IServico {
	
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		MensagemEnviada m = new MensagemEnviada(mensagem);
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setCdrefugo(UtilRN.setZeroEsquerda(mensagem.getCdRefugo()));
	    IwsRefugoDTO refugo = Stubedelegate.getInstancia().verificaCausaAcaoRefugo(ev);
		
	    m.setRefugo(refugo);
	    
    	Stubedelegate.getInstancia().enviaMensagemParaIhmSolicitante(mensagem.getIp(), m);
		
		return null;
	}
	

}
