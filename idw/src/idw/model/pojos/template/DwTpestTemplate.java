package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.DwTpest;

public abstract class DwTpestTemplate extends AbstractTemplate<DwTpest> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdTpest";

	@Override
	public Long getId() {		
		return getInstanceT().getIdTpest();				
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTpest(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((DwTpest)this).getCdTpest();
	}

	@Override
	public String getFieldNameCd() {
		return DwTpestTemplate._FIELD_NAME_CD;
	}

	@Override
	protected DwTpest atribuir(DwTpest from, DwTpest to, boolean isCopiarFK) {
		if (to == null)
			to = new DwTpest();
		
		to.setIdTpest(from.getIdTpest());
		to.setCdTpest(from.getCdTpest());
		to.setRevisao(from.getRevisao());
		to.setDsTpest(from.getDsTpest());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setStAtivo(from.getStAtivo());
		
		if (isCopiarFK) {
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
		}
		
		return to;
	}

}
