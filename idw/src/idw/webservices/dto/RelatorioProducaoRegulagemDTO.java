package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwConsolpa;

@SuppressWarnings("serial")
public class RelatorioProducaoRegulagemDTO implements Serializable {

	private List<PostoProducaoRegulagemDTO> postosPeriodo;
	
	private long periodoTempoParadaComPesoNaEficiencia = 0l;
	private long periodoTempoParadaSemPesoNaEficiencia = 0l;
	
	private long periodoTempoParadaRegulagemComPesoNaEficiencia = 0l;
	private long periodoTempoParadaRegulagemSemPesoNaEficiencia = 0l;
	
	private long periodoTempoParada = 0l;
	private double periodoProducaoEmRegulagem = 0d;
	
	private String periodoTempoParadaComPesoNaEficienciaHora = "00:00:00";
	private String periodoTempoParadaSemPesoNaEficienciaHora = "00:00:00";	
	private String periodoTempoParadaRegulagemComPesoNaEficienciaHora = "00:00:00";
	private String periodoTempoParadaRegulagemSemPesoNaEficienciaHora = "00:00:00";
	private String periodoTempoParadaHora = "00:00:00";
	private String periodoProducaoEmRegulagemHora;
	
	public List<PostoProducaoRegulagemDTO> getPostosPeriodo() {
		return postosPeriodo;
	}
	public void setPostosPeriodo(List<PostoProducaoRegulagemDTO> postosPeriodo) {
		this.postosPeriodo = postosPeriodo;
	}
	public long getPeriodoTempoParadaComPesoNaEficiencia() {
		return periodoTempoParadaComPesoNaEficiencia;
	}
	public void setPeriodoTempoParadaComPesoNaEficiencia(
			long periodoTempoParadaComPesoNaEficiencia) {
		this.periodoTempoParadaComPesoNaEficiencia = periodoTempoParadaComPesoNaEficiencia;
	}
	public long getPeriodoTempoParadaSemPesoNaEficiencia() {
		return periodoTempoParadaSemPesoNaEficiencia;
	}
	public void setPeriodoTempoParadaSemPesoNaEficiencia(
			long periodoTempoParadaSemPesoNaEficiencia) {
		this.periodoTempoParadaSemPesoNaEficiencia = periodoTempoParadaSemPesoNaEficiencia;
	}
	public long getPeriodoTempoParadaRegulagemComPesoNaEficiencia() {
		return periodoTempoParadaRegulagemComPesoNaEficiencia;
	}
	public void setPeriodoTempoParadaRegulagemComPesoNaEficiencia(
			long periodoTempoParadaRegulagemComPesoNaEficiencia) {
		this.periodoTempoParadaRegulagemComPesoNaEficiencia = periodoTempoParadaRegulagemComPesoNaEficiencia;
	}
	public long getPeriodoTempoParadaRegulagemSemPesoNaEficiencia() {
		return periodoTempoParadaRegulagemSemPesoNaEficiencia;
	}
	public void setPeriodoTempoParadaRegulagemSemPesoNaEficiencia(
			long periodoTempoParadaRegulagemSemPesoNaEficiencia) {
		this.periodoTempoParadaRegulagemSemPesoNaEficiencia = periodoTempoParadaRegulagemSemPesoNaEficiencia;
	}
	public long getPeriodoTempoParada() {
		return periodoTempoParada;
	}
	public void setPeriodoTempoParada(long periodoTempoParada) {
		this.periodoTempoParada = periodoTempoParada;
	}
	public double getPeriodoProducaoEmRegulagem() {
		return periodoProducaoEmRegulagem;
	}
	public void setPeriodoProducaoEmRegulagem(double periodoProducaoEmRegulagem) {
		this.periodoProducaoEmRegulagem = periodoProducaoEmRegulagem;
	}
	public String getPeriodoTempoParadaComPesoNaEficienciaHora() {
		return periodoTempoParadaComPesoNaEficienciaHora;
	}
	public void setPeriodoTempoParadaComPesoNaEficienciaHora(
			String periodoTempoParadaComPesoNaEficienciaHora) {
		this.periodoTempoParadaComPesoNaEficienciaHora = periodoTempoParadaComPesoNaEficienciaHora;
	}
	public String getPeriodoTempoParadaSemPesoNaEficienciaHora() {
		return periodoTempoParadaSemPesoNaEficienciaHora;
	}
	public void setPeriodoTempoParadaSemPesoNaEficienciaHora(
			String periodoTempoParadaSemPesoNaEficienciaHora) {
		this.periodoTempoParadaSemPesoNaEficienciaHora = periodoTempoParadaSemPesoNaEficienciaHora;
	}
	public String getPeriodoTempoParadaRegulagemComPesoNaEficienciaHora() {
		return periodoTempoParadaRegulagemComPesoNaEficienciaHora;
	}
	public void setPeriodoTempoParadaRegulagemComPesoNaEficienciaHora(
			String periodoTempoParadaRegulagemComPesoNaEficienciaHora) {
		this.periodoTempoParadaRegulagemComPesoNaEficienciaHora = periodoTempoParadaRegulagemComPesoNaEficienciaHora;
	}
	public String getPeriodoTempoParadaRegulagemSemPesoNaEficienciaHora() {
		return periodoTempoParadaRegulagemSemPesoNaEficienciaHora;
	}
	public void setPeriodoTempoParadaRegulagemSemPesoNaEficienciaHora(
			String periodoTempoParadaRegulagemSemPesoNaEficienciaHora) {
		this.periodoTempoParadaRegulagemSemPesoNaEficienciaHora = periodoTempoParadaRegulagemSemPesoNaEficienciaHora;
	}
	public String getPeriodoTempoParadaHora() {
		return periodoTempoParadaHora;
	}
	public void setPeriodoTempoParadaHora(String periodoTempoParadaHora) {
		this.periodoTempoParadaHora = periodoTempoParadaHora;
	}
	public String getPeriodoProducaoEmRegulagemHora() {
		return periodoProducaoEmRegulagemHora;
	}
	public void setPeriodoProducaoEmRegulagemHora(
			String periodoProducaoEmRegulagemHora) {
		this.periodoProducaoEmRegulagemHora = periodoProducaoEmRegulagemHora;
	}
	
	
	
	public void addParada(DwConsolpa pa) {
		if (pa.getDwTParada().getIsRegulagem() != null && pa.getDwTParada().getIsRegulagem()) {
			if (pa.getSegAutoTempoparadaCp() != null)
				periodoTempoParadaRegulagemComPesoNaEficiencia += pa.getSegAutoTempoparadaCp().longValue();
			if (pa.getSegAutoTempoparadaSp() != null)
				periodoTempoParadaRegulagemSemPesoNaEficiencia += pa.getSegAutoTempoparadaSp().longValue();

		} else {
			if (pa.getSegAutoTempoparadaCp() != null)
				periodoTempoParadaComPesoNaEficiencia += pa.getSegAutoTempoparadaCp().longValue();
			if (pa.getSegAutoTempoparadaSp() != null)
				periodoTempoParadaSemPesoNaEficiencia += pa.getSegAutoTempoparadaSp().longValue();
		}
	}
	
	
}
