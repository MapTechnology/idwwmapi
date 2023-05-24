package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptMonitorizacao")
public class PerdaProducaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String viewProduto;
	private String eficienciaCiclo;
	private String perdasIneficienciaCiclo;
	private String indiceParada;
	private String perdasPorParada;
	private String indiceRefugo;
	private String perdasPorRefugo;
	private String indiceCavidadesAtivas;
	private String perdasPorCavidadesInativas;
	private String totalPerdas;
	
	public String getViewProduto() {
		return viewProduto;
	}
	public void setViewProduto(String viewProduto) {
		this.viewProduto = viewProduto;
	}
	public String getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(String eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public String getPerdasIneficienciaCiclo() {
		return perdasIneficienciaCiclo;
	}
	public void setPerdasIneficienciaCiclo(String perdasIneficienciaCiclo) {
		this.perdasIneficienciaCiclo = perdasIneficienciaCiclo;
	}
	public String getIndiceParada() {
		return indiceParada;
	}
	public void setIndiceParada(String indiceParada) {
		this.indiceParada = indiceParada;
	}
	public String getPerdasPorParada() {
		return perdasPorParada;
	}
	public void setPerdasPorParada(String perdasPorParada) {
		this.perdasPorParada = perdasPorParada;
	}
	public String getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(String indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public String getPerdasPorRefugo() {
		return perdasPorRefugo;
	}
	public void setPerdasPorRefugo(String perdasPorRefugo) {
		this.perdasPorRefugo = perdasPorRefugo;
	}
	public String getIndiceCavidadesAtivas() {
		return indiceCavidadesAtivas;
	}
	public void setIndiceCavidadesAtivas(String indiceCavidadesAtivas) {
		this.indiceCavidadesAtivas = indiceCavidadesAtivas;
	}
	public String getPerdasPorCavidadesInativas() {
		return perdasPorCavidadesInativas;
	}
	public void setPerdasPorCavidadesInativas(String perdasPorCavidadesInativas) {
		this.perdasPorCavidadesInativas = perdasPorCavidadesInativas;
	}
	public String getTotalPerdas() {
		return totalPerdas;
	}
	public void setTotalPerdas(String totalPerdas) {
		this.totalPerdas = totalPerdas;
	}
	
	
}
