package idw.model.rn.injet.dto;

import java.util.Date;

import idw.model.rn.DataHoraRN;
import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class ParadaInjetDTO implements java.io.Serializable{

	private String cdParada;
	private String dsParada;
	private Float tempoParadaSegundos;
	private Float tempoTotal;
	private boolean isParadaPesa = true;
	private String dsAreaResponsavel = "";
	
	// Abaixo alguns atributos adicionais para guardar as ocorrencias das parada
	private Date dthriParada;
	private Date dthrfParada;
	/**
	 * @return the cdParada
	 */
	public String getCdParada() {
		return cdParada;
	}
	/**
	 * @param cdParada the cdParada to set
	 */
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	/**
	 * @return the dsParada
	 */
	public String getDsParada() {
		return dsParada;
	}
	/**
	 * @param dsParada the dsParada to set
	 */
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}
	/**
	 * @return the tempoParadaSegundos
	 */
	public Float getTempoParadaSegundos() {
		return tempoParadaSegundos;
	}
	public Float getTempoParadaHorasFormatado(){
		return FormulasInjet.formatarCasaDecimalDoFloat(tempoParadaSegundos / 3600f);
	}

	public String getTempoParadaFormatado(){
		return DataHoraRN.formatSegundosParaHHMM( getTempoParadaSegundos().intValue());
	}

	public Float getTempoParadaHoras(){
		return (tempoParadaSegundos / 3600f);
	}
	/**
	 * @param tempoParadaSegundos the tempoParadaSegundos to set
	 */
	public void setTempoParadaSegundos(Float tempoParadaSegundos) {
		this.tempoParadaSegundos = tempoParadaSegundos;
	}

	public void addTempoParadaSegundos(Float tempoParadaSegundos) {
		this.tempoParadaSegundos += tempoParadaSegundos;
	}

	/**
	 * @return the indiceParada
	 */
	public Float getIndiceTempoDaParada() {
		Float retorno = 0f;

		if (tempoTotal.intValue() > 0){
			retorno = (tempoParadaSegundos / tempoTotal);
			retorno *= 100f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}
	/**
	 * @return the tempoTotal
	 */
	public Float getTempoTotal() {
		return tempoTotal;
	}
	/**
	 * @param tempoTotal the tempoTotal to set
	 */
	public void setTempoTotal(Float tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	/**
	 * @return the isParadaPesa
	 */
	public boolean isParadaPesa() {
		return isParadaPesa;
	}
	/**
	 * @param isParadaPesa the isParadaPesa to set
	 */
	public void setParadaPesa(boolean isParadaPesa) {
		this.isParadaPesa = isParadaPesa;
	}
	public String getDsAreaResponsavel() {
		return dsAreaResponsavel;
	}
	public void setDsAreaResponsavel(String dsAreaResponsavel) {
		this.dsAreaResponsavel = dsAreaResponsavel;
	}
	public Date getDthriParada() {
		return dthriParada;
	}
	public void setDthriParada(Date dthriParada) {
		this.dthriParada = dthriParada;
	}
	public Date getDthrfParada() {
		return dthrfParada;
	}
	public void setDthrfParada(Date dthrfParada) {
		this.dthrfParada = dthrfParada;
	}
}
