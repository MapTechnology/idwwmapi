package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class OmPtBuilder extends AbstractPojoPersistentBuilder<OmPt, DAOGenericoTest> {

	private String cdPt = BuilderDefaults.CODIGO;
	private String dsPt = BuilderDefaults.DESCRICAO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	private OmTppt omTppt = new OmTpptBuilder().build();
	private OmCc omCc = new OmCcBuilder().build();
	private Byte tpImpprog = BuilderDefaults.ST_ATIVO;
	
	public OmPtBuilder withCdPt(String cdPt){
		this.cdPt = cdPt;
		return this;
	}
	
	public OmPtBuilder withDsPt(String dsPt){
		this.dsPt = dsPt;
		return this;
	}
	
	public OmPtBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmPtBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmPtBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmPtBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmPtBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public OmPtBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public OmPtBuilder withOmTppt(OmTppt omTppt){
		this.omTppt = omTppt;
		return this;
	}
	
	public OmPtBuilder withOmCc(OmCc omCc){
		this.omCc = omCc;
		return this;
	}
	
	public OmPtBuilder withTpImpprog(Byte tpImpprog){
		this.tpImpprog = tpImpprog;
		return this;
	}
	
	@Override
	public OmPt build() {
		OmPt omPt = new OmPt();
		omPt.setCdPt(cdPt);
		omPt.setDsPt(dsPt);
		omPt.setDtStativo(dtStAtivo);
		omPt.setDtRevisao(dtRevisao);
		omPt.setStAtivo(stAtivo);
		omPt.setRevisao(revisao);
		omPt.setOmUsrByIdUsrstativo(omUsrStAtivo);
		omPt.setOmUsrByIdUsrrevisao(omUsrRevisao);
		omPt.setOmTppt(omTppt);
		omPt.setOmCc(omCc);
		omPt.setTpImpprog(tpImpprog);
		return omPt;
	}

}
