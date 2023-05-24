package ms.coleta.tcp;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inovastandalone.DadosLocaisCCK;
import ms.coleta.ic.inovastandalone.ProcessaLinhaEvento;
import ms.coleta.ic.inovastandalone.VerificaCCK;
import ms.coleta.protocolo.ProtocoloEntradaFactory;
import ms.coleta.servico.ServicoFactory;
import ms.coleta.tcp.ServidorTcp.TipoProtocoloTCP;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;

public class RecebeDadosPorta{

	private IdwLogger log;
	private MensagemRecebida mensagemRecebida;
	private String ip;
	private IcDTO msicdto;
	
	public RecebeDadosPorta(String ip, MensagemRecebida mensagemRecebida, IdwLogger log, IcDTO dadosicDTO) {
		this.log = log;
		this.mensagemRecebida = mensagemRecebida;
		this.ip = ip;
		this.msicdto = dadosicDTO;
	}
	
	public void processaMensagem() {
		MensagemRecebida men = this.mensagemRecebida;
		men.setLog(this.log);
		
		men.setIp(this.ip);
		log.info("Tratando mensagem " + men.getMensagemRecebidaTcp().replaceAll("\n", ""));
		try {
			log.info("Chamando servico para mensagem " + men.getDescricaoServico() + " em " + DataHoraRN.getDataHoraAtualFormatada());
			log.iniciaAvaliacao("Servico " + men.getDescricaoServico());
			//se o servico da mensagem for um evento, deve-se montar o objeto do tipo EventoColetado interno
			//do objeto MensagemRecebida.
			if(msicdto != null && (
					men.getServico() == ServicoFactory._FIM_CICLO ||
					men.getServico() == ServicoFactory._INICIO_PARADA ||
					men.getServico() == ServicoFactory._MOTIVO_PARADA  ||
					men.getServico() == ServicoFactory._LOGIN ||
					men.getServico() == ServicoFactory._LOGOUT ||
					men.getServico() == ServicoFactory._INICIA_ALERTA ||
					men.getServico() == ServicoFactory._REMOVE_ALERTA ||
					men.getServico() == ServicoFactory._APAGAULTIMOREFUGO ||
					men.getServico() == ServicoFactory._NOVOREFUGO ||
					men.getServico() == ServicoFactory._IC_HEART_BEAT ||
					men.getServico() == ServicoFactory._NOVA_OP ||
					men.getServico() == ServicoFactory._FINALIZA_OP ||		
					men.getServico() == ServicoFactory._INICIO_CICLO ||
					men.getServico() == ServicoFactory._FIM_PARADA ||
					men.getServico() == ServicoFactory._PASSAGEM ||
					men.getServico() == ServicoFactory._VALIDA_NUMERO_DE_SERIE ||
					men.getServico() == ServicoFactory._VALIDA_PASSAGEM ||//IGUAL _VALIDA_NUMERO_DE_SERIE
					men.getServico() == ServicoFactory._VERIFICA_REFUGO_TCP ||
					men.getServico() == ServicoFactory._VALIDA_REFUGO ||//IGUAL _VERIFICA_REFUGO_TCP
					men.getServico() == ServicoFactory._CRIA_OP_AUTOMATICA ||
					men.getServico() == ServicoFactory._CRIA_OP_AUTOMATICA_STANDALONE ||//IGUAL _CRIA_OP_AUTOMATICA
					men.getServico() == ServicoFactory._CONSULTA_GENERICA_INOVASA ||
					men.getServico() == ServicoFactory._CONSULTA_GENERICA ||
					men.getServico() == ServicoFactory._INICIAR_CIP_INOVASA ||
					men.getServico() == ServicoFactory._FINALIZAR_CIP_INOVASA ||
					men.getServico() == ServicoFactory._INICIO_VARIACAO_RITMO ||
					men.getServico() == ServicoFactory._MOTIVO_VARRITMO ||
					men.getServico() == ServicoFactory._FIM_VARIACAO_RITMO ||
					men.getServico() == ServicoFactory._CCK ||
					men.getServico() == ServicoFactory._MEDICAO_CCK ||
					men.getServico() == ServicoFactory._INOVASA_STARTUP ||
					
					men.getServico() == ServicoFactory._CONSULTA ||
					men.getServico() == ServicoFactory._INFORMA_MOTIVO_PARADA ||
					men.getServico() == ServicoFactory._INICIA_NOVA_PARADA ||
					men.getServico() == ServicoFactory._VALIDAPARADA ||
					men.getServico() == ServicoFactory._VALIDAREFUGO ||
					men.getServico() == ServicoFactory._FINALIZA_PARADA ||
					men.getServico() == ServicoFactory._REGISTRO_CLIENTES ||
					men.getServico() == ServicoFactory._IC_HEART_BEAT
					)){

				men.setDadosIcDTO(msicdto);
				men.setIc(msicdto.getInterfaceAdam());
				
				if (men.getTipoProtocoloMensagem() == TipoProtocoloTCP.PROTOCOLO_NOVO)
					log.info("Protocolo novo");
				else
					log.info("Protocolo antigo");

				men.setEventoColetado(ProtocoloEntradaFactory.getInstancia(men).criarEventoColetado());
				
				if(men.getServico() == ServicoFactory._MEDICAO_CCK || men.getServico() == ServicoFactory._CCK) {
					VerificaCCK vcck= new VerificaCCK();
					DadosLocaisCCK dadosLocaisCCK=null;
					dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(men.getEventoColetado().getIcUpDTO(), 3);
					
					if(dadosLocaisCCK!=null){
						
						boolean isVerifica = vcck.verificaLancaAlerta(log, dadosLocaisCCK, men.getEventoColetado().getDadosCCK().getConsumoAtivo().doubleValue());
						
						if(isVerifica==true){
							EventoColetado evento = new EventoColetado();
							evento.setDthrEvento(men.getEventoColetado().getDthrEvento());
							evento.setIcUpDTO(men.getEventoColetado().getIcUpDTO());
							evento.setOrigem(men.getMensagemRecebidaTcp());
							evento.setLog(log);
							evento.setParametroLido(men.getEventoColetado().getDadosCCK().getConsumoAtivo());
							evento.setTipoEvento(ServicoFactory._ALERTA_CONSUMO_ATIVO);
							MensagemRecebida mensagemAlertaConsumoAtivo = new MensagemRecebida(evento);
							RecebeDadosPorta alertaRecebeDadosPorta = new RecebeDadosPorta(ip, mensagemAlertaConsumoAtivo, log, msicdto);
							alertaRecebeDadosPorta.processaMensagem();
							//nao colocar ele no if que monta evento coletado, ele ja esta monstado
						}
					}
	
					dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(men.getEventoColetado().getIcUpDTO(), ProcessaLinhaEvento._FATOR_DE_POTENCIA);
					if(dadosLocaisCCK!=null){
						if(vcck.verificaLancaAlerta(log, dadosLocaisCCK, men.getEventoColetado().getDadosCCK().getFatorDePotencia().doubleValue())==true){
							EventoColetado evento = new EventoColetado();
							evento.setDthrEvento(men.getEventoColetado().getDthrEvento());
							evento.setIcUpDTO(men.getEventoColetado().getIcUpDTO());
							evento.setOrigem(men.getMensagemRecebidaTcp());
							evento.setLog(log);
							evento.setParametroLido(men.getEventoColetado().getDadosCCK().getFatorDePotencia());
							evento.setTipoEvento(ServicoFactory._ALERTA_FATOR_DE_POTENCIA);
							MensagemRecebida mensagemAlertaFatorDePotencia = new MensagemRecebida(evento);
							RecebeDadosPorta alertaRecebeDadosPorta = new RecebeDadosPorta(ip, mensagemAlertaFatorDePotencia, log, msicdto);
							alertaRecebeDadosPorta.processaMensagem();
						}
					}
				}
			} else {
				log.info("msdto is null para o ip: " + ip + ", logo dara erro no servico.");
			}
			
			
			
			if( men.getEventoColetado() == null //||
				//men.getEventoColetado().getIcUpDTO()==null ||
				//men.getEventoColetado().getIcUpDTO().getUpDTO()==null||
				//men.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up()==null){
				){
				log.info("Mensagem Descartada porque eventoColetado é null:"+men.getMensagemRecebidaTcp());
				throw new ServicoFalhouException(null);
			} else if(men.getEventoColetado().getIcUpDTO()==null){
				log.info("Mensagem Descartada porque o IcUpDTO esta vazio " + men.getMensagemRecebidaTcp());
				throw new ServicoFalhouException(null);
			} else if(men.getEventoColetado().getIcUpDTO().getUpDTO()==null){
				log.info("Mensagem Descartada porque o UpDTO esta vazio " + men.getMensagemRecebidaTcp());
				throw new ServicoFalhouException(null);
			} else if(men.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up()==null){
				log.info("Mensagem Descartada porque o Cd_up esta vazio " + men.getMensagemRecebidaTcp());
				throw new ServicoFalhouException(null);
			}else{
				if (Stubdelegate.getInstancia().isInjetAtivo() == true){
					men.getEventoColetado().setChamarInjetWs(true);
				}

				ServicoFactory.getInstancia().executaServico(null, men);
				//SENOJ: adicionar wake do IETHread utilizar chamada IcUpDTO
				log.info("Servico para mensagem " + men.getDescricaoServico() + " finalizou em " + DataHoraRN.getDataHoraAtualFormatada());
			
				// Alessandre em 24-7-14 removi o save do evento
				//log.salvarEventoColetado(men.getEventoColetado());
			}
		} catch (ServicoFalhouException e) {
			// TODO Aqui devemos salvar o evento pendente e ficar tentando
			log.info("Salvando evento pois o mesmo nao foi processado", e);
			retornaMsgIhmSolicitante(men);
		} catch (Exception e){
			e.printStackTrace();
			log.info("Mensagem nao foi processada com sucesso, devido excessao abaixo ", e);
			retornaMsgIhmSolicitante(men);
		} finally {
			log.paraAvaliacao();
			log.info("Tratando mensagem FIM - " + men.getMensagemRecebidaTcp().replaceAll("\n", "") + "\n" + log.getAvaliacaoCompleta()+ "\n");
		}
	}
	
	private void retornaMsgIhmSolicitante(MensagemRecebida men){
		MensagemEnviada m = new MensagemEnviada(men);
		m.setServicoFalhou(true);
		m.setIhmDesconhecido(true);
		Stubedelegate.getInstancia().enviaMensagemParaClientesDesconhecido(m);
	}
	
	public void processaMensagem(javax.websocket.Session session) {
		MensagemRecebida men = this.mensagemRecebida;
		men.setSessaows(session);
		processaMensagem();
	}

	
}
