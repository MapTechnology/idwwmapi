package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import idw.model.IdwFacade;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsRefugoDTO;

public class TrataRetornoValidarRefugo extends TrataRetorno {

	public TrataRetornoValidarRefugo() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		try {
			this.ic.RefugoSendoInformado = IdwFacade.getInstancia().getTr_ValidaCodRefugo(this.ic.icupdto.getUp(), this.ic.icDadosRecebidos[10]);
		} catch(Exception e) {
			this.ic.RefugoSendoInformado = new IwsRefugoDTO();
			this.ic.RefugoSendoInformado.setIsRefugoValido(false);
		}
		
		if(!(this.ic.RefugoSendoInformado.getIsRefugoValido())) {
			Comando = "RESP;121;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";						
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
			return;
		}
		
		int rcausaref = 0, racaoref = 0, rjustref = 0, rprod = 0;
		if(this.ic.RefugoSendoInformado.getPedeAcao()) racaoref = 1;
		if(this.ic.RefugoSendoInformado.getPedeCausa()) rcausaref = 1;
		if(this.ic.RefugoSendoInformado.getPedeJust()) rjustref = 1;
		if(this.ic.icupdto.getCp().getProdutos() != null && this.ic.icupdto.getCp().getProdutos().size() > 1)
			rprod = 1;
		
		Comando = "RESP;121;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + rcausaref + ";" + racaoref + " ;" + rjustref + " ;" + rprod + " ; ; ; ; ;";
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
