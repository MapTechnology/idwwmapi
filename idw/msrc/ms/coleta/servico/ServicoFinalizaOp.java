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
import ms.model.rn.UpRN;

public class ServicoFinalizaOp implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		
		log.iniciaAvaliacao("Servico FINALIZA OP " + ev.getIdUpPdba());
		
		log.info(idLog, identacao, "Servico FINALIZA OP - INI");
		
		UpRN upRN = new UpRN();
		upRN.iniciaConexaoBanco();
		boolean isopfinalizada = true;
		MsEvt retorno = null;
		try {
			retorno = upRN.finalizarOP(log, idLog, identacao, ev);
			upRN.finalizarOPRestoLinha(log, idLog, identacao, ev);
			
			
		}catch(Exception e) {
			isopfinalizada = false;
		}finally {
			upRN.finalizaConexaoBanco(log);
		}

		MensagemEnviada m = new MensagemEnviada(mensagem);
		m.setOpfinalizada(isopfinalizada);
		
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		
		log.paraAvaliacao();
		log.info(idLog, identacao, "Servico FINALIZA OP - FIM " + log.getAvaliacaoCompleta());
		
		return retorno;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}

}
