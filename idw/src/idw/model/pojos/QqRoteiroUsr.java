package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.QqRoteiroUsrTemplate;


@Entity
@Table(name = "qq_roteiro_usr")
public class QqRoteiroUsr extends QqRoteiroUsrTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idRoteirousr;
	
	private OmUsr omusr;
	private OmUsrgrp omusrgrp;
	private QqRoteiroMov qqRoteiroMov;
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_ROTEIRO_USR_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_ROTEIRO_USR_SEQ", sequenceName = "QQ_ROTEIRO_USR_SEQ")
	@Column(name = "id_roteirousr", unique = true, nullable = false)
	public Long getIdRoteirousr() {
		return idRoteirousr;
	}
	public void setIdRoteirousr(Long idRoteirousr) {
		this.idRoteirousr = idRoteirousr;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usr")
	public OmUsr getOmusr() {
		return omusr;
	}
	public void setOmusr(OmUsr omusr) {
		this.omusr = omusr;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrgrp")
	public OmUsrgrp getOmusrgrp() {
		return omusrgrp;
	}
	public void setOmusrgrp(OmUsrgrp omusrgrp) {
		this.omusrgrp = omusrgrp;
	}

	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_roteiromov", nullable = false)
	public QqRoteiroMov getQqRoteiroMov() {
		return qqRoteiroMov;
	}
	public void setQqRoteiroMov(QqRoteiroMov qqRoteiroMov) {
		this.qqRoteiroMov = qqRoteiroMov;
	}
}
