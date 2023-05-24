package ms.model.rn.manutencao;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ms.coleta.ic.inova.Util;
import ms.model.MsFacade;
import ms.util.UtilsThreads;

public class ManutencaoBanco extends Thread{
	private IdwLogger log;
	private boolean isThreadExecutando = true;
	private int idLog;
	Calendar dthrUltimaVerificacao=null;
	private final static int REF_TIMEOUT=300;
	private final static int MAXIMO_REGISTROS=1000;
	private final static int DIAS_PARA_EXCLUSAO=10;

	public ManutencaoBanco() {
		this.dthrUltimaVerificacao = new GregorianCalendar();
		this.log = new IdwLogger("MSThread");
		this.setName("MSThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSms(DataHoraRN.getDataHoraAtual()));
	}
	
	private boolean executaManutencaoMsEvt(){
		boolean retorno=false;
		if(Util.getVerificaElapsedTime(this.dthrUltimaVerificacao , REF_TIMEOUT)){
			//Obtem data e hora para referencia de exclusão
			Calendar dthrrefExclusao= new GregorianCalendar();
			dthrrefExclusao.add(Calendar.DATE, -DIAS_PARA_EXCLUSAO);
			//executa metodo de manutençãoo do banco
			retorno=MsFacade.getInstancia().executaManutencaoMsEvt(log,dthrrefExclusao.getTime(), MAXIMO_REGISTROS);
			
	        atualizaReferencia(); //sempre atualiza a referÃŠncia
		}
		return retorno;		
	}
	
	@Override
	public void run() {
		idLog = log.getIdAleatorio();
		while (this.isThreadExecutando == true){
			log.info(idLog, 0, "executaManutencaoMsEvt para dthrverificacao=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(this.dthrUltimaVerificacao.getTime()));
			 //executa Manutençãoo de banco
	        executaManutencaoMsEvt();
	        UtilsThreads.pausaNaThread(300000);
		}
	}
	
	private void atualizaReferencia(){
		this.dthrUltimaVerificacao = new GregorianCalendar();
	}
	public void pararThread(){
		this.isThreadExecutando = false;
	}


}
