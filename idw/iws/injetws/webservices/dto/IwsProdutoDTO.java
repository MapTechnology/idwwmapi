package injetws.webservices.dto;

@SuppressWarnings("serial")
public class IwsProdutoDTO implements java.io.Serializable {

	private String cdProduto;
	private String dsProduto;
	private String cdReduzido;
	private Float producaoPlanejada;
	private Float producaoLiquida;
	/**
	 * @return the cdReduzido
	 */
	public String getCdReduzido() {
		return cdReduzido;
	}
	/**
	 * @param cdReduzido the cdReduzido to set
	 */
	public void setCdReduzido(String cdReduzido) {
		this.cdReduzido = cdReduzido;
	}
	/**
	 * @return the cdProduto
	 */
	public String getCdProduto() {
		return cdProduto;
	}
	/**
	 * @param cdProduto the cdProduto to set
	 */
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	/**
	 * @return the dsProduto
	 */
	public String getDsProduto() {
		return dsProduto;
	}
	/**
	 * @param dsProduto the dsProduto to set
	 */
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	/**
	 * @return the producaoPlanejada
	 */
	public Float getProducaoPlanejada() {
		return producaoPlanejada;
	}
	/**
	 * @param producaoPlanejada the producaoPlanejada to set
	 */
	public void setProducaoPlanejada(Float producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	/**
	 * @return the producaoLiquida
	 */
	public Float getProducaoLiquida() {
		return producaoLiquida;
	}
	/**
	 * @param producaoLiquida the producaoLiquida to set
	 */
	public void setProducaoLiquida(Float producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
}
