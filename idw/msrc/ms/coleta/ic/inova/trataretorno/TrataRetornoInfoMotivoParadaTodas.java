package ms.coleta.ic.inova.trataretorno;

import java.util.Calendar;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inova.dto.INovaUpDTO;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoInfoMotivoParadaTodas extends TrataRetorno {

	public TrataRetornoInfoMotivoParadaTodas() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		INovaUpDTO updto = null;
		int indiceUps = this.ic.Ups.size();
		int ispersiste = 0, contamaq = 0;
		boolean retor = false;
		boolean tudoOk = true;
		boolean is_regulagem = false;
		
		String Comando = "";
		
		for(int i = 0; i < indiceUps; i++) {
			updto = this.ic.Ups.get(i);
			if (updto.getIsUpAtiva() &&
				!updto.getIsSemPrograma() &&
				updto.getIsParadaEmAberto() &&
				(updto.getUltimaParadaAtual() != null ) && 
				(updto.getUltimaParadaAtual().getCdParada().equals("999999")))
			{
				if((this.ic.ParadaSendoInformada != null) && (!this.ic.ParadaSendoInformada.getCdParada().equals(""))) {
					if(Integer.parseInt(this.ic.icDadosRecebidos[10]) == 1) is_regulagem = true;
					
					if (this.ic.ParadaSendoInformada.getCdAcao() == null)
						this.ic.ParadaSendoInformada.setCdAcao("");
					if (this.ic.ParadaSendoInformada.getCdCausa() == null)
						this.ic.ParadaSendoInformada.setCdCausa("");
					if (this.ic.ParadaSendoInformada.getCdJustificativa() == null)
						this.ic.ParadaSendoInformada.setCdJustificativa("");
					if (this.ic.ParadaSendoInformada.getCdTecnicoResponsavel() == null)
						this.ic.ParadaSendoInformada.setCdTecnicoResponsavel("");
					if (this.ic.ParadaSendoInformada.getCdTecnicoUm() == null)
						this.ic.ParadaSendoInformada.setCdTecnicoUm("");
					if (this.ic.ParadaSendoInformada.getCdTecnicoDois() == null)
						this.ic.ParadaSendoInformada.setCdTecnicoDois("");
					if (this.ic.ParadaSendoInformada.getCdLocal() == null)
						this.ic.ParadaSendoInformada.setCdLocal("");
					
					retor = Stubdelegate.getInstancia().setTr_MotivoParada(updto.getIdUP(), parametro.getDataHoraEvento(),
							this.ic.ParadaSendoInformada.getCdParada(),
							this.ic.ParadaSendoInformada.getCdAcao(),
							this.ic.ParadaSendoInformada.getCdCausa(),
							this.ic.ParadaSendoInformada.getCdJustificativa(),
							this.ic.ParadaSendoInformada.getCdTecnicoResponsavel(),
							this.ic.ParadaSendoInformada.getCdTecnicoUm(),
							this.ic.ParadaSendoInformada.getCdTecnicoDois(),
							this.ic.ParadaSendoInformada.getCdLocal(),
							is_regulagem, log, idLog);	// parada de regulagem
					
					if(retor == true) {
						contamaq++;
						updto.getUltimaParadaAtual().setIsRegulagem(is_regulagem);
						updto.setIsEmRegulagem(is_regulagem);
						
						if(this.ic.icDadosRecebidos[11] != null && this.ic.icDadosRecebidos[11].length() > 0 && this.ic.icDadosRecebidos[11].equals("1")) {
							ispersiste = 1;
							updto.getUltimaParadaAtual().setIsPersistente(true);
						}
						else {
							updto.getUltimaParadaAtual().setIsPersistente(false);
							ispersiste = 0;
						}
						
						if(updto.getUltimaParadaAtual().getIsRegulagem() && updto.getUltimaParadaAtual().getIsPersistente()) {
							updto.getUltimaParadaAtual().setIsPersistente(false);
							ispersiste = 0;
						}
						
						updto.getUltimaParadaAtual().setCdParada(this.ic.ParadaSendoInformada.getCdParada());
						
						Comando = "SETPARPER;" + updto.getIdSubColetor().toString() + ";" + ispersiste + ";";
						
						this.ic.enviaDado(Comando);
						UtilsThreads.pausaNaThread(100);
						
						updto.getUltimaParadaAtual().setIsPesaCalculo(this.ic.icupdto.isTmpIsPesanaeficiencia());
						updto.getUltimaParadaAtual().setDsParada(this.ic.ParadaSendoInformada.getDsParada());
						updto.getUltimaParadaAtual().setIsPodeAlterarCdPar(this.ic.ParadaSendoInformada.getIsPodeAlterarCdPar());
						updto.setPedirParada(false);
						
						this.ic.setUP(updto.getIdSubColetor(), updto);
						Comando = "SETPARADA;" + updto.getIdSubColetor().toString() + ";" + this.ic.ParadaSendoInformada.getCdParada() + ";" + this.ic.icDadosRecebidos[10] + ";" + this.ic.ParadaSendoInformada.getDsParada() + ";;;;;;;;";
						
						this.ic.enviaDado(Comando);
						UtilsThreads.pausaNaThread(100);
					}
					else {
						tudoOk = false;
					}
				}
				else {
					tudoOk = false;
				}
			}
		}
		
		if(contamaq == 0) tudoOk = false;
		if(tudoOk) {
			Comando = "RESP;92;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
		else {
			Calendar DthrIparada = Calendar.getInstance();
			DthrIparada.setTime(this.ic.icupdto.getUltimaParadaAtual().getDthrIparada());
			
			Stubdelegate.getInstancia().GeraLogRecusaParada("92-Nao Validou atributos de Motivo de Parada", this.ic.icupdto.getIdUP(), DthrIparada, this.ic.ParadaSendoInformada.getCdParada(), log, idLog);
			Comando = "RESP;92;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
	}

}
