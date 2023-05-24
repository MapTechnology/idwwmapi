package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.monitorizacao.injet.ConfiguracoesInjetRN;
import idw.model.rn.monitorizacao.injet.GraficoRecorrenciaRefugoInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIParetoDTO;
import idw.webservices.dto.GraficoBIParetoPerdasDTO;
import ms.util.ConversaoTipos;

public class GraficoBIParetoPerdasRN extends AbstractRN<DAOGenerico> {

	private FiltroDetalhePTInjetDTO filtro;
	private DetalheMonitorizacaoPTInjetDTO indicadores = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasMaquinasTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosMaquinasTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasProdutosTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosProdutosTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasMaquinas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosMaquinas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasProdutos = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosProdutos = null;

	private GraficoBIParetoPerdasDTO itemGraficoProduto = null;
	private GraficoBIParetoPerdasDTO itemGraficoMaquina = null;

	public static final Byte PARETO_TODAS = 1;
	public static final Byte PARETO_CICLOS = 2;
	public static final Byte PARETO_PCI = 3;
	public static final Byte PARETO_PARADAS = 4;
	public static final Byte PARETO_REFUGOS = 5;

	public static final Byte QTD_PARETO_PERDAS_BI_EM_UB = 1;
	public static final Byte QTD_PARETO_PERDAS_BI_EM_KG = 2;
	public static final Byte QTD_PARETO_PERDAS_BI_EM_TON = 3;

	/*
	 * itens utilizados no pareto de perdas do BI
	 */
	private static final Byte PARETO_BI_PRODUTOS = 1;
	private static final Byte PARETO_BI_MAQUINAS = 2;

	public GraficoBIParetoPerdasRN() {
		super(new DAOGenerico());
	}

	public GraficoBIParetoPerdasRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * Grafico de pareto do BI Paradas
	 */
	public GraficoBIParetoDTO getGrafBIParetoPerdas(Byte unidadeQtItem,
			FiltroDetalhePTInjetDTO filtroBI,
			DetalheMonitorizacaoPTInjetDTO indicadores) {

		GraficoBIParetoDTO graficos = new GraficoBIParetoDTO();

		this.filtro = filtroBI;
		this.indicadores = indicadores;

		prepararGraficoPerdasBI();

		if (filtro.getTipoPareto() == PARETO_TODAS) {
			graficos.setGrafBIMaquinaPerdas(graficoParetoBIPerdasMaquinasTodas);
			graficos.setGrafBIMaquinaGanhos(graficoParetoBIGanhosMaquinasTodas);
			graficos.setGrafBIProdutoPerdas(graficoParetoBIPerdasProdutosTodas);
			graficos.setGrafBIProdutoGanhos(graficoParetoBIGanhosProdutosTodas);

		} else {

			if (filtro.getTipoPareto() == PARETO_CICLOS) {
				graficos.setGrafBIMaquinaPerdas(graficoParetoBIPerdasMaquinas);
				graficos.setGrafBIMaquinaGanhos(graficoParetoBIGanhosMaquinas);
				graficos.setGrafBIProdutoPerdas(graficoParetoBIPerdasProdutos);
				graficos.setGrafBIProdutoGanhos(graficoParetoBIGanhosProdutos);

			} else {
				graficos.setGrafBIMaquinaPerdas(graficoParetoBIPerdasMaquinas);
				graficos.setGrafBIMaquinaGanhos(null);
				graficos.setGrafBIProdutoPerdas(graficoParetoBIPerdasProdutos);
				graficos.setGrafBIProdutoGanhos(null);
			}
		}

		if (graficos != null && graficos.getGrafBIMaquinaPerdas() != null)
			ordenarDetalheBIPorQtdeDecrescente(unidadeQtItem, graficos.getGrafBIMaquinaPerdas());
		if (graficos != null && graficos.getGrafBIProdutoPerdas() != null)
			ordenarDetalheBIPorQtdeDecrescente(unidadeQtItem, graficos.getGrafBIProdutoPerdas());
		if (graficos != null && graficos.getGrafBIMaquinaGanhos() != null) {
			ordenarDetalheBIPorQtdeDecrescente(unidadeQtItem, graficos.getGrafBIMaquinaGanhos());
		}
		if (graficos != null && graficos.getGrafBIProdutoGanhos() != null) {
			ordenarDetalheBIPorQtdeDecrescente(unidadeQtItem, graficos.getGrafBIProdutoGanhos());
		}

		return graficos;

	}

	private void prepararGraficoPerdasBI() {
		if (filtro.getTipoPareto() == PARETO_TODAS) {
			prepararGraficoPerdasBITodas();
			return;
		}

		if (filtro.getTipoPareto() == PARETO_CICLOS) {
			prepararGraficoPerdasBICiclos();
			return;
		}

		if (filtro.getTipoPareto() == PARETO_PARADAS) {
			prepararGraficoPerdasBIParadas();
			return;
		}

		if (filtro.getTipoPareto() == PARETO_REFUGOS) {
			prepararGraficoPerdasBIRefugos();
			return;
		}

		if (filtro.getTipoPareto() == PARETO_PCI) {
			prepararGraficoPerdasBIPCI();
			return;
		}

	}

	private void ordenarDetalheBIPorQtdeDecrescente(final Byte unidadeQtItem,
			List<GraficoBIParetoPerdasDTO> grafBIPareto) {
		Collections.sort(grafBIPareto,
				new Comparator<GraficoBIParetoPerdasDTO>() {
					@Override
					public int compare(final GraficoBIParetoPerdasDTO o1,
							final GraficoBIParetoPerdasDTO o2) {
						final GraficoBIParetoPerdasDTO item1 = o1;
						final GraficoBIParetoPerdasDTO item2 = o2;

						if (unidadeQtItem.equals(QTD_PARETO_PERDAS_BI_EM_UB)) {
							return -(item1.getQtdItem().compareTo(item2.getQtdItem()));
						} else {
							if (unidadeQtItem
									.equals(QTD_PARETO_PERDAS_BI_EM_KG)) {
								return -(item1.getQtdItemEmKg().compareTo(item2
										.getQtdItemEmKg()));
							} else {
								if (unidadeQtItem
										.equals(QTD_PARETO_PERDAS_BI_EM_TON)) {
									return -(item1.getQtdItemEmTon()
											.compareTo(item2.getQtdItemEmTon()));
								} else {

									return -(item1
											.getQtdItemEmUnidadeMonetaria().compareTo(item2
													.getQtdItemEmUnidadeMonetaria()));
								}
							}
						}
					}
				});
	}

