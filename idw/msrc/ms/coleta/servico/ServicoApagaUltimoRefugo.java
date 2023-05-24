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

public class ServicoApagaUltimoRefugo implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {

		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		log.iniciaAvaliacao("Servico APAGA ULTIMO REFUGO " + mensagem.getEventoColetado().getIdUpPdba());

		log.info("Servico APAGA ULTIMO REFUGO - INI");
		
		MensagemEnviada m = new MensagemEnviada(mensagem);
		
		EventoColetado ev = mensagem.getEventoColetado();
	    ev.setCdrefugo(mensagem.getCdRefugo());
	    ev.setDthrUltimoRefugo(mensagem.getDthrUltRefugo());
	    ev.setMilisec(mensagem.getMsDthrUltRefugo());
	    ev.setIdRdzProduto(mensagem.getIdRdzProduto());
		
		
		m.setResultadoRefugo(Stubedelegate.getInstancia().apagaUltimoRefugo(ev));
		
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		
		log.paraAvaliacao();
		log.info("Servico  APAGA ULTIMO REFUGO  - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCdrefugo(evtArgs.get("1"));
		retorno.setCdcausa(evtArgs.get("2"));
		retorno.setCdacao(evtArgs.get("3"));
		retorno.setCdproduto(evtArgs.get("4"));
		retorno.setCb(evtArgs.get("5"));
		retorno.setQtde(evtArgs.get("6"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
	
	 

}
