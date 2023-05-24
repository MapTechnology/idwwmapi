package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbcau;
import idw.model.rn.AbstractRN;


public class CausaInjetRN extends AbstractRN<DAOGenericoInjet> {

	public CausaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbcau> listaCausasAtivas(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbcau ijtbcau ");
		q.appendWhere(MapQuery._NULL, "ijtbcau.cdcausas <> :cdcausa",true);
		q.appendWhere(MapQuery._AND, "ijtbcau.stativo=:ativo", true);
		q.defineParametro("cdcausa", "999999");
		q.defineParametro("ativo",1);

		return q.list();
	}
}
