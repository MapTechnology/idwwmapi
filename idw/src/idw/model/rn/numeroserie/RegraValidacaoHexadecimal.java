package idw.model.rn.numeroserie;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwMacrange;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProrange;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.consolidacao.producao.ConsolidacaoPassagem;
import idw.util.MacUtil;
import idw.webservices.dto.ResultadoDTO;

public class RegraValidacaoHexadecimal implements IRegraValidacao {

	@Override
	public ResultadoDTO isPassouNoTeste(PpCp ppcp, DwFolha dwfolha, DwFolhamoncomp dwfolhamoncomp, String ns, OmPt ompt, DAOGenerico dao) {
		ResultadoDTO retorno = new ResultadoDTO();

		retorno.setIdmensagem(retorno.CODIGO_DESCONHECIDO);

		
		if (MacUtil.isHexadecimal(ns)) {
			retorno.setIdmensagem(retorno.COM_SUCESSO);
			if (dwfolha.getIsAvaliarlimites() != null && dwfolha.getIsAvaliarlimites()) {
				if (ns.trim().length() >= dwfolha.getLimiteMinCb() && ns.trim().length() <= dwfolha.getLimiteMaxCb())
					retorno.setIdmensagem(retorno.COM_SUCESSO);
				else
					retorno.setIdmensagem(retorno.FORA_FAIXA);
			}
		}
		
		// Se for um hexa valida entao avaliar o banco de macs
		// Caso a OP seja de reprocesso o BANCO de MACs nao sera verificado, mas sim a lista de macs associados a OP
		if (retorno.isComSucesso()) {
			
			
			if (ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()) == false) {
				// Avaliar banco de macs
				ConsolidacaoPassagem rn = new ConsolidacaoPassagem();
				rn.setDao(dao);
				
				DwMacrange macrange = rn.isMateriaPrimaLimitada(ns, ompt);
				if (macrange == null) {
					OmProduto omproduto = dwfolha.obtemProduto();
					OmProrange omprorange = rn.pesquisarOmProrange(omproduto, ns);
					if (omprorange == null) {
						retorno.setIdmensagem(retorno.SEM_MAC_DISPONIVEL);
					}
				}
				
			}
		}
		return retorno;
	}

}
