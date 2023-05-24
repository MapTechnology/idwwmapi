package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoAlterarStatusApontSap extends TrataRetorno {

	public TrataRetornoAlterarStatusApontSap() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		Stubdelegate.getInstancia().alteraStatusApntSap(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icDadosRecebidos[10]);
		
		if(this.ic.icDadosRecebidos[10].equals("1")) {
			this.ic.icupdto.setStApntSap("1");
		}
		else {
			this.ic.icupdto.setStApntSap("0");
		}
		
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		String Comando = "";
		
		Comando = "RESP;43;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
