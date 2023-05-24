package idw.model.rn.injet;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwTurno;
import idw.model.pojos.injet.Ijhortur;
import idw.model.pojos.injet.Ijtbtur;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.rest.dto.TurnoDTO;
import injetws.model.rn.UtilRN;
import ms.util.ConversaoTipos;

public class TurnoInjetRN extends AbstractRN<DAOGenericoInjet> {

	public TurnoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public Ijhortur pesquisarIjhorturNaData(Date data, String cdTurno, String cdDiaSemana) {
		Ijhortur retorno = new Ijhortur();

		// Obtem lista ijcnsturno do filtro
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("from Ijhortur ijhortur ");
		q.append("join fetch ijhortur.ijhorage ");
		q.append(
				"where ijhortur.id.cdturno = :cdturno and ( ( :data between ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda ) or ");
		q.append(" (:data >= ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda is null) ) ");
		q.append("and ijhortur.id.cddiasem = :cddiasemana ");

		q.defineParametro("cdturno", cdTurno);
		q.defineParametro("cddiasemana", cdDiaSemana);
		q.defineParametroData("data", data);

		List<Ijhortur> listaIjhortur = null;

		listaIjhortur = q.list();

		if (listaIjhortur != null && listaIjhortur.size() > 0)
			retorno = listaIjhortur.get(0);

		return retorno;
	}

