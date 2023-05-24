package idw.model.rn.injet;

import java.util.List;

import org.hibernate.Query;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbgal;
import idw.model.rn.AbstractRN;

@SuppressWarnings("unchecked")
public class GalpaoInjetRN extends AbstractRN<DAOGenericoInjet>{

	public GalpaoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbgal> pesquisarIjtbgal(String cdGalpao){
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "select distinct ijtbgal ";
		HQL += "from Ijtbgal ijtbgal ";
		HQL += "join fetch ijtbgal.ijgalobjs ";
		HQL += "where ( exists (from Ijgalobj b where b.id.cdgalpao = ijtbgal.cdgalpao) or ";
		HQL += "exists (from Ijgalobjgal c where c.id.cdgalpao = ijtbgal.cdgalpao) ) ";

		if (cdGalpao != null && !cdGalpao.equals("")){
			HQL += "and ijtbgal.cdgalpao = '::cdgalpao' ";
			HQL = HQL.replaceAll("::cdgalpao", cdGalpao);
		}
		HQL += "order by ijtbgal.cdgalpao ";

		List<Ijtbgal> listaIjtbgal = null;

		Query q = getDaoSession().createQuery(HQL);
		
		try{
			listaIjtbgal = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		return listaIjtbgal;
	}
}