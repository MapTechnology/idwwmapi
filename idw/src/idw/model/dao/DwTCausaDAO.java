package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwTCausa;

public class DwTCausaDAO {

	private Session session;
	
	public DwTCausaDAO(Session session){
		this.session = session;
	}
	
	public List<DwTCausa> getCausaAtivas(String cdCausa, String dsCausa, String cdtppt){
		MapQuery q = new MapQuery(session);
		q.append("select causa");
		q.append("FROM DwTCausa causa");
		q.append("join fetch causa.omTppt omtppt");
		q.append("WHERE causa.stAtivo = :stAtivo");
		if (!cdCausa.equals("") && !dsCausa.equals("")) {
			q.append("AND causa.cdTcausa = :cdCausa OR causa.dsTcausa = :dsCausa");
		} else if (!cdCausa.equals("")) {
			q.append("AND causa.cdTcausa = :cdCausa");
		} else if (!dsCausa.equals("")) {
			q.append("AND causa.dsTcausa = :dsCausa");
		}
		if (cdtppt != null && cdtppt.equals("") == false) {
			q.append("and omtppt.cdTppt = :cdtppt");
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdCausa", cdCausa);
		q.defineParametro("dsCausa", dsCausa);
		q.defineParametro("cdtppt", cdtppt);
		return q.list();
	}
	
	public DwTCausa getDwTCausaPorCdAtivo(String cdTcausa){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTCausa causa");
		q.append("WHERE causa.cdTcausa = :cdTcausa");
		q.append("AND causa.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdTcausa", cdTcausa);
		return (DwTCausa) q.uniqueResult();
	}

}
