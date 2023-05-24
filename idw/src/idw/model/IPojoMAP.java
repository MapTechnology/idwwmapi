package idw.model;

import java.util.Date;

import idw.model.pojos.OmUsr;

public interface IPojoMAP {
	public Long getId();
	public void setId(Long id);
	public String getCd();
	public String getFieldNameCd();
	public OmUsr getOmUsrByIdUsrrevisao();
	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao);
	public Date getDtRevisao();
	public void setDtRevisao(Date dtRevisao);
	public Date getDtStativo();
	public void setDtStativo(Date dtStativo);
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo);
	public OmUsr getOmUsrByIdUsrstativo();
	public Long getRevisao();
	public void setRevisao(Long revisao);
	public Byte getStAtivo();
	public void setStAtivo(Byte stAtivo);
}
