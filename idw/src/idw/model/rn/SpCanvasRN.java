package idw.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpCanvasDAO;
import idw.model.excessoes.RegistroDesconhecidoException;

public class SpCanvasRN extends AbstractRN<DAOGenerico> {



	private final String formatoData;
	private final String formatoDataHora;



	public SpCanvasRN(String formatoData, String formatoDataHora) {
		this(null,  formatoData,  formatoDataHora);
	}

	public SpCanvasRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
		super(dao );
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;	
	}		

	//fa3dela3cascata
	public long deletarA3Cascata(int idSp) throws RegistroDesconhecidoException {
		SpCanvasDAO dao = new SpCanvasDAO(getDaoSession(),  formatoData,  formatoDataHora);

		long id = dao.deletarA3Cascata(idSp);
		if (id == 0L) {
			throw new RegistroDesconhecidoException();
		}

		return id;
	}



}
