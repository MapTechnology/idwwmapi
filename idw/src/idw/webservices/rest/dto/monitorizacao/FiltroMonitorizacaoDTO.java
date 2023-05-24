package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="filtroMonitorizacao")
public class FiltroMonitorizacaoDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	private String dtReferencia;
	private long idTurno;
	private int filtroOp;
	private String cdGt;
	private boolean turnoAtual;
	private List<FiltroDetalhePostoDTO> listaFiltroPosto;
	private List<Long> listaFiltroIdGt;
	private boolean gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos
	// gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos cujos PTs são de natureza semelhante . Exemplo: "5g_01_LIN01", "5g_02_LIN01", etc.

	public List<Long> getListaFiltroIdGt() {
		return listaFiltroIdGt;
	}
	public void setListaFiltroIdGt(List<Long> listaFiltroIdGt) {
		this.listaFiltroIdGt = listaFiltroIdGt;
	}
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	public int getFiltroOp() {
		return filtroOp;
	}
	public void setFiltroOp(int filtroOp) {
		this.filtroOp = filtroOp;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public boolean isTurnoAtual() {
		return turnoAtual;
	}
	public void setTurnoAtual(boolean turnoAtual) {
		this.turnoAtual = turnoAtual;
	}
	public List<FiltroDetalhePostoDTO> getListaFiltroPosto() {
		return listaFiltroPosto;
	}
	public void setListaFiltroPosto(List<FiltroDetalhePostoDTO> listaFiltroPosto) {
		this.listaFiltroPosto = listaFiltroPosto;
	}
	

	
	public boolean isGargalosAgrupados() {
		return gargalosAgrupados;
	}
	public void setGargalosAgrupados(boolean isGargalosAgrupados) {
		this.gargalosAgrupados = isGargalosAgrupados;
	}
	
	
	@Override
	public String toString() {
		return "FiltroMonitorizacaoDTO [dtReferencia=" + dtReferencia
				+ ", idTurno=" + idTurno + ", filtroOp=" + filtroOp + ", cdGt="
				+ cdGt + ", turnoAtual=" + turnoAtual + ", listaFiltroPosto="
				+ listaFiltroPosto + ", isGargalosAgrupados=" + gargalosAgrupados + "]";
	}
	
	public FiltroMonitorizacaoDTO getCopia() {
		FiltroMonitorizacaoDTO copia = new FiltroMonitorizacaoDTO();
		copia.dtReferencia = this.dtReferencia;
		copia.idTurno = this.idTurno;
		copia.filtroOp = this.filtroOp;
		copia.cdGt = this.cdGt;
		copia.turnoAtual = this.turnoAtual;
		copia.gargalosAgrupados = this.gargalosAgrupados;
		return copia;
	}
	
}
