package ms.model.rn.importacao.pdba;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.rn.InfoRN;
import ms.coleta.ic.inova.Stubdelegate;
import ms.model.rn.UpRN;
import ms.util.UtilsThreads;

public class ImportacaoParaPdbaThread extends Thread{
	private IdwLogger log;
	private boolean isThreadExecutando = true;
		
	public ImportacaoParaPdbaThread() {
		this.log = new IdwLogger("ImportacaoParaPdbaThread");
		this.setName("ImportacaoParaPdbaThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}

	@Override
	public void run() {
		// Ja que essa thread foi ativa, entao informar que a conexao com a base do injet deve ser estabelecida
		Stubdelegate.getInstancia().setInjetAtivo(true);

		// Loop infinito para thread do MS
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		while (this.isThreadExecutando == true){
	        
	        // Obtem dados do MS que ir� ser executado
			int idLog = log.getIdAleatorio();
			int identacao = 0;
			
	        log.iniciaAvaliacao("Importacao para o PDBA");
			log.info(idLog, identacao, "Iniciando ImportacaoParaPdbaThread as " + DataHoraRN.getDataHoraAtualFormatada());

			// Importa as m�quinas inclusive com o objetivo de obter a lista de Prup

			UpRN upRN = new UpRN(daoPdba,daoInjet);			
			try {
				upRN.iniciaConexaoBanco();				
				
				// Importa UP
				ImportaIjtbinjParaMsUpRN importaMaquina = new ImportaIjtbinjParaMsUpRN(log, upRN.getDaoInjet(),upRN.getDaoPdba());
				importaMaquina.importar(null);
				
				upRN.getDaoPdba().flushReiniciandoTransacao();
				
				// Importa MsUp para PrUp
				ImportaMsUpParaPrUpRN importaMsUp = new ImportaMsUpParaPrUpRN(log, upRN.getDaoInjet(),upRN.getDaoPdba());
				importaMsUp.importar(null);
				
				upRN.getDaoPdba().flushReiniciandoTransacao();
				
				InfoRN infoRN = new InfoRN(upRN.getDaoInjet(),upRN.getDaoPdba());
				infoRN.verificaEventoAtivaUP(log, idLog);	
				
				upRN.getDaoPdba().flushReiniciandoTransacao();
				
			} catch (Exception e){
				e.printStackTrace();
				log.info("Ocorreu a excessao", e);
			} finally {
		        log.paraAvaliacao();
		        log.info("Finalizando ImportacaoThread as " + DataHoraRN.getDataHoraAtualFormatada() + " com " + log.getAvaliacaoCompleta() + ". Esperando 2min para proxima importa��o.");
   					
			    try{					
					upRN.finalizaConexaoBanco(log);
				} catch (Exception e2){
					e2.printStackTrace();				
					upRN.finalizaConexaoBanco(log);
					log.info("		tentando novamente finalizar conexao de upRN conexao com banco");
				}
				
			}
	        // Limpa variaveis de memoria
            upRN = null;
	        
	        // Pausa para uma nova Importacao
            //UtilsThreads.pausaNaThread(20000);
	        UtilsThreads.pausaNaThread(120000);
		}
	}

	public void pararThread(){
		this.isThreadExecutando = false;
	}
}
