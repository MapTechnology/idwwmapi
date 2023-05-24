package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwConsolpa;
import idw.model.rn.DataHoraRN;

@SuppressWarnings("serial")
public class PostoProducaoRegulagemDTO implements Serializable {

	private List<ParadaRegulagemDTO> paradas = new ArrayList<>();
	
	private String cdPosto;
	private String cdProduto;
	
	private String posto;
	private String ferramenta;
	private String produto;
	
	private long totalTempoParadaComPesoNaEficiencia = 0l;
	private long totalTempoParadaSemPesoNaEficiencia = 0l;	
	private long totalTempoParadaRegulagemComPesoNaEficiencia = 0l;
	private long totalTempoParadaRegulagemSemPesoNaEficiencia = 0l;
	private long totalTempoParada = 0l;
	private double totalProducaoEmRegulagem = 0d;
	
	private String totalTempoParadaComPesoNaEficienciaHora = "00:00:00";
	private String totalTempoParadaSemPesoNaEficienciaHora = "00:00:00";	
	private String totalTempoParadaRegulagemComPesoNaEficienciaHora = "00:00:00";
	private String totalTempoParadaRegulagemSemPesoNaEficienciaHora = "00:00:00";
	private String totalTempoParadaHora = "00:00:00";
	private String totalProducaoEmRegulagemHora;
	
