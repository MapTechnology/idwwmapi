package idw.model.rn.algoritmos.monitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmPtDAO;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwRtTemplate.StFuncionamento;
import idw.model.pojos.template.OmIndTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.model.rn.monitorizacao.injet.ConfiguracoesInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetV2RN;
import idw.model.rn.monitorizacao.injet.TempoRealInjetRN;
import idw.model.rn.servemail.ServicoEmailFactory;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.CfgParamConcOP;
import idw.webservices.rest.dto.monitorizacao.injet.RtFolhaDTO;
import ms.util.ConversaoTipos;

public class AlgoritmoMonitorizacaoInjet implements IAlgoritmo {

	private Double indiceDefeito = null;
	private Double eficienciaCiclomedio = null;
	private Double eficienciaUltimoCiclo = null;
	private Double eficienciaRealizacao = null;
	private Double indice_parada = null;
	private Double indice_refugo = null;
	private Double indice_acur = null;
	private Double indice_OEE = null;
	private Double indice_producao = null;
	private Double cicloPadrao = null;
	private Double cicloMedio = null;
	private List<DwConsolid> listadwConsolid = null;
	private DwRt dwRt = null;
	private MonitorizacaoRN rn = null;
	private MonitorizacaoInjetRN rnI = null;
//	private MonitorizacaoInjetV2RN rnIV2 = null;

	private Double producaoBruta;
	private Double producaoRefugada;
	private Double producaoLiquida;

	@Override
	public void executar(
			IdwLogger log, 
			ObjRtMonitorizacaoDTO retorno, 
			DwConsolidTemplate.TpId tpId, 
			DwRt dwRt, 
			OmCfg omCfg, 
			MonitorizacaoRN rn, 
			boolean isTurnoAtual, 
			Integer filtroOp) {



		this.dwRt = dwRt;
		this.rn = rn;

		retorno.setTemOperador((dwRt.getIsOperador() != null) && dwRt.getIsOperador().booleanValue());

		// setar os valores do Turno
		retorno.setCdTurno(dwRt.getDwTurno().getCdTurno());
		retorno.setDsTurno(dwRt.getDwTurno().getDsTurno());
		retorno.setIdTurno(dwRt.getDwTurno().getIdTurno());

		retorno.setTipoAlgoritmo(ObjRtMonitorizacaoDTO.ALG_INJET);

		// verifica se o item possui configuracao
		// se tiver trata o item, senao retorna;
		if (retorno.isTemOmCfg() == false) {
			retorno.setOffline(true);
			retorno.setParada(true);
		}

		PTRN ptrn = new PTRN(rn.getDao());
		OmPt ompt = ptrn.pesquisarPtByCdPtStAtivo(retorno.getCdPt());
		FolhaRN frn = new FolhaRN(rn.getDao());

		retorno.setIdtppt(ompt.getOmTppt().getIdTppt());

		// Se tiver informacao em tempo real e nao estiver offline, tratar o
		// item
		if (retorno.isTemDwRt() && dwRt.getIsOffline() != null && dwRt.getIsOffline() == false) {

			log.iniciaAvaliacao("buscarDwConsolid - fim");
			log.info("buscarDwConsolid - inicio");
			listadwConsolid = buscarDwConsolid(ompt, tpId, filtroOp);
			log.mostrarAvaliacaoCompleta();

			log.iniciaAvaliacao("setarValores");
			setarValores(log, omCfg, dwRt.getDtReferencia());
			log.mostrarAvaliacaoCompleta();

			log.iniciaAvaliacao("setarValoresNoObjeto");
			setarValoresNoObjeto(retorno, isTurnoAtual);
			log.mostrarAvaliacaoCompleta();

			log.iniciaAvaliacao("setarFlags");
			setarFlags(log, isTurnoAtual, retorno, omCfg, null, ompt, listadwConsolid);
			log.mostrarAvaliacaoCompleta();

			// Alessandre: Em 23-5-13 se nao existir um dwconsolid para dwrt
			// eh pq nao tem cp carregada, assim acrescentei o if abaixo
			log.iniciaAvaliacao("iniciando varios atributos de retorno");
			if (listadwConsolid.isEmpty() == false) {
				retorno.setCdCp(listadwConsolid.get(0).getPpCp().getCdCp());

				// aqui pegar todos os produtos que vao aparecer na tooltip do icon
				String complemento = "";
				if (retorno.getCdProduto() == null) {
					retorno.setCdProduto("");
					retorno.setDsProduto("");
				}
				for (PpCpproduto ppcpproduto : listadwConsolid.get(0).getPpCp().getPpCpprodutos()) {
					retorno.setCdProduto(retorno.getCdProduto() + complemento + ppcpproduto.getOmProduto().getCdProduto());
					retorno.setDsProduto(retorno.getDsProduto() + complemento + ppcpproduto.getOmProduto().getDsProduto());
					complemento = "\n";
				}

				if (listadwConsolid.get(0).getOmPt().getIndOee() != null) {
					retorno.setIndOEE(listadwConsolid.get(0).getOmPt().getIndOee().doubleValue());
				}


				DwFolha dwfolha = listadwConsolid.get(0).getDwFolha();

				retorno.setCdFolha(dwfolha.getCdFolha());
				retorno.setDsFolha(dwfolha.getDsFolha());

				retorno.setProducaoLiquida(producaoLiquida);
				retorno.setProducaoBruta(producaoBruta);
				retorno.setProducaoRefugada(producaoRefugada);

				BigDecimal segAutoTempoativo = BigDecimal.ZERO;
				BigDecimal cicloPadrao = BigDecimal.ZERO;
				BigDecimal cavAtiva = BigDecimal.ONE;
				BigDecimal cavTotal = BigDecimal.ONE;
				BigDecimal segTempoParadaCP = BigDecimal.ZERO;
				BigDecimal fatorContagem = BigDecimal.ONE;

				DwConsolid dwconsolid = listadwConsolid.get(0);
				DwConsol dwconsol = dwconsolid.getDwConsols().iterator().next();

				if (dwconsol.getSegAutoTempoativo() != null) {
					segAutoTempoativo = dwconsol.getSegAutoTempoativo();
				}

				if (dwconsol.getSegAutoTempoparadaCp() != null) {
					segTempoParadaCP = dwconsol.getSegAutoTempoparadaCp();
				}

				if (dwconsolid.getDwFolha().getSegCiclopadrao() != null) {
					cicloPadrao = dwconsolid.getDwFolha().getSegCiclopadrao();
				}

				try {
					if (dwconsolid.getDwFolha().getDwFolhaiacs().iterator().next().getQtAtiva() != null) {
						cavAtiva = dwconsolid.getDwFolha().getDwFolhaiacs().iterator().next().getQtAtiva();
					}
				} catch (NoSuchElementException e) {
					cavAtiva = BigDecimal.ONE;
				}


				try {
					fatorContagem = frn.getFatorContagemFromDwFolha(dwfolha, ompt);
				} catch (SemPacoteOuFatorException e) {
					fatorContagem = BigDecimal.ZERO;
				}

				BigDecimal metaInstatanea = FormulasInjet.calcularProducaoPrevista(segAutoTempoativo, cicloPadrao, cavAtiva, fatorContagem, ompt.getIndOee()).setScale(0, BigDecimal.ROUND_FLOOR);

				if (IdwFacade.IS_IDW_ATIVO == false) {
					if (ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais()) {
						cavTotal = dwconsolid.getDwConsol().getQtAutoCavtotal();
						metaInstatanea = FormulasInjet.calcularProducaoPrevista(segAutoTempoativo, cicloPadrao, cavTotal, fatorContagem, ompt.getIndOee()).setScale(0, BigDecimal.ROUND_FLOOR);
					}
				}

				retorno.setMetaInstatanea(metaInstatanea.doubleValue());

				retorno.setSegCicloPadrao(cicloPadrao.doubleValue());
				retorno.setSegTempoAtivo(segAutoTempoativo.intValue());
				retorno.setSegTempoParadaCP(segTempoParadaCP.intValue());

				if (dwRt.getSegUltimociclo() != null)
					retorno.setSegUltimoCiclo(dwRt.getSegUltimociclo().doubleValue());

				retorno.setSegCicloMedio(cicloMedio);

				if (listadwConsolid != null && listadwConsolid.isEmpty() == false) {

					if (listadwConsolid.get(0).getPpCp() != null) {

						if (listadwConsolid.get(0).getPpCp().getPpCpprodutos() != null) {

							BigDecimal ultimaOpProducaoPlanejada = BigDecimal.ZERO;
							BigDecimal ultimaOpProducaoBruta = BigDecimal.ZERO;
							BigDecimal ultimaOpProducaoRefugada = BigDecimal.ZERO;
							BigDecimal ultimaOpProducaoLiquida = BigDecimal.ZERO;
							BigDecimal ultimaOpSaldoAProduzir = BigDecimal.ZERO;

							for (PpCpproduto ppCpProduto : listadwConsolid.get(0).getPpCp().getPpCpprodutos()) {
								retorno.setUltimaOp(ppCpProduto.getNrDoc());

								if (ppCpProduto.getPcsProducaoplanejada() != null)
									ultimaOpProducaoPlanejada = ultimaOpProducaoPlanejada.add(ppCpProduto.getPcsProducaoplanejada());
								if (ppCpProduto.getPcsProducaorefugada() != null)
									ultimaOpProducaoRefugada = ultimaOpProducaoRefugada.add(ppCpProduto.getPcsProducaorefugada());
								if (ppCpProduto.getPcsProducaobruta() != null)
									ultimaOpProducaoBruta = ultimaOpProducaoBruta.add(ppCpProduto.getPcsProducaobruta());
							}
							ultimaOpProducaoLiquida = ultimaOpProducaoBruta.subtract(ultimaOpProducaoRefugada);
							ultimaOpSaldoAProduzir = ultimaOpProducaoPlanejada.subtract(ultimaOpProducaoLiquida);

							retorno.setUltimaOpProducaoPlanejada(ultimaOpProducaoPlanejada.doubleValue());
							retorno.setUltimaOpProducaoRefugada(ultimaOpProducaoRefugada.doubleValue());
							retorno.setUltimaOpProducaoLiquida(ultimaOpProducaoLiquida.doubleValue());
							retorno.setUltimaOpSaldoAProduzir(ultimaOpSaldoAProduzir.doubleValue());
						}

						// FIXME: necessário identificar de algum modo a folha que está
						// em uso; provavelmente incluir id_folha em dw_rt. No momento a
						// propriedade UltimoMolde de objRtDTOItem não está sendo usada.
						if (listadwConsolid.get(0).getDwFolha() != null) {
							if (listadwConsolid.get(0).getDwFolha().getDwFolharaps() != null) {
								for (DwFolharap dwFolhaRap : listadwConsolid.get(0).getDwFolha().getDwFolharaps()) {
									if (dwFolhaRap.getDwRap() != null) {
										retorno.setUltimoMolde(dwFolhaRap.getDwRap().getCdRap());
										break;
									}
								}
							}
						}

					}
				} else {
					retorno.setUltimaOp("");
					retorno.setUltimoMolde("");
				}

			} else {
				retorno.setCdCp("");
				retorno.setCdProduto("");
				retorno.setDsProduto("");
				retorno.setCdFolha("");
				retorno.setDsFolha("");
			}
			log.mostrarAvaliacaoCompleta();

			// Se estiver sem planejamento entao inicializa ultima parada com a parada completa
			if (retorno.isTemPlanejamento() == false) {
				log.iniciaAvaliacao("setarValoresSemMolde");
				setarValoresSemMolde(retorno, dwRt);
				log.mostrarAvaliacaoCompleta();
			}
		}
	}

