package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwRap;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.util.FormulasInjet;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutoResumoFichaMaqDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.ProdutosResumoFichaMaqDTO;

public class DetalheMonitorizacaoOPRN extends DetalheMonitorizacaoPTInsertRN {
	/*
	 * Metodo para montar lista com informacoes consolidadas de produtos da
	 * ficha da maquina - op turno ou acumulado
	 */

	public ProdutosResumoFichaMaqDTO getListaProdutosResumoFichaProducaoDTO(ProdutosDTO listaP, byte tipoExibicaoQtd, byte periodoConsolidacao) {

		/*
		 * Alessandre em 24-11-15 o parametro lista esta vindo do netbeans com a
		 * lista de produtos pesquisada durante o ws do detalhe da maquina.
		 * Entretanto, essa lista esta com o mesmo produto por dt referencia e
		 * turno e nesse metodo o melhor seria nao ter essa quebra por dt e
		 * turno pois a ficha da maquina nao mostra esses campos
		 */
		List<ProdutoDTO> lista = new ArrayList<>();
		for (ProdutoDTO dto : listaP.getProdutos()) {
			// Avalia se ja existe o op, maquina e produto
			boolean isExiste = false;
			for (ProdutoDTO dto2 : lista) {
				if (dto2.getMaquina().getIdPt().equals(dto.getMaquina().getIdPt())) {
					if (dto2.getOrdemproducao().getNrop().equals(dto.getOrdemproducao().getNrop())) {
						if (dto2.getProduto().getCdProduto().equals(dto.getProduto().getCdProduto())) {
							dto2.setAproduzir(dto2.getAproduzir().add(dto.getAproduzir()));
							dto2.setCicloMedio(dto2.getCicloMedio() + dto.getCicloMedio());
							dto2.setCicloPadrao(dto2.getCicloPadrao() + dto.getCicloPadrao());
							// dto2.setEficiencia(eficiencia);
							if (dto2.getEstoqueProducao() != null)
								dto2.setEstoqueProducao(dto2.getEstoqueProducao().add(dto.getEstoqueProducao()));
							else
								dto2.setEstoqueProducao(dto.getEstoqueProducao());

							if (dto2.getTempoAtivo() != null)
								dto2.setTempoAtivo(dto2.getTempoAtivo().add(dto.getTempoAtivo()));
							else
								dto2.setTempoAtivo(dto.getTempoAtivo());
							if (dto2.getQtdTotal() != null)
								dto2.setQtdTotal(dto2.getQtdTotal().add(dto.getQtdTotal()));
							else
								dto2.setQtdTotal(dto.getQtdTotal());
							if (dto2.getQtdAtiva() != null)
								dto2.setQtdAtiva(dto2.getQtdAtiva().add(dto.getQtdAtiva()));
							else
								dto2.setQtdAtiva(dto.getQtdAtiva());
							dto2.setPcsProducaoRefugada(dto2.getPcsProducaoRefugada().add(dto.getPcsProducaoRefugada()));
							dto2.setPcsProducaoliquida(dto2.getPcsProducaoliquida().add(dto.getPcsProducaoliquida()));
							dto2.setPcsProducaobruta(dto2.getPcsProducaobruta().add(dto.getPcsProducaobruta()));
							dto2.setMetaInstantanea(dto2.getMetaInstantanea().add(dto.getMetaInstantanea()));
							isExiste = true;

						}
					}
				}
			}
			if (isExiste == false)
				lista.add(dto);
		}
		boolean itemExisteNaLista = false;
		DwFolha dwfolha = null;
		DwRap dwrap = null;
		ProdutosResumoFichaMaqDTO retorno = new ProdutosResumoFichaMaqDTO();

		BigDecimal pesoBruto = BigDecimal.ZERO.setScale(6);
		BigDecimal efiRea = BigDecimal.ZERO;

		if (lista != null) {
			for (ProdutoDTO pr : lista) {
				ProdutoResumoFichaMaqDTO prResumo = new ProdutoResumoFichaMaqDTO();
				if (periodoConsolidacao != PERIODO_CONSOLIDACAO_TURNO) {
					prResumo.setMaquina(pr.getMaquina());
					dwfolha = getDao().findById(DwFolha.class, pr.getOrdemproducao().getDwFolha().getIdFolha(), false);
					dwrap = null;

					if (dwfolha != null) {
						if (dwfolha.getDwFolharaps() != null) {
							for (DwFolharap dwfolharap : dwfolha.getDwFolharaps()) {
								if (dwfolharap.getDwRap() != null) {
									dwrap = dwfolharap.getDwRap();
								}
							}
						}
					}
					if (dwrap != null)
						prResumo.setFerramenta(dwrap.clone(false));

					// recupera producao planejada por produto
					Double qtPlanProduto = 0d;
					MapQuery query = new MapQuery(getDao().getSession());

					query.append("SELECT DISTINCT ppcp");
					query.append("from PpCp ppcp");
					query.appendWhere(MapQuery._NULL, "ppcp.cdCp = :cdcp ", true);
					query.append("order by ppcp.dthrInicioreal");
					query.defineParametro("tpId", (byte) 1);
					query.defineParametro("cdcp", pr.getOrdemproducao().getCdCp());

					List<PpCp> listOP = query.list();

					for (PpCp ppcp : listOP) {
						for (PpCpproduto produto : ppcp.getPpCpprodutos()) {
							if (produto.getOmProduto().getCd().equals(pr.getProduto().getCdProduto())) {
								qtPlanProduto = (produto.getPcsProducaoplanejada() != null ? produto.getPcsProducaoplanejada().doubleValue() : 0);
							}
						}
					}

					prResumo.setPcsPlanejadas(new BigDecimal(qtPlanProduto));
				}

				prResumo.setProduto(pr.getProduto());
				prResumo.setMetaInstantanea(pr.getMetaInstantanea());
				prResumo.setPcsProducaobruta(pr.getPcsProducaobruta());
				prResumo.setPcsProducaoliquida(pr.getPcsProducaoliquida());
				prResumo.setPcsProducaoRefugada(pr.getPcsProducaoRefugada());
				prResumo.setAproduzir(pr.getAproduzir());
				prResumo.setEficiencia(new BigDecimal(pr.getEficiencia()));

				if (tipoExibicaoQtd != EXIBICAO_QTD_UNIDADE_BASICA) {
					/*
					 * Necessario converter as qtdes para peso. Se nao houver
					 * peso cadastrado as qtdes ficarao zeradas
					 */

					pesoBruto = prResumo.getProduto().getGPesoBruto();

					if (pesoBruto == null) {
						pesoBruto = BigDecimal.ZERO;
					}

					if (tipoExibicaoQtd == EXIBICAO_QTD_PESO_KG) {
						pesoBruto = pesoBruto.divide(new BigDecimal(1000));
					} else {
						pesoBruto = pesoBruto.setScale(6).divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_UP);
					}

					if (pesoBruto.compareTo(BigDecimal.ZERO) == 0) {
						prResumo.setMetaInstantanea(BigDecimal.ZERO);
						prResumo.setPcsProducaobruta(BigDecimal.ZERO);
						prResumo.setPcsProducaoliquida(BigDecimal.ZERO);
						prResumo.setPcsProducaoRefugada(BigDecimal.ZERO);
						prResumo.setAproduzir(BigDecimal.ZERO);
						prResumo.setPcsPlanejadas(BigDecimal.ZERO);
					} else {
						prResumo.setMetaInstantanea(prResumo.getMetaInstantanea().multiply(pesoBruto));
						prResumo.setPcsProducaobruta(prResumo.getPcsProducaobruta().multiply(pesoBruto));
						prResumo.setPcsProducaoliquida(prResumo.getPcsProducaoliquida().multiply(pesoBruto));
						prResumo.setPcsProducaoRefugada(prResumo.getPcsProducaoRefugada().multiply(pesoBruto));
						prResumo.setAproduzir(prResumo.getAproduzir().multiply(pesoBruto));
						if (prResumo.getPcsPlanejadas() != null)
							prResumo.setPcsPlanejadas(prResumo.getPcsPlanejadas().multiply(pesoBruto));
						else
							prResumo.setPcsPlanejadas(BigDecimal.ZERO);

					}
				}

				if (retorno.getProdutos() == null) {
					retorno.setProdutos(new ArrayList<ProdutoResumoFichaMaqDTO>());
					retorno.getProdutos().add(prResumo);
				} else {
					// verifica se o produto já¡´á¡®a lista
					itemExisteNaLista = false;
					for (ProdutoResumoFichaMaqDTO itemLista : retorno.getProdutos()) {
						if (periodoConsolidacao != PERIODO_CONSOLIDACAO_TURNO) {
							if ((itemLista.getProduto().getCdProduto().equals(prResumo.getProduto().getCdProduto()))
									&& (itemLista.getMaquina().getCdPt().equals(prResumo.getMaquina().getCdPt()))
									&& (itemLista.getFerramenta() != null
											&& itemLista.getFerramenta().getCdRap() != null
											&& prResumo.getFerramenta() != null
											&& prResumo.getFerramenta().getCdRap() != null && itemLista.getFerramenta()
													.getCdRap().equals(prResumo.getFerramenta().getCdRap()))) {

								itemExisteNaLista = true;

							} else {
								itemExisteNaLista = false;
							}

						} else {
							if (itemLista.getProduto().getCdProduto().equals(prResumo.getProduto().getCdProduto())) {
								itemExisteNaLista = true;
							} else {
								itemExisteNaLista = false;
							}
						}

						if (itemExisteNaLista == true) {
							// atualizar
							itemLista.setMetaInstantanea(itemLista.getMetaInstantanea().add(prResumo.getMetaInstantanea()));
							itemLista.setPcsProducaobruta(itemLista.getPcsProducaobruta().add(prResumo.getPcsProducaobruta()));
							itemLista.setPcsProducaoliquida(itemLista.getPcsProducaoliquida().add(prResumo.getPcsProducaoliquida()));
							itemLista.setPcsProducaoRefugada(itemLista.getPcsProducaoRefugada().add(prResumo.getPcsProducaoRefugada()));
							itemLista.setAproduzir(itemLista.getAproduzir().add(prResumo.getAproduzir()));

							efiRea = BigDecimal.ZERO;
							if (itemLista.getMetaInstantanea() != null) {
								if (itemLista.getMetaInstantanea() != BigDecimal.ZERO) {
									efiRea = new BigDecimal((itemLista.getPcsProducaoliquida().doubleValue() / itemLista.getMetaInstantanea().doubleValue()) * 100);
								}
							}

							itemLista.setEficiencia(efiRea);

							// abandonar for
							break;
						}
					}

					if (itemExisteNaLista == false) {
						// adiciona item na lista
						retorno.getProdutos().add(prResumo);
					}
				}

			}

			for (ProdutoResumoFichaMaqDTO pr : retorno.getProdutos()) {
				BigDecimal indProd = BigDecimal.ZERO;
				indProd = new BigDecimal(FormulasInjet.calcularEficiencia(pr.getPcsProducaoliquida(), pr.getPcsPlanejadas()));
				
				//Alex 07/04/2017: eficiencia da tabela PRODUCAO da ficha da maquina estava zerado
				pr.setEficiencia(indProd);
				
				pr.setIndProducao(indProd);
				//Alex 17/04/2017: eficiencia da tabela PRODUCAO da ficha da maquina estava zerado
				BigDecimal eficiencia = new BigDecimal(FormulasInjet.calcularEficiencia(pr.getPcsProducaoliquida(), pr.getMetaInstantanea()));
				pr.setEficiencia(eficiencia);
			}

		}
		return retorno;
	}

}
