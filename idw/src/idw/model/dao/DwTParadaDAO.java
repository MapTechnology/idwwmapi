package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwTParada;

public class DwTParadaDAO {
	
	private Session session;
	
	public DwTParadaDAO(Session session){
		this.session = session;
	}
	
	public DwTParada getDwTParadaPorCdAtivoOrderById(String cdTParada){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTParada t");
		q.append("WHERE t.cdTparada = :cdTparada");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idTparada");
		q.defineParametro("cdTparada", cdTParada);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (DwTParada) q.uniqueResult();
	}

	public List<DwTParada> getDwTParadasAtivas(){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTParada parada");
		q.append("WHERE parada.stAtivo = :stAtivo");
		q.append("ORDER BY parada.cdTparada");
		q.defineParametro("stAtivo", (byte)1);
		return q.list();
	}

	public List<DwTParada> getDwTParadasAtivasPorTppt(long idTppt){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTParada parada");
		q.append("WHERE parada.stAtivo = :stAtivo");
		q.append("AND parada.omTppt.idTppt = :idTppt");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("idTppt", idTppt);
		return q.list();
	}
	
	public List<Object> getDwTParadasDistinctCdDs(){
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT parada.cdTparada, parada.dsTparada");
		q.append("FROM DwTParada parada");
		return q.list();
	}
	
}