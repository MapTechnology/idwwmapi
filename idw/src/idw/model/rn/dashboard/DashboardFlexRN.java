package idw.model.rn.dashboard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolidDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmPtDAO;
import idw.model.excessoes.GtDesconhecidoException;
import idw.model.excessoes.PtDesconhecidoException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.TurnoDesconhecidoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.PeriodoRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.TurnoRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.rest.dto.dashboard.flex.DashboardFlexDTO;
import idw.webservices.rest.dto.dashboard.flex.DashboardFlexHoraDTO;
import idw.webservices.rest.dto.dashboard.flex.DashboardFlexOpProdutoDTO;

public class DashboardFlexRN extends AbstractRN<DAOGenerico> {

	private static final String TEMPLATE_SEM_APONTAMENTO = "Sem apontamento";
	private static final String CAMPO_INDEFINIDO = "-";
	private static final String TEMPLATE_HORA = "%dh";
	private static final String TEMPLATE_DESCRICAO_STATUS_POSITIVO = "Produziu %d acima da meta até %dh";
	private static final String TEMPLATE_DESCRICAO_STATUS_NEGATIVO = "Deveria ter produzido %d até %dh";

	private Map<String, DashboardFlexOpProdutoDTO> mapOpProdutoClienteDTO;
	private Map<String, DashboardFlexHoraDTO> mapHorasDTO;
	private List<PeriodoDTO> listaPeriodosHorasDTO;
	private List<DwConsolid> dadosProdutivosPorHoraDentroTurno;
	private TurnoRN turnoRN;
	private FolhaRN folhaRN;
	private Map<String, BigDecimal> mapCavAtivaProd;
	private Map<String, BigDecimal> mapCicloPadrao;
	private int tempoProdutivoDia;
	private int tempoProdutivoAteHoraAtual;
	private static final byte STATUS_PRODUCAO_POSITIVO = 1;
	private static final byte STATUS_PRODUCAO_NEGATIVO = 0;
	private Date dataHoraAtual;
	private int horaAtual;
	
	public DashboardFlexRN() {
		super(new DAOGenerico());
		turnoRN = new TurnoRN(getDao());
		folhaRN = new FolhaRN(getDao());
	}

	public DashboardFlexRN(DAOGenerico dao) {
		super(dao);
		turnoRN = new TurnoRN(dao);
		folhaRN = new FolhaRN(dao);
	}

	public DashboardFlexDTO producao(String cdGt, String dthr)
			throws GtDesconhecidoException, PtDesconhecidoException, ParseException,
			TurnoDesconhecidoException, SemCicloPadraoException, SemCalendarioException {

		mapOpProdutoClienteDTO = new HashMap<>();
		mapHorasDTO = new HashMap<>();
		mapCavAtivaProd = new HashMap<>();
		mapCicloPadrao = new HashMap<>();

		// Valida se GT existe
		OmGt omGt = getOmGt(cdGt);

		OmPt omPt = getOmPtContaGt(cdGt);

		dataHoraAtual = null;
		if (dthr.isEmpty()) {
			dataHoraAtual = DataHoraRN.getDataHoraAtual();
		} else {
			dataHoraAtual = DataHoraRN.toDateFromYYYYMMDDHHMISS(dthr);
		}

		List<DwCalsem> dwCalsems = null;
		try {
			dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(omPt, dataHoraAtual);
		} catch (SemCalendarioException e) {
			String msg = String.format("Não encontrou calendário." + getMensagem(dataHoraAtual, cdGt, omPt.getCdPt()));
			throw new SemCalendarioException(msg);
		}
		TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTO(dwCalsems, dataHoraAtual);
		if (turnoAtualDTO == null) {
			throw new TurnoDesconhecidoException("Turno não encontrado." + getMensagem(dataHoraAtual, cdGt, omPt.getCdPt()));
		}

		listaPeriodosHorasDTO = PeriodoRN.obtemHorasPeriodo(turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno());

		tempoProdutivoDia = calcularTempoProdutivoDia(turnoAtualDTO, dwCalsems);

		tempoProdutivoAteHoraAtual = DataHoraRN.getQuantidadeSegundosNoPeriodo(turnoAtualDTO.getDtHrITurno(), dataHoraAtual);

		TempoRealRN tempoRealRN = new TempoRealRN(getDao());
		DwRt dwRt = tempoRealRN.getUltimoDwRt(omPt.getIdPt());

		if (dwRt != null && dwRt.getPpCp() != null) {
			DwConsolidDAO dwConsolidDAO = new DwConsolidDAO(getDaoSession());
			dadosProdutivosPorHoraDentroTurno = dwConsolidDAO.getProducaoPorHoraDentroTurnoPorGt(omGt.getCdGt(), turnoAtualDTO.getDtReferencia(), turnoAtualDTO.getCdTurno(), dwRt.getPpCp().getNrop());
		} else {
			dadosProdutivosPorHoraDentroTurno = new ArrayList<>();
		}

		horaAtual = getHoraAtual();

		DashboardFlexDTO retorno = null;

		if (dadosProdutivosPorHoraDentroTurno.isEmpty()) {
			retorno = montarDTOSemDwConsolidNoTurno(cdGt, omPt, dataHoraAtual);
		} else {
			retorno = montarDTOComDwConsolidNoTurno(cdGt, dataHoraAtual);
		}

		if (retorno == null) {
			retorno = montarVazioDTO(cdGt, dataHoraAtual);
		}
		
		retorno.setData(DataHoraRN.toStringDDMMYY(turnoAtualDTO.getDtReferencia()));
		retorno.setTurno(turnoAtualDTO.getDwturno().getDsTurno());

		return retorno;
	}

