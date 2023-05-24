package idw.model.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.pojos.template.MsEvtTemplate.StEvt;
import idw.model.rn.DataHoraRN;

public class MsEvtDAO {
	private final Session session;

	public MsEvtDAO(Session session) {
		this.session = session;
	}

	public MsEvt getMsEvt(long id) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT msEvt");
		q.append("FROM MsEvt msEvt");
		q.append("JOIN FETCH msEvt.msTpevt mstpevt");
		q.append("LEFT JOIN FETCH msEvt.dwPepro");
		q.append("LEFT JOIN FETCH msEvt.msEvtceps");
		q.append("LEFT JOIN FETCH msEvt.msEvt");
		q.append("LEFT JOIN FETCH msEvt.msEvtdefeitos");
		q.append("LEFT JOIN FETCH msEvt.msEvtmontagems");
		q.append("WHERE msEvt.idEvt = :idEvt");
		q.defineParametro("idEvt", id);
		return (MsEvt) q.uniqueResult();
	}

	public long totalEventosPendentesProcessamento(Session session, String cdUp) {
		MapQuery q0 = new MapQuery(session);
		q0.append("select count(*)");
		q0.append("from MsEvt msEvt");
		q0.append("join msEvt.msMsicup msicup");
		q0.append("join msicup.msUp msup");
		q0.append("where ");
		q0.append("msEvt.stEvt = 0");
		q0.append("and msup.cdUp = :cdUp");
		q0.defineParametro("cdUp", cdUp);
		List<Object> lcount = q0.list();
		return (long) lcount.get(0);
	}

	public List<MsEvt> getEventosPendentesProcessamento(String cdUp, int qtEventosParaProcessar) {
		MapQuery q = new MapQuery(session);
		q.append("select msEvt");
		q.append("from MsEvt msEvt");
		q.append("join fetch msEvt.msTpevt mstpevt");
		q.append("where");
		q.append("msEvt.stEvt = 0");
		q.append("and msEvt.cdUp = :cdUp");
		q.append("order by msEvt.idEvt");
		q.defineParametro("cdUp", cdUp);
		q.setMaxResults(qtEventosParaProcessar);
		return q.list();
	}

	public List<Long> getIdsEventosPendentesProcessamento(String cdUp, int qtEventosParaProcessar) {

		StringBuilder sb = new StringBuilder()
				.append("select new java.lang.Long(msEvt.idEvt) ")
				.append("from MsEvt msEvt ")
				.append("where msEvt.stEvt = 0 ")
				.append("and msEvt.cdUp = :cdUp ")
				.append("order by msEvt.idEvt ");

		MapQuery q = new MapQuery(session);
		q.append(sb.toString());
		q.defineParametro("cdUp", cdUp);
		q.setMaxResults(qtEventosParaProcessar);

		return q.list();

	}

	public void setStEvt(Long idEvt, StEvt stEvt, Date dtHrIProcessaServer, String erroConsol) {
		setStEvt(idEvt, stEvt.getValue(), dtHrIProcessaServer, erroConsol);
	}


	public void setStEvt(Long idEvt, int stEvt, Date dtHrIProcessaServer, String erroConsol) {
		MapQuery q = new MapQuery(session);
		q.append("UPDATE MsEvt msEvt SET msEvt.stEvt = :stEvt,");
		q.append("msEvt.dthrIprocessaserver = :dthrIprocessaserver, ");
		q.append("msEvt.dthrProcessaserver = :dthrProcessaserver,");
		q.append("msEvt.erroconsol = :erroconsol");
		q.append("WHERE msEvt.idEvt = :idEvt");
		q.defineParametro("stEvt", new BigDecimal(stEvt));
		q.defineParametro("dthrIprocessaserver", dtHrIProcessaServer);
		q.defineParametro("dthrProcessaserver", DataHoraRN.getDataHoraAtual());
		q.defineParametro("erroconsol", MsEvtTemplate.limitaTamanhoErroconsol(erroConsol));
		q.defineParametro("idEvt", idEvt);
		q.query().executeUpdate();
	}
}
