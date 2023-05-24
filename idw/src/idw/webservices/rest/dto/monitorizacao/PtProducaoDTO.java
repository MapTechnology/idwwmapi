package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptProducao")
public class PtProducaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String producaoPrevista;
	private String producaoBruta;
	private String producaoLiquida;
	private String producaoRefugada;
	private String producaoNRParada;
	private String producaoNRBI;
	private String producaoNRCiclo;
	private String totalProducaoNR;
	
	public String getProducaoPrevista() {
		return producaoPrevista;
	}
	public void setProducaoPrevista(String producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}
	public String getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(String producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public String getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(String producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public String getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(String producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public String getProducaoNRParada() {
		return producaoNRParada;
	}
	public void setProducaoNRParada(String producaoNRParada) {
		this.producaoNRParada = producaoNRParada;
	}	
	public String getProducaoNRBI() {
		return producaoNRBI;
	}
	public void setProducaoNRBI(String producaoNRBI) {
		this.producaoNRBI = producaoNRBI;
	}
	public String getProducaoNRCiclo() {
		return producaoNRCiclo;
	}
	public void setProducaoNRCiclo(String producaoNRCiclo) {
		this.producaoNRCiclo = producaoNRCiclo;
	}
	public String getTotalProducaoNR() {
		return totalProducaoNR;
	}
	public void setTotalProducaoNR(String totalProducaoNR) {
		this.totalProducaoNR = totalProducaoNR;
	}
	
	
}
