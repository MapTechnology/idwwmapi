package idw.model.pojos;
// Generated 28/07/2011 10:26:23 by Hibernate Tools 3.4.0.CR1

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

import idw.model.pojos.template.PpNecimpurllogTemplate;

/**
 * PpNecimpurllog generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_NECIMPURLLOG")
public class PpNecimpurllog extends PpNecimpurllogTemplate implements java.io.Serializable {

	private Long idNecimpurllog;
	private PpNecimpurl ppNecimpurl;
	private PpNecimplog ppNecimplog;
	private Date dthrIimportacao;
	private Date dthrFimportacao;
	private Integer stImp;
	private String dsErro;
	private String urlArquivo;
	private String aba;
	private Set<PpNec> ppNecs = new HashSet<PpNec>(0);

	public PpNecimpurllog() {
	}

	public PpNecimpurllog(Long idNecimpurllog, PpNecimpurl ppNecimpurl,
			PpNecimplog ppNecimplog) {
		this.idNecimpurllog = idNecimpurllog;
		this.ppNecimpurl = ppNecimpurl;
		this.ppNecimplog = ppNecimplog;
	}

	public PpNecimpurllog(Long idNecimpurllog, PpNecimpurl ppNecimpurl,
			PpNecimplog ppNecimplog, Date dthrIimportacao,
			Date dthrFimportacao, Integer stImp, String dsErro) {
		this.idNecimpurllog = idNecimpurllog;
		this.ppNecimpurl = ppNecimpurl;
		this.ppNecimplog = ppNecimplog;
		this.dthrIimportacao = dthrIimportacao;
		this.dthrFimportacao = dthrFimportacao;
		this.stImp = stImp;
		this.dsErro = dsErro;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "PP_NECIMPURLLOG_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_NECIMPURLLOG_SEQ", sequenceName = "PP_NECIMPURLLOG_SEQ")
	@Column(name = "ID_NECIMPURLLOG", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdNecimpurllog() {
		return this.idNecimpurllog;
	}

	public void setIdNecimpurllog(Long idNecimpurllog) {
		this.idNecimpurllog = idNecimpurllog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NECIMPURL", nullable = false)
	public PpNecimpurl getPpNecimpurl() {
		return this.ppNecimpurl;
	}

	public void setPpNecimpurl(PpNecimpurl ppNecimpurl) {
		this.ppNecimpurl = ppNecimpurl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NECIMPLOG", nullable = false)
	public PpNecimplog getPpNecimplog() {
		return this.ppNecimplog;
	}

	public void setPpNecimplog(PpNecimplog ppNecimplog) {
		this.ppNecimplog = ppNecimplog;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_IIMPORTACAO")
	public Date getDthrIimportacao() {
		return this.dthrIimportacao;
	}

	public void setDthrIimportacao(Date dthrIimportacao) {
		this.dthrIimportacao = dthrIimportacao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_FIMPORTACAO")
	public Date getDthrFimportacao() {
		return this.dthrFimportacao;
	}

	public void setDthrFimportacao(Date dthrFimportacao) {
		this.dthrFimportacao = dthrFimportacao;
	}

	@Column(name = "ST_IMP", length = 1)
	public Integer getStImp() {
		return this.stImp;
	}

	public void setStImp(Integer stImp) {
		this.stImp = stImp;
	}

	@Column(name = "DS_ERRO", length = 256)
	public String getDsErro() {
		return this.dsErro;
	}

	public void setDsErro(String dsErro) {
		this.dsErro = dsErro;
	}

	@Column(name = "URL_ARQUIVO")
	public String getUrlArquivo() {
		return this.urlArquivo;
	}

	public void setUrlArquivo(String urlArquivo) {
		this.urlArquivo = urlArquivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ppNecimpurllog")
	public Set<PpNec> getPpNecs() {
		return this.ppNecs;
	}

	public void setPpNecs(Set<PpNec> ppNecs) {
		this.ppNecs = ppNecs;
	}

	@Column(name = "ABA", length = 40)
	public String getAba() {
		return aba;
	}
	
	public void setAba(String aba) {
		this.aba = aba;
	}

}