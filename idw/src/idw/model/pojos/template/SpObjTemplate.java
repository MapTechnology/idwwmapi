package idw.model.pojos.template;

import idw.model.pojos.SpObj;

public class SpObjTemplate extends AbstractTemplate<SpObj> {
	
	@Override
	protected SpObj atribuir(SpObj from, SpObj to, boolean isCopiarFK) {
		if (to == null) {
			to = new SpObj();
		}
		
		to.setIdObj(from.getIdObj());
		to.setSpProblema(from.getSpProblema());
		to.setTextoobj(from.getTextoobj());
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDtRevisao(from.getDtRevisao());
		to.setIdUsrativo(from.getIdUsrativo());
		to.setIdUsrrevisao(from.getIdUsrrevisao());
		
		return to;
	}

}
