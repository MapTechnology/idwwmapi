package idw.model.rn.jobs;

import java.util.ArrayList;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmJob;
import idw.model.rn.AbstractRN;
import idw.servlets.JobEmExecucaoDTO;
import idw.util.IdwLogger;

public class GerenciadorJobsRN extends AbstractRN<DAOGenerico> implements IDao {

	public GerenciadorJobsRN() {
		super(new DAOGenerico());
	}
	
	public GerenciadorJobsRN(DAOGenerico dao) {
		super(dao);
	}

	/* Esse metodo deve excluir os jobs desativados ou incluir novos jobs
	 * alem de definir o quartz (parando ou iniciando novos quartz
	 */
	public List<JobEmExecucaoDTO> refreshNosJobs(List<JobEmExecucaoDTO> jobs, IdwLogger log, int idLog) {
		
		List<JobEmExecucaoDTO> jobsAtualizados = new ArrayList<>();
		
		// Obtem a lista de todos os Jobs
		List<OmJob> listaOmJob = pesquisarOmJobAtivos();

		// Inclui ou marca para parar um novo job
		log.info(idLog, 5, "Avaliando a lista de jobs na qtde=" + listaOmJob.size());
		for (OmJob omjob : listaOmJob) {
			log.info(idLog, 5, "Testando job " + omjob.getCdJob() + " se existe como job iniciado");
			boolean isExiste = false;
			JobEmExecucaoDTO dtoNovo = null;
			for (JobEmExecucaoDTO dto : jobs) {
				if (dto.getOmjob().getCdJob().equals(omjob.getCdJob())) {
					isExiste = true;
					dtoNovo = dto;
					break;
				}
			}
			if (isExiste == false) {
				log.info(idLog, 5, "Job não está na fila do quartz. Incluindo");
				// Definir dto
				dtoNovo = new JobEmExecucaoDTO();
				dtoNovo.setOmjob(omjob);
				dtoNovo.setIsExecutando(false); // Sera true qdo efetivamente estiver rodando

				// Incluir novo JOB no quartz
				SchedulerFactory sf = new StdSchedulerFactory();
				Scheduler sched = null;
				try {
					sched = sf.getScheduler();
					//sched.getContext().put("dto", dtoNovo); nao pode ser no contexto, pois o contexto eh unico e sempre eh sobreposto
				} catch (SchedulerException e) {
					e.printStackTrace();
					log.info(idLog, 5, "Excessao:", e);
				}
				
				
				
				JobDetail job = JobBuilder.newJob(IntegracaoIDWJob.class).withIdentity(omjob.getCdJob() /*"job1"*/, "group1").build();
				job.getJobDataMap().put("dto", dtoNovo);

				CronTrigger trigger = TriggerBuilder.newTrigger()
						.withIdentity("trigger" + omjob.getCdJob(), "group1")
						.withSchedule(CronScheduleBuilder.cronSchedule(omjob.getPadraoSchedule()))
						.build();
				// "0 0 0am * * ?" todos os dias a meia-noite

				log.info(idLog, 5, "Iniciando o job " + omjob.getCdJob());
				try {
					sched.scheduleJob(job, trigger);
					sched.start();
					log.info(idLog, 5, "Job iniciado " + omjob.getCdJob());
				} catch (SchedulerException e) {
					e.printStackTrace();
					log.info(idLog, 5, "Excessao:", e);
				}
				
				dtoNovo.setScheduler(sched);

			} else {
				log.info(idLog, 5, "Log já está na fila do quartz.");
			}
			
			// Incluir job atualizado
			jobsAtualizados.add(dtoNovo);
		}
		
		
		// Remove os jobs que não estão mais na lista
		for (JobEmExecucaoDTO dto : jobs) {
			boolean isExiste = false;
			for (OmJob omjob : listaOmJob) {
				if (omjob.getCdJob().equals(dto.getOmjob().getCdJob())) {
					isExiste = true;
					break;
				}
			}
			
			// Se o item nao existe mais na lista ou nao esta mais executando por algum motivo (ex. mudanca da string da periodicidade)
			if (isExiste == false && dto.getIsExecutando() == false) {
				try {
					log.info(idLog, 5, "Removendo o job da fila do quartz.");
					dto.getScheduler().shutdown();
				} catch (SchedulerException e) {
					e.printStackTrace();
					log.info(idLog, 5, "Excessao:", e);
				}
			}
		}
		return jobsAtualizados;
	}
	
	
	private List<OmJob> pesquisarOmJobAtivos() {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmJob a");
		q.append("where a.stAtivo = 1");
		
		return q.list();
	}
}
