package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPapro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

import java.math.BigDecimal;

public class OmPaproBuilder extends AbstractPojoPersistentBuilder<OmPapro, DAOGenericoTest>{

	private OmPa omPa = new OmPaBuilder().build();
	private OmProduto omProduto = new OmProdutoBuilder().build();
	private OmMapapa omMapapa = new OmMapapaBuilder().build();
	private OmPt omPt = new OmPtBuilder().build();
	private BigDecimal qtAtual = BuilderDefaults.QUANTIDADE;

	public OmPaproBuilder withOmPa(OmPa omPa){
		this.omPa = omPa;
		return this;
	}
	
	public OmPaproBuilder withOmProduto(OmProduto omProduto){
		this.omProduto = omProduto;
		return this;
	}
	
	public OmPaproBuilder withOmMapapa(OmMapapa omMapapa){
		this.omMapapa = omMapapa;
		return this;
	}
	
	public OmPaproBuilder withOmPt(OmPt omPt){
		this.omPt = omPt;
		return this;
	}
	
	public OmPaproBuilder withQtAtual(BigDecimal qtAtual){
		this.qtAtual = qtAtual;
		return this;
	}
	
	@Override
	public OmPapro build() {
		OmPapro omPapro = new OmPapro();
		omPapro.setOmPa(omPa);
		omPapro.setOmProduto(omProduto);
		omPapro.setOmMapapa(omMapapa);
		omPapro.setOmPt(omPt);
		omPapro.setQtAtual(qtAtual);
		return omPapro;
	}

}