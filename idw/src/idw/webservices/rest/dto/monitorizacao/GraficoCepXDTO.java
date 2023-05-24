package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoCepX")
public class GraficoCepXDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<GraficoCepValoresDTO> valores;
	
	private String lscx;
	private String lcx;
	private String licx;
	private String lscr;
	private String lcr;
	private String licr;
	
	private String m;
	private String n;
	private String desvioPadrao;
	private String media;
	
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	private String cp;
	private String cpi;
	private String cps;
	private String cpk;
	
	private String meta;
	private String limInf;
	private String limSup;
	
	
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getLimInf() {
		return limInf;
	}
	public void setLimInf(String limInf) {
		this.limInf = limInf;
	}
	public String getLimSup() {
		return limSup;
	}
	public void setLimSup(String limSup) {
		this.limSup = limSup;
	}
	public List<GraficoCepValoresDTO> getValores() {
		return valores;
	}
	public void setValores(List<GraficoCepValoresDTO> valores) {
		this.valores = valores;
	}
	public String getLscx() {
		return lscx;
	}
	public void setLscx(String lscx) {
		this.lscx = lscx;
	}
	public String getLcx() {
		return lcx;
	}
	public void setLcx(String lcx) {
		this.lcx = lcx;
	}
	public String getLicx() {
		return licx;
	}
	public void setLicx(String licx) {
		this.licx = licx;
	}
	public String getLscr() {
		return lscr;
	}
	public void setLscr(String lscr) {
		this.lscr = lscr;
	}
	public String getLcr() {
		return lcr;
	}
	public void setLcr(String lcr) {
		this.lcr = lcr;
	}
	public String getLicr() {
		return licr;
	}
	public void setLicr(String licr) {
		this.licr = licr;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getDesvioPadrao() {
		return desvioPadrao;
	}
	public void setDesvioPadrao(String desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCpi() {
		return cpi;
	}
	public void setCpi(String cpi) {
		this.cpi = cpi;
	}
	public String getCps() {
		return cps;
	}
	public void setCps(String cps) {
		this.cps = cps;
	}
	public String getCpk() {
		return cpk;
	}
	public void setCpk(String cpk) {
		this.cpk = cpk;
	}
	
	
	
}
