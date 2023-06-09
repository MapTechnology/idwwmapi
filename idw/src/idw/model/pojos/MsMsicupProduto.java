package idw.model.pojos;

// default package
// Generated 10/01/2011 10:46:16 by Hibernate Tools 3.3.0.GA

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.MsMsicupProdutoTemplate;

/**
 * MsMsicup generated by hbm2java
 */
@Entity
@Table(name = "MS_MSICUP_PRODUTO")
public class MsMsicupProduto extends MsMsicupProdutoTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idMsicupProduto;
	private MsMsicup msMsicup;
	
	private String cdProduto;
	private String urlConexao;

	public MsMsicupProduto() {
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_MSICUP_PRODUTO_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_MSICUP_PRODUTO_SEQ", sequenceName = "MS_MSICUP_PRODUTO_SEQ")
	@Column(name = "ID_MSICUP_PRODUTO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdMsicupProduto() {
		return this.idMsicupProduto;
	}

	public void setIdMsicupProduto(BigDecimal idMsicup) {
		this.idMsicupProduto = idMsicup;
	}

	@Column(name = "URL_CONEXAO", length = 100)
	public String getUrlConexao() {
		return this.urlConexao;
	}

	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}
	
	@Column(name = "CD_PRODUTO", length = 60)
	public String getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(String valor) {
		this.cdProduto = valor;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MSICUP")
	public MsMsicup getMsMsicup() {
		return this.msMsicup;
	}

	public void setMsMsicup(MsMsicup msMsicup) {
		this.msMsicup = msMsicup;
	}

}
