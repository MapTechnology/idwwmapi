package idw.model.rn.pdba;

import java.util.Date;

import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.rn.DataHoraRN;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;

public class CIPPdbaMsEvtRN extends AbstractPdbaMsEvtRN{

	public Boolean setTr_trataInicioDeCIP(String idup, Date dataReferencia, String tecnico){
		Boolean retorno;
		// Chamar servico de inicio de cip
		MsEvt msevt;
		try {
			msevt = executarServico(null, idup, tecnico, dataReferencia, null, null, ServicoFactory._INICIAR_CIP_INOVASA, "setTr_trataInicioDeCIP " + DataHoraRN.getDataHoraAtualFormatada());
		} catch (ServicoFalhouException e) {
			msevt = null;
		}
		
		if (msevt == null || msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal())) {
			retorno = false;
		} else {
			retorno = true;
		}

		return retorno;
	}
	
	public Boolean setTr_trataFimCIP(String idUp,Date dthrfim, String tecnico){
		
		// Chamar servico de fim de cip
		Boolean retorno;
		// Chamar servico de inicio de cip
		MsEvt msevt;
		try {
			msevt = executarServico(null, idUp, tecnico, dthrfim, null, null, ServicoFactory._FINALIZAR_CIP_INOVASA, "setTr_trataFimCIP " + DataHoraRN.getDataHoraAtualFormatada());
		} catch (ServicoFalhouException e) {
			msevt = null;
		}

		if (msevt == null || msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal())) {
			retorno = false;
		} else {
			retorno = true;
		}

		return retorno;
	}
}
