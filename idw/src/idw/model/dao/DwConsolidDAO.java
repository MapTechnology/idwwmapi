package idw.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.DataHoraRN;

public class DwConsolidDAO {

	private final Session session;

	public DwConsolidDAO(Session session) {
		this.session = session;
	}

	public DwConsolid getUltimoDwConsolid(OmPt omPt, DwConsolidTemplate.TpId tpId) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolid FROM DwConsolid dwConsolid");
		q.append("WHERE dwConsolid.omPt.idPt = :idPt");
		q.append("and dwConsolid.tpId = :tpId");
		q.append("ORDER BY dwConsolid.idConsolid DESC");
		q.defineParametro("idPt", omPt.getIdPt());
		q.defineParametro("tpId", tpId.getValue());
		q.setMaxResults(1);

		return (DwConsolid) q.uniqueResult();

	}

	public DwConsolid getUltimoDwConsolidParada(DwConsolpalog dwConsolpalog, DwConsolidTemplate.TpId tpId) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT dwConsolid FROM DwConsolid dwConsolid");
		q.append("JOIN FETCH dwConsolid.dwConsols dwConsol");
		q.append("JOIN FETCH dwConsol.dwConsolpas dwConsolpa");
		q.append("JOIN FETCH dwConsolpa.dwConsolpaocos dwConsolpaoco");
		q.append("WHERE dwConsolid.omPt.idPt = :idPt");
		q.append("AND dwConsolid.tpId = :tpId");
		q.append("AND dwConsolpaoco.dwConsolpalog = :dwConsolpalog");
		q.append("ORDER BY dwConsolid.idConsolid DESC");
		q.defineParametro("dwConsolpalog", dwConsolpalog);
		q.defineParametro("idPt", dwConsolpalog.getOmPt().getIdPt());
		q.defineParametro("tpId", tpId.getValue());
		q.setMaxResults(1);
		return (DwConsolid) q.uniqueResult();
	}

	/*
	 * FIXME milton - método getProducaoNoMesCorrente deveria filtrar pelo tpId. Verificar se ainda é utilizado
	 *
	 */
	public DwConsolid getProducaoNoMesCorrente(OmProduto omproduto) {
		MapQuery q = new MapQuery(session);
		q.append("select dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("join dwconsolid.dwFolha dwfolha");
		q.append("join dwfolha.dwFolhaiacs dwfolhaiac");
		q.append("where dwconsolid.ano = :ano");
		q.append("and dwconsolid.mes = :mes");
		q.append("and dwfolhaiac.omProduto.idProduto = :omproduto");

		q.defineParametro("ano", DataHoraRN.getApenasAno(DataHoraRN.getDataHoraAtual()));
		q.defineParametro("mes", DataHoraRN.getApenasMes(DataHoraRN.getDataHoraAtual()));
		q.defineParametro("omproduto", omproduto.getIdProduto());

		q.setMaxResults(1);

		return (DwConsolid) q.uniqueResult();
	}

	public List<DwConsolid> getProducaoDaOP(Long idPt, Long idCp, boolean isFetchParadas, boolean isFetchRefugos,
			boolean isFetchUsuarios) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT distinct consolid");
		q.append("FROM DwConsolid consolid");
		q.append("INNER JOIN consolid.omPt ompt");
		q.append("INNER JOIN FETCH consolid.dwConsols consol");
		q.append("INNER JOIN FETCH consolid.ppCp ppCp");
		if (isFetchUsuarios) {
			q.append("LEFT JOIN FETCH consol.dwConsolmos consolmo");
			q.append("LEFT JOIN FETCH consolmo.dwConsolmoocos consolmooco");
			q.append("LEFT JOIN FETCH consolmooco.dwConsolmolog consolmolog");
		}
		if (isFetchParadas) {
			q.append("LEFT JOIN FETCH consol.dwConsolpas consolpa");
			q.append("LEFT JOIN FETCH consolpa.dwConsolpaocos consolpaoco");
			q.append("LEFT JOIN FETCH consolpa.dwTParada tparada");
		}
		if (isFetchRefugos) {
			q.append("LEFT JOIN FETCH consol.dwConsolres consolre");
			q.append("LEFT JOIN FETCH consolre.dwTRefugo trefugo");
		}

		q.append("LEFT JOIN FETCH consol.dwConsolprs consolpr");
		q.append("INNER JOIN FETCH consolpr.omProduto omproduto ");
		q.append("WHERE consolid.tpId = :tpid");
		q.append("AND ompt.idPt = :idpt");
		q.append("AND ppCp.idCp = :idcp");
		q.append("ORDER BY consolid.idConsolid ");

		q.defineParametro("tpid", DwConsolidTemplate.TpId.TURNO.getValue().byteValue());
		q.defineParametro("idpt", idPt);
		q.defineParametro("idcp", idCp);
		return q.list();
	}

	public List<DwConsolid> getListaConsultaEficienciaHoraAHora(Date dtHrInicio, Date dtHrFim, long idPt,
			DwConsolidTemplate.TpId tpId) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT distinct consolid");
		q.append("FROM DwConsolid consolid");
		q.append("INNER JOIN consolid.omPt ompt");
		q.append("INNER JOIN FETCH consolid.dwConsols consol");
		q.append("LEFT JOIN FETCH consol.dwConsolmos consolmo");
		q.append("LEFT JOIN FETCH consolmo.dwConsolmoocos consolmooco");
		q.append("LEFT JOIN FETCH consolmooco.dwConsolmolog consolmolog");
		q.append("LEFT JOIN FETCH consol.dwConsolpas consolpa");
		q.append("LEFT JOIN FETCH consolpa.dwConsolpaocos consolpaoco");
		q.append("LEFT JOIN FETCH consolpa.dwTParada tparada");
		q.append("LEFT JOIN FETCH consol.dwConsolres consolre");
		q.append("LEFT JOIN FETCH consolre.dwTRefugo trefugo");
		q.append("LEFT JOIN FETCH consol.dwConsolprs consolpr");
		q.append("INNER JOIN FETCH consolpr.omProduto omproduto ");
		q.append("WHERE consolid.tpId = :tpid");
		q.append("AND consolid.dthrIhora between :dthrIhora and :dthrFhora");
		q.append("AND ompt.idPt = :idpt");
		q.append("and consolid.stAtivo is null");
		q.append("ORDER BY consolid.idConsolid ");

		q.defineParametro("tpid", (byte) tpId.getValue());
		q.defineParametroTimestamp("dthrIhora", dtHrInicio);
		q.defineParametroTimestamp("dthrFhora", dtHrFim);
		q.defineParametro("idpt", idPt);

		return q.list();
	}

	public List<DwConsolid> getProducaoPorHoraDentroTurnoPorGt(String cdGt, Date dtReferencia, String cdTurno, String nrDoc) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT distinct consolid");
		q.append("FROM DwConsolid consolid");
		q.append("INNER JOIN consolid.omPt ompt");
		q.append("INNER JOIN consolid.ppCp ppCp");
		q.append("INNER JOIN ppCp.ppCpprodutos ppCpproduto");
		q.append("INNER JOIN ompt.omGt omGt");
		q.append("INNER JOIN consolid.dwTurno dwTurno");
		q.append("INNER JOIN FETCH consolid.dwConsols consol");
		q.append("LEFT JOIN FETCH consol.dwConsolmos consolmo");
		q.append("LEFT JOIN FETCH consol.dwConsolprs consolpr");
		q.append("INNER JOIN FETCH consolpr.omProduto omproduto ");
		q.append("WHERE consolid.tpId = :tpid");
		q.append("AND consolid.dtReferencia = :dtReferencia");
		q.append("AND omGt.cdGt = :cdgt");
		q.append("AND dwTurno.cdTurno = :cdTurno");
		q.append("AND ppCpproduto.nrDoc = :nrDoc");
		q.append("AND consolid.stAtivo IS NULL");
		q.append("and ompt.isApongt = :apongt");
		q.append("ORDER BY consolid.idConsolid ");

		q.defineParametro("tpid", (byte) DwConsolidTemplate.TpId.HORA.getValue());
		q.defineParametro("cdgt", cdGt);
		q.defineParametro("nrDoc", nrDoc);
		q.defineParametroData("dtReferencia", dtReferencia);
		q.defineParametro("cdTurno", cdTurno);
		q.defineParametro("apongt", true);

		return q.list();
	}
	
	public List<DwConsol> getOeePizza(String cdProduto, long idGt, Date dtInicio, Date dtfim) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsol");
		q.append("FROM DwConsol dwConsol");
		q.append("INNER JOIN dwConsol.dwConsolid dwConsolid");
		q.append("INNER JOIN dwConsol.dwConsolprs dwConsolpr");
		q.append("INNER JOIN dwConsolpr.omProduto omProduto");
		q.append("INNER JOIN dwConsolid.omPt omPt");
		q.append("INNER JOIN omPt.omGt omGt");
		q.append("INNER JOIN dwConsolid.dwTurno dwTurno");
		q.append("INNER JOIN dwConsolid.dwPepro dwPepro");
		q.append("WHERE dwConsolid.stAtivo IS NULL");
		q.append("AND dwTurno.idTurno <> 1");
		q.append("AND dwConsolid.tpId = 1");
		q.append("AND dwPepro.idPepro = 1");
		q.append("AND omProduto.cdProduto = :cdProduto");
		q.append("AND omProduto.stAtivo = 1");
		q.append("AND dwConsolid.omGt IS NULL");
		q.append("AND omGt.idGt = :idGt");
		q.append("AND dwConsolid.dtReferencia BETWEEN :dtInicio AND :dtfim");

		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("idGt", idGt);
		q.defineParametroData("dtInicio", DataHoraRN.getDataSemHora(dtInicio));
		q.defineParametroData("dtfim", DataHoraRN.getDataSemHora(dtfim));

		return q.list();
	}
	
	public List<DwConsol> getQtCiclosByMaquinaTurnoDataToken(String cdMaquina, long idTurno, Date dt) {
		MapQuery q = new MapQuery(session);
		
		q.append("SELECT b ");
		q.append("from DwConsol b ");
		q.append("where ");
		q.append("b.dwConsolid.idConsolid in ");
		q.append("( ");
		q.append(" select a.idConsolid ");
		q.append(" from DwConsolid a ");
		q.append(" where ");
		q.append(" a.tpId=1 ");
		q.append(" and a.dtReferencia= :dt ");
		q.append(" and ( a.omPt.cdPt= :cdpt and a.omPt.stAtivo=1) ");
		q.append(" and a.dwTurno.idTurno= :idturno ");
		q.append(") ");

		q.defineParametro("cdpt", cdMaquina);
		q.defineParametro("idturno", idTurno);
		q.defineParametroData("dt", DataHoraRN.getDataSemHora(dt));

		return q.list();
	}
	
	
}

