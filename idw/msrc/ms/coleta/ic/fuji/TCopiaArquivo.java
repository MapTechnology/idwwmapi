package ms.coleta.ic.fuji;

import java.io.File;
import idw.util.IdwLogger;

public abstract class TCopiaArquivo {
	
	protected String nomeMaquina;
	protected String pathDestino = "";
	protected ICFuji ic;
	
	protected IdwLogger log;

	public TCopiaArquivo(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino;
		this.log = log;
	}

	public TCopiaArquivo(String nomeMaquina, String diretorioDestino, IdwLogger log, ICFuji ic) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino;
		this.log = log;
		this.ic = ic;
	}

	public abstract ArquivoFuji doJob(File arquivo);

}

