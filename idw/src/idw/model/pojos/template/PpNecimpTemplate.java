package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.PpNecimp;
import idw.model.pojos.PpNecimpurl;

public class PpNecimpTemplate  extends AbstractTemplate<PpNecimp> {

	@Override
	protected PpNecimp atribuir(PpNecimp from, PpNecimp to, boolean isCopiarFK) {
		if (to == null)
			to = new PpNecimp();
		
		to.setIdNecimp(from.getIdNecimp());
		to.setCdNecimp(from.getCdNecimp());
		to.setDsNecimp(from.getDsNecimp());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setTpNecimp(from.getTpNecimp());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());

		if (isCopiarFK == true){
			to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone());
			to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone());
		}
		
		if (from.getPpNecimpurls() != null){
			to.setPpNecimpurls(new HashSet<PpNecimpurl>());
			for (PpNecimpurl url : from.getPpNecimpurls()){
				to.getPpNecimpurls().add(url.clone());
			}
		}
		return to;
	}

}
