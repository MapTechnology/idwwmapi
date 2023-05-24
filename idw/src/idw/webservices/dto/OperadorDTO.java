package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;

public class OperadorDTO {
	private OmPt maquina;
	private PpCp ordemproducao;
	private Date dthrIlogin;
	private Integer msDthrilogin;
	private Date dthrFlogin;
	private Integer msDthrflogin;
	private OmUsr omUsr;
	
	public Date getDthrIlogin() {
		return dthrIlogin;
	}
	public void setDthrIlogin(Date dthrIlogin) {
		this.dthrIlogin = dthrIlogin;
	}
	public Integer getMsDthrilogin() {
		return msDthrilogin;
	}
	public void setMsDthrilogin(Integer msDthrilogin) {
		this.msDthrilogin = msDthrilogin;
	}
	public Date getDthrFlogin() {
		return dthrFlogin;
	}
	public void setDthrFlogin(Date dthrFlogin) {
		this.dthrFlogin = dthrFlogin;
	}
	public Integer getMsDthrflogin() {
		return msDthrflogin;
	}
	public void setMsDthrflogin(Integer msDthrflogin) {
		this.msDthrflogin = msDthrflogin;
	}
	public OmUsr getOmUsr() {
		return omUsr;
	}
	public void setOmUsr(OmUsr omUsr) {
		this.omUsr = omUsr;
	}
	public OmPt getMaquina() {
		return maquina;
	}
	public void setMaquina(OmPt maquina) {
		this.maquina = maquina;
	}
	public PpCp getOrdemproducao() {
		return ordemproducao;
	}
	public void setOrdemproducao(PpCp ordemproducao) {
		this.ordemproducao = ordemproducao;
	}
	
	
}
