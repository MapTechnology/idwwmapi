package ms.coleta.servico;

import java.util.Date;
import java.util.Map;

import org.hibernate.Session;

import idw.model.IdwFacade;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
import idw.model.pojos.template.MsIcTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoFimCiclo implements IServico, IProtocoloNovo {
	
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		EventoColetado ev = mensagem.getEventoColetado();
		
		MsEvt msevt = null;
		
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		String cdUp = "desc";
		if (ev.getIcUpDTO() != null && ev.getIcUpDTO().getUpDTO() != null) {
			cdUp = ev.getIcUpDTO().getUpDTO().getCd_up();
		} else if (ev.getIdUpPdba() != null){
			cdUp = ev.getIdUpPdba();
		}
		IdwLogger log = null;
		if (ev.getIdUpPdba() != null){
			log = new IdwLogger(ev.getIdUpPdba());
		} else {
			log = new IdwLogger(cdUp);
		}

		ev.setLog(log);

		log.iniciaAvaliacao("Servico FIM CICLO " + mensagem.getEventoColetado().getIdUpPdba());

		log.info("Servico FIM CICLO - INI em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + " - " + Stubedelegate.getInstancia().getContador() + " para " + cdUp);
		
		Date inicio2 = DataHoraRN.getDataHoraAtual();
		Stubedelegate.getInstancia().addContador();
		
		// O objetivo do if abaixo eh evitar que se entre no codigo se o idw nao estiver ativo
		if ( IdwFacade.getInstancia().isIDWAtivo() == true) {
	 		/*
	 		 * O techo abaixo entrou em substituicao ao trecho acima, conforme comentarioa acima em 01-02-13
	 		 */
			// Chama web-service de inicio de ciclo
			log.iniciaAvaliacao(idLog, "Chamando Stubedelegate.getInstancia().finalCiclo()");
			
			UpRN upRN = new UpRN();
			
			try {
				upRN.iniciaConexaoBanco(sessao);
				
				/*
				 * 
				 */
				MsUp msup = upRN.pesquisarMsUpPorCdUpStAtivo(cdUp);
				boolean isFinalizarCiclo = true;
				if (msup != null && msup.getSequencial() != null && msup.getSequencial() > 0){
					if (msup.getSequencial().equals(ev.getSequencial())){
						isFinalizarCiclo = false;
						log.info(idLog, 0, "O Fim do ciclo do sequencial " + msup.getSequencial() + " ja existe");
					} else {
						log.info(idLog, 0, "O sequencial em msUp = " + msup.getSequencial() + ". Inserindo final de ciclo");
					}
				}

				
				if (isFinalizarCiclo) {
					log.info(idLog, 0, "...........inicouConexaoBanco");
					Date inicio = DataHoraRN.getDataHoraAtual();
					log.info(idLog, 0, "...........pegouDtHrAtual");
					msevt = upRN.finalCiclo(idLog, identacao, ev);
					log.info(idLog, 0, "...........upRN.finalCiclo " + DataHoraRN.getQuantidadeMilisegundosNoPeriodo(inicio, DataHoraRN.getDataHoraAtual()));
				}
			} catch (Exception e){
				log.info("Ocorreu excessao abaixo", e);
				e.printStackTrace();
				log.paraAvaliacao();
				throw new ServicoFalhouException(e);
			} finally {
				// FInaliza aqui a sessao apenas se nao tiver sido passada
				if (sessao == null) {
					log.iniciaAvaliacao("finalizaConexaoBanco");
					log.info(idLog, 0, "...........finalizaConexaoBanco");
					inicio2 = DataHoraRN.getDataHoraAtual();
					upRN.finalizaConexaoBanco(log);
					log.info(idLog, 0, "...........fechatransacao " + DataHoraRN.getQuantidadeMilisegundosNoPeriodo(inicio2, DataHoraRN.getDataHoraAtual()));
					log.paraAvaliacao();
					log.info(idLog, identacao, log.getAvaliacaoCompleta());
				}
			}
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
	
			inicio2 = DataHoraRN.getDataHoraAtual();
			
			
			mensagem.getDadosIcDTO().setaDataHoraInicioCicloUP(ev.getIcUpDTO().getIdIcUp(), ev.getDthrEvento());
		}
		
		// Seta true para Up trabalhando
		ev.getIcUpDTO().getUpDTO().setUpTrabalhando(true);
		log.info(idLog, 0, "Maquina parada = " + ev.getIcUpDTO().getUpDTO().isUpParada());
 		
 		
 		// Se o tipo do IC for 3 (sem thread ativada, entao a parada automatica deverá ser vista pelo proprio IHM)
 		if (ev.getIcUpDTO().getIc().getTp_ic() != MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue()) {
			// Define o inicio ou final do ciclo no MsUpDTO para fins de deteccao da parada automatica		
			ev.getIcUpDTO().getUpDTO().setLog(log);
 		}
 		
 		log.info(idLog, 0, "ANDOND? " + mensagem.getDadosIcDTO().getStAndonConfiguravelAtivo());
 		
		if(mensagem.getDadosIcDTO().getStAndonConfiguravelAtivo()) {
			//Criando o evento de andon e a respectiva mensagem para que o serviço posssa ser chamado corretamente.
			EventoColetado eventoColetado = new EventoColetado();
			//número do serviço de andon é 4 para que o serviço seja buscado corretamente na lista se serviços disponíveis
			eventoColetado.setTipoEvento(4);
			eventoColetado.setIcUpDTO(ev.getIcUpDTO());
			MensagemRecebida mensagemAndon = new MensagemRecebida(eventoColetado);
			mensagemAndon.setDadosIcDTO(mensagem.getDadosIcDTO());
			mensagemAndon.setLog(mensagem.getLog());
			
			mensagemAndon.setIc(mensagem.getIc());
			try {
				log.info(idLog, 9, "INICIO - Chamando serviço para mensagem " + mensagemAndon.getDescricaoServico() + " em " + DataHoraRN.getDataHoraAtualFormatada());
				ServicoFactory.getInstancia().executaServico(sessao, mensagemAndon);
				log.info(idLog, 9, "FIM - Serviço para mensagem " + mensagemAndon.getDescricaoServico() + " finalizou em " + DataHoraRN.getDataHoraAtualFormatada());
			} catch (ServicoFalhouException e) {
				// TODO Aqui devemos salvar o evento pendente e ficar tentando
				log.info(idLog, 9, "Salvando evento pois o mesmo nao foi processado NAO está implementado.");
			}
		}
		
		// Envia informação para os clientes registrados que querem receber
		// informacoes
		// sobre o ciclo
		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);

		log.info(idLog, 9, "Mandando CICLO para clientes REGISTRADOS");
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);
		
		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, 0, "Servico FIM CICLO - FIM em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + log.getAvaliacaoCompleta());
		//System.out.println("...........trecho final do ciclo " + DataHoraRN.getQuantidadeMilisegundosNoPeriodo(inicio2, DataHoraRN.getDataHoraAtual()));
		
		
		return msevt;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setQtde(evtArgs.get("1"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
