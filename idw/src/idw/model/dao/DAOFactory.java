package idw.model.dao;

import org.hibernate.Session;

public final class DAOFactory {
	
	private DAOFactory(){		
	}
	
	public static DwEstDAO getDwEstDAO(Session session){
		return new DwEstDAO(session);
	}

	
}
