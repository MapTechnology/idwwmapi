package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class FiltroGraficoDTO implements Serializable {
	
	private String ano;
	private String mes;
	private String semana;
	
	private BigDecimal idGrafico;
	
	private String linhaDefault;
	private String timeDefault;
	private String turnoDefault;
	private String turnoDefault01;
	private String turnoDefault02;
	private GraficoDTO grafico;
	
	public FiltroGraficoDTO(){
	
	}
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public BigDecimal getIdGrafico() {
		return idGrafico;
	}

	public void setIdGrafico(BigDecimal idGrafico) {
		this.idGrafico = idGrafico;
	}

	public String getLinhaDefault() {
		return linhaDefault;
	}

	public void setLinhaDefault(String linhaDefault) {
		this.linhaDefault = linhaDefault;
	}

	public String getTimeDefault() {
		return timeDefault;
	}

	public void setTimeDefault(String timeDefault) {
		this.timeDefault = timeDefault;
	}

	public String getTurnoDefault01() {
		return turnoDefault01;
	}

	public void setTurnoDefault01(String turnoDefault) {
		this.turnoDefault01 = turnoDefault;
	}

	public String getTurnoDefault02() {
		return turnoDefault02;
	}

	public void setTurnoDefault02(String turnoDefault02) {
		this.turnoDefault02 = turnoDefault02;
	}

	public String getTurnoDefault() {
		return turnoDefault;
	}

	public void setTurnoDefault(String turnoDefault) {
		this.turnoDefault = turnoDefault;
	}

	public GraficoDTO getGrafico() {
		return grafico;
	}

	public void setGrafico(GraficoDTO grafico) {
		this.grafico = grafico;
	}

}
