package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbale;
import idw.model.rn.AbstractRN;


public class AlertaInjetRN extends AbstractRN<DAOGenericoInjet> {

	public AlertaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbale> listaAlertasAtivas(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbale ijtbale ");
		q.appendWhere(MapQuery._NULL, "ijtbale.cdalerta <> :cdalertadefault",true);
		q.appendWhere(MapQuery._AND, "ijtbale.cdalerta <> :cdalertaextrapolouinspecao",true);
		q.appendWhere(MapQuery._AND, "ijtbale.cdalerta <> :cdalertaextrapolouparada",true);
		q.appendWhere(MapQuery._AND, "ijtbale.cdalerta <> :cdalertaproblemaqualidade",true);
		q.defineParametro("cdalertadefault", "999999");
		q.defineParametro("cdalertaextrapolouinspecao", "EXT001");
		q.defineParametro("cdalertaextrapolouparada", "EXT002");
		q.defineParametro("cdalertaproblemaqualidade", "QLD001");

		return q.list();

	}
}
