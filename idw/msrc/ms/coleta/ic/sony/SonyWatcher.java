package ms.coleta.ic.sony;

import idw.util.IdwLogger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.coleta.ic.sony.bd.LinhaArquivoSonyTPRODUCT;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

import org.apache.commons.vfs2.impl.DefaultFileMonitor;

public abstract class SonyWatcher {
	
	public abstract void monitoraParadaAutomaticaHeartBeat(List<IcUpDTO> list);
	public abstract void iniciarWatcher();
	
	private ICSony ic;
	protected DefaultFileMonitor fm = null;
	private List<String> caminhos = new ArrayList<>();
	private List<IcUpDTO> icUpDTOList = new ArrayList<IcUpDTO>();
	
	private List<TratadorHeartBeat> tratadorHeartBeatList = new ArrayList<TratadorHeartBeat>();
	
	// Seta o tipo de watcher
	// 0 - BD
	// 1 - DVD
	protected int tipoWatcher = 0;

	protected Map<IcUpDTO, DescritorArquivosSony> ultimasModificacoes = new HashMap<>();
	
	private IdwLogger log;
	
	// protected int tempoParaAbrirParadaAutomatica = ( 2 * 60 * 1000);
	protected int tempoParaAbrirParadaAutomatica = ( 11 * 60 * 1000);

	public SonyWatcher(IdwLogger log, ICSony ic, int tipoWatcher) {
		super();
		this.log = log;
		this.ic = ic;
		this.tipoWatcher = tipoWatcher;
	}

	public void mataTratadoresHeartBeat(){
		for(TratadorHeartBeat a : tratadorHeartBeatList){
			a.stop();
		}
	}
	
	public void addTratadorHeartBeat(TratadorHeartBeat novo){
		if (novo != null){
			tratadorHeartBeatList.add(novo);
		}
		
	}
	

