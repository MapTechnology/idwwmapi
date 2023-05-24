package idw.model.rn.exp.injet;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.PpPlano;
import idw.util.IdwLogger;

public abstract class ExportacaoInjetFactory {
	public enum Type{
		OP;
	}

	public abstract void exportar(PpPlano ppplano) throws SemPlanejamentoException ;

	public static ExportacaoInjetFactory getInstance(Type type, IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		switch (type) {
		case OP:
			return new ExportacaoInjetOPRN(log, idLog, identacao, dao, daoInjet);
		}
		return null;
	}
}
