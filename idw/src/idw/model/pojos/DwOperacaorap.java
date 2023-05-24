package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Generated 19/02/2016 13:57:41 by Hibernate Tools 4.0.0

import idw.model.pojos.template.DwOperacaorapTemplate;

/**
 * DwOperacaorap generated by hbm2java
 */
@Entity
@Table(name = "dw_operacaorap")
public class DwOperacaorap extends DwOperacaorapTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idOperacaorap;
	private DwOperacao dwOperacao;
	private DwRap dwRap;

	public DwOperacaorap() {
	}

	public DwOperacaorap(Long idOperacaorap) {
		this.idOperacaorap = idOperacaorap;
	}

	public DwOperacaorap(Long idOperacaorap, DwOperacao dwOperacao, DwRap dwRap) {
		this.idOperacaorap = idOperacaorap;
		this.dwOperacao = dwOperacao;
		this.dwRap = dwRap;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_OPERACAORAP_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_OPERACAORAP_SEQ", sequenceName = "DW_OPERACAORAP_SEQ")
	@Column(name = "id_operacaorap", unique = true, nullable = false)
	public Long getIdOperacaorap() {
		return this.idOperacaorap;
	}

	public void setIdOperacaorap(Long idOperacaorap) {
		this.idOperacaorap = idOperacaorap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_operacao")
	public DwOperacao getDwOperacao() {
		return this.dwOperacao;
	}

	public void setDwOperacao(DwOperacao dwOperacao) {
		this.dwOperacao = dwOperacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rap")
	public DwRap getDwRap() {
		return this.dwRap;
	}

	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}	

}