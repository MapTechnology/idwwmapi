package idw.model.pojos.template;

import java.util.Date;

import idw.model.IPojoMAP;
import idw.model.pojos.OmFor;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class OmForTemplate extends AbstractTemplate<OmFor> implements IPojoMAP {

	private static final String _FIELD_NAME_CD = "CdFor";

	@Override
	public Long getId() {		
		return getInstanceT().getIdFor();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdFor(id == null ? 0L: id.longValue());
	}	

	@Override
	public String getCd() {
		return ((OmFor)this).getCdFor();
	}

	@Override
	public String getFieldNameCd() {
		return OmForTemplate._FIELD_NAME_CD;
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmFor omForOther = (OmFor) o;
			final OmFor omFor = (OmFor) this;
			equals = (new EqualsBuilderIdw())
						.append(omFor.getCdFor(), omForOther.getCdFor())
						.append(omFor.getNmFornecedor(), omForOther.getNmFornecedor())
						.append(omFor.getStAtivo(), omForOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode(){
		OmFor omFor = (OmFor) this;
		return (new HashCodeBuilderIdw())
						.append(omFor.getCdFor())
						.append(omFor.getNmFornecedor())
						.append(omFor.getStAtivo())
				.toHashCode();
	}


	public void set(
			 Long idFor,
			 String cdFor,
			 String nmFornecedor,
			 Long revisao,
			 Date dtRevisao,
			 Byte stAtivo,
			 Date dtStativo,
			 OmUsr omUsrByIdUsrstativo,
			 OmUsr omUsrByIdUsrrevisao){

		OmFor omFor = (OmFor) this;

		omFor.setIdFor(idFor);
		omFor.setCdFor(cdFor);
		omFor.setNmFornecedor(nmFornecedor);
		omFor.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		omFor.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		omFor.setRevisao(revisao);
		omFor.setStAtivo(stAtivo);
		omFor.setDtRevisao(dtRevisao);
		omFor.setDtStativo(dtStativo);

	}

	@Override
	protected OmFor atribuir(OmFor from, OmFor to, boolean isCopiarFK) {

		if(to == null){
			to = new OmFor();
		}

		to.set(
				from.getIdFor(),
				from.getCdFor(),
				from.getNmFornecedor(),
				from.getRevisao(),
				from.getDtRevisao(),
				from.getStAtivo(),
				from.getDtStativo(),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrstativo(), false): null),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrrevisao(), false): null));

		return to;
	}

}
