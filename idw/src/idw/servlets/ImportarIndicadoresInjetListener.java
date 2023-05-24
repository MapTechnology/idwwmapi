package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class ImportarIndicadoresInjetListener implements ServletContextListener{

	private IdwLogger log =  new IdwLogger("ImportarIndicadoresInjetListener");
	private ImportarIndicadoresInjetThread importarIndicadoresInjetThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		log.info("Destruindo contexto ImportarIndicadoresInjetListener");
		log.info("Parando ImportarIndicadoresInjetThread");
		this.importarIndicadoresInjetThread.pararThread();
		log.info("Contextro ImportarIndicadoresInjetListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		log.info("Inicializando ImportarIndicadoresInjetListener " + DataHoraRN.getDataHoraAtual());
		importarIndicadoresInjetThread = new ImportarIndicadoresInjetThread();
		importarIndicadoresInjetThread.start();
	}

}
