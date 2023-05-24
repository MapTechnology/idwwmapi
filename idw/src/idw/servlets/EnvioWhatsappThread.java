package idw.servlets;

import idw.model.pojos.template.OmCfgTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.ThreadUtil;
import idw.util.whatsapp.IWhatsapp;
import idw.util.whatsapp.WhatsappFactory;
import ms.coleta.ic.inova.Stubdelegate;

public class EnvioWhatsappThread extends Thread{

	private final long _DELAY_IMPORTACAO = 60000;

	private IdwLogger log = null;
	private boolean isThreadExecutando = true;

	public EnvioWhatsappThread() {
		this.setName("EnvioWhatsappThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}
	

	@Override
	public void run() {
		// Ja que essa thread foi ativa, entao informar que a conexao com a base do injet deve ser estabelecida
		Stubdelegate.getInstancia().setInjetAtivo(true);

		this.log = new IdwLogger("EnvioWhatsappThread");

		// Loop infinito para thread de importação do Injet
		while (this.isThreadExecutando == true){

			int idLog = this.log.getIdAleatorio();
			int identacao = 5;

	        // Obtem dados do MS que irá ser executado
			this.log.info(idLog, 0, "Iniciando EnvioWhatsappThread " + DataHoraRN.getDataHoraMiliAtualFormatada());


			try {
				
				IWhatsapp servicozap = WhatsappFactory.getInstancia().obtemProvedor(OmCfgTemplate.TpWhatsapp._TWILIO.getValue()); // substituir esse pelo omcfg
				servicozap.enviarMensagens();

			} catch (Exception e){
				this.log.info(idLog, identacao, "Ocorreu a excessao", e);
				e.printStackTrace();
			} finally {

			}
			

	        // Pausa para uma nova Importacao
	        ThreadUtil.pausaNaThread(this._DELAY_IMPORTACAO);

		}
	}

	public void pararThread(){
		this.isThreadExecutando = false;
	}
}
