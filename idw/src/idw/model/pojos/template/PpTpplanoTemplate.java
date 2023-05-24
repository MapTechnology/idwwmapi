package idw.model.pojos.template;

import idw.model.pojos.PpTpplano;

public class PpTpplanoTemplate extends AbstractTemplate<PpTpplano> {

	@Override
	protected PpTpplano atribuir(PpTpplano from, PpTpplano to,
			boolean isCopiarFK) {
		if(to == null) {
			to = new PpTpplano();
		}
		to.setIdTpplano(from.getIdTpplano());
		to.setDsTpplano(from.getDsTpplano());
		to.setTpAlgoritmo(from.getTpAlgoritmo());
		to.setIndOee(from.getIndOee());
		to.setIsConsiderarcal(from.getIsConsiderarcal());
		to.setIsConsiderarcm(from.getIsConsiderarcm());
		to.setIsConsiderarest(from.getIsConsiderarest());
		to.setIsConsiderarindisp(from.getIsConsiderarindisp());
		to.setIsConsiderarmo(from.getIsConsiderarmo());
		to.setIsConsiderarmp(from.getIsConsiderarmp());
		to.setIsConsideraroeefinalserie(from.getIsConsideraroeefinalserie());
		to.setIsConsiderarprodutoturno(from.getIsConsiderarprodutoturno());
		to.setIsConsiderarrap(from.getIsConsiderarrap());
		to.setIsDeterminadocal(from.getIsDeterminadocal());
		
		return to;
	}

}
