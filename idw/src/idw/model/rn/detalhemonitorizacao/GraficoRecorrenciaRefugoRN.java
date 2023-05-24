package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalheRecorrenciaRefugoDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIItemRecorrenciaDTO;
import idw.webservices.dto.GraficoBIRecorrenciaDTO;
import ms.util.ConversaoTipos;

public class GraficoRecorrenciaRefugoRN extends GraficoRecorrenciaFactory {

	public GraficoRecorrenciaRefugoRN() {
		super(new DAOGenerico());
	}

	public GraficoRecorrenciaRefugoRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * Metodo principal para retornar o grafico de recorrencia tanto para parada
	 * quanto para refugo
	 */
	public GraficoBIRecorrenciaDTO getGraficoBIParetoRecorrencia(FiltroDetalhePTInjetDTO filtroBI, Byte tipoRecorrencia, String cdItem) {

		IdwLogger log = new IdwLogger("getGraficoBIParetoRecorrencia");
		
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN(getDao());

		GraficoBIItemRecorrenciaDTO itemGrafico = new GraficoBIItemRecorrenciaDTO();
		GraficoBIRecorrenciaDTO grafico = new GraficoBIRecorrenciaDTO();
		GraficoBIRecorrenciaDTO graficoTotais = new GraficoBIRecorrenciaDTO();
		List<DwConsolid> ids = rn.pesquisarDwConsolids(log, filtroBI);
		DetalheRecorrenciaRefugoDTO detRefugo;

		List<DetalheRecorrenciaRefugoDTO> listaOcorrRef = new ArrayList<>();

		String cdparada = "";

		int indice = cdItem.indexOf("-");
		if (indice == -1) {
			cdparada = cdItem;
		} else {
			cdparada = cdItem.substring(0, indice);
		}

		boolean isExisteItem = false;

		Double qtdPerdida = 0d;
		Double qtdPerdidaPesoKg = 0d;
		Double qtdPerdidaPesoTon = 0d;
		Double segTempoParada = 0d;
		Double indItem = 0d;

		StringBuilder toolTip;
		String periodo = "";

		graficoTotais.setGrafico(new ArrayList<GraficoBIItemRecorrenciaDTO>());
		grafico.setGrafico(new ArrayList<GraficoBIItemRecorrenciaDTO>());
		
		if (ids != null && ids.isEmpty() == false) {

			for (DwConsolid dwci : ids) {
				// RECORRENCIA_REFUGO
				for (DwConsol dwc : dwci.getDwConsols()) {
					
					List<DwConsolre> listaRes = rn.getDwconsolRes(dwc);
					
					// Interage com todas os refugos
					
					for (DwConsolre dwcr : listaRes) {
						
						segTempoParada = 0d;

						qtdPerdida = dwcr.getPcsAutoProducaorefugada() != null ? dwcr.getPcsAutoProducaorefugada().doubleValue() : 0d;
						qtdPerdida += dwcr.getPcsManuProducaorefugada() != null ? dwcr.getPcsManuProducaorefugada().doubleValue() : 0d;

						qtdPerdidaPesoKg = 0d;
						qtdPerdidaPesoTon = 0d;

						// perdas por peso
						for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

							if (dwcpr.getOmProduto().getGPesoBruto() != null && dwcpr.getOmProduto().getGPesoBruto().compareTo(BigDecimal.ZERO) > 0) {
								BigDecimal pesoBruto = dwcpr.getOmProduto().getGPesoBruto();
								BigDecimal pesoBrutoKg = pesoBruto.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN);
								BigDecimal pesoBrutoTon = pesoBruto.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN);
								BigDecimal perdaPesoKg = BigDecimal.ZERO;
								BigDecimal perdaPesoTon = BigDecimal.ZERO;
								
								if (pesoBrutoKg.doubleValue() > 0) {
									perdaPesoKg = (new BigDecimal(qtdPerdida).divide(pesoBrutoKg, BigDecimal.ROUND_HALF_EVEN));
								}

								if (pesoBrutoTon.doubleValue() > 0) {
									perdaPesoTon = (new BigDecimal(qtdPerdida).divide(pesoBrutoTon, BigDecimal.ROUND_HALF_EVEN));
								}

								qtdPerdidaPesoKg = qtdPerdidaPesoKg + perdaPesoKg.doubleValue();
								qtdPerdidaPesoTon = qtdPerdidaPesoTon + perdaPesoTon.doubleValue();
							}
						}

						itemGrafico = new GraficoBIItemRecorrenciaDTO();
						itemGrafico.setQtdPerdidaKg(qtdPerdidaPesoKg);
						itemGrafico.setQtdPerdidaTon(qtdPerdidaPesoTon);
						itemGrafico.setQtdPerdida(qtdPerdida);
						itemGrafico.setSegTempoParadas(segTempoParada);

						if (filtroBI.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA)) {
							itemGrafico.setDthrIni(dwci.getDthrIhora());
							itemGrafico.setDthrFim(dwci.getDthrFhora());
						} else {
							itemGrafico.setDthrIni(dwci.getDtReferencia());
							itemGrafico.setDthrFim(dwci.getDtReferencia());
						}

						// TOTAIS: Valida total geral do perî°¤o.
						// Necessâ³©o por
						// causa do câ­£ulo do î¯¤ice
						isExisteItem = false;
						if (!graficoTotais.getGrafico().isEmpty()) {
							for (GraficoBIItemRecorrenciaDTO itemgraf : graficoTotais.getGrafico()) {
								if (DataHoraRN.compareTo(itemgraf.getDthrIni(), itemGrafico.getDthrIni()) == 0) {
									isExisteItem = true;

									// acumula
									itemgraf.setQtdPerdida(itemgraf.getQtdPerdida() + itemGrafico.getQtdPerdida());
									itemgraf.setSegTempoParadas(0d);
									break;
								}
							}
						}

						if (!isExisteItem) {
							graficoTotais.getGrafico().add(itemGrafico);
						}

						// item especî§©co: acumular para cdItem
						if (dwcr.getDwTRefugo().getCdTrefugo().equals(cdparada)) {
							listaOcorrRef = new ArrayList<DetalheRecorrenciaRefugoDTO>();
							for (DwConsolreoco ocorr : dwcr.getDwConsolreocos()) {
								Long qtdRefugada = 0l;
								qtdRefugada = ocorr.getDwConsolrelog().getPcsAutoProducaorefugada() != null ? ocorr.getDwConsolrelog().getPcsAutoProducaorefugada().longValue() : 0l;

								qtdRefugada += ocorr.getDwConsolrelog().getPcsManuProducaorefugada() != null ? ocorr.getDwConsolrelog().getPcsManuProducaorefugada().longValue() : 0l;

								// perdas por peso
								qtdPerdidaPesoKg = 0d;
								qtdPerdidaPesoTon = 0d;
								for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
									if (dwcpr.getOmProduto().getGPesoBruto() != null && dwcpr.getOmProduto().getGPesoBruto().doubleValue() > 0d) {

										BigDecimal pesoBrutoKg = dwcpr.getOmProduto().getGPesoBruto().divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN);
										BigDecimal pesoBrutoTon = dwcpr.getOmProduto().getGPesoBruto().divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN);

										Double perdaPesoKg = 0d;
										Double perdaPesoTon = 0d;

										if (pesoBrutoKg.doubleValue() > 0) {
											perdaPesoKg = (new BigDecimal(qtdPerdida).divide(pesoBrutoKg, BigDecimal.ROUND_HALF_EVEN)).doubleValue();
										}

										if (pesoBrutoTon.doubleValue() > 0) {
											perdaPesoTon = (new BigDecimal(qtdPerdida).divide(pesoBrutoTon, BigDecimal.ROUND_HALF_EVEN)).doubleValue();
										}

										qtdPerdidaPesoKg = qtdPerdidaPesoKg + perdaPesoKg;
										qtdPerdidaPesoTon = qtdPerdidaPesoTon + perdaPesoTon;
									}
								}

