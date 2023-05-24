package tftp;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TFTPServerListener implements ServletContextListener{
	private IdwLogger log =  new IdwLogger("TFTPServerListener");

	private TFTPServerThread tftpthread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Destruindo contexto TFTPServerListener");

		log.info("Parando TFTPServerThread");
		this.tftpthread.pararThread();
		
		log.info("Contextro TFTPServerListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		IwsFacade.setRealRootPath(arg0.getServletContext().getRealPath(""));
		TFTPDefines.TFTP_PORT = Integer.valueOf(arg0.getServletContext().getInitParameter("portatftp"));
		System.out.println("dir do contexto " + arg0.getServletContext().getRealPath(""));
		System.out.println("porta tfpf=" + TFTPDefines.TFTP_PORT);
		log.info("Inicializando TFTPServerListener as " + DataHoraRN.getDataHoraAtual());
		//Inicializa a thread do MS arg0.getServletContext().getRealPath("")
		tftpthread = new TFTPServerThread(IwsFacade.getRealRootPath(),log);
		//tftpthread = new TFTPServerThread("C:/Senoj/04_Shared/tftp/",log);
		tftpthread.start();
	}
}
