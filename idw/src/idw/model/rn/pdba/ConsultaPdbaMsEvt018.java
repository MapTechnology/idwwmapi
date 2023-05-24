package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;

public class ConsultaPdbaMsEvt018 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		if (dto.getListaProdutos() != null) {
			if (dto.getListaProdutos().size() > 0)
				retorno.setCampoRSP1(dto.getListaProdutos().get(0));
			retorno.setCampoRSP2("");

			if (dto.getListaProdutos().size() > 1)
				retorno.setCampoRSP3(dto.getListaProdutos().get(1));
			retorno.setCampoRSP4("");

			if (dto.getListaProdutos().size() > 2)
				retorno.setCampoRSP5(dto.getListaProdutos().get(2));
			retorno.setCampoRSP6("");

			if (dto.getListaProdutos().size() > 3)
				retorno.setCampoRSP7(dto.getListaProdutos().get(3));
			retorno.setCampoRSP8("");

			retorno.setResposta(true);
		} else {
			retorno.setCampoRSP1("");
			retorno.setCampoRSP2("");
			retorno.setCampoRSP3("");
			retorno.setCampoRSP4("");
			retorno.setCampoRSP5("");
			retorno.setCampoRSP6("");
			retorno.setCampoRSP7("");
			retorno.setCampoRSP8("");
			retorno.setResposta(false);
		}

		return retorno;
	}

}
