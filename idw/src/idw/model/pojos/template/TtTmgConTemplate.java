package idw.model.pojos.template;

import idw.model.pojos.TtTmgCon;

public abstract class TtTmgConTemplate implements Cloneable {
	@Override
	public Object clone() {
		TtTmgCon objPojo = (TtTmgCon) this;
		
		TtTmgCon clone = new TtTmgCon();
		clone.setConhecimento(objPojo.getConhecimento());
		clone.setCentro(objPojo.getCentro());
		clone.setDsErro(objPojo.getDsErro());
		clone.setDthrReferencia(objPojo.getDthrReferencia());
		clone.setDtPrevistaEntrada(objPojo.getDtPrevistaEntrada());
		clone.setGlobalcode(objPojo.getGlobalcode());
		clone.setIdTmgcon(objPojo.getIdTmgcon());
		clone.setIsImportado(objPojo.getIsImportado());
		clone.setIsTransito(objPojo.getIsTransito());
		clone.setQtMaterial(objPojo.getQtMaterial());
		
		return clone;

	  }
	
	public void copy(TtTmgCon omFrom,boolean copiarFK){
		TtTmgCon omTo = (TtTmgCon) this;
		omTo.setConhecimento(omFrom.getConhecimento());
		omTo.setDsErro(omFrom.getDsErro());
		omTo.setCentro(omFrom.getCentro());
		omTo.setDthrReferencia(omFrom.getDthrReferencia());
		omTo.setDtPrevistaEntrada(omFrom.getDtPrevistaEntrada());
		omTo.setGlobalcode(omFrom.getGlobalcode());
		omTo.setIdTmgcon(omFrom.getIdTmgcon());
		omTo.setIsImportado(omFrom.getIsImportado());
		omTo.setIsTransito(omFrom.getIsTransito());
		omTo.setQtMaterial(omFrom.getQtMaterial());
		
		if (copiarFK){
		}
		
	}
}
