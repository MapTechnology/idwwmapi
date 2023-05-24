package idw.model.rn.injet;

import java.math.BigDecimal;
import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbpar;
import idw.model.rn.AbstractRN;


public class ParadaInjetRN extends AbstractRN<DAOGenericoInjet> {

	public ParadaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbpar> listaParadasAtivas(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbpar ijtbpar ");
//		q.appendWhere(MapQuery._NULL, "ijtbpar.cdparada <> :cdparada",true);
		q.appendWhere(MapQuery._AND, " (ijtbpar.teprogramado IS NULL or ijtbpar.teprogramado = :teprogramado)", true);
		q.defineParametro("cdparada", "999999");
		q.defineParametro("teprogramado", BigDecimal.ONE);

		return q.list();
	}
}
