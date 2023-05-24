package ms.coleta.dto;

import java.util.List;

public class SessaoICDTO {
	private List<SessaoUPDTO> ups;
	private SessaoCfgDTO cfgDefault;
	private SessaoAndonDTO andon;
	
	public List<SessaoUPDTO> getUps() {
		return ups;
	}

	public void setUps(List<SessaoUPDTO> ups) {
		this.ups = ups;
	}

	public SessaoCfgDTO getCfgDefault() {
		return cfgDefault;
	}

	public void setCfgDefault(SessaoCfgDTO cfgDefault) {
		this.cfgDefault = cfgDefault;
	}

	public SessaoAndonDTO getAndon() {
		return andon;
	}

	public void setAndon(SessaoAndonDTO andon) {
		this.andon = andon;
	}
}
