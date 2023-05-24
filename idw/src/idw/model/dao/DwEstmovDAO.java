package idw.model.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.DwEstMovTemplate;


public class DwEstmovDAO {
	
	private Session session;
	
	public DwEstmovDAO(Session session){
		this.session = session;
	}
	
	public DwEstmov getDwEstmov(OmProduto omProduto, DwEst dwEst, Date dthrMov){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstmov FROM DwEstmov dwEstmov");
		q.append("WHERE dwEstmov.dthrMov = :dthrMov");
		q.append("AND dwEstmov.dwEstpro.omProduto = :omProduto");
		q.append("AND dwEstmov.dwEstpro.dwEst = :dwEst");
		q.defineParametro("dthrMov", dthrMov);
		q.defineParametro("omProduto", omProduto);
		q.defineParametro("dwEst", dwEst);
		q.setMaxResults(1);
		return (DwEstmov) q.uniqueResult();
	}
	
	public List<DwEstmov> getDwEstmovPeriodo(Collection<OmProduto> collectionOmProduto, DwEst dwEst, Date dthrInicio, Date dthrFim){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstmov FROM DwEstmov dwEstmov");
		q.append("INNER JOIN FETCH dwEstmov.dwEstpro dwEstpro");
		q.append("INNER JOIN FETCH dwEstpro.omProduto omProduto");
		q.append("WHERE dwEstmov.dthrMov >= :dthrInicio");
		if(dthrFim != null){
			q.append("and dwEstmov.dthrMov <= :dthrFim");
		}
		q.append("and omProduto IN :listOmProduto");
		q.append("and dwEstmov.dwEstpro.dwEst = :dwEst");
		
		q.defineParametroTimestamp("dthrInicio", dthrInicio);
		if(dthrFim != null){
			q.defineParametroTimestamp("dthrFim", dthrFim);
		}
		
		List<Object> listObjet = new ArrayList<Object>();
		listObjet.addAll(collectionOmProduto);
		
		q.defineListaParametro("listOmProduto",  listObjet);
		q.defineParametro("dwEst", dwEst);
		
		return q.list();
	}
	
	public List<DwEstmov> getDwEstmovPeriodo(OmProduto omProduto, DwEst dwEst, Date dthrInicio, Date dthrFim){
		MapQuery q = new MapQuery(session);
		
		q.append("SELECT dwEstmov FROM DwEstmov dwEstmov");
		q.append("WHERE dwEstmov.dthrMov >= :dthrInicio");
		if(dthrFim != null){
			q.append("and dwEstmov.dthrMov <= :dthrFim");
		}
		q.append("and dwEstmov.dwEstpro.omProduto = :omProduto");
		q.append("and dwEstmov.dwEstpro.dwEst = :dwEst");
		
		q.defineParametroTimestamp("dthrInicio", dthrInicio);
		if(dthrFim != null){
			q.defineParametroTimestamp("dthrFim", dthrFim);
		}
		q.defineParametro("omProduto", omProduto);
		q.defineParametro("dwEst", dwEst);
		
		return q.list();
	}
	
	public List<DwEstmov> getDwEstmovPeriodo(DwEst dwEst, Date dthrInicio, Date dthrFim){
		MapQuery q = new MapQuery(session);
		
		q.append("SELECT dwEstmov FROM DwEstmov dwEstmov");
		q.append("INNER JOIN FETCH dwEstmov.dwEstpro dwEstpro");
		q.append("INNER JOIN FETCH dwEstpro.omProduto omProduto");
		q.append("INNER JOIN FETCH dwEstpro.dwEst dwEst");
		
		q.append("WHERE dwEstmov.dthrMov >= :dthrInicio");
		if(dthrFim != null){
			q.append("and dwEstmov.dthrMov <= :dthrFim");
		}
		q.append("and dwEstmov.dwEstpro.dwEst = :dwEst");
		
		q.defineParametroTimestamp("dthrInicio", dthrInicio);
		if(dthrFim != null){
			q.defineParametroTimestamp("dthrFim", dthrFim);
		}
		q.defineParametro("dwEst", dwEst);
		
		return q.list();
	}
	
	public void apagarMovimentacaoEstoque(DwEstpro dwEstpro, DwEstMovTemplate.TpMov tpMov) {
		MapQuery q = new MapQuery(session);
		q.append("DELETE FROM DwEstmov dwEstmov ");		
		q.append("WHERE dwEstmov.dwEstpro = :dwEstpro ");
		if(tpMov != null){
			q.append(" AND dwEstmov.tpMov = :tpMov");
		}
		q.defineParametro("dwEstpro", dwEstpro);
		if(tpMov != null){
			q.defineParametro("tpMov", tpMov.getId());	
		}
		q.query().executeUpdate();		
	}
	
	public void apagarMovimentacaoEstoque(DwEst dwEst) {
		MapQuery q = new MapQuery(session);
		q.append("delete from DwEstmov dwEstmov");		
		q.append(" where dwEstmov.dwEstpro IN ");
		q.append(" ( SELECT dwEstpro FROM DwEstpro dwEstpro ");
		q.append(" WHERE dwEstpro.dwEst = :dwEst ");
		q.append(" )");
		q.defineParametro("dwEst", dwEst);
		q.query().executeUpdate();		
	}
	
	//consultas auxiliares para a verificar a esclus�o
	
	public List<DwEstmov> getDwEstmovs() {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstmov");
		return q.list();
	}
	
	public List<DwEstpro> getDwEstpros() {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstpro");
		return q.list();
	}
	

	
}