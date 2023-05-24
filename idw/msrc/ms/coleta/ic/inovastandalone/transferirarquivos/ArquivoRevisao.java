package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class ArquivoRevisao{

	private IdwLogger log;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten(DataHoraRN.dateToString(DataHoraRN.getDataHoraAtual(), "dd/MM/yyyy HH:mm:ss"));
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
}
