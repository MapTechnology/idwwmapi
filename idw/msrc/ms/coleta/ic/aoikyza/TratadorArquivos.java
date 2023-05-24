package ms.coleta.ic.aoikyza;

import java.io.File;
import java.nio.file.Path;

public abstract class TratadorArquivos {

	public abstract void doJob(Path path);
	
	protected void criaDiretorioSeNaoExistir(String urlDiretorio) { 
		File dir = new File(urlDiretorio);
		if (!dir.exists()) {
			dir.mkdirs();
			}
		}
	
}
