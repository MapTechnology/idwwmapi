package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwTCausa;
import idw.util.IdwLogger;

public class ArquivoCausas {
	
	private DwTCausa dwtcausa = null;
	private IdwLogger log;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten(""+dwtcausa.getOmTppt().getIdTppt());
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public DwTCausa getDwtcausa() {
		return dwtcausa;
	}

	public void setDwtcausa(DwTCausa dwtcausa) {
		this.dwtcausa = dwtcausa;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
	

}
