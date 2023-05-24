package idw.model.rn.mapaops;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.MapaCPDTO;
import idw.webservices.dto.MapaCPDTOs;
import idw.webservices.dto.MapaCPDetDTO;
import idw.webservices.dto.TurnoAtualDTO;
import ms.util.ConversaoTipos;

public class MapaOpsRN  extends AbstractRN<DAOGenerico> {

	public MapaOpsRN() {
		super(new DAOGenerico());
	}
	
	public MapaOpsRN(DAOGenerico dao) {
		super(dao);
	}

	/**
	 * Retorna as C
	 * Ps para montagem dos Mapa das CPs
	 * 
	 */
	public MapaCPDTOs getMapaCPs(FiltroDetalhePTInjetDTO filtro) {
		MapaCPDTOs retorno = new MapaCPDTOs();
		retorno.setCPs(new MapaCPDTO());
		retorno.getCPs().setIdListaCPs(MapaCPDTO.getIdListaCpsTodas());
		retorno.getCPs().setListaCPs(new ArrayList<MapaCPDetDTO>());

		retorno.setCPsIniciadas(new MapaCPDTO());
		retorno.getCPsIniciadas().setIdListaCPs(MapaCPDTO.getIdListaCpsIniciadas());
		retorno.getCPsIniciadas().setListaCPs(new ArrayList<MapaCPDetDTO>());

		retorno.setCPsNaoIniciadas(new MapaCPDTO());
		retorno.getCPsNaoIniciadas().setIdListaCPs(MapaCPDTO.getIdListaCpsNaoIniciadas());
		retorno.getCPsNaoIniciadas().setListaCPs(new ArrayList<MapaCPDetDTO>());

		retorno.setCPsIniciadasComProducaoEncerrada(new MapaCPDTO());
		retorno.getCPsIniciadasComProducaoEncerrada().setIdListaCPs(MapaCPDTO.getIdListaCpsProducaoEncerrada());
		retorno.getCPsIniciadasComProducaoEncerrada().setListaCPs(new ArrayList<MapaCPDetDTO>());

		retorno.setCPsIniciadasEmProducao(new MapaCPDTO());
		retorno.getCPsIniciadasEmProducao().setIdListaCPs(MapaCPDTO.getIdListaCpsEmProducao());
		retorno.getCPsIniciadasEmProducao().setListaCPs(new ArrayList<MapaCPDetDTO>());

		retorno.setCPsIniciadasEmProducaoNoPrazo(new MapaCPDTO());
		retorno.getCPsIniciadasEmProducaoNoPrazo().setIdListaCPs(MapaCPDTO.getIdListaCpsEmProducaoNoPrazo());
		retorno.getCPsIniciadasEmProducaoNoPrazo().setListaCPs(new ArrayList<MapaCPDetDTO>());

		retorno.setCPsIniciadasEmProducaoForaDoPrazo(new MapaCPDTO());
		retorno.getCPsIniciadasEmProducaoForaDoPrazo().setIdListaCPs(MapaCPDTO.getIdListaCpsEmProducaoForaDoPrazo());
		retorno.getCPsIniciadasEmProducaoForaDoPrazo().setListaCPs(new ArrayList<MapaCPDetDTO>());

		MapaCPDetDTO cpDet = null;

		Date dthrAtual = DataHoraRN.getDataHoraAtual();
		Date dtHrIni = null;
		Date dtHrFim = null;
		Date dtHrMin = null;
		Date dtHrMax = null;
		List<TurnoAtualDTO> listaTurnos = new ArrayList<TurnoAtualDTO>();
		List<TurnoAtualDTO> listaTurnosCP = new ArrayList<TurnoAtualDTO>();

		Map<String, List<TurnoAtualDTO>> mapTurnosPt = new HashMap<String, List<TurnoAtualDTO>>();
		Map<String, MapaCPDetDTO> mapCPs = new HashMap<String, MapaCPDetDTO>();
		Map<String, MapaCPDetDTO> mapCPsIniciadas = new HashMap<String, MapaCPDetDTO>();
		Map<String, MapaCPDetDTO> mapCPsNaoIniciadas = new HashMap<String, MapaCPDetDTO>();
		Map<String, MapaCPDetDTO> mapCPsIniciadasProducaoEncerrada = new HashMap<String, MapaCPDetDTO>();
		Map<String, MapaCPDetDTO> mapCPsIniciadasEmProducao = new HashMap<String, MapaCPDetDTO>();
		Map<String, MapaCPDetDTO> mapCPsIniciadasEmProducaoNoPrazo = new HashMap<String, MapaCPDetDTO>();
		Map<String, MapaCPDetDTO> mapCPsIniciadasEmProducaoForaDoPrazo = new HashMap<String, MapaCPDetDTO>();

		if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null && filtro.getAnoFinal() != null && filtro.getMesFinal() != null) {
			dtHrIni = DataHoraRN.getDataHora(filtro.getAnoInicial(), filtro.getMesInicial(), 1, 0, 0, 0, 0);
			dtHrFim = DataHoraRN.getDataHoraFimMes(DataHoraRN.getDataHora(filtro.getAnoFinal(), filtro.getMesFinal(), 1, 23, 59, 59, 0));
		} else {
			dtHrIni = DataHoraRN.setHoraNaData(filtro.getDtReferenciaInicial(), 0, 0, 0);
			dtHrFim = DataHoraRN.setHoraNaData(filtro.getDtReferenciaFinal(), 23, 59, 59);
		}

