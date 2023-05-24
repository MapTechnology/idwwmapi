package ms.model.rn.aoi;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.rn.AbstractRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.aoi.AoiOmronConveyor;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

/*
 * Essa classe tem como objetivo prover as RNs para o webservice
 * a ser chamado pelo coletor inova durante a coleta dos dados da AOI OMRON
 */
public class EventosAOIRN extends AbstractRN<DAOGenerico>{
	
	public EventosAOIRN() {
		super(new DAOGenerico());
	}

	public EventosAOIRN(DAOGenerico dao) {
		super(dao);
	}

	/* Metodo chamado pelo programa em C do inova
	 * 
	 */
	public EventoAOIDTO processaArquivoAoi(String cdup, String nrop, String nomeArquivo, EventoColetado evento, String botOrTop, String machName) {
		IdwLogger log = new IdwLogger("WSAOI" + cdup);
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		log.info(idLog, identacao, "Inicio processando coveyo " + cdup + " nrop=" + nrop + " nomeArquivo=" + nomeArquivo);
		
		identacao += 5;
		
		EventoAOIDTO retorno = new EventoAOIDTO();
		AoiOmronConveyor rn = new AoiOmronConveyor(log, idLog, identacao, nomeArquivo,nrop, cdup,botOrTop,evento.getDefeitos(), evento.getDthrEvento(), machName, evento.getCb(), evento.getIcUpDTO());
				
		List<EventoColetado> eventosProcessados = rn.obtemEvento();
		
		// Chama os servicos para todos os eventos
		
		if(rn.getStatus() == 1){
			for (EventoColetado ev : eventosProcessados) {
				MensagemRecebida mensagem = new MensagemRecebida(ev);
				mensagem.setLog(ev.getLog());
				mensagem.setIdLog(idLog);
				mensagem.setIdentacao(identacao);
				mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByIdUpPdba(cdup));

				try {
					ServicoFactory.getInstancia().executaServico(null, mensagem);
				} catch (ServicoFalhouException e) {
					log.info(idLog, identacao, "Excessao processaArquivoAoi:", e);
					e.printStackTrace();
				}

			}

			
		}
						
		retorno.setStEnvio(rn.getStatus());
		retorno.setCdParada(rn.getDsParada());
		
		identacao -= 5;
		
		log.info(idLog, identacao, "Fim processando coveyo");
		
		return retorno;
	}
	
}
