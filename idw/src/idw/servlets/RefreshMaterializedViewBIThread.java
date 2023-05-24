package idw.servlets;
 

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN; 
import idw.util.ThreadUtil;

public class RefreshMaterializedViewBIThread extends Thread {
	
	private final long DELAY_REFRESH = IdwFacade.TEMPO_EM_SEGUNDOS_REFRESH_MATERIALIZED_VIEW_BI * 1000;

	//private IdwLogger log = null;
	private boolean isThreadExecutando = true;
	 
	public RefreshMaterializedViewBIThread() {
		this.setName("RefreshMaterializedViewBIThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}

	@Override
	public void run() {
		//this.log = new IdwLogger("RefreshMaterializedViewBIThread");

		// Loop infinito para thread de gerenciamento de jobs
		while (this.isThreadExecutando == true){
			//int idLog = this.log.getIdAleatorio();

	     	//this.log.info(idLog, 0, "Iniciando RefreshMaterializedViewBIThread " + DataHoraRN.getDataHoraMiliAtualFormatada());

			RefreshRN rn = new RefreshRN();
			try {
				rn.iniciaConexaoBanco();
				rn.refresh();
				
			} catch (Exception e) {
				//log.info(idLog, 5, "Erro:", e);
				e.printStackTrace();
			} finally {
				rn.finalizaConexaoBanco();
			}
			
			rn = null; // ajudar o GB na limpeza
			
			/*
	        this.log.info(idLog, 0,
	        		  "Finalizando RefreshMaterializedViewBIThread "		        		 
	        		+ " com " + this.log.getAvaliacaoCompleta()
	        		+ ". Esperando " + (this._DELAY_GERENCIADOR /1000 /60) + "min para proxima importação.");
			*/
			
			// Pausa para uma nova Importacao
	        ThreadUtil.pausaNaThread(this.DELAY_REFRESH);
		}

	}

	public void pararThread(){
		this.isThreadExecutando = false;
	}
	
	private class RefreshRN extends AbstractRN<DAOGenerico> implements IDao {
		private RefreshRN() {
			super(new DAOGenerico());
		}
		
		private void refresh() {
			String cmdDML = "";
			
			if (DELAY_REFRESH > 0) {
				cmdDML = "REFRESH MATERIALIZED VIEW viewBIDtRefQtds";
				this.getDaoSession().createSQLQuery(cmdDML).executeUpdate();
				
				cmdDML = "REFRESH MATERIALIZED VIEW viewBIDtRefTempos";
				this.getDaoSession().createSQLQuery(cmdDML).executeUpdate();
				
				cmdDML = "REFRESH MATERIALIZED VIEW viewBIDtRefProdutos";
				this.getDaoSession().createSQLQuery(cmdDML).executeUpdate();
				
				cmdDML = "REFRESH MATERIALIZED VIEW viewBIAnoMesQtds";
				this.getDaoSession().createSQLQuery(cmdDML).executeUpdate();
				
				cmdDML = "REFRESH MATERIALIZED VIEW viewBIAnoMesTempos";
				this.getDaoSession().createSQLQuery(cmdDML).executeUpdate();
				
				cmdDML = "REFRESH MATERIALIZED VIEW viewBIAnoMesProdutos";	
				this.getDaoSession().createSQLQuery(cmdDML).executeUpdate();	
			}
		}
	}
}