	private List<DwConsolid> buscarDwConsolid(OmPt ompt, DwConsolidTemplate.TpId tpId, Integer filtroOP) {
		List<DwConsolid> retorno = null;

		// Alessandre: o if em 23-5-13, Se dwRt possuir planejamento carregado
		// entao tera dwconsolid
		if (dwRt.getPpCp() != null) {
			// Se for acumulado, nao usa data de referencia, nem o turno
			if (DwConsolidTemplate.TpId.ACUMULADO.equals(tpId) || filtroOP.equals(2)) {
				retorno = rn.getDwConsolidPorDt(ompt, dwRt.getPpCp(), null, null);
			} else {
				if (filtroOP.equals(0))
					retorno = rn.getDwConsolidPorDt(ompt, dwRt.getPpCp(), dwRt.getDtReferencia(), dwRt.getDwTurno());
				else
					retorno = rn.getDwConsolidPorDt(ompt, null, dwRt.getDtReferencia(), dwRt.getDwTurno());
			}
		} else {
			retorno = new ArrayList<DwConsolid>();
		}

		return retorno;
	}

	private void setarValoresSemMolde(ObjRtMonitorizacaoDTO objRtDTOItem, DwRt dwRt) {
		if (dwRt.getDwConsolpalog() != null) {

			if (dwRt.getDwConsolpalog().getDwTParada() != null) {
				objRtDTOItem.setUltimaParada(dwRt.getDwConsolpalog().getDwTParada().getCdTparada() + "-" + dwRt.getDwConsolpalog().getDwTParada().getDsTparada());
			} else {
				objRtDTOItem.setUltimaParada("");
			}
			objRtDTOItem.setIniParada(dwRt.getDwConsolpalog().getDthrIparada());
			objRtDTOItem.setFimParada(dwRt.getDwConsolpalog().getDthrFparada());
			if (dwRt.getDwConsolpalog().getDwTParada() != null && dwRt.getDwConsolpalog().getDwTParada().getDwTArea() != null)
				objRtDTOItem.setAreaResponsavel(dwRt.getDwConsolpalog().getDwTParada().getDwTArea().getCdArea() + "-" + dwRt.getDwConsolpalog().getDwTParada().getDwTArea().getDsArea());
			if (objRtDTOItem.getIniParada() != null && objRtDTOItem.getFimParada() != null) {
				objRtDTOItem.setDuracaoParada(diferencaEmHoras(objRtDTOItem.getIniParada(), objRtDTOItem.getFimParada()));
			}
		} else {
			objRtDTOItem.setUltimaParada(null);
			objRtDTOItem.setIniParada(null);
			objRtDTOItem.setFimParada(null);
			objRtDTOItem.setDuracaoParada(null);
			objRtDTOItem.setAreaResponsavel(null);
		}
	}


