package ms.coleta.ic.inova.trataretorno;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import idw.webservices.MswsComEvt;
import injetws.model.IwsFacade;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsUpDTO;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inova.dto.INovaUpDTO;
import ms.excessao.SemComunicacaoICException;
import ms.util.UtilsThreads;
import ms.webservice.Msws;

public class TrataRetornoPreInicializacao extends TrataRetorno {
	public MswsComEvt ms = new MswsComEvt();
	public TrataRetornoPreInicializacao() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		int paradaDefault = parametro.getParadaDefault();
		Calendar dataEvento = parametro.getDataHoraEvento();
		
		IwsHorarioDTO horarioDTO = new IwsHorarioDTO();
		do {
			try {
				horarioDTO = ms.getTr_sincronizaHorario();
			} catch (Exception e) {
				log.info(idLog, 0, e.getMessage());
				log.info(idLog, 0, e.getStackTrace());
				log.info(idLog, 0, "---------------------");
			}
		} while(horarioDTO == null || horarioDTO.getData() == null);
		
		log.info(idLog, 0, "Fim SincronizaDthr em Evento 0.");
		
		Calendar data = Calendar.getInstance();
		data.setTime(horarioDTO.getData());
		
		this.ic.enviaSetDataHora(data);
		
		if(this.ic.dataHoraUltimoEvento == null)
			this.ic.dataHoraUltimoEvento = Calendar.getInstance();
		this.ic.dataHoraUltimoEvento.setTime(horarioDTO.getData());
		
		log.info(idLog, 0, "Fim SetDthr em Evento 0.");
		
//		listaMngmtAndon.Clear(); // TODO: fazer quando for fazer andon
//		inicializaListaReleAndon(); // TODO: fazer quando for fazer andon
		
		if (paradaDefault == 1)
			inicializaColetor(true, dataEvento);
		else
			inicializaColetor(false, dataEvento); //TODO: verificar passagem de data feita pelo victor
		
		log.info(idLog, 0, "Fim InicializaColetor em Evento 0.");
		
		// pegando horarioDTO

	}
	
	private void inicializaColetor(boolean comParadaSemConexao, Calendar dtHr) {
		boolean isInicializadoComSucesso = false;
		
		String idColetor = this.ic.getMsgerenciado().getUrl_conexao();
		
		while (isInicializadoComSucesso == false) {
			IwsListaUpDTO listaupdto = new IwsListaUpDTO();
			
			try {
				listaupdto = ms.getTr_inicializacao(idColetor, comParadaSemConexao, false, dtHr.getTime());
				//ainda n�o foi definido como ir� se portar com parada Default
			} catch(Exception e) {
				listaupdto.setIsSGBDOnline(false);
			}
			
			int tentativa = 1;
			
			log.info(idLog, 0, "Conectando...");
			
			while(listaupdto.getIsSGBDOnline() == false) {
				log.info(idLog, 0, "Conectando: " + tentativa);
				UtilsThreads.pausaNaThread(100);
				
				String mensagem;
				mensagem = "IP Coletor:(" + idColetor + "). Sem conex�o com o banco de dados. Tentativa " + tentativa + ".";
				
				log.info(idLog, 0, mensagem);
				UtilsThreads.pausaNaThread(2000);
				
				try {
					listaupdto = ms.getTr_inicializacao(idColetor, comParadaSemConexao, false, dtHr.getTime()); //ainda n�o foi definido como ir� se portar com parada Default
				} catch(Exception e) {
					// TODO: Exception sem tratamento
				}
				
				tentativa++;
			}
			
			List<IwsUpDTO> upsWebService = listaupdto.getUps();
			
			tentativa = 1;
			log.info(idLog, 0, "Obtendo...");
			
			while(upsWebService == null || upsWebService.size() == 0) {
				log.info(idLog, 0, "Obtendo: " + tentativa);
				UtilsThreads.pausaNaThread(100);
				
				String mensagem;
				mensagem = "Nenhuma Unidade Produtiva (UP) definida para esse coletor (" + idColetor + ").Entre em contato com o Administrador do sistema. Tentativa " + tentativa + ".";
				
				log.info(idLog, 0, mensagem);
				UtilsThreads.pausaNaThread(2000);
				
				if(this.ic.monitora == false) return;
				
				// TODO Quando o webservice parou o gerenciador parou na linha abaixo
				// no entando deveria continuar sem interrupcoes.
				
				listaupdto = ms.getTr_inicializacao(idColetor, comParadaSemConexao, false, dtHr.getTime()); //ainda n�o foi definido como ir� se portar com parada Default
				
				upsWebService = listaupdto.getUps();
				tentativa++;
			}
			
			boolean isUpBemDefinida = true;
			log.info(idLog, 0, "Sinc DB...");
			
			List<INovaUpDTO> ups = new ArrayList<INovaUpDTO>(upsWebService.size());
			
			for(IwsUpDTO updto : upsWebService) {
				INovaUpDTO up = new INovaUpDTO();
				up.copyUpDTOWs(updto);
				
				if(up.getStCriacaoCP() < 1 || up.getStCriacaoCP() > 9) {
					isUpBemDefinida = false;
					
					String mensagem;
					
					mensagem = "IP Coletor:(" + idColetor + "). Tipo de Controle de Produ��o n�o definido para a UP (" + up.getUp() + ").Valor atual " + up.getStCriacaoCP() + ". Entre em contato com o Administrador do sistema.";
					
					log.info(idLog, 0, mensagem);
					UtilsThreads.pausaNaThread(2000);
				}
				else {
					try {
						ups.add(Stubdelegate.getInstancia().InicializaUp(up));
					} catch (SemComunicacaoICException e) {
						// TODO: Exception sem tratamento
					}
				}
			}
			
			if(isUpBemDefinida)
				isInicializadoComSucesso = true;
			
			if(listaupdto.getStAndonConfiguravel() == true) {
				if(this.ic.isAndonAtivo == false) {
					this.ic.isAndonAtivo = true;
				}
				
				//armazenaListaUpdto(listaupdto); // TODO: criar quando for colocar andon configuravel
			}
			
			if (listaupdto.getStAndonProcessoft() == true && !this.ic.isAndonAtivo && (this.ic.isAndonPrcsftAtivo == false)) {
				this.ic.isAndonPrcsftAtivo = true;
			}
			
			this.ic.Ups = ups;
			
			this.ic.isIniciando = false;
			
		}
	}
	
	
}
