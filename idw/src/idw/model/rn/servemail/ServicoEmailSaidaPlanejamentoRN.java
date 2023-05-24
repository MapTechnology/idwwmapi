package idw.model.rn.servemail;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsTpevtTemplate.Type;
import idw.util.IdwLogger;

public class ServicoEmailSaidaPlanejamentoRN extends ServicoEmailFactory {
	
	public ServicoEmailSaidaPlanejamentoRN(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}
	
	@Override
	protected Type getType() {		
		return Type.FIM_CICLO;
	}

	@Override
	protected String complementoAssuntoEmail(DwConsolid dwConsolid) {
		
		return " finalizou planejamento";
	}

	@Override
	protected String complementoMensagemEmail(DwConsolid dwConsolid){
		StringBuilder sb = new StringBuilder("");
		
		sb.append(dwConsolid.getDwFolha().getIdFolha());
		sb.append(" - ");
		sb.append(dwConsolid.getDwFolha().getCdFolha());
		sb.append(" - ");
		sb.append(dwConsolid.getDwFolha().getDsFolha());
		
		return sb.toString();
		
	}

	@Override
	public void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr) {
	}

}
