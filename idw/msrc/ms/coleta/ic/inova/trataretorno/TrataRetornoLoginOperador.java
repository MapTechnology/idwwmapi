package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsModDTO;

public class TrataRetornoLoginOperador extends TrataRetorno {

	public TrataRetornoLoginOperador() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		this.ic.icDadosRecebidos[10] = Stubdelegate.getInstancia().setZeroEsquerda(this.ic.icDadosRecebidos[10]);
		
		IwsAutenticacaoDTO autenticacao = null;
		
		try {
			autenticacao = Stubdelegate.getInstancia().validaLogin(this.ic.icupdto, this.ic.icDadosRecebidos[10], this.ic.icDadosRecebidos[11], parametro.getDataHoraEvento(), 0,this.ic.isValidaPorDsUsuario);
		} catch (RegistroDesconhecidoException e) {
			Comando = "RESP;17;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
			return;
		}
		
		if(autenticacao != null && autenticacao.getIsAutorizado()) {
			List<IwsModDTO> listaOpLogados = this.ic.icupdto.getListaLoginsEmAberto();
			
			for(IwsModDTO modin : listaOpLogados) {
				if (modin.getLogin().equals(this.ic.icDadosRecebidos[10]))
				{
					Comando = "RESP;17;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1;" + this.ic.icDadosRecebidos[10] + "; ; ; ; ; ; ; ;";
					// TODO Alessandre
					
					this.ic.enviaDado(Comando);
					UtilsThreads.pausaNaThread(10);
					return;
				}
			}
			
			IwsModDTO mod = new IwsModDTO();
			mod.setDthrLogin(autenticacao.getDtHrLogin());
			mod.setIdUsuario(autenticacao.getIdOperador());
			mod.setLogin(this.ic.icDadosRecebidos[10]);
			mod.setNome(autenticacao.getNomeOperador());
			
			// TODO: so pode haver UM!!
//			if(Gerente.getInstancia().SoPodeHaverUM) {
//				//Efetua Logout de todos os operadores
//				for(IwsModDTO modin : this.ic.icupdto.getListaLoginsEmAberto()) {
//						Stubdelegate.getInstancia().setTr_EvntLogout(this.ic.icupdto.getIdUP(), modin.login, parametro.getDataHoraEvento(), modin.dthrLogin);
//				}
				// TODO: Atualizar lista de Logins em aberto
//			}
			
			IwsErroDTO erroDTO = Stubdelegate.getInstancia().setTr_EvntLogin(this.ic.icupdto.getIdUP(), this.ic.icDadosRecebidos[10], parametro.getDataHoraEvento());
			
			if (erroDTO.getSucesso()) {
//				this.ic.icupdto.addModDTO(mod);
//				this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
				Comando = "SETLOG;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;";
				UtilsThreads.pausaNaThread(10);
				
				this.ic.enviaDado(Comando);
				Comando = "RESP;17;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;0;; ; ; ; ; ; ; ;";
			}
			else {
				log.info(idLog, 0, erroDTO.getMensagem());
				
				List<String> lines = this.ic.verificaTxtMensagem(erroDTO.getMensagem());
				
				Comando = "RESP;17;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
				
				if (lines.size() >= 1) Comando += lines.get(0) + ";";
				else Comando += " ;";
				if (lines.size() >= 2) Comando += lines.get(1) + ";";
				else Comando += " ;";
				if (lines.size() >= 3) Comando += lines.get(2) + ";";
				else Comando += " ;";
				if (lines.size() >= 4) Comando += lines.get(3) + ";";
				else Comando += " ;";
				Comando += " ; ; ; ; ; ;";
			}
			
		}
		else
			Comando = "RESP;17;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
