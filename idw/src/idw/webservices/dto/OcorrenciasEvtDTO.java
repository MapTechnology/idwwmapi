package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OcorrenciasEvtDTO {

	private Long idEvt;
	private String dsritmo;
	private Date dthrIni;
	private BigDecimal msDtHrIni;
	private Date dthrFim;
	private BigDecimal msDtHrFim;
	private BigDecimal duracaoEvt;
	private BigDecimal quantidade = BigDecimal.ZERO;

	public OcorrenciasEvtDTO() {
		super();
	}

	public Long getIdEvt() {
		return idEvt;
	}

	public void setIdEvt(Long idEvt) {
		this.idEvt = idEvt;
	}

	public Date getDthrIni() {
		return dthrIni;
	}

	public void setDthrIni(Date dthrIni) {
		this.dthrIni = dthrIni;
	}

	public BigDecimal getMsDtHrIni() {
		return msDtHrIni;
	}

	public void setMsDtHrIni(BigDecimal msDtHrIni) {
		this.msDtHrIni = msDtHrIni;
	}

	public Date getDthrFim() {
		return dthrFim;
	}

	public void setDthrFim(Date dthrFim) {
		this.dthrFim = dthrFim;
	}

	public BigDecimal getMsDtHrFim() {
		return msDtHrFim;
	}

	public void setMsDtHrFim(BigDecimal msDtHrFim) {
		this.msDtHrFim = msDtHrFim;
	}

	public BigDecimal getDuracaoEvt() {
		return duracaoEvt;
	}

	public void setDuracaoEvt(BigDecimal duracaoEvt) {
		this.duracaoEvt = duracaoEvt;
	}

	public String getDsritmo() {
		return dsritmo;
	}

	public void setDsritmo(String dsritmo) {
		this.dsritmo = dsritmo;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	
}
