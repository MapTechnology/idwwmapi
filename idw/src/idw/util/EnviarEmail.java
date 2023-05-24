package idw.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EnviarEmail {
	
	public static void main(String args[]) {
		List<String> destinatarios = new ArrayList<>();
		destinatarios.add("alessandre.barros@maptechnology.com.br");
		destinatarios.add("dcmenezes@gmail.com");
		
		try {
			EnviarEmail.enviarEmail(destinatarios, "teste", "teste teste", "arquivo.txt", "c:/arquivo.txt");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EmailDTO enviarEmail(EmailDTO emaildto) {
		EmailDTO retorno = new EmailDTO();
		try {
			EnviarEmail.enviarEmail(emaildto.getDestinatarios(), emaildto.getAssunto(), emaildto.getMensagem(), null, null);
		} catch (EmailException e) {
			e.printStackTrace();
			retorno.setAssunto(e.getMessage());
		}
		return retorno;
	}
	
	public static void enviarEmail(List<String> destinatarios, String assunto, String mensagem, String nomeArquivo, String arquivo) throws EmailException {
		boolean isExisteDestinatarios = false;
		
		/* Vou usar outra api
		SimpleEmail email = new SimpleEmail();
		
		// Inicializa destinatarios
		for(String dest: destinatarios){
			if (dest != null && dest.contains("@")) {
				email.addTo(dest); // destinatario
				isExisteDestinatarios = true;
			}
		}*/
		
		/* inicializa demais parametros EMAIL MAP
		email.setHostName("smtp.umbler.com"); // o servidor SMTP para envio do
		email.setFrom("injet.mail2@maptechnology.com.br"); // remetente
		email.setAuthentication("injet.mail2@maptechnology.com.br", "1nj3tm@!L");
		email.setSmtpPort(587);
		email.setSslSmtpPort("587");
		email.setSSL(false);
		email.setTLS(false);
		email.setCharset("utf-8");
		 */
		
		EmailAttachment attachment = null;
		
		if (arquivo != null && arquivo.equals("semArq") == false) {
			attachment = new EmailAttachment();
			attachment.setPath(arquivo);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription(nomeArquivo);
			attachment.setName(nomeArquivo);
		}
		
		MultiPartEmail emailAnexo = new MultiPartEmail();

		for(String dest: destinatarios){
			if (dest != null && dest.contains("@")) {
				emailAnexo.addTo(dest); // destinatario
				isExisteDestinatarios = true;
			}
		}

		emailAnexo.setHostName("104.47.22.202"); // mail.flex-am.com.br");
		emailAnexo.setFrom("srvlog.prd@flex-am.com.br");
		emailAnexo.setSubject(assunto);
		emailAnexo.setMsg(mensagem);
		emailAnexo.setSmtpPort(25);
		emailAnexo.setSslSmtpPort("587");
		emailAnexo.setSSL(false);
		emailAnexo.setTLS(false);
		emailAnexo.setCharset("utf-8");

		// add the attachment
		if (attachment != null)
			emailAnexo.attach(attachment);

		
		/* parametros email FLEX
		email.setHostName("mail.flex-am.com.br"); // o servidor SMTP para envio do
		email.setFrom("srvlog.prd@flex-am.com.br"); // remetente
		email.setAuthentication("srvlog.prd@flex-am.com.br", "5rv10gFl3x@2018");
		email.setSmtpPort(25);
		email.setSslSmtpPort("587");
		email.setSSL(false);
		email.setTLS(false);
		email.setCharset("utf-8");

		email.setSubject(assunto); // assunto do e-mail
		email.setMsg(mensagem); // conteudo do e-mail
		 */
		
		// envia email
		if (isExisteDestinatarios == true)
			emailAnexo.send();

	}

}
