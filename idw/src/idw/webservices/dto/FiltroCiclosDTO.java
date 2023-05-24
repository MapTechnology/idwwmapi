package idw.webservices.dto;

import idw.model.pojos.DwFolha;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class FiltroCiclosDTO {
	
	private OmPt omPt;
	private PpCp ppCp;
	private DwFolha dwFolha;
	private Boolean recuperarTodosOsCiclos;
	private FiltroAnaliseTurnoDTO analiseTurnoDTO;
	
	public PpCp getPpCp() {
		return ppCp;
	}

	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}

	public OmPt getOmPt() {
		return omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	
	public FiltroAnaliseTurnoDTO getAnaliseTurnoDTO() {
		return analiseTurnoDTO;
	}

	public void setAnaliseTurnoDTO(FiltroAnaliseTurnoDTO analiseTurnoDTO) {
		this.analiseTurnoDTO = analiseTurnoDTO;
	}

	public Boolean getRecuperarTodosOsCiclos() {
		return recuperarTodosOsCiclos;
	}

	public void setRecuperarTodosOsCiclos(Boolean recuperarTodosOsCiclos) {
		this.recuperarTodosOsCiclos = recuperarTodosOsCiclos;
	}

	public DwFolha getDwFolha() {
		return dwFolha;
	}

	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}
	
	
	
}
