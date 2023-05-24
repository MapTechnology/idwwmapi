package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
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

public class ServicoInicioCiclo implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();

		Stubedelegate.getInstancia().addContador();
		
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		
		String cdUp = "desc";

		if (ev.getIcUpDTO() != null && ev.getIcUpDTO().getUpDTO() != null) {
			cdUp = ev.getIcUpDTO().getUpDTO().getCd_up();
		} else if (ev.getIdUpPdba() != null) {
			log.info(idLog, identacao, "Alerta 1 - up esta nulo");
			cdUp = ev.getIdUpPdba();
		}

		log.iniciaAvaliacao(idLog, "Servico Ciclo inicio para " + cdUp);
		log.info(idLog, identacao, "Servico INICIO CICLO - INI em " + ev.getDthrEventoFormatadoParaEnvio() + " - " + Stubedelegate.getInstancia().getContador() + " para " + cdUp);

		UpRN upRN = new UpRN();
		PTRN ptRN = new PTRN();
		MsEvt retorno = null;
		
		try {
			upRN.iniciaConexaoBanco(sessao);
			ptRN.setDao(upRN.getDaoPdba());
			
			// O servico de inicio de ciclo ira gerar um ciclo apenas para o 1o ciclo da ordem de producao
			boolean isLancarCiclo = false;
			
			// Se o evento de inicio de ciclo estiver nulo, entao lancar o ciclo
			MsUp msup = upRN.pesquisarMsUpPorCdUpStAtivo(cdUp);
			
			isLancarCiclo = !(msup != null && msup.getMsEvtByIdEvtiniciociclo() != null);
			
			// Se for máquina ciclica, SEMPRE lancar o inicio de ciclo
			OmPt ompt = ptRN.pesquisarPtByCdPtStAtivo(cdUp);
			if (ompt != null && ompt.getOmTppt().isMaquinaCiclica())
				isLancarCiclo = true;
			
			// Agora verifica se o sequencial de msup esta definido. Se estiver verificar se eh diferente do sequencial do evento
			// se for, entao lancar um final de ciclo, se nao seguir em frente sem fazer nada. Esse trecho serve para
			// o PRODSTART sem um PRODEND na coleta da fuji. Para as demais coletas nao tera nenhum impacto pois o valor estara null
			if (msup.getSequencial() != null && msup.getSequencial() > 0){
				if (msup.getSequencial() != ev.getSequencial()){
					retorno = upRN.finalCiclo(idLog, identacao, ev);
				}
			}

			// o inicio de ciclo deve ser lancado (se for lancado) somente apos o lancamento do final de ciclo
			if (isLancarCiclo == true)
				retorno = upRN.inicioCiclo(idLog, identacao, ev);

			// Altera a sequencia para determinar qual ciclo esta sendo processado
			/* Alessandre em 27-01-16 comentei as duas linhas abaixo para nao setar o sequencial da placa, pois teve um caso na palladium
			 * onde o sequencial foi setado e depois veio um final de ciclo que nao foi processado pois o sequencia havia sido setado.
			msup.setSequencial(ev.getSequencial());
			upRN.getDaoPdba().makePersistent(msup);
			 */
		} catch (Exception e) {
			log.info(idLog, 0, "Ocorreu excessao abaixo", e);
			e.printStackTrace();
			throw new ServicoFalhouException(e);
		} finally {
			log.mostrarAvaliacaoCompleta();
			upRN.finalizaConexaoBanco(log);
		}


		// Salvar data e hora do início de ciclo
		mensagem.getDadosIcDTO().setaDataHoraInicioCicloUP(ev.getIcUpDTO().getIdIcUp(), ev.getDthrEvento());

		// Seta true para Up trabalhando
		ev.getIcUpDTO().getUpDTO().setUpTrabalhando(true);

		MensagemEnviada m = new MensagemEnviada(mensagem);
		
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		
		log.info(idLog, 0, "Servico INICIO CICLO - FIM em " + ev.getDthrEventoFormatadoParaEnvio());
		
		return retorno;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
}
