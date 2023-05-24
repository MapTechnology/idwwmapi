package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ConsolpasDTO implements Serializable{
private List<ConsolpaDTO> dwConsolpa;

public List<ConsolpaDTO> getDwConsolpa() {
	return dwConsolpa;
}

public void setDwConsolpa(List<ConsolpaDTO> dwConsolpa) {
	this.dwConsolpa = dwConsolpa;
}
	
}
