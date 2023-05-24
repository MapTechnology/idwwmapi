package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwOperacao;

public class OperacaoInprocessDTO {

	private long idProdutoAcabado;
	private long idProdutoSemiAcabado;
	private long idTppt;
	private List<Long> listaIdOperacao;
	private List<String> listaCdOperacao;
	private String cdProdutoAcabado;
	private String cdProdutoSemiAcabado;
	private String cdTppt;
	
	public OperacaoInprocessDTO(){
		listaIdOperacao = new ArrayList<Long>();
		listaCdOperacao = new ArrayList<String>();
	}
	
	public OperacaoInprocessDTO(DwOperacao dwOperacao){
		listaIdOperacao = new ArrayList<Long>();
		listaCdOperacao = new ArrayList<String>();
		this.idProdutoAcabado = dwOperacao.getOmProdutoByIdProdutoacabado().getIdProduto();
		this.idProdutoSemiAcabado = dwOperacao.getOmProdutoByIdProdutosemiacabado().getIdProduto();
		this.idTppt = dwOperacao.getOmTppt().getIdTppt();
		this.listaIdOperacao.add(dwOperacao.getIdOperacao());
		this.listaCdOperacao.add(dwOperacao.getCdOperacao());
		this.cdProdutoAcabado = dwOperacao.getOmProdutoByIdProdutoacabado().getCdProduto();
		this.cdProdutoSemiAcabado = dwOperacao.getOmProdutoByIdProdutosemiacabado().getCdProduto();
		this.cdTppt = dwOperacao.getOmTppt().getCd();
	}
	
	public OperacaoInprocessDTO(long idProdutoAcabado,
			long idProdutoSemiAcabado, long idTppt, long idOperacao, String cdOperacao,
			String cdProdutoAcabado, String cdProdutoSemiAcabado, String cdTppt) {
		listaIdOperacao = new ArrayList<Long>();
		listaCdOperacao = new ArrayList<String>();
		this.idProdutoAcabado = idProdutoAcabado;
		this.idProdutoSemiAcabado = idProdutoSemiAcabado;
		this.idTppt = idTppt;
		this.listaIdOperacao.add(idOperacao);
		this.listaCdOperacao.add(cdOperacao);
		this.cdProdutoAcabado = cdProdutoAcabado;
		this.cdProdutoSemiAcabado = cdProdutoSemiAcabado;
		this.cdTppt = cdTppt;
	}
	public long getIdProdutoAcabado() {
		return idProdutoAcabado;
	}
	public void setIdProdutoAcabado(long idProdutoAcabado) {
		this.idProdutoAcabado = idProdutoAcabado;
	}
	public long getIdProdutoSemiAcabado() {
		return idProdutoSemiAcabado;
	}
	public void setIdProdutoSemiAcabado(long idProdutoSemiAcabado) {
		this.idProdutoSemiAcabado = idProdutoSemiAcabado;
	}
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	public List<Long> getIdOperacao() {
		return listaIdOperacao;
	}
	public void setIdOperacao(List<Long> idOperacao) {
		this.listaIdOperacao = idOperacao;
	}
	public String getCdProdutoAcabado() {
		return cdProdutoAcabado;
	}
	public void setCdProdutoAcabado(String cdProdutoAcabado) {
		this.cdProdutoAcabado = cdProdutoAcabado;
	}
	public String getCdProdutoSemiAcabado() {
		return cdProdutoSemiAcabado;
	}
	public void setCdProdutoSemiAcabado(String cdProdutoSemiAcabado) {
		this.cdProdutoSemiAcabado = cdProdutoSemiAcabado;
	}
	public String getCdTppt() {
		return cdTppt;
	}
	public void setCdPt(String cdTppt) {
		this.cdTppt = cdTppt;
	}

	public List<String> getListaCdOperacao() {
		return listaCdOperacao;
	}

	public void setListaCdOperacao(List<String> listaCdOperacao) {
		this.listaCdOperacao = listaCdOperacao;
	}
	
	
	
	
}
