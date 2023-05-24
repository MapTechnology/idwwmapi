package ms.coleta.ic.inova.trataretorno;

import injetws.model.excessoes.SemSGBDException;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;

public class TrataRetornoEntradaOpConfirmada extends TrataRetorno {
	
	public TrataRetornoEntradaOpConfirmada() {
	}
	
	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(Stubdelegate.getInstancia().confirmacaoOp(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icDadosRecebidos[10], this.ic.icupdto)) {
			if(this.ic.icDadosRecebidos[10] != null) {
				if(this.ic.icDadosRecebidos[10].equals("1")) {
					//lcupdto.setIsComApntSap("1");
					this.ic.icupdto.setStApntSap("1");
				}
				else {
					//lcupdto.setIsComApntSap("1");
					this.ic.icupdto.setStApntSap("0");
				}
			}
			else {
				this.ic.icupdto.setIsApntSapAtivo(null);
			}
			
			this.ic.icupdto.setIsSemPrograma(false);
			this.ic.icupdto.getDadosCIP().setIsEmCIP(false);
			this.ic.icupdto.setCp(this.ic.icupdto.getCpTemp());
			
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
			this.ic.enviaSetPrUpColetor(this.ic.icupdto);
			
			UtilsThreads.pausaNaThread(100);
			
			// TODO: ANDON PROCESSOFT - a fazer
//			if(isAndonPrcsftAtivo) {
//				oUpAndonPrcsftDTO = Stubdelegate.getInstancia().setTr_getPrUpAndonPrcsft(this.ic.icupdto.getIdUP());
//				if (oUpAndonPrcsftDTO != null)
//				{
//					if (oUpAndonPrcsftDTO.stRele7SldZero != null)
//					{									
//						setSaida("8", "0", "0", oUpAndonPrcsftDTO.tmpRele7LigSldZero.ToString(), oUpAndonPrcsftDTO.tmpRele7DesSldZero.ToString());
//					}
//					setSaida("6", oUpAndonPrcsftDTO.stRele6, "0", oUpAndonPrcsftDTO.tmpRele6Lig.ToString(), oUpAndonPrcsftDTO.tmpRele6Des.ToString());
//					setSaida("5", oUpAndonPrcsftDTO.stRele7, "0", oUpAndonPrcsftDTO.tmpRele7Lig.ToString(), oUpAndonPrcsftDTO.tmpRele7Des.ToString());
//					setSaida("4", oUpAndonPrcsftDTO.stRele8, "1", oUpAndonPrcsftDTO.tmpRele8Lig.ToString(), oUpAndonPrcsftDTO.tmpRele8Des.ToString());
//
//					//transformando valor para inteiro, com precisao de 2 casas decimais, para enviar ao coletor
//					int iTmpLimParNaoInf = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.tmpLimParNaoInf * 100.0)).ToString());
//					int iVlRefEficUltCiclo = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.vlRefEficUltCiclo * 100.0)).ToString());
//					setDado(lcupdto.idSubColetor, "1", iTmpLimParNaoInf.ToString());
//					setDado(lcupdto.idSubColetor, "2", iVlRefEficUltCiclo.ToString());
//				}
//			}
			
			Comando = "";
			Comando += "RESP;5;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;";
			Comando += " ; ; ; ; ; ; ; ; ;";
		}
		else
		{
			Comando = "";
			Comando += "RESP;5;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}
	
}
