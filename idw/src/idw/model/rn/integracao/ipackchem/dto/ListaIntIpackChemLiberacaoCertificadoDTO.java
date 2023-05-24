package idw.model.rn.integracao.ipackchem.dto;

import java.util.List;

public class ListaIntIpackChemLiberacaoCertificadoDTO 
{
	private List<IntIpackChemCGQLiberadoDTO> listaCertificadosLiberados;

	public List<IntIpackChemCGQLiberadoDTO> getListaCertificadosLiberados() {
		return listaCertificadosLiberados;
	}

	public void setListaCertificadosLiberados(
			List<IntIpackChemCGQLiberadoDTO> listaCertificadosLiberados) {
		this.listaCertificadosLiberados = listaCertificadosLiberados;
	}
	
	
}
