package idw.util.whatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsAppRN {
	
    public static final String ACCOUNT_SID = "AC834ab3254963755e24365cee997a3767";
    public static final String AUTH_TOKEN = "b023263f510483dd818ec543416f56ce";

	 public static void main(String[] args) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new PhoneNumber("whatsapp:+559291424944"),
	                new PhoneNumber("whatsapp:+14155238886"),
	                "teste6")
//	            .setMediaUrl("http://localhost:8080/idw/images/19.gif") //https://demo.twilio.com/owl.png") //C:/alessandre/docs/telaGrafico.png
	            .create();

	        System.out.println(message.getSid());
	    }
	 
	 
}
