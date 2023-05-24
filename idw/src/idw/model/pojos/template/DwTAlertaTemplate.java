package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class DwTAlertaTemplate extends AbstractTemplate<DwTAlerta> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "cdTalerta";
	private static final int _MAX_LEN_CD_TALERTA = 30;
	private static final int _MAX_LEN_DS_TALERTA = 40;

	@Override
	public Long getId() {		
		return getInstanceT().getIdTalerta();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTalerta(id == null ? 0L: id.longValue());
	}		
	
	/**
	 * Campos usados no equals: CdTalerta, DsTalerta, OmTppt, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTAlerta dwTAlertaOther = (DwTAlerta) o;
			final DwTAlerta dwTAlerta = (DwTAlerta) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTAlerta.getCdTalerta(), dwTAlertaOther.getCdTalerta())
						.append(dwTAlerta.getDsTalerta(), dwTAlertaOther.getDsTalerta())
						.append(dwTAlerta.getOmTppt(), dwTAlertaOther.getOmTppt())
						.append(dwTAlerta.getIsAutomatico(), dwTAlertaOther.getIsAutomatico())
						.append(dwTAlerta.getIsTimeout(), dwTAlertaOther.getIsTimeout())
						.append(dwTAlerta.getStAtivo(), dwTAlertaOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTalerta, DsTalerta, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		DwTAlerta dwTAlerta = (DwTAlerta) this;

		return (new HashCodeBuilderIdw())
				.append(dwTAlerta.getCdTalerta())
				.append(dwTAlerta.getDsTalerta())
				.append(dwTAlerta.getOmTppt())
				.append(dwTAlerta.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((DwTAlerta)this).getCdTalerta();
	}

	@Override
	public String getFieldNameCd() {
		return DwTAlertaTemplate._FIELD_NAME_CD;
	}

	public void set(long idTalerta, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTalerta, Long revisao,
			String dsTalerta, Date dtRevisao, Byte stAtivo, Date dtStativo, 
			Boolean isTimeout, Boolean isAutomatico) {

		DwTAlerta dwTAlerta = (DwTAlerta) this;

		dwTAlerta.setIdTalerta(idTalerta);
		dwTAlerta.setOmTppt(omTppt);
		dwTAlerta.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTAlerta.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTAlerta.setCdTalerta(cdTalerta);
		dwTAlerta.setRevisao(revisao);
		dwTAlerta.setDsTalerta(dsTalerta);
		dwTAlerta.setDtRevisao(dtRevisao);
		dwTAlerta.setStAtivo(stAtivo);
		dwTAlerta.setDtStativo(dtStativo);
		dwTAlerta.setIsTimeout(isTimeout);
		dwTAlerta.setIsAutomatico(isAutomatico);
	}

	@Override
	protected DwTAlerta atribuir(DwTAlerta itemGet, DwTAlerta itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTAlerta();
		}

		itemSet.set(
				itemGet.getIdTalerta(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdTalerta(),
				itemGet.getRevisao(),
				itemGet.getDsTalerta(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo(),
				itemGet.getIsTimeout(),
				itemGet.getIsAutomatico());

		return itemSet;

	}

	public void limitarStrings(){
		DwTAlerta dwTAlerta = (DwTAlerta) this;
		dwTAlerta.setCdTalerta(StringUtils.left(dwTAlerta.getCdTalerta(), DwTAlertaTemplate._MAX_LEN_CD_TALERTA));
		dwTAlerta.setDsTalerta(StringUtils.left(dwTAlerta.getDsTalerta(), DwTAlertaTemplate._MAX_LEN_DS_TALERTA));
	}
}
