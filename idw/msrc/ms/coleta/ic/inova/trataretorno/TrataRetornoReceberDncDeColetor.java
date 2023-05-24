package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.UpDnc;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoReceberDncDeColetor extends TrataRetorno {

	public TrataRetornoReceberDncDeColetor() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		UpDnc oUpDnc = UpDnc.getNewInstancia(log, idLog);
		
		if(oUpDnc.pedidoReceberArquivo(this.ic.icupdto.getCdMaquina(), this.ic.icDadosRecebidos[10])) {
			oUpDnc.lastEventDnc = "36";
			oUpDnc.SLEEP_SEND = (int)((1600000 / oUpDnc.goUpDncDTO.getBaudRate().intValue()) - 33);
			
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
			
			Comando = "RESP;36;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;";
			Comando += String.valueOf(oUpDnc.goUpDncDTO.getRecTimeOut().intValue()); //Adicionar TIMEOUT
			Comando += "; ; ; ; ; ; ; ; ; ;";
		}
		else {
			String arquivo_cnt = "";
			
			log.info(idLog, 0, "Erro DNC: " + oUpDnc.codErro + " - Cod. Arq:" + this.ic.icDadosRecebidos[10] + " - Evt: " + this.ic.icDadosRecebidos[1] + " da UP " + this.ic.icupdto.getIdUP());
			
			if(oUpDnc.codErro == 7)
				arquivo_cnt = oUpDnc.goUpDncDTO.getcodArquivo() + ".CNT";
			
			Comando = "RESP;36;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" +
				oUpDnc.codErro + ";" + arquivo_cnt + " ; ; ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
