package idw.model.pojos.template;

import idw.model.pojos.DwEstmovRap;

public class DwEstmovRapTemplate  extends AbstractTemplate<DwEstmovRap> {

	@Override
	protected DwEstmovRap atribuir(DwEstmovRap from, DwEstmovRap to, boolean isCopiarFK) {
		if (to == null)
			to = new DwEstmovRap();
		
		to.setIdEstmovrap(from.getIdEstmovrap());
		to.setDthrMovimentacao(from.getDthrMovimentacao());
		
		if (isCopiarFK) {
			if (from.getDwEstlocalDestino() != null)
				to.setDwEstlocalDestino(from.getDwEstlocalDestino().clone(false));
			else
				to.setDwEstlocalDestino(null);
			
			if (from.getDwEstlocalOrigem() != null)
				to.setDwEstlocalOrigem(from.getDwEstlocalOrigem().clone(false));
			else
				to.setDwEstlocalOrigem(null);
			if (from.getDwRap() != null)
				to.setDwRap(from.getDwRap().clone(false));
			else
				to.setDwRap(null);
			if (from.getOmUsr() != null)
				to.setOmUsr(from.getOmUsr().clone(false));
			else
				to.setOmUsr(null);
			
		}
		return to;
	}

}
