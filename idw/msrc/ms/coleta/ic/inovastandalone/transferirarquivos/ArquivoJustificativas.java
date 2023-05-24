package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwTJust;
import idw.util.IdwLogger;

public class ArquivoJustificativas {
	private DwTJust dwtjust = null;
	private IdwLogger log;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten(""+dwtjust.getOmTppt().getIdTppt());
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public DwTJust getDwtjust() {
		return dwtjust;
	}

	public void setDwtjust(DwTJust dwtjust) {
		this.dwtjust = dwtjust;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
	
}
