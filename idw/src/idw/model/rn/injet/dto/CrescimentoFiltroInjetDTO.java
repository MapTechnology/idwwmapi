package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CrescimentoFiltroInjetDTO implements Serializable {

	private List<String> galpoes;
	private Integer mes;
	private Integer ano;
	
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public List<String> getGalpoes() {
		return galpoes;
	}
	public void setGalpoes(List<String> galpoes) {
		this.galpoes = galpoes;
	}
	
	
}
