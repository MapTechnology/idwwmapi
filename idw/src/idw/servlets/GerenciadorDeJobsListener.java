package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class GerenciadorDeJobsListener implements ServletContextListener {

	private IdwLogger log =  new IdwLogger("GerenciadorDeJobsListener");
	private GerenciadorDeJobsThread gerenciador;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Destruindo contexto GerenciadorDeJobsListener");
		log.info("Parando ImportarIndicadoresInjetThread");
		gerenciador.pararThread();
		log.info("Contextro GerenciadorDeJobsListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("Inicializando GerenciadorDeJobsListener " + DataHoraRN.getDataHoraAtual());
		gerenciador = new GerenciadorDeJobsThread();
		gerenciador.start();
	}
}
