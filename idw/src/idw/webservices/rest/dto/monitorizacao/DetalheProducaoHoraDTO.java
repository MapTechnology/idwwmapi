package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="detalheProducaoHora")
public class DetalheProducaoHoraDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String dtHrInicial;
	private String dtHrFinal;
	private String duracaoIntervalo;
	private String tempoDisponivel;
	private String horasTrabalhadas;
	private String horasParadas;
	private String horasParadasView;
	private String indiceParadas;
	private String ultimoCicloPadrao;
	private String cicloPadraoMedio;
	private String cicloMedio;
	private String perdasPorCiclo;
	private String perdasPorParadas;
	private String perdasPorRefugos;
	private String totalPerdas;
	
	private boolean isMostrarGraficoPerdas;
	
	private List<TabelaProducaoHora> listaProducao;
	private List<TabelaRefugoHora> listaRefugo;
	private List<TabelaParadaHoraDTO> listaParada;
	
	public String getDtHrInicial() {
		return dtHrInicial;
	}
	public void setDtHrInicial(String dtHrInicial) {
		this.dtHrInicial = dtHrInicial;
	}
	public String getDtHrFinal() {
		return dtHrFinal;
	}
	public void setDtHrFinal(String dtHrFinal) {
		this.dtHrFinal = dtHrFinal;
	}
	public String getDuracaoIntervalo() {
		return duracaoIntervalo;
	}
	public void setDuracaoIntervalo(String duracaoIntervalo) {
		this.duracaoIntervalo = duracaoIntervalo;
	}
	public String getTempoDisponivel() {
		return tempoDisponivel;
	}
	public void setTempoDisponivel(String tempoDisponivel) {
		this.tempoDisponivel = tempoDisponivel;
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
	public String getHorasParadasView() {
		return horasParadasView;
	}
	public void setHorasParadasView(String horasParadasView) {
		this.horasParadasView = horasParadasView;
	}
	public String getIndiceParadas() {
		return indiceParadas;
	}
	public void setIndiceParadas(String indiceParadas) {
		this.indiceParadas = indiceParadas;
	}
	public String getUltimoCicloPadrao() {
		return ultimoCicloPadrao;
	}
	public void setUltimoCicloPadrao(String ultimoCicloPadrao) {
		this.ultimoCicloPadrao = ultimoCicloPadrao;
	}
	public String getCicloPadraoMedio() {
		return cicloPadraoMedio;
	}
	public void setCicloPadraoMedio(String cicloPadraoMedio) {
		this.cicloPadraoMedio = cicloPadraoMedio;
	}
	public String getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(String cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public String getPerdasPorCiclo() {
		return perdasPorCiclo;
	}
	public void setPerdasPorCiclo(String perdasPorCiclo) {
		this.perdasPorCiclo = perdasPorCiclo;
	}
	public String getPerdasPorParadas() {
		return perdasPorParadas;
	}
	public void setPerdasPorParadas(String perdasPorParadas) {
		this.perdasPorParadas = perdasPorParadas;
	}
	public String getPerdasPorRefugos() {
		return perdasPorRefugos;
	}
	public void setPerdasPorRefugos(String perdasPorRefugos) {
		this.perdasPorRefugos = perdasPorRefugos;
	}
	public String getTotalPerdas() {
		return totalPerdas;
	}
	public void setTotalPerdas(String totalPerdas) {
		this.totalPerdas = totalPerdas;
	}
	public boolean isMostrarGraficoPerdas() {
		return isMostrarGraficoPerdas;
	}
	public void setMostrarGraficoPerdas(boolean isMostrarGraficoPerdas) {
		this.isMostrarGraficoPerdas = isMostrarGraficoPerdas;
	}
	public List<TabelaProducaoHora> getListaProducao() {
		return listaProducao;
	}
	public void setListaProducao(List<TabelaProducaoHora> listaProducao) {
		this.listaProducao = listaProducao;
	}
	public List<TabelaRefugoHora> getListaRefugo() {
		return listaRefugo;
	}
	public void setListaRefugo(List<TabelaRefugoHora> listaRefugo) {
		this.listaRefugo = listaRefugo;
	}
	public List<TabelaParadaHoraDTO> getListaParada() {
		return listaParada;
	}
	public void setListaParada(List<TabelaParadaHoraDTO> listaParada) {
		this.listaParada = listaParada;
	}
	
	
	

}
