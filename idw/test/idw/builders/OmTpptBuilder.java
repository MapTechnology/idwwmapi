package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class OmTpptBuilder extends AbstractPojoPersistentBuilder<OmTppt, DAOGenericoTest>{
	
	private String cdTppt = BuilderDefaults.CODIGO;
	private String dsTppt = BuilderDefaults.DESCRICAO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao =  new OmUsrBuilder().build();
	private OmAlgocor omAlgocor = new OmAlgocorBuilder().build();
	
	public OmTpptBuilder withCdTppt(String cdTppt){
		this.cdTppt = cdTppt;
		return this;
	}
	
	public OmTpptBuilder withDsTppt(String dsTppt){
		this.dsTppt = dsTppt;
		return this;
	}
	
	public OmTpptBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmTpptBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmTpptBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmTpptBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmTpptBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public OmTpptBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public OmTpptBuilder withOmAlgocor(OmAlgocor omAlgocor){
		this.omAlgocor = omAlgocor;
		return this;
	}
	
	@Override
	public OmTppt build() {
		OmTppt omTppt = new OmTppt();
		omTppt.setCdTppt(cdTppt);
		omTppt.setDsTppt(dsTppt);
		omTppt.setDtStativo(dtStAtivo);
		omTppt.setDtRevisao(dtRevisao);
		omTppt.setStAtivo(stAtivo);
		omTppt.setRevisao(revisao);
		omTppt.setOmUsrByIdUsrstativo(omUsrStAtivo);
		omTppt.setOmUsrByIdUsrrevisao(omUsrRevisao);
		omTppt.setOmAlgocor(omAlgocor);
		return omTppt;
	}

}
