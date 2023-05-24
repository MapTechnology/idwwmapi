package ms.coleta.ic.inova.trataretorno;

import java.util.Calendar;
import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inova.dto.INovaUpDTO;
import ms.util.UtilsThreads;
import injetws.model.IwsFacade;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsModDTO;

public class TrataRetornoValidarOperador extends TrataRetorno {

	public TrataRetornoValidarOperador() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		INovaUpDTO Oupdto = new INovaUpDTO();
		int indiceI = this.ic.Ups.size();
		boolean tudoOk = false;
		String msgFinal = "";
		IwsAutenticacaoDTO autenticacao = null;
		
		this.ic.icDadosRecebidos[10] = Stubdelegate.getInstancia().setZeroEsquerda(this.ic.icDadosRecebidos[10]);
		try
		{
			autenticacao = Stubdelegate.getInstancia().validaLogin(this.ic.icupdto, this.ic.icDadosRecebidos[10], this.ic.icDadosRecebidos[11], parametro.getDataHoraEvento(), 0,this.ic.isValidaPorDsUsuario);
		} catch(RegistroDesconhecidoException e) {
			Comando = "RESP;171;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
			return;
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
//		boolean stProdutoUsuario = getMsWs().getTr_stProdutoUsuario(Ups[0].idUP);
		boolean stProdutoUsuario = IwsFacade.getInstancia().getStProdutoUsuario(this.ic.Ups.get(0).getIdUP());
		
		if(autenticacao != null && autenticacao.getIsAutorizado()) {
			boolean islogin = false, naoEstaLogado;
			
			//verificar se esta ativo o stprodutoativo
			if (Integer.parseInt(this.ic.icDadosRecebidos[12]) == 1) islogin = true;
			IwsModDTO modo = new IwsModDTO();
			if (stProdutoUsuario) {
				tudoOk = false;
				msgFinal = "Esta funcao nao pode ser executada";
			}
			else {
				for(int i = 0; i < indiceI; i++) {
					naoEstaLogado = true;
					Oupdto = this.ic.Ups.get(i);
					if (Oupdto.getIsUpAtiva() && !Oupdto.getIsSemPrograma()) {
						
						if(islogin) {
							for(IwsModDTO modin : Oupdto.getListaLoginsEmAberto()) {
								if (modin.getLogin().equals(this.ic.icDadosRecebidos[10])) {
									naoEstaLogado = false;
								}
							}
							
							if(naoEstaLogado) {
								modo = new IwsModDTO();
								modo.setDthrLogin(autenticacao.getDtHrLogin());
								modo.setIdUsuario(autenticacao.getIdOperador());
								modo.setLogin(this.ic.icDadosRecebidos[10]);
								modo.setNome(autenticacao.getNomeOperador());
								
								Stubdelegate.getInstancia().setTr_EvntLogin(Oupdto.getIdUP(), this.ic.icDadosRecebidos[10], parametro.getDataHoraEvento());
								
//								Oupdto.addModDTO(modo);
//								this.ic.setUP(Oupdto.getIdSubColetor(), Oupdto);
								
								Comando = "SETLOG;" + Oupdto.getIdSubColetor().toString() + ";1;";
								
								this.ic.enviaDado(Comando);
								UtilsThreads.pausaNaThread(10);
								tudoOk = true;
							}
						}
						else if (Oupdto.getListaLoginsEmAberto().size() > 0) {
							for(IwsModDTO modin : Oupdto.getListaLoginsEmAberto()) {
								if (modin.getLogin().equals(this.ic.icDadosRecebidos[10])) {
									Calendar DthrLogin = Calendar.getInstance();
									DthrLogin.setTime(modin.getDthrLogin());
									
									Stubdelegate.getInstancia().setTr_EvntLogout(Oupdto.getIdUP(), this.ic.icDadosRecebidos[10], parametro.getDataHoraEvento(), DthrLogin);
//									Oupdto.removeModDTO(modin);
									
//									if(Oupdto.getListaOperadoresLogados().size() == 0) {
//										Comando = "SETLOG;" + Oupdto.getIdSubColetor().toString() + ";0;";
//										
//										this.ic.enviaDado(Comando);
//										UtilsThreads.pausaNaThread(10);
//									}
									tudoOk = true;
//									this.ic.setUP(Oupdto.getIdSubColetor(), Oupdto);
									break;
								}
							}
							
							Comando = "SETLOG;" + Oupdto.getIdSubColetor().toString() + ";0;";
							this.ic.enviaDado(Comando);
							UtilsThreads.pausaNaThread(10);
						}
					}
				}
			}
		}
		
		if(tudoOk) {
			Comando = "RESP;171;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
		else {
			if (stProdutoUsuario) {
				List<String> lines = this.ic.verificaTxtMensagem(msgFinal);
				Comando = "RESP;171;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
				if (lines.size() >= 1) Comando += lines.get(0) + ";";
				else Comando += " ;";
				if (lines.size() >= 2) Comando += lines.get(1) + ";";
				else Comando += " ;";
				if (lines.size() >= 3) Comando += lines.get(2) + ";";
				else Comando += " ;";
				if (lines.size() >= 4) Comando += lines.get(3) + ";";
				else Comando += " ;";
				Comando += " ; ; ; ; ; ;";
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
			}
			else {
				Comando = "RESP;171;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
			}
		}
	}

}