		// recuperar lista de turnos - necessario para pegar os limites reais do
		// período
		TurnoRN turno = new TurnoRN(getDao());
		try {

			List<OmPt> listaPTs = new ArrayList<OmPt>();

			if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() != null) {
				listaPTs.add(filtro.getOmPt());
			} else {
				// recuperar pts do grupo
				PTRN ptRN = new PTRN(getDao());
				try {
					listaPTs.addAll(ptRN.pesquisarPtByGt(filtro.getOmGt()));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			for (OmPt pt : listaPTs) {
				try {
					listaTurnos = turno.getTurnoAtualDTOsPeriodoComClone(pt, dtHrIni, dtHrFim);
					for (TurnoAtualDTO itemTurno : listaTurnos) {
						
						/* Alessandre em 28-11-17 verifiquei que quando um determinado turno é passado no filtro, mesmo assim todos os turnos
						 * eram resgatados. Para resolver isso acrescentei o if abaixo
						 */
						if (filtro.getDwTurno() != null && filtro.getDwTurno().getCdTurno().equals(itemTurno.getCdTurno()) == false) {
							continue;
						}
						
						
						// menor data/hora
						if (dtHrMin == null) {
							dtHrMin = itemTurno.getDtHrITurno();
						} else {
							if (DataHoraRN.compareTo(dtHrMin, itemTurno.getDtHrITurno()) > 0) {
								dtHrMin = itemTurno.getDtHrITurno();
							}
						}

						// maior data/hora
						if (dtHrMax == null) {
							dtHrMax = itemTurno.getDtHrFTurno();
						} else {
							if (DataHoraRN.compareTo(dtHrMax, itemTurno.getDtHrFTurno()) < 0) {
								dtHrMax = itemTurno.getDtHrFTurno();
							}
						}
						
						if (mapTurnosPt.containsKey(pt.getCdPt())) {
		                    listaTurnosCP = mapTurnosPt.get(pt.getCdPt());
		                }
						else {
						    listaTurnosCP = new ArrayList<TurnoAtualDTO>();
						}
                        listaTurnosCP.add(itemTurno);
                        mapTurnosPt.put(pt.getCdPt(), listaTurnosCP);
						
					}
				} catch (SemCalendarioException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT p");
		q.append("  FROM PpCp p");
		q.append("  JOIN FETCH p.ppCpprodutos pp");
		q.append("  JOIN FETCH p.dwFolha f");
		q.append("  LEFT JOIN FETCH f.dwFolhacics c");
		q.append("  LEFT JOIN FETCH f.dwFolharaps r");
		q.append("  LEFT JOIN FETCH r.dwFolharapcoms rc");
		q.append("  LEFT JOIN FETCH r.dwRap rap");
		q.append("  LEFT JOIN FETCH rap.dwRapGrupos rg");
		q.append("  LEFT JOIN FETCH rg.dwGrupoFerramenta rf");
		q.append("  LEFT JOIN FETCH rc.omProduto pr");
		q.append("  LEFT JOIN pr.omProcomestsForIdProdutomp prest");
		q.append("  LEFT JOIN prest.omProdutoByIdProduto prpro");
		
		q.append("  LEFT JOIN FETCH p.omPt ompt");
		q.append("  LEFT JOIN ompt.omObjs omobj");
		q.append("  LEFT JOIN omobj.omGtByIdGt omgt");
		
		q.append(" WHERE ( (p.dthrInicio BETWEEN :dthrini AND :dthrfim) OR (p.dthrFinal BETWEEN :dthrini AND :dthrfim) OR (:dthrini BETWEEN p.dthrInicio AND p.dthrFinal) )");
		q.append("   AND p.dthrInicio IS NOT NULL");
		q.append("   AND p.dthrFinal  IS NOT NULL");

		// filtro de pt
		if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() != null) {
			q.append("AND ompt.cdPt = :cdPt");
		}

		// grupo de pts
		if (filtro.getOmGt() != null) {
			q.append("AND omgt.cdGt = :cdGt");
		}

		// ferramenta
		if (filtro.getDwRap() != null) {
			q.append("AND rap.cdRap = :cdFerr");
		}

		// grupo de ferramentas
		if (filtro.getCdGrupoFerramenta() != null) {
			q.append("AND rf.cdGrupoFerramenta = :cdGrpFerr");
		}

		// produto
		if (filtro.getOmProduto() != null
				&& filtro.getOmProduto().getCdProduto() != null
				&& filtro.getOmProduto().getCdProduto().equals("") == false) {
			q.append("AND pr.cdProduto = :cdproduto");
		}

		// classe abc - máquina
		if (filtro.getTpClasseABCpt() != null) {
	        if (filtro.getTpClasseABCpt() == 2) {
	            q.append(" AND (ompt.tpClasseabc = :tpabcpt OR ompt.tpClasseabc IS NULL)");
	        } else {
	            q.append(" AND ompt.tpClasseabc = :tpabcpt");
	        }		
		}
		
        // classe abc - produto
		if (filtro.getTpClasseABCproduto() != null) {
			q.append(" AND pp.omProduto.tpClasseabc = :tpclasseproduto");
		}
        
		// conjuntos (produto pai)
		if (filtro.getCdProdutoPai() != null) {
			q.append("AND prpro.cdProduto = :cdProdutoPai");
		}

		q.append("ORDER BY p.cdCp");

		// prenchiemento do parametros
		q.defineParametroTimestamp("dthrini", dtHrMin);
		q.defineParametroTimestamp("dthrfim", dtHrMax);

		// filtro de pt
		if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() != null) {
			q.defineParametro("cdPt", filtro.getOmPt().getCdPt());
		}

		// grupo de pts
		if (filtro.getOmGt() != null) {
			q.defineParametro("cdGt", filtro.getOmGt().getCdGt());
		}

		// ferramenta
		if (filtro.getDwRap() != null) {
			q.defineParametro("cdFerr", filtro.getDwRap().getCdRap());
		}

		// grupo de ferramentas
		if (filtro.getCdGrupoFerramenta() != null) {
			q.defineParametro("cdGrpFerr", filtro.getCdGrupoFerramenta());
		}

		// produto
		if (filtro.getOmProduto() != null
				&& filtro.getOmProduto().getCdProduto() != null
				&& filtro.getOmProduto().getCdProduto().equals("") == false) {
			q.defineParametro("cdproduto", filtro.getOmProduto().getCdProduto());
		}

        q.defineParametro("tpabcpt", filtro.getTpClasseABCpt());
        q.defineParametro("tpclasseproduto", filtro.getTpClasseABCproduto());
		
		// conjuntos (produto pai)
		if (filtro.getCdProdutoPai() != null) {
			q.defineParametro("cdProdutoPai", filtro.getCdProdutoPai());
		}

		List<PpCp> lista = q.list();
		for (PpCp reg : lista) {
			
			boolean isCPValido = false;
			cpDet = new MapaCPDetDTO();

			if (filtro.getDwTurno() == null) {
				isCPValido = true;
			} else {
				// varre lista de turnos pra verificar se CP retornada dever ir
				// para lista de CPs

				listaTurnos = mapTurnosPt.get(reg.getOmPt().getCdPt());
			    
			    if (listaTurnos != null){
	                for (TurnoAtualDTO itemTurno : mapTurnosPt.get(reg.getOmPt().getCdPt())) {
	                    if ((itemTurno.getCdTurno().equals(filtro.getDwTurno().getCdTurno()))) {
	                        isCPValido = true;
	                        break;
	                    }
	                }			        
			    }
			}
			
			if (isCPValido) {
				// Marcos Sardinha: 2016-10-25 >> deve-se utilizar NrDoc na exibicao do mapa das OPs (mesmo numero pra todos os itens de uma mesma ppcp)
				String cp = reg.getCdCp();
				String nrDoc = reg.getPpCpprodutos().iterator().next().getNrDoc();  
				
				if (!mapCPs.containsKey(cp)) {
					cpDet = getMapaCPDet(cp, nrDoc);
					mapCPs.put(cp, cpDet);
				} else {
					cpDet = (MapaCPDetDTO) mapCPs.get(cp);
				}

				if (reg.getDthrInicioreal() != null) {
					// cps iniciadas
					mapCPsIniciadas.put(cp, cpDet);
					mapCPsNaoIniciadas.remove(cp);

					if (reg.getDthrFinalreal() != null) {
						// cps finalizadas
						mapCPsIniciadasProducaoEncerrada.put(cp, cpDet);
					} else {
						// cps em producao
						BigDecimal pcsCicloAtivas = BigDecimal.ONE;
						BigDecimal cicloPadrao = null;
						Boolean achouPcsCiclo = false;

						mapCPsIniciadasEmProducao.put(cp, cpDet);
						mapCPsIniciadasProducaoEncerrada.remove(cp);

						// atribui ciclo padrao da folha
						cicloPadrao = reg.getDwFolha().getSegCiclopadrao();

						// verificar se cp será cumprida no prazo
						for (PpCpproduto produto : reg.getPpCpprodutos()) {

							if (reg.getDwFolha().getDwFolhacics() != null && reg.getDwFolha().getDwFolhacics().size() > 0) {
								cicloPadrao = reg.getDwFolha().getDwFolhacics().iterator().next().getSegCiclopadrao();
							}

							if (reg.getDwFolha().getDwFolhaiacs() != null) {
								for (DwFolhaiac folha : reg.getDwFolha().getDwFolhaiacs()) {
									if (folha.getOmProduto().getCdProduto().equals(produto.getOmProduto().getCdProduto())) {
										pcsCicloAtivas = folha.getQtAtiva();
										achouPcsCiclo = true;
										break;
									}
								}
							} else {
								if (reg.getDwFolha().getDwFolharaps() != null) {
									for (DwFolharap dwfolharap : reg.getDwFolha().getDwFolharaps()) {
										for (DwFolharapcom drapc : dwfolharap.getDwFolharapcoms()) {
											if (drapc
													.getOmProduto()
													.getCdProduto()
													.equals(produto
															.getOmProduto()
															.getCdProduto())) {
												pcsCicloAtivas = drapc
														.getQtAtiva();
												achouPcsCiclo = true;
												break;
											}
										}

										if (achouPcsCiclo) {
											break;
										}
									}
								}
							}

							// calcular fim planejado
							BigDecimal saldoProduzir = BigDecimal.ZERO;
							BigDecimal prodBruta = BigDecimal.ZERO;
							BigDecimal prodRefugada = BigDecimal.ZERO;
							BigDecimal prodLiquida = BigDecimal.ZERO;
							BigDecimal prodPlan = BigDecimal.ZERO;

							byte _producao_planejada = 1;
							byte _producao_bruta = 2;
							byte _producao_refugada = 3;

							MapQuery qp = new MapQuery(getDaoSession());
							qp.append("SELECT a.omProduto.cdProduto, ");
							qp.append("       AVG(p.pcsProducaoplanejada) as pcsProducaoplanejada,");
							qp.append("       SUM(a.pcsAutoProducaobruta) as pcsAutoProducaobruta,");
							qp.append("       SUM(a.pcsAutoProducaorefugada) as pcsAutoProducaorefugada");
							qp.append("  FROM DwConsolpr a");
							qp.append("  JOIN a.dwConsol.dwConsolid.ppCp.ppCpprodutos p");
							qp.append("WHERE a.dwConsol.dwConsolid.ppCp.idCp = :idCp");
							qp.append("   AND a.omProduto.cdProduto = :cdProduto");
							qp.append("   AND a.dwConsol.dwConsolid.tpId = 1");
							qp.append("   AND p.omProduto.cdProduto = a.omProduto.cdProduto");
							qp.append(" GROUP BY a.omProduto.cdProduto");

							qp.defineParametro("idCp", produto.getPpCp().getIdCp());
							qp.defineParametro("cdProduto", produto.getOmProduto().getCdProduto());

							Object resumoProduto = qp.uniqueResult();

							if (resumoProduto != null) {
								Object[] regProduto = (Object[]) resumoProduto;

								prodPlan = ConversaoTipos
										.converterParaBigDecimal(regProduto[_producao_planejada] == null ? 0
												: regProduto[_producao_planejada]);
								prodPlan = new BigDecimal(prodPlan.longValue());

								prodBruta = ConversaoTipos
										.converterParaBigDecimal(regProduto[_producao_bruta] == null ? 0
												: regProduto[_producao_bruta]);
								prodRefugada = ConversaoTipos
										.converterParaBigDecimal(regProduto[_producao_refugada] == null ? 0
												: regProduto[_producao_refugada]);
								prodLiquida = prodBruta.subtract(prodRefugada);

								saldoProduzir = prodPlan.subtract(prodLiquida);

								if (saldoProduzir.doubleValue() > 0d && pcsCicloAtivas != null && pcsCicloAtivas.doubleValue() > 0d) {
									// ciclos necessarios para conclusao da producao
									Long ciclosNecessario = saldoProduzir
											.divide(pcsCicloAtivas,
													BigDecimal.ROUND_HALF_EVEN)
											.longValue();

									// tempo necessario para produzir ciclosNecessario
									BigDecimal tempoNecessario = new BigDecimal(
											ciclosNecessario)
											.multiply(cicloPadrao);
									Date dthrFimPrevista = DataHoraRN
											.adicionaSegundosNaData(dthrAtual,
													tempoNecessario.intValue());

									if (DataHoraRN.compareTo(reg.getDthrFinal(), dthrFimPrevista) > 0) {
										// cps em producao no prazo
										if (!mapCPsIniciadasEmProducaoForaDoPrazo
												.containsKey(cp)) {
											mapCPsIniciadasEmProducaoNoPrazo
													.put(cp, cpDet);
										}
									} else {
										// cps em producao fora do prazo
										mapCPsIniciadasEmProducaoForaDoPrazo
												.put(cp, cpDet);
										mapCPsIniciadasEmProducaoNoPrazo
												.remove(cp);
									}
								} else {
									// cps em producao no prazo
									if (!mapCPsIniciadasEmProducaoForaDoPrazo
											.containsKey(cp)) {
										mapCPsIniciadasEmProducaoNoPrazo.put(
												cp, cpDet);
									}
								}
							} else {
								// apesar de dizer que está iniciado, nao tem
								// dados
								/*
								 * mapCPs.remove(cp);
								 * mapCPsIniciadas.remove(cp);
								 * mapCPsNaoIniciadas.remove(cp);
								 * mapCPsIniciadasEmProducaoNoPrazo.remove(cp);
								 * mapCPsIniciadasEmProducaoForaDoPrazo
								 * .remove(cp);
								 */
							}
						}
					}
				} else {
					// cps nao inicidadas
					mapCPsNaoIniciadas.put(cp, cpDet);
				}
			}
		}

		retorno.getCPs().getListaCPs().addAll(mapCPs.values());
		retorno.getCPs().setResumo(getResumoMapaCP(retorno.getCPs().getListaCPs()));

		retorno.getCPsIniciadas().getListaCPs().addAll(mapCPsIniciadas.values());
		retorno.getCPsIniciadas().setResumo(getResumoMapaCP(retorno.getCPsIniciadas().getListaCPs()));

		retorno.getCPsNaoIniciadas().getListaCPs().addAll(mapCPsNaoIniciadas.values());
		retorno.getCPsNaoIniciadas().setResumo(getResumoMapaCP(retorno.getCPsNaoIniciadas().getListaCPs()));

		retorno.getCPsIniciadasComProducaoEncerrada().getListaCPs().addAll(mapCPsIniciadasProducaoEncerrada.values());
		retorno.getCPsIniciadasComProducaoEncerrada().setResumo(
				getResumoMapaCP(retorno.getCPsIniciadasComProducaoEncerrada()
						.getListaCPs()));

		retorno.getCPsIniciadasEmProducao().getListaCPs()
				.addAll(mapCPsIniciadasEmProducao.values());
		retorno.getCPsIniciadasEmProducao().setResumo(
				getResumoMapaCP(retorno.getCPsIniciadasEmProducao()
						.getListaCPs()));

		retorno.getCPsIniciadasEmProducaoNoPrazo().getListaCPs()
				.addAll(mapCPsIniciadasEmProducaoNoPrazo.values());
		retorno.getCPsIniciadasEmProducaoNoPrazo().setResumo(
				getResumoMapaCP(retorno.getCPsIniciadasEmProducaoNoPrazo()
						.getListaCPs()));

		retorno.getCPsIniciadasEmProducaoForaDoPrazo().getListaCPs()
				.addAll(mapCPsIniciadasEmProducaoForaDoPrazo.values());
		retorno.getCPsIniciadasEmProducaoForaDoPrazo().setResumo(
				getResumoMapaCP(retorno.getCPsIniciadasEmProducaoForaDoPrazo()
						.getListaCPs()));

		return retorno;
	}

	private MapaCPDetDTO getResumoMapaCP(List<MapaCPDetDTO> mapa) {
		MapaCPDetDTO retorno = getMapaCPDetDTOInicializado();

		for (MapaCPDetDTO det : mapa) {
			retorno.setSegHrsTot(retorno.getSegHrsTot().add(det.getSegHrsTot()));
			retorno.setSegHrsTrab(retorno.getSegHrsTrab().add(det.getSegHrsTrab()));
			retorno.setSegHrsDisp(retorno.getSegHrsDisp().add(det.getSegHrsDisp()));
			retorno.setSegHrsParCP(retorno.getSegHrsParCP().add(det.getSegHrsParCP()));
			retorno.setSegHrsParSP(retorno.getSegHrsParSP().add(det.getSegHrsParSP()));

			retorno.setQtdPlan(retorno.getQtdPlan().add(det.getQtdPlan()));
			retorno.setQtdPlanKg(retorno.getQtdPlanKg().add(det.getQtdPlanKg()));
			retorno.setQtdPlanTon(retorno.getQtdPlanTon().add(det.getQtdPlanTon()));

			retorno.setQtdPrev(retorno.getQtdPrev().add(det.getQtdPrev()));
			retorno.setQtdPrevKg(retorno.getQtdPrevKg().add(det.getQtdPrevKg()));
			retorno.setQtdPrevTon(retorno.getQtdPrevTon().add(det.getQtdPrevTon()));

			retorno.setQtdProdReg(retorno.getQtdProdReg().add(det.getQtdProdReg()));
			retorno.setQtdProdRegKg(retorno.getQtdProdRegKg().add(det.getQtdProdRegKg()));
			retorno.setQtdProdRegTon(retorno.getQtdProdRegTon().add(det.getQtdProdRegTon()));

			retorno.setQtdProdBruta(retorno.getQtdProdBruta().add(det.getQtdProdBruta()));
			retorno.setQtdProdBrutaKg(retorno.getQtdProdBrutaKg().add(det.getQtdProdBrutaKg()));
			retorno.setQtdProdBrutaTon(retorno.getQtdProdBrutaTon().add(det.getQtdProdBrutaTon()));

			retorno.setQtdProdRef(retorno.getQtdProdRef().add(det.getQtdProdRef()));
			retorno.setQtdProdRefKg(retorno.getQtdProdRefKg().add(det.getQtdProdRefKg()));
			retorno.setQtdProdRefTon(retorno.getQtdProdRefTon().add(det.getQtdProdRefTon()));

			retorno.setQtdProdLiq(retorno.getQtdProdLiq().add(det.getQtdProdLiq()));
			retorno.setQtdProdLiqKg(retorno.getQtdProdLiqKg().add(det.getQtdProdLiqKg()));
			retorno.setQtdProdLiqTon(retorno.getQtdProdLiqTon().add(
					det.getQtdProdLiqTon()));

			retorno.setQtdSaldoProd(retorno.getQtdSaldoProd().add(
					det.getQtdSaldoProd()));
			retorno.setQtdSaldoProdKg(retorno.getQtdSaldoProdKg().add(
					det.getQtdSaldoProdKg()));
			retorno.setQtdSaldoProdTon(retorno.getQtdSaldoProdTon().add(
					det.getQtdSaldoProdTon()));
			
			// em segundos
			retorno.setQtdPlanSeg(retorno.getQtdPlanSeg().add(
                    det.getQtdPlanSeg()));
            retorno.setQtdPrevSeg(retorno.getQtdPrevSeg().add(
                    det.getQtdPrevSeg()));
            retorno.setQtdProdBrutaSeg(retorno.getQtdProdBrutaSeg().add(
                    det.getQtdProdBrutaSeg()));
            retorno.setQtdProdRegSeg(retorno.getQtdProdRegSeg().add(
                    det.getQtdProdRegSeg()));
            retorno.setQtdProdRefSeg(retorno.getQtdProdRefSeg().add(
                    det.getQtdProdRefSeg()));
            retorno.setQtdProdLiqSeg(retorno.getQtdProdLiqSeg().add(
                    det.getQtdProdLiqSeg()));
            retorno.setQtdSaldoProdSeg(retorno.getQtdSaldoProdSeg().add(
                    det.getQtdSaldoProdSeg()));
			
		}

		// calcular indicadores
		retorno.setIndPar(new BigDecimal(FormulasInjet.calcularIndiceParada(
				retorno.getSegHrsParCP(), retorno.getSegHrsDisp())));
		retorno.setIndRef(new BigDecimal(FormulasInjet.calcularIndiceRefugo(
				retorno.getQtdProdRef(), retorno.getQtdProdBruta())));
		retorno.setEfiRea(new BigDecimal(FormulasInjet
				.calcularEficienciaRealizacao(retorno.getQtdProdLiq(),
						retorno.getQtdPrev())));
		retorno.setEfiCic(new BigDecimal(FormulasInjet.calcularEficienciaCiclo(
				retorno.getSegCicloPadrao(), retorno.getSegCicloMedio())));
		retorno.setIndAtend(new BigDecimal(FormulasInjet.calcularIndicePerda(
				retorno.getQtdProdLiq(), retorno.getQtdSaldoProd())));

		return retorno;
	}

	private MapaCPDetDTO getMapaCPDetDTOInicializado() {
		MapaCPDetDTO cpDet = new MapaCPDetDTO();

		cpDet.setSegHrsTot(BigDecimal.ZERO);
		cpDet.setSegHrsTrab(BigDecimal.ZERO);
		cpDet.setSegHrsDisp(BigDecimal.ZERO);
		cpDet.setSegHrsParCP(BigDecimal.ZERO);
		cpDet.setSegHrsParSP(BigDecimal.ZERO);

		cpDet.setQtdPlan(BigDecimal.ZERO);
		cpDet.setQtdPlanKg(BigDecimal.ZERO);
		cpDet.setQtdPlanTon(BigDecimal.ZERO);
		cpDet.setQtdPlanSeg(BigDecimal.ZERO);

		cpDet.setQtdPrev(BigDecimal.ZERO);
		cpDet.setQtdPrevKg(BigDecimal.ZERO);
		cpDet.setQtdPrevTon(BigDecimal.ZERO);
		cpDet.setQtdPrevSeg(BigDecimal.ZERO);
		
		cpDet.setQtdProdReg(BigDecimal.ZERO);
		cpDet.setQtdProdRegKg(BigDecimal.ZERO);
		cpDet.setQtdProdRegTon(BigDecimal.ZERO);
		cpDet.setQtdProdRegSeg(BigDecimal.ZERO);
		
		cpDet.setQtdProdBruta(BigDecimal.ZERO);
		cpDet.setQtdProdBrutaKg(BigDecimal.ZERO);
		cpDet.setQtdProdBrutaTon(BigDecimal.ZERO);
		cpDet.setQtdProdBrutaSeg(BigDecimal.ZERO);

		cpDet.setQtdProdRef(BigDecimal.ZERO);
		cpDet.setQtdProdRefKg(BigDecimal.ZERO);
		cpDet.setQtdProdRefTon(BigDecimal.ZERO);
		cpDet.setQtdProdRefSeg(BigDecimal.ZERO);
		
		cpDet.setQtdProdLiq(BigDecimal.ZERO);
		cpDet.setQtdProdLiqKg(BigDecimal.ZERO);
		cpDet.setQtdProdLiqTon(BigDecimal.ZERO);
		cpDet.setQtdProdLiqSeg(BigDecimal.ZERO);
		
		cpDet.setQtdSaldoProd(BigDecimal.ZERO);
		cpDet.setQtdSaldoProdKg(BigDecimal.ZERO);
		cpDet.setQtdSaldoProdTon(BigDecimal.ZERO);
		cpDet.setQtdSaldoProdSeg(BigDecimal.ZERO);
		
		cpDet.setIndAtend(BigDecimal.ZERO);
		cpDet.setEfiRea(BigDecimal.ZERO);
		cpDet.setEfiCic(BigDecimal.ZERO);
		cpDet.setIndPar(BigDecimal.ZERO);
		cpDet.setIndRef(BigDecimal.ZERO);

		return cpDet;
	}

	private MapaCPDetDTO getMapaCPDet(String cdCp, String nrDoc) {
		MapaCPDetDTO cpDet = getMapaCPDetDTOInicializado();
 		cpDet = getListaMapa(cdCp, nrDoc, false);
		
		return cpDet;
	}
	
	private MapaCPDetDTO getListaMapa(String cdCp, String nrDoc, boolean isRegulagem) {
		MapaCPDetDTO cpDet = new MapaCPDetDTO();
		
		cpDet.setCdCp(cdCp); // para o caso de CPs nao iniciadas
		cpDet.setNrDoc(nrDoc); // para o caso de CPs nao iniciadas

		byte _cdCp = 0;
		byte _nrDoc = 1;
		
		byte _segTempoTrab = 2;
		byte _segTempoParCP = 3;
		byte _segTempoParSP = 4;
		byte _segTempoAtivo = 5;
		
		byte _pcsProdPrev = 6;
		byte _pcsProdBruta = 7;
		byte _pcsProdRef = 8;
		byte _pcsProdPlan = 9;
		
		byte _pcsProdPrevGr = 10;
		byte _pcsProdBrutaGr = 11;
		byte _pcsProdRefGr = 12;
		byte _pcsProdPlanGr = 13;
		
        byte _pcsProdPrevSeg = 14;
        byte _pcsProdBrutaSeg = 15;
        byte _pcsProdRegSeg = 16;        
        byte _pcsProdRefSeg = 17;
        byte _pcsProdPlanSeg = 18;
		
		byte _segCicloPadrao = 19;
		byte _segCicloMedio = 20;
		byte _dtRefMin = 21;
		byte _dtRefMax = 22;

		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("SELECT c.cdCp, p.nrDoc, ");  // 0 e 1

		q.append("       SUM(b.segAutoTempotrabalhado) AS segTempotrabalhado,"); // 2
		q.append("       SUM(b.segAutoTempoparadaCp) AS segTempoparadaCp,"); // 3
		q.append("       SUM(b.segAutoTempoparadaSp) AS segTempoparadaSp,"); // 4
		q.append("       SUM(b.segAutoTempoativo) AS segTempoativo,"); // 5

		q.append("       SUM(b.pcsAutoProducaoprevista) AS pcsProducaoprevista,"); // 6
		q.append("       SUM(b.pcsAutoProducaobruta + CASE WHEN b.pcsManuProducaobruta IS NULL THEN 0 ELSE b.pcsManuProducaobruta END) AS pcsProducaobruta,"); // 7
		q.append("       SUM(b.pcsAutoProducaorefugada + CASE WHEN b.pcsManuProducaorefugada IS NULL THEN 0 ELSE b.pcsManuProducaorefugada  END) AS pcsProducaorefugada,"); // 8
		q.append("       AVG(p.pcsProducaoplanejada) AS  pcsProducaoplanejada,");

        q.append("       SUM(b.pcsAutoProducaoprevista * pr.GPesoBruto) AS pcsProducaoprevistaGr,");
        q.append("       SUM( (b.pcsAutoProducaobruta+ CASE WHEN b.pcsManuProducaorefugada IS NULL THEN 0 ELSE b.pcsManuProducaorefugada  END)  * pr.GPesoBruto) AS pcsProducaobrutaGr,");
        q.append("       SUM( (b.pcsAutoProducaorefugada+ CASE WHEN b.pcsManuProducaorefugada IS NULL THEN 0 ELSE b.pcsManuProducaorefugada  END) * pr.GPesoBruto) AS pcsProducaorefugadaGr,");
        q.append("       AVG(p.pcsProducaoplanejada * pr.GPesoBruto) AS  pcsProducaoplanejadaGr,");
    
        q.append("       SUM(b.segAutoTempoativo) AS pcsProducaoprevistaSeg,");
        q.append("       SUM(b.segAutoCicloprodutivo) AS pcsProducaobrutaSeg,");
        q.append("       SUM(b.segAutoCicloimprodutivo) AS pcsProducaoregSeg,");
        q.append("       SUM(b.segAutoTemporefugadas + CASE WHEN b.segManuTemporefugadas IS NULL THEN 0 ELSE b.segManuTemporefugadas  END) AS pcsProducaorefugadaSeg,");
        q.append("       AVG( (p.pcsProducaoplanejada / b.qtAutoCavativas ) * b.segAutoCiclopadrao  ) AS  pcsProducaoplanejadaSeg,");

        q.append("       SUM(b.segAutoCiclopadrao) AS segCiclopadrao,");
		q.append("       SUM(b.segAutoCiclomedio) AS segAutoCiclomedio, ");

		q.append("       MIN(a.dtReferencia) AS dtRefMin,");
		q.append("       MAX(a.dtReferencia) AS dtRefMax");

		
		q.append("  FROM DwConsolid a");

		q.append("  JOIN a.dwConsols b");
		q.append("  JOIN a.ppCp c");
		q.append("  JOIN c.ppCpprodutos p");
		q.append("  JOIN p.omProduto pr");

		q.append(" WHERE c.cdCp = :cdCp ");
		q.append("   AND a.tpId = 1");
		q.append("   AND a.dwTurno.idTurno <> 1"  );
		
		if (isRegulagem) {
			q.append("   AND a.dwPepro.idPepro = " + DwPeproTemplate.Type.REGULAGEM.getId());
		} else {		
			q.append("   AND a.stAtivo is null");
		}

		q.append(" GROUP BY c.cdCp, p.nrDoc ");

		q.defineParametro("cdCp", cdCp);

		List<Object> lista = q.list();


		for (Object itemLista : lista) {
		    BigDecimal qtdPlanGr = BigDecimal.ZERO;
			BigDecimal qtdPrevGr = BigDecimal.ZERO;
			BigDecimal qtdProdBrutaGr = BigDecimal.ZERO;
			BigDecimal qtdProdRefGr = BigDecimal.ZERO;
			BigDecimal qtdProdLiqGr = BigDecimal.ZERO;
			BigDecimal qtdProdRegGr = BigDecimal.ZERO;
			BigDecimal qtdSaldoProdGr = BigDecimal.ZERO;

			BigDecimal divisorKg = new BigDecimal(1000);
			BigDecimal divisorTon = new BigDecimal(1000000);

			cpDet = new MapaCPDetDTO();

			Object[] registro = (Object[]) itemLista;

			cpDet.setCdCp((String) registro[_cdCp]);
			cpDet.setNrDoc((String) registro[_nrDoc]);

			cpDet.setSegHrsTrab(ConversaoTipos.converterParaBigDecimal((registro[_segTempoTrab] == null ? 0 : registro[_segTempoTrab])));
			cpDet.setSegHrsDisp(ConversaoTipos.converterParaBigDecimal((registro[_segTempoAtivo] == null ? 0 : registro[_segTempoAtivo])));
			cpDet.setSegHrsParCP(ConversaoTipos.converterParaBigDecimal((registro[_segTempoParCP] == null ? 0 : registro[_segTempoParCP])));
			cpDet.setSegHrsParSP(ConversaoTipos.converterParaBigDecimal((registro[_segTempoParSP] == null ? 0 : registro[_segTempoParSP])));
			cpDet.setSegHrsTot(ConversaoTipos.converterParaBigDecimal(cpDet.getSegHrsDisp().add(cpDet.getSegHrsParSP())));

			cpDet.setSegCicloPadrao(ConversaoTipos.converterParaBigDecimal((registro[_segCicloPadrao] == null ? 0 : registro[_segCicloPadrao])));
			cpDet.setSegCicloMedio(ConversaoTipos.converterParaBigDecimal((registro[_segCicloMedio] == null ? 0 : registro[_segCicloMedio])));

			cpDet.setQtdPlan(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdPlan] == null ? 0 : registro[_pcsProdPlan])));
			cpDet.setQtdPrev(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdPrev] == null ? 0 : registro[_pcsProdPrev])));
			cpDet.setQtdProdBruta(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdBruta] == null ? 0 : registro[_pcsProdBruta])));
			cpDet.setQtdProdRef(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdRef] == null ? 0 : registro[_pcsProdRef])));
			cpDet.setQtdProdReg(BigDecimal.ZERO);
			cpDet.setQtdProdLiq(cpDet.getQtdProdBruta().subtract(cpDet.getQtdProdRef()));
			cpDet.setQtdSaldoProd(cpDet.getQtdPlan().subtract(cpDet.getQtdProdLiq()));


            
            // qtdes convertidas para segundos
            cpDet.setQtdPlanSeg(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdPlanSeg] == null ? 0 : registro[_pcsProdPlanSeg])));
            cpDet.setQtdPrevSeg(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdPrevSeg] == null ? 0 : registro[_pcsProdPrevSeg])));
            cpDet.setQtdProdBrutaSeg(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdBrutaSeg] == null ? 0 : registro[_pcsProdBrutaSeg])));
            cpDet.setQtdProdRefSeg(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdRefSeg] == null ? 0 : registro[_pcsProdRefSeg])));
            cpDet.setQtdProdRegSeg(ConversaoTipos.converterParaBigDecimal((registro[_pcsProdRegSeg] == null ? 0 : registro[_pcsProdRegSeg])));            
            cpDet.setQtdProdLiqSeg(cpDet.getQtdProdBrutaSeg().subtract(cpDet.getQtdProdRefSeg()));
            cpDet.setQtdSaldoProdSeg(cpDet.getQtdPlanSeg().subtract(cpDet.getQtdProdLiqSeg()));
			
			
			cpDet.setIndPar(new BigDecimal(FormulasInjet.calcularIndiceParada(cpDet.getSegHrsParCP(), cpDet.getSegHrsDisp())));
			cpDet.setIndRef(new BigDecimal(FormulasInjet.calcularIndiceRefugo(cpDet.getQtdProdRef(), cpDet.getQtdProdBruta())));
			cpDet.setEfiRea(new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(cpDet.getQtdProdLiq(), cpDet.getQtdPrev())));
			cpDet.setEfiCic(new BigDecimal(FormulasInjet.calcularEficienciaCiclo(cpDet.getSegCicloPadrao(), cpDet.getSegCicloMedio())));
			cpDet.setIndAtend(new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(cpDet.getQtdProdLiq(), cpDet.getQtdPlan())));

			qtdPlanGr = ConversaoTipos.converterParaBigDecimal((registro[_pcsProdPlanGr] == null ? 0 : registro[_pcsProdPlanGr]));
			qtdPrevGr = ConversaoTipos.converterParaBigDecimal((registro[_pcsProdPrevGr] == null ? 0 : registro[_pcsProdPrevGr]));
			qtdProdBrutaGr = ConversaoTipos.converterParaBigDecimal((registro[_pcsProdBrutaGr] == null ? 0 : registro[_pcsProdBrutaGr]));
			qtdProdRefGr = ConversaoTipos.converterParaBigDecimal((registro[_pcsProdRefGr] == null ? 0 : registro[_pcsProdRefGr]));
			qtdProdLiqGr = qtdProdBrutaGr.subtract(qtdProdRefGr);
			qtdProdRegGr = BigDecimal.ZERO;
			qtdSaldoProdGr = qtdPlanGr.subtract(qtdProdLiqGr);

			cpDet.setQtdPlanKg(qtdPlanGr.divide(divisorKg, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdPrevKg(qtdPrevGr.divide(divisorKg, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdBrutaKg(qtdProdBrutaGr.divide(divisorKg, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdRefKg(qtdProdRefGr.divide(divisorKg, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdRegKg(qtdProdRegGr.divide(divisorKg, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdLiqKg(qtdProdLiqGr.divide(divisorKg, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdSaldoProdKg(qtdSaldoProdGr.divide(divisorKg, BigDecimal.ROUND_HALF_EVEN));

			cpDet.setQtdPlanTon(qtdPlanGr.divide(divisorTon, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdPrevTon(qtdPrevGr.divide(divisorTon, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdBrutaTon(qtdProdBrutaGr.divide(divisorTon, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdRefTon(qtdProdRefGr.divide(divisorTon, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdRegTon(qtdProdRegGr.divide(divisorTon, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdProdLiqTon(qtdProdLiqGr.divide(divisorTon, BigDecimal.ROUND_HALF_EVEN));
			cpDet.setQtdSaldoProdTon(qtdSaldoProdGr.divide(divisorTon, BigDecimal.ROUND_HALF_EVEN));
			
			
			if (isRegulagem == false) {
				MapaCPDetDTO cpDetReg = getMapaCPDetDTOInicializado();
				cpDetReg = getListaMapa(cdCp, nrDoc, true);
				cpDet.setQtdProdReg(AritmeticaUtil.somar(cpDet.getQtdProdReg(), cpDetReg.getQtdProdBruta()));
				cpDet.setQtdProdRegKg(AritmeticaUtil.somar(cpDet.getQtdProdRegKg(), cpDetReg.getQtdProdBrutaKg()));
				cpDet.setQtdProdRegTon(AritmeticaUtil.somar(cpDet.getQtdProdRegTon(), cpDetReg.getQtdProdBrutaTon()));
				cpDet.setQtdProdRegSeg(AritmeticaUtil.somar(cpDet.getQtdProdRegSeg(), cpDetReg.getQtdProdBrutaSeg()));				
				
			}
					
			
			if (registro[_dtRefMin] != null) {
				cpDet.setDtTurnoMin((Date) registro[_dtRefMin]);
				cpDet.setDtTurnoMax((Date) registro[_dtRefMax]);
			}

		}
		
		return cpDet;
		
	}
	
}
