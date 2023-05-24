package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhasetup;
import idw.util.IdwLogger;

import java.util.List;

public class ArquivoFolhas {
	private DwFolha dwFolha = null;
	private List<DwFolhasetup> dwFolhaSetups = null;
	private IdwLogger log;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[SETUP]");
		arquivoInovaSA.addLineToBeWritten("SETUP_DEFAULT="+dwFolha.getSegSetup());
		for(DwFolhasetup folhaSetup : dwFolhaSetups) {
			arquivoInovaSA.addLineToBeWritten(folhaSetup.getDwFolhaByIdFolhasaindo().getIdFolha()+"="+folhaSetup.getSegSetup());
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public DwFolha getDwFolha() {
		return dwFolha;
	}

	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}

	public List<DwFolhasetup> getDwFolhaSetups() {
		return dwFolhaSetups;
	}

	public void setDwFolhaSetups(List<DwFolhasetup> dwFolhaSetups) {
		this.dwFolhaSetups = dwFolhaSetups;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

}
