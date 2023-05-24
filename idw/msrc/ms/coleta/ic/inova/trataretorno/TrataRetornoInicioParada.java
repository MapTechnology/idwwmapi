package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import ms.webservice.Msws;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsParadaDTO;
import idw.webservices.MswsComEvt;

public class TrataRetornoInicioParada extends TrataRetorno {
	public MswsComEvt ms = new MswsComEvt();
	public TrataRetornoInicioParada() {
	}
	
	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsCicloDTO cicloAtual = null;
		
		boolean isparadaauto = false;
		
		if(Integer.parseInt(this.ic.icDadosRecebidos[12]) == 1)
			isparadaauto = true;
		
		if(this.ic.icupdto.getUltimaParadaAtual() == null) {
			this.ic.icupdto.setUltimaParadaAtual(new IwsParadaDTO());
			this.ic.icupdto.getUltimaParadaAtual().setIsPersistente(false);
			this.ic.icupdto.getUltimaParadaAtual().setIsRegulagem(false); 
		}
		
		try {
			cicloAtual = ms.setTr_paradaInicio(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento().getTime(), isparadaauto, this.ic.icupdto.getUltimaParadaAtual().getIsPersistente(),false);
		} 
		//catch( e) {
		//	throw e;
		//} 
		catch (Exception e) {
			e.printStackTrace();
//			pnldto.IdUp = idup;
//			pnldto.Log = util.ObtemDataLocalParaLog() + "Ao Lan�ar Parada (8)";
//			if (e != null && e.Message != null)
//				pnldto.Log += e.Message;
//			SetPnlDTO();  
		}
		
		this.ic.icupdto.setIsParadaEmAberto(true);
		if (cicloAtual.isFinaizouOP()){ //Luiz - 20170705 Alguns parametros do ConcentradorC# nao foram encontrados  neste pojo
           //   this.ic.icupdto.TeveCicloProdutivo = false;
                this.ic.icupdto.setIsSemPrograma(true);
           //     this.ic.icupdto.ApontouPesagemAT = false;
           //     this.ic.icupdto.isOpConcluida = false;
                if (this.ic.icupdto.getCpTemp() != null) 
                	this.ic.icupdto.getCpTemp().setNrop(null);
                this.ic.icupdto.setUltimoRefugoAtual(null);
                this.ic.icupdto.setUltimaParadaAtual(null);
                this.ic.icupdto.setPedirParada(false);
                this.ic.icupdto.setIsEmRegulagem(false);
           //   this.ic.icupdto.setNumeroDeCiclos(0);
                this.ic.icupdto.setProducaoLiquida(0.0);
          //    this.ic.icupdto.setVleficultciclo(0);
                this.ic.icupdto.setDadosCIP(null);
                this.ic.icupdto.setIsParadaEmAberto(false);
                this.ic.icupdto.setIsApntSapAtivo(null);
         //     this.ic.icupdto.setIsMateriaApontada(false);
                this.ic.icupdto.setVisualizaTelaIntegDOal(false);
         //       setUP(this.ic.icupdto.idSubColetor, this.ic.icupdto);
         //       setPrUpColetor(this.ic.icupdto);
		}
		
		if(cicloAtual.getCicloValido()) {
			this.ic.icupdto.setNumeroDeCiclos(cicloAtual.getNumeroCiclosCont());
			Comando = "";
			Comando = "SETCIC;" + this.ic.icupdto.getIdSubColetor().toString() + ";" + this.ic.icupdto.getNumeroDeCiclos() + ";";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
		
		if (this.ic.icupdto.getUltimaParadaAtual().getIsPersistente())
			this.ic.icupdto.setPedirParada(false);
		else {
			this.ic.icupdto.getUltimaParadaAtual().setCdParada("999999");
			this.ic.icupdto.getUltimaParadaAtual().setIsPodeAlterarCdPar(true);
			this.ic.icupdto.getUltimaParadaAtual().setIsRegulagem(false);
			this.ic.icupdto.setPedirParada(true);
		}
		
		this.ic.icupdto.getUltimaParadaAtual().setDthrIparada(parametro.getDataHoraEvento().getTime());
		this.ic.icupdto.setIsEmRegulagem(false);
		
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
	}

}
