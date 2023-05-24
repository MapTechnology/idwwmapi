package idw.webservices.dto;

import idw.model.rn.geraplano.dtos.IdCtDTO;

public class AlocacaoProdutoMaquinaDTO {
	
	private CpsDTO cps = new CpsDTO();
	private IdCtDTO id;
	private int tempoExecucaoCps;
	private CpDTO cpReferencia = new CpDTO();
	
	public CpsDTO getCps() {
		return cps;
	}
	public void setCps(CpsDTO cps) {
		this.cps = cps;
	}
	public IdCtDTO getId() {
		return id;
	}
	public void setId(IdCtDTO id) {
		this.id = id;
	}
	public int getTempoExecucaoCps() {
		return tempoExecucaoCps;
	}
	public void setTempoExecucaoCps(int tempoExecucaoCps) {
		this.tempoExecucaoCps = tempoExecucaoCps;
	}
	public CpDTO getCpReferencia() {
		return cpReferencia;
	}
	public void setCpReferencia(CpDTO cpReferencia) {
		this.cpReferencia = cpReferencia;
	}
	
	
	
}
