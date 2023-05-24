package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.PpNec;

public class PpPlanecDAO {

	private Session session;
	
	public PpPlanecDAO(Session session) {
		this.session = session;
	}
	
	/**
	* TROCAR O IDNEC ANTIGO PELO NOVO
	* @param ppNecAntigo
	* @param ppNecNovo
	*/
	public void atualizarRefDePpNecEmPpPlanec(PpNec ppNecAntigo, PpNec ppNecNovo) {
		MapQuery q = new MapQuery(session);
		q.append("UPDATE PpPlanec ppplanec");
		q.append("SET ppplanec.ppNec = :ppNecNovo");
		q.append("WHERE ppplanec.ppNec = :ppNecAntigo");
		q.defineParametro("ppNecNovo", ppNecNovo);
		q.defineParametro("ppNecAntigo", ppNecAntigo);
		q.query().executeUpdate();
	}
	
}
