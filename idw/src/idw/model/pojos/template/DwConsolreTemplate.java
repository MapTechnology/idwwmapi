package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.DwConsolre;

public abstract class DwConsolreTemplate extends AbstractTemplate<DwConsolre>{

	public abstract BigDecimal getPcsAutoProducaorefugada();
	public abstract BigDecimal getPcsManuProducaorefugada();
	public abstract void setPcsAutoProducaorefugada(BigDecimal pcsAutoProducaorefugada);
	public abstract void setPcsManuProducaorefugada(BigDecimal pcsManuProducaorefugada);

	@Override
	protected DwConsolre atribuir(DwConsolre itemGet, DwConsolre itemSet, boolean isCopiarFK) {

		if (itemSet == null)
			itemSet = new DwConsolre();
		
		itemSet.setIdConsolre(itemGet.getIdConsolre());
		itemSet.setPcsAutoProducaorefugada(itemGet.getPcsAutoProducaorefugada());
		itemSet.setPcsManuProducaorefugada(itemGet.getPcsManuProducaorefugada());
		
		if (isCopiarFK){
			if (itemGet.getDwTRefugo() != null){
				itemSet.setDwTRefugo(itemGet.getDwTRefugo().clone(false));
			}
		}

		return itemSet;
	}
	
	public BigDecimal getPcsProducaorefugada() {
		BigDecimal retorno = BigDecimal.ZERO;
		if (getPcsAutoProducaorefugada() != null)
			retorno = retorno.add(getPcsAutoProducaorefugada());
		if (getPcsManuProducaorefugada() != null)
			retorno = retorno.add(getPcsManuProducaorefugada());
		
		return retorno;
	}
}
