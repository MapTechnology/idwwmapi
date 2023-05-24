package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ImportaProgramaListener implements ServletContextListener {
	private ImportaProgramaThread importaProgramaThread = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		importaProgramaThread.setContinuaExecutando(false);
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		importaProgramaThread = new ImportaProgramaThread();
		importaProgramaThread.start();
	}

}
