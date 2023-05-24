package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.IPojoMAP;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;

public abstract class DwEstTemplate extends AbstractTemplate<DwEst> implements IPojoMAP {
	private static final String _FIELD_NAME_CD = "CdEst";
	
	@Override
	public String getCd() {		
		return getInstanceT().getCdEst();
	}
	
	@Override
	public String getFieldNameCd() {		
		return _FIELD_NAME_CD;
	}
	
	@Override
	public Long getId() {
		return getInstanceT().getIdEst();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdEst(id);		
	}
	
	@Override
	protected DwEst atribuir(DwEst from, DwEst to, boolean isCopiarFK) {
		if (to == null) {
			to = new DwEst();
		}
		to.setIdEst(from.getIdEst());
		to.setCdEst(from.getCdEst());
		to.setDsEst(from.getDsEst());
		to.setDepara(from.getDepara());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());

		if (isCopiarFK == true) {
			if (from.getOmUsrByIdUsrrevisao() != null) {
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(
						false));
			}

			if (from.getOmUsrByIdUsrstativo() != null) {
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(
						false));
			}
			
			if (from.getDwTpest() != null)
				to.setDwTpest(from.getDwTpest().clone(false));

			to.setDwEstpros(new HashSet<DwEstpro>());
			for (DwEstpro estpro : from.getDwEstpros()) {
				to.getDwEstpros().add((DwEstpro) estpro.clone(false));
			}
		}

		return to;
	}
}
