package idw.webservices.rest.idw.v2.dto;

public class ParadaOcorDTO {
	private String cdParada;
	private String dsParada;
	private String cdCp;
	private String cdFerramenta;
	private String dtHrIniParMs; //ymdhms.m
	private String dtHrFimParMs; //ymdhms.m	
	private String duracaoParHMS;
	private Integer duracaoPar;
	private Boolean paradaAberta;
	
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getDsParada() {
		return dsParada;
	}
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public String getCdFerramenta() {
		return cdFerramenta;
	}
	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}
	public String getDtHrIniParMs() {
		return dtHrIniParMs;
	}
	public void setDtHrIniParMs(String dtHrIniParMs) {
		this.dtHrIniParMs = dtHrIniParMs;
	}
	public String getDtHrFimParMs() {
		return dtHrFimParMs;
	}
	public void setDtHrFimParMs(String dtHrFimParMs) {
		this.dtHrFimParMs = dtHrFimParMs;
	}
	public String getDuracaoParHMS() {
		return duracaoParHMS;
	}
	public void setDuracaoParHMS(String duracaoParHMS) {
		this.duracaoParHMS = duracaoParHMS;
	}
	public Integer getDuracaoPar() {
		return duracaoPar;
	}
	public void setDuracaoPar(Integer duracaoPar) {
		this.duracaoPar = duracaoPar;
	}
	public Boolean getParadaAberta() {
		return paradaAberta;
	}
	public void setParadaAberta(Boolean paradaAberta) {
		this.paradaAberta = paradaAberta;
	}
	
	
}
