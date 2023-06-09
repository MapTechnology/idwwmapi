package idw.model.pojos;

// Generated 17/03/2016 08:57:28 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MsEvtmontagem generated by hbm2java
 */
@Entity
@Table(name = "ms_evtmontagem")
public class MsEvtmontagem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idEvtmontagem;
	private MsEvt msEvt;
	private String cb;
	private String cdProduto;
	private Integer ordem;
	private String dsmontagem;

	public MsEvtmontagem() {
	}

	public MsEvtmontagem(Long idEvtmontagem, MsEvt msEvt) {
		super();
		this.idEvtmontagem = idEvtmontagem;
		this.msEvt = msEvt;
	}

	public MsEvtmontagem(Long idEvtmontagem, MsEvt msEvt, String cb, Integer ordem, String dsmontagem) {
		super();
		this.idEvtmontagem = idEvtmontagem;
		this.msEvt = msEvt;
		this.cb = cb;
		this.ordem = ordem;
		this.dsmontagem = dsmontagem;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_EVTMONTAGEM_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_EVTMONTAGEM_SEQ", sequenceName = "MS_EVTMONTAGEM_SEQ")
	@Column(name = "id_evtmontagem", unique = true, nullable = false)
	public Long getIdEvtmontagem() {
		return this.idEvtmontagem;
	}

	public void setIdEvtmontagem(Long idEvtmontagem) {
		this.idEvtmontagem = idEvtmontagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evt", nullable = false)
	public MsEvt getMsEvt() {
		return this.msEvt;
	}

	public void setMsEvt(MsEvt msEvt) {
		this.msEvt = msEvt;
	}

	@Column(name = "cb", length = 256)
	public String getCb() {
		return this.cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	@Column(name = "ordem")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Column(name = "dsmontagem", length = 40)
	public String getDsmontagem() {
		return this.dsmontagem;
	}

	public void setDsmontagem(String dsmontagem) {
		this.dsmontagem = dsmontagem;
	}

	@Column(name = "CD_PRODUTO", length = 60)
	public String getCdProduto() {
		return this.cdProduto;
	}

	public void setCdProduto(String valor) {
		this.cdProduto = valor;
	}
}
