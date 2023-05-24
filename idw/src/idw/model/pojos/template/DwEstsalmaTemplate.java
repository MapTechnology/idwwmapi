package idw.model.pojos.template;

import idw.model.pojos.DwEstsalma;

/**
 * Devido o fato do SAP da Panasonic nao gerenciar alguns semi-acabados do IAC como por exemplo algumas placas das jumpers. 
 * <br>Eh necessário guarda o input manual desses saldos. Esse input será utilizado como base de entrada do saldo inicial durante a importacao dos saldos.
 *
 */
public abstract class DwEstsalmaTemplate extends AbstractTemplate<DwEstsalma> {

	@Override
	protected DwEstsalma atribuir(DwEstsalma itemGet, DwEstsalma itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwEstsalma();

		itemSet.setDtReferencia(itemGet.getDtReferencia());
		itemSet.setIdEstsalma(itemGet.getIdEstsalma());
		itemSet.setQtSaldofinalmes(itemGet.getQtSaldofinalmes());
		
		if (isCopiarFK == true)
			itemSet.setOmProduto(itemGet.getOmProduto().clone(false));
				
		return itemSet;
	}	
}
