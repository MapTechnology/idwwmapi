package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsParadaDTO;

public class TrataRetornoInfoParadaPreConfig extends TrataRetorno {

	public TrataRetornoInfoParadaPreConfig() {
	}
	
	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsCicloDTO cicloCorrente = new IwsCicloDTO();
		
		//lan�a abertura de parada no BD
		//boolean isparadaauto = false;
		if(this.ic.icupdto.getUltimaParadaAtual() == null) {
			this.ic.icupdto.setUltimaParadaAtual(new IwsParadaDTO());
			this.ic.icupdto.getUltimaParadaAtual().setIsPersistente(false);
			this.ic.icupdto.getUltimaParadaAtual().setIsRegulagem(false);
		}
		
		cicloCorrente = Stubdelegate.getInstancia().setTr_LancaParada(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), false, false, log, idLog);
		this.ic.icupdto.setIsParadaEmAberto(true);
		
		if (cicloCorrente.getCicloValido()) {
			this.ic.icupdto.setNumeroDeCiclos(cicloCorrente.getNumeroCiclosCont());
			Comando = "";
			Comando = "SETCIC;" + this.ic.icupdto.getIdSubColetor().toString() + ";" + this.ic.icupdto.getNumeroDeCiclos() + ";";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}

		this.ic.icupdto.getUltimaParadaAtual().setCdParada("999999");
		this.ic.icupdto.getUltimaParadaAtual().setIsPodeAlterarCdPar(true);
		this.ic.icupdto.getUltimaParadaAtual().setIsRegulagem(false);
		this.ic.icupdto.setPedirParada(true);
		this.ic.icupdto.setIsEmRegulagem(false);

		this.ic.icupdto.getUltimaParadaAtual().setDthrIparada(parametro.getDataHoraEvento().getTime());
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		//valida c�digo da parada pr�-configurada
		IwsParadaDTO resposta = null;
		this.ic.icDadosRecebidos[11] = Stubdelegate.getInstancia().setZeroEsquerda(this.ic.icDadosRecebidos[11]);
		
		try {
			if(this.ic.icupdto.getUltimaParadaAtual() != null) {
				resposta = Stubdelegate.getInstancia().validaParada(this.ic.icupdto, this.ic.icDadosRecebidos[11]);
				
				if(resposta.getIsRegulagem() || resposta.getIsPersistente()) {
					this.ic.icDadosRecebidos[11] = "999999";
				}
			}
			
			this.ic.icupdto.setTmpIsPesanaeficiencia(resposta.getIsPesaCalculo());
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		} catch(Exception e) {
			e.printStackTrace();
//			pnldto.IdUp = idup;
//			pnldto.Log = util.ObtemDataLocalParaLog() + "Ao Lan�ar CICLO (81)";
//			if (e != null && e.Message != null)
//				pnldto.Log += e.Message;
//			SetPnlDTO();
		
			resposta = new IwsParadaDTO();
			resposta.setCdParada("");
			this.ic.icDadosRecebidos[11] = "999999";
		}
		
		//lan�a motivo de parada no BD
		String tipoParPreConfig;
		if(this.ic.icDadosRecebidos[12] != null && this.ic.icDadosRecebidos[12].equals("1"))
			tipoParPreConfig = "Entrada 7";
		else
			tipoParPreConfig = "Entrada 6";
		
		boolean motPar = Stubdelegate.getInstancia().setTr_MotivoParadaPreConfig(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(),
				this.ic.icDadosRecebidos[11], // codigo de parada
				"", // acao
				"", // causa
				"", // justificativa
				"", // tecnico responsavel
				"", // tecnico um
				"", // tecnico dois
				"", // local Parada
				false,// parada de regulagem
				tipoParPreConfig); //entrada que gerou o sinal de parada
		
		if(motPar == true) {
			this.ic.icupdto.getUltimaParadaAtual().setIsRegulagem(false);
			this.ic.icupdto.getUltimaParadaAtual().setIsPersistente(false);
			this.ic.icupdto.getUltimaParadaAtual().setCdParada(this.ic.icDadosRecebidos[11]);
			this.ic.icupdto.getUltimaParadaAtual().setIsPesaCalculo(this.ic.icupdto.isTmpIsPesanaeficiencia());
			
			String parada = this.ic.icDadosRecebidos[11];
			//Comando = "RESP;81;" + lcupdto.idSubColetor.ToString() + ";1;" + parada;
			//Comando = "RESP;45;" + lcupdto.idSubColetor.ToString() + ";1;" + parada;
			Comando = "SETPARADA;" + this.ic.icupdto.getIdSubColetor().toString() + ";" + parada + ";" + "0" + ";";
			
			if(this.ic.icDadosRecebidos[11].equals("999999")) {
				Comando += "Parada nao informada;";
			}
			else {
				Comando += resposta.getDsParada() + ";";
			}
			
			Comando += ";;;;;;;;";
			
			this.ic.icupdto.setPedirParada(false);
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		}
		else
		{
			Comando = "SETPARADA;" + this.ic.icupdto.getIdSubColetor().toString() + ";999999;0;Parada nao informada;";
			Comando += ";;;;;;;;";
			this.ic.icupdto.setPedirParada(false);
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
