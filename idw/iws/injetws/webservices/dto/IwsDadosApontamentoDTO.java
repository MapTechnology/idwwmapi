package injetws.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dados")
public class IwsDadosApontamentoDTO implements Serializable {

	/**
	 * 
	 */
	private List<IwsVariacaoRitmoValidaDTO> listaVariacoes = null;
	private static final long serialVersionUID = -4244871041817411140L;	
	private String InfoAdicional;
	private boolean deveInformarApont=false;	
	private int batidas;
	
	public String getInfoAdicional() {
		return InfoAdicional;
	}
	public void setInfoAdicional(String infoAdicional) {
		InfoAdicional = infoAdicional;
	}
	public boolean isDeveInformarApont() {
		return deveInformarApont;
	}
	public void setDeveInformarApont(boolean deveInformarApont) {
		this.deveInformarApont = deveInformarApont;
	}
	public List<IwsVariacaoRitmoValidaDTO> getListaVariacoes() {
		return listaVariacoes;
	}
	public void setListaVariacoes(List<IwsVariacaoRitmoValidaDTO> listaVariacoes) {
		this.listaVariacoes = listaVariacoes;
	}
	public int getBatidas() {
		return batidas;
	}
	public void setBatidas(int batidas) {
		this.batidas = batidas;
	}	

}
