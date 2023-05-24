package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoRemoveAlerta implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		
		log.iniciaAvaliacao("Servico REMOVE ALERTA " + ev.getIdUpPdba());

		log.info(idLog, identacao, "Servico REMOVE ALERTA - INI");
		
		
		// Se o injet estiver ativo entao incluir o evento
		boolean retornoInjet = false;
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			retornoInjet = IwsFacade.getInstancia().setTr_AlertaFim(
					mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getIdUpPDBA(), 
					mensagem.getEventoColetado().getCdalerta(), 
					mensagem.getEventoColetado().getDthrEvento());
		}

		
		UpRN upRN = new UpRN();
		upRN.iniciaConexaoBanco();
		MsEvt msevt = upRN.pararAlerta(ev);
		upRN.finalizaConexaoBanco(log);

		MensagemEnviada m = new MensagemEnviada(mensagem);
		if (msevt != null) {
			m.setAlertaParada(true);
		} else if (retornoInjet) {
			m.setAlertaParada(true);
		} else {
			m.setAlertaParada(false);
		}			

		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);

		log.paraAvaliacao();
		log.info(idLog, identacao, "Servico REMOVE ALERTA  - FIM " + log.getAvaliacaoCompleta());
		
		return msevt;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCdalerta(evtArgs.get("1"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
	

}
