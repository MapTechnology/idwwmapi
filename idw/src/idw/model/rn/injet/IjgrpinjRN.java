package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijgrpinj;
import idw.model.rn.AbstractRN;

public class IjgrpinjRN extends AbstractRN<DAOGenericoInjet> {

		public IjgrpinjRN(DAOGenericoInjet dao) {
			super(dao);
		}

		public List<Ijgrpinj> getGrupoMaquinasCombo() {
			
			MapQuery q = new MapQuery(getDao().getSession());
			q.append("FROM Ijgrpinj grupomaquinas ");
			List<Ijgrpinj> listaGrupoMaquinasCombo = q.list();
					
			return listaGrupoMaquinasCombo;
		}
}
