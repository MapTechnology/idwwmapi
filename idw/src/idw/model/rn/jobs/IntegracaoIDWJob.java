package idw.model.rn.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import idw.model.pojos.OmJob;
import idw.model.rn.integracao.AIntegracaoBackground;
import idw.model.rn.integracao.IntegracaoBackgroundFactory;
import idw.servlets.JobEmExecucaoDTO;
import idw.util.IdwLogger;

public class IntegracaoIDWJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		IdwLogger log = new IdwLogger("IntegracaoIDWJobQuartz");
		int idLog = log.getIdAleatorio();
	    
		log.info(idLog, 0, "Iniciando integracaoIDWJob chamada a partir do quartz");
		
		/* Alessandre em 02-05-22 o trecho abaixo foi comentado e substituido pelo seguinte pois o "dto" no contexto eh sempre sobreposto na criacao do job
		 * 
		SchedulerContext schedulerContext = null;
        try {
            schedulerContext = context.getScheduler().getContext();
        } catch (SchedulerException e1) {
            e1.printStackTrace();
            log.info(idLog, 5, "Excesao:", e1);
        }
        
        JobEmExecucaoDTO dto = (JobEmExecucaoDTO) schedulerContext.get("dto");
        		 */

		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		
        JobEmExecucaoDTO dto = (JobEmExecucaoDTO) dataMap.get("dto");
        
        if (dto.getIsExecutando() == false) {
	        OmJob omjob = dto.getOmjob();
	        
	        log.info(idLog, 5, "Executando job " + omjob.getCdJob());
	
			AIntegracaoBackground integracao = IntegracaoBackgroundFactory.getIntegracao(omjob);
			try {
				dto.setIsExecutando(true);
				integracao.iniciaConexaoBancoStatless();
				integracao.integrar(log, idLog);
			} catch (Exception e) {
				e.printStackTrace();
				log.info(idLog, 0, "Excessao:", e);
			} finally {
				log.info(idLog, 5, "Finalizando execucao do job " + omjob.getCdJob());
				dto.setIsExecutando(false);
				integracao.finalizaConexaoBancoStatless();
			}
			integracao = null; // ajudar o GB na limpeza da memoria
        } else {
    		log.info(idLog, 5, "Não executou pois job já em execução: " + dto.getOmjob().getCdJob());
        }
		log.info(idLog, 0, "Finalizando integracaoIDWJob");
	}

}
