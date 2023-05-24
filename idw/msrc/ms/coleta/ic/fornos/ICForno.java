package ms.coleta.ic.fornos;

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
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.fuji.fujiflexa.LinhaArquivoFujiFlexaMCRELOAD;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICForno implements IIC {
	
	private final IcDTO icdto;
	private BufferedEventos bufferEventos = new BufferedEventos();
	
	private FornoWatcher fornoWatcher = null;
	
	private ExecutorService executor = Executors.newFixedThreadPool(5);
	
	private Map<String, LinhaArquivoData> ultimasLinhasProcessadasData = new HashMap<>();
	
	public ICForno (IcDTO icdto) {
		super();
		this.icdto = icdto;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		return bufferEventos.obtemEventos();
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		if (fornoWatcher != null)
			fornoWatcher.finalizar();
		
		fornoWatcher = new FornoWatcher(log, this);

		// Watcher dos arquivos
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			if (updto.getUrlConexao() != null
					&& !updto.getUrlConexao().equals("")
//					&& (updto.getUrlConexao().contains("\\") 
//							|| updto.getUrlConexao().contains("/"))	
					) {
				if (updto.getUrlConexao().contains("\\") 
						|| updto.getUrlConexao().contains("/")) {
					fornoWatcher.addDiretorio(updto.getUrlConexao());
					fornoWatcher.addIcUpDTO(updto);
				}
			}
		}
		
		if (fornoWatcher.getIcUpDTOList().size() != 0)
			fornoWatcher.iniciarWatcher();
		
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		if (fornoWatcher != null)
			fornoWatcher.finalizar();
		// Sleep para aguardar as threads serem finalizadas,
		// apos o finalizar();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Finaliza o executor
		executor.shutdown();
	}
	
	public BufferedEventos getBufferEventos() {
		return this.bufferEventos;
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

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

	public Map<String, LinhaArquivoData> getUltimasLinhasProcessadasData() {
		return ultimasLinhasProcessadasData;
	}

	public FornoWatcher getFornoWatcher() {
		return fornoWatcher;
	}

	public void setFornoWatcher(FornoWatcher fornoWatcher) {
		this.fornoWatcher = fornoWatcher;
	}

}
