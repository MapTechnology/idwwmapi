package idw.model.rn.folhainspecaorap;

public class QqInsRapDTO {

	private String cdInspecao;
	private Byte stInspecao;
	private String status = "200"; // codigo de sucesso
	private String title;

	public String getCdInspecao() {
		return cdInspecao;
	}
	public void setCdInspecao(String cdInspecao) {
		this.cdInspecao = cdInspecao;
	}
	public Byte getStInspecao() {
		return stInspecao;
	}
	public void setStInspecao(Byte stInspecao) {
		this.stInspecao = stInspecao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
