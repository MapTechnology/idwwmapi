package idw.model.pojos.template;



import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalpt;


public abstract class DwCalptTemplate extends AbstractTemplate<DwCalpt> {
	
	@Override
	protected DwCalpt atribuir(DwCalpt from, DwCalpt to, boolean isCopiarFK) {
		
		if(to == null){
			to = new DwCalpt();
		}
		
		DwCalpt omTo = (DwCalpt) this;
		omTo.setIdCalpt(from.getIdCalpt());
		omTo.setDthrivalidade(from.getDthrivalidade());
		omTo.setDthrStativo(from.getDthrStativo());
		omTo.setStAtivo(from.getStAtivo().byteValue());
		
		if (isCopiarFK){
			omTo.setOmPt(from.getOmPt());			
			omTo.setDwCal(from.getDwCal());
		}
		
		return to;
	}
	
	@Override
	public DwCalpt clone() {
		return this.clone(true);
	}

	@Override
	public DwCalpt clone(boolean isCopiarFK){

		DwCalpt item = (DwCalpt) this;
		
		DwCalpt clone = new DwCalpt();
		clone.setIdCalpt(item.getIdCalpt());
		clone.setDthrivalidade(item.getDthrivalidade());
		clone.setDthrStativo(item.getDthrStativo());		
		clone.setOmPt(item.getOmPt().clone());
		clone.setStAtivo(item.getStAtivo());
		
		if (isCopiarFK){
			clone.setDwCal((DwCal)item.getDwCal().clone());
		}
		
		clone = this.atribuir(item, clone, isCopiarFK);
		
		return clone;
	}
	
	@Override
	public void copy(DwCalpt omFrom,boolean isCopiarFK){
		this.atribuir(omFrom, (DwCalpt) this, isCopiarFK);
	}
	

	
	
}
