package idw.util.whatsapp;

import java.util.List;

import org.hibernate.Session;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmCfg;
import idw.model.pojos.injet.IjMsgAppMsg;
import idw.model.rn.PTRN;
import idw.util.Util;
import injetws.model.rn.injet.InjetAlertaRN;

public class TwilioWhatsapp implements IWhatsapp {

	@Override
	public void enviarMensagens() {
		
		PTRN rn = new PTRN();
		
		rn.iniciaConexaoBanco();
		
		// Obter configuracao geral
		OmCfg omcfg = Util.getConfigGeral(rn.getDaoSession());
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		InjetAlertaRN irn = new InjetAlertaRN(dao);
		
		

        try {
			irn.iniciaConexaoBanco();

			// Obter mensagens que serão enviadas que ainda não foram
			List<IjMsgAppMsg> lista = obtemMensagensNaoEnviadas(irn.getDaoInjet().getSession());

	        Twilio.init(omcfg.getIdWhatsapp(), omcfg.getPwWhatsapp());

	
	        for (IjMsgAppMsg msg : lista) {
	        	try {
			        Message.creator(
			                new PhoneNumber("whatsapp:" + msg.getTelefone()),
			                new PhoneNumber("whatsapp:" + omcfg.getTelWhatsapp()),
			                msg.getTitulo() + "\n" + msg.getMensagem())
	//		            .setMediaUrl(
	//		                Arrays.asList(URI.create("https://images.unsplash.com/photo-1545093149-618ce3bcf49d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80")))
			            .create();
			        
			        msg.setStenvio(1);
	        	} catch (Exception e) {
	        		e.printStackTrace();
	        		msg.setStenvio(2);
	        	}
	        	irn.getDaoInjet().makePersistent(msg);
	        }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	irn.finalizaConexaoBanco();
        }
        
	}
	
	private List<IjMsgAppMsg> obtemMensagensNaoEnviadas(Session sessao) {
		MapQuery q = new MapQuery(sessao);
		
		q.append("select a");
		q.append("from IjMsgAppMsg a");
		q.append("where a.stenvio = 0");
		
		return q.list();
	}

}
