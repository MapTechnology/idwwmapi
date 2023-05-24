package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwNserie;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

public class OrdemProducaoProdutoDTO {
	
	private OmProduto produto;
	private Date dthrInicioPlanejado;
	private Date dthrFimPlanejado;
	private BigDecimal producaoPlanejada;
	private OmPt pt;
	private OmGt gt;
	private List<DwNserie> dwNseries;
	
	public OmProduto getProduto() {
		return produto;
	}
	public void setProduto(OmProduto produto) {
		this.produto = produto;
	}
	public Date getDthrInicioPlanejado() {
		return dthrInicioPlanejado;
	}
	public void setDthrInicioPlanejado(Date dthrInicioPlanejado) {
		this.dthrInicioPlanejado = dthrInicioPlanejado;
	}
	public Date getDthrFimPlanejado() {
		return dthrFimPlanejado;
	}
	public void setDthrFimPlanejado(Date dthrFimPlanejado) {
		this.dthrFimPlanejado = dthrFimPlanejado;
	}
	public BigDecimal getProducaoPlanejada() {
		return producaoPlanejada;
	}
	public void setProducaoPlanejada(BigDecimal producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	public OmPt getPt() {
		return pt;
	}
	public void setPt(OmPt pt) {
		this.pt = pt;
	}
	public OmGt getGt() {
		return gt;
	}
	public void setGt(OmGt gt) {
		this.gt = gt;
	}
	public List<DwNserie> getDwNseries() {
		return dwNseries;
	}
	public void setDwNseries(List<DwNserie> dwNseries) {
		this.dwNseries = dwNseries;
	}
	
}