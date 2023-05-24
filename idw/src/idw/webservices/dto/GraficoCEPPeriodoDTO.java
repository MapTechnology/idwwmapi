package idw.webservices.dto;

import java.util.Date;
import java.util.List;

public class GraficoCEPPeriodoDTO 
{
	private Integer idItemDTO;
	private Date dthrIni;
	private Date dthrFim;
	private String cdTurno;
	private String dsTurno;
	private Date dtTurno;
	private List<GraficoCEPDetParamDTO> parametros;
	private Byte zona;
	
	
	public Integer getIdItemDTO() {
		return idItemDTO;
	}
	public void setIdItemDTO(Integer idItemDTO) {
		this.idItemDTO = idItemDTO;
	}
	public Date getDthrIni() {
		return dthrIni;
	}
	public void setDthrIni(Date dthrIni) {
		this.dthrIni = dthrIni;
	}
	public Date getDthrFim() {
		return dthrFim;
	}
	public void setDthrFim(Date dthrFim) {
		this.dthrFim = dthrFim;
	}
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public Date getDtTurno() {
		return dtTurno;
	}
	public void setDtTurno(Date dtTurno) {
		this.dtTurno = dtTurno;
	}

	public List<GraficoCEPDetParamDTO> getParametros() {
		return parametros;
	}
	public void setParametros(List<GraficoCEPDetParamDTO> parametros) {
		this.parametros = parametros;
	}
	public Byte getZona() {
		return zona;
	}
	public void setZona(Byte zona) {
		this.zona = zona;
	}
}
