package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwNserie;

public class DwNSerieDAO {
	private final Session session;

	public DwNSerieDAO(Session session) {
		this.session = session;
	}

	public DwNserie getUltimoDwNSerieComLike(String prefixo) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwNserie FROM DwNserie dwNserie");
		q.append("WHERE dwNserie.cb LIKE :prefixo");
		q.append("ORDER BY dwNserie.cb DESC");
		q.defineParametro("prefixo", prefixo + "%");
		q.setMaxResults(1);
		return (DwNserie) q.uniqueResult();
	}

}
