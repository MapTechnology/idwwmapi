package idw.webservices.rest.dto.monitorizacao.injet.bi;

public class BiIndicadoresFicTecDTO {
	private String cdPt;
	private String cdRap;
	private String cdEstrutura;
	private BiIndicadoresDTO indicadores = new BiIndicadoresDTO();
		
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
	public BiIndicadoresDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(BiIndicadoresDTO indicadores) {
		this.indicadores = indicadores;
	}
	
}
