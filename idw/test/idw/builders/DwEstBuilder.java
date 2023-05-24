package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwEst;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class DwEstBuilder extends AbstractPojoPersistentBuilder<DwEst, DAOGenericoTest>{
	
	private String cdEst = BuilderDefaults.CODIGO;
	private String dsEst = BuilderDefaults.DESCRICAO;
	private byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	
	public DwEstBuilder withCdEst(String cdEst){
		this.cdEst = cdEst;
		return this;
	}
	
	public DwEstBuilder withDsEst(String dsEst){
		this.dsEst = dsEst;
		return this;
	} 
	
	public DwEstBuilder withStAtivo(byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public DwEstBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public DwEstBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public DwEstBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public DwEstBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public DwEstBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}

	@Override
	public DwEst build() {
		DwEst dwEst = new DwEst();
		dwEst.setCdEst(cdEst);
		dwEst.setDsEst(dsEst);
		dwEst.setStAtivo(stAtivo);
		dwEst.setRevisao(revisao);
		dwEst.setDtRevisao(dtRevisao);
		dwEst.setDtStativo(dtStAtivo);
		dwEst.setOmUsrByIdUsrstativo(omUsrStAtivo);
		dwEst.setOmUsrByIdUsrrevisao(omUsrRevisao);
		return dwEst;
	}

}