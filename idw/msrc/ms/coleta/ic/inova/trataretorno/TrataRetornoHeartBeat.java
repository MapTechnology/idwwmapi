package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoHeartBeat extends TrataRetorno {

	public TrataRetornoHeartBeat() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		this.ic.trataEventoHtBeat(this.ic.icDadosRecebidos);
	}

}
