package ms.coleta.ic.juki;

import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.juki.errhist.JukiWatcherErrHist;
import ms.coleta.ic.juki.errhist.LinhaArquivoJukiErrHist;
import ms.coleta.ic.juki.errlog.JukiWatcherErrLog;
import ms.coleta.ic.sony.bd.LinhaArquivoSonyTPRODUCT;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICJuki implements IIC{
	
	private final IcDTO icdto;
	private JukiWatcher watcherErrLog = null;
	private JukiWatcher watcherErrHist = null;
	
	private JukiBufferedEventos bufferEventos = new JukiBufferedEventos();
	
	// Buffer com a ultima linha processada do ErrLog de cada maquina
	private Map<String, LinhaArquivoJukiErrHist> ultimasLinhasProcessadas_ErrHist = new HashMap<>();
	// Buffer com o ultimo evento gerado de cada maquina
	private Map<String, EventoColetado> ultimoEventoGerado = new HashMap<>();
	
	public ICJuki(IcDTO icdto) {
		super();
		this.icdto = icdto;
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		return bufferEventos.obtemEventos();
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		if (watcherErrLog != null)
			watcherErrLog.finalizar();
		
		if (watcherErrHist != null)
			watcherErrHist.finalizar();
		
		watcherErrLog = new JukiWatcherErrLog(log, this);
		watcherErrHist = new JukiWatcherErrHist(log, this);
		
		// Watcher dos arquivos ErrLog
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			if (updto.getUrlConexao() != null
					&& !updto.getUrlConexao().equals("")) {
				watcherErrLog.addDiretorio(updto.getUrlConexao());
				watcherErrLog.addIcUpDTO(updto);
			}
		}
		// Watcher dos arquivos ErrHist
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			if (updto.getUrlAuxiliar() != null
					&& !updto.getUrlAuxiliar().equals("")) {
				watcherErrHist.addDiretorio(updto.getUrlAuxiliar());
				watcherErrHist.addIcUpDTO(updto);
			}
		}
		
		if (watcherErrLog.getIcUpDTOList().size() != 0)
			watcherErrLog.iniciarWatcher();
		
		if (watcherErrHist.getIcUpDTOList().size() != 0)
			watcherErrHist.iniciarWatcher();
	}
		
	public Map<String, LinhaArquivoJukiErrHist> getUltimasLinhasProcessadasErrHist() {
		return ultimasLinhasProcessadas_ErrHist;
	}
	
	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		if(watcherErrLog != null) {
			watcherErrLog.finalizar();
		}
		if (watcherErrHist != null)
			watcherErrHist.finalizar();
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

	public IcDTO getIcdto() {
		return icdto;
	}

	public JukiBufferedEventos getBufferEventos() {
		return this.bufferEventos;
	}

	public JukiWatcher getWatcherErrLog() {
		return watcherErrLog;
	}

	public void setWatcherErrLog(JukiWatcher watcherErrLog) {
		this.watcherErrLog = watcherErrLog;
	}

	public Map<String, EventoColetado> getUltimoEventoGerado() {
		return ultimoEventoGerado;
	}

	public void setUltimoEventoGerado(Map<String, EventoColetado> ultimoEventoGerado) {
		this.ultimoEventoGerado = ultimoEventoGerado;
	}

	// //Avaliar Necessidade
//		public LinhaArquivoJukiErrLog obtemUltimaLinhaDaMaquina_ErrLog(String cdPt) {
//			LinhaArquivoJukiErrLog retorno = null;
//			
//			if (ultimasLinhasProcessadas_ErrLog.containsKey(cdPt)) {
//				retorno = ultimasLinhasProcessadas_ErrLog.get(cdPt);
//			} else {
	//
//				// Parser do campo origem do evento de msevt daquela op
//				MsEvt msEvt = MsFacade.getInstancia().pesquisarMsEvtUltimoEventoLancadoComOrigem(cdPt);
//				if (msEvt != null) {
//					String origemVal = msEvt.getOrigem();
//					if (origemVal != null && origemVal.length() > 0) {
//						String[] origem =idw.util.UtilsString.quebrarStringEmVetor(msEvt.getOrigem(), ",").toArray(new String[0]);
//						// if (origem.length > 0) {
//						// Checa se o split deu certo
//						if (origem.length > 6) {
//							retorno = new LinhaArquivoJukiErrLog();
//							retorno.setDateTime(origem[0]);
//							retorno.setMachineID(origem[1]);
//							retorno.setOP(origem[2]);
//							retorno.setOrigem(msEvt.getOrigem());				
//						}
//					}
//				}
//			}
//			return retorno;
//		}
}
