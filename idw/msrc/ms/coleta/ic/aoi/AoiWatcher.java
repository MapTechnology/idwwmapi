package ms.coleta.ic.aoi;

import java.io.File;
import java.util.Date;
import java.util.List;
import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.AWatcher;
import ms.coleta.ic.coletalogs.TratadorHeartBeat;

import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;


/*
 * Essa classe nao deve ser utilizada, sua funcionalidade foi direcionada para a classe ICAoiOmron
 * e para ICAoiTri7500
 */
@Deprecated
public class AoiWatcher extends AWatcher {

	private ICAoiOmron ic;
	private int idLog = log.getIdAleatorio();
	private WatcherAoiOmron w = null;
	
	public AoiWatcher(IdwLogger log, ICAoiOmron ic) {
		super(log);
		this.ic = ic;
	}
	
	@Override
	public void iniciarWatcher() {
		log.info("Iniciando watcher AoiWatcher");
		try {
			String caminho = caminhos.get(0);
			IcUpDTO icUpDTO = icUpDTOList.get(0);
			TratadorArquivos tratador = null;
			
			// Determinando tipo de tratador apropriado para o tipo de AOI
			// o if abaixo nao eh necessario pois o tipo do ic agora eh especifico
			//if (ic.getIcdto().getUrl_conexao() != null && ic.getIcdto().getUrl_conexao().toLowerCase().contains("omron")) {
				tratador = new TrataArquivosAoiOmronGerandoEventos(log, getIcUpDTOList(), ic);
			//} else {
//				tratador = new TrataArquivosAoiTri7500GerandoEventos(log, getIcUpDTOList(), ic);
			//}
			
			//Luiz - 20190607 - Comentei a linha abaixo para utilizar o meu watcher temporariamente para o blockchain
			// O watcher 
			//w = new WatcherDiretoriosAOI(icUpDTO, (new File(caminho)).toPath(), log, idLog, tratador);
			w = new WatcherAoiOmron(icUpDTO, (new File(caminho)).toPath(), log, idLog, tratador);
//			w.start();
		} catch (Exception e) {
			log.info("AoiWatcher:", e);
			e.printStackTrace();
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
	
	@Override
	public void finalizar(){
		if(w.isExecutandoWatcher()) {
			this.w.setExecutandoWatcher(false);
		}
		
	}
	
}
