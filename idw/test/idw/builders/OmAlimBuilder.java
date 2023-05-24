package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;

import java.util.HashSet;
import java.util.Set;

public class OmAlimBuilder extends AbstractPojoPersistentBuilder<OmAlim, DAOGenericoTest>{
	
	private String cdAlim = BuilderDefaults.CODIGO;
	private String dsAlim = BuilderDefaults.DESCRICAO;
	private Byte stAlim = BuilderDefaults.ST_ATIVO;
	private Byte tpAlim = BuilderDefaults.ST_ATIVO;
	private OmMapa omMapa = new OmMapaBuilder().build();
	private OmUsr omUsr = new OmUsrBuilder().build();
	private Set<OmPt> omPts = new HashSet<OmPt>();
	
	public OmAlimBuilder withCdAlim(String cdAlim){
		this.cdAlim = cdAlim;
		return this;
	}
	
	public OmAlimBuilder withDsAlim(String dsAlim){
		this.dsAlim = dsAlim;
		return this;
	}
	
	public OmAlimBuilder withStAlim(Byte stAlim){
		this.stAlim = stAlim;
		return this;
	}
	
	public OmAlimBuilder withTpAlim(Byte tpAlim){
		this.tpAlim = tpAlim;
		return this;
	}
	
	public OmAlimBuilder withOmMapa(OmMapa omMapa){
		this.omMapa = omMapa;
		return this;
	}
	
	public OmAlimBuilder withOmUsr(OmUsr omUsr){
		this.omUsr = omUsr;
		return this;
	}
	
	public OmAlimBuilder withOmPts(Set<OmPt> omPts){
		this.omPts = omPts;
		return this;
	}

	@Override
	public OmAlim build() {
		OmAlim alim = new OmAlim();
		alim.setCdAlim(cdAlim);
		alim.setDsAlim(dsAlim);
		alim.setStAlim(stAlim);
		alim.setTpAlim(tpAlim);
		alim.setOmMapa(omMapa);
		alim.setOmUsr(omUsr);
		alim.setOmPtsForIdAlimcorrente(omPts);
		return alim;
	}

}
