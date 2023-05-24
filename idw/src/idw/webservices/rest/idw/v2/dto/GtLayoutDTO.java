package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gtlayout")
public class GtLayoutDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String cdPt;
	Integer idImg;
	Integer x;
	Integer y;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public Integer getIdImg() {
		return idImg;
	}
	public void setIdImg(Integer idImg) {
		this.idImg = idImg;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
}
