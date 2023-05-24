package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmUsr;

public class OmAlimreaBuilder extends AbstractPojoPersistentBuilder<OmAlimrea, DAOGenericoTest>{

	private String cdLido = BuilderDefaults.CODIGO;
	private OmAlim omAlim = new OmAlimBuilder().build();
	private OmUsr omUsr = new OmUsrBuilder().build();
	private OmMapapa omMapapa = new OmMapapaBuilder().build();
	
	public OmAlimreaBuilder withCdLido(String cdLido){
		this.cdLido = cdLido;
		return this;
	}
	
	public OmAlimreaBuilder withOmAlim(OmAlim omAlim){
		this.omAlim = omAlim;
		return this;
	}
	
	public OmAlimreaBuilder withOmUsr(OmUsr omUsr){
		this.omUsr = omUsr;
		return this;
	}
	
	public OmAlimreaBuilder withOmMapapa(OmMapapa omMapapa){
		this.omMapapa = omMapapa;
		return this;
	}
	
	@Override
	public OmAlimrea build() {
		OmAlimrea omAlimrea = new OmAlimrea();
		omAlimrea.setCdLido(cdLido);
		omAlimrea.setOmAlim(omAlim);
		omAlimrea.setOmUsr(omUsr);
		omAlimrea.setOmMapapa(omMapapa);
		return omAlimrea;
	}

}