package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsInspecaoManualDTO;

public class TrataRetornoSolDadosInspQualidade2 extends TrataRetorno {

	public TrataRetornoSolDadosInspQualidade2() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		IwsInspecaoManualDTO dadosInspecao = Stubdelegate.getInstancia().getTr_DadosInspecao(this.ic.icupdto.getIdUP());
		
		String Comando = "";
		if(dadosInspecao != null) {
			if(dadosInspecao.getErro() == true && dadosInspecao.getInf02() != null && dadosInspecao.equals("2")) {
				List<String> lines = this.ic.verificaTxtMensagem(dadosInspecao.getMsgErro());
				
				Comando = "RESP;31;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
				
				if (lines.size() >= 1) Comando += lines.get(0) + ";";
				else Comando += " ;";
				if (lines.size() >= 2) Comando += lines.get(1) + ";";
				else Comando += " ;";
				if (lines.size() >= 3) Comando += lines.get(2) + ";";
				else Comando += " ;";
				if (lines.size() >= 4) Comando += lines.get(3) + ";";
				else Comando += " ;";
				Comando += " ; ; ; ; ; ;";
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
//				break;
				return;
			}
			
			if(dadosInspecao.getPrupexecinspecao() == null) {
				Comando = "RESP;31;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;20; ; ; ; ; ; ; ; ;";
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
//				break;
				return;
			}
			
			this.ic.ultimaInspecao = dadosInspecao;
			this.ic.idupUltimaInspec = this.ic.icupdto.getIdUP();
			
			// set Inspecao no coletor
			Comando = this.ic.setInsPec(this.ic.icupdto, dadosInspecao);
		}
		else
		{
			Comando = "RESP;31;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;20; ; ; ; ; ; ; ; ;";
		}
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
