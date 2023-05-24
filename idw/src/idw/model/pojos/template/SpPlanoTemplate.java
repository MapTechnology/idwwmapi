package idw.model.pojos.template;

import idw.model.pojos.SpPlano;

public class SpPlanoTemplate extends AbstractTemplate<SpPlano> {

	@Override
	protected SpPlano atribuir(SpPlano from, SpPlano to, boolean isCopiarFK) {
		if (to == null) {
			to = new SpPlano();
		}
		
		to.setIdPlano(from.getIdPlano());
		to.setProblemaOque(from.getProblemaOque());
		to.setAcaoComo(from.getAcaoComo());
		to.setPrazoiniQuando(from.getPrazoiniQuando());
		to.setPrazofimQuando(from.getPrazofimQuando());
		to.setStatusPercconclusao(from.getStatusPercconclusao());
		to.setDtalertaini(from.getDtalertaini());
		to.setDtalertafim(from.getDtalertafim());
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDtRevisao(from.getDtRevisao());
		to.setIdUsrativo(from.getIdUsrativo());
		to.setIdUsrrevisao(from.getIdUsrrevisao());
		
		if (isCopiarFK) {
			
		}
		
		return to;
	}
	
}
