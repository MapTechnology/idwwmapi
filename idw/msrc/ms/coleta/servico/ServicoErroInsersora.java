package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoErroInsersora implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		// TODO Auto-generated method stub
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		log.iniciaAvaliacao(idLog, "Inicio Servico erro Insersora: " + mensagem.getEventoColetado());
		log.info(idLog, identacao, "Servico erro insersora");
		
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		
		UpRN upRN = new UpRN();
		try{
			upRN.iniciaConexaoBanco();
			upRN.insereErroInsersora(idLog, identacao, ev);
		}catch(Exception e){
			log.info("Ocorreu a excessao: ", e);
		}finally{
			log.iniciaAvaliacao("finalizaConexaoBanco");
			upRN.finalizaConexaoBanco(log);
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
		}
		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());
		
		return null;
	}

}