	// TODO: No caso do DVD, o tamanho do arquivo nao varia diretamente com o numero de linhas,
	// ou seja, sera necessario fazer um tratamento especifico
	
	
	protected List<EventoColetado> geraEventoHeartBeat(Date dataEvento, IcUpDTO icupdto) {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._IC_HEART_BEAT); // Fim de Ciclo
		eventoColetado.setDthrEvento(dataEvento);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icupdto);
		// eventoColetado.setOrigem("SonyWatcher: Parada Automatica Lancada Pela Coleta");
		eventoColetado.setOrigem("HEARTBEAT_POR_UP"); //180606F&A ("") -> ("HEARTBEAT_POR_UP")
		
		List<EventoColetado> eventos = new ArrayList<EventoColetado>() ;
		eventos.add(eventoColetado);
		
		log.info("EventoLogSony: Gerou evento de Heart Beat:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoColetado.getDthrEvento()) 
				+ ";" + eventoColetado.getCdop());
		
		return eventos;
	}
	
	protected List<EventoColetado> geraEventoParadaAutomatica(IcUpDTO updto, Date fileLastModifiedDate) {
		
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA); // Fim de Ciclo
		eventoColetado.setDthrEvento(fileLastModifiedDate);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(updto);
		// eventoColetado.setOrigem("SonyWatcher: Parada Automatica Lancada Pela Coleta");
		eventoColetado.setOrigem("");
		List<EventoColetado> eventos = new ArrayList<EventoColetado>() ;
		eventos.add(eventoColetado);
		
		log.info("EventoLogSony: Gerou evento de Inicio de Parada:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoColetado.getDthrEvento()) 
				+ ";" + eventoColetado.getCdop());
		
		return eventos;
	}

	/**
	 * Obtem o File do TPRODUCTDATA mais antigo presente no diretorio passado
	 * @param arq: caminho do diretorio que conte o TPRODUCTDATA
	 * @return file
	 */
	private File getTPRODUCTDATAFromUrl(File arq) {
		if (arq.exists()) {
			File[] dirChildren = arq.listFiles();
			for (File fileChildren: dirChildren) {
				if (fileChildren.getName().toUpperCase().contains("TPRODUCTDATA")) {
					return fileChildren;
				}
			}
		}
		return null;
	}
	
	private File getMDBFromUrl(File arq) {
		if (arq.exists()) {
			File[] dirChildren = arq.listFiles();
			for (File fileChildren: dirChildren) {
				if (fileChildren.getName().toUpperCase().contains("MDB")) {
					return fileChildren;
				}
			}
		}
		return null;
	}
	
	
	/**
	 *  Responsavel por obter a referencia do arquivo correto
	 *  dependendo do tipo de watcher
	 * @param arq
	 * @return
	 */
	protected File getFileLogProdutivo (File arq) {
		if (tipoWatcher == 0)
			return getTPRODUCTDATAFromUrl(arq);
		else if (tipoWatcher == 1)
			return getMDBFromUrl(arq);
		
		return null;
	}
	
	public void addDiretorio(String caminho) {
		log.info("adicionando " + caminho);
		caminhos.add(caminho);

	}
	
	public void addIcUpDTO(IcUpDTO icUpDTO) {
		log.info("adicionando " + icUpDTO.getUpDTO().getCd_up());
		icUpDTOList.add(icUpDTO);

	}

	public void finalizar() {
		log.info("Finalizando watcher");
		fm.stop();
	}

	public DefaultFileMonitor getFm() {
		return fm;
	}

	public void setFm(DefaultFileMonitor fm) {
		this.fm = fm;
	}

	protected ICSony getIc() {
		return ic;
	}

	protected void setIc(ICSony ic) {
		this.ic = ic;
	}

	public List<String> getCaminhos() {
		return caminhos;
	}

	protected void setCaminhos(List<String> caminhos) {
		this.caminhos = caminhos;
	}

	protected List<IcUpDTO> getIcUpDTOList() {
		return icUpDTOList;
	}

	protected void setIcUpDTOList(List<IcUpDTO> icUpDTOList) {
		this.icUpDTOList = icUpDTOList;
	}
	
	public List<TratadorHeartBeat> getTratadorHeartBeatList() {
		return tratadorHeartBeatList;
	}
	public void setTratadorHeartBeatList(List<TratadorHeartBeat> tratadorHeartBeatList) {
		this.tratadorHeartBeatList = tratadorHeartBeatList;
	}

	public class DescritorArquivosSony{
		public Date data;
		public long tamanho;
		private boolean isParado = false;
		
		public DescritorArquivosSony (Date date, long tamanho) {
			this.data = date;
			this.tamanho = tamanho;
		}
		
		public boolean getIsParado(){
			return isParado;
		}
		
		public void setIsParado(boolean status){
			isParado = status;
		}
		
		// Se os tamanhos forem iguais, comparar as datas
		public int compare(Object o2){
			DescritorArquivosSony d1 = (DescritorArquivosSony)this;
			DescritorArquivosSony d2 = (DescritorArquivosSony)o2;
			if (d1.tamanho == d2.tamanho) {
				return d1.data.compareTo(d2.data);
			}
			return -1;
		}
		
		public int compareTo(Object o2){
			DescritorArquivosSony d1 = (DescritorArquivosSony)this;
			DescritorArquivosSony d2 = (DescritorArquivosSony)o2;
			if ((d1.tamanho == d2.tamanho)) {
				return 0;
			}
			return -1;
		}
		
		public int compareJustDate(Object o2){
			DescritorArquivosSony d1 = (DescritorArquivosSony)this;
			DescritorArquivosSony d2 = (DescritorArquivosSony)o2;
			
			return d1.data.compareTo(d2.data);
		}
		
//		public int compareTo(Object o2){
//			DescritorArquivosSony d1 = (DescritorArquivosSony)this;
//			DescritorArquivosSony d2 = (DescritorArquivosSony)o2;
//			if ((d1.tamanho == d2.tamanho) && (d1.data.compareTo(d2.data) == 0)) {
//				// return d1.data.compareTo(d2.data);
//				return 0;
//			}
//			return -1;
//		}
	}

}



