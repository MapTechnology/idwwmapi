package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class ConsolidacaoLocalEstoqueListener implements ServletContextListener{

	private IdwLogger log =  new IdwLogger("ConsolidacaoLocalEstoqueListener");
	private ConsolidacaoLocalEstoqueThread consolidacaoLocalEstoqueThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		log.info("Destruindo contexto ConsolidacaoLocalEstoqueListener");
		log.info("Parando ConsolidacaoLocalEstoqueThread");
		this.consolidacaoLocalEstoqueThread.pararThread();
		log.info("Contextro ConsolidacaoLocalEstoqueListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		log.info("Inicializando ConsolidacaoLocalEstoqueListener �s " + DataHoraRN.getDataHoraAtual());
		consolidacaoLocalEstoqueThread = new ConsolidacaoLocalEstoqueThread();
		consolidacaoLocalEstoqueThread.start();
	}

}
