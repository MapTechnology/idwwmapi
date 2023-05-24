package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.rn.AbstractRN;


public class MestreInjetRN extends AbstractRN<DAOGenericoInjet> {

	public MestreInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbmestres> listaMestres(){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbmestres ijtbMestres where ijtbMestres.cdmestre <> :CdMestreInvalido ");
		q.defineParametro("CdMestreInvalido", "999999");
		return q.list();
	}
}
