package idw.model.rn.geraplano.dtos;

import idw.model.pojos.OmProduto;

public class ProdutoComparable implements Comparable<ProdutoComparable>{
	private OmProduto omproduto;
	private Integer prioridade;
	
	public OmProduto getOmproduto() {
		return omproduto;
	}
	public void setOmproduto(OmProduto omproduto) {
		this.omproduto = omproduto;
	}
	@Override
	public int compareTo(ProdutoComparable o) {
		// A prioridade do produto eh definida conforme a odernacao das necessidades dentro do plano
		int retorno = 0;
		if (this.prioridade != null && o.getPrioridade() != null)
			retorno = this.prioridade.compareTo(o.getPrioridade());
		else
			retorno = getOmproduto().getCdProduto().compareTo(o.getOmproduto().getCdProduto());
		
		return retorno;
	}
	@Override
	public String toString(){
		return omproduto.getCdProduto();
	}
	public Integer getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
}
