package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwMacrange;
import idw.model.pojos.template.DwMacrangeTemplate.TpRegra;
import idw.util.SQLUtils;

public class DwMacrangeDAO {
	
	private Session session;
	
	public DwMacrangeDAO(Session session) {
		this.session = session;
	}
	
	public DwMacrange getMacPorId(Long idMacrange) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT mac");
		q.append("FROM DwMacrange mac");
		q.append("WHERE mac.idMacrange = :idMacrange");
		
		q.defineParametro("idMacrange", idMacrange);
		
		return (DwMacrange) q.uniqueResult();
	}
	
	public List<DwMacrange> getTodos() {
		MapQuery q = new MapQuery(session);
		q.append("SELECT mac");
		q.append("FROM DwMacrange mac");
		q.append("ORDER BY mac.dthrCadastro DESC");
		return q.list();
	}
	
	public List<DwMacrange> getMacPorRegra(TpRegra regra) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT mac");
		q.append("FROM DwMacrange mac");
		q.append("WHERE 1=1");
		q.append("AND mac.tpRegra = :regra");
		q.append("ORDER BY mac.dthrCadastro DESC");
		
		q.defineParametro("regra", regra.getId());
		
		return q.list();
	}
	
	public boolean possuiIntercessaoRangeGlobal(String macInicial, String macFinal) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT mac");
		q.append("FROM DwMacrange mac");
		q.append("WHERE 1=1");
		q.append("AND mac.tpRegra = :regra");
		q.append("AND");
		q.append(SQLUtils.getSQLDentroPeriodoConsiderandoAberto("mac.cdMacInicial", "mac.cdMacFinal", ":inicio", ":fim"));
		q.append("ORDER BY mac.cdMacInicial");
		
		q.defineParametro("regra", TpRegra.LIMITEGLOBAL.getId());
		q.defineParametro("inicio", macInicial);
		q.defineParametro("fim", macFinal);
		
		List<DwMacrange> lista = q.list();

		System.out.println("lista de intercessoes global");
		for(DwMacrange i : lista) {
			System.out.println("   id:"+i.getIdMacrange());
		}
		
		return lista.size() != 0;
	}
	
	public boolean possuiIntercessaoRangePai(Long idMacPai, String macInicial, String macFinal) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT mac");
		q.append("FROM DwMacrange mac");
		q.append("WHERE 1=1");
		q.append("AND mac.dwMacrangepai.idMacrange = :idMacPai");
		q.append("AND");
		q.append(SQLUtils.getSQLDentroPeriodoConsiderandoAberto("mac.cdMacInicial", "mac.cdMacFinal", ":inicio", ":fim"));
		q.append("ORDER BY mac.cdMacInicial");
		
		q.defineParametro("idMacPai", idMacPai);
		q.defineParametro("inicio", macInicial);
		q.defineParametro("fim", macFinal);
		
		List<DwMacrange> lista = q.list();

		System.out.println("lista de intercessoes do mac: " + idMacPai);
		for(DwMacrange i : lista) {
			System.out.println("   id:"+i.getIdMacrange());
		}
		
		return lista.size() != 0;
	}

}
