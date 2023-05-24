package idw.model.rn.integracao.erp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwNserie;
import idw.model.pojos.OmGt;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.PtDTO;

public class OpIntegracaoDTO {

	private String nrop;
	private Date dthrIplanejada;
	private Date dthrFplanejada;
	private String nrLoteMp;
	private String dtLoteMp;
	private String resultadoImportacao;
	private String tipoOP;
	private String cdGt;
	
	private List<ProdutoDTO> produtos = new ArrayList<>();
	private List<PtDTO> postos = new ArrayList<>();
	private List<OmGt> grupos = new ArrayList<>();
	
	private List<DwNserie> seriais = new ArrayList<>();
		
	public String getNrop() {
		return nrop;
	}
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	public Date getDthrIplanejada() {
		return dthrIplanejada;
	}
	public void setDthrIplanejada(Date dthrIplanejada) {
		this.dthrIplanejada = dthrIplanejada;
	}
	public Date getDthrFplanejada() {
		return dthrFplanejada;
	}
	public void setDthrFplanejada(Date dthrFplanejada) {
		this.dthrFplanejada = dthrFplanejada;
	}
	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	public List<PtDTO> getPostos() {
		return postos;
	}
	public void setPostos(List<PtDTO> postos) {
		this.postos = postos;
	}
	public String getResultadoImportacao() {
		return resultadoImportacao;
	}
	public void setResultadoImportacao(String resultadoImportacao) {
		this.resultadoImportacao = resultadoImportacao;
	}
	public List<OmGt> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<OmGt> grupos) {
		this.grupos = grupos;
	}
	public String getNrLoteMp() {
		return nrLoteMp;
	}
	public void setNrLoteMp(String nrLoteMp) {
		this.nrLoteMp = nrLoteMp;
	}
	public String getDtLoteMp() {
		return dtLoteMp;
	}
	public void setDtLoteMp(String dtLoteMp) {
		this.dtLoteMp = dtLoteMp;
	}
	public String getTipoOP() {
		return tipoOP;
	}
	public void setTipoOP(String tipoOP) {
		this.tipoOP = tipoOP;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public List<DwNserie> getSeriais() {
		return seriais;
	}
	public void setSeriais(List<DwNserie> seriais) {
		this.seriais = seriais;
	}
	
}
