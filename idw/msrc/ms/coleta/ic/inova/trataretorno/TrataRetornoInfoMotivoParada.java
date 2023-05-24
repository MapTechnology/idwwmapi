package ms.coleta.ic.inova.trataretorno;

import idw.webservices.MswsComEvt;
import injetws.model.excessoes.SemSGBDException;

import java.util.Calendar;

import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;

public class TrataRetornoInfoMotivoParada extends TrataRetorno {
	MswsComEvt ms = new MswsComEvt();
	public TrataRetornoInfoMotivoParada() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		int ispersist = 0;
		int batidas = 0;
		
		boolean is_regulagem = false;
		
		try {
			batidas = (Integer.parseInt(this.ic.icDadosRecebidos[12]));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(Integer.parseInt(this.ic.icDadosRecebidos[10]) == 1)
			is_regulagem = true;
		if(this.ic.ParadaSendoInformada.getCdAcao() == null)
			this.ic.ParadaSendoInformada.setCdAcao("");
		if(this.ic.ParadaSendoInformada.getCdCausa() == null)
			this.ic.ParadaSendoInformada.setCdCausa("");
		if(this.ic.ParadaSendoInformada.getCdJustificativa() == null)
			this.ic.ParadaSendoInformada.setCdJustificativa("");
		if(this.ic.ParadaSendoInformada.getCdTecnicoResponsavel() == null)
			this.ic.ParadaSendoInformada.setCdTecnicoResponsavel("");
		if(this.ic.ParadaSendoInformada.getCdTecnicoUm() == null)
			this.ic.ParadaSendoInformada.setCdTecnicoUm("");
		if(this.ic.ParadaSendoInformada.getCdTecnicoDois() == null)
			this.ic.ParadaSendoInformada.setCdTecnicoDois("");
		if(this.ic.ParadaSendoInformada.getCdLocal() == null)
			this.ic.ParadaSendoInformada.setCdLocal("");
		
		boolean ret =  ms.setTr_paradaMotivo(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento().getTime(),
				this.ic.ParadaSendoInformada.getCdParada(),
				this.ic.ParadaSendoInformada.getCdAcao(),
				this.ic.ParadaSendoInformada.getCdCausa(),
				this.ic.ParadaSendoInformada.getCdJustificativa(),
				this.ic.ParadaSendoInformada.getCdTecnicoResponsavel(),
				this.ic.ParadaSendoInformada.getCdTecnicoUm(),
				this.ic.ParadaSendoInformada.getCdTecnicoDois(),
				this.ic.ParadaSendoInformada.getCdLocal(),
		//Luiz 20170706 - no penultimo parametro "String tipoParPreConfig" esta sendo setado "VAZIO" sempre
				is_regulagem, "VAZIO", batidas);
		
		if(ret == true) {
			this.ic.icupdto.getUltimaParadaAtual().setIsRegulagem(is_regulagem);
			this.ic.icupdto.setIsEmRegulagem(is_regulagem);
			if(this.ic.icDadosRecebidos[11] != null && this.ic.icDadosRecebidos[11].length() > 0 && !this.ic.icDadosRecebidos[11].equals(" ")) {
				ispersist = Integer.parseInt(this.ic.icDadosRecebidos[11]);
			}
			
			if(ispersist == 1) {
				this.ic.icupdto.getUltimaParadaAtual().setIsPersistente(true);
			}
			else {
				this.ic.icupdto.getUltimaParadaAtual().setIsPersistente(false);
				ispersist = 0;
			}
			this.ic.icupdto.getUltimaParadaAtual().setCdParada(this.ic.ParadaSendoInformada.getCdParada());
			this.ic.icupdto.getUltimaParadaAtual().setDsParada(this.ic.icupdto.getTmpDsParada());
			this.ic.icupdto.getUltimaParadaAtual().setIsPodeAlterarCdPar(this.ic.icupdto.isTmpPermiteAlterar());
			
			Comando = "SETPARPER;" + this.ic.icupdto.getIdSubColetor().toString() + ";" + Integer.toString(ispersist) + ";";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
			
			this.ic.icupdto.getUltimaParadaAtual().setIsPesaCalculo(this.ic.icupdto.isTmpIsPesanaeficiencia());
			Comando = "RESP;9;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + this.ic.ParadaSendoInformada.getCdParada() + " ;" + this.ic.icDadosRecebidos[10] + ";" + this.ic.ParadaSendoInformada.getDsParada() + ";";
			Comando += "; ; ; ; ; ; ; ;";
			this.ic.icupdto.setPedirParada(false);
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		}
		else {
			Calendar DthrIparada = Calendar.getInstance();
			DthrIparada.setTime(this.ic.icupdto.getUltimaParadaAtual().getDthrIparada());
			
			Stubdelegate.getInstancia().GeraLogRecusaParada("9-N�o Validou atributos de Motivo de Parada", this.ic.icupdto.getIdUP(), DthrIparada, this.ic.icDadosRecebidos[10], log, idLog);
			Comando = "RESP;9;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		}
		// TODO Alessandre
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
