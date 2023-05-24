package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTJust;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

/**
 *
 * @author milton
 *
 */
public abstract class DwTJustTemplate extends AbstractTemplate<DwTJust> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "CdTjust";
	private static final int _MAX_LEN_CD_TJUST = 30;
	private static final int _MAX_LEN_DS_TJUST = 40;

	@Override
	public Long getId() {		
		return getInstanceT().getIdTjust();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTjust(id == null ? null: id.longValue());
	}		
	
	/**
	 * Campos usados no equals: CdTjust, DsTjust, OmTppt, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTJust dwTJustOther = (DwTJust) o;
			final DwTJust dwTJust = (DwTJust) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTJust.getCdTjust(), dwTJustOther.getCdTjust())
						.append(dwTJust.getDsTjust(), dwTJustOther.getDsTjust())
						.append(dwTJust.getOmTppt(), dwTJustOther.getOmTppt())
						.append(dwTJust.getStAtivo(), dwTJustOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTjust, DsTjust, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		DwTJust dwTJust = (DwTJust) this;

		return (new HashCodeBuilderIdw())
				.append(dwTJust.getCdTjust())
				.append(dwTJust.getDsTjust())
				.append(dwTJust.getOmTppt())
				.append(dwTJust.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((DwTJust)this).getCdTjust();
	}

	@Override
	public String getFieldNameCd() {
		return DwTJustTemplate._FIELD_NAME_CD;
	}

	public void set(Long idTjust, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTjust, Long revisao,
			String dsTjust, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		DwTJust dwTJust = (DwTJust) this;

		dwTJust.setIdTjust(idTjust);
		dwTJust.setOmTppt(omTppt);
		dwTJust.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTJust.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTJust.setCdTjust(cdTjust);
		dwTJust.setRevisao(revisao);
		dwTJust.setDsTjust(dsTjust);
		dwTJust.setDtRevisao(dtRevisao);
		dwTJust.setStAtivo(stAtivo);
		dwTJust.setDtStativo(dtStativo);

	}

	@Override
	protected DwTJust atribuir(DwTJust itemGet, DwTJust itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTJust();
		}


		itemSet.set(
				itemGet.getIdTjust(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdTjust(),
				itemGet.getRevisao(),
				itemGet.getDsTjust(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;

	}

	public void limitarStrings(){
		DwTJust dwTJust = (DwTJust) this;
		dwTJust.setCdTjust(StringUtils.left(dwTJust.getCdTjust(), DwTJustTemplate._MAX_LEN_CD_TJUST));
		dwTJust.setDsTjust(StringUtils.left(dwTJust.getDsTjust(), DwTJustTemplate._MAX_LEN_DS_TJUST));
	}
}
