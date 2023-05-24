package idw.webservices.rest.dto.dashboard.flex;

import java.math.BigDecimal;

import idw.model.rn.DataHoraRN;

public class DashboardFlexHoraDTO {
	private String dthrIhora;
	private String hora;
	private BigDecimal downtime;
	private int meta;
	private int produzidos;
	private int defeitos;
	private int scraps;
	
	private double indfor;

	
	public String getDowntimeFormatado() {
		return DataHoraRN.formatSegundosParaHHMMSS(this.downtime);
	}
	public BigDecimal getDowntime() {
		return downtime;
	}
	public void setDowntime(BigDecimal downtime) {
		this.downtime = downtime;
	}
	public int getMeta() {
		return meta;
	}
	public void setMeta(int meta) {
		this.meta = meta;
	}
	public String getDthrIhoraFormatado() {
		return dthrIhora;
	}
	public void setDthrIhoraFormatado(String dthrIhora) {
		this.dthrIhora = dthrIhora;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getProduzidos() {
		return produzidos;
	}
	public void setProduzidos(int produzido) {
		this.produzidos = produzido;
	}
	public int getDefeitos() {
		return defeitos;
	}
	public void setDefeitos(int defeitos) {
		this.defeitos = defeitos;
	}
	public int getScraps() {
		return scraps;
	}
	public void setScraps(int scraps) {
		this.scraps = scraps;
	}
	public double getIndfor() {
		return indfor;
	}
	public void setIndfor(double indfor) {
		this.indfor = indfor;
	}

}
