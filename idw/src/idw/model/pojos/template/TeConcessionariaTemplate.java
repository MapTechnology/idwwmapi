package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TeConcessionaria;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class TeConcessionariaTemplate extends AbstractTemplate<TeConcessionaria> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "CdConcessionaria";
	private static final int _MAX_LEN_CD_CONCESSIONARIA = 30;
	private static final int _MAX_LEN_DS_CONCESSIONARIA = 100;

	@Override
	public Long getId() {		
		return getInstanceT().getIdConcessionaria();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdConcessionaria(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdConcessionaria, DsConcessionaria, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final TeConcessionaria teConcessionariaOther = (TeConcessionaria) o;
			final TeConcessionaria teConcessionaria = (TeConcessionaria) this;
			equals = (new EqualsBuilderIdw())
						.append(teConcessionaria.getCdConcessionaria(), teConcessionariaOther.getCdConcessionaria())
						.append(teConcessionaria.getDsConcessionaria(), teConcessionariaOther.getDsConcessionaria())
						.append(teConcessionaria.getStAtivo(), teConcessionariaOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdConcessionaria, DsConcessionaria, StAtivo
	 */
	@Override
	public int hashCode(){

		TeConcessionaria teConcessionaria = (TeConcessionaria) this;

		return (new HashCodeBuilderIdw())
				.append(teConcessionaria.getCdConcessionaria())
				.append(teConcessionaria.getDsConcessionaria())
				.append(teConcessionaria.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((TeConcessionaria)this).getCdConcessionaria();
	}

	@Override
	public String getFieldNameCd() {
		return TeConcessionariaTemplate._FIELD_NAME_CD;
	}

	public void set(long idConcessionaria, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdConcessionaria, Long revisao,
			String dsConcessionaria, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		TeConcessionaria teConcessionaria = (TeConcessionaria) this;

		teConcessionaria.setIdConcessionaria(idConcessionaria);
		teConcessionaria.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		teConcessionaria.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		teConcessionaria.setCdConcessionaria(cdConcessionaria);
		teConcessionaria.setRevisao(revisao);
		teConcessionaria.setDsConcessionaria(dsConcessionaria);
		teConcessionaria.setDtRevisao(dtRevisao);
		teConcessionaria.setStAtivo(stAtivo);
		teConcessionaria.setDtStativo(dtStativo);

	}

	@Override
	protected TeConcessionaria atribuir(TeConcessionaria itemGet, TeConcessionaria itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new TeConcessionaria();
		}

		itemSet.set(
				itemGet.getIdConcessionaria(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdConcessionaria(),
				itemGet.getRevisao(),
				itemGet.getDsConcessionaria(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;

	}

	public void limitarStrings(){
		TeConcessionaria teConcessionaria = (TeConcessionaria) this;
		teConcessionaria.setCdConcessionaria(StringUtils.left(teConcessionaria.getCdConcessionaria(), TeConcessionariaTemplate._MAX_LEN_CD_CONCESSIONARIA));
		teConcessionaria.setDsConcessionaria(StringUtils.left(teConcessionaria.getDsConcessionaria(), TeConcessionariaTemplate._MAX_LEN_DS_CONCESSIONARIA));
	}

}
