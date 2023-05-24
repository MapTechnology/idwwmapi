package ms.model.rn.importacao.mws;

import idw.util.IdwLogger;
import idw.model.dao.mws.DAOGenericoMws;
import idw.model.dao.tdba.DAOGenericoTdba;
import idw.model.dao.injet.DAOGenericoInjet;

import idw.model.rn.DataHoraRN;
import ms.util.UtilsThreads;

public class ImportacaoParaTdbaThread extends Thread{
	private IdwLogger log;
	private boolean isThreadExecutando = true;
	
	public ImportacaoParaTdbaThread(){
		this.log = new IdwLogger("ImportacaoParaTdbaThread");
		this.setName("ImportacaoParaTdbaThread-" + idw.model.rn.DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}

	@Override
	public void run(){
		DAOGenericoTdba  daoTdba = new DAOGenericoTdba();
		DAOGenericoMws daoMws = new DAOGenericoMws();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
	
		
		while(this.isThreadExecutando == true){
			
			int idLog = log.getIdAleatorio();
			int identacao = 0;
			
			log.iniciaAvaliacao("ImportacaoParaTdba");
			log.info(idLog, identacao, "Iniciando ImportacaoParaTdbaThread: " + DataHoraRN.getDataHoraAtual());
			try{
				ImportaMovimentacaoParaTdba importaTdba = new ImportaMovimentacaoParaTdba(log, daoMws, daoTdba, daoInjet);
				importaTdba.iniciaConexaoBanco();
				importaTdba.importar(null);
				importaTdba.finalizaConexaoBanco();
			}catch(Exception e ){
				log.error(idLog, identacao, "Ocorreu a excessao: " +  e.getMessage() );
				e.printStackTrace();
			}
			UtilsThreads.pausaNaThread(10000);
		}
	}
	
	public void pararThread(){
		this.isThreadExecutando = false;
	}
	
}
