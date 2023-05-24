package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmCfgurlTemplate;

@Entity
@Table(name = "om_cfgurl")
public class OmCfgurl extends OmCfgurlTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idCfgurl;
	private OmCfg omCfg;
	private String urlConexao;
	private String dsUrl;
	private Integer utc;

	public OmCfgurl() {
	}

	public OmCfgurl(Long idCfgurl) {
		this.idCfgurl = idCfgurl;
	}

	public OmCfgurl(Long idCfgurl, OmCfg omCfg, String urlConexao, String dsUrl) {
		this.idCfgurl = idCfgurl;
		this.omCfg = omCfg;
		this.urlConexao = urlConexao;
		this.dsUrl = dsUrl;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_CFGURL_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_CFGURL_SEQ", sequenceName = "OM_CFGURL_SEQ")
	@Column(name = "id_cfgurl", unique = true, nullable = false)
	public Long getIdCfgurl() {
		return this.idCfgurl;
	}

	public void setIdCfgurl(Long idCfgurl) {
		this.idCfgurl = idCfgurl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cfg")
	public OmCfg getOmCfg() {
		return this.omCfg;
	}

	public void setOmCfg(OmCfg omCfg) {
		this.omCfg = omCfg;
	}

	@Column(name = "url_conexao")
	public String getUrlConexao() {
		return this.urlConexao;
	}

	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}

	@Column(name = "ds_url", length = 100)
	public String getDsUrl() {
		return this.dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}
	@Column(name = "UTC")
	public Integer getUtc() {
		return this.utc;
	}
	public void setUtc(Integer utc) {
		this.utc = utc;
	}
}