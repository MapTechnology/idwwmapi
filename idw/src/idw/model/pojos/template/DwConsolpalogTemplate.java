package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.DwConsolpalog;
import idw.model.rn.DataHoraRN;

public abstract class DwConsolpalogTemplate extends AbstractTemplate<DwConsolpalog> {

	public boolean isDtHrDentroParadaComRegulagem(Date dtHr){
		
		DwConsolpalog dwconsolpalog = (DwConsolpalog) this;
		
		if (dwconsolpalog != null && dwconsolpalog.getDwTParada() != null
				&& dwconsolpalog.getDwTParada().getIsRegulagem() != null && dwconsolpalog.getDwTParada().getIsRegulagem().equals(true)) {
			return isDtHrDentroParadaSemConsiderarIgualAoInicioOuFim(dtHr);		
		}

		return false;
		
	}
	
	public boolean isDtHrDentroParadaSemConsiderarIgualAoInicioOuFim(Date dtHr){
		DwConsolpalog dwconsolpalog = (DwConsolpalog) this;
		
		if(dwconsolpalog.getDthrIparada() != null
				&& DataHoraRN.compareTo(dwconsolpalog.getDthrIparada(), dtHr) < 0
				&& (dwconsolpalog.getDthrFparada() == null || DataHoraRN.compareTo(dwconsolpalog.getDthrFparada(), dtHr) > 0)){
			
			return true;
			
		}
		
		return false;
		
	}
	
	@Override
	protected DwConsolpalog atribuir(DwConsolpalog from, DwConsolpalog to,
			boolean isCopiarFK) {
		
		if(to == null){
			to = new DwConsolpalog();
		}
		
		to.setIdConsolpalog(from.getIdConsolpalog());
	
		to.setDthrIparada(from.getDthrIparada());		
		to.setMsDthriparada(from.getMsDthriparada());
		to.setDthrFparada(from.getDthrFparada());
		to.setMsDthrfparada(from.getMsDthrfparada());
		to.setDthrFparadaAb(from.getDthrFparadaAb());
		to.setMsDthrfparadaAb(from.getMsDthrfparadaAb());
		to.setSegAutoTempoparadaAb(from.getSegAutoTempoparadaAb());
		to.setSegAutoTempoparadaCp(from.getSegAutoTempoparadaCp());
		to.setSegManuTempoparadaCp(from.getSegManuTempoparadaCp());
		to.setSegAutoTempoparadaSp(from.getSegAutoTempoparadaSp());	
		to.setSegManuTempoparadaSp(from.getSegManuTempoparadaSp());
		to.setIsVarritmo(from.getIsVarritmo());
		to.setSegAutoCta(from.getSegAutoCta());
		to.setSegManuCta(from.getSegManuCta());

		if(isCopiarFK){
			if(from.getOmPt() != null){
				to.setOmPt(from.getOmPt().clone(false));
			}
			
			if(from.getDwTParada() != null){
				to.setDwTParada(from.getDwTParada().clone(false));
			}
			
			if(from.getDwTAcao() != null){
				to.setDwTAcao(from.getDwTAcao().clone(false));
			}
			
			if(from.getDwTCausa() != null){
				to.setDwTCausa(from.getDwTCausa().clone(false));
			}
			
			if(from.getDwTJust() != null){
				to.setDwTJust(from.getDwTJust().clone(false));
			}
			if (from.getPpCp() != null){
				to.setPpCp(from.getPpCp().clone(false));
			}
		}
		
		return to;
		
	}

	public boolean isAberta() {
		DwConsolpalog dwConsolpalog = (DwConsolpalog) this;
		return dwConsolpalog.getDthrFparada() == null; 
	}
}