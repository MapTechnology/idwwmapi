package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="filtroDetalhePosto")
public class FiltroDetalhePostoDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private long idConsolid;
	private int filtroOp;
	private String cdCp;
	private String dtReferencia;
	private String dtHrReferenciaInicial;
	private String dtHrReferenciaFinal;
	private long idTurno;
	private String cdPosto;
	private Byte tpId;
	private long idProduto;
	private String cdProduto;
	private String cdGt;
	private int tipoPosto;
	private long idRap;

	private boolean gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos
	// gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos cujos PTs são de natureza semelhante . Exemplo: "5g_01_LIN01", "5g_02_LIN01", etc.
	
	
	private String cdTipoPosto;

	public long getIdConsolid() {
		return idConsolid;
	}
	public void setIdConsolid(long idConsolid) {
		this.idConsolid = idConsolid;
	}
	public int getFiltroOp() {
		return filtroOp;
	}
	public void setFiltroOp(int filtroOp) {
		this.filtroOp = filtroOp;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public String getDtHrReferenciaInicial() {
		return dtHrReferenciaInicial;
	}
	public void setDtHrReferenciaInicial(String dtHrReferenciaInicial) {
		this.dtHrReferenciaInicial = dtHrReferenciaInicial;
	}
	public String getDtHrReferenciaFinal() {
		return dtHrReferenciaFinal;
	}
	public void setDtHrReferenciaFinal(String dtHrReferenciaFinal) {
		this.dtHrReferenciaFinal = dtHrReferenciaFinal;
	}
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	public String getCdPosto() {
		return cdPosto;
	}
	public void setCdPosto(String cdPosto) {
		this.cdPosto = cdPosto;
	}
	public Byte getTpId() {
		return tpId;
	}
	public void setTpId(Byte tpId) {
		this.tpId = tpId;
	}
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public int getTipoPosto() {
		return tipoPosto;
	}
	public void setTipoPosto(int tipoPosto) {
		this.tipoPosto = tipoPosto;
	}
	public long getIdRap() {
		return idRap;
	}
	public void setIdRap(long idRap) {
		this.idRap = idRap;
	}
	
	public String getCdTipoPosto() {
		return cdTipoPosto;
	}
	public void setCdTipoPosto(String cdTipoPosto) {
		this.cdTipoPosto = cdTipoPosto;
	}
	
	public boolean isGargalosAgrupados() {
		return gargalosAgrupados;
	}
	public void setGargalosAgrupados(boolean isGargalosAgrupados) {
		this.gargalosAgrupados = isGargalosAgrupados;
	}

	public FiltroDetalhePostoDTO getCopia() {
		FiltroDetalhePostoDTO copia = new FiltroDetalhePostoDTO();
		copia.idConsolid = this.idConsolid;
		copia.filtroOp = this.filtroOp;
		copia.cdCp = this.cdCp;
		copia.dtReferencia = this.dtReferencia;
		copia.dtHrReferenciaInicial = this.dtHrReferenciaInicial;
		copia.dtHrReferenciaFinal = this.dtHrReferenciaFinal;
		copia.idTurno = this.idTurno;
		copia.cdPosto = this.cdPosto;
		copia.tpId = this.tpId;
		copia.idProduto = this.idProduto;
		copia.cdProduto = this.cdProduto;
		copia.cdGt = this.cdGt;
		copia.tipoPosto = this.tipoPosto;
		copia.idRap = this.idRap;
		return copia;
	}
	
	
	
}