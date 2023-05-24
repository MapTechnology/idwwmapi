package idw.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwLogvalroteiro;
import idw.webservices.dto.SerieParettoDTO;

public class DwLogvalroteiroDAO {
	private final Session session;

	public DwLogvalroteiroDAO(Session session) {
		this.session = session;
	}
	
	public List<DwLogvalroteiro> getLogsvalroteiro(String codigoBarras) {
		MapQuery q = new MapQuery(session);

		q.append("SELECT distinct a ");
		q.append("from DwLogvalroteiro a ");
		q.append("JOIN FETCH a.omPt b");
		q.append(" ");
		q.append("WHERE a.cb = :codigoBarras");
		q.append("ORDER BY a.dthrLog DESC");
		
		q.defineParametro("codigoBarras", codigoBarras);
		q.setMaxResults(50);
		List<DwLogvalroteiro> retorno = q.list();
		
		return retorno;
		
	}
	
	


	
	
}
