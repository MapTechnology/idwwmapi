package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTAlerta;

@SuppressWarnings("serial")
public class DwTAlertaDTO implements Serializable {

	private DwTAlerta dwTAlerta;

	public DwTAlerta getDwTAlerta() {
		return dwTAlerta;
	}

	public void setDwTAlerta(DwTAlerta dwTAlerta) {
		this.dwTAlerta = dwTAlerta;
	}
		
}
