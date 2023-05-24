package idw.model.dao;

import idw.model.pojos.SpCatcausa;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

public class SpCatCausaDAO {

	private final MapQuery q;

	public SpCatCausaDAO(Session session) {
		q = new MapQuery(session);
	}

	public List<SpCatcausa> getListaCategorias(int idLingua) {
		q.append("SELECT spCatcausa");
		q.append("FROM SpCatcausa spCatcausa ");
		q.append("LEFT JOIN FETCH spCatcausa.spCatcausadses spCatcausads ");
		q.append("WHERE ");
		q.append(" spCatcausa.stAtivo = :stAtivo");
		q.append("AND spCatcausads.spLingua.idLingua = :idLingua");
		q.append("ORDER BY spCatcausa.cdCatcausa");
		

		q.defineParametro("stAtivo", BigDecimal.ONE);
		q.defineParametro("idLingua", new BigDecimal(idLingua));

		return q.list();
	}

}
