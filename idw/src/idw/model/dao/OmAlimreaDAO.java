package idw.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmAlimrea;
import idw.model.pojos.template.OmAlimreaTemplate;
import idw.model.rn.DataHoraRN;

public class OmAlimreaDAO {
	
	private Session session;
	
	public OmAlimreaDAO(Session session){
		this.session = session;
	}

	public List<OmAlimrea> getOmAlimreaPorIdAlim(Long idAlimCorrente){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmAlimrea omalimrea ");
		q.append("WHERE omalimrea.omAlim.idAlim =:idalim ");
		q.append("ORDER BY omalimrea.idAlimrea ");
		q.defineParametro("idalim", idAlimCorrente);
		return q.list();
	}

	public List<OmAlimrea> getOmAlimreaPorIdAlim(Long idAlimCorrente, boolean isApenasRealimentacao, Date dtHrInicioLeitura, Date dtHrFimLeitura){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmAlimrea omalimrea ");
		q.append("WHERE omalimrea.omAlim.idAlim =:idalim ");
		
		if (isApenasRealimentacao) {
			q.append(" AND omalimrea.tpLeitura = :tpLeitura");
		}
		
		boolean isFiltroDatas = (dtHrInicioLeitura != null && dtHrFimLeitura != null);
		if (isFiltroDatas) {
			q.append("AND omalimrea.dthrLeitura BETWEEN :inicio AND :fim");
		}		
		
		q.append("ORDER BY omalimrea.idAlimrea ");
		q.defineParametro("idalim", idAlimCorrente);
		if (isApenasRealimentacao) {		
			q.defineParametro("tpLeitura", OmAlimreaTemplate.TpLeitura.REALIMENTACAO.getId());			
		}
		if (isFiltroDatas) {
			q.defineParametroData("inicio", DataHoraRN.getDataSemHora(dtHrInicioLeitura));
			q.defineParametroData("fim", DataHoraRN.adicionaDiasDaData(dtHrFimLeitura, 1));
		}
		return q.list();
	}
	
}