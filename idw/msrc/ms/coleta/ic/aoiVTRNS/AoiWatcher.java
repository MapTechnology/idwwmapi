package ms.coleta.ic.aoiVTRNS;

import java.io.File;
import java.util.Date;
import java.util.List;
import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.AWatcher;
import ms.coleta.ic.coletalogs.TratadorHeartBeat;

import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;


public class AoiWatcher extends AWatcher {

	private ICAoiVTRNS ic;
	private int idLog = log.getIdAleatorio();
	
	public AoiWatcher(IdwLogger log, ICAoiVTRNS ic) {
		super(log);
		this.ic = ic;
	}
	
	@Override
	public void iniciarWatcher() {
		log.info("Iniciando watcher AoiWatcher");
		WatcherDiretoriosAOI w = null;
		try {
			String caminho = caminhos.get(0);
			IcUpDTO icUpDTO = icUpDTOList.get(0);
			TratadorArquivos tratador = null;
			
			// Determinando tipo de tratador apropriado para o tipo de AOI
			tratador = new TrataArquivosAoiVTRNSGerandoEventos(log, getIcUpDTOList(), ic);
			
			w = new WatcherDiretoriosAOI(icUpDTO, (new File(caminho)).toPath(), log, idLog, tratador);
			w.start();
		} catch (Exception e) {
			log.error(e);
		}
		
		// Lanca HeartBeats
		TratadorHeartBeat t = new TratadorHeartBeat(getIcUpDTOList(), this);
		t.setName("monitoraHeartBeatAoi");
		addTratadorHeartBeat(t, "monitoraHeartBeatAoi");
		t.start();
	}
	

	@Override
	public void monitoraHeartBeat(List<IcUpDTO> list) {
		// Lan�a evento de HeartBeat
		// Como e criado um watcher por IC, basta lancar aqui um evento de HeartBeat
		List<EventoColetado> eventos;
		for (IcUpDTO auxIcUpDTO : list) {
			if (auxIcUpDTO.getUrlConexao() != null
					&& !auxIcUpDTO.getUrlConexao().equals("")) {
				File caminhoRemoto = new File(auxIcUpDTO.getUrlConexao());
				if (caminhoRemoto.exists()) {
					eventos = geraEventoHeartBeat(new Date(), auxIcUpDTO);
					ic.getBufferEventos().addEventos((eventos));
				}
			}
		}
	}
	
}

