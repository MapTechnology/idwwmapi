package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsInspecaoManualDTO;

public class TrataRetornoSolInspQualidade2 extends TrataRetorno {

	public TrataRetornoSolInspQualidade2() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsInspecaoManualDTO respInspecao = Stubdelegate.getInstancia().getTr_SolicitaInspecaoManual(this.ic.icupdto.getIdUP());
		if(this.ic.ultimaInspecao.getPrupexecinspecao() != null && respInspecao.getPrupexecinspecao() != null) {
			if(respInspecao.getPrupexecinspecao().getIdInspecao() == this.ic.ultimaInspecao.getPrupexecinspecao().getIdInspecao()) {
				Comando = "RESP;311;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
				//caso já haja uma inspeção adicionada na tabela e ela coinscide com a inspeção anterior
			}
			else if(respInspecao.getIdUp() != this.ic.ultimaInspecao.getIdUp() && respInspecao.getPrupexecinspecao().getIdInspecao() != this.ic.ultimaInspecao.getPrupexecinspecao().getIdInspecao()) {
				Comando = "RESP;311;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
				//caso a última inspeção executada não seja da mesma máquina
			}
		}
		else {
			if(respInspecao.getErro() == false) {
				if(respInspecao.getInf02() != null && respInspecao.getInf02().equals("2")) {
					Comando = "RESP;311;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
					
					this.ic.enviaDado(Comando);
					UtilsThreads.pausaNaThread(10);
//					break;
					return;
					//se já existem dados na tabela, continuar inspeção
				}
				
				respInspecao = Stubdelegate.getInstancia().setTr_Inspecao(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento());
				
				if(respInspecao.getErro() == false) {
					Comando = "RESP;311;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
					//se não há erro
				}
				else {
					if(respInspecao.getInf02() != null && respInspecao.getInf02().equals("1")) {
						List<String> lines = this.ic.verificaTxtMensagem(respInspecao.getMsgErro());
						
						Comando = "RESP;311;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
						
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
					else {
						Comando = "RESP;311;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + respInspecao.getInf01() + "; ; ; ; ; ; ; ; ;";
					}
				}
			}
			else {
				Comando = "RESP;311;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + respInspecao.getInf01() + "; ; ; ; ; ; ; ; ;";
				if(respInspecao.getIscomalertaprobqualidade() == true) {
					this.ic.icupdto.setIsComAlertaProbQuali(true);
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
					this.ic.enviaSetPrUpColetor(this.ic.icupdto);
				}
				//havendo erro, envia código de erro
			}
		}
		
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
