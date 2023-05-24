package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class OmCcBuilder extends AbstractPojoPersistentBuilder<OmCc, DAOGenericoTest> {
	
	private String cdCc = BuilderDefaults.CODIGO;
	private String dsCc = BuilderDefaults.DESCRICAO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	
	public OmCcBuilder withCdCc(String cdCc){
		this.cdCc = cdCc;
		return this;
	}
	
	public OmCcBuilder withDsCc(String dsCc){
		this.dsCc = dsCc;
		return this;
	}
	
	public OmCcBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmCcBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmCcBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmCcBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	public OmCcBuilder withOmUsrstativo(OmUsr omUsrstativo){
		this.omUsrStAtivo = omUsrstativo;
		return this;
	}

	public OmCcBuilder withOmUsrrevisao(OmUsr omUsrrevisao){
		this.omUsrRevisao = omUsrrevisao;
		return this;
	}
	
	@Override
	public OmCc build(){
		OmCc omCc = new OmCc();
		omCc.setCdCc(cdCc);
		omCc.setDsCc(dsCc);
		omCc.setDtRevisao(dtRevisao);
		omCc.setDtStativo(dtStAtivo);
		omCc.setStAtivo(stAtivo);
		omCc.setRevisao(revisao);
		omCc.setOmUsrByIdUsrrevisao(omUsrRevisao);
		omCc.setOmUsrByIdUsrstativo(omUsrStAtivo);
		return omCc;
	}

}
