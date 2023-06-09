package idw.model.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

// Generated 05/01/2010 11:04:20 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmHomoptTemplate;


/**
 * OmHomopt generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "om_homopt", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_usrhomologado", "id_pt" }))
public class OmHomopt extends OmHomoptTemplate implements java.io.Serializable {

	private long idHomo;
	private OmUsr omUsrByIdUsr;
	private OmUsr omUsrByIdUsrhomologado;
	private OmPt omPt;
	private Date dthrHomopt;
	private Byte tpHomopt;

	public OmHomopt() {
	}

	public OmHomopt(long idHomo, OmUsr omUsrByIdUsr,
			OmUsr omUsrByIdUsrhomologado, OmPt omPt) {
		this.idHomo = idHomo;
		this.omUsrByIdUsr = omUsrByIdUsr;
		this.omUsrByIdUsrhomologado = omUsrByIdUsrhomologado;
		this.omPt = omPt;
	}

	public OmHomopt(long idHomo, OmUsr omUsrByIdUsr,
			OmUsr omUsrByIdUsrhomologado, OmPt omPt, Date dthrHomopt,
			Byte tpHomopt) {
		this.idHomo = idHomo;
		this.omUsrByIdUsr = omUsrByIdUsr;
		this.omUsrByIdUsrhomologado = omUsrByIdUsrhomologado;
		this.omPt = omPt;
		this.dthrHomopt = dthrHomopt;
		this.tpHomopt = tpHomopt;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_HOMOPT_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_HOMOPT_SEQ", sequenceName = "OM_HOMOPT_SEQ")
	@Column(name = "id_homo", nullable = false)
	public long getIdHomo() {
		return this.idHomo;
	}

	public void setIdHomo(long idHomo) {
		this.idHomo = idHomo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usr", nullable = false)
	public OmUsr getOmUsrByIdUsr() {
		return this.omUsrByIdUsr;
	}

	public void setOmUsrByIdUsr(OmUsr omUsrByIdUsr) {
		this.omUsrByIdUsr = omUsrByIdUsr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrhomologado", nullable = false)
	public OmUsr getOmUsrByIdUsrhomologado() {
		return this.omUsrByIdUsrhomologado;
	}

	public void setOmUsrByIdUsrhomologado(OmUsr omUsrByIdUsrhomologado) {
		this.omUsrByIdUsrhomologado = omUsrByIdUsrhomologado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt", nullable = false)
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_homopt", length = 23)
	public Date getDthrHomopt() {
		return this.dthrHomopt;
	}

	public void setDthrHomopt(Date dthrHomopt) {
		this.dthrHomopt = dthrHomopt;
	}

	@Column(name = "tp_homopt")
	public Byte getTpHomopt() {
		return this.tpHomopt;
	}

	public void setTpHomopt(Byte tpHomopt) {
		this.tpHomopt = tpHomopt;
	}

}
