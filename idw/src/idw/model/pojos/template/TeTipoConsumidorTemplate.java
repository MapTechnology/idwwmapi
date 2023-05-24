package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TeTipoConsumidor;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class TeTipoConsumidorTemplate extends AbstractTemplate<TeTipoConsumidor> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "CdTipoConsumidor";
	private static final int _MAX_LEN_CD_CONCESSIONARIA = 30;
	private static final int _MAX_LEN_DS_CONCESSIONARIA = 100;

	@Override
	public Long getId() {		
		return getInstanceT().getIdTipoConsumidor();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTipoConsumidor(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdTipoConsumidor, DsTipoConsumidor, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final TeTipoConsumidor teTipoConsumidorOther = (TeTipoConsumidor) o;
			final TeTipoConsumidor teTipoConsumidor = (TeTipoConsumidor) this;
			equals = (new EqualsBuilderIdw())
						.append(teTipoConsumidor.getCdTipoConsumidor(), teTipoConsumidorOther.getCdTipoConsumidor())
						.append(teTipoConsumidor.getDsTipoConsumidor(), teTipoConsumidorOther.getDsTipoConsumidor())
						.append(teTipoConsumidor.getStAtivo(), teTipoConsumidorOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTipoConsumidor, DsTipoConsumidor, StAtivo
	 */
	@Override
	public int hashCode(){

		TeTipoConsumidor teTipoConsumidor = (TeTipoConsumidor) this;

		return (new HashCodeBuilderIdw())
				.append(teTipoConsumidor.getCdTipoConsumidor())
				.append(teTipoConsumidor.getDsTipoConsumidor())
				.append(teTipoConsumidor.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((TeTipoConsumidor)this).getCdTipoConsumidor();
	}

	@Override
	public String getFieldNameCd() {
		return TeTipoConsumidorTemplate._FIELD_NAME_CD;
	}

	public void set(long idTipoConsumidor, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTipoConsumidor, Long revisao,
			String dsTipoConsumidor, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		TeTipoConsumidor teTipoConsumidor = (TeTipoConsumidor) this;

		teTipoConsumidor.setIdTipoConsumidor(idTipoConsumidor);
		teTipoConsumidor.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		teTipoConsumidor.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		teTipoConsumidor.setCdTipoConsumidor(cdTipoConsumidor);
		teTipoConsumidor.setRevisao(revisao);
		teTipoConsumidor.setDsTipoConsumidor(dsTipoConsumidor);
		teTipoConsumidor.setDtRevisao(dtRevisao);
		teTipoConsumidor.setStAtivo(stAtivo);
		teTipoConsumidor.setDtStativo(dtStativo);

	}

	@Override
	protected TeTipoConsumidor atribuir(TeTipoConsumidor itemGet, TeTipoConsumidor itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new TeTipoConsumidor();
		}

		itemSet.set(
				itemGet.getIdTipoConsumidor(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdTipoConsumidor(),
				itemGet.getRevisao(),
				itemGet.getDsTipoConsumidor(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;

	}

	public void limitarStrings(){
		TeTipoConsumidor teTipoConsumidor = (TeTipoConsumidor) this;
		teTipoConsumidor.setCdTipoConsumidor(StringUtils.left(teTipoConsumidor.getCdTipoConsumidor(), TeTipoConsumidorTemplate._MAX_LEN_CD_CONCESSIONARIA));
		teTipoConsumidor.setDsTipoConsumidor(StringUtils.left(teTipoConsumidor.getDsTipoConsumidor(), TeTipoConsumidorTemplate._MAX_LEN_DS_CONCESSIONARIA));
	}

}