	private int calcularTempoProdutivoDia(TurnoAtualDTO turnoAtualDTO, List<DwCalsem> dwCalsems) {
		List<TurnoAtualDTO> listaTurnosDoDia = turnoRN.getTurnosDTODoDia(turnoAtualDTO, false, dwCalsems);

		int tempoProdutivoDia = 0;
		for (TurnoAtualDTO turno : listaTurnosDoDia) {
			// Descartar turno improdutivo
			if (turno.getDwturno().getIsImprodutivo() != null && turno.getDwturno().getIsImprodutivo())
				continue;
			tempoProdutivoDia = tempoProdutivoDia + turno.getSegDuracaoProdutiva().intValue(); // DataHoraRN.getQuantidadeSegundosNoPeriodo(turno.getDtHrITurno(),
																								// turno.getDtHrFTurno());
		}
		return tempoProdutivoDia;
	}

	/*
	 * Alessandre em 23-04-18 substitui o metodo abaixo pelo seguinte. O metodo abaixo utiliza os defeitos vindos dos postos de testes. Mas
	 * o cliente deseja os defeitos apontados pelo reprocesso private int getDefeitos(DwConsol dwConsol) { int defeitos = 0; for
	 * (DwConsoldef dwConsoldef : dwConsol.getDwConsoldefs()) { if (dwConsoldef.getQtDefeitos() != null) { defeitos = defeitos +
	 * dwConsoldef.getQtDefeitos().intValue(); } } return defeitos; }
	 */

	// Obtem a quantidade de placas com defeito e não a quantidade de defeitos
	private int getDefeitosNaHora(DwConsolid id, String cdGt) {
		int defeitos = 0;

		/*
		 * Pesquisa os CBs que passaram pelo posto contando quantos tem registro no reprocesso
		 * 
		 */
		PTRN rn = new PTRN(getDao());
		OmPt ompt = null;
		OmGt omgt = null;
		try {
			ompt = rn.getOmPt("REP_IM"); // eh fixo pois falta rever o ihm reprocesso no web
		} catch (RegistroDesconhecidoException e) {
			return 0;
		}
		try {
			omgt = getOmGt(cdGt);
		} catch (GtDesconhecidoException e) {
			return 0;
		}

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select distinct b.cb");
		q.append("from DwPassagem a");
		q.append("join a.dwNserie b");
		q.append("join a.omPt c");
		q.append("join a.omUsrByIdUsroperador d");
		q.append("join d.omGt f");
		q.append("join a.dwConsolid e");
		q.append("where");
		q.append("e.dtReferencia = :dt");
		q.append("and e.dwTurno.idTurno = :idturno");
		q.append("and f.cdGt = :cdGt");
		q.append("and c.cdPt = :cdpt");
		q.append("and e.tpId = 1");
		q.append("and a.dthr between :dthrihora and :dthrfhora");

		q.defineParametroData("dt", id.getDtReferencia());
		q.defineParametro("idturno", id.getDwTurno().getIdTurno());
		q.defineParametro("cdGt", omgt.getCdGt());
		q.defineParametro("cdpt", ompt.getCdPt());
		q.defineParametroTimestamp("dthrihora", id.getDthrIhora());
		q.defineParametroTimestamp("dthrfhora", id.getDthrFhora());

		defeitos = q.list().size();

		return defeitos;
	}

