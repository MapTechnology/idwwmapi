package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpalogtec;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwConsolpalogtecTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.util.FormulasInjet;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DetalheRecorrenciaParadaDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIItemRecorrenciaDTO;
import idw.webservices.dto.GraficoBIRecorrenciaDTO;
import ms.util.ConversaoTipos;

public class GraficoRecorrenciaParadaInjetRN extends GraficoRecorrenciaInjetFactory {

	public GraficoRecorrenciaParadaInjetRN() {
		super(new DAOGenericoInjet());
	}

	public GraficoRecorrenciaParadaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	/*
	 * Metodo principal para retornar o grafico de recorrencia tanto para parada quanto para refugo
	 */
	public GraficoBIRecorrenciaDTO getGraficoBIParetoRecorrencia(
			FiltroDetalhePTInjetDTO filtroBI, Byte tipoRecorrencia,
			String cdItem) {

		GraficoBIRecorrenciaDTO retorno = new GraficoBIRecorrenciaDTO();

		DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(getDao());
		GraficoBIItemRecorrenciaDTO itemGrafico = new GraficoBIItemRecorrenciaDTO();
		GraficoBIRecorrenciaDTO graficoTotais = new GraficoBIRecorrenciaDTO();
		DetalheMonitorizacaoPTInjetDTO indicadores = rn.getDetalheMonitorizacaoPtInjetDTO(filtroBI);
		DetalheRecorrenciaParadaDTO detParada;

		List<DetalheRecorrenciaParadaDTO> listaOcorrPar = new ArrayList<>();

		String cdparada = "";

		int indice = cdItem.indexOf("-");
		if (indice == -1) {
			cdparada = cdItem;
		} else {
			cdparada = cdItem.substring(0, indice);
		}

		BigDecimal cicloPadrao = null;
		BigDecimal cavAtiva = null;

		Integer duracaoParada = 0;

		Boolean existeItem = false;

		Double qtdPerdida = 0d;
		Double qtdPerdidaPesoKg = 0d;
		Double qtdPerdidaPesoTon = 0d;
		Double segTempoParada = 0d;
		Double segTempoParadaCP = 0d;
		Double segTempoParadaSP = 0d;
		Double indItem = 0d;

		StringBuilder toolTip;
		String periodo = "";

		graficoTotais.setGrafico(new ArrayList<GraficoBIItemRecorrenciaDTO>());
		retorno.setGrafico(new ArrayList<GraficoBIItemRecorrenciaDTO>());

		Map<String, String> mapOcor = new HashMap<String, String>();

		if (indicadores != null && indicadores.getListaDwConsolId() != null) {
			for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
				cicloPadrao = dwci.getDwConsol().getSegAutoCiclopadrao();
				cavAtiva = dwci.getDwConsol().getQtAutoCavativas();

				for (DwConsol dwc : dwci.getDwConsols()) {
					List<DwConsolpa> listaPas = getDwconsolPas(dwci, null);
					List<DwConsolid> consolids = new ArrayList<>();
					consolids.add(dwci);

					for (DwConsolpa dwcp : listaPas) {
						segTempoParada = 0d;
						segTempoParadaCP = 0d;
						segTempoParadaSP = 0d;

						if (dwcp.getSegAutoTempoparadaCp() != null) {
							segTempoParadaCP = dwcp.getSegAutoTempoparadaCp().doubleValue();
						}
						
						if (dwcp.getSegAutoTempoparadaSp() != null) {
							segTempoParadaSP = dwcp.getSegAutoTempoparadaSp().doubleValue();
						}

						segTempoParada = segTempoParadaCP + segTempoParadaSP;
						qtdPerdida =
								FormulasInjet.calcularPcsPerdaParada(new BigDecimal(segTempoParadaCP), cicloPadrao, cavAtiva).setScale(0, RoundingMode.FLOOR).doubleValue();
						qtdPerdidaPesoKg = 0d;
						qtdPerdidaPesoTon = 0d;

						// perdas por peso
						TreeMap<String, OmProduto> mapPro = new TreeMap<String, OmProduto>();
						for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
							if (dwcpr.getOmProduto().getGPesoBruto() != null && dwcpr.getOmProduto().getGPesoBruto().doubleValue() > 0) {
								Double perdaPesoKg = (new BigDecimal(qtdPerdida)
										.multiply(dwcpr.getOmProduto().getGPesoBruto()))
												.doubleValue()
										/ 1000;
								Double perdaPesoTon = (new BigDecimal(
										qtdPerdida).multiply(dwcpr.getOmProduto()
												.getGPesoBruto())).doubleValue()
										/ 1000000;

								qtdPerdidaPesoKg = qtdPerdidaPesoKg
										+ perdaPesoKg;
								qtdPerdidaPesoTon = qtdPerdidaPesoTon
										+ perdaPesoTon;
							}

							mapPro.put(dwcpr.getOmProduto().getCdProduto(), dwcpr.getOmProduto());
						}

						String produtos = ""; // serao adicionados as ocorrencias
						for (Map.Entry<String, OmProduto> m : mapPro.entrySet()) {
							OmProduto p = (OmProduto) m.getValue();
							if (produtos.equals("")) {
								produtos = p.getCdProduto();
							} else {
								produtos = produtos.concat("; ").concat(p.getCdProduto());
							}
						}

						itemGrafico = new GraficoBIItemRecorrenciaDTO();
						itemGrafico.setQtdPerdida(ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(new BigDecimal(qtdPerdida)).doubleValue());
						itemGrafico.setQtdPerdidaKg(qtdPerdidaPesoKg);
						itemGrafico.setQtdPerdidaTon(qtdPerdidaPesoTon);
						itemGrafico.setSegTempoParadas(segTempoParada);

						if (segTempoParadaSP > 0d) {
							itemGrafico.setIsParadaSemPeso(true);
						}

						if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
							itemGrafico.setDthrIni(dwci.getDthrIhora());
							itemGrafico.setDthrFim(dwci.getDthrFhora());
						} else {
							itemGrafico.setDthrIni(dwci.getDtReferencia());
							itemGrafico.setDthrFim(dwci.getDtReferencia());
						}

						// TOTAIS: Valida total geral do periodo
						// Necessario causa do calculo do indice
						existeItem = false;
						if (!graficoTotais.getGrafico().isEmpty()) {
							for (GraficoBIItemRecorrenciaDTO itemgraf : graficoTotais
									.getGrafico()) {
								if (DataHoraRN.compareTo(itemgraf.getDthrIni(), itemGrafico.getDthrIni()) == 0) {
									existeItem = true;

									// acumula
									itemgraf.setQtdPerdida(itemgraf
											.getQtdPerdida()
											+ itemGrafico.getQtdPerdida());
									itemgraf.setSegTempoParadas(itemgraf
											.getSegTempoParadas()
											+ itemGrafico.getSegTempoParadas());
									break;
								}
							}
						}

						if (!existeItem) {
							graficoTotais.getGrafico().add(itemGrafico);
						}

						// item especî§©co: acumular para cdItem
						if (dwcp.getDwTParada().getCdTparada().equals(cdparada)) {
							listaOcorrPar = new ArrayList<DetalheRecorrenciaParadaDTO>();

							for (DwConsolpaoco ocorr : dwcp.getDwConsolpaocos()) {
								if (ocorr.getDthrFparada() != null) {

									detParada = new DetalheRecorrenciaParadaDTO();
									detParada.setCdPt(dwci.getOmPt().getCdPt());
									detParada.setDsPt(dwci.getOmPt().getDsPt());
									detParada.setCdFolha(dwci.getDwFolha()
											.getCdFolha());
									detParada.setDsFolha(dwci.getDwFolha()
											.getDsFolha());

									detParada.setCdProduto(produtos);
									detParada.setDsProduto("");

									detParada.setCdTurno(dwci.getDwTurno().getCdTurno());
									detParada.setDsTurno(dwci.getDwTurno().getDsTurno());
									detParada.setDtHrIniPar(ocorr.getDwConsolpalog().getDthrIparada());
									if (ocorr.getDwConsolpalog().getDthrFparada() != null) {
										detParada.setDtHrFimPar(ocorr.getDwConsolpalog().getDthrFparada());
									} else {
										detParada.setDtHrFimPar(ocorr.getDthrFparada());
									}

									// limitar ocorrencia (ini/fim) ao periodo da barra
									if (filtroBI.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA)) {
										if (DataHoraRN.before(detParada.getDtHrIniPar(), dwci.getDthrIhora())) {
											detParada.setDtHrIniPar(dwci.getDthrIhora());
										}

										if (DataHoraRN.after(detParada.getDtHrFimPar(), dwci.getDthrFhora())) {
											detParada.setDtHrFimPar(dwci.getDthrFhora());
										}
									}

									if (filtroBI.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
										if (DataHoraRN.before(detParada.getDtHrIniPar(), dwci.getDthrIturno())) {
											detParada.setDtHrIniPar(dwci.getDthrIturno());
										}

										if (DataHoraRN.after(detParada.getDtHrFimPar(), dwci.getDthrFturno())) {
											detParada.setDtHrFimPar(dwci.getDthrFturno());
										}
									}

									String keyPar = dwci.getOmPt().getCdPt() + " - " + detParada.getDtHrIniPar();
									if (mapOcor.containsKey(keyPar) == false) {
										mapOcor.put(keyPar, keyPar);

										duracaoParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(detParada.getDtHrIniPar(),
												detParada.getDtHrFimPar());
										detParada.setDuracao(duracaoParada.doubleValue());
										listaOcorrPar.add(detParada);
									}
								}
							}

							qtdPerdida = FormulasInjet.calcularPcsPerdaParada(
									new BigDecimal(segTempoParadaCP),
									cicloPadrao, cavAtiva).setScale(0, RoundingMode.FLOOR).doubleValue();
							qtdPerdidaPesoKg = 0d;
							qtdPerdidaPesoTon = 0d;

							// perdas por peso
							for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
								if (dwcpr.getOmProduto().getGPesoBruto() != null
										&& dwcpr.getOmProduto().getGPesoBruto()
												.doubleValue() > 0d) {
									Double perdaPesoKg = (new BigDecimal(
											qtdPerdida).multiply(dwcpr
													.getOmProduto().getGPesoBruto()))
															.doubleValue()
											/ 1000;
									Double perdaPesoTon = (new BigDecimal(
											qtdPerdida).multiply(dwcpr
													.getOmProduto().getGPesoBruto()))
															.doubleValue()
											/ 1000000;

									qtdPerdidaPesoKg = qtdPerdidaPesoKg
											+ perdaPesoKg;
									qtdPerdidaPesoTon = qtdPerdidaPesoTon
											+ perdaPesoTon;
								}
							}

							itemGrafico = new GraficoBIItemRecorrenciaDTO();
							itemGrafico.setQtdPerdida(ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(new BigDecimal(qtdPerdida)).doubleValue());
							itemGrafico.setQtdPerdidaKg(qtdPerdidaPesoKg);
							itemGrafico.setQtdPerdidaTon(qtdPerdidaPesoTon);
							itemGrafico.setSegTempoParadas(segTempoParada);
							itemGrafico
									.setListaParadas(new ArrayList<DetalheRecorrenciaParadaDTO>());
							itemGrafico.getListaParadas().addAll(listaOcorrPar);

							if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
								itemGrafico.setDthrIni(dwci.getDthrIhora());
								itemGrafico.setDthrFim(dwci.getDthrFhora());
							} else {
								// DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO
								itemGrafico.setDthrIni(dwci.getDtReferencia());
								itemGrafico.setDthrFim(dwci.getDtReferencia());
							}

