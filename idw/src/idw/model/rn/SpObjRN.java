package idw.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpObjDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.SpObj;

public class SpObjRN extends AbstractRN<DAOGenerico> {

	public SpObjRN() {
		this(null);
	}

	public SpObjRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public SpObj deletarObjetivo(int idObj) throws RegistroDesconhecidoException {
		SpObjDAO dao = new SpObjDAO(getDaoSession());
		SpObj objetivo = dao.getObjetivo(idObj);
		if (objetivo == null) {
			throw new RegistroDesconhecidoException();
		}
		this.getDao().delete(objetivo);
		return objetivo;
	}


	public long insertObjetivo(long idObj, long idProblema, String texto) throws RegistroDesconhecidoException {
		SpObjDAO dao = new SpObjDAO(getDaoSession());
		long idobjetivo = dao.insertObjetivo(idObj, idProblema, texto);
		if (idobjetivo == 0L) {
			throw new RegistroDesconhecidoException();
		}
		return idobjetivo;
	}

}
