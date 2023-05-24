package idw.model.rn.alimentacao;

import java.io.Serializable;

import idw.webservices.dto.SucessoDTO;

public class ReelidDTO extends SucessoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String reelid;
	private Double saldo;
	public String getReelid() {
		return reelid;
	}
	public void setReelid(String reelid) {
		this.reelid = reelid;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	

}
