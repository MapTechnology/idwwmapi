package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.PpIndisp;
import idw.model.pojos.PpIndispRappt;

public class PpIndispTemplate extends AbstractTemplate<PpIndisp>{

	public enum _StIndisp{
		CADASTRADO(0), 
		USARPLANEJAMENTO(1);
		
		private final int value;
		
		_StIndisp(int value){
			this.value = value;
		}
		
		public int getValue(){
			return this.value;
		}
	}

	@Override
	protected PpIndisp atribuir(PpIndisp from, PpIndisp to, boolean isCopiarFK) {

		if (to == null)
			to = new PpIndisp();
		
		to.setCdIndisp(from.getCdIndisp());
		to.setDsIndisp(from.getDsIndisp());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIdIndisp(from.getIdIndisp());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setStIndisp(from.getStIndisp());
		
		to.setPpIndispRappts(new HashSet<PpIndispRappt>());
		
		if (from.getPpIndispRappts() != null){
			for(PpIndispRappt indispRappt : from.getPpIndispRappts()){
				to.getPpIndispRappts().add(indispRappt.clone());
			}	
		}
		
		  
		
		if (isCopiarFK == true){
			to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone());
			to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone());			
		}
		
		return to;
	}

}
