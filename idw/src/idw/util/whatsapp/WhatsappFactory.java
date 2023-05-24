package idw.util.whatsapp;

import java.util.HashMap;
import java.util.Map;

import idw.model.pojos.template.OmCfgTemplate;

public class WhatsappFactory {

	
	private static WhatsappFactory instancia = null;
	
	private Map<Integer, Class> provedoresDisponiveis = new HashMap<>();
	
	private WhatsappFactory() {
		super();
		
		this.provedoresDisponiveis.put(OmCfgTemplate.TpWhatsapp._SEMWHATSAPP.getValue(), WhatsappFactory.class);
		this.provedoresDisponiveis.put(OmCfgTemplate.TpWhatsapp._TWILIO.getValue(), TwilioWhatsapp.class);
	}
	
	public static WhatsappFactory getInstancia() {
		if (instancia == null)
			instancia = new WhatsappFactory();
		return instancia;
	}
	
	public IWhatsapp obtemProvedor(Integer tpProvedor) {
		try {
			return (IWhatsapp) provedoresDisponiveis.get(tpProvedor).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
