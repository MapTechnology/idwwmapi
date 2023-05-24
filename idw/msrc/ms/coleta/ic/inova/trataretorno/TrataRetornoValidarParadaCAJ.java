package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsErroDTO;

public class TrataRetornoValidarParadaCAJ extends TrataRetorno {

	public TrataRetornoValidarParadaCAJ() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		try {
			IwsErroDTO erroCAJ;
			
			erroCAJ = Stubdelegate.getInstancia().validaCAJ(this.ic.icDadosRecebidos[11], this.ic.icDadosRecebidos[10], this.ic.icDadosRecebidos[12], this.ic.icupdto.getIdUP(), this.ic.ParadaSendoInformada);
			
			if(erroCAJ.getSucesso()) {
				this.ic.ParadaSendoInformada.setCdAcao(this.ic.icDadosRecebidos[10]);
				this.ic.ParadaSendoInformada.setCdCausa(this.ic.icDadosRecebidos[11]);
				this.ic.ParadaSendoInformada.setCdJustificativa(this.ic.icDadosRecebidos[12]);
				Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1;0; ; ; ; ; ; ; ;";
			}
			else {
				Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
				Comando += erroCAJ.getMensagem();
				Comando += " ; ; ; ; ; ;";
			}
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
