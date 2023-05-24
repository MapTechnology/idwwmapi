package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

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

/**
 * Ijtbparam generated by hbm2java
 */
@Entity
@Table(name = "IJTBPARAM")
public class Ijtbparam implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5008539952123164581L;
	private String cdparam;
	private Ijlinguas ijlinguas;
	private String tipoparam;
	private String nomeparam;
	private String nometabela;
	private String cdinterno;
	private Set<Ijparamitensarq> ijparamitensarqs = new HashSet<Ijparamitensarq>(
			0);
	private Set<Ijparaminf> ijparaminfs = new HashSet<Ijparaminf>(0);

	public Ijtbparam() {
	}

	public Ijtbparam(String cdparam, String tipoparam, String nomeparam,
			String cdinterno) {
		this.cdparam = cdparam;
		this.tipoparam = tipoparam;
		this.nomeparam = nomeparam;
		this.cdinterno = cdinterno;
	}

	public Ijtbparam(String cdparam, Ijlinguas ijlinguas, String tipoparam,
			String nomeparam, String nometabela, String cdinterno,
			Set<Ijparamitensarq> ijparamitensarqs, Set<Ijparaminf> ijparaminfs) {
		this.cdparam = cdparam;
		this.ijlinguas = ijlinguas;
		this.tipoparam = tipoparam;
		this.nomeparam = nomeparam;
		this.nometabela = nometabela;
		this.cdinterno = cdinterno;
		this.ijparamitensarqs = ijparamitensarqs;
		this.ijparaminfs = ijparaminfs;
	}

	@Id
	@Column(name = "CDPARAM", unique = true, nullable = false, length = 6)
	public String getCdparam() {
		return this.cdparam;
	}

	public void setCdparam(String cdparam) {
		this.cdparam = cdparam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDLINGUA")
	public Ijlinguas getIjlinguas() {
		return this.ijlinguas;
	}

	public void setIjlinguas(Ijlinguas ijlinguas) {
		this.ijlinguas = ijlinguas;
	}

	@Column(name = "TIPOPARAM", nullable = false, length = 1)
	public String getTipoparam() {
		return this.tipoparam;
	}

	public void setTipoparam(String tipoparam) {
		this.tipoparam = tipoparam;
	}

	@Column(name = "NOMEPARAM", nullable = false, length = 50)
	public String getNomeparam() {
		return this.nomeparam;
	}

	public void setNomeparam(String nomeparam) {
		this.nomeparam = nomeparam;
	}

	@Column(name = "NOMETABELA", length = 20)
	public String getNometabela() {
		return this.nometabela;
	}

	public void setNometabela(String nometabela) {
		this.nometabela = nometabela;
	}

	@Column(name = "CDINTERNO", nullable = false, length = 20)
	public String getCdinterno() {
		return this.cdinterno;
	}

	public void setCdinterno(String cdinterno) {
		this.cdinterno = cdinterno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbparam")
	public Set<Ijparamitensarq> getIjparamitensarqs() {
		return this.ijparamitensarqs;
	}

	public void setIjparamitensarqs(Set<Ijparamitensarq> ijparamitensarqs) {
		this.ijparamitensarqs = ijparamitensarqs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbparam")
	public Set<Ijparaminf> getIjparaminfs() {
		return this.ijparaminfs;
	}

	public void setIjparaminfs(Set<Ijparaminf> ijparaminfs) {
		this.ijparaminfs = ijparaminfs;
	}

}
