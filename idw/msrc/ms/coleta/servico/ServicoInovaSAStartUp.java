package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inovastandalone.InovaSAStartingUpManager;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.IcRN;

public class ServicoInovaSAStartUp implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {

		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao(idLog, "ServicoInovaSAStartUp");
		
		log.info(idLog, identacao,"Servico INOVASA STARTUP - INI para " + mensagem.getIp());
		
		if(mensagem.getIp() != null) {
			String dirBase = IwsFacade.getRealRootPath();
			String filePath = dirBase + "/" + mensagem.getIp() + ".zip";
			log.info(idLog, identacao, "ServicoInovaSAStartUp: Removing " + filePath);
			ArquivosDiretorios.delete(filePath);
			
			InovaSAStartingUpManager.getInstancia().addInovaSAIP(mensagem.getIp());
		}
		
		// Lancar evento de inicio, motivo e fim de parada para o inova clp. Para tanto obter o ultimo evento
		// ou o ultimo heartbeat e usar a data e hora maior como referencia para o inicio da parada
		// usar a mesma data e hora para lancar o motivo de parada igual ao definido em omcfg.id_TparadaSemconexao
		// O fim da parada usara a data e hora desse servico
		IcRN rn = new IcRN();
		try {
			rn.iniciaConexaoBanco(null);
			MensagemRecebida mensagemParadaSemConexao = new MensagemRecebida();
			EventoColetado evParadaSemConexao = new EventoColetado();
			evParadaSemConexao.setDthrEvento(mensagem.getEventoColetado().getDthrEvento());
			evParadaSemConexao.setIcUpDTO(mensagem.getEventoColetado().getIcUpDTO());
			evParadaSemConexao.setOrigem("servicoInovaSAStartup");
			
			mensagemParadaSemConexao.setDadosIcDTO(mensagem.getDadosIcDTO());
			mensagemParadaSemConexao.setLog(mensagem.getLog());
			mensagemParadaSemConexao.setIdLog(mensagem.getIdLog());
			mensagemParadaSemConexao.setIdentacao(mensagem.getIdentacao());
			mensagemParadaSemConexao.setIc(mensagem.getIc());
			mensagemParadaSemConexao.setEventoColetado(evParadaSemConexao);
			
			
			rn.lancaParadaSemConexao(log, idLog, identacao, mensagemParadaSemConexao);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception em lancaParadaSemConexao");
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);

		
		log.info(idLog, identacao, "Servico INOVASA STARTUP - FIM ");
		//System.out.println("Servico INOVASA STARTUP - FIM ");

		log.paraAvaliacao();
		log.info(idLog, identacao, log.getAvaliacaoCompleta());
		
		return null; // Pois nao existe um evento a ser gravado em MsEvt
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}

}