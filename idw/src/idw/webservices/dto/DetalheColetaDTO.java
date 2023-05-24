package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class DetalheColetaDTO implements Serializable{
	private Date dthrColeta;
	private int msDthrColeta;
	private BigDecimal tensao;
	private BigDecimal corrente;
	private int fluxoEntrada;
	private int fluxoSaida;
	private String dsFluxoEntrada;
	private String dsFluxoSaida;
	
	public String getDsFluxoEntrada() {
		return dsFluxoEntrada;
	}
	public void setDsFluxoEntrada(String dsFluxoEntrada) {
		this.dsFluxoEntrada = dsFluxoEntrada;
	}
	public String getDsFluxoSaida() {
		return dsFluxoSaida;
	}
	public void setDsFluxoSaida(String dsFluxoSaida) {
		this.dsFluxoSaida = dsFluxoSaida;
	}
	public Date getDthrColeta() {
		return dthrColeta;
	}
	public void setDthrColeta(Date dthrColeta) {
		this.dthrColeta = dthrColeta;
	}
	public int getMsDthrColeta() {
		return msDthrColeta;
	}
	public void setMsDthrColeta(int msDthrColeta) {
		this.msDthrColeta = msDthrColeta;
	}
	public BigDecimal getTensao() {
		return tensao;
	}
	public void setTensao(BigDecimal tensao) {
		this.tensao = tensao;
	}
	public BigDecimal getCorrente() {
		return corrente;
	}
	public void setCorrente(BigDecimal corrente) {
		this.corrente = corrente;
	}
	public int getFluxoEntrada() {
		return fluxoEntrada;
	}
	public void setFluxoEntrada(int fluxoEntrada) {
		this.fluxoEntrada = fluxoEntrada;
	}
	public int getFluxoSaida() {
		return fluxoSaida;
	}
	public void setFluxoSaida(int fluxoSaida) {
		this.fluxoSaida = fluxoSaida;
	}
}
