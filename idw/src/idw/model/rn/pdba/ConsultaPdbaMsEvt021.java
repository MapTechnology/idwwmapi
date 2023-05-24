package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.util.ConversaoTipos;

public class ConsultaPdbaMsEvt021 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		if (dto.isCIP()) {
			retorno.setCampoRSP1(dto.getCipDthrIni());
			retorno.setCampoRSP2("");
			retorno.setCampoRSP3("Prod:");
			retorno.setCampoRSP4(ConversaoTipos.converteParaString(dto.getProducaoLiquida(), 0));
			retorno.setCampoRSP5("Ref:");
			retorno.setCampoRSP6(ConversaoTipos.converteParaString(dto.getProducaoRefugada(), 0));
			retorno.setCampoRSP7("");
			retorno.setCampoRSP8("");
		} else {
			retorno.setCampoRSP1("CIP INDISPONIVEL");
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
