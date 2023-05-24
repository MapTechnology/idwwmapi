package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="detalheCiclo")
public class DetalheCicloDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private ResumoPerdaGanhoCicloDTO resumo;
	private MetaIndicadorDTO metaIndicador;
	private List<GraficoDetalheCicloDTO> produtosPerdas;
	private List<GraficoDetalheCicloDTO> produtosGanhos;
	private List<GraficoDetalheCicloDTO> postosPerdas;
	private List<GraficoDetalheCicloDTO> postosGanhos;
	
	public ResumoPerdaGanhoCicloDTO getResumo() {
		return resumo;
	}
	public void setResumo(ResumoPerdaGanhoCicloDTO resumo) {
		this.resumo = resumo;
	}
	public MetaIndicadorDTO getMetaIndicador() {
		return metaIndicador;
	}
	public void setMetaIndicador(MetaIndicadorDTO metaIndicador) {
		this.metaIndicador = metaIndicador;
	}
	public List<GraficoDetalheCicloDTO> getProdutosPerdas() {
		return produtosPerdas;
	}
	public void setProdutosPerdas(List<GraficoDetalheCicloDTO> produtosPerdas) {
		this.produtosPerdas = produtosPerdas;
	}
	public List<GraficoDetalheCicloDTO> getProdutosGanhos() {
		return produtosGanhos;
	}
	public void setProdutosGanhos(List<GraficoDetalheCicloDTO> produtosGanhos) {
		this.produtosGanhos = produtosGanhos;
	}
	public List<GraficoDetalheCicloDTO> getPostosPerdas() {
		return postosPerdas;
	}
	public void setPostosPerdas(List<GraficoDetalheCicloDTO> postosPerdas) {
		this.postosPerdas = postosPerdas;
	}
	public List<GraficoDetalheCicloDTO> getPostosGanhos() {
		return postosGanhos;
	}
	public void setPostosGanhos(List<GraficoDetalheCicloDTO> postosGanhos) {
		this.postosGanhos = postosGanhos;
	}
	
	
	
	
}
