package injetws.webservices.dto;

public class IwsErroDTO {
	
	private String mensagem = new String();
	private boolean sucesso = false;
	
	
	public IwsErroDTO() {
		
	}
	
	public String getMensagem() {
		return(this.mensagem);
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public boolean getSucesso() {
		return(this.sucesso);
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	
	
}
