package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.UpDnc;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoAposEnviarDncParaColetor extends TrataRetorno {

	public TrataRetornoAposEnviarDncParaColetor() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		UpDnc oUpDnc = UpDnc.getInstancia(log, idLog);
		if(oUpDnc.lastEventDnc == "35") {
			if(this.ic.icDadosRecebidos[10] == "1") {
				oUpDnc.post_enviar_arquivo(parametro.getDataHoraEvento());
			}
			else { // erro no envio do arquivo
				log.info(idLog, 0, "Erro DNC: " + this.ic.icDadosRecebidos[11] + " - Evt: " + this.ic.icDadosRecebidos[1] + " da UP " + this.ic.icupdto.getIdUP());
				//quando der erro, nao faz nada, no maximo exibe msg de erro
			}
		}
		oUpDnc.lastEventDnc = "";
		
		UtilsThreads.pausaNaThread(10);
	}

}
