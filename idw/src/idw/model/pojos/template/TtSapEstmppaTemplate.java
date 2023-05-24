package idw.model.pojos.template;

import idw.model.pojos.TtSapEstmppa;

public abstract class TtSapEstmppaTemplate implements Cloneable {
	@Override
	public Object clone() {
		TtSapEstmppa objPojo = (TtSapEstmppa) this;
		
		TtSapEstmppa clone = new TtSapEstmppa();
		clone.setCentro(objPojo.getCentro());
		clone.setDeposito(objPojo.getDeposito());
		clone.setDsErro(objPojo.getDsErro());
		clone.setDthrReferencia(objPojo.getDthrReferencia());
		clone.setGlobalcode(objPojo.getGlobalcode());
		clone.setIdSapestmppa(objPojo.getIdSapestmppa());
		clone.setIsImportado(objPojo.getIsImportado());
		clone.setQtEstoque(objPojo.getQtEstoque());
		
		return clone;

	  }
	
	public void copy(TtSapEstmppa omFrom,boolean copiarFK){
		TtSapEstmppa omTo = (TtSapEstmppa) this;
		omTo.setCentro(omFrom.getCentro());
		omTo.setDeposito(omFrom.getDeposito());
		omTo.setDsErro(omFrom.getDsErro());
		omTo.setDthrReferencia(omFrom.getDthrReferencia());
		omTo.setGlobalcode(omFrom.getGlobalcode());
		omTo.setIdSapestmppa(omFrom.getIdSapestmppa());
		omTo.setIsImportado(omFrom.getIsImportado());
		omTo.setQtEstoque(omFrom.getQtEstoque());
		
		if (copiarFK){
		}
		
	}
}
