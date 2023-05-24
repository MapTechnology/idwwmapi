package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmUsr;

public class DwTurnoBuilder extends AbstractPojoPersistentBuilder<DwTurno, DAOGenericoTest>{

	private String cdTurno = BuilderDefaults.CODIGO;
	private String dsTurno = BuilderDefaults.DESCRICAO;
	private Long revisao = BuilderDefaults.REVISAO;
	private byte stAtivo = BuilderDefaults.ST_ATIVO;
	private OmUsr omUsrRevisao = new OmUsrBuilder().build();
	private OmUsr omUsrStAtivo = new OmUsrBuilder().build();
	
	public DwTurnoBuilder withCdTurno(String cdTurno){
		this.cdTurno = cdTurno;
		return this;
	}
	
	public DwTurnoBuilder withDsTurno(String dsTurno){
		this.dsTurno = dsTurno;
		return this;
	}
	
	public DwTurnoBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	public DwTurnoBuilder withStAtivo(byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public DwTurnoBuilder withOmUsrRevisao(OmUsr omUsrRevisao){
		this.omUsrRevisao = omUsrRevisao;
		return this;
	}
	
	public DwTurnoBuilder withOmUsrStAtivo(OmUsr omUsrStAtivo){
		this.omUsrStAtivo = omUsrStAtivo;
		return this;
	}
	
	@Override
	public DwTurno build() {
		DwTurno dwTurno = new DwTurno();
		dwTurno.setCdTurno(cdTurno);
		dwTurno.setDsTurno(dsTurno);
		dwTurno.setRevisao(revisao);
		dwTurno.setStAtivo(stAtivo);
		dwTurno.setOmUsrByIdUsrrevisao(omUsrRevisao);
		dwTurno.setOmUsrByIdUsrstativo(omUsrStAtivo);
		return dwTurno;
	}

}