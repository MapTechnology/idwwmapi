package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ProgramasInsersorasDTO implements Serializable {
	private long idPt;
	private String cdPt;
	private String depara;
	private List<ProgramaInsersoraDTO> programasInsersorasDTO;

	public List<ProgramaInsersoraDTO> getProgramasInsersorasDTO() {
		return programasInsersorasDTO;
	}

	public void setProgramasInsersorasDTO(
			List<ProgramaInsersoraDTO> programasInsersorasDTO) {
		this.programasInsersorasDTO = programasInsersorasDTO;
	}

	public long getIdPt() {
		return idPt;
	}

	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}

	public String getCdPt() {
		return cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

	public String getDepara() {
		return depara;
	}

	public void setDepara(String depara) {
		this.depara = depara;
	}
}
