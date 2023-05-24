package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inova.Stubdelegate;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoConsulta implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		if (Stubdelegate.getInstancia().isInjetAtivo() == true){
			IdwLogger log = mensagem.getLog();
			EventoColetado ev = mensagem.getEventoColetado();
			//ev.setCdconsulta(mensagem.getCdConsulta());
			
			log.iniciaAvaliacao("Servico CONSULTA " + ev.getCdconsulta());
			log.info("Servico CONSULTA - INI");
	        
			IwsConsultaDTO consulta = Stubedelegate.getInstancia().consulta(mensagem, ev);
			
			MensagemEnviada m = new MensagemEnviada(mensagem);
	        m.setConsulta(consulta);
	        
	        log.info("Mandando resposta para cliente :" + mensagem.getIp());
	      	Stubedelegate.getInstancia().enviaMensagemParaIhmSolicitante(mensagem.getIp(), m);
	      	
		    log.paraAvaliacao();
			log.info("Servico CONSULTA - FIM  " + log.getAvaliacaoCompleta() );
			
			// Ailton 2019-09-23: maneira de passar o retorno da consulta para quem chama o servico 
			MsEvt retorno = new MsEvt();
			if (consulta != null && consulta.getCampoRSP1() != null) {
				retorno.setCb(consulta.getCampoRSP1() 
					+ "," + consulta.getCampoRSP2()
					+ "," + consulta.getCampoRSP3()
					+ "," + consulta.getCampoRSP4()
					+ "," + consulta.getCampoRSP5()
					+ "," + consulta.getCampoRSP6()
					+ "," + consulta.getCampoRSP7()
					+ "," + consulta.getCampoRSP8());
				return retorno;
			}
		} else {
			// Consulta qdo for apenas IDW
			ServicoConsultaGenericaINOVASA rn = new ServicoConsultaGenericaINOVASA();
			rn.executaServico(sessao, mensagem);
		}
		
		return null;
	}

}