	private DashboardFlexDTO montarDTOSemDwConsolidNoTurno(String cdGt, OmPt omPt, Date dataHoraAtual) throws SemCicloPadraoException {
		DashboardFlexDTO dashboardFlexDTO = null;
		TempoRealRN tempoRealRN = new TempoRealRN(getDao());
		DwRt dwRt = tempoRealRN.getUltimoDwRtSemConsiderarOP(omPt.getIdPt());
		if (dwRt != null) {
			PpCp ppCp = dwRt.getPpCp();
			if (ppCp != null) {

				dashboardFlexDTO = createDashboardFlexDTO(cdGt, dwRt.getDtReferencia());
				
				dashboardFlexDTO.setTurno(dwRt.getDwTurno().getDsTurno());

				String cdCliente = getCdCliente(ppCp);
				String cdCp = ppCp.getCdCp();
				DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
				BigDecimal cicloPadrao = folhaRN.getCicloPadrao(mapCicloPadrao, dwFolha, omPt);

				for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
					OmProduto omProduto = ppCpproduto.getOmProduto();
					String cdProduto = omProduto.getCdProduto();

					int metaDia = calcularMetaDia(tempoProdutivoDia, dwFolha, cicloPadrao, omProduto);
					int metaHoraAcumulado = calcularMetaDia(tempoProdutivoAteHoraAtual, dwFolha, cicloPadrao, omProduto);

					DashboardFlexOpProdutoDTO dashboardFlexOpProdutoDTO = createAndAddDashboardFlexOpDTO(cdCp, cdCliente, cdProduto, metaDia, metaHoraAcumulado, dashboardFlexDTO);

					atualizarStatusProducao(dashboardFlexOpProdutoDTO);

				}

			}
		}

