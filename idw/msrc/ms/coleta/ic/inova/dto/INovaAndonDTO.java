package ms.coleta.ic.inova.dto;

import java.util.Calendar;

import injetws.webservices.dto.IwsAndonDTO;

@SuppressWarnings("serial")
public class INovaAndonDTO extends IwsAndonDTO {
	
	private Double indicadorASerUsado = 0d;
	private Calendar dtHrInicio = Calendar.getInstance();
	private Boolean timerIniciado = false;
	
	public void copyAndonDTOWS(IwsAndonDTO andonDTO) {
		
		if(andonDTO != null) {
			this.setIndicador(andonDTO.getIndicador());
			this.setIdeventoandon(andonDTO.getIdeventoandon());
			this.setIdrele(andonDTO.getIdrele());
			this.setIdreleaux(andonDTO.getIdreleaux());
//			this.idreleSpecified=andonDTO.idreleSpecified;
			this.setIdup(andonDTO.getIdup());
			this.setListaAndonArgsDTO(andonDTO.getListaAndonArgsDTO());
			this.setPrioridade(andonDTO.getPrioridade());
//			this.prioridadeSpecified=andonDTO.prioridadeSpecified;
			this.setStativo(andonDTO.getStativo());
//			this.stativoSpecified=andonDTO.stativoSpecified;
			this.setStintermitente(andonDTO.getStintermitente());
//			this.stintermitenteSpecified=andonDTO.stintermitenteSpecified;
			this.setTmpliminspqld(andonDTO.getTmpliminspqld());
//			this.tmpliminspqldSpecified=andonDTO.tmpliminspqldSpecified;
			this.setTmpsinalalto(andonDTO.getTmpsinalalto());
//			this.tmpsinalaltoSpecified=andonDTO.tmpsinalaltoSpecified;
			this.setTmpsinalbaixo(andonDTO.getTmpsinalbaixo());
//			this.tmpsinalbaixoSpecified=andonDTO.tmpsinalbaixoSpecified;
			
			if(this.getIndicador() != null) {
				this.indicadorASerUsado = andonDTO.getIndicador().getVlindicadorHora();
				this.indicadorASerUsado = andonDTO.getIndicador().getVlindicadorTurno();
			}	
			
		}
	}

	public Double getIndicadorASerUsado() {
		return indicadorASerUsado;
	}
	public void setIndicadorASerUsado(Double indicadorASerUsado) {
		this.indicadorASerUsado = indicadorASerUsado;
	}

	public Calendar getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(Calendar dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}

	public Boolean getTimerIniciado() {
		return timerIniciado;
	}
	public void setTimerIniciado(Boolean timerIniciado) {
		this.timerIniciado = timerIniciado;
	}
	
	
}
