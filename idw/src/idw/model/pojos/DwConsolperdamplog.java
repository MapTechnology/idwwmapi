package idw.model.pojos;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// Generated 30/04/2013 11:32:48 by Hibernate Tools 3.4.0.CR1


import idw.model.pojos.template.DwConsolperdamplogTemplate;

/**
 * DwConsolperdamplog generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="dw_consolperdamplog"
		)
public class DwConsolperdamplog extends DwConsolperdamplogTemplate implements java.io.Serializable {


	private long idConsolpemplog;
	
	private OmPt omPt;
	private PpCp ppCp;
	private OmMapapa omMapapa;
	private OmProduto omProduto;
	private DwTPerdamp dwTPerdamp;
	private DwRap dwRap;
	private Date dthrPerdamp;
	private int msDthrperdamp;
	private BigDecimal qtAutoPerdamp;
	private BigDecimal qtManuPerdamp;
	private Set<DwConsolpempoco> dwConsolpempocos = new HashSet<DwConsolpempoco>(0);

	public DwConsolperdamplog() {
	}


	public DwConsolperdamplog(long idConsolpemplog, OmProduto omProduto, DwTPerdamp dwTPerdamp, DwRap dwRap, Date dthrPerdamp, int msDthrperdamp, BigDecimal qtAutoPerdamp, BigDecimal qtManuPerdamp) {
		this.idConsolpemplog = idConsolpemplog;
		this.omProduto = omProduto;
		this.dwTPerdamp = dwTPerdamp;
		this.dwRap = dwRap;
		this.dthrPerdamp = dthrPerdamp;
		this.msDthrperdamp = msDthrperdamp;
		this.qtAutoPerdamp = qtAutoPerdamp;
		this.qtManuPerdamp = qtManuPerdamp;
	}
	public DwConsolperdamplog(long idConsolpemplog, OmProduto omProduto, DwTPerdamp dwTPerdamp, DwRap dwRap, Date dthrPerdamp, int msDthrperdamp, BigDecimal qtAutoPerdamp, BigDecimal qtManuPerdamp, Set<DwConsolpempoco> dwConsolpempocos) {
		this.idConsolpemplog = idConsolpemplog;
		this.omProduto = omProduto;
		this.dwTPerdamp = dwTPerdamp;
		this.dwRap = dwRap;
		this.dthrPerdamp = dthrPerdamp;
		this.msDthrperdamp = msDthrperdamp;
		this.qtAutoPerdamp = qtAutoPerdamp;
		this.qtManuPerdamp = qtManuPerdamp;
		this.dwConsolpempocos = dwConsolpempocos;
	}

	@Id 
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_CONSOLPERDAMPLOG_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_CONSOLPERDAMPLOG_SEQ", sequenceName = "DW_CONSOLPERDAMPLOG_SEQ")
	@Column(name="id_consolpemplog", unique=true, nullable=false)
	public long getIdConsolpemplog() {
		return this.idConsolpemplog;
	}

	public void setIdConsolpemplog(long idConsolpemplog) {
		this.idConsolpemplog = idConsolpemplog;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produto", nullable=false)
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_mapapa", nullable=true)
	public OmMapapa getOmMapapa() {
		return omMapapa;
	}


	public void setOmMapapa(OmMapapa omMapapa) {
		this.omMapapa = omMapapa;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pt", nullable=true)
	public OmPt getOmPt() {
		return omPt;
	}


	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cp", nullable=true)
	public PpCp getPpCp() {
		return ppCp;
	}


	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tperdamp", nullable=false)
	public DwTPerdamp getDwTPerdamp() {
		return this.dwTPerdamp;
	}

	public void setDwTPerdamp(DwTPerdamp dwTPerdamp) {
		this.dwTPerdamp = dwTPerdamp;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rap", nullable=false)
	public DwRap getDwRap() {
		return this.dwRap;
	}

	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dthr_perdamp", nullable=false, length=23)
	public Date getDthrPerdamp() {
		return this.dthrPerdamp;
	}

	public void setDthrPerdamp(Date dthrPerdamp) {
		this.dthrPerdamp = dthrPerdamp;
	}


	@Column(name="ms_dthrperdamp", nullable=false)
	public int getMsDthrperdamp() {
		return this.msDthrperdamp;
	}

	public void setMsDthrperdamp(int msDthrperdamp) {
		this.msDthrperdamp = msDthrperdamp;
	}


	@Column(name="qt_auto_perdamp", nullable=false, precision=14, scale=4)
	public BigDecimal getQtAutoPerdamp() {
		return this.qtAutoPerdamp;
	}

	public void setQtAutoPerdamp(BigDecimal qtAutoPerdamp) {
		this.qtAutoPerdamp = qtAutoPerdamp;
	}


	@Column(name="qt_manu_perdamp", nullable=false, precision=14, scale=4)
	public BigDecimal getQtManuPerdamp() {
		return this.qtManuPerdamp;
	}

	public void setQtManuPerdamp(BigDecimal qtManuPerdamp) {
		this.qtManuPerdamp = qtManuPerdamp;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="dwConsolperdamplog")
	public Set<DwConsolpempoco> getDwConsolpempocos() {
		return this.dwConsolpempocos;
	}

	public void setDwConsolpempocos(Set<DwConsolpempoco> dwConsolpempocos) {
		this.dwConsolpempocos = dwConsolpempocos;
	}




}


