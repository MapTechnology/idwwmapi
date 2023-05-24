package injetws.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class IwsRefugoComDefeitosDTO implements Serializable{
	
	private String idUP;
	private String quantidade;
	private String idRdzProduto;
	private List<IwsDefeitoDTO> defeitos = new ArrayList<IwsDefeitoDTO>();
	
	public void addDefeito(IwsDefeitoDTO defeito){
		this.defeitos.add(defeito);
	}
	/**
	 * @return the idUP
	 */
	public String getIdUP() {
		return idUP;
	}
	/**
	 * @param idUP the idUP to set
	 */
	public void setIdUP(String idUP) {
		this.idUP = idUP;
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
	/**
	 * @return the idRdzProduto
	 */
	public String getIdRdzProduto() {
		return idRdzProduto;
	}
	/**
	 * @param idRdzProduto the idRdzProduto to set
	 */
	public void setIdRdzProduto(String idRdzProduto) {
		this.idRdzProduto = idRdzProduto;
	}
	/**
	 * @return the defeitos
	 */
	public List<IwsDefeitoDTO> getDefeitos() {
		return defeitos;
	}
	/**
	 * @param defeitos the defeitos to set
	 */
	public void setDefeitos(List<IwsDefeitoDTO> defeitos) {
		this.defeitos = defeitos;
	}
}
