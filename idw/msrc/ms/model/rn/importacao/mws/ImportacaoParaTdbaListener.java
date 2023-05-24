package ms.model.rn.importacao.mws;

import idw.util.IdwLogger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;

public class ImportacaoParaTdbaListener implements ServletContextListener {
	private IdwLogger log = new IdwLogger("ImportacaoParaTdbaListener");
	
	
	
	private ImportacaoParaTdbaThread msThread;
			
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("Destruindo Context ImportacaoParaTdbaListener");
		
		log.info("Parando ImportacaoParaTdbaListener");
		
		this.msThread.pararThread();
		log.info("Contexto ImportacaoParaTdbaListener Destruido");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("inicializando ImportacaoParaTdbaListener as " + DataHoraRN.getDataHoraAtual());
		
		//inicializa a thread
		msThread = new ImportacaoParaTdbaThread();
		msThread.start();
		
	}

}
