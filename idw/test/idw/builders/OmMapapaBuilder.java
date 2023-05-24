package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;

import java.math.BigDecimal;

public class OmMapapaBuilder extends AbstractPojoPersistentBuilder<OmMapapa, DAOGenericoTest> {

	private OmPa omPa = new OmPaBuilder().build();
	private OmProduto omProduto = new OmProdutoBuilder().build();
	private BigDecimal qtUsada = BuilderDefaults.QUANTIDADE;
	private OmMapa omMapa = new OmMapaBuilder().build();
	
	public OmMapapaBuilder withOmPa(OmPa omPa){
		this.omPa = omPa;
		return this;
	}
	
	public OmMapapaBuilder withOmProduto(OmProduto omProduto){
		this.omProduto = omProduto;
		return this;
	}
	
	public OmMapapaBuilder withQtUsada(BigDecimal qtUsada){
		this.qtUsada = qtUsada;
		return this;
	}
	
	public OmMapapaBuilder withOmMap(OmMapa omMapa){
		this.omMapa = omMapa;
		return this;
	}
	
	@Override
	public OmMapapa build(){
		OmMapapa omMapapa = new OmMapapa();
		omMapapa.setOmPa(omPa);
		omMapapa.setOmProduto(omProduto);
		omMapapa.setQtUsada(qtUsada);
		omMapapa.setOmMapa(omMapa);
		return omMapapa;
	}

}
