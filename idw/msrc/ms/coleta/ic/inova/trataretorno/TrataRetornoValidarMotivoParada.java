package ms.coleta.ic.inova.trataretorno;

import java.util.Calendar;

import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsParadaDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import idw.webservices.MswsComEvt;

public class TrataRetornoValidarMotivoParada extends TrataRetorno {
	MswsComEvt ms = new MswsComEvt();
	public TrataRetornoValidarMotivoParada() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		this.ic.ParadaSendoInformada = null;
		boolean isParadaValida = true;
		this.ic.ParadaSendoInformada = new IwsParadaDTO();
		String comandoResposta = "";
		
		try {
			if(this.ic.icupdto.getUltimaParadaAtual() != null) {
				
				if(!this.ic.icupdto.getUltimaParadaAtual().getIsPodeAlterarCdPar()) {
					Calendar DthrIparada = Calendar.getInstance();
					DthrIparada.setTime(this.ic.icupdto.getUltimaParadaAtual().getDthrIparada());
					
					Stubdelegate.getInstancia().GeraLogRecusaParada("91-N�o � permitido alterar o Cd desta Parada", this.ic.icupdto.getIdUP(), DthrIparada, this.ic.icDadosRecebidos[10], log, idLog);
					comandoResposta = "RESP;91;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
					
					this.ic.enviaDado(comandoResposta);
					UtilsThreads.pausaNaThread(10);
					return;
				}
				
				this.ic.ParadaSendoInformada = ms.getTr_TabParadaSetaCod(this.ic.icupdto.getUp(), this.ic.icDadosRecebidos[10]);
				if(this.ic.ParadaSendoInformada.getIsRegulagem() != this.ic.icupdto.getUltimaParadaAtual().getIsRegulagem()) {
					isParadaValida = false;
					if (this.ic.icupdto.getUltimaParadaAtual().getCdParada().equals("999999")) {
						if (this.ic.icupdto.getIsParadaEmAberto()) isParadaValida = true;
					}
				}
			}
		} catch(Exception e) {
			this.ic.ParadaSendoInformada = new IwsParadaDTO();
			this.ic.ParadaSendoInformada.setCdParada("");
		}
		
		if(this.ic.ParadaSendoInformada.getCdParada().equals("") || !isParadaValida) {
			String motivo = "";
			
			if(!isParadaValida)
				motivo = " FlagFalse ";
			else
				motivo = " CdParadaVazio ";
			
			Calendar DthrIparada = Calendar.getInstance();
			DthrIparada.setTime(this.ic.icupdto.getUltimaParadaAtual().getDthrIparada());
			
			Stubdelegate.getInstancia().GeraLogRecusaParada("91-C�digo de Parada Inv�lido-" + motivo, this.ic.icupdto.getIdUP(), DthrIparada, this.ic.icDadosRecebidos[10], log, idLog);
			comandoResposta = "RESP;91;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			
			this.ic.enviaDado(comandoResposta);
			UtilsThreads.pausaNaThread(10);
			return;
		}
		
		int rcausa = 0, racao = 0, rjust = 0, rtec1 = 0, rtec2 = 0, rtecresp = 0, isreg = 0, ispersistent = 0;
		if(this.ic.ParadaSendoInformada.getIsPedeCausa()) rcausa = 1;
		if(this.ic.ParadaSendoInformada.getIsPedeAcao()) racao = 1;
		if(this.ic.ParadaSendoInformada.getIsPedeJust()) rjust = 1;
		if(this.ic.ParadaSendoInformada.getIsTecnicoArea()) rtecresp = 1;
		if(this.ic.ParadaSendoInformada.getQtMinimaTecnicos() >= 2) {
			rtec2 = 1;
			// Alessandre em 5-4-16 removi a substracao abaixo, nao entendi a nece
			this.ic.ParadaSendoInformada.setQtMinimaTecnicos(this.ic.ParadaSendoInformada.getQtMinimaTecnicos() - 2);// -= 2;
		}
		if(this.ic.ParadaSendoInformada.getQtMinimaTecnicos() == 1) rtec1 = 1;
		if(this.ic.ParadaSendoInformada.getIsRegulagem()) isreg = 1;
		if(this.ic.ParadaSendoInformada.getIsPersistente()) ispersistent = 1;
		
		if (isreg == 1 && ispersistent == 1) {
			ispersistent = 0;
		}
		
		this.ic.icupdto.setTmpIsPesanaeficiencia(this.ic.ParadaSendoInformada.getIsPesaCalculo());
		this.ic.icupdto.setTmpDsParada(this.ic.ParadaSendoInformada.getDsParada());
		this.ic.icupdto.setTmpPermiteAlterar(this.ic.ParadaSendoInformada.getIsPodeAlterarCdPar());
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		comandoResposta = "RESP;91;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + this.ic.ParadaSendoInformada.getCdParada() + ";" + rcausa + ";" + racao + ";" + rjust + ";" + rtec1 + ";" + rtec2 + ";" + rtecresp + ";" + isreg + ";" + ispersistent + ";" + this.ic.ParadaSendoInformada.getDsParada() + ";";

		this.ic.enviaDado(comandoResposta);
	}

}
