package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class ImportarIpackChemListener implements ServletContextListener
{
	private IdwLogger log =  new IdwLogger("ImportarIpackChemListener");
	private ImportarIpackChemThread importarIpackChemThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		log.info("Destruindo contexto ImportarIpackChemListener");
		log.info("Parando ImportarIndicadoresInjetThread");
		this.importarIpackChemThread.pararThread();
		log.info("Contextro ImportarIpackChemListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		log.info("Inicializando ImportarIpackChemListener - " + DataHoraRN.getDataHoraAtual());
		importarIpackChemThread = new ImportarIpackChemThread();
		importarIpackChemThread.start();
	}	
}
