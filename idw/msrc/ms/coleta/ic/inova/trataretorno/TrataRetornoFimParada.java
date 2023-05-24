package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inova.dto.INovaReleDTO;
//import ms.coleta.ic.inova.dto.INovaReleDTO;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsReleDTO;
import idw.webservices.MswsComEvt;

public class TrataRetornoFimParada extends TrataRetorno {
	MswsComEvt ms = new MswsComEvt();
	public TrataRetornoFimParada() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		IwsReleDTO infoLocalRele = new IwsReleDTO();
		INovaReleDTO localRele = new INovaReleDTO();
		
		ms.setTr_paradaFim(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento().getTime());
		
		this.ic.icupdto.setIsParadaEmAberto(false);
		this.ic.icupdto.setPedirParada(false);
		this.ic.icupdto.setIsEmRegulagem(false);
		if(this.ic.icDadosRecebidos[10] != null && this.ic.icDadosRecebidos[10].equals("1"))
			this.ic.icupdto.getUltimaParadaAtual().setIsPersistente(false);
		
		this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		
		// pegar informacoes para o rele 8
		
		if(this.ic.isAndonPrcsftAtivo == true) {
			IwsReleDTO oRele8_10 = ms.setTr_getRele8(this.ic.icupdto.getIdUP());
			
			if (oRele8_10 != null) {
				this.ic.setSaida(oRele8_10);
			}
		}
	}

}
