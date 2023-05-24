package idw.webservices.rest;

import idw.util.IdwLogger;

public abstract class AbstractResource {
	private IdwLogger idwLogger;
	
	public AbstractResource(){
		idwLogger = new IdwLogger("WebServicesRest");
	}

	public IdwLogger getIdwLogger() {
		return idwLogger;
	}

	public void setIdwLogger(IdwLogger idwLogger) {
		this.idwLogger = idwLogger;
	}
	
	

}