		return dashboardFlexDTO;
	}

	private void atualizarStatusProducao(DashboardFlexOpProdutoDTO dashboardFlexOpProdutoDTO) {
		if (dashboardFlexOpProdutoDTO.getProduzidos() == 0) {
			dashboardFlexOpProdutoDTO.setStatusProducao(STATUS_PRODUCAO_NEGATIVO);
			dashboardFlexOpProdutoDTO.setStatusProducaoDescricao(TEMPLATE_SEM_APONTAMENTO);
		} else if (dashboardFlexOpProdutoDTO.getProduzidos() > dashboardFlexOpProdutoDTO.getMetaHoraAcumulado()) {
			dashboardFlexOpProdutoDTO.setStatusProducao(STATUS_PRODUCAO_POSITIVO);
			int pecasProduzidasAMais = dashboardFlexOpProdutoDTO.getProduzidos() - dashboardFlexOpProdutoDTO.getMetaHoraAcumulado();
			dashboardFlexOpProdutoDTO.setStatusProducaoDescricao(String.format(TEMPLATE_DESCRICAO_STATUS_POSITIVO, pecasProduzidasAMais, horaAtual));
		} else {
			dashboardFlexOpProdutoDTO.setStatusProducao(STATUS_PRODUCAO_NEGATIVO);
			dashboardFlexOpProdutoDTO.setStatusProducaoDescricao(String.format(TEMPLATE_DESCRICAO_STATUS_NEGATIVO, dashboardFlexOpProdutoDTO.getMetaHoraAcumulado(), horaAtual));
		}
	}

	private int getHoraAtual() {
		Date inicioHora = DataHoraRN.getDataSemMinutosSegundosMilissegundos(dataHoraAtual);
		int i = 1;
		for (PeriodoDTO periodoDTO : listaPeriodosHorasDTO) {
			if (DataHoraRN.equals(inicioHora, periodoDTO.getDtHrInicio())) {
				return i;
			}
			i++;
		}
		throw new IllegalStateException("Data/Hora atual não está dentro do período de horas dentro do turno. " +
				"Data/Hora atual " + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataHoraAtual));
	}

	private int calcularMetaDia(int tempoProdutivoDia, DwFolha dwFolha, BigDecimal cicloPadrao, OmProduto omProduto) {
		BigDecimal cavAtivas = folhaRN.getPcsPorCicloAtivas(mapCavAtivaProd, dwFolha, omProduto);

		BigDecimal metaDia = AritmeticaUtil.dividir(new BigDecimal(tempoProdutivoDia), cicloPadrao, 2, RoundingMode.FLOOR);
		metaDia = metaDia.multiply(cavAtivas);

		return metaDia.intValue();
	}

	private DashboardFlexDTO montarDTOComDwConsolidNoTurno(String cdGt, Date dataHoraAtual) throws SemCicloPadraoException {

		DashboardFlexDTO dashboardFlexDTO = createDashboardFlexDTO(cdGt, dataHoraAtual);

		BigDecimal indDefeitoMeta = new BigDecimal(0.5);

		for (DwConsolid dwConsolid : dadosProdutivosPorHoraDentroTurno) {
			OmPt omPt = dwConsolid.getOmPt();
			DwFolha dwFolha = dwConsolid.getDwFolha();
			PpCp ppCp = dwConsolid.getPpCp();
			String cdCliente = getCdCliente(ppCp);
			String nrDoc = ppCp.getNrop();
			Date dthrIHora = dwConsolid.getDthrIhora();
			DwConsol dwConsol = dwConsolid.getDwConsol();

			int defeitos = getDefeitosNaHora(dwConsolid, cdGt);

			for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
				OmProduto omProduto = ppCpproduto.getOmProduto();
				String cdProduto = omProduto.getCdProduto();

				DashboardFlexOpProdutoDTO dashboardFlexOpProdutoDTO = getDashboardFlexOpDTOIfNotExistsCreateAndAdd(nrDoc, cdCliente, omProduto, dashboardFlexDTO, omPt, dwFolha);

				DashboardFlexHoraDTO dashboardFlexHoraDTO = getDashboardFlexHoraDTO(nrDoc, cdCliente, cdProduto, dthrIHora);

				// Atualização da quantidade de defeitos não pode ficar dentro do loop dwConsol.getDwConsolprs()
				// - Primeiro porque nem precisaria, já que o defeito é aplicado para todos os produtos.
				// - Segundo que eventos de defeito podem não gerar linha em DwConsolpr.
				atualizarQuantidadeDefeitos(dashboardFlexOpProdutoDTO, dashboardFlexHoraDTO, defeitos);

				for (DwConsolpr dwConsolpr : dwConsol.getDwConsolprs()) {
					if (dwConsolpr.getOmProduto().getCdProduto().equals(cdProduto)) {

						if (dwConsolpr.getOmProduto().getIndDefeito() != null) {
							indDefeitoMeta = dwConsolpr.getOmProduto().getIndDefeito();
						}

						atualizarQuantidadeScraps(dashboardFlexOpProdutoDTO, dashboardFlexHoraDTO, dwConsolpr);

						if (omPt.getIsApongt()) {
							atualizarQuantidadeProduzida(dashboardFlexOpProdutoDTO, dashboardFlexHoraDTO, dwConsolpr);
						}

					}
				}

			}

		}

		for (DashboardFlexOpProdutoDTO dashboardFlexOpProdutoDTO : dashboardFlexDTO.getOpsProdutos()) {
			dashboardFlexOpProdutoDTO.setIndiceDefeito(indDefeitoMeta.doubleValue());
			atualizarIndiceDefeitoRealOpProduto(dashboardFlexOpProdutoDTO, dataHoraAtual);
			atualizarStatusProducao(dashboardFlexOpProdutoDTO);
		}

		return dashboardFlexDTO;

	}

	private void atualizarIndiceDefeitoRealOpProduto(DashboardFlexOpProdutoDTO dashboardFlexOpProdutoDTO, Date dataHoraAtual) {

		Date dtHrIHora = DataHoraRN.getDataSemMinutosSegundosMilissegundos(dataHoraAtual);

		DashboardFlexHoraDTO dashboardFlexHoraDTO = getDashboardFlexHoraDTO(
				dashboardFlexOpProdutoDTO.getCdCp(),
				dashboardFlexOpProdutoDTO.getCliente(),
				dashboardFlexOpProdutoDTO.getModelo(),
				dtHrIHora);

		BigDecimal indiceDefeito = calcularIndiceDefeito(dashboardFlexHoraDTO.getDefeitos(), dashboardFlexOpProdutoDTO.getProduzidos());

		// System.out.println("qtDefeitos=" + dashboardFlexHoraDTO.getDefeitos() + " producao=" + dashboardFlexOpProdutoDTO.getProduzidos()
		// + " inddef=" + indiceDefeito);
		dashboardFlexOpProdutoDTO.setIndiceDefeitoReal(indiceDefeito.doubleValue());

	}

	private void atualizarQuantidadeDefeitos(DashboardFlexOpProdutoDTO dashboardFlexOpProdutoDTO, DashboardFlexHoraDTO dashboardFlexHoraDTO, int defeitos) {
		// System.out.println(dashboardFlexOpProdutoDTO.getDefeitos() + " + " + defeitos + " de novo");

		dashboardFlexOpProdutoDTO.setDefeitos(dashboardFlexOpProdutoDTO.getDefeitos() + defeitos);
		if (dashboardFlexHoraDTO != null)
			dashboardFlexHoraDTO.setDefeitos(dashboardFlexHoraDTO.getDefeitos() + defeitos);
	}

	private void atualizarQuantidadeScraps(DashboardFlexOpProdutoDTO dashboardFlexOpDTO, DashboardFlexHoraDTO dashboardFlexHoraDTO,
			DwConsolpr dwConsolpr) {
		BigDecimal scrapsHora = BigDecimal.ZERO;
		
		if (dashboardFlexHoraDTO != null)
			scrapsHora = AritmeticaUtil.somar(dwConsolpr.getPcsAutoProducaorefugada(), dashboardFlexHoraDTO.getScraps());

		dashboardFlexHoraDTO.setScraps(scrapsHora.intValue());
		dashboardFlexOpDTO.setScraps(AritmeticaUtil.somar(scrapsHora, dashboardFlexOpDTO.getScraps()).intValue());
	}

	private void atualizarQuantidadeProduzida(DashboardFlexOpProdutoDTO dashboardFlexOpDTO, DashboardFlexHoraDTO dashboardFlexHoraDTO, DwConsolpr dwConsolpr) {
		BigDecimal produzidoHora = AritmeticaUtil.somar(dwConsolpr.getPcsAutoProducaobruta(), dashboardFlexHoraDTO.getProduzidos());
		BigDecimal metaHora = AritmeticaUtil.somar(dwConsolpr.getDwConsol().getPcsAutoProducaoprevista(), dashboardFlexHoraDTO.getMeta());
		BigDecimal downtime = AritmeticaUtil.somar(dwConsolpr.getDwConsol().getSegAutoTempoparadaCp(), dashboardFlexHoraDTO.getDowntime());
		
		dashboardFlexHoraDTO.setProduzidos(produzidoHora.intValue());
		dashboardFlexHoraDTO.setMeta(metaHora.intValue());
		dashboardFlexHoraDTO.setDowntime(downtime);

		// Atualiza a quantidade total de Produzindas com base a producao hora a hora
		int produzidosTotal = 0;
		for (DashboardFlexHoraDTO hora : dashboardFlexOpDTO.getHoras()) {
			produzidosTotal += hora.getProduzidos();
		}
		dashboardFlexOpDTO.setProduzidos(produzidosTotal);

	}

	private BigDecimal calcularIndiceDefeito(int defeitos, int produzido) {
		BigDecimal totalDefeito = new BigDecimal(defeitos);
		BigDecimal totalProduzido = new BigDecimal(produzido);
		BigDecimal indiceDefeito = FormulasInjet.calcularIndiceDefeito(totalProduzido, totalDefeito, 4);
		return indiceDefeito;
	}

	private String getCdCliente(PpCp ppCp) {
		PpCliente ppCliente = ppCp.getPpCliente();
		String cdCliente = (ppCliente == null ? CAMPO_INDEFINIDO : ppCliente.getCdCliente());
		return cdCliente;
	}

	private DashboardFlexHoraDTO getDashboardFlexHoraDTO(String cdCp, String cdCliente, String cdProduto, Date dthrIHora) {
		String key = getKeyOpClienteProdutoHora(cdCp, cdCliente, cdProduto, dthrIHora);
		DashboardFlexHoraDTO dashboardFlexHoraDTO = mapHorasDTO.get(key);
		return dashboardFlexHoraDTO;
	}

	private DashboardFlexOpProdutoDTO getDashboardFlexOpDTOIfNotExistsCreateAndAdd(String nrDoc, String cdCliente, OmProduto omProduto,
			DashboardFlexDTO dashboardFlexDTO, OmPt omPt, DwFolha dwFolha) throws SemCicloPadraoException {

		String cdProduto = omProduto.getCdProduto();
		String keyOpClienteProduto = getKeyOpClienteProduto(nrDoc, cdCliente, cdProduto);
		DashboardFlexOpProdutoDTO dashboardFlexOpDTO = mapOpProdutoClienteDTO.get(keyOpClienteProduto);

		if (dashboardFlexOpDTO == null) {
			BigDecimal cicloPadrao = folhaRN.getCicloPadrao(mapCicloPadrao, dwFolha, omPt);
			int metaDia = calcularMetaDia(tempoProdutivoDia, dwFolha, cicloPadrao, omProduto);
			int metaHoraAcumulado = calcularMetaDia(tempoProdutivoAteHoraAtual, dwFolha, cicloPadrao, omProduto);

			dashboardFlexOpDTO = createAndAddDashboardFlexOpDTO(nrDoc, cdCliente, cdProduto, metaDia, metaHoraAcumulado,
					keyOpClienteProduto, dashboardFlexDTO);
		}

		return dashboardFlexOpDTO;
	}

	private DashboardFlexOpProdutoDTO createAndAddDashboardFlexOpDTO(String nrDoc, String cdCliente, String cdProduto, int metaDia, int metaHoraAcumulado, String keyOpClienteProduto, DashboardFlexDTO dashboardFlexDTO) {
		DashboardFlexOpProdutoDTO dashboardFlexOpDTO;
		dashboardFlexOpDTO = createDashboardFlexOpProdutoDTO(nrDoc, cdCliente, cdProduto, metaDia, metaHoraAcumulado);
		mapOpProdutoClienteDTO.put(keyOpClienteProduto, dashboardFlexOpDTO);
		dashboardFlexDTO.getOpsProdutos().add(dashboardFlexOpDTO);
		return dashboardFlexOpDTO;
	}

	private DashboardFlexOpProdutoDTO createAndAddDashboardFlexOpDTO(String cdCp, String cdCliente, String cdProduto, int metaDia, int metaHoraAcumulado, DashboardFlexDTO dashboardFlexDTO) {
		String keyOpClienteProduto = getKeyOpClienteProduto(cdCp, cdCliente, cdProduto);
		DashboardFlexOpProdutoDTO dashboardFlexOpDTO = createAndAddDashboardFlexOpDTO(cdCp, cdCliente, cdProduto, metaDia, metaHoraAcumulado, keyOpClienteProduto, dashboardFlexDTO);
		return dashboardFlexOpDTO;
	}

	private String getKeyOpClienteProduto(String cdCp, String cdCliente, String cdProduto) {
		return cdCp + "#" + cdCliente + "#" + cdProduto;
	}

	private String getKeyOpClienteProdutoHora(String cdCp, String cdCliente, String cdProduto, Date dthrIHora) {
		return getKeyOpClienteProduto(cdCp, cdCliente, cdProduto) + "#" + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dthrIHora);
	}

	private DashboardFlexDTO createDashboardFlexDTO(String cdGt, Date dataHoraAtual) {
		DashboardFlexDTO dashboardFlexDTO = new DashboardFlexDTO();
		dashboardFlexDTO.setData(DataHoraRN.dateToStringDDMMYYYY(dataHoraAtual));
		dashboardFlexDTO.setHora(DataHoraRN.getTimeHHMMSSASString(dataHoraAtual));
		dashboardFlexDTO.setCdGt(cdGt);
		dashboardFlexDTO.setOpsProdutos(new ArrayList<DashboardFlexOpProdutoDTO>());
		return dashboardFlexDTO;
	}

	private DashboardFlexDTO montarVazioDTO(String cdGt, Date dataHoraAtual) {
		DashboardFlexDTO dashboardFlexDTO = createDashboardFlexDTO(cdGt, dataHoraAtual);
		DashboardFlexOpProdutoDTO dashboardFlexOpDTO =
				createDashboardFlexOpProdutoDTO(CAMPO_INDEFINIDO, CAMPO_INDEFINIDO, CAMPO_INDEFINIDO, 0, 0);
		dashboardFlexDTO.getOpsProdutos().add(dashboardFlexOpDTO);
		return dashboardFlexDTO;
	}

	private DashboardFlexOpProdutoDTO createDashboardFlexOpProdutoDTO(String nrDoc, String cliente, String modelo, int metaDia,
			int metaHoraAcumulado) {
		DashboardFlexOpProdutoDTO dashboardFlexOpDTO = new DashboardFlexOpProdutoDTO();
		dashboardFlexOpDTO.setCdCp(nrDoc);
		dashboardFlexOpDTO.setCliente(cliente);
		dashboardFlexOpDTO.setModelo(modelo);
		dashboardFlexOpDTO.setIndiceDefeito(0.0);
		dashboardFlexOpDTO.setIndiceDefeitoReal(0.0);
		dashboardFlexOpDTO.setIndiceDefeitoReal(0.0);
		dashboardFlexOpDTO.setMetaDia(metaDia);
		dashboardFlexOpDTO.setMetaHoraAcumulado(metaHoraAcumulado);
		dashboardFlexOpDTO.setProduzidos(0);
		dashboardFlexOpDTO.setDefeitos(0);
		dashboardFlexOpDTO.setScraps(0);
		dashboardFlexOpDTO.setHoras(new ArrayList<DashboardFlexHoraDTO>());

		int i = 1;
		for (PeriodoDTO periodoDTO : listaPeriodosHorasDTO) {

			DashboardFlexHoraDTO dashboardFlexHoraDTO = createDashboardFlexHoraDTO(i, periodoDTO);

			dashboardFlexOpDTO.getHoras().add(dashboardFlexHoraDTO);

			String key = getKeyOpClienteProdutoHora(nrDoc, cliente, modelo, periodoDTO.getDtHrInicio());

			mapHorasDTO.put(key, dashboardFlexHoraDTO);

			i++;

		}
		return dashboardFlexOpDTO;
	}

	private DashboardFlexHoraDTO createDashboardFlexHoraDTO(int i, PeriodoDTO periodoDTO) {
		DashboardFlexHoraDTO dashboardFlexHoraDTO = new DashboardFlexHoraDTO();
		dashboardFlexHoraDTO.setDthrIhoraFormatado(DataHoraRN.dateToStringHH(periodoDTO.getDtHrInicio()) + " - " + DataHoraRN.dateToStringHH(periodoDTO.getDtHrFim()));
		dashboardFlexHoraDTO.setHora(String.format(TEMPLATE_HORA, i));
		dashboardFlexHoraDTO.setProduzidos(0);
		dashboardFlexHoraDTO.setDefeitos(0);
		dashboardFlexHoraDTO.setScraps(0);
		return dashboardFlexHoraDTO;
	}

	private String getMensagem(Date dataHoraAtual, String cdGt, String cdPt) {
		return String.format(
				" Data %s, grupo de trabalho %s e posto de trabalho %s.",
				DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataHoraAtual),
				cdGt,
				cdPt);
	}

	private OmGt getOmGt(String cdGt) throws GtDesconhecidoException {
		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());
		OmGt omGt = omGtDAO.getOmGtPorCdAtivo(cdGt);
		if (omGt == null) {
			String msg = String.format("Grupo de trabalho %s não encontrado.", cdGt);
			throw new GtDesconhecidoException(msg);
		}
		return omGt;
	}

	private OmPt getOmPtContaGt(String cdGt) throws PtDesconhecidoException {
		OmPtDAO omPtDAO = new OmPtDAO(getDaoSession());
		OmPt omPt = omPtDAO.getOmPtContaGt(cdGt);
		if (omPt == null) {
			String msg = String.format("Não encontrado posto de trabalho que conte para o GT %s.", cdGt);
			throw new PtDesconhecidoException(msg);
		}
		return omPt;
	}

}
