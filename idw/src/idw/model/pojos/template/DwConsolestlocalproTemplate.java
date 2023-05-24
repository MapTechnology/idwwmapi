package idw.model.pojos.template;

import org.apache.commons.lang3.Validate;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolestlocalpro;

public class DwConsolestlocalproTemplate  extends AbstractTemplate<DwConsolestlocalpro> implements Comparable<DwConsolestlocalpro> {

	@Override
	public int compareTo(DwConsolestlocalpro o) {
		Validate.notNull(o);
		
		Long l1 = new Long(getInstanceT().getIdConsolestlocalpro());
		return l1.compareTo(o.getIdConsolestlocalpro());		
	}

	@Override
	protected DwConsolestlocalpro atribuir(DwConsolestlocalpro from,
			DwConsolestlocalpro to, boolean isCopiarFK) {
		
		if (to == null) {
			to = new DwConsolestlocalpro();
		}
		
		to.setIdConsolestlocalpro(from.getIdConsolestlocalpro());
		to.setAno(from.getAno());
		to.setDthrFturno(from.getDthrFturno());
		to.setDthrIturno(from.getDthrIturno());
		to.setDtReferencia(from.getDtReferencia());
		to.setMes(from.getMes());
		to.setQtAjuste(from.getQtAjuste());
		to.setQtConsumida(from.getQtConsumida());
		to.setQtEntrada(from.getQtEntrada());
		to.setQtPerda(from.getQtPerda());
		to.setQtSaida(from.getQtSaida());
		to.setQtTotal(from.getQtTotal());
		
		if(isCopiarFK){
			to.setDwCal((DwCal)from.getDwCal().clone());
			to.setDwEstlocalpro(from.getDwEstlocalpro().clone(true));
			to.setDwTurno(from.getDwTurno().clone(false));
		}
		
		return to;
	}

}
