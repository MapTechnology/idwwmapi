package injetws.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class IwsListaMatPrimaDTO implements Serializable {

	private List<IwsProdMateriaPrimaDTO> materiasPrimas = new ArrayList<IwsProdMateriaPrimaDTO>();
	private boolean erro = false;
	/**
	 * @param materiasPrimas the materiasPrimas to set
	 */
	public void setMateriasPrimas(List<IwsProdMateriaPrimaDTO> materiasPrimas) {
		this.materiasPrimas = materiasPrimas;
	}
	/**
	 * @return the materiasPrimas
	 */
	public List<IwsProdMateriaPrimaDTO> getMateriasPrimas() {
		return materiasPrimas;
	}
	/**
	 * @param erro the erro to set
	 */
	public void setErro(boolean erro) {
		this.erro = erro;
	}
	/**
	 * @return the erro
	 */
	public boolean isErro() {
		return erro;
	}
	
	public void copyListMatPrima(List<IwsProdMateriaPrimaDTO> materias) {
		if(materias != null) {
			for(IwsProdMateriaPrimaDTO materia : materias) {
				IwsProdMateriaPrimaDTO mat = new IwsProdMateriaPrimaDTO();
				mat.setIdRegistro(materia.getIdRegistro());
				mat.setCdMateriaPrima(materia.getCdMateriaPrima());
				mat.setCdProduto(materia.getCdProduto());
				mat.setDsMateriaPrima(materia.getDsMateriaPrima());
				mat.setDsProduto(materia.getDsProduto());
				mat.setIdUp(materia.getIdUp());
				mat.setUnidade(materia.getUnidade());
				mat.setEstoque(materia.getEstoque());
				mat.setLote(materia.getLote());
				mat.setControlalote(materia.getControlalote());
				
				this.materiasPrimas.add(mat);
			}
		}
		else this.materiasPrimas = null;
	}
}
