package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.TeConcessionaria;
import idw.model.pojos.TeLei;
import idw.model.pojos.TeTarifas;
import idw.model.pojos.TeTarifasemanal;
import idw.model.pojos.TeTipoConsumidor;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class TeTarifasTemplate extends AbstractTemplate<TeTarifas> {

	/**
	 * Campos usados no equals: CdTarifas, DsTarifas, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final TeTarifas teTarifasOther = (TeTarifas) o;
			final TeTarifas teTarifas = (TeTarifas) this;
			equals = (new EqualsBuilderIdw())
						.append(teTarifas.getTeConcessionaria(), teTarifasOther.getTeConcessionaria())
						.append(teTarifas.getTeLei(), teTarifasOther.getTeLei())
						.append(teTarifas.getTeTarifasemanals(), teTarifasOther.getTeTarifasemanals())
						.append(teTarifas.getTeTipoConsumidor(), teTarifasOther.getTeTipoConsumidor())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdConcessionaria, DsConcessionaria, StAtivo
	 */
	@Override
	public int hashCode(){
		TeTarifas teTarifas = (TeTarifas) this;
		return (new HashCodeBuilderIdw())
				.append(teTarifas.getTeConcessionaria())
				.append(teTarifas.getTeLei())
				.append(teTarifas.getTeTarifasemanals())
				.append(teTarifas.getTeTipoConsumidor())
				.toHashCode();
	}


	public void set(long idTarifas, TeTipoConsumidor teTipoConsumidor,
			TeConcessionaria teConcessionaria, TeLei teLei,
			Date dtInicioTarifa, Date dtFimTarifa ) {
		TeTarifas teTarifa = (TeTarifas) this;
		teTarifa.setIdTarifas(idTarifas);
		teTarifa.setTeTipoConsumidor(teTipoConsumidor);
		teTarifa.setTeConcessionaria(teConcessionaria);
		teTarifa.setTeLei(teLei);
		teTarifa.setDtInicioTarifa(dtInicioTarifa);
		teTarifa.setDtFimTarifa(dtFimTarifa);
	}

	@Override
	protected TeTarifas atribuir(TeTarifas itemGet, TeTarifas itemSet, boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new TeTarifas();
		}
		itemSet.set(
				itemGet.getIdTarifas(),
				null,
				null,
				null,
				itemGet.getDtInicioTarifa(),
				itemGet.getDtFimTarifa());
		if(isCopiarFK){
			itemSet.setTeConcessionaria(itemGet.getTeConcessionaria().clone());
			itemSet.setTeTipoConsumidor(itemGet.getTeTipoConsumidor().clone());
			itemSet.setTeLei(itemGet.getTeLei().clone());
			for (TeTarifasemanal teTarifasemanals : itemGet.getTeTarifasemanals()){
				itemSet.getTeTarifasemanals().add((TeTarifasemanal) teTarifasemanals.clone());
			}
		}
		return itemSet;

	}

}
