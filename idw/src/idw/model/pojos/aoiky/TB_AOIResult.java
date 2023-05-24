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
@Table(name = "TB_AOIResult")
public class TB_AOIResult implements java.io.Serializable {
	
	@Id
	private String pcbguid;
	private long pcbid;
	private String machineId;
	private String machineIp;
	private String jobguid;
	private String jobFileIdLocal;
	private String jobFileIdShare;
	private String jobFileShareDir;
	private String lot;
	@Column(name = "startDateTime", columnDefinition="StartDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDateTime;
	@Column(name = "endDateTime", columnDefinition="EndDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDateTime;
	private String reviewUserId;
	private int pcbResultBefore;
	private int pcbResultAfter;
	private int pcbRepair;
	private String barCode;
	private String allBarCode;
	private String pcbModel;

	public TB_AOIResult (){
		
	}
	
	public TB_AOIResult (String pcbguid,long pcbid, String machineId, Date endDateTime, int pcbResultBefore,
						int pcbResultAfter, int pcbRepair ,String allBarCode, String pcbModel, String reviewUserId){
		
		this.pcbguid = pcbguid;
		this.pcbid = pcbid;
		this.machineId = machineId;
		this.endDateTime = endDateTime;
		this.pcbResultBefore = pcbResultBefore;
		this.pcbResultAfter = pcbResultAfter;
		this.pcbRepair = pcbRepair;
		this.allBarCode = allBarCode;
		this.pcbModel = pcbModel;
		this.reviewUserId = reviewUserId;
			
	}
	
	//@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "PCBGUID", nullable = false)
	public String getPcbGuid() {
		return this.pcbguid;
	}
	
	@Column(name = "PCBID", nullable = true)
	public long getPcbId() {
		return this.pcbid;
	}
	
	public void setPcbId(long pcbid) {
		this.pcbid = pcbid;
	}
	
	public void setPcbGuid(String pcbguid) {
		this.pcbguid = pcbguid;
	}
	
	@Column(name = "MachineID", nullable = true)
	public String getMAchineId() {
		return this.machineId;
	}
	
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	@Column(name = "EndDateTime", nullable = true)
	public Date getEndDateTime() {
		return this.endDateTime;
	}
	
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	@Column(name = "PCBResultBefore", nullable = true)
	public int getPCBResultBefore() {
		return this.pcbResultBefore;
	}
	
	public void setpcbResultBefore(int pcbResultBefore) {
		this.pcbResultBefore = pcbResultBefore;
	}
	
	@Column(name = "PCBResultAfter", nullable = true)
	public int getPCBResultAfter() {
		return this.pcbResultAfter;
	}
	
	public void setpcbResultAfter(int pcbResultAfter) {
		this.pcbResultAfter = pcbResultAfter;
	}
	
	@Column(name = "PCBRepair", nullable = true)
	public int getPcbRepair() {
		return this.pcbRepair;
	}
	
	public void setPcbRepair(int pcbRepair) {
		this.pcbRepair = pcbRepair;
	}
	
	@Column(name = "ALLBarCode", nullable = true)
	public String getAllBarCode() {
		return this.allBarCode;
	}
	
	public void setAllBarCode(String allBarCode) {
		this.allBarCode = allBarCode;
	}
	
	@Column(name = "PCBModel", nullable = true)
	public String getPcbModel() {
		return this.pcbModel;
	}
	
	public void setPcbModel(String pcbModel) {
		this.pcbModel = pcbModel;
	}
	
	@Column(name = "ReviewUserID", nullable = true)
	public String getReviewUserId() {
		return this.reviewUserId;
	}
	
	public void setReviewUserId(String reviewUserId) {
		this.reviewUserId = reviewUserId;
	}
	
	
	
	
	
	
	
	
	
	

	
}
