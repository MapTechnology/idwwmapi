package idw.servlets;

import idw.model.dao.DAOGenerico;
import idw.model.rn.DataHoraRN;
import idw.model.rn.consolidacao.estoque.ConsolidacaoLocalEstoque;
import idw.util.IdwLogger;

public class ConsolidacaoLocalEstoqueThread extends Thread {

	private boolean isThreadExecutando = true;
	private final int DELAY_AUTO_UPDATE = 1000;
	private final int QTD_REGISTROS = 100;

	public ConsolidacaoLocalEstoqueThread() {
		this.setName(ConsolidacaoLocalEstoqueThread.class.getName() + "-" 
				+ DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN
						.getDataHoraAtual()));
	}

	@Override
	public void run() {

		DAOGenerico dao = new DAOGenerico();
		ConsolidacaoLocalEstoque consolidacaoLocalEstoque = new ConsolidacaoLocalEstoque(dao);

		IdwLogger log = new IdwLogger("ConsolidacaoLocalEstoqueThread");
		
		while (isThreadExecutando) {
			
			try{
				int idLog = log.getIdAleatorio();
				dao.iniciaConexaoBanco(null);
				consolidacaoLocalEstoque.consolidarTabelaTemporariaLocalEstoque(log, idLog, QTD_REGISTROS);
			}catch(Exception e){
				e.printStackTrace();
				dao.rollBackTransacaoSemException();
			}finally{
				dao.finalizaConexaoBancoSemException();
			}
			
			
			try {
				Thread.sleep(DELAY_AUTO_UPDATE);
			} catch (InterruptedException ex) {

			}
			
		}
	}

	public void pararThread() {
		this.isThreadExecutando = false;
	}

}
