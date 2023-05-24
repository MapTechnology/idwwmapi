package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.MmTpos;

public abstract class MmTposTemplate extends AbstractTemplate<MmTpos> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdTpos";

	@Override
	public Long getId() {		
		return getInstanceT().getIdTpos();				
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTpos(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((MmTpos)this).getCdTpos();
	}

	@Override
	public String getFieldNameCd() {
		return MmTposTemplate._FIELD_NAME_CD;
	}

	
	@Override
	protected MmTpos atribuir(MmTpos from, MmTpos to, boolean isCopiarFK) {
		if (to == null)
			to = new MmTpos();
		
		to.setIdTpos(from.getIdTpos());
		to.setCdTpos(from.getCdTpos());
		to.setRevisao(from.getRevisao());
		to.setDsTpos(from.getDsTpos());
		to.setDtStativo(from.getDtStativo());
		to.setDtRevisao(from.getDtRevisao());
		to.setStAtivo(from.getStAtivo());
		
		if (isCopiarFK) {
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao());
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo());
		}
		
		return to;
	}

}
