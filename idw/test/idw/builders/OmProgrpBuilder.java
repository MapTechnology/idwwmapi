package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class OmProgrpBuilder extends AbstractPojoPersistentBuilder<OmProgrp, DAOGenericoTest> {
	
	private String cdProgrp = BuilderDefaults.CODIGO;
	private String dsProgrp = BuilderDefaults.DESCRICAO;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	
	public OmProgrpBuilder withCdProgrp(String cdProgrp){
		this.cdProgrp = cdProgrp;
		return this;
	}
	
	public OmProgrpBuilder withDsProgrp(String dsProgrp){
		this.dsProgrp = dsProgrp;
		return this;
	}
	
	public OmProgrpBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmProgrpBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmProgrpBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public OmProgrpBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}

	@Override
	public OmProgrp build() {
		OmProgrp omProgrp = new OmProgrp();
		omProgrp.setCdProgrp(cdProgrp);
		omProgrp.setDsProgrp(dsProgrp);
		omProgrp.setDtRevisao(dtRevisao);
		omProgrp.setDtStativo(dtStAtivo);
		omProgrp.setOmUsrByIdUsrstativo(omUsrStAtivo);
		omProgrp.setOmUsrByIdUsrrevisao(omUsrRevisao);
		return omProgrp;
	}

}