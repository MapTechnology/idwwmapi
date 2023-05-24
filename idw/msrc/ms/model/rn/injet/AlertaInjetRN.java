package ms.model.rn.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbale;

public class AlertaInjetRN extends DAOGenericoInjet {
	public Ijtbale pesquisarIjtbale(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbale ijtbale where ijtbale.cdalerta = :cd and ijtbale.cdalerta <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbale) q.uniqueResult();
	}
}
