package idw.model.pojos.template;

import idw.model.pojos.TtSapSaiexp;

public abstract class TtSapSaiexpTemplate implements Cloneable {
	@Override
	public Object clone() {
		TtSapSaiexp objPojo = (TtSapSaiexp) this;
		
		TtSapSaiexp clone = new TtSapSaiexp();
		clone.setCentro(objPojo.getCentro());
		clone.setDeposito(objPojo.getDeposito());
		clone.setDsErro(objPojo.getDsErro());
		clone.setDthrReferencia(objPojo.getDthrReferencia());
		clone.setDtSaida(objPojo.getDtSaida());
		clone.setGlobalcode(objPojo.getGlobalcode());
		clone.setIsImportado(objPojo.getIsImportado());
		clone.setQtSaida(objPojo.getQtSaida());
		clone.setTtSapSaiexp(objPojo.getTtSapSaiexp());
				
		return clone;

	  }
	
	public void copy(TtSapSaiexp omFrom,boolean copiarFK){
		TtSapSaiexp omTo = (TtSapSaiexp) this;
		omTo.setCentro(omFrom.getCentro());
		omTo.setDeposito(omFrom.getDeposito());
		omTo.setDsErro(omFrom.getDsErro());
		omTo.setDthrReferencia(omFrom.getDthrReferencia());
		omTo.setDtSaida(omFrom.getDtSaida());
		omTo.setGlobalcode(omFrom.getGlobalcode());
		omTo.setIsImportado(omFrom.getIsImportado());
		omTo.setQtSaida(omFrom.getQtSaida());
		omTo.setTtSapSaiexp(omFrom.getTtSapSaiexp());
		
		if (copiarFK){
		}
		
	}
}
