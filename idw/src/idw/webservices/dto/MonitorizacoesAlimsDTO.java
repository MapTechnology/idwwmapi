package idw.webservices.dto;

import java.util.List;

public class MonitorizacoesAlimsDTO {

	private String cdPt;
	private String cdMapa;
	private List<MonitorizacaoAlimDTO> ompaproList;

	public List<MonitorizacaoAlimDTO> getOmpaproList() {
		return ompaproList;
	}

	public void setOmpaproList(List<MonitorizacaoAlimDTO> ompaproList) {
		this.ompaproList = ompaproList;
	}
	
	
	public List<MonitorizacaoAlimDTO> getLista() {
		return this.ompaproList;
	}
	
	public void setLista(List<MonitorizacaoAlimDTO> ompaproList) {
		this.ompaproList = ompaproList;
	}

	public String getCdPt() {
		return cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

	public String getCdMapa() {
		return cdMapa;
	}

	public void setCdMapa(String cdMapa) {
		this.cdMapa = cdMapa;
	}
	
	
}
