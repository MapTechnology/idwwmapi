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

public class ServicoEmailFinalCicloRN extends ServicoEmailFactory {

	public ServicoEmailFinalCicloRN(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}

	@Override
	protected Type getType() {		
		return Type.FIM_CICLO;
	}

	@Override
	protected String complementoAssuntoEmail(DwConsolid dwConsolid) {
		StringBuilder detalhe = new StringBuilder();
		String sDtHrFHora = DataHoraRN.dateToString(dwConsolid.getDthrFhora(), "dd/MM/yyyy HH:mm:ss");
		String sDtReferecia = DataHoraRN.dateToString(dwConsolid.getDtReferencia(), "dd/MM/yyyy");
		detalhe.append(" fechou ciclo ");
		detalhe.append(sDtHrFHora);
		detalhe.append(" do dia ");
		detalhe.append(sDtReferecia);		
		detalhe.append(" fechou ");
		return detalhe.toString();
	}

	@Override
	protected String complementoMensagemEmail(
			DwConsolid dwConsolid) {
		return null;
	}

	@Override
	public void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr) {
		// TODO Auto-generated method stub
		
	}


}
