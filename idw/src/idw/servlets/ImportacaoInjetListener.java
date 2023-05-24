package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class ImportacaoInjetListener implements ServletContextListener{
	private IdwLogger log =  new IdwLogger("ImportacaoInjetListener");
	private ImportacaoInjetThread importacaoInjetThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Destruindo contexto ImportacaoInjetListener");

		log.info("Parando ImportacaoInjetThread");
		this.importacaoInjetThread.pararThread();
		
		log.info("Contextro ImportacaoInjetListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		log.info("Inicializando ImportacaoInjetListener as " + DataHoraRN.getDataHoraAtual());

		// Inicializa a thread de importa��o do Injet
		importacaoInjetThread = new ImportacaoInjetThread();
		importacaoInjetThread.start();
	}
}
