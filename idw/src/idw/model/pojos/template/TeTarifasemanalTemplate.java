package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.TeTarifas;
import idw.model.pojos.TeTarifasemanal;

public abstract class TeTarifasemanalTemplate extends AbstractTemplate<TeTarifasemanal> {

	public void set(long idTarifasemanal, TeTarifas teTarifas, Integer diaSemanaInicio,
			Integer diaSemanaFim, BigDecimal hrInicio, BigDecimal hrFim,
			BigDecimal vlTarifademanda,  BigDecimal vlTarifaconsumo) {

		TeTarifasemanal teTarifasemanal = (TeTarifasemanal) this;
		teTarifasemanal.setIdTarifasemanal(idTarifasemanal);
		teTarifasemanal.setDiaSemanaInicio(diaSemanaInicio);
		teTarifasemanal.setDiaSemanaFim(diaSemanaFim);
		teTarifasemanal.setHrInicio(hrInicio);
		teTarifasemanal.setHrFim(hrFim);
		teTarifasemanal.setVlTarifaconsumo(vlTarifaconsumo);
		teTarifasemanal.setVlTarifademanda(vlTarifademanda);
		teTarifasemanal.setTeTarifas(teTarifas);
	}

	@Override
	protected TeTarifasemanal atribuir(TeTarifasemanal itemGet, TeTarifasemanal itemSet, boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new TeTarifasemanal();
		}

		itemSet.set(
				itemGet.getIdTarifasemanal(),
				null,
				itemGet.getDiaSemanaInicio(),
				itemGet.getDiaSemanaFim(),
				itemGet.getHrInicio(),
				itemGet.getHrFim(),
				itemGet.getVlTarifademanda(),
				itemGet.getVlTarifaconsumo());
		
		return itemSet;

	}



}