								detRefugo = new DetalheRecorrenciaRefugoDTO();
								detRefugo.setCdPt(dwci.getOmPt().getCdPt());
								detRefugo.setDsPt(dwci.getOmPt().getDsPt());
								detRefugo.setCdFolha(dwci.getDwFolha().getCdFolha());
								detRefugo.setDsFolha(dwci.getDwFolha().getDsFolha());
								detRefugo.setCdProduto(ocorr.getDwConsolrelog().getOmProduto().getCdProduto());
								detRefugo.setDsProduto(ocorr.getDwConsolrelog().getOmProduto().getDsProduto());
								detRefugo.setCdTurno(dwci.getDwTurno().getCdTurno());
								detRefugo.setDsTurno(dwci.getDwTurno().getDsTurno());
								detRefugo.setDtHrRefugo(ocorr.getDwConsolrelog().getDthrRefugo());
								detRefugo.setQtdRefugada(qtdRefugada.doubleValue());
								
								boolean encontrouFerramenta = false;
								for (DwFolharap fr : dwci.getDwFolha().getDwFolharaps()){
									for (DwFolharapcom rc : fr.getDwFolharapcoms()) {
										if (rc.getOmProduto().getCdProduto().equals(detRefugo.getCdProduto())) {
											detRefugo.setCdFerramenta(fr.getDwRap().getCdRap());
											detRefugo.setDsFerramenta(fr.getDwRap().getDsRap());
											
											encontrouFerramenta = true;
											break;
										}
										
										if (encontrouFerramenta) {
											break;
										}
									}
								}
								
