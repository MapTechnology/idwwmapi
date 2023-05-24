package idw.util;

import java.awt.Paint;
import java.util.Date;

public class IntervaloGrafTendenciaRefugoParada {

	private int serie;
	private Double percIntInicial;
	private Double percIntFinal;
	private Paint corIntervalo;
	private String operadorInicial;
	private String operadorFinal;
	private Date intervaloDtHrIni;
	private Date intervaloDtHrFim;
	private int duracaoIntervalo;

	public IntervaloGrafTendenciaRefugoParada() {
		super();
	}

	public int getSerie() {
		return serie;
	}

	public Paint getCorIntervalo() {
		return corIntervalo;
	}

	public String getOperadorInicial() {
		return operadorInicial;
	}

	public String getOperadorFinal() {
		return operadorFinal;
	}

	public void setOperadorFinal(String operadorFinal) {
		this.operadorFinal = operadorFinal;
	}

	public Double getPercIntInicial() {
		return percIntInicial;
	}

	public void setPercIntInicial(Double percIntInicial) {
		this.percIntInicial = percIntInicial;
	}

	public Double getPercIntFinal() {
		return percIntFinal;
	}

	public void setPercIntFinal(Double percIntFinal) {
		this.percIntFinal = percIntFinal;
	}

	public Date getIntervaloDtHrIni() {
		return intervaloDtHrIni;
	}

	public void setIntervaloDtHrIni(Date intervaloDtHrIni) {
		this.intervaloDtHrIni = intervaloDtHrIni;
	}

	public Date getIntervaloDtHrFim() {
		return intervaloDtHrFim;
	}

	public void setIntervaloDtHrFim(Date intervaloDtHrFim) {
		this.intervaloDtHrFim = intervaloDtHrFim;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public void setCorIntervalo(Paint corIntervalo) {
		this.corIntervalo = corIntervalo;
	}

	public void setOperadorInicial(String operadorInicial) {
		this.operadorInicial = operadorInicial;
	}

	public int getDuracaoIntervalo() {
		return duracaoIntervalo;
	}
	
	public void setDuracaoIntervalo(int duracaoIntervalo) {
		this.duracaoIntervalo = duracaoIntervalo;
	}

}