	/*
	 * Metodo principal para definir as flags do PT que serao usadas na tela de
	 * monitorizacao. Se esta online ou offline, parado ou trabalhando. Esse
	 * metodo identifica esses status
	 */
	private void setarFlags(IdwLogger log, boolean isTurnoAtual, ObjRtMonitorizacaoDTO objRtDTOItem, OmCfg omCfg, CfgParamConcOP cfgGeralInjet,
			OmPt ompt, List<DwConsolid> listaids) {
		// se diffTime for maior que 60, entao item esta offline.
		// Alessandre em 10-2-14 Comentei a linha abaixo pq o 3o turno da semp
		// estava sempre em offlina
		// isso ocorreu pq o elapsed acima esta considerando a dt referencia com
		// a hora zerada, deveos corrigir. enquanto isso nao levaremos
		// para offline. Retornei com a linha abaixo pois estava impactando nos
		// outros turnos
		objRtDTOItem.setOffline(false); // diffTime > 60);

	
		/*
		int p = 0;
		if (ompt.getCdPt().equals("INJ_off_5526")){
			p=0;
		}	
		*/
			
		
		
		boolean rtOffline = dwRt.getIsOffline() == null ? true : dwRt.getIsOffline();

		// Se hoyver mudanca de status de true pra false ou vice versa, alterar
		// o registro
		if (objRtDTOItem.isOffline() != rtOffline) {
			// atualizar dwrt.offline
			dwRt.setIsOffline(objRtDTOItem.isOffline());
		}

		// Se existir uma diferenca de 60 segundos entre o heartbeat e a hora
		// atual e o pt nao estive offline, entao considera-lo offline
		int diff = 0;

		if (dwRt.getDthrHeartbeat() != null)
			diff = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwRt.getDthrHeartbeat(), DataHoraRN.getDataHoraAtual());

		// Levar para offline apenas se for turno atual, os turnos passados nao
		// devem ser alterados......
		DwConsolid dwconsolid = null;
		if (listaids != null && listaids.size() > 0)
			dwconsolid = listaids.get(0);

		if (isTurnoAtual && dwRt.getIsOffline() == false && diff > 1200) {
			dwRt.setIsOffline(true);
			// Enviar email avisando que maquina esta offline
			ServicoEmailFactory email = ServicoEmailFactory.getInstance(log, 0, 0, rn.getDaoSession(),
					ServicoEmailFactory.TpEvt.ALERTA_OFFLINE);
			if (dwconsolid != null)
				email.gerarAlerta(dwconsolid);
		}

		// Verificando se a maquina eh gargalo
		if (dwRt.getIsGargalodinamico() != null)
			objRtDTOItem.setGargaloDinamico(dwRt.getIsGargalodinamico());
		else
			objRtDTOItem.setGargaloDinamico(false);

		if (dwRt.getIsGargaloteorico() != null)
			objRtDTOItem.setGargaloTeorico(dwRt.getIsGargaloteorico());
		else
			objRtDTOItem.setGargaloTeorico(false);


		if (IdwFacade.IS_IDW_ATIVO) {
			// Verificando se a maquina esta dentro da meta
			objRtDTOItem.setDentroDaMeta(isMaquinaDentroDaMeta(log, dwRt.getOmPt(), omCfg));

			if (ompt.getIsConsolpendente() != null) {
				objRtDTOItem.setConsolidacaoPendente(ompt.getIsConsolpendente());			
			}
			else {
				objRtDTOItem.setConsolidacaoPendente(false);	
			}			
		} else {
			// Verificando se a maquina esta dentro da meta
			objRtDTOItem.setConsolidacaoPendente(false);
			objRtDTOItem.setDentroDaMeta(false);

			if (dwRt.getIsSemplanejamento()==false) {
				objRtDTOItem.setDentroDaMeta(isMaquinaDentroDaMeta(log, dwRt.getOmPt(), omCfg));

				if (isTurnoAtual) {
					objRtDTOItem.setConsolidacaoPendente(ompt.getIsConsolpendente());
				}
			}			
		}


		// verifica flag de maq. parada
		objRtDTOItem.setParada(dwRt.getStFuncionamento() != null && dwRt.getStFuncionamento().equals((byte) 0));

		// setar se esta em CIP
		objRtDTOItem.setCIP(dwRt.getIsCip() != null && dwRt.getIsCip());
		// Setar se o cip esta extrapolado. Isso ocorre quando existir um alerta
		// em aberto automatico igual ao da configuracao
		if (objRtDTOItem.isCIP())
			if (IdwFacade.IS_IDW_ATIVO) {
				objRtDTOItem.setCIPExtrapolado(isCIPExtrapolado(dwRt, omCfg, dwconsolid));	
			} else {
				objRtDTOItem.setCIPExtrapolado(isCIPExtrapoladoInjet(dwconsolid));
			}


		// verifica se é parada com peso
		if (objRtDTOItem.isParada() && dwRt.getDwConsolpalog() != null && dwRt.getDwConsolpalog().getDwTParada() != null) {
			objRtDTOItem.setParadaComPeso(dwRt.getDwConsolpalog().getDwTParada().getIsPesa());
		} else {
			objRtDTOItem.setParadaComPeso(objRtDTOItem.isParada() && (dwRt.getIsParadapeso() != null && dwRt.getIsParadapeso()));
		}
		objRtDTOItem.setParadaSemPesoEfic(!objRtDTOItem.isParadaComPeso());

		// verifica se maq. esta sem Molde
		objRtDTOItem.setTemPlanejamento(!((dwRt.getIsSemplanejamento() != null) && (dwRt.getIsSemplanejamento())));
		objRtDTOItem.setComAlerta(((dwRt.getIsAlerta() != null) && (dwRt.getIsAlerta())));

		// Verifica se parada é parada de manutencao
		// objRtDTOItem.setParadaManutencao(objRtDTOItem.isParada() &&
		// (dwRt.getIsManutencaopre() != null && dwRt.getIsManutencaopre()));
		if (objRtDTOItem.isParada() == true && dwRt != null && dwRt.getDwConsolpalog() != null
				&& dwRt.getDwConsolpalog().getDwTParada() != null
				&& dwRt.getDwConsolpalog().getDwTParada().getCdTparada() != null
				&& dwRt.getDwConsolpalog().getDwTParada().getIsMtbf() != null) {
			objRtDTOItem.setParadaManutencao(dwRt.getDwConsolpalog().getDwTParada().getIsMtbf());
		} else {
			objRtDTOItem.setParadaManutencao(false);
		}

		if (objRtDTOItem.isParada() == true && dwRt != null && dwRt.getDwConsolpalog() != null
				&& dwRt.getDwConsolpalog().getDwTParada() != null
				&& dwRt.getDwConsolpalog().getDwTParada().getCdTparada() != null && omCfg.getDwTParada() != null)
			objRtDTOItem.setParadaNaoInformada(
					dwRt.getDwConsolpalog().getDwTParada().getCdTparada().equals(omCfg.getDwTParada().getCdTparada()));
		else
			objRtDTOItem.setParadaNaoInformada(false);

