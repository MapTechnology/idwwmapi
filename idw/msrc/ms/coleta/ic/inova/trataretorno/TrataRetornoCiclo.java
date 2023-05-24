package ms.coleta.ic.inova.trataretorno;

import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsReleDTO;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inova.dto.INovaReleDTO;
import ms.util.UtilsThreads;
import idw.webservices.MswsComEvt;

public class TrataRetornoCiclo extends TrataRetorno {
	MswsComEvt ms = new MswsComEvt();
	public TrataRetornoCiclo() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		int quantidadeLida = 0;
		int quantidadepedida=0;
        int qtdInformada = 0;
         
		if(this.ic.icupdto.getIsSemPrograma()) {
			log.info(idLog, 0, "CicloDesprezado" + this.ic.ipColetor);
			log.info(idLog, 1, "Ciclo desprezado por estar sem op - idUP: "+this.ic.icupdto.getIdUP());
			return;
		}
		
		// TODO: Obten��o de BarCode
		String infoAdicional = "";
		boolean rejeitaCiclo = false;
		try {
			this.ic.dadosApontamentoDTO.setBatidas(0);
			//if (Gerente.getInstancia().SalvaBarCode || 
            //Gerente.getInstancia().IsCustomizacaoKarina ||
            //(this.isCicloComInspec && getTipoVersaoColetor("KAP"))||
            //(getTipoVersaoColetor("MASACS")))
			//{
			//if(this.ic.icDadosRecebidos[10].length() > 1) {
			//	infoAdicional = this.ic.icDadosRecebidos[10];
			//	this.ic.dadosApontamentoDTO.setInfoAdicional(infoAdicional);
//				if(Gerente.getInstancia().SalvaBarCode) {
//					List<String> dadoslog = new List<String>();
//					dadoslog.Add(barCode);
//					geraLog("CicloInfoAdicional" + this.lcIpAdd, dadoslog); 
//					Stubdelegate.getInstancia().salvaBarcodeEsmaltec(barCode,DtHrEvento,lcupdto.up);
//				}
//				if(this.ic.getVersaoIC.equals("MASACS"))
//				{
//					qtdInformada = this.ic.getBatidasFromBarCode(infoAdicional);
					
//				}
			}
			
		 catch (Exception e) {
			//tratamento vazio n�o pode obter o c�digo de barras
			// TODO: tratamento barcode
		}
		if (!rejeitaCiclo)
		{
		if(this.ic.icupdto.getIsParadaEmAberto()) {
			IwsCicloDTO ciclo = new IwsCicloDTO();
			if(infoAdicional.length() > 30)
				this.ic.dadosApontamentoDTO.setInfoAdicional(infoAdicional.substring(0, 30));
			else
				this.ic.dadosApontamentoDTO.setInfoAdicional("");
			if (this.ic.dadosApontamentoDTO.getBatidas() == 0)
			{
				try
				{
					this.ic.dadosApontamentoDTO.setBatidas(Integer.parseInt(this.ic.icDadosRecebidos[10]));
				}
				catch(Exception e)
				{
					this.ic.dadosApontamentoDTO.setBatidas((int) Math.floor(this.ic.icupdto.getCp().getCfgTamanhoUmPacoteCiclos()));
				}
			}
				ciclo = ms.setTr_CicloInicio(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento().getTime(), this.ic.dadosApontamentoDTO);
				this.ic.icupdto.setIsParadaEmAberto(this.ic.icupdto.getIsEmRegulagem());// by Senoj Caso parada seja de regulagem n�o fecha a parada
				this.ic.icupdto.setPedirParada(false);
			if(ciclo.getCicloValido()) {
				//this.ic.icupdto.setTeveCicloProdutivo(true);
				this.ic.icupdto.setNumeroDeCiclos(ciclo.getNumeroCiclosCont());
				Comando = "";
				Comando = "SETCIC;" + this.ic.icupdto.getIdSubColetor().toString() + ";" + this.ic.icupdto.getNumeroDeCiclos() + ";";
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
			}
		}
		else {
			IwsReleDTO oRele8_7 = new IwsReleDTO();
			try {
				if (infoAdicional.length() > 30) 
					this.ic.dadosApontamentoDTO.setInfoAdicional(infoAdicional.substring(0, 30));
				else
					this.ic.dadosApontamentoDTO.setInfoAdicional("");
				if(this.ic.dadosApontamentoDTO.getBatidas() == 0)
				{
					try
					{
						this.ic.dadosApontamentoDTO.setBatidas(Integer.parseInt(this.ic.icDadosRecebidos[10]));
					}
					catch(Exception e)
					{
						this.ic.dadosApontamentoDTO.setBatidas((int) Math.floor(this.ic.icupdto.getCp().getCfgTamanhoUmPacoteCiclos()));
					}
				}
				oRele8_7 = ms.setTr_CicloFim(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento().getTime(), this.ic.dadosApontamentoDTO);
				if (oRele8_7 != null) {
					if(this.ic.isAndonAtivo == true)
						this.ic.icupdto.setvleficultciclo(oRele8_7.getDadosUltCiclo().getVlEficUltCiclo());
					
					if(this.ic.isAndonPrcsftAtivo == true)
						this.ic.setSaida(oRele8_7);
					
					if(oRele8_7.getDadosUltCiclo().getCicloValido()) {
						this.ic.icupdto.setNumeroDeCiclos(oRele8_7.getDadosUltCiclo().getNumeroCiclosCont());
						Comando = "";
						Comando = "SETCIC;" + this.ic.icupdto.getIdSubColetor().toString() + ";" + this.ic.icupdto.getNumeroDeCiclos() + ";";
						
						this.ic.enviaDado(Comando);
						UtilsThreads.pausaNaThread(10);
					}
				}
			} catch (Exception e) {
				log.info(idLog, 0, "Ao Lan�ar CICLO (7)" + this.ic.icupdto.getIdUP());
				log.info(idLog, 1, e.getMessage());
				e.printStackTrace();
			}
		}
		}
		else
		{
			Comando = "";
			Comando = "SETCIC;" + this.ic.icupdto.getIdSubColetor().toString() + ";" + this.ic.icupdto.getNumeroDeCiclos() + ";";
			
			this.ic.enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
	}

}
