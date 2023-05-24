package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoExecutarInspQualidade1 extends TrataRetorno {

	public TrataRetornoExecutarInspQualidade1() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(Stubdelegate.getInstancia().setTr_InspecaoManual(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icDadosRecebidos[10], this.ic.icDadosRecebidos[11], this.ic.icDadosRecebidos[12])) {
			Comando = "RESP;29;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
		}
		else {
			Comando = "RESP;29;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
