package ms.model.rn.importacao.pdba;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;

public class ImportacaoParaPdbaListener implements ServletContextListener{
	private IdwLogger log =  new IdwLogger("ImportacaoParaPdbaListener");
	private ImportacaoParaPdbaThread msthread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Destruindo contexto ImportacaoParaPdbaListener");

		log.info("Parando ImportacaoParaPdbaThread");
		this.msthread.pararThread();
		
		log.info("Contextro ImportacaoParaPdbaListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {		
			
		log.info("Inicializando ImportacaoListener as " + DataHoraRN.getDataHoraAtual());
	
        if(Boolean.parseBoolean(arg0.getServletContext().getInitParameter("isCdParadaPadraoInjet"))==true){
        	log.info("Ativando isCdParadaPadraoInjet =True códigod de parada serão completados com Zeros à esquerda");
        	IwsFacade.getInstancia().setCdParadaPadraoInjet(true);        	
        }else{
        	log.info("isCdParadaPadraoInjet = FALSE em Web.xml  O código de parada não terá zeros à esquerda");
        	IwsFacade.getInstancia().setCdParadaPadraoInjet(false);        	
        }
	
		msthread = new ImportacaoParaPdbaThread();
		msthread.start();
	}
}
