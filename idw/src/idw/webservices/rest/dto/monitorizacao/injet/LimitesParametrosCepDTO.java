package idw.webservices.rest.dto.monitorizacao.injet;

public class LimitesParametrosCepDTO {
	private String cdPt;
	private String cdRap;
	private String cdEstrutura;
	private String limiteInferior;
	private String meta;
	private String limiteSuperior;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}
	public String getCdEstrutura() {
		return cdEstrutura;
	}
	public void setCdEstrutura(String cdEstrutura) {
		this.cdEstrutura = cdEstrutura;
	}
	public String getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(String limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getLimiteSuperior() {
		return limiteSuperior;
	}
	public void setLimiteSuperior(String limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}
	
	
}
