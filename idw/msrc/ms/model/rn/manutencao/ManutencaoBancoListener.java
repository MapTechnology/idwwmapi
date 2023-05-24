package ms.model.rn.manutencao;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ManutencaoBancoListener implements ServletContextListener{
	private IdwLogger log =  new IdwLogger("ManutencaoBancoListener");
	private ManutencaoBanco manutencaoBanco;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Destruindo contexto ManutencaoBancoListener");
		log.info("Parando ManutencaoBanco");
		
		this.manutencaoBanco.pararThread();
		
		log.info("Contextro ManutencaoBancoListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		log.info("Inicializando ManutencaoBancoListener as " + DataHoraRN.getDataHoraAtual() );		// Inicializa a thread 
		manutencaoBanco = new ManutencaoBanco();
		manutencaoBanco.start();
		log.info("Finalizando ManutencaoBancoListener as " + DataHoraRN.getDataHoraAtual());      
		
	}
}
