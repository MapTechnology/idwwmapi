package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsRefugoDTO;

public class TrataRetornoFazerRefugo extends TrataRetorno {

	public TrataRetornoFazerRefugo() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(this.ic.icupdto.getCp().getProdutos() != null) {
			if (this.ic.icupdto.getCp().getProdutos().size() == 1) this.ic.icDadosRecebidos[14] = this.ic.icupdto.getCp().getProdutos().get(0).getCdReduzido();
			try {
				IwsRefugoDTO respRef = Stubdelegate.getInstancia().setTr_LancaRefugo(this.ic.icupdto, parametro.getDataHoraEvento(), this.ic.RefugoSendoInformado.getCdRefugo(), this.ic.icDadosRecebidos[10], this.ic.icDadosRecebidos[11], this.ic.icDadosRecebidos[15], this.ic.icDadosRecebidos[14]);
				if (respRef.getIsRefugoValido()) {
					Comando = "RESP;12;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + respRef.getCdRefugo() + "; ; ; ; ; ; ; ";
//					this.ic.icupdto.getUltimoRefugoAtual().copyRefugoDTOWS(respRef);
					this.ic.icupdto.setUltimoRefugoAtual(respRef);
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
				}
				else {
					Comando = "RESP;12;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ";
				}
			} catch (Exception e) {
				e.printStackTrace();
				
				Comando = "RESP;12;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			}
		}
		else {
			Comando = "RESP;12;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
