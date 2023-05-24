package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="analiseTurno")
public class AnaliseTurnoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String eficienciaRealizacao;
	private String producaoPlanejada;
	private String producaoPrevista;
	private String producaoTotal;
	private String perdasTotais;
	private String indicePerda;
	private String produtividadeOee;
	
	private String indiceParadas;
	private String perdasPorParadas;
	private String tempoTotalParadas;
	
	private String indiceCavidadesAtivas;
	
	private String indiceRefugos;
	private String refugos;
	
	private String eficienciaCiclo;
	private String perdasIneficienciaCiclo;
	private String eficienciaInstantanea;
	
	private List<MetaIndicadorDTO> metaIndicadores;
	private List<AnaliseTurnoPostoDTO> postos;
	private List<AnaliseTurnoGtDTO> gts;
	
	private List<IndicadorDTO> listaEficienciaRealizacao;
	private List<IndicadorDTO> listaEficienciaCiclo;
	private List<IndicadorDTO> listaIndiceRefugos;
	private List<IndicadorDTO> listaIndiceParadas;
	private List<IndicadorDTO> listaIndicePerdas;
	private List<IndicadorDTO> listaIndiceCavidadesAtivas;
	private List<IndicadorDTO> listaProdutividadeOee;
	private List<IndicadorDTO> listaEficienciaInstantanea;
	
	public String getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(String eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	public String getProducaoPlanejada() {
		return producaoPlanejada;
	}
	public void setProducaoPlanejada(String producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	public String getProducaoPrevista() {
		return producaoPrevista;
	}
	public void setProducaoPrevista(String producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}
	public String getProducaoTotal() {
		return producaoTotal;
	}
	public void setProducaoTotal(String producaoTotal) {
		this.producaoTotal = producaoTotal;
	}
	public String getPerdasTotais() {
		return perdasTotais;
	}
	public void setPerdasTotais(String perdasTotais) {
		this.perdasTotais = perdasTotais;
	}
	public String getIndicePerda() {
		return indicePerda;
	}
	public void setIndicePerda(String indicePerda) {
		this.indicePerda = indicePerda;
	}
	public String getProdutividadeOee() {
		return produtividadeOee;
	}
	public void setProdutividadeOee(String produtividadeOee) {
		this.produtividadeOee = produtividadeOee;
	}
	public String getIndiceParadas() {
		return indiceParadas;
	}
	public void setIndiceParadas(String indiceParadas) {
		this.indiceParadas = indiceParadas;
	}
	public String getPerdasPorParadas() {
		return perdasPorParadas;
	}
	public void setPerdasPorParadas(String perdasPorParadas) {
		this.perdasPorParadas = perdasPorParadas;
	}
	public String getTempoTotalParadas() {
		return tempoTotalParadas;
	}
	public void setTempoTotalParadas(String tempoTotalParadas) {
		this.tempoTotalParadas = tempoTotalParadas;
	}
	public String getIndiceCavidadesAtivas() {
		return indiceCavidadesAtivas;
	}
	public void setIndiceCavidadesAtivas(String indiceCavidadesAtivas) {
		this.indiceCavidadesAtivas = indiceCavidadesAtivas;
	}
	public String getIndiceRefugos() {
		return indiceRefugos;
	}
	public void setIndiceRefugos(String indiceRefugos) {
		this.indiceRefugos = indiceRefugos;
	}
	public String getRefugos() {
		return refugos;
	}
	public void setRefugos(String refugos) {
		this.refugos = refugos;
	}
	public String getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(String eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public String getPerdasIneficienciaCiclo() {
		return perdasIneficienciaCiclo;
	}
	public void setPerdasIneficienciaCiclo(String perdasIneficienciaCiclo) {
		this.perdasIneficienciaCiclo = perdasIneficienciaCiclo;
	}
	public String getEficienciaInstantanea() {
		return eficienciaInstantanea;
	}
	public void setEficienciaInstantanea(String eficienciaInstantanea) {
		this.eficienciaInstantanea = eficienciaInstantanea;
	}
	public List<MetaIndicadorDTO> getMetaIndicadores() {
		return metaIndicadores;
	}
	public void setMetaIndicadores(List<MetaIndicadorDTO> metaIndicadores) {
		this.metaIndicadores = metaIndicadores;
	}
	public List<AnaliseTurnoPostoDTO> getPostos() {
		return postos;
	}
	public void setPostos(List<AnaliseTurnoPostoDTO> postos) {
		this.postos = postos;
	}
	public List<IndicadorDTO> getListaEficienciaRealizacao() {
		return listaEficienciaRealizacao;
	}
	public void setListaEficienciaRealizacao(
			List<IndicadorDTO> listaEficienciaRealizacao) {
		this.listaEficienciaRealizacao = listaEficienciaRealizacao;
	}
	public List<IndicadorDTO> getListaEficienciaCiclo() {
		return listaEficienciaCiclo;
	}
	public void setListaEficienciaCiclo(List<IndicadorDTO> listaEficienciaCiclo) {
		this.listaEficienciaCiclo = listaEficienciaCiclo;
	}
	public List<IndicadorDTO> getListaIndiceRefugos() {
		return listaIndiceRefugos;
	}
	public void setListaIndiceRefugos(List<IndicadorDTO> listaIndiceRefugos) {
		this.listaIndiceRefugos = listaIndiceRefugos;
	}
	public List<IndicadorDTO> getListaIndiceParadas() {
		return listaIndiceParadas;
	}
	public void setListaIndiceParadas(List<IndicadorDTO> listaIndiceParadas) {
		this.listaIndiceParadas = listaIndiceParadas;
	}
	public List<IndicadorDTO> getListaIndicePerdas() {
		return listaIndicePerdas;
	}
	public void setListaIndicePerdas(List<IndicadorDTO> listaIndicePerdas) {
		this.listaIndicePerdas = listaIndicePerdas;
	}
	public List<IndicadorDTO> getListaIndiceCavidadesAtivas() {
		return listaIndiceCavidadesAtivas;
	}
	public void setListaIndiceCavidadesAtivas(
			List<IndicadorDTO> listaIndiceCavidadesAtivas) {
		this.listaIndiceCavidadesAtivas = listaIndiceCavidadesAtivas;
	}
	public List<IndicadorDTO> getListaProdutividadeOee() {
		return listaProdutividadeOee;
	}
	public void setListaProdutividadeOee(List<IndicadorDTO> listaProdutividadeOee) {
		this.listaProdutividadeOee = listaProdutividadeOee;
	}
	public List<IndicadorDTO> getListaEficienciaInstantanea() {
		return listaEficienciaInstantanea;
	}
	public void setListaEficienciaInstantanea(
			List<IndicadorDTO> listaEficienciaInstantanea) {
		this.listaEficienciaInstantanea = listaEficienciaInstantanea;
	}
	public List<AnaliseTurnoGtDTO> getGts() {
		return gts;
	}
	public void setGts(List<AnaliseTurnoGtDTO> gts) {
		this.gts = gts;
	}

	
	
	
}
