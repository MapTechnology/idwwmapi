package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import injetws.model.rn.UtilRN;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoNovoRefugo implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
//		ev.setCdop(mensagem.getNrOp());
//		ev.setIdRdzProduto(ev.getIdRdzProduto());
//		ev.setQtde(ev.getQtde());
//		ev.setChamarInjetWs(mensagem.getEventoColetado().isChamarInjetWs());

		log.iniciaAvaliacao("Servico NOVO REFUGO " + ev.getIdUpPdba());
		log.info("Servico NOVO REFUGO - INI");
		
		// Se o injet estiver ativo entao devemos colocar zeros a esquerda
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			if (ev.getCdrefugo() != null && ev.getCdrefugo().equals("") == false)
				ev.setCdrefugo(UtilRN.setZeroEsquerda(ev.getCdrefugo()));
			if (ev.getCdacao() != null && ev.getCdacao().equals("") == false)
				ev.setCdacao(UtilRN.setZeroEsquerda(ev.getCdacao()));
			if (ev.getCdcausa() != null && ev.getCdcausa().equals("") == false)
				ev.setCdcausa(UtilRN.setZeroEsquerda(ev.getCdcausa()));
		}
		
	    MsEvt retorno = Stubedelegate.getInstancia().inserirNovoRefugo(ev);
	    
		// Envia informação para os clientes registrados que querem receber
		// informacoes
		// sobre o ciclo
		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);

		log.info(idLog, 9, "Mandando NOVOREFUGO para clientes REGISTRADOS");
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);

	    log.paraAvaliacao();
		log.info("Servico NOVO REFUGO - FIM " + log.getAvaliacaoCompleta());
		
		return retorno;
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
