package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.IPojoMAP;
import idw.model.pojos.OmGrnts;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;



public abstract class OmUsrgrpTemplate extends AbstractTemplate<OmUsrgrp> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdUsrgrp";

	@Override
	public Long getId() {		
		return getInstanceT().getIdUsrgrp();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdUsrgrp(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdUsrGrp, DsUsrGrp, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmUsrgrp dwTUsrGrpOther = (OmUsrgrp) o;
			final OmUsrgrp dwTUsrGrp = (OmUsrgrp) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTUsrGrp.getCdUsrgrp(), dwTUsrGrpOther.getCdUsrgrp())
						.append(dwTUsrGrp.getDsUsrGrp(), dwTUsrGrpOther.getDsUsrGrp())
						.append(dwTUsrGrp.getStAtivo(), dwTUsrGrpOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdUsrGrp, DsUsrGrp, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		OmUsrgrp dwTUsrGrp = (OmUsrgrp) this;

		return (new HashCodeBuilderIdw())
				.append(dwTUsrGrp.getCdUsrgrp())
				.append(dwTUsrGrp.getDsUsrGrp())
				.append(dwTUsrGrp.getStAtivo())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((OmUsrgrp) this).getCdUsrgrp();
	}

	@Override
	public String getFieldNameCd() {
		return OmUsrgrpTemplate._FIELD_NAME_CD;
	}


	@Override
	protected OmUsrgrp atribuir(OmUsrgrp from, OmUsrgrp to, boolean isCopiarFK) {

		if (to == null) {
			to = new OmUsrgrp();
		}

		to.setIdUsrgrp(from.getIdUsrgrp());
		to.setCdUsrgrp(from.getCdUsrgrp());
		to.setDsUsrGrp(from.getDsUsrGrp());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());

		if (isCopiarFK){
			if(from.getOmGrntses() != null ){
				to.setOmGrntses(new HashSet<OmGrnts>(0));
				for(OmGrnts omGrnts: from.getOmGrntses()){
					to.getOmGrntses().add(omGrnts.clone()); // eh necessario ser true para o login do desktop ter acesso aos direitos
				}
			}
			if(from.getOmUsrs() != null){
				to.setOmUsrs(new HashSet<OmUsr>(0));
				for(OmUsr omUsr: from.getOmUsrs()){
					to.getOmUsrs().add(omUsr.clone(false));
				}
			}

		}
		return to;
	}


	@Override
	public OmUsr getOmUsrByIdUsrrevisao() {
		return null;
	}

	@Override
	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
	}

	@Override
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
	}

	@Override
	public OmUsr getOmUsrByIdUsrstativo() {
		return null;
	}
}
