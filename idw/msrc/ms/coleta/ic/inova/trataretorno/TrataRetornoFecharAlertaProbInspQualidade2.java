package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
//import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsErroDTO;

public class TrataRetornoFecharAlertaProbInspQualidade2 extends TrataRetorno {

	public TrataRetornoFecharAlertaProbInspQualidade2() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		IwsErroDTO answer = new IwsErroDTO();
		String Comando = "";
		
		answer = Stubdelegate.getInstancia().encerraAlertaProbQuali(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.cdUserAlerQuali);
		
		if (answer.getSucesso() == true) {
			this.ic.icupdto.setIsComAlertaProbQuali(false);
			
			Comando = "RESP;42;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
			
//			List<IwsAlertaDTO> listaAlertasAbertos = this.ic.icupdto.getListaAlertasAbertos();
//			
//			for(IwsAlertaDTO alertascan : listaAlertasAbertos) {
//				if (alertascan.getCdAlerta().equals("QLD001")) {
//					this.ic.icupdto.removeAlertaDTO(alertascan);
////					alertaToRemove = alertascan;
//					break;
//				}
//			}
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem(answer.getMensagem());
			Comando = "RESP;42;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
			if (lines.size() >= 1) Comando += lines.get(0) + ";";
			else Comando += " ;";
			if (lines.size() >= 2) Comando += lines.get(1) + ";";
			else Comando += " ;";
			if (lines.size() >= 3) Comando += lines.get(2) + ";";
			else Comando += " ;";
			if (lines.size() >= 4) Comando += lines.get(3) + ";";
			else Comando += " ;";
			Comando += " ; ; ; ; ; ;";
			this.ic.icupdto.setIsComAlertaProbQuali(true);
			//Comando = "RESP;42;" + lcupdto.idSubColetor.ToString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		this.ic.enviaSetPrUpColetor(this.ic.icupdto);
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
