package idw.model.rn.injet.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AODetalheInjetDTO implements Serializable{
	private int ano = 0;
	private int mes = 0;
	private Float divisorParaMediaAcumulada = 0f;
	private String dsDetalhe = "";
	private Float oee = 0f;
	private Float oeecapital = 0f;
	private Float eficienciareal = 0f;
	private Float indparada = 0f;
	private Float indrefugo = 0f;
	private Float eficiclo = 0f;
	private Float indperda = 0f;
	
	// MaquinaDTO servira para guardar as informacoes para calculo do Acumulado do relatorio
	private MaquinaInjetDTO maquinaDTO = new MaquinaInjetDTO();
	/**
	 * @return the oee
	 */
	public Float getOee() {
		return oee;
	}
	/**
	 * @param oee the oee to set
	 */
	public void setOee(Float oee) {
		this.oee = oee;
	}
	/**
	 * @return the oeecapital
	 */
	public Float getOeecapital() {
		return oeecapital;
	}
	/**
	 * @param oeecapital the oeecapital to set
	 */
	public void setOeecapital(Float oeecapital) {
		this.oeecapital = oeecapital;
	}
	/**
	 * @return the eficienciareal
	 */
	public Float getEficienciareal() {
		return eficienciareal;
	}
	/**
	 * @param eficienciareal the eficienciareal to set
	 */
	public void setEficienciareal(Float eficienciareal) {
		this.eficienciareal = eficienciareal;
	}
	/**
	 * @return the indparada
	 */
	public Float getIndparada() {
		return indparada;
	}
	/**
	 * @param indparada the indparada to set
	 */
	public void setIndparada(Float indparada) {
		this.indparada = indparada;
	}
	/**
	 * @return the indrefugo
	 */
	public Float getIndrefugo() {
		return indrefugo;
	}
	/**
	 * @param indrefugo the indrefugo to set
	 */
	public void setIndrefugo(Float indrefugo) {
		this.indrefugo = indrefugo;
	}
	/**
	 * @return the eficiclo
	 */
	public Float getEficiclo() {
		return eficiclo;
	}
	/**
	 * @param eficiclo the eficiclo to set
	 */
	public void setEficiclo(Float eficiclo) {
		this.eficiclo = eficiclo;
	}
	/**
	 * @return the indperda
	 */
	public Float getIndperda() {
		return indperda;
	}
	/**
	 * @param indperda the indperda to set
	 */
	public void setIndperda(Float indperda) {
		this.indperda = indperda;
	}
	/**
	 * @return the dsDetalhe
	 */
	public String getDsDetalhe() {
		return dsDetalhe;
	}
	/**
	 * @param dsDetalhe the dsDetalhe to set
	 */
	public void setDsDetalhe(String dsDetalhe) {
		this.dsDetalhe = dsDetalhe;
	}
	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}
	/**
	 * @return the maquinaDTO
	 */
	public MaquinaInjetDTO getMaquinaDTO() {
		return maquinaDTO;
	}
	/**
	 * @param maquinaDTO the maquinaDTO to set
	 */
	public void setMaquinaDTO(MaquinaInjetDTO maquinaDTO) {
		this.maquinaDTO = maquinaDTO;
	}
	/**
	 * @return the ano
	 */
	public int getAno() {
		return ano;
	}
	/**
	 * @param ano the ano to set
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}
	/**
	 * @return the divisorParaMediaAcumulada
	 */
	public Float getDivisorParaMediaAcumulada() {
		return divisorParaMediaAcumulada;
	}
	/**
	 * @param divisorParaMediaAcumulada the divisorParaMediaAcumulada to set
	 */
	public void setDivisorParaMediaAcumulada(Float divisorParaMediaAcumulada) {
		this.divisorParaMediaAcumulada = divisorParaMediaAcumulada;
	}
	
}
