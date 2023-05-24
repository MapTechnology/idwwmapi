package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;

public class OmProcomestDAO {
	
	private Session session;
	
	public OmProcomestDAO(Session session){
		this.session = session;
	}
	
	public List<OmProcomest> getOmProcomestPorProduto(OmProduto omproduto){
		MapQuery q = new MapQuery(session);
		q.append("select omprocomest");
		q.append("from OmProcomest omprocomest");
		q.append("where omprocomest.omProdutoByIdProdutomp = :omproduto");
		q.defineParametro("omproduto", omproduto);
		return q.list();
	}

	public OmProcomest getOmProcomest(OmProduto omprodutoPai, OmProduto omprodutoFilho) {
		MapQuery q = new MapQuery(session);
		
		q.append("select omprocomest");
		q.append("from OmProcomest omprocomest");
		q.append("where omprocomest.omProdutoByIdProdutomp = :omprodutoFilho");
		q.append("and omprocomest.omProdutoByIdProduto = :omproduto");
		q.defineParametro("omprodutoFilho", omprodutoFilho);
		q.defineParametro("omproduto", omprodutoPai);
		q.setMaxResults(1);
		return (OmProcomest) q.uniqueResult();		
	}
}
