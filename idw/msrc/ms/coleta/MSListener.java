package ms.coleta;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.IdwFacade;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.tcp.ServidorTcp;

public class MSListener implements ServletContextListener{
	public static final String PATH_CACHE_COLETA_PARAMETER = "diretorio";
	private ServidorTcp servidorTcp;
	private IdwLogger log =  new IdwLogger("MSListener");
	private MSThread msthread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Destruindo contexto MSListener");

		// Derrubar as thread criadas para os ICs
		log.info("Parando servidorTcp");
		servidorTcp.stopServer();

		// Derruba a thread do MS
		this.msthread.pararThread();

		log.info("Contextro MSListener destruido");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		log.info("Inicializando Mobilidade Total as " + DataHoraRN.getDataHoraAtual() + " vers�o " + idw.util.Util.getVersao());

		Stubedelegate.getInstancia().setPathRelativo(arg0.getServletContext().getRealPath(""));

		// Sinalizando que o IDW esta ativo. Assim todos os webservices do Injet lancar�o eventos tamb�m para o IDW msevt
        if(Boolean.parseBoolean(arg0.getServletContext().getInitParameter("IDWAtivo"))==true){
        	log.info("Ativando IDW");
        	IdwFacade.getInstancia().setIDWAtivo(true);
        }else{
        	log.info("IDW Desativado em Web.xml");
        	IdwFacade.getInstancia().setIDWAtivo(false);
        }

        String pathCacheColeta =  arg0.getServletContext().getInitParameter(PATH_CACHE_COLETA_PARAMETER);

		// Inicializa a thread do MS
		msthread = new MSThread(pathCacheColeta);
		msthread.start();

		// Guarda MSThread no Stubdelegate, pois sera necess�rio identificar as Ups pelos servicos que nao sao
		// chamados pelo ServidorTcp e nem pelo gerenciador MSThread, como porexemplo, eventos vindos do JConcentrador em C#
		Stubedelegate.getInstancia().setMsthread(msthread);


		// Inicializa servidor TCP para escutar as requisi�oes
		log.info("Inicializando servidorTcp as " + DataHoraRN.getDataHoraAtual());
        servidorTcp = new ServidorTcp();
        try {
			servidorTcp.startServer(3000);
		} catch (IOException e1) {
			e1.printStackTrace();
			log.info("Falha inicializa��o do servidorTcp");
		}

	}
}
