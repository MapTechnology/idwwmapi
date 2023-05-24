package idw.model.rn.insert;

import org.hibernate.HibernateException;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.EventoDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class EventoInsertParaMsEvtRN extends AbstractRN<DAOGenerico>{

	public EventoInsertParaMsEvtRN(){
		this(new DAOGenerico());
	}
	
	public EventoInsertParaMsEvtRN(DAOGenerico dao) {
		super(dao);
	}

	// Trata o evento vindo via webservice da ColetaFuji ou ColetaPt200
	public void trataEvento(EventoDTO eventoDTO) throws IllegalArgumentException, HibernateException {
		IdwLogger log = null;
		if (eventoDTO == null)
			return;

		try {
			log = new IdwLogger("TrataEventoRN-" + eventoDTO.getMaquina());
		} catch (NullPointerException e) {
			e.printStackTrace();
			return;
		}
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		log.iniciaAvaliacao("TrataEventoRN");
		log.info(idLog, identacao, "Iniciando TrataEventoRN");

		log.info(idLog, identacao, "@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@");

		log.info(idLog, identacao, "Estou no Evento RN:");
		log.info(idLog, identacao, "Linha: " + eventoDTO.getLinha());
		log.info(idLog, identacao, "Maquina: " + eventoDTO.getMaquina());
		log.info(idLog, identacao, "Data: " + eventoDTO.getData());
		log.info(idLog, identacao, "Codigo: " + eventoDTO.getCodigo());
		log.info(idLog, identacao, "Programa: " + eventoDTO.getPrograma());
		log.info(idLog, identacao, "Produto: " + eventoDTO.getProduto());
		log.info(idLog, identacao, "Estagio: " + eventoDTO.getEstagioEvento());
		log.info(idLog, identacao, "Origem: " + eventoDTO.getOrigem());
		log.info(idLog, identacao, "Tipo Evento:  " + eventoDTO.getTipoEvento());
		log.info(idLog, identacao, "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

		iniciaConexaoBanco();
		try {
			tratarEvento(log, idLog, identacao, eventoDTO); //bug
 		} catch (Exception e) {
 			log.info(idLog, 0, "Excessao", e);
			e.printStackTrace();
		} finally {
			finalizaConexaoBanco();
		}

		log.info(idLog, 0, log.getAvaliacaoCompleta());
	}

	private void tratarEvento(IdwLogger log, int idLog, int identacao, EventoDTO eventoDTO) {
		log.info(idLog, identacao, "inicio tratarEvento");

		// Encontra o cdUp a partir do evento
		String cdUp = null;
		boolean evtParada = false;
		
		cdUp = eventoDTO.getMaquina();

		IcUpDTO icup = Stubedelegate.getInstancia().getMsthread().getIcUp(cdUp);
		// Se upDTO n�o existir entao gerar um log avisando da necessidade de
		// cadastrar a UP no MS que esta rodando
		if (icup != null && icup.getUpDTO() != null) {

			cdUp = icup.getUpDTO().getCd_up();

			// Verifica se o evento eh do estagio esperado pelo PT, se
			// nao for descartar o evento
			OmPt ompt = null;
			ompt = IdwFacade.getInstancia().pesquisarOmPtAPartiCdPt(cdUp);

			if (ompt == null) {
				log.info(idLog, identacao, "OmPt para o depara desconhecido " + cdUp);
				return;
			}
			if(eventoDTO.isInicioParada() || eventoDTO.isFimParada()){
				if(eventoDTO.getParadaDTO() != null){
					if(eventoDTO.getParadaDTO().getCodigoParada().contains("140000") || eventoDTO.getParadaDTO().getCodigoParada().contains("140001")){
						eventoDTO.setEstagioEvento(ompt.getEstagio().toString());
					}
				}
				evtParada = true;				
			}
			
			int tipoevento = obtemTipoServicoAPartirDoEvento(eventoDTO);
			
			// Alessandre em 22-11-19 a perda de componente tambem nao deve considerar estagio
			if (evtParada == false && tipoevento != ServicoFactory._ERRO_INSERSORA) { //Marcus: em 07/11/13, condi��oo para n�o considerar o estágio para eventos de parada
				if (ompt.getEstagio() == null || ompt.getEstagio() != eventoDTO.getEstagio()) {
					log.info(idLog, identacao, "Evento NAO EH do estagio esperado " + eventoDTO);
					return;
				}
			}

			// Preparar a chamada do servico conforme o evento que tenha chegado
			// O servico irá cadastrar em MsEvt, cuidar para que o serviço n�o
			// cadastro em PrCOletorEventos
			// Inicializa evento
			EventoColetado evento = new EventoColetado();
			evento.setDthrEvento(eventoDTO.getDataComoData());
			evento.setTipoEvento(tipoevento);
			evento.setIdUpPdba(cdUp);
			evento.setChamarInjetWs(false);
			evento.setIcUpDTO(icup);
			evento.setLog(log);
			evento.setIdLog(idLog);
			evento.setIdentacao(0);
			evento.setCdop(eventoDTO.getPrograma());
			evento.setSequencial(eventoDTO.getSequencial());
			evento.setOrigem(eventoDTO.getOrigem());
			evento.setIsCbConforme(false);
			if(eventoDTO.getQuantidade()!= null && !eventoDTO.getQuantidade().equals("0")) 
			{
				evento.setQtde(eventoDTO.getQuantidade());
			}
			
			if(eventoDTO.getErroDTO() != null){
				evento.setErroInsersora(eventoDTO.getErroDTO());
			}
			
			//Passa o codigo de parada para tratar oe vento
			if (eventoDTO.isInicioParada()  ){
				if (eventoDTO.getParadaDTO() != null && eventoDTO.getParadaDTO().getCodigoParada() != null && eventoDTO.getParadaDTO().getCodigoParada().trim().equals("") == false){
					evento.setCdparada(eventoDTO.getParadaDTO().getCodigoParada());
				}
			}
			//ph: Inserindo informa��oo do Feeder e do Nozzle
			evento.setFeeders(eventoDTO.getFeeders());
			evento.setNozzles(eventoDTO.getNozzles());
			
			
			
			// Eh necessario que IcUp tenha valor dentro do evento e dentro de
			// IcUp,
			// a Up deve ter valor

			
			
			// Se o evento for de troca de programa entao avaliar se a configuracao do sistema permite alterar o programa apenas pelo IHM ou via coleta
			if (evento.getTipoEvento() == ServicoFactory._TROCA_PROGRAMA) {
				OmCfg omcfg = Util.getConfigGeral(getDaoSession());
				boolean isIhmtrocaop = false;
				if (ompt.getOmTppt() != null && ompt.getOmTppt().getIsIhmtrocaop() != null) {
					isIhmtrocaop = ompt.getOmTppt().getIsIhmtrocaop();
				} else if (omcfg.getIsIhmtrocaop() != null)
					isIhmtrocaop = omcfg.getIsIhmtrocaop();
				
				evento.setEventoApenasInformativo(isIhmtrocaop);

			}
			
			
			
			// Inicializa MensagemRecebida
			MensagemRecebida mensagem = new MensagemRecebida(evento);
			mensagem.setLog(evento.getLog());
			mensagem.setIdLog(evento.getIdLog());
			mensagem.setIdentacao(evento.getIdentacao());
			mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByIdUpPdba(cdUp));

			// Chama o servico de alerta
			try {
				// Se for um evento nao tratado gerar um log e continuar em
				// outro ponto
				if (evento.getTipoEvento() == -1) {
					log.info(idLog, identacao, "Tipo de evento desconhecido = " + eventoDTO.getTipoEvento());
				} else {
					log.info(
							idLog,
							identacao,
							"TIPO Evento recebido = "
									+ eventoDTO.getTipoEvento()
									+ ", evento a ser executado = "
									+ evento.getTipoEvento());
					ServicoFactory.getInstancia().executaServico(null, mensagem);
				}
			} catch (ServicoFalhouException e) {
				e.printStackTrace();
				log.info(idLog, 0, "Excessao", e);
			}
		} else {
			// Nao existe o icDTO.getUpdTO
			log.info(idLog, identacao, "Nao encotrou icup ou updto para " + eventoDTO.getMaquina());
		}
		log.info(idLog, 0, "fim do tratarEvento");
	}

	/*
	 * Metodo responsavel em converter o tipo do Evento no tipo do Servico
	 */
	private int obtemTipoServicoAPartirDoEvento(EventoDTO evento) {
		int retorno = -1;
		switch (evento.getTipoEvento()) {
		case EventoDTO._EVENTO_INICIO_PARADA:
			retorno = ServicoFactory._INICIO_PARADA;
			break;
		case EventoDTO._EVENTO_FIM_PARADA:
			retorno = ServicoFactory._FIM_PARADA;
			break;
		case EventoDTO._EVENTO_INICIO_CICLO:
			retorno = ServicoFactory._INICIO_CICLO;
			break;
		case EventoDTO._EVENTO_FIM_CICLO:
			retorno = ServicoFactory._FIM_CICLO;
			break;
		case EventoDTO._EVENTO_TROCA_PROGRAMA:
			retorno = ServicoFactory._TROCA_PROGRAMA;
			break;
		case EventoDTO._EVENTO_USO_FEEDER:
			retorno = ServicoFactory._USO_RAP;
			break;
		case EventoDTO._EVENTO_USO_NOZZLE:
			retorno = ServicoFactory._USO_RAP;
			break;
		case EventoDTO._EVENTO_ERRO:
			retorno = ServicoFactory._ERRO_INSERSORA;
			break;
		}
		return retorno;
	}
}
