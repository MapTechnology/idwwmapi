package idw.model.pojos.injet.template;

import java.math.BigDecimal;

import idw.model.pojos.injet.IjcnsmaqopId;

public abstract class IjcnsmaqopTemplate {
	
	private Boolean isConsideraCorrecaoTempo = false;
	
	public abstract BigDecimal getTmpcicnormal();
	public abstract BigDecimal getCtcp();
	public abstract BigDecimal getCtci();
	public abstract BigDecimal getTmpcicfinparada();
	public abstract BigDecimal getCtt();
	public abstract BigDecimal getTmpparadas();
	public abstract IjcnsmaqopId getId();

	public BigDecimal pegarTempoDisponivel(){
		BigDecimal retorno = new BigDecimal(0);
		
		retorno = retorno.add(pegarTmpCicNormalConsiderandoCorrecao());
		retorno = retorno.add(pegarCttConsiderandoCorrecao());
		retorno = retorno.add(pegarTmpcicfinparadaConsiderandoCorrecao());
		retorno = retorno.add(getTmpparadas());
		
		return new BigDecimal(retorno.intValue());
	}
	public BigDecimal pegarTmpCicNormalConsiderandoCorrecao(){
		BigDecimal retorno = getTmpcicnormal();
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

	public boolean mesmoMolde(IjcnsmaqopTemplate ijcnsturno){
		boolean retorno = false;
		
		if (getId().getCdmolde().equals(ijcnsturno.getId().getCdmolde()) &&
				getId().getCdestrutura().equals(ijcnsturno.getId().getCdestrutura()))
			retorno = true;
		
		return retorno;
	}
}
