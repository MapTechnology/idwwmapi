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

public class ServicoEmailOfflineRN extends ServicoEmailFactory {

	public ServicoEmailOfflineRN(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}

	@Override
	protected Type getType() {		
		return Type.MAQUINA_OFFLINE;
	}

	@Override
	protected String complementoAssuntoEmail(DwConsolid dwConsolid) {
		StringBuilder detalhe = new StringBuilder();
		String sDtHrIHora = "";
		String sDtHrFHora = "";
		if (dwConsolid.getDthrIhora() != null) {
			sDtHrIHora = DataHoraRN.dateToString(dwConsolid.getDthrIhora(), "dd/MM/yyyy HH:mm:ss");
			sDtHrFHora = DataHoraRN.dateToString(dwConsolid.getDthrFhora(), "dd/MM/yyyy HH:mm:ss");
		}
		String sDtReferecia = DataHoraRN.dateToString(dwConsolid.getDtReferencia(), "dd/MM/yyyy");
		detalhe.append(" na Hora ");
		detalhe.append(sDtHrIHora);
		detalhe.append(" - ");
		detalhe.append(sDtHrFHora);
		detalhe.append(" do dia ");
		detalhe.append(sDtReferecia);		
		return detalhe.toString();
	}

	@Override
	protected String complementoMensagemEmail(DwConsolid dwConsolid) {
		return "";
	}

	@Override
	public void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr) {

		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		assunto.append("Forno ");
		assunto.append(ompt.getCdPt());

		assunto.append(this.complementoAssuntoEmail(dwConsolid));
		assunto.append(" Sem Conex�o ");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema IDW as ");
		descricao.append(DataHoraRN.getDataHoraAtualFormatada());
		descricao.append(this.complementoMensagemEmail(dwConsolid));

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());
	}
}
