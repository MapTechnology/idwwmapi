package idw.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmailDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> destinatarios = new ArrayList<>();
	private String assunto = "";
	private String mensagem = "";
	
	private List<EmailArquivoDTO> arquivos = new ArrayList<>();

	public List<String> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<EmailArquivoDTO> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<EmailArquivoDTO> arquivos) {
		this.arquivos = arquivos;
	}

	
}
