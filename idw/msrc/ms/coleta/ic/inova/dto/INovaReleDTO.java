package ms.coleta.ic.inova.dto;

import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsReleDTO;

@SuppressWarnings("serial")
public class INovaReleDTO extends IwsReleDTO {
	
	
	public void copyReleDTOWs(IwsReleDTO oRele) {
		IwsCicloDTO lcDadosCiclo = new IwsCicloDTO();
		
		if(oRele != null) {
			this.setINF01(oRele.getINF01());
			this.setINF02(oRele.getINF02());
			this.setINF03(oRele.getINF03());
			this.setINF04(oRele.getINF04());
			this.setINF05(oRele.getINF05());
			this.settmpLimParNaoInf(oRele.gettmpLimParNaoInf());
			this.setvlRefEficUltCiclo(oRele.getvlRefEficUltCiclo());
			if(oRele.getDadosUltCiclo() != null) {
				lcDadosCiclo = oRele.getDadosUltCiclo();
				this.setDadosUltCiclo(lcDadosCiclo);
			}
			else
				this.setDadosUltCiclo(null);
		}
	}
	
	public void copyAndonDTO(INovaAndonDTO andon) {
		this.setINF01(String.valueOf(andon.getIdrele()));
		this.setINF02(String.valueOf(andon.getStativo()));
		this.setINF03(String.valueOf(andon.getStintermitente()));
		this.setINF04(String.valueOf(andon.getTmpsinalalto()));
		this.setINF05(String.valueOf(andon.getTmpsinalbaixo()));
		this.settmpLimParNaoInf(null);
		this.setvlRefEficUltCiclo(null);
		this.setDadosUltCiclo(null);
	}
	
}
