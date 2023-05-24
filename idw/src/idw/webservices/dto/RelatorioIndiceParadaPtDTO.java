package idw.webservices.dto;

import java.util.List;


public class RelatorioIndiceParadaPtDTO {

	private String maquina;
	private String parada;
	private String indiceED;
	private Double tempoAtivo;
	private Double tempoParadas;
	private Double horasProdutivas;
	private Double tempoParadasCP;
	private Double tempoParadasSP;
	private Double segMTTR;
	private Double segMTBF;
	private Double tempoMTTR_MTBF;
	private Double disponibilidade;
	private int qtdMTTR_MTBF;
	private int qtdOcorrenciasPPE; 
	private int qtdParada;
	private List<RelatorioIndiceParadaPtDTO> subRelatorioIndiceParadas; 
	private List<ParadaRelatorioDTO> listaParadasRelatorio; 
	private List<ItemParadaPorPtDTO> itensRelatorio;
	
		
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public Double getTempoAtivo() {
		return tempoAtivo;
	}
	public void setTempoAtivo(Double tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}
	public Double getTempoParadas() {
		return tempoParadas;
	}
	public void setTempoParadas(Double tempoParadas) {
		this.tempoParadas = tempoParadas;
	}
	public Double getHorasProdutivas() {
		return horasProdutivas;
	}
	public void setHorasProdutivas(Double horasProdutivas) {
		this.horasProdutivas = horasProdutivas;
	}	
	public List<ParadaRelatorioDTO> getListaParadasRelatorio() {
		return listaParadasRelatorio;
	}
	public void setListaParadasRelatorio(List<ParadaRelatorioDTO> listaParadasRelatorio) {
		this.listaParadasRelatorio = listaParadasRelatorio;
	}
	public int getQtdOcorrenciasPPE() {
		return qtdOcorrenciasPPE;
	}
	public void setQtdOcorrenciasPPE(int qtdOcorrenciasPPE) {
		this.qtdOcorrenciasPPE = qtdOcorrenciasPPE;
	}
	
	
	public List<RelatorioIndiceParadaPtDTO> getSubRelatorioIndiceParadas() {
		return subRelatorioIndiceParadas;
	}
	public void setSubRelatorioIndiceParadas(List<RelatorioIndiceParadaPtDTO> subRelatorioIndiceParadas) {
		this.subRelatorioIndiceParadas = subRelatorioIndiceParadas;
	}
	public Double getTempoParadasCP() {
		return tempoParadasCP;
	}
	public void setTempoParadasCP(Double tempoParadasCP) {
		this.tempoParadasCP = tempoParadasCP;
	}
	public Double getTempoParadasSP() {
		return tempoParadasSP;
	}
	public void setTempoParadasSP(Double tempoParadasSP) {
		this.tempoParadasSP = tempoParadasSP;
	}
	
	
	
	
	
	
	
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public int getQtdParada() {
		return qtdParada;
	}
	public void setQtdParada(int qtdParada) {
		this.qtdParada = qtdParada;
	}
	public List<ItemParadaPorPtDTO> getItensRelatorio() {
		return itensRelatorio;
	}
	public void setItensRelatorio(List<ItemParadaPorPtDTO> itensRelatorio) {
		this.itensRelatorio = itensRelatorio;
	}
	public String getIndiceED() {
		return indiceED;
	}
	public void setIndiceED(String indiceED) {
		this.indiceED = indiceED;
	}
	public Double getSegMTTR() {
		return segMTTR;
	}
	public void setSegMTTR(Double segMTTR) {
		this.segMTTR = segMTTR;
	}
	public Double getSegMTBF() {
		return segMTBF;
	}
	public void setSegMTBF(Double segMTBF) {
		this.segMTBF = segMTBF;
	}
	public int getQtdMTTR_MTBF() {
		return qtdMTTR_MTBF;
	}
	public void setQtdMTTR_MTBF(int qtdMTTR_MTBF) {
		this.qtdMTTR_MTBF = qtdMTTR_MTBF;
	}
	public Double getTempoMTTR_MTBF() {
		return tempoMTTR_MTBF;
	}
	public void setTempoMTTR_MTBF(Double tempoMTTR_MTBF) {
		this.tempoMTTR_MTBF = tempoMTTR_MTBF;
	}
	public Double getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(Double disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}