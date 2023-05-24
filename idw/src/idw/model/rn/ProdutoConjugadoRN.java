package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwProdutoconjugado;
import idw.model.pojos.OmProduto;

public class ProdutoConjugadoRN extends AbstractRN<DAOGenerico> {

	public ProdutoConjugadoRN(DAOGenerico dao) {
		super(dao);
	}

	public void apagarApagarProdutosConjugados(OmProduto omProdutoFiltro) {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("DELETE FROM DwProdutoconjugado dwProdutoconjugado");
		
		
		if(omProdutoFiltro != null){
			q.append("where dwProdutoconjugado.omProdutoByIdProdutopai.cdProduto = :cdProduto");
			q.defineParametro("cdProduto", omProdutoFiltro.getCdProduto());
		}
		
		q.query().executeUpdate();		
		
	}

	public List<DwProdutoconjugado> getTodosProdutosConjugados() {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append(" SELECT dwProdutoconjugado FROM DwProdutoconjugado dwProdutoconjugado");
		q.append(" INNER JOIN FETCH dwProdutoconjugado.omProdutoByIdProdutopai");
		q.append(" INNER JOIN FETCH dwProdutoconjugado.omProdutoByIdProdutofilho");
		
		return q.list();
	}
	
	
}
