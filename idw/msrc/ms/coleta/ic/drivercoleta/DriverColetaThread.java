package ms.coleta.ic.drivercoleta;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class DriverColetaThread extends Thread {
	
	private boolean isContinuaExecutando = true;
	private IdwLogger log;
	private String pathRelativo="";
	
	private DriverColetaRN driverColetaRN;
	
	public DriverColetaThread(String pathRelativo, IdwLogger log) {
		this.log=log;
		this.setName("DriverColetaThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
		this.pathRelativo=pathRelativo;
		
	}
	
	@Override
	public void run() {
		driverColetaRN = new DriverColetaRN(pathRelativo, log);
		while(isContinuaExecutando)
		{
			try {
				driverColetaRN.avaliarUpsParaProcessamento();
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setContinuaExecutando(boolean isContinuaExecutando) {
		this.isContinuaExecutando = isContinuaExecutando;
	}

}
