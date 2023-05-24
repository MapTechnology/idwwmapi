package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;

public class ConsultaPdbaMsEvt019 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		if (dto.isCIP()) {
			retorno.setCampoRSP1(dto.getCipDthrIni());
			retorno.setCampoRSP2(dto.getCipDuration());
			retorno.setCampoRSP3("");
			retorno.setCampoRSP4("");
			retorno.setCampoRSP5("");
			retorno.setCampoRSP6("");
			retorno.setCampoRSP7("");
			retorno.setCampoRSP8("");
		} else {
			retorno.setCampoRSP1("Sem Ctrl.Inicio Pro");
			retorno.setCampoRSP2("");
			retorno.setCampoRSP3("");
			retorno.setCampoRSP4("");
			retorno.setCampoRSP5("");
			retorno.setCampoRSP6("");
			retorno.setCampoRSP7("");
			retorno.setCampoRSP8("");
		}
		retorno.setResposta(true);

		return retorno;
	}

}
