package idw.model.rn.relatorios.opprocessada;

import idw.model.pojos.DwConsolid;
import idw.webservices.dto.FiltroRelatorioOPProcessadaDTO;

public class DeterminaAgrupador {
	
	private String agrupador;
	
	public DeterminaAgrupador() {
		super();
	}
	
	public DeterminaAgrupador(DwConsolid id, FiltroRelatorioOPProcessadaDTO filtro) {
		super();
		
		if (filtro.getTipoAgrupamento() == FiltroRelatorioOPProcessadaDTO.TipoAgrupamento.MAQUINA.getValue() ) {
			agrupador = id.getOmPt().getCdPt();
		} else if (filtro.getTipoAgrupamento() == FiltroRelatorioOPProcessadaDTO.TipoAgrupamento.OP.getValue() ) {
			agrupador = id.getPpCp().getNrop();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agrupador == null) ? 0 : agrupador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeterminaAgrupador other = (DeterminaAgrupador) obj;
		if (agrupador == null) {
			if (other.agrupador != null)
				return false;
		} else if (!agrupador.equals(other.agrupador))
			return false;
		return true;
	}

}
