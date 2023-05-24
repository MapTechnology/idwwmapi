package idw.relatorio.analiseproducaoeficiencia;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

public class AnaliseProducaoEficienciaHoraAHoraDetalheDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private Date dthrIHora;
	@Transient
	private Date dthrFHora;

	private String intervaloHoraInicial;
	private String intervaloHoraFinal;

	private Double producaoBruta = 0d;
	private Double producaoPrevista = 0d;
	private Double producaoRefugada = 0d;
	private Double producaoLiquida = 0d;
	private Double cicloMedio = 0d;
	private Double cicloPadrao = 0d;
	private Double tempoAtivo = 0d;
	private Double tempoTotalParadasCP = 0d;
	private Double metaHora = 0d;
	private Double indiceMAtivas = 0d;
	private Float indiceEficienciaRealizacao = 0f;
	private Float indiceRefugo = 0f;
	private Float indiceParada = 0f;
	private String paradaRefugo;
	private Double tempoParadaOuQtRefugo = 0d;
	private Boolean isParada; // sera true quando a linha for referente a parada e false qdo for referente a refugo. Usado para a ordenacao

	private String tempoAtivoFormatado = "";
	private String tempoTotalParadasCPFormatado = "";
	private String tempoParadaOutQtRefugoFormatado = "";

	private Date dthrIRef;

	public AnaliseProducaoEficienciaHoraAHoraDetalheDTO() {
	}

	public AnaliseProducaoEficienciaHoraAHoraDetalheDTO(String tempoFormatadoZerado) {
		setParadaRefugo(null);
		setTempoParadaOuQtRefugo(null);
		setTempoParadaOuQtRefugoFormatado(null);
		setDthrIHora(null);
		setIntervaloHoraInicial(null);
		setDthrFHora(null);
		setIntervaloHoraFinal(null);
		setTempoTotalParadasCP(0d);
		setTempoTotalParadasCPFormatado(tempoFormatadoZerado);
		setTempoAtivo(0d);
		setTempoAtivoFormatado(tempoFormatadoZerado);
		setIndiceParada(0f);
		setIndiceEficienciaRealizacao(0f);
		setIndiceRefugo(0f);
		setIndiceMAtivas(0d);
		setProducaoBruta(0d);
		setProducaoLiquida(0d);
		setProducaoPrevista(0d);
		setProducaoRefugada(0d);
		setMetaHora(0d);
		setCicloMedio(0d);
		setCicloPadrao(0d);
	}

	public String getIntervaloHoraInicial() {
		return intervaloHoraInicial;
	}

	public void setIntervaloHoraInicial(String intervaloHoraInicial) {
		this.intervaloHoraInicial = intervaloHoraInicial;
	}

	public String getIntervaloHoraFinal() {
		return intervaloHoraFinal;
	}

	public void setIntervaloHoraFinal(String intervaloHoraFinal) {
		this.intervaloHoraFinal = intervaloHoraFinal;
	}

	public Double getProducaoBruta() {
		return producaoBruta;
	}

	public void setProducaoBruta(Double producaoBruta) {
		this.producaoBruta = producaoBruta;
	}

	public Double getProducaoPrevista() {
		return producaoPrevista;
	}

	public void setProducaoPrevista(Double producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}

	public Double getProducaoRefugada() {
		return producaoRefugada;
	}

	public void setProducaoRefugada(Double producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}

	public Double getCicloMedio() {
		return cicloMedio;
	}

	public void setCicloMedio(Double cicloMedio) {
		this.cicloMedio = cicloMedio;
	}

	public Double getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(Double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}

	public Double getTempoAtivo() {
		return tempoAtivo;
	}

	public void setTempoAtivo(Double tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}

	public Double getTempoTotalParadasCP() {
		return tempoTotalParadasCP;
	}

	public void setTempoTotalParadasCP(Double tempoParada) {
		this.tempoTotalParadasCP = tempoParada;
	}

	public Double getProducaoLiquida() {
		return producaoLiquida;
	}

	public void setProducaoLiquida(Double producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}

	public Double getMetaHora() {
		return metaHora;
	}

	public void setMetaHora(Double metaHora) {
		this.metaHora = metaHora;
	}

	public Float getIndiceEficienciaRealizacao() {
		return indiceEficienciaRealizacao;
	}

	public void setIndiceEficienciaRealizacao(Float indiceEficienciaRealizacao) {
		this.indiceEficienciaRealizacao = indiceEficienciaRealizacao;
	}

	public Float getIndiceRefugo() {
		return indiceRefugo;
	}

	public void setIndiceRefugo(Float indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}

	public Float getIndiceParada() {
		return indiceParada;
	}

	public void setIndiceParada(Float indiceParada) {
		this.indiceParada = indiceParada;
	}

	public Double getIndiceMAtivas() {
		return indiceMAtivas;
	}

	public void setIndiceMAtivas(Double indiceMAtivas) {
		this.indiceMAtivas = indiceMAtivas;
	}

	public String getParadaRefugo() {
		return paradaRefugo;
	}

	public void setParadaRefugo(String paradaRefugo) {
		this.paradaRefugo = paradaRefugo;
	}

	public Double getTempoParadaOuQtRefugo() {
		return tempoParadaOuQtRefugo;
	}

	public void setTempoParadaOuQtRefugo(Double tempoParadaOuQtRefugo) {
		this.tempoParadaOuQtRefugo = tempoParadaOuQtRefugo;
	}

	public String getTempoAtivoFormatado() {
		return tempoAtivoFormatado;
	}

	public void setTempoAtivoFormatado(String tempoAtivoFormatado) {
		this.tempoAtivoFormatado = tempoAtivoFormatado;
	}

	public String getTempoTotalParadasCPFormatado() {
		return tempoTotalParadasCPFormatado;
	}

	public void setTempoTotalParadasCPFormatado(String tempoParadaFormatado) {
		this.tempoTotalParadasCPFormatado = tempoParadaFormatado;
	}

	public String getTempoParadaOuQtRefugoFormatado() {
		return tempoParadaOutQtRefugoFormatado;
	}

	/**
	 * Campo está sendo usado para guardar o tempo da parada(00:00:00) ou a quantidade de refugo (0.00s)
	 *
	 */
	public void setTempoParadaOuQtRefugoFormatado(String tempoParadaOuQtRefugoFormatado) {
		this.tempoParadaOutQtRefugoFormatado = tempoParadaOuQtRefugoFormatado;
	}

	@Transient
	public Date getDthrIHora() {
		return dthrIHora;
	}

	@Transient
	public void setDthrIHora(Date dthrIHora) {
		this.dthrIHora = dthrIHora;
	}

	@Transient
	public Date getDthrFHora() {
		return dthrFHora;
	}

	@Transient
	public void setDthrFHora(Date dthrFHora) {
		this.dthrFHora = dthrFHora;
	}

	public void setIndicadores(AnaliseProducaoEficienciaHoraAHoraDetalheDTO from) {
		setTempoTotalParadasCP(from.getTempoTotalParadasCP());
		setTempoTotalParadasCPFormatado(from.getTempoTotalParadasCPFormatado());
		setTempoAtivo(from.getTempoAtivo());
		setTempoAtivoFormatado(from.getTempoAtivoFormatado());
		setIndiceParada(from.getIndiceParada());
		setIndiceEficienciaRealizacao(from.getIndiceEficienciaRealizacao());
		setIndiceRefugo(from.getIndiceRefugo());
		setIndiceMAtivas(from.getIndiceMAtivas());
		setProducaoBruta(from.getProducaoBruta());
		setProducaoLiquida(from.getProducaoLiquida());
		setProducaoPrevista(from.getProducaoPrevista());
		setProducaoRefugada(from.getProducaoRefugada());
		setMetaHora(from.getMetaHora());
		setCicloMedio(from.getCicloMedio());
		setCicloPadrao(from.getCicloPadrao());
	}

	@XmlTransient
	public Date getDthrIRef() {
		return dthrIRef;
	}

	public void setDthrIRef(Date dthrIRef) {
		this.dthrIRef = dthrIRef;
	}

	public Boolean getIsParada() {
		return isParada;
	}

	public void setIsParada(Boolean isParada) {
		this.isParada = isParada;
	}
}
