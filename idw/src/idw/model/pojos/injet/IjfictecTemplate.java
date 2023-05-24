package idw.model.pojos.injet;

public abstract class IjfictecTemplate implements Cloneable{
	@Override
	public Object clone() {
		Ijfictec item = (Ijfictec) this;
		
		Ijfictec clone = new Ijfictec();
		IjfictecId idclone = new IjfictecId();
		idclone.setCdinjetora(item.getId().getCdinjetora());
		idclone.setCdestrutura(item.getId().getCdestrutura());
		idclone.setCdmolde(item.getId().getCdmolde());
		idclone.setDthrivalcic(item.getId().getDthrivalcic());
		clone.setId(idclone);
		clone.setIjestmol(item.getIjestmol());
		clone.setIjtbusu(item.getIjtbusu());
		clone.setIjtbinj(item.getIjtbinj());
		clone.setCiclopadrao(item.getCiclopadrao());
		clone.setVarmin(item.getVarmin());
		clone.setVarmax(item.getVarmax());
		clone.setOrdpriorid(item.getOrdpriorid());
		clone.setDthrfvalcic(item.getDthrfvalcic());
		clone.setJustificativa(item.getJustificativa());
		clone.setDthrivalestru(item.getDthrivalestru());
		clone.setFatorcontagemprod(item.getFatorcontagemprod());
		
		return clone;

	  }
}
