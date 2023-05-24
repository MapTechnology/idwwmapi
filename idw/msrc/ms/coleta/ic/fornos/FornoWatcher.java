package ms.coleta.ic.fornos;

import java.io.File;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.AFileMonitor;
import ms.coleta.ic.coletalogs.AWatcher;
import ms.coleta.ic.coletalogs.MapFileMonitor;
import ms.coleta.ic.coletalogs.TratadorHeartBeat;
import ms.coleta.ic.fuji.fujiflexa.TrataArquivosFujiFlexaGerandoEventos;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.ConversaoTipos;

public class FornoWatcher extends AWatcher {

	private ICForno ic;
	
	public FornoWatcher(IdwLogger log, ICForno ic) {
		super(log);
		this.ic = ic;
	}

	@Override
	public void iniciarWatcher() {
		log.info("Iniciando watcher FornoWatcher");
		
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("FujiWatcherFujiFlexa: excecao ao obter fsManager: ", e);
			e.printStackTrace();
		}

		// O MapFileMonitor tem como diferenca e vantagem sobre o DefaultFileMonitor ter limitacao de profundidade
		// dos arquivos. Apenas o primeiro subnivel e monitorado
		// fm = new DefaultFileMonitor(new TrataArquivosFujiFlexaGerandoEventos(log, getIcUpDTOList(), getIc()));
		// fm = new MapFileMonitor(new TrataArquivosDataGerandoEventos(log, getIcUpDTOList(), ic));
		fm = new FornoFileMonitor(new TrataArquivosDataGerandoEventos(log, getIcUpDTOList(), ic));
		fm.setRecursive(true);
		
		// Debounce 1
		// Garante que o FileMonitor nao seja ativado repetidas vezes seguidas
		// e garante um tempo para o arquivo terminar de ser escrito
		fm.setDelay(1 * 1000);
		
		setUrlsAMonitorar(fm, fsManager);
		
		// Ailton 2018-07-09: Ordenacao da lista de icUpDTOs; E necessario para o lancamento 
		// das termperatura por zonas;
		// icUpDTOList = ordenaIcUpDTOs();

		fm.start();
		
		// Lanca HeartBeats
		TratadorHeartBeat t = new TratadorHeartBeat(getIcUpDTOList(), this);
		t.setName("monitoraHeartBeatFornos");
		t.setTempoParaLancarHeartBeat(60*1000);
		addTratadorHeartBeat(t, "monitoraHeartBeatFornos");
		t.start();
	}
	
	// Ailton 2018-07-12:
	// Legacy
//	private List<IcUpDTO> ordenaIcUpDTOs() {
//		List<IcUpDTO> retorno = icUpDTOList;
//		
//		// Sorting
//		Collections.sort(retorno, new Comparator<IcUpDTO>() {
//		// Collections.sort(icUpDTOList, new Comparator<IcUpDTO>() {
//		        @Override
//		        public int compare(IcUpDTO icupdto1, IcUpDTO icupdto2)
//		        {
//
//		            //return  fruit1.fruitName.compareTo(fruit2.fruitName);
//		        	if (icupdto1.getUpDTO().getDs_up() !=  null
//		        			&& !icupdto1.getUpDTO().getDs_up().equals("")
//		        			&& icupdto2.getUpDTO().getDs_up() !=  null
//		        			&& !icupdto1.getUpDTO().getDs_up().equals("")) {
//		        		int zona1 = ConversaoTipos.converterParaInt(icupdto1.getUpDTO().getDs_up());
//		        		int zona2 = ConversaoTipos.converterParaInt(icupdto2.getUpDTO().getDs_up());
//		        		return Integer.compare(zona1, zona2);
//		        	}
//		        	return 0;
//		        }
//		    });
//		return retorno;
//	}

	@Override
	public void monitoraHeartBeat(List<IcUpDTO> list) {
		// Lança evento de HeartBeat
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
