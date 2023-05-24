package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroAnaliseGargalo")
public class FiltroAnaliseGargaloDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String dtReferencia;
	private long idTurno;
	private int filtroOp;
	private String cdGt;
	private List<FiltroDetalhePostoDTO> listaFiltroPostos;
	private List<FiltroPtCpDTO> listaFiltroPtCp;
	
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
	public List<FiltroDetalhePostoDTO> getListaFiltroPostos() {
		return listaFiltroPostos;
	}
	public void setListaFiltroPostos(List<FiltroDetalhePostoDTO> listaFiltroPostos) {
		this.listaFiltroPostos = listaFiltroPostos;
	}
	public List<FiltroPtCpDTO> getListaFiltroPtCp() {
		return listaFiltroPtCp;
	}
	public void setListaFiltroPtCp(List<FiltroPtCpDTO> listaFiltroPtCp) {
		this.listaFiltroPtCp = listaFiltroPtCp;
	}

	
	

}