		// calcula quantidade produzida, para saber se OP esta concluida ou se
		// esta com 90% concluida;
		if (dwRt.getPcsProducaoplanejadaOp() != null && dwRt.getPcsProducaoliquidaOp() != null) {
			if (dwRt.getPcsProducaoplanejadaOp().doubleValue() > 0) {
				// Op estara concluida se Producao Planejada for igual a producao
				// liquida
				objRtDTOItem.setOpConcluida(dwRt.getPcsProducaoplanejadaOp().doubleValue() - dwRt.getPcsProducaoliquidaOp().doubleValue() <= 0);

				if (IdwFacade.IS_IDW_ATIVO) {
					Long porcentagemOp = (long) ((dwRt.getPcsProducaoliquidaOp().doubleValue() * 100) / dwRt.getPcsProducaoplanejadaOp().doubleValue());
					objRtDTOItem.setOpConcluida90PorCento(porcentagemOp >= 90);
				} else {
					/*
					 *  no injet a definicao para conclusao de op tem duas config distintas
					 *  1. Se ijconger.TpVerifConcOP = "1"  >>  ijconger.VlVefifConcOP indica o perc de conclusao da OP (nao necessariamente 90)
					 *  2. Se ijconger.TpVerifConcOP = "2"  >>  ijconger.VlVefifConcOP indica a quantidade de horas para conclusao da OP
					 */
					if (cfgGeralInjet.getTpVerifConcOP().equals("1")) {
						BigDecimal porcentagemOp = new BigDecimal((dwRt.getPcsProducaoliquidaOp().doubleValue() / dwRt.getPcsProducaoplanejadaOp().doubleValue()));
						objRtDTOItem.setOpConcluida90PorCento(porcentagemOp.doubleValue() >= cfgGeralInjet.getVlVerifConcOP().doubleValue());						
					} else {
						if (dwRt.getPpCp() != null) {
							objRtDTOItem.setOpConcluida90PorCento(isHorasConclusaoOP(dwRt.getPpCp().getCdCp(), dwRt.getOmPt().getCdPt(), cfgGeralInjet.getVlVerifConcOP()));	
						}						
					}
				}

			}
		}

		// Verificar se o indice de refugo esta acima da meta
		// obter o limite definido para o indice de refugo. Se nao existir
		// adotar o 3%
		double indiceRefugoMaximo = 3d;
		for (OmCfgind omcfgind : omCfg.getOmCfginds()) {
			if (omcfgind.getOmInd().getIdInd() == OmIndTemplate.Tipo.INDICE_REFUGO.getId()) {
				indiceRefugoMaximo = omcfgind.getIndMeta().doubleValue();
			}
		}

		if (objRtDTOItem.getIndiceRefugos().doubleValue() >= indiceRefugoMaximo) {
			objRtDTOItem.setIndiceRefugo3porCento(true);
		} else {
			objRtDTOItem.setIndiceRefugo3porCento(false);
		}

