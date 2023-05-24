package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.util.ConversaoTipos;

public class ConsultaPdbaMsEvt009 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		retorno.setCampoRSP1("%CIC TRN:");
		retorno.setCampoRSP2(ConversaoTipos.converteParaString(dto.getEfiCiclos(), 2));
		retorno.setCampoRSP3("%CIC OP:");
		retorno.setCampoRSP4(ConversaoTipos.converteParaString(dto.getEfiCiclosOP(), 2));
		retorno.setCampoRSP5("");
		retorno.setCampoRSP6("");
		retorno.setCampoRSP7("");
		retorno.setCampoRSP8("");
		
		retorno.setResposta(true);

		return retorno;
	}

}
