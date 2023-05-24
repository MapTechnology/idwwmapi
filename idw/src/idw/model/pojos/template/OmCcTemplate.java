package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.OmCc;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class OmCcTemplate extends AbstractTemplate<OmCc> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "CdUsr";

	@Override
	public Long getId() {		
		return getInstanceT().getIdCc();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdCc(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((OmCc) this).getCdCc();
	}

	@Override
	public String getFieldNameCd() {
		return OmCcTemplate._FIELD_NAME_CD;
	}

	/**
	 * Campos usados no equals: CdCc, DsCc, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmCc omCcOther = (OmCc) o;
			final OmCc omCc = (OmCc) this;
			equals = (new EqualsBuilderIdw())
						.append(omCc.getCdCc(), omCcOther.getCdCc())
						.append(omCc.getDsCc(), omCcOther.getDsCc())
						.append(omCc.getStAtivo(), omCcOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdCc, DsCc, StAtivo
	 *
	 */
	@Override
	public int hashCode(){

		OmCc omCc = (OmCc) this;

		return (new HashCodeBuilderIdw())
						.append(omCc.getCdCc())
						.append(omCc.getDsCc())
						.append(omCc.getStAtivo())
						.toHashCode();
	}

	@Override
	protected OmCc atribuir(OmCc itemGet, OmCc itemSet, boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new OmCc();
		}

		itemSet.setIdCc(itemGet.getIdCc());
		itemSet.setCdCc(itemGet.getCdCc());
		itemSet.setDsCc(itemGet.getDsCc());
		itemSet.setDtRevisao(itemGet.getDtRevisao());
		itemSet.setDtStativo(itemGet.getDtStativo());

		if (itemGet.getOmUsrByIdUsrrevisao() != null) {
			itemSet.setOmUsrByIdUsrrevisao(itemGet.getOmUsrByIdUsrrevisao().clone());
		}

		if (itemGet.getOmUsrByIdUsrstativo() != null) {
			itemSet.setOmUsrByIdUsrstativo(itemGet.getOmUsrByIdUsrstativo().clone());
		}

		itemSet.setRevisao(itemGet.getRevisao());
		itemSet.setStAtivo(itemGet.getStAtivo());

		return itemSet;
	}

}
