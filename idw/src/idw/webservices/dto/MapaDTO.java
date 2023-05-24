package idw.webservices.dto;

import java.io.Serializable;

import idw.util.Util;

@SuppressWarnings("serial")
public class MapaDTO implements Serializable{
	private String Unit;
    private String PartsName;
    private int qtdComponentes;
    private String TipoFeeder;
    private String Side;
//    private String nomeMaquina;
//   private String nomePrograma;
//   private String Linha;
    
    /**
     * Mascaras
     */
    private String mascaraComponente = "??????";
    
    public MapaDTO(){
    
    }
    public MapaDTO(String unit, String partsName, int componentes, String tipoFeeder, String side/*, String NomeMaquina, String NomePrograma*/){
    	this.Unit = unit;
    	this.PartsName = partsName;
    	this.qtdComponentes = componentes;
    	this.TipoFeeder = tipoFeeder;
    	this.Side = side;
//    	this.nomeMaquina = NomeMaquina;
//    	this.nomePrograma = NomePrograma;
    }
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		Unit = unit;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return Unit;
	}
	/**
	 * @param partsName the partsName to set
	 */
	public void setPartsName(String partsName) {
		PartsName = partsName;
	}
	/**
	 * @return the partsName
	 */
	public String getPartsName() {
		return Util.extraiPorMascara(PartsName, mascaraComponente);
	}
	/**
	 * @param qtdComponentes the qtdComponentes to set
	 */
	public void setQtdComponentes(int qtdComponentes) {
		this.qtdComponentes = qtdComponentes;
	}
	/**
	 * @return the qtdComponentes
	 */
	public int getQtdComponentes() {
		return qtdComponentes;
	}
	/**
	 * @param tipoFeeder the tipoFeeder to set
	 */
	public void setTipoFeeder(String tipoFeeder) {
		TipoFeeder = tipoFeeder;
	}
	/**
	 * @return the tipoFeeder
	 */
	public String getTipoFeeder() {
		return TipoFeeder;
	}
	/*v*
	 * @param nomeMaquina the nomeMaquina to set
	 */
/*	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}
	*//* *

	 * @return the nomeMaquina
	 */
/*	public String getNomeMaquina() {
		return nomeMaquina;
	}
	*/ /**
	 * @param nomePrograma the nomePrograma to set
	 */
	/*public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}*/
	/**
	 * @return the nomePrograma
	 */
	/*public String getNomePrograma() {
		return nomePrograma;
	}*/
	/*public void setLinha(String linha) {
		Linha = linha;
	}*
	public String getLinha() {
		return Linha;
	}*/
	public void setSide(String side) {
		Side = side;
	}
	public String getSide() {
		return Side;
	}

}

