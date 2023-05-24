package idw.model.rn.roteiroinspecao;

import idw.webservices.dto.SucessoDTO;

public abstract class RetornoDTO extends SucessoDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer totalPaginas;
	private Integer pagina;
	
	private String idioma;
	private Integer qtRegistroPorPagina;

	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Integer getQtRegistroPorPagina() {
		return qtRegistroPorPagina;
	}
	public void setQtRegistroPorPagina(Integer qtRegistroPorPagina) {
		this.qtRegistroPorPagina = qtRegistroPorPagina;
	}
	public Integer getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	
	
}