							// Marcos Sardinha: 2017-07-25 >> Defeito #4209
							if (segTempoParadaSP > 0d) {
								itemGrafico.setIsParadaSemPeso(true);
							}

							existeItem = false;
							if (!graficoTotais.getGrafico().isEmpty()) {
								for (GraficoBIItemRecorrenciaDTO itemgraf : retorno
										.getGrafico()) {
									if (DataHoraRN.compareTo(itemgraf.getDthrIni(),
											itemGrafico.getDthrIni()) == 0) {
										existeItem = true;

										// acumula
										itemgraf.setQtdPerdida(itemgraf
												.getQtdPerdida()
												+ itemGrafico.getQtdPerdida());
										itemgraf.setSegTempoParadas(itemgraf
												.getSegTempoParadas()
												+ itemGrafico
														.getSegTempoParadas());
										itemgraf.getListaParadas().addAll(
												listaOcorrPar);
										break;
									}
								}
							}

							if (!existeItem) {
								retorno.getGrafico().add(itemGrafico);
							}
						}
					}
				}
			}
		}

		// calcular os indices de cada intervalo
		for (GraficoBIItemRecorrenciaDTO itemIntervalo : retorno.getGrafico()) {
			itemIntervalo.setQtdPerdida(ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(new BigDecimal(itemIntervalo.getQtdPerdida())).doubleValue());
			
			for (GraficoBIItemRecorrenciaDTO itemIntervaloTotal : graficoTotais.getGrafico()) {
				if (DataHoraRN.compareTo(itemIntervalo.getDthrIni(),
						itemIntervaloTotal.getDthrIni()) == 0) {

					indItem = 0d;

					if (tipoRecorrencia == RECORRENCIA_PARADA) {

						if (itemIntervaloTotal.getSegTempoParadas().doubleValue() != 0d) {
							indItem = (itemIntervalo.getSegTempoParadas()
									.doubleValue() / itemIntervaloTotal
											.getSegTempoParadas().doubleValue())
									* 100;
						}
					} else {
						if (itemIntervaloTotal.getQtdPerdida().doubleValue() != 0d) {
							indItem = (itemIntervalo.getQtdPerdida().doubleValue() / itemIntervaloTotal
									.getQtdPerdida().doubleValue()) * 100;
						}
					}

					String strIndItem = ConversaoTipos.converteParaString(
							indItem, 2).replace(",", ".");
					indItem = Double.parseDouble(strIndItem);
					break;
				}

			}

			if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
				periodo = itemIntervalo.getDthrIni() + " - "
						+ itemIntervalo.getDthrFim();
			} else {
				periodo = DataHoraRN.dateToStringDDMMYYYY(itemIntervalo.getDthrIni());
			}

			// parada =
			// filtroBI.getDwTParada().getCdTparada()+"-"+filtroBI.getDwTParada().getDsTparada();

			if (tipoRecorrencia == RECORRENCIA_PARADA) {
				toolTip = new StringBuilder();
				toolTip.append("<html>");
				toolTip.append("Parada: ");
				toolTip.append(cdItem);
				toolTip.append("<br>");
				toolTip.append("Periodo: ");
				toolTip.append(periodo);
				toolTip.append("<br>");
				toolTip.append("Ind.parada no periodo: ");
				toolTip.append(ConversaoTipos.converteParaString(indItem, 2));
				toolTip.append("%");
				toolTip.append("<br>");
				toolTip.append("Tempo paradas: ");
				toolTip.append(DataHoraRN.formatSegundosParaHHMMSS(itemIntervalo.getSegTempoParadas().intValue()));
				toolTip.append("<br>");

				// Marcos Sardinha: 2017-07-25 >> Defeito #4209
				if (itemIntervalo.getIsParadaSemPeso() == false) {
					toolTip.append("Pcs perdidas ");
					toolTip.append(ConversaoTipos.converteParaString(ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(new BigDecimal(itemIntervalo.getQtdPerdida())).doubleValue(), 2));
					toolTip.append("<br>");
					toolTip.append("Pcs perdidas (Kg): ");
					toolTip.append(ConversaoTipos.converteParaString(itemIntervalo.getQtdPerdidaKg().doubleValue(), 4));
					toolTip.append("<br>");
					toolTip.append("Pcs perdidas (Ton): ");
					toolTip.append(ConversaoTipos.converteParaString(itemIntervalo.getQtdPerdidaTon().doubleValue(), 4));
				}
				toolTip.append("</html>");

			} else {
				// RECORRENCIA_REFUGO
				toolTip = new StringBuilder();
				toolTip.append("<html>");
				toolTip.append("Periodo: ");
				toolTip.append(periodo);
				toolTip.append("<br>");
				toolTip.append("Ind.refugo no periodo: ");
				toolTip.append(ConversaoTipos.converteParaString(indItem, 2));
				toolTip.append("%");
				toolTip.append("<br>");
				toolTip.append("Pcs refugadas : ");
				toolTip.append(ConversaoTipos.converteParaString(itemIntervalo.getQtdPerdida().doubleValue(), 2));
				toolTip.append("<br>");
				toolTip.append("Pcs refugadas (Kg): ");
				toolTip.append(ConversaoTipos.converteParaString(itemIntervalo.getQtdPerdidaKg().doubleValue(), 4));
				toolTip.append("<br>");
				toolTip.append("Pcs refugadas (Ton): ");
				toolTip.append(ConversaoTipos.converteParaString(itemIntervalo.getQtdPerdidaTon().doubleValue(), 4));
				toolTip.append("</html>");

			}
			itemIntervalo.setIndItem(indItem);
			itemIntervalo.setToolTip(toolTip.toString());
		}

		ordenarDetalheBIRecorrenciaPorPeriodo(retorno.getGrafico());
		return retorno;
	}

	@SuppressWarnings("unchecked")
	private List<DwConsolpa> getDwconsolPas(DwConsolid dwci, String cdParada) {
		List<DwConsolpa> listaPas = new ArrayList<>();

		int _dthrIniHora = 0;
		int _dtTurno = 0;
		int _cdTurno = _dtTurno + 1;
		int _nrOP = (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue()) ? _dthrIniHora : _cdTurno) + 1;
		int _cdMaquina = _nrOP + 1;
		int _cdMolde = _cdMaquina + 1;
		int _cdEstrutura = _cdMolde + 1;
		int _dthrIValEstru = _cdEstrutura + 1;
		int _dthrIValCic = _dthrIValEstru + 1;
		int _cdParada = _dthrIValCic + 1;
		int _dsParada = _cdParada + 1;
		int _cdArea = _dsParada + 1;
		int _dsArea = _cdArea + 1;
		int _segTmpParCP = _dsArea + 1;
		int _segTmpParSP = _segTmpParCP + 1;
		int _pcsPerdaParCP = _segTmpParSP + 1;
		int _pcsPerdaParSP = _pcsPerdaParCP + 1;
		int _qtOcorParCP = _pcsPerdaParSP + 1;
		int _qtOcorParSP = _qtOcorParCP + 1;

		class RegistroLido {
			Date dthrIniHora;
			Date dtTurno;
			String cdTurno;
			String nrOP;
			String cdMaquina;
			String cdMolde;
			String cdEstrutura;
			Date dthrIValEstru;
			Date dthrIValCic;
			String cdParada;
			String dsParada;
			String cdArea;
			String dsArea;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
			BigDecimal qtOcorParCP = BigDecimal.ZERO;
			BigDecimal qtOcorParSP = BigDecimal.ZERO;
		}

		String strSQL = "";
		if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL
					.concat("SELECT a.dthriniintervalo, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, ");
		} else {
			strSQL = strSQL.concat(
					"SELECT a.dtturno, a.cdturno, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, ");
		}

		strSQL = strSQL.concat("       a.cdparada, p.dsparada, p.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat("       a.tmpparadas, a.tmpparadassempeso, ");
		strSQL = strSQL.concat("       ( ( a.tmpparadas / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL
				.concat("       ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparSP, ");
		strSQL = strSQL.concat("       a.qtdparadas, a.qtdparadassempeso ");

		if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat("  FROM ijreaparcnsUT a ");
		} else {
			strSQL = strSQL.concat("  FROM ijreaparcnsTUR a ");
		}

		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 c2 ON (c2.cdmolde = ft.cdmolde AND c2.cdestrutura = ft.cdestrutura AND c2.dthrival = ft.dthrivalestru) ");

		// qdo houver filtro de id de ijcnsUT / ijcnsturno
		if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat(" JOIN ijcnsut cns ON (     cns.dthriniintervalo = a.dthriniintervalo ");
			strSQL = strSQL.concat("                       AND cns.cdinjetora = a.cdinjetora ");
			strSQL = strSQL.concat("                       AND cns.nrop = a.nrop ");
			strSQL = strSQL.concat("                       AND cns.cdmolde = a.cdmolde ");
			strSQL = strSQL.concat("                       AND cns.cdestrutura = a.cdestrutura ");
			strSQL = strSQL.concat("                       AND cns.dthrivalestru = a.dthrivalestru ");
			strSQL = strSQL.concat("                       AND cns.dthrivalcic = a.dthrivalcic) ");
		} else {
			strSQL = strSQL.concat(" JOIN ijcnsturno cns ON (    cns.dtturno = a.dtturno ");
			strSQL = strSQL.concat("                         AND cns.cdturno = a.cdturno ");
			strSQL = strSQL.concat("                         AND cns.cdinjetora = a.cdinjetora ");
			strSQL = strSQL.concat("                         AND cns.nrop = a.nrop ");
			strSQL = strSQL.concat("                         AND cns.cdmolde = a.cdmolde ");
			strSQL = strSQL.concat("                         AND cns.cdestrutura = a.cdestrutura ");
			strSQL = strSQL.concat("                         AND cns.dthrivalestru = a.dthrivalestru ");
			strSQL = strSQL.concat("                         AND cns.dthrivalcic = a.dthrivalcic) ");
		}

		strSQL = strSQL.concat("  WHERE cns.idregistro = :idregistro ");

		if (cdParada != null && cdParada != "") {
			strSQL = strSQL.concat(" AND a.cdparada = '" + cdParada + "'");
		}
		
		
		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setLong("idregistro", dwci.getIdConsolid());
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				registro.dthrIniHora = (Date) registroLido[_dthrIniHora];
			} else {
				registro.dtTurno = (Date) registroLido[_dtTurno];
				registro.cdTurno = (String) registroLido[_cdTurno];
			}

			registro.cdMaquina = (String) registroLido[_cdMaquina];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.nrOP = (String) registroLido[_nrOP];
			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];
			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];

			registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
			registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
			registro.pcsPerdaParCP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]).setScale(0, RoundingMode.FLOOR));
			registro.pcsPerdaParSP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]).setScale(0, RoundingMode.FLOOR));
			registro.qtOcorParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_qtOcorParCP]);
			registro.qtOcorParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_qtOcorParSP]);

			DwConsolpa pa = new DwConsolpa();
			pa.setSegAutoTempoparadaCp(registro.segTmpParCP);
			pa.setSegAutoTempoparadaSp(registro.segTmpParSP);
			pa.setPcsAutoPerdaparadaCp(registro.pcsPerdaParCP);
			pa.setPcsAutoPerdaparadaSp(registro.pcsPerdaParSP);
			pa.setQtAutoOcoparadaCp(registro.qtOcorParCP);
			pa.setQtAutoOcoparadaSp(registro.qtOcorParSP);

			DwTArea area = new DwTArea();
			area.setIdArea(ConversaoTipos.converterParaBigDecimal(registro.cdArea).longValue());
			area.setCdArea(registro.cdArea);
			area.setDsArea(registro.dsArea);

			DwTParada par = new DwTParada();
			par.setDwTArea(area);
			par.setIdTparada(ConversaoTipos
					.converterParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(registro.cdParada)).longValue());
			par.setCdTparada(registro.cdParada);
			par.setDsTparada(registro.dsParada);

			pa.setDwTParada(par);

			pa.setDwConsolpaocos(new HashSet<DwConsolpaoco>());
			pa.setDwConsolpaocos(getDwConsolpaoco(dwci.getTpId(),
					registro.dthrIniHora, registro.dtTurno, registro.cdTurno,
					registro.nrOP, registro.cdMaquina, registro.cdMolde, registro.cdEstrutura,
					registro.dthrIValEstru, registro.dthrIValCic, registro.cdParada));

			listaPas.add(pa);
		}

		return listaPas;
	}

	private Set<DwConsolpaoco> getDwConsolpaoco(Byte tpId,
			Date dtHrIniHora, Date dtTurno, String cdTurno,
			String nrOP, String cdMaquina, String cdMolde, String cdEstrutura,
			Date dthrIValEstru, Date dtdhrIValCic, String cdParada) {

		Set<DwConsolpaoco> retorno = new HashSet<DwConsolpaoco>();

		int _dthrIUT = 0;
		int _dtTurno = 0;
		int _cdTurno = _dtTurno + 1;
		int _dthrIniPar = (tpId.equals(DwConsolidTemplate.TpId.HORA.getValue()) ? _dthrIUT : _cdTurno) + 1;
		int _dthrFimPar = _dthrIniPar + 1;
		int _cdParada = _dthrFimPar + 1;
		int _dsParada = _cdParada + 1;
		int _cdCausa = _dsParada + 1;
		int _dsCausa = _cdCausa + 1;
		int _cdAcao = _dsCausa + 1;
		int _dsAcao = _cdAcao + 1;
		int _cdJust = _dsAcao + 1;
		int _dsJust = _cdJust + 1;
		int _cdArea = _dsJust + 1;
		int _dsArea = _cdArea + 1;
		int _isComPeso = _dsArea + 1;
		int _segTmpParCP = _isComPeso + 1;
		int _segTmpParSP = _segTmpParCP + 1;
		int _pcsPerdaParCP = _segTmpParSP + 1;
		int _pcsPerdaParSP = _pcsPerdaParCP + 1;
		int _cdMaquina = _pcsPerdaParSP + 1;
		int _cdMaqEstendido = _cdMaquina + 1;
		int _cdIdentific = _cdMaqEstendido + 1;
		int _cdMolde = _cdIdentific + 1;
		int _cdMolEstendido = _cdMolde + 1;
		int _cdTecR = _cdMolEstendido + 1;
		int _nmTecR = _cdTecR + 1;
		int _cdTec1 = _nmTecR + 1;
		int _nmTec1 = _cdTec1 + 1;
		int _cdTec2 = _nmTec1 + 1;
		int _nmTec2 = _cdTec2 + 1;

		class RegistroLido {
			Date dthrIUT;
			Date dtTurno;
			String cdTurno;
			Date dthrIniPar;
			Date dthrFimPar;
			String cdParada;
			String dsParada;
			String cdCausa;
			String dsCausa;
			String cdAcao;
			String dsAcao;
			String cdJust;
			String dsJust;
			String cdArea;
			String dsArea;
			int isComPeso;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
			String cdMaquina;
			String cdMaqEstendido;
			String cdIdentific;
			String cdMolde;
			String cdMolEstendido;
			String cdTecR;
			String nmTecR;
			String cdTec1;
			String nmTec1;
			String cdTec2;
			String nmTec2;
		}

		String strSQL = "";

		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
			strSQL = strSQL.concat("SELECT a.dtturno, a.cdturno, ");
		} else {
			strSQL = strSQL.concat("SELECT a.dthriniintervalo,  ");
		}

		strSQL = strSQL.concat(" a.dthripar, a.dthrfpar, ");
		strSQL = strSQL.concat(" a.cdparada, p.dsparada, ");
		strSQL = strSQL.concat(" cau.cdcausas, cau.dscausas, ");
		strSQL = strSQL.concat(" aco.cdacoes, aco.dsacoes, ");
		strSQL = strSQL.concat(" jup.cdjustparada, jup.dsjustparada, ");
		strSQL = strSQL.concat(" p.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat(" a.paradacompeso, a.tmpparadas, a.tmpparadassempeso, ");
		strSQL = strSQL.concat(" ( ( a.tmpparadas / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL
				.concat(" ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparSP,  ");
		strSQL = strSQL.concat(" i.cdinjetora, i.cdinjestendido, i.cdidentific, ");
		strSQL = strSQL.concat(" m.cdmolde, m.cdmolestendido, ");
		strSQL = strSQL.concat(" a.drtresponsa, ur.nmusuario as nmTecR, ");
		strSQL = strSQL.concat(" a.drtecnico1, u1.nmusuario as nmTec1, ");
		strSQL = strSQL.concat(" a.drttecnico2, u2.nmusuario as nmTec2 ");

		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
			strSQL = strSQL.concat(" FROM ijreaparcnsocorTUR a  ");	
		} else {
			strSQL = strSQL.concat(" FROM ijreaparcnsocorUT a  ");
		}
		
		
		strSQL = strSQL.concat(" JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(" JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		strSQL = strSQL.concat(" JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
		strSQL = strSQL.concat(
				" JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic)  ");
		strSQL = strSQL.concat(
				" JOIN cavidades2 c2 ON (c2.cdmolde = ft.cdmolde AND c2.cdestrutura = ft.cdestrutura AND c2.dthrival = ft.dthrivalestru)  ");

		strSQL = strSQL.concat(" LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbjup jup ON (jup.cdjustparada = a.cdjustparada) ");

        strSQL = strSQL.concat(" LEFT JOIN ijtbusu ur ON (ur.cdusuario = a.drtresponsa) ");
        strSQL = strSQL.concat(" LEFT JOIN ijtbusu u1 ON (u1.cdusuario = a.drtecnico1) ");
        strSQL = strSQL.concat(" LEFT JOIN ijtbusu u2 ON (u2.cdusuario = a.drttecnico2) ");
        
		// filtros
		if (tpId.equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat("  WHERE a.dthriniintervalo = :dthrini ");
		} else {
			strSQL = strSQL.concat("  WHERE a.dtturno = :dtturno ");
			strSQL = strSQL.concat("    AND a.cdturno = :cdturno ");
		}

		strSQL = strSQL.concat("    AND a.cdinjetora = :cdinjetora ");
		strSQL = strSQL.concat("    AND a.cdmolde = :cdmolde ");
		strSQL = strSQL.concat("    AND a.cdestrutura = :cdestrutura ");
		strSQL = strSQL.concat("    AND a.dthrivalestru = :dthrivalestru ");
		strSQL = strSQL.concat("    AND a.dthrivalcic = :dthrivalcic ");
		strSQL = strSQL.concat("    AND a.nrop = :nrop ");

		if (cdParada != null && cdParada != "") {
			strSQL = strSQL.concat("    AND a.cdparada = '" + cdParada + "'");
		}
		
		
		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		// definicao de parametros
		q.setString("cdinjetora", cdMaquina);
		q.setString("cdmolde", cdMolde);
		q.setString("cdestrutura", cdEstrutura);
		q.setTimestamp("dthrivalestru", dthrIValEstru);
		q.setTimestamp("dthrivalcic", dtdhrIValCic);
		q.setString("nrop", nrOP);

		// periodo e turno
		if (tpId.equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			q.setTimestamp("dthrini", dtHrIniHora);
		} else {
			q.setTimestamp("dtturno", dtTurno);
			q.setString("cdturno", cdTurno);
		}

		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			if (tpId.equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				registro.dthrIUT = (Date) registroLido[_dthrIUT];
			} else {
				registro.dtTurno = (Date) registroLido[_dtTurno];
				registro.cdTurno = (String) registroLido[_cdTurno];
			}

			registro.dthrIniPar = (Date) registroLido[_dthrIniPar];
			registro.dthrFimPar = (Date) registroLido[_dthrFimPar];
			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];
			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];

			if (registroLido[_cdCausa] != null) {
				registro.cdCausa = (String) registroLido[_cdCausa];
				registro.dsCausa = (String) registroLido[_dsCausa];
			}

			if (registroLido[_cdAcao] != null) {
				registro.cdAcao = (String) registroLido[_cdAcao];
				registro.dsAcao = (String) registroLido[_dsAcao];
			}

			if (registroLido[_cdJust] != null) {
				registro.cdJust = (String) registroLido[_cdJust];
				registro.dsJust = (String) registroLido[_dsJust];
			}

			registro.isComPeso = ConversaoTipos.converterParaBigDecimal(registroLido[_isComPeso]).intValue();

			registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
			registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
			
			registro.pcsPerdaParCP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]).setScale(0, RoundingMode.FLOOR));
			registro.pcsPerdaParSP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]).setScale(0, RoundingMode.FLOOR));

			registro.cdMaquina = (String) registroLido[_cdMaquina];
			registro.cdMaqEstendido = (String) registroLido[_cdMaqEstendido];
			registro.cdIdentific = (String) registroLido[_cdIdentific];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];

			if (registroLido[_cdTecR] != null) {
				registro.cdTecR = (String) registroLido[_cdTecR];
				registro.nmTecR = (String) registroLido[_nmTecR];
			}

			if (registroLido[_cdTec1] != null) {
				registro.cdTec1 = (String) registroLido[_cdTec1];
				registro.nmTec1 = (String) registroLido[_nmTec1];
			}

			if (registroLido[_cdTec2] != null) {
				registro.cdTec2 = (String) registroLido[_cdTec2];
				registro.nmTec2 = (String) registroLido[_nmTec2];
			}

			DwConsolpaoco paoco = new DwConsolpaoco();
			paoco.setDthrIparada(registro.dthrIniPar);
			paoco.setDthrFparada(registro.dthrFimPar);

			DwTArea area = new DwTArea();
			area.setCdArea(registro.cdArea);
			area.setIdArea(ConversaoTipos.converteParaInt(area.getCdArea()));
			area.setDsArea(registro.dsArea);

			DwTCausa causa = new DwTCausa();
			if (registro.cdCausa != null) {
				causa.setIdTcausa(ConversaoTipos.converterParaBigDecimal(registro.cdCausa).longValue());
				causa.setCdTcausa(registro.cdCausa);
				causa.setDsTcausa(registro.dsCausa);
			}

			DwTAcao acao = new DwTAcao();
			if (registro.cdAcao != null) {
				acao.setIdTacao(ConversaoTipos.converterParaBigDecimal(registro.cdAcao).longValue());
				acao.setCdTacao(registro.cdAcao);
				acao.setDsTacao(registro.dsAcao);
			}

			DwTJust just = new DwTJust();
			if (registro.cdJust != null) {
				just.setIdTjust(ConversaoTipos.converterParaBigDecimal(registro.cdJust).longValue());
				just.setCdTjust(registro.cdJust);
				just.setDsTjust(registro.dsJust);
			}

			Set<DwConsolpalogtec> listaTecnicos = new HashSet<DwConsolpalogtec>();
			OmUsr tecR = new OmUsr();
			if (registro.cdTecR != null) {
				tecR.setIdUsr(ConversaoTipos.converterParaBigDecimal(registro.cdTecR).longValue());
				tecR.setCdUsr(registro.cdTecR);
				tecR.setDsNome(registro.nmTecR);

				DwConsolpalogtec lt = new DwConsolpalogtec();
				lt.setOmUsr(tecR);
				lt.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TECRESP.getValue());
				listaTecnicos.add(lt);
			}

			OmUsr tec1 = new OmUsr();
			if (registro.cdTec1 != null) {
				tec1.setIdUsr(ConversaoTipos.converterParaBigDecimal(registro.cdTec1).longValue());
				tec1.setCdUsr(registro.cdTec1);
				tec1.setDsNome(registro.nmTec1);

				DwConsolpalogtec lt = new DwConsolpalogtec();
				lt.setOmUsr(tec1);
				lt.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TEC1.getValue());
				listaTecnicos.add(lt);

			}

			OmUsr tec2 = new OmUsr();
			if (registro.cdTec2 != null) {
				tec2.setIdUsr(ConversaoTipos.converterParaBigDecimal(registro.cdTec2).longValue());
				tec2.setCdUsr(registro.cdTec2);
				tec2.setDsNome(registro.nmTec2);

				DwConsolpalogtec lt = new DwConsolpalogtec();
				lt.setOmUsr(tec2);
				lt.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TEC2.getValue());
				listaTecnicos.add(lt);
			}

			DwTParada par = new DwTParada();
			par.setCdTparada(registro.cdParada);
			par.setIdTparada(ConversaoTipos
					.converterParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(par.getCdTparada())).longValue());
			par.setDsTparada(registro.dsParada);
			par.setDwTArea(area);

			DwConsolpalog paLog = new DwConsolpalog();
			paLog.setDthrIparada(registro.dthrIniPar);
			paLog.setDthrFparada(registro.dthrFimPar);
			paLog.setDwTAcao(acao);
			paLog.setDwTCausa(causa);
			paLog.setDwTJust(just);
			paLog.setDwTParada(par);
			paLog.setDwConsolpalogtecs(new HashSet<DwConsolpalogtec>());
			paLog.setDwConsolpalogtecs(listaTecnicos);

			paoco.setDwTAcao(acao);
			paoco.setDwTCausa(causa);
			paoco.setDwTJust(just);
			paoco.setDwConsolpalog(paLog);

			retorno.add(paoco);
		}

		return retorno;
	}
}
