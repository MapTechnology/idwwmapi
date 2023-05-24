package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoAlterarQuantidadeCartaoKanban extends TrataRetorno {

	public TrataRetornoAlterarQuantidadeCartaoKanban() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		boolean tipoAlteracao = false;
		String mensagemRetorno = "";
		String Comando = "";
		
		if(this.ic.icDadosRecebidos[10].equals("A")) {
			tipoAlteracao = true;
		}
		
		mensagemRetorno = Stubdelegate.getInstancia().alteraCartoesKanban(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icDadosRecebidos[11], tipoAlteracao);
		
		if(mensagemRetorno.equals("OK")) {
			Comando = "RESP;44;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;";
			if (tipoAlteracao == true)
				Comando += "1";	 //adicao de cartoes
			else
				Comando += "0";	 //remocao de cartoes
			Comando += "; ; ; ; ; ; ; ; ;";
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem(mensagemRetorno);
			
			Comando = "RESP;44;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
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
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
