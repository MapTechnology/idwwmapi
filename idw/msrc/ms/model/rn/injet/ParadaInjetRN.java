package ms.model.rn.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbpar;

public class ParadaInjetRN extends DAOGenericoInjet {
	public Ijtbpar pesquisarIjtbpar(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbpar ijtb where ijtb.cdparada = :cd and ijtb.cdparada <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbpar) q.uniqueResult();
	}
}
