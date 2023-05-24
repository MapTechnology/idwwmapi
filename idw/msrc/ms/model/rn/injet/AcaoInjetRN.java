package ms.model.rn.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbaco;

public class AcaoInjetRN extends DAOGenericoInjet {
	public Ijtbaco pesquisarIjtbaco(String cd){
		MapQuery q = new MapQuery(getSession());
		q.append("from Ijtbaco ijtb where ijtb.cdacoes = :cd and ijtb.cdacoes <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbaco) q.uniqueResult();
	}
}
