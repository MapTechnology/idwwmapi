package ms.coleta.ic.fuji;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.fuji.fujiflexa.FujiWatcherFujiFlexa;
import ms.coleta.ic.fuji.fujiflexa.LinhaArquivoFujiFlexaMCRELOAD;
import ms.coleta.ic.juki.JukiBufferedEventos;
import ms.coleta.ic.sony.bd.LinhaArquivoSonyTDOWNTIME;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICFuji implements IIC{

	private final IcDTO icdto;
	private FujiBufferedEventos bufferEventos = new FujiBufferedEventos();
	
	private FujiWatcher fujiWatcherFujiFlexa = null;
	
	private Map<String, LinhaArquivoFujiFlexaMCRELOAD> ultimasLinhasProcessadasMCRELOAD = new HashMap<>();

	// Modificacao para evitar o uso excessivo de Threads
	// Referencias: https://www.journaldev.com/1069/threadpoolexecutor-java-thread-pool-example-executorservice
	private ExecutorService executor = Executors.newFixedThreadPool(5);
	
	public ICFuji(IcDTO icdto) {
		super();
		this.icdto = icdto;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		return bufferEventos.obtenEventos();
	}
	
	public FujiBufferedEventos getBufferEventos() {
		return this.bufferEventos;
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		if (fujiWatcherFujiFlexa != null)
			fujiWatcherFujiFlexa.finalizar();
		
		fujiWatcherFujiFlexa = new FujiWatcherFujiFlexa(log, this);

		// Watcher dos arquivos ErrLog
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			if (updto.getUrlConexao() != null
					&& !updto.getUrlConexao().equals("")) {
				fujiWatcherFujiFlexa.addDiretorio(updto.getUrlConexao());
				fujiWatcherFujiFlexa.addIcUpDTO(updto);
			}
		}
		
		if (fujiWatcherFujiFlexa.getIcUpDTOList().size() != 0)
			fujiWatcherFujiFlexa.iniciarWatcher();
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		if (fujiWatcherFujiFlexa != null)
			fujiWatcherFujiFlexa.finalizar();
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

	public Map<String, LinhaArquivoFujiFlexaMCRELOAD> getUltimasLinhasProcessadasMCRELOAD() {
		return ultimasLinhasProcessadasMCRELOAD;
	}

	public void setUltimasLinhasProcessadasMCRELOAD(Map<String, LinhaArquivoFujiFlexaMCRELOAD> ultimasLinhasProcessadasMCRELOAD) {
		this.ultimasLinhasProcessadasMCRELOAD = ultimasLinhasProcessadasMCRELOAD;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

}
