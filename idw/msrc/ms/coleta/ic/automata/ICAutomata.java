package ms.coleta.ic.automata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICAutomata implements IIC {
	
	// Buffer com a ultima parada de cada OP
	private Map<String, LinhaArquivoAutomata> paradas = new HashMap<>();

	private AutomataBufferedEventos bufferEventos = new AutomataBufferedEventos();
	private AutomataWatcher watcher = null;
	private final IcDTO icdto;
	
	private IdwLogger log;

	public ICAutomata(IcDTO icdto) {
		super();
		this.icdto = icdto;
	}
	
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		log.info("INICIANDO DRIVER AUTOMATA " + getVersaoDriver());
		if (watcher != null) {
			watcher.finalizar();
		}
		
		watcher = new AutomataWatcher(this, bufferEventos, log);
		
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			watcher.addDiretorio(updto.getUrlConexao());
			watcher.addIcUpDTO(updto);
		}
		
		watcher.iniciarWatcher();
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		return bufferEventos.obtemEventos();
	}


	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		log.info("FINALIZANDO DRIVER AUTOMATA " + getVersaoDriver());
		watcher.finalizar();
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
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
	}
	
	public LinhaArquivoAutomata obtemUltimaParadaOp(String cdOp) {
		
		if (paradas.containsKey(cdOp)) {
			return paradas.get(cdOp);
		}
		
		return null;
	}
	
	public void removerUltimaParadaOp(String cdOp) {
		if (paradas.containsKey(cdOp)) {
			paradas.remove(cdOp);
		}
	}

	public AutomataBufferedEventos getBufferEventos() {
		return bufferEventos;
	}

	public Map<String, LinhaArquivoAutomata> getParadas() {
		return paradas;
	}

}
