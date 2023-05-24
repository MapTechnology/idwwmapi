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
 * MsEvtdefeito generated by hbm2java
 */
@Entity
@Table(name = "ms_evtdefeito")
public class MsEvtdefeito implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idEvtdefeito;
	private MsEvt msEvt;
	private String cdDefeito;
	private String cdAcao;
	private String cdCausa;
	private String cdJustificativa;
	private String cdArea;
	
	private String cdPosicao;
	private String cb;

	public MsEvtdefeito() {
	}

	public MsEvtdefeito(Long idEvtdefeito, MsEvt msEvt) {
		this.idEvtdefeito = idEvtdefeito;
		this.msEvt = msEvt;
	}

	public MsEvtdefeito(Long idEvtdefeito, MsEvt msEvt, String cdDefeito, String cdAcao, String cdCausa,
			String cdJustificativa) {
		this.idEvtdefeito = idEvtdefeito;
		this.msEvt = msEvt;
		this.cdDefeito = cdDefeito;
		this.cdAcao = cdAcao;
		this.cdCausa = cdCausa;
		this.cdJustificativa = cdJustificativa;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_EVTDEFEITO_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_EVTDEFEITO_SEQ", sequenceName = "MS_EVTDEFEITO_SEQ")
	@Column(name = "id_evtdefeito", unique = true, nullable = false)
	public Long getIdEvtdefeito() {
		return this.idEvtdefeito;
	}

	public void setIdEvtdefeito(Long idEvtdefeito) {
		this.idEvtdefeito = idEvtdefeito;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evt", nullable = false)
	public MsEvt getMsEvt() {
		return this.msEvt;
	}

	public void setMsEvt(MsEvt msEvt) {
		this.msEvt = msEvt;
	}

	@Column(name = "cd_defeito", length = 40)
	public String getCdDefeito() {
		return this.cdDefeito;
	}

	public void setCdDefeito(String cdDefeito) {
		this.cdDefeito = cdDefeito;
	}

	@Column(name = "cd_acao", length = 40)
	public String getCdAcao() {
		return this.cdAcao;
	}

	public void setCdAcao(String cdAcao) {
		this.cdAcao = cdAcao;
	}

	@Column(name = "cd_causa", length = 40)
	public String getCdCausa() {
		return this.cdCausa;
	}

	public void setCdCausa(String cdCausa) {
		this.cdCausa = cdCausa;
	}

	@Column(name = "cd_justificativa", length = 40)
	public String getCdJustificativa() {
		return this.cdJustificativa;
	}

	public void setCdJustificativa(String cdJustificativa) {
		this.cdJustificativa = cdJustificativa;
	}

	@Column(name = "CD_AREA", length = 60)
	public String getCdArea() {
		return this.cdArea;
	}

	public void setCdArea(String cd) {
		this.cdArea = cd;
	}
	
	@Column(name = "cd_posicao", length = 40)
	public String getCdPosicao() {
		return this.cdPosicao;
	}

	public void setCdPosicao(String cdPosicao) {
		this.cdPosicao = cdPosicao;
	}
	
	@Column(name = "cb", length = 40)
	public String getCb() {
		return this.cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}
}
