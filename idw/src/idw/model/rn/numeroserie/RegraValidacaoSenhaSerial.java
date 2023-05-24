package idw.model.rn.numeroserie;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.webservices.dto.ResultadoDTO;

public class RegraValidacaoSenhaSerial implements IRegraValidacao {

	@Override
	public ResultadoDTO isPassouNoTeste(PpCp ppcp, DwFolha dwfolha, DwFolhamoncomp dwfolhamoncomp, String ns, OmPt ompt, DAOGenerico dao) {
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setIdmensagem(retorno.COM_SUCESSO);
		return retorno;
	}

}
