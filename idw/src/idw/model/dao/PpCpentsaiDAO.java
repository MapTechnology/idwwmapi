package idw.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpentsai;

public class PpCpentsaiDAO {
	private final Session session;
	
	public PpCpentsaiDAO(Session session){
		this.session = session;
	}
	
	public PpCpentsai getUltimoPpCpentsaiDoPt(OmPt omPt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT ppCpentsai ");
		q.append("FROM PpCpentsai ppCpentsai ");
		q.append("where ppCpentsai.omPt = :omPt ");
		q.append("ORDER BY ppCpentsai.dthrInicio DESC, idCpentsai DESC");
		q.defineParametro("omPt", omPt);
		q.setMaxResults(1);
		return (PpCpentsai) q.uniqueResult();
	}

	public List<PpCpentsai> getPpCpentsai(OmPt omPt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT ppCpentsai ");
		q.append("FROM PpCpentsai ppCpentsai ");
		q.append("where ppCpentsai.omPt = :omPt ");
		q.append("ORDER BY ppCpentsai.dthrInicio DESC, idCpentsai DESC");
		q.defineParametro("omPt", omPt);		
		return q.list();		
	}
	
	public PpCpentsai incluirNovoPpCpentsai(PpCp ppCp, OmPt omPt, Date dthrInicio, Date dthrFim) {
		PpCpentsai ppCpentsai;
		ppCpentsai = new PpCpentsai();
		ppCpentsai.setOmPt(omPt);
		ppCpentsai.setPpCp(ppCp);
		ppCpentsai.setDthrInicio(dthrInicio);
		ppCpentsai.setDthrFim(dthrFim);
		session.saveOrUpdate(ppCpentsai);
		return ppCpentsai;
	}

}
