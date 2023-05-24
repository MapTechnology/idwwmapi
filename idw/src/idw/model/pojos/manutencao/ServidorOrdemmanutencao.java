package idw.model.pojos.manutencao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servidor_ordemmanutencao")
public class ServidorOrdemmanutencao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String codigo;
	private String descricao;
	private Date datacriacao;
	private BigDecimal tempototalmanutencao;
	private Integer frequenciamanutencao;
	private Integer tipo;
	private Integer status;
	private Integer responsavelcriacaoId;
	private Boolean isparada;

	private Set<ServidorAtividadesordem> servidorAtividades = new HashSet<>();
	
	private ServidorConjuntos  servidorConjuntos;
	
	
	public ServidorOrdemmanutencao() {
		super();
	}
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "SERVIDOR_ORDEMMANUTENCAO_SEQ")
	@javax.persistence.SequenceGenerator(name = "SERVIDOR_ORDEMMANUTENCAO_SEQ", sequenceName = "SERVIDOR_ORDEMMANUTENCAO_SEQ")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "codigo", length = 140)
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Column(name = "descricao", length = 140)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datacriacao", length = 23)
	public Date getDatacriacao() {
		return datacriacao;
	}
	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}
	@Column(name = "tempototalmanutencao")
	public BigDecimal getTempototalmanutencao() {
		return tempototalmanutencao;
	}
	public void setTempototalmanutencao(BigDecimal tempototalmanutencao) {
		this.tempototalmanutencao = tempototalmanutencao;
	}
	@Column(name = "frequenciamanutencao")
	public Integer getFrequenciamanutencao() {
		return frequenciamanutencao;
	}
	public void setFrequenciamanutencao(Integer frequenciamanutencao) {
		this.frequenciamanutencao = frequenciamanutencao;
	}
	@Column(name = "tipo")
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "responsavelcriacao_id")
	public Integer getResponsavelcriacaoId() {
		return responsavelcriacaoId;
	}
	public void setResponsavelcriacaoId(Integer responsavelcriacaoId) {
		this.responsavelcriacaoId = responsavelcriacaoId;
	}
	@Column(name = "isparada")
	public Boolean getIsparada() {
		return isparada;
	}
	public void setIsparada(Boolean isparada) {
		this.isparada = isparada;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "servidorOrdemmanutencao")
	public Set<ServidorAtividadesordem> getServidorAtividades() {
		return servidorAtividades;
	}
	public void setServidorAtividades(Set<ServidorAtividadesordem> servidorAtividades) {
		this.servidorAtividades = servidorAtividades;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conjunto_id")
	public ServidorConjuntos getServidorConjuntos() {
		return servidorConjuntos;
	}


	public void setServidorConjuntos(ServidorConjuntos servidorConjuntos) {
		this.servidorConjuntos = servidorConjuntos;
	}


}
