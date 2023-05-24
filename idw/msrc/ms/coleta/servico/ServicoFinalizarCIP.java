package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;

public class ServicoFinalizarCIP implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		log.iniciaAvaliacao("Servico FINALIZARCIP " + mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());
		log.info("Servi�o FINALIZACIP");
		
		// No momento o CIP funciona apenas para o INJET

		IwsFacade.getInstancia().setTr_trataFimCIP(mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getIdUpPDBA(), mensagem.getEventoColetado().getDthrEvento(), null);
		
		log.paraAvaliacao();
		log.info("FIM-Servico FINALIZARCIP");
		
		return null;
	}

}
