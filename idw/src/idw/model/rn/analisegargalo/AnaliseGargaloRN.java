package idw.model.rn.analisegargalo;


/*
 * No momento essa classe nao esta sendo usada pelo sistema
 */
public class AnaliseGargaloRN {

	public void analisaGargalos() {
		// trecho codigo para setar variaveis de controle gargaloDinamico e
		// gargaloTeorico
		/*
		 * 
		if (retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao() != null) { 
			GTRN gtRn = new GTRN();
			gtRn.setDao(getDao());
			

			for (ObjRtMonitorizacaoDTO objRtMonitorizacao : retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao()) { // percorre a lista
																// de
																// ObjsRtMonitorizacao

				DetalheAnaliseGargaloDTO detalheAnaliseGargaloDTO = new DetalheAnaliseGargaloDTO();
				OmGt omgt = new OmGt();
				
				omgt = gtRn.pesquisarGtByCdGtStAtivo(retorno.getGtDTO().getGt().getCdGt()); // consulta gt de acordo com o cdGt passado // como parametro
												// o GtRn

				if (omgt != null) { // verifica se o gt é null
					List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp = new ArrayList<FiltroProducaoPtCpDTO>();
					FiltroProducaoPtCpDTO filtroProducaoPtCp;
					FiltroProducaoDTO filtroProducao = null;

					if (omgt.getOmTpgt().getIdTpgt() == 3) { // verifica se o
															// IdTpgt eh igual a
															// 3 (Celula)
						filtroProducao = new FiltroProducaoDTO(); // instancia
																	// filtroProducaoDTO
						filtroProducao.setTpId((byte) 1); // seta o TpId
						filtroProducao.setDtReferencia(filtro.getDtReferencia()); // seta a data de
														// referencia
						filtroProducao.setDwTurno(filtro.getDwTurno()); // seta
																				// o
																				// dwTurno

						// verifica se o cdcp eh diferente de null e se o
						// isTemPlanejamento é verdadeiro
						if (objRtMonitorizacao.getCdCp() != null && !objRtMonitorizacao.getCdCp().equals("") && objRtMonitorizacao.isTemPlanejamento() == true) {
							filtroProducaoPtCp = new FiltroProducaoPtCpDTO();
							OmPt pt = new OmPt();
							PpCp ppCp = new PpCp();
							pt.setIdPt(objRtMonitorizacao.getIdPt()); // seta no
																		// objeto
																		// pt o
																		// parametro
																		// IdPt
							ppCp.setCdCp(objRtMonitorizacao.getCdCp()); // seta
																		// no
																		// objeto
																		// ppCp
																		// o
																		// parametro
																		// CdCp
							filtroProducaoPtCp.setOmPt(pt); // seta o objeto
															// filtroProducaoPTCp
															// com o parametro
															// pt
							filtroProducaoPtCp.setPpCp(ppCp); // seta o objeto
																// filtroProducaoPTCp
																// com o
																// parametro
																// ppCp
							listaFiltroProducaoPtCp.add(filtroProducaoPtCp); // guarda
																				// o
																				// objeto
																				// filtroProducaoPtCp
																				// na
																				// lista
						}
						filtroProducao.setListaFiltroProducaoPtCp(listaFiltroProducaoPtCp); // adiciona
																						// listaFiltroProducaoPtCp
					}

					if (filtroProducao != null) { // verifica se o objeto
													// filtroProducao 'e
													// diferente de null
						DetalheMonitorizacaoPTInjetRN detalheRN = new DetalheMonitorizacaoPTInjetRN(getDao());
						
						detalheAnaliseGargaloDTO = detalheRN.getDetalheCelulas(filtroProducao); // consulta
																	// detalheCelulas
																	// de acordo
																	// com o
																	// objeto
																	// filtroProducao
					}

					if (detalheAnaliseGargaloDTO != null) { // verifica se o
															// objeto
															// detalheAnaliseGargaloDTO
															// é diferente de
															// null
						// percore a lista de indicadoresPtGargaloDinamico
						for (IndicadoresPtDTO indicadoresPtDinamico : detalheAnaliseGargaloDTO.getListaIndicadoresPtGargaloDinamico().getLista()) {

							if (objRtMonitorizacao.getCdPt() != null && indicadoresPtDinamico.getOmPt().getCdPt() != null) {
								// verifica se o CdPt do indicadorPt é igual ao
								// cdPt do objRtMonitorizacao
								if (objRtMonitorizacao.getCdPt().equals(indicadoresPtDinamico.getOmPt().getCdPt())) {
									// seta a variavel GargaloDinamico como true
									objRtMonitorizacao.setGargaloDinamico(true);
								}
							}
						}

						// percorre a lista de indicadoresPtGargaloTeorico
						for (IndicadoresPtDTO indicadoresPTGargalho : detalheAnaliseGargaloDTO.getListaIndicadoresPtGargaloTeorico().getLista()) {

							if (objRtMonitorizacao.getCdPt() != null && indicadoresPTGargalho.getOmPt().getCdPt() != null) {
								// verifica se o CdPt do indicadorPt é igual ao
								// cdPt do objRtMonitorizacao
								if (objRtMonitorizacao.getCdPt().equals(indicadoresPTGargalho.getOmPt().getCdPt())) {
									// seta a variavel gargaloTeorico como true
									objRtMonitorizacao.setGargaloTeorico(true);
								}
							}
						}
					}
				}
			}

		}
		 */

	}

}
