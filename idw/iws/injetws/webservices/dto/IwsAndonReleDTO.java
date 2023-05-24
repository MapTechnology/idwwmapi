package injetws.webservices.dto;

import java.util.ArrayList;
import java.util.List;

public class IwsAndonReleDTO {
	private String idup;
	private IwsReleDTO relayFromBeat;
	private List<IwsAndonDTO> listaAndonFromBeat = new ArrayList<IwsAndonDTO>();
	
	private Boolean isComAlertaProblemaQualidade = null;
	// 2 - usado para determinar que esta variável não foi moficicada
	
	private Boolean isInspecaoPendente = null;
	// 2 - usado para determinar que esta variável não foi moficicada
	
	private Integer resultadoUltimaInspecao = null;
	//vlauria 20100404
	/*	A variável resultadoUltimaInspecao segue a seguinte lógica:
	 *		0 - não há resultado 
	 *		1 - aprovado
	 *		2 - reprovado
	 *		3 - aprovado com restrição
	 *		4 - usado apenas para determinar que esta variável não foi modificada  
	 */
	
	public void setIdup(String idup) {
		this.idup = idup;
	}
	public String getIdup() {
		return idup;
	}
	public void setListaAndon(List<IwsAndonDTO> listaAndon) {
		if(listaAndon != null && listaAndon.size() >0)
			this.listaAndonFromBeat.addAll(listaAndon);
	}
	public List<IwsAndonDTO> getListaAndon() {
		return listaAndonFromBeat;
	}
	public void setRelayFromBeat(IwsReleDTO relayFromBeat) {
		this.relayFromBeat = relayFromBeat;
	}
	public IwsReleDTO getRelayFromBeat() {
		return relayFromBeat;
	}
	
	public void setIsComAlertaProblemaQualidade(Boolean isComAlertaProblemaQualidade) {
		this.isComAlertaProblemaQualidade = isComAlertaProblemaQualidade;
	}
	public Boolean getIsComAlertaProblemaQualidade() {
		return isComAlertaProblemaQualidade;
	}
	
	public void setResultadoUltimaInspecao(Integer resultadoUltimaInspecao) {
		this.resultadoUltimaInspecao = resultadoUltimaInspecao;
	}
	public Integer getResultadoUltimaInspecao() {
		return resultadoUltimaInspecao;
	}
	
	public void setIsInspecaoPendente(Boolean isInspecaoPendente) {
		this.isInspecaoPendente = isInspecaoPendente;
	}
	public Boolean getIsInspecaoPendente() {
		return isInspecaoPendente;
	}
}
