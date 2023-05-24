package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ms.coleta.ic.inovastandalone.GerarSessoesInovaStandaloneThread;

public class GerarSessoesInovaStandaloneListener implements ServletContextListener {
	private GerarSessoesInovaStandaloneThread rn = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		rn.pararThread();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		rn = new GerarSessoesInovaStandaloneThread();
		rn.start();
	}

}
