package ms.coleta.ic.automata;

import java.util.ArrayList;
import java.util.List;

import ms.model.dto.IcUpDTO;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import idw.util.IdwLogger;

public class AutomataWatcher {

	private IdwLogger log;
	private ICAutomata ic;
	private DefaultFileMonitor fm = null;
	private AutomataBufferedEventos bufferEventos;
	
	private List<String> caminhos = new ArrayList<>();
	private List<IcUpDTO> icUpDTOList = new ArrayList<IcUpDTO>();
	
	public AutomataWatcher(ICAutomata ic, AutomataBufferedEventos bufferEventos, IdwLogger log) {
		super();
		this.ic = ic;
		this.bufferEventos = bufferEventos;
		this.log = log;
	}
	
	public void addDiretorio(String caminho) {
		log.info("adicionando caminho " + caminho);
		caminhos.add(caminho);
	}
	
	public void addIcUpDTO(IcUpDTO icUpDTO) {
		log.info("adicionando icUpDTO " + icUpDTO.getUpDTO().getCd_up());
		icUpDTOList.add(icUpDTO);
	}

	public void iniciarWatcher() {
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("Excessao1:", e);
			e.printStackTrace();
		}

		TrataArquivoAutomata trataArquivoAutomata = new TrataArquivoAutomata(log, getIc(), getIcUpDTOList());
		fm = new DefaultFileMonitor(new AutomataFileListener(log, trataArquivoAutomata));
		fm.setRecursive(true);

		// Informa ao watcher todos os arquivos a serem monitorizados
		for (String caminho : caminhos) {
			FileObject listendir = null;
			try {
				listendir = fsManager.resolveFile(caminho);
			} catch (FileSystemException e) {
				e.printStackTrace();
				log.info("Excessao: ", e);
			}
			fm.addFile(listendir);
		}
		
		fm.start();
		for (String caminho : caminhos) {
			trataArquivoAutomata.sincronizarArquivosGerandoEventos(caminho);
		}
	}
	
	public void finalizar() {
		log.info("Finalizando watcher");
		fm.stop();
	}

	public ICAutomata getIc() {
		return ic;
	}

	public void setIc(ICAutomata ic) {
		this.ic = ic;
	}

	public List<IcUpDTO> getIcUpDTOList() {
		return icUpDTOList;
	}

	public void setIcUpDTOList(List<IcUpDTO> icUpDTOList) {
		this.icUpDTOList = icUpDTOList;
	}
	
	
}
