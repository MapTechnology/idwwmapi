package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijkanbanlocal generated by hbm2java
 */
@Entity
@Table(name = "IJKANBANLOCAL")
public class Ijkanbanlocal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3037523032530742541L;
	private String cdlocalkanban;
	private char filaproducao;
	private String dslocalkanban;
	private char stlocalkanban;
	private Set<Ijkanbanfluxo> ijkanbanfluxosForCdlocalorigem = new HashSet<Ijkanbanfluxo>(
			0);
	private Set<Ijkanbanmov> ijkanbanmovsForCdlocalorigem = new HashSet<Ijkanbanmov>(
			0);
	private Set<Ijkanbanmov> ijkanbanmovsForCdlocaldestino = new HashSet<Ijkanbanmov>(
			0);
	private Set<Ijkanbanfluxo> ijkanbanfluxosForCdlocaldestino = new HashSet<Ijkanbanfluxo>(
			0);
	private Set<Ijkanbanidcartao> ijkanbanidcartaos = new HashSet<Ijkanbanidcartao>(
			0);

	public Ijkanbanlocal() {
	}

	public Ijkanbanlocal(String cdlocalkanban, char filaproducao,
			String dslocalkanban, char stlocalkanban) {
		this.cdlocalkanban = cdlocalkanban;
		this.filaproducao = filaproducao;
		this.dslocalkanban = dslocalkanban;
		this.stlocalkanban = stlocalkanban;
	}

	public Ijkanbanlocal(String cdlocalkanban, char filaproducao,
			String dslocalkanban, char stlocalkanban,
			Set<Ijkanbanfluxo> ijkanbanfluxosForCdlocalorigem,
			Set<Ijkanbanmov> ijkanbanmovsForCdlocalorigem,
			Set<Ijkanbanmov> ijkanbanmovsForCdlocaldestino,
			Set<Ijkanbanfluxo> ijkanbanfluxosForCdlocaldestino,
			Set<Ijkanbanidcartao> ijkanbanidcartaos) {
		this.cdlocalkanban = cdlocalkanban;
		this.filaproducao = filaproducao;
		this.dslocalkanban = dslocalkanban;
		this.stlocalkanban = stlocalkanban;
		this.ijkanbanfluxosForCdlocalorigem = ijkanbanfluxosForCdlocalorigem;
		this.ijkanbanmovsForCdlocalorigem = ijkanbanmovsForCdlocalorigem;
		this.ijkanbanmovsForCdlocaldestino = ijkanbanmovsForCdlocaldestino;
		this.ijkanbanfluxosForCdlocaldestino = ijkanbanfluxosForCdlocaldestino;
		this.ijkanbanidcartaos = ijkanbanidcartaos;
	}

	@Id
	@Column(name = "CDLOCALKANBAN", unique = true, nullable = false, length = 6)
	public String getCdlocalkanban() {
		return this.cdlocalkanban;
	}

	public void setCdlocalkanban(String cdlocalkanban) {
		this.cdlocalkanban = cdlocalkanban;
	}

	@Column(name = "FILAPRODUCAO", nullable = false, length = 1)
	public char getFilaproducao() {
		return this.filaproducao;
	}

	public void setFilaproducao(char filaproducao) {
		this.filaproducao = filaproducao;
	}

	@Column(name = "DSLOCALKANBAN", nullable = false, length = 40)
	public String getDslocalkanban() {
		return this.dslocalkanban;
	}

	public void setDslocalkanban(String dslocalkanban) {
		this.dslocalkanban = dslocalkanban;
	}

	@Column(name = "STLOCALKANBAN", nullable = false, length = 1)
	public char getStlocalkanban() {
		return this.stlocalkanban;
	}

	public void setStlocalkanban(char stlocalkanban) {
		this.stlocalkanban = stlocalkanban;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijkanbanlocalByCdlocalorigem")
	public Set<Ijkanbanfluxo> getIjkanbanfluxosForCdlocalorigem() {
		return this.ijkanbanfluxosForCdlocalorigem;
	}

	public void setIjkanbanfluxosForCdlocalorigem(
			Set<Ijkanbanfluxo> ijkanbanfluxosForCdlocalorigem) {
		this.ijkanbanfluxosForCdlocalorigem = ijkanbanfluxosForCdlocalorigem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijkanbanlocalByCdlocalorigem")
	public Set<Ijkanbanmov> getIjkanbanmovsForCdlocalorigem() {
		return this.ijkanbanmovsForCdlocalorigem;
	}

	public void setIjkanbanmovsForCdlocalorigem(
			Set<Ijkanbanmov> ijkanbanmovsForCdlocalorigem) {
		this.ijkanbanmovsForCdlocalorigem = ijkanbanmovsForCdlocalorigem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijkanbanlocalByCdlocaldestino")
	public Set<Ijkanbanmov> getIjkanbanmovsForCdlocaldestino() {
		return this.ijkanbanmovsForCdlocaldestino;
	}

	public void setIjkanbanmovsForCdlocaldestino(
			Set<Ijkanbanmov> ijkanbanmovsForCdlocaldestino) {
		this.ijkanbanmovsForCdlocaldestino = ijkanbanmovsForCdlocaldestino;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijkanbanlocalByCdlocaldestino")
	public Set<Ijkanbanfluxo> getIjkanbanfluxosForCdlocaldestino() {
		return this.ijkanbanfluxosForCdlocaldestino;
	}

	public void setIjkanbanfluxosForCdlocaldestino(
			Set<Ijkanbanfluxo> ijkanbanfluxosForCdlocaldestino) {
		this.ijkanbanfluxosForCdlocaldestino = ijkanbanfluxosForCdlocaldestino;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijkanbanlocal")
	public Set<Ijkanbanidcartao> getIjkanbanidcartaos() {
		return this.ijkanbanidcartaos;
	}

	public void setIjkanbanidcartaos(Set<Ijkanbanidcartao> ijkanbanidcartaos) {
		this.ijkanbanidcartaos = ijkanbanidcartaos;
	}

}
