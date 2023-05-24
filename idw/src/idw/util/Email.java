package idw.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email extends Thread {
	private String assunto;
	private String descricao;
	private List<String> destinatarios = new ArrayList<String>();
	private IdwLogger log;
	private int idLog;
	private int identacao;	
	
	public Email(IdwLogger log, int idLog, int identacao, List<String> destinatarios, String assunto, String descricao ){
		this.log = log;
		this.idLog = idLog;
		this.identacao = identacao;
		this.assunto = assunto;
		this.descricao = descricao;		
		if(destinatarios != null){
			this.destinatarios = destinatarios;
		}
	}
	
	public Email(IdwLogger log, int idLog, int identacao, String destinatario, String assunto, String descricao ){
		this(log, idLog, identacao, new ArrayList<String>(), assunto, descricao);
		this.destinatarios.add(destinatario);
	}
	
	
	//TODO: Senoj --> Adicionar um m�todo  de configurar um email padr�o de origem
	private void enviaEmail() throws EmailException {
		boolean isExisteDestinatarios = false;
		SimpleEmail email = new SimpleEmail();
		
		// Inicializa destinatarios
		for(String dest: this.destinatarios){
			if (dest != null && dest.contains("@")) {
				log.info(idLog, identacao, "adicionando email " + dest);
				email.addTo(dest); // destinat�rio
				isExisteDestinatarios = true;
			}
		}
		
		// inicializa demais parametros
		/* Trecho abaixo comentado para a flex, pois sera usado servidor da flex
		 * no futuro devemos criar em omcfg as configuracoes necessarias
		email.setHostName("smtp.umbler.com"); // o servidor SMTP para envio do
		email.setFrom("injetmail@maptechnology.com.br"); // remetente
		email.setSubject(this.assunto); // assunto do e-mail
		email.setMsg(this.descricao); // conteudo do e-mail
		email.setAuthentication("injetmail@maptechnology.com.br", "{55e9s]pRD)e");
		email.setSmtpPort(587);
		email.setSslSmtpPort("587");
		email.setSSL(false);
		email.setTLS(false);
		email.setCharset("utf-8");
		 */
		
		
		email.setHostName("mail.flex-am.com.br");
		email.setFrom("srvlog.prd@flex-am.com.br");
		email.setSubject(assunto);
		email.setMsg(descricao);
		email.setSmtpPort(25);
		email.setSslSmtpPort("587");
		email.setSSL(false);
		email.setTLS(false);
		email.setCharset("utf-8");

		
		// envia email
		if (isExisteDestinatarios == true) {
			email.send();
			log.info(idLog, identacao, "email.send");
		}
	}
	
	@Override
	public void run() {
		try {
			enviaEmail();
		} catch (EmailException ex) {
			if (log != null){
				log.info(idLog, identacao, "Não foi possivel enviar o email pelo motivo abaixo");
				log.info(idLog, identacao, ex);
			}
		}
	}
	
	public static void main(String[] args) {
		IdwLogger log = new IdwLogger("testeemail");
		Email rn = new Email(log, 0, 0, "statusmaquinasolda@flex-am.com.br", "teste1", "teste1");
		try {
			rn.enviaEmail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
