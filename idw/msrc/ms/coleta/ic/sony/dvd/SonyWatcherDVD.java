package ms.coleta.ic.sony.dvd;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ICSony;
import ms.coleta.ic.sony.SonyWatcher;
import ms.coleta.ic.sony.SonyWatcher.DescritorArquivosSony;
import ms.coleta.ic.sony.TratadorHeartBeat;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class SonyWatcherDVD extends SonyWatcher{
	
	private IdwLogger log = null;

	public SonyWatcherDVD(IdwLogger log, ICSony ic) {
		super(log, ic, 1); // 1 e o tipo de coleta, 1 - DVD
		this.log = log;
	}

	@Override
	public void iniciarWatcher() {
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("Excessao1:", e);
			e.printStackTrace();
		}

		fm = new DefaultFileMonitor(new TrataArquivoGerandoEventosDVD(log,
				getIcUpDTOList(), getIc()));
		fm.setRecursive(true);
		
		// Debounce 1
		// Garante que o FileMonitor nao seja ativado repetidas vezes seguidas
		// e garante um tempo para o arquivo terminar de ser escrito
		fm.setDelay(30 * 1000);
		setFm(fm);

		// Informa ao watcher todos os arquivos a serem monitorizados
		for (String caminho : getCaminhos()) {
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
		
		TratadorHeartBeat t = new TratadorHeartBeat(getIcUpDTOList(), this);
		t.setName("monitoraParadaAutomaticaHeartBeat DVD");
		addTratadorHeartBeat(t);
		
		t.start();

	}

	public void monitoraParadaAutomaticaHeartBeat(List<IcUpDTO> list){
		// Monitora a necessidade de lancar parada automatica
		// e lanca a parada se necessario
		// monitoraParadaAutomatica();
		
		// Lança evento de HeartBeat
		// Como e criado um watcher por IC, basta lancar aqui um evento de HeartBeat
		List<EventoColetado> eventos;
		for (IcUpDTO updto : list){
			File arq = new File(updto.getUrlConexao());
			if (arq.exists() && arq.listFiles().length > 0) {
				eventos = geraEventoHeartBeat(new Date(), updto);
				getIc().getBufferEventos().addEventos((eventos));
			}
		}
	}
	
	private void monitoraParadaAutomatica() {
		for (IcUpDTO updto : getIc().getIcdto().getMsIcUpDTOLocais()) {
			File arq = new File(updto.getUrlConexao());
			File tProductDataFile = null;
			tProductDataFile = getFileLogProdutivo(arq);
			
			if (tProductDataFile != null) {
				Date atualDate = new Date();
				long atualLong = atualDate.getTime();
				
				// Criando descritor do arquivo
				Date fileLastModifiedDate = new Date(tProductDataFile.lastModified());
				long tamanhoArquivo = tProductDataFile.length();
				DescritorArquivosSony descritorArquivo = new DescritorArquivosSony(fileLastModifiedDate, tamanhoArquivo);
				
				if ( (ultimasModificacoes.get(updto) != null) && (ultimasModificacoes.get(updto).compareJustDate(descritorArquivo) != 0) ) {
					ultimasModificacoes.remove(updto);
				} else if ((ultimasModificacoes.get(updto) == null) && (atualLong - fileLastModifiedDate.getTime() >= tempoParaAbrirParadaAutomatica)) {
					List<EventoColetado> eventos = geraEventoParadaAutomatica(updto, fileLastModifiedDate);
					getIc().getBufferEventos().addEventos((eventos));
					descritorArquivo.setIsParado(true);
					ultimasModificacoes.put(updto, descritorArquivo);
				}
					
			} else {
				if (!ultimasModificacoes.containsKey(updto) 
						|| (ultimasModificacoes.containsKey(updto) && (ultimasModificacoes.get(updto) != null) ) ) {
					List<EventoColetado> eventos = geraEventoParadaAutomatica(updto, new Date());
					getIc().getBufferEventos().addEventos((eventos));
					ultimasModificacoes.put(updto, null);
				}
			}
			
		}
			
	}
	
} // Fim de classe
