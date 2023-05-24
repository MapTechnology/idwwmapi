package idw.model.pojos.aoiky;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import idw.model.pojos.agramkow.Servers;

@Entity
@Table(name = "TB_AOIDefect")
public class TB_AOIDefect implements java.io.Serializable{
	
	private String pcbguid;
	@Id
	private String componentGuid;
	private String uname;
	private String partNumber;
	
	public TB_AOIDefect (){
		
	}
	
	public TB_AOIDefect(String pcbguid, String componentGuid, String uname, String partNumber){
		this.pcbguid = pcbguid;
		this.componentGuid = componentGuid;
		this.uname = uname;
		this.partNumber = partNumber;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PCBGUID", nullable = true)
	public String getPcbGuid() {
		return this.pcbguid;
	}
	
	public void setPcbGuid(String pcbguid) {
		this.pcbguid = pcbguid;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "ComponentGUID", nullable = false)
	public String getComponentGuid() {
		return this.componentGuid;
	}
	
	public void setComponentGuid(String componentGuid) {
		this.componentGuid = componentGuid;
	}
	
	@Column(name = "uname", nullable = true)
	public String getUname() {
		return this.uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	@Column(name = "PartNumber", nullable = true)
	public String getPartNumber() {
		return this.partNumber;
	}
	
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	
	
	

}
