package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class DwTAcaoTemplate extends AbstractTemplate<DwTAcao> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "CdTacao";
	private static final int _MAX_LEN_CD_TACAO = 30;
	private static final int _MAX_LEN_DS_TACAO = 40;

	@Override
	public Long getId() {		
		return getInstanceT().getIdTacao();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTacao(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdTacao, DsTacao, OmTppt, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTAcao dwTAcaoOther = (DwTAcao) o;
			final DwTAcao dwTAcao = (DwTAcao) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTAcao.getCdTacao(), dwTAcaoOther.getCdTacao())
						.append(dwTAcao.getDsTacao(), dwTAcaoOther.getDsTacao())
						.append(dwTAcao.getOmTppt(), dwTAcaoOther.getOmTppt())
						.append(dwTAcao.getStAtivo(), dwTAcaoOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTacao, DsTacao, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		DwTAcao dwTAcao = (DwTAcao) this;

		return (new HashCodeBuilderIdw())
				.append(dwTAcao.getCdTacao())
				.append(dwTAcao.getDsTacao())
				.append(dwTAcao.getOmTppt())
				.append(dwTAcao.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((DwTAcao)this).getCdTacao();
	}

	@Override
	public String getFieldNameCd() {
		return DwTAcaoTemplate._FIELD_NAME_CD;
	}

	public void set(long idTacao, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTacao, Long revisao,
			String dsTacao, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		DwTAcao dwTAcao = (DwTAcao) this;

		dwTAcao.setIdTacao(idTacao);
		dwTAcao.setOmTppt(omTppt);
		dwTAcao.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTAcao.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTAcao.setCdTacao(cdTacao);
		dwTAcao.setRevisao(revisao);
		dwTAcao.setDsTacao(dsTacao);
		dwTAcao.setDtRevisao(dtRevisao);
		dwTAcao.setStAtivo(stAtivo);
		dwTAcao.setDtStativo(dtStativo);

	}

	@Override
	protected DwTAcao atribuir(DwTAcao itemGet, DwTAcao itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTAcao();
		}

		itemSet.set(
				itemGet.getIdTacao(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdTacao(),
				itemGet.getRevisao(),
				itemGet.getDsTacao(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;

	}

	public void limitarStrings(){
		DwTAcao dwTAcao = (DwTAcao) this;
		dwTAcao.setCdTacao(StringUtils.left(dwTAcao.getCdTacao(), DwTAcaoTemplate._MAX_LEN_CD_TACAO));
		dwTAcao.setDsTacao(StringUtils.left(dwTAcao.getDsTacao(), DwTAcaoTemplate._MAX_LEN_DS_TACAO));
	}

}
