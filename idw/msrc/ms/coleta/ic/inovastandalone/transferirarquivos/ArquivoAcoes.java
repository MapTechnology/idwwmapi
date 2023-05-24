package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwTAcao;
import idw.util.IdwLogger;

public class ArquivoAcoes {
	
	private DwTAcao dwtacao = null;
	private IdwLogger log;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {

		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten(""+dwtacao.getOmTppt().getIdTppt());
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public DwTAcao getDwtacao() {
		return dwtacao;
	}

	public void setDwtacao(DwTAcao dwtacao) {
		this.dwtacao = dwtacao;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
	

}
