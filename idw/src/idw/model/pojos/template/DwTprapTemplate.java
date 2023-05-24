package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.DwTprap;
import idw.util.CloneUtil;

public abstract class DwTprapTemplate extends AbstractTemplate<DwTprap> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "CdFTprap";
	
	
	@Override
	public Long getId() {
		return getInstanceT().getIdTprap();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdTprap(id);
	}
	@Override
	public String getCd() {
		return ((DwTprap) this).getCdTprap();
	}

	@Override
	public String getFieldNameCd() {
		return QqFolhaInsRapTemplate._FIELD_NAME_CD;
	}


	@Override
	protected DwTprap atribuir(DwTprap from, DwTprap to, boolean isCopiarFK) {
		if (to == null) {
			to = new DwTprap();
		}
		
		to.setIdTprap(from.getIdTprap());
		to.setCdTprap(from.getCdTprap());
		to.setRevisao(from.getRevisao());
		to.setDsTprap(from.getDsTprap());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setStAtivo(from.getStAtivo());

		if (isCopiarFK) {
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(CloneUtil.clone(from.getOmUsrByIdUsrrevisao(), false) );
			else
				to.setOmUsrByIdUsrrevisao(null);
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(CloneUtil.clone(from.getOmUsrByIdUsrstativo(), false) );
			else
				to.setOmUsrByIdUsrstativo(null);
				
		}
		
		return to;
	}

}
