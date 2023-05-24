package idw.model.pojos.agramkow;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Models generated by hbm2java
 */
@Entity
@Table(name = "MODELS")
public class Models implements java.io.Serializable {

	private ModelsId id;
	private Servers servers;
	
	private String descriptor;
	private String note;
	private Byte useReprocessLimits;
	private Byte doubleCharge;
	private Byte compressorCheck;
	private Byte eventCheck;
	private Byte testModel;
	private Long modelType;
	private String createdBy;
	private Date createdDate;
	private String changedBy;
	private Date changedDate;
	private Byte archived;
	

	public Models() {
	}

	public Models(ModelsId id, Servers servers, 
			String descriptor, Byte useReprocessLimits,
			Byte doubleCharge, Byte compressorCheck, Byte eventCheck,
			Byte testModel, Long modelType, Date createdDate,
			Date changedDate, Byte archived) {
		this.id = id;
		this.servers = servers;
		
		this.descriptor = descriptor;
		this.useReprocessLimits = useReprocessLimits;
		this.doubleCharge = doubleCharge;
		this.compressorCheck = compressorCheck;
		this.eventCheck = eventCheck;
		this.testModel = testModel;
		this.modelType = modelType;
		this.createdDate = createdDate;
		this.changedDate = changedDate;
		this.archived = archived;
	}

	public Models(ModelsId id, Servers servers, 
			String descriptor, String note,
			Byte useReprocessLimits, Byte doubleCharge, Byte compressorCheck,
			Byte eventCheck, Byte testModel, Long modelType,
			String createdBy, Date createdDate, String changedBy,
			Date changedDate, Byte archived
			) {
		this.id = id;
		this.servers = servers;
		
		this.descriptor = descriptor;
		this.note = note;
		this.useReprocessLimits = useReprocessLimits;
		this.doubleCharge = doubleCharge;
		this.compressorCheck = compressorCheck;
		this.eventCheck = eventCheck;
		this.testModel = testModel;
		this.modelType = modelType;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.changedBy = changedBy;
		this.changedDate = changedDate;
		this.archived = archived;
		
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "modelId", column = @Column(name = "MODEL_ID", nullable = false)),
			@AttributeOverride(name = "server", column = @Column(name = "SERVER", nullable = false)) })
	public ModelsId getId() {
		return this.id;
	}

	public void setId(ModelsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERVER", nullable = false, insertable = false, updatable = false)
	public Servers getServers() {
		return this.servers;
	}

	public void setServers(Servers servers) {
		this.servers = servers;
	}


	@Column(name = "DESCRIPTOR", nullable = false)
	public String getDescriptor() {
		return this.descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	@Column(name = "NOTE")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "USE_REPROCESS_LIMITS", nullable = false)
	public Byte getUseReprocessLimits() {
		return this.useReprocessLimits;
	}

	public void setUseReprocessLimits(Byte useReprocessLimits) {
		this.useReprocessLimits = useReprocessLimits;
	}

	@Column(name = "DOUBLE_CHARGE", nullable = false)
	public Byte getDoubleCharge() {
		return this.doubleCharge;
	}

	public void setDoubleCharge(Byte doubleCharge) {
		this.doubleCharge = doubleCharge;
	}

	@Column(name = "COMPRESSOR_CHECK", nullable = false)
	public Byte getCompressorCheck() {
		return this.compressorCheck;
	}

	public void setCompressorCheck(Byte compressorCheck) {
		this.compressorCheck = compressorCheck;
	}

	@Column(name = "EVENT_CHECK", nullable = false)
	public Byte getEventCheck() {
		return this.eventCheck;
	}

	public void setEventCheck(Byte eventCheck) {
		this.eventCheck = eventCheck;
	}

	@Column(name = "TEST_MODEL", nullable = false)
	public Byte getTestModel() {
		return this.testModel;
	}

	public void setTestModel(Byte testModel) {
		this.testModel = testModel;
	}

	@Column(name = "MODEL_TYPE", nullable = false)
	public Long getModelType() {
		return this.modelType;
	}

	public void setModelType(Long modelType) {
		this.modelType = modelType;
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

	@Column(name = "ARCHIVED", nullable = false)
	public Byte getArchived() {
		return this.archived;
	}

	public void setArchived(Byte archived) {
		this.archived = archived;
	}


}
