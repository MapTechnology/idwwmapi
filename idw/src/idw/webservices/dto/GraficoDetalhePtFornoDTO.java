package idw.webservices.dto;


import java.util.List;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmedparamlog;

public class GraficoDetalhePtFornoDTO {

	private List<DwConsolmedparamlog> listaDwConsolMedParamLog;
	private List<DwConsolid> listaDwConsolId;
	
	public List<DwConsolmedparamlog> getListaDwConsolMedParamLog() {
		return listaDwConsolMedParamLog;
	}
	public void setListaDwConsolMedParamLog(
			List<DwConsolmedparamlog> listaDwConsolMedParamLog) {
		this.listaDwConsolMedParamLog = listaDwConsolMedParamLog;
	}
	public List<DwConsolid> getListaDwConsolId() {
		return listaDwConsolId;
	}
	public void setListaDwConsolId(List<DwConsolid> listaDwConsolId) {
		this.listaDwConsolId = listaDwConsolId;
	}
}
