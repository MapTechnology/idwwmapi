package ms.model.rn.coletaComAndon;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.rn.AbstractRN;
import injetws.model.excessoes.RegistroDesconhecidoException;

public class OperadorRN extends AbstractRN<DAOGenericoInjet>{

	public OperadorRN(){
		super(new DAOGenericoInjet());
	}
	
	public OperadorRN(DAOGenericoInjet dao) {
		super(dao);
	}
	/**
	 * Recuperar usuario de ijtbusu
	 * 
	 * @param cdUsuario
	 *            Código do usuário
	 * @return Usuário
	 * @throws RegistroDesconhecidoException
	 */
	public String isOperador(String cracha){
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("from Ijtbusu ijtb ");	
		q.append("where ijtb.matricula = :ds and ijtb.stusuario = 0 ");
		q.defineParametro("ds", cracha);
		
		Ijtbusu ijtbusu = (Ijtbusu) q.uniqueResult();
		
		if (ijtbusu == null)
			return "999999";
		
		return ijtbusu.getCdusuario();
	}
}
