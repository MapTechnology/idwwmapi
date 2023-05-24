package ms.coleta.ic.inova.trataretorno;

import java.util.Calendar;
import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsModDTO;

public class TrataRetornoLogoutOperador extends TrataRetorno {

	public TrataRetornoLogoutOperador() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		List<IwsModDTO> listaOpLogados = this.ic.icupdto.getListaLoginsEmAberto();
		
		for(IwsModDTO modin : listaOpLogados) {
			if(modin.getLogin().equals(this.ic.icDadosRecebidos[10])) {
				Calendar DthrLogin = Calendar.getInstance();
				DthrLogin.setTime(modin.getDthrLogin());
				
				Stubdelegate.getInstancia().setTr_EvntLogout(this.ic.icupdto.getIdUP(), this.ic.icDadosRecebidos[10], parametro.getDataHoraEvento(), DthrLogin);
				
//				this.ic.icupdto.removeModDTO(modin);
				break;
			}
		}
		
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		if(this.ic.icupdto.getListaLoginsEmAberto().size() == 0) {
			Comando = "SETLOG;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
		
		Comando = "RESP;18;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
