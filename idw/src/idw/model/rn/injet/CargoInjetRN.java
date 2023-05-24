package idw.model.rn.injet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbcar;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.rn.AbstractRN;


public class CargoInjetRN extends AbstractRN<DAOGenericoInjet> {

	public CargoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbcar> listaCargos(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbcar ijtbcar ");
		q.appendWhere(MapQuery._NULL, "ijtbcar.cdcargo <> :cdcargo",true);
		q.defineParametro("cdcargo", "999999");

		return q.list();
	}

	public List<Ijtbcar> listaCargosUsuariosAtivos(List<Ijtbusu> listaUsuariosAtivos){

		List<Ijtbcar> retorno = new ArrayList<Ijtbcar>();

		Map<String, Ijtbcar> listaIjtbcar = new HashMap<String, Ijtbcar>();
		if((listaUsuariosAtivos != null) && (listaUsuariosAtivos.size() > 0) ){
			for(Ijtbusu ijtbusu: listaUsuariosAtivos){
				Ijtbcar ijtbcar = ijtbusu.getIjtbcar();
				// Adiciona se item ainda n�o estiver na lista
				if(listaIjtbcar.get(ijtbcar.getCdcargo()) == null){
					listaIjtbcar.put(ijtbcar.getCdcargo(), ijtbcar);
				}
			}
			retorno.addAll(listaIjtbcar.values());
		}

		return retorno;

	}

}
