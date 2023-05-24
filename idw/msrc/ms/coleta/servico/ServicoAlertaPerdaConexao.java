package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmPt;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.PTRN;
import idw.model.rn.servemail.ServicoEmailFactory;
import idw.util.IdwLogger;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoAlertaPerdaConexao implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
	
		
		
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao("Servico enviaEmailAlertaPerdaConexao com " + mensagem.getIp());

		log.info(idLog, identacao, "Servi�o enviaEmailAlertaPerdaConexao");		
		
		EventoColetado ev = mensagem.getEventoColetado();

		// Encontrar dwconsolid
		ConsolidaRN rn = new ConsolidaRN();
		rn.iniciaConexaoBanco(sessao);
		
		PTRN ptrn = new PTRN(rn.getDao());
		
		OmPt ompt;
		try {
			ompt = ptrn.getOmPt(ev.getIcUpDTO().getUpDTO().getCd_up());
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		DwConsolid dwconsolid = rn.getUltimoDwConsolidTurno(ompt.getIdPt());
		
		// Esse servico nao ira enviar registro para ms-evt, apenas ira enviar emails
		ServicoEmailFactory email = ServicoEmailFactory.getInstance(log, idLog, identacao, rn.getDaoSession(), ServicoEmailFactory.TpEvt.ALERTA_OFFLINE);
		email.gerarAlerta(dwconsolid);

		rn.finalizaConexaoBanco();
		
        log.info(idLog, identacao, "Mandando resposta para cliente :" + mensagem.getIp());
		log.paraAvaliacao();
		log.info(idLog, identacao, "Servi�o enviaEmailAlertaPerdaConexao - FIM  " + log.getAvaliacaoCompleta() );
		
		return null;
	}
	
	

}
