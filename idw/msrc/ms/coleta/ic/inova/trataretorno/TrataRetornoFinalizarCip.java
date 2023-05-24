package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoFinalizarCip extends TrataRetorno {

	public TrataRetornoFinalizarCip() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(Stubdelegate.getInstancia().setTr_FimCIP(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(),null)) { //lanca evento fim de CIP
			this.ic.icupdto.getDadosCIP().setIsEmCIP(false);
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
			Comando = "RESP;27;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
		else {
			Comando = "RESP;27;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
	}

}
