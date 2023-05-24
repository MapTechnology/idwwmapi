package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import idw.webservices.dto.FeederDTO;
import idw.webservices.dto.NozzleDTO;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;

//PH em 2012-12-13
//No momento só irei salvar o log, não ira ser feito nada neste momento
public class ServicoUsoRap  implements IServico{

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem)
			throws ServicoFalhouException {
		// TODO Auto-generated method stub
		//Gera um log para debugar
		//Apenas para poder receber essa informação e saber q ela esta chegando
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		String cdUp = "desc";
		if(mensagem.getEventoColetado().getIcUpDTO() != null && mensagem.getEventoColetado().getIcUpDTO().getUpDTO() != null){
			cdUp = mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up();
			log.iniciaAvaliacao(idLog, "ServicoUsoRap: " + cdUp );
			
			log.info(idLog, identacao, "INICIO - ServicoUsoRap em: " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() );
			log.info(idLog, identacao, "Produto: " + mensagem.getEventoColetado().getCdproduto());
			
			//Verifico se o evento é de feeder ou nozzle
			if(mensagem.getEventoColetado().getFeeders() != null){
				for(int i = 0 ; i < mensagem.getEventoColetado().getFeeders().size(); i++){
					if(mensagem.getEventoColetado().getFeeders().get(i) != null){
						FeederDTO feeder = mensagem.getEventoColetado().getFeeders().get(i);
						log.info(idLog, identacao, "Modulo: " +  feeder.getModulo() + "|" + "Slot: " + feeder.getSlot() + "|" 
								+"Qtd Inserida: " + feeder.getQuantidadeUsada() + "|" + "Qtd Erro: " + feeder.getQuantidadeErro() + "|"+
								"Origem: " + feeder.getOrigem());
					}
				}
			}
			if(mensagem.getEventoColetado().getNozzles() != null){
				for(int i = 0; i < mensagem.getEventoColetado().getNozzles().size(); i++){
					if(mensagem.getEventoColetado().getNozzles().get(i) != null){
						NozzleDTO nozzle = mensagem.getEventoColetado().getNozzles().get(i);
						log.info(idLog, identacao, "Módulo: " + nozzle.getModulo() + "|" +
						"Cabeça: " + nozzle.getCabeca() + "|" + "posicao: " + nozzle.getPosicao() + "|" +
								"Qtd Usada: " + nozzle.getQuantidadUsada()  + "|" + "Origem: " + nozzle.getOrigem());
					}
				}
			
			}
			
			log.mostrarAvaliacaoCompleta();
			
		}else{
			log.info(idLog, identacao, "Alerta 1 - up está nulo");
		}
		
		return null;
	}

}
