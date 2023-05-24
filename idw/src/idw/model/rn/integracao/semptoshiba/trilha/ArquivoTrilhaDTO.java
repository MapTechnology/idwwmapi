package idw.model.rn.integracao.semptoshiba.trilha;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ArquivoTrilhaDTO implements Serializable {

	private String nome;
	private String conteudo;

	public ArquivoTrilhaDTO() {

	}

	public ArquivoTrilhaDTO(String nome, String conteudo) {
		this.nome = nome;
		this.conteudo = conteudo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
