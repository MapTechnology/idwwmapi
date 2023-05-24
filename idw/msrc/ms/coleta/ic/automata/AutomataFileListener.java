package ms.coleta.ic.automata;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;

import idw.util.IdwLogger;

public class AutomataFileListener implements FileListener {
	
	private IdwLogger log;
	private TrataArquivoAutomata trataArquivoAutomata;

	public AutomataFileListener(
			IdwLogger log,
			TrataArquivoAutomata trataArquivoAutomata) {
		super();
		this.log = log;
		this.trataArquivoAutomata = trataArquivoAutomata;
	}
	
	@Override
	public void fileCreated(FileChangeEvent arg0) throws Exception {
		log.info("ARQUIVO CRIADO = " + arg0.getFile().getName().getBaseName());
		trataArquivoAutomata.trataArquivoGerandoEventos(arg0);
	}

	@Override
	public void fileChanged(FileChangeEvent arg0) throws Exception {
		log.info("ARQUIVO MODIFICADO = " + arg0.getFile().getName().getBaseName());
		trataArquivoAutomata.trataArquivoGerandoEventos(arg0);
	}

	@Override
	public void fileDeleted(FileChangeEvent arg0) throws Exception {
		log.info("ARQUIVO EXCLUIDO = " + arg0.getFile().getName().getBaseName());
	}

}
