package ms.model.rn.injet;


import java.util.List;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.pojos.injet.Ijusudirespec;

public class UsuarioInjetRN extends DAOGenericoInjet {
	
	public Ijtbusu pesquisarIjtbusu(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbusu ijtb ");
		q.append("left join fetch ijtb.ijtbusutecespec ijtbusutecespec ");
		q.append("left join fetch ijtb.ijusuDirespecs ijusuDirespecs ");
		q.append("where ijtb.cdusuario = :cd and ijtb.cdusuario <> '999999' and ijtb.stusuario = 0 ");
		q.defineParametro("cd", cd);

		List<Ijtbusu> listaIjtbusu = null;
		
		listaIjtbusu = q.list();
		Ijtbusu ijtbusu = null;
		if (listaIjtbusu != null && listaIjtbusu.size() > 0){
			ijtbusu = listaIjtbusu.get(0);
		}
		return ijtbusu;
	}
	public boolean isTecnicoQualidade(Ijtbusu ijtbusu){
		boolean retorno = false;
		if (ijtbusu.getIjusudirespecs() != null && ijtbusu.getIjusudirespecs().size() > 0){
			for (Ijusudirespec t : ijtbusu.getIjusudirespecs()){
				if (t.getId().getCdfuncao().equals("000026")){
					retorno = true;
					break;
				}
			}
		}
		return retorno;
	}
	
	public boolean isTecnicoCIP(Ijtbusu ijtbusu){
		boolean retorno = false;
		if (ijtbusu.getIjusudirespecs() != null && ijtbusu.getIjusudirespecs().size() > 0){
			for (Ijusudirespec t : ijtbusu.getIjusudirespecs()){
				if (t.getId().getCdfuncao().equals("000032")){
					retorno = true;
					break;
				}
			}
		}
		return retorno;
	}
	
}
