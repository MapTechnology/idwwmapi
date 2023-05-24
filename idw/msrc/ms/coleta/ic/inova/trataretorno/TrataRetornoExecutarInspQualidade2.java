package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsErroDTO;

public class TrataRetornoExecutarInspQualidade2 extends TrataRetorno {

	public TrataRetornoExecutarInspQualidade2() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		IwsErroDTO erros = new IwsErroDTO();
		
		//se a leitura for efetuada corretamente, envia evento 32
		this.ic.ultimaInspecao.getPrupexecinspecao().setStExecucao('2'); // TODO: aqui eh um char, no c# eh um ushort... verificar se funciona normal
		
		String Comando = "";
		
		try {
			erros = Stubdelegate.getInstancia().finalizaInspecao(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.ultimaInspecao);
		} catch(Exception e) {
			Comando += "RESP;32;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + "; ; ; ; ; ; ; ; ; ;";
		}
		
		if (erros.getSucesso() == true)
			Comando += "RESP;32;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + "; ; ; ; ; ; ; ; ; ;";
		else {
			List<String> lines = this.ic.verificaTxtMensagem(erros.getMensagem());
			
			Comando = "RESP;32;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
			
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
		
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
