package idw.model.pojos.template;

import idw.model.pojos.MsMsicupProduto;
import ms.model.APojoMs;

public class MsMsicupProdutoTemplate extends APojoMs<MsMsicupProduto>{

	@Override
	protected MsMsicupProduto atribuir(MsMsicupProduto from, MsMsicupProduto to, boolean isCopiarFK) {
		if (to == null)
			to = new MsMsicupProduto();
		
		to.setIdMsicupProduto(from.getIdMsicupProduto());
		to.setUrlConexao(from.getUrlConexao());
		to.setCdProduto(from.getCdProduto());

		if (isCopiarFK){
		}
		return to;
	}

}
