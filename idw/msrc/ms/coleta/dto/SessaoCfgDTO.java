package ms.coleta.dto;

public class SessaoCfgDTO {
	private long idCfg;
	private boolean isLoginObrigatorio;
	private String mascaraCb = "";
	private boolean isRequerTecnicoInicioCIP;
	private boolean isRequerTecnicoFimCIP;
	private String cdParadaDefault = "";
	private String dsParadaDefault = "";
	private String cdParadaCIPDefault = "";
	private String dsParadaCIPDefault = "";
	private String cdAlertaCIPDefault = "";
	private String cdRitmoDefault = "";
	private String dsRitmoDefault = "";
	
	public long getIdCfg() {
		return idCfg;
	}
	public void setIdCfg(long idCfg) {
		this.idCfg = idCfg;
	}
	public boolean isLoginObrigatorio() {
		return isLoginObrigatorio;
	}
	public void setLoginObrigatorio(boolean isLoginObrigatorio) {
		this.isLoginObrigatorio = isLoginObrigatorio;
	}
	public String getMascaraCb() {
		return mascaraCb;
	}
	public void setMascaraCb(String mascaraCb) {
		this.mascaraCb = mascaraCb;
	}
	public boolean isRequerTecnicoInicioCIP() {
		return isRequerTecnicoInicioCIP;
	}
	public void setRequerTecnicoInicioCIP(boolean isRequerTecnicoInicioCIP) {
		this.isRequerTecnicoInicioCIP = isRequerTecnicoInicioCIP;
	}
	public boolean isRequerTecnicoFimCIP() {
		return isRequerTecnicoFimCIP;
	}
	public void setRequerTecnicoFimCIP(boolean isRequerTecnicoFimCIP) {
		this.isRequerTecnicoFimCIP = isRequerTecnicoFimCIP;
	}
	public String getCdParadaDefault() {
		return cdParadaDefault;
	}
	public void setCdParadaDefault(String cdParadaDefault) {
		this.cdParadaDefault = cdParadaDefault;
	}
	public String getDsParadaDefault() {
		return dsParadaDefault;
	}
	public void setDsParadaDefault(String dsParadaDefault) {
		this.dsParadaDefault = dsParadaDefault;
	}
	public String getCdParadaCIPDefault() {
		return cdParadaCIPDefault;
	}
	public void setCdParadaCIPDefault(String cdParadaCIPDefault) {
		this.cdParadaCIPDefault = cdParadaCIPDefault;
	}
	public String getDsParadaCIPDefault() {
		return dsParadaCIPDefault;
	}
	public void setDsParadaCIPDefault(String dsParadaCIPDefault) {
		this.dsParadaCIPDefault = dsParadaCIPDefault;
	}
	public String getCdAlertaCIPDefault() {
		return cdAlertaCIPDefault;
	}
	public void setCdAlertaCIPDefault(String cdAlertaCIPDefault) {
		this.cdAlertaCIPDefault = cdAlertaCIPDefault;
	}
	public String getCdRitmoDefault() {
		return cdRitmoDefault;
	}
	public void setCdRitmoDefault(String cdRitmoDefault) {
		this.cdRitmoDefault = cdRitmoDefault;
	}
	public String getDsRitmoDefault() {
		return dsRitmoDefault;
	}
	public void setDsRitmoDefault(String dsRitmoDefault) {
		this.dsRitmoDefault = dsRitmoDefault;
	}
}
