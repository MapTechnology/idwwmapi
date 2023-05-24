package idw.model.pojos.template;

import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;



public abstract class OmMapapaTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		OmMapapa omMapapa = (OmMapapa) this;
		OmMapapa clone = new OmMapapa();
		
		clone.setIdMapapa(omMapapa.getIdMapapa());
		clone.setQtUsada(omMapapa.getQtUsada());
		clone.setIsCiclounico(omMapapa.getIsCiclounico());;

		if (omMapapa.getOmPa() != null)
			clone.setOmPa((OmPa)omMapapa.getOmPa().clone(false));
		
		clone.setOmProduto((OmProduto)omMapapa.getOmProduto().clone(false));		
		
		return clone;
	}
	
	public void copy(OmMapapa omFrom,boolean copiarFK){
		OmMapapa omTo = (OmMapapa) this;
		omTo.setIdMapapa(omFrom.getIdMapapa());
		
		if (copiarFK){
			omTo.setOmPa(omFrom.getOmPa());						
			omTo.setOmProduto(omFrom.getOmProduto());
		}
		
	}
}
