package idw.model.rn.imp.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbmol;
import idw.model.rn.AbstractRN;

/**
 * M�todos �teis para regras de neg�cio relacionadas ao molde ({@link Ijtbmol}) 
 * @author milton
 *
 */
public class MoldeInjetRN extends AbstractRN<DAOGenericoInjet> {
	
	public static final String CODIGO_MOLDE_DEFAULT = "999999";
	
	public MoldeInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}
	

	/**
	 * Pega todos moldes com c�digo diferente de '999999'
	 * @return
	 */
	
	public List<Ijtbmol> getListaMoldesValidos(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT ijtbmol FROM Ijtbmol ijtbmol");
		q.append("WHERE ijtbmol.cdMolde <> :cdMoldeDefault");
		q.defineParametro("cdMoldeDefault", MoldeInjetRN.CODIGO_MOLDE_DEFAULT);		
		return q.list();		
	}
	
	
	

}
