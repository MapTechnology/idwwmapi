package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.rn.PTRN;
import idw.util.IdwLogger;
import idw.util.Util;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoTrocaPrograma implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();

		String cdUp = "desc";

		if (mensagem.getEventoColetado().getIcUpDTO() != null && mensagem.getEventoColetado().getIcUpDTO().getUpDTO() != null) {
			cdUp = mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up();
		} else if (mensagem.getEventoColetado().getIdUpPdba() != null) {
			log.info(idLog, identacao, "Alerta 1 - up esta nulo");
			cdUp = mensagem.getEventoColetado().getIdUpPdba();
		}

		log.iniciaAvaliacao(idLog, "Servico TROCA DE PROGRAMA para " + cdUp);
		log.info(idLog, identacao, "INICIO - Servi�o TROCA DE PROGRAMA em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + " - " + Stubedelegate.getInstancia().getContador());

		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);

		// Observacao: Nesse servico nao se deve bloquear a troca do programa (OP) pois sera usada pelo IHM. Ou seja, as trocas de programas que
		// vierem pela ColetaInsersora deve ser bloqueada na RN chamadada pelo WebService
		
		UpRN upRN = new UpRN();
		try {
			upRN.iniciaConexaoBanco(sessao, log, idLog, identacao);
			log.iniciaAvaliacao(idLog, "pesquisarMsUpPorCdUpStAtivo " + cdUp);
			log.info(idLog, identacao, "pesquisarMsUpPorCdUpStAtivo " + cdUp);
			MsUp msup = upRN.pesquisarMsUpPorCdUpStAtivo(cdUp);
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
			
			OmCfg omcfg = Util.getConfigGeral(upRN.getDaoPdba().getSession());
			
			if (msup != null ) {
				
				// Independe se vai atualizar a OP como sendo o programa da SMD, sempre iremos salvar qual o programa atual
				// da maquina. Sera usada como referencia
				msup.setNomePrograma(ev.getCdop());
				
				// Se for necessario atualizar a referencia a OP
				if (msup.getNrop() == null || (msup.getNrop().equals(ev.getCdop()) == false && ev.getCdop().contains("COPY") == false)) { // o COPY eh para descartar as copias feitas no programa
					/* Verificar se o PT troca ou nao a OP */
					PTRN prn = new PTRN(upRN.getDaoPdba());
					OmPt ompt = prn.getOmPt(msup.getCdUp());
					
					boolean isIhmTrocaOP = !(omcfg.getIsIhmtrocaop() == null) || (omcfg.getIsIhmtrocaop() != null && omcfg.getIsIhmtrocaop() );
					
					if (ompt != null && ompt.getOmTppt() != null && ompt.getOmTppt().getIsIhmtrocaop() != null)
						isIhmTrocaOP = ompt.getOmTppt().getIsIhmtrocaop();
					
					
					// Se o ihm nao trocar a op entao devemos assumir a no op a partir da troca do programa
					if (isIhmTrocaOP == false) {
						
						log.info(idLog, identacao, "Programa MUDOU de " + msup.getNrop() + " para " + ev.getCdop());
						msup.setNrop(ev.getCdop());
						// Alessandre comentei a linha abaixo em 2-2-14 pois a limpeza do ciclo gera periodos sem coleta
						//msup.setMsEvtByIdEvtiniciociclo(null);
						//msup.setMsEvtByIdEvtinicioparada(null);
						
					}
					upRN.getDaoPdba().makePersistent(msup);
				}
			} else {
				log.info(idLog, identacao, "Programa n�o mudou");
			}
		} catch (Exception e) {
			log.info("Ocorreu excessao abaixo", e);
		} finally {
			log.iniciaAvaliacao("finalizaConexaoBanco");
			upRN.finalizaConexaoBanco(log);
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
		}

		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, 0, "FIM - Troca de programa em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + log.getAvaliacaoCompleta());
		
		return null;
	}
}
