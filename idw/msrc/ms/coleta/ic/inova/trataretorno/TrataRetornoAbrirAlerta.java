package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAlertaDTO;

public class TrataRetornoAbrirAlerta extends TrataRetorno {

	public TrataRetornoAbrirAlerta() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if(!this.ic.icDadosRecebidos[10].equals("QLD001")) {
			this.ic.icDadosRecebidos[10] = Stubdelegate.getInstancia().setZeroEsquerda(this.ic.icDadosRecebidos[10]);
			
			if(this.ic.icupdto.getListaAlertasEmAberto() != null) {
				for(IwsAlertaDTO alertascan : this.ic.icupdto.getListaAlertasEmAberto()) {
					if (alertascan.getCdAlerta().equals(this.ic.icDadosRecebidos[10]))
					{
						Comando = "RESP;15;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1;" + Stubdelegate.getInstancia().setZeroEsquerda(this.ic.icDadosRecebidos[10]) + "; ; ; ; ; ; ; ;";
						
						this.ic.enviaDado(Comando);
						UtilsThreads.pausaNaThread(10);
						return;
					}
				}
			}
			
			IwsAlertaDTO respale = Stubdelegate.getInstancia().validaAlerta(this.ic.icupdto, this.ic.icDadosRecebidos[10], parametro.getDataHoraEvento());
			
			if((respale == null) || (respale.getCdAlerta() == null) || (respale.getCdAlerta().equals(""))) {
				Comando = "RESP;15;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
				// TODO Alessandre
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
				return;
			}
			
			Stubdelegate.getInstancia().alertaInicio(this.ic.icupdto.getIdUP(), this.ic.icDadosRecebidos[10], parametro.getDataHoraEvento());
			
			Comando = "RESP;15;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;0; ; ; ; ; ; ; ; ;";
			
//			IwsAlertaDTO alertadto = new IwsAlertaDTO();
////			alertadto.copyAlertaDTOWs(respale);
//			alertadto = respale;
////			alertadto.DthrIAlerta = DtHrEvento;
//			alertadto.setdthrinialerta(parametro.getDataHoraEvento().getTime());
//			
//			this.ic.icupdto.addAlertaDTO(alertadto);
			
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		}
		else {
			Comando = "RESP;15;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		// TODO Alessandre
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
