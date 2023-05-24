package ms.coleta.ic.inova.trataretorno;

//import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
//import ms.coleta.ic.inova.dto.INovaReleDTO;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
//import injetws.webservices.dto.IwsAlertaDTO;
//import injetws.webservices.dto.IwsReleDTO;

public class TrataRetornoFecharAlerta extends TrataRetorno {

	public TrataRetornoFecharAlerta() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
//		IwsReleDTO infoLocalRele = new IwsReleDTO();
//		INovaReleDTO localRele = new INovaReleDTO();
//		IwsAlertaDTO alertaToRemove = new IwsAlertaDTO();
		
		if(!this.ic.icDadosRecebidos[10].equals("QLD001")) { //vlauria 20100322
			if (Stubdelegate.getInstancia().FechaAlerta(this.ic.icupdto.getIdUP(), this.ic.icDadosRecebidos[10], parametro.getDataHoraEvento())) {
//				List<IwsAlertaDTO> listaAlertasAbertos = this.ic.icupdto.getListaAlertasAbertos();
//				
//				for(IwsAlertaDTO alertascan : listaAlertasAbertos) {
//					if (alertascan.getCdAlerta().equals(this.ic.icDadosRecebidos[10])) {
//						this.ic.icupdto.removeAlertaDTO(alertascan);
////						alertaToRemove = alertascan;
//						break;
//					}
//				}
				
				this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
				Comando = "RESP;16;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
			}
			else
				Comando = "RESP;16;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		else {
			Comando = "RESP;16;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		// TODO Alessandre
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
