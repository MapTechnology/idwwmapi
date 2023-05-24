package idw.webservices.dto;

import java.util.List;

public class AcompanhamentoProducaoDTO {
	private String unidMedida;
	private double eficRelaizacao;
	private double eficiCiclo;
	private double indicePa;
	private double indiceRef;
	private double indicecavAtiva;
	private String intervalo;
	private String maquina;
	private int metaPeriodo;
	private int qtdPrevista;
	private int qtdProduzida;
	private int projecaofPeriodo;
	
	private double eficRelaizacaoDec;
	private double eficiCicloDec;
	private double indicePaDec;
	private double indiceRefDec;
	private double indicecavAtivaDec;
	private double metaPeriodoDec;
	private double qtdPrevistaDec;
	private double qtdProduzidaDec;
	private double projecaofPeriodoDec;
	private List<RelatorioParadasAbertasDTO> listaCompletaParadas;
	
	
	public double getIndiceRefDec() {
		return indiceRefDec;
	}

	public void setIndiceRefDec(double indiceRefDec) {
		this.indiceRefDec = indiceRefDec;
	}

	public double getIndicecavAtivaDec() {
		return indicecavAtivaDec;
	}

	public void setIndicecavAtivaDec(double indicecavAtivaDec) {
		this.indicecavAtivaDec = indicecavAtivaDec;
	}

	public double getMetaPeriodoDec() {
		return metaPeriodoDec;
	}

	public void setMetaPeriodoDec(double metaPeriodoDec) {
		this.metaPeriodoDec = metaPeriodoDec;
	}

	public double getQtdPrevistaDec() {
		return qtdPrevistaDec;
	}

	public void setQtdPrevistaDec(double qtdPrevistaDec) {
		this.qtdPrevistaDec = qtdPrevistaDec;
	}

	public double getQtdProduzidaDec() {
		return qtdProduzidaDec;
	}

	public void setQtdProduzidaDec(double qtdProduzidaDec) {
		this.qtdProduzidaDec = qtdProduzidaDec;
	}

	public double getProjecaofPeriodoDec() {
		return projecaofPeriodoDec;
	}

	public void setProjecaofPeriodoDec(double projecaofPeriodoDec) {
		this.projecaofPeriodoDec = projecaofPeriodoDec;
	}


	public List<RelatorioParadasAbertasDTO> getListaCompletaParadas() {
		return listaCompletaParadas;
	}

	public void setListaCompletaParadas(
			List<RelatorioParadasAbertasDTO> listaCompletaParadas) {
		this.listaCompletaParadas = listaCompletaParadas;
	}

	public String getUnidMedida() {
		return unidMedida;
	}

	public void setUnidMedida(String unidMedida) {
		this.unidMedida = unidMedida;
	}

	public double getEficRelaizacao() {
		return eficRelaizacao;
	}

	public void setEficRelaizacao(double eficRelaizacao) {
		this.eficRelaizacao = eficRelaizacao;
	}

	public double getEficiCiclo() {
		return eficiCiclo;
	}

	public void setEficiCiclo(double eficiCiclo) {
		this.eficiCiclo = eficiCiclo;
	}

	public double getIndicePa() {
		return indicePa;
	}

	public void setIndicePa(double indicePa) {
		this.indicePa = indicePa;
	}

	public double getIndiceRef() {
		return indiceRef;
	}

	public void setIndiceRef(double indiceRef) {
		this.indiceRef = indiceRef;
	}

	public double getIndicecavAtiva() {
		return indicecavAtiva;
	}

	public void setIndicecavAtiva(double indicecavAtiva) {
		this.indicecavAtiva = indicecavAtiva;
	}

	public String getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public int getMetaPeriodo() {
		return metaPeriodo;
	}

	public void setMetaPeriodo(int metaPeriodo) {
		this.metaPeriodo = metaPeriodo;
	}

	public int getQtdPrevista() {
		return qtdPrevista;
	}

	public void setQtdPrevista(int qtdPrevista) {
		this.qtdPrevista = qtdPrevista;
	}

	public int getQtdProduzida() {
		return qtdProduzida;
	}

	public void setQtdProduzida(int qtdProduzida) {
		this.qtdProduzida = qtdProduzida;
	}

	public int getProjecaofPeriodo() {
		return projecaofPeriodo;
	}

	public void setProjecaofPeriodo(int projecaofPeriodo) {
		this.projecaofPeriodo = projecaofPeriodo;
	}

	public double getEficRelaizacaoDec() {
		return eficRelaizacaoDec;
	}

	public void setEficRelaizacaoDec(double eficRelaizacaoDec) {
		this.eficRelaizacaoDec = eficRelaizacaoDec;
	}

	public double getEficiCicloDec() {
		return eficiCicloDec;
	}

	public void setEficiCicloDec(double eficiCicloDec) {
		this.eficiCicloDec = eficiCicloDec;
	}

	public double getIndicePaDec() {
		return indicePaDec;
	}

	public void setIndicePaDec(double indicePaDec) {
		this.indicePaDec = indicePaDec;
	}

	@Override
	public boolean equals(Object obj) {
		AcompanhamentoProducaoDTO tar = (AcompanhamentoProducaoDTO) obj;
		return (tar.getIntervalo().equals(getIntervalo()) && tar.getMaquina().equals(getMaquina()));
	}

	
}
