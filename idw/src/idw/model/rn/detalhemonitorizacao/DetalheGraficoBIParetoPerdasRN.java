package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpr;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.FolhaRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.GraficoBIParetoDetAreaRespDTO;
import idw.webservices.dto.GraficoBIParetoDetAreaRespParDTO;
import idw.webservices.dto.GraficoBIParetoDetAreaRespParProDTO;
import idw.webservices.dto.GraficoBIParetoDetAreaRespParProMaqDTO;
import idw.webservices.dto.GraficoBIParetoDetAreaRespParProMaqParDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemProdutoFerramentaDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetAreaRespDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetParOrdemProdutoDTO;
import idw.webservices.dto.ResumoParetoPerdasDetParadasDTO;

public class DetalheGraficoBIParetoPerdasRN extends AbstractRN<DAOGenerico>{
	
	public DetalheGraficoBIParetoPerdasRN() {
		super(new DAOGenerico());
	}
	
	public DetalheGraficoBIParetoPerdasRN(DAOGenerico dao) {
		super(dao);
	}

	
	
	/*
	 * Método que retorna o detalhamento de perdas por parada - ordena��oo de
	 * produtos, molde e maquinas com maiores perdas
	 */


	public ListaGraficoBIParetoDetParOrdemProdutoDTO getDetalhamentoGraficoPerdasBIParOrdemProduto(DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdParada, String cdMaquina, String cdProduto, Boolean isComPeso, Boolean isSemPeso) {
		
		final Byte ORDEM_UB = 1;
		final Byte ORDEM_PESO = 2;
		final Byte ORDEM_UM = 3;

		final Double TEMPO_LIMITE_MICRO_PARADA_EM_SEGUNDOS = 60d;

		class TotaisDetalhe {
			Boolean isParComPeso;
			Double segTempoPar;
			Double qtdOcorrPar;
			Double segTempoMicroPar;
			Double qtdMicroPar;
			Double indMicroPar;
			Double qtdProd;
			Double qtdPrev;
			Double indPerda;
			Double qtdPerdasPar;
			Double qtdPerdasTon;
			Double qtdPerdasKg;
			Double qtdPerdasUM;
		}

		class Parada {
			Long idTParada;
			String cdParada;
			String dsParada;
			TotaisDetalhe det = new TotaisDetalhe();
		}

		class Maquina {
			String cdMaquina;
			String dsMaquina;

			Map<String, Parada> paradas = new HashMap<String, Parada>();
			TotaisDetalhe det = new TotaisDetalhe();
		}

		class Molde {
			String cdMolde;
			String dsMolde;
			Map<String, Maquina> maquinas = new HashMap<String, Maquina>();
		}

		class Produto {
			String cdProduto;
			String dsProduto;
			Map<String, Molde> moldes = new HashMap<String, Molde>();
		}
		
		// utilizados na identificacao dos agrupamentos
		Maquina idMaq = new Maquina();
		Molde idMol = new Molde();
		Parada idPar = new Parada();
		Produto idPro = new Produto();
		Map<String, Maquina> mapIdMaq = new HashMap<String, Maquina>();
		Map<String, Molde> mapIdMol = new HashMap<String, Molde>();
		Map<String, Parada> mapIdPar = new HashMap<String, Parada>();
		Map<String, Produto> mapIdPro = new HashMap<String, Produto>();

		// totalizadores
		TotaisDetalhe itemDet = new TotaisDetalhe();

		// map utilizado na montagem das classes a serem retornadas
		Produto itemPro = new Produto();
		Parada itemPar = new Parada();
		Molde itemMol = new Molde();
		Maquina itemMaq = new Maquina();
		Map<String, Produto> mapDetPro = new HashMap<String, Produto>();

		ListaGraficoBIParetoDetParOrdemProdutoDTO detalhamento = new ListaGraficoBIParetoDetParOrdemProdutoDTO();
		detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetParadasDTO()); 
		ResumoParetoPerdasDetParadasDTO resumo = new ResumoParetoPerdasDetParadasDTO();
		
		// ciclo padr�o e cav ativas
		BigDecimal segCicloPadrao = BigDecimal.ZERO;
		BigDecimal qtPcsCiclo = BigDecimal.ZERO;
		BigDecimal fatorContagem = BigDecimal.ONE;

		// tempo ativo
		BigDecimal segTempoAtivoAuto = BigDecimal.ZERO;
		BigDecimal segTempoAtivoManual = BigDecimal.ZERO;
		BigDecimal segTempoAtivo = BigDecimal.ZERO;

		// peso bruto e valor unitário
		BigDecimal pesoBruto = BigDecimal.ZERO;
		BigDecimal valorUnitario = BigDecimal.ZERO;

		// qtds
		BigDecimal qtPrevista = BigDecimal.ZERO;
		BigDecimal qtBruta = BigDecimal.ZERO;
		BigDecimal qtRef = BigDecimal.ZERO;
		BigDecimal qtBoa = BigDecimal.ZERO;

		BigDecimal qtPar = BigDecimal.ZERO;
		BigDecimal qtParKg = BigDecimal.ZERO;
		BigDecimal qtParTon = BigDecimal.ZERO;
		BigDecimal qtParUM = BigDecimal.ZERO;
		
		ConsolidaRN crn = new ConsolidaRN(getDao());

        // tempo disponivel eh o mesmo independente de filtro
        resumo.setTempoDisponivel(indicadores.getTempoDisponiveis());
        
                
        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
			// ciclo padr�o
			FolhaRN folhaRN = new FolhaRN(this.getDao());
			segCicloPadrao = BigDecimal.ZERO;

