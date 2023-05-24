package idw.model.rn.geraplano.dtos;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class IdCtDTO implements Comparable<IdCtDTO>{
	private OmPt omptEscolhido;
	private OmGt omgtEscolhido;

	@Override
	public String toString(){
		return (getOmptEscolhido() != null ? getOmptEscolhido().getCdPt() : (getOmgtEscolhido() != null ? getOmgtEscolhido().getCdGt() : "sem ct"));
	}

	public OmPt getOmptEscolhido() {
		return omptEscolhido;
	}
	public void setOmptEscolhido(OmPt omptEscolhido) {
		this.omptEscolhido = omptEscolhido;
	}
	public OmGt getOmgtEscolhido() {
		return omgtEscolhido;
	}
	public void setOmgtEscolhido(OmGt omgtEscolhido) {
		this.omgtEscolhido = omgtEscolhido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((omgtEscolhido == null) ? 0 : omgtEscolhido.hashCode());
		result = prime * result
				+ ((omptEscolhido == null) ? 0 : omptEscolhido.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdCtDTO other = (IdCtDTO) obj;
		
		if (getOmptEscolhido() != null && other.getOmptEscolhido() != null) {
			if (getOmptEscolhido().getIdPt().equals(other.getOmptEscolhido().getIdPt()) == true)
				return true;
		} else  if (getOmgtEscolhido() != null && other.getOmgtEscolhido() != null) {
			if (getOmgtEscolhido().getIdGt().equals(other.getOmgtEscolhido().getIdGt()) == true)
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(IdCtDTO o) {
		// No momento a ordenacao abaixo esta fixa, mas para generalizar o sistema
		// deve-se criar uma configuracao para definir a ordem
		int ordem1 = getOrdemPeloTpPt(this);
		int ordem2 = getOrdemPeloTpPt(o);
		return (ordem1 < ordem2 ? -1 : (ordem1 > ordem2 ? +1 :
			toString().compareTo(o.toString())
			) );
	}
	
	private int getOrdemPeloTpPt(IdCtDTO idp){
		int retorno = 6;
		if (idp.toString().indexOf("PtMS") >= 0)
			retorno = 1;
		if (idp.toString().indexOf("PtJVK") >= 0)
			retorno = 2;
		if (idp.toString().indexOf("PtAVK") >= 0)
			retorno = 3;
		if (idp.toString().indexOf("PtRH") >= 0)
			retorno = 4;
		if (idp.toString().indexOf("GtSMD") >= 0 || idp.toString().indexOf("PtSMD") >= 0)
			retorno = 5;

		return retorno;
	}
}
