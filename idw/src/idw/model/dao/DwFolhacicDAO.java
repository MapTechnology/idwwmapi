package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.OmGt;

public class DwFolhacicDAO {
	private final Session session;
	
	public DwFolhacicDAO(Session session){
		this.session = session;
	}
	
	public DwFolhacic getDwFolhacic(DwFolha dwFolha, OmGt omGt){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwFolhacic FROM DwFolhacic dwFolhacic");
		q.append("WHERE dwFolhacic.dwFolha = :dwFolha");
		q.append("AND dwFolhacic.omGt = :omGt");
		q.defineParametro("dwFolha", dwFolha);
		q.setMaxResults(1);
		return (DwFolhacic) q.uniqueResult();
	}

	public DwFolhacic getDwFolhacicPelaFolhaECdPt(DwFolha dwFolha, String cdPt){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwFolhacic FROM DwFolhacic dwFolhacic");
		q.append("WHERE dwFolhacic.dwFolha = :dwFolha");
		q.append("AND dwFolhacic.omPt.cdPt= :cdPt");
		q.defineParametro("dwFolha", dwFolha);
		q.defineParametro("cdPt", cdPt);
		q.setMaxResults(1);		
		return (DwFolhacic) q.uniqueResult();
	}

	public DwFolhacic getDwFolhacicPelaFolhaECdGt(DwFolha dwFolha, String cdGt){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwFolhacic FROM DwFolhacic dwFolhacic");
		q.append("WHERE dwFolhacic.dwFolha = :dwFolha");
		q.append("AND dwFolhacic.omGt.cdGt= :cdGt");
		q.defineParametro("dwFolha", dwFolha);
		q.defineParametro("cdGt", cdGt);
		q.setMaxResults(1);		
		return (DwFolhacic) q.uniqueResult();
	}	

	public DwFolhacic getDwFolhacicPelaFolhaECdGtOuCdPt(DwFolha dwFolha, String codigo){
		DwFolhacic dwFolhacic = getDwFolhacicPelaFolhaECdGt(dwFolha, codigo);
		if(dwFolhacic == null){
			dwFolhacic = getDwFolhacicPelaFolhaECdPt(dwFolha, codigo);
		}
		return dwFolhacic;
	}
	
}
