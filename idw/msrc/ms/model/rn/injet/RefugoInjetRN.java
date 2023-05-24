package ms.model.rn.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbref;

public class RefugoInjetRN extends DAOGenericoInjet {
	public Ijtbref pesquisarIjtbref(String cdrefugo){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbref ijtbref where ijtbref.cdrefugo = :cdrefugo and ijtbref.cdrefugo <> '999999'");
		q.defineParametro("cdrefugo", cdrefugo);
		q.setMaxResults(1);
		return (Ijtbref) q.uniqueResult();
	}	
	
}
