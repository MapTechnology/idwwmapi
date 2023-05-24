package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptAnaliseGargalo")
public class PtAnaliseGargaloDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cor;
	private String posto;
	private String cicloPadrao;
	private String cicloMedio;
	private String horasPeriodo;
	private String horasTotais;
	private String horasDisponiveis;
	private String horasTrabalhadas;
	private String horasParadas;
	private String producaoBruta;
	private String producaoRefugada;
	private String producaoLiquida;
	private String producaoPrevista;
	private String eficienciaRealizacao;
	private String indiceRefugo;
	private String indiceParada;
	private String indiceCavidadesAtivas;
	private String eficienciaCiclo;
	private String indiceProdutividade;
	private String eficienciaInst;
	private String ito;
	private String ido;
	private String ipa;
	private String oee;
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(String cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public String getHorasPeriodo() {
		return horasPeriodo;
	}
	public void setHorasPeriodo(String horasPeriodo) {
		this.horasPeriodo = horasPeriodo;
	}
	public String getHorasTotais() {
		return horasTotais;
	}
	public void setHorasTotais(String horasTotais) {
		this.horasTotais = horasTotais;
	}
	public String getHorasDisponiveis() {
		return horasDisponiveis;
	}
	public void setHorasDisponiveis(String horasDisponiveis) {
		this.horasDisponiveis = horasDisponiveis;
	}
	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public String getHorasParadas() {
		return horasParadas;
	}
	public void setHorasParadas(String horasParadas) {
		this.horasParadas = horasParadas;
	}
	public String getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(String producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public String getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(String producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public String getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(String producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public String getProducaoPrevista() {
		return producaoPrevista;
	}
	public void setProducaoPrevista(String producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}
	public String getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(String eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	public String getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(String indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public String getIndiceParada() {
		return indiceParada;
	}
	public void setIndiceParada(String indiceParada) {
		this.indiceParada = indiceParada;
	}
	public String getIndiceCavidadesAtivas() {
		return indiceCavidadesAtivas;
	}
	public void setIndiceCavidadesAtivas(String indiceCavidadesAtivas) {
		this.indiceCavidadesAtivas = indiceCavidadesAtivas;
	}
	public String getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(String eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public String getIndiceProdutividade() {
		return indiceProdutividade;
	}
	public void setIndiceProdutividade(String indiceProdutividade) {
		this.indiceProdutividade = indiceProdutividade;
	}
	public String getEficienciaInst() {
		return eficienciaInst;
	}
	public void setEficienciaInst(String eficienciaInst) {
		this.eficienciaInst = eficienciaInst;
	}
	public String getIto() {
		return ito;
	}
	public void setIto(String ito) {
		this.ito = ito;
	}
	public String getIdo() {
		return ido;
	}
	public void setIdo(String ido) {
		this.ido = ido;
	}
	public String getIpa() {
		return ipa;
	}
	public void setIpa(String ipa) {
		this.ipa = ipa;
	}
	public String getOee() {
		return oee;
	}
	public void setOee(String oee) {
		this.oee = oee;
	}
	
	

}
