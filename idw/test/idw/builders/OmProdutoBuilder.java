package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class OmProdutoBuilder extends AbstractPojoPersistentBuilder<OmProduto, DAOGenericoTest> {

	private String cdProduto = BuilderDefaults.CODIGO;
	private String dsProduto = BuilderDefaults.DESCRICAO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	private OmProgrp omProgrp = new OmProgrpBuilder().build();
	private OmCc omCc = new OmCcBuilder().build();
	
	public OmProdutoBuilder withCdProduto(String cdProduto){
		this.cdProduto = cdProduto;
		return this;
	}
	
	public OmProdutoBuilder withDsProduto(String dsProduto){
		this.dsProduto = dsProduto;
		return this;
	}
	
	public OmProdutoBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmProdutoBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmProdutoBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmProdutoBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmProdutoBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public OmProdutoBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public OmProdutoBuilder withOmProgrp(OmProgrp omProgrp){
		this.omProgrp = omProgrp;
		return this;
	}
	
	public OmProdutoBuilder withOmCc(OmCc omCc){
		this.omCc = omCc;
		return this;
	}
	
	@Override
	public OmProduto build(){
		OmProduto omProduto = new OmProduto();
		omProduto.setCdProduto(cdProduto);
		omProduto.setDsProduto(dsProduto);
		omProduto.setDtStativo(dtStAtivo);
		omProduto.setDtRevisao(dtRevisao);
		omProduto.setStAtivo(stAtivo);
		omProduto.setRevisao(revisao);
		omProduto.setOmUsrByIdUsrstativo(omUsrStAtivo);
		omProduto.setOmUsrByIdUsrrevisao(omUsrRevisao);
		omProduto.setOmProgrp(omProgrp);
		omProduto.setOmCc(omCc);
		return omProduto;
	}
	
}