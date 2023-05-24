package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.TeTarifas;
import idw.model.pojos.TeTarifasemanal;

public class TeTarifasDAO {
	
	private Session session;
	
	public TeTarifasDAO(Session session) {
		this.session = session;
	}
	
	public TeTarifas getTeTarifasPorId(long idTarifas) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeTarifas tarifa");
		q.append("WHERE tarifa.idTarifas = :idTarifas");
		q.defineParametro("idTarifas", idTarifas);
		return (TeTarifas) q.uniqueResult();
	}

	public List<TeTarifas> getTodasTeTarifas() {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeTarifas tarifa");
		return q.list();
	}	
	
	public TeTarifasemanal getTeTarifasemanalPorId(long idTarifasemanal) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeTarifasemanal semanal");
		q.append("WHERE semanal.idTarifasemanal = :idTarifasemanal");
		q.defineParametro("idTarifasemanal", idTarifasemanal);
		return (TeTarifasemanal) q.uniqueResult();
	}
	
	public List<TeTarifasemanal> getTeTarifasemanal(TeTarifas tarifa) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeTarifasemanal semanal");
		q.append("WHERE semanal.teTarifas.idTarifas = :idTarifas");
		q.defineParametro("idTarifas", tarifa.getIdTarifas());
		return q.list();
	}

}