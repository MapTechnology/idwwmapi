package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmPtcncTemplate;

@SuppressWarnings("serial")
@Entity
@Table(name = "om_ptcnc")
public class OmPtcnc extends OmPtcncTemplate implements Serializable {

	private long idPtcnc;
	private OmPt omPtByIdPt;
	private OmPt omPtByIdPtFilho;
	

	public OmPtcnc() {
	}

	public OmPtcnc(long idPtcnc, OmPt omPtByIdPtFilho) {
		this.idPtcnc = idPtcnc;
		this.omPtByIdPtFilho = omPtByIdPtFilho;
	}

	public OmPtcnc(long idPtcnc, OmPt omPtByIdPt, OmPt omPtByIdPtFilho) {
		this.idPtcnc = idPtcnc;
		this.omPtByIdPt = omPtByIdPt;
		this.omPtByIdPtFilho = omPtByIdPtFilho;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_PTCNC_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PTCNC_SEQ", sequenceName = "OM_PTCNC_SEQ")
	@Column(name = "id_ptcnc", unique = true, nullable = false)
	public long getIdPtcnc() {
		return this.idPtcnc;
	}

	public void setIdPtcnc(long idPtcnc) {
		this.idPtcnc = idPtcnc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt")
	public OmPt getOmPtByIdPt() {
		return this.omPtByIdPt;
	}

	public void setOmPtByIdPt(OmPt omPtByIdPt) {
		this.omPtByIdPt = omPtByIdPt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ptFilho", nullable = false)
	public OmPt getOmPtByIdPtFilho() {
		return this.omPtByIdPtFilho;
	}

	public void setOmPtByIdPtFilho(OmPt omPtByIdPtFilho) {
		this.omPtByIdPtFilho = omPtByIdPtFilho;
	}

	

	

}
