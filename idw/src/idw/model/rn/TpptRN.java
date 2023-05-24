package idw.model.rn;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmTppt;
import idw.webservices.dto.OmTpptDTO;

public class TpptRN extends AbstractRN<DAOGenerico> {

	public TpptRN() {
		this(null);
	}

	public TpptRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public OmTpptDTO getOmTpptDTO() {
		OmTpptDTO retorno = new OmTpptDTO();
		List<OmTppt> listaOmTppt;
		List<OmTppt> listaOmTpptRetorno = new ArrayList<OmTppt>();

		listaOmTppt = getOmTpPtsAtivos();

		if (listaOmTppt != null) {
			listaOmTpptRetorno.add(0, null);
			for (OmTppt omtppt : listaOmTppt) {
				listaOmTpptRetorno.add(omtppt.clone());
			}
		}
		retorno.setListaOmTppts(listaOmTpptRetorno);
		return retorno;
	}

	public List<OmTppt> getOmTpPtsAtivos() {

		MapQuery query = new MapQuery(getDao().getSession());
		query.append("SELECT omtppt");
		query.append("FROM OmTppt omtppt");
		query.append("WHERE omtppt.stAtivo =1");
		return query.list();

	}

	public OmTppt getOmTpptDTO(OmTppt item) {
		OmTppt retorno = null;

		try {
			retorno = this.getDao().findByCd(item);
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}

		return retorno;
	}

	public OmTppt getOmTpptByCd(String cdtppt) {
		OmTppt retorno = null;

		try {
			OmTppt item = new OmTppt();
			item.setCdTppt(cdtppt);
			retorno = this.getDao().findByCd(item);
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}

		return retorno;
	}
}