	public List<ParadaRegulagemDTO> getParadas() {
		return paradas;
	}
	public void setParadas(List<ParadaRegulagemDTO> paradas) {
		this.paradas = paradas;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public long getTotalTempoParadaComPesoNaEficiencia() {
		return totalTempoParadaComPesoNaEficiencia;
	}
	public void setTotalTempoParadaComPesoNaEficiencia(
			long totalTempoParadaComPesoNaEficiencia) {
		this.totalTempoParadaComPesoNaEficiencia = totalTempoParadaComPesoNaEficiencia;
	}
	public long getTotalTempoParadaSemPesoNaEficiencia() {
		return totalTempoParadaSemPesoNaEficiencia;
	}
	public void setTotalTempoParadaSemPesoNaEficiencia(
			long totalTempoParadaSemPesoNaEficiencia) {
		this.totalTempoParadaSemPesoNaEficiencia = totalTempoParadaSemPesoNaEficiencia;
	}
	public long getTotalTempoParadaRegulagemComPesoNaEficiencia() {
		return totalTempoParadaRegulagemComPesoNaEficiencia;
	}
	public void setTotalTempoParadaRegulagemComPesoNaEficiencia(
			long totalTempoParadaRegulagemComPesoNaEficiencia) {
		this.totalTempoParadaRegulagemComPesoNaEficiencia = totalTempoParadaRegulagemComPesoNaEficiencia;
	}
	public long getTotalTempoParadaRegulagemSemPesoNaEficiencia() {
		return totalTempoParadaRegulagemSemPesoNaEficiencia;
	}
	public void setTotalTempoParadaRegulagemSemPesoNaEficiencia(
			long totalTempoParadaRegulagemSemPesoNaEficiencia) {
		this.totalTempoParadaRegulagemSemPesoNaEficiencia = totalTempoParadaRegulagemSemPesoNaEficiencia;
	}
	public long getTotalTempoParada() {
		return totalTempoParada;
	}
	public void setTotalTempoParada(long totalTempoParada) {
		this.totalTempoParada = totalTempoParada;
	}
	public double getTotalProducaoEmRegulagem() {
		return totalProducaoEmRegulagem;
	}
	public void setTotalProducaoEmRegulagem(double totalProducaoEmRegulagem) {
		this.totalProducaoEmRegulagem = totalProducaoEmRegulagem;
	}
	public String getTotalTempoParadaComPesoNaEficienciaHora() {
		return totalTempoParadaComPesoNaEficienciaHora;
	}
	public void setTotalTempoParadaComPesoNaEficienciaHora(
			String totalTempoParadaComPesoNaEficienciaHora) {
		this.totalTempoParadaComPesoNaEficienciaHora = totalTempoParadaComPesoNaEficienciaHora;
	}
	public String getTotalTempoParadaSemPesoNaEficienciaHora() {
		return totalTempoParadaSemPesoNaEficienciaHora;
	}
	public void setTotalTempoParadaSemPesoNaEficienciaHora(
			String totalTempoParadaSemPesoNaEficienciaHora) {
		this.totalTempoParadaSemPesoNaEficienciaHora = totalTempoParadaSemPesoNaEficienciaHora;
	}
	public String getTotalTempoParadaRegulagemComPesoNaEficienciaHora() {
		return totalTempoParadaRegulagemComPesoNaEficienciaHora;
	}
	public void setTotalTempoParadaRegulagemComPesoNaEficienciaHora(String totalTempoParadaRegulagemComPesoNaEficienciaHora) {
		this.totalTempoParadaRegulagemComPesoNaEficienciaHora = totalTempoParadaRegulagemComPesoNaEficienciaHora;
	}
	public String getTotalTempoParadaRegulagemSemPesoNaEficienciaHora() {
		return totalTempoParadaRegulagemSemPesoNaEficienciaHora;
	}
	public void setTotalTempoParadaRegulagemSemPesoNaEficienciaHora(String totalTempoParadaRegulagemSemPesoNaEficienciaHora) {
		this.totalTempoParadaRegulagemSemPesoNaEficienciaHora = totalTempoParadaRegulagemSemPesoNaEficienciaHora;
	}
	public String getTotalTempoParadaHora() {
		return totalTempoParadaHora;
	}
	public void setTotalTempoParadaHora(String totalTempoParadaHora) {
		this.totalTempoParadaHora = totalTempoParadaHora;
	}
	public String getTotalProducaoEmRegulagemHora() {
		return totalProducaoEmRegulagemHora;
	}
	public void setTotalProducaoEmRegulagemHora(String totalProducaoEmRegulagemHora) {
		this.totalProducaoEmRegulagemHora = totalProducaoEmRegulagemHora;
	}
	
	public void addConsolPA(DwConsolpa pa) {
		
		// Abaixo consolida toda a parada mesmo que seja em regulagem
		if (pa.getSegAutoTempoparadaCp() != null)
			totalTempoParadaComPesoNaEficiencia += pa.getSegAutoTempoparadaCp().longValue();
		if (pa.getSegAutoTempoparadaSp() != null)
			totalTempoParadaSemPesoNaEficiencia += pa.getSegAutoTempoparadaSp().longValue();
		
		if (pa.getDwTParada().getIsPesa())
			totalTempoParadaComPesoNaEficienciaHora = DataHoraRN.formatSegundosParaHHMMSS((int)totalTempoParadaComPesoNaEficiencia);
		else
			totalTempoParadaSemPesoNaEficienciaHora = DataHoraRN.formatSegundosParaHHMMSS((int)totalTempoParadaSemPesoNaEficiencia);	

		// Se for parada de regulagem entao consolida a parte tambem
		if (pa.getDwTParada().getIsRegulagem() != null && pa.getDwTParada().getIsRegulagem()) {
			if (pa.getSegAutoTempoparadaCp() != null)
				totalTempoParadaRegulagemComPesoNaEficiencia += pa.getSegAutoTempoparadaCp().longValue();
			if (pa.getSegAutoTempoparadaSp() != null)
				totalTempoParadaRegulagemSemPesoNaEficiencia += pa.getSegAutoTempoparadaSp().longValue();

			if (pa.getDwTParada().getIsPesa())
				totalTempoParadaRegulagemComPesoNaEficienciaHora = DataHoraRN.formatSegundosParaHHMMSS((int)totalTempoParadaRegulagemComPesoNaEficiencia);
			else
				totalTempoParadaRegulagemSemPesoNaEficienciaHora = DataHoraRN.formatSegundosParaHHMMSS((int)totalTempoParadaRegulagemSemPesoNaEficiencia);
	
		}
	}
	
	public void addParada(ParadaRegulagemDTO parada) {
		
			boolean isExiste = false;
			for (ParadaRegulagemDTO paradaLocal : getParadas()) {
				
				if (paradaLocal.getParada().equals(parada.getParada())) {
					paradaLocal.setTempoParada(paradaLocal.getTempoParada() + parada.getTempoParada());
					paradaLocal.setTempoParadaHora(DataHoraRN.formatSegundosParaHHMMSS((int)paradaLocal.getTempoParada()));
					
					isExiste = true;
				}
			}
			if (isExiste == false) {
				getParadas().add(parada);
			}
		
	}
	
	@Override
	public boolean equals(Object o) {
		boolean isretorno = false;
		PostoProducaoRegulagemDTO from = (PostoProducaoRegulagemDTO) o;
		if (
				from.getPosto().equals(getPosto()) && 
				from.getFerramenta().equals(getFerramenta()) && 
				from.getProduto().equals(getProduto()))
			isretorno = true;
		return isretorno;
	}
	
	@Override
	public String toString() {
		return "posto:" + getPosto() + " ferramenta:" + getFerramenta() + " produto:" + getProduto();
	}
	public String getCdPosto() {
		return cdPosto;
	}
	public void setCdPosto(String cdPosto) {
		this.cdPosto = cdPosto;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}


}
