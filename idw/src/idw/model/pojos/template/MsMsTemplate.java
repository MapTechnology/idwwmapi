package idw.model.pojos.template;

import idw.model.pojos.MsMs;
import ms.model.APojoMs;

public class MsMsTemplate extends APojoMs<MsMs>{

	@Override
	protected MsMs atribuir(MsMs from, MsMs to, boolean isCopiarFK) {
		if (to == null)
			to = new MsMs();
		
		to.setIdMs(from.getIdMs());
		to.setCdMs(from.getCdMs());
		to.setDsMs(from.getDsMs());
		to.setDthrHeartbeat(from.getDthrHeartbeat());
		to.setDthrRevisao(from.getDthrRevisao());
		to.setDthrStativo(from.getDthrStativo());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setSegHeartbeat(from.getSegHeartbeat());
		to.setTpCalculoandon(from.getTpCalculoandon());
		to.setUrlConexao(from.getUrlConexao());

		if (isCopiarFK){
			to.setMsUsr(from.getMsUsr().clone());
		}
		return to;
	}

}
