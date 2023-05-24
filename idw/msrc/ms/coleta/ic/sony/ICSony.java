package ms.coleta.ic.sony;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.sony.bd.LinhaArquivoSonyTALARM;
import ms.coleta.ic.sony.bd.LinhaArquivoSonyTDOWNTIME;
import ms.coleta.ic.sony.bd.LinhaArquivoSonyTPRODUCT;
import ms.coleta.ic.sony.bd.SonyWatcherBD;
import ms.coleta.ic.sony.dvd.LinhaArquivoSonyMDB;
import ms.coleta.ic.sony.dvd.SonyWatcherDVD;
import ms.excessao.SemComunicacaoICException;
import ms.model.MsFacade;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

/**
 * @author map
 *
 */
public class ICSony implements IIC{

	private SonyBufferedEventos bufferEventos = new SonyBufferedEventos();

	// BD
	// Buffer com o ultimo evento de cada shop order do TPRODUCTDATA
	private Map<String, LinhaArquivoSonyTPRODUCT> ops = new HashMap<>();
	// Buffer com a ultima linha processada de cada maquina do TPRODUCTDATA
	private Map<String, LinhaArquivoSonyTPRODUCT> ultimasLinhasProcessadas = new HashMap<>();
	// Buffer com a ultima linha processada de cada maquina do TPRODUCTDATA
	private Map<String, LinhaArquivoSonyTALARM> ultimasLinhasProcessadasTALARM = new HashMap<>();
	// Buffer com as datas dos ultimos arquivos TDOWNTIME processados
	private Map<String, Date> datasTDownTime = new HashMap<>();
	private Map<String, LinhaArquivoSonyTDOWNTIME> ultimasLinhasProcessadasTDOWNTIME = new HashMap<>();
	
	// DVD
	// Buffer com a ultima linha processada de cada maquina do MDB
	private Map<String, LinhaArquivoSonyMDB> ultimasLinhasProcessadasMDB = new HashMap<>();
	// Buffer com o ultimo evento de cada maquina+shop order do MDB
	private Map<String, LinhaArquivoSonyMDB> opsMDB = new HashMap<>();
	
	private SonyWatcher watcher = null;
	private final IcDTO icdto;

	public ICSony(IcDTO icdto) {
		super();
		this.icdto = icdto;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		return bufferEventos.obtenEventos();
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		UtilsThreads.pausaNaThread(1000l);
		
		if (watcher != null)
			watcher.finalizar();
		
		// Determina o tipo do IC
		if (icdto.getUrl_conexao() != null && icdto.getUrl_conexao().toLowerCase().equals("bd")) {
			watcher = new SonyWatcherBD(log, this);
		}
		else if (icdto.getUrl_conexao() != null && icdto.getUrl_conexao().toLowerCase().equals("dvd")) {
			watcher = new SonyWatcherDVD(log, this);
		}
		else {
			return;
		}
		
		// Se o ic for valido e um watcher for criado
		// o wacther é processado
		
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			watcher.addDiretorio(updto.getUrlConexao());
			watcher.addIcUpDTO(updto);
		}
		
