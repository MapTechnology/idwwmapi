package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.IdwFacade;  

public class RefreshMaterializedViewBIListener implements ServletContextListener {
	private RefreshMaterializedViewBIThread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (IdwFacade.TEMPO_EM_SEGUNDOS_REFRESH_MATERIALIZED_VIEW_BI > 0) {
			thread.pararThread();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//log.info("Inicializando RefreshMaterializedViewBIListener " + DataHoraRN.getDataHoraAtual());
		if (IdwFacade.TEMPO_EM_SEGUNDOS_REFRESH_MATERIALIZED_VIEW_BI > 0) {
			thread = new RefreshMaterializedViewBIThread();
			thread.start();			
		}
		
	}
}