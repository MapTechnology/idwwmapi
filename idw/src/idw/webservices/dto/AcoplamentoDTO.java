package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AcoplamentoDTO implements Serializable {
	
	private long idFolha;
	private long idProduto;
	private String cb;
	private long idTppt;
	private long idPt;
	private long idProdutoAcoplado;
	private ResultadoDTO resultado = new ResultadoDTO();
	private String cdProduto;
	
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}
	
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	
	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	
	public long getIdProdutoAcoplado() {
		return idProdutoAcoplado;
	}
	public void setIdProdutoAcoplado(long idProdutoAcoplado) {
		this.idProdutoAcoplado = idProdutoAcoplado;
	}
	
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	
}
