package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwCal;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class DwCalBuilder extends AbstractPojoPersistentBuilder<DwCal, DAOGenericoTest> {
	
	private String cdCal = BuilderDefaults.CODIGO;
	private String dsCal = BuilderDefaults.DESCRICAO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	
	
	public DwCalBuilder withCdCal(String cdCal){
		this.cdCal = cdCal;
		return this;
	}
	
	public DwCalBuilder withDsCal(String dsCal){
		this.dsCal = dsCal;
		return this;
	}
	
	public DwCalBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public DwCalBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public DwCalBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	public DwCalBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public DwCalBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public DwCalBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	@Override
	public DwCal build(){
		DwCal dwCal = new DwCal();
		dwCal.setCdCal(cdCal);
		dwCal.setDsCal(dsCal);
		dwCal.setDtStativo(dtStAtivo);
		dwCal.setDtRevisao(dtRevisao);
		dwCal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		dwCal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		dwCal.setStAtivo(stAtivo);
		dwCal.setRevisao(revisao);
		return dwCal;
	}

}