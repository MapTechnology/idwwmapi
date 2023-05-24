package idw.model.rn.consolidacao;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.MsEvt;

@SuppressWarnings("serial")
public class EventoInvalidoEmParadaRegulagemException extends EventoInvalidoException {

	public EventoInvalidoEmParadaRegulagemException(MsEvt msEvt, DwConsolpalog dwConsolpalog) {
		super(msEvt, 
				new ToStringBuilder(dwConsolpalog, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("Parada regulagem aberta")
				.append("IdConsolpalog", ObjectUtils.defaultIfNull(dwConsolpalog.getIdConsolpalog(), "") )
				.append("dthrIparada", ObjectUtils.defaultIfNull(dwConsolpalog.getDthrIparada(), "") )
				.append("dthrFparada", ObjectUtils.defaultIfNull(dwConsolpalog.getDthrFparada(), "") )
				.toString());
			
	}

}
