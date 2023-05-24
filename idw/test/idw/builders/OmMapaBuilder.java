package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class OmMapaBuilder extends AbstractPojoPersistentBuilder<OmMapa, DAOGenericoTest> {
	
	private String cdMapa = BuilderDefaults.CODIGO;
	private String dsMapa = BuilderDefaults.DESCRICAO;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Long revisao = BuilderDefaults.REVISAO;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private OmPrg omPrg = new OmPrgBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmProduto omProduto = new OmProdutoBuilder().build();
	private OmPt omPt = new OmPtBuilder().build();
	
	public OmMapaBuilder withCdMapa(String cdMapa){
		this.cdMapa = cdMapa;
		return this;
	}
	
	public OmMapaBuilder withDsMapa(String dsMapa){
		this.dsMapa = dsMapa;
		return this;
	}
	
	public OmMapaBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmMapaBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmMapaBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmMapaBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmMapaBuilder withOmPrg(OmPrg omPrg){
		this.omPrg = omPrg;
		return this;
	}
	
	public OmMapaBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public OmMapaBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public OmMapaBuilder withOmProduto(OmProduto omProduto){
		this.omProduto = omProduto;
		return this;
	}
	
	public OmMapaBuilder withOmPt(OmPt omPt){
		this.omPt = omPt;
		return this;
	}
	
	@Override
	public OmMapa build() {
		OmMapa omMapa= new OmMapa();
		omMapa.setCdMapa(cdMapa);
		omMapa.setDsMapa(dsMapa);
		omMapa.setDtRevisao(dtRevisao);
		omMapa.setDtStativo(dtStAtivo);
		omMapa.setRevisao(revisao);
		omMapa.setStAtivo(stAtivo);
		omMapa.setOmUsrByIdUsrrevisao(omUsrRevisao);
		omMapa.setOmUsrByIdUsrstativo(omUsrStAtivo);
		omMapa.setOmProduto(omProduto);
		omMapa.setOmPt(omPt);
		omMapa.setOmPrg(omPrg);	
		return omMapa;
	}

}