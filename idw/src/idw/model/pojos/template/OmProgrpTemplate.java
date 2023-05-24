package idw.model.pojos.template;

import java.util.Date;

import idw.model.IPojoMAP;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class OmProgrpTemplate extends AbstractTemplate<OmProgrp> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdProgrp";

	@Override
	public Long getId() {		
		return getInstanceT().getIdProgrp();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdProgrp(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((OmProgrp)this).getCdProgrp();
	}

	@Override
	public String getFieldNameCd() {
		return OmProgrpTemplate._FIELD_NAME_CD;
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmProgrp omProgrpOther = (OmProgrp) o;
			final OmProgrp omProgrp = (OmProgrp) this;
			equals = (new EqualsBuilderIdw())
						.append(omProgrp.getCdProgrp(), omProgrpOther.getCdProgrp())
						.append(omProgrp.getDsProgrp(), omProgrpOther.getDsProgrp())
						.append(omProgrp.getStAtivo(), omProgrpOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode(){

		OmProgrp omProgrp = (OmProgrp) this;

		return (new HashCodeBuilderIdw())
						.append(omProgrp.getCdProgrp())
						.append(omProgrp.getDsProgrp())
						.append(omProgrp.getStAtivo())
						.toHashCode();
	}

	@Override
	protected OmProgrp atribuir(OmProgrp from, OmProgrp to, boolean isCopiarFK) {
		if(to == null){
			to = new OmProgrp();
		}

		to.set(
				from.getIdProgrp(),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrstativo(),false): null),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrrevisao(),false): null),
				from.getCdProgrp(),
				from.getRevisao(),
				from.getDsProgrp(),
				from.getDtRevisao(),
				from.getStAtivo(),
				from.getDtStativo(),
				from.getIsArivarexportacaobc());

		return to;

	}

	public void set(long idProgrp, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdProgrp, Long revisao,
			String dsProgrp, Date dtRevisao, Byte stAtivo, Date dtStativo, Boolean isAtivarexportacaobc){

		OmProgrp omProgrp = (OmProgrp) this;
		omProgrp.setIdProgrp(idProgrp);
		omProgrp.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		omProgrp.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		omProgrp.setCdProgrp(cdProgrp);
		omProgrp.setDsProgrp(dsProgrp);
		omProgrp.setDtRevisao(dtRevisao);
		omProgrp.setDtStativo(dtStativo);
		omProgrp.setRevisao(revisao);
		omProgrp.setStAtivo(stAtivo);
		omProgrp.setIsArivarexportacaobc(isAtivarexportacaobc);

	}

}
