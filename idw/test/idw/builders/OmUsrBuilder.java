package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;

import java.util.Date;


public class OmUsrBuilder extends AbstractPojoPersistentBuilder<OmUsr, DAOGenericoTest> {
	
	private String cdUsuario = BuilderDefaults.CODIGO;
	private String dsUsuario = BuilderDefaults.DESCRICAO;
	private String login = BuilderDefaults.CODIGO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().build();
	
	public OmUsrBuilder withCdUsuario(String cdUsuario){
		this.cdUsuario = cdUsuario;
		return this;
	}
	
	public OmUsrBuilder withDsUsuario(String dsUsuario){
		this.dsUsuario = dsUsuario;
		return this;
	}
	
	public OmUsrBuilder withLogin(String login){
		this.login = login;
		return this;
	}
	
	public OmUsrBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmUsrBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmUsrBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmUsrBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmUsrBuilder withOmUsrgrp(OmUsrgrp omUsrgrp){
		this.omUsrgrp = omUsrgrp;
		return this;
	}
	
	@Override
	public OmUsr build(){
		OmUsr omUsr = new OmUsr();
		omUsr.setDtRevisao(dtRevisao);
		omUsr.setDtStativo(dtStAtivo);
		omUsr.setCdUsr(cdUsuario);
		omUsr.setDsNome(dsUsuario);
		omUsr.setLogin(login);
		omUsr.setStAtivo(stAtivo);
		omUsr.setRevisao(revisao);
		omUsr.setOmUsrgrp(omUsrgrp);
		return omUsr;
	}

   
}