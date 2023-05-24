package idw.servlets;

import java.util.ArrayList;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.model.rn.jobs.GerenciadorJobsRN;
import idw.util.IdwLogger;
import idw.util.ThreadUtil;

public class GerenciadorDeJobsThread  extends Thread{
	
	private final long _DELAY_GERENCIADOR = 120000;

	private IdwLogger log = null;
	private boolean isThreadExecutando = true;
	
	private List<JobEmExecucaoDTO> jobs = new ArrayList<>();

	public GerenciadorDeJobsThread() {
		this.setName("GerenciadorDeJobsThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}

	@Override
	public void run() {
		this.log = new IdwLogger("GerenciadorDeJobsThread");

		// Loop infinito para thread de gerenciamento de jobs
		while (this.isThreadExecutando == true){
			int idLog = this.log.getIdAleatorio();

	        // Obtem dados do MS que irá ser executado
			this.log.info(idLog, 0, "Iniciando GerenciadorDeJobsThread " + DataHoraRN.getDataHoraMiliAtualFormatada());

			GerenciadorJobsRN rn = new GerenciadorJobsRN();
			try {
				rn.iniciaConexaoBanco();
				
				this.jobs = rn.refreshNosJobs(this.jobs, log, idLog);
				
			} catch (Exception e) {
				log.info(idLog, 5, "Erro:", e);
				e.printStackTrace();
			} finally {
				rn.finalizaConexaoBanco();
			}
			
			rn = null; // ajudar o GB na limpeza
			
	        this.log.info(idLog, 0,
	        		  "Finalizando GerenciadorDeJobsThread "		        		 
	        		+ " com " + this.log.getAvaliacaoCompleta()
	        		+ ". Esperando " + (this._DELAY_GERENCIADOR /1000 /60) + "min para proxima importação.");

			// Pausa para uma nova Importacao
	        ThreadUtil.pausaNaThread(this._DELAY_GERENCIADOR);
		}

	}

	public void pararThread(){
		this.isThreadExecutando = false;
	}

}
