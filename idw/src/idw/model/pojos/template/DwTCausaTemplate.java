package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class DwTCausaTemplate extends AbstractTemplate<DwTCausa> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "CdTcausa";
	private static final int _MAX_LEN_CD_TCAUSA = 30;
	private static final int _MAX_LEN_DS_TCAUSA = 40;

	@Override
	public Long getId() {		
		return getInstanceT().getIdTcausa();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTcausa(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdTcausa, DsTcausa, OmTppt, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTCausa dwTCausaOther = (DwTCausa) o;
			final DwTCausa dwTCausa = (DwTCausa) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTCausa.getCdTcausa(), dwTCausaOther.getCdTcausa())
						.append(dwTCausa.getDsTcausa(), dwTCausaOther.getDsTcausa())
						.append(dwTCausa.getOmTppt(), dwTCausaOther.getOmTppt())
						.append(dwTCausa.getStAtivo(), dwTCausaOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTcausa, DsTcausa, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		DwTCausa dwTCausa = (DwTCausa) this;

		return (new HashCodeBuilderIdw())
				.append(dwTCausa.getCdTcausa())
				.append(dwTCausa.getDsTcausa())
				.append(dwTCausa.getOmTppt())
				.append(dwTCausa.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((DwTCausa)this).getCdTcausa();
	}

	@Override
	public String getFieldNameCd() {
		return DwTCausaTemplate._FIELD_NAME_CD;
	}

	public void set(long idTcausa, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTcausa, Long revisao,
			String dsTcausa, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		DwTCausa dwTCausa = (DwTCausa) this;

		dwTCausa.setIdTcausa(idTcausa);
		dwTCausa.setOmTppt(omTppt);
		dwTCausa.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTCausa.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTCausa.setCdTcausa(cdTcausa);
		dwTCausa.setRevisao(revisao);
		dwTCausa.setDsTcausa(dsTcausa);
		dwTCausa.setDtRevisao(dtRevisao);
		dwTCausa.setStAtivo(stAtivo);
		dwTCausa.setDtStativo(dtStativo);

	}

	@Override
	protected DwTCausa atribuir(DwTCausa itemGet, DwTCausa itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTCausa();
		}

		itemSet.set(
				itemGet.getIdTcausa(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdTcausa(),
				itemGet.getRevisao(),
				itemGet.getDsTcausa(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;

	}

	public void limitarStrings(){
		DwTCausa dwTCausa = (DwTCausa) this;
		dwTCausa.setCdTcausa(StringUtils.left(dwTCausa.getCdTcausa(), DwTCausaTemplate._MAX_LEN_CD_TCAUSA));
		dwTCausa.setDsTcausa(StringUtils.left(dwTCausa.getDsTcausa(), DwTCausaTemplate._MAX_LEN_DS_TCAUSA));
	}

}