								listaOcorrRef.add(detRefugo);
							}

							itemGrafico = new GraficoBIItemRecorrenciaDTO();
							itemGrafico.setQtdPerdida(qtdPerdida);
							itemGrafico.setQtdPerdidaKg(qtdPerdidaPesoKg);
							itemGrafico.setQtdPerdidaTon(qtdPerdidaPesoTon);
							itemGrafico.setSegTempoParadas(segTempoParada);
							itemGrafico.setListaRefugos(new ArrayList<DetalheRecorrenciaRefugoDTO>());

							itemGrafico.getListaRefugos().addAll(listaOcorrRef);

							if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
								itemGrafico.setDthrIni(dwci.getDthrIhora());
								itemGrafico.setDthrFim(dwci.getDthrFhora());
							} else {
								// DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO
								itemGrafico.setDthrIni(dwci.getDtReferencia());
								itemGrafico.setDthrFim(dwci.getDtReferencia());
							}

							isExisteItem = false;
							if (!graficoTotais.getGrafico().isEmpty()) {
								for (GraficoBIItemRecorrenciaDTO itemgraf : grafico.getGrafico()) {

									if (DataHoraRN.compareTo(itemgraf.getDthrIni(), itemGrafico.getDthrIni()) == 0) {
										isExisteItem = true;

										// acumula
										itemgraf.setQtdPerdida(itemgraf.getQtdPerdida() + itemGrafico.getQtdPerdida());
										itemgraf.setSegTempoParadas(itemgraf.getSegTempoParadas() + itemGrafico.getSegTempoParadas());

										// TODO: implementar clone de dwcr
										itemgraf.getListaRefugos().addAll(listaOcorrRef);
										break;
									}
								}
							}

							if (!isExisteItem) {
								grafico.getGrafico().add(itemGrafico);
							}
						}
					}
				}
			}
		}

		// calcular os indices de cada intervalo
		for (GraficoBIItemRecorrenciaDTO itemIntervalo : grafico.getGrafico()) {
			for (GraficoBIItemRecorrenciaDTO itemIntervaloTotal : graficoTotais.getGrafico()) {
				if (DataHoraRN.compareTo(itemIntervalo.getDthrIni(), itemIntervaloTotal.getDthrIni()) == 0) {
					indItem = 0d;
					
					if (itemIntervaloTotal.getQtdPerdida().doubleValue() != 0d){
						indItem = (itemIntervalo.getQtdPerdida().doubleValue() / itemIntervaloTotal.getQtdPerdida().doubleValue()) * 100;						
					}
					
					String strIndItem = ConversaoTipos.converteParaString(indItem, 2).replace(",", ".");
					indItem = Double.parseDouble(strIndItem);
					break;
				}

			}

			if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
				periodo = itemIntervalo.getDthrIni() + " - " + itemIntervalo.getDthrFim();
			} else {
				periodo = DataHoraRN.dateToStringDDMMYYYY(itemIntervalo.getDthrIni());
			}

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


			itemIntervalo.setIndItem(indItem);
			itemIntervalo.setToolTip(toolTip.toString());
		}

		ordenarDetalheBIRecorrenciaPorPeriodo(grafico.getGrafico());
		return grafico;
	}
}
