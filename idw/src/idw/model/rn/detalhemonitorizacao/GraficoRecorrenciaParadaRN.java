package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.OmProduto;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.util.FormulasInjet;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DetalheRecorrenciaParadaDTO;
import idw.webservices.dto.DetalheRecorrenciaRefugoDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIItemRecorrenciaDTO;
import idw.webservices.dto.GraficoBIRecorrenciaDTO;
import ms.util.ConversaoTipos;

public class GraficoRecorrenciaParadaRN extends GraficoRecorrenciaFactory{

	public GraficoRecorrenciaParadaRN() {
		super(new DAOGenerico());
	}
	
	public GraficoRecorrenciaParadaRN(DAOGenerico dao) {
		super(dao);
	}
	
	/*
	 * Metodo principal para retornar o grafico de recorrencia tanto para parada quanto para refugo
	 */
	public GraficoBIRecorrenciaDTO 	getGraficoBIParetoRecorrencia(
			FiltroDetalhePTInjetDTO filtroBI, Byte tipoRecorrencia,
			String cdItem) {

		GraficoBIRecorrenciaDTO retorno = new GraficoBIRecorrenciaDTO();

		ConsolidaRN crn = new ConsolidaRN(getDao());
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN(getDao());
		GraficoBIItemRecorrenciaDTO itemGrafico = new GraficoBIItemRecorrenciaDTO();
		GraficoBIRecorrenciaDTO graficoTotais = new GraficoBIRecorrenciaDTO();
		DetalheMonitorizacaoPTInjetDTO indicadores = rn.getDetalheMonitorizacaoPtInjetDTO(filtroBI);
		DetalheRecorrenciaParadaDTO detParada;
		DetalheRecorrenciaRefugoDTO detRefugo;
		
		List<DetalheRecorrenciaParadaDTO> listaOcorrPar = new ArrayList<>();
		List<DetalheRecorrenciaRefugoDTO> listaOcorrRef = new ArrayList<>();
		
		String cdparada = "";

		int indice = cdItem.indexOf("-");
		if (indice == -1) {
			cdparada = cdItem;
		} else {
			cdparada = cdItem.substring(0, indice);
		}

		FolhaRN folhaRN = new FolhaRN(getDao());
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
				if (tipoRecorrencia == RECORRENCIA_PARADA) {
					// recupera ciclo padrao
					try {
						cicloPadrao = folhaRN.getCicloPadrao(dwci.getDwFolha(), dwci.getOmPt());
					} catch (SemCicloPadraoException e) {
						e.printStackTrace();
					}
	
					// cavidades ativas
					try {
						cavAtiva = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha());
					} catch (SemPcsPorCicloAtivasException e) {
						e.printStackTrace();
					}
	
					for (DwConsol dwc : dwci.getDwConsols()) {
						List<DwConsolpa> listaPas = crn.getDwconsolPas(dwc);
						List<DwConsolid> consolids = new ArrayList<>();
						consolids.add(dwci);
						
						for (DwConsolpa dwcp : listaPas) {
							segTempoParada = 0d;
							segTempoParadaCP = 0d;
							segTempoParadaSP = 0d;
							
						    if (dwcp.getSegAutoTempoparadaCp() != null) {
						    	segTempoParadaCP = dwcp.getSegAutoTempoparadaCp() != null ? dwcp.getSegAutoTempoparadaCp().doubleValue() : 0d;
						    	segTempoParadaCP += dwcp.getSegManuTempoparadaCp() != null ? dwcp.getSegManuTempoparadaCp().doubleValue() : 0d;
							} else if (dwcp.getSegAutoTempoparadaSp() != null) {
								segTempoParadaSP = dwcp.getSegAutoTempoparadaSp() != null ? dwcp.getSegAutoTempoparadaSp().doubleValue() : 0d;
								segTempoParadaSP += dwcp.getSegManuTempoparadaSp() != null ? dwcp.getSegManuTempoparadaSp().doubleValue() : 0d;
							}
	
						    segTempoParada = segTempoParadaCP + segTempoParadaSP;
							qtdPerdida = FormulasInjet.calcularPcsPerdaParada(new BigDecimal(segTempoParadaCP), cicloPadrao, cavAtiva).doubleValue();
							qtdPerdidaPesoKg = 0d;
							qtdPerdidaPesoTon = 0d;
	
							// perdas por peso							
							TreeMap<String, OmProduto> mapPro = new TreeMap<String, OmProduto>();  
							for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
								if (dwcpr.getOmProduto().getGPesoBruto() != null && dwcpr.getOmProduto().getGPesoBruto().doubleValue() > 0) {
									Double perdaPesoKg = (new BigDecimal(qtdPerdida)
											.multiply(dwcpr.getOmProduto().getGPesoBruto()))
											.doubleValue() / 1000;
									Double perdaPesoTon = (new BigDecimal(
											qtdPerdida).multiply(dwcpr.getOmProduto()
											.getGPesoBruto())).doubleValue() / 1000000;
	
									qtdPerdidaPesoKg = qtdPerdidaPesoKg
											+ perdaPesoKg;
									qtdPerdidaPesoTon = qtdPerdidaPesoTon
											+ perdaPesoTon;
								}

								mapPro.put(dwcpr.getOmProduto().getCdProduto(), dwcpr.getOmProduto());
							}

							String produtos = ""; // serao adicionados as ocorrencias							
							for(Map.Entry<String, OmProduto> m: mapPro.entrySet()){
								OmProduto p = (OmProduto) m.getValue();
								if (produtos.equals("")) {
									produtos = p.getCdProduto(); 
								} else {
									produtos = produtos.concat("; ").concat(p.getCdProduto());
								}								
							}

							
							itemGrafico = new GraficoBIItemRecorrenciaDTO();
							itemGrafico.setQtdPerdida(qtdPerdida);
							itemGrafico.setQtdPerdidaKg(qtdPerdidaPesoKg);
							itemGrafico.setQtdPerdidaTon(qtdPerdidaPesoTon);
							itemGrafico.setSegTempoParadas(segTempoParada);
							
							//Marcos Sardinha: 2017-07-25 >> Defeito #4209
							if (segTempoParadaSP > 0d) {
								itemGrafico.setIsParadaSemPeso(true);
							}
	
							if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
								itemGrafico.setDthrIni(dwci.getDthrIhora());
								itemGrafico.setDthrFim(dwci.getDthrFhora());
							} else {
								// DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO
								itemGrafico.setDthrIni(dwci.getDtReferencia());
								itemGrafico.setDthrFim(dwci.getDtReferencia());
							}
	
							// TOTAIS: Valida total geral do perî°¤o.
							// Necessâ³©o por
							// causa do câ­£ulo do î¯¤ice
							existeItem = false;
							if (!graficoTotais.getGrafico().isEmpty()) {
								for (GraficoBIItemRecorrenciaDTO itemgraf : graficoTotais
										.getGrafico()) {
									if (DataHoraRN.compareTo(itemgraf.getDthrIni(),itemGrafico.getDthrIni()) == 0) {
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
									if (ocorr.getDthrFparada()!= null) {
										
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
										
										//limitar ocorrencia (ini/fim) ao periodo da barra
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
											
											duracaoParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(detParada.getDtHrIniPar(), detParada.getDtHrFimPar());
											detParada.setDuracao(duracaoParada.doubleValue());
											listaOcorrPar.add(detParada);											
										}
									}
								}
	
								qtdPerdida = FormulasInjet.calcularPcsPerdaParada(
										new BigDecimal(segTempoParadaCP),
										cicloPadrao, cavAtiva).doubleValue();
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
												.doubleValue() / 1000;
										Double perdaPesoTon = (new BigDecimal(
												qtdPerdida).multiply(dwcpr
												.getOmProduto().getGPesoBruto()))
												.doubleValue() / 1000000;
	
										qtdPerdidaPesoKg = qtdPerdidaPesoKg
												+ perdaPesoKg;
										qtdPerdidaPesoTon = qtdPerdidaPesoTon
												+ perdaPesoTon;
									}
								}
	
