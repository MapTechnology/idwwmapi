package ms.model.dto;

import java.util.Date;

import idw.model.pojos.MsUpihm;

public class UpIhmDTO implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idUpIhm;
	private IhmDTO ihm;
	private UpDTO up;
	private Date dthrCadastro;
	
	public UpIhmDTO() {
	}
	
	public UpIhmDTO(MsUpihm msupihm){
		this.setIdUpIhm(msupihm.getIdUpihm().intValue());
		this.setIhm(new IhmDTO(msupihm.getMsIhm()));
		this.setDthrCadastro(msupihm.getDthrCadastro());
		this.setUp(new UpDTO(msupihm.getMsUp(), null));
	}
	
	public void setIdUpIhm(Integer idUpIhm) {
		this.idUpIhm = idUpIhm;
	}
	public Integer getIdUpIhm() {
		return idUpIhm;
	}
	
	public void setIhm(IhmDTO ihm) {
		this.ihm = ihm;
	}
	public IhmDTO getIhm() {
		return ihm;
	}
	
	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}
	public Date getDthrCadastro() {
		return dthrCadastro;
	}

	public UpDTO getUp() {
		return up;
	}

	public void setUp(UpDTO up) {
		this.up = up;
	}
	
	

}
