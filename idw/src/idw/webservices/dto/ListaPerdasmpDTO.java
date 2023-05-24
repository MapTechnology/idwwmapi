package idw.webservices.dto;

import idw.model.rn.geraplano.dtos.DatasDTO;

import java.util.List;

public class ListaPerdasmpDTO {
	
	private List<PerdasmpDTO> perdasmpDTOs;
	private List<PerdasmpDTO> perdasmpOPDTOs;
	private List<PerdasmpDTO> perdasmpAlimDTOs;
	private List<PerdasmpDTO> perdasmpRapDTOs;
	private String indicePerdasMP;
	private String indicePerdasRAP;
	private DatasDTO corVerde;
	private DatasDTO corAmarela;
	private DatasDTO corLaranja;
	private DatasDTO corVermelho;
	private DatasDTO corVerdeRap;
	private DatasDTO corAmarelaRap;
	private DatasDTO corLaranjaRap;
	private DatasDTO corVermelhoRap;
	
	public List<PerdasmpDTO> getPerdasmpDTOs() {
		return perdasmpDTOs;
	}
	public void setPerdasmpDTOs(List<PerdasmpDTO> perdasmpDTOs) {
		this.perdasmpDTOs = perdasmpDTOs;
	}
	public List<PerdasmpDTO> getPerdasmpRapDTOs() {
		return perdasmpRapDTOs;
	}
	public void setPerdasmpRapDTOs(List<PerdasmpDTO> perdasmpRapDTOs) {
		this.perdasmpRapDTOs = perdasmpRapDTOs;
	}
	public String getIndicePerdasMP() {
		return indicePerdasMP;
	}
	public void setIndicePerdasMP(String indicePerdasMP) {
		this.indicePerdasMP = indicePerdasMP;
	}
	public String getIndicePerdasRAP() {
		return indicePerdasRAP;
	}
	public void setIndicePerdasRAP(String indicePerdasRAP) {
		this.indicePerdasRAP = indicePerdasRAP;
	}
	public DatasDTO getCorVerde() {
		return corVerde;
	}
	public void setCorVerde(DatasDTO corVerde) {
		this.corVerde = corVerde;
	}
	public DatasDTO getCorAmarela() {
		return corAmarela;
	}
	public void setCorAmarela(DatasDTO corAmarela) {
		this.corAmarela = corAmarela;
	}
	public DatasDTO getCorLaranja() {
		return corLaranja;
	}
	public void setCorLaranja(DatasDTO corLaranja) {
		this.corLaranja = corLaranja;
	}
	public DatasDTO getCorVermelho() {
		return corVermelho;
	}
	public void setCorVermelho(DatasDTO corVermelho) {
		this.corVermelho = corVermelho;
	}
	public DatasDTO getCorVerdeRap() {
		return corVerdeRap;
	}
	public void setCorVerdeRap(DatasDTO corVerdeRap) {
		this.corVerdeRap = corVerdeRap;
	}
	public DatasDTO getCorAmarelaRap() {
		return corAmarelaRap;
	}
	public void setCorAmarelaRap(DatasDTO corAmarelaRap) {
		this.corAmarelaRap = corAmarelaRap;
	}
	public DatasDTO getCorLaranjaRap() {
		return corLaranjaRap;
	}
	public void setCorLaranjaRap(DatasDTO corLaranjaRap) {
		this.corLaranjaRap = corLaranjaRap;
	}
	public DatasDTO getCorVermelhoRap() {
		return corVermelhoRap;
	}
	public void setCorVermelhoRap(DatasDTO corVermelhoRap) {
		this.corVermelhoRap = corVermelhoRap;
	}
	public List<PerdasmpDTO> getPerdasmpOPDTOs() {
		return perdasmpOPDTOs;
	}
	public void setPerdasmpOPDTOs(List<PerdasmpDTO> perdasmpOPDTOs) {
		this.perdasmpOPDTOs = perdasmpOPDTOs;
	}
	public List<PerdasmpDTO> getPerdasmpAlimDTOs() {
		return perdasmpAlimDTOs;
	}
	public void setPerdasmpAlimDTOs(List<PerdasmpDTO> perdasmpAlimDTOs) {
		this.perdasmpAlimDTOs = perdasmpAlimDTOs;
	}	
}
