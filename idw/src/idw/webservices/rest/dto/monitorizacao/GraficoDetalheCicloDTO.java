package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoDetalheCiclo")
public class GraficoDetalheCicloDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String descricao;
	private String pecas;
	private String pecasIndice;
	private String pecasIndiceCor;
	private String pesoKg;
	private String pesoKgIndice;
	private String pesoKgIndiceCor;
	private String pesoTon;
	private String pesoTonIndice;
	private String pesoTonIndiceCor;
	private String custo;
	private String custoIndice;
	private String custoIndiceCor;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPecas() {
		return pecas;
	}
	public void setPecas(String pecas) {
		this.pecas = pecas;
	}
	public String getPecasIndice() {
		return pecasIndice;
	}
	public void setPecasIndice(String pecasIndice) {
		this.pecasIndice = pecasIndice;
	}
	public String getPecasIndiceCor() {
		return pecasIndiceCor;
	}
	public void setPecasIndiceCor(String pecasIndiceCor) {
		this.pecasIndiceCor = pecasIndiceCor;
	}
	public String getPesoKg() {
		return pesoKg;
	}
	public void setPesoKg(String pesoKg) {
		this.pesoKg = pesoKg;
	}
	public String getPesoKgIndice() {
		return pesoKgIndice;
	}
	public void setPesoKgIndice(String pesoKgIndice) {
		this.pesoKgIndice = pesoKgIndice;
	}
	public String getPesoKgIndiceCor() {
		return pesoKgIndiceCor;
	}
	public void setPesoKgIndiceCor(String pesoKgIndiceCor) {
		this.pesoKgIndiceCor = pesoKgIndiceCor;
	}
	public String getPesoTon() {
		return pesoTon;
	}
	public void setPesoTon(String pesoTon) {
		this.pesoTon = pesoTon;
	}
	public String getPesoTonIndice() {
		return pesoTonIndice;
	}
	public void setPesoTonIndice(String pesoTonIndice) {
		this.pesoTonIndice = pesoTonIndice;
	}
	public String getPesoTonIndiceCor() {
		return pesoTonIndiceCor;
	}
	public void setPesoTonIndiceCor(String pesoTonIndiceCor) {
		this.pesoTonIndiceCor = pesoTonIndiceCor;
	}
	public String getCusto() {
		return custo;
	}
	public void setCusto(String custo) {
		this.custo = custo;
	}
	public String getCustoIndice() {
		return custoIndice;
	}
	public void setCustoIndice(String custoIndice) {
		this.custoIndice = custoIndice;
	}
	public String getCustoIndiceCor() {
		return custoIndiceCor;
	}
	public void setCustoIndiceCor(String custoIndiceCor) {
		this.custoIndiceCor = custoIndiceCor;
	}
	
	
	
	
}
