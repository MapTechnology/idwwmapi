package ms.coleta.ic.inova.trataretorno;

import java.util.Calendar;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoCancelarRefugo extends TrataRetorno {

	public TrataRetornoCancelarRefugo() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(this.ic.icupdto.getUltimoRefugoAtual() != null) {
			try {
				Calendar DthrUltRefugo = Calendar.getInstance();
				DthrUltRefugo.setTime(this.ic.icupdto.getUltimoRefugoAtual().getDthrUltRefugo());
				
				if(Stubdelegate.getInstancia().setTr_ApagaUltimoRefugo(this.ic.icupdto.getUltimoRefugoAtual().getCdRefugo(),
						this.ic.icupdto.getUltimoRefugoAtual().getIdReduzidaProd(),
						DthrUltRefugo,
						String.valueOf(this.ic.icupdto.getUltimoRefugoAtual().getMilissegundos()),
						this.ic.icupdto, parametro.getDataHoraEvento()))
				{
					Comando = "RESP;14;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
					this.ic.icupdto.getUltimoRefugoAtual().setCdRefugo(null);
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
				}
				else {
					Comando = "RESP;14;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
				}
			} catch (Exception e) {
				e.printStackTrace();
				
				log.info(idLog, 0, "Erro ao Lançar Cancela Refugo (14)");
				log.info(idLog, 0, " Erro tentar apagar refugo " + this.ic.icupdto.getUltimoRefugoAtual().getCdRefugo() + ":" + this.ic.icupdto.getUltimoRefugoAtual().getIdReduzidaProd());
				
				Comando = "RESP;14;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			}
		}
		else
		{
			Comando = "RESP;14;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			this.ic.enviaSetPrUpColetor(this.ic.icupdto);
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
