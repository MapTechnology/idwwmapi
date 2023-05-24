package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoEvolucaoCicloPadrao")
public class GraficoEvolucaoCicloPadraoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String inicioValidade;
	private String cicloPadrao;
	private String revisao;
	private String revisaoUsuario;
	
	public String getInicioValidade() {
		return inicioValidade;
	}
	public void setInicioValidade(String inicioValidade) {
		this.inicioValidade = inicioValidade;
	}
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getRevisao() {
		return revisao;
	}
	public void setRevisao(String revisao) {
		this.revisao = revisao;
	}
	public String getRevisaoUsuario() {
		return revisaoUsuario;
	}
	public void setRevisaoUsuario(String revisaoUsuario) {
		this.revisaoUsuario = revisaoUsuario;
	}
	
	
}