	private void prepararGraficoPerdasBITodas() {
		graficoParetoBIPerdasProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();

		prepararGraficoPerdasBICiclos();
		atualizarGraficoPerdasBITodas();

		prepararGraficoPerdasBIParadas();
		atualizarGraficoPerdasBITodas();

		prepararGraficoPerdasBIRefugos();
		atualizarGraficoPerdasBITodas();

		prepararGraficoPerdasBIPCI();
		atualizarGraficoPerdasBITodas();

		if (IdwFacade.IS_IDW_ATIVO) {
			atualizarParetosPerdaGanho(graficoParetoBIPerdasProdutosTodas, graficoParetoBIGanhosProdutosTodas, false, false);
			atualizarParetosPerdaGanho(graficoParetoBIPerdasMaquinasTodas, graficoParetoBIGanhosMaquinasTodas, true, false);
		} else {
			atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasProdutosTodas, graficoParetoBIGanhosProdutosTodas, false, false);
			atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasMaquinasTodas, graficoParetoBIGanhosMaquinasTodas, true, false);
		}

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutosTodas,
				PARETO_BI_PRODUTOS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosProdutosTodas,
				PARETO_BI_PRODUTOS);

		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinasTodas,
				PARETO_BI_MAQUINAS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosMaquinasTodas,
				PARETO_BI_MAQUINAS);
	}

	private void prepararGraficoPerdasBICiclos() {
		BigDecimal segCicloPadrao = BigDecimal.ZERO;
		BigDecimal qtPcsCiclo = BigDecimal.ZERO;
		BigDecimal segRitmo = BigDecimal.ZERO;
		BigDecimal qtPerdasCiclo = BigDecimal.ZERO;

		BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloUnidadeMonetaria = BigDecimal.ZERO;
		BigDecimal pesoBruto = BigDecimal.ZERO;

		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();

		for (DwConsolid dwciAux : indicadores.getListaDwConsolId()) {
			DwConsolid dwci = null;
			if (IdwFacade.IS_IDW_ATIVO) {
				dwci = getDao().findById(DwConsolid.class, dwciAux.getIdConsolid(), false);
			} else {
				dwci = dwciAux;
			}

			for (DwConsol dwc : dwci.getDwConsols()) {
				for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
					itemGraficoProduto = new GraficoBIParetoPerdasDTO();
					itemGraficoMaquina = new GraficoBIParetoPerdasDTO();

					itemGraficoProduto.setIdItemPareto(dwcpr.getOmProduto()
							.getIdProduto());
					itemGraficoProduto.setCdItemPareto(dwcpr.getOmProduto()
							.getCdProduto());
					itemGraficoProduto.setDsItemPareto(dwcpr.getOmProduto()
							.getDsProduto());

					itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
					itemGraficoMaquina
							.setIdItemPareto(dwci.getOmPt().getIdPt());
					itemGraficoMaquina
							.setCdItemPareto(dwci.getOmPt().getCdPt());
					itemGraficoMaquina
							.setDsItemPareto(dwci.getOmPt().getDsPt());

					// ciclo padrÃ£o e pcs por ciclo -- pog
					FolhaRN folhaRN = new FolhaRN(this.getDao());
					segCicloPadrao = BigDecimal.ZERO;
					try {
						segCicloPadrao = folhaRN.getCicloPadrao(
								dwci.getDwFolha(), dwci.getOmPt());
					} catch (SemCicloPadraoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					qtPcsCiclo = BigDecimal.ZERO;
					try {
						qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(
								dwci.getDwFolha(), dwcpr.getOmProduto());
					} catch (SemPcsPorCicloAtivasException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					segRitmo = (dwc.getSegAutoRitmo() != null ? dwc.getSegAutoRitmo() : BigDecimal.ZERO);
					qtPerdasCiclo = FormulasInjet
							.calcularPcsPerdaciclo(segRitmo, segCicloPadrao,
									qtPcsCiclo);

					// perdas em kg e ton
					if (dwcpr.getOmProduto().getGPesoBruto() != null) {
						pesoBruto = dwcpr.getOmProduto().getGPesoBruto();

						// perdas em kg
						qtPerdasCicloKg = qtPerdasCiclo
								.multiply(new BigDecimal(pesoBruto
										.doubleValue() / 1000));

						// perdas em toneladas
						qtPerdasCicloTon = qtPerdasCiclo
								.multiply(new BigDecimal(pesoBruto
										.doubleValue() / 1000000));
					} else {
						qtPerdasCicloKg = BigDecimal.ZERO;
						qtPerdasCicloTon = BigDecimal.ZERO;
					}

					// perdas em unidade monetÃ¡ria
					if (dwcpr.getOmProduto().getVlCustounit() != null) {
						qtPerdasCicloUnidadeMonetaria = qtPerdasCiclo
								.multiply(dwcpr.getOmProduto().getVlCustounit());
					} else {
						qtPerdasCicloUnidadeMonetaria = BigDecimal.ZERO;
					}

					itemGraficoProduto.setQtdItem(0d);
					itemGraficoProduto.setQtdItemEmKg(0d);
					itemGraficoProduto.setQtdItemEmTon(0d);
					itemGraficoProduto.setQtdItemEmUnidadeMonetaria(0d);

					itemGraficoMaquina.setQtdItem(0d);
					itemGraficoMaquina.setQtdItemEmKg(0d);
					itemGraficoMaquina.setQtdItemEmTon(0d);
					itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(0d);

					if (qtPerdasCiclo.doubleValue() != 0d) {
						if (qtPerdasCiclo.doubleValue() > 0d) {
							itemGraficoProduto.setQtdItem(qtPerdasCiclo
									.doubleValue());
							itemGraficoMaquina.setQtdItem(qtPerdasCiclo
									.doubleValue());

							itemGraficoProduto.setQtdItemEmKg(qtPerdasCicloKg
									.doubleValue());
							itemGraficoProduto.setQtdItemEmTon(qtPerdasCicloTon
									.doubleValue());
							itemGraficoProduto
									.setQtdItemEmUnidadeMonetaria(qtPerdasCicloUnidadeMonetaria
											.doubleValue());

							itemGraficoMaquina.setQtdItemEmKg(qtPerdasCicloKg
									.doubleValue());
							itemGraficoMaquina.setQtdItemEmTon(qtPerdasCicloTon
									.doubleValue());
							itemGraficoMaquina
									.setQtdItemEmUnidadeMonetaria(qtPerdasCicloUnidadeMonetaria
											.doubleValue());

							atualizarPerdasBI(itemGraficoProduto,
									graficoParetoBIPerdasProdutos);
							atualizarPerdasBI(itemGraficoMaquina,
									graficoParetoBIPerdasMaquinas);
						} else {
							if (qtPerdasCiclo.doubleValue() < 0d) {
								itemGraficoProduto.setQtdItem(qtPerdasCiclo
										.abs().doubleValue());
								itemGraficoMaquina.setQtdItem(qtPerdasCiclo
										.abs().doubleValue());

								itemGraficoProduto
										.setQtdItemEmKg(qtPerdasCicloKg.abs()
												.doubleValue());
								itemGraficoProduto
										.setQtdItemEmTon(qtPerdasCicloTon.abs()
												.doubleValue());
								itemGraficoProduto
										.setQtdItemEmUnidadeMonetaria(qtPerdasCicloUnidadeMonetaria
												.abs().doubleValue());

								itemGraficoMaquina
										.setQtdItemEmKg(qtPerdasCicloKg.abs()
												.doubleValue());
								itemGraficoMaquina
										.setQtdItemEmTon(qtPerdasCicloTon.abs()
												.doubleValue());
								itemGraficoMaquina
										.setQtdItemEmUnidadeMonetaria(qtPerdasCicloUnidadeMonetaria
												.abs().doubleValue());

								atualizarGanhosBI(itemGraficoProduto,
										graficoParetoBIGanhosProdutos);
								atualizarGanhosBI(itemGraficoMaquina,
										graficoParetoBIGanhosMaquinas);
							}
						}

					}
				}
			}
		}

		if (IdwFacade.IS_IDW_ATIVO) {
			atualizarParetosPerdaGanho(graficoParetoBIPerdasProdutos, graficoParetoBIGanhosProdutos, false, true);
			atualizarParetosPerdaGanho(graficoParetoBIPerdasMaquinas, graficoParetoBIGanhosMaquinas, true, true);
		} else {
			atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasProdutos, graficoParetoBIGanhosProdutos, false, true);
			atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasMaquinas, graficoParetoBIGanhosMaquinas, true, true);
		}

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos,
				PARETO_BI_PRODUTOS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosProdutos,
				PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas,
				PARETO_BI_MAQUINAS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosMaquinas,
				PARETO_BI_MAQUINAS);

	}

	private void prepararGraficoPerdasBIParadas() {
		ConsolidaRN crn = new ConsolidaRN(getDao());

		BigDecimal segCicloPadrao = BigDecimal.ZERO;
		BigDecimal qtPcsCiclo = BigDecimal.ZERO;
		BigDecimal segtempoParadas = BigDecimal.ZERO;
		BigDecimal segtempoParadaSP = BigDecimal.ZERO;
		BigDecimal segtempoParadaCP = BigDecimal.ZERO;
		BigDecimal qtPerdasPar = BigDecimal.ZERO;
		BigDecimal qtPerdasParKg = BigDecimal.ZERO;
		BigDecimal qtPerdasParTon = BigDecimal.ZERO;
		BigDecimal qtPerdasParUM = BigDecimal.ZERO;
		BigDecimal pesoBruto = BigDecimal.ZERO;

		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();

		for (DwConsolid dwciAux : indicadores.getListaDwConsolId()) {
			DwConsolid dwci = null;
			if (IdwFacade.IS_IDW_ATIVO) {
				dwci = getDao().findById(DwConsolid.class, dwciAux.getIdConsolid(), false);
			} else {
				dwci = dwciAux;
			}

			for (DwConsol dwc : dwci.getDwConsols()) {
				List<DwConsolpa> listaPas = crn.getDwconsolPas(dwc);

				segtempoParadaSP = BigDecimal.ZERO;
				segtempoParadaCP = BigDecimal.ZERO;

				for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
					itemGraficoProduto = new GraficoBIParetoPerdasDTO();
					itemGraficoMaquina = new GraficoBIParetoPerdasDTO();

					itemGraficoProduto.setIdItemPareto(dwcpr.getOmProduto()
							.getIdProduto());
					itemGraficoProduto.setCdItemPareto(dwcpr.getOmProduto()
							.getCdProduto());
					itemGraficoProduto.setDsItemPareto(dwcpr.getOmProduto()
							.getDsProduto());

					itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
					itemGraficoMaquina
							.setIdItemPareto(dwci.getOmPt().getIdPt());
					itemGraficoMaquina
							.setCdItemPareto(dwci.getOmPt().getCdPt());
					itemGraficoMaquina
							.setDsItemPareto(dwci.getOmPt().getDsPt());

					// ciclo padrÃ£o e pcs por ciclo -- pog
					FolhaRN folhaRN = new FolhaRN(this.getDao());
					segCicloPadrao = BigDecimal.ZERO;
					try {
						segCicloPadrao = folhaRN.getCicloPadrao(
								dwci.getDwFolha(), dwci.getOmPt());
					} catch (SemCicloPadraoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					qtPcsCiclo = BigDecimal.ZERO;
					try {
						qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(
								dwci.getDwFolha(), dwcpr.getOmProduto());
					} catch (SemPcsPorCicloAtivasException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// Se o motivo da parada veio definido no filtro entao pegar
					// o tempo da parada definida, senao pegar o tempo total
					if ((filtro.getCdtparada() != null && filtro.getCdtparada().equals("") == false) ||
							(filtro.getDwtarea() != null)) {
						segtempoParadas = BigDecimal.ZERO;
						for (DwConsolpa consolpa : dwc.getDwConsolpas()) {
							Boolean isParadaValida = true;

							if (filtro.getDwtarea() != null) {
								if (!consolpa.getDwTParada().getDwTArea().getCdArea().equals(filtro.getDwtarea().getCdArea())) {
									isParadaValida = false;
								}
							}

							if (isParadaValida == true) {
								if (filtro.getCdtparada() != null && filtro.getCdtparada().equals("") == false) {
									if (!consolpa.getDwTParada().getCdTparada().equals(filtro.getCdtparada())) {
										isParadaValida = false;
									}
								}

								if (isParadaValida == true) {
									if (filtro.getIsParadasComPeso() != null && filtro.getIsParadasComPeso()
											&& consolpa.getDwTParada().getIsPesa() == false)
										continue;

									if (filtro.getIsParadasSemPeso() != null && filtro.getIsParadasSemPeso()
											&& consolpa.getDwTParada().getIsPesa())
										continue;

									if (consolpa.getSegAutoTempoparadaCp() != null) {
										segtempoParadaCP = segtempoParadaCP
												.add(consolpa
														.getSegAutoTempoparadaCp());
									} else {
										if (consolpa.getSegAutoTempoparadaSp() != null) {
											segtempoParadaSP = segtempoParadaSP
													.add(consolpa
															.getSegAutoTempoparadaSp());
										}
									}

								}
							}
						}
					} else {
						if (filtro.getIsParadasComPeso() != null && filtro.getIsParadasComPeso()) {
							// Pegar o tempo total da parada
							segtempoParadaCP = AritmeticaUtil.somar(
									dwc.getSegAutoTempoparadaCp() != null ? dwc
											.getSegAutoTempoparadaCp()
											: BigDecimal.ZERO,
									dwc.getSegManuTempoparadaCp() != null ? dwc
											.getSegManuTempoparadaCp()
											: BigDecimal.ZERO);
						}

						if (filtro.getIsParadasSemPeso() != null && filtro.getIsParadasSemPeso()) {
							// Pegar o tempo total da parada
							segtempoParadaSP = (AritmeticaUtil.somar(
									dwc.getSegAutoTempoparadaSp() != null ? dwc
											.getSegAutoTempoparadaSp()
											: BigDecimal.ZERO,
									dwc.getSegManuTempoparadaSp() != null ? dwc
											.getSegManuTempoparadaSp()
											: BigDecimal.ZERO));

						}
					}

					segtempoParadas = AritmeticaUtil.somar(segtempoParadaCP, segtempoParadaSP);

					if (segtempoParadaSP.doubleValue() > 0d) {
						itemGraficoProduto.setIsParadaSemPeso(true);
						itemGraficoMaquina.setIsParadaSemPeso(true);
					} else {
						itemGraficoProduto.setIsParadaSemPeso(false);
						itemGraficoMaquina.setIsParadaSemPeso(false);
					}

					qtPerdasPar = FormulasInjet.calcularPcsPerdaParada(
							segtempoParadas, segCicloPadrao, qtPcsCiclo);
					// qtPerdasPar = new BigDecimal(qtPerdasPar.longValue());

					// perdas em kg e ton
					if (dwcpr.getOmProduto().getGPesoBruto() != null) {
						pesoBruto = dwcpr.getOmProduto().getGPesoBruto();

						// perdas em kg
						qtPerdasParKg = qtPerdasPar.multiply(new BigDecimal(
								pesoBruto.doubleValue() / 1000));

						// perdas em toneladas
						qtPerdasParTon = qtPerdasPar.multiply(new BigDecimal(
								pesoBruto.doubleValue() / 1000000));
					} else {
						qtPerdasParKg = BigDecimal.ZERO;
						qtPerdasParTon = BigDecimal.ZERO;
					}

					// perdas em unidade monetÃ¡ria
					if (dwcpr.getOmProduto().getVlCustounit() != null) {
						qtPerdasParUM = qtPerdasPar.multiply(dwcpr
								.getOmProduto().getVlCustounit());
					} else {
						qtPerdasParUM = BigDecimal.ZERO;
					}

					itemGraficoProduto.setSegTempo(0d);
					itemGraficoProduto.setQtdItem(0d);
					itemGraficoProduto.setQtdItemEmKg(0d);
					itemGraficoProduto.setQtdItemEmTon(0d);
					itemGraficoProduto.setQtdItemEmUnidadeMonetaria(0d);

					itemGraficoMaquina.setSegTempo(0d);
					itemGraficoMaquina.setQtdItem(0d);
					itemGraficoMaquina.setQtdItemEmKg(0d);
					itemGraficoMaquina.setQtdItemEmTon(0d);
					itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(0d);

					if (qtPerdasPar.doubleValue() > 0d) {
						itemGraficoProduto.setSegTempo(segtempoParadas.doubleValue());
						itemGraficoMaquina.setSegTempo(segtempoParadas.doubleValue());

						itemGraficoProduto.setQtdItem(qtPerdasPar.doubleValue());
						itemGraficoMaquina.setQtdItem(qtPerdasPar.doubleValue());

						itemGraficoProduto.setQtdItemEmKg(qtPerdasParKg
								.doubleValue());
						itemGraficoProduto.setQtdItemEmTon(qtPerdasParTon
								.doubleValue());
						itemGraficoProduto
								.setQtdItemEmUnidadeMonetaria(qtPerdasParUM
										.doubleValue());

						itemGraficoMaquina.setQtdItemEmKg(qtPerdasParKg
								.doubleValue());
						itemGraficoMaquina.setQtdItemEmTon(qtPerdasParTon
								.doubleValue());
						itemGraficoMaquina
								.setQtdItemEmUnidadeMonetaria(qtPerdasParUM
										.doubleValue());
					}

					atualizarPerdasBI(itemGraficoProduto,
							graficoParetoBIPerdasProdutos);
					atualizarPerdasBI(itemGraficoMaquina,
							graficoParetoBIPerdasMaquinas);
				}
			}
		}

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos,
				PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas,
				PARETO_BI_MAQUINAS);
	}

	private void prepararGraficoPerdasBIRefugos() {
		BigDecimal qtPcsRef = BigDecimal.ZERO;
		BigDecimal qtPcsRefKg = BigDecimal.ZERO;
		BigDecimal qtPcsRefTon = BigDecimal.ZERO;
		BigDecimal qtPcsRefUM = BigDecimal.ZERO;
		BigDecimal pesoBruto = BigDecimal.ZERO;

		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();

		GraficoRecorrenciaRefugoInjetRN grRefRN = null;
		if (IdwFacade.IS_IDW_ATIVO == false) {
			grRefRN = new GraficoRecorrenciaRefugoInjetRN();
			grRefRN.getDao().iniciaSessao();
		}
		
		for (DwConsolid dwciAux : indicadores.getListaDwConsolId()) {
			DwConsolid dwci = null;
			if (IdwFacade.IS_IDW_ATIVO) {
				dwci = getDao().findById(DwConsolid.class, dwciAux.getIdConsolid(), false);
			} else {
				dwci = dwciAux;
			}

			for (DwConsol dwc : dwci.getDwConsols()) {
				if (IdwFacade.IS_IDW_ATIVO == false) {
					if (dwc.getDwConsolres().size() == 0) {
						dwc.getDwConsolres().addAll(grRefRN.getDwconsolRes(dwci, null));
					}
				}
				for (DwConsolre consolre : dwc.getDwConsolres()) {
					Boolean isRefugoOK = false;

					if ((filtro.getCdtrefugo() == null) || (filtro.getCdtrefugo() != null && filtro.getCdtrefugo().equals(""))) {
						isRefugoOK = true;
					} else {
						// recuperar refugos baseados nas ocorrencias
						if ((filtro.getCdtrefugo() != null && filtro.getCdtrefugo().equals("") == false
								&& consolre.getDwTRefugo().getCdTrefugo().equals(filtro.getCdtrefugo()))) {
							isRefugoOK = true;
						}
					}

					if (isRefugoOK) {
						for (DwConsolreoco oco : consolre.getDwConsolreocos()) {
							itemGraficoProduto = new GraficoBIParetoPerdasDTO();
							itemGraficoMaquina = new GraficoBIParetoPerdasDTO();

							itemGraficoProduto.setIdItemPareto(oco.getDwConsolrelog().getOmProduto()
									.getIdProduto());
							itemGraficoProduto.setCdItemPareto(oco.getDwConsolrelog().getOmProduto()
									.getCdProduto());
							itemGraficoProduto.setDsItemPareto(oco.getDwConsolrelog().getOmProduto()
									.getDsProduto());

							itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
							itemGraficoMaquina
									.setIdItemPareto(dwci.getOmPt().getIdPt());
							itemGraficoMaquina
									.setCdItemPareto(dwci.getOmPt().getCdPt());
							itemGraficoMaquina
									.setDsItemPareto(dwci.getOmPt().getDsPt());

							qtPcsRef = AritmeticaUtil.somar(
									oco.getDwConsolrelog().getPcsAutoProducaorefugada() != null ? oco.getDwConsolrelog()
											.getPcsAutoProducaorefugada()
											: BigDecimal.ZERO,
									oco.getDwConsolrelog().getPcsManuProducaorefugada() != null ? oco.getDwConsolrelog()
											.getPcsManuProducaorefugada()
											: BigDecimal.ZERO);

							// perdas em kg e ton
							if (oco.getDwConsolrelog().getOmProduto().getGPesoBruto() != null) {
								pesoBruto = oco.getDwConsolrelog().getOmProduto().getGPesoBruto();

								// perdas em kg
								qtPcsRefKg = qtPcsRef.multiply(new BigDecimal(pesoBruto
										.doubleValue() / 1000));

								// perdas em toneladas
								qtPcsRefTon = qtPcsRef.multiply(new BigDecimal(
										pesoBruto.doubleValue() / 1000000));
							} else {
								qtPcsRefKg = BigDecimal.ZERO;
								qtPcsRefTon = BigDecimal.ZERO;
							}

							// perdas em unidade monetaria
							if (oco.getDwConsolrelog().getOmProduto().getVlCustounit() != null) {
								qtPcsRefUM = qtPcsRef.multiply(oco.getDwConsolrelog().getOmProduto()
										.getVlCustounit());
							} else {
								qtPcsRefUM = BigDecimal.ZERO;
							}

							itemGraficoProduto.setQtdItem(0d);
							itemGraficoProduto.setQtdItemEmKg(0d);
							itemGraficoProduto.setQtdItemEmTon(0d);
							itemGraficoProduto.setQtdItemEmUnidadeMonetaria(0d);

							itemGraficoMaquina.setQtdItem(0d);
							itemGraficoMaquina.setQtdItemEmKg(0d);
							itemGraficoMaquina.setQtdItemEmTon(0d);
							itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(0d);

							itemGraficoProduto
									.setQtdItem((double) qtPcsRef.longValue());
							itemGraficoMaquina
									.setQtdItem((double) qtPcsRef.longValue());

							itemGraficoProduto.setQtdItemEmKg(qtPcsRefKg.doubleValue());
							itemGraficoProduto.setQtdItemEmTon(qtPcsRefTon
									.doubleValue());
							itemGraficoProduto.setQtdItemEmUnidadeMonetaria(qtPcsRefUM
									.doubleValue());

							itemGraficoMaquina.setQtdItemEmKg(qtPcsRefKg.doubleValue());
							itemGraficoMaquina.setQtdItemEmTon(qtPcsRefTon
									.doubleValue());
							itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(qtPcsRefUM
									.doubleValue());

							atualizarPerdasBI(itemGraficoProduto,
									graficoParetoBIPerdasProdutos);
							atualizarPerdasBI(itemGraficoMaquina,
									graficoParetoBIPerdasMaquinas);
						}
					}
				}
			}
		}
		
		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos,
				PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas,
				PARETO_BI_MAQUINAS);

		
		if (IdwFacade.IS_IDW_ATIVO == false) {
			grRefRN.getDao().finalizaSessao();
		}
	}

	private void prepararGraficoPerdasBIPCI() {
		Long qtPcsCicloAtivas = 0l;
		Long qtPcsCicloTotais = 0l;
		Long qtCiclosExec = 0l;

		BigDecimal qtPcs = BigDecimal.ZERO;
		BigDecimal qtPcsKg = BigDecimal.ZERO;
		BigDecimal qtPcsTon = BigDecimal.ZERO;
		BigDecimal qtPcsUM = BigDecimal.ZERO;
		BigDecimal pesoBruto = BigDecimal.ZERO;

		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();

		for (DwConsolid dwciAux : indicadores.getListaDwConsolId()) {
			DwConsolid dwci = null;
			if (IdwFacade.IS_IDW_ATIVO) {
				dwci = getDao().findById(DwConsolid.class, dwciAux.getIdConsolid(), false);
			} else {
				dwci = dwciAux;
			}

			for (DwConsol dwc : dwci.getDwConsols()) {
				for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

					// recupera pcs por ciclo ativas
					qtPcsCicloAtivas = 1l;
					qtPcsCicloTotais = 1l;

					try {
						if (dwc.getDwConsolid().getDwFolha().getDwFolharaps() != null) {
							for (DwFolharap rap : dwc.getDwConsolid()
									.getDwFolha().getDwFolharaps()) {
								for (DwFolharapcom rapcom : rap
										.getDwFolharapcoms()) {
									if (rapcom
											.getOmProduto()
											.getCdProduto()
											.equals(dwcpr.getOmProduto()
													.getCdProduto())) {
										// produtos sÃ£o iguais ... pega a qtd
										// de cavidades
										qtPcsCicloAtivas = rapcom.getQtAtiva()
												.longValue();
										qtPcsCicloTotais = rapcom.getQtTotal()
												.longValue();
										break;
									}
								}
							}
						}
					} catch (Exception e) {
						// se ocorrer erro considera cavidades como 1
					}

					qtCiclosExec = AritmeticaUtil
							.somar(dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo()
									: BigDecimal.ZERO,
									dwc.getQtManuCicloprodutivo() != null ? dwc
											.getQtManuCicloprodutivo()
											: BigDecimal.ZERO)
							.longValue();

					qtPcs = new BigDecimal(FormulasInjet.calcularPerdaCavidade(
							new BigDecimal(qtCiclosExec),
							new BigDecimal(qtPcsCicloTotais),
							new BigDecimal(qtPcsCicloAtivas)).doubleValue());

					if (qtPcs != BigDecimal.ZERO) {
						itemGraficoProduto = new GraficoBIParetoPerdasDTO();
						itemGraficoMaquina = new GraficoBIParetoPerdasDTO();

						itemGraficoProduto.setIdItemPareto(dwcpr.getOmProduto()
								.getIdProduto());
						itemGraficoProduto.setCdItemPareto(dwcpr.getOmProduto()
								.getCdProduto());
						itemGraficoProduto.setDsItemPareto(dwcpr.getOmProduto()
								.getDsProduto());

						itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
						itemGraficoMaquina.setIdItemPareto(dwci.getOmPt()
								.getIdPt());
						itemGraficoMaquina.setCdItemPareto(dwci.getOmPt()
								.getCdPt());
						itemGraficoMaquina.setDsItemPareto(dwci.getOmPt()
								.getDsPt());

						// perdas em kg e ton
						if (dwcpr.getOmProduto().getGPesoBruto() != null) {
							pesoBruto = dwcpr.getOmProduto().getGPesoBruto();

							// perdas em kg
							qtPcsKg = qtPcs.multiply(new BigDecimal(pesoBruto
									.doubleValue() / 1000));

							// perdas em toneladas
							qtPcsTon = qtPcs.multiply(new BigDecimal(pesoBruto
									.doubleValue() / 1000000));
						} else {
							qtPcsKg = BigDecimal.ZERO;
							qtPcsTon = BigDecimal.ZERO;
						}

						// perdas em unidade monetÃ¡ria
						if (dwcpr.getOmProduto().getVlCustounit() != null) {
							qtPcsUM = qtPcs.multiply(dwcpr.getOmProduto()
									.getVlCustounit());
						} else {
							qtPcsUM = BigDecimal.ZERO;
						}

						itemGraficoProduto.setQtdItem(0d);
						itemGraficoProduto.setQtdItemEmKg(0d);
						itemGraficoProduto.setQtdItemEmTon(0d);
						itemGraficoProduto.setQtdItemEmUnidadeMonetaria(0d);

						itemGraficoMaquina.setQtdItem(0d);
						itemGraficoMaquina.setQtdItemEmKg(0d);
						itemGraficoMaquina.setQtdItemEmTon(0d);
						itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(0d);

						itemGraficoProduto.setQtdItem((double) qtPcs
								.longValue());
						itemGraficoMaquina.setQtdItem((double) qtPcs
								.longValue());

						itemGraficoProduto
								.setQtdItemEmKg(qtPcsKg.doubleValue());
						itemGraficoProduto.setQtdItemEmTon(qtPcsTon
								.doubleValue());
						itemGraficoProduto.setQtdItemEmUnidadeMonetaria(qtPcsUM
								.doubleValue());

						itemGraficoMaquina
								.setQtdItemEmKg(qtPcsKg.doubleValue());
						itemGraficoMaquina.setQtdItemEmTon(qtPcsTon
								.doubleValue());
						itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(qtPcsUM
								.doubleValue());

						atualizarPerdasBI(itemGraficoProduto,
								graficoParetoBIPerdasProdutos);
						atualizarPerdasBI(itemGraficoMaquina,
								graficoParetoBIPerdasMaquinas);
					}
				}
			}
		}

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos,
				PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas,
				PARETO_BI_MAQUINAS);

	}

	private void atualizarGraficoPerdasBITodas() {
		Boolean existeItem = false;

		// perdas por produto
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIPerdasProdutos) {
			itemGraficoProduto = new GraficoBIParetoPerdasDTO();
			itemGraficoProduto.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoProduto.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoProduto.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoProduto.setIndItem(itemgraf.getIndItem());
			itemGraficoProduto.setQtdItem(itemgraf.getQtdItem());

			itemGraficoProduto.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoProduto.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoProduto.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoProduto.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoProduto.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoProduto.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica produto
			existeItem = false;
			if (graficoParetoBIPerdasProdutosTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIPerdasProdutosTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoProduto.getQtdItem());

						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoProduto.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoProduto.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoProduto
												.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIPerdasProdutosTodas.add(itemGraficoProduto);
			}
		}

		// perdas por mÃ¡quina
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIPerdasMaquinas) {
			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
			itemGraficoMaquina.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoMaquina.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoMaquina.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoMaquina.setIndItem(itemgraf.getIndItem());
			itemGraficoMaquina.setQtdItem(itemgraf.getQtdItem());

			itemGraficoMaquina.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoMaquina.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoMaquina.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoMaquina.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoMaquina.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica mÃ¡quina
			existeItem = false;
			if (graficoParetoBIPerdasMaquinasTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIPerdasMaquinasTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoMaquina.getQtdItem());
						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoMaquina.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoMaquina.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoMaquina
												.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIPerdasMaquinasTodas.add(itemGraficoMaquina);
			}
		}

		// ganhos por produto
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIGanhosProdutos) {
			itemGraficoProduto = new GraficoBIParetoPerdasDTO();
			itemGraficoProduto.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoProduto.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoProduto.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoProduto.setIndItem(itemgraf.getIndItem());
			itemGraficoProduto.setQtdItem(itemgraf.getQtdItem());

			itemGraficoProduto.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoProduto.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoProduto.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoProduto.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoProduto.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoProduto.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica produto
			existeItem = false;
			if (graficoParetoBIGanhosProdutosTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIGanhosProdutosTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoProduto.getQtdItem());
						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoProduto.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoProduto.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoProduto
												.getQtdItemEmUnidadeMonetaria());

						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIGanhosProdutosTodas.add(itemGraficoProduto);
			}
		}

		// ganhos por mÃ¡quina
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIGanhosMaquinas) {
			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
			itemGraficoMaquina.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoMaquina.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoMaquina.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoMaquina.setIndItem(itemgraf.getIndItem());
			itemGraficoMaquina.setQtdItem(itemgraf.getQtdItem());

			itemGraficoMaquina.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoMaquina.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoMaquina.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoMaquina.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoMaquina.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica mÃ¡quina
			existeItem = false;
			if (graficoParetoBIGanhosMaquinasTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIGanhosMaquinasTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoMaquina.getQtdItem());

						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoMaquina.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoMaquina.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoMaquina
												.getQtdItemEmUnidadeMonetaria());

						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIGanhosMaquinasTodas.add(itemGraficoMaquina);
			}
		}

	}

	private void calcularIndicePerdasBI(List<GraficoBIParetoPerdasDTO> listaBI,
			Byte tipoPareto) {
		Double totalPerdas = 0d;
		Double indPerdas = 0d;

		Double totalPerdasKg = 0d;
		Double totalPerdasTon = 0d;
		Double totalPerdasUM = 0d;
		Double indPerdasKg = 0d;
		Double indPerdasTon = 0d;
		Double indPerdasUM = 0d;

		String toolTip = "";
		String toolTipKg = "";
		String toolTipTon = "";
		String toolTipUnidadeMonetaria = "";


		// necessario por causa do Injet VF / empresas eventualmente sem perdas decimais
		List<GraficoBIParetoPerdasDTO> listaExcluir = new ArrayList<>();
		
		for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
			if (IdwFacade.IS_IDW_ATIVO == false) {
				Double valorConvertidoUBInjet =
						ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(itemgraf.getQtdItem())).doubleValue();
				itemgraf.setQtdItem(valorConvertidoUBInjet);
				if (itemgraf.getQtdItem() > 0) {					
					itemgraf.setQtdItem(valorConvertidoUBInjet);
					totalPerdas = totalPerdas + itemgraf.getQtdItem();
					totalPerdasKg = totalPerdasKg + itemgraf.getQtdItemEmKg();
					totalPerdasTon = totalPerdasTon + itemgraf.getQtdItemEmTon();
					totalPerdasUM = totalPerdasUM + itemgraf.getQtdItemEmUnidadeMonetaria();
				} else {
					listaExcluir.add(itemgraf);
				}	

			} else {
				totalPerdas = totalPerdas + itemgraf.getQtdItem();
				totalPerdasKg = totalPerdasKg + itemgraf.getQtdItemEmKg();
				totalPerdasTon = totalPerdasTon + itemgraf.getQtdItemEmTon();
				totalPerdasUM = totalPerdasUM + itemgraf.getQtdItemEmUnidadeMonetaria();
			}
		}

		if (listaExcluir.size() > 0) {
			for (GraficoBIParetoPerdasDTO itemgraf : listaExcluir) {
				listaBI.remove(itemgraf);
			}
		}
		
		
		if (totalPerdas > 0) {
			// calcula o Ã­ndice de perdas por mÃ¡quina
			for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
				indPerdas = 0d;
				indPerdasKg = 0d;
				indPerdasTon = 0d;
				indPerdasUM = 0d;

				if (totalPerdas > 0) {
					indPerdas = (itemgraf.getQtdItem() / totalPerdas) * 100;
					indPerdasKg = (itemgraf.getQtdItemEmKg() / totalPerdasKg) * 100;
					indPerdasTon = (itemgraf.getQtdItemEmTon() / totalPerdasTon) * 100;
					indPerdasUM = (itemgraf.getQtdItemEmUnidadeMonetaria() / totalPerdasUM) * 100;
				}
				itemgraf.setIndItem(indPerdas);
				itemgraf.setIndItemEmKg(indPerdasKg);
				itemgraf.setIndItemEmTon(indPerdasTon);
				itemgraf.setIndItemEmUnidadeMonetaria(indPerdasUM);

				if (tipoPareto == PARETO_BI_MAQUINAS) {
					toolTip = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTip = toolTip
								+ "Perdas: "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItem(), 2)
								+ "<br>";
					}

					toolTip = toolTip
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItem(), 2) + "%" + "</html>";

					toolTipKg = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipKg = toolTipKg
								+ "Perdas (Kg): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmKg(), 4)
								+ "<br>";
					}

					toolTipKg = toolTipKg
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItemEmKg(), 2) + "%" + "</html>";

					toolTipTon = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipTon = toolTipTon
								+ "Perdas (Ton): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmTon(), 4)
								+ "<br>";
					}

					toolTipTon = toolTipTon
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItemEmTon(), 2) + "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
								+ "Perdas ($): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
								+ "<br>";
					}

					toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";

				} else {
					toolTip = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTip = toolTip
								+ "Perdas: "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItem(), 2)
								+ "<br>";
					}

					toolTip = toolTip
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItem(), 2)
							+ "%" + "</html>";

					toolTipKg = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipKg = toolTipKg
								+ "Perdas (Kg): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmKg(), 4);

					}

					toolTipKg = toolTipKg
							+ "<br>"
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmKg(), 2)
							+ "%" + "</html>";

					toolTipTon = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipTon = toolTipTon
								+ "Perdas (Ton): "
								+ ConversaoTipos.converteParaString(
										itemgraf.getQtdItemEmTon(), 4)
								+ "<br>";
					}

					toolTipTon = toolTipTon
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmTon(), 2)
							+ "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
								+ "Perdas ($): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
								+ "<br>";
					}

					toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";
				}

				itemgraf.setToolTipItem(toolTip);
				itemgraf.setToolTipItemKg(toolTipKg);
				itemgraf.setToolTipItemTon(toolTipTon);
				itemgraf.setToolTipItemUnidadeMonetaria(toolTipUnidadeMonetaria);
			}
		}		
	}

	private void calcularIndiceGanhosBI(List<GraficoBIParetoPerdasDTO> listaBI,
			Byte tipoPareto) {
		Double totalItem = 0d;
		Double indItem = 0d;

		Double totalKg = 0d;
		Double totalTon = 0d;
		Double totalUM = 0d;
		Double indKg = 0d;
		Double indTon = 0d;
		Double indUM = 0d;

		String toolTip = "";
		String toolTipKg = "";
		String toolTipTon = "";
		String toolTipUnidadeMonetaria = "";

		// necessario por causa do Injet VF / empresas eventualmente sem perdas decimais
		List<GraficoBIParetoPerdasDTO> listaExcluir = new ArrayList<>();
		
		for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
			if (IdwFacade.IS_IDW_ATIVO == false) {
				Double valorConvertidoUBInjet = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(itemgraf.getQtdItem())).doubleValue();
				itemgraf.setQtdItem(valorConvertidoUBInjet);
				if (itemgraf.getQtdItem() > 0) {					
					totalItem = totalItem + itemgraf.getQtdItem();
					totalKg = totalKg + itemgraf.getQtdItemEmKg();
					totalTon = totalTon + itemgraf.getQtdItemEmTon();
					totalUM = totalUM + itemgraf.getQtdItemEmUnidadeMonetaria();
				} else {
					listaExcluir.add(itemgraf);
				}					

			} else {
				totalItem = totalItem + itemgraf.getQtdItem();
				totalKg = totalKg + itemgraf.getQtdItemEmKg();
				totalTon = totalTon + itemgraf.getQtdItemEmTon();
				totalUM = totalUM + itemgraf.getQtdItemEmUnidadeMonetaria();
			}
		}

		if (listaExcluir.size() > 0) {
			for (GraficoBIParetoPerdasDTO itemgraf : listaExcluir) {
				listaBI.remove(itemgraf);
			}
		}
		
		if (totalItem > 0) {
			// calcula o Ã­ndice de perdas por mÃ¡quina
			for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
				indItem = 0d;
				indKg = 0d;
				indTon = 0d;
				indUM = 0d;

				if (totalItem > 0) {
					indItem = (itemgraf.getQtdItem() / totalItem) * 100;
					indKg = (itemgraf.getQtdItemEmKg() / totalKg) * 100;
					indTon = (itemgraf.getQtdItemEmTon() / totalTon) * 100;
					indUM = (itemgraf.getQtdItemEmUnidadeMonetaria() / totalUM) * 100;
				}
				itemgraf.setIndItem(indItem);
				itemgraf.setIndItemEmKg(indKg);
				itemgraf.setIndItemEmTon(indTon);
				itemgraf.setIndItemEmUnidadeMonetaria(indUM);

				if (tipoPareto == PARETO_BI_MAQUINAS) {
					toolTip = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItem(), 2)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItem(), 2)
							+ "%" + "</html>";

					toolTipKg = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos (Kg): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmKg(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmKg(), 2)
							+ "%" + "</html>";

					toolTipTon = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos (Ton): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmTon(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmTon(), 2)
							+ "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos ($): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";

				} else {
					toolTip = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItem(), 2)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItem(), 2)
							+ "%" + "</html>";

					toolTipKg = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos (Kg): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmKg(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmKg(), 2)
							+ "%" + "</html>";

					toolTipTon = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Perdas (Ton): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmTon(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmTon(), 2)
							+ "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos ($): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";
				}

				itemgraf.setToolTipItem(toolTip);
				itemgraf.setToolTipItemKg(toolTipKg);
				itemgraf.setToolTipItemTon(toolTipTon);
				itemgraf.setToolTipItemUnidadeMonetaria(toolTipUnidadeMonetaria);
			}
		}

	}


	private void atualizarPerdasBI(GraficoBIParetoPerdasDTO itemLista,
			List<GraficoBIParetoPerdasDTO> listaBI) {
		Boolean existeItem = false;

		if (itemLista.getQtdItem() > 0) {
			if (listaBI.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
					if (itemLista.getCdItemPareto().equals(
							itemgraf.getCdItemPareto())) {

						// acumula
						if (itemgraf.getSegTempo() != null) {
							itemgraf.setSegTempo(itemgraf.getSegTempo()
									+ itemLista.getSegTempo());
						}
						itemgraf.setQtdItem(itemgraf.getQtdItem()
								+ itemLista.getQtdItem());
						itemgraf.setQtdItemEmKg(itemgraf.getQtdItemEmKg()
								+ itemLista.getQtdItemEmKg());
						itemgraf.setQtdItemEmTon(itemgraf.getQtdItemEmTon()
								+ itemLista.getQtdItemEmTon());
						itemgraf.setQtdItemEmUnidadeMonetaria(itemgraf
								.getQtdItemEmUnidadeMonetaria()
								+ itemLista.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				listaBI.add(itemLista);
			}
		}

	}

	
	private void atualizarGanhosBI(GraficoBIParetoPerdasDTO itemLista,
			List<GraficoBIParetoPerdasDTO> listaBI) {
		Boolean existeItem = false;

		if (itemLista.getQtdItem() > 0) {
			if (listaBI.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
					if (itemLista.getCdItemPareto().equals(
							itemgraf.getCdItemPareto())) {
						// acumula
						if (itemgraf.getSegTempo() != null) {
							itemgraf.setSegTempo(itemgraf.getSegTempo()
									+ itemLista.getSegTempo());
						}
						itemgraf.setQtdItem(itemgraf.getQtdItem()
								+ itemLista.getQtdItem());
						itemgraf.setQtdItemEmKg(itemgraf.getQtdItemEmKg()
								+ itemLista.getQtdItemEmKg());
						itemgraf.setQtdItemEmTon(itemgraf.getQtdItemEmTon()
								+ itemLista.getQtdItemEmTon());
						itemgraf.setQtdItemEmUnidadeMonetaria(itemgraf
								.getQtdItemEmUnidadeMonetaria()
								+ itemLista.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				listaBI.add(itemLista);
			}
		}
	}

	private void atualizarParetosPerdaGanho(List<GraficoBIParetoPerdasDTO> grafPerdas, List<GraficoBIParetoPerdasDTO> grafGanhos,
			Boolean isMaquina, Boolean isCiclo) {
		GraficoBIParetoPerdasDTO itemGrafico = new GraficoBIParetoPerdasDTO();

		if (grafPerdas != null && grafGanhos != null) {

			Map<Long, Long> mapMaquina = new HashMap<Long, Long>();

			List<GraficoBIParetoPerdasDTO> grafBIPerdas = new ArrayList<GraficoBIParetoPerdasDTO>();
			List<GraficoBIParetoPerdasDTO> grafBIGanhos = new ArrayList<GraficoBIParetoPerdasDTO>();

			for (GraficoBIParetoPerdasDTO perda : grafPerdas) {
				if (!mapMaquina.containsKey(perda.getIdItemPareto())) {
					mapMaquina.put(perda.getIdItemPareto(), null);
				}
			}
			for (GraficoBIParetoPerdasDTO ganho : grafGanhos) {
				if (!mapMaquina.containsKey(ganho.getIdItemPareto())) {
					mapMaquina.put(ganho.getIdItemPareto(), null);
				}
			}

			Set<Long> keysMaquinas = mapMaquina.keySet();
			GraficoBIParetoPerdasDTO itemPerda = null;
			GraficoBIParetoPerdasDTO itemGanho = null;

			for (Long maq : keysMaquinas) {
				// MAQ - ver se o resultado de cada item eh perda ou ganho
				itemPerda = null;
				itemGanho = null;
				for (GraficoBIParetoPerdasDTO perda : grafPerdas) {
					if (perda.getIdItemPareto().equals(maq)) {
						itemPerda = new GraficoBIParetoPerdasDTO();
						itemPerda = perda;
						break;
					}
				}

				for (GraficoBIParetoPerdasDTO ganho : grafGanhos) {
					if (ganho.getIdItemPareto().equals(maq)) {
						itemGanho = new GraficoBIParetoPerdasDTO();
						itemGanho = ganho;
						break;
					}
				}

				if (itemPerda != null && itemGanho == null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico = itemPerda;
					grafBIPerdas.add(itemGrafico);
				}

				if (itemGanho != null && itemPerda == null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico = itemGanho;
					grafBIGanhos.add(itemGrafico);
				}

				if (itemPerda != null && itemGanho != null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico.setIdItemPareto(itemPerda.getIdItemPareto());
					itemGrafico.setCdItemPareto(itemPerda.getCdItemPareto());
					itemGrafico.setDsItemPareto(itemPerda.getDsItemPareto());
					itemGrafico.setSegTempo(itemPerda.getSegTempo());

					itemGrafico.setIndItem(0d);
					itemGrafico.setIndItemEmKg(0d);
					itemGrafico.setIndItemEmTon(0d);
					itemGrafico.setIndItemEmUnidadeMonetaria(0d);

					itemGrafico.setToolTipItem("");
					itemGrafico.setToolTipItemKg("");
					itemGrafico.setToolTipItemTon("");
					itemGrafico.setToolTipItemUnidadeMonetaria("");

					itemGrafico.setQtdItem(itemPerda.getQtdItem() - itemGanho.getQtdItem());
					itemGrafico.setQtdItemEmKg(itemPerda.getQtdItemEmKg() - itemGanho.getQtdItemEmKg());
					itemGrafico.setQtdItemEmTon(itemPerda.getQtdItemEmTon() - itemGanho.getQtdItemEmTon());
					itemGrafico.setQtdItemEmUnidadeMonetaria(
							itemPerda.getQtdItemEmUnidadeMonetaria() - itemGanho.getQtdItemEmUnidadeMonetaria());

					if (itemGrafico.getQtdItem() < 0) {
						// ganho
						itemGrafico.setQtdItem(itemGrafico.getQtdItem() * -1);
						itemGrafico.setQtdItemEmKg(itemGrafico.getQtdItemEmKg() * -1);
						itemGrafico.setQtdItemEmTon(itemGrafico.getQtdItemEmTon() * -1);
						itemGrafico.setQtdItemEmUnidadeMonetaria(itemGrafico.getQtdItemEmUnidadeMonetaria() * -1);

						grafBIGanhos.add(itemGrafico);

					} else {
						if (itemGrafico.getQtdItem() > 0) {
							// perda
							grafBIPerdas.add(itemGrafico);

						} else {
							// ignorar - perdas e ganhos se anularam
						}
					}
				}
			}

			if (isCiclo) {
				if (isMaquina) {
					graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasMaquinas = grafBIPerdas;
					graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosMaquinas = grafBIGanhos;
				} else {
					graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasProdutos = grafBIPerdas;
					graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosProdutos = grafBIGanhos;
				}
			} else {
				if (isMaquina) {
					graficoParetoBIPerdasMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasMaquinasTodas = grafBIPerdas;
					graficoParetoBIGanhosMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosMaquinasTodas = grafBIGanhos;
				} else {
					graficoParetoBIPerdasProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasProdutosTodas = grafBIPerdas;
					graficoParetoBIGanhosProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosProdutosTodas = grafBIGanhos;
				}
			}
		}
	}

	private void atualizarParetosPerdaGanhoInjet(List<GraficoBIParetoPerdasDTO> grafPerdas, List<GraficoBIParetoPerdasDTO> grafGanhos,
			Boolean isMaquina, Boolean isCiclo) {
		GraficoBIParetoPerdasDTO itemGrafico = new GraficoBIParetoPerdasDTO();

		if (grafPerdas != null && grafGanhos != null) {

			Map<String, String> mapMaquina = new HashMap<String, String>();

			List<GraficoBIParetoPerdasDTO> grafBIPerdas = new ArrayList<GraficoBIParetoPerdasDTO>();
			List<GraficoBIParetoPerdasDTO> grafBIGanhos = new ArrayList<GraficoBIParetoPerdasDTO>();

			for (GraficoBIParetoPerdasDTO perda : grafPerdas) {
				if (!mapMaquina.containsKey(perda.getCdItemPareto())) {
					mapMaquina.put(perda.getCdItemPareto(), null);
				}
			}
			for (GraficoBIParetoPerdasDTO ganho : grafGanhos) {
				if (!mapMaquina.containsKey(ganho.getCdItemPareto())) {
					mapMaquina.put(ganho.getCdItemPareto(), null);
				}
			}

			Set<String> keysMaquinas = mapMaquina.keySet();
			GraficoBIParetoPerdasDTO itemPerda = null;
			GraficoBIParetoPerdasDTO itemGanho = null;

			for (String maq : keysMaquinas) {
				// MAQ - ver se o resultado de cada item eh perda ou ganho
				itemPerda = null;
				itemGanho = null;
				for (GraficoBIParetoPerdasDTO perda : grafPerdas) {
					if (perda.getCdItemPareto().equals(maq)) {
						itemPerda = new GraficoBIParetoPerdasDTO();
						itemPerda = perda;
						break;
					}
				}

				for (GraficoBIParetoPerdasDTO ganho : grafGanhos) {
					if (ganho.getCdItemPareto().equals(maq)) {
						itemGanho = new GraficoBIParetoPerdasDTO();
						itemGanho = ganho;
						break;
					}
				}

				if (itemPerda != null && itemGanho == null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico = itemPerda;
					grafBIPerdas.add(itemGrafico);
				}

				if (itemGanho != null && itemPerda == null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico = itemGanho;
					grafBIGanhos.add(itemGrafico);
				}

				if (itemPerda != null && itemGanho != null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico.setIdItemPareto(itemPerda.getIdItemPareto());
					itemGrafico.setCdItemPareto(itemPerda.getCdItemPareto());
					itemGrafico.setDsItemPareto(itemPerda.getDsItemPareto());
					itemGrafico.setSegTempo(itemPerda.getSegTempo());

					itemGrafico.setIndItem(0d);
					itemGrafico.setIndItemEmKg(0d);
					itemGrafico.setIndItemEmTon(0d);
					itemGrafico.setIndItemEmUnidadeMonetaria(0d);

					itemGrafico.setToolTipItem("");
					itemGrafico.setToolTipItemKg("");
					itemGrafico.setToolTipItemTon("");
					itemGrafico.setToolTipItemUnidadeMonetaria("");

					itemGrafico.setQtdItem(itemPerda.getQtdItem() - itemGanho.getQtdItem());
					
					if (IdwFacade.IS_IDW_ATIVO == false) {
						itemGrafico.setQtdItem(
								ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(itemGrafico.getQtdItem()))
										.doubleValue());
					}
					itemGrafico.setQtdItemEmKg(itemPerda.getQtdItemEmKg() - itemGanho.getQtdItemEmKg());
					itemGrafico.setQtdItemEmTon(itemPerda.getQtdItemEmTon() - itemGanho.getQtdItemEmTon());
					itemGrafico.setQtdItemEmUnidadeMonetaria(
							itemPerda.getQtdItemEmUnidadeMonetaria() - itemGanho.getQtdItemEmUnidadeMonetaria());

					if (itemGrafico.getQtdItem() < 0) {
						// ganho
						itemGrafico.setQtdItem(itemGrafico.getQtdItem() * -1);
						itemGrafico.setQtdItemEmKg(itemGrafico.getQtdItemEmKg() * -1);
						itemGrafico.setQtdItemEmTon(itemGrafico.getQtdItemEmTon() * -1);
						itemGrafico.setQtdItemEmUnidadeMonetaria(itemGrafico.getQtdItemEmUnidadeMonetaria() * -1);

						grafBIGanhos.add(itemGrafico);

					} else {
						if (itemGrafico.getQtdItem() > 0) {
							// perda
							grafBIPerdas.add(itemGrafico);

						} else {
							// ignorar - perdas e ganhos se anularam
						}
					}
				}
			}

			/*
			if (isCiclo) {
				if (isMaquina) {
					graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasMaquinas = grafBIPerdas;
					graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosMaquinas = grafBIGanhos;
				} else {
					graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasProdutos = grafBIPerdas;
					graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosProdutos = grafBIGanhos;
				}
			} else {
				if (isMaquina) {
					graficoParetoBIPerdasMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasMaquinasTodas = grafBIPerdas;
					graficoParetoBIGanhosMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosMaquinasTodas = grafBIGanhos;
				} else {
					graficoParetoBIPerdasProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIPerdasProdutosTodas = grafBIPerdas;
					graficoParetoBIGanhosProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
					graficoParetoBIGanhosProdutosTodas = grafBIGanhos;
				}
			}
			*/
		}
	}

}
