package idw.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import idw.model.IdwFacade;
import idw.model.rn.consolidacao.ControleConsolidacaoMsEvt;
import idw.util.IdwLogger;
import ms.util.UtilsThreads;

public class ConsolidacaoMsEvtListener implements ServletContextListener {
    private static final String PARAM_CONSOLIDACAO_EVENTOS_PARA_PROCESSAR = "consolidacao.qtEventosPt";
    private static final String PARAM_CONSOLIDACAO_THREADS_PT = "consolidacao.qtThreadsPt";
    private IdwLogger log = new IdwLogger("ConsolidacaoEventosListener");
    private int idLog = 0;
    private int identacao = 0;
    private ControleConsolidacaoMsEvt controleConsolidacaoMsEvt;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        try {
            log.info(idLog, identacao, "Destruindo contexto ConsolidacaoEventosListener");

            log.info(idLog, identacao, "Parando ConsolidacaoMsEvtThread");

            controleConsolidacaoMsEvt.finalizar();

            log.info(idLog, identacao, "Contexto ConsolidacaoEventosListener destruido");
        } catch (Exception e) {
            e.printStackTrace();
            log.info(idLog, 0, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        try {
            idLog = log.getIdAleatorio();

            log.info(idLog, identacao, "Inicializando contexto");
            
            UtilsThreads.pausaNaThread(5000);

            // Sinalizando que o IDW est� ativo. Assim todos os webservices do Injet lancar�o eventos tamb�m para o IDW msevt
            if (Boolean.parseBoolean(arg0.getServletContext().getInitParameter("IDWAtivo")) == true) {
                log.info(idLog, identacao, "Ativando IDW");
                IdwFacade.getInstancia().setIDWAtivo(true);
            } else {
                log.info(idLog, identacao, "IDW Desativado em Web.xml");
                IdwFacade.getInstancia().setIDWAtivo(false);
            }

            final String qtThreadsPt = arg0.getServletContext().getInitParameter(PARAM_CONSOLIDACAO_THREADS_PT);
            final String qtEventosParaProcessar = arg0.getServletContext().getInitParameter(PARAM_CONSOLIDACAO_EVENTOS_PARA_PROCESSAR);

            controleConsolidacaoMsEvt = new ControleConsolidacaoMsEvt(qtThreadsPt, qtEventosParaProcessar);
            controleConsolidacaoMsEvt.iniciar();

            log.info(idLog, identacao, "Fim inicialização");

        } catch (Exception e) {
            e.printStackTrace();
            log.info(idLog, 0, e);
            throw new RuntimeException(e);
        }
    }
}
