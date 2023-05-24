package ms.coleta.dto;

import java.util.Calendar;

public class ParametroDTO {
	private int nrIcDO;
	private boolean stAtivo;
	private boolean stPiscando;
	private int tempoOn;
	private int tempoOff;
	
	private Integer tipoEvento = null;
	private Calendar dataHoraEvento = null;
	private Integer paradaDefault = null;
	
	public ParametroDTO() { }
	
	public ParametroDTO(AndonDTO andon) {
		this.nrIcDO = andon.getIdrele() - 1;
		this.stAtivo = andon.getStativo() == 0? false : true;
		this.stPiscando = andon.getStintermitente() == 0? false : true;
		this.tempoOn = andon.getTmpsinalalto();
		this.tempoOff = andon.getTmpsinalbaixo();		
	}
	
	/*
	 * nrIdDO indica qual a sa�da digital a ser acionada.
	 */
	public void setNrIcDO(int nricdo) {
		this.nrIcDO = nricdo;
	}
	public int getNrIcDO() {
		return this.nrIcDO;
	}
	
	/*
	 * stAtivo indica o estado da sa�da digital: 1 = ligado, 0 = desligado
	 */
	public void setStAtivo(boolean stAtivo) {
		this.stAtivo = stAtivo;
	}
	public boolean getStAtivo() {
		return stAtivo;
	}

	/*
	 * isPiscando indica se a sa�da digital est� piscando ou cont�nua: 1 = piscando, 0 = cont�nua
	 */
	public void setStPiscando(boolean isPiscando) {
		this.stPiscando = isPiscando;
	}
	public boolean getStPiscando() {
		return stPiscando;
	}

	/*
	 * tempoOn indica o tempo em que a sa�da digital permanecar� ligada
	 */
	public void setTempoOn(int tempoOn) {
		this.tempoOn = tempoOn;
	}
	public int getTempoOn() {
		return tempoOn;
	}

	/*
	 * tempoOff indica o tempo em que a sa�da digital permanecer� desligada
	 */
	public void setTempoOff(int tempoOff) {
		this.tempoOff = tempoOff;
	}

	public int getTempoOff() {
		return tempoOff;
	}
	
	
	
	public Integer getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(Integer tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Calendar getDataHoraEvento() {
		return dataHoraEvento;
	}
	public void setDataHoraEvento(Calendar dataHoraEvento) {
		this.dataHoraEvento = dataHoraEvento;
	}
	
	public Integer getParadaDefault() {
		return paradaDefault;
	}
	public void setParadaDefault(Integer paradaDefault) {
		this.paradaDefault = paradaDefault;
	}
	
	
	public void copyDTO(ParametroDTO dto) {
		this.nrIcDO = dto.getNrIcDO();
		this.stAtivo = dto.getStAtivo();
		this.stPiscando = dto.getStPiscando();
		this.tempoOn = dto.getTempoOn();
		this.tempoOff = dto.getTempoOff();
	}
}
