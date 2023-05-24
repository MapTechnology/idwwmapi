package idw.model.pojos.template;

import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.OmProduto;

public class DwFolharapcomTemplate extends AbstractTemplate<DwFolharapcom> {

	@Override
	protected DwFolharapcom atribuir(DwFolharapcom from, DwFolharapcom to,
			boolean isCopiarFK) {
		if(to == null) {
			to = new DwFolharapcom();
		}
		
		to.setIdFolharapcom(from.getIdFolharapcom());
		to.setDwFolharap(null);
		to.setQtAtiva(from.getQtAtiva());
		to.setQtTotal(from.getQtTotal());
		to.setIdredzproduto(from.getIdredzproduto());
		
		to.setOmProduto((OmProduto)from.getOmProduto().clone());
		
		return to;
	}

}
