package idw.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpProblemaDAO;
import idw.model.excessoes.RegistroDesconhecidoException;

public class SpProblemaRN extends AbstractRN<DAOGenerico> {



	private final String formatoData;
	private final String formatoDataHora;



	public SpProblemaRN(String formatoData, String formatoDataHora) {
		this(null,  formatoData,  formatoDataHora);
	}

	public SpProblemaRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
		super(dao );
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;	
	}		

	//fa3delproblemacascata
	public long deletarProblemaCascata(int idProblema) throws RegistroDesconhecidoException {
		SpProblemaDAO dao = new SpProblemaDAO(getDaoSession(),  formatoData,  formatoDataHora);

		long id = dao.deletarProblemaCascata(idProblema);
		if (id == 0L) {
			throw new RegistroDesconhecidoException();
		}

		return id;
	}



}
