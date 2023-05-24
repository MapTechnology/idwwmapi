package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijbroneopsecao generated by hbm2java
 */
@Entity
@Table(name = "IJBRONEOPSECAO")
public class Ijbroneopsecao implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6887339171050959931L;
	private IjbroneopsecaoId id;
	private double qtdplansecao;
	private String cdinjetora;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrcriacao;
	private String cdusuario;
	private String nropinjet;
	private char stregistro;
	private Set<Ijbroneopsecaoops> ijbroneopsecaoopses = new HashSet<Ijbroneopsecaoops>(
			0);
	private Set<Ijbroneopprocomp> ijbroneopprocomps = new HashSet<Ijbroneopprocomp>(
			0);

	public Ijbroneopsecao() {
	}

	public Ijbroneopsecao(IjbroneopsecaoId id, double qtdplansecao,
			char stregistro) {
		this.id = id;
		this.qtdplansecao = qtdplansecao;
		this.stregistro = stregistro;
	}

	public Ijbroneopsecao(IjbroneopsecaoId id, double qtdplansecao,
			String cdinjetora, String cdmolde, String cdestrutura,
			Date dthrcriacao, String cdusuario, String nropinjet,
			char stregistro, Set<Ijbroneopsecaoops> ijbroneopsecaoopses,
			Set<Ijbroneopprocomp> ijbroneopprocomps) {
		this.id = id;
		this.qtdplansecao = qtdplansecao;
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrcriacao = dthrcriacao;
		this.cdusuario = cdusuario;
		this.nropinjet = nropinjet;
		this.stregistro = stregistro;
		this.ijbroneopsecaoopses = ijbroneopsecaoopses;
		this.ijbroneopprocomps = ijbroneopprocomps;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nropsecao", column = @Column(name = "NROPSECAO", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)) })
	public IjbroneopsecaoId getId() {
		return this.id;
	}

	public void setId(IjbroneopsecaoId id) {
		this.id = id;
	}

	@Column(name = "QTDPLANSECAO", nullable = false, precision = 126, scale = 0)
	public double getQtdplansecao() {
		return this.qtdplansecao;
	}

	public void setQtdplansecao(double qtdplansecao) {
		this.qtdplansecao = qtdplansecao;
	}

	@Column(name = "CDINJETORA", length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDMOLDE", length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRCRIACAO", length = 7)
	public Date getDthrcriacao() {
		return this.dthrcriacao;
	}

	public void setDthrcriacao(Date dthrcriacao) {
		this.dthrcriacao = dthrcriacao;
	}

	@Column(name = "CDUSUARIO", length = 6)
	public String getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}

	@Column(name = "NROPINJET", length = 10)
	public String getNropinjet() {
		return this.nropinjet;
	}

	public void setNropinjet(String nropinjet) {
		this.nropinjet = nropinjet;
	}

	@Column(name = "STREGISTRO", nullable = false, length = 1)
	public char getStregistro() {
		return this.stregistro;
	}

	public void setStregistro(char stregistro) {
		this.stregistro = stregistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijbroneopsecao")
	public Set<Ijbroneopsecaoops> getIjbroneopsecaoopses() {
		return this.ijbroneopsecaoopses;
	}

	public void setIjbroneopsecaoopses(
			Set<Ijbroneopsecaoops> ijbroneopsecaoopses) {
		this.ijbroneopsecaoopses = ijbroneopsecaoopses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijbroneopsecao")
	public Set<Ijbroneopprocomp> getIjbroneopprocomps() {
		return this.ijbroneopprocomps;
	}

	public void setIjbroneopprocomps(Set<Ijbroneopprocomp> ijbroneopprocomps) {
		this.ijbroneopprocomps = ijbroneopprocomps;
	}

}
