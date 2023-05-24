package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OmLicmodrec generated by hbm2java
 */
@Entity
@Table(name = "om_licmodrec")
public class OmLicmodrec implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idLicmodrec;
	private OmModuloRecurso omModuloRecurso;
	private OmLicenca omLicenca;
	private String chaveVerificacaoLicenca;
	private String chaveVerificacao;

	public OmLicmodrec() {
	}

	public OmLicmodrec(Long idLicmodrec, OmModuloRecurso omModuloRecurso, OmLicenca omLicenca) {
		this.idLicmodrec = idLicmodrec;
		this.omModuloRecurso = omModuloRecurso;
		this.omLicenca = omLicenca;
	}

	public OmLicmodrec(Long idLicmodrec, OmModuloRecurso omModuloRecurso, OmLicenca omLicenca,
			String chaveVerificacaoLicenca, String chaveVerificacao) {
		this.idLicmodrec = idLicmodrec;
		this.omModuloRecurso = omModuloRecurso;
		this.omLicenca = omLicenca;
		this.chaveVerificacaoLicenca = chaveVerificacaoLicenca;
		this.chaveVerificacao = chaveVerificacao;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_LICMODREC_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_LICMODREC_SEQ", sequenceName = "OM_LICMODREC_SEQ")
	@Column(name = "id_licmodrec", unique = true, nullable = false)
	public Long getIdLicmodrec() {
		return this.idLicmodrec;
	}

	public void setIdLicmodrec(Long idLicmodrec) {
		this.idLicmodrec = idLicmodrec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modulo_recurso", nullable = false)
	public OmModuloRecurso getOmModuloRecurso() {
		return this.omModuloRecurso;
	}

	public void setOmModuloRecurso(OmModuloRecurso omModuloRecurso) {
		this.omModuloRecurso = omModuloRecurso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_licenca", nullable = false)
	public OmLicenca getOmLicenca() {
		return this.omLicenca;
	}

	public void setOmLicenca(OmLicenca omLicenca) {
		this.omLicenca = omLicenca;
	}

	@Column(name = "chave_verificacao_licenca", length = 512)
	public String getChaveVerificacaoLicenca() {
		return this.chaveVerificacaoLicenca;
	}

	public void setChaveVerificacaoLicenca(String chaveVerificacaoLicenca) {
		this.chaveVerificacaoLicenca = chaveVerificacaoLicenca;
	}

	@Column(name = "chave_verificacao", length = 512)
	public String getChaveVerificacao() {
		return this.chaveVerificacao;
	}

	public void setChaveVerificacao(String chaveVerificacao) {
		this.chaveVerificacao = chaveVerificacao;
	}

}
