package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class AOGalpaoInjetDTO implements Serializable{
	private String codigo;
	private String descricao;
	private List<AOMaquinaInjetDTO> maquinas;
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the maquinas
	 */
	public List<AOMaquinaInjetDTO> getMaquinas() {
		return maquinas;
	}
	/**
	 * @param maquinas the maquinas to set
	 */
	public void setMaquinas(List<AOMaquinaInjetDTO> maquinas) {
		this.maquinas = maquinas;
	}
}
