package ms.coleta.servico;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.MsPtColeta;
import idw.model.pojos.OmPt;
import idw.model.rn.PTRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoMotivoParada implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = log.getIdAleatorio();
		int identacao = mensagem.getIdentacao();
		mensagem.setIdLog(idLog);
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		ev.setIdLog(idLog);

		log.iniciaAvaliacao(idLog, "Servico MOTIVO PARADA " + mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());
		log.info(idLog, 0, "Servico MOTIVO PARADA INI " + ev.getCdparada());

		UpRN upRN = new UpRN();
		MsEvt msevt;
		try {
			upRN.iniciaConexaoBanco();
			
			msevt = upRN.corrigeParada(ev);
			if (msevt == null) {
				log.info(idLog, 0, "Nao lancou parada");
			}
			
			
			
			
			// Verificar se o PT aponta paradas para o grupo de trabalho, se sim o motivo de parada apontado deve refletir tb nos outros pts que estiverem PARADOS
			PTRN ptrn = new PTRN(upRN.getDaoPdba());

			OmPt omPt = ptrn.getOmPt(mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());
			
			if (omPt.getIsAponparadagt() != null && omPt.getIsAponparadagt() == true) {
				// Obtem a lista dos outros PTs do Gt atualmente paraddos
				List<OmPt> listapts = ptrn.pesquisarPtComColetaByGt(omPt.getOmGt(), omPt);
				for (OmPt ompt : listapts) {
					// Se for o mesmo PT nao precisa fazer de novo
					if (ompt.equals(omPt))
						continue;
					
					// Verifica se est� parada no momento.
					MsPtColeta msptcoleta = ompt.getMsPtColeta();
					
					if (msptcoleta.getDthrIparada() != null && msptcoleta.getDthrFparada() == null) {
						// Insere um msevt para corrigir a parada do pt
						EventoColetado evPt = new EventoColetado(ev);
						
						evPt.setCdop(ompt.getMsPtColeta().getNrop());
						evPt.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(ompt.getCdPt()));
						
						upRN.corrigeParada(evPt);
					}
				}
			}


			
			
			
			
			
			
		} catch (Exception e){
			log.info(idLog, 0, "Ocorreu excessao abaixo", e);
			e.printStackTrace();
			msevt = null;
		} finally {
			upRN.finalizaConexaoBanco(log);
		}

		// Alessandre em 11-12-13 comentei o envio do cliente pois ele serve apenas para qdo houver mais de um IHM
		// * alem disso ele deve ser revisto para usar a mesma tecnoclogia de thread do outro metodo de envio de mensagem
		
		// Envia informa��o para os clientes registrados que querem receber
		// informacoes
		// sobre o ciclo
		

		// Salva c�digo de parada enviado pelo IHM para ser processado pelas regras de neg�cio do Andon Configur�vel
		//mensagem.getDadosIcDTO().setCdParadaUP(mensagem.getDadosIcDTO().getIdIc(), mensagem.getCdParadaIhm());
		// Envia para clientes registrados
		
		
		log.info("Mandando MOTIVO PARADA para clientes REGISTRADOS");
		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);
		
		//Stubedelegate.getInstancia().enviaMensagemParaClientesRegistradosComExcessaoDaOrigem(mensagemEnviada);
		//Stubedelegate.getInstancia().enviaMensagemParaClientesRegistrados(idLog , 9 , mensagemEnviada);
		 
		log.paraAvaliacao();
		log.info("Servico MOTIVO PARADA - FIM - " + log.getAvaliacaoCompleta());
		
		return msevt;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCdparada(evtArgs.get("1"));
		retorno.setCdcausa(evtArgs.get("2"));
		retorno.setCdacao(evtArgs.get("3"));
		retorno.setCdjustificativa(evtArgs.get("4"));
		retorno.setCdtec1(evtArgs.get("5"));
		retorno.setCdtec2(evtArgs.get("6"));
		retorno.setCdtecResponsavel(evtArgs.get("7"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
