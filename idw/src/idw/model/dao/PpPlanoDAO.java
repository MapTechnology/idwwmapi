package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.PpNec;
import idw.model.pojos.PpPlano;
import idw.model.pojos.template.PpPlanoTemplate.TpPlano;

public class PpPlanoDAO {
	
	private Session session;
	
	public PpPlanoDAO(Session session) {
		this.session = session;
	}
	
	/**
	* MARCAR OS PLANOS PARA SEREM SIMULADOS NOVAMENTE
	* @param ppNecAntigo
	* @param ppNecNovo
	*/
	public void marcarPlanosParaSeremSimulados(PpNec ppNecAntigo, PpNec ppNecNovo) {
		MapQuery q = new MapQuery(session);
		q.append("UPDATE PpPlano ppplano");
		q.append("SET ppplano.isSimular = :issimular");
		q.append("WHERE ppplano.idPlano IN (");
		q.append("SELECT a.idPlano");
		q.append("FROM PpPlano a");
		q.append("JOIN a.ppPlanecs ppplanec");
		q.append("WHERE ppplanec.ppNec = :ppnec )");
		q.defineParametro("ppnec", ppNecAntigo);
		q.defineParametro("issimular", true);
		q.query().executeUpdate();
		q.novaConsulta();
	}

	public List<PpPlano> getPpPlanosPorStPlano(TpPlano tpPlano) {
		MapQuery q = new MapQuery(session);
		q.append("FROM PpPlano ppplano");
		q.append("WHERE ppplano.stAtivo = :stAtivo");
		q.append("AND ppplano.stPlano = :stPlano");
		q.defineParametro("stAtivo", 1);
		q.defineParametro("stPlano", tpPlano.getId());
		return q.list();
	}
}
