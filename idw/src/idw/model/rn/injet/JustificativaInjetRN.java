package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbjup;
import idw.model.rn.AbstractRN;


public class JustificativaInjetRN extends AbstractRN<DAOGenericoInjet> {

	public JustificativaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbjup> listaJustificativasAtivas(){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbjup ijtbjup ");
		q.appendWhere(MapQuery._NULL, "ijtbjup.cdjustparada <> :cdjust",true);
		q.appendWhere(MapQuery._AND, "ijtbjup.stativo=:ativo", true);
		q.defineParametro("cdjust", "999999");
		q.defineParametro("ativo",1);
		return q.list();
	}
}
