package ms.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import idw.model.pojos.MsEvt;

@SuppressWarnings("serial")
public class EvtDTO implements Serializable{

	private Date dthrIEvento;
	private Date dthrFEvento;
	private BigDecimal idEvento;
	private BigDecimal idEventoAnterior;
	private BigDecimal idTipoEvento;
	private String dsTipoEvento;
	
	public EvtDTO(){
		
	}
	public EvtDTO(MsEvt msevt){
		this.dthrFEvento = msevt.getDthrEvento();
		this.dthrIEvento = msevt.getDthrEventoanterior();
		this.idEvento = new BigDecimal(msevt.getIdEvt());
		if (msevt.getMsEvt() != null)
			this.idEventoAnterior = new BigDecimal(msevt.getMsEvt().getIdEvt());
		this.idTipoEvento = new BigDecimal( msevt.getMsTpevt().getIdTpevt() );
		this.dsTipoEvento = msevt.getMsTpevt().getDsTpevt();
	}

	public Date getDthrIEvento() {
		return dthrIEvento;
	}

	public void setDthrIEvento(Date dthrIEvento) {
		this.dthrIEvento = dthrIEvento;
	}

	public Date getDthrFEvento() {
		return dthrFEvento;
	}

	public void setDthrFEvento(Date dthrFEvento) {
		this.dthrFEvento = dthrFEvento;
	}

	public BigDecimal getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(BigDecimal idEvento) {
		this.idEvento = idEvento;
	}

	public BigDecimal getIdEventoAnterior() {
		return idEventoAnterior;
	}

	public void setIdEventoAnterior(BigDecimal idEventoAnterior) {
		this.idEventoAnterior = idEventoAnterior;
	}

	public BigDecimal getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(BigDecimal idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getDsTipoEvento() {
		return dsTipoEvento;
	}

	public void setDsTipoEvento(String dsTipoEvento) {
		this.dsTipoEvento = dsTipoEvento;
	}
}
