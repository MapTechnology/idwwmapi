package ms.coleta.ic.sony;

import java.util.List;

import ms.model.dto.IcUpDTO;

public class TratadorHeartBeat extends  Thread {

	private boolean continuarExecutando = true;
	private List<IcUpDTO> icUpDTOList = null;
	private SonyWatcher watcher;
	
	private int tempoParaMonitorarParadaAutomatica = 5 * 60 * 1000;
	
	// TratadorHeartBeat(String nomeThread, List<IcUpDTO> icUpDTOList, SonyWatcher watcher, int tempoParaMonitorarParadaAutomatica) {
	public TratadorHeartBeat(List<IcUpDTO> icUpDTOList, SonyWatcher watcher) {
		this.icUpDTOList = icUpDTOList;
		this.watcher = watcher;
	}
	
	@Override
	public void run() {

		while (continuarExecutando) {
			watcher.monitoraParadaAutomaticaHeartBeat(icUpDTOList);
			try {
				Thread.sleep(tempoParaMonitorarParadaAutomatica);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
