package idw.webservices.dto;

public class RelatorioIndiceDiarioDTO {
	
	private double qtdProduzida ;
	private double qtdPrevista;
	private double qtdBoas;
	private double qtdRefugada;
	private double indiceCavAtiva;
	private double indiceRefugo;
	private double indiceRealizacao;
	private double oee;
	private String data;
	private double tempoProdutivo;
	private double tempoAtivo;
	private String unidMedida;
	
	private double qtdProduzidaDEC ;
	private double qtdPrevistaDEC;
	private double qtdBoasDEC;
	private double qtdRefugadaDEC;
	
	private int cavAtivas;
	private int cavTotais;
	
	private double tempoBoas;
	private double tempoRitmo;
	
	
	
	public double getQtdProduzida() {
		return qtdProduzida;
	}
	public void setQtdProduzida(double qtdProduzida) {
		this.qtdProduzida = qtdProduzida;
	}
	public double getQtdPrevista() {
		return qtdPrevista;
	}
	public void setQtdPrevista(double qtdPrevista) {
		this.qtdPrevista = qtdPrevista;
	}
	public double getQtdBoas() {
		return qtdBoas;
	}
	public void setQtdBoas(double qtdBoas) {
		this.qtdBoas = qtdBoas;
	}
	public double getQtdRefugada() {
		return qtdRefugada;
	}
	public void setQtdRefugada(double qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}
	public double getQtdProduzidaDEC() {
		return qtdProduzidaDEC;
	}
	public void setQtdProduzidaDEC(double qtdProduzidaDEC) {
		this.qtdProduzidaDEC = qtdProduzidaDEC;
	}
	public double getQtdPrevistaDEC() {
		return qtdPrevistaDEC;
	}
	public void setQtdPrevistaDEC(double qtdPrevistaDEC) {
		this.qtdPrevistaDEC = qtdPrevistaDEC;
	}
	public double getQtdBoasDEC() {
		return qtdBoasDEC;
	}
	public void setQtdBoasDEC(double qtdBoasDEC) {
		this.qtdBoasDEC = qtdBoasDEC;
	}
	public double getQtdRefugadaDEC() {
		return qtdRefugadaDEC;
	}
	public void setQtdRefugadaDEC(double qtdRefugadaDEC) {
		this.qtdRefugadaDEC = qtdRefugadaDEC;
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
	public double getIndiceCavAtiva() {
		return indiceCavAtiva;
	}
	public void setIndiceCavAtiva(double indiceCavAtiva) {
		this.indiceCavAtiva = indiceCavAtiva;
	}
	public double getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(double indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public double getIndiceRealizacao() {
		return indiceRealizacao;
	}
	public void setIndiceRealizacao(double indiceRealizacao) {
		this.indiceRealizacao = indiceRealizacao;
	}
	public double getOee() {
		return oee;
	}
	public void setOee(double oee) {
		this.oee = oee;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUnidMedida() {
		return unidMedida;
	}
	public void setUnidMedida(String unidMedida) {
		this.unidMedida = unidMedida;
	}	
	public int getCavAtivas() {
		return cavAtivas;
	}
	public void setCavAtivas(int cavAtivas) {
		this.cavAtivas = cavAtivas;
	}
	public int getCavTotais() {
		return cavTotais;
	}
	public void setCavTotais(int cavTotais) {
		this.cavTotais = cavTotais;
	}
	public double getTempoRitmo() {
		return tempoRitmo;
	}
	public void setTempoRitmo(double tempoRitmo) {
		this.tempoRitmo = tempoRitmo;
	}
	public double getTempoBoas() {
		return tempoBoas;
	}
	public void setTempoBoas(double tempoBoas) {
		this.tempoBoas = tempoBoas;
	}
	
}