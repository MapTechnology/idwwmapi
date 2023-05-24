package ms.coleta.ic.jconcentrador;

import java.util.List;

import ms.coleta.ic.sony.SonyWatcher;
import ms.model.dto.IcUpDTO;

public class TratadorHeartBeat extends Thread{
	
	private boolean continuarExecutando = true;
	private List<IcUpDTO> icUpDTOList = null;
	private JConcentrador jConcentrador;
	
	private int tempoParaMonitorarParadaAutomatica = 10 * 1000;
	
	public TratadorHeartBeat(List<IcUpDTO> icUpDTOList, JConcentrador Jcon) {
		this.icUpDTOList = icUpDTOList;
		this.jConcentrador = Jcon;

	}
	
	@Override
	public void run() {
		int contador = 0;
		int contadorHeartBeat = 0;
		while (continuarExecutando) {
			this.jConcentrador.monitoraParadaAutomaticaHeartBeat(tempoParaMonitorarParadaAutomatica);
			contador = contador + 1;
			contadorHeartBeat = contadorHeartBeat + 1;
			if (contador >= 5) {
				this.jConcentrador.atualizaOpsDasUps();
				contador = 0;
			}
			if(contadorHeartBeat >= 3) {
				this.jConcentrador.geraEventoHeartBeat();
				contadorHeartBeat = 0;
			}
			try {
				Thread.sleep(tempoParaMonitorarParadaAutomatica);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	

}
