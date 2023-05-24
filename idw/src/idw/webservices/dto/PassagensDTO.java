package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class PassagensDTO implements Serializable {

	private List<NaoConformidadeDTO> ncs;
	private List<PassagemDTO> listaPessagem;

	private String opAtualPosto;
	
	public List<PassagemDTO> getPassagens() {
		return listaPessagem;
	}

	public void setPesquisa(List<PassagemDTO> listaPessagem) {
		this.listaPessagem = listaPessagem;
	}

	public List<PassagemDTO> getListaPessagem() {
		return listaPessagem;
	}

	public void setListaPessagem(List<PassagemDTO> listaPessagem) {
		this.listaPessagem = listaPessagem;
	}

	public List<NaoConformidadeDTO> getNcs() {
		return ncs;
	}

	public void setNcs(List<NaoConformidadeDTO> ncs) {
		this.ncs = ncs;
	}

	public String getOpAtualPosto() {
		return opAtualPosto;
	}

	public void setOpAtualPosto(String opAtualPosto) {
		this.opAtualPosto = opAtualPosto;
	}

}
