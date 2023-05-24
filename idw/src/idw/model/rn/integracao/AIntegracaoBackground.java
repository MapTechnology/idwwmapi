package idw.model.rn.integracao;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmJob;
import idw.model.pojos.OmJobdet;
import idw.model.rn.AbstractRN;
import idw.util.IdwLogger;

public abstract class AIntegracaoBackground extends AbstractRN<DAOGenerico>{

	public AIntegracaoBackground(DAOGenerico dao) {
		super(dao);
	}

	public abstract void integrar(IdwLogger log, int idLog);
	
	private OmJob omjob = null;

	public OmJob getOmjob() {
		return omjob;
	}

	public void setOmjob(OmJob omjob) {
		this.omjob = omjob;
	}
	
	
	protected List<OmJobdet> pesquisarOmJobdets(OmJob omjob) {
		MapQuery q = new MapQuery(getDaoSessionStatless());
		q.append("select a");
		q.append("from OmJobdet a");
		q.append("where a.omJob = :omjob");
		q.defineParametro("omjob", omjob);
		return q.list();
	}


}
