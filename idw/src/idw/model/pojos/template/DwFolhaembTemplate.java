package idw.model.pojos.template;

import org.hibernate.SessionException;

import idw.model.pojos.DwFolhaemb;
import idw.model.pojos.OmCfgscrpimp;

public class DwFolhaembTemplate extends AbstractTemplate<DwFolhaemb> {

	@Override
	protected DwFolhaemb atribuir(DwFolhaemb from, DwFolhaemb to, boolean isCopiarFK) {
		if (to == null)
			to = new DwFolhaemb();

		to.setIdFolhaemb(from.getIdFolhaemb());
		to.setIsEmbDefault(from.getIsEmbDefault());
		to.setQtNaEmbalagem(from.getQtNaEmbalagem());

		if (isCopiarFK == true) {
			if(from.getOmProduto() != null) {
				try {
					to.setOmProduto(from.getOmProduto().clone(false));
				}catch(SessionException e) {
					to.setOmProduto(null);
				}
			}
			if (from.getOmCfgscrpimp() != null) {
				try {
					to.setOmCfgscrpimp((OmCfgscrpimp) from.getOmCfgscrpimp().clone());
				} catch (SessionException e) {
					to.setOmCfgscrpimp(null);
				}
			}
		}
		
		return to;
	}
}
