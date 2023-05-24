package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.util.ConversaoTipos;

public class ConsultaPdbaMsEvt001 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		retorno.setCampoRSP1("PRD TRN:");
		retorno.setCampoRSP2(ConversaoTipos.converteParaString(dto.getProducaoLiquida(), 0));
		retorno.setCampoRSP3("%REA TRN:");
		retorno.setCampoRSP4(ConversaoTipos.converteParaString(dto.getEfiRealizacao(), 2));
		retorno.setCampoRSP5("");
		retorno.setCampoRSP6("");
		retorno.setCampoRSP7("");
		retorno.setCampoRSP8("");
		
		retorno.setResposta(true);

		return retorno;
	}

}
