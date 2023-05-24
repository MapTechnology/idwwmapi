package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAutenticacaoDTO;

public class TrataRetornoValidarLoginFimCip extends TrataRetorno {

	public TrataRetornoValidarLoginFimCip() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		this.ic.icDadosRecebidos[10] = Stubdelegate.getInstancia().setZeroEsquerda(this.ic.icDadosRecebidos[10]);
		IwsAutenticacaoDTO autenticaLogin = null;
		
		try {
			autenticaLogin = Stubdelegate.getInstancia().validaLogin(this.ic.icupdto, this.ic.icDadosRecebidos[10], this.ic.icDadosRecebidos[11], parametro.getDataHoraEvento(), 0,this.ic.isValidaPorDsUsuario);
		} catch(RegistroDesconhecidoException e) {
			Comando = "RESP;271;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
			return;
		}
		
		if(autenticaLogin.getIsAutorizado()) {
			Comando = "RESP;271;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
		}
		else {
			Comando = "RESP;271;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
