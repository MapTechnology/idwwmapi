package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="analiseGargalo")
public class AnaliseGargaloDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String grupoTrabalho;
	private String data;
	private String turno;
	private String corCicloPadrao;
	private String corCicloMedio;
	private String corCicloMedioGargaloAgrupado;//190508
	private String corGargaloTeorico;
	private String corGargaloDinamico;
	private List<PtAnaliseGargaloDTO> postos;
	private List<AnaliseGargaloGraficoDTO> gargalos;
	private PtIndicadorDTO indicadoresApontamentoGt;
	private PtTemposDTO temposApontamentoGt;
	private PtIconeDTO icone;
	private boolean gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos
	// gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos cujos PTs são de natureza semelhante . Exemplo: "5g_01_LIN01", "5g_02_LIN01", etc.
	
	
	public String getGrupoTrabalho() {
		return grupoTrabalho;
	}
	public void setGrupoTrabalho(String grupoTrabalho) {
		this.grupoTrabalho = grupoTrabalho;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getCorCicloPadrao() {
		return corCicloPadrao;
	}
	public void setCorCicloPadrao(String corCicloPadrao) {
		this.corCicloPadrao = corCicloPadrao;
	}
	public String getCorCicloMedio() {
		return corCicloMedio;
	}
	public void setCorCicloMedio(String corCicloMedio) {
		this.corCicloMedio = corCicloMedio;
	}
	public String getCorGargaloTeorico() {
		return corGargaloTeorico;
	}
	public void setCorGargaloTeorico(String corGargaloTeorico) {
		this.corGargaloTeorico = corGargaloTeorico;
	}
	public String getCorGargaloDinamico() {
		return corGargaloDinamico;
	}
	public void setCorGargaloDinamico(String corGargaloDinamico) {
		this.corGargaloDinamico = corGargaloDinamico;
	}
	public List<PtAnaliseGargaloDTO> getPostos() {
		return postos;
	}
	public void setPostos(List<PtAnaliseGargaloDTO> postos) {
		this.postos = postos;
	}
	public List<AnaliseGargaloGraficoDTO> getGargalos() {
		return gargalos;
	}
	public void setGargalos(List<AnaliseGargaloGraficoDTO> gargalos) {
		this.gargalos = gargalos;
	}
	public PtIndicadorDTO getIndicadoresApontamentoGt() {
		return indicadoresApontamentoGt;
	}
	public void setIndicadoresApontamentoGt(PtIndicadorDTO indicadoresApontamentoGt) {
		this.indicadoresApontamentoGt = indicadoresApontamentoGt;
	}
	public PtTemposDTO getTemposApontamentoGt() {
		return temposApontamentoGt;
	}
	public void setTemposApontamentoGt(PtTemposDTO temposApontamentoGt) {
		this.temposApontamentoGt = temposApontamentoGt;
	}
	public PtIconeDTO getIcone() {
		return icone;
	}
	public void setIcone(PtIconeDTO icone) {
		this.icone = icone;
	}

	public boolean isGargalosAgrupados() {
		return gargalosAgrupados;
	}
	public void setGargalosAgrupados(boolean isGargalosAgrupados) {
		this.gargalosAgrupados = isGargalosAgrupados;
	}
	
	public String getCorCicloMedioGargaloAgrupado() {
		return corCicloMedioGargaloAgrupado;
	}
	public void setCorCicloMedioGargaloAgrupado(String corCicloMedioGargaloAgrupado) {
		this.corCicloMedioGargaloAgrupado = corCicloMedioGargaloAgrupado;
	}
	
	
}
