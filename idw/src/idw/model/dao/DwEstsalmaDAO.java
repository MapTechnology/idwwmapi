package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwEstsalma;

public class DwEstsalmaDAO {

	private Session session;
	
	public DwEstsalmaDAO(Session session){
		this.session = session;
	}
	
	public List<DwEstsalma> getDwEstsalmaPorCdProduto(String cdProduto){
		MapQuery q = new MapQuery(session);
		q.append("select distinct e");
		q.append("from DwEstsalma e");
		q.appendWhere(MapQuery._NULL, "e.omProduto.cdProduto = :cdProduto", cdProduto != null && cdProduto.equals("") == false);
		q.defineParametro("cdProduto", cdProduto);
		return q.list();
	}
	
	public DwEstsalma getDwEstsalmaPorId(long idEstsalma){
		MapQuery q = new MapQuery(session);
		q.append("from DwEstsalma dwestsalma");
		q.append("where dwestsalma.idEstsalma = :id");
		q.defineParametro("id", idEstsalma);
		DwEstsalma retorno = (DwEstsalma) q.uniqueResult();
		return retorno;
	}
	
}
