package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.IPojoMAP;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmRegrasNscb;
import idw.model.pojos.OmRegrasTags;


public abstract class OmRegrasNscbTemplate extends AbstractTemplate<OmRegrasNscb> implements IPojoMAP{
	public static final String _FIELD_NAME_CD = "cdRegrasNscb";

	@Override
	public Long getId() {		
		return getInstanceT().getIdRegrasNscb();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdRegrasNscb(id);
	}	
	
	@Override
	public String getCd() {
		return ((OmRegrasNscb)this).getCdRegrasNscb();
	}

	@Override
	public String getFieldNameCd() {
		return OmRegrasNscbTemplate._FIELD_NAME_CD;
	}

	@Override
	protected OmRegrasNscb atribuir(OmRegrasNscb from, OmRegrasNscb to, boolean isCopiarFK) {
		
		if(to == null){
			to = new OmRegrasNscb();
		}
		
		to.setIdRegrasNscb(from.getIdRegrasNscb());
		to.setCdRegrasNscb(from.getCdRegrasNscb());
		to.setDsRegrasNscb(from.getDsRegrasNscb());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		
		if(from.getOmRegrasTagses() != null){
			to.setOmRegrasTagses(new HashSet<OmRegrasTags>());
			for(OmRegrasTags regrasTags : from.getOmRegrasTagses()){
				to.getOmRegrasTagses().add(regrasTags.clone(false));
			}
		}
				
		if(isCopiarFK) {
			
			if(from.getOmUsrByIdUsrrevisao() != null) {
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}
			
			if(from.getOmUsrByIdUsrstativo() != null) {
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}
			
//			if(from.getOmRegrasTagses() != null){
//				to.setOmRegrasTagses(new HashSet<OmRegrasTags>());
//				for(OmRegrasTags regrasTags : from.getOmRegrasTagses()){
//					to.getOmRegrasTagses().add(regrasTags.clone(true));
//				}
//			}
			
			if(from.getOmCfgsForIdRegrasCb() != null){
				to.setOmCfgsForIdRegrasCb(new HashSet<OmCfg>());
				for(OmCfg cfg: from.getOmCfgsForIdRegrasCb()){
					to.getOmCfgsForIdRegrasCb().add(cfg.clone(false));
				}
			}
			
			if(from.getOmCfgsForIdRegrasNs() != null){
				to.setOmCfgsForIdRegrasNs(new HashSet<OmCfg>());
				for(OmCfg cfg: from.getOmCfgsForIdRegrasNs()){
					to.getOmCfgsForIdRegrasNs().add(cfg.clone(false));
				}
			}
			
		}
		
		return to;
	}

}