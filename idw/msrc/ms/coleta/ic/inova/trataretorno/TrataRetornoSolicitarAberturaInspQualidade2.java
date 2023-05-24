package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsErroDTO;

public class TrataRetornoSolicitarAberturaInspQualidade2 extends TrataRetorno {

	public TrataRetornoSolicitarAberturaInspQualidade2() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsErroDTO errodto = new IwsErroDTO();
		errodto = Stubdelegate.getInstancia().setTr_lancaAberturaInspecao(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento());
		if (errodto.getSucesso()) {
			Comando += "RESP;41;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + "; ; ; ; ; ; ; ; ; ;";
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem(errodto.getMensagem());
			
			Comando = "RESP;41;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
			if(lines.size() >= 1) Comando += lines.get(0) + ";";
			else Comando += " ;";
			if(lines.size() >= 2) Comando += lines.get(1) + ";";
			else Comando += " ;";
			if(lines.size() >= 3) Comando += lines.get(2) + ";";
			else Comando += " ;";
			if(lines.size() >= 4) Comando += lines.get(3) + ";";
			else Comando += " ;";
			Comando += " ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
