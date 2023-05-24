package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.Agrupamento;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.TipoPeso;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.TipoProducao;

@XmlRootElement(name="filtroRelatorios")
public class FiltroRelatoriosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// No caso do "Índice de Paradas", o tipo pode ser: Padrão, Por Ferramenta, Por Produto
	// private String tipo;

	private String dtEmissao;
	private String op;
	private String dthrIni;
	private String dthrFim;
	private String cdTurno;
	private String cdPt;
	private String cdGt;
	private String cdFerramenta;
	private String cdGrpFerramenta;
	private boolean isTodasParadas;
	private List<String> listaCdParadas;
	private boolean isTodasAreas;
	private List<String> listaCdAreas;
	private boolean isAgrupadoPorPt;
	private boolean isAgrupadoPorFerramenta;
	private boolean isAgrupadoPorProduto;
	private boolean isProducaoEmPeca;
	private boolean isProducaoEmPesoBruto;
	private boolean isProducaoEmPesoLiquido;
	private boolean isPesoEmKg;
	private boolean isPesoEmTon;
	
	public String getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getDthrIni() {
		return dthrIni;
	}
	public void setDthrIni(String dthrIni) {
		this.dthrIni = dthrIni;
	}
	public String getDthrFim() {
		return dthrFim;
	}
	public void setDthrFim(String dthrFim) {
		this.dthrFim = dthrFim;
	}
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getCdFerramenta() {
		return cdFerramenta;
	}
	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}
	public String getCdGrpFerramenta() {
		return cdGrpFerramenta;
	}
	public void setCdGrpFerramenta(String cdGrpFerramenta) {
		this.cdGrpFerramenta = cdGrpFerramenta;
	}
	public boolean getIsTodasParadas() {
		return isTodasParadas;
	}
	public void setIsTodasParadas(boolean isTodasParadas) {
		this.isTodasParadas = isTodasParadas;
	}
	public List<String> getListaCdParadas() {
		return listaCdParadas;
	}
	public void setListaCdParadas(List<String> listaCdParadas) {
		this.listaCdParadas = listaCdParadas;
	}
	public boolean getIsTodasAreas() {
		return isTodasAreas;
	}
	public void setIsTodasAreas(boolean isTodasAreas) {
		this.isTodasAreas = isTodasAreas;
	}	
	public List<String> getListaCdAreas() {
		return listaCdAreas;
	}
	public void setListaCdAreas(List<String> listaCdAreas) {
		this.listaCdAreas = listaCdAreas;
	}
	public boolean getIsAgrupadoPorPt() {
		return isAgrupadoPorPt;
	}
	public void setIsAgrupadoPorPt(boolean isAgrupadoPorPt) {
		this.isAgrupadoPorPt = isAgrupadoPorPt;
	}
	public boolean getIsAgrupadoPorFerramenta() {
		return isAgrupadoPorFerramenta;
	}
	public void setIsAgrupadoPorFerramenta(boolean isAgrupadoPorFerramenta) {
		this.isAgrupadoPorFerramenta = isAgrupadoPorFerramenta;
	}
	public boolean getIsAgrupadoPorProduto() {
		return isAgrupadoPorProduto;
	}
	public void setIsAgrupadoPorProduto(boolean isAgrupadoPorProduto) {
		this.isAgrupadoPorProduto = isAgrupadoPorProduto;
	}
	public boolean getIsProducaoEmPeca() {
		return isProducaoEmPeca;
	}
	public void setIsProducaoEmPeca(boolean isProducaoEmPeca) {
		this.isProducaoEmPeca = isProducaoEmPeca;
	}
	public boolean getIsProducaoEmPesoBruto() {
		return isProducaoEmPesoBruto;
	}
	public void setIsProducaoEmPesoBruto(boolean isProducaoEmPesoBruto) {
		this.isProducaoEmPesoBruto = isProducaoEmPesoBruto;
	}
	public boolean getIsProducaoEmPesoLiquido() {
		return isProducaoEmPesoLiquido;
	}
	public void setIsProducaoEmPesoLiquido(boolean isProducaoEmPesoLiquido) {
		this.isProducaoEmPesoLiquido = isProducaoEmPesoLiquido;
	}
	public boolean getIsPesoEmKg() {
		return isPesoEmKg;
	}
	public void setIsPesoEmKg(boolean isPesoEmKg) {
		this.isPesoEmKg = isPesoEmKg;
	}
	public boolean getIsPesoEmTon() {
		return isPesoEmTon;
	}
	public void setIsPesoEmTon(boolean isPesoEmTon) {
		this.isPesoEmTon = isPesoEmTon;
	}
	
}
