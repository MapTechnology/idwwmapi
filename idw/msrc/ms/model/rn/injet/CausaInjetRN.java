package ms.model.rn.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbcau;

public class CausaInjetRN extends DAOGenericoInjet {
	public Ijtbcau pesquisarIjtbcau(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbcau ijtbcau where ijtbcau.cdcausas = :cd and ijtbcau.cdcausas <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbcau) q.uniqueResult();
	}
}
