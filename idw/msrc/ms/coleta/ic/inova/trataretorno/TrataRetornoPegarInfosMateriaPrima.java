package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;

public class TrataRetornoPegarInfosMateriaPrima extends TrataRetorno {

	public TrataRetornoPegarInfosMateriaPrima() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsProdMateriaPrimaDTO lcprima = null;
		IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO = new IwsUpAndonPrcsftDTO();
		
		lcprima = this.ic.buscaUltimaMatPrimaUsada(this.ic.icupdto.getIdUP());
		if ( (lcprima != null) && (lcprima.getErro() == 0)) {
			Comando = "RESP;998;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1;";
			Comando += "1;";
			Comando += lcprima.getDsProduto() + ";" +
				lcprima.getDsMateriaPrima() + ";" +
				lcprima.getUnidade() + ";";
			//insere o controle de solicatação de lote
			if (lcprima.getControlalote())
				Comando += "1;";
			else
				Comando += "0;";
			Comando += " ; ; ; ;";
			
			this.ic.icupdto.setMatPrimaEnviada(new IwsProdMateriaPrimaDTO());
			this.ic.icupdto.getMatPrimaEnviada().setCdProduto(lcprima.getCdProduto());
			this.ic.icupdto.getMatPrimaEnviada().setCdMateriaPrima(lcprima.getCdMateriaPrima());
			this.ic.icupdto.getMatPrimaEnviada().setControlalote(lcprima.getControlalote());
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		}
		else if( lcprima == null ) {
			Stubdelegate.getInstancia().confirmacaoOp(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), null, this.ic.icupdto);
			Stubdelegate.getInstancia().geraLogIntegracaoDoal(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), "FIM DA VALIDACAO DA OP", true);
			Stubdelegate.getInstancia().enviaListaMatPrima(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icupdto, this.ic.matPrimaParaApontar);
			this.ic.matPrimaParaApontar.clear();
			this.ic.icupdto.setIsSemPrograma(false);
			this.ic.icupdto.setStIntegracaoDoal(true);
			this.ic.icupdto.setCp(this.ic.icupdto.getCpTemp());
			this.ic.icupdto.setMatPrimaEnviada(null);
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
			this.ic.enviaSetPrUpColetor(this.ic.icupdto);
			this.ic.setDoal(this.ic.icupdto);
			
			UtilsThreads.pausaNaThread(100);
			
			if(this.ic.isAndonPrcsftAtivo) {
				oUpAndonPrcsftDTO = Stubdelegate.getInstancia().setTr_getPrUpAndonPrcsft(this.ic.icupdto.getIdUP());
				if (oUpAndonPrcsftDTO != null) {
					if (oUpAndonPrcsftDTO.getstRele7SldZero() != null) {
						this.ic.setSaida("8", "0", "0", oUpAndonPrcsftDTO.gettmpRele7LigSldZero().toString(), oUpAndonPrcsftDTO.gettmpRele7DesSldZero().toString());
					}
					
					this.ic.setSaida("6", oUpAndonPrcsftDTO.getstRele6(), "0", oUpAndonPrcsftDTO.gettmpRele6Lig().toString(), oUpAndonPrcsftDTO.gettmpRele6Des().toString());
					this.ic.setSaida("5", oUpAndonPrcsftDTO.getstRele7(), "0", oUpAndonPrcsftDTO.gettmpRele7Lig().toString(), oUpAndonPrcsftDTO.gettmpRele7Des().toString());
					this.ic.setSaida("4", oUpAndonPrcsftDTO.getstRele8(), "1", oUpAndonPrcsftDTO.gettmpRele8Lig().toString(), oUpAndonPrcsftDTO.gettmpRele8Des().toString());
					
					//transformando valor para inteiro, com precisao de 2 casas decimais, para enviar ao coletor
					int iTmpLimParNaoInf = oUpAndonPrcsftDTO.gettmpLimParNaoInf().intValue() * 100;
					int iVlRefEficUltCiclo = oUpAndonPrcsftDTO.getvlRefEficUltCiclo().intValue() * 100;
					this.ic.setDado(this.ic.icupdto.getIdSubColetor(), "1", String.valueOf(iTmpLimParNaoInf));
					this.ic.setDado(this.ic.icupdto.getIdSubColetor(), "2", String.valueOf(iVlRefEficUltCiclo));
				}
			}
			Comando = "RESP;998;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;0;";
			Comando += "; ; ; ; ; ; ; ;";
		}
		else {
			String msg = "";
			if (lcprima.getErro() == 1)
				msg = "ESTA MAQUINA NAO ESTA INSERIDA NA LISTA DE MAQUINAS DA INTEGRACAO";
			else if (lcprima.getErro() == 2)
				msg = "A LISTA DE MATERIAS PRIMAS NAO ESTA PREENCHIDA CORRETAMENTE";
			else
				msg = "ERRO: PROTECAO CONTRA PROBLEMAS NAO IDENTIFICADOS";
			
			List<String> lines = this.ic.verificaTxtMensagem(msg);
			Comando = "RESP;998;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
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
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
