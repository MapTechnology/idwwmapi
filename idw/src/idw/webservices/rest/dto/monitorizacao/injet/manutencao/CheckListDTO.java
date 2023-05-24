package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.util.List;

public class CheckListDTO {
	private String cdCheckList;
	private String dsCheckList;
	private List<DetalheCheckListDTO> detalhesCheckList;
	
	public String getCdCheckList() {
		return cdCheckList;
	}
	public void setCdCheckList(String cdCheckList) {
		this.cdCheckList = cdCheckList;
	}
	public String getDsCheckList() {
		return dsCheckList;
	}
	public void setDsCheckList(String dsCheckList) {
		this.dsCheckList = dsCheckList;
	}
	public List<DetalheCheckListDTO> getDetalhesCheckList() {
		return detalhesCheckList;
	}
	public void setDetalhesCheckList(List<DetalheCheckListDTO> detalhesCheckList) {
		this.detalhesCheckList = detalhesCheckList;
	}
	
	
}
