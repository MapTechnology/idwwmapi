package ms.coleta.servico;

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

public class ServicoValidaNumeroDeSerie implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		int tpRetorno=0; // 0 = invalido 1=valido 2=valido mas ja foi passado 3=Roteiro inconsistente
		boolean isNaoFoiRefugado = true;

		log.iniciaAvaliacao(idLog, "Chamando ServicoValidaNumeroDeSerie");
		log.info("Servico VALIDA NUMERO DE SERIE - INI");

		ConsolidacaoRefugoRN refRN = new ConsolidacaoRefugoRN();
		EventoColetado ev = mensagem.getEventoColetado();
		try {
			log.info(idLog, identacao,"ServicoValidaRefugoInovaSA:"+mensagem.getMensagemRecebidaTcp());
			refRN.iniciaConexaoBanco();
			
			isNaoFoiRefugado =refRN.validaRefugoInovaSA(ev.getNumeroSerie(),  4L); // 4 eh o codigo do estoque REFUGO. O correto eh obter esse valor em omcfg
		} catch (Exception e){
			log.info(idLog, identacao,"Erro ao validar o Refugo do InvaSA:", e);
			e.printStackTrace();
		}

		// Se o NS não estiver refugado entao verificar se eh um NS valido
		if(isNaoFoiRefugado ){		
			ValidaNumeroSerieRN rn = new ValidaNumeroSerieRN(refRN.getDao());
			try {
				log.info(idLog, identacao,"ServicoValidaNumeroDeSerie:"+mensagem.getMensagemRecebidaTcp());
				tpRetorno=rn.validaNumeroSerie(ev.getUp(),ev.getCdop(),ev.getNumeroSerie(),ev.getCdproduto() , mensagem );
			} catch (Exception e){
				log.info(idLog, identacao,"Erro ao validar o Numero de Serie: ", e);
			}
		} else
			tpRetorno = 5; // Perguntar se deseja cancelar o refugo

		refRN.finalizaConexaoBanco();

		MensagemEnviada m = new MensagemEnviada(mensagem);
		m.setNsvalido(tpRetorno);
		
		log.info(idLog, identacao, "ServicoValidaNumeroDeSerie retorno para " + mensagem.getIp() );
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);

		log.paraAvaliacao();
		log.info(idLog, identacao, "Servico VALIDA NUMERO DE SERIE - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCb(evtArgs.get("1"));
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=" + mensagem.getNSValido() + "\n";
	}
}
