package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijgrpdetinj;
import idw.model.rn.AbstractRN;


public class IjgrpdetinjRN extends AbstractRN<DAOGenericoInjet> {

	public IjgrpdetinjRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijgrpdetinj> listamaquinas(String cdgrupoMaquinas){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijgrpdetinj maquinas ");
		q.append("WHERE maquinas.ijgrpinj.cdgrpinj = :cdgrpmaquinas ");
		
		q.defineParametro("cdgrpmaquinas", cdgrupoMaquinas);

		List<Ijgrpdetinj> listaMaquinas = q.list();
		
		return listaMaquinas;
	}
}
