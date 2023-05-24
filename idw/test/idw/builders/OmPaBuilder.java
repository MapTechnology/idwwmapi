package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class OmPaBuilder extends AbstractPojoPersistentBuilder<OmPa, DAOGenericoTest> {

	private String cdPa = BuilderDefaults.CODIGO;
	private String dsPa = BuilderDefaults.DESCRICAO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	private OmPt omPt = new OmPtBuilder().build();
	
	public OmPaBuilder withCdPa(String cdPa){
		this.cdPa = cdPa;
		return this;
	}
	
	public OmPaBuilder withDsPa(String dsPa){
		this.dsPa = dsPa;
		return this;
	}
	
	public OmPaBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmPaBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmPaBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmPaBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmPaBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public OmPaBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public OmPaBuilder withOmPt(OmPt omPt){
		this.omPt = omPt;
		return this;
	}
	
	@Override
	public OmPa build(){
		OmPa omPa = new OmPa();
		omPa.setCdPa(cdPa);
		omPa.setDsPa(dsPa);
		omPa.setDtRevisao(dtRevisao);
		omPa.setDtStativo(dtStAtivo);
		omPa.setStAtivo(stAtivo);
		omPa.setRevisao(revisao);
		omPa.setOmUsrByIdUsrstativo(omUsrStAtivo);
		omPa.setOmUsrByIdUsrrevisao(omUsrRevisao);
		omPa.setOmPt(omPt);
		return omPa;
	}
	
}
