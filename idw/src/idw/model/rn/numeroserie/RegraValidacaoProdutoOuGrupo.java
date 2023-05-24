package idw.model.rn.numeroserie;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.webservices.dto.ResultadoDTO;

public class RegraValidacaoProdutoOuGrupo implements IRegraValidacao {

	@Override
	public ResultadoDTO isPassouNoTeste(PpCp ppcp, DwFolha dwfolha, DwFolhamoncomp dwfolhamoncomp, String ns, OmPt ompt, DAOGenerico dao) {
		ResultadoDTO retorno = new ResultadoDTO();

		retorno.setIdmensagem(retorno.COM_SUCESSO);
		
		// Avaliar se o CB tem limite de tamanho
		if (dwfolha.getIsAvaliarlimites() != null && dwfolha.getIsAvaliarlimites()) {
			if (ns.trim().length() >= dwfolha.getLimiteMinCb() && ns.trim().length() <= dwfolha.getLimiteMaxCb())
				retorno.setIdmensagem(retorno.COM_SUCESSO);
			else
				retorno.setIdmensagem(retorno.FORA_FAIXA);
		}

		return retorno;
	}
}
