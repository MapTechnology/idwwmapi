package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwDesalimpendcontag;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwEstlocalTemplate;

public class DwDesalimpendcontagDAO {

	private final Session session;
	
	public DwDesalimpendcontagDAO(Session session){
		this.session = session;
	}
	
	public List<DwDesalimpendcontag> getDwDesalimpendcontags(DwEstlocal estLocal, OmPt pt, OmProduto produto){
		
		MapQuery q = new MapQuery(session);
		q.append("SELECT desalim FROM DwDesalimpendcontag desalim");
		q.append("LEFT JOIN FETCH desalim.dwEstlocalpro estlocalpro");
		q.append("LEFT JOIN FETCH estlocalpro.dwEstlocal localEstoque");
		q.append("LEFT JOIN FETCH localEstoque.dwEst estoque");
		q.append("LEFT JOIN FETCH localEstoque.omPt pt");
		q.append("LEFT JOIN FETCH localEstoque.omPa pa");
		q.append("LEFT JOIN FETCH estlocalpro.dwEstpro estpro");
		q.append("LEFT JOIN FETCH estpro.omProduto produto");
		q.append("WHERE 1 = 1 ");
		
		if(produto != null){
			q.append("AND produto.cdProduto = :cdProduto AND produto.stAtivo = 1");
			q.defineParametro("cdProduto", produto.getCdProduto());
		}
		if(pt != null){
			q.append("AND pt.cdPt = :cdPt AND pt.stAtivo = 1");
			q.defineParametro("cdPt", pt.getCdPt());
		}
		if(estLocal != null){
			q.append("AND localEstoque.cdLocal = :cdLocal AND localEstoque.stAtivo = 1");
			q.defineParametro("cdLocal", estLocal.getCdLocal());
		}else{
			q.append("AND localEstoque.tpLocalEstoque = :tpLocalEstoque");
		}

		q.append("ORDER BY desalim.dthrDesalim");
		
		q.defineParametro("tpLocalEstoque", DwEstlocalTemplate.TpLocalEstoque.DESALIMENTACAO.getId());
		
		return q.list();
	}
	
	public void removerProdutoDeDesalimpendcontag(OmProduto omProduto){
		
		MapQuery q = new MapQuery(session);
		q.append("DELETE from DwDesalimpendcontag dwDesalimpendcontag");	
		q.append("WHERE dwDesalimpendcontag.dwEstlocalpro IN (");
		q.append(" 		SELECT dwEstlocalpro FROM DwEstlocalpro dwEstlocalpro");
		q.append(" 			INNER JOIN dwEstlocalpro.dwEstpro dwEstpro ");
		q.append("			WHERE dwEstpro.omProduto = :omProduto");
		q.append("		)");			
		q.defineParametro("omProduto", omProduto);
		q.query().executeUpdate();			
				
	}

}
