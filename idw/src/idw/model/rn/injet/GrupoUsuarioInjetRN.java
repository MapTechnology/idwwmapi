package idw.model.rn.injet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijgruusu;
import idw.model.pojos.injet.Ijtbgru;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.rn.AbstractRN;


public class GrupoUsuarioInjetRN extends AbstractRN<DAOGenericoInjet> {

	public GrupoUsuarioInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbgru> listaGruposUsuariosAtivos(List<Ijtbusu> listaUsuariosAtivos){

		List<Ijtbgru> retorno = new ArrayList<Ijtbgru>();

		Map<String, Ijtbgru> listaIjtbgru = new HashMap<String, Ijtbgru>();
		if((listaUsuariosAtivos != null) && (listaUsuariosAtivos.size() > 0)) {
			for(Ijtbusu ijtbusu: listaUsuariosAtivos){
				if(ijtbusu.getIjgruusus() != null) {
					for(Ijgruusu ijgruusu: ijtbusu.getIjgruusus()){
						if(ijgruusu.getIjtbgru() != null){
							Ijtbgru ijtbgru = ijgruusu.getIjtbgru();
							listaIjtbgru.put(ijtbgru.getCdgrupo(), ijtbgru);
						}
					}
				}
			}
			retorno.addAll(listaIjtbgru.values());
		}

		return retorno;
	}

}
