package injetws.webservices.dto;

@SuppressWarnings("serial")
public class IwsDefeitoDTO implements java.io.Serializable{
	private String cdDefeito;
	private String dsDefeito;
	private String quantidade;
	/**
	 * @return the cdDefeito
	 */
	public String getCdDefeito() {
		return cdDefeito;
	}
	/**
	 * @param cdDefeito the cdDefeito to set
	 */
	public void setCdDefeito(String cdDefeito) {
		this.cdDefeito = cdDefeito;
	}
	/**
	 * @return the dsDefeito
	 */
	public String getDsDefeito() {
		return dsDefeito;
	}
	/**
	 * @param dsDefeito the dsDefeito to set
	 */
	public void setDsDefeito(String dsDefeito) {
		this.dsDefeito = dsDefeito;
	}
	/**
	 * @return the quantidade
	 */
	public String getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
}
