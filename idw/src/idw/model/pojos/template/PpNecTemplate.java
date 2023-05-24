package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.PpPlanec;

public class PpNecTemplate extends AbstractTemplate<PpNec>{

	@Override
	protected PpNec atribuir(PpNec from, PpNec to, boolean isCopiarFK) {
		if (to == null)
			to = new PpNec();

		to.setCdNec(from.getCdNec());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setHrLeadtime(from.getHrLeadtime());
		to.setIdNec(from.getIdNec());
		to.setNrDoc(from.getNrDoc());		

		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setTpNec(from.getTpNec());
		to.setUrlOrigem(from.getUrlOrigem()); 
		
		
		if (isCopiarFK == true){
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));	
			
			if (from.getOmProduto() != null) {
				to.setOmProduto((OmProduto)from.getOmProduto().clone(false));
			}
			
			if (from.getPpCliente() != null)
				to.setPpCliente(from.getPpCliente().clone(false));
			
			if (from.getOmPt() != null)
				to.setOmPt(from.getOmPt().clone(false));
		}
		
		if (from.getPpNeccrons() != null) { //PpNeccron
			to.setPpNeccrons(new HashSet<PpNeccron>());
			for(PpNeccron pp : from.getPpNeccrons()){
				to.getPpNeccrons().add(pp.clone());
			}
		}
		
		if (from.getPpPlanecs() != null) { //PpPlanec
			to.setPpPlanecs(new HashSet<PpPlanec>());
			for(PpPlanec pp : from.getPpPlanecs()){
				to.getPpPlanecs().add(pp.clone(false));
			}
		}	
		
		if (from.getPpCps() != null) { //PpCp
			to.setPpCps(new HashSet<PpCp>());
			for(PpCp pp : from.getPpCps()) {
				to.getPpCps().add(pp.clone(false));
			}
		}

		return to;
	}

}
