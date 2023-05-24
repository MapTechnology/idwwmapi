package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpCausaDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmUsr;
import idw.model.pojos.SpCausa;
import idw.model.pojos.SpCausads;
import idw.webservices.rest.mfv.dto.CausaEfeitoDTO;

public class SpCausaRN extends AbstractRN<DAOGenerico> {

	public SpCausaRN() {
		this(null);
	}

	public SpCausaRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}


	public SpCausa deletarCausa(int idCausa) throws RegistroDesconhecidoException {
		SpCausaDAO dao = new SpCausaDAO(getDaoSession());

		deletarCausaDs(idCausa);

		SpCausa causa = dao.getCausa(idCausa);
		if (causa == null) {
			throw new RegistroDesconhecidoException();
		}
		this.getDao().delete(causa);
		return causa;
	}

	public List<SpCausads> deletarCausaDs(int idCausa) throws RegistroDesconhecidoException {
		SpCausaDAO dao = new SpCausaDAO(getDaoSession());
		List<SpCausads> listaDses = null;
		listaDses = dao.getCausaDses(idCausa);
		if (listaDses == null) {
			throw new RegistroDesconhecidoException();
		}
		for(SpCausads causaDs : listaDses){
			this.getDao().delete(causaDs);
		}

		return listaDses;
	}


	public long insertCausa(long idCausa,  String texto) throws RegistroDesconhecidoException {
		SpCausaDAO dao = new SpCausaDAO(getDaoSession());
		long id = dao.insertCausa(idCausa,  texto);
		if (id == 0L) {
			throw new RegistroDesconhecidoException();
		}
		return id;
	}	

	//fa3insertupdatecausaefeito
	public CausaEfeitoDTO insertCausaEfeito(
			long idProblema
			, long idCatCausa 
			, long idCausaEfeito
			, long idCausa 
			, String textocausa 
			, long idCausaEfeitoPai
			) throws RegistroDesconhecidoException {
		SpCausaDAO dao = new SpCausaDAO(getDaoSession());
		CausaEfeitoDTO ret = dao.insertCausaEfeito(
				idProblema
				, idCatCausa
				, idCausaEfeito
				, idCausa
				, textocausa			
				, idCausaEfeitoPai
				);
		if (ret == null) {
			throw new RegistroDesconhecidoException();
		}
		return ret;
	}


	//fa3deletecausaefeito
	public long deletarCausaEfeito(long idCausaEfeito, int nivelMaximo)  
			throws RegistroDesconhecidoException {
		SpCausaDAO dao = new SpCausaDAO(getDaoSession());
		long id = dao.deletarCausaEfeito(idCausaEfeito,  nivelMaximo);
		if (id == 0L) {
			throw new RegistroDesconhecidoException();
		}
		return id;		
	}

}
