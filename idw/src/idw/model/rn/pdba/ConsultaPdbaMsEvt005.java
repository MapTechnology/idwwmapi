package idw.model.rn.pdba;

import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.util.ConversaoTipos;

public class ConsultaPdbaMsEvt005 implements IConsultaMsEvtRN{

	@Override
	public IwsConsultaDTO getConsulta(ConsultaInovaSADTO dto) {
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		
		retorno.setCampoRSP1("SALDO OP:");
		retorno.setCampoRSP2(ConversaoTipos.converteParaString(dto.getUltimaOpSaldoAProduzir(), 0));
		retorno.setCampoRSP3("OP:");
		retorno.setCampoRSP4(dto.getUltimaOp());
		retorno.setCampoRSP5("FERRAM.");
		retorno.setCampoRSP6(dto.getUltimoMolde());
		if (dto.getListaProdutos() != null && dto.getListaProdutos().size() > 0)
			retorno.setCampoRSP7(dto.getListaProdutos().get(0));
		else
			retorno.setCampoRSP7("");
		retorno.setCampoRSP8("");
		
		retorno.setResposta(true);

		return retorno;
	}

}
