package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Generated 19/02/2016 13:57:41 by Hibernate Tools 4.0.0

import idw.model.pojos.template.DwOperacaomidiaTemplate;

/**
 * DwOperacaomidia generated by hbm2java
 */
@Entity
@Table(name = "dw_operacaomidia")
public class DwOperacaomidia extends DwOperacaomidiaTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idOperacaomidia;
	private DwOperacao dwOperacao;
	private Integer ordem;
	private String dsOperacaomidia;
	private byte[] midia;

	public DwOperacaomidia() {
	}

	public DwOperacaomidia(Long idOperacaomidia) {
		this.idOperacaomidia = idOperacaomidia;
	}

	public DwOperacaomidia(Long idOperacaomidia, DwOperacao dwOperacao, Integer ordem, String dsOperacaomidia,
			byte[] midia) {
		this.idOperacaomidia = idOperacaomidia;
		this.dwOperacao = dwOperacao;
		this.ordem = ordem;
		this.dsOperacaomidia = dsOperacaomidia;
		this.midia = midia;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_OPERACAOMIDIA_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_OPERACAOMIDIA_SEQ", sequenceName = "DW_OPERACAOMIDIA_SEQ")
	@Column(name = "id_operacaomidia", unique = true, nullable = false)
	public Long getIdOperacaomidia() {
		return this.idOperacaomidia;
	}

	public void setIdOperacaomidia(Long idOperacaomidia) {
		this.idOperacaomidia = idOperacaomidia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_operacao")
	public DwOperacao getDwOperacao() {
		return this.dwOperacao;
	}

	public void setDwOperacao(DwOperacao dwOperacao) {
		this.dwOperacao = dwOperacao;
	}

	@Column(name = "ordem")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Column(name = "ds_operacaomidia")
	public String getDsOperacaomidia() {
		return this.dsOperacaomidia;
	}

	public void setDsOperacaomidia(String dsOperacaomidia) {
		this.dsOperacaomidia = dsOperacaomidia;
	}

	@Column(name = "midia")
	public byte[] getMidia() {
		return this.midia;
	}

	public void setMidia(byte[] midia) {
		this.midia = midia;
	}

}