		objRtDTOItem.setManutencaoPrev(dwRt.getIsManutencaopre());
		objRtDTOItem.setAlertaVidaUtil(dwRt.getIsVidautilmolde());

	}


	private boolean isHorasConclusaoOP(String nrOP, String cdPt, BigDecimal horasParaConclusao) {
		boolean retorno = false;
		boolean isOPConcluida = true;
		
		/*
		int p = 0;
		if (cdPt.equals("INJ_off_5526")){
			p=0;
		}		
		*/	

		if (! nrOP.equals("")) {
			int _produto = 0;
			int _cicloPadrao = _produto + 1;
			int _fatorContagem = _cicloPadrao + 1;
			int _pcsCicloAtivas = _fatorContagem + 1;
			int _prodPlan = _pcsCicloAtivas + 1;
			int _prodLiquida = _prodPlan + 1;


			class Registro {
				// String cdProduto; // atributo sem uso
				BigDecimal cicloPadrao = BigDecimal.ZERO;
				BigDecimal fatorContagem = BigDecimal.ZERO;
				BigDecimal pcsCicloAtivas = BigDecimal.ZERO;
				BigDecimal prodLiquida = BigDecimal.ZERO;
				BigDecimal prodPlan = BigDecimal.ZERO;
			}


			MapQuery q =  new MapQuery(rnI.getDaoSession());
			
			q.append("SELECT p.cdproduto, ft.ciclopadrao, ft.fatorcontagemprod, mp.qtcavativas, ");
			q.append("       (p.qtpecasproduzir / dc.divisorUB) as prodplan,  ");
			q.append("       (CASE WHEN r.prodliquida IS NULL THEN 0 ELSE r.prodliquida END) prodliq ");
			q.append("  FROM ijop a ");
			q.append("  JOIN ijopprodutos p on (p.nrop = a.nrop AND p.cdmolde = a.cdmolde AND p.cdestrutura = a.cdestrutura) "); 
			q.append("  JOIN viewDivisorContagem dc ON (1=1) ");
			q.append("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrfvalcic IS NULL) ");
			q.append("  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");
			q.append("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");

			//sub-query com total produzido liquido
			q.append("  LEFT JOIN (SELECT a.cdproduto, ");
			q.append("                    SUM(a.prodbruta - a.prodrefugada) as prodliquida ");
			q.append("               FROM viewBIDtRefProdutos a ");
			q.append("              WHERE a.nrop = :nrop ");
			q.append("                AND a.cdinjestendido = :cdpt ");
			q.append("             GROUP BY a.cdproduto) r ON (r.cdproduto = p.cdproduto) ");

			q.append(" WHERE a.nrop = :nrop ");
			q.append("   AND i.cdinjestendido = :cdpt ");

			q.defineParametro("nrop", nrOP);
			q.defineParametro("cdpt", cdPt);

			List<?> lista = q.querySQL().list();


			Date dtHrAtual = DataHoraRN.getDataHoraAtual();
			Date dtHrFimPrev = dtHrAtual;
			Date dtHrFimPrevMax = dtHrAtual;


			for (Object reg : lista) {
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				Registro registro = new Registro();
//				registro.cdProduto = (String) registroLido[_produto]; // atributo sem uso
				registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadrao]);
				registro.fatorContagem = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorContagem]);
				registro.pcsCicloAtivas = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsCicloAtivas]);
				registro.prodLiquida = ConversaoTipos.converterParaBigDecimal(registroLido[_prodLiquida]);
				registro.prodPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]);

				if (registro.prodLiquida.doubleValue() < registro.prodPlan.doubleValue()) {
					isOPConcluida = false;

					BigDecimal saldoOP = AritmeticaUtil.diminuir(registro.prodPlan, registro.prodLiquida);
					BigDecimal qtdCiclosNec = AritmeticaUtil.dividir(saldoOP, AritmeticaUtil.multiplicar(registro.pcsCicloAtivas, registro.fatorContagem));
					BigDecimal tempoNec = BigDecimal.ZERO;

					double resto = saldoOP.doubleValue() % AritmeticaUtil.multiplicar(registro.pcsCicloAtivas, registro.fatorContagem).doubleValue();
					if (resto > 0d) {
						qtdCiclosNec = AritmeticaUtil.somar(qtdCiclosNec, BigDecimal.ONE);
					}

					//calc fim previsto
					tempoNec = AritmeticaUtil.multiplicar(qtdCiclosNec, registro.cicloPadrao);
					dtHrFimPrev = DataHoraRN.somaSegundos(dtHrAtual, tempoNec.intValue());

					if (DataHoraRN.after(dtHrFimPrev, dtHrFimPrevMax)) {
						dtHrFimPrevMax = dtHrFimPrev;
					}
				}				
			}	

			if (!isOPConcluida) {
				int segParaConclusao = AritmeticaUtil.multiplicar(horasParaConclusao, new BigDecimal(3600)).intValue();
				int segTempoPrevConc = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrAtual, dtHrFimPrevMax);

				retorno = (segTempoPrevConc <= segParaConclusao);
			}

		}

		return retorno;
	}

	/*
	 * Esse metodo deve retornar true se existe um CIP em aberto para o Rt
	 * avaliado
	 */
	private boolean isCIPExtrapolado(DwRt dwRt, OmCfg omcfg, DwConsolid id) {
		boolean isRetorno = false;
		ConsolidaRN rnC = new ConsolidaRN();
		rnC.setDao(rn.getDao());
		List<DwConsolallog> listaabertos = rnC.getDwConsolalComAlertaAberto(dwRt.getOmPt());

		for (DwConsolallog aberto : listaabertos) {
			// Verificar se existe intersecao entre os alertas abertas e o
			// periodo avaliado
			Date fim = aberto.getDthrFalerta();
			if (fim == null)
				fim = DataHoraRN.getDataHoraAtual();

			if (DataHoraRN.isIntersecao(id.getDthrIturno(), id.getDthrFturno(), aberto.getDthrIalerta(), fim) == false)
				continue;

			if (omcfg.getDwTAlerta() != null
					&& omcfg.getDwTAlerta().getCdTalerta().equals(aberto.getDwTAlerta().getCdTalerta())) {
				isRetorno = true;
				break;
			}
		}
		return isRetorno;
	}

	private boolean isCIPExtrapoladoInjet(DwConsolid id) {
		boolean isRetorno = false;
		TempoRealInjetRN rn = new TempoRealInjetRN(rnI.getDao());
		isRetorno = rn.isCipExtrapolado(id.getOmPt().getCdPt());		
		return isRetorno;
	}


	/**
	 * Máquina está dentro da meta quando não satisfaz as seguintes condições: 1
	 * - Eficiência de ciclo médio, esta fora de faixa; 2 - Eficiência do Últmio
	 * Ciclo esta fora de faixa; 3 - indice de refugo acima da faixa; 4 -
	 * Eficiência de realização fora de faixa
	 */
	private boolean isMaquinaDentroDaMeta(IdwLogger log, OmPt ompt, OmCfg omCfg) {

		/**
		 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e
		 * direta, onde ciclo padrao esta para 100 assim como ciclo medio esta
		 * para x
		 */

		// TODO verificar indice dentro do OmPt
		if (ompt.getOmIndpts() != null && ompt.getOmIndpts().isEmpty() == false) {

			for (OmIndpt indPt : ompt.getOmIndpts()) {

				if (IdwFacade.IS_IDW_ATIVO) {
					// testa EficienciaRealizacao
					if (indPt.getIdIndpt() == 1) {

						if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaRealizacao) {
							return false;
						}

					}

					// testa EficienciaCiclomedio
					if (indPt.getIdIndpt() == 2) {

						if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaCiclomedio) {
							return false;
						}

						if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaUltimoCiclo) {
							return false;
						}
					}
				} else {
					// testa EficienciaRealizacao
					if (indPt.getOmInd().getCdInd().equals("ER")) {

						if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaRealizacao) {
							return false;
						}

					}

					// testa EficienciaCiclomedio
					if (indPt.getOmInd().getCdInd().equals("EC")) {

						if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaCiclomedio) {
							return false;
						}

						if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaUltimoCiclo) {
							return false;
						}
					}					
				}

			}
		} else if (ompt.getOmTppt().getOmIndtppts() != null && ompt.getOmTppt().getOmIndtppts().isEmpty() == false) {

			// TODO verificar indice dentro do OmTppt
			for (OmIndtppt indTppt : ompt.getOmTppt().getOmIndtppts()) {
				// testa EficienciaCiclomedio
				if (indTppt.getIdIndtppt() == 1) {
					if (indTppt.getNumMeta() == null || indTppt.getNumMeta().longValue() > eficienciaCiclomedio) {
						return false;
					}
				}

				// testa EficienciaUltimoCiclo
				if (indTppt.getIdIndtppt() == 2) {

					if (indTppt.getNumMeta() == null || indTppt.getNumMeta().longValue() > eficienciaUltimoCiclo) {
						return false;
					}

					if (indTppt.getNumMeta() == null || indTppt.getNumMeta().longValue() > eficienciaRealizacao) {
						return false;
					}
				}

			}
		} else if (omCfg.getOmCfginds() != null && omCfg.getOmCfginds().isEmpty() == false) {

			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				/*
				 * 1 ER 2 EC 3 IR 4 IP
				 */
				if (omCfgInd.getOmInd().getIdInd() == 1) {
					if (eficienciaRealizacao < omCfgInd.getIndMeta().longValue()) {
						return false;
					}
				}

				if (omCfgInd.getOmInd().getIdInd() == 2) {
					if (eficienciaCiclomedio < omCfgInd.getIndMeta().longValue()) {
						return false;
					}

					if (eficienciaUltimoCiclo < omCfgInd.getIndMeta().longValue()) {
						return false;
					}
				}

				if (omCfgInd.getOmInd().getIdInd() == 3) {
					if (indice_refugo > omCfgInd.getIndMeta().longValue()) {
						return false;
					}
				}

				if (omCfgInd.getOmInd().getIdInd() == 4) {
					if (indice_parada > omCfgInd.getIndMeta().longValue()) {
						return false;
					}
				}

			}
		}
		return true;
	}


	/*
	 * Inicializar Valores que serão utilizados em todo o Algoritmo
	 */
	private void setarValores(IdwLogger log, OmCfg omcfg, Date dtReferencia) {

		log.iniciaAvaliacao("...setarValores1");
		DetalheMonitorizacaoPTInjetDTO retorno = new DetalheMonitorizacaoPTInjetDTO();
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();

		// Filtro deve ser inicializado com os valores corretos a serem
		// calculaods
		filtro.setDtReferencia(dtReferencia);

		IndicadoresDoDetalheRN iRN = new IndicadoresDoDetalheRN(this.rn.getDao(), log, omcfg, listadwConsolid,
				false /* isRecuperarListaProdutos */, false /* isRecuperarListaOperadores */,
				false /* isRecuperarListaAlertas */, false /* isRecuperarListaPerdas */,
				false /* isRecuperarListaResumoDatas */, false /* isRecuperarListaResumoTurnos */, retorno, filtro);

		log.mostrarAvaliacaoCompleta();

		log.iniciaAvaliacao("...setarValores2");

		iRN.setResumoIndicadores();

		indice_refugo = retorno.getIndiceRefugos();
		indice_parada = retorno.getIndiceParadas();
		indice_acur = retorno.getIndiceCavAtivas();
		indice_OEE = retorno.getProdutividadeOEE();
		eficienciaRealizacao = retorno.getEfiRealizacao();

		cicloPadrao = retorno.getCiclosCicPadrao(); // dwConsol.getSegAutoCiclopadrao().doubleValue();
		cicloMedio = retorno.getCiclosCicMedio(); // getCicloMedio();
		eficienciaCiclomedio = retorno.getCiclosEficienciaCic();

		indice_producao = getIndiceProducao();
		if (dwRt.getSegUltimociclo() != null)
			eficienciaUltimoCiclo = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(cicloPadrao), dwRt.getSegUltimociclo()).doubleValue(); // getEficienciaUltimoCiclo()
		else
			eficienciaUltimoCiclo = 0d;

		/* Calculo do indice de defeito qtTotalDefeitos / qtTotalTeste * 100 */
		indiceDefeito = retorno.getIndiceDefeito();

		producaoLiquida = retorno.getQtdPecasBoas();
		producaoRefugada = retorno.getQtdRefugadas();
		producaoBruta = retorno.getQtdProduzida();
		log.mostrarAvaliacaoCompleta();
	}

	private void setarValoresNoObjeto(ObjRtMonitorizacaoDTO objRtDTOItem, boolean isTurnoAtual) {
		objRtDTOItem.setEfiRealizacao(eficienciaRealizacao.doubleValue());
		objRtDTOItem.setEfiCiclos(eficienciaCiclomedio.doubleValue());
		objRtDTOItem.setIndiceRefugos(indice_refugo.doubleValue());
		objRtDTOItem.setIndiceProducao(indice_producao.doubleValue());
		objRtDTOItem.setIndiceParadas(indice_parada.doubleValue());
		objRtDTOItem.setProdutividadeOEE(indice_OEE.doubleValue());
		objRtDTOItem.setIndiceCavAtivas(indice_acur.doubleValue());

		// Defeito #6508 - InjetWeb: Tela de monitoramento do web está exibindo dados de indicadores diferentes do injet
		if (isTurnoAtual) { 
			objRtDTOItem.setEfiInstantanea(eficienciaUltimoCiclo.doubleValue());
		} else {
			objRtDTOItem.setEfiInstantanea(0d);
		}

		if (indiceDefeito != null)
			objRtDTOItem.setIndiceDefeito(indiceDefeito.doubleValue());
		else
			objRtDTOItem.setIndiceDefeito(0d);
	}

	private Double getIndiceProducao() {
		if (dwRt.getPcsProducaoliquidaOp() == null || dwRt.getPcsProducaoplanejadaOp() == null) {
			return 0d;

		}
		return FormulasInjet
				.calcularIndiceProducaoDaOP(dwRt.getPcsProducaoliquidaOp(), dwRt.getPcsProducaoplanejadaOp())
				.doubleValue();
	}

	private String diferencaEmHoras(Date dataInicial, Date dataFinal) {
		StringBuilder data = new StringBuilder();

		long diferenca = dataFinal.getTime() - dataInicial.getTime();
		long diferencaEmHoras = (diferenca / 1000) / 60 / 60;
		long minutosRestantes = (diferenca / 1000) / 60 % 60;
		long segundosRestantes = (diferenca / 1000) % (60);

		data.append(diferencaEmHoras < 10 ? "0" + diferencaEmHoras + ":" : diferencaEmHoras + ":");
		data.append(minutosRestantes < 10 ? "0" + minutosRestantes + ":" : minutosRestantes + ":");
		data.append(segundosRestantes < 10 ? "0" + segundosRestantes : segundosRestantes);

		return data.toString();
	}

	public void executar(
			IdwLogger log, 
			ObjRtMonitorizacaoDTO retorno, 
			DwConsolidTemplate.TpId tpId, 
			RtFolhaDTO rtf, 
			OmCfg omCfg, 
			MonitorizacaoInjetRN rn, 
			boolean isTurnoAtual, 
			Integer filtroOp) {

		


		DiversosInjetRN rnIj = new DiversosInjetRN(rn.getDao());
		CfgParamConcOP confGeralInjet = rnIj.getParamConcOP();

		boolean isPrevistasPelasCavTotais = false;

		if (IdwFacade.IS_IDW_ATIVO == false) {
			isPrevistasPelasCavTotais = ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais(); 
		}

		this.dwRt = rtf.getRt();
		this.rnI = rn;


		retorno.setTemOperador((dwRt.getIsOperador() != null) && dwRt.getIsOperador().booleanValue());

		// setar os valores do Turno
		retorno.setCdTurno(dwRt.getDwTurno().getCdTurno());
		retorno.setDsTurno(dwRt.getDwTurno().getDsTurno());
		retorno.setIdTurno(dwRt.getDwTurno().getIdTurno());

		retorno.setTipoAlgoritmo(ObjRtMonitorizacaoDTO.ALG_INJET);

		// verifica se o item possui configuracao
		// se tiver trata o item, senao retorna;
		if (retorno.isTemOmCfg() == false) {
			retorno.setOffline(true);
			retorno.setParada(true);
		}

		OmPtDAO omPtDAO = new OmPtDAO(rnI.getDaoSession());
		OmPt ompt = omPtDAO.getOmPtAtivoComUltimaRevisaoInjet(rnI.getDao(), retorno.getCdPt());

		/*
		int p = 0;
		if (ompt.getCdPt().equals("INJ_off_5526")){
			p=0;
		}	
		*/
		
		
		retorno.setIdtppt(1l); // 1 = maq ciclica

		// Se tiver informacao em tempo real e nao estiver offline, tratar o item
		if (retorno.isTemDwRt() && dwRt.getIsOffline() != null && dwRt.getIsOffline() == false) {
			log.iniciaAvaliacao("buscarDwConsolid");
			listadwConsolid = buscarDwConsolidInjet(ompt, tpId, filtroOp);
			log.mostrarAvaliacaoCompleta();

			log.iniciaAvaliacao("setarValores");
			setarValoresInjet(log, omCfg, dwRt.getDtReferencia(), isTurnoAtual);
			log.mostrarAvaliacaoCompleta();

			log.iniciaAvaliacao("setarValoresNoObjeto");
			setarValoresNoObjeto(retorno, isTurnoAtual);
			log.mostrarAvaliacaoCompleta();

			if (listadwConsolid.size() == 0) {
				// zerar indice de producao - compatibilidade com tm do injet (Defeito #6508)
				retorno.setIndiceProducao(0d);
			}

			log.iniciaAvaliacao("setarFlags");
			setarFlags(log, isTurnoAtual, retorno, omCfg, confGeralInjet, ompt, listadwConsolid);
			log.mostrarAvaliacaoCompleta();

			// Alessandre: Em 23-5-13 se nao existir um dwconsolid para dwrt
			// eh pq nao tem cp carregada, assim acrescentei o if abaixo
			log.iniciaAvaliacao("iniciando varios atributos de retorno");
			if (listadwConsolid.isEmpty() == false) {
				retorno.setCdCp(listadwConsolid.get(0).getPpCp().getCdCp());

				// aqui pegar todos os produtos que vao aparecer na tooltip do icon
				String complemento = "";
				if (retorno.getCdProduto() == null) {
					retorno.setCdProduto("");
					retorno.setDsProduto("");
				}
				for (PpCpproduto ppcpproduto : listadwConsolid.get(0).getPpCp().getPpCpprodutos()) {
					retorno.setCdProduto(retorno.getCdProduto() + complemento + ppcpproduto.getOmProduto().getCdProduto());
					retorno.setDsProduto(retorno.getDsProduto() + complemento + ppcpproduto.getOmProduto().getDsProduto());
					complemento = "\n";
				}

				if (listadwConsolid.get(0).getOmPt().getIndOee() != null) {
					retorno.setIndOEE(listadwConsolid.get(0).getOmPt().getIndOee().doubleValue());
				}

				DwFolha dwfolha = listadwConsolid.get(0).getDwFolha();

				retorno.setCdFolha(dwfolha.getCdFolha());
				retorno.setDsFolha(dwfolha.getDsFolha());

				retorno.setProducaoLiquida(producaoLiquida);
				retorno.setProducaoBruta(producaoBruta);
				retorno.setProducaoRefugada(producaoRefugada);

				BigDecimal segAutoTempoativo = BigDecimal.ZERO;
				BigDecimal cicloPadrao = BigDecimal.ZERO;
				BigDecimal cavAtiva = BigDecimal.ONE;
				BigDecimal segTempoParadaCP = BigDecimal.ZERO;
				BigDecimal fatorContagem = BigDecimal.ONE;

				DwConsolid dwconsolid = listadwConsolid.get(0);
				DwConsol dwconsol = dwconsolid.getDwConsols().iterator().next();

				if (dwconsol.getSegAutoTempoativo() != null) {
					segAutoTempoativo = dwconsol.getSegAutoTempoativo();
				}

				if (dwconsol.getSegAutoTempoparadaCp() != null) {
					segTempoParadaCP = dwconsol.getSegAutoTempoparadaCp();
				}

				if (dwconsolid.getDwFolha().getSegCiclopadrao() != null) {
					cicloPadrao = dwconsolid.getDwFolha().getSegCiclopadrao();
				}

				try {
					cavAtiva = dwconsol.getQtAutoCavativas();
				} catch (NoSuchElementException e) {
					cavAtiva = BigDecimal.ONE;
				}

				fatorContagem = rtf.getFolha().getQtFatorcontagem();

				BigDecimal metaInstatanea = FormulasInjet.calcularProducaoPrevista(segAutoTempoativo, cicloPadrao, cavAtiva, fatorContagem, ompt.getIndOee()).setScale(0, BigDecimal.ROUND_FLOOR);;

				if(isPrevistasPelasCavTotais) {
					metaInstatanea = FormulasInjet.calcularProducaoPrevista(segAutoTempoativo, cicloPadrao, dwconsol.getQtAutoCavtotal(), fatorContagem, ompt.getIndOee()).setScale(0, BigDecimal.ROUND_FLOOR);;
				}

				retorno.setMetaInstatanea(metaInstatanea.doubleValue());

				retorno.setSegCicloPadrao(cicloPadrao.doubleValue());
				retorno.setSegTempoAtivo(segAutoTempoativo.intValue());
				retorno.setSegTempoParadaCP(segTempoParadaCP.intValue());

				if (dwRt.getSegUltimociclo() != null)
					retorno.setSegUltimoCiclo(dwRt.getSegUltimociclo().doubleValue());

				retorno.setSegCicloMedio(cicloMedio);

				if (listadwConsolid != null && listadwConsolid.isEmpty() == false) {

					if (listadwConsolid.get(0).getPpCp() != null) {

						if (listadwConsolid.get(0).getPpCp().getPpCpprodutos() != null) {

							BigDecimal ultimaOpProducaoPlanejada = BigDecimal.ZERO;
							BigDecimal ultimaOpProducaoBruta = BigDecimal.ZERO;
							BigDecimal ultimaOpProducaoRefugada = BigDecimal.ZERO;
							BigDecimal ultimaOpProducaoLiquida = BigDecimal.ZERO;
							BigDecimal ultimaOpSaldoAProduzir = BigDecimal.ZERO;

							for (PpCpproduto ppCpProduto : listadwConsolid.get(0).getPpCp().getPpCpprodutos()) {
								retorno.setUltimaOp(ppCpProduto.getNrDoc());

								if (ppCpProduto.getPcsProducaoplanejada() != null)
									ultimaOpProducaoPlanejada = ultimaOpProducaoPlanejada.add(ppCpProduto.getPcsProducaoplanejada());
								if (ppCpProduto.getPcsProducaorefugada() != null)
									ultimaOpProducaoRefugada = ultimaOpProducaoRefugada.add(ppCpProduto.getPcsProducaorefugada());
								if (ppCpProduto.getPcsProducaobruta() != null)
									ultimaOpProducaoBruta = ultimaOpProducaoBruta.add(ppCpProduto.getPcsProducaobruta());
							}
							ultimaOpProducaoLiquida = ultimaOpProducaoBruta.subtract(ultimaOpProducaoRefugada);
							ultimaOpSaldoAProduzir = ultimaOpProducaoPlanejada.subtract(ultimaOpProducaoLiquida);

							retorno.setUltimaOpProducaoPlanejada(ultimaOpProducaoPlanejada.doubleValue());
							retorno.setUltimaOpProducaoRefugada(ultimaOpProducaoRefugada.doubleValue());
							retorno.setUltimaOpProducaoLiquida(ultimaOpProducaoLiquida.doubleValue());
							retorno.setUltimaOpSaldoAProduzir(ultimaOpSaldoAProduzir.doubleValue());
						}

						// FIXME: necessário identificar de algum modo a folha que está
						// em uso; provavelmente incluir id_folha em dw_rt. No momento a
						// propriedade UltimoMolde de objRtDTOItem não está sendo usada.
						if (listadwConsolid.get(0).getDwFolha() != null) {
							if (listadwConsolid.get(0).getDwFolha().getDwFolharaps() != null) {
								for (DwFolharap dwFolhaRap : listadwConsolid.get(0).getDwFolha().getDwFolharaps()) {
									if (dwFolhaRap.getDwRap() != null) {
										retorno.setUltimoMolde(dwFolhaRap.getDwRap().getCdRap());
										break;
									}
								}
							}
						}

					}
				} else {
					retorno.setUltimaOp("");
					retorno.setUltimoMolde("");
				}

			} else {
				retorno.setCdCp("");
				retorno.setCdProduto("");
				retorno.setDsProduto("");
				retorno.setCdFolha("");
				retorno.setDsFolha("");

				if (rtf.getFolha().getDwFolharaps().size() > 0) {
					DwFolharapcom rapCom = rtf.getFolha().getDwFolharaps().iterator().next().getDwFolharapcoms().iterator().next();
					retorno.setIndiceCavAtivas(FormulasInjet.calcularIndicePcsPorCicloAtivas(rapCom.getQtTotal(), rapCom.getQtAtiva()).doubleValue());
				}
			}
			log.mostrarAvaliacaoCompleta();

			// Se estiver sem planejamento entao inicializa ultima parada com a parada completa
			if (retorno.isTemPlanejamento() == false) {
				log.iniciaAvaliacao("setarValoresSemMolde");
				setarValoresSemMolde(retorno, dwRt);

				// atribui indicadores zerados (comportamento do Injet)
				retorno.setEfiRealizacao(0d);
				retorno.setEfiCiclos(0d);
				retorno.setEfiInstantanea(0d);
				retorno.setIndiceRefugos(0d);
				retorno.setIndiceParadas(0d);
				retorno.setIndiceProducao(0d);
				retorno.setIndiceCavAtivas(0d);
				retorno.setProdutividadeOEE(0d);

				log.mostrarAvaliacaoCompleta();
			}
		}		
	}

	private List<DwConsolid> buscarDwConsolidInjet(OmPt ompt, DwConsolidTemplate.TpId tpId, Integer filtroOP) {
		List<DwConsolid> retorno = null;

		if (dwRt.getPpCp() != null)
		{
			// Se for acumulado, nao usa data de referencia, nem o turno
			if (DwConsolidTemplate.TpId.ACUMULADO.equals(tpId) || filtroOP.equals(2)) {
				retorno = rnI.getDwConsolidPorDt(ompt, dwRt.getPpCp(), dwRt, null, null);
			} else {
				if (filtroOP.equals(0)) {
					retorno = rnI.getDwConsolidPorDt(ompt, dwRt.getPpCp(), dwRt, dwRt.getDtReferencia(), dwRt.getDwTurno());
				} else {
					retorno = rnI.getDwConsolidPorDt(ompt, null, dwRt, dwRt.getDtReferencia(), dwRt.getDwTurno());
				}					
			}			
		} else {
			retorno = new ArrayList<DwConsolid>();
		}

		return retorno;
	}

	/*
	 * Inicializar Valores que serão utilizados em todo o Algoritmo
	 */
	private void setarValoresInjet(IdwLogger log, OmCfg omcfg, Date dtReferencia, boolean isTurnoAtual) {

		log.iniciaAvaliacao("...setarValores1");
		DetalheMonitorizacaoPTInjetDTO retorno = new DetalheMonitorizacaoPTInjetDTO();
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();

		// Filtro deve ser inicializado com os valores corretos a serem
		// calculaods
		filtro.setDtReferencia(dtReferencia);

		DAOGenerico dao = new DAOGenerico();
		dao.iniciaSessao();

		IndicadoresDoDetalheRN iRN = new IndicadoresDoDetalheRN(dao, log, omcfg, listadwConsolid,
				false /* isRecuperarListaProdutos */, false /* isRecuperarListaOperadores */,
				false /* isRecuperarListaAlertas */, false /* isRecuperarListaPerdas */,
				false /* isRecuperarListaResumoDatas */, false /* isRecuperarListaResumoTurnos */, retorno, filtro);

		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("...setarValores2");

		iRN.setResumoIndicadores();

		indice_refugo = retorno.getIndiceRefugos();
		indice_parada = retorno.getIndiceParadas();
		indice_acur = retorno.getIndiceCavAtivas();
		indice_OEE = retorno.getProdutividadeOEE();
		eficienciaRealizacao = retorno.getEfiRealizacao();

		cicloPadrao = retorno.getCiclosCicPadrao(); 
		cicloMedio = retorno.getCiclosCicMedio(); 
		eficienciaCiclomedio = retorno.getCiclosEficienciaCic();

		indice_producao = getIndiceProducao();
		
		/*
		int i=0;
		if(retorno.getOmPt().getCdPt().equals("INJ_off_5526")){
			i=1;
		}
		*/

		// efi instantanea
		eficienciaUltimoCiclo = 0d;
		if (dwRt.getSegUltimociclo() != null)
		{			
			if (dwRt.getStFuncionamento() == StFuncionamento.PRODUZINDO.getId()) {
				eficienciaUltimoCiclo = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(cicloPadrao), dwRt.getSegUltimociclo()).doubleValue(); 	
			}
		}

		producaoLiquida = retorno.getQtdPecasBoas();
		producaoRefugada = retorno.getQtdRefugadas();
		producaoBruta = retorno.getQtdProduzida();
		log.mostrarAvaliacaoCompleta();

		dao.finalizaSessao();
	}



	//WEB - Injet - V2 (node)
	@Override
	public void executar(
			IdwLogger log, 
			ObjRtMonitorizacaoDTO retorno, 
			DwConsolidTemplate.TpId tpId, 
			RtFolhaDTO rtf, 
			OmCfg omCfg, 
			MonitorizacaoInjetV2RN rn, 
			boolean isTurnoAtual, 
			Integer filtroOp) {


		// Alessandre trecho comentado abaixo pois esta sem uso apenas consumindo recurso
//		DiversosInjetRN rnIj = new DiversosInjetRN(rn.getDao());  sem uso
//		CfgParamConcOP confGeralInjet = rnIj.getParamConcOP(); sem uso

//		boolean isPrevistasPelasCavTotais = false; // sem uso

//		if (IdwFacade.IS_IDW_ATIVO == false) {
//			isPrevistasPelasCavTotais = ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais(); 
//		}

//		this.rnIV2 = rn;




		retorno.setTipoAlgoritmo(ObjRtMonitorizacaoDTO.ALG_INJET);

		// verifica se o item possui configuracao
		// se tiver trata o item, senao retorna;
		if (retorno.isTemOmCfg() == false) {
			retorno.setOffline(true);
			retorno.setParada(true);
		}

//		OmPtDAO omPtDAO = new OmPtDAO(rnIV2.getDaoSession());
//		OmPt ompt = omPtDAO.getOmPtAtivoComUltimaRevisaoInjet(rnIV2.getDao(), retorno.getCdPt());

		retorno.setIdtppt(1l); // 1 = maq ciclica


		// Se tiver informacao em tempo real e nao estiver offline, tratar o item

		//set valores injet - setarValoresInjet - 202005
		indice_refugo = new Double(0L);
		indice_parada = new Double(0L);
		indice_acur = new Double(0L);
		indice_OEE =new Double(0L);//99L
		eficienciaRealizacao =new Double(0L);
		cicloPadrao = new Double(0L); 
		cicloMedio = new Double(0L); 
		eficienciaCiclomedio = new Double(0L);
		indice_producao =new Double(0L);
		// efi instantanea
		eficienciaUltimoCiclo = new Double(0L); 	
		producaoLiquida = new Double(0L);//300L
		producaoRefugada = new Double(0L);
		producaoBruta = new Double(0L);
		// set valores obj - setarValoresNoObjeto - 202005
		setarValoresNoObjeto(retorno, isTurnoAtual);
		retorno.setIndiceProducao(0d);
		// set flags - setarFlags - 202005

		// set outros - 202005
		retorno.setCdCp("");
		retorno.setCdProduto("");
		retorno.setDsProduto("");		
		retorno.setIndOEE(0d);
		// atribui indicadores zerados (comportamento do Injet)
		retorno.setEfiRealizacao(0d);//99d
		retorno.setEfiCiclos(0d);
		retorno.setEfiInstantanea(0d);
		retorno.setIndiceRefugos(0d);
		retorno.setIndiceParadas(0d);
		retorno.setIndiceProducao(0d);
		retorno.setIndiceCavAtivas(0d);
		retorno.setProdutividadeOEE(0d);
		retorno.setCdFolha("");
		retorno.setDsFolha("");
		retorno.setProducaoLiquida(producaoLiquida);
		retorno.setProducaoBruta(producaoBruta);
		retorno.setProducaoRefugada(producaoRefugada);
		retorno.setMetaInstatanea(0d);
		retorno.setSegCicloPadrao(cicloPadrao.doubleValue());
		retorno.setSegTempoAtivo(0);
		retorno.setSegTempoParadaCP(0);
		retorno.setSegUltimoCiclo(0d);
		retorno.setSegCicloMedio(cicloMedio);
		// Verificando se a maquina esta dentro da meta
		retorno.setDentroDaMeta(false);
		
		
		/*
		int i=0;
		if(ompt.getCdPt().equals("INJ_off_5526")){
			i=1;
		}		
		*/
		
		retorno.setParadaComPeso(false);
		retorno.setTemPlanejamento(false);
		retorno.setComAlerta(false);
		retorno.setParada(false);
		retorno.setConsolidacaoPendente(false);//oxe
		retorno.setTemOperador(false);//oxe

		retorno.setOffline(true);
		retorno.setParada(false);
		retorno.setParadaComPeso(false);
		retorno.setParadaExtrapolada(false);
		retorno.setParadaManutencao(false);
		retorno.setParadaNaoInformada(false);
		retorno.setParadaSemPesoEfic(false);
		retorno.setTemPlanejamento(false);//oxe


	}	

}
