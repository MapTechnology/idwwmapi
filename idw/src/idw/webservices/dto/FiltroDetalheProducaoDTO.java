package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwRap;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class FiltroDetalheProducaoDTO {
	
	private Date dthrinicio;
	private Date dthrfim;
	private OmPt ompt;
	private DwRap molde;
	private long iddwConsolid;
	private long idCp;
	private Byte tpId;
	private PpCp ppCp;
	private Integer indice;
	private DwTurno dwTurno;
	
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public Integer getIndice() {
		return indice;
	}
	public void setIndice(Integer indice) {
		this.indice = indice;
	}
	public PpCp getPpCp() {
		return ppCp;
	}
	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	public Byte getTpId() {
		return tpId;
	}
	public void setTpId(Byte tpId) {
		this.tpId = tpId;
	}
	public Date getDthrinicio() {
		return dthrinicio;
	}
	public void setDthrinicio(Date dthrinicio) {
		this.dthrinicio = dthrinicio;
	}
	public Date getDthrfim() {
		return dthrfim;
	}
	public void setDthrfim(Date dthrfim) {
		this.dthrfim = dthrfim;
	}
	public OmPt getOmpt() {
		return ompt;
	}
	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}
	public DwRap getMolde() {
		return molde;
	}
	public void setMolde(DwRap molde) {
		this.molde = molde;
	}
	public long getIddwConsolid() {
		return iddwConsolid;
	}
	public void setIddwConsolid(long iddwConsolid) {
		this.iddwConsolid = iddwConsolid;
	}
	public long getIdCp() {
		return idCp;
	}
	public void setIdCp(long idCp) {
		this.idCp = idCp;
	}
	
	
	
}
