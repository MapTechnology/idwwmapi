package idw.webservices.dto;

import idw.model.pojos.DwRap;

public class FolhaFeederRapDTO {
	private String feederTable;
	private String feederTrack;
	private Long idRap;
	private DwRap dwRap;
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	public String getFeederTable() {
		return feederTable;
	}
	public void setFeederTable(String feederTable) {
		this.feederTable = feederTable;
	}
	public String getFeederTrack() {
		return feederTrack;
	}
	public void setFeederTrack(String feederTrack) {
		this.feederTrack = feederTrack;
	}
	public Long getIdRap() {
		return idRap;
	}
	public void setIdRap(Long idRap) {
		this.idRap = idRap;
	} 
}
