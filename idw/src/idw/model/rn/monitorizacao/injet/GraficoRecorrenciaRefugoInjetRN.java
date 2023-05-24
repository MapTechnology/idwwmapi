package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalheRecorrenciaRefugoDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIItemRecorrenciaDTO;
import idw.webservices.dto.GraficoBIRecorrenciaDTO;
import ms.util.ConversaoTipos;

public class GraficoRecorrenciaRefugoInjetRN  extends GraficoRecorrenciaInjetFactory {

	public GraficoRecorrenciaRefugoInjetRN() {
		super(new DAOGenericoInjet());
	}

	public GraficoRecorrenciaRefugoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	/*
	 * Metodo principal para retornar o grafico de recorrencia tanto para parada
	 * quanto para refugo
	 */
	public GraficoBIRecorrenciaDTO getGraficoBIParetoRecorrencia(FiltroDetalhePTInjetDTO filtroBI, Byte tipoRecorrencia, String cdItem) {

		IdwLogger log = new IdwLogger("getGraficoBIParetoRecorrencia");
		
		DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(getDao());

		GraficoBIItemRecorrenciaDTO itemGrafico = new GraficoBIItemRecorrenciaDTO();
		GraficoBIRecorrenciaDTO grafico = new GraficoBIRecorrenciaDTO();
		GraficoBIRecorrenciaDTO graficoTotais = new GraficoBIRecorrenciaDTO();
		List<DwConsolid> ids = rn.getDetalheMonitorizacaoPtInjetDTO(filtroBI).getListaDwConsolId();
		DetalheRecorrenciaRefugoDTO detRefugo;

		List<DetalheRecorrenciaRefugoDTO> listaOcorrRef = new ArrayList<>();

		String cdrefugo = "";

		int indice = cdItem.indexOf("-");
		if (indice == -1) {
			cdrefugo = cdItem;
		} else {
			cdrefugo = cdItem.substring(0, indice);
		}

		boolean isExisteItem = false;

		Double qtdPerdida = 0d;
		Double qtdPerdidaPesoKg = 0d;
		Double qtdPerdidaPesoTon = 0d;
		Double segTempoRefugo = 0d;
		Double indItem = 0d;

		StringBuilder toolTip;
		String periodo = "";

		graficoTotais.setGrafico(new ArrayList<GraficoBIItemRecorrenciaDTO>());
		grafico.setGrafico(new ArrayList<GraficoBIItemRecorrenciaDTO>());
		
		if (ids != null && ids.isEmpty() == false) {

			for (DwConsolid dwci : ids) {
				// RECORRENCIA_REFUGO
				for (DwConsol dwc : dwci.getDwConsols()) {
					
					List<DwConsolre> listaRes = getDwconsolRes(dwci, null);
					
					// Interage com todas os refugos
					
					for (DwConsolre dwcr : listaRes) {
						
						segTempoRefugo = 0d;

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
						itemGrafico.setSegTempoParadas(segTempoRefugo);

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
						if (dwcr.getDwTRefugo().getCdTrefugo().equals(cdrefugo)) {
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
							itemGrafico.setSegTempoParadas(segTempoRefugo);
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
	
    @SuppressWarnings("unchecked")
	public List<DwConsolre> getDwconsolRes(DwConsolid dwci, String cdRrefugo) {
		List<DwConsolre> listaRes = new ArrayList<>();

		int _dthrIniHora_id = 0;
		int _dthrFimHora_id = _dthrIniHora_id + 1;
		int _dtTurno_id = 0;
		int _cdTurno_id = _dtTurno_id + 1;
		int _nrOP_id = (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue()) ? _dthrFimHora_id : _cdTurno_id) + 1;
		int _cdMaquina_id = _nrOP_id + 1;
		int _cdMolde_id = _cdMaquina_id + 1;
		int _cdEstrutura_id = _cdMolde_id + 1;
		int _dthrIValEstru_id = _cdEstrutura_id + 1;
		int _dthrIValCic_id = _dthrIValEstru_id + 1;

		
		class IdRegistro {
			Date dthrIniHora;
			Date dthrFimHora;
			Date dtTurno;
			String cdTurno;
			String nrOP;
			String cdMaquina;
			String cdMolde;
			String cdEstrutura;
			Date dthrIValEstru;
			Date dthrIValCic;
		}

		int _dthrRefugo = 0;
		int _cdMaquina = _dthrRefugo + 1;
		int _cdRefugo = _cdMaquina + 1;		
		int _dsRefugo = _cdRefugo + 1;
		int _cdArea = _dsRefugo + 1;
		int _dsArea = _cdArea + 1;
		int _cdAcao = _dsArea + 1;
		int _dsAcao = _cdAcao + 1;
		int _cdCausa = _dsAcao + 1;
		int _dsCausa = _cdCausa + 1;
		int _cdProduto = _dsCausa + 1;
		int _dsProduto = _cdProduto + 1;
		int _qtRefugada = _dsProduto + 1;

		
		class RegistroLido {
			Date dthrRefugo;
			String cdMaquina;
			String cdRefugo;
			String dsRefugo;			
			String cdArea;
			String dsArea;
			String cdAcao;
			String dsAcao;
			String cdCausa;
			String dsCausa;
			String cdProduto;
			String dsProduto;
			BigDecimal qtRefugada = BigDecimal.ZERO;
		}
		
		
		String strSQL = "";
		if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL
					.concat("SELECT DISTINCT a.dthriniintervalo, a.dthrfimintervalo, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic ");
		} else {
			strSQL = strSQL.concat("SELECT DISTINCT a.dtturno, a.cdturno, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic ");
		}

		if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat("  FROM ijCnsUTDetRef a ");
		} else {
			strSQL = strSQL.concat("  FROM ijCnsTurnoDetRef a ");
		}

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

		List<Object> listaIds = new ArrayList<Object>();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setLong("idregistro", dwci.getIdConsolid());
		listaIds = q.list();

		for (Object reg : listaIds) {
			IdRegistro registroId = new IdRegistro();

			Object[] registroL = null;
			Object registroLux = (Object) reg;
			registroL = (Object[]) registroLux;

			Date dthrIni = null;
			Date dthrFim = null;
			
			if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				registroId.dthrIniHora = (Date) registroL[_dthrIniHora_id];
				registroId.dthrFimHora = (Date) registroL[_dthrFimHora_id];
				
				dthrIni = registroId.dthrIniHora;
				dthrFim = registroId.dthrFimHora;
				
			} else {
				registroId.dtTurno = (Date) registroL[_dtTurno_id];
				registroId.cdTurno = (String) registroL[_cdTurno_id];
				
				try {
					dthrIni = FuncoesApoioInjet.calcularInicioTurno(getDao(), registroId.dtTurno, registroId.cdTurno);
					dthrFim = FuncoesApoioInjet.calcularFimTurno(getDao(), registroId.dtTurno, registroId.cdTurno);
				} catch (SemCalendarioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			registroId.cdMaquina = (String) registroL[_cdMaquina_id];
			registroId.cdMolde = (String) registroL[_cdMolde_id];
			registroId.cdEstrutura = (String) registroL[_cdEstrutura_id];
			registroId.dthrIValEstru = (Date) registroL[_dthrIValEstru_id];
			registroId.dthrIValCic = (Date) registroL[_dthrIValCic_id];
			registroId.nrOP = (String) registroL[_nrOP_id];
			
			
			// recupera as ocorrencias
			strSQL = "";
			strSQL = strSQL.concat("SELECT a.dthrirefugo, a.cdinjetora, b.cdrefugo, b.dsrefugo,  ar.cdarea, ar.dsarea, ");
			strSQL = strSQL.concat("       aco.cdacoes, aco.dsacoes, cau.cdcausas, cau.dscausas, ");
			strSQL = strSQL.concat("       p.cdproduto, p.dsproduto, a.qtrefugada ");
			strSQL = strSQL.concat(" FROM ijrearef a  ");
			strSQL = strSQL.concat(" JOIN ijtbref b ON (b.cdrefugo = a.cdrefugo) ");
			strSQL = strSQL.concat(" JOIN ijareres ar oN (ar.cdarea = b.cdarea)");
			strSQL = strSQL.concat(" JOIN ijmolpro c ON (c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrival = a.dthrivalestru AND c.cdidentificacao = a.cdidentificacao) ");
			strSQL = strSQL.concat(" JOIN ijtbpro p ON (p.cdproduto = c.cdproduto) ");
			strSQL = strSQL.concat(" LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
			strSQL = strSQL.concat(" LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");

			strSQL = strSQL.concat("  WHERE a.dthrIrefugo BETWEEN :dthrini AND :dthrfim");
			strSQL = strSQL.concat("    AND a.lcancelado = 0 ");
			strSQL = strSQL.concat("    AND a.cdinjetora = :cdinjetora ");
			strSQL = strSQL.concat("    AND a.cdmolde = :cdmolde ");
			strSQL = strSQL.concat("    AND a.cdestrutura = :cdestrutura ");
			strSQL = strSQL.concat("    AND a.dthrivalestru = :dthrivalestru ");
			strSQL = strSQL.concat("    AND a.dthrivalcic = :dthrivalcic ");
			strSQL = strSQL.concat("    AND a.nrop = :nrop ");
			
			if (cdRrefugo != null && cdRrefugo != "") {
				strSQL = strSQL.concat("    AND b.cdrefugo = '" + cdRrefugo + "'");
			}
			
			strSQL = strSQL.concat(" ORDER BY a.dthrirefugo, a.cdinjetora ");
			
			List<Object> lista = new ArrayList<Object>();
			SQLQuery qr = this.getDaoSession().createSQLQuery(strSQL);

			// definicao de parametros
			qr.setString("cdinjetora", registroId.cdMaquina);
			qr.setString("cdmolde", registroId.cdMolde);
			qr.setString("cdestrutura", registroId.cdEstrutura);
			qr.setTimestamp("dthrivalestru", registroId.dthrIValEstru);
			qr.setTimestamp("dthrivalcic", registroId.dthrIValCic);
			qr.setString("nrop", registroId.nrOP);
			qr.setTimestamp("dthrini", dthrIni);
			qr.setTimestamp("dthrfim", dthrFim);
			
			lista = qr.list();			

			Map<String, DwConsolre> mapRe = new HashMap<String, DwConsolre>();
			
			for (Object regL : lista) {
				RegistroLido registro = new RegistroLido();

				Object[] registroLido = null;
				Object registroLidoAux = (Object) regL;
				registroLido = (Object[]) registroLidoAux;

				
				registro.dthrRefugo = (Date) registroLido[_dthrRefugo];
				registro.cdMaquina  = (String) registroLido[_cdMaquina];
				registro.cdRefugo  = (String) registroLido[_cdRefugo];
				registro.dsRefugo  = (String) registroLido[_dsRefugo];
				registro.cdArea  = (String) registroLido[_cdArea];				
				registro.dsArea  = (String) registroLido[_dsArea];
				
				if (registroLido[_cdAcao] != null ) {
					registro.cdAcao  = (String) registroLido[_cdAcao];				
					registro.dsAcao  = (String) registroLido[_dsAcao];					
				}
				
				if (registroLido[_cdCausa] != null) {
					registro.cdCausa  = (String) registroLido[_cdCausa];				
					registro.dsCausa  = (String) registroLido[_dsCausa];					
				}
				
				registro.cdProduto  = (String) registroLido[_cdProduto];
				registro.dsProduto  = (String) registroLido[_dsProduto];
				registro.qtRefugada = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtRefugada]));
								
				
				OmProduto pro = new OmProduto();
				pro.setCdProduto(registro.cdProduto);
				pro.setDsProduto(registro.dsProduto);
				
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
				
				DwTArea area = new DwTArea();
				area.setCdArea(registro.cdArea);
				area.setIdArea(ConversaoTipos.converteParaInt(area.getCdArea()));
				area.setDsArea(registro.dsArea);
								
				DwTRefugo tref = new DwTRefugo();
				tref.setIdTrefugo(ConversaoTipos.converterParaBigDecimal(registro.cdRefugo).longValue());
				tref.setCdTrefugo(registro.cdRefugo);
				tref.setDsTrefugo(registro.dsRefugo);
				tref.setDwTArea(area);
				
				
				DwConsolrelog relog = new DwConsolrelog();
				relog.setDthrRefugo(registro.dthrRefugo);
				relog.setDwTAcao(acao);
				relog.setDwTCausa(causa);
				relog.setDwTRefugo(tref);
				relog.setOmProduto(pro);
				relog.setOmPt(dwci.getOmPt());
				relog.setPcsAutoProducaorefugada(registro.qtRefugada);
				relog.setDwConsolreocos(new HashSet<DwConsolreoco>());

				DwConsolreoco reoco = new DwConsolreoco();
				reoco.setDwConsolrelog(new DwConsolrelog());
				reoco.setDwConsolrelog(relog);

				
				DwConsolre re = new DwConsolre();
				re.setDwTRefugo(tref);				
				re.setPcsAutoProducaorefugada(registro.qtRefugada);
				re.setDwConsolreocos(new HashSet<DwConsolreoco>());
				re.getDwConsolreocos().add(reoco);
				
				if (mapRe.containsKey(registro.cdRefugo)) {
					// atualiza qtde refugada de cdRefugo
					DwConsolre reUpd = new DwConsolre();
					reUpd = mapRe.get(registro.cdRefugo);
					mapRe.remove(registro.cdRefugo);
					
					reUpd.setPcsAutoProducaorefugada(AritmeticaUtil.somar(reUpd.getPcsAutoProducaorefugada(), registro.qtRefugada));
					reUpd.getDwConsolreocos().add(reoco);
					
					mapRe.put(registro.cdRefugo, reUpd);
					
				} else {
					mapRe.put(registro.cdRefugo, re);
				}
			}
			
			listaRes.addAll(mapRe.values());
		}
		
		return listaRes;    	
    }	
}
