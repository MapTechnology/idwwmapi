package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import idw.model.pojos.PpNec;

@SuppressWarnings("serial")
public class PpNecDTO extends PpNec implements Serializable{

	private ResultadoDTO resultadoDTO = new ResultadoDTO();
	private List<PpNeccronDTO> plano;
	Date inicioApontamento;
	Date fimApontamento;
	Date inicioPlanejamento;
	Date fimPlanejamento;
	
	public PpNecDTO(){
	}
	public PpNecDTO(PpNec ppnec){
		this.setCdNec(ppnec.getCdNec());
		this.setDtRevisao(ppnec.getDtRevisao());
		this.setDtStativo(ppnec.getDtStativo());
		this.setHrLeadtime(ppnec.getHrLeadtime());
		this.setIdNec(ppnec.getIdNec());
		this.setNrDoc(ppnec.getNrDoc());
		this.setOmProduto(ppnec.getOmProduto());
		this.setOmUsrByIdUsrrevisao(ppnec.getOmUsrByIdUsrrevisao());
		this.setOmUsrByIdUsrstativo(ppnec.getOmUsrByIdUsrstativo());
		this.setPpCliente(ppnec.getPpCliente());
		this.setPpNeccrons(ppnec.getPpNeccrons());
		this.setPpPlanecs(ppnec.getPpPlanecs());
		this.setRevisao(ppnec.getRevisao());
		this.setStAtivo(ppnec.getStAtivo());
		this.setTpNec(ppnec.getTpNec());
		this.setUrlOrigem(ppnec.getUrlOrigem());
				
	}	
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public void setPlano(List<PpNeccronDTO> plano) {
		this.plano = plano;
	}
	public List<PpNeccronDTO> getPlano() {
		return plano;
	}
	public Date getInicioApontamento() {
		return inicioApontamento;
	}
	public void setInicioApontamento(Date inicioApontamento) {
		this.inicioApontamento = inicioApontamento;
	}
	public Date getFimApontamento() {
		return fimApontamento;
	}
	public void setFimApontamento(Date fimApontamento) {
		this.fimApontamento = fimApontamento;
	}
	public Date getInicioPlanejamento() {
		return inicioPlanejamento;
	}
	public void setInicioPlanejamento(Date inicioPlanejamento) {
		this.inicioPlanejamento = inicioPlanejamento;
	}
	public Date getFimPlanejamento() {
		return fimPlanejamento;
	}
	public void setFimPlanejamento(Date fimPlanejamento) {
		this.fimPlanejamento = fimPlanejamento;
	}
}
