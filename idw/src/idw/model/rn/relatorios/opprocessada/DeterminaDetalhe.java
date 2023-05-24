package idw.model.rn.relatorios.opprocessada;

import idw.model.pojos.DwConsolid;

public class DeterminaDetalhe {

	private DwConsolid id;
	
	public DeterminaDetalhe() {
		super();
	}
	
	public DeterminaDetalhe(DwConsolid id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : (id.getOmPt().getCdPt() + id.getPpCp().getNrop()).hashCode());
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
		DeterminaDetalhe other = (DeterminaDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else {
			// testa se eho mesmo pt ou op
			return id.getOmPt().getCdPt().equals(other.id.getOmPt().getCdPt()) && id.getPpCp().getNrop().equals(other.id.getPpCp().getNrop());
		}
		return true;
	}
}
