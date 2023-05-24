package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import idw.webservices.rest.idw.v2.dto.ClasseHistogramaDTO;

@XmlRootElement(name="ciclo")
public class UltimosCicloDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cicloPadrao;
	private String lie;
	private String lse;
	private String meta;
	private String qtdAlocada;
	
	
	private String numeroCiclos;
	private String media;
	private String desvioPadrao;
	
	private String cp;
	private String cpi;
	private String cps;
	private String cpk;
	
	private int intervaloHistograma;
	private List<CicloDetalheDTO> cicloDetalhes;	
	private List<CicloDetalheDTO> cicloDetalhesView;
	private List<ClasseHistogramaDTO> classesHistograma;
	
	
			
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getLie() {
		return lie;
	}
	public void setLie(String lie) {
		this.lie = lie;
	}
	public String getLse() {
		return lse;
	}
	public void setLse(String lse) {
		this.lse = lse;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getQtdAlocada() {
		return qtdAlocada;
	}
	public void setQtdAlocada(String qtdAlocada) {
		this.qtdAlocada = qtdAlocada;
	}
	public String getNumeroCiclos() {
		return numeroCiclos;
	}
	public void setNumeroCiclos(String numeroCiclos) {
		this.numeroCiclos = numeroCiclos;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getDesvioPadrao() {
		return desvioPadrao;
	}
	public void setDesvioPadrao(String desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCpi() {
		return cpi;
	}
	public void setCpi(String cpi) {
		this.cpi = cpi;
	}
	public String getCps() {
		return cps;
	}
	public void setCps(String cps) {
		this.cps = cps;
	}
	public String getCpk() {
		return cpk;
	}
	public void setCpk(String cpk) {
		this.cpk = cpk;
	}
	public int getIntervaloHistograma() {
		return intervaloHistograma;
	}
	public void setIntervaloHistograma(int intervaloHistograma) {
		this.intervaloHistograma = intervaloHistograma;
	}
	public List<CicloDetalheDTO> getCicloDetalhes() {
		return cicloDetalhes;
	}
	public void setCicloDetalhes(List<CicloDetalheDTO> cicloDetalhes) {
		this.cicloDetalhes = cicloDetalhes;
	}
	public List<CicloDetalheDTO> getCicloDetalhesView() {
		return cicloDetalhesView;
	}
	public void setCicloDetalhesView(List<CicloDetalheDTO> cicloDetalhesView) {
		this.cicloDetalhesView = cicloDetalhesView;
	}
	public List<ClasseHistogramaDTO> getClassesHistograma() {
		return classesHistograma;
	}
	public void setClassesHistograma(List<ClasseHistogramaDTO> classesHistograma) {
		this.classesHistograma = classesHistograma;
	}
	
	
}
