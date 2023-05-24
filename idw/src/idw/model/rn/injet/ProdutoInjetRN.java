package idw.model.rn.injet;

import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.rn.AbstractRN;


public class ProdutoInjetRN extends AbstractRN<DAOGenericoInjet> {

	public ProdutoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbpro> listaProdutosAtivos(){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbpro ijtbpro ");
		q.appendWhere(MapQuery._NULL, "ijtbpro.cdproduto <> :cdproduto",true);
		q.defineParametro("cdproduto", "99999999999999999999");
		return q.list();
	}

	public Ijtbpro pesquisaIjTbPro(String cdProduto) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbpro ijtbpro ");
		q.appendWhere(MapQuery._NULL, "ijtbpro.cdproduto = :cdproduto", true);
		q.defineParametro("cdproduto", cdProduto);
		List<Object> lista = q.list();
		return (Ijtbpro) lista.get(0);
	}
}
