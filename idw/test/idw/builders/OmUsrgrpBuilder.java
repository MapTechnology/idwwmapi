package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmUsrgrp;

import java.util.Date;


public class OmUsrgrpBuilder extends AbstractPojoPersistentBuilder<OmUsrgrp, DAOGenericoTest> {
	
	private String codigo = BuilderDefaults.CODIGO;
	private String descricao = BuilderDefaults.DESCRICAO;	
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	
	public OmUsrgrpBuilder withCodigo(String codigo){
		this.codigo = codigo;
		return this;
	}
	
	public OmUsrgrpBuilder withDescricao(String descricao){
		this.descricao = descricao;
		return this;
	}
	
	public OmUsrgrpBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmUsrgrpBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmUsrgrpBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmUsrgrpBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}

	
	@Override
	public OmUsrgrp build(){
		OmUsrgrp omUsrgrp = new OmUsrgrp();
		omUsrgrp.setCdUsrgrp(codigo);
		omUsrgrp.setDsUsrGrp(descricao);
		omUsrgrp.setDtStativo(dtStAtivo);
		omUsrgrp.setDtRevisao(dtRevisao);
		omUsrgrp.setStAtivo(stAtivo);
		omUsrgrp.setRevisao(revisao);
		return omUsrgrp;
	}
	
}
