package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class EnvioWhatsappListener implements ServletContextListener{

	private IdwLogger log =  new IdwLogger("EnvioWhatsappListener");
	private EnvioWhatsappThread rn;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		log.info("Destruindo contexto EnvioWhatsappListener");
		log.info("Parando EnvioWhatsappListener");
		this.rn.pararThread();
		log.info("Contextro EnvioWhatsappListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		log.info("Inicializando EnvioWhatsappListener " + DataHoraRN.getDataHoraAtual());
		rn = new EnvioWhatsappThread();
		rn.start();
	}

}
