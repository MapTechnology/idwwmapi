package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

import java.util.Date;

public class OmPrgBuilder  extends AbstractPojoPersistentBuilder<OmPrg, DAOGenericoTest> {
	
	private String cdPrg = BuilderDefaults.CODIGO;
	private String dsPrg = BuilderDefaults.DESCRICAO;
	private Long revisao = BuilderDefaults.REVISAO;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private OmPt omPt = new OmPtBuilder().build();
	private OmProduto omProduto = new OmProdutoBuilder().build();
	
	public OmPrgBuilder withCdPrg(String cdPrg){
		this.cdPrg = cdPrg;
		return this;
	}
	
	public OmPrgBuilder withDsPrg(String dsPrg){
		this.dsPrg = dsPrg;
		return this;
	}
	
	public OmPrgBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmPrgBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public OmPrgBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public OmPrgBuilder withStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public OmPrgBuilder withOmPt(OmPt omPt){
		this.omPt = omPt;
		return this;
	}
	
	public OmPrgBuilder withOmProduto(OmProduto omProduto){
		this.omProduto = omProduto;
		return this;
	}
		
	@Override
	public OmPrg build() {
		OmPrg omPrg = new OmPrg();
		omPrg.setCdPrg(cdPrg);
		omPrg.setDsPrg(dsPrg);
		omPrg.setRevisao(revisao);
		omPrg.setStAtivo(stAtivo);
		omPrg.setDtRevisao(dtRevisao);
		omPrg.setDtStativo(dtStAtivo);
		omPrg.setOmPt(omPt);
		omPrg.setOmProduto(omProduto);
		return omPrg;
	}
	
}
