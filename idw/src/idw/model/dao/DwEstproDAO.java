package idw.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmProduto;
import idw.model.rn.DataHoraRN;

public class DwEstproDAO {
	
	private Session session;
	
	public DwEstproDAO(Session session){
		this.session = session;
	}

	public List<DwEstpro> pesquisarDwEstproByIdProduto(long idProduto){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstpro dwestpro ");
		q.append("WHERE dwestpro.omProduto.idProduto = :idproduto");
		q.defineParametro("idproduto", idProduto);
		return q.list();
	}
	
	public DwEstpro pesquisaUniqueDwEstproByIdProduto(long idProduto){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstpro dwestpro ");
		q.append("WHERE dwestpro.omProduto.idProduto = :idproduto");
		q.defineParametro("idproduto", idProduto);
		return (DwEstpro) q.uniqueResult();
	}
	
	private MapQuery getMapQueryDwEstpro(OmProduto omProduto, DwEst dwEst){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstpro FROM DwEstpro dwEstpro");		
		q.append("WHERE dwEstpro.omProduto = :omProduto");
		q.append("AND dwEstpro.dwEst = :dwEst");
		q.append("ORDER BY dwEstpro.idEstpro");
		q.defineParametro("omProduto", omProduto);
		q.defineParametro("dwEst", dwEst);
		return q;
	}
	
	public List<DwEstpro> getDwEstproList(OmProduto omProduto, DwEst dwEst){
		MapQuery q = getMapQueryDwEstpro(omProduto, dwEst);
		return q.list();
	}
	
	public DwEstpro getDwEstproUnique(OmProduto omProduto, DwEst dwEst){
		MapQuery q = getMapQueryDwEstpro(omProduto, dwEst);
		q.setMaxResults(1);
		return (DwEstpro) q.uniqueResult();
	}
	
	
	public void apagarEstoqueProdutos(DwEst dwEst){
		MapQuery q = new MapQuery(session);
		q.append("DELETE from DwEstpro dwEstpro ");
		q.append("WHERE dwEstpro.dwEst = :dwEst");
		q.defineParametro("dwEst", dwEst);
		q.query().executeUpdate();	
		session.flush();
	}
	
	
	
	public void apagarTodosEstoqueProduto() {
		MapQuery qApagaEst = new MapQuery(session);
		qApagaEst.append("delete from DwEstpro");
		qApagaEst.query().executeUpdate();
	}
	
	public void zerarEstoqueProdutos(DwEst dwEst){
		zerarEstoque(dwEst, null);
	}

	public void zerarEstoqueProduto(DwEst dwEst, OmProduto omProduto){
		zerarEstoque(dwEst, omProduto);
	}
	
	private void zerarEstoque(DwEst dwEst, OmProduto omProduto){
		MapQuery q = new MapQuery(session);
		q.append("UPDATE DwEstpro dwEstpro ");
		q.append(" SET dwEstpro.qtEntrada = :qtEntrada ");
		q.append(" ,dwEstpro.qtSaida = :qtSaida ");
		q.append(" ,dwEstpro.qtAjuste = :qtAjuste ");
		q.append(" ,dwEstpro.qtTotal = :qtTotal ");
		q.append(" ,dwEstpro.qtReservada = :qtReservada ");
		q.append(" ,dwEstpro.dthrAjuste = :dthrAjuste ");
		q.append(" ,dwEstpro.dthrEntrada = :dthrEntrada ");
		q.append(" ,dwEstpro.dthrSaida = :dthrSaida ");
		q.append(" ,dwEstpro.dthrTotal = :dthrTotal ");
		q.append(" WHERE dwEstpro.dwEst = :dwEst ");
		if(omProduto != null){
			q.append(" AND dwEstpro.omProduto = :omProduto ");
		}
		q.defineParametro("dwEst", dwEst);
		if(omProduto != null){
			q.defineParametro("omProduto", omProduto);
		}
		Date dtHrAtual = DataHoraRN.getDataHoraAtual();
		q.defineParametro("qtEntrada", BigDecimal.ZERO);
		q.defineParametro("qtSaida", BigDecimal.ZERO);
		q.defineParametro("qtAjuste", BigDecimal.ZERO);
		q.defineParametro("qtTotal", BigDecimal.ZERO);
		q.defineParametro("qtReservada", BigDecimal.ZERO);
		q.defineParametroTimestamp("dthrEntrada", dtHrAtual);
		q.defineParametroTimestamp("dthrSaida", dtHrAtual);
		q.defineParametroTimestamp("dthrAjuste", dtHrAtual);
		q.defineParametroTimestamp("dthrTotal", dtHrAtual);
		q.query().executeUpdate();
		session.flush();
	}
	
	public List<DwEstpro> getDwEstpros(){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstpro");
		return q.list();
	}
	
	public List<DwEstpro> getEstoquesProdutos(Collection<OmProduto> listProdutos){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstpro FROM DwEstpro dwEstpro");
		q.append("INNER JOIN FETCH dwEstpro.omProduto omProduto");
		q.append("INNER JOIN FETCH dwEstpro.dwEst dwEst");
		q.append("WHERE dwEstpro.omProduto IN :omProdutos");
		q.append("AND dwEstpro.dwEst = :dwEst");
		List<Object> listObjects = new ArrayList<Object>();
		listObjects.addAll(listProdutos);
		q.defineListaParametro("omProdutos", listObjects);
		return q.list();
	}
	
	public List<DwEstpro> getEstoqueProdutos(Collection<OmProduto> listProdutos, DwEst dwEst){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstpro FROM DwEstpro dwEstpro");		
		q.append("WHERE dwEstpro.omProduto IN :omProdutos");
		q.append("AND dwEstpro.dwEst = :dwEst");
		List<Object> listObjects = new ArrayList<Object>();
		listObjects.addAll(listProdutos);
		q.defineListaParametro("omProdutos", listObjects);
		q.defineParametro("dwEst", dwEst);
		return q.list();
	}
	
	public DwEstpro getDwEstproPorId(long idEstpro){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstpro estPro");
		q.append("WHERE estPro.idEstpro = :idEstpro");
		q.defineParametro("idEstpro", idEstpro);
		q.setMaxResults(1);
		return (DwEstpro) q.uniqueResult();
	}
	
}