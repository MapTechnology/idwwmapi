package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijareres;
import idw.model.rn.AbstractRN;

public class AreaInjetRN extends AbstractRN<DAOGenericoInjet> {

		public AreaInjetRN(DAOGenericoInjet dao) {
			super(dao);
		}

		public List<Ijareres> listaAreasAtivas(){

			MapQuery q = new MapQuery(this.getDao().getSession());
			q.append("from Ijareres ijareres ");
//			q.appendWhere(MapQuery._NULL, "ijareres.cdarea <> :cdarea",true);
//			q.defineParametro("cdarea", "999999");

			return q.list();
		}
}
