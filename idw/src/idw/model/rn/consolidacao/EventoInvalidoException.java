package idw.model.rn.consolidacao;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.pojos.MsEvt;

@SuppressWarnings("serial")
public class EventoInvalidoException extends Exception {

	private final String msgAux;

	public EventoInvalidoException(MsEvt msEvt, String msgAux, Throwable e) {
		super(montarMensagem(msEvt, msgAux), e);
		this.msgAux = e.getMessage();
	}
	
	public EventoInvalidoException(MsEvt msEvt, String msgAux) {
		super(montarMensagem(msEvt, msgAux));
		this.msgAux = msgAux;
	}

	public String getMsgAux() {
		return msgAux;
	}

	private static String montarMensagem(MsEvt msEvt, String msgAux) {
		return new ToStringBuilder(msEvt, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("Evento inválido")
				.append("idEvt", msEvt.getIdEvt())
				.append("cdUp", msEvt.getCdUp())
				.append("idTpEvt", (msEvt.getMsTpevt() == null ? "" : msEvt.getMsTpevt().getIdTpevt()))
				.append("TpEvt", (msEvt.getMsTpevt() == null ? "" : msEvt.getMsTpevt().getType()))
				.append(ObjectUtils.defaultIfNull(msgAux, ""))
				.toString();
	}
}
