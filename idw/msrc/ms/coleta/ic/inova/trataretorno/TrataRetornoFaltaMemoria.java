package ms.coleta.ic.inova.trataretorno;

import java.util.Calendar;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import injetws.model.IwsFacade;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoFaltaMemoria extends TrataRetorno {

	public TrataRetornoFaltaMemoria() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		Calendar dthrBeat = this.ic.ObtemDatadeDado(this.ic.icDadosRecebidos);
		
		try {
//			if (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta == true)
//				getMsWs().setTr_MCSemConexao(lcIpAdd + ":" + lcPorta, dthrBeat);
//			else
//				getMsWs().setTr_MCSemConexao(lcIpAdd, dthrBeat);
			
			IwsFacade.getInstancia().setTr_MCSemConexao(this.ic.ipColetor, dthrBeat.getTime());
		} catch (Exception e) {
			Stubdelegate.getInstancia().setSemComunicacaoWS(true);
		}
	}

}