		watcher.iniciarWatcher();
		
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		if(watcher != null) {
			watcher.finalizar();
			watcher.mataTratadoresHeartBeat();
		}
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return "v1.0";
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "v1.0";
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}
	
	public LinhaArquivoSonyTALARM obtemUltimaLinhaTALARMDaMaquina(String cdPt) {
		LinhaArquivoSonyTALARM retorno = null;
		
		if (ultimasLinhasProcessadasTALARM.containsKey(cdPt)) {
			retorno = ultimasLinhasProcessadasTALARM.get(cdPt);
		}
		return retorno;
	}
	
	public LinhaArquivoSonyTPRODUCT obtemUltimaLinhaDaMaquina(String cdPt) {
		LinhaArquivoSonyTPRODUCT retorno = null;
		
		if (ultimasLinhasProcessadas.containsKey(cdPt)) {
			retorno = ultimasLinhasProcessadas.get(cdPt);
		} else {

			// Parser do campo origem do evento de msevt daquela op
			MsEvt msEvt = MsFacade.getInstancia().pesquisarMsEvtUltimoEventoLancadoComOrigem(cdPt);
			if (msEvt != null) {
				String origemVal = msEvt.getOrigem();
				if (origemVal != null && origemVal.length() > 0) {
					String[] origem =idw.util.UtilsString.quebrarStringEmVetor(msEvt.getOrigem(), ",").toArray(new String[0]);
					// if (origem.length > 0) {
					// Checa se o split deu certo
					if (origem.length > 9) {
						retorno = new LinhaArquivoSonyTPRODUCT();
						
						retorno.setdDateTime(origem[0]);
						retorno.setProductionStatus(origem[1]);
						retorno.setMachineID(origem[2]);
						retorno.setShopOrder(origem[3]);
						retorno.setOrderQuantity(origem[4]);
						retorno.setOrderOKQuantity(origem[5]);
						retorno.setOrderNGQuantity(origem[6]);
						retorno.setRemainOrder(origem[7]);
						retorno.setNid(origem[8]);
						retorno.setStopTime(origem[10]);
						retorno.setOrigem(msEvt.getOrigem());
						
						if (origem.length > 15) {
							retorno.setInjectionShots(origem[15]);	
						}
						
						// O uso de ifs diferentes garante compatibilidade com bancos que possuem 
						// registros antigos
						if (origem.length > 30) {
							retorno.setNITEM198(origem[16]);
							retorno.setNITEM199(origem[17]);
							retorno.setNITEM200(origem[18]);
							retorno.setNITEM201(origem[19]);
							retorno.setNITEM202(origem[20]);
							retorno.setNITEM203(origem[21]);
							retorno.setNITEM204(origem[22]);
							retorno.setNITEM205(origem[23]);
							retorno.setNITEM206(origem[24]);
							retorno.setNITEM207(origem[25]);
							retorno.setNITEM208(origem[26]);
							retorno.setNITEM209(origem[27]);
							retorno.setNITEM210(origem[28]);
							retorno.setNITEM211(origem[29]);
							retorno.setNITEM212(origem[30]);
						}
						retorno.povoaNitems();
					}
				}
			}
		}
		
		return retorno;
	}
	
	/**
	 * Retorna a ultima linha processada de uma OP e Maquina
	 * para maquina BD
	 * @param cdOp
	 * @param cdPt
	 * @return
	 */
	public LinhaArquivoSonyTPRODUCT obtemUltimaLinhaDaOpMaquina(String cdOp, String cdPt) {
		LinhaArquivoSonyTPRODUCT retorno = null;
		// Um registro no map guardado da memoria tem a chave (cdOp + cdPt) 
		if (ops.containsKey(cdOp + cdPt)) {
			retorno = ops.get(cdOp + cdPt);
		} else {

			// Parser do campo origem do evento de msevt daquela op
			MsEvt msEvt = MsFacade.getInstancia().pesquisarMsEvtUltimoEventoLancado(cdOp, cdPt);
			if (msEvt != null) {
				String origemVal = msEvt.getOrigem();
				if (origemVal != null && origemVal.length() > 0) {
					String[] origem =idw.util.UtilsString.quebrarStringEmVetor(msEvt.getOrigem(), ",").toArray(new String[0]);
					// if (origem.length > 0) {
					if (origem.length > 9) {
						retorno = new LinhaArquivoSonyTPRODUCT();
						
						retorno.setdDateTime(origem[0]);
						retorno.setProductionStatus(origem[1]);
						retorno.setMachineID(origem[2]);
						retorno.setShopOrder(origem[3]);
						retorno.setOrderQuantity(origem[4]);
						retorno.setOrderOKQuantity(origem[5]);
						retorno.setOrderNGQuantity(origem[6]);
						retorno.setRemainOrder(origem[7]);
						retorno.setNid(origem[8]);
						retorno.setStopTime(origem[10]);
						retorno.setOrigem(msEvt.getOrigem());
						
						if (origem.length > 15) {
							retorno.setInjectionShots(origem[15]);
						}
						// O uso de ifs diferentes garante compatibilidade com bancos que possuem 
						// registros antigos
						if (origem.length > 30) {
							retorno.setNITEM198(origem[16]);
							retorno.setNITEM199(origem[17]);
							retorno.setNITEM200(origem[18]);
							retorno.setNITEM201(origem[19]);
							retorno.setNITEM202(origem[20]);
							retorno.setNITEM203(origem[21]);
							retorno.setNITEM204(origem[22]);
							retorno.setNITEM205(origem[23]);
							retorno.setNITEM206(origem[24]);
							retorno.setNITEM207(origem[25]);
							retorno.setNITEM208(origem[26]);
							retorno.setNITEM209(origem[27]);
							retorno.setNITEM210(origem[28]);
							retorno.setNITEM211(origem[29]);
							retorno.setNITEM212(origem[30]);
						}
						retorno.povoaNitems();
					} 
				}
			}
		}
		
		return retorno;
	}
	
	/**
	 * Retorna a ultima linha processada de uma OP e Maquina
	 * para maquina BD
	 * @param cdOp
	 * @param cdPt
	 * @return
	 */
	public LinhaArquivoSonyMDB obtemUltimaLinhaDaOpMaquinaMDB(String cdOp, String cdPt) {
		LinhaArquivoSonyMDB retorno = null;
		// Um registro no map guardado da memoria tem a chave (cdOp + cdPt) 
		if (opsMDB.containsKey(cdOp + cdPt)) {
			retorno = opsMDB.get(cdOp + cdPt);
		} else {
			// Parser do campo origem do evento de msevt daquela op
			MsEvt msEvt = MsFacade.getInstancia().pesquisarMsEvtUltimoEventoLancado(cdOp, cdPt);
			if (msEvt != null) {
				String origemVal = msEvt.getOrigem();
				if (origemVal != null && origemVal.length() > 0) {	
					String[] origem =idw.util.UtilsString.quebrarStringEmVetor(msEvt.getOrigem(), ",").toArray(new String[0]);
					if (origem.length > 6) {
						retorno = new LinhaArquivoSonyMDB();
						retorno.setDateTime(origem[0]);
						retorno.setCmd(origem[1]);
						retorno.setMachineID(origem[2]);
						retorno.setShopOrder(origem[3]);
						retorno.setOrderStatus(origem[4]);
						retorno.setbShot(origem[5]);
						retorno.setBndOk(origem[6]);
						
						if (origem.length > 13) {
							retorno.setBndReject0(origem[7]);
							retorno.setBndReject1(origem[8]);
							retorno.setBndReject2(origem[9]);
							retorno.setBndReject3(origem[10]);
							retorno.setBndReject4(origem[11]);
							retorno.setBndReject5(origem[12]);
							retorno.setBndReject6(origem[13]);
						}
						if (origem.length > 20) {
							retorno.setBndDrop(origem[14]);
							retorno.setBndScrap(origem[15]);
							retorno.setBndClear(origem[16]);
							retorno.setBndReflected(origem[17]);
							retorno.setBndVisual(origem[18]);
							retorno.setBndPatrol(origem[19]);
							retorno.getBndDefs().set(0, origem[20]);
						}
						if (origem.length > 39) {
							for (int i = 0; i < 16; i++) {
								retorno.getBndDefs().set(i, origem[20 + i]);
							}
							retorno.setMldDrop1(origem[36]);
							retorno.setMldDrop2(origem[37]);
							retorno.setMldDrop3(origem[38]);
							retorno.setMldDrop4(origem[39]);
						}
						if (origem.length > 41) {
							retorno.setBndInSystem(origem[40]);
							retorno.setTotalizadorRefugoValido(origem[41]);
						}
						// Caso o if acima nao seja atendido, povoaBndRejects usara zeros no vetor
						retorno.povoaBndRejects();
						retorno.setOrigem(msEvt.getOrigem());				
					}
				}
			}
		}
		
		return retorno;
	}
	
	public LinhaArquivoSonyMDB obtemUltimaLinhaDaMaquinaMDB(String cdPt) {
		LinhaArquivoSonyMDB retorno = null;
		
		if (ultimasLinhasProcessadasMDB.containsKey(cdPt)) {
			retorno = ultimasLinhasProcessadasMDB.get(cdPt);
		} else {

			// Parser do campo origem do evento de msevt daquela op
			MsEvt msEvt = MsFacade.getInstancia().pesquisarMsEvtUltimoEventoLancadoComOrigem(cdPt);
			if (msEvt != null) {
				String origemVal = msEvt.getOrigem();
				if (origemVal != null && origemVal.length() > 0) {
					String[] origem =idw.util.UtilsString.quebrarStringEmVetor(msEvt.getOrigem(), ",").toArray(new String[0]);
					// if (origem.length > 0) {
					// Checa se o split deu certo
					if (origem.length > 6) {
						retorno = new LinhaArquivoSonyMDB();
						
						
						retorno.setDateTime(origem[0]);
						retorno.setCmd(origem[1]);
						retorno.setMachineID(origem[2]);
						retorno.setShopOrder(origem[3]);
						retorno.setOrderStatus(origem[4]);
						retorno.setbShot(origem[5]);
						retorno.setBndOk(origem[6]);
						
						if (origem.length > 13) {
							retorno.setBndReject0(origem[7]);
							retorno.setBndReject1(origem[8]);
							retorno.setBndReject2(origem[9]);
							retorno.setBndReject3(origem[10]);
							retorno.setBndReject4(origem[11]);
							retorno.setBndReject5(origem[12]);
							retorno.setBndReject6(origem[13]);
						}
						if (origem.length > 20) {
							retorno.setBndDrop(origem[14]);
							retorno.setBndScrap(origem[15]);
							retorno.setBndClear(origem[16]);
							retorno.setBndReflected(origem[17]);
							retorno.setBndVisual(origem[18]);
							retorno.setBndPatrol(origem[19]);
							retorno.getBndDefs().set(0, origem[20]);
						}
						if (origem.length > 39) {
							for (int i = 0; i < 16; i++) {
								retorno.getBndDefs().set(i, origem[20 + i]);
							}
							retorno.setMldDrop1(origem[36]);
							retorno.setMldDrop2(origem[37]);
							retorno.setMldDrop3(origem[38]);
							retorno.setMldDrop4(origem[39]);
						}
						if (origem.length > 41) {
							retorno.setBndInSystem(origem[40]);
							retorno.setTotalizadorRefugoValido(origem[41]);
						}
						// Caso o if acima nao seja atendido, povoaBndRejects usara zeros no vetor
						retorno.povoaBndRejects();
						retorno.setOrigem(msEvt.getOrigem());				
					}
				}
			}
		}
		return retorno;
	}
	
	public SonyBufferedEventos getBufferEventos() {
		return this.bufferEventos;
	}

	public Map<String, LinhaArquivoSonyTPRODUCT> getOps() {
		return this.ops;
	}
	
	public Map<String, LinhaArquivoSonyTPRODUCT> getUltimasLinhasProcessadas() {
		return ultimasLinhasProcessadas;
	}
	
	public Map<String, LinhaArquivoSonyMDB> getUltimasLinhasProcessadasMDB() {
		return ultimasLinhasProcessadasMDB;
	}
	
	public Map<String, LinhaArquivoSonyTDOWNTIME> getUltimasLinhasProcessadasTDOWNTIME() {
		return ultimasLinhasProcessadasTDOWNTIME;
	}
	
	public Map<String, LinhaArquivoSonyMDB> getOpsMDB() {
		return this.opsMDB;
	}

	public IcDTO getIcdto() {
		return icdto;
	}

	public Map<String, LinhaArquivoSonyTALARM> getUltimasLinhasProcessadasTALARM() {
		return ultimasLinhasProcessadasTALARM;
	}

	public void setUltimasLinhasProcessadasTALARM(Map<String, LinhaArquivoSonyTALARM> ultimasLinhasProcessadasTALARM) {
		this.ultimasLinhasProcessadasTALARM = ultimasLinhasProcessadasTALARM;
	}

	public Map<String, Date> getDatasTDownTime() {
		return datasTDownTime;
	}

	public void setDatasTDownTime(Map<String, Date> datasTDownTime) {
		this.datasTDownTime = datasTDownTime;
	}

	public SonyWatcher getWatcher() {
		return watcher;
	}

	public void setWatcher(SonyWatcher watcher) {
		this.watcher = watcher;
	}
	
}
