package idw.model.rn.joblog;

import java.io.Serializable;
import java.util.Date;

public class FiltroPesquisaOmJobDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdJob;
	private Date dthrIExecucao;
	private Date dthrFExecucao;
	private Integer qtdeRegistros;
	
	
	public String getCdJob() {
		return cdJob;
	}
	public void setCdJob(String cdJob) {
		this.cdJob = cdJob;
	}
	public Date getDthrIExecucao() {
		return dthrIExecucao;
	}
	public void setDthrIExecucao(Date dthrIExecucao) {
		this.dthrIExecucao = dthrIExecucao;
	}
	public Date getDthrFExecucao() {
		return dthrFExecucao;
	}
	public void setDthrFExecucao(Date dthrFExecucao) {
		this.dthrFExecucao = dthrFExecucao;
	}
	public Integer getQtdeRegistros() {
		return qtdeRegistros;
	}
	public void setQtdeRegistros(Integer qtdeRegistros) {
		this.qtdeRegistros = qtdeRegistros;
	}
	
	
}
