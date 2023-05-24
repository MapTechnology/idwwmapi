package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import idw.model.pojos.template.QqFolhaInsMedTemplate;

@XmlRootElement
@Entity
@Table(name = "QQ_FOLHA_INS_MED")
public class QqFolhaInsMed extends QqFolhaInsMedTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFolhainsmed;
	private String dsFolhainsmed;
	private byte[] media;
	private Integer ordem;
	private String nomearquivo;
	
	
	// FK
	private QqFolhaInsAtiv qqFolhaInsAtiv;


	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_FOLHA_INS_MED_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_FOLHA_INS_MED_SEQ", sequenceName = "QQ_FOLHA_INS_MED_SEQ")
	@Column(name = "id_folhainsmed", unique = true, nullable = false)
	public Long getIdFolhainsmed() {
		return idFolhainsmed;
	}


	public void setIdFolhainsmed(Long idFolhainsmed) {
		this.idFolhainsmed = idFolhainsmed;
	}


	@Column(name = "DS_FOLHAINSMED", length = 256)
	public String getDsFolhainsmed() {
		return dsFolhainsmed;
	}


	public void setDsFolhainsmed(String dsFolhainsmed) {
		this.dsFolhainsmed = dsFolhainsmed;
	}


	@Column(name = "media")
	public byte[] getMedia() {
		return media;
	}


	public void setMedia(byte[] media) {
		this.media = media;
	}


	@Column(name = "ORDEM")
	public Integer getOrdem() {
		return ordem;
	}


	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}


	@Column(name = "NOMEARQUIVO")
	public String getNomearquivo() {
		return nomearquivo;
	}
	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}

	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOLHAINSATIV")
	public QqFolhaInsAtiv getQqFolhaInsAtiv() {
		return qqFolhaInsAtiv;
	}


	public void setQqFolhaInsAtiv(QqFolhaInsAtiv qqFolhaInsAtiv) {
		this.qqFolhaInsAtiv = qqFolhaInsAtiv;
	}
}
