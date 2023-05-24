package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmImg;

public class OmImgDAO {
	
	private Session session;
	
	public OmImgDAO(Session session){
		this.session = session;
	}
	
	public OmImg getOmImgPorCdAtivo(String cdImg){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmImg t");
		q.append("WHERE t.cdImg = :cdImg");
		q.append("AND t.stAtivo = 1");
		q.append("ORDER BY t.idImg");
		q.defineParametro("cdImg", cdImg);
		return (OmImg) q.uniqueResult();
	}

	public List<OmImg> getOmImgAtivo(){
		
		MapQuery q = new MapQuery(session);
		
		q.append("FROM OmImg t");
		q.append("WHERE t.stAtivo = 1");
		q.append("ORDER BY t.idImg");
		
		return q.list();
		
	}

}
