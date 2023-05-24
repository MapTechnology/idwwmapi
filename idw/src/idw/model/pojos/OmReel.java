package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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

import idw.model.pojos.template.OmReelTemplate;

@Entity
@Table(name = "om_reel")
public class OmReel extends OmReelTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idReel;
	private String cdReelid;
	private Date dthrCadastro;
	private BigDecimal qtAlimentada;
	private BigDecimal qtUsada;
	private BigDecimal qtPerdida;
	
	private OmAlimrea omAlimrea;
	
	public OmReel() {
		super();
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_REEL_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_REEL_SEQ", sequenceName = "OM_REEL_SEQ")
	@Column(name = "id_reel", unique = true, nullable = false)
	public Long getIdReel() {
		return idReel;
	}

	public void setIdReel(Long idReel) {
		this.idReel = idReel;
	}

	@Column(name = "cd_reelid")
	public String getCdReelid() {
		return cdReelid;
	}

	public void setCdReelid(String cdReelid) {
		this.cdReelid = cdReelid;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_cadastro", length = 23)
	public Date getDthrCadastro() {
		return dthrCadastro;
	}

	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}

	@Column(name = "qt_alimentada")
	public BigDecimal getQtAlimentada() {
		return qtAlimentada;
	}

	public void setQtAlimentada(BigDecimal qtAlimentada) {
		this.qtAlimentada = qtAlimentada;
	}

	@Column(name = "qt_usada")
	public BigDecimal getQtUsada() {
		return qtUsada;
	}

	public void setQtUsada(BigDecimal qtUsada) {
		this.qtUsada = qtUsada;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alimrea")
	public OmAlimrea getOmAlimrea() {
		return omAlimrea;
	}
	public void setOmAlimrea(OmAlimrea omAlimrea) {
		this.omAlimrea = omAlimrea;
	}

	@Column(name = "qt_perdida")
	public BigDecimal getQtPerdida() {
		return qtPerdida;
	}

	public void setQtPerdida(BigDecimal qtPerdida) {
		this.qtPerdida = qtPerdida;
	}
	

}
