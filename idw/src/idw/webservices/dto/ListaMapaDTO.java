package idw.webservices.dto;

import java.util.List;

import idw.util.Util;

@SuppressWarnings("serial")
public class ListaMapaDTO implements java.io.Serializable{
	private List<MapaDTO> listMapaDTO;
	private String nomePrograma;
	private String dataPrograma;
	private String nomeMaquina;
	private String nomeLinha;
	private int	estagio;
	private String nomeSemiProduto;
	private String cliente;
	/**
     * Mascaras
     */
    private String mascaraPrograma = "??????";
    private String mascaraProduto = "??????";
    
	public ListaMapaDTO(){
	
	}
	
	public void setListMapaDTO(List<MapaDTO> listMapaDTO) {
		this.listMapaDTO = listMapaDTO;
	}

	public List<MapaDTO> getListMapaDTO() {
		return listMapaDTO;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

	public String getNomePrograma() {
		return Util.extraiPorMascara(nomePrograma, mascaraPrograma);
	}

	public void setDataPrograma(String dataPrograma) {
		this.dataPrograma = dataPrograma;
	}

	public String getDataPrograma() {
		return dataPrograma;
	}

	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}

	public String getNomeMaquina() {
		return nomeMaquina;
	}

	public void setNomeLinha(String nomeLinha) {
		this.nomeLinha = nomeLinha;
	}

	public String getNomeLinha() {
		return nomeLinha;
	}

	public void setEstagio(int estagio) {
		this.estagio = estagio;
	}

	public int getEstagio() {
		return estagio;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setNomeSemiProduto(String nomeSemiProduto) {
		this.nomeSemiProduto = nomeSemiProduto;
	}

	public String getNomeSemiProduto() {
		return Util.extraiPorMascara(nomeSemiProduto, mascaraProduto);
	}
	
}
