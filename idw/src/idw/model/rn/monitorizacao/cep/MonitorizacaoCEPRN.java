package idw.model.rn.monitorizacao.cep;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.mapping.Array;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

//import com.sun.jmx.snmp.Timestamp;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmedparamlog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamedtemhor;
import idw.model.pojos.DwFolhamedtemp;
import idw.model.pojos.DwFolhamedtemphorcfg;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwFolhaTemplate;
import idw.model.pojos.template.DwFtParamTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.monitorizacao.injet.DetalheMonitorizacaoPTInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebCepInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.webservices.dto.CEPFolhaDTO;
import idw.webservices.dto.CEPFolhasDTO;
import idw.webservices.dto.CEPParametroDTO;
import idw.webservices.dto.CicloDTO;
import idw.webservices.dto.CiclosDTO;
import idw.webservices.dto.ConstanteCartaControleDTO;
import idw.webservices.dto.DetalhamentoParadaDTO;
import idw.webservices.dto.DetalheCEPDTO;
import idw.webservices.dto.DetalheMonitorizacaoCEPDTO;
import idw.webservices.dto.DetalheMonitorizacaoCEPOcorrDTO;
import idw.webservices.dto.DetalheParadaDTO;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FolhaCEPDTO;
import idw.webservices.dto.GraficoCEPDTO;
import idw.webservices.dto.GraficoCEPDetParamDTO;
import idw.webservices.dto.GraficoCEPPeriodoDTO;
import idw.webservices.dto.IndicadoresEstatisticosCEPDTO;
import idw.webservices.dto.ListaDetalheMonitorizacaoCEPDTO;
import idw.webservices.dto.ListaFolhaCEPDTO;
import idw.webservices.dto.ListaParametrosCEPDTO;
import idw.webservices.dto.ParametroCEPDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.RelatorioGraficoCEPDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepValoresDTO;
import idw.webservices.rest.injet.BiResource;
import ms.util.ConversaoTipos;

public class MonitorizacaoCEPRN extends AbstractRN<DAOGenerico> {

	private static final byte REFERENCIA_TEMPO_TOTAL = 0;
	private static final byte REFERENCIA_TEMPO_TRABALHADO = 1;
	private static final byte REFERENCIA_TEMPO_PARADA_COM_PESO = 2;
	private static final byte REFERENCIA_TEMPO_PARADA_SEM_PESO = 3;
	private static final byte REFERENCIA_TEMPO_CICLOS = 4; // essa consolidaçãoo
															// não existe

	private static final byte GRAFICO_CNC_POR_HORA = 1;
	private static final byte GRAFICO_CNC_POR_DATA_TURNO = 2;
	private static final byte GRAFICO_CNC_POR_DATA = 3;
	private static final byte GRAFICO_CNC_RESUMO = 4;
	

	private byte _graf_zona = 0;
	private byte _graf_zona_hora_dthrini = 1;
	private byte _graf_zona_hora_dthrfim = 2;

	private byte _graf_zona_data_turno_data = 1;
	private byte _graf_zona_data_turno_cdturno = 2;
	private byte _graf_zona_data_turno_dsturno = 3;

	private byte _graf_zona_data_data = 1;
	
	
	private byte _graf_hora_dthrini = 0;
	private byte _graf_hora_dthrfim = 1;

	private byte _graf_data_turno_data = 0;
	private byte _graf_data_turno_cdturno = 1;
	private byte _graf_data_turno_dsturno = 2;

	private byte _graf_data_data = 0;

	private byte _graf_tpReferencia = 0;
	private byte _graf_idFolha = 1;
	private byte _graf_cdFtgrupo = 2;
	private byte _graf_dsFtgrupo = 3;
	private byte _graf_idFtParam = 4;
	private byte _graf_dsParametro = 5;
	private byte _graf_vlMinimo = 6;
	private byte _graf_vlMedio = 7;
	private byte _graf_vlMaximo = 8;
	private byte _graf_vlSomado = 9;
	private byte _graf_qtMedicoes = 10;
	private byte _graf_vlMonetario = 11;
	private byte _graf_vlUltimo = 12;

	private static final byte _folha_idfolha = 0;
	private static final byte _folha_idftparam = 1;
	private static final byte _folha_idpt = 2;

	private static final byte LIMITE_CRITICO_INFERIOR = 1;
	private static final byte LIMITE_ACEITAVEL_INFERIOR = 2;
	private static final byte LIMITE_IDEAL = 3;
	private static final byte LIMITE_ACEITAVEL_SUPERIOR = 4;
	private static final byte LIMITE_CRITICO_SUPERIOR = 5;

	private static final byte _tpReferencia = 0;
	private static final byte _idFolha = 1;	//parece não usado . por isso que o cdFtgrupo seguinte utiliza o mesmo 1
	private static final byte _cdFtgrupo = 1;
	private static final byte _dsFtgrupo = 2; 
	private static final byte _idFtParam = 3;
	private static final byte _dsParametro = 4;
	private static final byte _vlMinimo = 5;
	private static final byte _vlMedio = 6;
	private static final byte _vlMaximo = 7;
	private static final byte _vlSomado = 8;
	private static final byte _qtMedicoes = 9;
	private static final byte _vlMonetario = 10;
	private static final byte _vlUltimo = 11;

	public MonitorizacaoCEPRN() {
		this(null);
	}

	public MonitorizacaoCEPRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public ListaParametrosCEPDTO getListaParametrosCEP(Boolean incluirItemTODOS) {
		final Byte _idFtParam = 0;
		final Byte _dsParametro = 1;

		ListaParametrosCEPDTO retorno = new ListaParametrosCEPDTO();
		ParametroCEPDTO itemLista;

		retorno.setParametrosCEP(new ArrayList<ParametroCEPDTO>());

		if (incluirItemTODOS) {
			itemLista = new ParametroCEPDTO();
			itemLista.setIdFtParam(0l);
			itemLista.setDsParametro("TODOS");
			retorno.getParametrosCEP().add(itemLista);
		}

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT a.idFtParam, a.dsParametro");
		q.append("  FROM DwFtParam a");
		q.append(" ORDER BY a.idFtParam");
		List<Object> lista = q.list();
		for (Object reg : lista) {
			Object[] registro = (Object[]) reg;

			itemLista = new ParametroCEPDTO();
			itemLista.setIdFtParam((Long) registro[_idFtParam]);
			itemLista.setDsParametro(registro[_dsParametro].toString());
			retorno.getParametrosCEP().add(itemLista);
		}

		return retorno;
	}

	public DetalheCEPDTO getDetalheCEPGraf(Byte quebraPeriodo,
			DwConsolidDTOs listaDwconsolid,
			ListaParametrosCEPDTO listaParametros) {
		String hql_agrupamento = "";
		byte _somar = 0;

		DetalheCEPDTO retorno = new DetalheCEPDTO();
		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();
		DetalheMonitorizacaoCEPDTO itemLista = new DetalheMonitorizacaoCEPDTO();

		List<Object> listaIdConsolId = new ArrayList<Object>();
		List<Object> listaParametrosId = new ArrayList<Object>();

		// monta lista de idconsolid
		for (DwConsolidDTO dwci : listaDwconsolid.getListaDwConsolidDTO()) {
			listaIdConsolId.add(dwci.getDwConsolid().getIdConsolid());
		}
		// lista de parametros CNC
		for (ParametroCEPDTO paramCEP : listaParametros.getParametrosCEP()) {
			listaParametrosId.add(paramCEP.getIdFtParam());
		}

		// recuperar todos os diferentes conjuntos formados por idfolha +
		// idftparam
		retorno.setListaFolhasCEP(new ListaFolhaCEPDTO());
		retorno.getListaFolhasCEP()
				.setListaFolhas(new ArrayList<FolhaCEPDTO>());

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT e.dwFolha.idFolha, b.idFtParam, e.omPt.idPt ");
		q.append("  FROM DwConsolParam a ");
		q.append("  JOIN a.dwFtParam b ");
		q.append("  JOIN b.dwFtGrupo c ");
		q.append("  JOIN a.dwConsol d ");
		q.append("  JOIN d.dwConsolid e ");
		q.append(" WHERE b.idFtParam  IN (:listaParametrosId) ");
		q.append("   AND e.idConsolid IN (:listaIdConsolId) ");
		q.append(" GROUP BY e.dwFolha.idFolha, b.idFtParam ");
		q.defineListaParametro("listaParametrosId", listaParametrosId);
		q.defineListaParametro("listaIdConsolId", listaIdConsolId);

		List<Object> listaFolha = q.list();
		for (Object regFolha : listaFolha) {
			Object[] registroFolha = (Object[]) regFolha;
			OmPt ompt = new OmPt();
			ompt.setIdPt((Long)registroFolha[_folha_idpt]);

			folhaCEP = getFolhasCEP(ompt, (Long) registroFolha[_folha_idftparam]);

			// recuperar resumo do período do conjunto folha + param
			switch (quebraPeriodo) {
			case GRAFICO_CNC_POR_HORA:
				hql_agrupamento = " e.dthrIhora, e.dthrFhora,";
				_somar = 2;
				break;

			case GRAFICO_CNC_POR_DATA_TURNO:
				hql_agrupamento = " e.dtReferencia, e.dwTurno.cdTurno, e.dwTurno.dsTurno, ";
				_somar = 3;
				break;
			case GRAFICO_CNC_POR_DATA:
				hql_agrupamento = " e.dtReferencia,";
				_somar = 1;
				break;
			}

			_graf_tpReferencia = (byte) (_tpReferencia + _somar);
			_graf_idFolha = (byte) (_idFolha + _somar);
			_graf_cdFtgrupo = (byte) (_cdFtgrupo + _somar);
			_graf_dsFtgrupo = (byte) (_dsFtgrupo + _somar);
			_graf_idFtParam = (byte) (_idFtParam + _somar);
			_graf_dsParametro = (byte) (_dsParametro + _somar);
			_graf_vlMinimo = (byte) (_vlMinimo + _somar);
			_graf_vlMedio = (byte) (_vlMedio + _somar);
			_graf_vlMaximo = (byte) (_vlMaximo + _somar);
			_graf_vlSomado = (byte) (_vlSomado + _somar);
			_graf_qtMedicoes = (byte) (_qtMedicoes + _somar);
			_graf_vlMonetario = (byte) (_vlMonetario + _somar);

			MapQuery qDet = new MapQuery(getDaoSession());
			qDet.append("SELECT "
					+ hql_agrupamento
					+ " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro,");
			qDet.append("       MIN(a.vlMinimo) as vlMinimo, ");
			qDet.append("       AVG(a.vlMedio) as vlMedio, ");
			qDet.append("       MAX(a.vlMaximo) as vlMaximo, ");
			qDet.append("       SUM(a.vlSomado) as vlSomado, ");
			qDet.append("       SUM(a.qtMedicoes) as qtMedicoes, ");
			qDet.append("       SUM(a.vlMonetario) as vlMonetario ");
			qDet.append("  FROM DwConsolParam a");
			qDet.append("  JOIN a.dwFtParam b ");
			qDet.append("  JOIN b.dwFtGrupo c ");
			qDet.append("  JOIN a.dwConsol d ");
			qDet.append("  JOIN d.dwConsolid e ");
			qDet.append("  WHERE e.dwFolha.idFolha = :idFolha ");
			qDet.append("    AND b.idFtParam  = :idFtParam ");
			qDet.append("    AND e.idConsolid IN (:listaIdConsolId) ");
			qDet.append("  GROUP BY "
					+ hql_agrupamento
					+ " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro");

			qDet.defineParametro("idFolha", folhaCEP.getIdFolha());
			qDet.defineParametro("idFtParam", folhaCEP.getIdFtParam());
			qDet.defineListaParametro("listaIdConsolId", listaIdConsolId);
			qDet.setMaxResults(30);

			List<Object> lista = qDet.list();

			for (Object reg : lista) {
				Object[] registro = (Object[]) reg;
				itemLista = new DetalheMonitorizacaoCEPDTO();

				switch (quebraPeriodo) {
				case GRAFICO_CNC_POR_HORA:
					itemLista.setDthrIni((Date) registro[_graf_hora_dthrini]);
					itemLista.setDthrFim((Date) registro[_graf_hora_dthrfim]);
					break;

				case GRAFICO_CNC_POR_DATA_TURNO:
					itemLista
							.setDtTurno((Date) registro[_graf_data_turno_data]);
					itemLista.setCdTurno(registro[_graf_data_turno_cdturno]
							.toString());
					break;

				case GRAFICO_CNC_POR_DATA:
					itemLista.setDtTurno((Date) registro[_graf_data_data]);
					break;
				}
				itemLista.setTpReferencia((Byte) registro[_graf_tpReferencia]);
				itemLista.setCdFtGrupo(registro[_graf_cdFtgrupo].toString());
				itemLista.setDsFtGrupo(registro[_graf_dsFtgrupo].toString());
				itemLista.setIdFtParam((Long) registro[_graf_idFtParam]);
				itemLista.setDsParamentro(registro[_graf_dsParametro]
						.toString());
				itemLista.setVlMinimo(ConversaoTipos
						.converterParaBigDecimal(registro[_graf_vlMinimo]));
				itemLista.setVlMedio(ConversaoTipos
						.converterParaBigDecimal(registro[_graf_vlMedio]));
				itemLista.setVlMaximo(ConversaoTipos
						.converterParaBigDecimal(registro[_graf_vlMaximo]));
				itemLista.setVlSomado(ConversaoTipos
						.converterParaBigDecimal(registro[_graf_vlSomado]));
				itemLista.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(
						registro[_graf_qtMedicoes]).intValue());
				itemLista
						.setVlMonetario(ConversaoTipos
								.converterParaBigDecimal((registro[_graf_vlMonetario] == null ? 0
										: registro[_graf_vlMonetario])));
				itemLista.setListaOcorrencias(getListaOcorrenciasCEP(
						itemLista.getTpReferencia(), folhaCEP.getIdFtParam(),
						folhaCEP.getIdFolha(), listaIdConsolId));
				itemLista
						.setFolhaCEPSemListas(getCopiaFolhaSemDetalhamento(folhaCEP));

				folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP()
						.add(itemLista);
			}

			// folhaCEP.setIndicadoresCEP(getIndicadoresEstatisticosCEP(folhaCEP,
			// 1));
			retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
		}

