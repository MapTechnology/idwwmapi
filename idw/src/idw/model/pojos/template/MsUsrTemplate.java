package idw.model.pojos.template;

import idw.model.pojos.MsUsr;
import ms.model.APojoMs;

public class MsUsrTemplate extends APojoMs<MsUsr>{

	@Override
	protected MsUsr atribuir(MsUsr from, MsUsr to, boolean isCopiarFK) {
		if (to == null)
			to = new MsUsr();
		
		to.setIdUsr(from.getIdUsr());
		to.setCdUsr(from.getCdUsr());
		to.setDthrRevisao(from.getDthrRevisao());
		to.setDthrStativo(from.getDthrStativo());
		to.setLogin(from.getLogin());
		to.setRevisao(from.getRevisao());
		to.setSenha(from.getSenha());
		to.setStAtivo(from.getStAtivo());

		if (isCopiarFK){
		}
		return to;
	}

}
