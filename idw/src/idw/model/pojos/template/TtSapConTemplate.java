package idw.model.pojos.template;

import idw.model.pojos.TtSapCon;

public abstract class TtSapConTemplate implements Cloneable {
	@Override
	public Object clone() {
		TtSapCon objPojo = (TtSapCon) this;
		
		TtSapCon clone = new TtSapCon();
		clone.setCentro(objPojo.getCentro());
		clone.setConhecimento(objPojo.getConhecimento());
		clone.setDeposito(objPojo.getDeposito());
		clone.setDsErro(objPojo.getDsErro());
		clone.setDsErro(objPojo.getDsErro());
		clone.setDtConhecimento(objPojo.getDtConhecimento());
		clone.setDthrReferencia(objPojo.getDthrReferencia());
		clone.setIdSapcon(objPojo.getIdSapcon());
		clone.setIdSapcon(objPojo.getIdSapcon());
		clone.setIsImportado(objPojo.getIsImportado());

		return clone;

	  }
	
	public void copy(TtSapCon omFrom,boolean copiarFK){
		TtSapCon omTo = (TtSapCon) this;
		omTo.setCentro(omFrom.getCentro());
		omTo.setConhecimento(omFrom.getConhecimento());
		omTo.setDeposito(omFrom.getDeposito());
		omTo.setDsErro(omFrom.getDsErro());
		omTo.setDsErro(omFrom.getDsErro());
		omTo.setDtConhecimento(omFrom.getDtConhecimento());
		omTo.setDthrReferencia(omFrom.getDthrReferencia());
		omTo.setIdSapcon(omFrom.getIdSapcon());
		omTo.setIdSapcon(omFrom.getIdSapcon());
		omTo.setIsImportado(omFrom.getIsImportado());
		
		if (copiarFK){
		}
		
	}
}