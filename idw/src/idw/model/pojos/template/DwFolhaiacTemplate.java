package idw.model.pojos.template;

import org.hibernate.SessionException;

import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;

public class DwFolhaiacTemplate extends AbstractTemplate<DwFolhaiac> {

	@Override
	protected DwFolhaiac atribuir(DwFolhaiac from, DwFolhaiac to, boolean isCopiarFK) {
		if(to == null) {
			to = new DwFolhaiac();
		}
		
		to.setIdFolhaiac(from.getIdFolhaiac());
		to.setQtAtiva(from.getQtAtiva());
		to.setQtMpporciclo(from.getQtMpporciclo());

		if (isCopiarFK == true){
			if (from.getOmPrg() != null) {
				try {
					to.setOmPrg((OmPrg)from.getOmPrg().clone());
				}catch(SessionException e) {
					to.setOmPrg(null);
				}
			}
			
			if (from.getOmProduto() != null) {
				try {
					to.setOmProduto((OmProduto)from.getOmProduto().clone());
				}catch(SessionException e) {
					to.setOmProduto(null);
				}
			}
	
			if (from.getOmProdutodois() != null) {
				try {
					to.setOmProdutodois((OmProduto)from.getOmProdutodois().clone());
				}catch(SessionException e) {
					to.setOmProdutodois(null);
				}
			}
		}
		
		to.setDwFolha(null);
		
		return to;
	}

}
