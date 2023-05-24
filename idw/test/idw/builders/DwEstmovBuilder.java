package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;

import java.util.Date;

public class DwEstmovBuilder extends AbstractPojoPersistentBuilder<DwEstmov, DAOGenericoTest>{

	private DwEstpro dwEstpro = new DwEstproBuilder().build();
	private OmPt omPt = new OmPtBuilder().build();
	private DwTurno dwTurno = new DwTurnoBuilder().build();
	private OmUsr omUsr = new OmUsrBuilder().build();
	private Date dtHrMov = BuilderDefaults.DATE;
	
	public DwEstmovBuilder withDwEstpro(DwEstpro dwEstpro){
		this.dwEstpro = dwEstpro;
		return this;
	}
	
	public DwEstmovBuilder withOmPt(OmPt omPt){
		this.omPt = omPt;
		return this;
	}
	
	public DwEstmovBuilder withDwTurno(DwTurno dwTurno){
		this.dwTurno = dwTurno;
		return this;
	}
	
	public DwEstmovBuilder withOmUsr(OmUsr omUsr){
		this.omUsr = omUsr;
		return this;
	}
	
	public DwEstmovBuilder withDtHrMov(Date dtHrMov){
		this.dtHrMov = dtHrMov;
		return this;
	}
	
	@Override
	public DwEstmov build() {
		DwEstmov dwEstmov = new DwEstmov();
		dwEstmov.setDwEstpro(dwEstpro);
		dwEstmov.setOmPt(omPt);
		dwEstmov.setDwTurno(dwTurno);
		dwEstmov.setOmUsr(omUsr);
		dwEstmov.setDthrMov(dtHrMov);
		return dwEstmov;
	}

}
