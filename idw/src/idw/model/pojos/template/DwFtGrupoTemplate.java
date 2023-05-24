package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.DwFtGrupo;


public abstract class DwFtGrupoTemplate extends AbstractTemplate<DwFtGrupo> implements IPojoMAP{
	public static final String _FIELD_NAME_CD = "cdFtgrupo";

	@Override
	public Long getId() {		
		return getInstanceT().getIdFtgrupo();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdFtgrupo(id);
	}		
	@Override
	public String getCd() {
		return ((DwFtGrupo)this).getCdFtgrupo();
	}

	@Override
	public String getFieldNameCd() {
		return DwFtGrupoTemplate._FIELD_NAME_CD;
	}

	@Override
	protected DwFtGrupo atribuir(DwFtGrupo from, DwFtGrupo to, boolean isCopiarFK) {
		if (to == null)
			to = new DwFtGrupo();
		
		to.setCdFtgrupo(from.getCdFtgrupo());
		to.setDsFtgrupo(from.getDsFtgrupo());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIdFtgrupo(from.getIdFtgrupo());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		
		return to;

	  }
}
