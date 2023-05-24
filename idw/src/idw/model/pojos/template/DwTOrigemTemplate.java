package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTOrigem;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class DwTOrigemTemplate extends AbstractTemplate<DwTOrigem> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "CdOrigem";
	private static final int _MAX_LEN_CD_ORIGEM = 30;
	private static final int _MAX_LEN_DS_ORIGEM = 40;

	@Override
	public Long getId() {		
		return getInstanceT().getIdOrigem();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdOrigem(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdOrigem, DsOrigem, OmTppt, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTOrigem dwTOrigemOther = (DwTOrigem) o;
			final DwTOrigem dwTOrigem = (DwTOrigem) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTOrigem.getCdOrigem(), dwTOrigemOther.getCdOrigem())
						.append(dwTOrigem.getDsOrigem(), dwTOrigemOther.getDsOrigem())
						.append(dwTOrigem.getOmTppt(), dwTOrigemOther.getOmTppt())
						.append(dwTOrigem.getStAtivo(), dwTOrigemOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdOrigem, DsOrigem, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		DwTOrigem dwTOrigem = (DwTOrigem) this;

		return (new HashCodeBuilderIdw())
				.append(dwTOrigem.getCdOrigem())
				.append(dwTOrigem.getDsOrigem())
				.append(dwTOrigem.getOmTppt())
				.append(dwTOrigem.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((DwTOrigem)this).getCdOrigem();
	}

	@Override
	public String getFieldNameCd() {
		return DwTOrigemTemplate._FIELD_NAME_CD;
	}

	public void set(long idOrigem, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdOrigem, Long revisao,
			String dsOrigem, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		DwTOrigem dwTOrigem = (DwTOrigem) this;

		dwTOrigem.setIdOrigem(idOrigem);
		dwTOrigem.setOmTppt(omTppt);
		dwTOrigem.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTOrigem.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTOrigem.setCdOrigem(cdOrigem);
		dwTOrigem.setRevisao(revisao);
		dwTOrigem.setDsOrigem(dsOrigem);
		dwTOrigem.setDtRevisao(dtRevisao);
		dwTOrigem.setStAtivo(stAtivo);
		dwTOrigem.setDtStativo(dtStativo);

	}

	@Override
	protected DwTOrigem atribuir(DwTOrigem itemGet, DwTOrigem itemSet, boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTOrigem();
		}

		itemSet.set(
				itemGet.getIdOrigem(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdOrigem(),
				itemGet.getRevisao(),
				itemGet.getDsOrigem(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;

	}

	public void limitarStrings(){
		DwTOrigem dwTOrigem = (DwTOrigem) this;
		dwTOrigem.setCdOrigem(StringUtils.left(dwTOrigem.getCdOrigem(), DwTOrigemTemplate._MAX_LEN_CD_ORIGEM));
		dwTOrigem.setDsOrigem(StringUtils.left(dwTOrigem.getDsOrigem(), DwTOrigemTemplate._MAX_LEN_DS_ORIGEM));
	}

}
