package idw.webservices.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class FiltroDetalheLogVRotDTO {

	private Byte tpId;
	private Date dtReferenciaInicial;
	private Date dtReferenciaFinal;
	private DwTurno dwTurno;
	private OmPt omPt;
	private PpCp ppCp;
	private OmGt omGt;
	private DwTArea dwtarea;
	private OmProduto omProduto;
	
	private String codigoItem;
	
	public Byte getTpId() {
		return tpId;
	}
	public void setTpId(Byte tpId) {
		this.tpId = tpId;
	}
	public Date getDtReferenciaInicial() {
		return dtReferenciaInicial;
	}
	public void setDtReferenciaInicial(Date dtReferenciaInicial) {
		this.dtReferenciaInicial = dtReferenciaInicial;
	}
	public Date getDtReferenciaFinal() {
		return dtReferenciaFinal;
	}
	public void setDtReferenciaFinal(Date dtReferenciaFinal) {
		this.dtReferenciaFinal = dtReferenciaFinal;
	}
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public PpCp getPpCp() {
		return ppCp;
	}
	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	public DwTArea getDwtarea() {
		return dwtarea;
	}
	public void setDwtarea(DwTArea dwtarea) {
		this.dwtarea = dwtarea;
	}
	public String getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}	
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
		String retorno = "FiltroDetalheLogVRotDTO\n";
		
		retorno += "	tpId = ";
		if(tpId != null){
			retorno += tpId + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dtReferenciaInicial = ";
		if(dtReferenciaInicial != null){
			retorno += sdf.format(dtReferenciaInicial) + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dtReferenciaFinal = ";
		if(dtReferenciaFinal != null){
			retorno += sdf.format(dtReferenciaFinal) + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dwTurno = ";
		if(dwTurno != null){
			retorno += dwTurno.getCdTurno() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	omPt = ";
		if(omPt != null){
			retorno += omPt.getCdPt() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	ppCp = ";
		if(ppCp != null){
			retorno += ppCp.getCdCp() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	omGt = ";
		if(omGt != null){
			retorno += omGt.getCdGt() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dwtarea = ";
		if(dwtarea != null){
			retorno += dwtarea.getCdArea() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	omProduto = ";
		if(omProduto != null){
			retorno += omProduto.getCdProduto() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	codigoItem = ";
		if(codigoItem != null){
			retorno += codigoItem + "\n";
		} else {
			retorno += "null\n";
		}
		
		return retorno;
	}
	
}
