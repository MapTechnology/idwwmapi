package idw.model.pojos.manutencao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servidor_atividadesordem")
public class ServidorAtividadesordem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String descricao; 
	private String dataManutencao; 
	private String dataInicio; 
	private String dataInicioPausa; 
	private String dataFimPausa; 
	private String dataFim; 
	private String tempoManutencao; 
	private String observacao; 
	private Integer status; 
	private Integer falhaId; 
	private Integer idConjuntoId; 
	private ServidorOrdemmanutencao servidorOrdemmanutencao; 
	private Integer idPecaId; 
	private Integer idSubConjuntoId; 
	private Integer realizadoPorId; 
	private Integer responsavelId; 
	private String manutencaoCorretiva; 
	private Integer manutencaoId;
	
	
	public ServidorAtividadesordem() {
		super();
	}
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "SERVIDOR_ATIVIDADESORDEM_SEQ")
	@javax.persistence.SequenceGenerator(name = "SERVIDOR_ATIVIDADESORDEM_SEQ", sequenceName = "SERVIDOR_ATIVIDADESORDEM_SEQ")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "descricao", length = 100)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Column(name = "dataManutencao")
	public String getDataManutencao() {
		return dataManutencao;
	}
	public void setDataManutencao(String dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	@Column(name = "dataInicio")
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	@Column(name = "dataInicioPausa")
	public String getDataInicioPausa() {
		return dataInicioPausa;
	}
	public void setDataInicioPausa(String dataInicioPausa) {
		this.dataInicioPausa = dataInicioPausa;
	}
	@Column(name = "dataFimPausa")
	public String getDataFimPausa() {
		return dataFimPausa;
	}
	public void setDataFimPausa(String dataFimPausa) {
		this.dataFimPausa = dataFimPausa;
	}
	@Column(name = "dataFim")
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	@Column(name = "tempoManutencao", length = 12)
	public String getTempoManutencao() {
		return tempoManutencao;
	}
	public void setTempoManutencao(String tempoManutencao) {
		this.tempoManutencao = tempoManutencao;
	}
	@Column(name = "observacao", length = 250)
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "falha_id")
	public Integer getFalhaId() {
		return falhaId;
	}
	public void setFalhaId(Integer falha_id) {
		this.falhaId = falha_id;
	}
	@Column(name = "idConjunto_id")
	public Integer getIdConjuntoId() {
		return idConjuntoId;
	}
	public void setIdConjuntoId(Integer idConjunto_id) {
		this.idConjuntoId = idConjunto_id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOrdem_id")
	public ServidorOrdemmanutencao getServidorOrdemmanutencao() {
		return servidorOrdemmanutencao;
	}
	public void setServidorOrdemmanutencao(ServidorOrdemmanutencao servidorOrdemmanutencao) {
		this.servidorOrdemmanutencao = servidorOrdemmanutencao;
	}
	@Column(name = "idPeca_id")
	public Integer getIdPecaId() {
		return idPecaId;
	}
	public void setIdPecaId(Integer idPeca_id) {
		this.idPecaId = idPeca_id;
	}
	@Column(name = "idSubConjunto_id")
	public Integer getIdSubConjuntoId() {
		return idSubConjuntoId;
	}
	public void setIdSubConjuntoId(Integer idSubConjunto_id) {
		this.idSubConjuntoId = idSubConjunto_id;
	}
	@Column(name = "realizadoPor_id")
	public Integer getRealizadoPorId() {
		return realizadoPorId;
	}
	public void setRealizadoPorId(Integer realizadoPor_id) {
		this.realizadoPorId = realizadoPor_id;
	}
	@Column(name = "responsavel_id")
	public Integer getResponsavelId() {
		return responsavelId;
	}
	public void setResponsavelId(Integer responsavel_id) {
		this.responsavelId = responsavel_id;
	}
	@Column(name = "manutencaoCorretiva")
	public String getManutencaoCorretiva() {
		return manutencaoCorretiva;
	}
	public void setManutencaoCorretiva(String manutencaoCorretiva) {
		this.manutencaoCorretiva = manutencaoCorretiva;
	}
	@Column(name = "manutencao_id")
	public Integer getManutencaoId() {
		return manutencaoId;
	}
	public void setManutencaoId(Integer manutencao_id) {
		this.manutencaoId = manutencao_id;
	}
	
}
