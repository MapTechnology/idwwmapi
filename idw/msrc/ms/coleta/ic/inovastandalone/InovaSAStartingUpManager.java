package ms.coleta.ic.inovastandalone;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class InovaSAStartingUpManager {
	private static InovaSAStartingUpManager instancia = null;
	private LinkedList<String> fifoInovaSAStartingUp = null;	
	private final Semaphore fifoAvailable = new Semaphore(1);

	public InovaSAStartingUpManager() {			
	}
	
	public static InovaSAStartingUpManager getInstancia() {
		if(instancia == null)
			instancia = new InovaSAStartingUpManager();
		return instancia;
	}
	
	protected void getListaSemaphore() {
		try {
			fifoAvailable.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void releaseMsgSemaphore() {
		fifoAvailable.release();
	}

	public void addInovaSAIP(String ip){
		getListaSemaphore();
		if(fifoInovaSAStartingUp==null){
			fifoInovaSAStartingUp=new LinkedList<String>();
		}
		fifoInovaSAStartingUp.add(ip);				
		releaseMsgSemaphore();
	}

	public String getInovaSAIP(){
		String retorno = null;
		getListaSemaphore();
		if(fifoInovaSAStartingUp != null && fifoInovaSAStartingUp.isEmpty() == false){
			retorno = fifoInovaSAStartingUp.removeFirst();
		}
		releaseMsgSemaphore();
		return retorno;
	}
}
