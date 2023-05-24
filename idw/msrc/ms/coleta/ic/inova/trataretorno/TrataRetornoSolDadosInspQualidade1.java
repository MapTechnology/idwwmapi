package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsInspecaoManualDTO;

public class TrataRetornoSolDadosInspQualidade1 extends TrataRetorno {

	public TrataRetornoSolDadosInspQualidade1() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsInspecaoManualDTO rspInspecaoManual = Stubdelegate.getInstancia().getTr_InspecaoManual(this.ic.icupdto.getCdMaquina(), parametro.getDataHoraEvento());
		if (!rspInspecaoManual.getErro()) {
			Comando = "RESP;28;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + rspInspecaoManual.getInf02() + ";" + rspInspecaoManual.getInf03() + "; ; ; ; ; ; ;";
		}
		else {
			if(rspInspecaoManual.getIscomalertaprobqualidade() == true) {
				Comando = "RESP;28;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + rspInspecaoManual.getInf01() + "; ; ; ; ; ; ; ;";
			}
			else {
				if(rspInspecaoManual.getMsgErro() != null) {
					List<String> lines = this.ic.verificaTxtMensagem(rspInspecaoManual.getMsgErro());
					
					Comando = "RESP;28;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
					
					if (lines.size() >= 1) Comando += lines.get(0) + ";";
					else Comando += " ;";
					if (lines.size() >= 2) Comando += lines.get(1) + ";";
					else Comando += " ;";
					if (lines.size() >= 3) Comando += lines.get(2) + ";";
					else Comando += " ;";
					if (lines.size() >= 4) Comando += lines.get(3) + ";";
					else Comando += " ;";
					Comando += " ; ; ; ; ; ;";
				}
				else {
					Comando = "RESP;28;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
				}
			}
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
