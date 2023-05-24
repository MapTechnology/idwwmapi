package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.IPojoMAP;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalavu;
import idw.model.pojos.DwCalpt;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.OmUsr;


public abstract class DwCalTemplate extends AbstractTemplate<DwCal> implements IPojoMAP{
	
	@Override
	public String getCd() {
		return ((DwCal)this).getCdCal();
	}
	
	@Override
	public String getFieldNameCd() {
		return "CdCal";
	}
	
	@Override
	public Long getId() {
		return ((DwCal)this).getIdCal();
	}
	
	@Override
	public void setId(Long id) {
		((DwCal)this).setIdCal(id == null ? 0L: id.longValue());
	}
	
	@Override
	protected DwCal atribuir(DwCal from, DwCal to, boolean isCopiarFK) {
		if(to == null){
			to = new DwCal();
		}

		to.setIdCal(from.getIdCal());
		to.setCdCal(from.getCdCal());
		to.setDsCal(from.getDsCal());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDthrFvalidade(from.getDthrFvalidade());
		to.setDthrIvalidade(from.getDthrIvalidade());		
		
		
		if (isCopiarFK) {
			to.setDwCalpts(new HashSet<DwCalpt>());
			
			for (DwCalpt calpt : from.getDwCalpts()){
				to.getDwCalpts().add((DwCalpt) calpt.clone(false));
			}
			to.setDwCalavus(new HashSet<DwCalavu>());
			for (DwCalavu calavu : from.getDwCalavus()){
				to.getDwCalavus().add((DwCalavu) calavu.clone());
			}
			
			to.setDwCalsems(new HashSet<DwCalsem>());
			for (DwCalsem calsem : from.getDwCalsems()){
				to.getDwCalsems().add((DwCalsem) calsem.clone(false));
			}
			
			OmUsr omUsrRev = new OmUsr();
			try {
				omUsrRev.setCdUsr(from.getOmUsrByIdUsrrevisao().getCdUsr());
				omUsrRev.setDsNome(from.getOmUsrByIdUsrrevisao().getDsNome());
			} catch (Exception e) {
				
			}		
			to.setOmUsrByIdUsrrevisao(omUsrRev);
	
			OmUsr omUsrSt = new OmUsr();
			try {
				omUsrSt.setCdUsr(from.getOmUsrByIdUsrstativo().getCdUsr());
				omUsrSt.setDsNome(from.getOmUsrByIdUsrstativo().getDsNome());
			} catch (Exception e) {
				
			}		
			to.setOmUsrByIdUsrstativo(omUsrSt);		
		}
		
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		
		return to;

	  }
	
	public void copy(DwCal omFrom,boolean copiarFK){
		DwCal omTo = (DwCal) this;
		omTo.setIdCal(omFrom.getIdCal());
		omTo.setCdCal(omFrom.getCdCal());
		omTo.setDsCal(omFrom.getDsCal());
		omTo.setDtRevisao(omFrom.getDtRevisao());
		omTo.setDtStativo(omFrom.getDtStativo());
		omTo.setRevisao(omFrom.getRevisao());
		omTo.setStAtivo(omFrom.getStAtivo().byteValue());
		
		omTo.setDthrFvalidade(omFrom.getDthrFvalidade());
		omTo.setDthrIvalidade(omFrom.getDthrIvalidade());
		
		if (copiarFK){
			omTo.setOmUsrByIdUsrrevisao(omFrom.getOmUsrByIdUsrrevisao());			
			omTo.setOmUsrByIdUsrstativo(omFrom.getOmUsrByIdUsrstativo());
		}
		
	}
}
