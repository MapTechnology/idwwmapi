package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;
import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsDadosCCKDTO;

public class ServicoMedCCK implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
	
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		EventoColetado ev = mensagem.getEventoColetado();
		ev.setLog(log);
		
		log.iniciaAvaliacao(idLog, "Servico MED CCK ");
		log.info(idLog, identacao, "Servico MED CCK - INI");
		
		UpRN upRN = new UpRN();
		try {
			upRN.iniciaConexaoBanco();
			upRN.lancaMedicaoParametro(log, idLog, identacao, ev);
		} catch (Exception e){
			e.printStackTrace();
			log.info("MedCCK: Ocorreu excessao abaixo", e);
		} finally {
			log.iniciaAvaliacao("finalizaConexaoBanco");
			upRN.finalizaConexaoBanco(log);
			log.paraAvaliacao();
			log.info(idLog, identacao, log.getAvaliacaoCompleta());
		}
		
        MensagemEnviada m = new MensagemEnviada(mensagem);
		
	    Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);
		
		log.paraAvaliacao(ev.getIdEvt());
		log.info(idLog, identacao, "Servico MED CCK - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		Double consumoAtivo=null,fatorPotencia=null,correnteA=null,correnteB=null,correnteC=null,
		tensaoA=null,tensaoAB=null,tensaoAC=null,tensaoBC=null,tensaoB=null,tensaoC=null,tensaoMedia=null,
		correnteMedia=null;
		
		consumoAtivo=Double.parseDouble(evtArgs.get("3"))/1000;
		fatorPotencia=Double.parseDouble(evtArgs.get("15"))/1000;
		correnteA=Double.parseDouble(evtArgs.get("9"))/1000;
		correnteB=Double.parseDouble(evtArgs.get("10"))/1000;
		correnteC=Double.parseDouble(evtArgs.get("11"))/1000;
		correnteMedia=Double.parseDouble(evtArgs.get("12"))/1000;
		tensaoA=Double.parseDouble(evtArgs.get("5"))/10;		
		tensaoB=Double.parseDouble(evtArgs.get("6"))/10;
		tensaoC=Double.parseDouble(evtArgs.get("7"))/10;
		tensaoAB=Double.parseDouble(evtArgs.get("30"))/10;
		tensaoAC=Double.parseDouble(evtArgs.get("31"))/10;
		tensaoBC=Double.parseDouble(evtArgs.get("32"))/10;
		tensaoMedia=Double.parseDouble(evtArgs.get("8"))/10;
		
		IwsDadosCCKDTO dadosCCK = new IwsDadosCCKDTO();
		
		dadosCCK.setConsumoAtivo(consumoAtivo);
		dadosCCK.setFatorDePotencia(fatorPotencia);
		
		dadosCCK.setCorrenteA(correnteA);
		dadosCCK.setCorrenteB(correnteB);
		dadosCCK.setCorrenteC(correnteC);
		
		dadosCCK.setCorrenteMedia(correnteMedia);
		
		dadosCCK.setTensaoAB(tensaoAB);
		dadosCCK.setTensaoAC(tensaoAC);
		dadosCCK.setTensaoBC(tensaoBC);
		
		dadosCCK.setTensaoA(tensaoA);
		dadosCCK.setTensaoB(tensaoB);
		dadosCCK.setTensaoC(tensaoC);
		
		dadosCCK.setTensaoMedia(tensaoMedia);
		
		dadosCCK.truncateAllValuesPrecision(3);
		retorno.setDadosCCK(dadosCCK);
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
	
}
