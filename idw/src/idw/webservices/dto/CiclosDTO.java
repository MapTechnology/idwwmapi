package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CiclosDTO{
	private List<CicloDTO> listaCicloDTO = new ArrayList<CicloDTO>();
	private BigDecimal k;
	private BigDecimal cicloPadrao;
	private BigDecimal segCicloMinimo;
	private BigDecimal percCicloMaximo;
	private BigDecimal cavAtivas;
	private BigDecimal metaHora;
	private CapabilidadeProcessoDTO capabilidadeProcessoDTO;
	private List<IntervaloDTO> listaIntervaloDTO = new ArrayList<>();	
	
	public CiclosDTO(){		
	}
	
	public CapabilidadeProcessoDTO getCapabilidadeProcessoDTO() {
		return capabilidadeProcessoDTO;
	}

	public void setCapabilidadeProcessoDTO(
			CapabilidadeProcessoDTO capabilidadeProcessoDTO) {
		this.capabilidadeProcessoDTO = capabilidadeProcessoDTO;
	}

	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}

	public BigDecimal getCavAtivas() {
		return cavAtivas;
	}

	public void setCavAtivas(BigDecimal cavAtivas) {
		this.cavAtivas = cavAtivas;
	}

	public BigDecimal getMetaHora() {
		return metaHora;
	}

	public void setMetaHora(BigDecimal metaHora) {
		this.metaHora = metaHora;
	}

	public List<CicloDTO> getListaCicloDTO() {
		return listaCicloDTO;
	}

	public void setListaCicloDTO(List<CicloDTO> listaCicloDTO) {
		this.listaCicloDTO = listaCicloDTO;
	}

	public List<IntervaloDTO> getListaIntervaloDTO() {
		return listaIntervaloDTO;
	}

	public void setListaIntervaloDTO(List<IntervaloDTO> listaIntervaloDTO) {
		this.listaIntervaloDTO = listaIntervaloDTO;
	}

	public BigDecimal getK() {
		return k;
	}

	public void setK(BigDecimal k) {
		this.k = k;
	}

	public BigDecimal getSegCicloMinimo() {
		return segCicloMinimo;
	}

	public void setSegCicloMinimo(BigDecimal segCicloMinimo) {
		this.segCicloMinimo = segCicloMinimo;
	}

	public BigDecimal getPercCicloMaximo() {
		return percCicloMaximo;
	}

	public void setPercCicloMaximo(BigDecimal percCicloMaximo) {
		this.percCicloMaximo = percCicloMaximo;
	}
}
