package idw.model.pojos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmPaproTemplate;

/**
 * OmPapro generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "om_papro")
public class OmPapro extends OmPaproTemplate implements java.io.Serializable {

	private long idPapro;
	private OmPa omPa;
	private OmProduto omProduto;
	private OmMapapa omMapapa;
	private OmPt omPt;
	private BigDecimal qtAtual;

	public OmPapro() {
	}

	public OmPapro(long idPapro) {
		this.idPapro = idPapro;
	}

	public OmPapro(long idPapro, OmPa omPa, OmProduto omProduto,
			OmMapapa omMapapa, OmPt omPt, BigDecimal qtAtual) {
		this.idPapro = idPapro;
		this.omPa = omPa;
		this.omProduto = omProduto;
		this.omMapapa = omMapapa;
		this.omPt = omPt;
		this.qtAtual = qtAtual;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_PAPRO_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PAPRO_SEQ", sequenceName = "OM_PAPRO_SEQ")	
	@Column(name = "id_papro", unique = true, nullable = false)
	public long getIdPapro() {
		return this.idPapro;
	}

	public void setIdPapro(long idPapro) {
		this.idPapro = idPapro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pa")
	public OmPa getOmPa() {
		return this.omPa;
	}

	public void setOmPa(OmPa omPa) {
		this.omPa = omPa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto")
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mapapa")
	public OmMapapa getOmMapapa() {
		return this.omMapapa;
	}

	public void setOmMapapa(OmMapapa omMapapa) {
		this.omMapapa = omMapapa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt")
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@Column(name = "qt_atual", precision = 14, scale = 4)
	public BigDecimal getQtAtual() {
		return this.qtAtual;
	}

	public void setQtAtual(BigDecimal qtAtual) {
		this.qtAtual = qtAtual;
	}

}
