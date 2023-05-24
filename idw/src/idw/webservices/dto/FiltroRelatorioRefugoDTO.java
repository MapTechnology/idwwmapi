package idw.webservices.dto;

import idw.model.pojos.OmTppt;

public class FiltroRelatorioRefugoDTO {

	private OmTppt omTpptRefugo;
	private boolean ordenarRefugo;
	private Byte situacao;
  
	public OmTppt getOmTpptRefugo() {
		return omTpptRefugo;
	}
	public void setOmTpptRefugo(OmTppt omTpptRefugo) {
		this.omTpptRefugo = omTpptRefugo;
	}
	public boolean isOrdenarRefugo() {
		return ordenarRefugo;
	}
	public void setOrdenarRefugo(boolean ordenarRefugo) {
		this.ordenarRefugo = ordenarRefugo;
	}
	public Byte getSituacao() {
		return situacao;
	}
	public void setSituacao(Byte situacao) {
		this.situacao = situacao;
	}
	@Override
	public String toString() {
	
		String retorno;
		
		retorno = "FiltroRelatorioRefugoDTO [";
		
		retorno += "omTpptRefugo=";
		
		if (this.omTpptRefugo != null) {
			retorno += this.omTpptRefugo.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "ordenarRefugo=" + this.ordenarRefugo + ", " +
				   "situacao=" + this.situacao + "]";
		
		return retorno;
		
		/*return "FiltroRelatorioRefugoDTO [omTpptRefugo=" + omTpptRefugo + ", ordenarRefugo=" + ordenarRefugo + ", situacao=" + situacao + "]";*/
	
	}

}
