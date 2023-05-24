package idw.model.pojos.template;

import org.hibernate.SessionException;

import idw.model.pojos.SpSetor;

public class SpSetorTemplate extends AbstractTemplate<SpSetor> {
	
	@Override
	protected SpSetor atribuir(SpSetor from, SpSetor to, boolean isCopiarFK) {
		if (to == null) {
			to = new SpSetor();
		}
		
		to.setIdSetor(from.getIdSetor());
		to.setCdSetor(from.getCdSetor());
		to.setDsSetor(from.getDsSetor());		
		to.setTpSetor(from.getTpSetor());
		to.setOrdem(from.getOrdem());		
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDtRevisao(from.getDtRevisao());
		to.setIdUsrativo(from.getIdUsrativo());
		to.setIdUsrrevisao(from.getIdUsrrevisao());
		
		if(isCopiarFK) {
			if(from.getOmGt() != null) {
				try {
					to.setOmGt(from.getOmGt().clone(false));
				} catch(SessionException e) {
					to.setOmGt(null);
				}
			}
		}
		
		return to;
	}

}
