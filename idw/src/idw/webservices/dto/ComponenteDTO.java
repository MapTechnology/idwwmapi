package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ComponenteDTO implements Serializable {
	
	private long idProduto;
	private String cb;
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProdutoEsperado) {
		this.idProduto = idProdutoEsperado;
	}
}
