package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Exportacao019 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_019")
public class Exportacao019 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3357115402772915577L;
	private Exportacao019Id id;
	private String dtrefturno;
	private char cdturno;
	private String cdoperador;
	private String cdmaquina;
	private String cdproduto;
	private String cdrefugo;
	private double qtrefugada;
	private char tpoperacao;
	private char stregistro;
	private Date dthrstregistro;

	public Exportacao019() {
	}

	public Exportacao019(Exportacao019Id id, String dtrefturno, char cdturno,
			String cdoperador, String cdmaquina, String cdproduto,
			String cdrefugo, double qtrefugada, char tpoperacao,
			char stregistro, Date dthrstregistro) {
		this.id = id;
		this.dtrefturno = dtrefturno;
		this.cdturno = cdturno;
		this.cdoperador = cdoperador;
		this.cdmaquina = cdmaquina;
		this.cdproduto = cdproduto;
		this.cdrefugo = cdrefugo;
		this.qtrefugada = qtrefugada;
		this.tpoperacao = tpoperacao;
		this.stregistro = stregistro;
		this.dthrstregistro = dthrstregistro;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idregistro", column = @Column(name = "IDREGISTRO", nullable = false, length = 13)),
			@AttributeOverride(name = "idplanta", column = @Column(name = "IDPLANTA", nullable = false, length = 4)),
			@AttributeOverride(name = "idarea", column = @Column(name = "IDAREA", nullable = false, length = 10)) })
	public Exportacao019Id getId() {
		return this.id;
	}

	public void setId(Exportacao019Id id) {
		this.id = id;
	}

	@Column(name = "DTREFTURNO", nullable = false, length = 8)
	public String getDtrefturno() {
		return this.dtrefturno;
	}

	public void setDtrefturno(String dtrefturno) {
		this.dtrefturno = dtrefturno;
	}

	@Column(name = "CDTURNO", nullable = false, length = 1)
	public char getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(char cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "CDOPERADOR", nullable = false, length = 6)
	public String getCdoperador() {
		return this.cdoperador;
	}

	public void setCdoperador(String cdoperador) {
		this.cdoperador = cdoperador;
	}

	@Column(name = "CDMAQUINA", nullable = false, length = 6)
	public String getCdmaquina() {
		return this.cdmaquina;
	}

	public void setCdmaquina(String cdmaquina) {
		this.cdmaquina = cdmaquina;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "CDREFUGO", nullable = false, length = 6)
	public String getCdrefugo() {
		return this.cdrefugo;
	}

	public void setCdrefugo(String cdrefugo) {
		this.cdrefugo = cdrefugo;
	}

	@Column(name = "QTREFUGADA", nullable = false, precision = 126, scale = 0)
	public double getQtrefugada() {
		return this.qtrefugada;
	}

	public void setQtrefugada(double qtrefugada) {
		this.qtrefugada = qtrefugada;
	}

	@Column(name = "TPOPERACAO", nullable = false, length = 1)
	public char getTpoperacao() {
		return this.tpoperacao;
	}

	public void setTpoperacao(char tpoperacao) {
		this.tpoperacao = tpoperacao;
	}

	@Column(name = "STREGISTRO", nullable = false, length = 1)
	public char getStregistro() {
		return this.stregistro;
	}

	public void setStregistro(char stregistro) {
		this.stregistro = stregistro;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRSTREGISTRO", nullable = false, length = 7)
	public Date getDthrstregistro() {
		return this.dthrstregistro;
	}

	public void setDthrstregistro(Date dthrstregistro) {
		this.dthrstregistro = dthrstregistro;
	}

}
