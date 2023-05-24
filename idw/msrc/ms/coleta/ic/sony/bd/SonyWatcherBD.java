package ms.coleta.ic.sony.bd;

import idw.util.IdwLogger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ms.coleta.ic.sony.ICSony;
import ms.coleta.ic.sony.SonyWatcher;
import ms.coleta.ic.sony.TratadorHeartBeat;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

public class SonyWatcherBD extends SonyWatcher{

	private IdwLogger log = null;
	int tempoParaMonitorarParadaAutomatica = 5 * 60 * 1000;
	
	public SonyWatcherBD(IdwLogger log, ICSony ic) {
		super(log, ic, 0); // 0 e o tipo de coleta - BD
		this.log = log;
	}
	
	@Override
	public void iniciarWatcher() {
		//DefaultFileMonitor fm = getFm();
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("SonyWatcherBD: excecao ao obter fsManager: ", e);
			e.printStackTrace();
		}

		fm = new DefaultFileMonitor(new TrataArquivoGerandoEventosBD(log, getIcUpDTOList(), getIc()));
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
				log.info("SonyWatcherBD: ", e);
			}
			fm.addFile(listendir);
		}

		fm.start();
		
		// Monitora Parada Automatica e HeartBeat
		TratadorHeartBeat t = new TratadorHeartBeat(getIcUpDTOList(), this);
		t.setName("monitoraParadaAutomaticaHeartBeat BD");
		addTratadorHeartBeat(t);
		
		t.start();
		
	} // Fim do iniciarWatcher()

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
			Date atualDate = new Date();
			
			if (tProductDataFile != null) {
				
				long atualLong = atualDate.getTime();
				
				// Criando descritor do arquivo
				Date fileLastModifiedDate = new Date(tProductDataFile.lastModified());
				long tamanhoArquivo = tProductDataFile.length();
				DescritorArquivosSony descritorArquivo = new DescritorArquivosSony(fileLastModifiedDate, tamanhoArquivo);
				
				if ((ultimasModificacoes.get(updto) != null) && (ultimasModificacoes.get(updto).compareTo(descritorArquivo)) != 0 ) {
					descritorArquivo.setIsParado(false);
					ultimasModificacoes.put(updto, descritorArquivo);
				}
				
				if (ultimasModificacoes.get(updto) == null) {
					ultimasModificacoes.put(updto, descritorArquivo);
				} else if ( !(ultimasModificacoes.get(updto).getIsParado()) && (atualLong - ultimasModificacoes.get(updto).data.getTime() >= tempoParaAbrirParadaAutomatica)) {
					List<EventoColetado> eventos = geraEventoParadaAutomatica(updto, fileLastModifiedDate);
					getIc().getBufferEventos().addEventos((eventos));
					descritorArquivo.setIsParado(true);
					ultimasModificacoes.put(updto, descritorArquivo);
					log.info("SonyWatcherBD: Parada automatica lancada por tempoParaAbrirParadaAutomatica ter sido atingido. Maquina: " + updto.getUpDTO().getDs_up()
							+ " Data Atual " +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(atualDate) 
							+ "Ultima data computada: "  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(ultimasModificacoes.get(updto).data) );
				}
				
			} else {
				if (!ultimasModificacoes.containsKey(updto) 
						|| (ultimasModificacoes.containsKey(updto) && (ultimasModificacoes.get(updto) != null) ) ) {
					List<EventoColetado> eventos = geraEventoParadaAutomatica(updto, new Date());
					getIc().getBufferEventos().addEventos((eventos));
					ultimasModificacoes.put(updto, null);
					log.info("SonyWatcherBD: Parada automatica lancada por arquivo estar inacessivel. Maquina: " + updto.getUpDTO().getDs_up()
							+ " Data ~ " +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(atualDate) );
				}
			}
			
		}
	}
	
//	private void monitoraParadaAutomatica() {
//		for (IcUpDTO updto : getIc().getIcdto().getMsIcUpDTOLocais()) {
//			File arq = new File(updto.getUrlConexao());
//			File tProductDataFile = null;
//			tProductDataFile = getFileLogProdutivo(arq);
//			
//			if (tProductDataFile != null) {
//				Date atualDate = new Date();
//				
//				// Criando descritor do arquivo
//				Date fileLastModifiedDate = new Date(tProductDataFile.lastModified());
//				long tamanhoArquivo = tProductDataFile.length();
//				DescritorArquivosSony descritorArquivo = new DescritorArquivosSony(fileLastModifiedDate, tamanhoArquivo);
//				
//				// Se o arquivo nao estava sendo monitorado, monitorar
//				if (!ultimasModificacoes.containsKey(updto)) {
//					ultimasModificacoes.put(updto, descritorArquivo);
//					
//				} else if ( ( ultimasModificacoes.get(updto) != null
//						&& ultimasModificacoes.get(updto).compareTo(descritorArquivo) != 0 )) {
//					// Se o arquivo estava sendo monitorado e seu registro era diferente de null
//					// E houve mudancas entre o tamanho do arquivo analisado agora e o tamanho do
//					// arquivo guardado no dicionario
//					long atualLong = atualDate.getTime();
//					long oldLong = ( ultimasModificacoes.get(updto).data.getTime() );
//					// Checa se a diferenca entre a data guardada no dicionario e a data atual e maior
//					// ou igual o limiar para abertura de parada
//					if (atualLong - oldLong >= (tempoParaAbrirParadaAutomatica)) {
//						// Lanca parada autonatica
//						List<EventoColetado> eventos = geraEventoParadaAutomatica(updto, fileLastModifiedDate);
//						getIc().getBufferEventos().addEventos((eventos));
//						
//						ultimasModificacoes.put(updto, descritorArquivo);
//					}
//				} else if ((ultimasModificacoes.get(updto) == null)) {
//					// Se o conteudo do registro esta null, atualiza-se
//					ultimasModificacoes.put(updto, descritorArquivo);
//				}
//			} else {
//				// Caso o Diretorio esteja Inacessivel
//				// Lancar parada sobre isso
//				if (!ultimasModificacoes.containsKey(updto) 
//						|| (ultimasModificacoes.containsKey(updto) && (ultimasModificacoes.get(updto) != null) ) ) {
//					List<EventoColetado> eventos = geraEventoParadaAutomatica(updto, new Date());
//					getIc().getBufferEventos().addEventos((eventos));
//					ultimasModificacoes.put(updto, null);
//				}				
//			}
//		}
//	}
	
} // Fim da Classe
