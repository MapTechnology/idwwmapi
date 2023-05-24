package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.DwConsolrelog;

public abstract class DwConsolrelogTemplate extends AbstractTemplate<DwConsolrelog>{

	
	public abstract BigDecimal getPcsAutoProducaorefugada();
	public abstract BigDecimal getPcsManuProducaorefugada();
	public abstract void setPcsAutoProducaorefugada(BigDecimal pcsAutoProducaorefugada);
	public abstract void setPcsManuProducaorefugada(BigDecimal pcsManuProducaorefugada);

	
	
	@Override
	protected DwConsolrelog atribuir(DwConsolrelog itemGet, DwConsolrelog itemSet, boolean isCopiarFK) {

		if (itemSet == null)
			itemSet = new DwConsolrelog();
		
		itemSet.setDthrCancelado(itemGet.getDthrCancelado());
		itemSet.setDthrRefugo(itemGet.getDthrRefugo());
		itemSet.setIdConsolrelog(itemGet.getIdConsolrelog());
		itemSet.setIsCancelado(itemGet.getIsCancelado());
		itemSet.setIsLancadotm(itemGet.getIsLancadotm());
		itemSet.setMsDthrrefugo(itemGet.getMsDthrrefugo());
		itemSet.setPcsAutoProducaorefugada(itemGet.getPcsAutoProducaorefugada());
		itemSet.setPcsManuProducaorefugada(itemGet.getPcsManuProducaorefugada());
		
		if (isCopiarFK){
			if (itemGet.getDwTAcao() != null)
				itemSet.setDwTAcao(itemGet.getDwTAcao().clone(false));
			if (itemGet.getDwTCausa() != null)
				itemSet.setDwTCausa(itemGet.getDwTCausa().clone(false));
			if (itemGet.getDwTRefugo() != null)
				itemSet.setDwTRefugo(itemGet.getDwTRefugo().clone(false));
			if (itemGet.getOmProduto() != null)
				itemSet.setOmProduto(itemGet.getOmProduto().clone(false));
			if (itemGet.getOmPt() != null)
				itemSet.setOmPt(itemGet.getOmPt().clone(false));
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
