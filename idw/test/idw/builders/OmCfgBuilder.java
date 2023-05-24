package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwPepro;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmUsr;

public class OmCfgBuilder extends AbstractPojoPersistentBuilder<OmCfg, DAOGenericoTest> {
	
	private OmCc omCcdefault = new OmCcBuilder().build();
	private DwCal dwCal = new DwCalBuilder().build();
	private DwPepro dwPeproNormal = new DwPeproBuilder().build();
	private DwPepro dwPreproCtrepproc = dwPeproNormal;
	private OmUsr omUsrimpprog = new OmUsrBuilder().build();
	private OmUsr omUsrrevisao = omUsrimpprog;
	private OmUsr omUsrstativo = omUsrimpprog;
	private Long revisao = BuilderDefaults.REVISAO;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	
	public OmCfgBuilder withOmCcdefault(OmCc omCcdefault){
		this.omCcdefault = omCcdefault;
		return this;
	}
	
	public OmCfgBuilder withDwCal(DwCal dwCal){
		this.dwCal = dwCal;
		return this;
	}
	
	public OmCfgBuilder withDwPeproNormal(DwPepro dwPeproNormal){
		this.dwPeproNormal = dwPeproNormal;
		return this;
	}
	
	public OmCfgBuilder withDwPreproCtrepproc(DwPepro dwPreproCtrepproc){
		this.dwPreproCtrepproc = dwPreproCtrepproc;
		return this;
	}
	
	public OmCfgBuilder withOmUsrimpprog(OmUsr omUsrimpprog){
		this.omUsrimpprog = omUsrimpprog;
		return this;
	}
	
	public OmCfgBuilder withOmUsrrevisao(OmUsr omUsrrevisao){
		this.omUsrrevisao = omUsrrevisao;
		return this;
	}
	
	public OmCfgBuilder withOmUsrstativo(OmUsr omUsrstativo){
		this.omUsrstativo = omUsrstativo;
		return this;
	}
	
	public OmCfgBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public OmCfgBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	@Override
	public OmCfg build(){
		OmCfg omCfg = new OmCfg();
		omCfg.setOmCcdefault(omCcdefault);
		omCfg.setDwCal(dwCal);
		omCfg.setDwPeproByIdPepronormal(dwPeproNormal);
		omCfg.setDwPeproByIdPeproctreproc(dwPreproCtrepproc);
		omCfg.setOmUsrimpprog(omUsrimpprog);
		omCfg.setOmUsrByIdUsrrevisao(omUsrrevisao);
		omCfg.setOmUsrByIdUsrstativo(omUsrstativo);
		omCfg.setRevisao(revisao);
		omCfg.setStAtivo(stAtivo);
		return omCfg;
	}
}
