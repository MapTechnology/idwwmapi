package idw.model.dao;

import org.apache.commons.lang3.Validate;
import org.hibernate.Session;

import idw.model.pojos.DwConsolpt;
import idw.model.pojos.OmPt;

public class DwConsolptDAO {

	private final Session session;
	
	public DwConsolptDAO(Session session){
		this.session = session;
	}
	
	/**
	 * Pega o {@code DwConsolpt}
	 * @param omPt
	 * @return
	 */
	public DwConsolpt getDwConsolpt(OmPt omPt){
		Validate.notNull(omPt, "id do posto de trabalho nao pode ser nulo");
		MapQuery q = new MapQuery(session);

		q.append("SELECT dwConsolpt FROM DwConsolpt dwConsolpt");
		q.append("WHERE dwConsolpt.omPt = :omPt");
		q.append("ORDER BY dwConsolpt.idConsolpt DESC");
		q.defineParametro("omPt", omPt);
		q.setMaxResults(1);

		DwConsolpt dwConsolpt = (DwConsolpt) q.uniqueResult(); 

		return dwConsolpt;
	}

	/**
	 * Pega o {@code DwConsolpt} com base no {@code omPt}
	 * <br> Se não encontrar criar um novo {@DwConsolpt}
	 * @param omPt
	 * @return
	 */
	public DwConsolpt getDwConsolptSeNaoEncontraCria(OmPt omPt){
		Validate.notNull(omPt, "omPt nao pode ser nulo");

		DwConsolpt dwConsolpt = getDwConsolpt(omPt);
		if(dwConsolpt == null){

			dwConsolpt = new DwConsolpt();
			dwConsolpt.setOmPt(omPt);	
			session.saveOrUpdate(dwConsolpt);
		}

		return dwConsolpt;
	}

}
