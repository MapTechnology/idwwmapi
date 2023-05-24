package idw.model.pojos.template;

import java.util.Date;
import java.util.HashSet;

import org.hibernate.LazyInitializationException;
import org.hibernate.SessionException;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProturno;


public abstract class DwTurnoTemplate  extends AbstractTemplate<DwTurno>{
	
	@Override
	protected DwTurno atribuir(DwTurno from, DwTurno to, boolean isCopiarFK) {
		if(to == null){
			to = new DwTurno();
		}
		
		to.setIdTurno(from.getIdTurno());
		to.setCdTurno(from.getCdTurno());
		to.setDsTurno(from.getDsTurno());
		to.setIsImprodutivo(from.getIsImprodutivo());
		
		
		if(from.getDtRevisao() != null){
			to.setDtRevisao((Date)from.getDtRevisao().clone());
		}
		if(from.getDtStativo() != null){
			to.setDtStativo((Date)from.getDtStativo().clone());
		}
		
		to.setCor(from.getCor());		
		
		if(isCopiarFK) {
			if(from.getOmUsrByIdUsrrevisao() != null){
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}
			if(from.getOmUsrByIdUsrstativo() != null){
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}
			if(from.getOmProturnos() != null) {
				try {
					to.setOmProturnos(new HashSet<OmProturno>());
					
					for (OmProturno proturno:from.getOmProturnos()){
						to.getOmProturnos().add((OmProturno) proturno.clone());
					}
				}catch(SessionException e) {
					to.setOmProturnos(null);
				}catch(LazyInitializationException e) {
					to.setOmProturnos(null);
				}
			}
		}
		
		if(from.getRevisao() != null){
			to.setRevisao(from.getRevisao().longValue());
		}
		if(from.getStAtivo() != null){
			to.setStAtivo(from.getStAtivo().byteValue());
		}
		
		return to;
	}
	
	public Object cloneParaAlim() {
		DwTurno dwTurno = (DwTurno) this;
		DwTurno clone = new DwTurno();
		
		clone.setIdTurno(dwTurno.getIdTurno());
		clone.setDsTurno(dwTurno.getDsTurno());	
		
		return clone;
	}
	
}
