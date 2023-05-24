package idw.model.pojos.template;

import idw.model.pojos.OmCfgurl;

public abstract class OmCfgurlTemplate extends AbstractTemplate<OmCfgurl>{

	@Override
	protected OmCfgurl atribuir(OmCfgurl from, OmCfgurl to, boolean isCopiarFK) {
		if (to == null) {
			to = new OmCfgurl();
		}
		
		to.setIdCfgurl(from.getIdCfgurl());
		to.setDsUrl(from.getDsUrl());
		to.setUrlConexao(from.getUrlConexao());
		to.setUtc(from.getUtc());
		return to;
	}

}
