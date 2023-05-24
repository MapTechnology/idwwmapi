package idw.model.pojos.manutencao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servidor_conjuntos")
public class ServidorConjuntos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id; 
	private String nome; 
	private String codigo; 
	private String ultimaManutencao; 
	private String hierarquia; 
	private Boolean status; 
	private BigDecimal mtbfMeta; 
	private BigDecimal mtbf; 
	private BigDecimal mttrMeta; 
	private BigDecimal mttr; 
	private String imageUrl; 
	private Boolean temFilho; 
	private String modelo; 
	private String numeroSerie; 
	private String anoFabricacao; 
	private Integer idArea_id; 
	private Integer idEstoque_id; 
	private Integer ultimoRevisor_id;
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "SERVIDOR_CONJUNTOS_SEQ")
	@javax.persistence.SequenceGenerator(name = "SERVIDOR_CONJUNTOS_SEQ", sequenceName = "SERVIDOR_CONJUNTOS_SEQ")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "codigo")
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Column(name = "ultimaManutencao")
	public String getUltimaManutencao() {
		return ultimaManutencao;
	}
	public void setUltimaManutencao(String ultimaManutencao) {
		this.ultimaManutencao = ultimaManutencao;
	}
	@Column(name = "hierarquia")
	public String getHierarquia() {
		return hierarquia;
	}
	public void setHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
	}
	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "mtbfMeta")
	public BigDecimal getMtbfMeta() {
		return mtbfMeta;
	}
	public void setMtbfMeta(BigDecimal mtbfMeta) {
		this.mtbfMeta = mtbfMeta;
	}
	@Column(name = "mtbf")
	public BigDecimal getMtbf() {
		return mtbf;
	}
	public void setMtbf(BigDecimal mtbf) {
		this.mtbf = mtbf;
	}
	@Column(name = "mttrMeta")
	public BigDecimal getMttrMeta() {
		return mttrMeta;
	}
	public void setMttrMeta(BigDecimal mttrMeta) {
		this.mttrMeta = mttrMeta;
	}
	@Column(name = "mttr")
	public BigDecimal getMttr() {
		return mttr;
	}
	public void setMttr(BigDecimal mttr) {
		this.mttr = mttr;
	}
	@Column(name = "imageUrl")
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Column(name = "temFilho")
	public Boolean getTemFilho() {
		return temFilho;
	}
	public void setTemFilho(Boolean temFilho) {
		this.temFilho = temFilho;
	}
	@Column(name = "modelo")
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	@Column(name = "numeroSerie")
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	@Column(name = "anoFabricacao")
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	@Column(name = "idArea_id")
	public Integer getIdArea_id() {
		return idArea_id;
	}
	public void setIdArea_id(Integer idArea_id) {
		this.idArea_id = idArea_id;
	}
	@Column(name = "idEstoque_id")
	public Integer getIdEstoque_id() {
		return idEstoque_id;
	}
	public void setIdEstoque_id(Integer idEstoque_id) {
		this.idEstoque_id = idEstoque_id;
	}
	@Column(name = "ultimoRevisor_id")
	public Integer getUltimoRevisor_id() {
		return ultimoRevisor_id;
	}
	public void setUltimoRevisor_id(Integer ultimoRevisor_id) {
		this.ultimoRevisor_id = ultimoRevisor_id;
	}

	
	
}