			// sem filtro de máquina ou com filtro e máquina selecionada igual
			// ao filtro
			if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {

				for (DwConsol dwc : dwci.getDwConsols()) {
					segCicloPadrao = dwc.getSegAutoCiclopadrao();

					// tempo ativo
					segTempoAtivoAuto = FormulasInjet.calcularTempoAtivo(
							dwc.getSegAutoCicloprodutivo(),
							dwc.getSegAutoTempoparadaCp(),
							dwc.getSegAutoCicloimprodutivo(),
							dwc.getSegAutoTempoparadaCpVr(),
							dwc.getSegAutoTempoparadaSpVr());

					segTempoAtivoManual = FormulasInjet.calcularTempoAtivo(
							dwc.getSegManuCicloprodutivo(),
							dwc.getSegManuTempoparadaCp(),
							dwc.getSegManuCicloimprodutivo(),
							dwc.getSegManuTempoparadaCpVr(),
							dwc.getSegManuTempoparadaSpVr());

					segTempoAtivo = AritmeticaUtil.somar(segTempoAtivoAuto,
							segTempoAtivoManual);

										
					// lista de paradas
					List<DwConsolpa> dwcpas = crn.getDwconsolPas(dwc);
					
					for (DwConsolpa par : dwcpas) {
						if ((cdParada.equals("")) || (cdParada.compareTo(par.getDwTParada().getCdTparada()) == 0)) {
							
							if (isComPeso != null && isComPeso && par.getDwTParada().getIsPesa() == false) {
							    if (isSemPeso == null || (isSemPeso != null && isSemPeso == false))
							    {
							        continue;
							    }
							}
								
							
							if (isSemPeso != null && isSemPeso && par.getDwTParada().getIsPesa()) {
                                if (isComPeso == null || (isComPeso != null && isComPeso == false))
                                {
                                    continue;
                                }
							}
								
							// lista de produtos vinculados a parada
							for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

								// resumo
								itemDet = new TotaisDetalhe();

								if (par.getDwTParada().getIsPesa()) {
									itemDet.isParComPeso = true;
									itemDet.segTempoPar = AritmeticaUtil
											.somar(par
													.getSegAutoTempoparadaCp() != null ? par
													.getSegAutoTempoparadaCp()
													: BigDecimal.ZERO,
													par.getSegManuTempoparadaCp() != null ? par
															.getSegManuTempoparadaCp()
															: BigDecimal.ZERO)
											.doubleValue();

									itemDet.qtdOcorrPar = AritmeticaUtil
											.somar(par.getQtAutoOcoparadaCp() != null ? par
													.getQtAutoOcoparadaCp()
													: BigDecimal.ZERO,
													par.getQtManuOcoparadaCp() != null ? par
															.getQtAutoOcoparadaCp()
															: BigDecimal.ZERO)
											.doubleValue();
									itemDet.indPerda = 0d;

								} else {
									itemDet.isParComPeso = false;
									itemDet.segTempoPar = AritmeticaUtil
											.somar(par
													.getSegAutoTempoparadaSp() != null ? par
													.getSegAutoTempoparadaSp()
													: BigDecimal.ZERO,
													par.getSegManuTempoparadaSp() != null ? par
															.getSegManuTempoparadaSp()
															: BigDecimal.ZERO)
											.doubleValue();

									itemDet.qtdOcorrPar = AritmeticaUtil
											.somar(par.getQtAutoOcoparadaSp() != null ? par
													.getQtAutoOcoparadaSp()
													: BigDecimal.ZERO,
													par.getQtManuOcoparadaSp() != null ? par
															.getQtAutoOcoparadaSp()
															: BigDecimal.ZERO)
											.doubleValue();

									itemDet.indPerda = 0d;
								}

								if ((itemDet.segTempoPar < TEMPO_LIMITE_MICRO_PARADA_EM_SEGUNDOS)
										&& (itemDet.segTempoPar != 0d)) {
									itemDet.qtdMicroPar = 1d;
									itemDet.segTempoMicroPar = itemDet.segTempoPar;
									itemDet.indMicroPar = 0d;
								} else {
									itemDet.qtdMicroPar = 0d;
									itemDet.segTempoMicroPar = 0d;
									itemDet.indMicroPar = 0d;
								}

								itemDet.qtdProd = 0d;
								itemDet.qtdPrev = 0d;
								itemDet.indPerda = 0d;
								itemDet.qtdPerdasPar = 0d;
								itemDet.qtdPerdasTon = 0d;
								itemDet.qtdPerdasKg = 0d;
								itemDet.qtdPerdasUM = 0d;

								// sem filtro de produto ou com filtro e
								// máquina selecionada igual ao filtro
								
								if ((cdProduto.equals(""))
										|| (cdProduto.equals(dwcpr
												.getOmProduto().getCdProduto()))) {
								    
									// pcs por ciclo
									qtPcsCiclo = BigDecimal.ZERO;
									try {
										qtPcsCiclo = folhaRN
												.getPcsPorCicloAtivas(
														dwci.getDwFolha(),
														dwcpr.getOmProduto());
									} catch (SemPcsPorCicloAtivasException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									try {
										fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwci.getDwFolha(), dwci.getOmPt());
									} catch (SemPacoteOuFatorException e) {
										fatorContagem = BigDecimal.ONE;
									}

									// peso
									if (dwcpr.getOmProduto().getGPesoBruto() != null) {
										pesoBruto = dwcpr.getOmProduto()
												.getGPesoBruto();
									} else {
										pesoBruto = BigDecimal.ZERO;
									}

									// custo
									if (dwcpr.getOmProduto().getVlCustounit() != null) {
										valorUnitario = dwcpr.getOmProduto()
												.getVlCustounit();
									} else {
										valorUnitario = BigDecimal.ZERO;
									}

									if (par.getDwTParada().getIsPesa()) {
										qtPar = FormulasInjet
												.calcularPcsPerdaParada(
														new BigDecimal(
																itemDet.segTempoPar),
														segCicloPadrao,
														qtPcsCiclo);
									} else {
										qtPar = BigDecimal.ZERO;
									}

									qtParUM = qtPar.multiply(valorUnitario);
									qtParKg = qtPar.multiply(new BigDecimal(
											pesoBruto.doubleValue() / 1000));
									qtParTon = qtPar.multiply(new BigDecimal(
											pesoBruto.doubleValue() / 1000000));

									itemDet.qtdPerdasPar = qtPar.doubleValue();
									itemDet.qtdPerdasTon = qtParTon
											.doubleValue();
									itemDet.qtdPerdasKg = qtParKg.doubleValue();
									itemDet.qtdPerdasUM = qtParUM.doubleValue();

									// Maps com identifica��oo
									idMaq.cdMaquina = dwci.getOmPt().getCdPt();
									idMaq.dsMaquina = dwci.getOmPt().getDsPt();
									
									idMol = new Molde();
									idMol.cdMolde = dwci.getDwFolha()
											.getCdFolha();
									idMol.dsMolde = dwci.getDwFolha()
											.getDsFolha();

									idPar = new Parada();
									idPar.idTParada = par.getDwTParada()
											.getIdTparada();
									idPar.cdParada = par.getDwTParada()
											.getCdTparada();
									idPar.dsParada = par.getDwTParada()
											.getDsTparada();

									idPro = new Produto();
									idPro.cdProduto = dwcpr.getOmProduto()
											.getCdProduto();
									idPro.dsProduto = dwcpr.getOmProduto()
											.getDsProduto();

									mapIdMaq.put(idMaq.cdMaquina, idMaq);
									mapIdMol.put(idMol.cdMolde, idMol);
									mapIdPar.put(idPar.cdParada, idPar);
									mapIdPro.put(idPro.cdProduto, idPro);

									itemPar = new Parada();
									itemPar.idTParada = idPar.idTParada;
									itemPar.cdParada = idPar.cdParada;
									itemPar.dsParada = idPar.dsParada;
									itemPar.det = new TotaisDetalhe();
									itemPar.det.isParComPeso = itemDet.isParComPeso;
									itemPar.det.segTempoPar = itemDet.segTempoPar;
									itemPar.det.qtdOcorrPar = itemDet.qtdOcorrPar;
									itemPar.det.segTempoMicroPar = itemDet.segTempoMicroPar;
									itemPar.det.qtdMicroPar = itemDet.qtdMicroPar;
									itemPar.det.indMicroPar = itemDet.indMicroPar;
									itemPar.det.qtdProd = itemDet.qtdProd;
									itemPar.det.qtdPrev = itemDet.qtdPrev;
									itemPar.det.indPerda = itemDet.indPerda;
									itemPar.det.qtdPerdasPar = itemDet.qtdPerdasPar;
									itemPar.det.qtdPerdasTon = itemDet.qtdPerdasTon;
									itemPar.det.qtdPerdasKg = itemDet.qtdPerdasKg;
									itemPar.det.qtdPerdasUM = itemDet.qtdPerdasUM;

									itemMaq = new Maquina();
									itemMaq.cdMaquina = idMaq.cdMaquina;
									itemMaq.dsMaquina = idMaq.dsMaquina;
									itemMaq.paradas.put(itemPar.cdParada,
											itemPar);
									itemMaq.det = new TotaisDetalhe();
									itemMaq.det.isParComPeso = itemDet.isParComPeso;
									itemMaq.det.segTempoPar = itemDet.segTempoPar;
									itemMaq.det.qtdOcorrPar = itemDet.qtdOcorrPar;
									itemMaq.det.segTempoMicroPar = itemDet.segTempoMicroPar;
									itemMaq.det.qtdMicroPar = itemDet.qtdMicroPar;
									itemMaq.det.indMicroPar = itemDet.indMicroPar;
									itemMaq.det.qtdProd = itemDet.qtdProd;
									itemMaq.det.qtdPrev = itemDet.qtdPrev;
									itemMaq.det.indPerda = itemDet.indPerda;
									itemMaq.det.qtdPerdasPar = itemDet.qtdPerdasPar;
									itemMaq.det.qtdPerdasTon = itemDet.qtdPerdasTon;
									itemMaq.det.qtdPerdasKg = itemDet.qtdPerdasKg;
									itemMaq.det.qtdPerdasUM = itemDet.qtdPerdasUM;

									itemMol = new Molde();
									itemMol.cdMolde = idMol.cdMolde;
									itemMol.dsMolde = idMol.dsMolde;
									itemMol.maquinas.put(itemMaq.cdMaquina,
											itemMaq);

									itemPro = new Produto();
									itemPro.cdProduto = idPro.cdProduto;
									itemPro.dsProduto = idPro.dsProduto;
									itemPro.moldes
											.put(itemMol.cdMolde, itemMol);

									if (mapDetPro.containsKey(idPro.cdProduto)) {
										if (mapDetPro.get(idPro.cdProduto).moldes.containsKey(idMol.cdMolde)) {
											
											if (mapDetPro.get(idPro.cdProduto).moldes.get(idMol.cdMolde).maquinas.containsKey(idMaq.cdMaquina)) {

												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.segTempoPar += itemPar.det.segTempoPar;
												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.qtdOcorrPar += itemPar.det.qtdOcorrPar;
												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.segTempoMicroPar += itemPar.det.segTempoMicroPar;
												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.qtdMicroPar += itemPar.det.qtdMicroPar;

												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.qtdPerdasPar += itemPar.det.qtdPerdasPar;
												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.qtdPerdasUM += itemPar.det.qtdPerdasUM;
												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.qtdPerdasKg += itemPar.det.qtdPerdasKg;
												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).det.qtdPerdasTon += itemPar.det.qtdPerdasTon;

												if (mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.get(idMaq.cdMaquina).paradas
														.containsKey(idPar.cdParada)) {
														
													mapDetPro.get(idPro.cdProduto).moldes
															.get(idMol.cdMolde).maquinas
															.get(idMaq.cdMaquina).paradas
															.get(idPar.cdParada).det.segTempoPar += itemPar.det.segTempoPar;
													
													mapDetPro.get(idPro.cdProduto).moldes
															.get(idMol.cdMolde).maquinas
															.get(idMaq.cdMaquina).paradas
															.get(idPar.cdParada).det.qtdOcorrPar += itemPar.det.qtdOcorrPar;
											
													mapDetPro
															.get(idPro.cdProduto).moldes
															.get(idMol.cdMolde).maquinas
															.get(idMaq.cdMaquina).paradas
															.get(idPar.cdParada).det.qtdPerdasPar += itemPar.det.qtdPerdasPar;
													mapDetPro
															.get(idPro.cdProduto).moldes
															.get(idMol.cdMolde).maquinas
															.get(idMaq.cdMaquina).paradas
															.get(idPar.cdParada).det.qtdPerdasUM += itemPar.det.qtdPerdasUM;
													mapDetPro
															.get(idPro.cdProduto).moldes
															.get(idMol.cdMolde).maquinas
															.get(idMaq.cdMaquina).paradas
															.get(idPar.cdParada).det.qtdPerdasKg += itemPar.det.qtdPerdasKg;
													mapDetPro
															.get(idPro.cdProduto).moldes
															.get(idMol.cdMolde).maquinas
															.get(idMaq.cdMaquina).paradas
															.get(idPar.cdParada).det.qtdPerdasTon += itemPar.det.qtdPerdasTon;
												} else {
													mapDetPro
															.get(idPro.cdProduto).moldes
															.get(idMol.cdMolde).maquinas
															.get(idMaq.cdMaquina).paradas
															.put(itemPar.cdParada,
																	itemPar);
												}
											} else {
												mapDetPro.get(idPro.cdProduto).moldes
														.get(idMol.cdMolde).maquinas
														.put(idMaq.cdMaquina,
																itemMaq);
											}
										} else {
											mapDetPro.get(idPro.cdProduto).moldes
													.put(itemMol.cdMolde,
															itemMol);
										}
									} else {
										mapDetPro.put(idPro.cdProduto, itemPro);
									}

								}
							}							
						}
					}

