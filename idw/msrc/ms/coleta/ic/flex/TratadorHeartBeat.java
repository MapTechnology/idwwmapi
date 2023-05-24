package ms.coleta.ic.flex;

import java.util.Date;

import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;

public class TratadorHeartBeat extends  Thread {
	
	private IdwLogger log = null;
	private boolean continuarExecutando = true;
	private IcDTO icdto;
	
	private int tempoParaMonitorarParadaAutomatica =  10 * 1000; // em ms

	
	public TratadorHeartBeat(IcDTO icdto,  IdwLogger log) {
		super();
		this.icdto = icdto;
		this.log = log;
	}



	@Override
	public void run() {

		while (continuarExecutando) {
			try {
				geraHeartBeat();
				Thread.sleep(tempoParaMonitorarParadaAutomatica);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void geraHeartBeat() {
		// Chama web-service IcHeartBeat
		String urlIC = icdto.getCd_ic();
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setIdentacao(0);
		eventoColetado.setLog(log);

		try {
			Stubedelegate.getInstancia().icHeartBeat( 0 , urlIC, eventoColetado);
		} catch (ServicoFalhouException e) {
			log.error ("Falha ao chamar Stubedelegate.getInstancia().icHeartBeat em geraHeartBeat() " + e.toString());
		} catch (Exception e) {
			log.error ("Falha ao chamar Stubedelegate.getInstancia().icHeartBeat em geraHeartBeat() " + e.toString());
		}
		
	}



	public IcDTO getIcdto() {
		return icdto;
	}

	public void setIcdto(IcDTO icdto) {
		this.icdto = icdto;
	}
	
	public boolean isContinuarExecutando() {
		return continuarExecutando;
	}

	public void setContinuarExecutando(boolean continuarExecutando) {
		this.continuarExecutando = continuarExecutando;
	}
		
}
