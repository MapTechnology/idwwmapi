package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;

public class ConsultaPdbaMsEvt022 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		retorno.setCampoRSP1("CONSULTA");
		retorno.setCampoRSP2("INDISPONIVEL");
		retorno.setCampoRSP3("");
		retorno.setCampoRSP4("");
		retorno.setCampoRSP5("");
		retorno.setCampoRSP6("");
		retorno.setCampoRSP7("");
		retorno.setCampoRSP8("");
		
		retorno.setResposta(true);

		return retorno;
	}

}
