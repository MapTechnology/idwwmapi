package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="resumoPerdaGanhoCiclo")
public class ResumoPerdaGanhoCicloDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String periodo;
	private String eficienciaCiclo;
	private String ganhosTotaisPecas;
	private String ganhosTotaisKg;
	private String ganhosTotaisTon;
	private String perdasTotaisPecas;
	private String perdasTotaisKg;
	private String perdasTotaisTon;
	private String saldoPecas;
	private String saldoKg;
	private String saldoTon;
	
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(String eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public String getGanhosTotaisPecas() {
		return ganhosTotaisPecas;
	}
	public void setGanhosTotaisPecas(String ganhosTotaisPecas) {
		this.ganhosTotaisPecas = ganhosTotaisPecas;
	}
	public String getGanhosTotaisKg() {
		return ganhosTotaisKg;
	}
	public void setGanhosTotaisKg(String ganhosTotaisKg) {
		this.ganhosTotaisKg = ganhosTotaisKg;
	}
	public String getGanhosTotaisTon() {
		return ganhosTotaisTon;
	}
	public void setGanhosTotaisTon(String ganhosTotaisTon) {
		this.ganhosTotaisTon = ganhosTotaisTon;
	}
	public String getPerdasTotaisPecas() {
		return perdasTotaisPecas;
	}
	public void setPerdasTotaisPecas(String perdasTotaisPecas) {
		this.perdasTotaisPecas = perdasTotaisPecas;
	}
	public String getPerdasTotaisKg() {
		return perdasTotaisKg;
	}
	public void setPerdasTotaisKg(String perdasTotaisKg) {
		this.perdasTotaisKg = perdasTotaisKg;
	}
	public String getPerdasTotaisTon() {
		return perdasTotaisTon;
	}
	public void setPerdasTotaisTon(String perdasTotaisTon) {
		this.perdasTotaisTon = perdasTotaisTon;
	}
	public String getSaldoPecas() {
		return saldoPecas;
	}
	public void setSaldoPecas(String saldoPecas) {
		this.saldoPecas = saldoPecas;
	}
	public String getSaldoKg() {
		return saldoKg;
	}
	public void setSaldoKg(String saldoKg) {
		this.saldoKg = saldoKg;
	}
	public String getSaldoTon() {
		return saldoTon;
	}
	public void setSaldoTon(String saldoTon) {
		this.saldoTon = saldoTon;
	}
	
	
}
