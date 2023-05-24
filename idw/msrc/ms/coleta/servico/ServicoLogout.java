package ms.coleta.servico;

import java.text.ParseException;
import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.rn.DataHoraRN;
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

public class ServicoLogout implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao("Servico LOGOUT" + mensagem.getEventoColetado().getIdUpPdba());
		log.info(idLog, identacao, "Servico LOGOUT - INI ");
		
		
		// Se o injet estiver ativo entao incluir o evento
		IwsErroDTO retornoInjet = null;
		if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
			try {
				retornoInjet = IwsFacade.getInstancia().efetuaLogout(
						mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getIdUpPDBA(), 
						mensagem.getEventoColetado().getLogin(), 
						mensagem.getEventoColetado().getDthrEvento(),
						DataHoraRN.toDateFromYYYYMMDDHHMISS(mensagem.getDthrlogin()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		MsEvt msevt;
        UsuarioMSRN usuarioRN = new UsuarioMSRN();
        usuarioRN.iniciaConexaoBanco(sessao);
        try{
        	msevt = usuarioRN.isLogoutEfetuado(mensagem.getEventoColetado());
        }catch (Exception e) {
        	e.printStackTrace();
        	log.info(e);
        	msevt = null;
		} finally {
			usuarioRN.finalizaConexaoBanco();
		}
        
        MensagemEnviada m = new MensagemEnviada(mensagem);
	    m.setLogoutEfetuado(msevt != null && !msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal()));	
	    if (retornoInjet != null && retornoInjet.getSucesso())
	    	m.setLogoutEfetuado(retornoInjet.getSucesso());
		
	    log.info(idLog, identacao, "Mandando resposta de Logout para " + mensagem.getIp());
	    Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		    	 	    	 
		log.paraAvaliacao();
		log.info(idLog, identacao, "Servico LOGOUT - FIM - " + log.getAvaliacaoCompleta());
		
		return msevt;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setLogin(evtArgs.get("1"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
