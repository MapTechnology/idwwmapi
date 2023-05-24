package idw.model.rn.servemail;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsTpevtTemplate.Type;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class ServicoEmailHeartBeatRN extends ServicoEmailFactory {
	
	public ServicoEmailHeartBeatRN(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}

	@Override
	protected Type getType() {		
		return Type.HEART_BEAT;
	}

	@Override
	protected String complementoAssuntoEmail(DwConsolid dwConsolid) {
		StringBuilder detalhe = new StringBuilder();
		String sDtHrIHora = DataHoraRN.dateToString(dwConsolid.getDthrIhora(), "dd/MM/yyyy HH:mm:ss");
		String sDtHrFHora = DataHoraRN.dateToString(dwConsolid.getDthrFhora(), "dd/MM/yyyy HH:mm:ss");
		String sDtReferecia = DataHoraRN.dateToString(dwConsolid.getDtReferencia(), "dd/MM/yyyy");
		detalhe.append(" na Hora ");
		detalhe.append(sDtHrIHora);
		detalhe.append(" - ");
		detalhe.append(sDtHrFHora);
		detalhe.append(" do dia ");
		detalhe.append(sDtReferecia);		
		detalhe.append(" fechou ");
		return detalhe.toString();
	}

	@Override
	protected String complementoMensagemEmail(
			DwConsolid dwConsolid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr) {
	}

}
