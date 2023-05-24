package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;

public class DetalhesDTO {
	List<Long> idProcativs = new ArrayList<Long>();

	public List<Long> getIdProcativs() {
		return idProcativs;
	}

	public void setIdProcativs(List<Long> idProcativs) {
		this.idProcativs = idProcativs;
	}
}
