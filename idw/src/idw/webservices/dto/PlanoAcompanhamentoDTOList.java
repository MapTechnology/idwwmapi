package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.PpCp;

public class PlanoAcompanhamentoDTOList {
	
	private List<PlanoAcompanhamentoDTO> acompanhamentos = new ArrayList<PlanoAcompanhamentoDTO>();
	private List<PpCp> ppcps = new ArrayList<PpCp>();
	private Double indiceAtraso;
	private Double indiceAntecipacao;
	private Double mediaAtrasos;
	
	
	public Double getIndiceAtraso() {
		return indiceAtraso;
	}

	public void setIndiceAtraso(Double indiceAtraso) {
		this.indiceAtraso = indiceAtraso;
	}

	public Double getIndiceAntecipacao() {
		return indiceAntecipacao;
	}

	public void setIndiceAntecipacao(Double indiceAntecipacao) {
		this.indiceAntecipacao = indiceAntecipacao;
	}

	public Double getMediaAtrasos() {
		return mediaAtrasos;
	}

	public void setMediaAtrasos(Double mediaAtrasos) {
		this.mediaAtrasos = mediaAtrasos;
	}

	public PlanoAcompanhamentoDTOList(){
	}
	
	public PlanoAcompanhamentoDTOList(List<PlanoAcompanhamentoDTO> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	public List<PlanoAcompanhamentoDTO> getAcompanhamentos() {
		return acompanhamentos;
	}

	public void setAcompanhamentos(List<PlanoAcompanhamentoDTO> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	public void adicionaAcompanhamentoOuAcumula(List<PlanoAcompanhamentoDTO> pacomp){
		List<PlanoAcompanhamentoDTO> novosAcompanhamentos = new ArrayList<PlanoAcompanhamentoDTO>();
		for (PlanoAcompanhamentoDTO p : pacomp){
			// Verifica se p existe na lista geral de acompanhamentos
			boolean isExiste = false;
			for (PlanoAcompanhamentoDTO plocal : getAcompanhamentos()){
				if (plocal.getSemiProduto().equals(p.getSemiProduto()) == true){
					isExiste = true;
					// Acumula as ppnec
					plocal.getListaPpnec().addAll(p.getListaPpnec());
					
					// sai do for
					break;
				}
			}
			if (isExiste == false){
				// Incluir na lista dos elementos que comporao os acompanhamentos
				novosAcompanhamentos.add(p);
			}
		}
		
		// Finaliza adicionando os novosAcompanhamentos a lista geral de acompanhamentos
		this.acompanhamentos.addAll(novosAcompanhamentos);
	}

	public List<PpCp> getPpcps() {
		return ppcps;
	}

	public void setPpcps(List<PpCp> ppcps) {
		this.ppcps = ppcps;
	}
}
