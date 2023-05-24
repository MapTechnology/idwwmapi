package ms.coleta.ic.inova.dto;

import java.util.ArrayList;
import java.util.List;

import injetws.webservices.dto.IwsListaMatPrimaDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;

@SuppressWarnings("serial")
public class INovaListaMatPrimaDTO extends IwsListaMatPrimaDTO {
	
	private String idup;
	private int ultimaMatPrimaLida = 0;
	
	
	public String getIdup() {
		return idup;
	}
	public void setIdup(String idup) {
		this.idup = idup;
	}
	public int getUltimaMatPrimaLida() {
		return ultimaMatPrimaLida;
	}
	public void setUltimaMatPrimaLida(int ultimaMatPrimaLida) {
		this.ultimaMatPrimaLida = ultimaMatPrimaLida;
	}
	
	
	public void copyListaMatPrimaWS(IwsListaMatPrimaDTO materias) {
		this.setMateriasPrimas(new ArrayList<IwsProdMateriaPrimaDTO>());
		
		List<IwsProdMateriaPrimaDTO> materiaPrima = materias.getMateriasPrimas();
		
		for(IwsProdMateriaPrimaDTO materia : materiaPrima) {
			IwsProdMateriaPrimaDTO mat = new IwsProdMateriaPrimaDTO();
			
//			mat.copyPrUpProdMatPrimaWS(materia);
			mat = materia;
			
			this.getMateriasPrimas().add(mat);
		}
	}
	
	
}
