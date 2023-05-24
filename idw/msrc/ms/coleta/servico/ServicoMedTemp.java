package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.rn.UpRN;

public class ServicoMedTemp implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
	
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao(idLog, "Chamando ServicoMedTemp");
		
		UpRN upRN = new UpRN();
		try {
			upRN.iniciaConexaoBanco();
			upRN.lancaMedicaoParametro(log, idLog, identacao, mensagem.getEventoColetado());
		} catch (Exception e){
			e.printStackTrace();
			log.info(idLog, identacao, "MedTemp: Ocorreu excessao abaixo", e);
		} finally {
			log.iniciaAvaliacao("finalizaConexaoBanco");
			upRN.finalizaConexaoBanco(log);
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
		}
		
		log.mostrarAvaliacaoCompleta(idLog, identacao);
		
		return null;
	}
	
}
