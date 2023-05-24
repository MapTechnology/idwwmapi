package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwCal;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

import java.util.Date;

public class PpCpBuilder extends AbstractPojoPersistentBuilder<PpCp, DAOGenericoTest> {

	private String cdCp = BuilderDefaults.CODIGO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	private DwCal dwCal = new DwCalBuilder().build();
	private OmPt omPt = new OmPtBuilder().build();
	
	public PpCpBuilder withCdPpCp(String cdCp){
		this.cdCp = cdCp;
		return this;
	}
	
	public PpCpBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public PpCpBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public PpCpBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public PpCpBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public PpCpBuilder withDwCal(DwCal dwCal){
		this.dwCal = dwCal;
		return this;
	}
	
	public PpCpBuilder withOmPt(OmPt omPt){
		this.omPt = omPt;
		return this;
	}
	
	@Override
	public PpCp build(){
		PpCp ppCp = new PpCp();
		ppCp.setCdCp(cdCp);
		ppCp.setDtStativo(dtStAtivo);
		ppCp.setDtRevisao(dtRevisao);
		ppCp.setStAtivo(stAtivo);
		ppCp.setRevisao(revisao);
		ppCp.setDwCal(dwCal);
		ppCp.setOmPt(omPt);
		return ppCp;
	}
	
}