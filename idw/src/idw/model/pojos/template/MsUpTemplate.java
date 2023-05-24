package idw.model.pojos.template;

import idw.model.pojos.MsUp;
import ms.model.APojoMs;

public class MsUpTemplate extends APojoMs<MsUp>{

	@Override
	protected MsUp atribuir(MsUp from, MsUp to, boolean isCopiarFK) {
		if (to == null)
			to = new MsUp();
		
		to.setIdUp(from.getIdUp());
		to.setCdUp(from.getCdUp());
		to.setDsUp(from.getDsUp());
		to.setDthrRevisao(from.getDthrRevisao());
		to.setDthrStativo(from.getDthrStativo());
		to.setIsLicenciada(from.getIsLicenciada());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setCdBc(from.getCdBc());
		to.setNrop(from.getNrop());
		to.setSequencial(from.getSequencial());
		to.setTpUp(from.getTpUp());
		to.setNomePrograma(from.getNomePrograma());

		if (isCopiarFK){
			to.setMsUsr(from.getMsUsr().clone());
		}
		return to;
	}

}
