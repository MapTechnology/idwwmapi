package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.PpIndispRappt;

public class PpIndispRapptTemplate extends AbstractTemplate<PpIndispRappt>{

	
	public enum _TpRecurso{
		_PT(BigDecimal.ZERO), 
		_RAP(BigDecimal.ONE);
		
		private final BigDecimal value;
		
		_TpRecurso(BigDecimal value){
			this.value = value;
		}
		
		public BigDecimal getValue(){
			return this.value;
		}
	}

	@Override
	protected PpIndispRappt atribuir(PpIndispRappt from, PpIndispRappt to,
			boolean isCopiarFK) {
		if (to == null)
			to = new PpIndispRappt();
		
		to.setDsIndispRappt(from.getDsIndispRappt());
		to.setDthrFinal(from.getDthrFinal());
		to.setDthrInicio(from.getDthrInicio());
		to.setIdIndispRappt(from.getIdIndispRappt());
		
		if (from.getDwRap() != null){
			to.setDwRap(from.getDwRap().clone(false));	
		}
		
		
		if (from.getOmPt() != null){
			to.setOmPt(from.getOmPt().clone(false));
		}
		
		
		/*if (from.getPpIndisp() != null){
			to.setPpIndisp(from.getPpIndisp().clone());	
		}*/
		
		to.setQtIndisp(from.getQtIndisp());
		to.setTpRecurso(from.getTpRecurso());
		
		
	
		
		if (isCopiarFK == true){
			if (from.getDwTParada() != null)
				to.setDwTParada(from.getDwTParada().clone(false));
		}		
		
		return to;
	}

}
