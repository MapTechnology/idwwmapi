package idw.servlets;

import org.quartz.Scheduler;

import idw.model.pojos.OmJob;

public class JobEmExecucaoDTO {

	private OmJob omjob;
	private Boolean isExecutando = false;
	private Scheduler scheduler = null;
	
	public OmJob getOmjob() {
		return omjob;
	}
	public void setOmjob(OmJob omjob) {
		this.omjob = omjob;
	}
	public Boolean getIsExecutando() {
		return isExecutando;
	}
	public void setIsExecutando(Boolean isExecutando) {
		this.isExecutando = isExecutando;
	}
	public Scheduler getScheduler() {
		return scheduler;
	}
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
}
