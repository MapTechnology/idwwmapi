package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

public class FiltroConsolLocalEstoqueDTO {
	
	private OmProduto omProduto;
	private DwEst dwEst;
	private DwEstlocal dwEstlocal;
	private OmGt omGt;
	private OmPt omPt;
	private Date dtRefInicio;
	private Date dtRefFim;
	private DwTurno dwTurno;
	private byte tpLocalEstoque;
	
	public OmProduto getOmProduto() {
		return omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	public DwEst getDwEst() {
		return dwEst;
	}

	public void setDwEst(DwEst dwEst) {
		this.dwEst = dwEst;
	}

	public DwEstlocal getDwEstlocal() {
		return dwEstlocal;
	}

	public void setDwEstlocal(DwEstlocal dwEstlocal) {
		this.dwEstlocal = dwEstlocal;
	}

	public OmGt getOmGt() {
		return omGt;
	}

	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}

	public OmPt getOmPt() {
		return omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	public Date getDtRefInicio() {
		return dtRefInicio;
	}

	public void setDtRefInicio(Date dtRefInicio) {
		this.dtRefInicio = dtRefInicio;
	}

	public Date getDtRefFim() {
		return dtRefFim;
	}

	public void setDtRefFim(Date dtRefFim) {
		this.dtRefFim = dtRefFim;
	}

	public DwTurno getDwTurno() {
		return dwTurno;
	}

	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}

	public byte getTpLocalEstoque() {
		return tpLocalEstoque;
	}

	public void setTpLocalEstoque(byte tpLocalEstoque) {
		this.tpLocalEstoque = tpLocalEstoque;
	}
	
}
