package idw.model.pojos.template;

import idw.model.pojos.PpPlancol;

public class PpPlancolTemplate extends AbstractTemplate<PpPlancol> {

	@Override
	protected PpPlancol atribuir(PpPlancol from, PpPlancol to,
			boolean isCopiarFK) {
		if(to == null) {
			to = new PpPlancol();
		}
		
		to.setIdPlancol(from.getIdPlancol());
		to.setIsId(from.getIsId());
		to.setIsAcuml(from.getIsAcuml());
		to.setIsDtcobertura(from.getIsDtcobertura());
		to.setIsFim(from.getIsFim());
		to.setIsInicio(from.getIsInicio());
		to.setIsNcjt(from.getIsNcjt());
		to.setIsProdhora(from.getIsProdhora());
		to.setIsProduto(from.getIsProduto());
		to.setIsQtcjt(from.getIsQtcjt());
		to.setIsQtdmagaz(from.getIsQtdmagaz());
		to.setIsQtplan(from.getIsQtplan());
		to.setIsRoteiro(from.getIsRoteiro());
		to.setIsSt(from.getIsSt());
		to.setIsApAberta(from.getIsApAberta());
		to.setIsTmpestim(from.getIsTmpestim());
		to.setIsTurno(from.getIsTurno());
		to.setIsProducao(from.getIsProducao());
		to.setIsSaldoproduzir(from.getIsSaldoproduzir());
		to.setIsIniciosaldo(from.getIsIniciosaldo());
		
		if(isCopiarFK) {
			to.setPpPlano(from.getPpPlano().clone(false));
		}
		
		return to;
	}

}