		return retorno;
	}

	private FolhaCEPDTO getCopiaFolhaSemDetalhamento(FolhaCEPDTO folhaOrigem) {
		FolhaCEPDTO folha = new FolhaCEPDTO();

		folha.setIdFolha(folhaOrigem.getIdFolha());
		folha.setCdFolha(folhaOrigem.getCdFolha());
		folha.setRevisao(folhaOrigem.getRevisao());
		folha.setIdFtParam(folhaOrigem.getIdFtParam());
		folha.setLimCriticoInf(folhaOrigem.getLimCriticoInf());
		folha.setLimAceitavelInfIni(folhaOrigem.getLimAceitavelInfIni());
		folha.setLimAceitavelInfFim(folhaOrigem.getLimAceitavelInfFim());
		folha.setLimIdealIni(folhaOrigem.getLimIdealIni());
		folha.setLimIdealFim(folhaOrigem.getLimIdealFim());
		folha.setLimAceitavelSupIni(folhaOrigem.getLimAceitavelSupIni());
		folha.setLimAceitavelSupFim(folhaOrigem.getLimAceitavelSupFim());
		folha.setLimCriticoSup(folhaOrigem.getLimCriticoSup());
		folha.setTemMinimo(folhaOrigem.getTemMinimo());
		folha.setTemMeta(folhaOrigem.getTemMeta());
		folha.setTemMaximo(folhaOrigem.getTemMaximo());
		return folha;
	}

	public DetalheCEPDTO getDetalheCEP(DwConsolidDTOs listaDwconsolid, ListaParametrosCEPDTO listaParametros) {
		DetalheCEPDTO retorno = new DetalheCEPDTO();
		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();

		DetalheMonitorizacaoCEPDTO itemLista = new DetalheMonitorizacaoCEPDTO();

		List<Object> listaIdConsolId = new ArrayList<Object>();
		List<Object> listaParametrosId = new ArrayList<Object>();
		List<Object> listaOmpt = new ArrayList<>();
		
		// monta lista de idconsolid
		for (DwConsolidDTO dwci : listaDwconsolid.getListaDwConsolidDTO()) {
			listaIdConsolId.add(dwci.getDwConsolid().getIdConsolid());
			if (listaOmpt.contains(dwci.getDwConsolid().getOmPt()) == false)
				listaOmpt.add(dwci.getDwConsolid().getOmPt());
		}

		for (ParametroCEPDTO paramCEP : listaParametros.getParametrosCEP()) {
			listaParametrosId.add(paramCEP.getIdFtParam());
		}

		// recuperar todos os diferentes conjuntos formados por idfolha +
		// idftparam
		retorno.setListaFolhasCEP(new ListaFolhaCEPDTO());
		retorno.getListaFolhasCEP()
				.setListaFolhas(new ArrayList<FolhaCEPDTO>());

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT e.dwFolha.idFolha, b.idFtParam, e.omPt.idPt ");
		q.append("  FROM DwConsolParam a ");
		q.append("  JOIN a.dwFtParam b ");
		q.append("  JOIN b.dwFtGrupo c ");
		q.append("  JOIN a.dwConsol d ");
		q.append("  JOIN d.dwConsolid e ");
		q.append(" join e.omPt f");
		q.append(" WHERE b.idFtParam  IN (:listaParametrosId) ");
		q.append("   AND f IN (:listaompt) ");
		q.append(" GROUP BY  e.dwFolha.idFolha, b.idFtParam ");

		q.defineListaParametro("listaParametrosId", listaParametrosId);
		q.defineListaParametro("listaompt", listaOmpt);
		List<Object> listaFolha = q.list();
		for (Object regFolha : listaFolha) {
			Object[] registroFolha = (Object[]) regFolha;
			OmPt ompt = new OmPt();
			ompt.setIdPt((Long) registroFolha[_folha_idpt]);
			folhaCEP = getFolhasCEP(ompt, (Long) registroFolha[_folha_idftparam]);

			MapQuery qDet = new MapQuery(getDaoSession());
			qDet.append("SELECT a.tpReferencia, e.dwFolha.idFolha, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro,");
			qDet.append("       MIN(a.vlMinimo) as vlMinimo, ");
			qDet.append("       AVG(a.vlMedio) as vlMedio, ");
			qDet.append("       MAX(a.vlMaximo) as vlMaximo, ");
			qDet.append("       SUM(a.vlSomado) as vlSomado, ");
			qDet.append("       SUM(a.qtMedicoes) as qtMedicoes, ");
			qDet.append("       SUM(a.vlMonetario) as vlMonetario ");
			qDet.append("  FROM DwConsolParam a");
			qDet.append("  JOIN a.dwFtParam b ");
			qDet.append("  JOIN b.dwFtGrupo c ");
			qDet.append("  JOIN a.dwConsol d ");
			qDet.append("  JOIN d.dwConsolid e ");
			qDet.append("  WHERE e.dwFolha.idFolha = :idFolha ");
			qDet.append("    AND b.idFtParam  = :idFtParam ");
			qDet.append("    AND e.idConsolid IN (:listaIdConsolId) ");
			qDet.append("  GROUP BY a.tpReferencia, e.dwFolha.idFolha, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro");

			qDet.defineParametro("idFolha", folhaCEP.getIdFolha());
			qDet.defineParametro("idFtParam", folhaCEP.getIdFtParam());
			qDet.defineListaParametro("listaIdConsolId", listaIdConsolId);

			List<Object> lista = qDet.list();

			for (Object reg : lista) {
				Object[] registro = (Object[]) reg;

				itemLista = new DetalheMonitorizacaoCEPDTO();
				itemLista.setTpReferencia((Byte) registro[_tpReferencia]);
				itemLista.setCdFtGrupo(registro[_cdFtgrupo].toString());
				itemLista.setDsFtGrupo(registro[_dsFtgrupo].toString());
				itemLista.setIdFtParam((Long) registro[_idFtParam]);
				itemLista.setDsParamentro(registro[_dsParametro].toString());

				itemLista.setVlMinimo(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMinimo]));
				itemLista.setVlMedio(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMedio]));
				itemLista.setVlMaximo(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMaximo]));
				itemLista.setVlSomado(ConversaoTipos
						.converterParaBigDecimal(registro[_vlSomado]));
				itemLista.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(
						registro[_qtMedicoes]).intValue());
				itemLista
						.setVlMonetario(ConversaoTipos
								.converterParaBigDecimal((registro[_vlMonetario] == null ? 0
										: registro[_vlMonetario])));

				itemLista.setListaOcorrencias(getListaOcorrenciasCEP(
						itemLista.getTpReferencia(), folhaCEP.getIdFtParam(),
						folhaCEP.getIdFolha(), listaIdConsolId));
				itemLista
						.setFolhaCEPSemListas(getCopiaFolhaSemDetalhamento(folhaCEP));

				folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP()
						.add(itemLista);
			}

			retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
		}

		return retorno;
	}

	public DetalheCEPDTO getDetalheParadasCEP(
			DetalhamentoParadaDTO detParadaDTO,
			ListaParametrosCEPDTO listaParametros) {
		MapQuery q;

		DetalheCEPDTO retorno = new DetalheCEPDTO();
		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();
		DetalheMonitorizacaoCEPDTO itemLista = new DetalheMonitorizacaoCEPDTO();
		List<Object> listaIdConsolPaOco = new ArrayList<Object>();
		List<Object> listaParametrosId = new ArrayList<Object>();

		for (ParametroCEPDTO paramCEP : listaParametros.getParametrosCEP()) {
			listaParametrosId.add(paramCEP.getIdFtParam());
		}

		// recuperar id das ocorrencias de parada
		if (detParadaDTO != null && detParadaDTO.getListaparadas() != null) {
			for (DetalheParadaDTO detPar : detParadaDTO.getListaparadas()) {
				String cdPt = detPar.getMaquina();
				Integer posSeparador = cdPt.indexOf(" -");
				if (posSeparador > 0) {
					cdPt = cdPt.substring(0, posSeparador);
				}

				q = new MapQuery(getDaoSession());
				q.append("SELECT DISTINCT c.idConsolpaoco ");
				q.append("  FROM DwConsolpaParam a ");
				q.append("  JOIN a.dwConsolpa b ");
				q.append("  JOIN b.dwConsolpaocos c ");
				q.append(" WHERE b.dwConsol.dwConsolid.omPt.cdPt = :cdPt ");
				q.append("   AND c.dthrIparada = :dthrIniPar");

				q.defineParametro("cdPt", cdPt);
				q.defineParametroTimestamp("dthrIniPar", detPar.getInicio());
				// Alessandre em 3-7-15 o hql acima retornou mais de uma linha,
				// entao comentei o trecho abaixo e substitui pelo seguinte
				// Long idConsolpaoco = (Long) q.uniqueResult();
				// listaIdConsolPaOco.add(idConsolpaoco);
				List<Long> lista = q.list();
				listaIdConsolPaOco.addAll(lista);
			}
		}

		// recuperar todos os diferentes conjuntos formados por idfolha +
		// idftparam
		retorno.setListaFolhasCEP(new ListaFolhaCEPDTO());
		retorno.getListaFolhasCEP()
				.setListaFolhas(new ArrayList<FolhaCEPDTO>());

		q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT a.dwConsolpa.dwConsol.dwConsolid.dwFolha.idFolha, b.dwConsolParam.dwFtParam.idFtParam,  a.dwConsolpa.dwConsol.dwConsolid.omPt.idPt");
		q.append("  FROM DwConsolpaoco a ");
		q.append("  JOIN a.dwConsolParammeds b ");
		q.append("  JOIN b.dwConsolmedparamlog c ");
		q.append(" WHERE a.idConsolpaoco IN (:listaIdConsolPaOco)");
		q.append("   AND b.dwConsolParam.dwFtParam.idFtParam IN (:listaParametrosId) ");

		q.defineListaParametro("listaIdConsolPaOco", listaIdConsolPaOco);
		q.defineListaParametro("listaParametrosId", listaParametrosId);

		List<Object> listaFolha = q.list();
		for (Object regFolha : listaFolha) {
			Object[] registroFolha = (Object[]) regFolha;
			OmPt ompt = new OmPt();
			ompt.setIdPt((Long) registroFolha[_folha_idpt]); 
			folhaCEP = getFolhasCEP(ompt, (Long) registroFolha[_folha_idftparam]);

			MapQuery qDet = new MapQuery(getDaoSession());

			qDet.append("SELECT a.dwConsolpa.dwTParada.isPesa as tpReferencia, a.dwConsolpa.dwConsol.dwConsolid.dwFolha.idFolha, ");
			qDet.append("       b.dwConsolParam.dwFtParam.dwFtGrupo.cdFtgrupo, b.dwConsolParam.dwFtParam.dwFtGrupo.dsFtgrupo, ");
			qDet.append("       b.dwConsolParam.dwFtParam.idFtParam, b.dwConsolParam.dwFtParam.dsParametro, ");
			qDet.append("       MIN(c.vlrLido) as vlMinimo,");
			qDet.append("       AVG(c.vlrLido) as vlMedio, ");
			qDet.append("       MAX(c.vlrLido) as vlMaximo, ");
			qDet.append("       SUM(c.vlrLido) as vlSomado, ");
			qDet.append("       COUNT(c.vlrLido) as qtMedicoes, ");
			qDet.append("       SUM(c.vlMonetario) as vlMonetario ");
			qDet.append("  FROM DwConsolpaoco a ");
			qDet.append("  JOIN a.dwConsolParammeds b ");
			qDet.append("  JOIN b.dwConsolmedparamlog c ");
			qDet.append(" WHERE a.idConsolpaoco IN (:listaIdConsolPaOco)  ");
			qDet.append("   AND a.dwConsolpa.dwConsol.dwConsolid.dwFolha.idFolha = :idFolha ");
			qDet.append("   AND b.dwConsolParam.dwFtParam.idFtParam = :idFtParam ");
			qDet.append(" GROUP BY a.dwConsolpa.dwTParada.isPesa, a.dwConsolpa.dwConsol.dwConsolid.dwFolha.idFolha, ");
			qDet.append("          b.dwConsolParam.dwFtParam.dwFtGrupo.cdFtgrupo, ");
			qDet.append("          b.dwConsolParam.dwFtParam.dwFtGrupo.dsFtgrupo, ");
			qDet.append("          b.dwConsolParam.dwFtParam.idFtParam, ");
			qDet.append("          b.dwConsolParam.dwFtParam.dsParametro ");

			qDet.defineParametro("idFolha", folhaCEP.getIdFolha());
			qDet.defineParametro("idFtParam", folhaCEP.getIdFtParam());
			qDet.defineListaParametro("listaIdConsolPaOco", listaIdConsolPaOco);

			List<Object> lista = qDet.list();

			for (Object reg : lista) {
				Object[] registro = (Object[]) reg;

				folhaCEP = getFolhasCEP(new OmPt(), (Long) registro[_idFtParam]);

				itemLista = new DetalheMonitorizacaoCEPDTO();

				if ((Boolean) registro[_tpReferencia]) {
					itemLista.setTpReferencia(REFERENCIA_TEMPO_PARADA_SEM_PESO);
				} else {
					itemLista.setTpReferencia(REFERENCIA_TEMPO_PARADA_COM_PESO);
				}

				itemLista.setCdFtGrupo(registro[_cdFtgrupo].toString());
				itemLista.setDsFtGrupo(registro[_dsFtgrupo].toString());
				itemLista.setIdFtParam((Long) registro[_idFtParam]);
				itemLista.setDsParamentro(registro[_dsParametro].toString());
				itemLista.setVlMinimo(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMinimo]));
				itemLista.setVlMedio(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMedio]));
				itemLista.setVlMaximo(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMaximo]));
				itemLista.setVlSomado(ConversaoTipos
						.converterParaBigDecimal(registro[_vlSomado]));
				itemLista.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(
						registro[_qtMedicoes]).intValue());
				itemLista
						.setVlMonetario(ConversaoTipos
								.converterParaBigDecimal((registro[_vlMonetario] == null ? 0
										: registro[_vlMonetario])));
				itemLista.setListaOcorrencias(getListaOcorrenciasParadasCEP(
						folhaCEP.getIdFtParam(), folhaCEP.getIdFolha(),
						listaIdConsolPaOco));
				itemLista
						.setFolhaCEPSemListas(getCopiaFolhaSemDetalhamento(folhaCEP));

				folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP()
						.add(itemLista);
			}

			retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
		}

		return retorno;
	}

	public DetalheCEPDTO getDetalheCiclosCEP(CiclosDTO detCiclosDTO,
			ListaParametrosCEPDTO listaParametros) {
		MapQuery q;

		DetalheCEPDTO retorno = new DetalheCEPDTO();
		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();
		DetalheMonitorizacaoCEPDTO itemLista = new DetalheMonitorizacaoCEPDTO();
		List<Object> listaDwRtId = new ArrayList<Object>();
		List<Object> listaParametrosId = new ArrayList<Object>();

		for (ParametroCEPDTO paramCEP : listaParametros.getParametrosCEP()) {
			listaParametrosId.add(paramCEP.getIdFtParam());
		}

		// recuperar id dos ciclos
		for (CicloDTO ciclo : detCiclosDTO.getListaCicloDTO()) {
			listaDwRtId.add(ciclo.getDwRtcic().getIdRtcic());
		}

		// recuperar todos os diferentes conjuntos formados por idfolha +
		// idftparam
		retorno.setListaFolhasCEP(new ListaFolhaCEPDTO());
		retorno.getListaFolhasCEP()
				.setListaFolhas(new ArrayList<FolhaCEPDTO>());

		q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT a.dwFolha.idFolha, b.dwFtParam.idFtParam ");
		q.append("  FROM DwRtcic a ");
		q.append("  JOIN a.dwConsolmedparamlogs b ");
		q.append(" WHERE a.idRtcic IN (:listaDwRtId)  ");
		q.append("   AND b.dwFtParam.idFtParam IN (:listaParametrosId) ");
		q.append("   AND a.dwFolha IS NOT NULL ");
		q.append(" GROUP BY a.dwFolha.idFolha, b.dwFtParam.idFtParam ");

		q.defineListaParametro("listaDwRtId", listaDwRtId);
		q.defineListaParametro("listaParametrosId", listaParametrosId);

		List<Object> listaFolha = new ArrayList<>();
		listaFolha = q.list();

		for (Object regFolha : listaFolha) {
			Object[] registroFolha = (Object[]) regFolha;
			folhaCEP = getFolhasCEP(new OmPt(), (Long) registroFolha[_folha_idftparam]);

			MapQuery qDet = new MapQuery(getDaoSession());
			qDet.append("SELECT " + REFERENCIA_TEMPO_CICLOS
					+ " as tpReferencia, a.dwFolha.idFolha, ");
			qDet.append("       b.dwFtParam.dwFtGrupo.cdFtgrupo, b.dwFtParam.dwFtGrupo.dsFtgrupo, ");
			qDet.append("       b.dwFtParam.idFtParam, b.dwFtParam.dsParametro, ");
			qDet.append("       MIN(b.vlrLido) as vlMinimo,");
			qDet.append("       AVG(b.vlrLido) as vlMedio, ");
			qDet.append("       MAX(b.vlrLido) as vlMaximo, ");
			qDet.append("       SUM(b.vlrLido) as vlSomado, ");
			qDet.append("       COUNT(b.vlrLido) as qtMedicoes, ");
			qDet.append("       SUM(b.vlMonetario) as vlMonetario ");
			qDet.append("  FROM DwRtcic a ");
			qDet.append("  JOIN a.dwConsolmedparamlogs b ");
			qDet.append(" WHERE b.dwrtcic.idRtcic IN (:listaDwRtId)  ");
			qDet.append("   AND b.dwrtcic.dwFolha.idFolha = :idFolha ");
			qDet.append("   AND b.dwFtParam.idFtParam = :idFtParam ");
			qDet.append(" GROUP BY a.dwFolha.idFolha, ");
			qDet.append("          b.dwFtParam.dwFtGrupo.cdFtgrupo, b.dwFtParam.dwFtGrupo.dsFtgrupo,  ");
			qDet.append("          b.dwFtParam.idFtParam, b.dwFtParam.dsParametro ");

			qDet.defineParametro("idFolha", folhaCEP.getIdFolha());
			qDet.defineParametro("idFtParam", folhaCEP.getIdFtParam());
			qDet.defineListaParametro("listaDwRtId", listaDwRtId);

			List<Object> lista = qDet.list();

			for (Object reg : lista) {
				Object[] registro = (Object[]) reg;

				folhaCEP = getFolhasCEP(new OmPt(), (Long) registro[_idFtParam]);

				itemLista = new DetalheMonitorizacaoCEPDTO();

				itemLista.setTpReferencia(ConversaoTipos
						.converterParaBigDecimal(registro[_tpReferencia])
						.byteValue());
				itemLista.setCdFtGrupo(registro[_cdFtgrupo].toString());
				itemLista.setDsFtGrupo(registro[_dsFtgrupo].toString());
				itemLista.setIdFtParam((Long) registro[_idFtParam]);
				itemLista.setDsParamentro(registro[_dsParametro].toString());
				itemLista.setVlMinimo(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMinimo]));
				itemLista.setVlMedio(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMedio]));
				itemLista.setVlMaximo(ConversaoTipos
						.converterParaBigDecimal(registro[_vlMaximo]));
				itemLista.setVlSomado(ConversaoTipos
						.converterParaBigDecimal(registro[_vlSomado]));
				itemLista.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(
						registro[_qtMedicoes]).intValue());
				itemLista
						.setVlMonetario(ConversaoTipos
								.converterParaBigDecimal((registro[_vlMonetario] == null ? 0
										: registro[_vlMonetario])));
				itemLista.setListaOcorrencias(getListaOcorrenciasCiclosCEP(
						folhaCEP.getIdFtParam(), folhaCEP.getIdFolha(),
						listaDwRtId));
				itemLista
						.setFolhaCEPSemListas(getCopiaFolhaSemDetalhamento(folhaCEP));

				folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP()
						.add(itemLista);
			}
			retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
		}

		return retorno;
	}

	public List<DetalheMonitorizacaoCEPOcorrDTO> getListaOcorrenciasCEP(
			Byte tpReferencia, Long idFtParam, Long idFolha,
			List<Object> listaIdConsolId) {
		List<DetalheMonitorizacaoCEPOcorrDTO> retorno = new ArrayList<DetalheMonitorizacaoCEPOcorrDTO>();

		/*
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT c ");
		q.append("  FROM DwConsolParam a");
		q.append("  JOIN a.dwConsolParammeds b ");
		q.append("  JOIN b.dwConsolmedparamlog c ");
		q.append(" WHERE a.tpReferencia = :tpReferencia ");
		q.append("   AND a.dwFtParam.idFtParam = :idFtParam ");
		q.append("   AND a.dwConsol.dwConsolid.dwFolha.idFolha = :idFolha ");
		q.append("   AND a.dwConsol.dwConsolid.idConsolid IN (:listaIdConsolId) ");
		q.append(" ORDER BY c.idConsolmedparamlog");

		q.defineParametro("tpReferencia", tpReferencia);
		q.defineParametro("idFtParam", idFtParam);
		q.defineParametro("idFolha", idFolha);
		q.defineListaParametro("listaIdConsolId", listaIdConsolId);

		List<DwConsolmedparamlog> lista = q.list();

		for (DwConsolmedparamlog itemLista : lista) {
			DetalheMonitorizacaoCEPOcorrDTO detCEPOcorr = new DetalheMonitorizacaoCEPOcorrDTO();
			detCEPOcorr.setIdFtParam(itemLista.getDwFtParam().getIdFtParam());
			detCEPOcorr.setDsParamentro(itemLista.getDwFtParam().getDsParametro());
			detCEPOcorr.setDthrMedicao(itemLista.getDthrMedicao());
			detCEPOcorr.setMsDthrmedicao(itemLista.getMsDthrmedicao());
			detCEPOcorr.setVlMonetario((itemLista.getVlMonetario() == null ? BigDecimal.ZERO: itemLista.getVlMonetario()));
			detCEPOcorr.setVlrLido(itemLista.getVlrLido());

			retorno.add(detCEPOcorr);
		}
		*/
		
		String str_idConsolid = listaIdConsolId.toString();
		str_idConsolid = str_idConsolid.toString().replace("[", "");
		str_idConsolid = str_idConsolid.toString().replace("]", "");
				
		String strSQL = "";
		strSQL = "SELECT a.id_ft_param AS idFtParam,";
		strSQL = strSQL.concat(" d.ds_parametro AS dsParamentro, ");
		strSQL = strSQL.concat(" c.dthr_medicao AS dthrMedicao, ");
		strSQL = strSQL.concat(" c.ms_dthrmedicao AS msDthrmedicao, ");
		strSQL = strSQL.concat(" (CASE WHEN c.vl_monetario IS NULL THEN  0 ELSE c.vl_monetario END) AS vlMonetario, ");
		strSQL = strSQL.concat(" c.vlr_lido AS vlrLido ");
		strSQL = strSQL.concat(" FROM dw_consol_param a ");
		strSQL = strSQL.concat(" JOIN dw_consol_parammed b ON (b.id_consolparam = a.id_consolparam) ");
		strSQL = strSQL.concat(" JOIN dw_consolmedparamlog c ON (c.id_consolmedparamlog = b.id_consolmedparamlog)");
		strSQL = strSQL.concat(" JOIN dw_ft_param d ON (d.id_ft_param = a.id_ft_param) ");
		strSQL = strSQL.concat(" JOIN dw_consol e ON (e.id_consol = a.id_consol) ");
		strSQL = strSQL.concat(" JOIN dw_consolid f ON (f.id_consolid = e.id_consolid) ");
		strSQL = strSQL.concat(" WHERE f.id_folha = " + idFolha );
		strSQL = strSQL.concat("  AND f.id_consolid in (" + str_idConsolid + ")");
		strSQL = strSQL.concat("  AND a.tp_referencia = " + tpReferencia);
		List<DetalheMonitorizacaoCEPOcorrDTO> lista = 
				this.getDaoSession().createSQLQuery(strSQL)
				.addScalar("idFtParam", new LongType())
				.addScalar("dsParamentro", new StringType())
				.addScalar("dthrMedicao", new DateType())
				.addScalar("msDthrmedicao", new IntegerType())
				.addScalar("vlMonetario", new BigDecimalType())
				.addScalar("vlrLido", new BigDecimalType())				
				.setResultTransformer(Transformers.aliasToBean(DetalheMonitorizacaoCEPOcorrDTO.class))
				.list();
	
		retorno.addAll(lista);
		lista = null;
		
		return retorno;
	}
	
	
	public DetalheMonitorizacaoCEPOcorrDTO getUltimaOcorrenciaCEP(
			Byte tpReferencia, Long idFtParam, Long idFolha,
			List<Object> listaIdConsolId) { // mais recente ocorrencia CEP
		DetalheMonitorizacaoCEPOcorrDTO retorno = new DetalheMonitorizacaoCEPOcorrDTO();
		
		String str_idConsolid = listaIdConsolId.toString();
		str_idConsolid = str_idConsolid.toString().replace("[", "");
		str_idConsolid = str_idConsolid.toString().replace("]", "");
		
		
		String strSQL = "";
		strSQL = "SELECT a.id_ft_param AS idFtParam,";
		strSQL = strSQL.concat(" d.ds_parametro AS dsParamentro, ");
		strSQL = strSQL.concat(" c.dthr_medicao AS dthrMedicao, ");
		strSQL = strSQL.concat(" c.ms_dthrmedicao AS msDthrmedicao, ");
		strSQL = strSQL.concat(" (CASE WHEN c.vl_monetario IS NULL THEN 0 ELSE c.vl_monetario END) AS vlMonetario, ");
		strSQL = strSQL.concat(" c.vlr_lido AS vlrLido ");
		strSQL = strSQL.concat(" FROM dw_consol_param a ");
		strSQL = strSQL.concat(" JOIN dw_consol_parammed b ON (b.id_consolparam = a.id_consolparam) ");
		strSQL = strSQL.concat(" JOIN dw_consolmedparamlog c ON (c.id_consolmedparamlog = b.id_consolmedparamlog)");
		strSQL = strSQL.concat(" JOIN dw_ft_param d ON (d.id_ft_param = a.id_ft_param) ");
		strSQL = strSQL.concat(" JOIN dw_consol e ON (e.id_consol = a.id_consol) ");
		strSQL = strSQL.concat(" JOIN dw_consolid f ON (f.id_consolid = e.id_consolid) ");
		strSQL = strSQL.concat(" WHERE 1=1 " );
		if (idFolha!=null && idFolha.longValue()>0L){
			strSQL = strSQL.concat(" AND f.id_folha = " + idFolha );			
		}
		if (idFtParam!=null ){
			strSQL = strSQL.concat(" AND a.id_ft_param = " + idFtParam );			
		}
		strSQL = strSQL.concat("  AND f.id_consolid in (" + str_idConsolid + ")");
		strSQL = strSQL.concat("  AND a.tp_referencia = " + tpReferencia);
		strSQL = strSQL.concat("  ORDER BY dthrMedicao DESC ");

		DetalheMonitorizacaoCEPOcorrDTO ret =  (DetalheMonitorizacaoCEPOcorrDTO)
				this.getDaoSession().createSQLQuery(strSQL)
				.addScalar("idFtParam", new LongType())
				.addScalar("dsParamentro", new StringType())
				.addScalar("dthrMedicao", new DateType())
				.addScalar("msDthrmedicao", new IntegerType())
				.addScalar("vlMonetario", new BigDecimalType())
				.addScalar("vlrLido", new BigDecimalType())				
				.setResultTransformer(Transformers.aliasToBean(DetalheMonitorizacaoCEPOcorrDTO.class)).setMaxResults(1)
				.uniqueResult();
	
		retorno = ret;
		
		
		return retorno;
	}

	public DetalheMonitorizacaoCEPOcorrDTO getUltimaOcorrenciaCEPInjet(
			Byte tpReferencia, Long idFtParam, Long idFolha, PeriodoDTO periodo, String cdPt) { // mais recente ocorrencia CEP

		DetalheMonitorizacaoCEPOcorrDTO retorno = new DetalheMonitorizacaoCEPOcorrDTO();
		
		String strSQL = "";
		strSQL = "SELECT a.id_ft_param AS idFtParam,";
		strSQL = strSQL.concat(" d.ds_parametro AS dsParamentro, ");
		strSQL = strSQL.concat(" c.dthr_medicao AS dthrMedicao, ");
		strSQL = strSQL.concat(" c.ms_dthrmedicao AS msDthrmedicao, ");
		strSQL = strSQL.concat(" (CASE WHEN c.vl_monetario IS NULL THEN 0 ELSE c.vl_monetario END) AS vlMonetario, ");
		strSQL = strSQL.concat(" c.vlr_lido AS vlrLido ");
		strSQL = strSQL.concat(" FROM dw_consol_param a ");
		strSQL = strSQL.concat(" JOIN dw_consol_parammed b ON (b.id_consolparam = a.id_consolparam) ");
		strSQL = strSQL.concat(" JOIN dw_consolmedparamlog c ON (c.id_consolmedparamlog = b.id_consolmedparamlog)");
		strSQL = strSQL.concat(" JOIN dw_ft_param d ON (d.id_ft_param = a.id_ft_param) ");
		strSQL = strSQL.concat(" JOIN dw_consol e ON (e.id_consol = a.id_consol) ");
		strSQL = strSQL.concat(" JOIN dw_consolid f ON (f.id_consolid = e.id_consolid) ");		
		strSQL = strSQL.concat(" JOIN om_pt g ON (g.id_pt = f.id_pt AND g.cd_pt = '" + cdPt + "'" + ") ");
		strSQL = strSQL.concat(" WHERE 1=1 " );
		
//		if (idFolha!=null && idFolha.longValue()>0L){
//			strSQL = strSQL.concat(" AND f.id_folha = " + idFolha );			
//		}
		if (idFtParam!=null ){
			strSQL = strSQL.concat(" AND a.id_ft_param = " + idFtParam );			
		}
		
		strSQL = strSQL.concat("  AND c.dthr_medicao BETWEEN :dthrini AND :dthrfim");
		strSQL = strSQL.concat("  AND a.tp_referencia = " + tpReferencia);
		strSQL = strSQL.concat("  ORDER BY dthrMedicao DESC ");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("dthrini", periodo.getDtHrInicio())
		 .setParameter("dthrfim", periodo.getDtHrFim());

		DetalheMonitorizacaoCEPOcorrDTO ret =  (DetalheMonitorizacaoCEPOcorrDTO)
				q.addScalar("idFtParam", new LongType())
				.addScalar("dsParamentro", new StringType())
				.addScalar("dthrMedicao", new DateType())
				.addScalar("msDthrmedicao", new IntegerType())
				.addScalar("vlMonetario", new BigDecimalType())
				.addScalar("vlrLido", new BigDecimalType())				
				.setResultTransformer(Transformers.aliasToBean(DetalheMonitorizacaoCEPOcorrDTO.class)).setMaxResults(1)
				.uniqueResult();
	
		retorno = ret;
		
		
		return retorno;
	}
	
	public List<DetalheMonitorizacaoCEPOcorrDTO> getListaOcorrenciasCEPInjet(
			Byte tpReferencia, Long idFtParam, Long idFolha, PeriodoDTO periodo, String cdPt) { // mais recente ocorrencia CEP

		List<DetalheMonitorizacaoCEPOcorrDTO> retorno = new ArrayList<DetalheMonitorizacaoCEPOcorrDTO>();

		String strSQL = "";
		strSQL = "SELECT a.id_ft_param AS idFtParam,";
		strSQL = strSQL.concat(" d.ds_parametro AS dsParamentro, ");
		strSQL = strSQL.concat(" c.dthr_medicao AS dthrMedicao, ");
		strSQL = strSQL.concat(" c.ms_dthrmedicao AS msDthrmedicao, ");
		strSQL = strSQL.concat(" (CASE WHEN c.vl_monetario IS NULL THEN 0 ELSE c.vl_monetario END) AS vlMonetario, ");
		strSQL = strSQL.concat(" c.vlr_lido AS vlrLido ");
		strSQL = strSQL.concat(" FROM dw_consol_param a ");
		strSQL = strSQL.concat(" JOIN dw_consol_parammed b ON (b.id_consolparam = a.id_consolparam) ");
		strSQL = strSQL.concat(" JOIN dw_consolmedparamlog c ON (c.id_consolmedparamlog = b.id_consolmedparamlog)");
		strSQL = strSQL.concat(" JOIN dw_ft_param d ON (d.id_ft_param = a.id_ft_param) ");
		strSQL = strSQL.concat(" JOIN dw_consol e ON (e.id_consol = a.id_consol) ");
		strSQL = strSQL.concat(" JOIN dw_consolid f ON (f.id_consolid = e.id_consolid and f.tp_id = '" + 0 + "'" + ") ");
		strSQL = strSQL.concat(" JOIN om_pt g ON (g.id_pt = f.id_pt AND g.cd_pt = '" + cdPt + "'" + ") ");
		strSQL = strSQL.concat(" WHERE 1=1 " );
		
//		if (idFolha!=null && idFolha.longValue()>0L){
//			strSQL = strSQL.concat(" AND f.id_folha = " + idFolha );			
//		}
		if (idFtParam!=null ){
			strSQL = strSQL.concat(" AND a.id_ft_param = " + idFtParam );			
		}
		
		strSQL = strSQL.concat("  AND c.dthr_medicao BETWEEN :dthrini AND :dthrfim");
		strSQL = strSQL.concat("  AND a.tp_referencia = " + tpReferencia);
		strSQL = strSQL.concat("  ORDER BY dthrMedicao DESC ");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("dthrini", periodo.getDtHrInicio())
		 .setParameter("dthrfim", periodo.getDtHrFim());

		List<DetalheMonitorizacaoCEPOcorrDTO> lista = (List<DetalheMonitorizacaoCEPOcorrDTO>)
				q.addScalar("idFtParam", new LongType())
				.addScalar("dsParamentro", new StringType())
				.addScalar("dthrMedicao", new TimestampType())
				.addScalar("msDthrmedicao", new IntegerType())
				.addScalar("vlMonetario", new BigDecimalType())
				.addScalar("vlrLido", new BigDecimalType())				
				.setResultTransformer(Transformers.aliasToBean(DetalheMonitorizacaoCEPOcorrDTO.class)).setMaxResults(50)
				.list();
		
		
//		// Ordenar o vetor
//		if(lista.size()!=0){
//			for(int i=lista.size()-1;i==0;i--){
//				retorno.add(lista.get(i));
//			}
//		}
		
		Collections.reverse(lista);
		retorno=lista;
		lista = null;
		
		return retorno;
	}
	
	
	
	public List<DetalheMonitorizacaoCEPOcorrDTO> getListaOcorrenciasParadasCEP(
			Long idFtParam, Long idFolha, List<Object> listaIdConsolPaOco) {
		List<DetalheMonitorizacaoCEPOcorrDTO> retorno = new ArrayList<DetalheMonitorizacaoCEPOcorrDTO>();

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT c ");
		q.append("  FROM DwConsolpaoco a ");
		q.append("  JOIN a.dwConsolParammeds b ");
		q.append("  JOIN b.dwConsolmedparamlog c ");
		q.append(" WHERE a.idConsolpaoco IN (:listaIdConsolPaOco)  ");
		q.append("   AND c.dwFtParam.idFtParam = :idFtParam ");
		q.append("   AND a.dwConsolpa.dwConsol.dwConsolid.dwFolha.idFolha = :idFolha ");
		q.append(" ORDER BY c.idConsolmedparamlog");

		q.defineParametro("idFtParam", idFtParam);
		q.defineParametro("idFolha", idFolha);
		q.defineListaParametro("listaIdConsolPaOco", listaIdConsolPaOco);

		List<DwConsolmedparamlog> lista = q.list();

		for (DwConsolmedparamlog itemLista : lista) {
			DetalheMonitorizacaoCEPOcorrDTO detCEPOcorr = new DetalheMonitorizacaoCEPOcorrDTO();
			detCEPOcorr.setIdFtParam(itemLista.getDwFtParam().getIdFtParam());
			detCEPOcorr.setDsParamentro(itemLista.getDwFtParam()
					.getDsParametro());
			detCEPOcorr.setDthrMedicao(itemLista.getDthrMedicao());
			detCEPOcorr.setMsDthrmedicao(itemLista.getMsDthrmedicao());
			detCEPOcorr
					.setVlMonetario((itemLista.getVlMonetario() == null ? BigDecimal.ZERO
							: itemLista.getVlMonetario()));
			detCEPOcorr.setVlrLido(itemLista.getVlrLido());

			retorno.add(detCEPOcorr);
		}

		return retorno;
	}

	public List<DetalheMonitorizacaoCEPOcorrDTO> getListaOcorrenciasCiclosCEP(
			Long idFtParam, Long idFolha, List<Object> listaDwRtId) {
		List<DetalheMonitorizacaoCEPOcorrDTO> retorno = new ArrayList<DetalheMonitorizacaoCEPOcorrDTO>();
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT DISTINCT b ");
		q.append("  FROM DwRtcic a ");
		q.append("  JOIN a.dwConsolmedparamlogs b ");
		q.append(" WHERE a.idRtcic IN (:listaDwRtId) ");
		q.append("   AND b.dwFtParam.idFtParam = :idFtParam ");
		q.append("   AND a.dwFolha.idFolha = :idFolha ");
		q.append(" ORDER BY b.idConsolmedparamlog");

		q.defineParametro("idFtParam", idFtParam);
		q.defineParametro("idFolha", idFolha);
		q.defineListaParametro("listaDwRtId", listaDwRtId);

		List<DwConsolmedparamlog> lista = q.list();

		for (DwConsolmedparamlog itemLista : lista) {
			DetalheMonitorizacaoCEPOcorrDTO detCEPOcorr = new DetalheMonitorizacaoCEPOcorrDTO();
			detCEPOcorr.setIdFtParam(itemLista.getDwFtParam().getIdFtParam());
			detCEPOcorr.setDsParamentro(itemLista.getDwFtParam()
					.getDsParametro());
			detCEPOcorr.setDthrMedicao(itemLista.getDthrMedicao());
			detCEPOcorr.setMsDthrmedicao(itemLista.getMsDthrmedicao());
			detCEPOcorr
					.setVlMonetario((itemLista.getVlMonetario() == null ? BigDecimal.ZERO
							: itemLista.getVlMonetario()));
			detCEPOcorr.setVlrLido(itemLista.getVlrLido());

			retorno.add(detCEPOcorr);
		}

		return retorno;
	}

	public FolhaCEPDTO getFolhasCEP(OmPt ompt, Long idFtParam) {
		FolhaCEPDTO retorno = new FolhaCEPDTO();

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT f ");
		q.append(" FROM DwFolha f ");
		q.append(" JOIN FETCH f.dwFolhamedtemps g ");
		q.append(" JOIN FETCH g.dwFolhamedtemhors h ");
		q.append(" JOIN FETCH h.dwFtParam p ");
		q.append(" JOIN FETCH h.dwFolhamedtemphorcfgs i ");
		q.append(" WHERE f.stAtivo = 1");
		if (idFtParam > 0)
			q.append("   AND h.dwFtParam.idFtParam = :idFtParam");
		q.append("and f.omPt = :ompt");

		q.setMaxResults(1);
		
		q.defineParametro("idFtParam", idFtParam);
		q.defineParametro("ompt", ompt);
		
		DwFolha folha = (DwFolha) q.uniqueResult();
		
		/* Alessandre em 28-11-15 comentei o if abaixo pois nao faz sentido trazer os limites sem 
		 * considerar a variavel, senao ira aparecer limites de uma variavel em outra
		if (folha == null) {
			// nao encontrou limites/espec do parametro... desconsiderar parametro
			
			q = null;
			q = new MapQuery(getDaoSession());
			q.append("SELECT DISTINCT f ");
			q.append(" FROM DwFolha f ");
			q.append(" left JOIN FETCH f.dwFolhamedtemps g ");
			q.append(" left JOIN FETCH g.dwFolhamedtemhors h ");
			q.append(" left JOIN FETCH h.dwFtParam p ");
			q.append(" left JOIN FETCH h.dwFolhamedtemphorcfgs i ");
			q.append(" WHERE f.idFolha = :idFolha");

			q.setMaxResults(1);
			q.defineParametro("idFolha", idFolha);
			folha = (DwFolha) q.uniqueResult();
		}
		 */

		retorno = new FolhaCEPDTO();
		if (folha != null) {
			retorno.setIdFolha(folha.getIdFolha());
			retorno.setCdFolha(folha.getCdFolha());
			retorno.setRevisao(folha.getRevisao());
		} else {
			retorno.setIdFolha(0l);
			retorno.setCdFolha("SemFolha");
			retorno.setRevisao(0l);
		}
		retorno.setIdFtParam(idFtParam);
		retorno.setIndicadoresCEP(new IndicadoresEstatisticosCEPDTO());
		retorno.setListaDetalheCEP(new ListaDetalheMonitorizacaoCEPDTO());
		retorno.getListaDetalheCEP().setDetMonitorizacaoCEP(new ArrayList<DetalheMonitorizacaoCEPDTO>());

		DwFolhamedtemp folhaMedTemp = null;
		DwFolhamedtemhor folhaMedTempHor = null;

		if (folha != null && folha.getDwFolhamedtemps() != null && folha.getDwFolhamedtemps().size() > 0)
			folhaMedTemp = folha.getDwFolhamedtemps().iterator().next();

		if (folhaMedTemp != null)
			folhaMedTempHor = folhaMedTemp.getDwFolhamedtemhors().iterator().next();

		List<DwFolhamedtemphorcfg> folhaLimites = new ArrayList<DwFolhamedtemphorcfg>();
		if (folhaMedTempHor != null && folhaMedTempHor.getDwFolhamedtemphorcfgs() != null && folhaMedTempHor.getDwFolhamedtemphorcfgs().size() > 0)
			folhaLimites.addAll(folhaMedTempHor.getDwFolhamedtemphorcfgs());

		// orderna lista - necessário por causa de uma eventual da tradu��oo dos
		// termos
		Collections.sort(folhaLimites, new Comparator<DwFolhamedtemphorcfg>() {
			@Override
			public int compare(final DwFolhamedtemphorcfg o1, final DwFolhamedtemphorcfg o2) {
				BigDecimal v1 = o1.getLimInfTemp() != null ? o1.getLimInfTemp() : BigDecimal.ZERO;
				BigDecimal v2 = o2.getLimInfTemp() != null ? o2.getLimInfTemp() : BigDecimal.ZERO;

				return v1.compareTo(v2);
			}
		});

		byte i = 0;

		if (folhaMedTempHor != null && folhaMedTempHor.getDwFtParam() != null) {
			retorno.setTemMaximo(folhaMedTempHor.getDwFtParam().getIsMaximo());
			retorno.setTemMinimo(folhaMedTempHor.getDwFtParam().getIsMinimo());
			retorno.setTemMeta(folhaMedTempHor.getDwFtParam().getIsMaximo());
		}

		for (DwFolhamedtemphorcfg folhaLimite : folhaLimites) {
			i++;

			switch (i) {
			case LIMITE_CRITICO_INFERIOR:
				retorno.setLimCriticoInf(folhaLimite.getLimSupTemp());
				break;
			case LIMITE_ACEITAVEL_INFERIOR:
				retorno.setLimAceitavelInfIni(folhaLimite.getLimInfTemp());
				retorno.setLimAceitavelInfFim(folhaLimite.getLimSupTemp());
				break;
			case LIMITE_IDEAL:
				retorno.setLimIdealIni(folhaLimite.getLimInfTemp());
				retorno.setLimIdealFim(folhaLimite.getLimSupTemp());
				break;
			case LIMITE_ACEITAVEL_SUPERIOR:
				retorno.setLimAceitavelSupIni(folhaLimite.getLimInfTemp());
				retorno.setLimAceitavelSupFim(folhaLimite.getLimSupTemp());
				break;
			case LIMITE_CRITICO_SUPERIOR:
				retorno.setLimCriticoSup(folhaLimite.getLimInfTemp());
				break;
			}
		}

		return retorno;
	}

	public IndicadoresEstatisticosCEPDTO getIndicadoresEstatisticosCEP(
			FolhaCEPDTO folhaCEP, Integer tamanhoAmostra) {
		IndicadoresEstatisticosCEPDTO indicadores = new IndicadoresEstatisticosCEPDTO();
		ListaParametrosCEPDTO listaParametros = getListaParametrosCEP(true);

		BigDecimal mediasAcumuladas = BigDecimal.ZERO;
		BigDecimal amplitudesAcumuladas = BigDecimal.ZERO;
		BigDecimal somaQuadrados = BigDecimal.ZERO;
		BigDecimal somaVlrLidos = BigDecimal.ZERO;
		BigDecimal xBarraBarra = BigDecimal.ZERO;
		BigDecimal rBarra = BigDecimal.ZERO;
		BigDecimal xBarraCP = BigDecimal.ZERO;
		Integer somaQtdOcorr = 0;

		for (DetalheMonitorizacaoCEPDTO itemGrafico : folhaCEP
				.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
			mediasAcumuladas = mediasAcumuladas.add(itemGrafico.getVlMedio());
			amplitudesAcumuladas = amplitudesAcumuladas.add(
					itemGrafico.getVlMaximo()).subtract(
					itemGrafico.getVlMinimo());
			somaVlrLidos = somaVlrLidos.add(itemGrafico.getVlSomado());
			somaQtdOcorr = somaQtdOcorr + itemGrafico.getQtMedicoes();
		}
		xBarraCP = somaVlrLidos.divide(new BigDecimal(somaQtdOcorr),
				BigDecimal.ROUND_HALF_EVEN);

		indicadores.setIdFtParam(folhaCEP.getIdFtParam());

		for (ParametroCEPDTO param : listaParametros.getParametrosCEP()) {
			if (param.getIdFtParam().equals(folhaCEP.getIdFtParam())) {
				indicadores.setDsFtParam(param.getDsParametro());
				break;
			}
		}

		indicadores.setN(tamanhoAmostra.intValue());
		indicadores.setM(folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP()
				.size());

		xBarraBarra = mediasAcumuladas.divide(
				new BigDecimal(indicadores.getM()), BigDecimal.ROUND_HALF_EVEN);
		if (indicadores.getN().equals(BigDecimal.ONE)) {
			if (indicadores.getM().equals(BigDecimal.ONE)) {
				rBarra = BigDecimal.ZERO;
			} else {
				rBarra = amplitudesAcumuladas.divide(
						new BigDecimal(indicadores.getM() - 1),
						BigDecimal.ROUND_HALF_EVEN);
			}
		} else {
			rBarra = amplitudesAcumuladas.divide(
					new BigDecimal(indicadores.getM()),
					BigDecimal.ROUND_HALF_EVEN);
		}
		indicadores.setLsc_X(AritmeticaUtil.somar(
				xBarraBarra,
				ConstanteCartaControleDTO.get(indicadores.getN()).A2
						* rBarra.intValue()));
		indicadores.setLc_X(xBarraBarra);
		indicadores.setLic_X(AritmeticaUtil.diminuir(
				xBarraBarra,
				ConstanteCartaControleDTO.get(indicadores.getN()).A2
						* rBarra.intValue()));

		indicadores.setLsc_R(new BigDecimal(ConstanteCartaControleDTO
				.get(indicadores.getN()).D4 * rBarra.intValue()));
		indicadores.setLc_R(rBarra);
		indicadores.setLic_R(new BigDecimal(ConstanteCartaControleDTO
				.get(indicadores.getN()).D3 * rBarra.intValue()));

		/*
		 *  trecho abaixo trocado por consulta
		for (DetalheMonitorizacaoCEPDTO itemGrafico : folhaCEP
				.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
			for (DetalheMonitorizacaoCEPOcorrDTO itemOcorr : itemGrafico
					.getListaOcorrencias()) {
				somaQuadrados = somaQuadrados.add(itemOcorr.getVlrLido()
						.subtract(xBarraCP).pow(2));
			}
		}
		*/
				
		
		if ((somaQtdOcorr - 1) > 0) {
			indicadores.setDesvioPadrao(new BigDecimal(Math.sqrt(somaQuadrados
					.divide(new BigDecimal(somaQtdOcorr - 1),
							BigDecimal.ROUND_HALF_EVEN).doubleValue())));
		}

		if (indicadores.getDesvioPadrao() != null) {
			if (indicadores.getDesvioPadrao().doubleValue() > 0d) {
				if (folhaCEP != null && folhaCEP.getTemMinimo() != null
						&& folhaCEP.getTemMinimo() == true
						&& folhaCEP.getTemMeta() != null
						&& folhaCEP.getTemMeta() == true
						&& folhaCEP.getTemMaximo() != null
						&& folhaCEP.getTemMaximo() == true) {
					/*
					 * CP = (dblLSE - dblLIE) / (6 * dblDesvioPadrao) CPI =
					 * (dblXBarraCP - dblLIE) / (3 * dblDesvioPadrao) CPS =
					 * (dblLSE - dblXBarraCP) / (3 * dblDesvioPadrao) CPK =
					 * IIf(dblCPS < dblCPI, dblCPS, dblCPI)
					 */

					indicadores.setCp((folhaCEP.getLimCriticoSup()
							.subtract(folhaCEP.getLimCriticoInf())).divide(
							new BigDecimal(6).multiply(indicadores
									.getDesvioPadrao()),
							BigDecimal.ROUND_HALF_EVEN));
					indicadores.setCpi((xBarraCP.subtract(folhaCEP
							.getLimCriticoInf())).divide(new BigDecimal(3)
							.multiply(indicadores.getDesvioPadrao()),
							BigDecimal.ROUND_HALF_EVEN));
					indicadores.setCps((folhaCEP.getLimCriticoSup()
							.subtract(xBarraCP)).divide(new BigDecimal(3)
							.multiply(indicadores.getDesvioPadrao()),
							BigDecimal.ROUND_HALF_EVEN));
					indicadores
							.setCpk(indicadores.getCps().doubleValue() < indicadores
									.getCpi().doubleValue() ? indicadores
									.getCps() : indicadores.getCpi());
				} else {
					if (folhaCEP != null && folhaCEP.getTemMinimo() != null
							&& folhaCEP.getTemMinimo() == true
							&& folhaCEP.getTemMeta() != null
							&& folhaCEP.getTemMeta() == false
							&& folhaCEP.getTemMaximo() != null
							&& folhaCEP.getTemMaximo() == false) {
						indicadores.setCpi((xBarraCP.subtract(folhaCEP
								.getLimCriticoInf())).divide(new BigDecimal(3)
								.multiply(indicadores.getDesvioPadrao()),
								BigDecimal.ROUND_HALF_EVEN));
						indicadores.setCpk(indicadores.getCpi());
					} else {
						if (folhaCEP != null && folhaCEP.getTemMinimo() != null
								&& folhaCEP.getTemMinimo() == false
								&& folhaCEP.getTemMeta() != null
								&& folhaCEP.getTemMeta() == false
								&& folhaCEP.getTemMaximo() != null
								&& folhaCEP.getTemMaximo() == true) {
							indicadores.setCps((folhaCEP.getLimCriticoSup()
									.subtract(xBarraCP)).divide(new BigDecimal(
									3).multiply(indicadores.getDesvioPadrao()),
									BigDecimal.ROUND_HALF_EVEN));
							indicadores.setCpk(indicadores.getCps());
						}
					}
				}
			}
		}

		if (somaQtdOcorr < 6) {
			indicadores.setLic_R(null);
		}

		return indicadores;
	}

	public GraficoCEPDTO getGraficoCEP(Byte quebraPeriodo, DetalheCEPDTO folhasCEP) {
		GraficoCEPDTO grafico = null;
		Map<Long, String> mapParametros = new HashMap<Long, String>();
		Map<String, GraficoCEPPeriodoDTO> mapPeriodo = new HashMap<String, GraficoCEPPeriodoDTO>();
		Map<String, Map<Long, GraficoCEPDetParamDTO>> mapPeriodoxParam = new HashMap<String, Map<Long, GraficoCEPDetParamDTO>>();
		String keyQuebra = "";

		grafico = new GraficoCEPDTO();
		grafico.setItemGrafico(new ArrayList<GraficoCEPPeriodoDTO>());
		grafico.setIndicadoresEstatisticos(new ArrayList<IndicadoresEstatisticosCEPDTO>());

		// identifica os diferentes períodos e parâmetros avaliados
		for (FolhaCEPDTO detalhe : folhasCEP.getListaFolhasCEP().getListaFolhas()) {
			for (DetalheMonitorizacaoCEPDTO det : detalhe.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
				if (!mapParametros.containsKey(det.getIdFtParam())) {
					mapParametros.put(det.getIdFtParam(), det.getDsParamentro());
				}
				DwTurno dwturno = new DwTurno();
				dwturno.setCdTurno(det.getCdTurno());
				dwturno.setDsTurno(det.getDsTurno());

				GraficoCEPPeriodoDTO itemPeriodo = new GraficoCEPPeriodoDTO();
				itemPeriodo.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

				switch (quebraPeriodo) {
				case GRAFICO_CNC_POR_HORA:
					keyQuebra = det.getDthrIni().toString() + "; " + det.getDthrFim().toString();
					itemPeriodo.setDthrIni(det.getDthrIni());
					itemPeriodo.setDthrFim(det.getDthrFim());
					break;
				case GRAFICO_CNC_POR_DATA_TURNO:
					keyQuebra = det.getCdTurno() + ";" + det.getDtTurno().toString();
					itemPeriodo.setDtTurno(det.getDtTurno());
					itemPeriodo.setCdTurno(det.getCdTurno());
					break;
				case GRAFICO_CNC_POR_DATA:
					keyQuebra = det.getDtTurno().toString();
					itemPeriodo.setDtTurno(det.getDtTurno());
					break;
				}

				GraficoCEPPeriodoDTO itemGraf = new GraficoCEPPeriodoDTO();
				itemGraf.setDthrIni(itemPeriodo.getDthrIni());
				itemGraf.setDthrFim(itemPeriodo.getDthrFim());
				itemGraf.setDtTurno(itemPeriodo.getDtTurno());
				itemGraf.setCdTurno(itemPeriodo.getCdTurno());
				itemGraf.setDsTurno(itemPeriodo.getDsTurno());
				itemGraf.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

				if (!mapPeriodo.containsKey(keyQuebra)) {
					mapPeriodo.put(keyQuebra, itemGraf);

				}

				if (mapPeriodoxParam.containsKey(keyQuebra)) {
					// identifica se o parâmetro já está na lista
					Map<Long, GraficoCEPDetParamDTO> mapParam = mapPeriodoxParam.get(keyQuebra);
					if (mapParam.containsKey(det.getIdFtParam()) == false) {
						GraficoCEPDetParamDTO itemDet = new GraficoCEPDetParamDTO();
						itemDet.setIdFtParam(det.getIdFtParam());
						itemDet.setDsFtParam(det.getDsParamentro());
						itemDet.setDetParam(det);
						itemDet.setDtReferenciaParaToolTip(det.getDtTurno());
						itemDet.setDwturnoParaToolTip(dwturno);
						mapParam.put(itemDet.getIdFtParam(), itemDet);

						mapPeriodoxParam.put(keyQuebra, mapParam);
					}
				} else {
					Map<Long, GraficoCEPDetParamDTO> mapParam = new HashMap<Long, GraficoCEPDetParamDTO>();
					GraficoCEPDetParamDTO itemDet = new GraficoCEPDetParamDTO();
					itemDet.setIdFtParam(det.getIdFtParam());
					itemDet.setDsFtParam(det.getDsParamentro());
					itemDet.setDetParam(det);
					itemDet.setDtReferenciaParaToolTip(det.getDtTurno());
					itemDet.setDwturnoParaToolTip(dwturno);
					mapParam.put(itemDet.getIdFtParam(), itemDet);

					mapPeriodoxParam.put(keyQuebra, mapParam);
				}
			}

			grafico.getIndicadoresEstatisticos().add(
					detalhe.getIndicadoresCEP());
		}

		// percorrer Maps e criar entradas para parametros que faltam na matriz
		// período x parâmetros
		Set<String> chavesPeriodo = mapPeriodoxParam.keySet();
		for (String periodo : chavesPeriodo) {
			GraficoCEPPeriodoDTO itemPeriodo = new GraficoCEPPeriodoDTO();
			itemPeriodo.setDthrIni(mapPeriodo.get(periodo).getDthrIni());
			itemPeriodo.setDthrFim(mapPeriodo.get(periodo).getDthrFim());
			itemPeriodo.setCdTurno(mapPeriodo.get(periodo).getCdTurno());
			itemPeriodo.setDsTurno(mapPeriodo.get(periodo).getDsTurno());
			itemPeriodo.setDtTurno(mapPeriodo.get(periodo).getDtTurno());
			itemPeriodo.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

			switch (quebraPeriodo) {
			case GRAFICO_CNC_POR_HORA:
				keyQuebra = itemPeriodo.getDthrIni().toString() + "; " + itemPeriodo.getDthrFim().toString();
				break;
			case GRAFICO_CNC_POR_DATA_TURNO:
				keyQuebra = itemPeriodo.getCdTurno() + ";" + itemPeriodo.getDtTurno().toString();
				break;
			case GRAFICO_CNC_POR_DATA:
				keyQuebra = itemPeriodo.getDtTurno().toString();
				break;
			}

			Set<Long> chavesParam = mapParametros.keySet();
			for (Long chave : chavesParam) {
				Map<Long, GraficoCEPDetParamDTO> mapParam = mapPeriodoxParam.get(keyQuebra);
				if (!mapParam.containsKey(chave)) {
					GraficoCEPDetParamDTO detParamVazio = new GraficoCEPDetParamDTO();
					detParamVazio.setIdFtParam(chave);
					detParamVazio.setDsFtParam(mapParametros.get(chave));
					detParamVazio.setDetParam(new DetalheMonitorizacaoCEPDTO());
					detParamVazio.setDtReferenciaParaToolTip(DataHoraRN.getDataHoraAtual());
					detParamVazio.setDwturnoParaToolTip(new DwTurno());

					itemPeriodo.getParametros().add(detParamVazio);
				} else {
					itemPeriodo.getParametros().add(mapParam.get(chave));
				}
			}

			grafico.getItemGrafico().add(itemPeriodo);
		}

		// percorre lista e atribui indice
		int i = 0;
		for (GraficoCEPPeriodoDTO periodo : grafico.getItemGrafico()) {
			periodo.setIdItemDTO(i);
			i++;
		}

		// system.out.println("fim - " + new Date());

		return grafico;
	}

	public IndicadoresEstatisticosCEPDTO getIndicadoresEstatisticosCEP2(Byte tpReferencia, Long idFtParam, FolhaCEPDTO folhaCEP, List<Object> listaIdConsolId, Integer tamanhoAmostra) 
	{
		IndicadoresEstatisticosCEPDTO indicadores = new IndicadoresEstatisticosCEPDTO();
		ListaParametrosCEPDTO listaParametros = getListaParametrosCEP(true);

		BigDecimal mediasAcumuladas = BigDecimal.ZERO;
		BigDecimal amplitudesAcumuladas = BigDecimal.ZERO;
		BigDecimal somaQuadrados = BigDecimal.ZERO;
		BigDecimal somaVlrLidos = BigDecimal.ZERO;
		BigDecimal xBarraBarra = BigDecimal.ZERO;
		BigDecimal rBarra = BigDecimal.ZERO;
		BigDecimal xBarraCP = BigDecimal.ZERO;
		Integer somaQtdOcorr = 0;

		String str_idConsolid = listaIdConsolId.toString();
		str_idConsolid = str_idConsolid.toString().replace("[", "");
		str_idConsolid = str_idConsolid.toString().replace("]", "");		
		String strSQL = "";
		
		for (DetalheMonitorizacaoCEPDTO itemGrafico : folhaCEP
				.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
			mediasAcumuladas = mediasAcumuladas.add(itemGrafico.getVlMedio());
			amplitudesAcumuladas = amplitudesAcumuladas.add(
					itemGrafico.getVlMaximo()).subtract(
					itemGrafico.getVlMinimo());
			somaVlrLidos = somaVlrLidos.add(itemGrafico.getVlSomado());
			somaQtdOcorr = somaQtdOcorr + itemGrafico.getQtMedicoes();
		}
		
		if (somaQtdOcorr > 0)
		{
			xBarraCP = somaVlrLidos.divide(new BigDecimal(somaQtdOcorr), BigDecimal.ROUND_HALF_EVEN);
		}
		else
		{
			xBarraCP = BigDecimal.ZERO;
		}
	
		indicadores.setIdFtParam(folhaCEP.getIdFtParam());

		for (ParametroCEPDTO param : listaParametros.getParametrosCEP()) {
			if (param.getIdFtParam().equals(folhaCEP.getIdFtParam())) {
				indicadores.setDsFtParam(param.getDsParametro());
				break;
			}
		}

		indicadores.setN(tamanhoAmostra.intValue());
		indicadores.setM(folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP()
				.size());

		if (indicadores.getM() > 0)
		{
			xBarraBarra = mediasAcumuladas.divide(
					new BigDecimal(indicadores.getM()), BigDecimal.ROUND_HALF_EVEN);
			if (indicadores.getN().equals(BigDecimal.ONE)) {
				if (indicadores.getM().equals(BigDecimal.ONE)) {
					rBarra = BigDecimal.ZERO;
				} else {
					rBarra = amplitudesAcumuladas.divide(
							new BigDecimal(indicadores.getM() - 1),
							BigDecimal.ROUND_HALF_EVEN);
				}
			} else {
				rBarra = amplitudesAcumuladas.divide(
						new BigDecimal(indicadores.getM()),
						BigDecimal.ROUND_HALF_EVEN);
			}
			indicadores.setLsc_X(AritmeticaUtil.somar(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
			indicadores.setLc_X(xBarraBarra);
			indicadores.setLic_X(AritmeticaUtil.diminuir(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
	
			indicadores.setLsc_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D4 * rBarra.intValue()));
			indicadores.setLc_R(rBarra);
			indicadores.setLic_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D3 * rBarra.intValue()));
			
			strSQL = "SELECT COUNT(c.vlr_lido) as vlr_lido,";
			strSQL = strSQL.concat(" SUM( (c.vlr_lido - " + xBarraCP.toString() + ") * (c.vlr_lido - " + xBarraCP.toString() + ")) as soma_quadrados ");
			strSQL = strSQL.concat(" FROM dw_consol_param a ");
			strSQL = strSQL.concat(" JOIN dw_consol_parammed b ON (b.id_consolparam = a.id_consolparam) ");
			strSQL = strSQL.concat(" JOIN dw_consolmedparamlog c ON (c.id_consolmedparamlog = b.id_consolmedparamlog)");
			strSQL = strSQL.concat(" JOIN dw_consol e ON (e.id_consol = a.id_consol) ");
			strSQL = strSQL.concat(" JOIN dw_consolid f ON (f.id_consolid = e.id_consolid) ");
			strSQL = strSQL.concat(" WHERE a.tp_referencia = " + tpReferencia);
			strSQL = strSQL.concat("   AND a.id_ft_param = " + idFtParam);
			strSQL = strSQL.concat("   AND f.id_consolid in (" + str_idConsolid + ")");
			Object[] resumo = (Object[]) this.getDaoSession().createSQLQuery(strSQL).setMaxResults(1).uniqueResult();
	
			somaQuadrados = ConversaoTipos.converterParaBigDecimal(resumo[1]);
			
			if (somaQuadrados != null && (somaQtdOcorr - 1) > 0) {
				indicadores.setDesvioPadrao(new BigDecimal(Math.sqrt(somaQuadrados
						.divide(new BigDecimal(somaQtdOcorr - 1),
								BigDecimal.ROUND_HALF_EVEN).doubleValue())));
			}
	
			if (indicadores.getDesvioPadrao() != null) {
				if (indicadores.getDesvioPadrao().doubleValue() > 0d) {
					if (folhaCEP != null && folhaCEP.getTemMinimo() != null
							&& folhaCEP.getTemMinimo() == true
							&& folhaCEP.getTemMeta() != null
							&& folhaCEP.getTemMeta() == true
							&& folhaCEP.getTemMaximo() != null
							&& folhaCEP.getTemMaximo() == true) {
						/*
						 * CP = (dblLSE - dblLIE) / (6 * dblDesvioPadrao) CPI =
						 * (dblXBarraCP - dblLIE) / (3 * dblDesvioPadrao) CPS =
						 * (dblLSE - dblXBarraCP) / (3 * dblDesvioPadrao) CPK =
						 * IIf(dblCPS < dblCPI, dblCPS, dblCPI)
						 */
	
						indicadores.setCp((folhaCEP.getLimCriticoSup()
								.subtract(folhaCEP.getLimCriticoInf())).divide(
								new BigDecimal(6).multiply(indicadores
										.getDesvioPadrao()),
								BigDecimal.ROUND_HALF_EVEN));
						indicadores.setCpi((xBarraCP.subtract(folhaCEP
								.getLimCriticoInf())).divide(new BigDecimal(3)
								.multiply(indicadores.getDesvioPadrao()),
								BigDecimal.ROUND_HALF_EVEN));
						indicadores.setCps((folhaCEP.getLimCriticoSup()
								.subtract(xBarraCP)).divide(new BigDecimal(3)
								.multiply(indicadores.getDesvioPadrao()),
								BigDecimal.ROUND_HALF_EVEN));
						indicadores
								.setCpk(indicadores.getCps().doubleValue() < indicadores
										.getCpi().doubleValue() ? indicadores
										.getCps() : indicadores.getCpi());
					} else {
						if (folhaCEP != null && folhaCEP.getTemMinimo() != null
								&& folhaCEP.getTemMinimo() == true
								&& folhaCEP.getTemMeta() != null
								&& folhaCEP.getTemMeta() == false
								&& folhaCEP.getTemMaximo() != null
								&& folhaCEP.getTemMaximo() == false) {
							indicadores.setCpi((xBarraCP.subtract(folhaCEP
									.getLimCriticoInf())).divide(new BigDecimal(3)
									.multiply(indicadores.getDesvioPadrao()),
									BigDecimal.ROUND_HALF_EVEN));
							indicadores.setCpk(indicadores.getCpi());
						} else {
							if (folhaCEP != null && folhaCEP.getTemMinimo() != null
									&& folhaCEP.getTemMinimo() == false
									&& folhaCEP.getTemMeta() != null
									&& folhaCEP.getTemMeta() == false
									&& folhaCEP.getTemMaximo() != null
									&& folhaCEP.getTemMaximo() == true) {
								indicadores.setCps((folhaCEP.getLimCriticoSup()
										.subtract(xBarraCP)).divide(new BigDecimal(
										3).multiply(indicadores.getDesvioPadrao()),
										BigDecimal.ROUND_HALF_EVEN));
								indicadores.setCpk(indicadores.getCps());
							}
						}
					}
				}
			}
		}
		else
		{
			xBarraBarra = BigDecimal.ZERO;
			rBarra = BigDecimal.ZERO;
			indicadores.setLsc_X(AritmeticaUtil.somar(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
			indicadores.setLc_X(xBarraBarra);
			indicadores.setLic_X(AritmeticaUtil.diminuir(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
	
			indicadores.setLsc_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D4 * rBarra.intValue()));
			indicadores.setLc_R(rBarra);
			indicadores.setLic_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D3 * rBarra.intValue()));
			
			indicadores.setDesvioPadrao(null);
		}
		
		if (somaQtdOcorr < 6) {
			indicadores.setLic_R(null);
		}

		return indicadores;
	}


	public IndicadoresEstatisticosCEPDTO getIndicadoresEstatisticosCEP2INJET(DAOGenericoInjet daoInj, DAOGenerico daoVF,  Byte tpReferencia, Long idFtParam, FolhaCEPDTO folhaCEP, List<DwConsolid> listaDwconsolid, Integer tamanhoAmostra) 
	{
		IndicadoresEstatisticosCEPDTO indicadores = new IndicadoresEstatisticosCEPDTO();
		ListaParametrosCEPDTO listaParametros = getListaParametrosCEP(true);

		BigDecimal mediasAcumuladas = BigDecimal.ZERO;
		BigDecimal amplitudesAcumuladas = BigDecimal.ZERO;
		BigDecimal somaQuadrados = BigDecimal.ZERO;
		BigDecimal somaVlrLidos = BigDecimal.ZERO;
		BigDecimal xBarraBarra = BigDecimal.ZERO;
		BigDecimal rBarra = BigDecimal.ZERO;
		BigDecimal xBarraCP = BigDecimal.ZERO;
		Integer somaQtdOcorr = 0;

		//180816 String str_idConsolid = listaIdConsolId.toString();
		//180816 str_idConsolid = str_idConsolid.toString().replace("[", "");
		//180816 str_idConsolid = str_idConsolid.toString().replace("]", "");
		
		String strSQL = "";
		
		for (DetalheMonitorizacaoCEPDTO itemGrafico : folhaCEP
				.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
			mediasAcumuladas = mediasAcumuladas.add(itemGrafico.getVlMedio());
			amplitudesAcumuladas = amplitudesAcumuladas.add(
					itemGrafico.getVlMaximo()).subtract(
					itemGrafico.getVlMinimo());
			somaVlrLidos = somaVlrLidos.add(itemGrafico.getVlSomado());
			somaQtdOcorr = somaQtdOcorr + itemGrafico.getQtMedicoes();
		}
		
		if (somaQtdOcorr > 0)
		{
			xBarraCP = somaVlrLidos.divide(new BigDecimal(somaQtdOcorr), BigDecimal.ROUND_HALF_EVEN);
		}
		else
		{
			xBarraCP = BigDecimal.ZERO;
		}
	
		indicadores.setIdFtParam(folhaCEP.getIdFtParam());

		for (ParametroCEPDTO param : listaParametros.getParametrosCEP()) {
			if (param.getIdFtParam().equals(folhaCEP.getIdFtParam())) {
				indicadores.setDsFtParam(param.getDsParametro());
				break;
			}
		}

		indicadores.setN(tamanhoAmostra.intValue());
		
		try {
			indicadores.setM(folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP().get(0).getQtMedicoes());
		}catch (Exception e){
			
		}
		
		//indicadores.setM(1);		

		if (indicadores.getM() > 0)
		{
			xBarraBarra = mediasAcumuladas.divide(
					new BigDecimal(indicadores.getM()), BigDecimal.ROUND_HALF_EVEN);
			if (indicadores.getN().equals(BigDecimal.ONE)) {
				if (indicadores.getM().equals(BigDecimal.ONE)) {
					rBarra = BigDecimal.ZERO;
				} else {
					rBarra = amplitudesAcumuladas.divide(
							new BigDecimal(indicadores.getM() - 1),
							BigDecimal.ROUND_HALF_EVEN);
				}
			} else {
				rBarra = amplitudesAcumuladas.divide(
						new BigDecimal(indicadores.getM()),
						BigDecimal.ROUND_HALF_EVEN);
			}
			indicadores.setLsc_X(AritmeticaUtil.somar(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
			indicadores.setLc_X(xBarraBarra);
			indicadores.setLic_X(AritmeticaUtil.diminuir(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
	
			indicadores.setLsc_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D4 * rBarra.intValue()));
			indicadores.setLc_R(rBarra);
			indicadores.setLic_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D3 * rBarra.intValue()));
			
			for (DwConsolid id : listaDwconsolid) {//180816
				id.getTpId();
				//180816
				String cdCP = id.getPpCp().getCdCp();
				String cdPt = id.getOmPt().getCdPt();
				Date dthrIniTur = id.getDthrIturno();
				Date dthrFimTur = id.getDthrFturno();
				//180816
				List<PeriodoDTO> listaPeriodosOP = new ArrayList<>();
				PlanejamentoInjetRN ijRN = new PlanejamentoInjetRN(daoInj);
				listaPeriodosOP = ijRN.getPeriodosOPTurno(cdPt, cdCP, dthrIniTur, dthrFimTur);

				for (PeriodoDTO periodo : listaPeriodosOP) {//180816
					strSQL = "SELECT COUNT(c.vlr_lido) as vlr_lido,";
					strSQL = strSQL.concat(" SUM( (c.vlr_lido - " + xBarraCP.toString() + ") * (c.vlr_lido - " + xBarraCP.toString() + ")) as soma_quadrados,");
					strSQL = strSQL.concat("STDEV( c.vlr_lido) as desvio_padrao,");
					strSQL = strSQL.concat("AVG( c.vlr_lido) as media");
					strSQL = strSQL.concat(" FROM dw_consol_param a ");
					strSQL = strSQL.concat(" JOIN dw_consol_parammed b ON (b.id_consolparam = a.id_consolparam) ");
					strSQL = strSQL.concat(" JOIN dw_consolmedparamlog c ON (c.id_consolmedparamlog = b.id_consolmedparamlog)");
					strSQL = strSQL.concat(" JOIN dw_consol e ON (e.id_consol = a.id_consol) ");
					strSQL = strSQL.concat(" JOIN dw_consolid f ON (f.id_consolid = e.id_consolid) and f.tp_id ="+id.getTpId().intValue());
					strSQL = strSQL.concat(" JOIN om_pt g ON (g.id_pt = f.id_pt) ");
					strSQL = strSQL.concat(" WHERE a.tp_referencia = " + tpReferencia);
					strSQL = strSQL.concat("   AND a.id_ft_param = " + idFtParam);
					//180816 strSQL = strSQL.concat("   AND f.id_consolid in (" + str_idConsolid + ")");
					//strSQL = strSQL.concat("   AND c.dthr_medicao BETWEEN '" + DataHoraRN.dateToStringYYYYMMDDHHMMSS( periodo.getDtHrInicio() ) + "' AND '" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(  periodo.getDtHrFim() ) + "' " );
					strSQL = strSQL.concat("   AND c.dthr_medicao BETWEEN :dthrini AND :dthrfim ");
					strSQL = strSQL.concat("   AND g.cd_pt = '" + cdPt + "' ");
					
					Object[] resumo = (Object[]) this.getDaoSession().createSQLQuery(strSQL).setTimestamp("dthrini", periodo.getDtHrInicio()).setTimestamp("dthrfim", periodo.getDtHrFim()).setMaxResults(1).uniqueResult();
					
					// teste abaixo necessario pq eventualmente pode haver intervalo sem coleta CEP
					if (resumo[1] != null) {
						somaQuadrados = somaQuadrados.add(  ConversaoTipos.converterParaBigDecimal(resumo[1]) );
					}
					
					// Adicionando o desvio padrao
					if (resumo[2] != null) {
						indicadores.setDesvioPadrao(ConversaoTipos.converterParaBigDecimal(resumo[2]));
					}
					
					// Adicionando a media dos valores
					if (resumo[3] != null) {
						indicadores.setMedia(ConversaoTipos.converterParaBigDecimal(resumo[3]));
					}
			
					
				}
			}
			//180816 somaQuadrados =  ConversaoTipos.converterParaBigDecimal(resumo[1]) ;
			
//			// Comentado: Usar o desvio padrao calculado pelo banco
//			if (somaQuadrados != null && (somaQtdOcorr - 1) > 0) {
//				indicadores.setDesvioPadrao(new BigDecimal(Math.sqrt(somaQuadrados
//						.divide(new BigDecimal(somaQtdOcorr - 1),
//								BigDecimal.ROUND_HALF_EVEN).doubleValue())));
//			}
//	
			if (indicadores.getDesvioPadrao() != null) {
				if (indicadores.getDesvioPadrao().doubleValue() > 0d) {
					if (folhaCEP != null && folhaCEP.getTemMinimo() != null
							&& folhaCEP.getTemMinimo() == true
							&& folhaCEP.getTemMeta() != null
							&& folhaCEP.getTemMeta() == true
							&& folhaCEP.getTemMaximo() != null
							&& folhaCEP.getTemMaximo() == true) {
						/*
						 * CP = (dblLSE - dblLIE) / (6 * dblDesvioPadrao) CPI =
						 * (dblXBarraCP - dblLIE) / (3 * dblDesvioPadrao) CPS =
						 * (dblLSE - dblXBarraCP) / (3 * dblDesvioPadrao) CPK =
						 * IIf(dblCPS < dblCPI, dblCPS, dblCPI)
						 */
	
						indicadores.setCp((folhaCEP.getLimCriticoSup()
								.subtract(folhaCEP.getLimCriticoInf())).divide(
								new BigDecimal(6).multiply(indicadores
										.getDesvioPadrao()),
								BigDecimal.ROUND_HALF_EVEN));
//						indicadores.setCpi((xBarraCP.subtract(folhaCEP
//								.getLimCriticoInf())).divide(new BigDecimal(3)
//								.multiply(indicadores.getDesvioPadrao()),
//								BigDecimal.ROUND_HALF_EVEN));
//						indicadores.setCps((folhaCEP.getLimCriticoSup()
//								.subtract(xBarraCP)).divide(new BigDecimal(3)
//								.multiply(indicadores.getDesvioPadrao()),
//								BigDecimal.ROUND_HALF_EVEN));

						indicadores.setCpi((indicadores.getMedia().subtract(folhaCEP
								.getLimCriticoInf())).divide(new BigDecimal(3)
								.multiply(indicadores.getDesvioPadrao()),
								BigDecimal.ROUND_HALF_EVEN));
						indicadores.setCps((folhaCEP.getLimCriticoSup()
								.subtract(indicadores.getMedia())).divide(new BigDecimal(3)
								.multiply(indicadores.getDesvioPadrao()),
								BigDecimal.ROUND_HALF_EVEN));
						indicadores
								.setCpk(indicadores.getCps().doubleValue() < indicadores
										.getCpi().doubleValue() ? indicadores
										.getCps() : indicadores.getCpi());
						
						// Correção conforme Juce para dados iguais ao do injet
						indicadores.setLc_R(new BigDecimal(0.0));
						indicadores.setLsc_R(new BigDecimal(0.0));
						indicadores.setLic_R(null);
						indicadores.setLc_X(new BigDecimal(indicadores.getMedia().doubleValue()));
						indicadores.setLsc_X(new BigDecimal(indicadores.getMedia().doubleValue()));
						indicadores.setLic_X(new BigDecimal(indicadores.getMedia().doubleValue()));
						
					} else {
						if (folhaCEP != null && folhaCEP.getTemMinimo() != null
								&& folhaCEP.getTemMinimo() == true
								&& folhaCEP.getTemMeta() != null
								&& folhaCEP.getTemMeta() == false
								&& folhaCEP.getTemMaximo() != null
								&& folhaCEP.getTemMaximo() == false) {
							indicadores.setCpi((xBarraCP.subtract(folhaCEP
									.getLimCriticoInf())).divide(new BigDecimal(3)
									.multiply(indicadores.getDesvioPadrao()),
									BigDecimal.ROUND_HALF_EVEN));
							indicadores.setCpk(indicadores.getCpi());
						} else {
							if (folhaCEP != null && folhaCEP.getTemMinimo() != null
									&& folhaCEP.getTemMinimo() == false
									&& folhaCEP.getTemMeta() != null
									&& folhaCEP.getTemMeta() == false
									&& folhaCEP.getTemMaximo() != null
									&& folhaCEP.getTemMaximo() == true) {
								indicadores.setCps((folhaCEP.getLimCriticoSup()
										.subtract(xBarraCP)).divide(new BigDecimal(
										3).multiply(indicadores.getDesvioPadrao()),
										BigDecimal.ROUND_HALF_EVEN));
								indicadores.setCpk(indicadores.getCps());
							}
						}
					}
				}
			}
		}
		else
		{
			xBarraBarra = BigDecimal.ZERO;
			rBarra = BigDecimal.ZERO;
			indicadores.setLsc_X(AritmeticaUtil.somar(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
			indicadores.setLc_X(xBarraBarra);
			indicadores.setLic_X(AritmeticaUtil.diminuir(
					xBarraBarra,
					ConstanteCartaControleDTO.get(indicadores.getN()).A2
							* rBarra.intValue()));
	
			indicadores.setLsc_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D4 * rBarra.intValue()));
			indicadores.setLc_R(rBarra);
			indicadores.setLic_R(new BigDecimal(ConstanteCartaControleDTO
					.get(indicadores.getN()).D3 * rBarra.intValue()));
			
			indicadores.setDesvioPadrao(null);
		}
		
		if (somaQtdOcorr < 6) {
			indicadores.setLic_R(null);
		}

		return indicadores;
	}
	

	/*
	 * Metodo para retornar o grafico x do cep
	 */
	public DetalheCEPDTO getDetalheCEPGraf2(Byte quebraPeriodo, Byte tpReferencia, Long idFtParam, FiltroDetalhePTInjetDTO filtro) {
		DetalheCEPDTO retorno = new DetalheCEPDTO();
		
		List<Object> listaIdConsolId = getListaIdConsol(filtro);
				
		MapQuery qDet = new MapQuery(getDaoSession());
		String hql_agrupamento = "";
		byte _somar = 0;

		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();
		FolhaCEPDTO folhaCEPLimites = new FolhaCEPDTO();
		FolhaCEPDTO folhaSemDet =new FolhaCEPDTO();
		DetalheMonitorizacaoCEPDTO itemLista = new DetalheMonitorizacaoCEPDTO();

		// recuperar todos os diferentes conjuntos formados por idfolha + idftparam
		retorno.setListaFolhasCEP(new ListaFolhaCEPDTO());
		retorno.getListaFolhasCEP().setListaFolhas(new ArrayList<FolhaCEPDTO>());

		if (listaIdConsolId.size() > 0) {
			FolhaRN frn = new FolhaRN(getDao());
			DwFolha dwfolha = null;
			dwfolha = frn.getDwFolhaByOmPt(filtro.getOmPt(), DwFolhaTemplate.TpFolha.MEDICAO_TEMPERATURA.getValue());
			if (dwfolha != null)
				folhaCEPLimites = getFolhasCEP(filtro.getOmPt(), idFtParam);
			
			
			folhaCEP = getFolhasCEP(filtro.getOmPt(), idFtParam);
			folhaSemDet = getCopiaFolhaSemDetalhamento(folhaCEPLimites);
	
			// recuperar resumo do período do conjunto folha + param
			switch (quebraPeriodo) {
			case GRAFICO_CNC_POR_HORA:
				hql_agrupamento = " e.dthrIhora, e.dthrFhora,";
				_somar = 2;
				break;
	
			case GRAFICO_CNC_POR_DATA_TURNO:
				hql_agrupamento = " e.dtReferencia, e.dwTurno.cdTurno, e.dwTurno.dsTurno, ";
				_somar = 3;
				break;
			case GRAFICO_CNC_POR_DATA:
				hql_agrupamento = " e.dtReferencia,";
				_somar = 1;
				break;
			}
	
			if (getIsTemperaturaZona(idFtParam)) {
				hql_agrupamento =  " a.zona," + hql_agrupamento;
				_somar =  (byte) (_somar +  1);				
			}
			
			_graf_tpReferencia = (byte) (_tpReferencia + _somar);
			_graf_idFolha = (byte) (_idFolha + _somar);
			_graf_cdFtgrupo = (byte) (_cdFtgrupo + _somar);
			_graf_dsFtgrupo = (byte) (_dsFtgrupo + _somar);
			_graf_idFtParam = (byte) (_idFtParam + _somar);
			_graf_dsParametro = (byte) (_dsParametro + _somar);
			_graf_vlMinimo = (byte) (_vlMinimo + _somar);
			_graf_vlMedio = (byte) (_vlMedio + _somar);
			_graf_vlMaximo = (byte) (_vlMaximo + _somar);
			_graf_vlSomado = (byte) (_vlSomado + _somar);
			_graf_qtMedicoes = (byte) (_qtMedicoes + _somar);
			_graf_vlMonetario = (byte) (_vlMonetario + _somar);
			_graf_vlUltimo = (byte) (_vlUltimo + _somar);
	
			qDet = new MapQuery(getDaoSession());
			qDet.append("SELECT " + hql_agrupamento + " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro,");
			qDet.append("       MIN(a.vlMinimo) as vlMinimo, ");
			qDet.append("       AVG(a.vlMedio) as vlMedio, ");
			qDet.append("       MAX(a.vlMaximo) as vlMaximo, ");
			qDet.append("       SUM(a.vlSomado) as vlSomado, ");
			qDet.append("       SUM(a.qtMedicoes) as qtMedicoes, ");
			qDet.append("       SUM(a.vlMonetario) as vlMonetario ");
			qDet.append("  FROM DwConsolParam a");
			qDet.append("  JOIN a.dwFtParam b ");
			qDet.append("  JOIN b.dwFtGrupo c ");
			qDet.append("  JOIN a.dwConsol d ");
			qDet.append("  JOIN d.dwConsolid e ");
			// tirei o filtro por folha
			//qDet.append("  WHERE e.dwFolha.idFolha = :idFolha ");
			qDet.append("    WHERE a.tpReferencia  = :tpReferencia ");
			if (idFtParam > 0){
				qDet.append("    AND b.idFtParam  = :idFtParam ");
			}
			qDet.append("    AND e.idConsolid IN (:listaIdConsolId) ");
			
			if (getIsTemperaturaZona(idFtParam)) {
				//qDet.append("   AND e.idConsolid = (SELECT MAX(cut.idConsolid) FROM DwConsolid cut WHERE cut.idConsolid IN (:listaIdConsolId))");
				qDet.append("   AND e.idConsolid = (SELECT MAX(cid.idConsolid) ");
				qDet.append("                         FROM DwConsolid cid ");
				qDet.append("                         JOIN cid.dwConsols con ");
				qDet.append("                         JOIN con.dwConsolParams cparam ");
				qDet.append("                        WHERE cid.idConsolid IN (:listaIdConsolId)");
				qDet.append("                          AND cparam.dwFtParam.idFtParam  = :idFtParam )");
				
			}
			
			
			qDet.append("  GROUP BY " + hql_agrupamento  + " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro");
	
			// Tirei o filtor por folha
			//qDet.defineParametro("idFolha", folhaCEP.getIdFolha());

			if (idFtParam > 0){
				qDet.defineParametro("idFtParam", folhaCEP.getIdFtParam());
			}
			qDet.defineParametro("tpReferencia",tpReferencia);
			qDet.defineListaParametro("listaIdConsolId", listaIdConsolId);
	
			List<Object> lista = qDet.list();
	
			for (Object reg : lista) {
				Object[] registro = (Object[]) reg;
				itemLista = new DetalheMonitorizacaoCEPDTO();

				if (getIsTemperaturaZona(idFtParam)) {
					itemLista.setZona((Byte) registro[_graf_zona]);;
					
					switch (quebraPeriodo) {
					case GRAFICO_CNC_POR_HORA:
						itemLista.setDthrIni((Date) registro[_graf_zona_hora_dthrini]);
						itemLista.setDthrFim((Date) registro[_graf_zona_hora_dthrfim]);
						break;
		
					case GRAFICO_CNC_POR_DATA_TURNO:
						itemLista.setDtTurno((Date) registro[_graf_zona_data_turno_data]);
						itemLista.setCdTurno(registro[_graf_zona_data_turno_cdturno].toString());
						break;
		
					case GRAFICO_CNC_POR_DATA:
						itemLista.setDtTurno((Date) registro[_graf_zona_data_data]);
						break;
					}
					
					
				} else {				
					switch (quebraPeriodo) {
					case GRAFICO_CNC_POR_HORA:
						itemLista.setDthrIni((Date) registro[_graf_hora_dthrini]);
						itemLista.setDthrFim((Date) registro[_graf_hora_dthrfim]);
						break;
		
					case GRAFICO_CNC_POR_DATA_TURNO:
						itemLista.setDtTurno((Date) registro[_graf_data_turno_data]);
						itemLista.setCdTurno(registro[_graf_data_turno_cdturno].toString());
						break;
		
					case GRAFICO_CNC_POR_DATA:
						itemLista.setDtTurno((Date) registro[_graf_data_data]);
						break;
					}
				}				
				
				itemLista.setTpReferencia((Byte) registro[_graf_tpReferencia]);
				itemLista.setCdFtGrupo(registro[_graf_cdFtgrupo].toString());
				itemLista.setDsFtGrupo(registro[_graf_dsFtgrupo].toString());
				itemLista.setIdFtParam((Long) registro[_graf_idFtParam]);
				itemLista.setDsParamentro(registro[_graf_dsParametro].toString());
				itemLista.setVlMinimo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMinimo]));
				itemLista.setVlMedio(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMedio]));
				itemLista.setVlMaximo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMaximo]));
				itemLista.setVlSomado(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlSomado]));
				itemLista.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(registro[_graf_qtMedicoes]).intValue());
				itemLista.setVlMonetario(ConversaoTipos.converterParaBigDecimal((registro[_graf_vlMonetario] == null ? 0
										: registro[_graf_vlMonetario])));

				
				//itemLista.setListaOcorrencias(getListaOcorrenciasCEP2(itemLista.getTpReferencia(), folhaCEP.getIdFtParam(), folhaCEP.getIdFolha(), listaIdConsolId));

				DetalheMonitorizacaoCEPOcorrDTO ultimaocorrencia =  new DetalheMonitorizacaoCEPOcorrDTO();
				
				//BUG ultimaocorrencia = getUltimaOcorrenciaCEP(itemLista.getTpReferencia(), folhaCEP.getIdFtParam(), folhaCEP.getIdFolha(), listaIdConsolId);
				ultimaocorrencia = getUltimaOcorrenciaCEP(itemLista.getTpReferencia(), itemLista.getIdFtParam(), folhaCEP.getIdFolha(), listaIdConsolId);

				if (ultimaocorrencia!=null && ultimaocorrencia.getVlrLido()!=null){
					itemLista.setVlUltimo(ultimaocorrencia.getVlrLido());	
				}
				
				
				
				itemLista.setFolhaCEPSemListas(folhaSemDet);
	
				folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP().add(itemLista);
			}
	
			folhaCEP.setIndicadoresCEP(getIndicadoresEstatisticosCEP2(tpReferencia, idFtParam, folhaCEP, listaIdConsolId, 1));
			retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
		}
		qDet = null;
		
		return retorno;
	}
	
	public DetalheCEPDTO getDetalheCEPGraf3(Byte quebraPeriodo, Byte tpReferencia, Long idFtParam, FiltroDetalhePTInjetDTO filtro) {
		DetalheCEPDTO retorno = new DetalheCEPDTO();
		
		List<Object> listaIdConsolId = getListaIdConsol2(filtro);
				
		MapQuery qDet = new MapQuery(getDaoSession());
		String hql_agrupamento = "";
		byte _somar = 0;

		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();
		FolhaCEPDTO folhaCEPLimites = new FolhaCEPDTO();
		FolhaCEPDTO folhaSemDet =new FolhaCEPDTO();
		DetalheMonitorizacaoCEPDTO itemLista = new DetalheMonitorizacaoCEPDTO();

		// recuperar todos os diferentes conjuntos formados por idfolha + idftparam
		retorno.setListaFolhasCEP(new ListaFolhaCEPDTO());
		retorno.getListaFolhasCEP().setListaFolhas(new ArrayList<FolhaCEPDTO>());

		if (listaIdConsolId.size() > 0) {
			FolhaRN frn = new FolhaRN(getDao());
			DwFolha dwfolha = null;
			dwfolha = frn.getDwFolhaByOmPt(filtro.getOmPt(), DwFolhaTemplate.TpFolha.MEDICAO_TEMPERATURA.getValue());
			if (dwfolha != null)
				folhaCEPLimites = getFolhasCEP(filtro.getOmPt(), idFtParam);
			
			
			folhaCEP = getFolhasCEP(filtro.getOmPt(), idFtParam);
			folhaSemDet = getCopiaFolhaSemDetalhamento(folhaCEPLimites);
	
			// recuperar resumo do período do conjunto folha + param
			switch (quebraPeriodo) {
			case GRAFICO_CNC_POR_HORA:
				hql_agrupamento = " e.dthrIhora, e.dthrFhora,";
				_somar = 2;
				break;
	
			case GRAFICO_CNC_POR_DATA_TURNO:
				hql_agrupamento = " e.dtReferencia, e.dwTurno.cdTurno, e.dwTurno.dsTurno, ";
				_somar = 3;
				break;
			case GRAFICO_CNC_POR_DATA:
				hql_agrupamento = " e.dtReferencia,";
				_somar = 1;
				break;
			}
	
			if (getIsTemperaturaZona(idFtParam)) {
				hql_agrupamento =  " a.zona," + hql_agrupamento;
				_somar =  (byte) (_somar +  1);				
			}
			
			_graf_tpReferencia = (byte) (_tpReferencia + _somar);
			_graf_idFolha = (byte) (_idFolha + _somar);
			_graf_cdFtgrupo = (byte) (_cdFtgrupo + _somar);
			_graf_dsFtgrupo = (byte) (_dsFtgrupo + _somar);
			_graf_idFtParam = (byte) (_idFtParam + _somar);
			_graf_dsParametro = (byte) (_dsParametro + _somar);
			_graf_vlMinimo = (byte) (_vlMinimo + _somar);
			_graf_vlMedio = (byte) (_vlMedio + _somar);
			_graf_vlMaximo = (byte) (_vlMaximo + _somar);
			_graf_vlSomado = (byte) (_vlSomado + _somar);
			_graf_qtMedicoes = (byte) (_qtMedicoes + _somar);
			_graf_vlMonetario = (byte) (_vlMonetario + _somar);
			_graf_vlUltimo = (byte) (_vlUltimo + _somar);
	
			qDet = new MapQuery(getDaoSession());
			qDet.append("SELECT " + hql_agrupamento + " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro,");
			qDet.append("       MIN(a.vlMinimo) as vlMinimo, ");
			qDet.append("       AVG(a.vlMedio) as vlMedio, ");
			qDet.append("       MAX(a.vlMaximo) as vlMaximo, ");
			qDet.append("       SUM(a.vlSomado) as vlSomado, ");
			qDet.append("       SUM(a.qtMedicoes) as qtMedicoes, ");
			qDet.append("       SUM(a.vlMonetario) as vlMonetario ");
			qDet.append("  FROM DwConsolParam a");
			qDet.append("  JOIN a.dwFtParam b ");
			qDet.append("  JOIN b.dwFtGrupo c ");
			qDet.append("  JOIN a.dwConsol d ");
			qDet.append("  JOIN d.dwConsolid e ");
			// tirei o filtro por folha
			//qDet.append("  WHERE e.dwFolha.idFolha = :idFolha ");
			qDet.append("    WHERE a.tpReferencia  = :tpReferencia ");
			if (idFtParam > 0){
				qDet.append("    AND b.idFtParam  = :idFtParam ");
			}
			qDet.append("    AND e.idConsolid IN (:listaIdConsolId) ");
			
			if (getIsTemperaturaZona(idFtParam)) {
				//qDet.append("   AND e.idConsolid = (SELECT MAX(cut.idConsolid) FROM DwConsolid cut WHERE cut.idConsolid IN (:listaIdConsolId))");
				qDet.append("   AND e.idConsolid = (SELECT MAX(cid.idConsolid) ");
				qDet.append("                         FROM DwConsolid cid ");
				qDet.append("                         JOIN cid.dwConsols con ");
				qDet.append("                         JOIN con.dwConsolParams cparam ");
				qDet.append("                        WHERE cid.idConsolid IN (:listaIdConsolId)");
				qDet.append("                          AND cparam.dwFtParam.idFtParam  = :idFtParam )");
				
			}
			
			
			qDet.append("  GROUP BY " + hql_agrupamento  + " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro");
	
			// Tirei o filtor por folha
			//qDet.defineParametro("idFolha", folhaCEP.getIdFolha());

			if (idFtParam > 0){
				qDet.defineParametro("idFtParam", folhaCEP.getIdFtParam());
			}
			qDet.defineParametro("tpReferencia",tpReferencia);
			qDet.defineListaParametro("listaIdConsolId", listaIdConsolId);
	
			List<Object> lista = qDet.list();
	
			for (Object reg : lista) {
				Object[] registro = (Object[]) reg;
				itemLista = new DetalheMonitorizacaoCEPDTO();

				if (getIsTemperaturaZona(idFtParam)) {
					itemLista.setZona((Byte) registro[_graf_zona]);;
					
					switch (quebraPeriodo) {
					case GRAFICO_CNC_POR_HORA:
						itemLista.setDthrIni((Date) registro[_graf_zona_hora_dthrini]);
						itemLista.setDthrFim((Date) registro[_graf_zona_hora_dthrfim]);
						break;
		
					case GRAFICO_CNC_POR_DATA_TURNO:
						itemLista.setDtTurno((Date) registro[_graf_zona_data_turno_data]);
						itemLista.setCdTurno(registro[_graf_zona_data_turno_cdturno].toString());
						break;
		
					case GRAFICO_CNC_POR_DATA:
						itemLista.setDtTurno((Date) registro[_graf_zona_data_data]);
						break;
					}
					
					
				} else {				
					switch (quebraPeriodo) {
					case GRAFICO_CNC_POR_HORA:
						itemLista.setDthrIni((Date) registro[_graf_hora_dthrini]);
						itemLista.setDthrFim((Date) registro[_graf_hora_dthrfim]);
						break;
		
					case GRAFICO_CNC_POR_DATA_TURNO:
						itemLista.setDtTurno((Date) registro[_graf_data_turno_data]);
						itemLista.setCdTurno(registro[_graf_data_turno_cdturno].toString());
						break;
		
					case GRAFICO_CNC_POR_DATA:
						itemLista.setDtTurno((Date) registro[_graf_data_data]);
						break;
					}
				}				
				
				itemLista.setTpReferencia((Byte) registro[_graf_tpReferencia]);
				itemLista.setCdFtGrupo(registro[_graf_cdFtgrupo].toString());
				itemLista.setDsFtGrupo(registro[_graf_dsFtgrupo].toString());
				itemLista.setIdFtParam((Long) registro[_graf_idFtParam]);
				itemLista.setDsParamentro(registro[_graf_dsParametro].toString());
				itemLista.setVlMinimo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMinimo]));
				itemLista.setVlMedio(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMedio]));
				itemLista.setVlMaximo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMaximo]));
				itemLista.setVlSomado(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlSomado]));
				itemLista.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(registro[_graf_qtMedicoes]).intValue());
				itemLista.setVlMonetario(ConversaoTipos.converterParaBigDecimal((registro[_graf_vlMonetario] == null ? 0
										: registro[_graf_vlMonetario])));

				
				//itemLista.setListaOcorrencias(getListaOcorrenciasCEP2(itemLista.getTpReferencia(), folhaCEP.getIdFtParam(), folhaCEP.getIdFolha(), listaIdConsolId));

				DetalheMonitorizacaoCEPOcorrDTO ultimaocorrencia =  new DetalheMonitorizacaoCEPOcorrDTO();
				//BUG ultimaocorrencia = getUltimaOcorrenciaCEP(itemLista.getTpReferencia(), folhaCEP.getIdFtParam(), folhaCEP.getIdFolha(), listaIdConsolId);
				ultimaocorrencia = getUltimaOcorrenciaCEP(itemLista.getTpReferencia(), itemLista.getIdFtParam(), folhaCEP.getIdFolha(), listaIdConsolId);

				if (ultimaocorrencia!=null && ultimaocorrencia.getVlrLido()!=null){
					itemLista.setVlUltimo(ultimaocorrencia.getVlrLido());	
				}
				
				
				
				itemLista.setFolhaCEPSemListas(folhaSemDet);
	
				folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP().add(itemLista);
			}
	
			folhaCEP.setIndicadoresCEP(getIndicadoresEstatisticosCEP2(tpReferencia, idFtParam, folhaCEP, listaIdConsolId, 1));
			retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
		}
		qDet = null;
		
		return retorno;
	}


	/*
	 * Metodo para retornar o grafico x do cep
	 */
	public DetalheCEPDTO getDetalheCEPGraf2INJET(DAOGenericoInjet daoInj, DAOGenerico daoVF, Byte quebraPeriodo, Byte tpReferencia, Long idFtParam, FiltroDetalhePTInjetDTO filtro) {

		DetalheCEPDTO retorno = new DetalheCEPDTO();
		//List<Object> listaIdConsolId = getListaIdConsol(filtro);
		
		//180816
		DetalheMonitorizacaoPTInjetRN rnptInjet = new DetalheMonitorizacaoPTInjetRN(daoInj.getDao());
		IdwLogger log = new IdwLogger("getDetalheCEPGraf2INJET");
		List<DwConsolid> listaDwconsolid; 
		listaDwconsolid = rnptInjet.pesquisarDwConsolids(log, filtro);

		MapQuery qDet = new MapQuery(getDaoSession());
		String hql_agrupamento = "";
		byte _somar = 0;

		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();
		FolhaCEPDTO folhaCEPLimites = new FolhaCEPDTO();
		FolhaCEPDTO folhaSemDet = new FolhaCEPDTO();
		DetalheMonitorizacaoCEPDTO itemLista = new DetalheMonitorizacaoCEPDTO();

		DetalheMonitorizacaoWebCepInjetRN rnCEP = new DetalheMonitorizacaoWebCepInjetRN(daoInj, BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		
		// recuperar todos os diferentes conjuntos formados por idfolha + idftparam
		retorno.setListaFolhasCEP(new ListaFolhaCEPDTO());
		retorno.getListaFolhasCEP().setListaFolhas(new ArrayList<FolhaCEPDTO>());

		//180815 if (listaIdConsolId.size() > 0) {
		if (listaDwconsolid.size() > 0) { //180815 
			folhaCEP = getFolhasCEP(filtro.getOmPt(), idFtParam);
						
			Map<Long, FolhaCEPDTO> mapFolhasCEP = rnCEP.getLimitesCEP(filtro.getOmPt().getCdPt(), filtro.getCdCp(), idFtParam);
			if (mapFolhasCEP.size() > 0 && idFtParam > 0) {
				if (mapFolhasCEP.get(idFtParam) != null) {
					folhaCEP = getCopiaFolhaSemDetalhamento(mapFolhasCEP.get(idFtParam));
					folhaCEP.setListaDetalheCEP(new ListaDetalheMonitorizacaoCEPDTO());
					folhaCEP.getListaDetalheCEP().setDetMonitorizacaoCEP(new ArrayList<DetalheMonitorizacaoCEPDTO>());					
				}				
			}
						
			
			for (DwConsolid id : listaDwconsolid) {//180816

				//180816
				String cdCP = id.getPpCp().getCdCp();
				String cdPt = id.getOmPt().getCdPt();
				Date dthrIniTur = id.getDthrIturno();
				Date dthrFimTur = id.getDthrFturno();
				//180816
				List<PeriodoDTO> listaPeriodosOP = new ArrayList<>();
				PlanejamentoInjetRN ijRN = new PlanejamentoInjetRN(daoInj);
				listaPeriodosOP = ijRN.getPeriodosOPTurno(cdPt, cdCP, dthrIniTur, dthrFimTur);
		
				for (PeriodoDTO periodo : listaPeriodosOP) {//180816

					FolhaRN frn = new FolhaRN(getDao());
					DwFolha dwfolha = null;
					dwfolha = frn.getDwFolhaByOmPt(filtro.getOmPt(), DwFolhaTemplate.TpFolha.MEDICAO_TEMPERATURA.getValue());
					if (dwfolha != null) {
						folhaCEPLimites = getFolhasCEP(filtro.getOmPt(), idFtParam);
					}
						
					
					
					//folhaCEP = getFolhasCEP(filtro.getOmPt(), idFtParam);
					folhaSemDet = getCopiaFolhaSemDetalhamento(folhaCEPLimites);
					folhaSemDet.setListaDetalheCEP(new ListaDetalheMonitorizacaoCEPDTO());
					folhaSemDet.getListaDetalheCEP().setDetMonitorizacaoCEP(new ArrayList<DetalheMonitorizacaoCEPDTO>());						
			
					// recuperar resumo do período do conjunto folha + param
					switch (quebraPeriodo) {
					case GRAFICO_CNC_POR_HORA:
						hql_agrupamento = " e.dthrIhora, e.dthrFhora,";
						_somar = 2;
						break;
			
					case GRAFICO_CNC_POR_DATA_TURNO:
						hql_agrupamento = " e.dtReferencia, e.dwTurno.cdTurno, e.dwTurno.dsTurno, ";
						_somar = 3;
						break;
					case GRAFICO_CNC_POR_DATA:
						hql_agrupamento = " e.dtReferencia,";
						_somar = 1;
						break;
					case GRAFICO_CNC_RESUMO:
						hql_agrupamento = " ";
						_somar = 0;
						break;						
					}
			
					if (getIsTemperaturaZona(idFtParam)) {
						hql_agrupamento =  " a.zona," + hql_agrupamento;
						_somar =  (byte) (_somar +  1);				
					}
					
					_graf_tpReferencia = (byte) (_tpReferencia + _somar);
					_graf_idFolha = (byte) (_idFolha + _somar);
					_graf_cdFtgrupo = (byte) (_cdFtgrupo + _somar);
					_graf_dsFtgrupo = (byte) (_dsFtgrupo + _somar);
					_graf_idFtParam = (byte) (_idFtParam + _somar);
					_graf_dsParametro = (byte) (_dsParametro + _somar);
					_graf_vlMinimo = (byte) (_vlMinimo + _somar);
					_graf_vlMedio = (byte) (_vlMedio + _somar);
					_graf_vlMaximo = (byte) (_vlMaximo + _somar);
					_graf_vlSomado = (byte) (_vlSomado + _somar);
					_graf_qtMedicoes = (byte) (_qtMedicoes + _somar);
					_graf_vlMonetario = (byte) (_vlMonetario + _somar);
			
					
			    	//q.append("SELECT SUM(CASE WHEN logm.vlrLido IS NULL THEN  0 ELSE logm.vlrLido END) as vlLido, ");
					//q.append("       SUM(CASE WHEN logm.vlMonetario  IS NULL THEN  0 ELSE logm.vlMonetario END) as vlMonetario ");

					
					qDet = new MapQuery(getDaoSession());
					qDet.append("SELECT" + hql_agrupamento + " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro,");
					qDet.append("       MIN(CASE WHEN logm.vlrLido IS NULL THEN  0 ELSE logm.vlrLido END) as vlMinimo, ");
					qDet.append("       AVG(CASE WHEN logm.vlrLido IS NULL THEN  0 ELSE logm.vlrLido END) as vlMedio, ");
					qDet.append("       MAX(CASE WHEN logm.vlrLido IS NULL THEN  0 ELSE logm.vlrLido END) as vlMaximo, ");
					qDet.append("       SUM(CASE WHEN logm.vlrLido IS NULL THEN  0 ELSE logm.vlrLido END) as vlSomado, ");
					qDet.append("       COUNT(logm.vlrLido) as qtMedicoes, ");
					qDet.append("       SUM(CASE WHEN logm.vlMonetario  IS NULL THEN  0 ELSE logm.vlMonetario END) as vlMonetario ");
					qDet.append("  FROM DwConsolParam a");
					qDet.append("  JOIN a.dwFtParam b ");
					qDet.append("  JOIN b.dwFtGrupo c ");
					qDet.append("  JOIN a.dwConsol d ");
					qDet.append("  JOIN d.dwConsolid e ");
					qDet.append("  JOIN a.dwConsolParammeds meds");
					qDet.append("  JOIN meds.dwConsolmedparamlog logm");

					// tirei o filtro por folha
					//qDet.append("  WHERE e.dwFolha.idFolha = :idFolha ");

					qDet.append("    WHERE a.tpReferencia  = :tpReferencia ");
					if (idFtParam > 0)
						qDet.append("    AND b.idFtParam  = :idFtParam ");

					//180816 qDet.append("    AND e.idConsolid IN (:listaIdConsolId) ");

					qDet.append(" AND logm.dthrMedicao BETWEEN :dthrini AND :dthrfim");
					qDet.append(" AND e.omPt.cdPt = :cdpt");
					
					qDet.append(" AND e.tpId = " + (quebraPeriodo == GRAFICO_CNC_POR_HORA ? 0 : 1) );

					if (getIsTemperaturaZona(idFtParam)) {
						//qDet.append("   AND e.idConsolid = (SELECT MAX(cut.idConsolid) FROM DwConsolid cut WHERE cut.idConsolid IN (:listaIdConsolId))");

						qDet.append(" AND e.idConsolid = (SELECT MAX(cid.idConsolid) ");
						qDet.append("                            FROM DwConsolid cid ");
						qDet.append("                            JOIN cid.dwConsols con ");
						qDet.append("                            JOIN con.dwConsolParams cparam ");
						qDet.append("                            JOIN a.dwConsolParammeds meds ");
						qDet.append("                            JOIN meds.dwConsolmedparamlog logm ");
						//180816 qDet.append("                      WHERE cid.idConsolid IN (:listaIdConsolId)");
						qDet.append("                      WHERE logm.dthrMedicao BETWEEN :dthrini AND :dthrfim ");
						qDet.append("                          AND cparam.tpReferencia  = :tpReferencia ");
						qDet.append("                          AND e.omPt.cdPt = :cdpt ");
						qDet.append("                          AND e.tpId = " + (quebraPeriodo == GRAFICO_CNC_POR_HORA ? 0 : 1) );
						qDet.append("                          AND cparam.dwFtParam.idFtParam  = :idFtParam ) ");
					}

					qDet.append("  GROUP BY " + hql_agrupamento  + " a.tpReferencia, c.cdFtgrupo, c.dsFtgrupo, b.idFtParam, b.dsParametro");

					// Tirei o filtor por folha
					//qDet.defineParametro("idFolha", folhaCEP.getIdFolha());
					qDet.defineParametro("idFtParam", folhaCEP.getIdFtParam());
					qDet.defineParametro("tpReferencia",tpReferencia);
					//180816 qDet.defineListaParametro("listaIdConsolId", listaIdConsolId);
					qDet.defineParametro("cdpt", cdPt);
					qDet.defineParametro("dthrini", periodo.getDtHrInicio());
					qDet.defineParametro("dthrfim", periodo.getDtHrFim());
					
					List<Object> lista = qDet.list();

					for (Object reg : lista) {
						Object[] registro = (Object[]) reg;
						itemLista = new DetalheMonitorizacaoCEPDTO();
		
						if (getIsTemperaturaZona(idFtParam)) {
							itemLista.setZona((Byte) registro[_graf_zona]);;
							
							switch (quebraPeriodo) {
							case GRAFICO_CNC_POR_HORA:;
								itemLista.setDthrIni((Date) registro[_graf_zona_hora_dthrini]);
								itemLista.setDthrFim((Date) registro[_graf_zona_hora_dthrfim]);
								break;
				
							case GRAFICO_CNC_POR_DATA_TURNO:
								itemLista.setDtTurno((Date) registro[_graf_zona_data_turno_data]);
								itemLista.setCdTurno(registro[_graf_zona_data_turno_cdturno].toString());
								break;
				
							case GRAFICO_CNC_POR_DATA:
								itemLista.setDtTurno((Date) registro[_graf_zona_data_data]);
								break;
							}
							
							
						} else {				
							switch (quebraPeriodo) {
							case GRAFICO_CNC_POR_HORA:
								itemLista.setDthrIni((Date) registro[_graf_hora_dthrini]);
								itemLista.setDthrFim((Date) registro[_graf_hora_dthrfim]);
								break;
				
							case GRAFICO_CNC_POR_DATA_TURNO:
								itemLista.setDtTurno((Date) registro[_graf_data_turno_data]);
								itemLista.setCdTurno(registro[_graf_data_turno_cdturno].toString());
								break;
				
							case GRAFICO_CNC_POR_DATA:
								itemLista.setDtTurno((Date) registro[_graf_data_data]);
								break;
							}
						}				
						
						itemLista.setIdFtParam((Long) registro[_graf_idFtParam]);
						
						folhaSemDet = getCopiaFolhaSemDetalhamento(folhaCEPLimites);
						folhaSemDet.setListaDetalheCEP(new ListaDetalheMonitorizacaoCEPDTO());
						folhaSemDet.getListaDetalheCEP().setDetMonitorizacaoCEP(new ArrayList<DetalheMonitorizacaoCEPDTO>());	
						
						if (mapFolhasCEP.size() > 0) {
							if (mapFolhasCEP.get(itemLista.getIdFtParam()) != null) {
								folhaSemDet = getCopiaFolhaSemDetalhamento(mapFolhasCEP.get(itemLista.getIdFtParam()));
								folhaSemDet.setListaDetalheCEP(new ListaDetalheMonitorizacaoCEPDTO());
								folhaSemDet.getListaDetalheCEP().setDetMonitorizacaoCEP(new ArrayList<DetalheMonitorizacaoCEPDTO>());								
							}
						}												

						
						itemLista.setTpReferencia((Byte) registro[_graf_tpReferencia]);
						itemLista.setCdFtGrupo(registro[_graf_cdFtgrupo].toString());
						itemLista.setDsFtGrupo(registro[_graf_dsFtgrupo].toString());
						
						itemLista.setDsParamentro(registro[_graf_dsParametro].toString());
						itemLista.setVlMinimo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMinimo]));
						itemLista.setVlMedio(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMedio]));
						itemLista.setVlMaximo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMaximo]));
						itemLista.setVlSomado(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlSomado]));
						itemLista.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(registro[_graf_qtMedicoes]).intValue());
						itemLista.setVlMonetario(ConversaoTipos.converterParaBigDecimal((registro[_graf_vlMonetario] == null ? 0 : registro[_graf_vlMonetario])));
						itemLista.getListaOcorrencias();
						if (quebraPeriodo == GRAFICO_CNC_RESUMO && idFtParam == 0) {
							DetalheMonitorizacaoCEPDTO itemListaParam = new DetalheMonitorizacaoCEPDTO();
							
							itemListaParam.setTpReferencia((Byte) registro[_graf_tpReferencia]);
							itemListaParam.setCdFtGrupo(registro[_graf_cdFtgrupo].toString());
							itemListaParam.setDsFtGrupo(registro[_graf_dsFtgrupo].toString());
							
							itemListaParam.setDsParamentro(registro[_graf_dsParametro].toString());
							itemListaParam.setVlMinimo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMinimo]));
							itemListaParam.setVlMedio(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMedio]));
							itemListaParam.setVlMaximo(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlMaximo]));
							itemListaParam.setVlSomado(ConversaoTipos.converterParaBigDecimal(registro[_graf_vlSomado]));
							itemListaParam.setQtMedicoes(ConversaoTipos.converterParaBigDecimal(registro[_graf_qtMedicoes]).intValue());
							itemListaParam.setVlMonetario(ConversaoTipos.converterParaBigDecimal((registro[_graf_vlMonetario] == null ? 0 : registro[_graf_vlMonetario])));
							
							folhaSemDet.getListaDetalheCEP().getDetMonitorizacaoCEP().add(itemListaParam);
						}

						itemLista.setFolhaCEPSemListas(folhaSemDet);
												

						DetalheMonitorizacaoCEPOcorrDTO ultimaocorrencia =  new DetalheMonitorizacaoCEPOcorrDTO();
						ultimaocorrencia = getUltimaOcorrenciaCEPInjet(itemLista.getTpReferencia(), itemLista.getIdFtParam(), folhaCEP.getIdFolha(), periodo, cdPt);
						
						if (ultimaocorrencia!=null && ultimaocorrencia.getVlrLido()!=null){
							itemLista.setVlUltimo(ultimaocorrencia.getVlrLido());	
						}

						// Retornando as ultimas ocorrencias 
						List<DetalheMonitorizacaoCEPOcorrDTO> ultimasocorrencias =  new ArrayList<DetalheMonitorizacaoCEPOcorrDTO>();
						ultimasocorrencias = getListaOcorrenciasCEPInjet(itemLista.getTpReferencia(), itemLista.getIdFtParam(), folhaCEP.getIdFolha(), periodo, cdPt);
						
						if(ultimasocorrencias!=null){
							itemLista.setListaOcorrencias(ultimasocorrencias);
						}
						
						
						folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP().add(itemLista);
					}
			
					//180816 movido folhaCEP.setIndicadoresCEP(getIndicadoresEstatisticosCEP2(tpReferencia, idFtParam, folhaCEP, listaIdConsolId, 1));
					//180816 movido retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
				}
			}
			
			
			if (quebraPeriodo == GRAFICO_CNC_RESUMO && idFtParam == 0) {
				// considera todos os periodos, logo, precisa calcular indicadores estatisticos de cada um deles
				for (DetalheMonitorizacaoCEPDTO lista : folhaCEP.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
					IndicadoresEstatisticosCEPDTO indicadores = new IndicadoresEstatisticosCEPDTO();
					indicadores = getIndicadoresEstatisticosCEP2INJET(daoInj, daoVF, tpReferencia, lista.getIdFtParam(), lista.getFolhaCEPSemListas(), listaDwconsolid, 1);
					lista.getFolhaCEPSemListas().setIndicadoresCEP(indicadores);
				}
			}
			
			folhaCEP.setIndicadoresCEP(getIndicadoresEstatisticosCEP2INJET(daoInj, daoVF,  tpReferencia, idFtParam, folhaCEP, listaDwconsolid, 1));			//folhaCEP.SET
			retorno.getListaFolhasCEP().getListaFolhas().add(folhaCEP);
			
		}
		qDet = null;
		
		return retorno;
	}
	

	
	
	public GraficoCEPDTO getGraficoCEP2(Byte quebraPeriodo, Byte tpReferencia, ListaParametrosCEPDTO parametros, FiltroDetalhePTInjetDTO filtro) 
	{
		// system.out.println("ini - " + new Date());

		DetalheCEPDTO folhasCEP = null;
		GraficoCEPDTO grafico = null;
		Map<Long, String> mapParametros = new HashMap<Long, String>();
		Map<String, GraficoCEPPeriodoDTO> mapPeriodo = new HashMap<String, GraficoCEPPeriodoDTO>();
		Map<String, Map<Long, GraficoCEPDetParamDTO>> mapPeriodoxParam = new HashMap<String, Map<Long, GraficoCEPDetParamDTO>>();
		String keyQuebra = "";

		for (ParametroCEPDTO par : parametros.getParametrosCEP()) {
			DetalheCEPDTO folhasCEPaux = new DetalheCEPDTO();
			if (IdwFacade.IS_IDW_ATIVO == true) {
				folhasCEPaux = getDetalheCEPGraf2(quebraPeriodo, tpReferencia, par.getIdFtParam(), filtro);
			} else {
				DAOGenericoInjet daoInj = new DAOGenericoInjet();
				daoInj.iniciaSessao();	
				folhasCEPaux = getDetalheCEPGraf2INJET(daoInj, getDao(), quebraPeriodo, tpReferencia, par.getIdFtParam(), filtro);
				daoInj.finalizaSessao();
			}
			// Adicionar em folhasCEP
			if (folhasCEP == null)
				folhasCEP = folhasCEPaux;
			else
				folhasCEP.getListaFolhasCEP().getListaFolhas().addAll(folhasCEPaux.getListaFolhasCEP().getListaFolhas());
		}
		
		grafico = new GraficoCEPDTO();
		grafico.setItemGrafico(new ArrayList<GraficoCEPPeriodoDTO>());
		grafico.setIndicadoresEstatisticos(new ArrayList<IndicadoresEstatisticosCEPDTO>());

		// identifica os diferentes períodos e parâmetros avaliados
		for (FolhaCEPDTO detalhe : folhasCEP.getListaFolhasCEP().getListaFolhas()) {
			for (DetalheMonitorizacaoCEPDTO det : detalhe.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
				DwTurno dwturno = new DwTurno();
				dwturno.setCdTurno(det.getCdTurno());
				dwturno.setDsTurno(det.getDsTurno());

				if (!mapParametros.containsKey(det.getIdFtParam())) {
					mapParametros.put(det.getIdFtParam(), det.getDsParamentro());
				}

				GraficoCEPPeriodoDTO itemPeriodo = new GraficoCEPPeriodoDTO();
				itemPeriodo.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

				switch (quebraPeriodo) {
				case GRAFICO_CNC_POR_HORA:
					keyQuebra = det.getDthrIni().toString() + "; " + det.getDthrFim().toString();
					itemPeriodo.setDthrIni(det.getDthrIni());
					itemPeriodo.setDthrFim(det.getDthrFim());
					break;
				case GRAFICO_CNC_POR_DATA_TURNO:
					keyQuebra = det.getCdTurno() + ";"
							+ det.getDtTurno().toString();
					itemPeriodo.setDtTurno(det.getDtTurno());
					itemPeriodo.setCdTurno(det.getCdTurno());
					break;
				case GRAFICO_CNC_POR_DATA:
					keyQuebra = det.getDtTurno().toString();
					itemPeriodo.setDtTurno(det.getDtTurno());
					break;
				}
				
				if (getIsTemperaturaZona(det.getIdFtParam())) {
					if (det!=null && det.getZona()!=null){
						keyQuebra = det.getZona().toString();	
					}
				}

				GraficoCEPPeriodoDTO itemGraf = new GraficoCEPPeriodoDTO();
				
				if (getIsTemperaturaZona(det.getIdFtParam())) {
					if (det!=null && det.getZona()!=null){
						itemGraf.setZona(det.getZona());	
					}
				}
				itemGraf.setDthrIni(itemPeriodo.getDthrIni());
				itemGraf.setDthrFim(itemPeriodo.getDthrFim());
				itemGraf.setDtTurno(itemPeriodo.getDtTurno());
				itemGraf.setCdTurno(itemPeriodo.getCdTurno());
				itemGraf.setDsTurno(itemPeriodo.getDsTurno());
				itemGraf.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

				if (!mapPeriodo.containsKey(keyQuebra)) {
					mapPeriodo.put(keyQuebra, itemGraf);

				}

				if (mapPeriodoxParam.containsKey(keyQuebra)) {
					// identifica se o parâmetro já está na lista
					Map<Long, GraficoCEPDetParamDTO> mapParam = mapPeriodoxParam
							.get(keyQuebra);
					if (mapParam.containsKey(det.getIdFtParam()) == false) {
						GraficoCEPDetParamDTO itemDet = new GraficoCEPDetParamDTO();
						itemDet.setIdFtParam(det.getIdFtParam());
						itemDet.setDsFtParam(det.getDsParamentro());
						itemDet.setDtReferenciaParaToolTip(det.getDtTurno());
						itemDet.setDwturnoParaToolTip(dwturno);

						itemDet.setDetParam(det);
						mapParam.put(itemDet.getIdFtParam(), itemDet);

						mapPeriodoxParam.put(keyQuebra, mapParam);
					}
				} else {
					Map<Long, GraficoCEPDetParamDTO> mapParam = new HashMap<Long, GraficoCEPDetParamDTO>();
					GraficoCEPDetParamDTO itemDet = new GraficoCEPDetParamDTO();
					itemDet.setIdFtParam(det.getIdFtParam());
					itemDet.setDsFtParam(det.getDsParamentro());
					itemDet.setDtReferenciaParaToolTip(det.getDtTurno());
					itemDet.setDwturnoParaToolTip(dwturno);

					itemDet.setDetParam(det);
					mapParam.put(itemDet.getIdFtParam(), itemDet);

					mapPeriodoxParam.put(keyQuebra, mapParam);
				}
			}

			grafico.getIndicadoresEstatisticos().add(detalhe.getIndicadoresCEP());
		}

		// percorrer Maps e criar entradas para parametros que faltam na matriz
		// período x parâmetros
		Set<String> chavesPeriodo = mapPeriodoxParam.keySet();
		for (String periodo : chavesPeriodo) {
			GraficoCEPPeriodoDTO itemPeriodo = new GraficoCEPPeriodoDTO();
			itemPeriodo.setZona(mapPeriodo.get(periodo).getZona());
			itemPeriodo.setDthrIni(mapPeriodo.get(periodo).getDthrIni());
			itemPeriodo.setDthrFim(mapPeriodo.get(periodo).getDthrFim());
			itemPeriodo.setCdTurno(mapPeriodo.get(periodo).getCdTurno());
			itemPeriodo.setDsTurno(mapPeriodo.get(periodo).getDsTurno());
			itemPeriodo.setDtTurno(mapPeriodo.get(periodo).getDtTurno());
			itemPeriodo.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

			switch (quebraPeriodo) {
			case GRAFICO_CNC_POR_HORA:
				keyQuebra = itemPeriodo.getDthrIni().toString() + "; " + itemPeriodo.getDthrFim().toString();
				break;
			case GRAFICO_CNC_POR_DATA_TURNO:
				keyQuebra = itemPeriodo.getCdTurno() + ";" + itemPeriodo.getDtTurno().toString();
				break;
			case GRAFICO_CNC_POR_DATA:
				keyQuebra = itemPeriodo.getDtTurno().toString();
				break;
			}
			
			if (itemPeriodo.getZona() != null) {
				keyQuebra = itemPeriodo.getZona().toString();
			}

			Set<Long> chavesParam = mapParametros.keySet();
			for (Long chave : chavesParam) {
				Map<Long, GraficoCEPDetParamDTO> mapParam = mapPeriodoxParam.get(keyQuebra);
				if (!mapParam.containsKey(chave)) {
					GraficoCEPDetParamDTO detParamVazio = new GraficoCEPDetParamDTO();
					detParamVazio.setIdFtParam(chave);
					detParamVazio.setDsFtParam(mapParametros.get(chave));
					detParamVazio.setDtReferenciaParaToolTip(DataHoraRN.getDataHoraAtual());
					detParamVazio.setDwturnoParaToolTip(new DwTurno());

					detParamVazio.setDetParam(new DetalheMonitorizacaoCEPDTO());
					itemPeriodo.getParametros().add(detParamVazio);
				} else {
					itemPeriodo.getParametros().add(mapParam.get(chave));
				}
			}

			grafico.getItemGrafico().add(itemPeriodo);
		}

		// percorre lista e atribui indice
		int i = 0;
		for (GraficoCEPPeriodoDTO periodo : grafico.getItemGrafico()) {
			periodo.setIdItemDTO(i);
			i++;
		}

		grafico.setListaRelatorio(gerarRelatorioDTO(grafico, quebraPeriodo));
		return grafico;
	}
	
	public GraficoCEPDTO getGraficoCEP3(Byte quebraPeriodo, Byte tpReferencia, ListaParametrosCEPDTO parametros, FiltroDetalhePTInjetDTO filtro) 
	{
		// system.out.println("ini - " + new Date());

		DetalheCEPDTO folhasCEP = null;
		GraficoCEPDTO grafico = null;
		Map<Long, String> mapParametros = new HashMap<Long, String>();
		Map<String, GraficoCEPPeriodoDTO> mapPeriodo = new HashMap<String, GraficoCEPPeriodoDTO>();
		Map<String, Map<Long, GraficoCEPDetParamDTO>> mapPeriodoxParam = new HashMap<String, Map<Long, GraficoCEPDetParamDTO>>();
		String keyQuebra = "";

		for (ParametroCEPDTO par : parametros.getParametrosCEP()) {
			DetalheCEPDTO folhasCEPaux = new DetalheCEPDTO();
			if (IdwFacade.IS_IDW_ATIVO == true) {
				folhasCEPaux = getDetalheCEPGraf3(quebraPeriodo, tpReferencia, par.getIdFtParam(), filtro);
			} else {
				DAOGenericoInjet daoInj = new DAOGenericoInjet();
				daoInj.iniciaSessao();	
				folhasCEPaux = getDetalheCEPGraf2INJET(daoInj, getDao(), quebraPeriodo, tpReferencia, par.getIdFtParam(), filtro);
				daoInj.finalizaSessao();
			}
			// Adicionar em folhasCEP
			if (folhasCEP == null)
				folhasCEP = folhasCEPaux;
			else
				folhasCEP.getListaFolhasCEP().getListaFolhas().addAll(folhasCEPaux.getListaFolhasCEP().getListaFolhas());
		}
		
		grafico = new GraficoCEPDTO();
		grafico.setItemGrafico(new ArrayList<GraficoCEPPeriodoDTO>());
		grafico.setIndicadoresEstatisticos(new ArrayList<IndicadoresEstatisticosCEPDTO>());

		// identifica os diferentes períodos e parâmetros avaliados
		for (FolhaCEPDTO detalhe : folhasCEP.getListaFolhasCEP().getListaFolhas()) {
			for (DetalheMonitorizacaoCEPDTO det : detalhe.getListaDetalheCEP().getDetMonitorizacaoCEP()) {
				DwTurno dwturno = new DwTurno();
				dwturno.setCdTurno(det.getCdTurno());
				dwturno.setDsTurno(det.getDsTurno());

				if (!mapParametros.containsKey(det.getIdFtParam())) {
					mapParametros.put(det.getIdFtParam(), det.getDsParamentro());
				}

				GraficoCEPPeriodoDTO itemPeriodo = new GraficoCEPPeriodoDTO();
				itemPeriodo.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

				switch (quebraPeriodo) {
				case GRAFICO_CNC_POR_HORA:
					keyQuebra = det.getDthrIni().toString() + "; " + det.getDthrFim().toString();
					itemPeriodo.setDthrIni(det.getDthrIni());
					itemPeriodo.setDthrFim(det.getDthrFim());
					break;
				case GRAFICO_CNC_POR_DATA_TURNO:
					keyQuebra = det.getCdTurno() + ";"
							+ det.getDtTurno().toString();
					itemPeriodo.setDtTurno(det.getDtTurno());
					itemPeriodo.setCdTurno(det.getCdTurno());
					break;
				case GRAFICO_CNC_POR_DATA:
					keyQuebra = det.getDtTurno().toString();
					itemPeriodo.setDtTurno(det.getDtTurno());
					break;
				}
				
				if (getIsTemperaturaZona(det.getIdFtParam())) {
					if (det!=null && det.getZona()!=null){
						keyQuebra = det.getZona().toString();	
					}
				}

				GraficoCEPPeriodoDTO itemGraf = new GraficoCEPPeriodoDTO();
				
				if (getIsTemperaturaZona(det.getIdFtParam())) {
					if (det!=null && det.getZona()!=null){
						itemGraf.setZona(det.getZona());	
					}
				}
				itemGraf.setDthrIni(itemPeriodo.getDthrIni());
				itemGraf.setDthrFim(itemPeriodo.getDthrFim());
				itemGraf.setDtTurno(itemPeriodo.getDtTurno());
				itemGraf.setCdTurno(itemPeriodo.getCdTurno());
				itemGraf.setDsTurno(itemPeriodo.getDsTurno());
				itemGraf.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

				if (!mapPeriodo.containsKey(keyQuebra)) {
					mapPeriodo.put(keyQuebra, itemGraf);

				}

				if (mapPeriodoxParam.containsKey(keyQuebra)) {
					// identifica se o parâmetro já está na lista
					Map<Long, GraficoCEPDetParamDTO> mapParam = mapPeriodoxParam
							.get(keyQuebra);
					if (mapParam.containsKey(det.getIdFtParam()) == false) {
						GraficoCEPDetParamDTO itemDet = new GraficoCEPDetParamDTO();
						itemDet.setIdFtParam(det.getIdFtParam());
						itemDet.setDsFtParam(det.getDsParamentro());
						itemDet.setDtReferenciaParaToolTip(det.getDtTurno());
						itemDet.setDwturnoParaToolTip(dwturno);

						itemDet.setDetParam(det);
						mapParam.put(itemDet.getIdFtParam(), itemDet);

						mapPeriodoxParam.put(keyQuebra, mapParam);
					}
				} else {
					Map<Long, GraficoCEPDetParamDTO> mapParam = new HashMap<Long, GraficoCEPDetParamDTO>();
					GraficoCEPDetParamDTO itemDet = new GraficoCEPDetParamDTO();
					itemDet.setIdFtParam(det.getIdFtParam());
					itemDet.setDsFtParam(det.getDsParamentro());
					itemDet.setDtReferenciaParaToolTip(det.getDtTurno());
					itemDet.setDwturnoParaToolTip(dwturno);

					itemDet.setDetParam(det);
					mapParam.put(itemDet.getIdFtParam(), itemDet);

					mapPeriodoxParam.put(keyQuebra, mapParam);
				}
			}

			grafico.getIndicadoresEstatisticos().add(detalhe.getIndicadoresCEP());
		}

		// percorrer Maps e criar entradas para parametros que faltam na matriz
		// período x parâmetros
		Set<String> chavesPeriodo = mapPeriodoxParam.keySet();
		for (String periodo : chavesPeriodo) {
			GraficoCEPPeriodoDTO itemPeriodo = new GraficoCEPPeriodoDTO();
			itemPeriodo.setZona(mapPeriodo.get(periodo).getZona());
			itemPeriodo.setDthrIni(mapPeriodo.get(periodo).getDthrIni());
			itemPeriodo.setDthrFim(mapPeriodo.get(periodo).getDthrFim());
			itemPeriodo.setCdTurno(mapPeriodo.get(periodo).getCdTurno());
			itemPeriodo.setDsTurno(mapPeriodo.get(periodo).getDsTurno());
			itemPeriodo.setDtTurno(mapPeriodo.get(periodo).getDtTurno());
			itemPeriodo.setParametros(new ArrayList<GraficoCEPDetParamDTO>());

			switch (quebraPeriodo) {
			case GRAFICO_CNC_POR_HORA:
				keyQuebra = itemPeriodo.getDthrIni().toString() + "; " + itemPeriodo.getDthrFim().toString();
				break;
			case GRAFICO_CNC_POR_DATA_TURNO:
				keyQuebra = itemPeriodo.getCdTurno() + ";" + itemPeriodo.getDtTurno().toString();
				break;
			case GRAFICO_CNC_POR_DATA:
				keyQuebra = itemPeriodo.getDtTurno().toString();
				break;
			}
			
			if (itemPeriodo.getZona() != null) {
				keyQuebra = itemPeriodo.getZona().toString();
			}

			Set<Long> chavesParam = mapParametros.keySet();
			for (Long chave : chavesParam) {
				Map<Long, GraficoCEPDetParamDTO> mapParam = mapPeriodoxParam.get(keyQuebra);
				if (!mapParam.containsKey(chave)) {
					GraficoCEPDetParamDTO detParamVazio = new GraficoCEPDetParamDTO();
					detParamVazio.setIdFtParam(chave);
					detParamVazio.setDsFtParam(mapParametros.get(chave));
					detParamVazio.setDtReferenciaParaToolTip(DataHoraRN.getDataHoraAtual());
					detParamVazio.setDwturnoParaToolTip(new DwTurno());

					detParamVazio.setDetParam(new DetalheMonitorizacaoCEPDTO());

					itemPeriodo.getParametros().add(detParamVazio);
				} else {
					itemPeriodo.getParametros().add(mapParam.get(chave));
				}
			}

			grafico.getItemGrafico().add(itemPeriodo);
		}

		// percorre lista e atribui indice
		int i = 0;
		for (GraficoCEPPeriodoDTO periodo : grafico.getItemGrafico()) {
			periodo.setIdItemDTO(i);
			i++;
		}

		grafico.setListaRelatorio(gerarRelatorioDTO(grafico, quebraPeriodo));
		return grafico;
	}
	
	private List<RelatorioGraficoCEPDTO> gerarRelatorioDTO(GraficoCEPDTO grafico, Byte quebraPeriodo){
		List<RelatorioGraficoCEPDTO> listaRelatorio = new ArrayList<>();
		
		for(GraficoCEPPeriodoDTO i : grafico.getItemGrafico()){			
			for(GraficoCEPDetParamDTO par : i.getParametros()){
				
				String descricao = par.getDsFtParam();
				String periodo = "";
				Double valor = 0.0D;
				
				if (par.getIdFtParam().equals(7L) // fator de potencia
                        || par.getIdFtParam().equals(1L) // corrente
                        || par.getIdFtParam().equals(4L) // tensao
                        || (par.getIdFtParam()>=8L && par.getIdFtParam() <= 16L) // ou qq corrente ou tensao de fase
                    //    || (par.getIdFtParam()>=20L && par.getIdFtParam() <= 26L) // ou VELOCIDADE ou qq PRESSAO
                        ) {
					// pegar valor medio
					valor = par.getDetParam().getVlMedio().doubleValue();
                } if (
                		par.getIdFtParam().equals(5l) || 
                		par.getIdFtParam().equals(17l) || 
                		par.getIdFtParam().equals(18l) || 
                		par.getIdFtParam().equals(19l)
                		|| par.getIdFtParam().equals(20l)
                		) {// temperatura
                	if (par.getDetParam().getVlMaximo() != null)
                		valor = par.getDetParam().getVlMaximo().doubleValue();
                	else
                		valor = 0d;
                } else {
                	if (par.getDetParam().getVlSomado() != null)
                		valor = par.getDetParam().getVlSomado().doubleValue();
                	else
                		valor = 0d;
                }
				
				Date dataParaOrdernarLista = new Date();
				
				switch (quebraPeriodo) {
				case GRAFICO_CNC_POR_HORA:
					dataParaOrdernarLista = i.getDthrIni();
					periodo = DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataParaOrdernarLista);
					break;
				case GRAFICO_CNC_POR_DATA_TURNO:
					dataParaOrdernarLista = i.getDtTurno();
					periodo = DataHoraRN.dateToStringDDMMYYYY(i.getDtTurno()) + "-" + i.getCdTurno();
					break;
				case GRAFICO_CNC_POR_DATA:
					dataParaOrdernarLista = i.getDtTurno();
					periodo = DataHoraRN.dateToStringDDMMYYYY(i.getDtTurno());
					break;
				}			
				
				RelatorioGraficoCEPDTO item = new RelatorioGraficoCEPDTO();
				item.setData(dataParaOrdernarLista);
				item.setPeriodo(periodo);
				item.setDescricao(descricao);
				item.setValor(ConversaoTipos.converteParaString(valor, 3));
				listaRelatorio.add(item);
			}
		}
		
		Comparator<RelatorioGraficoCEPDTO> comparatorData = new Comparator<RelatorioGraficoCEPDTO>() {
			@Override
			public int compare(RelatorioGraficoCEPDTO o1,
					RelatorioGraficoCEPDTO o2) {
				return DataHoraRN.compareTo(o1.getData(), o2.getData());
			}
		};
		Collections.sort(listaRelatorio, comparatorData);
		
		return listaRelatorio;
	}

	private List<Object> getListaIdConsol(FiltroDetalhePTInjetDTO filtro) {
		List<Object> retorno = new ArrayList<>();
		MapQuery q = new MapQuery(getDao().getSession());
		

		// recupera lista de id de dwconsolid
		q.append("SELECT DISTINCT dwconsolid.idConsolid");
		q.append("FROM DwConsolid dwconsolid");
		q.append("JOIN dwconsolid.dwConsols dwconsol");
		q.append("LEFT JOIN dwconsolid.dwRt dwRt");
		q.append("LEFT JOIN dwconsolid.dwProreas dwprorea");
		q.append("LEFT JOIN dwRt.dwConsolpalog dwconsolpalog");
		q.append("LEFT JOIN dwconsolid.ppCp ppcp");
		q.append("LEFT JOIN ppcp.ppCpprodutos ppcpprodutos");
		q.append("LEFT JOIN dwconsolid.dwFolha dwfolha");

		if ((filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) || ((filtro.getCdGrupoFerramenta() != null) || (filtro.getDwRap() != null))) {
			q.append("LEFT JOIN dwfolha.dwFolharaps dwfolharap");
			q.append("LEFT JOIN dwfolharap.dwFolharapcoms dwfolharapcom");

			// grupo de moldes - novo filtro BI
			if (filtro.getCdGrupoFerramenta() != null) {
				q.append("LEFT JOIN dwfolharap.dwRap.dwRapGrupos grpmol");
			}
		}

		if (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) {
			q.append("LEFT JOIN dwfolharapcom.omProduto omprodutorap");
		}

		q.append("LEFT JOIN dwconsol.dwConsolmos dwconsolmo");
		q.append("LEFT JOIN dwconsol.dwConsolals dwconsolal");

		q.append("LEFT JOIN dwconsolid.dwTurno ");
		q.append("LEFT JOIN dwconsolid.omPt ");
		q.append("LEFT JOIN dwfolha.dwFolhaiacs dwfolhaiac");
		q.append("LEFT JOIN dwfolhaiac.omProduto omprodutoiac");
		q.append("LEFT JOIN dwconsol.dwConsolprs dwConsolprs");
		q.append("LEFT JOIN dwConsolprs.omProduto omproduto ");

		// conjuntos - novo filtro BI
		if (filtro.getCdProdutoPai() != null) {
			q.append("LEFT JOIN omproduto.omProcomestsForIdProdutomp profilho");
			q.append("LEFT JOIN profilho.omProdutoByIdProduto propai");
		}

		q.appendWhere(MapQuery._NULL, "dwconsolid.tpId = :tpId and dwconsolid.stAtivo is null ", true);
		q.appendWhere(
				MapQuery._AND,
				"((dwconsolid.ano * 1000) + dwconsolid.mes) BETWEEN :ami AND :amf",
				filtro.getAnoInicial() != null
						&& filtro.getMesInicial() != null
						&& filtro.getAnoFinal() != null
						&& filtro.getMesFinal() != null);

		/*
		 * filtroOP pode assumir os seguintes valores 0 = ultima OP 1 = todas as
		 * ops Se o filtroOP for igual a zero, entao utilizar a ppCP que está no
		 * filtro
		 */
		q.appendWhere(
				MapQuery._AND,
				"dwconsolid.ppCp.cdCp = :nrop",
				filtro.getCdCp() != null
						&& filtro.getCdCp().equals("") == false
						&& filtro.getFiltroOp() != null
						&& filtro.getFiltroOp() == 0);

		q.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia = :data",
				filtro.getDtReferencia() != null
						&& filtro.getAnoInicial() == null);

		q.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno = :idTurno",
				filtro.getDwTurno() != null);

		q.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno <> 1",
				filtro.getDwTurno() == null);

		q.appendWhere(MapQuery._AND, "dwconsolid.omPt.cdPt = :ompt",
				filtro.getOmPt() != null);
		q.appendWhere(
				MapQuery._AND,
				"exists (select ompt from OmPt ompt JOIN ompt.omObjs omobj where omobj.omGtByIdGt.idGt = :idGt and ompt = dwconsolid.omPt)",
				filtro.getOmGt() != null);
		q.appendWhere(MapQuery._AND,
				"ppcpprodutos.omProduto.idProduto = :idProduto",
				filtro.getOmProduto() != null
						&& filtro.getOmProduto().getIdProduto() > 0);
		q.appendWhere(
				MapQuery._AND,
				"dwconsolid.dtReferencia between :dti and :dtf",
				filtro.getDtReferenciaInicial() != null
						&& filtro.getDtReferenciaFinal() != null
						&& filtro.getAnoInicial() == null);
		q.appendWhere(MapQuery._AND, "dwconsolid.dthrIhora >= :dthrIhora", filtro.getDthrIhora() != null && filtro.getDtReferenciaInicial() == null);
		q.appendWhere(MapQuery._AND, "dwconsolid.dthrFhora <= :dthrFhora", filtro.getDthrFhora() != null && filtro.getDtReferenciaInicial() == null);
		q.appendWhere(
				MapQuery._AND,
				"( omprodutoiac.cdProduto = :cdproduto or omprodutorap.cdProduto = :cdproduto or omproduto.cdProduto = :cdproduto) ",
				filtro.getOmProduto() != null
						&& filtro.getOmProduto().getCdProduto() != null
						&& filtro.getOmProduto().getCdProduto().equals("") == false);

		q.appendWhere(MapQuery._AND, "dwfolharap.dwRap.cdRap = :cdmol",
				(filtro.getDwRap() != null));
		q.appendWhere(MapQuery._AND,
				"grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol",
				(filtro.getCdGrupoFerramenta() != null));
		q.appendWhere(MapQuery._AND, "propai.cdProduto = :cdProdutoPai",
				(filtro.getCdProdutoPai() != null));

		q.append("order by dwconsolid.idConsolid desc");

		// preenchimento dos parametros
		q.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro
				.getDwTurno().getIdTurno() : 0);

		if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) {
			OmPt ompt = getDao().findById(OmPt.class,
					filtro.getOmPt().getIdPt(), false);
			filtro.getOmPt().setCdPt(ompt.getCdPt());
		}

		if (filtro.getOmPt() != null)
			q.defineParametro("ompt", filtro.getOmPt().getCdPt());

		q.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt()
				.getIdGt() : null);
		q.defineParametro("idProduto", filtro.getOmProduto() != null
				&& filtro.getOmProduto().getIdProduto() > 0 ? filtro
				.getOmProduto().getIdProduto() : null);
		q.defineParametro(
				"cdproduto",
				filtro.getOmProduto() != null
						&& filtro.getOmProduto().getCdProduto() != null
						&& filtro.getOmProduto().getCdProduto().equals("") == false ? filtro
						.getOmProduto().getCdProduto() : null);
		q.defineParametroData(
				"data",
				filtro.getDtReferencia() != null ? DataHoraRN
						.getDataSemHora(filtro.getDtReferencia()) : null);
		q.defineParametroData(
				"dti",
				filtro.getDtReferenciaInicial() != null ? DataHoraRN
						.getDataSemHora(filtro.getDtReferenciaInicial()) : null);
		q.defineParametroData(
				"dtf",
				filtro.getDtReferenciaFinal() != null ? DataHoraRN
						.getDataSemHora(filtro.getDtReferenciaFinal()) : null);

		if (filtro.getDthrIhora() != null) {
			q.defineParametroTimestamp("dthrIhora", filtro.getDthrIhora());
		}

		if (filtro.getDthrFhora() != null) {
			q.defineParametroTimestamp("dthrFhora", filtro.getDthrFhora());
		}

		if (filtro.getTpId() == null) {
			filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
		}

		// TODO alterar esse trecho
		// mudei o periodo de consolidaÃ§Ã£o pra TURNO pois ainda nÃ£o existe
		// registros para ACUMULADO
		if ((filtro.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO)
				|| (filtro.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)) {
			q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
		} else if (filtro.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_MES)) {
			q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);
		} else {
			q.defineParametro("tpId", filtro.getTpId());
		}

		// Eduardo: Trecho comentado com o intutito de considerar todos os
		// DwConsolids do Turno
		// Alessandre: em 29-10-14 reativei o trecho abaixo posi agora existe o
		// filtroOP que se for 0 (ver comentario anterior) passar a OP
		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false) {
			q.defineParametro("nrop", filtro.getCdCp());
		}

		if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null
				&& filtro.getAnoFinal() != null && filtro.getMesFinal() != null) {
			q.defineParametro("ami",
					(filtro.getAnoInicial() * 1000) + filtro.getMesInicial());
			q.defineParametro("amf",
					(filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
		}

		// novo filtro BI
		if (filtro.getDwRap() != null) {
			q.defineParametro("cdmol", filtro.getDwRap().getCdRap());
		}
		if (filtro.getCdGrupoFerramenta() != null) {
			q.defineParametro("cdgrpmol", filtro.getCdGrupoFerramenta());
		}

		if (filtro.getCdProdutoPai() != null) {
			q.defineParametro("cdProdutoPai", filtro.getCdProdutoPai());
		}

		retorno = q.list();
		return retorno;				
		
	}
	
	private List<Object> getListaIdConsol2(FiltroDetalhePTInjetDTO filtro) {
		List<Object> retorno = new ArrayList<>();
		MapQuery q = new MapQuery(getDao().getSession());
		
		//tentativa 2
		
				q = new MapQuery(getDao().getSession());
				
				q.append("SELECT DISTINCT dwconsolid.idConsolid");
				q.append("FROM DwConsolid dwconsolid");
				q.append("JOIN dwconsolid.dwConsols dwconsol");
				q.append("LEFT JOIN dwconsolid.dwRt dwRt");
				q.append("LEFT JOIN dwconsolid.dwProreas dwprorea");
				q.append("LEFT JOIN dwRt.dwConsolpalog dwconsolpalog");
				q.append("LEFT JOIN dwconsolid.ppCp ppcp");
				q.append("LEFT JOIN ppcp.ppCpprodutos ppcpprodutos");
				q.append("LEFT JOIN dwconsolid.dwFolha dwfolha");

				if ((filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) || ((filtro.getCdGrupoFerramenta() != null) || (filtro.getDwRap() != null))) {
					q.append("LEFT JOIN dwfolha.dwFolharaps dwfolharap");
					q.append("LEFT JOIN dwfolharap.dwFolharapcoms dwfolharapcom");

					// grupo de moldes - novo filtro BI
					if (filtro.getCdGrupoFerramenta() != null) {
						q.append("LEFT JOIN dwfolharap.dwRap.dwRapGrupos grpmol");
					}
				}

				if (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) {
					q.append("LEFT JOIN dwfolharapcom.omProduto omprodutorap");
				}

				q.append("LEFT JOIN dwconsol.dwConsolmos dwconsolmo");
				q.append("LEFT JOIN dwconsol.dwConsolals dwconsolal");

				q.append("LEFT JOIN dwconsolid.dwTurno ");
				q.append("LEFT JOIN dwconsolid.omPt ");
				q.append("LEFT JOIN dwfolha.dwFolhaiacs dwfolhaiac");
				q.append("LEFT JOIN dwfolhaiac.omProduto omprodutoiac");
				q.append("LEFT JOIN dwconsol.dwConsolprs dwConsolprs");
				q.append("LEFT JOIN dwConsolprs.omProduto omproduto ");

				// conjuntos - novo filtro BI
				if (filtro.getCdProdutoPai() != null) {
					q.append("LEFT JOIN omproduto.omProcomestsForIdProdutomp profilho");
					q.append("LEFT JOIN profilho.omProdutoByIdProduto propai");
				}

				q.appendWhere(MapQuery._NULL, "dwconsolid.tpId = :tpId and dwconsolid.stAtivo is null ", true);
				q.appendWhere(
						MapQuery._AND,
						"((dwconsolid.ano * 1000) + dwconsolid.mes) BETWEEN :ami AND :amf",
						filtro.getAnoInicial() != null
								&& filtro.getMesInicial() != null
								&& filtro.getAnoFinal() != null
								&& filtro.getMesFinal() != null);

				/*
				 * filtroOP pode assumir os seguintes valores 0 = ultima OP 1 = todas as
				 * ops Se o filtroOP for igual a zero, entao utilizar a ppCP que está no
				 * filtro
				 */
				q.appendWhere(
						MapQuery._AND,
						"dwconsolid.ppCp.cdCp = :nrop",
						filtro.getCdCp() != null
								&& filtro.getCdCp().equals("") == false
								&& filtro.getFiltroOp() != null
								&& filtro.getFiltroOp() == 0);

				/*q.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia = :data",
						filtro.getDtReferencia() != null
								&& filtro.getAnoInicial() == null);*/

				q.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno = :idTurno",
						filtro.getDwTurno() != null);

				q.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno <> 1",
						filtro.getDwTurno() == null);

				q.appendWhere(MapQuery._AND, "dwconsolid.omPt.cdPt = :ompt",
						filtro.getOmPt() != null);
				/*q.appendWhere(
						MapQuery._AND,
						"exists (select ompt from OmPt ompt JOIN ompt.omObjs omobj where omobj.omGtByIdGt.idGt = :idGt and ompt = dwconsolid.omPt)",
						filtro.getOmGt() != null);*/
				q.appendWhere(MapQuery._AND,
						"ppcpprodutos.omProduto.idProduto = :idProduto",
						filtro.getOmProduto() != null
								&& filtro.getOmProduto().getIdProduto() > 0);
				/*q.appendWhere(
						MapQuery._AND,
						"dwconsolid.dtReferencia between :dti and :dtf",
						filtro.getDtReferenciaInicial() != null
								&& filtro.getDtReferenciaFinal() != null
								&& filtro.getAnoInicial() == null);
				q.appendWhere(MapQuery._AND, "dwconsolid.dthrIhora >= :dthrIhora", filtro.getDthrIhora() != null && filtro.getDtReferenciaInicial() == null);
				q.appendWhere(MapQuery._AND, "dwconsolid.dthrFhora <= :dthrFhora", filtro.getDthrFhora() != null && filtro.getDtReferenciaInicial() == null);
				*/
				q.appendWhere(
						MapQuery._AND,
						"( omprodutoiac.cdProduto = :cdproduto or omprodutorap.cdProduto = :cdproduto or omproduto.cdProduto = :cdproduto) ",
						filtro.getOmProduto() != null
								&& filtro.getOmProduto().getCdProduto() != null
								&& filtro.getOmProduto().getCdProduto().equals("") == false);

				q.appendWhere(MapQuery._AND, "dwfolharap.dwRap.cdRap = :cdmol",
						(filtro.getDwRap() != null));
				q.appendWhere(MapQuery._AND,
						"grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol",
						(filtro.getCdGrupoFerramenta() != null));
				q.appendWhere(MapQuery._AND, "propai.cdProduto = :cdProdutoPai",
						(filtro.getCdProdutoPai() != null));

				q.append("order by dwconsolid.idConsolid desc");

				// preenchimento dos parametros
				q.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro
						.getDwTurno().getIdTurno() : 0);

				if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) {
					OmPt ompt = getDao().findById(OmPt.class,
							filtro.getOmPt().getIdPt(), false);
					filtro.getOmPt().setCdPt(ompt.getCdPt());
				}

				if (filtro.getOmPt() != null)
					q.defineParametro("ompt", filtro.getOmPt().getDepara());

				q.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt()
						.getIdGt() : null);
				q.defineParametro("idProduto", filtro.getOmProduto() != null
						&& filtro.getOmProduto().getIdProduto() > 0 ? filtro
						.getOmProduto().getIdProduto() : null);
				q.defineParametro(
						"cdproduto",
						filtro.getOmProduto() != null
								&& filtro.getOmProduto().getCdProduto() != null
								&& filtro.getOmProduto().getCdProduto().equals("") == false ? filtro
								.getOmProduto().getCdProduto() : null);
				q.defineParametroData(
						"data",
						filtro.getDtReferencia() != null ? DataHoraRN
								.getDataSemHora(filtro.getDtReferencia()) : null);
				q.defineParametroData(
						"dti",
						filtro.getDtReferenciaInicial() != null ? DataHoraRN
								.getDataSemHora(filtro.getDtReferenciaInicial()) : null);
				q.defineParametroData(
						"dtf",
						filtro.getDtReferenciaFinal() != null ? DataHoraRN
								.getDataSemHora(filtro.getDtReferenciaFinal()) : null);

				if (filtro.getDthrIhora() != null) {
					q.defineParametroTimestamp("dthrIhora", filtro.getDthrIhora());
				}

				if (filtro.getDthrFhora() != null) {
					q.defineParametroTimestamp("dthrFhora", filtro.getDthrFhora());
				}

				if (filtro.getTpId() == null) {
					filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
				}

				// TODO alterar esse trecho
				// mudei o periodo de consolidaÃ§Ã£o pra TURNO pois ainda nÃ£o existe
				// registros para ACUMULADO
				if ((filtro.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO)
						|| (filtro.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)) {
					q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
				} else if (filtro.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_MES)) {
					q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);
				} else {
					q.defineParametro("tpId", filtro.getTpId());
				}

				// Eduardo: Trecho comentado com o intutito de considerar todos os
				// DwConsolids do Turno
				// Alessandre: em 29-10-14 reativei o trecho abaixo posi agora existe o
				// filtroOP que se for 0 (ver comentario anterior) passar a OP
				if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false) {
					q.defineParametro("nrop", filtro.getCdCp());
				}

				if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null
						&& filtro.getAnoFinal() != null && filtro.getMesFinal() != null) {
					q.defineParametro("ami",
							(filtro.getAnoInicial() * 1000) + filtro.getMesInicial());
					q.defineParametro("amf",
							(filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
				}

				// novo filtro BI
				if (filtro.getDwRap() != null) {
					q.defineParametro("cdmol", filtro.getDwRap().getCdRap());
				}
				if (filtro.getCdGrupoFerramenta() != null) {
					q.defineParametro("cdgrpmol", filtro.getCdGrupoFerramenta());
				}

				if (filtro.getCdProdutoPai() != null) {
					q.defineParametro("cdProdutoPai", filtro.getCdProdutoPai());
				}
				retorno = q.list();
				return retorno;
		
	}

	public CEPFolhasDTO getCEPFolhas(Byte quebraPeriodo, FiltroDetalhePTInjetDTO filtro, ListaParametrosCEPDTO listaParametros) {
		CEPFolhasDTO retorno = new CEPFolhasDTO();
		CEPFolhaDTO folha = new CEPFolhaDTO();
		CEPParametroDTO parametro = new CEPParametroDTO();

		MapQuery q = new MapQuery(getDao().getSession());

		FolhaCEPDTO folhaCEP = new FolhaCEPDTO();
		Map<Long, CEPFolhaDTO> mapFolha = new HashMap<Long, CEPFolhaDTO>();

		List<Object> listaParametrosId = new ArrayList<Object>();
		List<Object> listaIdConsolId = getListaIdConsol(filtro);

		// lista de parametros CNC
		for (ParametroCEPDTO paramCEP : listaParametros.getParametrosCEP()) {
			listaParametrosId.add(paramCEP.getIdFtParam());
		}

		// recuperar todos os diferentes conjuntos formados por idfolha +
		// idftparam
		retorno.setFolhas(new ArrayList<CEPFolhaDTO>());

		q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT e.dwFolha.idFolha, b.idFtParam, e.omPt.idPt ");
		q.append("  FROM DwConsolParam a ");
		q.append("  JOIN a.dwFtParam b ");
		q.append("  JOIN b.dwFtGrupo c ");
		q.append("  JOIN a.dwConsol d ");
		q.append("  JOIN d.dwConsolid e ");
		q.append(" WHERE b.idFtParam  IN (:listaParametrosId) ");
		
		// alessandre em 16-11-18 acrescentei o if pq a listsa veio vazio e gerou erro, mas nao pude avaliar a causa de ter vindo vazia
		if (listaIdConsolId != null && listaIdConsolId.isEmpty() == false)
			q.append("   AND e.idConsolid IN (:listaIdConsolId) ");
		q.append(" GROUP BY e.dwFolha.idFolha, b.idFtParam, e.omPt.idPt ");
		q.defineListaParametro("listaParametrosId", listaParametrosId);
		q.defineListaParametro("listaIdConsolId", listaIdConsolId);

		List<Object> listaFolha = null;
		if (listaIdConsolId != null)
			listaFolha = q.list();
		else
			listaFolha = new ArrayList<>();
		
		for (Object regFolha : listaFolha) {
			Object[] registroFolha = (Object[]) regFolha;
			OmPt ompt = new OmPt();
			ompt.setIdPt((Long) registroFolha[_folha_idpt]);

			folhaCEP = getFolhasCEP(ompt, (Long) registroFolha[_folha_idftparam]);

			folha = new CEPFolhaDTO();
			folha.setParametros(new ArrayList<CEPParametroDTO>());
			folha.setIdFolha(folhaCEP.getIdFolha());
			folha.setCdFolha(folhaCEP.getCdFolha());
			folha.setRevisao(folhaCEP.getRevisao());
			
			parametro = new CEPParametroDTO();

			parametro.setIdFtParam(folhaCEP.getIdFtParam());
			parametro.setLimAceitavelInfFim(folhaCEP.getLimAceitavelInfFim());
			parametro.setLimAceitavelInfIni(folhaCEP.getLimAceitavelInfIni());
			parametro.setLimAceitavelSupFim(folhaCEP.getLimAceitavelSupFim());
			parametro.setLimAceitavelSupIni(folhaCEP.getLimAceitavelSupIni());
			parametro.setLimCriticoInf(folhaCEP.getLimCriticoInf());
			parametro.setLimCriticoSup(folhaCEP.getLimCriticoSup());
			parametro.setLimIdealFim(folhaCEP.getLimIdealFim());
			parametro.setLimIdealIni(folhaCEP.getLimIdealIni());
			parametro.setTemMaximo(folhaCEP.getTemMaximo());
			parametro.setTemMeta(folhaCEP.getTemMeta());
			parametro.setTemMinimo(folhaCEP.getTemMinimo());

			folha.getParametros().add(parametro);

			if (!mapFolha.containsKey(folhaCEP.getIdFolha())) {
				mapFolha.put(folha.getIdFolha(), folha);
			} else {
				CEPFolhaDTO folhaMap = mapFolha.get(folha.getIdFolha());
				folhaMap.getParametros().add(parametro);
				mapFolha.put(folha.getIdFolha(), folhaMap);
			}
		}

		retorno.getFolhas().addAll(mapFolha.values());
		return retorno;
	}

    public static boolean getIsTemperaturaZona(Long idFtParam) {
    	if (idFtParam == DwFtParamTemplate.Type.TEMPERATURA_ZONAS.getId() || 
    		idFtParam == DwFtParamTemplate.Type.TEMPERATURA_ZONAS_BOTTOM.getId() ||
    		idFtParam == DwFtParamTemplate.Type.TEMPERATURA_ZONAS_TOP.getId()) {
    		
    		return true;
    	} else {
    		return false;
    	}
    }	
}
