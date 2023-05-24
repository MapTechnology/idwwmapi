package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwConsolpa;

@SuppressWarnings("serial")
public class ConsolpaDTO implements Serializable {
	
private DwConsolpa DwConsolpa;

public DwConsolpa getDwConsolpa() {
	return DwConsolpa;
}

public void setDwConsolpa(DwConsolpa dwConsolpa) {
	DwConsolpa = dwConsolpa;
}


}
