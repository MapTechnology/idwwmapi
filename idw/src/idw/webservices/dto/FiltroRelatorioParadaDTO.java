package idw.webservices.dto;

import idw.model.pojos.OmTppt;

public class FiltroRelatorioParadaDTO {
	
	private OmTppt omTppt;
	private boolean ordenar;
	private Byte situacao;

	public boolean isOrdenar() {
		return ordenar;
	}
	
	public void setOrdenar(boolean ordenar) {
		this.ordenar = ordenar;
	}

	public OmTppt getOmTppt() {
		return omTppt;
	}
	
	public void setOmTppt(OmTppt omTppt) {
		this.omTppt = omTppt;
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
		
		retorno = "FiltroRelatorioParadaDTO [";
		
		retorno += "omTppt=";
		
		if (this.omTppt != null) {
			retorno += this.omTppt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "ordenar=" + this.ordenar + ", " +
				   "situacao=" + this.situacao + "]";
		
		return retorno;
		
		//return "FiltroRelatorioParadaDTO [omTppt=" + omTppt + ", ordenar=" + ordenar + ", situacao=" + situacao + "]";
	}
 
}
