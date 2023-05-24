package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tabelaParadaHora")
public class TabelaParadaHoraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String posto;
	private String folha;
	private String ferramenta;
	private String parada;
	private String inicio;
	private String fim;
	private String duracao;
	private String areaResponsavel;
	private String causa;
	private String acao;
	private String justificativa;
	private String tecnico1;
	private String tecnico2;
	private String tecnicoResponsavel;
	private String perdasParada;
	private String turno;
	
	private FiltroDetalheParadaDTO filtro;
	
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getFolha() {
		return folha;
	}
	public void setFolha(String folha) {
		this.folha = folha;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getAreaResponsavel() {
		return areaResponsavel;
	}
	public void setAreaResponsavel(String areaResponsavel) {
		this.areaResponsavel = areaResponsavel;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public String getTecnico1() {
		return tecnico1;
	}
	public void setTecnico1(String tecnico1) {
		this.tecnico1 = tecnico1;
	}
	public String getTecnico2() {
		return tecnico2;
	}
	public void setTecnico2(String tecnico2) {
		this.tecnico2 = tecnico2;
	}
	public String getTecnicoResponsavel() {
		return tecnicoResponsavel;
	}
	public void setTecnicoResponsavel(String tecnicoResponsavel) {
		this.tecnicoResponsavel = tecnicoResponsavel;
	}
	public String getPerdasParada() {
		return perdasParada;
	}
	public void setPerdasParada(String perdasParada) {
		this.perdasParada = perdasParada;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public FiltroDetalheParadaDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroDetalheParadaDTO filtro) {
		this.filtro = filtro;
	}
	
	
}
