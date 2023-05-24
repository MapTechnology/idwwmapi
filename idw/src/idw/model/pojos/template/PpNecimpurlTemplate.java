package idw.model.pojos.template;

import idw.model.pojos.PpNecimpurl;

public class PpNecimpurlTemplate  extends AbstractTemplate<PpNecimpurl> {

	@Override
	protected PpNecimpurl atribuir(PpNecimpurl from, PpNecimpurl to, boolean isCopiarFK) {
		if (to == null)
			to = new PpNecimpurl();
		
		to.setIdNecimpurl(from.getIdNecimpurl());
		to.setUrlFonte(from.getUrlFonte());
		to.setMascara(from.getMascara());
		to.setAba(from.getAba());
		return to;
	}

}
