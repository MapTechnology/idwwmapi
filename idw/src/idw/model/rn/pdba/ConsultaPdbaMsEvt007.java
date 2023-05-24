package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.util.ConversaoTipos;

public class ConsultaPdbaMsEvt007 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		retorno.setCampoRSP1("%PAR TRN:");
		retorno.setCampoRSP2(ConversaoTipos.converteParaString(dto.getIndiceParadas(), 2));
		retorno.setCampoRSP3("%PAR OP:");
		retorno.setCampoRSP4(ConversaoTipos.converteParaString(dto.getIndiceParadasPorOP(), 2));
		retorno.setCampoRSP5("");
		retorno.setCampoRSP6("");
		retorno.setCampoRSP7("");
		retorno.setCampoRSP8("");
		
		retorno.setResposta(true);

		return retorno;
	}

}