	public List<Ijhortur> pesquisarListaIjhortur(Date data, String cdDiaSemana) {
		// Obtem lista ijcnsturno do filtro
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("from Ijhortur ijhortur ");
		q.append("join fetch ijhortur.ijhorage ");
		q.append("join fetch ijhortur.ijtbtur ");
		q.append("where ( ( :data between ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda ) or ");
		q.append(" (:data >= ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda is null) ) ");
		q.append("and ijhortur.id.cddiasem = :cddiasemana ");

		q.defineParametro("cddiasemana", cdDiaSemana);
		q.defineParametroTimestamp("data", data);

		List<Ijhortur> listaIjhortur = null;

		try {
			listaIjhortur = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaIjhortur;
	}

	public List<Ijtbtur> getTurnosCombo() {

		MapQuery q = new MapQuery(getDao().getSession());
		q.append("FROM Ijtbtur turno ");
		List<Ijtbtur> listaTurnoCombo = q.list();

		Ijtbtur primeiraOpcao = new Ijtbtur();
		primeiraOpcao.setDsturno("Todos os Turnos");
		listaTurnoCombo.add(0, primeiraOpcao);

		return listaTurnoCombo;
	}

	public List<TurnoDTO> getTurnosInjetParaVF() {
		List<TurnoDTO> turnosDTO = new ArrayList<TurnoDTO>();

		MapQuery q = new MapQuery(getDao().getSession());
		q.append("FROM Ijtbtur turno ORDER BY turno.cdturno");
		List<Ijtbtur> listaTurnos = q.list();

		for (Ijtbtur turnoInjet : listaTurnos) {
			TurnoDTO turno = new TurnoDTO();
			turno.setIdTurno(ConversaoTipos.converteParaBigDecimal(turnoInjet.getCdturno()).longValue());
			turno.setCdTurno(turnoInjet.getCdturno());
			turno.setDsTurno(turnoInjet.getDsturno());

			turnosDTO.add(turno);
		}

		return turnosDTO;
	}

	public TurnoDTO getTurnoInjet(String cdTurno) {
		TurnoDTO turnoDTO = new TurnoDTO();

		MapQuery q = new MapQuery(getDao().getSession());
		q.append("FROM Ijtbtur turno WHERE turno.cdturno = :cdturno");
		q.defineParametro("cdturno", cdTurno);
		List<Ijtbtur> listaTurnos = q.list();

		turnoDTO.setIdTurno(ConversaoTipos.converteParaBigDecimal(listaTurnos.get(0).getCdturno()).longValue());
		turnoDTO.setCdTurno(listaTurnos.get(0).getCdturno());
		turnoDTO.setDsTurno(listaTurnos.get(0).getDsturno());

		return turnoDTO;
	}
	
	public DwTurno getDwTurnoPorIdInjet(long idTurno) {
		DwTurno retorno = new DwTurno();

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("FROM Ijtbtur turno");
		q.append("WHERE turno.cdturno = :idTurno");
		q.defineParametro("idTurno", UtilRN.setZeroEsquerda(((Long) idTurno).toString()));
		Ijtbtur turno = (Ijtbtur) q.uniqueResult();

		retorno.setIdTurno(ConversaoTipos.converteParaBigDecimal(turno.getCdturno()).longValue());
		retorno.setCdTurno(turno.getCdturno());
		retorno.setDsTurno(turno.getDsturno());

		return retorno;
	}

	public TurnoAtualDTO getTurnoAtualDTOPassandoDtTurnoEIdTurno(Date dtReferencia, Long idTurno) throws SemCalendarioException {
		TurnoAtualDTO retorno = new TurnoAtualDTO();
		String cdTurno = UtilRN.setZeroEsquerda(((Long) idTurno).toString());

		try {
			Date dtHrIniTur = FuncoesApoioInjet.calcularInicioTurno(getDao(), dtReferencia, cdTurno);
			Date dtHrFimTur = FuncoesApoioInjet.calcularFimTurno(getDao(), dtReferencia, cdTurno);

			DwTurno dwturno = getDwTurnoPorIdInjet(idTurno);

			retorno.setIdCal(0);
			retorno.setSegPosTolerancia(BigDecimal.ZERO);
			retorno.setSegPreTolerancia(BigDecimal.ZERO);
			retorno.setCdTurno(cdTurno);
			retorno.setDtReferencia(dtReferencia);
			;
			retorno.setDtHrITurno(dtHrIniTur);
			retorno.setDtHrFTurno(dtHrFimTur);
			retorno.setDwturno(dwturno);

		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;
	}

	public List<PeriodoDTO> getIntervalosPeriodo(Date dtIni, Date dtFim, String cdTurno) {
		List<PeriodoDTO> lista = new ArrayList<PeriodoDTO>();

		Date dtRef = dtIni;
		while (dtRef.before(dtFim) || dtRef.equals(dtFim)) {
			TurnoInjetRN rnT = new TurnoInjetRN(getDao());

			List<Ijtbtur> listaTurInj = new ArrayList<Ijtbtur>();
			if (cdTurno == null) {
				listaTurInj = rnT.getTurnosCombo();
			} else {
				DwTurno turVF = rnT.getDwTurnoPorIdInjet(ConversaoTipos.converteParaBigDecimal(cdTurno).longValue());
				Ijtbtur tur = new Ijtbtur();
				tur.setCdturno(turVF.getCdTurno());
				tur.setDsturno(turVF.getDsTurno());
				listaTurInj.add(tur);
			}

			for (Ijtbtur t : listaTurInj) {
				cdTurno = t.getCdturno();

				PeriodoDTO periodo = new PeriodoDTO();
				Date dthrIniTur;
				Date dthrFimTur;

				try {
					dthrIniTur = FuncoesApoioInjet.calcularInicioTurno(getDao(), dtRef, cdTurno);
					dthrFimTur = FuncoesApoioInjet.calcularFimTurno(getDao(), dtRef, cdTurno);

					periodo.setDtHrInicio(dthrIniTur);
					periodo.setDtHrFim(dthrFimTur);
					periodo.setDuracao((long) DataHoraRN.getQuantidadeSegundosNoPeriodo(periodo.getDtHrInicio(), periodo.getDtHrFim()));

					lista.add(periodo);

				} catch (SemCalendarioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			dtRef = DataHoraRN.adicionaDiasDaData(dtRef, 1);
		}

		Collections
				.sort(lista,
						new Comparator<PeriodoDTO>() {
							@Override
							public int compare(
									final PeriodoDTO o1,
									final PeriodoDTO o2) {
								final PeriodoDTO item1 = o1;
								final PeriodoDTO item2 = o2;
								return (item1.getDtHrInicio()).compareTo(item2.getDtHrFim());
							}
						});

		return lista;
	}

	@SuppressWarnings("unchecked")
	public PeriodoDTO getIniFimPeriodo(Date dtIni, Date dtFim, String cdTurno) {
		PeriodoDTO periodo = new PeriodoDTO();

		String strSQL = "";
		strSQL = strSQL.concat("SELECT MIN(ht.dthrini) as dthrini, MAX(ht.dthrfim) as dthrfim ");
		strSQL = strSQL.concat("  FROM ijcnsTurIniFim ht ");
		strSQL = strSQL.concat(" WHERE ht.dtref BETWEEN :dtini AND :dtfim ");

		if (!cdTurno.equals("")) {
			strSQL = strSQL.concat(" AND ht.cdturno = :cdturno ");
		}

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		//q.setTimestamp("dtini", dtIni);
		//q.setTimestamp("dtfim", dtFim);
		
		q.setDate("dtini", dtIni);
		q.setDate("dtfim", dtFim);

		if (!cdTurno.equals("")) {
			q.setString("cdturno", cdTurno);
		}
		
		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		Object reg = lista.get(0);
		Object[] registroLido = null;
		Object registroLidoAux = (Object) reg;
		
		registroLido = (Object[]) registroLidoAux;
		
		periodo.setDtHrInicio((Date) registroLido[0]);
		periodo.setDtHrFim((Date) registroLido[1]);

		return periodo;
	}
	
	
	@SuppressWarnings("unchecked")
	public PeriodoDTO getTurnoAtualColetas() {
		PeriodoDTO periodo = new PeriodoDTO();
		TurnoAtualDTO turnoatualDTO = new TurnoAtualDTO();
		
		String strSQL = "";

		strSQL = strSQL.concat("SELECT ht.dtref , ht.cdturno , ht.dthrini, ht.dthrfim ");
		strSQL = strSQL.concat("  FROM ijcnsTurIniFim ht ");
		strSQL = strSQL.concat("  WHERE ht.dthrini = (SELECT max(ht2.dthrini) as dthrini FROM ijcnsTurIniFim ht2) ");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		
		List<Object> lista = new ArrayList<Object>();
		lista = q.list();
		
		if (lista!=null && lista.size()>0){
			
			Object reg = lista.get(0);
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			
			registroLido = (Object[]) registroLidoAux;
			
			turnoatualDTO.setDtReferencia((Date) registroLido[0]);
			turnoatualDTO.setCdTurno((String) registroLido[1]);
			turnoatualDTO.setDtHrITurno((Timestamp) registroLido[2]);
			turnoatualDTO.setDtHrFTurno((Timestamp) registroLido[3]);
			
			periodo.setDtHrInicio((Timestamp) registroLido[2]);
			periodo.setDtHrFim((Timestamp) registroLido[3]);
			periodo.setTurnoAtualDTO(turnoatualDTO);
			
			
		}


		return periodo;
	}
	
	
}
