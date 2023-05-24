package ms.coleta.ic.coletalogs;

import java.util.List;

import ms.coleta.ic.fornos.FornoWatcher;
import ms.model.dto.IcUpDTO;

public class TratadorHeartBeat extends  Thread {

	private boolean continuarExecutando = true;
	private List<IcUpDTO> icUpDTOList = null;
	private AWatcher watcher;
	
	private int tempoParaLancarHeartBeat = 5 * 60 * 1000;
	
	public TratadorHeartBeat(List<IcUpDTO> icUpDTOList, AWatcher watcher) {
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

	public int getTempoParaLancarHeartBeat() {
		return tempoParaLancarHeartBeat;
	}

	public void setTempoParaLancarHeartBeat(int tempoParaLancarHeartBeat) {
		this.tempoParaLancarHeartBeat = tempoParaLancarHeartBeat;
	}

}