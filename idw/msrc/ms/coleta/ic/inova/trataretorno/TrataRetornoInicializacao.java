package ms.coleta.ic.inova.trataretorno;

import injetws.model.excessoes.SemSGBDException;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.dto.INovaUpDTO;

public class TrataRetornoInicializacao extends TrataRetorno {

	public TrataRetornoInicializacao() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		boolean setdoalForFirstUpComOP = true;
		for(INovaUpDTO up : this.ic.Ups) {
			this.ic.enviaSetPrUpColetor(up);
			
			if(up.isStIntegracaoDoal()) {
				if(!up.getIsSemPrograma()) {
					
					this.ic.atualizaListaMatPrima(up.getIdUP(), this.ic.buscaListaMateriaPrima(up.getIdUP()));
					if(setdoalForFirstUpComOP) {
						this.ic.setDoal(up);
						setdoalForFirstUpComOP = false;
					}
				}
			}
			
			// Setando Reles 6 a 8 - Inicio
//			if (isAndonPrcsftAtivo == true)
//			{
//				if ((up != null) && (up.cp != null) &&
//					(up.isUpAtiva) &&
//					((up.cp.nrop != null) && (up.cp.nrop.Length > 0)))
//				{
//					oUpAndonPrcsftDTO = Stubdelegate.getInstancia().setTr_getPrUpAndonPrcsft(up.idUP);
//					if (oUpAndonPrcsftDTO != null)
//					{
//						if (oUpAndonPrcsftDTO.stRele7SldZero != null)
//						{										
//							setSaida("8", "0", "0", oUpAndonPrcsftDTO.tmpRele7LigSldZero.ToString(), oUpAndonPrcsftDTO.tmpRele7DesSldZero.ToString());
//						}
//						setSaida("6", oUpAndonPrcsftDTO.stRele6, "0", oUpAndonPrcsftDTO.tmpRele6Lig.ToString(), oUpAndonPrcsftDTO.tmpRele6Des.ToString());
//						setSaida("5", oUpAndonPrcsftDTO.stRele7, "0", oUpAndonPrcsftDTO.tmpRele7Lig.ToString(), oUpAndonPrcsftDTO.tmpRele7Des.ToString());
//						setSaida("4", oUpAndonPrcsftDTO.stRele8, "1", oUpAndonPrcsftDTO.tmpRele8Lig.ToString(), oUpAndonPrcsftDTO.tmpRele8Des.ToString());
//						
//						//transformando valor para inteiro, com precisao de 2 casas decimais, para enviar ao coletor
//						int iTmpLimParNaoInf = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.tmpLimParNaoInf * 100.0)).ToString());
//						int iVlRefEficUltCiclo = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.vlRefEficUltCiclo * 100.0)).ToString());
//						setDado(up.idSubColetor, "1", iTmpLimParNaoInf.ToString());
//						setDado(up.idSubColetor, "2", iVlRefEficUltCiclo.ToString());
//					}
//				}
//			}
		}
	}

}
