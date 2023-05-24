package ms.coleta.ic.alcatel;


import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;

import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class TrataArquivoGerandoEventos implements FileListener{

	private AlcatelBufferedEventos bufferEventos;
	private IdwLogger log;
	
	public TrataArquivoGerandoEventos(AlcatelBufferedEventos bufferEventos, IdwLogger log) {
		super();
		this.bufferEventos = bufferEventos;
		this.log = log;
	}
	
	@Override
	public void fileCreated(FileChangeEvent arg0) throws Exception {
		log.info("Lendo arquivo =" + arg0.getFile().getName().getBaseName());
		
		ArquivoAlcatel arquivo = new ArquivoAlcatel(log);
		
		EventoColetado evento = arquivo.obtemEvento(arg0.getFile().getContent().getInputStream()); 
				
		this.bufferEventos.addEvento(evento);
		
		// Incluir um evento de ciclo para cada passagem
		EventoColetado eventoCiclo = new EventoColetado();
		eventoCiclo.setTipoEvento(ServicoFactory._FIM_CICLO);
		eventoCiclo.setDthrEvento(evento.getDthrEvento());
		eventoCiclo.setIcUpDTO(evento.getIcUpDTO());
		eventoCiclo.setCb(evento.getCb());
		eventoCiclo.setNumeroSerie(evento.getNumeroSerie());
		
		this.bufferEventos.addEvento(eventoCiclo);
	}


	

	
	
	@Override
	public void fileChanged(FileChangeEvent arg0) throws Exception {
	}

	@Override
	public void fileDeleted(FileChangeEvent arg0) throws Exception {
	}

}
