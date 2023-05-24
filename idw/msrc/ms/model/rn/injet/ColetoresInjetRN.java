package ms.model.rn.injet;

import java.util.List;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbcoletores;

public class ColetoresInjetRN extends DAOGenericoInjet {
	public List<Ijtbcoletores> pesquisarListaIjtbcoletores(){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbcoletores ijtb join fetch ijtb.ijtbsubcoletoreses ijtbsubcoletores ");
		return q.list();
	}
}
