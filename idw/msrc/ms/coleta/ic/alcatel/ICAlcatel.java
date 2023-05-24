package ms.coleta.ic.alcatel;

import java.util.List;

import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICAlcatel implements IIC{

	private AlcatelBufferedEventos bufferEventos = new AlcatelBufferedEventos();
	private AlcatelWatcher watcher = null; 
	private final IcDTO icdto;
	
	private IdwLogger log;

	public ICAlcatel(IcDTO icdto) {
		super();
		this.icdto = icdto;
	}
			
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		log.info("Iniciando DRIVER Alcatael " + getVersaoDriver());
		if (watcher != null)
			watcher.finalizar();
		
		watcher = new AlcatelWatcher(bufferEventos, log);
		
		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
			watcher.addDiretorio(updto.getUrlConexao());
		}
		
		watcher.iniciarWatcher();
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		return bufferEventos.obtenEventos();
	}


	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		log.info("Finalizando DRIVER Alcatael " + getVersaoDriver());
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
}
