package idw.servlets;

import idw.model.IdwFacade;
import idw.model.rn.DataHoraRN;

public class ImportaProgramaThread extends Thread {
	private boolean isContinuaExecutando = true;
	
	public ImportaProgramaThread(){
		this.setName("ImportaProgramaThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}
	
	@Override
	public void run() {
		try {
			sleep(5000);
		} catch (InterruptedException e1) {}

		while (isContinuaExecutando) {
			try{
				IdwFacade.getInstancia().importaPrograma();
			} catch (Exception e){
				e.printStackTrace();
				//System.out.println("Reiniciando a thread de importação de programas IAC");
			}
			
            try {
                sleep(300000);
				//System.out.println("Reiniciando a thread de importação de programas IAC");
            } catch (InterruptedException e) {}
        }
		//System.out.println("Saindo da thread de importação de programas IAC");

    }

	public void setContinuaExecutando(boolean isContinuaExecutando) {
		this.isContinuaExecutando = isContinuaExecutando;
	}
}
