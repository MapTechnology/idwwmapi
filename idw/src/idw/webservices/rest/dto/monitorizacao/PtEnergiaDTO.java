package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptEnergia")
public class PtEnergiaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ordemProducao;
	private String producaoBrutaKwh;
	private String producaoLiquidaKwh;
	private String producaoRefugadaKwh;
	private String custoKwhProducaoBruta;
	private String custoKwhProducaoLiquida;
	private String custoKwhProducaoRefugada;
	private String energiaConsumidaKwh;
	private String producaoBruta;
	private String producaoLiquida;
	private String producaoRefugada;
	
	public String getOrdemProducao() {
		return ordemProducao;
	}
	public void setOrdemProducao(String ordemProducao) {
		this.ordemProducao = ordemProducao;
	}
	public String getProducaoBrutaKwh() {
		return producaoBrutaKwh;
	}
	public void setProducaoBrutaKwh(String producaoBrutaKwh) {
		this.producaoBrutaKwh = producaoBrutaKwh;
	}
	public String getProducaoLiquidaKwh() {
		return producaoLiquidaKwh;
	}
	public void setProducaoLiquidaKwh(String producaoLiquidaKwh) {
		this.producaoLiquidaKwh = producaoLiquidaKwh;
	}
	public String getProducaoRefugadaKwh() {
		return producaoRefugadaKwh;
	}
	public void setProducaoRefugadaKwh(String producaoRefugadaKwh) {
		this.producaoRefugadaKwh = producaoRefugadaKwh;
	}
	public String getCustoKwhProducaoBruta() {
		return custoKwhProducaoBruta;
	}
	public void setCustoKwhProducaoBruta(String custoKwhProducaoBruta) {
		this.custoKwhProducaoBruta = custoKwhProducaoBruta;
	}
	public String getCustoKwhProducaoLiquida() {
		return custoKwhProducaoLiquida;
	}
	public void setCustoKwhProducaoLiquida(String custoKwhProducaoLiquida) {
		this.custoKwhProducaoLiquida = custoKwhProducaoLiquida;
	}
	public String getCustoKwhProducaoRefugada() {
		return custoKwhProducaoRefugada;
	}
	public void setCustoKwhProducaoRefugada(String custoKwhProducaoRefugada) {
		this.custoKwhProducaoRefugada = custoKwhProducaoRefugada;
	}
	public String getEnergiaConsumidaKwh() {
		return energiaConsumidaKwh;
	}
	public void setEnergiaConsumidaKwh(String energiaConsumidaKwh) {
		this.energiaConsumidaKwh = energiaConsumidaKwh;
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
	
	
}
