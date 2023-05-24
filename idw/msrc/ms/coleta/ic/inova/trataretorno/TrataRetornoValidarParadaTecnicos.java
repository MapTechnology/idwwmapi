package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.util.UtilsThreads;
import injetws.model.IwsFacade;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoValidarParadaTecnicos extends TrataRetorno {

	public TrataRetornoValidarParadaTecnicos() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		try {
			//Valida TEcnico 1
			if(this.ic.icDadosRecebidos[10] == "1") {
				boolean resultado94 = IwsFacade.getInstancia().getTr_ValidaLoginSenha(this.ic.icDadosRecebidos[11], this.ic.icDadosRecebidos[12], 3);
				if(resultado94) {
					this.ic.ParadaSendoInformada.setCdTecnicoUm(this.ic.icDadosRecebidos[11]);
					Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1;1;" + this.ic.icDadosRecebidos[10] + "; ; ; ; ; ; ; ; ;";
				}
				else {
					Comando = "RESP;93;"+this.ic.icupdto.getIdSubColetor().toString()+";1;0;0;;;;;;;;;;";
				}
			}
			else if (this.ic.icDadosRecebidos[10] == "2") { //Valida Tecnico 2
				boolean resultado94 = IwsFacade.getInstancia().getTr_ValidaLoginSenha(this.ic.icDadosRecebidos[11], this.ic.icDadosRecebidos[12], 4);
				if (resultado94) {
					this.ic.ParadaSendoInformada.setCdTecnicoDois(this.ic.icDadosRecebidos[11]);
					Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1;" + this.ic.icDadosRecebidos[10] + "; ; ; ; ; ; ; ; ;";
				}
				else
				{
					Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;0;0;;;;;;;;;;";
				}
			}
			else if (this.ic.icDadosRecebidos[10] == "3") { //Valida Tecnico Responsavel
				boolean resultado94 = IwsFacade.getInstancia().getTr_ValidaLoginSenha(this.ic.icDadosRecebidos[11], this.ic.icDadosRecebidos[12], 5);
				
				if(resultado94) {
					this.ic.ParadaSendoInformada.setCdTecnicoResponsavel(this.ic.icDadosRecebidos[11]);
					Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1;" + this.ic.icDadosRecebidos[10] + "; ; ; ; ; ; ; ; ;";
				}
				else {
					Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;0;0;;;;;;;;;;";
				}
			}
			else //Envio um evento desconhecido
			{
				Comando = "RESP;93;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;0;;;;;;;;;;";
			}
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
