package idw.model.pojos.injet.template;

import idw.model.pojos.injet.Ijmolpro;
import idw.model.pojos.injet.IjmolproId;

public abstract class IjmolproTemplate implements Cloneable {

	
	@Override
	public Object clone() {
		Ijmolpro item = (Ijmolpro) this;
		
		Ijmolpro clone = new Ijmolpro();
		IjmolproId idclone = new IjmolproId();
		idclone.setCdestrutura(item.getId().getCdestrutura());
		idclone.setCdmolde(item.getId().getCdmolde());
		idclone.setCdproduto(item.getId().getCdproduto());
		idclone.setDthrival(item.getId().getDthrival());
		clone.setId(idclone);
		clone.setIjestmol(item.getIjestmol());
		clone.setIjtbusu(item.getIjtbusu());
		clone.setIjtbpro(item.getIjtbpro());
		clone.setDthrfval(item.getDthrfval());
		clone.setCdidentificacao(item.getCdidentificacao());
		clone.setQtcavidades(item.getQtcavidades());
		clone.setQtcavativas(item.getQtcavativas());
		clone.setPbrutomedio(item.getPbrutomedio());
		clone.setPliquidomedio(item.getPliquidomedio());
		
		return clone;

	  }
}
