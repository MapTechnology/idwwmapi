package ms.coleta.ic.drivercoleta;

import idw.util.IdwLogger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DriverColetaListener implements ServletContextListener {
	
	private IdwLogger log =  new IdwLogger("DriverColetaListener");
	private DriverColetaThread drivercoleta = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		drivercoleta.setContinuaExecutando(false);
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		drivercoleta = new DriverColetaThread(arg0.getServletContext().getRealPath("")+"/coleta/maquinas/", log);
		drivercoleta.start();
	}

}
