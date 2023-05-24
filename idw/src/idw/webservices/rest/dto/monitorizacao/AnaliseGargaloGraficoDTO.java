package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="analiseGargaloGrafico")
public class AnaliseGargaloGraficoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String posto;
	private String cicloPadrao;
	private String cicloMedio;
	private String corCicloPadrao;
	private String corCicloMedio;
	private FiltroDetalhePostoDTO filtro;
	
	private String caminhoIcone;//180828 -- URL para o icone padrão do respectivo PT
	private PtIconeDTO ptIcone;//180828 preparação para uso futuro: TODO: implementar status

	private boolean gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos
	// gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos cujos PTs são de natureza semelhante . Exemplo: "5g_01_LIN01", "5g_02_LIN01", etc.
	
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
	public FiltroDetalhePostoDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroDetalhePostoDTO filtro) {
		this.filtro = filtro;
	}
	
	
	public String getCaminhoIcone() {
		return caminhoIcone;
	}
	public void setCaminhoIcone(String caminhoIcone) {
		this.caminhoIcone = caminhoIcone;
	}

	public PtIconeDTO getPtIcone() {
		return ptIcone;
	}
	public void setPtIcone(PtIconeDTO ptIcone) {
		this.ptIcone = ptIcone;
	}

	public boolean isGargalosAgrupados() {
		return gargalosAgrupados;
	}
	public void setGargalosAgrupados(boolean isGargalosAgrupados) {
		this.gargalosAgrupados = isGargalosAgrupados;
	}
	
}
