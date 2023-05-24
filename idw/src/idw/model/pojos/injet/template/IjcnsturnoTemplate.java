package idw.model.pojos.injet.template;

import java.io.Serializable;
import java.math.BigDecimal;

import idw.model.pojos.injet.IjcnsturnoId;
import idw.model.pojos.injet.Ijop;

@SuppressWarnings("serial")
public abstract class IjcnsturnoTemplate implements Serializable{
	
	public abstract Ijop getIjop();
	public abstract void setIjop(Ijop ijop);
	
	private Boolean isConsideraCorrecaoTempo = false;
	
	public abstract BigDecimal getTmpcicnormal();
	public abstract BigDecimal getCtcp();
	public abstract BigDecimal getCtci();
	public abstract BigDecimal getTmpcicfinparada();
	public abstract BigDecimal getCtt();
	public abstract BigDecimal getTmpparadas();
	public abstract IjcnsturnoId getId();

	public BigDecimal pegarTempoDisponivel(){
		BigDecimal retorno = new BigDecimal(0);
		
		retorno = retorno.add(pegarTmpCicNormalConsiderandoCorrecao());
		retorno = retorno.add(pegarCttConsiderandoCorrecao());
		retorno = retorno.add(pegarTmpcicfinparadaConsiderandoCorrecao());
		retorno = retorno.add(getTmpparadas());
		
		return retorno;
	}
	public BigDecimal pegarTmpCicNormalConsiderandoCorrecao(){
		BigDecimal retorno = new BigDecimal(0);
		
		if (getTmpcicnormal() != null)
			retorno = getTmpcicnormal();
		
		if (isConsideraCorrecaoTempo)
			retorno = retorno.add(getCtcp());
		
		return retorno;
	}

	public BigDecimal pegarTmpcicfinparadaConsiderandoCorrecao(){
		BigDecimal retorno = getTmpcicfinparada();
		
		if (isConsideraCorrecaoTempo)
			retorno = retorno.add(getCtci());
		
		return retorno;
	}
	
	public BigDecimal pegarCttConsiderandoCorrecao(){
		BigDecimal retorno = new BigDecimal(0); 
		if (isConsideraCorrecaoTempo)
			retorno = getCtt();
		return retorno;
	}
	/**
	 * @return the isConsideraCorrecaoTempo
	 */
	public Boolean getIsConsideraCorrecaoTempo() {
		return isConsideraCorrecaoTempo;
	}
	/**
	 * @param isConsideraCorrecaoTempo the isConsideraCorrecaoTempo to set
	 */
	public void setIsConsideraCorrecaoTempo(Boolean isConsideraCorrecaoTempo) {
		this.isConsideraCorrecaoTempo = isConsideraCorrecaoTempo;
	}

	public boolean mesmoMolde(IjcnsturnoTemplate ijcnsturno){
		boolean retorno = false;
		
		if (getId().getCdmolde().equals(ijcnsturno.getId().getCdmolde()) &&
				getId().getCdestrutura().equals(ijcnsturno.getId().getCdestrutura()))
			retorno = true;
		
		return retorno;
	}
	
}
