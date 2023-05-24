package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class DwTRefugoTemplate extends AbstractTemplate<DwTRefugo> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "CdTrefugo";
	private static final int _MAX_LEN_CD_TREFUGO = 30;
	private static final int _MAX_LEN_DS_TREFUGO = 40;


	@Override
	public Long getId() {		
		return getInstanceT().getIdTrefugo();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTrefugo(id == null ? null : id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdTrefugo, DsTrefugo, OmTppt, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTRefugo dwTRefugoOther = (DwTRefugo) o;
			final DwTRefugo dwTRefugo = (DwTRefugo) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTRefugo.getCdTrefugo(), dwTRefugoOther.getCdTrefugo())
						.append(dwTRefugo.getDsTrefugo(), dwTRefugoOther.getDsTrefugo())
						.append(dwTRefugo.getOmTppt(), dwTRefugoOther.getOmTppt())
						.append(dwTRefugo.getDwTArea(), dwTRefugoOther.getDwTArea())
						.append(dwTRefugo.getStAtivo(), dwTRefugoOther.getStAtivo())
						.append(dwTRefugo.getIsRequerCausa(), dwTRefugoOther.getIsRequerCausa())
						.append(dwTRefugo.getIsRequerAcao(), dwTRefugoOther.getIsRequerAcao())
						.append(dwTRefugo.getIsAutomatico(), dwTRefugoOther.getIsAutomatico())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTrefugo, DsTrefugo, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		DwTRefugo dwTRefugo = (DwTRefugo) this;

		return (new HashCodeBuilderIdw())
				.append(dwTRefugo.getCdTrefugo())
				.append(dwTRefugo.getDsTrefugo())
				.append(dwTRefugo.getOmTppt())
				.append(dwTRefugo.getStAtivo())
				.append(dwTRefugo.getIsRequerCausa())
				.append(dwTRefugo.getIsRequerAcao())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((DwTRefugo)this).getCdTrefugo();
	}

	@Override
	public String getFieldNameCd() {
		return DwTRefugoTemplate._FIELD_NAME_CD;
	}

	public void set(Long idTrefugo, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			DwTArea dwTArea, OmUsr omUsrByIdUsrrevisao, String cdTrefugo, Long revisao,
			String dsTrefugo, Date dtRevisao, Byte stAtivo, Date dtStativo,
			Boolean isRequerCausa, Boolean isRequerAcao, Boolean isAutomatico) {

		DwTRefugo dwTRefugo = (DwTRefugo) this;

		dwTRefugo.setIdTrefugo(idTrefugo);
		dwTRefugo.setOmTppt(omTppt);
		dwTRefugo.setDwTArea(dwTArea);
		dwTRefugo.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTRefugo.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTRefugo.setCdTrefugo(cdTrefugo);
		dwTRefugo.setRevisao(revisao);
		dwTRefugo.setDsTrefugo(dsTrefugo);
		dwTRefugo.setDtRevisao(dtRevisao);
		dwTRefugo.setStAtivo(stAtivo);
		dwTRefugo.setDtStativo(dtStativo);
		dwTRefugo.setIsRequerCausa(isRequerCausa);
		dwTRefugo.setIsRequerAcao(isRequerAcao);
		dwTRefugo.setIsAutomatico(isAutomatico);
	}

	@Override
	protected DwTRefugo atribuir(DwTRefugo itemGet, DwTRefugo itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTRefugo();
		}

		itemSet.set(
				itemGet.getIdTrefugo(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getDwTArea(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdTrefugo(),
				itemGet.getRevisao(),
				itemGet.getDsTrefugo(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo(),
				itemGet.getIsRequerCausa(),
				itemGet.getIsRequerAcao(),
				itemGet.getIsAutomatico());

		return itemSet;

	}

	public void limitarStrings(){
		DwTRefugo dwTRefugo = (DwTRefugo) this;
		dwTRefugo.setCdTrefugo(StringUtils.left(dwTRefugo.getCdTrefugo(), DwTRefugoTemplate._MAX_LEN_CD_TREFUGO));
		dwTRefugo.setDsTrefugo(StringUtils.left(dwTRefugo.getDsTrefugo(), DwTRefugoTemplate._MAX_LEN_DS_TREFUGO));
	}

}
