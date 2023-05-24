package ms.coleta.ic.inovastandalone;

import idw.util.IdwLogger;
import ms.coleta.ICThread;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.ICFactory;
import ms.coleta.ic.IIC;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.IcDTO;
import ms.model.dto.EventoColetado;
import idw.model.rn.DataHoraRN;
import ms.util.UtilsThreads;

public class InovaStandaloneThread extends ICThread { 


	private IcDTO dadosicdtolocal;
	private IIC ic = null;
	private boolean isICInicializado = false;
	private boolean isThreadExecutando = true;
	private boolean isICOnline = true; 
	private IdwLogger log;

	public InovaStandaloneThread(){

	}
	public InovaStandaloneThread(IcDTO dadosicdtolocal) {
		this.dadosicdtolocal = dadosicdtolocal;
		this.ic = ICFactory.getInstancia().getMS(this.dadosicdtolocal);

		if (this.dadosicdtolocal.getCd_ic() == null){
			this.log = new IdwLogger("semurl");
		} else {
			this.log = new IdwLogger(this.dadosicdtolocal.getCd_ic());
		}
		this.dadosicdtolocal.setLog(this.log);
		this.setName("IC:"+dadosicdtolocal.getUrl_conexao() + "-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}

	public IcDTO getDadosIcDTO() {
		return this.dadosicdtolocal;
	}

	public void setDadosIcDTO(IcDTO ms) {
		this.dadosicdtolocal = ms;
	}



	@Override
	public void run() {
		// Inicializa dispositivo
		log.iniciaAvaliacao("Inicializacao IC " + this.getDadosIcDTO().getUrl_conexao());
		log.info("INICIALIZANDO thread para IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada());
		do {
			try {
				if (this.ic == null) {
					
					isThreadExecutando = false;
					break;
				}

				this.isICInicializado = false;
				this.ic.inicializaIC(log);
				this.isICInicializado = true;
				this.isICOnline = true;
			} catch (SemComunicacaoICException e1) {
				if (this.isICOnline == true)
					log.info("FALHOU inicializa��o IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada() + " por " + e1.getMessage());

				this.isICOnline = false;
				UtilsThreads.pausaNaThread(30000);
			} catch (NullPointerException e2) {
				e2.printStackTrace();
				if (this.isICOnline == true)
					log.info("FALHOU Inicializacao do IC pois n�o existe um driver para o tipo IC = " + this.getDadosIcDTO().getTp_ic());

				this.isICOnline = false;
				UtilsThreads.pausaNaThread(30000);
			}

		} while (this.isICInicializado == false);	

		log.paraAvaliacao();
		log.info("INICIALIZANDO FIM thread para IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada() + " - " + log.getAvaliacaoCompleta());
		log.info("Entrando no loop infinito da thread do IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtual());
		// Loop infinito para leitura dos eventos do IC
		
		while (isThreadExecutando == true) {
			// Obtem um evento do MS (modulo de sinais)
			EventosColetados eventos;
			try {				
				eventos = ic.getEventos(getOmcfg());
				
				if (this.isICOnline == false){
					// Gera log de retorno nas comunicacoes com o IC
					log.info("ON-LINE IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada());
					
				}

				this.isICOnline = true;
			} catch (SemComunicacaoICException e1) {
				eventos = new EventosColetados();

				if (this.isICOnline == true){
					// Gera log informando perda de conexao com o IC
					log.info("OFF-LINE IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada());
					

				}
				this.isICOnline = false;
			}catch(Exception e){
				e.printStackTrace();
				log.info("Erro em GetEventos: "+e.getMessage());
				
				continue;
			}

			// Chama o servico correspondente ao evento ocorrido
			if (eventos.isExisteEvento() == true) {
				log.iniciaAvaliacao("Tratanto evento IC " + this.getDadosIcDTO().getUrl_conexao());
				log.info("Recebendo " + eventos.getEventosColetados().size() + " evento(s) do IC " + this.getDadosIcDTO().getUrl_conexao());
				

				// Varre todos os eventos recebidos chamando seus respectivos
				// parses
				MensagemRecebida mensagem = null;
				for (EventoColetado evento : eventos.getEventosColetados()) {
					mensagem = new MensagemRecebida(evento);
					mensagem.setLog(getLogAdquado(mensagem));

					mensagem.setDadosIcDTO(this.dadosicdtolocal);
					mensagem.setIc(this.ic);

					String dados=null;
					if (mensagem.getEventoColetado().getTipoEvento() != ServicoFactory._HEART_BEAT_INOVA){
						if(mensagem.getEventoColetado().getIcUpDTO().getUpDTO() == null){
							log.info("Evento das " + evento.getDthrEventoFormatadoParaEnvio() + " do tipo " + evento.getTipoEvento() + " descartado pois nao possui identificacao valida para a UP ");
							continue;
						}
						dados= " para IdIcUp = " + evento.getIcUpDTO().getIdIcUp();
					}else{
						dados= "Evento HeartBeat";
						
						mensagem.setIp(this.getDadosIcDTO().getUrl_conexao());
					}

					try {
						log.iniciaAvaliacao("Servi�o " + mensagem.getDescricaoServico() + dados);
						log.info("INICIO - Chamando servi�o para mensagem " + mensagem.getDescricaoServico() + " em " + DataHoraRN.getDataHoraAtualFormatada());
						ServicoFactory.getInstancia().executaServico(null, mensagem);
					} catch (ServicoFalhouException e) {
						// TODO Aqui devemos salvar o evento pendente e ficar tentando executa-lo se for um evento imprescindivel
						log.info("Salvando evento pois o mesmo nao foi processado");
					} catch (Exception e){
						log.info("AVALIAR ERROR: ", e);
						e.printStackTrace();
					} finally {
						log.paraAvaliacao();
						log.info("	FIM - Servi�o para mensagem " + mensagem.getDescricaoServico() + " finalizou em " + DataHoraRN.getDataHoraAtualFormatada() + " - " + log.getAvaliacaoCompleta());
					}

					// Se o log estiver em modo Trace, salvar todos os eventos coletados
					//log.salvarEventoColetado(evento);
				}

				log.paraAvaliacao();
				log.info("Recebendo FIM - " + eventos.getEventosColetados().size() + " evento(s) do IC " + this.getDadosIcDTO().getUrl_conexao() + " - " + log.getAvaliacaoCompleta());

			}
			UtilsThreads.pausaNaThread(100);
		}
		try {
			//finaliza IEThread
			if (ic != null)
				ic.finalizaIC();
		} catch (SemComunicacaoICException e) {
			log.info("Nao foi possivel finalizar o IC devido ao SemComunicacaoICException");
		}
		log.info("PARANDO thread de coleta do IC" + this.getDadosIcDTO().getIdIc());
		
	}

	public void pararThread(){
		isThreadExecutando = false;
	}	

	public IIC getIICAdam() {
		return this.ic;
	}
	public IdwLogger getLogAdquado(MensagemRecebida mensagem){
		IdwLogger retorno = log;
		return retorno;
	}
}
