package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.MsIc;
import idw.model.pojos.MsPerfilandon;
import idw.model.pojos.MsPerfilregras;
import ms.model.APojoMs;

public class MsPerfilandonTemplate extends APojoMs<MsPerfilandon>{

	@Override
	protected MsPerfilandon atribuir(MsPerfilandon from, MsPerfilandon to, boolean isCopiarFK) {
		if (to == null) {
			to = new MsPerfilandon();
		}
		
		to.setCdPerfilandon(from.getCdPerfilandon());
		to.setDsPerfilandon(from.getDsPerfilandon());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIdPerfilandon(from.getIdPerfilandon());
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());

		if (isCopiarFK){
			if(from.getMsUsrByIdUsrRevisao() != null) {
				to.setMsUsrByIdUsrRevisao(from.getMsUsrByIdUsrRevisao().clone(false));
			}
			if(from.getMsUsrByIdUsrStAtivo() != null) {
				to.setMsUsrByIdUsrStAtivo(from.getMsUsrByIdUsrStAtivo().clone(false));
			}
			if(from.getMsPerfilregrases() != null) {
				to.setMsPerfilregrases(new HashSet<MsPerfilregras>());
				for (MsPerfilregras regra : from.getMsPerfilregrases()) {
					to.getMsPerfilregrases().add(regra.clone(false));
				}
			}
			if(from.getMsIcs() != null) {
				to.setMsIcs(new HashSet<MsIc>());
				for(MsIc ic : from.getMsIcs()) {
					to.getMsIcs().add(ic.clone(false));
				}
			}
		}
		return to;
	}

}
