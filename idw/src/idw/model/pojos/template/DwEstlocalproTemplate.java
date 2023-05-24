package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.PpCp;

public class DwEstlocalproTemplate extends AbstractTemplate<DwEstlocalpro> {

	public static DwEstlocalpro newDwEstlocalpro(DwEstlocal dwEstlocal,
			DwEstpro dwEstpro, PpCp ppCp, BigDecimal qtTotal) {
		DwEstlocalpro dwEstlocalpro = new DwEstlocalpro();
		dwEstlocalpro.setDwEstlocal(dwEstlocal);
		dwEstlocalpro.setDwEstpro(dwEstpro);
		dwEstlocalpro.setPpCp(ppCp);
		dwEstlocalpro.setQtTotal(qtTotal);
		dwEstlocalpro.setQtAjuste(qtTotal);
		dwEstlocalpro.setQtEntrada(BigDecimal.ZERO);
		dwEstlocalpro.setQtSaida(BigDecimal.ZERO);
		return dwEstlocalpro;
	}

	@Override
	protected DwEstlocalpro atribuir(DwEstlocalpro from, DwEstlocalpro to,
			boolean isCopiarFK) {
		if (to == null) {
			to = new DwEstlocalpro();
		}

		to.setIdEstlocalpro(from.getIdEstlocalpro());
		to.setQtAjuste(from.getQtAjuste());
		to.setQtEntrada(from.getQtEntrada());
		to.setQtSaida(from.getQtSaida());
		to.setQtTotal(from.getQtTotal());

		if (isCopiarFK == true) {
			if (from.getDwEstlocal() != null) {
				to.setDwEstlocal(from.getDwEstlocal().clone(true));
			}
			if (from.getDwEstpro() != null) {
				to.setDwEstpro(from.getDwEstpro().clone(true));
			}
			if (from.getPpCp() != null) {
				to.setPpCp(from.getPpCp().clone(false));
			}
		}
		return to;
	}

}
