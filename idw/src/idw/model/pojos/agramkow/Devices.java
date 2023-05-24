package idw.model.pojos.agramkow;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Devices generated by hbm2java
 */
@Entity
@Table(name = "DEVICES")
public class Devices implements java.io.Serializable {

	private Long deviceId;
	private String descriptor;
	private String originalName;
	private String description;
	private String note;
	private Byte hasLimit;
	private Byte hasResult;
	private Byte hasEvent;
	private Byte hasReport;
	private Byte inOut;
	private Byte processing;
	private String createdBy;
	private Date createdDate;
	private String changedBy;
	private Date changedDate;
	private String defaultConfig;
	private Byte show;
	private String flags;
	
	private Set<Failcodes> failcodeses = new HashSet<Failcodes>(0);
	
	private Set<ResultsHeader> resultsHeaders = new HashSet<ResultsHeader>(0);
	private Set<Units> unitses = new HashSet<Units>(0);
	

	public Devices() {
	}

	public Devices(Long deviceId, String descriptor,
			String originalName, Byte hasLimit, Byte hasResult,
			Byte hasEvent, Byte hasReport, Date createdDate, Date changedDate) {
		this.deviceId = deviceId;
		this.descriptor = descriptor;
		this.originalName = originalName;
		this.hasLimit = hasLimit;
		this.hasResult = hasResult;
		this.hasEvent = hasEvent;
		this.hasReport = hasReport;
		this.createdDate = createdDate;
		this.changedDate = changedDate;
	}

	public Devices(Long deviceId, String descriptor,
			String originalName, String description,
			String note, Byte hasLimit, Byte hasResult, Byte hasEvent,
			Byte hasReport, Byte inOut, Byte processing,
			String createdBy, Date createdDate, String changedBy,
			Date changedDate, String defaultConfig, Byte show,
			String flags, 
			Set<Failcodes> failcodeses, 
			
			Set<ResultsHeader> resultsHeaders, Set<Units> unitses) {
		this.deviceId = deviceId;
		this.descriptor = descriptor;
		this.originalName = originalName;
		this.description = description;
		this.note = note;
		this.hasLimit = hasLimit;
		this.hasResult = hasResult;
		this.hasEvent = hasEvent;
		this.hasReport = hasReport;
		this.inOut = inOut;
		this.processing = processing;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.changedBy = changedBy;
		this.changedDate = changedDate;
		this.defaultConfig = defaultConfig;
		this.show = show;
		this.flags = flags;
		
		this.failcodeses = failcodeses;
		
		this.resultsHeaders = resultsHeaders;
		this.unitses = unitses;
		
	}

	@Id
	@Column(name = "DEVICE_ID", unique = true, nullable = false)
	public Long getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "DESCRIPTOR", nullable = false)
	public String getDescriptor() {
		return this.descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	@Column(name = "ORIGINAL_NAME", nullable = false)
	public String getOriginalName() {
		return this.originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "NOTE")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "HAS_LIMIT", nullable = false)
	public Byte getHasLimit() {
		return this.hasLimit;
	}

	public void setHasLimit(Byte hasLimit) {
		this.hasLimit = hasLimit;
	}

	@Column(name = "HAS_RESULT", nullable = false)
	public Byte getHasResult() {
		return this.hasResult;
	}

	public void setHasResult(Byte hasResult) {
		this.hasResult = hasResult;
	}

	@Column(name = "HAS_EVENT", nullable = false)
	public Byte getHasEvent() {
		return this.hasEvent;
	}

	public void setHasEvent(Byte hasEvent) {
		this.hasEvent = hasEvent;
	}

	@Column(name = "HAS_REPORT", nullable = false)
	public Byte getHasReport() {
		return this.hasReport;
	}

	public void setHasReport(Byte hasReport) {
		this.hasReport = hasReport;
	}

	@Column(name = "IN_OUT")
	public Byte getInOut() {
		return this.inOut;
	}

	public void setInOut(Byte inOut) {
		this.inOut = inOut;
	}

	@Column(name = "PROCESSING")
	public Byte getProcessing() {
		return this.processing;
	}

	public void setProcessing(Byte processing) {
		this.processing = processing;
	}

	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 23)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CHANGED_BY")
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CHANGED_DATE", nullable = false, length = 23)
	public Date getChangedDate() {
		return this.changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	@Column(name = "DEFAULT_CONFIG")
	public String getDefaultConfig() {
		return this.defaultConfig;
	}

	public void setDefaultConfig(String defaultConfig) {
		this.defaultConfig = defaultConfig;
	}

	@Column(name = "SHOW")
	public Byte getShow() {
		return this.show;
	}

	public void setShow(Byte show) {
		this.show = show;
	}

	@Column(name = "FLAGS")
	public String getFlags() {
		return this.flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
	public Set<Failcodes> getFailcodeses() {
		return this.failcodeses;
	}

	public void setFailcodeses(Set<Failcodes> failcodeses) {
		this.failcodeses = failcodeses;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
	public Set<ResultsHeader> getResultsHeaders() {
		return this.resultsHeaders;
	}

	public void setResultsHeaders(Set<ResultsHeader> resultsHeaders) {
		this.resultsHeaders = resultsHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
	public Set<Units> getUnitses() {
		return this.unitses;
	}

	public void setUnitses(Set<Units> unitses) {
		this.unitses = unitses;
	}


}