package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsModDTO;

public class TrataRetornoConsulta extends TrataRetorno {

	public TrataRetornoConsulta() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(this.ic.icDadosRecebidos[10].equals("999")) {
			if (this.ic.icupdto.getListaLoginsEmAberto().size() > 0) {
				Comando = "RESP;19;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;Usuarios ;Logados;";
				for(IwsModDTO modin : this.ic.icupdto.getListaLoginsEmAberto()) {
					Comando += modin.getLogin() + " ;";
				}
				Comando += " ; ; ; ; ; ; ; ; ;";
			}
			else {
				Comando = "RESP;19;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;Sem ;usuarios ;Logados ; ; ; ; ; ; ;";
			}
		}
		else {
			IwsConsultaDTO rspConsulta = Stubdelegate.getInstancia().setTr_Consulta(this.ic.icDadosRecebidos[10], this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento());
			if (rspConsulta.getResposta()) {
				Comando = "RESP;19;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + rspConsulta.getCampoRSP1() + " ;" + rspConsulta.getCampoRSP2() + " ;" + rspConsulta.getCampoRSP3() + " ;" + rspConsulta.getCampoRSP4() + " ;" + rspConsulta.getCampoRSP5() + " ;" + rspConsulta.getCampoRSP6() + " ;" + rspConsulta.getCampoRSP7() + " ;" + rspConsulta.getCampoRSP8() + "; ;";
			}
			else {
				Comando = "RESP;19;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			}
		}
		
		// TODO Alessandre
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
