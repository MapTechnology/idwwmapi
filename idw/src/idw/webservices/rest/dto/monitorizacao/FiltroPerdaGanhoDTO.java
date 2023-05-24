package idw.webservices.rest.dto.monitorizacao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroPerdaGanhoCiclo")
public class FiltroPerdaGanhoDTO extends FiltroDetalhePostoDTO {
	
	private static final long serialVersionUID = 1L;
	
	private int tipo;
	private String cdPostoSelecionado;
	private String cdProdutoSelecionado;
	private int tipoOrdenacao;
	private boolean mostrarParadaComPeso;
	private boolean mostrarParadaSemPeso;
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getCdPostoSelecionado() {
		return cdPostoSelecionado;
	}
	public void setCdPostoSelecionado(String cdPostoSelecionado) {
		this.cdPostoSelecionado = cdPostoSelecionado;
	}
	public String getCdProdutoSelecionado() {
		return cdProdutoSelecionado;
	}
	public void setCdProdutoSelecionado(String cdProdutoSelecionado) {
		this.cdProdutoSelecionado = cdProdutoSelecionado;
	}
	public int getTipoOrdenacao() {
		return tipoOrdenacao;
	}
	public void setTipoOrdenacao(int tipoOrdenacao) {
		this.tipoOrdenacao = tipoOrdenacao;
	}
	public boolean isMostrarParadaComPeso() {
		return mostrarParadaComPeso;
	}
	public void setMostrarParadaComPeso(boolean mostrarParadaComPeso) {
		this.mostrarParadaComPeso = mostrarParadaComPeso;
	}
	public boolean isMostrarParadaSemPeso() {
		return mostrarParadaSemPeso;
	}
	public void setMostrarParadaSemPeso(boolean mostrarParadaSemPeso) {
		this.mostrarParadaSemPeso = mostrarParadaSemPeso;
	}
	@Override
	public String toString() {
		return "FiltroPerdaGanhoDTO [tipo=" + tipo + ", cdPostoSelecionado="
				+ cdPostoSelecionado + ", cdProdutoSelecionado="
				+ cdProdutoSelecionado + ", tipoOrdenacao=" + tipoOrdenacao
				+ ", mostrarParadaComPeso=" + mostrarParadaComPeso
				+ ", mostrarParadaSemPeso=" + mostrarParadaSemPeso + "]";
	}
	
	

}
