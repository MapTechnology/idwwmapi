package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class AOMaquinaInjetDTO  implements Serializable{
	private String codigo;
	private String descricao;
	private List<AODetalheInjetDTO> detalhes;
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
	 * @return the detalhes
	 */
	public List<AODetalheInjetDTO> getDetalhes() {
		return detalhes;
	}
	/**
	 * @param detalhes the detalhes to set
	 */
	public void setDetalhes(List<AODetalheInjetDTO> detalhes) {
		this.detalhes = detalhes;
	}

}
