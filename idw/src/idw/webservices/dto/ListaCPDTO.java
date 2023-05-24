package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.OmPt;

@XmlRootElement
public class ListaCPDTO {

	private List<CpDTO> listaCps = new ArrayList<>();
	private List<CpDTO> listaCpsAux;
	private Boolean isIhmtrocaop;
	private Boolean isPtSemop = false;
	private Boolean isInclusao; // Se true eh pq a GUI esta tentando incluir ao inves de alterar

	private ResultadoDTO resultado;

	public List<CpDTO> getListaCps() {
		return listaCps;
	}

	public List<CpDTO> getListaCpsAux() {
		return listaCpsAux;
	}

	public void setListaCpsAux(List<CpDTO> listaCpsAux) {
		this.listaCpsAux = listaCpsAux;
	}

	public void setListaCps(List<CpDTO> listaCps) {
		this.listaCps = listaCps;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public Boolean getIsIhmtrocaop() {
		return isIhmtrocaop;
	}

	public void setIsIhmtrocaop(Boolean isIhmtrocaop) {
		this.isIhmtrocaop = isIhmtrocaop;
	}

	public Boolean getIsPtSemop() {
		return isPtSemop;
	}

	public void setIsPtSemop(Boolean isPtSemop) {
		this.isPtSemop = isPtSemop;
	}

	public Boolean getIsInclusao() {
		return isInclusao;
	}

	public void setIsInclusao(Boolean isInclusao) {
		this.isInclusao = isInclusao;
	}

	public boolean isExistePt(OmPt ompt) {
		for (CpDTO cpdto : this.listaCps) {
			if (cpdto.getCp().getOmPt().getCdPt().equals(ompt.getCdPt()))
				return true;
		}
		return false;
	}
}
