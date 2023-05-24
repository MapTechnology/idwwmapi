package idw.webservices.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ResultadoSubetapaDTO {
	private long idSubetapa;
	private int ordemSubetapa;
	private boolean isPassou;
	
	private Date dthrISubetapaPreFalha;
	private Date dthrFSubetapaPreFalha;
	private Date dthrISubetapaPosFalha;
	private Date dthrFSubetapaPosFalha;
	
	private List<ResultadoMedicaoDTO> medicoes = new ArrayList<ResultadoMedicaoDTO>();
	

	public int getOrdemSubetapa() {
		return ordemSubetapa;
	}

	public void setOrdemSubetapa(int ordemSubetapa) {
		this.ordemSubetapa = ordemSubetapa;
	}

	public Date getDthrISubetapaPreFalha() {
		return dthrISubetapaPreFalha;
	}

	public void setDthrISubetapaPreFalha(Date dthrISubetapaPreFalha) {
		this.dthrISubetapaPreFalha = dthrISubetapaPreFalha;
	}

	public Date getDthrFSubetapaPreFalha() {
		return dthrFSubetapaPreFalha;
	}

	public void setDthrFSubetapaPreFalha(Date dthrFSubetapaPreFalha) {
		this.dthrFSubetapaPreFalha = dthrFSubetapaPreFalha;
	}

	public Date getDthrISubetapaPosFalha() {
		return dthrISubetapaPosFalha;
	}

	public void setDthrISubetapaPosFalha(Date dthrISubetapaPosFalha) {
		this.dthrISubetapaPosFalha = dthrISubetapaPosFalha;
	}

	public Date getDthrFSubetapaPosFalha() {
		return dthrFSubetapaPosFalha;
	}

	public void setDthrFSubetapaPosFalha(Date dthrFSubetapaPosFalha) {
		this.dthrFSubetapaPosFalha = dthrFSubetapaPosFalha;
	}

	public List<ResultadoMedicaoDTO> getMedicoes() {
		return medicoes;
	}

	public void setMedicoes(List<ResultadoMedicaoDTO> medicoes) {
		this.medicoes = medicoes;
	}

	public boolean isPassou() {
		return isPassou;
	}

	public void setPassou(boolean isPassou) {
		this.isPassou = isPassou;
	}

	public long getIdSubetapa() {
		return idSubetapa;
	}

	public void setIdSubetapa(long idSubetapa) {
		this.idSubetapa = idSubetapa;
	}
}
