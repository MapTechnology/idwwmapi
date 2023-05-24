package ms.coleta.ic.inova.trataretorno;

import java.math.BigDecimal;

import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;

public class TrataRetornoFinalizacaoOp extends TrataRetorno {

	public TrataRetornoFinalizacaoOp() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		if (this.ic.icupdto.getIsComAlertaProbQuali() ||
				this.ic.icupdto.getIsComInspecaoPendente() ||
				((this.ic.icupdto.getListaAlertasDiariodeBordo() != null) && (this.ic.icupdto.getListaAlertasDiariodeBordo().size() > 0)))
		{
			Comando = "RESP;6;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
			if(this.ic.icupdto.getIsComAlertaProbQuali())
				Comando+="Com ALe. Prob. Qual.;";
			if(this.ic.icupdto.getIsComInspecaoPendente())
				Comando+="Com Inspec. Pendente;";
			if ((this.ic.icupdto.getListaAlertasDiariodeBordo() != null) && (this.ic.icupdto.getListaAlertasDiariodeBordo().size() > 0))
				Comando+="Apon D. de Bordo Qld;";
			Comando+="; ; ; ; ;";
			
		}
		else if(Stubdelegate.getInstancia().setTr_EvntFimPlanejamento(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), log, idLog)) {
			this.ic.icupdto.setIsSemPrograma(true);
			
			if(this.ic.icupdto.getCp() != null) this.ic.icupdto.getCp().setNrop(null);
			
//			this.ic.icupdto.getListaAlertasAbertos().clear();
			this.ic.icupdto.setUltimoRefugoAtual(new IwsRefugoDTO());
			this.ic.icupdto.setUltimaParadaAtual(new IwsParadaDTO());
			this.ic.icupdto.setNumeroDeCiclos(new BigDecimal(0));
			this.ic.icupdto.setProducaoLiquida(0d);
			this.ic.icupdto.setIsEmRegulagem(false);
			this.ic.icupdto.setvleficultciclo(0d);
			this.ic.icupdto.getDadosCIP().setIsEmCIP(false);
			this.ic.icupdto.setIsParadaEmAberto(false);
//			this.ic.icupdto.setIsComAlertaProbQuali(false);
			this.ic.icupdto.setIsApntSapAtivo(null);
			this.ic.icupdto.setStAlimIntegracaoDoal(false);
			this.ic.icupdto.setVisualizaTelaIntegDOal(false);  
			//ph 20120103
//			try {
//				Stubdelegate.getInstancia().atualizaOperadoresLogados(this.ic.icupdto, log, idLog);
//			} catch (SemComunicacaoICException e) {
//				// TODO: essa exception nao esta e nao estava sendo tratada no C#
//				e.printStackTrace();
//			}
			
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
			this.ic.enviaSetPrUpColetor(this.ic.icupdto);
			
			//vlauria 20100318
			Comando = "RESP;6;" + this.ic.icupdto.getIdSubColetor().toString() + ";1; ; ; ; ; ; ; ; ; ;";
		}
		else
			Comando = "RESP;6;" + this.ic.icupdto.getIdSubColetor().toString() + ";0; ; ; ; ; ; ; ; ; ;";
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
