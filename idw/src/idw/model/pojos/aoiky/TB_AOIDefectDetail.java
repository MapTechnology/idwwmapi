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
@Table(name = "TB_AOIDefectDetail")
public class TB_AOIDefectDetail implements java.io.Serializable{
	
	@Id
	private String detailGuid;
	private String pcbguid;
	private String componentGuid;
	private int defect;
	private int redefect;
	private int failure;
	
	public TB_AOIDefectDetail(){
		
	}
	
	public TB_AOIDefectDetail(String pcbguid,String componentGuid, int defect, 
								int redefect ,int failure ){
		
		this.pcbguid = pcbguid;
		this.componentGuid = componentGuid;
		this.defect = defect;
		this.redefect = redefect;
		this.failure = failure;
		
	}
	
	@Column(name = "DetailGUID", nullable = false)
	public String getDetailGuid() {
		return this.detailGuid;
	}
	
	public void setDetailGuid(String detailGuid) {
		this.detailGuid = detailGuid;
	}
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PCBGUID", nullable = false)
	public String getPcbGuid() {
		return this.pcbguid;
	}
	
	public void setPcbGuid(String pcbguid) {
		this.pcbguid = pcbguid;
	}
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@Join
	@Column(name = "ComponentGUID", nullable = false)
	public String getComponentGuid() {
		return this.componentGuid;
	}
	
	public void setComponentGuid(String componentGuid) {
		this.componentGuid = componentGuid;
	}
	
	@Column(name = "Defect", nullable = true)
	public int getDefect() {
		return this.defect;
	}
	
	public void setDefect(int defect) {
		this.defect = defect;
	}
	
	@Column(name = "ReDefect", nullable = true)
	public int getRedefect() {
		return this.redefect;
	}
	
	public void setRedefect(int redefect) {
		this.redefect = redefect;
	}
	
	@Column(name = "Failure", nullable = true)
	public int getFailure() {
		return this.failure;
	}
	
	public void setFailure(int failure) {
		this.failure = failure;
	}
	
	
	
	
	
	
	
}
