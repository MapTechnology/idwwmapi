package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.IdwFacade;
import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoPassagem implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		// O serviço de passagem deverá lançar também um evento de final de ciclo a fim de contabilizar as passagens
		// Somenete se a passagem for validada com sucesso
		String cdUp = "desc";
		MsEvt retorno = null;
		
		if (ev.getIcUpDTO() != null && ev.getIcUpDTO().getUpDTO() != null) {
			cdUp = ev.getIcUpDTO().getUpDTO().getCd_up();
		} else if (ev.getIdUpPdba() != null){
			log.info(idLog, identacao, "Alerta 1 - up esta nulo");
			cdUp = ev.getIdUpPdba();
		}
		
		log.iniciaAvaliacao(idLog, "Servico PASSAGEM");
		log.info(idLog, identacao, "Servico PASSAGEM - INI em " + ev.getDthrEventoFormatadoParaEnvio() + " para " + cdUp);

		if ( IdwFacade.getInstancia().isIDWAtivo() == true) {
			UpRN upRN = new UpRN();
			try {
				upRN.iniciaConexaoBanco();
				retorno = upRN.registrarPassagem(idLog, identacao, ev);
			} catch (Exception e){
				log.info("Ocorreu excessao abaixo", e);
				e.printStackTrace();
			} finally {
				upRN.finalizaConexaoBanco(log);
				log.info(idLog, identacao, log.getAvaliacaoCompleta());
			}
		}
		
		// Ailton: resolucao de bug ()09/11/16
		// Coletor ficava sem conexao apos um evento de passagem
		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);
		
		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, identacao, "Servico PASSAGEM - FIM em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + log.getAvaliacaoCompleta());
		
		return retorno;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCb(evtArgs.get("1"));
		retorno.setQtde(evtArgs.get("2"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}

}
