package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;

public class ServicoIniciarCIP implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		log.iniciaAvaliacao("Servico INICIARCIP " + mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());
		log.info("Servico INICIARCIP");
		
		// No momento o CIP funciona apenas para o INJET
		IwsFacade.getInstancia().setTr_trataInicioDeCIP(mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getIdUpPDBA(), mensagem.getEventoColetado().getDthrEvento(), null);
		
		log.paraAvaliacao();
		log.info("FIM-Servico INICIARCIP");
		
		return null;
	}

}
