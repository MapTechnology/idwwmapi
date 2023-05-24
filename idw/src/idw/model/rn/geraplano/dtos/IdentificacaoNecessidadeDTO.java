package idw.model.rn.geraplano.dtos;


public class IdentificacaoNecessidadeDTO {
	private Long idProduto;
	private Long idNec;
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Long getIdNec() {
		return idNec;
	}
	public void setIdNec(Long idNeccron) {
		this.idNec = idNeccron;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idNec == null) ? 0 : idNec.hashCode());
		result = prime * result
				+ ((idProduto == null) ? 0 : idProduto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentificacaoNecessidadeDTO other = (IdentificacaoNecessidadeDTO) obj;
		if (idNec == null) {
			if (other.idNec != null)
				return false;
		} else if (!idNec.equals(other.idNec))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
	
	
}
