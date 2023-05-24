package ms.coleta.ic.juki;

import java.util.List;

import ms.model.dto.IcUpDTO;

public class TratadorHeartBeat extends  Thread {

	private boolean continuarExecutando = true;
	private List<IcUpDTO> icUpDTOList = null;
	private JukiWatcher watcher;
	
	private int tempoParaLancarHeartBeat = 5 * 60 * 1000;
	// private int tempoParaLancarHeartBeat = 30 * 1000;
	
	public TratadorHeartBeat(List<IcUpDTO> icUpDTOList, JukiWatcher watcher) {
		this.icUpDTOList = icUpDTOList;
		this.watcher = watcher;
	}
	
	@Override
	public void run() {

		while (continuarExecutando) {
			watcher.monitoraHeartBeat(icUpDTOList);
			try {
				Thread.sleep(tempoParaLancarHeartBeat);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public boolean isContinuarExecutando() {
		return continuarExecutando;
	}

	public void setContinuarExecutando(boolean continuarExecutando) {
		this.continuarExecutando = continuarExecutando;
	}

}