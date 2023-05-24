package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class OmCargoTemplate extends AbstractTemplate<OmCargo> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "CdCargo";
	private static final int _MAX_LEN_CD_CARGO = 30;
	private static final int _MAX_LEN_DS_CARGO = 100;

	@Override
	public Long getId() {		
		return getInstanceT().getIdCargo();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdCargo(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdCargo, DsCargo, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmCargo dwTCargoOther = (OmCargo) o;
			final OmCargo dwTCargo = (OmCargo) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTCargo.getCdCargo(), dwTCargoOther.getCdCargo())
						.append(dwTCargo.getDsCargo(), dwTCargoOther.getDsCargo())
						.append(dwTCargo.getStAtivo(), dwTCargoOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdCargo, DsCargo, StAtivo
	 */
	@Override
	public int hashCode(){

		OmCargo dwTCargo = (OmCargo) this;

		return (new HashCodeBuilderIdw())
				.append(dwTCargo.getCdCargo())
				.append(dwTCargo.getDsCargo())
				.append(dwTCargo.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((OmCargo)this).getCdCargo();
	}

	@Override
	public String getFieldNameCd() {
		return OmCargoTemplate._FIELD_NAME_CD;
	}

	public void set(long idCargo, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdCargo, Long revisao,
			String dsCargo, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		OmCargo dwTCargo = (OmCargo) this;

		dwTCargo.setIdCargo(idCargo);
		dwTCargo.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTCargo.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTCargo.setCdCargo(cdCargo);
		dwTCargo.setRevisao(revisao);
		dwTCargo.setDsCargo(dsCargo);
		dwTCargo.setDtRevisao(dtRevisao);
		dwTCargo.setStAtivo(stAtivo);
		dwTCargo.setDtStativo(dtStativo);

	}

	@Override
	protected OmCargo atribuir(OmCargo itemGet, OmCargo itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new OmCargo();
		}

		itemSet.set(
				itemGet.getIdCargo(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdCargo(),
				itemGet.getRevisao(),
				itemGet.getDsCargo(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;

	}

	public void limitarStrings(){
		OmCargo omCargo = (OmCargo) this;
		omCargo.setCdCargo(StringUtils.left(omCargo.getCdCargo(), OmCargoTemplate._MAX_LEN_CD_CARGO));
		omCargo.setDsCargo(StringUtils.left(omCargo.getDsCargo(), OmCargoTemplate._MAX_LEN_DS_CARGO));
	}

}
