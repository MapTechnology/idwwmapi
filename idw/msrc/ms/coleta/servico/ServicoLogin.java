package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;
import injetws.webservices.dto.IwsErroDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UsuarioMSRN;

public class ServicoLogin implements IServico, IProtocoloNovo {

	static String[] vtrLogin = null;
	static int indice = 0;
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao("Servico LOGIN " + mensagem.getEventoColetado().getLogin());
		log.info(idLog, identacao, "Servico LOGIN - INI");
	
		boolean isUsuarioLogado = false;
		MsEvt msevt;

		UsuarioMSRN usuarioMSRN = new UsuarioMSRN();

		IwsErroDTO retornoInjet = null;
		// Se o injet estiver ativo entao incluir o evento
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			retornoInjet = IwsFacade.getInstancia().efetuaLogin(
					mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getIdUpPDBA(), 
					mensagem.getEventoColetado().getLogin(), 
					mensagem.getEventoColetado().getDthrEvento());
		}
		

		try {
			usuarioMSRN.iniciaConexaoBanco(sessao);
			// Tenta fazer o login
			msevt = usuarioMSRN.logarUsuario(mensagem.getEventoColetado());
			if (msevt == null) {
				isUsuarioLogado = false;
			} else if (msevt != null && msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal()) == false) {
				isUsuarioLogado = true;
			}
		} catch (Exception e) {
			msevt = null;
			isUsuarioLogado = false;
			log.info(e);
			e.printStackTrace();
		} finally {
			usuarioMSRN.finalizaConexaoBanco();
		}
		
		if (retornoInjet != null && retornoInjet.getSucesso())
			isUsuarioLogado = retornoInjet.getSucesso();

		//Primeiro verifica se Login e Senha estão corretos
		MensagemEnviada m = new MensagemEnviada(mensagem);
		m.setLoginOperadorAutenticado(true);
		// TODO: isUsuarioLogado nao e confiavel
		m.setUsuarioLogado(isUsuarioLogado);
		m.setLoginOperadorAutenticado(isUsuarioLogado);
		
		
		log.info(idLog, identacao, "Mandando resposta do login para " + mensagem.getIp() );
		
	    Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
	    
	    log.paraAvaliacao();
		log.info(idLog, identacao, "Servico LOGIN - FIM " + log.getAvaliacaoCompleta());
		
		return msevt;
	}
	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setLogin(evtArgs.get("1"));
		retorno.setSenha(evtArgs.get("2"));
	}
	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
	
	
}
