package idw.model.pojos;
// Generated 28/07/2011 10:26:23 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OmContato generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "OM_CONTATO")
public class OmContato implements java.io.Serializable {

	private Long idContato;
	private PpCliente ppCliente;
	private String nmContato;
	private String obs;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String email1;
	private String email2;
	private String email3;
	private Set<OmGarantia> omGarantias = new HashSet<OmGarantia>(0);

	public OmContato() {
	}

	public OmContato(Long idContato, PpCliente ppCliente) {
		this.idContato = idContato;
		this.ppCliente = ppCliente;
	}

	public OmContato(Long idContato, PpCliente ppCliente, String nmContato,
			String obs, String telefone1, String telefone2, String telefone3,
			String email1, String email2, String email3,
			Set<OmGarantia> omGarantias) {
		this.idContato = idContato;
		this.ppCliente = ppCliente;
		this.nmContato = nmContato;
		this.obs = obs;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.email1 = email1;
		this.email2 = email2;
		this.email3 = email3;
		this.omGarantias = omGarantias;
	}

	@Id
	@Column(name = "ID_CONTATO", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdContato() {
		return this.idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	public PpCliente getPpCliente() {
		return this.ppCliente;
	}

	public void setPpCliente(PpCliente ppCliente) {
		this.ppCliente = ppCliente;
	}

	@Column(name = "NM_CONTATO", length = 100)
	public String getNmContato() {
		return this.nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	@Column(name = "OBS", length = 256)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Column(name = "TELEFONE1", length = 20)
	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	@Column(name = "TELEFONE2", length = 20)
	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	@Column(name = "TELEFONE3", length = 20)
	public String getTelefone3() {
		return this.telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	@Column(name = "EMAIL1", length = 256)
	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	@Column(name = "EMAIL2", length = 256)
	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	@Column(name = "EMAIL3", length = 256)
	public String getEmail3() {
		return this.email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omContato")
	public Set<OmGarantia> getOmGarantias() {
		return this.omGarantias;
	}

	public void setOmGarantias(Set<OmGarantia> omGarantias) {
		this.omGarantias = omGarantias;
	}

}
