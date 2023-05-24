package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.rn.DataHoraRN;

@SuppressWarnings("serial")
public class PeriodoDTO implements Serializable {
	private Date dtHrInicio;
	private Date dtHrFim;
	private TurnoAtualDTO turnoAtualDTO;
	private Long duracao = 0L;

	public Long getDuracao() {
		return duracao;
	}
	public void setDuracao(Long duracao) {
		this.duracao = duracao;
	}
	public TurnoAtualDTO getTurnoAtualDTO() {
		return turnoAtualDTO;
	}
	public void setTurnoAtualDTO(TurnoAtualDTO turnoAtualDTO) {
		this.turnoAtualDTO = turnoAtualDTO;
	}
	public Date getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(Date dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}
	public Date getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(Date dtHrFim) {
		this.dtHrFim = dtHrFim;
	}
	
	@Override
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("dtHrInicio", (dtHrInicio != null? DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrInicio) : "null"))
		.append("dtHrFim", (dtHrFim != null? DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrFim) : "null"))
		.append("duracao", duracao)
		.append("idCal", (turnoAtualDTO != null ? turnoAtualDTO.getIdCal(): "null" ) )
		.append("idTurno", (turnoAtualDTO != null && turnoAtualDTO.getDwturno() != null ? turnoAtualDTO.getDwturno().getIdTurno() : "null"))
		.append("dthriturno", (turnoAtualDTO != null &&  turnoAtualDTO.getDtHrITurno() != null ? DataHoraRN.dateToStringYYYYMMDDHHMMSS(turnoAtualDTO.getDtHrITurno()) : "null"))
		.append("dthrfturno", (turnoAtualDTO != null && turnoAtualDTO.getDtHrFTurno() != null? DataHoraRN.dateToStringYYYYMMDDHHMMSS(turnoAtualDTO.getDtHrFTurno()) : "null"))
		.append("dtReferencia", (turnoAtualDTO != null && turnoAtualDTO.getDtReferencia() != null ? DataHoraRN.dateToStringYYYYMMDDHHMMSS(turnoAtualDTO.getDtReferencia()) : "null"))
		.toString();	
	}

}
