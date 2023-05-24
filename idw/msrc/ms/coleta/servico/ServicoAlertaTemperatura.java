package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmPt;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.PTRN;
import idw.model.rn.servemail.ServicoEmailAlertaParametroRN;
import idw.model.rn.servemail.ServicoEmailFactory;
import idw.util.IdwLogger;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoAlertaTemperatura implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
	
		
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao("Servico enviaEmailAlertaTemp " + mensagem.getEventoColetado().getParametroLido()+"�C");

		log.info(idLog, identacao, "Servico enviaEmailAlertaTemp");		
		
		EventoColetado ev = mensagem.getEventoColetado();

		// Encontrar dwconsolid
		ConsolidaRN rn = new ConsolidaRN();
		
		try {
			rn.iniciaConexaoBanco();
			
			PTRN ptrn = new PTRN(rn.getDao());
			
			OmPt ompt = ptrn.getOmPt(ev.getIcUpDTO().getUpDTO().getCd_up());
			
			DwConsolid dwconsolid = rn.getUltimoDwConsolidTurno(ompt.getIdPt());
			
			// Esse servico nao ira enviar registro para ms-evt, apenas ira enviar emails
			ServicoEmailFactory email = ServicoEmailFactory.getInstance(log, idLog, identacao, rn.getDaoSession(), ServicoEmailFactory.TpEvt.ALERTA_PARAMETRO);
			
			
			( (ServicoEmailAlertaParametroRN) email).setParametroAferido(ev.getParametroLido().toString());
			( (ServicoEmailAlertaParametroRN) email).setDtAfericaoParametro(ev.getDthrEvento());
			( (ServicoEmailAlertaParametroRN) email).setFaixaMinima(ev.getForaFaixaInicial());
			( (ServicoEmailAlertaParametroRN) email).setFaixaMaxima(ev.getForaFaixaFinal());
			
			
			
			if(dwconsolid!=null)
				email.gerarAlerta(dwconsolid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
        log.info(idLog, identacao, "Mandando resposta para cliente :" + mensagem.getIp());
		log.paraAvaliacao();
		log.info(idLog, identacao, "Servico enviaEmailAlertaTemp - FIM  " + log.getAvaliacaoCompleta() );
		
		return null;
	}
}
