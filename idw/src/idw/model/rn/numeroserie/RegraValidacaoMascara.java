package idw.model.rn.numeroserie;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.util.UtilsString;
import idw.webservices.dto.ResultadoDTO;

public class RegraValidacaoMascara implements IRegraValidacao {

	@Override
	public ResultadoDTO isPassouNoTeste(PpCp ppcp, DwFolha dwfolha, DwFolhamoncomp dwfolhamoncomp, String ns, OmPt ompt, DAOGenerico dao) {
		ResultadoDTO retorno = new ResultadoDTO();

		retorno.setIdmensagem(retorno.COM_SUCESSO);
		
		// Essa regra de validacao está validando a mascara da montagem (dwfolhamoncomp) e nao do produto principal (dwfolha)
		boolean isMascaraValida = UtilsString.isConformeMascara(ns, dwfolhamoncomp.getMascara());
		if (isMascaraValida == false) {
			retorno.setIdmensagem(retorno.getCODIGO_DESCONHECIDO());
		} else {
			// Avaliar se o CB tem limite de tamanho
			if (dwfolha.getIsAvaliarlimites() != null && dwfolha.getIsAvaliarlimites()) {
				if (ns.trim().length() >= dwfolhamoncomp.getLimiteMinCb() && ns.trim().length() <= dwfolhamoncomp.getLimiteMaxCb())
					retorno.setIdmensagem(retorno.COM_SUCESSO);
				else
					retorno.setIdmensagem(retorno.FORA_LIMITE);
			}
		}
		
		return retorno;
	}
}