					// lista de produtos vinculados as ferramenta e aos turnos
					// ... só interessa a produ��oo líquida e a produ��oo
					// prevista
					for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
						// sem filtro de produto ou com filtro e máquina
						// selecionada igual ao filtro
						if ((cdProduto.equals(""))
								|| (cdProduto.equals(dwcpr.getOmProduto()
										.getCdProduto()))) {
							// pcs por ciclo
							qtPcsCiclo = BigDecimal.ZERO;
							try {
								qtPcsCiclo = folhaRN
										.getPcsPorCicloAtivas(
												dwci.getDwFolha(),
												dwcpr.getOmProduto());
							} catch (SemPcsPorCicloAtivasException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							// qtd bruta, ref e boa
							qtBruta = AritmeticaUtil
									.somar(dwcpr.getPcsAutoProducaobruta() != null ? dwcpr.getPcsAutoProducaobruta()
											: BigDecimal.ZERO,
											dwcpr.getPcsManuProducaobruta() != null ? dwcpr.getPcsManuProducaobruta()
													: BigDecimal.ZERO);

							qtRef = AritmeticaUtil
									.somar(dwcpr.getPcsAutoProducaorefugada() != null ? dwcpr.getPcsAutoProducaorefugada()
											: BigDecimal.ZERO,
											dwcpr.getPcsManuProducaorefugada() != null ? dwcpr.getPcsManuProducaorefugada()
													: BigDecimal.ZERO);

							qtBoa = AritmeticaUtil.diminuir(qtBruta, qtRef);

							// qtd prevista
							qtPrevista = FormulasInjet.calcularProducaoPrevista(
									segTempoAtivo, 
									segCicloPadrao, 
									qtPcsCiclo,
									fatorContagem,
									dwci.getOmPt().getIndOee()
									);

							// verificar se existe... pode ser que n�o tenho
							// ocorrido parada no período analisado
							itemMaq = new Maquina();
							itemMaq.cdMaquina = dwci.getOmPt().getCdPt();
							itemMaq.dsMaquina = dwci.getOmPt().getDsPt();
							itemMaq.det = new TotaisDetalhe();
							itemMaq.det.qtdProd = 0d;
							itemMaq.det.qtdPrev = 0d;
							itemMaq.det.indPerda = 0d;
							itemMaq.det.qtdPerdasPar = 0d;
							itemMaq.det.qtdPerdasKg = 0d;
							itemMaq.det.qtdPerdasTon = 0d;
							itemMaq.det.qtdPerdasUM = 0d;
							itemMaq.det.segTempoPar = 0d;
							itemMaq.det.qtdOcorrPar = 0d;
							itemMaq.det.segTempoMicroPar = 0d;
							itemMaq.det.qtdMicroPar = 0d;
							itemMaq.det.indMicroPar = 0d;
							itemMaq.det.isParComPeso = false;

							itemMol = new Molde();
							itemMol.cdMolde = dwci.getDwFolha().getCdFolha();
							itemMol.dsMolde = dwci.getDwFolha().getDsFolha();

							itemMol.maquinas.put(itemMaq.cdMaquina, itemMaq);

							itemPro = new Produto();
							itemPro.cdProduto = dwcpr.getOmProduto().getCdProduto();
							itemPro.dsProduto = dwcpr.getOmProduto().getDsProduto();
							itemPro.moldes.put(itemMol.cdMolde, itemMol);

							if (mapDetPro.containsKey(itemPro.cdProduto)) {
								Produto produtoAux = mapDetPro.get(itemPro.cdProduto);
								if (produtoAux.moldes.containsKey(itemMol.cdMolde)) {
									Molde moldeAux = produtoAux.moldes.get(itemMol.cdMolde);
									if (moldeAux.maquinas.containsKey(itemMaq.cdMaquina) == false) {
										// se nao contem a maquina, incluir
										moldeAux.maquinas.put(itemMaq.cdMaquina, itemMaq);
									}
								} else {
									// Se nao contem o molde entao incluir
									produtoAux.moldes.put(itemMol.cdMolde, itemMol);
								}
							} else {
								mapDetPro.put(itemPro.cdProduto, itemPro);
							}

							mapDetPro.get(itemPro.cdProduto).moldes
									.get(itemMol.cdMolde).maquinas
									.get(itemMaq.cdMaquina).det.qtdProd += qtBoa
									.doubleValue();
							mapDetPro.get(itemPro.cdProduto).moldes
									.get(itemMol.cdMolde).maquinas
									.get(itemMaq.cdMaquina).det.qtdPrev += qtPrevista
									.doubleValue();
							mapDetPro.get(itemPro.cdProduto).moldes
									.get(itemMol.cdMolde).maquinas
									.get(itemMaq.cdMaquina).det.indPerda = FormulasInjet
									.calcularEficiencia(
											new BigDecimal(
													mapDetPro
															.get(itemPro.cdProduto).moldes
															.get(itemMol.cdMolde).maquinas
															.get(itemMaq.cdMaquina).det.qtdPerdasPar),
											new BigDecimal(
													mapDetPro
															.get(itemPro.cdProduto).moldes
															.get(itemMol.cdMolde).maquinas
															.get(itemMaq.cdMaquina).det.qtdPrev))
									.doubleValue();
						}
					}
				}
			}
		}

		detalhamento
				.setProdutos(new ArrayList<GraficoBIParetoDetParOrdemProdutoDTO>());

		Set<String> chavesProduto = mapDetPro.keySet();
		for (String keyPro : chavesProduto) {
			GraficoBIParetoDetParOrdemProdutoDTO pro = new GraficoBIParetoDetParOrdemProdutoDTO();
			pro.setCdProduto(mapDetPro.get(keyPro).cdProduto);
			pro.setDsProduto(mapDetPro.get(keyPro).dsProduto);
			pro.setFerramentas(new ArrayList<GraficoBIParetoDetParOrdemProdutoFerramentaDTO>());

			pro.setSegTempoParadas(0d);
			pro.setQtOcorrParadas(0d);

			pro.setQtPerdasKg(0d);
			pro.setQtPerdasTon(0d);
			pro.setQtPerdasUB(0d);
			pro.setQtPerdasUM(0d);

			pro.setQtProd(0d);
			pro.setQtPrev(0d);
			pro.setIndPerda(0d);

			pro.setSegTempoMicroParadas(0d);
			pro.setQtdOcorrMicroParadas(0d);
			pro.setIndMicroParadas(0d);

			Set<String> chavesMolde = mapDetPro.get(keyPro).moldes.keySet();
			for (String keyMol : chavesMolde) {
				GraficoBIParetoDetParOrdemProdutoFerramentaDTO mol = new GraficoBIParetoDetParOrdemProdutoFerramentaDTO();
				mol.setCdFerramenta(mapDetPro.get(keyPro).moldes.get(keyMol).cdMolde);
				mol.setDsFerramenta(mapDetPro.get(keyPro).moldes.get(keyMol).dsMolde);
				mol.setMaquinas(new ArrayList<GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO>());

				mol.setSegTempoParadas(0d);
				mol.setQtOcorrParadas(0d);

				mol.setQtPerdasKg(0d);
				mol.setQtPerdasTon(0d);
				mol.setQtPerdasUB(0d);
				mol.setQtPerdasUM(0d);

				mol.setQtProd(0d);
				mol.setQtPrev(0d);
				mol.setIndPerda(0d);

				mol.setSegTempoMicroParadas(0d);
				mol.setQtdOcorrMicroParadas(0d);
				mol.setIndMicroParadas(0d);

				Set<String> chavesMaq = mapDetPro.get(keyPro).moldes
						.get(keyMol).maquinas.keySet();
				for (String keyMaq : chavesMaq) {
					GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO maq = new GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO();
					maq.setCdMaquina(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).cdMaquina);
					maq.setDsMaquina(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).dsMaquina);
					maq.setParadas(new ArrayList<GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO>());

					maq.setSegTempoParadas(mapDetPro.get(keyPro).moldes
							.get(keyMol).maquinas.get(keyMaq).det.segTempoPar);
					maq.setQtOcorrParadas(mapDetPro.get(keyPro).moldes
							.get(keyMol).maquinas.get(keyMaq).det.qtdOcorrPar);
					maq.setQtPerdasKg(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).det.qtdPerdasKg);
					maq.setQtPerdasTon(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).det.qtdPerdasTon);
					maq.setQtPerdasUB(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).det.qtdPerdasPar);
					maq.setQtPerdasUM(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).det.qtdPerdasUM);

					maq.setQtProd(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).det.qtdProd);
					maq.setQtPrev(mapDetPro.get(keyPro).moldes.get(keyMol).maquinas
							.get(keyMaq).det.qtdPrev);
					maq.setIndPerda(FormulasInjet.calcularEficiencia(
							new BigDecimal(maq.getQtPerdasUB()),
							new BigDecimal(maq.getQtPrev())).doubleValue());

					maq.setSegTempoMicroParadas(mapDetPro.get(keyPro).moldes
							.get(keyMol).maquinas.get(keyMaq).det.segTempoMicroPar);
					maq.setQtdOcorrMicroParadas(mapDetPro.get(keyPro).moldes
							.get(keyMol).maquinas.get(keyMaq).det.qtdMicroPar);
					maq.setIndMicroParadas(FormulasInjet.calcularEficiencia(
							new BigDecimal(maq.getQtdOcorrMicroParadas()),
							new BigDecimal(maq.getQtOcorrParadas()))
							.doubleValue());

					Set<String> chavesPar = mapDetPro.get(keyPro).moldes
							.get(keyMol).maquinas.get(keyMaq).paradas.keySet();
					for (String keyPar : chavesPar) {
						GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO par = new GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO();
						par.setCdParada(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).cdParada);
						par.setDsParada(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).dsParada);
						par.setIdTparada(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).idTParada);

						par.setSegTempoParadas(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.segTempoPar);
						par.setQtOcorrParadas(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.qtdOcorrPar);
						par.setQtPerdasKg(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.qtdPerdasKg);
						par.setQtPerdasTon(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.qtdPerdasTon);
						par.setQtPerdasUB(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.qtdPerdasPar);
						par.setQtPerdasUM(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.qtdPerdasUM);

						par.setSegTempoMicroParadas(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.segTempoMicroPar);
						par.setQtdOcorrMicroParadas(mapDetPro.get(keyPro).moldes
								.get(keyMol).maquinas.get(keyMaq).paradas
								.get(keyPar).det.qtdMicroPar);
						par.setIndMicroParadas(FormulasInjet
								.calcularEficiencia(
										new BigDecimal(par
												.getQtdOcorrMicroParadas()),
										new BigDecimal(par.getQtOcorrParadas()))
								.doubleValue());

						maq.getParadas().add(par);
					}

					if (maq.getQtOcorrParadas() > 0) {
						// totais do molde
						mol.setSegTempoParadas(mol.getSegTempoParadas()
								+ maq.getSegTempoParadas());
						mol.setQtOcorrParadas(mol.getQtOcorrParadas()
								+ maq.getQtOcorrParadas());
						mol.setQtPerdasKg(mol.getQtPerdasKg()
								+ maq.getQtPerdasKg());
						mol.setQtPerdasTon(mol.getQtPerdasTon()
								+ maq.getQtPerdasTon());
						mol.setQtPerdasUB(mol.getQtPerdasUB()
								+ maq.getQtPerdasUB());
						mol.setQtPerdasUM(mol.getQtPerdasUM()
								+ maq.getQtPerdasUM());

						mol.setQtProd(mol.getQtProd() + maq.getQtProd());
						mol.setQtPrev(mol.getQtPrev() + maq.getQtPrev());
						mol.setIndPerda(FormulasInjet.calcularEficiencia(
								new BigDecimal(mol.getQtPerdasUB()),
								new BigDecimal(mol.getQtPrev())).doubleValue());

						mol.setSegTempoMicroParadas(mol
								.getSegTempoMicroParadas()
								+ maq.getSegTempoMicroParadas());
						mol.setQtdOcorrMicroParadas(mol
								.getQtdOcorrMicroParadas()
								+ maq.getQtdOcorrMicroParadas());
						mol.setIndMicroParadas(FormulasInjet
								.calcularEficiencia(
										new BigDecimal(mol
												.getQtdOcorrMicroParadas()),
										new BigDecimal(mol.getQtOcorrParadas()))
								.doubleValue());

						mol.getMaquinas().add(maq);
					}
				}

				if (mol.getQtOcorrParadas() > 0) {
					// totais do produto
					pro.setSegTempoParadas(pro.getSegTempoParadas()
							+ mol.getSegTempoParadas());
					pro.setQtOcorrParadas(pro.getQtOcorrParadas()
							+ mol.getQtOcorrParadas());
					pro.setQtPerdasKg(pro.getQtPerdasKg() + mol.getQtPerdasKg());
					pro.setQtPerdasTon(pro.getQtPerdasTon()
							+ mol.getQtPerdasTon());
					pro.setQtPerdasUB(pro.getQtPerdasUB() + mol.getQtPerdasUB());
					pro.setQtPerdasUM(pro.getQtPerdasUM() + mol.getQtPerdasUM());

					pro.setQtProd(pro.getQtProd() + mol.getQtProd());
					pro.setQtPrev(pro.getQtPrev() + mol.getQtPrev());
					pro.setIndPerda(FormulasInjet.calcularEficiencia(
							new BigDecimal(pro.getQtPerdasUB()),
							new BigDecimal(pro.getQtPrev())).doubleValue());

					pro.setSegTempoMicroParadas(pro.getSegTempoMicroParadas()
							+ mol.getSegTempoMicroParadas());
					pro.setQtdOcorrMicroParadas(pro.getQtdOcorrMicroParadas()
							+ mol.getQtdOcorrMicroParadas());
					pro.setIndMicroParadas(FormulasInjet.calcularEficiencia(
							new BigDecimal(pro.getQtdOcorrMicroParadas()),
							new BigDecimal(pro.getQtOcorrParadas()))
							.doubleValue());

					pro.getFerramentas().add(mol);
				}
			}

			if (pro.getQtOcorrParadas() > 0) {
				detalhamento.getProdutos().add(pro);
				
                // resumo indicadores
                detalhamento.getResumoIndicadores().setPerdaUB(detalhamento.getResumoIndicadores().getPerdaUB() + pro.getQtPerdasUB());
                detalhamento.getResumoIndicadores().setPerdaUM(detalhamento.getResumoIndicadores().getPerdaUM() + pro.getQtPerdasUM());
                detalhamento.getResumoIndicadores().setPerdaKg(detalhamento.getResumoIndicadores().getPerdaKg() + pro.getQtPerdasKg());
                detalhamento.getResumoIndicadores().setPerdaTon(detalhamento.getResumoIndicadores().getPerdaTon() + pro.getQtPerdasTon());
                detalhamento.getResumoIndicadores().setTempoParadas(detalhamento.getResumoIndicadores().getTempoParadas() + pro.getSegTempoParadas());
                detalhamento.getResumoIndicadores().setTempoDisponivel(resumo.getTempoDisponivel());    
                detalhamento.getResumoIndicadores().setIndPar(FormulasInjet.calcularIndiceParada(new BigDecimal(detalhamento.getResumoIndicadores().getTempoParadas()),  new BigDecimal(detalhamento.getResumoIndicadores().getTempoDisponivel())).doubleValue());
				
			}
		}

		// ordenar ferramentas do produto
		for (GraficoBIParetoDetParOrdemProdutoDTO produto : detalhamento
				.getProdutos()) {
			Collections
					.sort(produto.getFerramentas(),
							new Comparator<GraficoBIParetoDetParOrdemProdutoFerramentaDTO>() {
								@Override
								public int compare(
										final GraficoBIParetoDetParOrdemProdutoFerramentaDTO o1,
										final GraficoBIParetoDetParOrdemProdutoFerramentaDTO o2) {
									final GraficoBIParetoDetParOrdemProdutoFerramentaDTO item1 = o1;
									final GraficoBIParetoDetParOrdemProdutoFerramentaDTO item2 = o2;
									return (item1.getQtPerdasUB())
											.compareTo(item2.getQtPerdasUB())
											* -1;
								}
							});

			// ordernar maquinas de cada ferramenta
			for (GraficoBIParetoDetParOrdemProdutoFerramentaDTO ferramenta : produto
					.getFerramentas()) {

				Collections
						.sort(ferramenta.getMaquinas(),
								new Comparator<GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO>() {
									@Override
									public int compare(
											final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO o1,
											final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO o2) {
										final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO item1 = o1;
										final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO item2 = o2;
										return (item1.getQtPerdasUB())
												.compareTo(item2
														.getQtPerdasUB())
												* -1;
									}
								});

				// ordernar paradas de cada máquina
				for (GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaDTO maquina : ferramenta
						.getMaquinas()) {
					Collections
							.sort(maquina.getParadas(),
									new Comparator<GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO>() {
										@Override
										public int compare(
												final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO o1,
												final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO o2) {
											final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO item1 = o1;
											final GraficoBIParetoDetParOrdemProdutoFerramentaMaquinaParadaDTO item2 = o2;
											return (item1.getQtPerdasUB())
													.compareTo(item2
															.getQtPerdasUB())
													* -1;
										}
									});
				}

			}

		}

		// ordenar lista de produtos
		if (ordemQtd.equals(ORDEM_UB)) {
			Collections.sort(detalhamento.getProdutos(),
					new Comparator<GraficoBIParetoDetParOrdemProdutoDTO>() {
						@Override
						public int compare(
								final GraficoBIParetoDetParOrdemProdutoDTO o1,
								final GraficoBIParetoDetParOrdemProdutoDTO o2) {
							final GraficoBIParetoDetParOrdemProdutoDTO item1 = o1;
							final GraficoBIParetoDetParOrdemProdutoDTO item2 = o2;
							return (item1.getQtPerdasUB()).compareTo(item2
									.getQtPerdasUB()) * -1;
						}
					});

		}

		if (ordemQtd.equals(ORDEM_PESO)) {
			Collections.sort(detalhamento.getProdutos(),
					new Comparator<GraficoBIParetoDetParOrdemProdutoDTO>() {
						@Override
						public int compare(
								final GraficoBIParetoDetParOrdemProdutoDTO o1,
								final GraficoBIParetoDetParOrdemProdutoDTO o2) {
							final GraficoBIParetoDetParOrdemProdutoDTO item1 = o1;
							final GraficoBIParetoDetParOrdemProdutoDTO item2 = o2;
							return (item1.getQtPerdasKg()).compareTo(item2
									.getQtPerdasKg()) * -1;
						}
					});

		}

		if (ordemQtd.equals(ORDEM_UM)) {
			Collections.sort(detalhamento.getProdutos(),
					new Comparator<GraficoBIParetoDetParOrdemProdutoDTO>() {
						@Override
						public int compare(
								final GraficoBIParetoDetParOrdemProdutoDTO o1,
								final GraficoBIParetoDetParOrdemProdutoDTO o2) {
							final GraficoBIParetoDetParOrdemProdutoDTO item1 = o1;
							final GraficoBIParetoDetParOrdemProdutoDTO item2 = o2;
							return (item1.getQtPerdasUM()).compareTo(item2
									.getQtPerdasUM()) * -1;
						}
					});
		}

		return detalhamento;
	}

	
    /*
     * Método que retorna o detalhamento de perdas por por area resp - ordenacao de
     * areas, paradas, produtos e maquinas com maiores perdas
     */
	
	public ListaGraficoBIParetoDetAreaRespDTO getDetalhamentoGraficoPerdasBIAreaRespPar(DetalheMonitorizacaoPTInjetDTO indicadores, String cdArea, String cdParada, String cdMaquina, String cdProduto, Boolean isComPeso, Boolean isSemPeso) {
        final Double TEMPO_LIMITE_MICRO_PARADA_EM_SEGUNDOS = 60d;

        class TotaisDetalhe {
            Boolean isParComPeso;
            Double segTempoPar;
            Double qtdOcorrPar;
            Double segTempoMicroPar;
            Double qtdMicroPar;
            Double indMicroPar;
            Double qtdPerdasPar;
            Double qtdPerdasTon;
            Double qtdPerdasKg;
            Double qtdPerdasUM;
        }

        class Parada {
            Long idTParada;
            String cdParada;
            String dsParada;
            TotaisDetalhe det = new TotaisDetalhe();
        }

        class Maquina {
            String cdMaquina;
            String dsMaquina;

            Map<String, Parada> paradas = new HashMap<String, Parada>();
            TotaisDetalhe det = new TotaisDetalhe();
        }

        class Produto {
            String cdProduto;
            String dsProduto;
            Map<String, Maquina> maquinas = new HashMap<String, Maquina>();
        }

        class ParadaArea {
            Long idTParada;
            String cdParada;
            String dsParada;
            Map<String, Produto> produtos = new HashMap<String, Produto>();
        }
        
        class AreaResp {
            String cdArea;
            String dsArea;
            Map<String, ParadaArea> paradaArea = new HashMap<String, ParadaArea>();            
        }
        
        
        // utilizados na identifica��oo dos agrupamentos
        Parada idPar = new Parada();
        Maquina idMaq = new Maquina();
        Produto idPro = new Produto();
        ParadaArea idParArea = new ParadaArea();
        AreaResp idAreaResp = new AreaResp();
        Map<String, Maquina> mapIdMaq = new HashMap<String, Maquina>();
        Map<String, Parada> mapIdPar = new HashMap<String, Parada>();
        Map<String, Produto> mapIdPro = new HashMap<String, Produto>();
        Map<String, ParadaArea> mapIdParArea = new HashMap<String, ParadaArea>();
        Map<String, AreaResp> mapIdArea = new HashMap<String, AreaResp>();

        // totalizadores
        TotaisDetalhe itemDet = new TotaisDetalhe();

        // map utilizado na montagem das classes a serem retornadas
        Parada itemPar = new Parada();
        Maquina itemMaq = new Maquina();
        Produto itemPro = new Produto();
        ParadaArea itemParArea = new ParadaArea();
        AreaResp itemAreaResp = new AreaResp();
        
        Map<String, AreaResp> mapDetArea = new HashMap<String, AreaResp>();

        ListaGraficoBIParetoDetAreaRespDTO detalhamento = new ListaGraficoBIParetoDetAreaRespDTO();

        // ciclo padr�o e cav ativas
        BigDecimal segCicloPadrao = BigDecimal.ZERO;
        BigDecimal qtPcsCiclo = BigDecimal.ZERO;
    
        // peso bruto e valor unitário
        BigDecimal pesoBruto = BigDecimal.ZERO;
        BigDecimal valorUnitario = BigDecimal.ZERO;

        // qtds
        BigDecimal qtPar = BigDecimal.ZERO;
        BigDecimal qtParKg = BigDecimal.ZERO;
        BigDecimal qtParTon = BigDecimal.ZERO;
        BigDecimal qtParUM = BigDecimal.ZERO;
        
        ConsolidaRN crn = new ConsolidaRN(getDao());

        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
            // ciclo padr�o
            FolhaRN folhaRN = new FolhaRN(this.getDao());
            segCicloPadrao = BigDecimal.ZERO;

            // sem filtro de máquina ou com filtro e máquina selecionada igual
            // ao filtro
            if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {

                for (DwConsol dwc : dwci.getDwConsols()) {
                    segCicloPadrao = dwc.getSegAutoCiclopadrao();

                    // lista de paradas
                    List<DwConsolpa> dwcpas = crn.getDwconsolPas(dwc);
                    for (DwConsolpa par : dwcpas) {
                        
                        Boolean isParadaValida = true;
                        
                        if (!cdArea.equals("") || !cdParada.equals(""))
                        {                        
                            if (!cdArea.equals("")) {
                                if (!(cdArea.compareTo(par.getDwTParada().getDwTArea().getCdArea()) == 0)){
                                    isParadaValida = false;
                                }
                            }
                            
                            if (isParadaValida == true){
                                if (!cdParada.equals("")) {
                                    if (!(cdParada.compareTo(par.getDwTParada().getCdTparada()) == 0)) {
                                        isParadaValida = false;    
                                    }                                
                                }
                            }
                        }
                        
                        if (isParadaValida == true) {
                            
                            if (isComPeso != null && isComPeso && par.getDwTParada().getIsPesa() == false) {
                                if (isSemPeso == null || (isSemPeso != null && isSemPeso == false))
                                {
                                    continue;
                                }
                            }
                                
                            
                            if (isSemPeso != null && isSemPeso && par.getDwTParada().getIsPesa()) {
                                if (isComPeso == null || (isComPeso != null && isComPeso == false))
                                {
                                    continue;
                                }
                            }
                                
                            // lista de produtos vinculados a parada
                            for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

                                // resumo
                                itemDet = new TotaisDetalhe();

                                if (par.getDwTParada().getIsPesa()) {
                                    itemDet.isParComPeso = true;
                                    itemDet.segTempoPar = AritmeticaUtil
                                            .somar(par
                                                    .getSegAutoTempoparadaCp() != null ? par
                                                    .getSegAutoTempoparadaCp()
                                                    : BigDecimal.ZERO,
                                                    par.getSegManuTempoparadaCp() != null ? par
                                                            .getSegManuTempoparadaCp()
                                                            : BigDecimal.ZERO)
                                            .doubleValue();

                                    itemDet.qtdOcorrPar = AritmeticaUtil
                                            .somar(par.getQtAutoOcoparadaCp() != null ? par
                                                    .getQtAutoOcoparadaCp()
                                                    : BigDecimal.ZERO,
                                                    par.getQtManuOcoparadaCp() != null ? par
                                                            .getQtAutoOcoparadaCp()
                                                            : BigDecimal.ZERO)
                                            .doubleValue();

                                } else {
                                    itemDet.isParComPeso = false;
                                    itemDet.segTempoPar = AritmeticaUtil
                                            .somar(par
                                                    .getSegAutoTempoparadaSp() != null ? par
                                                    .getSegAutoTempoparadaSp()
                                                    : BigDecimal.ZERO,
                                                    par.getSegManuTempoparadaSp() != null ? par
                                                            .getSegManuTempoparadaSp()
                                                            : BigDecimal.ZERO)
                                            .doubleValue();

                                    itemDet.qtdOcorrPar = AritmeticaUtil
                                            .somar(par.getQtAutoOcoparadaSp() != null ? par
                                                    .getQtAutoOcoparadaSp()
                                                    : BigDecimal.ZERO,
                                                    par.getQtManuOcoparadaSp() != null ? par
                                                            .getQtAutoOcoparadaSp()
                                                            : BigDecimal.ZERO)
                                            .doubleValue();

                                }

                                if ((itemDet.segTempoPar < TEMPO_LIMITE_MICRO_PARADA_EM_SEGUNDOS)
                                        && (itemDet.segTempoPar != 0d)) {
                                    itemDet.qtdMicroPar = 1d;
                                    itemDet.segTempoMicroPar = itemDet.segTempoPar;
                                    itemDet.indMicroPar = 0d;
                                } else {
                                    itemDet.qtdMicroPar = 0d;
                                    itemDet.segTempoMicroPar = 0d;
                                    itemDet.indMicroPar = 0d;
                                }

                                itemDet.qtdPerdasPar = 0d;
                                itemDet.qtdPerdasTon = 0d;
                                itemDet.qtdPerdasKg = 0d;
                                itemDet.qtdPerdasUM = 0d;

                                // sem filtro de produto ou com filtro e
                                // máquina selecionada igual ao filtro
                                if ((cdProduto.equals(""))
                                        || (cdProduto.equals(dwcpr
                                                .getOmProduto().getCdProduto()))) {
                                    // pcs por ciclo
                                    qtPcsCiclo = BigDecimal.ZERO;
                                    try {
                                        qtPcsCiclo = folhaRN
                                                .getPcsPorCicloAtivas(
                                                        dwci.getDwFolha(),
                                                        dwcpr.getOmProduto());
                                    } catch (SemPcsPorCicloAtivasException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }

                                    // peso
                                    if (dwcpr.getOmProduto().getGPesoBruto() != null) {
                                        pesoBruto = dwcpr.getOmProduto()
                                                .getGPesoBruto();
                                    } else {
                                        pesoBruto = BigDecimal.ZERO;
                                    }

                                    // custo
                                    if (dwcpr.getOmProduto().getVlCustounit() != null) {
                                        valorUnitario = dwcpr.getOmProduto()
                                                .getVlCustounit();
                                    } else {
                                        valorUnitario = BigDecimal.ZERO;
                                    }

                                    if (par.getDwTParada().getIsPesa()) {
                                        qtPar = FormulasInjet
                                                .calcularPcsPerdaParada(
                                                        new BigDecimal(
                                                                itemDet.segTempoPar),
                                                        segCicloPadrao,
                                                        qtPcsCiclo);
                                    } else {
                                        qtPar = BigDecimal.ZERO;
                                    }

                                    qtParUM = qtPar.multiply(valorUnitario);
                                    qtParKg = qtPar.multiply(new BigDecimal(
                                            pesoBruto.doubleValue() / 1000));
                                    qtParTon = qtPar.multiply(new BigDecimal(
                                            pesoBruto.doubleValue() / 1000000));

                                    itemDet.qtdPerdasPar = qtPar.doubleValue();
                                    itemDet.qtdPerdasTon = qtParTon
                                            .doubleValue();
                                    itemDet.qtdPerdasKg = qtParKg.doubleValue();
                                    itemDet.qtdPerdasUM = qtParUM.doubleValue();

                                    // Maps com identifica��oo
                                    idPar = new Parada();
                                    idPar.idTParada = par.getDwTParada()
                                            .getIdTparada();
                                    idPar.cdParada = par.getDwTParada()
                                            .getCdTparada();
                                    idPar.dsParada = par.getDwTParada()
                                            .getDsTparada();

                                    
                                    idMaq.cdMaquina = dwci.getOmPt().getCdPt();
                                    idMaq.dsMaquina = dwci.getOmPt().getDsPt();

                                    idPro = new Produto();
                                    idPro.cdProduto = dwcpr.getOmProduto()
                                            .getCdProduto();
                                    idPro.dsProduto = dwcpr.getOmProduto()
                                            .getDsProduto();
                                                                        
                                    idParArea = new ParadaArea();
                                    idParArea.idTParada = par.getDwTParada()
                                            .getIdTparada();
                                    idParArea.cdParada = par.getDwTParada()
                                            .getCdTparada();
                                    idParArea.dsParada = par.getDwTParada()
                                            .getDsTparada();

                                    idAreaResp = new AreaResp();
                                    idAreaResp.cdArea = par.getDwTParada().getDwTArea().getCdArea();
                                    idAreaResp.dsArea = par.getDwTParada().getDwTArea().getDsArea();

                                    mapIdPar.put(idPar.cdParada, idPar);                                    
                                    mapIdMaq.put(idMaq.cdMaquina, idMaq);
                                    mapIdPro.put(idPro.cdProduto, idPro);
                                    mapIdParArea.put(idParArea.cdParada, idParArea);
                                    mapIdArea.put(idAreaResp.cdArea, idAreaResp);

                                    itemPar = new Parada();
                                    itemPar.idTParada = idPar.idTParada;
                                    itemPar.cdParada = idPar.cdParada;
                                    itemPar.dsParada = idPar.dsParada;
                                    itemPar.det = new TotaisDetalhe();
                                    itemPar.det.isParComPeso = itemDet.isParComPeso;
                                    itemPar.det.segTempoPar = itemDet.segTempoPar;
                                    itemPar.det.qtdOcorrPar = itemDet.qtdOcorrPar;
                                    itemPar.det.segTempoMicroPar = itemDet.segTempoMicroPar;
                                    itemPar.det.qtdMicroPar = itemDet.qtdMicroPar;
                                    itemPar.det.indMicroPar = itemDet.indMicroPar;
                                    itemPar.det.qtdPerdasPar = itemDet.qtdPerdasPar;
                                    itemPar.det.qtdPerdasTon = itemDet.qtdPerdasTon;
                                    itemPar.det.qtdPerdasKg = itemDet.qtdPerdasKg;
                                    itemPar.det.qtdPerdasUM = itemDet.qtdPerdasUM;

                                    itemMaq = new Maquina();
                                    itemMaq.cdMaquina = idMaq.cdMaquina;
                                    itemMaq.dsMaquina = idMaq.dsMaquina;
                                    itemMaq.paradas.put(itemPar.cdParada,
                                            itemPar);
                                    itemMaq.det = new TotaisDetalhe();
                                    itemMaq.det.isParComPeso = itemDet.isParComPeso;
                                    itemMaq.det.segTempoPar = itemDet.segTempoPar;
                                    itemMaq.det.qtdOcorrPar = itemDet.qtdOcorrPar;
                                    itemMaq.det.segTempoMicroPar = itemDet.segTempoMicroPar;
                                    itemMaq.det.qtdMicroPar = itemDet.qtdMicroPar;
                                    itemMaq.det.indMicroPar = itemDet.indMicroPar;
                                    itemMaq.det.qtdPerdasPar = itemDet.qtdPerdasPar;
                                    itemMaq.det.qtdPerdasTon = itemDet.qtdPerdasTon;
                                    itemMaq.det.qtdPerdasKg = itemDet.qtdPerdasKg;
                                    itemMaq.det.qtdPerdasUM = itemDet.qtdPerdasUM;


                                    itemPro = new Produto();
                                    itemPro.cdProduto = idPro.cdProduto;
                                    itemPro.dsProduto = idPro.dsProduto;
                                    itemPro.maquinas
                                            .put(itemMaq.cdMaquina, itemMaq);

                                    
                                    itemParArea = new ParadaArea();
                                    itemParArea.cdParada = idParArea.cdParada;
                                    itemParArea.dsParada = idParArea.cdParada;
                                    itemParArea.idTParada = idParArea.idTParada;
                                    itemParArea.produtos.put(itemPro.cdProduto, itemPro);
                                    
                                    itemAreaResp = new AreaResp();
                                    itemAreaResp.cdArea = idAreaResp.cdArea;
                                    itemAreaResp.dsArea = idAreaResp.dsArea;
                                    itemAreaResp.paradaArea.put(itemParArea.cdParada, itemParArea);
                                    
                                    
                                    
                                    if (mapDetArea.containsKey(idAreaResp.cdArea)) {
                                        if (mapDetArea.get(idAreaResp.cdArea).paradaArea.containsKey(idParArea.cdParada)) {                                            
                                            if (mapDetArea.get(idAreaResp.cdArea).paradaArea.get(idParArea.cdParada).produtos.containsKey(idPro.cdProduto)) {
                                                if (mapDetArea.get(idAreaResp.cdArea).paradaArea.get(idParArea.cdParada).produtos.get(idPro.cdProduto).maquinas.containsKey(idMaq.cdMaquina)) {
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                            .get(idParArea.cdParada).produtos
                                                            .get(idPro.cdProduto).maquinas
                                                            .get(idMaq.cdMaquina)
                                                            .det.segTempoPar += itemPar.det.segTempoPar;
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                            .get(idParArea.cdParada).produtos
                                                            .get(idPro.cdProduto).maquinas
                                                            .get(idMaq.cdMaquina)
                                                            .det.qtdOcorrPar += itemPar.det.qtdOcorrPar;
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                            .get(idParArea.cdParada).produtos
                                                            .get(idPro.cdProduto).maquinas
                                                            .get(idMaq.cdMaquina)
                                                            .det.segTempoMicroPar += itemPar.det.segTempoMicroPar;
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                            .get(idParArea.cdParada).produtos
                                                            .get(idPro.cdProduto).maquinas
                                                            .get(idMaq.cdMaquina)
                                                            .det.qtdMicroPar += itemPar.det.qtdMicroPar;
        
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                            .get(idParArea.cdParada).produtos
                                                            .get(idPro.cdProduto).maquinas
                                                            .get(idMaq.cdMaquina)
                                                            .det.qtdPerdasPar += itemPar.det.qtdPerdasPar;
                                                        mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                        .get(idParArea.cdParada).produtos
                                                        .get(idPro.cdProduto).maquinas
                                                        .get(idMaq.cdMaquina)
                                                        .det.qtdPerdasUM += itemPar.det.qtdPerdasUM;
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                        .get(idParArea.cdParada).produtos
                                                        .get(idPro.cdProduto).maquinas
                                                        .get(idMaq.cdMaquina)
                                                        .det.qtdPerdasKg += itemPar.det.qtdPerdasKg;
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                        .get(idParArea.cdParada).produtos
                                                        .get(idPro.cdProduto).maquinas
                                                        .get(idMaq.cdMaquina)
                                                        .det.qtdPerdasTon += itemPar.det.qtdPerdasTon;
        
                                                    if (mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                            .get(idParArea.cdParada).produtos
                                                            .get(idPro.cdProduto).maquinas
                                                            .get(idMaq.cdMaquina).paradas
                                                            .containsKey(idPar.cdParada)) {
                                                            
                                                        mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                                .get(idParArea.cdParada).produtos
                                                                .get(idPro.cdProduto).maquinas
                                                                .get(idMaq.cdMaquina).paradas
                                                                .get(idPar.cdParada).det.segTempoPar += itemPar.det.segTempoPar;
                                                        
                                                        mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                                .get(idParArea.cdParada).produtos
                                                                .get(idPro.cdProduto).maquinas
                                                                .get(idMaq.cdMaquina).paradas
                                                                .get(idPar.cdParada).det.qtdOcorrPar += itemPar.det.qtdOcorrPar;
                                                
                                                        mapDetArea
                                                                .get(idAreaResp.cdArea).paradaArea
                                                                .get(idParArea.cdParada).produtos
                                                                .get(idPro.cdProduto).maquinas
                                                                .get(idMaq.cdMaquina).paradas
                                                                .get(idPar.cdParada).det.qtdPerdasPar += itemPar.det.qtdPerdasPar;
                                                        mapDetArea
                                                                .get(idAreaResp.cdArea).paradaArea
                                                                .get(idParArea.cdParada).produtos
                                                                .get(idPro.cdProduto).maquinas
                                                                .get(idMaq.cdMaquina).paradas
                                                                .get(idPar.cdParada).det.qtdPerdasUM += itemPar.det.qtdPerdasUM;
                                                        mapDetArea
                                                                .get(idAreaResp.cdArea).paradaArea
                                                                .get(idParArea.cdParada).produtos
                                                                .get(idPro.cdProduto).maquinas
                                                                .get(idMaq.cdMaquina).paradas
                                                                .get(idPar.cdParada).det.qtdPerdasKg += itemPar.det.qtdPerdasKg;
                                                        mapDetArea
                                                                .get(idAreaResp.cdArea).paradaArea
                                                                .get(idParArea.cdParada).produtos
                                                                .get(idPro.cdProduto).maquinas
                                                                .get(idMaq.cdMaquina).paradas
                                                                .get(idPar.cdParada).det.qtdPerdasTon += itemPar.det.qtdPerdasTon;
                                                    } else {
                                                        mapDetArea
                                                                .get(idAreaResp.cdArea).paradaArea
                                                                .get(idParArea.cdParada).produtos
                                                                .get(idPro.cdProduto).maquinas
                                                                .get(idMaq.cdMaquina).paradas
                                                                .put(itemPar.cdParada,
                                                                        itemPar);
                                                    }
                                                    
                                                    
                                                } else {
                                                    mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                    .get(idParArea.cdParada).produtos
                                                    .get(idPro.cdProduto).maquinas
                                                    .put(idMaq.cdMaquina,
                                                            itemMaq);                                                    
                                                }
                                                
                                            } else {
                                                mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                        .get(idParArea.cdParada).produtos
                                                        .put(idPro.cdProduto,
                                                                itemPro);
                                            }
                                        } else {
                                            mapDetArea.get(idAreaResp.cdArea).paradaArea
                                                    .put(idParArea.cdParada,
                                                            itemParArea);
                                        }
                                    } else {
                                        mapDetArea.put(idAreaResp.cdArea, itemAreaResp);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        detalhamento
                .setAreasResp(new ArrayList<GraficoBIParetoDetAreaRespDTO>());

        Set<String> chavesArea = mapDetArea.keySet();
        for (String keyArea : chavesArea) {
            GraficoBIParetoDetAreaRespDTO areaResp = new GraficoBIParetoDetAreaRespDTO();
            
            areaResp.setCdArea(mapDetArea.get(keyArea).cdArea);
            areaResp.setDsArea(mapDetArea.get(keyArea).dsArea);
            areaResp.setParadas(new ArrayList<GraficoBIParetoDetAreaRespParDTO>());

            areaResp.setSegTempoParadas(0d);
            areaResp.setQtOcorrParadas(0d);

            areaResp.setQtPerdasKg(0d);
            areaResp.setQtPerdasTon(0d);
            areaResp.setQtPerdasUB(0d);
            areaResp.setQtPerdasUM(0d);

            areaResp.setSegTempoMicroParadas(0d);
            areaResp.setQtdOcorrMicroParadas(0d);
            areaResp.setIndMicroParadas(0d);

            Set<String> chavesParArea = mapDetArea.get(keyArea).paradaArea.keySet();
            for (String keyParArea : chavesParArea) {
                GraficoBIParetoDetAreaRespParDTO parArea = new GraficoBIParetoDetAreaRespParDTO();
                parArea.setIdTParada(mapDetArea.get(keyArea).paradaArea.get(keyParArea).idTParada);
                parArea.setCdParada(mapDetArea.get(keyArea).paradaArea.get(keyParArea).cdParada);
                parArea.setDsParada(mapDetArea.get(keyArea).paradaArea.get(keyParArea).dsParada);
                parArea.setProdutos(new ArrayList<GraficoBIParetoDetAreaRespParProDTO>());

                parArea.setSegTempoParadas(0d);
                parArea.setQtOcorrParadas(0d);

                parArea.setQtPerdasKg(0d);
                parArea.setQtPerdasTon(0d);
                parArea.setQtPerdasUB(0d);
                parArea.setQtPerdasUM(0d);

                parArea.setSegTempoMicroParadas(0d);
                parArea.setQtdOcorrMicroParadas(0d);
                parArea.setIndMicroParadas(0d);

                Set<String> chavesProduto = mapDetArea.get(keyArea).paradaArea.get(keyParArea).produtos.keySet();
                for (String keyPro : chavesProduto) {
                    GraficoBIParetoDetAreaRespParProDTO pro = new GraficoBIParetoDetAreaRespParProDTO();
                    pro.setCdProduto(mapDetArea.get(keyArea).paradaArea.get(keyParArea).produtos
                            .get(keyPro).cdProduto);
                    pro.setDsProduto(mapDetArea.get(keyArea).paradaArea.get(keyParArea).produtos
                            .get(keyPro).dsProduto);
                    pro.setMaquinas(new ArrayList<GraficoBIParetoDetAreaRespParProMaqDTO>());

                    pro.setSegTempoParadas(0d);
                    pro.setQtOcorrParadas(0d);

                    pro.setQtPerdasKg(0d);
                    pro.setQtPerdasTon(0d);
                    pro.setQtPerdasUB(0d);
                    pro.setQtPerdasUM(0d);

                    pro.setSegTempoMicroParadas(0d);
                    pro.setQtdOcorrMicroParadas(0d);
                    pro.setIndMicroParadas(0d);

                                        
                    Set<String> chavesMaq = mapDetArea.get(keyArea).paradaArea.get(keyParArea).produtos.get(keyPro).maquinas.keySet();
                    for (String keyMaq : chavesMaq) {    
                        GraficoBIParetoDetAreaRespParProMaqDTO maq = new GraficoBIParetoDetAreaRespParProMaqDTO();
                        
                        maq.setCdMaquina(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).cdMaquina);
                        maq.setDsMaquina(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).dsMaquina);
                        maq.setParadas(new ArrayList<GraficoBIParetoDetAreaRespParProMaqParDTO>());
    
                        maq.setSegTempoParadas(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.segTempoPar);
                        
                        maq.setQtOcorrParadas(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.qtdOcorrPar);
                        
                        maq.setQtPerdasKg(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.qtdPerdasKg);
                        
                        maq.setQtPerdasTon(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.qtdPerdasTon);
                        
                        maq.setQtPerdasUB(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.qtdPerdasPar);
                        
                        maq.setQtPerdasUM(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.qtdPerdasUM);
    
                        maq.setSegTempoMicroParadas(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.segTempoMicroPar);
                        maq.setQtdOcorrMicroParadas(mapDetArea
                                .get(keyArea).paradaArea
                                .get(keyParArea).produtos
                                .get(keyPro).maquinas
                                .get(keyMaq).det.qtdMicroPar);                        
                        maq.setIndMicroParadas(FormulasInjet.calcularEficiencia(
                                new BigDecimal(maq.getQtdOcorrMicroParadas()),
                                new BigDecimal(maq.getQtOcorrParadas()))
                                .doubleValue());
    
                        Set<String> chavesPar = mapDetArea.get(keyArea).paradaArea
                                .get(keyParArea).produtos.get(keyPro).maquinas.get(keyMaq).paradas.keySet();
                        for (String keyPar : chavesPar) {
                            GraficoBIParetoDetAreaRespParProMaqParDTO par = new GraficoBIParetoDetAreaRespParProMaqParDTO();
                            par.setCdParada(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).cdParada);
                            par.setDsParada(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).dsParada);
                            par.setIdTParada(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).idTParada);
    
                            par.setSegTempoParadas(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.segTempoPar);
                            par.setQtOcorrParadas(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.qtdOcorrPar);
                            par.setQtPerdasKg(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.qtdPerdasKg);
                            par.setQtPerdasTon(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.qtdPerdasTon);
                            par.setQtPerdasUB(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.qtdPerdasPar);
                            par.setQtPerdasUM(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.qtdPerdasUM);
    
                            par.setSegTempoMicroParadas(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.segTempoMicroPar);
                            par.setQtdOcorrMicroParadas(mapDetArea
                                    .get(keyArea).paradaArea
                                    .get(keyParArea).produtos
                                    .get(keyPro).maquinas
                                    .get(keyMaq).paradas
                                    .get(keyPar).det.qtdMicroPar);
                            par.setIndMicroParadas(FormulasInjet
                                    .calcularEficiencia(
                                            new BigDecimal(par
                                                    .getQtdOcorrMicroParadas()),
                                            new BigDecimal(par.getQtOcorrParadas()))
                                    .doubleValue());
    
                            maq.getParadas().add(par);
                        }
    
                        if (maq.getQtOcorrParadas() > 0) {
                            // totais do produto
                            pro.setSegTempoParadas(pro.getSegTempoParadas()
                                    + maq.getSegTempoParadas());
                            pro.setQtOcorrParadas(pro.getQtOcorrParadas()
                                    + maq.getQtOcorrParadas());
                            pro.setQtPerdasKg(pro.getQtPerdasKg()
                                    + maq.getQtPerdasKg());
                            pro.setQtPerdasTon(pro.getQtPerdasTon()
                                    + maq.getQtPerdasTon());
                            pro.setQtPerdasUB(pro.getQtPerdasUB()
                                    + maq.getQtPerdasUB());
                            pro.setQtPerdasUM(pro.getQtPerdasUM()
                                    + maq.getQtPerdasUM());
    
                            pro.setSegTempoMicroParadas(pro
                                    .getSegTempoMicroParadas()
                                    + maq.getSegTempoMicroParadas());
                            pro.setQtdOcorrMicroParadas(pro
                                    .getQtdOcorrMicroParadas()
                                    + maq.getQtdOcorrMicroParadas());
                            pro.setIndMicroParadas(FormulasInjet
                                    .calcularEficiencia(
                                            new BigDecimal(pro
                                                    .getQtdOcorrMicroParadas()),
                                            new BigDecimal(pro.getQtOcorrParadas()))
                                    .doubleValue());
    
                            pro.getMaquinas().add(maq);
                        }                        
                        
                        if (maq.getQtOcorrParadas() > 0) {
                            // totais do parada
                            parArea.setSegTempoParadas(parArea.getSegTempoParadas()
                                    + maq.getSegTempoParadas());
                            parArea.setQtOcorrParadas(parArea.getQtOcorrParadas()
                                    + maq.getQtOcorrParadas());
                            parArea.setQtPerdasKg(parArea.getQtPerdasKg()
                                    + maq.getQtPerdasKg());
                            parArea.setQtPerdasTon(parArea.getQtPerdasTon()
                                    + maq.getQtPerdasTon());
                            parArea.setQtPerdasUB(parArea.getQtPerdasUB()
                                    + maq.getQtPerdasUB());
                            parArea.setQtPerdasUM(parArea.getQtPerdasUM()
                                    + maq.getQtPerdasUM());
    
                            parArea.setSegTempoMicroParadas(parArea
                                    .getSegTempoMicroParadas()
                                    + maq.getSegTempoMicroParadas());
                            parArea.setQtdOcorrMicroParadas(parArea
                                    .getQtdOcorrMicroParadas()
                                    + maq.getQtdOcorrMicroParadas());
                            parArea.setIndMicroParadas(FormulasInjet
                                    .calcularEficiencia(
                                            new BigDecimal(parArea
                                                    .getQtdOcorrMicroParadas()),
                                            new BigDecimal(parArea.getQtOcorrParadas()))
                                    .doubleValue());
    
                            parArea.getProdutos().add(pro);
                        }
                    }
                }

                if (parArea.getQtOcorrParadas() > 0) {
                    // totais do parada da area
                    areaResp.setSegTempoParadas(areaResp.getSegTempoParadas()
                            + parArea.getSegTempoParadas());
                    areaResp.setQtOcorrParadas(areaResp.getQtOcorrParadas()
                            + parArea.getQtOcorrParadas());
                    areaResp.setQtPerdasKg(areaResp.getQtPerdasKg() + parArea.getQtPerdasKg());
                    areaResp.setQtPerdasTon(areaResp.getQtPerdasTon()
                            + parArea.getQtPerdasTon());
                    areaResp.setQtPerdasUB(areaResp.getQtPerdasUB() + parArea.getQtPerdasUB());
                    areaResp.setQtPerdasUM(areaResp.getQtPerdasUM() + parArea.getQtPerdasUM());

                    areaResp.setSegTempoMicroParadas(areaResp.getSegTempoMicroParadas()
                            + parArea.getSegTempoMicroParadas());
                    areaResp.setQtdOcorrMicroParadas(areaResp.getQtdOcorrMicroParadas()
                            + parArea.getQtdOcorrMicroParadas());
                    areaResp.setIndMicroParadas(FormulasInjet.calcularEficiencia(
                            new BigDecimal(areaResp.getQtdOcorrMicroParadas()),
                            new BigDecimal(areaResp.getQtOcorrParadas()))
                            .doubleValue());

                    areaResp.getParadas().add(parArea);
                }
            }

            if (areaResp.getQtOcorrParadas() > 0) {
                detalhamento.getAreasResp().add(areaResp);
            }
        }

        return detalhamento;
    }
	
}
