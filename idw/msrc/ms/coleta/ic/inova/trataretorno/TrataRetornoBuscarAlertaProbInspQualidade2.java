package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsErroDTO;

public class TrataRetornoBuscarAlertaProbInspQualidade2 extends TrataRetorno {

	public TrataRetornoBuscarAlertaProbInspQualidade2() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsErroDTO resultado = Stubdelegate.getInstancia().buscaAlertaQualiAberto(this.ic.icupdto.getCdMaquina());
		
		if(resultado.getSucesso()) {
			Comando += "RESP;421;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + "; ; ; ; ; ; ; ; ; ;";
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem(resultado.getMensagem());
			Comando = "RESP;421;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
			if (lines.size() >= 1) Comando += lines.get(0) + ";";
			else Comando += " ;";
			if (lines.size() >= 2) Comando += lines.get(1) + ";";
			else Comando += " ;";
			if (lines.size() >= 3) Comando += lines.get(2) + ";";
			else Comando += " ;";
			if (lines.size() >= 4) Comando += lines.get(3) + ";";
			else Comando += " ;";
			Comando += " ; ; ; ; ; ;";
			//Comando += "RESP;421;" + lcupdto.idSubColetor.ToString() + ";0;" + resultado + "; ; ; ; ; ; ; ; ; ;";
			this.ic.icupdto.setIsComAlertaProbQuali(true);
			
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
			this.ic.enviaSetPrUpColetor(this.ic.icupdto);
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
