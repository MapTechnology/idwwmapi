package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.template.DwConsolidTemplate;

@SuppressWarnings("serial")
public class FiltroProducaoDTO implements Serializable{

	/** @see DwConsolidTemplate.TpId*/
	private byte tpId;
	private Date dtReferencia;
	private OmGt omGt;
	private DwTurno dwTurno;
	private InicioFimDTO inicioFimHora;
	private InicioFimDTO inicioFimTurno;	
	private List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp;
	private Boolean isTurnoAtual;
	private Date dthrReferencia;
	
	public byte getTpId() {
		return tpId;
	}
	public void setTpId(byte tpId) {
		this.tpId = tpId;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public InicioFimDTO getInicioFimHora() {
		return inicioFimHora;
	}
	public void setInicioFimHora(InicioFimDTO inicioFimHora) {
		this.inicioFimHora = inicioFimHora;
	}
	public InicioFimDTO getInicioFimTurno() {
		return inicioFimTurno;
	}
	public void setInicioFimTurno(InicioFimDTO inicioFimTurno) {
		this.inicioFimTurno = inicioFimTurno;
	}
	public List<FiltroProducaoPtCpDTO> getListaFiltroProducaoPtCp() {
		return listaFiltroProducaoPtCp;
	}
	public void setListaFiltroProducaoPtCp(
			List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp) {
		this.listaFiltroProducaoPtCp = listaFiltroProducaoPtCp;
	}
	public Boolean getIsTurnoAtual() {
		return isTurnoAtual;
	}
	public void setIsTurnoAtual(Boolean isTurnoAtual) {
		this.isTurnoAtual = isTurnoAtual;
	}
	public Date getDthrReferencia() {
		return dthrReferencia;
	}
	public void setDthrReferencia(Date dthrReferencia) {
		this.dthrReferencia = dthrReferencia;
	}
	

}