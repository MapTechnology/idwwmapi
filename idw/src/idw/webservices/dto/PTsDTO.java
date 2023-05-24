/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("serial")
public class PTsDTO implements Serializable {
    private List<PtDTO> pts;
    
    
    private String status;
    private String msgStatus;

	public List<PtDTO> getPts() {
		return pts;
	}

	public void setPts(List<PtDTO> pts) {
		this.pts = pts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	
    

    
}