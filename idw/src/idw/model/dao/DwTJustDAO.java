package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwTJust;

public class DwTJustDAO {
	
	private Session session;
	
	public DwTJustDAO(Session session){
		this.session = session;
	}
	
	public List<DwTJust> getDwTJust(String cdJust, String dsJust, String cdtppt){
		MapQuery q = new MapQuery(session);
		q.append("select justificativa");
		q.append("FROM DwTJust justificativa");
		q.append("join fetch justificativa.omTppt omtppt");
		q.append("WHERE justificativa.stAtivo = :stAtivo");
		if (!cdJust.equals("") && !dsJust.equals("")) {
			q.append("AND justificativa.cdTjust = :cdJust OR justificativa.dsTjust = :dsJust");
		} else if (!cdJust.equals("")) {
			q.append("AND justificativa.cdTjust = :cdJust");
		} else if (!dsJust.equals("")) {
			q.append("AND justificativa.dsTjust = :dsJust");
		}
		if (cdtppt != null && cdtppt.equals("") == false) {
			q.append("and omtppt.cdTppt = :cdtppt");
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdJust", cdJust);
		q.defineParametro("dsJust", dsJust);
		q.defineParametro("cdtppt", cdtppt);
		return q.list();
	}

	public DwTJust getDwTJustPorCdAtivo(String cdTjust){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTJust just");
		q.append("WHERE just.cdTjust = :cdTjust");
		q.append("AND just.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdTjust", cdTjust);
		return (DwTJust) q.uniqueResult();
	}
}
