package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ExpArquivoExportadoDTO implements Serializable {
	
	private String nomeArquivo;
	private String tituloComponente1;
	private String tituloComponente2;
	private List<ExpLinhaExportadaDTO> linhas;
	private String conteudo;
	private boolean isGravarCabecalho = true;
	
	public boolean isGravarCabecalho() {
		return isGravarCabecalho;
	}
	public void setGravarCabecalho(boolean isGravarCabecalho) {
		this.isGravarCabecalho = isGravarCabecalho;
	}
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public String getTituloComponente1() {
		return tituloComponente1;
	}
	public void setTituloComponente1(String tituloComponente1) {
		this.tituloComponente1 = tituloComponente1;
	}
	public String getTituloComponente2() {
		return tituloComponente2;
	}
	public void setTituloComponente2(String tituloComponente2) {
		this.tituloComponente2 = tituloComponente2;
	}
	public List<ExpLinhaExportadaDTO> getLinhas() {
		return linhas;
	}
	public void setLinhas(List<ExpLinhaExportadaDTO> linhas) {
		this.linhas = linhas;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
			
}
