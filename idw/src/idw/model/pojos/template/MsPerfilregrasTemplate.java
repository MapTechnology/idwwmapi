package idw.model.pojos.template;

import idw.model.pojos.MsPerfilregras;
import ms.model.APojoMs;

public class MsPerfilregrasTemplate extends APojoMs<MsPerfilregras>{

	@Override
	protected MsPerfilregras atribuir(MsPerfilregras from, MsPerfilregras to, boolean isCopiarFK) {
		if (to == null)
			to = new MsPerfilregras();
		
		to.setIdPerfilregras(from.getIdPerfilregras());
		to.setIsPiscante(from.getIsPiscante());
		to.setPorta(from.getPorta());
		to.setPrioridade(from.getPrioridade());
		to.setSegTempoauto(from.getSegTempoauto());
		to.setSegTempobaixa(from.getSegTempobaixa());
		to.setSegTolerancia(from.getSegTolerancia());
		to.setSinalMotivo(from.getSinalMotivo());
		to.setTpMotivo(from.getTpMotivo());
		to.setTpSaida(from.getTpSaida());
		to.setUrlConexaoUp(from.getUrlConexaoUp());
		to.setVlMotivo(from.getVlMotivo());
		if (isCopiarFK){
			to.setMsPerfilandon(from.getMsPerfilandon().clone(false));
		}
		return to;
	}

}