								itemGrafico = new GraficoBIItemRecorrenciaDTO();
								itemGrafico.setQtdPerdida(qtdPerdida);
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
	
								//Marcos Sardinha: 2017-07-25 >> Defeito #4209
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
				} else {
					// RECORRENCIA_REFUGO
					for (DwConsol dwc : dwci.getDwConsols()) {
						List<DwConsolre> listaRes = rn.getDwconsolRes(dwc);
						for (DwConsolre dwcr : listaRes) {
							segTempoParada = 0d;
	
							qtdPerdida = dwcr.getPcsAutoProducaorefugada() != null ? dwcr
									.getPcsAutoProducaorefugada().longValue() : 0d;
							qtdPerdida += dwcr.getPcsManuProducaorefugada() != null ? dwcr
									.getPcsManuProducaorefugada().longValue() : 0d;
	
							qtdPerdidaPesoKg = 0d;
							qtdPerdidaPesoTon = 0d;
	
							// perdas por peso
							for (DwConsolpr dwcpr : dwc.getDwConsolprs()) 
							{
								
								if (dwcpr.getOmProduto().getGPesoBruto() != null && dwcpr.getOmProduto().getGPesoBruto().compareTo(BigDecimal.ZERO) > 0) {
									BigDecimal pesoBruto = dwcpr.getOmProduto().getGPesoBruto();
									BigDecimal pesoBrutoKg = pesoBruto.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN);
									BigDecimal pesoBrutoTon = pesoBruto.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN);
									BigDecimal perdaPesoKg = BigDecimal.ZERO;
									BigDecimal perdaPesoTon = BigDecimal.ZERO;
									if (pesoBrutoKg.doubleValue() > 0) 
									{
										perdaPesoKg = (new BigDecimal(qtdPerdida).multiply(pesoBrutoKg));
									}
									
									if (pesoBrutoTon.doubleValue() > 0)
									{
										perdaPesoTon = (new BigDecimal(qtdPerdida).multiply(pesoBrutoTon)) ;
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
	
							if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
								itemGrafico.setDthrIni(dwci.getDthrIhora());
								itemGrafico.setDthrFim(dwci.getDthrFhora());
							} else {
								// DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO
								itemGrafico.setDthrIni(dwci.getDtReferencia());
								itemGrafico.setDthrFim(dwci.getDtReferencia());
							}
	
							// TOTAIS: Valida total geral do perî°¤o.
							// Necessâ³©o por
							// causa do câ­£ulo do î¯¤ice
							existeItem = false;
							if (!graficoTotais.getGrafico().isEmpty()) {
								for (GraficoBIItemRecorrenciaDTO itemgraf : graficoTotais
										.getGrafico()) {
									if (DataHoraRN.compareTo(itemgraf.getDthrIni(), 
											itemGrafico.getDthrIni()) == 0) {
										existeItem = true;
	
										// acumula
										itemgraf.setQtdPerdida(itemgraf
												.getQtdPerdida()
												+ itemGrafico.getQtdPerdida());
										itemgraf.setSegTempoParadas(0d);
										break;
									}
								}
							}
	
							if (!existeItem) {
								graficoTotais.getGrafico().add(itemGrafico);
							}
	
							// item especî§©co: acumular para cdItem
							if (dwcr.getDwTRefugo().getCdTrefugo().equals(cdparada)) {
								listaOcorrRef = new ArrayList<DetalheRecorrenciaRefugoDTO>();
								for (DwConsolreoco ocorr : dwcr.getDwConsolreocos()) {
									Long qtdRefugada = 0l;
									qtdRefugada = ocorr.getDwConsolrelog()
											.getPcsAutoProducaorefugada() != null ? ocorr
											.getDwConsolrelog()
											.getPcsAutoProducaorefugada()
											.longValue()
											: 0l;
	
									qtdRefugada += ocorr.getDwConsolrelog()
											.getPcsManuProducaorefugada() != null ? ocorr
											.getDwConsolrelog()
											.getPcsManuProducaorefugada()
											.longValue()
											: 0l;
	
									// perdas por peso
									qtdPerdidaPesoKg = 0d;
									qtdPerdidaPesoTon = 0d;
									for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
										if (dwcpr.getOmProduto().getGPesoBruto() != null
												&& dwcpr.getOmProduto()
														.getGPesoBruto()
														.doubleValue() > 0d) {
											
											BigDecimal pesoBrutoKg = dwcpr.getOmProduto().getGPesoBruto().divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN);
											BigDecimal pesoBrutoTon = dwcpr.getOmProduto().getGPesoBruto().divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN);
											
											
											Double perdaPesoKg = 0d;
											Double perdaPesoTon = 0d;
											
											if (pesoBrutoKg.doubleValue() > 0) 
											{
												perdaPesoKg = (new BigDecimal(qtdPerdida).multiply(pesoBrutoKg)).doubleValue();
											}
											
											if (pesoBrutoTon.doubleValue() > 0) 
											{
												perdaPesoTon = (new BigDecimal(qtdPerdida).multiply(pesoBrutoTon)).doubleValue();
											}
	
											qtdPerdidaPesoKg = qtdPerdidaPesoKg + perdaPesoKg;
											qtdPerdidaPesoTon = qtdPerdidaPesoTon + perdaPesoTon;
										}
									}
	
									detRefugo = new DetalheRecorrenciaRefugoDTO();
									detRefugo.setCdPt(dwci.getOmPt().getCdPt());
									detRefugo.setDsPt(dwci.getOmPt().getDsPt());
									detRefugo.setCdFolha(dwci.getDwFolha()
											.getCdFolha());
									detRefugo.setDsFolha(dwci.getDwFolha()
											.getDsFolha());
									detRefugo.setCdProduto(ocorr.getDwConsolrelog()
											.getOmProduto().getCdProduto());
									detRefugo.setDsProduto(ocorr.getDwConsolrelog()
											.getOmProduto().getDsProduto());
									detRefugo.setCdTurno(dwci.getDwTurno()
											.getCdTurno());
									detRefugo.setDsTurno(dwci.getDwTurno()
											.getDsTurno());
									detRefugo.setDtHrRefugo(ocorr
											.getDwConsolrelog().getDthrRefugo());
									detRefugo.setQtdRefugada(qtdRefugada
											.doubleValue());
									listaOcorrRef.add(detRefugo);
								}
	
								itemGrafico = new GraficoBIItemRecorrenciaDTO();
								itemGrafico.setQtdPerdida(qtdPerdida);
								itemGrafico.setQtdPerdidaKg(qtdPerdidaPesoKg);
								itemGrafico.setQtdPerdidaTon(qtdPerdidaPesoTon);
								itemGrafico.setSegTempoParadas(segTempoParada);
								itemGrafico
										.setListaRefugos(new ArrayList<DetalheRecorrenciaRefugoDTO>());
	
								itemGrafico.getListaRefugos().addAll(listaOcorrRef);
	
								if (filtroBI.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA) {
									itemGrafico.setDthrIni(dwci.getDthrIhora());
									itemGrafico.setDthrFim(dwci.getDthrFhora());
								} else {
									// DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO
									itemGrafico.setDthrIni(dwci.getDtReferencia());
									itemGrafico.setDthrFim(dwci.getDtReferencia());
								}
	
								existeItem = false;
								if (!graficoTotais.getGrafico().isEmpty()) {
									for (GraficoBIItemRecorrenciaDTO itemgraf : retorno
											.getGrafico()) {
	
										if (DataHoraRN.compareTo(itemgraf.getDthrIni(), itemGrafico.getDthrIni()) == 0) {
											existeItem = true;
	
											// acumula
											itemgraf.setQtdPerdida(itemgraf
													.getQtdPerdida()
													+ itemGrafico.getQtdPerdida());
											itemgraf.setSegTempoParadas(itemgraf
													.getSegTempoParadas()
													+ itemGrafico
															.getSegTempoParadas());
	
											// TODO: implementar clone de dwcr
											itemgraf.getListaRefugos().addAll(
													listaOcorrRef);
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
		}

		// calcular os indices de cada intervalo
		for (GraficoBIItemRecorrenciaDTO itemIntervalo : retorno.getGrafico()) {
			for (GraficoBIItemRecorrenciaDTO itemIntervaloTotal : graficoTotais.getGrafico()) {
				if (DataHoraRN.compareTo(itemIntervalo.getDthrIni(), 
						itemIntervaloTotal.getDthrIni()) == 0) {
					
					indItem = 0d;
					
					if (tipoRecorrencia == RECORRENCIA_PARADA) {
						
						if (itemIntervaloTotal.getSegTempoParadas().doubleValue() != 0d) {
							indItem = (itemIntervalo.getSegTempoParadas()
									.doubleValue() / itemIntervaloTotal
									.getSegTempoParadas().doubleValue()) * 100;
						}
					} else {
						if (itemIntervaloTotal.getQtdPerdida().doubleValue() != 0d){
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
				
				//Marcos Sardinha: 2017-07-25 >> Defeito #4209
				if (itemIntervalo.getIsParadaSemPeso() == false) {
					toolTip.append("Pcs perdidas : ");
					toolTip.append(ConversaoTipos.converteParaString(itemIntervalo.getQtdPerdida().doubleValue(), 2));
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
}
