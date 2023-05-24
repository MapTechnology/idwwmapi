package ms.coleta.ic.juki;

import java.io.File;
import idw.util.IdwLogger;

public abstract class TCopiaArquivo {
	
	protected String nomeMaquina;
	protected String pathDestino = "";
	protected ICJuki ic;
	
	protected IdwLogger log;

	public TCopiaArquivo(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino;
		this.log = log;
	}

	public TCopiaArquivo(String nomeMaquina, String diretorioDestino, IdwLogger log, ICJuki ic) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino;
		this.log = log;
		this.ic = ic;
	}

	public abstract ArquivoJuki doJob(File arquivo);

}
