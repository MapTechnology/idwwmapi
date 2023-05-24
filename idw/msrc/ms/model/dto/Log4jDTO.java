package ms.model.dto;

public class Log4jDTO {

	private boolean desabilitarLog;
	private String nivel;
	private String tamanho;
	private String qtdeArquivos;
	private String diretorio;
		
	
	public String getNivel() {
		return nivel;
	}
	
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getQtdeArquivos() {
		return qtdeArquivos;
	}
	
	public void setQtdeArquivos(String qtdeArquivos) {
		this.qtdeArquivos = qtdeArquivos;
	}
	
	public String getDiretorio() {
		return diretorio;
	}
	
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public void setDesabilitarLog(boolean desabilitarLog) {
		this.desabilitarLog = desabilitarLog;
	}

	public boolean isDesabilitarLog() {
		return desabilitarLog;
	}
	
	
}
