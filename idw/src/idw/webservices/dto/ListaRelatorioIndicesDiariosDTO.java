package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioIndicesDiariosDTO {

	private List<RelatorioIndiceDiarioDTO> listaRelatorioIndiceDiario;
	private int totalPrevisto;
	private int totalProduzido;
	private int totalBoas;
	private int totalRefugada;
	private double totalCavAtiva;
	private double totalIndefugo;
	private double totaleficRealizacao;
	private double totalOee;
	private double tempoProdutivo;
	private double tempoAtivo;
	
	private double totalPrevistoDEC;
	private double totalProduzidoDEC;
	private double totalBoasDEC;
	private double totalRefugadaDEC;
	private double tempoProdutivoDEC;
	private double tempoAtivoDEC;
	
	//Marcos Sardinha: 2017-08-23 >> Defeito #4407
	private double tempoBoas;
	private double tempoRitmo;
	private double indCavTotal;
	
	
	public double getTempoProdutivoDEC() {
		return tempoProdutivoDEC;
	}

	public void setTempoProdutivoDEC(double tempoProdutivoDEC) {
		this.tempoProdutivoDEC = tempoProdutivoDEC;
	}

	public double getTempoAtivoDEC() {
		return tempoAtivoDEC;
	}

	public void setTempoAtivoDEC(double tempoAtivoDEC) {
		this.tempoAtivoDEC = tempoAtivoDEC;
	}

	public double getTotalPrevistoDEC() {
		return totalPrevistoDEC;
	}

	public void setTotalPrevistoDEC(double totalPrevistoDEC) {
		this.totalPrevistoDEC = totalPrevistoDEC;
	}

	public double getTotalProduzidoDEC() {
		return totalProduzidoDEC;
	}

	public void setTotalProduzidoDEC(double totalProduzidoDEC) {
		this.totalProduzidoDEC = totalProduzidoDEC;
	}

	public double getTotalBoasDEC() {
		return totalBoasDEC;
	}

	public void setTotalBoasDEC(double totalBoasDEC) {
		this.totalBoasDEC = totalBoasDEC;
	}

	public double getTotalRefugadaDEC() {
		return totalRefugadaDEC;
	}

	public void setTotalRefugadaDEC(double totalRefugadaDEC) {
		this.totalRefugadaDEC = totalRefugadaDEC;
	}

	public double getTempoProdutivo() {
		return tempoProdutivo;
	}

	public void setTempoProdutivo(double tempoProdutivo) {
		this.tempoProdutivo = tempoProdutivo;
	}

	public double getTempoAtivo() {
		return tempoAtivo;
	}

	public void setTempoAtivo(double tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}

	public int getTotalPrevisto() {
		return totalPrevisto;
	}

	public void setTotalPrevisto(int totalPrevisto) {
		this.totalPrevisto = totalPrevisto;
	}

	public int getTotalProduzido() {
		return totalProduzido;
	}

	public void setTotalProduzido(int totalProduzido) {
		this.totalProduzido = totalProduzido;
	}

	public int getTotalBoas() {
		return totalBoas;
	}

	public void setTotalBoas(int totalBoas) {
		this.totalBoas = totalBoas;
	}

	public int getTotalRefugada() {
		return totalRefugada;
	}

	public void setTotalRefugada(int totalRefugada) {
		this.totalRefugada = totalRefugada;
	}

	public double getTotalCavAtiva() {
		return totalCavAtiva;
	}

	public void setTotalCavAtiva(double totalCavAtiva) {
		this.totalCavAtiva = totalCavAtiva;
	}

	public double getTotalIndefugo() {
		return totalIndefugo;
	}

	public void setTotalIndefugo(double totalIndefugo) {
		this.totalIndefugo = totalIndefugo;
	}



	public double getTotalOee() {
		return totalOee;
	}

	public void setTotalOee(double totalOee) {
		this.totalOee = totalOee;
	}

	public List<RelatorioIndiceDiarioDTO> getListaRelatorioIndiceDiario() {
		return listaRelatorioIndiceDiario;
	}

	public void setListaRelatorioIndiceDiario(
			List<RelatorioIndiceDiarioDTO> listaRelatorioIndiceDiario) {
		this.listaRelatorioIndiceDiario = listaRelatorioIndiceDiario;
	}

	public double getTotaleficRealizacao() {
		return totaleficRealizacao;
	}

	public void setTotaleficRealizacao(double totaleficRealizacao) {
		this.totaleficRealizacao = totaleficRealizacao;
	}

	public double getTempoBoas() {
		return tempoBoas;
	}

	public void setTempoBoas(double tempoBoas) {
		this.tempoBoas = tempoBoas;
	}

	public double getTempoRitmo() {
		return tempoRitmo;
	}

	public void setTempoRitmo(double tempoRitmo) {
		this.tempoRitmo = tempoRitmo;
	}

	public double getIndCavTotal() {
		return indCavTotal;
	}

	public void setIndCavTotal(double indCavTotal) {
		this.indCavTotal = indCavTotal;
	}

	
}
