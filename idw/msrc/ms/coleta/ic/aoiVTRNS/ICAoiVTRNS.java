package ms.coleta.ic.aoiVTRNS;

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
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;


//Fabr�cio Val�rio: Coleta da AOI TRI7500 da linha 2 da Flex - 06/08/2018

public class ICAoiVTRNS implements IIC {
	
	private final IcDTO icdto;
	private BufferedEventos bufferEventos = new BufferedEventos();
	
	private AoiWatcher aoiWatcher = null;
	
	private ExecutorService executor = Executors.newFixedThreadPool(5);
	
	private Map<String, ArquivoAoiOmron> ultimosLogsProcessados = new HashMap<>();
	
	public ICAoiVTRNS (IcDTO icdto) {
		super();
		this.icdto = icdto;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		return bufferEventos.obtemEventos();
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		if (aoiWatcher != null)
			aoiWatcher.finalizar();
		
		aoiWatcher = new AoiWatcher(log, this);

		// Watcher dos arquivos
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			if (updto.getUrlConexao() != null && !updto.getUrlConexao().equals("")
					&& (updto.getUrlConexao().contains("\\") || updto.getUrlConexao().contains("/"))) {
					aoiWatcher.addDiretorio(updto.getUrlConexao());
					aoiWatcher.addIcUpDTO(updto);
			}
		}
		
		if (aoiWatcher.getIcUpDTOList().size() != 0)
			aoiWatcher.iniciarWatcher();
		
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		if (aoiWatcher != null)
			aoiWatcher.finalizar();
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

	public Map<String, ArquivoAoiOmron> getUltimosLogsProcessadosAoi() {
		return ultimosLogsProcessados;
	}

	public AoiWatcher getAoiWatcher() {
		return aoiWatcher;
	}

	public void setAoiWatcher(AoiWatcher aoiWatcher) {
		this.aoiWatcher = aoiWatcher;
	}

	public IcDTO getIcdto() {
		return icdto;
	}

}
