package idw.webservices.dto;

public class FolhaToRapDTO {
	private Long idRap;
	private String feederTable;
	
	public Long getIdRap() {
		return idRap;
	}
	public void setIdRap(Long idRap) {
		this.idRap = idRap;
	}
	
	public void setFeederTable(String feederTable) {
		this.feederTable = feederTable;
	}
	public String getFeederTable() {
		return feederTable;
	}
}
