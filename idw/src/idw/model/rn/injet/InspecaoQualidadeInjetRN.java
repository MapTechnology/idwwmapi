package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijparaminterface;
import idw.model.pojos.injet.Ijtbcentinsp;
import idw.model.rn.AbstractRN;


public class InspecaoQualidadeInjetRN extends AbstractRN<DAOGenericoInjet> {

	public InspecaoQualidadeInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}
	
	public List<Ijtbcentinsp> getListaTodosIjtbcentinsp(){
		return this.getDao().findAll(Ijtbcentinsp.class);
	}
	
	/**
	 * Pegar {@code Ijparaminterface} baseado no seu id {@code idparametro}  
	 * @param parameterid
	 * @return
	 */
	public Ijparaminterface getIjparaminterface(String parameterid) {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT ijparaminterface FROM Ijparaminterface Ijparaminterface");
		q.append("WHERE ijparaminterface.idparametro = :idparametro");
		q.defineParametro("idparametro", parameterid);
		q.setMaxResults(1);
		return (Ijparaminterface) q.uniqueResult();
	}
	
}
