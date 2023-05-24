package idw.model.pojos.template;

import idw.model.pojos.TeLei;

public abstract class TeLeiTemplate extends AbstractTemplate<TeLei>  {

	@Override
	protected TeLei atribuir(TeLei itemGet, TeLei itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new TeLei();
		}
		itemSet.setIdLei(itemGet.getIdLei());
		itemSet.setCdLei(itemGet.getCdLei());
		itemSet.setDsLei(itemGet.getDsLei());
		itemSet.setDtIvigencia(itemGet.getDtIvigencia());
		itemSet.setDtFvigencia(itemGet.getDtFvigencia());
		/*itemSet.set(
				itemGet.getIdLei(),
				itemGet.getCdLei(),
				itemGet.getDsLei());
*/
		return itemSet;

	}


}
