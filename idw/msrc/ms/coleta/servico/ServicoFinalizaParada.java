package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;

public class ServicoFinalizaParada implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._INICIA_NOVA_PARADA);

		log.iniciaAvaliacao("Servico FINALIZA PARADA " + ev.getIcUpDTO().getUpDTO().getCd_up());
		log.info("Servico FINALIZA PARADA - INI");

		MensagemEnviada m = new MensagemEnviada(mensagem);
		
		try {
			// finaliza a parada
			MsFacade.getInstancia().finalizaParada(ev);
			MsFacade.getInstancia().inicioParada(sessao, ev);
			// Seta true para Up trabalhando
			ev.getIcUpDTO().getUpDTO().setUpTrabalhando(false);
			// Inicializa codigo de parada nao informada
			mensagem.getDadosIcDTO().setCdParadaUP(ev.getIcUpDTO().getIdIcUp(), "999999");
			m.setParadaFinalizada(true);
		} catch (Exception e) {
			m.setParadaFinalizada(false);

			throw new ServicoFalhouException(e);
		}
		
		Stubedelegate.getInstancia().enviaMensagemParaIhmSolicitante(mensagem.getIp(), m);
		
		log.paraAvaliacao();
		log.info("Servico FINALIZA PARADA - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}
}
