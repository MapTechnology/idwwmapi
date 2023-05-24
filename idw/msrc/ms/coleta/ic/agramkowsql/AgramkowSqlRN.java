package ms.coleta.ic.agramkowsql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.MapQuery;
import idw.model.dao.agramkow.DAOGenericoAgramkow;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.agramkow.Line;
import idw.model.pojos.agramkow.ResultsHeader;
import injetws.model.excessoes.RegistroDesconhecidoException;
import ms.model.dao.AbstractAgramkowDAO;

public class AgramkowSqlRN extends AbstractAgramkowDAO  {
	
	public static int NUM_DIAS_A_PARTIR_DATA_ATUAL = -7;

	public AgramkowSqlRN(DAOGenericoAgramkow daoAgramkow) {
		Validate.notNull(daoAgramkow);
		
		this.setDaoAgramkow(daoAgramkow);
	}


	// apenas de exemplo/testes
	public Line getLineByLineid(Long paramLineid) throws RegistroDesconhecidoException  {
		MapQuery q = new MapQuery(this.getDaoAgramkow().getSession());

		q.append("SELECT a ");
		q.append("FROM Line a ");
		q.append("where a.id.lineId = :paramLineid ");

		q.defineParametro("paramLineid", paramLineid);

		Line line = (Line) q.uniqueResult();
		
		if (line == null && line.getDescriptor().equals("")) {
			throw new RegistroDesconhecidoException();
		}

		return line;
	}


	public List<ResultsHeader> getResultsHeaderList(Date data, String bc) {
		MapQuery q = new MapQuery(this.getDaoAgramkow().getSession());

		List<ResultsHeader> list = new ArrayList<ResultsHeader>();

		q.append("select t ");
		q.append("from ResultsHeader t ");
		q.append("join fetch t.failcodes fc ");
		q.append("join fetch t.units u ");
		q.append("join fetch t.line lin ");
		q.append("join fetch t.areas a ");
		q.append("join fetch t.devices d ");
		q.append("left join fetch fc.failcodeLanguageses fl  ");
		q.append("where ");
		q.append("t.dateTested >= :data ");
		q.append("and t.status = '0' ");
		//2019 q.append("and fl.id.languageId = 4 ");
		q.append("and t.barcode = :bc ");

		q.defineParametroData("data", data);
		q.defineParametro("bc", bc);
		q.setMaxResults(100);
		
		list =  q.list();
		return list;
	}


	public List<ResultsHeader> getResultsHeaderMRTList(Date data, String bc, String idPtAnterior, String idPtServerAnterior) {
		//MRT = mais recentes testes: lista os mais recentes testes para o BC dado, para pt anterior dado (unit)
		MapQuery q = new MapQuery(this.getDaoAgramkow().getSession());

		List<ResultsHeader> list = new ArrayList<ResultsHeader>();

		q.append("select t ");
		q.append("from ResultsHeader t ");
		q.append("join fetch t.units u ");
		q.append("where ");
		q.append("t.dateTested >= :data ");
		q.append("and t.barcode = :bc ");
		q.append("and u.id.server = :idptserveranterior and u.id.unitId = :idptanterior ");
		q.append("order by t.dateTested desc ");
		
		q.defineParametroData("data", data);
		q.defineParametro("bc", bc);
		q.defineParametro("idptanterior", Long.valueOf(idPtAnterior).longValue());
		q.defineParametro("idptserveranterior", Byte.valueOf(idPtServerAnterior).byteValue());
		q.setMaxResults(100);
		
		list =  q.list();
		return list;
	}
	
}