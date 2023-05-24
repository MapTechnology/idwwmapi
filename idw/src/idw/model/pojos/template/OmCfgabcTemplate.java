package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.IPojoMAP;
import idw.model.pojos.OmCfgabc;
import idw.model.pojos.OmCfgabclim;
import idw.util.CloneUtil;

public abstract class OmCfgabcTemplate extends AbstractTemplate<OmCfgabc> implements IPojoMAP{
	
	public static final String _FIELD_NAME_CD = "cdCfgabc";

	@Override
	protected OmCfgabc atribuir(OmCfgabc from, OmCfgabc to, boolean isCopiarFK) {
		if (to == null) {
			to = new OmCfgabc();
		}
		
		to.setCdCfgabc(from.getCdCfgabc());
		to.setDsCfgabc(from.getDsCfgabc());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIdCfgabc(from.getIdCfgabc());
		to.setObs(from.getObs());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		
		if (isCopiarFK) {
			
			to.setOmUsrByIdUsrstativo(CloneUtil.clone(from.getOmUsrByIdUsrstativo(),false));
			to.setOmUsrByIdUsrrevisao(CloneUtil.clone(from.getOmUsrByIdUsrrevisao(),false));
			
			if (from.getOmCfgabclims() != null) {
				to.setOmCfgabclims(new HashSet<OmCfgabclim>());
				for (OmCfgabclim lim : from.getOmCfgabclims()) {
					OmCfgabclim clone = lim.clone();
					to.getOmCfgabclims().add(clone);
				}
			}
		}
		return to;
	}

	@Override
	public Long getId() {
		return getInstanceT().getIdCfgabc();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdCfgabc(id);
	}

	@Override
	public String getCd() {
		return ((OmCfgabc)this).getCdCfgabc();
	}

	@Override
	public String getFieldNameCd() {
		return OmCfgabcTemplate._FIELD_NAME_CD;
	}

}
