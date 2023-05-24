package idw.model.pojos.template;

import idw.model.pojos.DwLogvalroteiro;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public abstract class DwLogvalroteiroTemplate  extends AbstractTemplate<DwLogvalroteiro>{
	
	@Override
	protected DwLogvalroteiro atribuir(DwLogvalroteiro from, DwLogvalroteiro to, boolean isCopiarFK) {
		if(to == null){
			to = new DwLogvalroteiro();
		}
		
		to.setCb(from.getCb());
		to.setCdPtDef(from.getCdPtDef());
		to.setDthrLog(from.getDthrLog());
		
		if(isCopiarFK) {
			if(from.getDwNserie() != null){
				to.setDwNserie(from.getDwNserie().clone(false));
			}
			if(from.getDwTDefeito() != null){
				to.setDwTDefeito((DwTDefeito) from.getDwTDefeito().clone());
			}
			if(from.getDwTurno() != null){
				to.setDwTurno((DwTurno) from.getDwTurno().clone());
			}
			if(from.getOmProduto() != null){
				to.setOmProduto((OmProduto) from.getOmProduto().clone(false));
			}
			if(from.getOmPt() != null){
				to.setOmPt((OmPt) from.getOmPt().clone(false));
			}
			if(from.getPpCp() != null){
				to.setPpCp((PpCp) from.getPpCp().clone(false));
			}			
		}


		return to;
	}	

}
