package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.UpDnc;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoEnviarDncParaColetor extends TrataRetorno {

	public TrataRetornoEnviarDncParaColetor() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		UpDnc oUpDnc;
		
		oUpDnc = UpDnc.getNewInstancia(log, idLog);
		
		if(oUpDnc.pedidoEnviarArquivo(this.ic.icupdto.getIdUP(), this.ic.icDadosRecebidos[10])) {
			oUpDnc.lastEventDnc = "35";
			oUpDnc.SLEEP_SEND = (int) ((1920000 / oUpDnc.goUpDncDTO.getBaudRate().intValue()) + 10);
			
			Comando = "SETDNC;" +
				oUpDnc.goUpDncDTO.getBaudRate().toString() + ";" +
				oUpDnc.goUpDncDTO.getDataBit().toString() + ";" +
				oUpDnc.goUpDncDTO.getStopBit().toString() + ";";
			
			if(oUpDnc.goUpDncDTO.getParity().toUpperCase().contains("ODD")) {
				Comando += "1;";
			}
			else if(oUpDnc.goUpDncDTO.getParity().toUpperCase().contains("EVEN")) {
				Comando += "2;";
			}
			else { //NONE
				Comando += "0;";
			}
			Comando += oUpDnc.goUpDncDTO.getSerialPort() + "; ; ; ; ; ; ;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
			
			Comando = "RESP;35;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" +
				oUpDnc.numPcts + ";" +
				oUpDnc.lastPctSize + ";";
			if(oUpDnc.isEXT) Comando += "1;";
			else Comando += "0;";
			Comando += "; ; ; ; ; ; ; ; ;";
		}
		else {
			String arq_nome_completo = "";
			
			log.info(idLog, 0, "Erro DNC: " + oUpDnc.codErro + " - Cod. Arq:" + this.ic.icDadosRecebidos[10] + " - Evt: " + this.ic.icDadosRecebidos[1] + " da UP " + this.ic.icupdto.getIdUP());
			
			arq_nome_completo = oUpDnc.goUpDncDTO.getcodArquivo() + ".";
			if(oUpDnc.isEXT) { arq_nome_completo += oUpDnc.goUpDncDTO.getDownloadExt(); }
			else { arq_nome_completo += "CNT"; }
			
			Comando = "RESP;35;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" +
				oUpDnc.codErro + ";" + arq_nome_completo + " ; ; ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
