package idw.model.rn.op;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.rn.AbstractRN;

public class OpSimplesRN extends AbstractRN<DAOGenerico>{

	public OpSimplesRN() {
		super(new DAOGenerico());
	}
	public OpSimplesRN(DAOGenerico dao) {
		super(dao);
	}

	public Integer excluirOPSimples(String nrDoc) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("update PpCp a set a.stAtivo = 0 where a.stAtivo = 1 and exists (from PpCpproduto b where b.ppCp.idCp = a.idCp and b.nrDoc = :doc)");
		q.append("and not exists (from OmPt ompt where ompt.stAtivo=1 and ompt.ppCp.idCp = a.idCp and ompt.isSemop = :is)");
		q.defineParametro("doc", nrDoc);
		q.defineParametro("is", false);
		return q.query().executeUpdate();
	}
}
