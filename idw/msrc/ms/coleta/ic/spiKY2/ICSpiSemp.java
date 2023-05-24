package ms.coleta.ic.spiKY2;

import java.util.List;

import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.aoiVTRNSSQL.ArquivoUltimoID;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;


//Fabr�cio Val�rio: Coleta da SPI KY8030 da linha 2 da Flex - 28/08/2018
/*
 * Substituida pela classe ICSpiKY2
 */
@Deprecated
public class ICSpiSemp extends ICFlex {
	
	private BufferedEventos bufferEventos = new BufferedEventos();
	
	private ArquivoUltimoID ultimoID = null;

	public ICSpiSemp(IcDTO icdto) {
		super(icdto, new WatcherTriggerSpiKy2(), false);
		WatcherTriggerSpiKy2 trigger = (WatcherTriggerSpiKy2) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos, icdto);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		
		List<EventoColetado> lista = bufferEventos.getEventos().getEventosColetados();
		
		for (EventoColetado ev:lista){
			
			if (ev.getCdop() != null && !ev.getCdop().equals("")){
				//parada.setOpParadaECiclo(ev.getCdop());
			}
			
			if (ev.getTipoEvento() != 18 && ev.getTipoEvento() != 3 && ev.getTipoEvento() != 4){
				//parada.fimParada();
			}
			
		}
		
		return bufferEventos.obtemEventos();
	}

	
	// Criar novo inicializaIC para poder inicializar tambem o ultimoID
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		ultimoID = new ArquivoUltimoID(Stubedelegate.getInstancia().getMsthread().getPathCacheColeta());
		ultimoID.loadUltimoID(icdto);
		
		((WatcherTriggerSpiKy2) getTrigger()).setArquivoUltimoID(this.ultimoID);
		
		this.log = log;
		this.idLog = log.getIdAleatorio();
		inicializarOuFinalizarWatcher();

	}

}
