package idw.model.rn.monitorizacao.detalhes.dto;

import java.io.Serializable;
import java.util.Date;

public class HistoricoSmedDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String cdPt;
	private Date dthrIPlanejado;
	private Date dthrFPlanejado;
	private Date dthrIReal;
	private Date dthrFReal;
	private Long segDuracaoPlanejada;
	private Long segDuracaoReal;
	private String operador;
	private String produto;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public Date getDthrIPlanejado() {
		return dthrIPlanejado;
	}
	public void setDthrIPlanejado(Date dthrIPlanejado) {
		this.dthrIPlanejado = dthrIPlanejado;
	}
	public Date getDthrFPlanejado() {
		return dthrFPlanejado;
	}
	public void setDthrFPlanejado(Date dthrFPlanejado) {
		this.dthrFPlanejado = dthrFPlanejado;
	}
	public Date getDthrIReal() {
		return dthrIReal;
	}
	public void setDthrIReal(Date dthrIReal) {
		this.dthrIReal = dthrIReal;
	}
	public Date getDthrFReal() {
		return dthrFReal;
	}
	public void setDthrFReal(Date dthrFReal) {
		this.dthrFReal = dthrFReal;
	}
	public Long getSegDuracaoPlanejada() {
		return segDuracaoPlanejada;
	}
	public void setSegDuracaoPlanejada(Long minDuracaoPlanejada) {
		this.segDuracaoPlanejada = minDuracaoPlanejada;
	}
	public Long getSegDuracaoReal() {
		return segDuracaoReal;
	}
	public void setSegDuracaoReal(Long minDuracaoReal) {
		this.segDuracaoReal = minDuracaoReal;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
}
