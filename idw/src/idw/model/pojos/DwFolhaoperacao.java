package idw.model.pojos;
// Generated 12/09/2011 09:05:50 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.DwFolhaoperacaoTemplate;

/**
 * DwFolhaiac generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DW_FOLHAOPERACAO")
public class DwFolhaoperacao extends DwFolhaoperacaoTemplate		 implements java.io.Serializable {

	private Long idFolhaoperacao;
	private DwFolha dwFolha;
	private DwOperacao dwOperacao;
	private IpBalanceamento ipBalanceamento;
	private Integer ordem;

	public DwFolhaoperacao() {
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_FOLHAOPERACAO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_FOLHAOPERACAO_SEQ", sequenceName = "DW_FOLHAOPERACAO_SEQ")
	@Column(name = "ID_FOLHAOPERACAO", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdFolhaoperacao() {
		return this.idFolhaoperacao;
	}

	public void setIdFolhaoperacao(Long id) {
		this.idFolhaoperacao = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOLHA")
	public DwFolha getDwFolha() {
		return this.dwFolha;
	}

	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}

	@Column(name = "ORDEM", precision = 22, scale = 0)
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OPERACAO")
	public DwOperacao getDwOperacao() {
		return this.dwOperacao;
	}

	public void setDwOperacao(DwOperacao dwOperacao) {
		this.dwOperacao = dwOperacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BALANCEAMENTO")
	public IpBalanceamento getIpBalanceamento() {
		return this.ipBalanceamento;
	}

	public void setIpBalanceamento(IpBalanceamento ipbalanceamento) {
		this.ipBalanceamento = ipbalanceamento;
	}
}
