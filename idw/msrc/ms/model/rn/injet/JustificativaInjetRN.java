package ms.model.rn.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbjup;

public class JustificativaInjetRN extends DAOGenericoInjet {
	public Ijtbjup pesquisarIjtbjup(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbjup ijtb where ijtb.cdjustparada = :cd and ijtb.cdjustparada <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbjup) q.uniqueResult();
	}
}
