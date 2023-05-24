package ms.coleta.ic.coletalogs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;

import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public abstract class AWatcher {

public abstract void iniciarWatcher();
public abstract void monitoraHeartBeat(List<IcUpDTO> list);
	
	protected IdwLogger log;
	// protected DefaultFileMonitor fm = null;
	// protected MapFileMonitor fm = null;
	protected AFileMonitor fm = null;
	protected List<String> caminhos = new ArrayList<>();
	//private List<IcUpDTO> icUpDTOList = new ArrayList<IcUpDTO>();
	protected List<IcUpDTO> icUpDTOList = new ArrayList<IcUpDTO>();
	private List<TratadorHeartBeat> tratadorHeartBeatList = new ArrayList<TratadorHeartBeat>();
	
	public AWatcher (IdwLogger log) {
		this.log = log;
	}
	
	public void addDiretorio(String caminho) {
		log.info("adicionando " + caminho);
		caminhos.add(caminho);
	}

	public void addIcUpDTO(IcUpDTO icUpDTO) {
		log.info("adicionando " + icUpDTO.getUpDTO().getCd_up());
		icUpDTOList.add(icUpDTO);
	}
	
	protected void setUrlsAMonitorar(AFileMonitor fm, FileSystemManager fsManager) {
		// Informa ao watcher todos os arquivos a serem monitorizados
		// for (String caminho : getCaminhos()) {
		for (String caminho : caminhos) {
			FileObject listendir = null;
			try {
				listendir = fsManager.resolveFile(caminho);
			} catch (FileSystemException e) {
				e.printStackTrace();
				log.info(e);
			}
			fm.addFile(listendir);
		}
	}

	public void finalizar() {
		log.info("Finalizando watcher");
		if (fm != null)
			fm.stop();
		mataTratadoresHeartBeat();
	}


	protected List<EventoColetado> geraEventoHeartBeat(Date dataEvento, IcUpDTO icupdto) {
		EventoColetado eventoColetado = new EventoColetado();

		eventoColetado.setTipoEvento(ServicoFactory._IC_HEART_BEAT); // Fim de Ciclo
		eventoColetado.setDthrEvento(dataEvento);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icupdto);
		// eventoColetado.setOrigem("SonyWatcher: Parada Automatica Lancada Pela Coleta");
		eventoColetado.setOrigem("");

		List<EventoColetado> eventos = new ArrayList<EventoColetado>();
		eventos.add(eventoColetado);

		log.info("JukiWatcher: Gerou evento de Heart Beat:;"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoColetado.getDthrEvento())
				+ ";" + eventoColetado.getCdop());

		return eventos;
	}
	
	public void mataTratadoresHeartBeat() {
		if (tratadorHeartBeatList.size() > 0) {
			for (TratadorHeartBeat a : tratadorHeartBeatList) {
				// a.stop();
				a.setContinuarExecutando(false);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				log.error("Falha ao dar sleep para matar threads de HeartBeat"+e);
			}
		}
	}
	
	public void addTratadorHeartBeat(TratadorHeartBeat novo, String nomeTratador) {
		if (novo != null) {
			for (TratadorHeartBeat a : tratadorHeartBeatList) {
				if (a.getName().equals(nomeTratador)) {
					a.setContinuarExecutando(false);
					tratadorHeartBeatList.remove(a);
				}
			}
			tratadorHeartBeatList.add(novo);
		}
	}

	public AFileMonitor getFm() {
		return fm;
	}
	
	public List<IcUpDTO> getIcUpDTOList() {
		return icUpDTOList;
	}

	protected void setIcUpDTOList(List<IcUpDTO> icUpDTOList) {
		this.icUpDTOList = icUpDTOList;
	}
	
	public void setFm(MapFileMonitor fm) {
		this.fm = fm;
	}
	
	public List<String> getCaminhos() {
		return caminhos;
	}
}
