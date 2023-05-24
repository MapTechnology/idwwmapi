package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class IndicadoresPorDataInjetDTO implements Serializable{

	private Date data;
	private Float ec;
	private Float er;
	private Float ir;
	private Float ip;
	private Float ipd;
	private BigDecimal perdasCiclo;
	private BigDecimal perdasParada;
	private BigDecimal perdasRefugo;
	private BigDecimal perdasCavidades;

	public Float participacaoPerdasCavidadesNoTotalPerdas(){
		Float retorno = perdasCiclo.floatValue();
		if (getPerdasTotal().floatValue() > 0){
			retorno = retorno / getPerdasTotal().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float participacaoPerdasRefugoNoTotalPerdas(){
		Float retorno = perdasRefugo.floatValue();
		if (getPerdasTotal().floatValue() > 0){
			retorno = retorno / getPerdasTotal().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float participacaoPerdasCicloNoTotalPerdas(){
		Float retorno = perdasCiclo.floatValue();
		if (getPerdasTotal().floatValue() > 0){
			retorno = retorno / getPerdasTotal().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float participacaoPerdasParadaNoTotalPerdas(){
		Float retorno = perdasParada.floatValue();
		if (getPerdasTotal().floatValue() > 0){
			retorno = retorno / getPerdasTotal().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public BigDecimal getPerdasTotal(){
		return perdasCiclo.add(perdasParada).add(perdasRefugo).add(perdasCavidades);
	}
	/**
	 * @return the perdasCiclo
	 */
	public BigDecimal getPerdasCiclo() {
		return perdasCiclo;
	}
	/**
	 * @param perdasCiclo the perdasCiclo to set
	 */
	public void setPerdasCiclo(BigDecimal perdasCiclo) {
		this.perdasCiclo = perdasCiclo;
	}

	/**
	 * @return the perdasParada
	 */
	public BigDecimal getPerdasParada() {
		return perdasParada;
	}

	/**
	 * @param perdasParada the perdasParada to set
	 */
	public void setPerdasParada(BigDecimal perdasParada) {
		this.perdasParada = perdasParada;
	}

	/**
	 * @return the perdasRefugo
	 */
	public BigDecimal getPerdasRefugo() {
		return perdasRefugo;
	}

	/**
	 * @param perdasRefugo the perdasRefugo to set
	 */
	public void setPerdasRefugo(BigDecimal perdasRefugo) {
		this.perdasRefugo = perdasRefugo;
	}

	/**
	 * @return the perdasCavidades
	 */
	public BigDecimal getPerdasCavidades() {
		return perdasCavidades;
	}

	/**
	 * @param perdasCavidades the perdasCavidades to set
	 */
	public void setPerdasCavidades(BigDecimal perdasCavidades) {
		this.perdasCavidades = perdasCavidades;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the ec
	 */
	public Float getEc() {
		return ec;
	}
	/**
	 * @param ec the ec to set
	 */
	public void setEc(Float ec) {
		this.ec = ec;
	}
	/**
	 * @return the er
	 */
	public Float getEr() {
		return er;
	}
	/**
	 * @param er the er to set
	 */
	public void setEr(Float er) {
		this.er = er;
	}
	/**
	 * @return the ir
	 */
	public Float getIr() {
		return ir;
	}
	/**
	 * @param ir the ir to set
	 */
	public void setIr(Float ir) {
		this.ir = ir;
	}
	/**
	 * @return the ip
	 */
	public Float getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(Float ip) {
		this.ip = ip;
	}
	/**
	 * @return the ipd
	 */
	public Float getIpd() {
		return ipd;
	}
	/**
	 * @param ipd the ipd to set
	 */
	public void setIpd(Float ipd) {
		this.ipd = ipd;
	}

}
