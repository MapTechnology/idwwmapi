package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.HashSet;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmProduto;
import idw.util.CloneUtil;

public abstract class DwEstProTemplate extends AbstractTemplate<DwEstpro> {

	public static DwEstpro newDwEstpro(DwEst dwEst, OmProduto omProduto, BigDecimal qtTotal){
		DwEstpro dwEstpro = new DwEstpro();
		dwEstpro.setIdEstpro(null);
		dwEstpro.setDwEst(dwEst);
		dwEstpro.setOmProduto(omProduto);
		dwEstpro.setPpCliente(omProduto.getPpCliente());
		dwEstpro.setQtTotal(qtTotal);
		dwEstpro.setQtAjuste(qtTotal);
		dwEstpro.setQtEntrada(BigDecimal.ZERO);
		dwEstpro.setQtReservada(BigDecimal.ZERO);
		dwEstpro.setQtSaida(BigDecimal.ZERO);
		return dwEstpro;
	}
	
	@Override
	protected DwEstpro atribuir(DwEstpro from, DwEstpro to, boolean isCopiarFK) {

		if (to == null){
			to = new DwEstpro();
		}
		
		to.setIdEstpro(from.getIdEstpro());
		to.setQtAjuste(from.getQtAjuste());
		to.setQtEntrada(from.getQtEntrada());
		to.setQtReservada(from.getQtReservada());
		to.setQtSaida(from.getQtSaida());
		to.setQtTotal(from.getQtTotal());
		to.setDthrAjuste(from.getDthrAjuste());
		to.setDthrEntrada(from.getDthrEntrada());
		to.setDthrSaida(from.getDthrSaida());
		to.setDthrTotal(from.getDthrTotal());
		
		to.setDwEstmovs(new HashSet<DwEstmov>());
		if(isCopiarFK){
			to.setDwEst(CloneUtil.clone(from.getDwEst(), false));
			
			to.setOmProduto(CloneUtil.clone(from.getOmProduto(), false));
			to.setPpCliente(CloneUtil.clone(from.getPpCliente(), false));
			
			for (DwEstmov estmov : from.getDwEstmovs()) {
				to.getDwEstmovs().add((DwEstmov) estmov.clone(false));
			}
			
		}
		
		return to;

	}
}
