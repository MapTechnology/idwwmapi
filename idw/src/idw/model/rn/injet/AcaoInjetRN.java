package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbaco;
import idw.model.rn.AbstractRN;


public class AcaoInjetRN extends AbstractRN<DAOGenericoInjet> {

	public AcaoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbaco> listaAcaosAtivas(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbaco ijtbaco ");
		q.appendWhere(MapQuery._NULL, "ijtbaco.cdacoes <> :cdacao",true);
		q.appendWhere(MapQuery._AND, "ijtbaco.stativo=:ativo", true);
		q.defineParametro("cdacao", "999999");
		q.defineParametro("ativo",1);

		return q.list();
	}
}
