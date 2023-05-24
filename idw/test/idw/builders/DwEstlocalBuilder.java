package idw.builders;

import java.util.Date;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.OmUsr;

public class DwEstlocalBuilder  extends AbstractPojoPersistentBuilder<DwEstlocal, DAOGenericoTest>{

	private String cdLocal = BuilderDefaults.CODIGO;
	private String dsLocal = BuilderDefaults.DESCRICAO;
	private Long revisao = BuilderDefaults.REVISAO;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Date dtAtivo = BuilderDefaults.DATE;
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private DwEst dwEst = new DwEstBuilder().build();
	
	public DwEstlocalBuilder withCdLocal(String cdLocal){
		this.cdLocal = cdLocal;
		return this;
	}
	
	public DwEstlocalBuilder withDsLocal(String dsLocal){
		this.dsLocal = dsLocal;
		return this;
	}
	
	public DwEstlocalBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public DwEstlocalBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public DwEstlocalBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public DwEstlocalBuilder withDtAtivo(Date dtAtivo){
		this.dtAtivo = dtAtivo;
		return this;
	}
	
	public DwEstlocalBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public DwEstlocalBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public DwEstlocalBuilder withDwEst(DwEst dwEst){
		this.dwEst = dwEst;
		return this;
	}
	
	@Override
	public DwEstlocal build() {
		DwEstlocal estlocal = new DwEstlocal();
		estlocal.setCdLocal(cdLocal);
		estlocal.setDsLocal(dsLocal);
		estlocal.setRevisao(revisao);
		estlocal.setStAtivo(stAtivo);
		estlocal.setDtRevisao(dtRevisao);
		estlocal.setDtStativo(dtAtivo);
		estlocal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		estlocal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		estlocal.setDwEst(dwEst);
		return estlocal;
	}

}