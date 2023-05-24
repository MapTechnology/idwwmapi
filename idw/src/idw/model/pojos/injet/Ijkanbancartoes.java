package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijkanbancartoes generated by hbm2java
 */
@Entity
@Table(name = "IJKANBANCARTOES")
public class Ijkanbancartoes implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5949452953452315364L;
	private IjkanbancartoesId id;
	private Ijkanbanlote ijkanbanlote;
	private Ijkanbanidcartao ijkanbanidcartao;
	private Date dthrleitura;
	private Character stlibproducao;
	private Date dthrlibproducao;

	public Ijkanbancartoes() {
	}

	public Ijkanbancartoes(IjkanbancartoesId id, Ijkanbanlote ijkanbanlote,
			Ijkanbanidcartao ijkanbanidcartao, Date dthrleitura) {
		this.id = id;
		this.ijkanbanlote = ijkanbanlote;
		this.ijkanbanidcartao = ijkanbanidcartao;
		this.dthrleitura = dthrleitura;
	}

	public Ijkanbancartoes(IjkanbancartoesId id, Ijkanbanlote ijkanbanlote,
			Ijkanbanidcartao ijkanbanidcartao, Date dthrleitura,
			Character stlibproducao, Date dthrlibproducao) {
		this.id = id;
		this.ijkanbanlote = ijkanbanlote;
		this.ijkanbanidcartao = ijkanbanidcartao;
		this.dthrleitura = dthrleitura;
		this.stlibproducao = stlibproducao;
		this.dthrlibproducao = dthrlibproducao;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrlotekanban", column = @Column(name = "NRLOTEKANBAN", nullable = false, length = 12)),
			@AttributeOverride(name = "idcartaokanban", column = @Column(name = "IDCARTAOKANBAN", nullable = false, length = 50)) })
	public IjkanbancartoesId getId() {
		return this.id;
	}

	public void setId(IjkanbancartoesId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NRLOTEKANBAN", nullable = false, insertable = false, updatable = false)
	public Ijkanbanlote getIjkanbanlote() {
		return this.ijkanbanlote;
	}

	public void setIjkanbanlote(Ijkanbanlote ijkanbanlote) {
		this.ijkanbanlote = ijkanbanlote;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCARTAOKANBAN", nullable = false, insertable = false, updatable = false)
	public Ijkanbanidcartao getIjkanbanidcartao() {
		return this.ijkanbanidcartao;
	}

	public void setIjkanbanidcartao(Ijkanbanidcartao ijkanbanidcartao) {
		this.ijkanbanidcartao = ijkanbanidcartao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRLEITURA", nullable = false, length = 7)
	public Date getDthrleitura() {
		return this.dthrleitura;
	}

	public void setDthrleitura(Date dthrleitura) {
		this.dthrleitura = dthrleitura;
	}

	@Column(name = "STLIBPRODUCAO", length = 1)
	public Character getStlibproducao() {
		return this.stlibproducao;
	}

	public void setStlibproducao(Character stlibproducao) {
		this.stlibproducao = stlibproducao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRLIBPRODUCAO", length = 7)
	public Date getDthrlibproducao() {
		return this.dthrlibproducao;
	}

	public void setDthrlibproducao(Date dthrlibproducao) {
		this.dthrlibproducao = dthrlibproducao;
	}

}
