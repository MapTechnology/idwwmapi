package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbref;
import idw.model.rn.AbstractRN;


public class RefugoInjetRN extends AbstractRN<DAOGenericoInjet> {

	public RefugoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbref> listaRefugosAtivas(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbref ijtbref ");
		q.appendWhere(MapQuery._NULL, "ijtbref.cdrefugo <> :cdrefugo",true);
		q.appendWhere(MapQuery._AND, "ijtbref.stativo=:ativo", true);
		q.defineParametro("cdrefugo", "999999");
		q.defineParametro("ativo",1);

		return q.list();
	}
}
