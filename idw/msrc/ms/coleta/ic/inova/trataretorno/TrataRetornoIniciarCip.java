package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoIniciarCip extends TrataRetorno {

	public TrataRetornoIniciarCip() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(Stubdelegate.getInstancia().setTr_IniCIP(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.TecnicoCIP)) { //lanca evento inicio de CIP
			
			this.ic.icupdto.getDadosCIP().setIsEmCIP(true);
			this.ic.icupdto.getDadosCIP().setIsCIPPendente(false);
			this.ic.icupdto.getDadosCIP().setDtHrInicio(parametro.getDataHoraEvento().getTime());
			
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
			
			Comando = "RESP;26;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
		else {
			Comando = "RESP;26;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
	}

}
