package ms.coleta;

import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.ICFactory;
import ms.coleta.ic.IIC;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.util.UtilsThreads;

public class ICThread extends Thread{

	private IcDTO dadosicdtolocal;
	private IIC ic = null;
	private boolean isICInicializado = false;
	private boolean isThreadExecutando = true;
	private boolean isInicializacaoAbortada = false; // Sera true caso o ic seja finalizado e a inicializacao ainda nao tenha sido concluida
	private boolean isICOnline = true;
	private IdwLogger log;
	private int idLog;

	private OmCfg omcfg; // Disponibilizar para os drivers usarem as configura��es do sistema

	public ICThread(){

	}
	public ICThread(IcDTO dadosicdtolocal) {
		this.dadosicdtolocal = dadosicdtolocal;
		this.ic = ICFactory.getInstancia().getMS(this.dadosicdtolocal);

		if (this.dadosicdtolocal.getCd_ic() == null){
			this.log = new IdwLogger("semurl");
		} else {
			this.log = new IdwLogger(this.dadosicdtolocal.getCd_ic());
		}
		this.idLog = this.log.getIdAleatorio();
		
		this.dadosicdtolocal.setLog(this.log);

		this.setName("IC:"+dadosicdtolocal.getCd_ic() + "-" + idLog);
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
		/*Adicionado por amaury em 04.11.14*/

		log.info(idLog, 0, "INICIALIZANDO thread para IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada());
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
				
				// Se a inicializacao tiver sido abortada, entao nao devemos
				if (this.isInicializacaoAbortada) {
					isThreadExecutando = false;
					break;
				}
					

			} catch (SemComunicacaoICException e1) {
				if (this.isICOnline == true)
					log.info(idLog, 0, "FALHOU inicializacao IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada() + " por " + e1.getMessage());

				this.isICOnline = false;
				UtilsThreads.pausaNaThread(30000);
			} catch (NullPointerException e2) {
				e2.printStackTrace();
				if (this.isICOnline == true)
					log.info(idLog, 0, "FALHOU Inicializacao do IC pois n�o existe um driver para o tipo IC = " + this.getDadosIcDTO().getTp_ic());

				this.isICOnline = false;
				UtilsThreads.pausaNaThread(30000);
			}

		} while (this.isICInicializado == false);

		log.paraAvaliacao();
		log.info(idLog, 0, "FIM - INICIALIZANDO thread para IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada() + " - " + log.getAvaliacaoCompleta());
		log.info(idLog, 0, "Entrando no loop infinito da thread do IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtual());
		// Loop infinito para leitura dos eventos do IC

		while (isThreadExecutando == true) {
			// Obtem um evento do MS (modulo de sinais)
			EventosColetados eventos;
			try {
				eventos = ic.getEventos(this.omcfg);

				if (this.isICOnline == false){
					// Gera log de retorno nas comunicacoes com o IC
					log.info(idLog, 0, "ON-LINE IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada());

				}

				this.isICOnline = true;
			} catch (SemComunicacaoICException e1) {
				eventos = new EventosColetados();

				if (this.isICOnline == true){
					// Gera log informando perda de conexao com o IC
					log.info(idLog, 0, "OFF-LINE IC " + this.getDadosIcDTO().getUrl_conexao() + " as " + DataHoraRN.getDataHoraAtualFormatada());


				}
				this.isICOnline = false;
			}catch(Exception e){
				e.printStackTrace();
				log.info(idLog, 0, "Erro em GetEventos: "+e.getMessage());

				continue;
			}

			// Chama o servico correspondente ao evento ocorrido
			if (eventos.isExisteEvento() == true) {
				log.iniciaAvaliacao("Tratanto evento IC " + this.getDadosIcDTO().getUrl_conexao());

				// Varre todos os eventos recebidos chamando seus respectivos
				// parses
				MensagemRecebida mensagem = null;
				for (EventoColetado evento : eventos.getEventosColetados()) {
					mensagem = new MensagemRecebida(evento);
					mensagem.setLog(log);
					mensagem.setIdLog(idLog);
					mensagem.setIdentacao(5);

					mensagem.setDadosIcDTO(this.dadosicdtolocal);
					mensagem.setIc(this.ic);
					String dados=null;

					if (mensagem.getEventoColetado().getTipoEvento() != ServicoFactory._IC_HEART_BEAT){
						try{
							if(mensagem.getEventoColetado() == null || mensagem.getEventoColetado().getIcUpDTO() == null || mensagem.getEventoColetado().getIcUpDTO().getUpDTO() == null){
								if(evento.getDthrEvento() == null){
									log.info(idLog, 0, "Evento DTHR NULO do tipo " + evento.getTipoEvento() + " descartado pois nao possui identificacao valida para a UP ");
								}else
									log.info(idLog, 0, "Evento das " + evento.getDthrEventoFormatadoParaEnvio() + " do tipo " + evento.getTipoEvento() + " descartado pois nao possui identificacao valida para a UP ");
								continue;
							}
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
							continue;
						}
						dados= " para IdIcUp = " + evento.getIcUpDTO().getIdIcUp();
					}else{
						dados= "Evento HeartBeat";
						mensagem.setIp(this.getDadosIcDTO().getUrl_conexao());
					}

					boolean isExecutouServico = false;
					int nMultiplicadorTempoEspera = 1;
					do {
						try {
							// Alessandre em 02-01-2019 removendo os logs qdo for o heartbeat pois o mesmo já tem um arquivo especifico
							if (mensagem != null && mensagem.getServico() != 18) {
								log.iniciaAvaliacao("Servico " + mensagem.getDescricaoServico() + dados);
								log.info(idLog, 0, "INICIO - Chamando servico para mensagem " + mensagem.getDescricaoServico() + " em " + DataHoraRN.getDataHoraAtualFormatada());
							}
							
							ServicoFactory.getInstancia().executaServico(null, mensagem);
							isExecutouServico = true;
	
						} catch (Exception e) {
							isExecutouServico = false;
							// Se o evento não foi finalizado, devemos tentar novamente, o mesmo não pode ser perdido, principalemnte se for uma rastreabilidade
							// vinda  a partir de um txt. O trataarqruivo já processou o txt, se perdermos o evento a rastreabilidade se perde.
							log.info(idLog, 0, "Salvando evento pois o mesmo nao foi processado");
							// TODO falta criar infra para o evento ser salvo e restaurado caso o servidor seja reiniciado entre esses 2 estados
							
							log.info(idLog, 0, "AVALIAR ERROR: ", e);
							e.printStackTrace();
							
							
							// Da um tempo para tentar novamente processar o servico. O Tempo de espera vai crescendo conforme as quantidades de tentativas
							long tempoEspera = nMultiplicadorTempoEspera * 100l;
							nMultiplicadorTempoEspera++;
							if (nMultiplicadorTempoEspera > 100) // limite maximo de espera em 10seg
								nMultiplicadorTempoEspera = 1;
							
							UtilsThreads.pausaNaThread(tempoEspera);
	
						} finally {
							if (mensagem != null && mensagem.getServico() != 18) {
								log.paraAvaliacao();
								log.info(idLog, 0, "FIM - Servico para mensagem " + mensagem.getDescricaoServico() + " finalizou em " + DataHoraRN.getDataHoraAtualFormatada() + " - " + log.getAvaliacaoCompleta());
							}
						}
					} while (isExecutouServico == false);
					
					// Se o log estiver em modo Trace, salvar todos os eventos coletados
					//log.salvarEventoColetado(evento);
				}

				log.paraAvaliacao();
				log.info(idLog, 0, "Tratou evento do IC " + this.getDadosIcDTO().getUrl_conexao() + " - em ms = " + log.getMilisegundosTranscorridos());

			}
			UtilsThreads.pausaNaThread(100);
		}
		try {
			//finaliza IEThread
			if (ic != null)
				ic.finalizaIC();
		} catch (SemComunicacaoICException e) {
			log.info(idLog, 0, "Nao foi possivel finalizar o IC devido ao SemComunicacaoICException");
		}
		log.info(idLog, 0, "PARANDO thread de coleta do IC " + this.getDadosIcDTO().getUrl_conexao());

	}

	public void pararThread(){
		isThreadExecutando = false;
		isInicializacaoAbortada = true;
	}

	public IIC getIICAdam() {
		return this.ic;
	}
	public IdwLogger getLogAdquado(MensagemRecebida mensagem){
		IdwLogger retorno = log;
		return retorno;
	}
	public OmCfg getOmcfg() {
		return omcfg;
	}
	public void setOmcfg(OmCfg omcfg) {
		this.omcfg = omcfg;
	}
}
