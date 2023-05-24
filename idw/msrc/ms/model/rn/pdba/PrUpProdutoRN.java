package ms.model.rn.pdba;

import java.math.BigDecimal;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpProduto;

public class PrUpProdutoRN {
	DAOGenerico dao;
	
	public PrUpProdutoRN(DAOGenerico dao){
		this.dao = dao;
	}
	
	public PrUpProduto pesquisaProdutoPorIdUp(PrUp prup){
		
	    	MapQuery query = new MapQuery(dao.getSession());
			query.append("select produto ");
			query.append("from PrUpProduto produto ");
			query.append("where produto.prUp.idup = :idup ");
			//query.append("and produto.dreduzidaproduto = :idrdzprod");		
			query.defineParametro("idup",prup.getIdup());
			//query.defineParametro("idrdzprod",idrdzprod);
			query.setMaxResults(1);
			
			PrUpProduto produto = null;
			produto = (PrUpProduto) query.uniqueResult(); 
			//PrUpProduto produto = (PrUpProduto) query.list().get(0);
			
	    	return produto ;
	    	
	}
	
	public List<PrUpProduto> pesquisaListaProdutoPorUp(BigDecimal idup){
		
    	MapQuery query = new MapQuery(dao.getSession());
		query.append("select produto");
		query.append("from PrUpProduto produto");
		query.append("where produto.prUp.idup = :idup");
		
		query.defineParametro("idup",idup);
		
		
		
		List<PrUpProduto> produtos =  query.list(); 
		
    	return produtos ;
    	
   } 
	
}
