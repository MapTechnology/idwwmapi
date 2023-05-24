package ms.coleta.servico;

import java.math.BigDecimal;
import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.rn.consolidacao.refugo.ConsolidacaoRefugoRN;
import idw.model.rn.numeroserie.ValidaNumeroSerieRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.EventoRN;

public class ServicoValidaRefugoInovaSA implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {

		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		int isValido=0;
		boolean isValidoRefugo = false;
		
		log.iniciaAvaliacao(idLog, "Chamando ServicoValidaRefugoInovaSA");
		log.info("Servico VALIDA REFUGO INOVASA - INI");

		ConsolidacaoRefugoRN refRN = new ConsolidacaoRefugoRN();
		refRN.iniciaConexaoBanco();
		ValidaNumeroSerieRN rn = new ValidaNumeroSerieRN(refRN.getDao());
		MsEvt msevt = null;
		EventoColetado ev = mensagem.getEventoColetado();
		try {
			log.info(idLog, identacao,"ServicoValidaNumeroDeSerie:"+mensagem.getMensagemRecebidaTcp());
			isValido=rn.validaNumeroSerie(ev.getUp(),ev.getCdop(),ev.getNumeroSerie(),ev.getCdproduto(), mensagem);
			// Se isValido for igual a 4 (solicita a qtde) analisar se o CB passado tem algum evento de producao para a OP + CB
			// Se nao tiver, entao o NS eh invalido
			// isValido pode ser = 0 para fail, 1 para sucesso, 2 para sucesso sem contar ciclo e 3 - para falha NC 4 - pedir Qtde
			if(isValido != 4) {
				EventoRN evRN = new EventoRN();
				evRN.setDao(refRN.getDao());
				msevt = evRN.pesquisarMsEvtByCBeUP(ev.getNumeroSerie(), new BigDecimal(ev.getIcUpDTO().getIdIcUp()), ev.getCdop());
			
				if (msevt == null) {
					isValido = 0;
				}
			}
		} catch (Exception e){
			log.info(idLog, identacao,"Erro ao validar o Numero de Serie: ", e);
		}
	
		// Se 2 - ok sem contar ciclo ou 3 - nc ou 4-pedir qtde validar refugo
		if(isValido >= 2){
			try {
				log.info(idLog, identacao,"ServicoValidaRefugoInovaSA:"+mensagem.getMensagemRecebidaTcp());
				isValidoRefugo=refRN.validaRefugoInovaSA(ev.getNumeroSerie(),  4L);
				/* Alessandre em 22-01-16 comentei o trecho abaixo para o Chile pois eles desejam refugar independente da hora
				if (isValidoRefugo == true) {
					PTRN prn = new PTRN(refRN.getDao());
					OmPt ompt = prn.getOmPt(mensagem.getUp());
					TurnoRN trn = new TurnoRN(refRN.getDao());
					TurnoAtualDTO turnoAtual = trn.getTurnoAtualDTOSemClone(ompt, DataHoraRN.getDataHoraAtual());
					Date inicio = DataHoraRN.getDataHoraAtual(); // Pode ser o inicio da hora atual ou inicio do turno
					inicio = DataHoraRN.getDataHoraInicial(inicio);
					Date fim = DataHoraRN.getDataHoraAtual(); // Fim da hora atual ou fim do turno
					fim = DataHoraRN.getDataHoraFinal(fim);
					if (inicio.before(turnoAtual.getDtHrITurno()))
						inicio = turnoAtual.getDtHrITurno();
					if (fim.after(turnoAtual.getDtHrFTurno()))
						fim = turnoAtual.getDtHrFTurno();
					
					isValidoRefugo = DataHoraRN.isIntersecao(msevt.getDthrEvento(), inicio, fim);
					
				} */
			} catch (Exception e){
				log.info(idLog, identacao,"Erro ao validar o Refugo do InvaSA:", e);
				e.printStackTrace();
			}
		}
		refRN.finalizaConexaoBanco();
		
		MensagemEnviada m = new MensagemEnviada(mensagem);
		m.setRefugoValido(isValidoRefugo);
		m.setNsvalido(isValido);
		
		log.info(idLog, identacao, "ServicoValidaRefugoInovaSA para " + mensagem.getIp() );
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);

		log.paraAvaliacao();
		log.info(idLog, identacao, "Servico VALIDA REFUGO INOVASA - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCb(evtArgs.get("1"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		int retorno = 0;

		if(mensagem.getNSValido() == 5) {
			retorno = 3;//REF_FAIL_JA_REFUGADO
		} else {
			if(mensagem.isRefugoValido()==true){
				if(mensagem.getNSValido() == 4){
					retorno = 2;//REF_PEDE_QTD
				}
				else {
					retorno = 0;//REF_OK
				}
			} else{
				retorno = 1;//REF_FAIL
			}
		}
		return "[resp]\nst="+retorno+"\n";
	}

}
