package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.OmUnidmedida;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class OmUnidmedidaTemplate extends AbstractTemplate<OmUnidmedida> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "cdUnidmedida";
	private static final int _MAX_LEN_CD_UNIDMEDIDA = 60;
	private static final int _MAX_LEN_DS_UNIDMEDIDA = 100;

	@Override
	public Long getId() {		
		return getInstanceT().getIdUnidmedida();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdUnidmedida(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdUnidmedida, DsUnidmedida, StAtivo
	 */
	@Override
	public boolean equals(Object o) {
		boolean equals = false;
		if ((o != null) && this.getClass().isAssignableFrom(o.getClass())) {
			final OmUnidmedida omUnidmedidaOther = (OmUnidmedida) o;
			final OmUnidmedida omUnidmedida = (OmUnidmedida) this;
			equals = (new EqualsBuilderIdw())
					.append(omUnidmedida.getCdUnidmedida(),	omUnidmedidaOther.getCdUnidmedida())
					.append(omUnidmedida.getDsUnidmedida(),	omUnidmedidaOther.getDsUnidmedida())
					.append(omUnidmedida.getStAtivo(), omUnidmedidaOther.getStAtivo()).isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdUnidmedida, DsUnidmedida, StAtivo
	 */
	@Override
	public int hashCode() {

		OmUnidmedida unidmedida = (OmUnidmedida) this;

		return (new HashCodeBuilderIdw()).append(unidmedida.getCdUnidmedida())
				.append(unidmedida.getDsUnidmedida())
				.append(unidmedida.getStAtivo()).toHashCode();
	}

	@Override
	public String getCd() {
		return ((OmUnidmedida) this).getCdUnidmedida();
	}

	@Override
	public String getFieldNameCd() {
		return OmUnidmedidaTemplate._FIELD_NAME_CD;
	}

	public void set(long idUnidmedida, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdUnidmedida, Long revisao,
			String dsUnidmedida, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		OmUnidmedida omUnidmedida = (OmUnidmedida) this;

		omUnidmedida.setIdUnidmedida(idUnidmedida);
		omUnidmedida.setIdUnidmedida(idUnidmedida);
		omUnidmedida.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		omUnidmedida.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		omUnidmedida.setCdUnidmedida(cdUnidmedida);
		omUnidmedida.setRevisao(revisao);
		omUnidmedida.setDsUnidmedida(dsUnidmedida);
		omUnidmedida.setDtRevisao(dtRevisao);
		omUnidmedida.setStAtivo(stAtivo);
		omUnidmedida.setDtStativo(dtStativo);

	}
	
	/**
	 * Atualiza c�digo, decri��o e situa��o da unidade de medida
	 * @param cdUnidmedida
	 * @param dsUnidmedida
	 * @param stAtivo
	 */
	public void set(String cdUnidmedida, String dsUnidmedida, Byte stAtivo){
		getInstanceT().setCdUnidmedida(cdUnidmedida);
		getInstanceT().setDsUnidmedida(dsUnidmedida);
		getInstanceT().setStAtivo(stAtivo);
	}
	
	@Override
	protected OmUnidmedida atribuir(OmUnidmedida itemGet, OmUnidmedida itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new OmUnidmedida();
		}

		itemSet.set(
				itemGet.getIdUnidmedida(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),	false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),	false) : null), 
				itemGet.getCdUnidmedida(), 
				itemGet.getRevisao(),
				itemGet.getDsUnidmedida(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(), 
				itemGet.getDtStativo());

		return itemSet;

	}
		
	
	public void limitarStrings() {
		OmUnidmedida omUnidmedida = (OmUnidmedida) this;
		omUnidmedida.setCdUnidmedida(StringUtils.left(omUnidmedida.getCdUnidmedida(),
				OmUnidmedidaTemplate._MAX_LEN_CD_UNIDMEDIDA));
		omUnidmedida.setDsUnidmedida(StringUtils.left(omUnidmedida.getDsUnidmedida(),
				OmUnidmedidaTemplate._MAX_LEN_DS_UNIDMEDIDA));
	}
	
}
