package idw.model.rn.integracao.arquivotexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.OmObjDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmTppt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.OmJobdetlogTemplate;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.GTRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.integracao.erp.OpIntegracaoDTO;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CpDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.PtDTO;
import ms.util.UtilsThreads;

public class IntegracaoOPRN {

	private OmJobdetlog detlog = new OmJobdetlog();
	private DAOGenerico daoP;

	public enum _ResultadoIntegracao {
		ERRO(0), SUCESSO(1), SUCESSO_COM_ADVERTENCIA(2);

		private final int value;

		_ResultadoIntegracao(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	/*
	 * Metodo principal que importa a op do arquivo texto para a base
	 */
	public int integrarOP(OmJoblog omjoblog, OmJobdet det, String arquivo, DAOGenerico dao, IdwLogger log, int idLog) {
		int retorno = _ResultadoIntegracao.SUCESSO.getValue();

		this.daoP = dao;

		detlog.setDthrIexecucao(DataHoraRN.getDataHoraAtual());
		detlog.setIdJobdetlog(null);
		detlog.setOmJobdet(det);
		detlog.setOmJoblog(omjoblog);
		detlog.setStExecucao(OmJobdetlogTemplate._StExecucao.SUCESSO.getValue());

		String dthrCriacao = DataHoraRN.dateToStringYYYYMMDDHHMMSS(ArquivosDiretorios.getDtHrModificacao(arquivo));

		detlog.setUrlOrigem(arquivo + dthrCriacao);

		/*
		 * Ler o arquivo para incluir na base
		 * 
		 */
		File arqleitura = null;
		arqleitura = new File(arquivo);
		if (arqleitura.exists()) {
			int resultado = lerArquivo(arqleitura, log, idLog);
			if (resultado == 1) {// sucesso
				detlog.setDsExecucao("Importação OP ok do arquivo " + arquivo);
				retorno = _ResultadoIntegracao.SUCESSO.getValue();
			} else if (resultado == -1) {
				detlog.setDsExecucao("Arquivo OP não existe. " + arquivo);
				detlog.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
				retorno = _ResultadoIntegracao.ERRO.getValue();
			} else if (resultado == -2) {
				detlog.setDsExecucao("Erro de leitura do arquivo OP. " + arquivo);
				detlog.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
				retorno = _ResultadoIntegracao.ERRO.getValue();
			} else if (resultado == -3) {
				retorno = _ResultadoIntegracao.SUCESSO_COM_ADVERTENCIA.getValue();
				detlog.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
			} else {
				if (resultado == 2)
					detlog.setDsExecucao("Importação OP com advertências para o arquivo " + arquivo);
				else
					detlog.setDsExecucao("Erro OP nro " + resultado);
				retorno = _ResultadoIntegracao.ERRO.getValue();
				detlog.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
			}
		} else {
			detlog.setDsExecucao("Arquivo OP não existe. " + arquivo);
			retorno = _ResultadoIntegracao.ERRO.getValue();
		}
		detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
		dao.makePersistent(detlog);

		return retorno;
	}

	/*
	 * Ler arquivo texto e transforma em OpIntegarcaoDTO
	 * 
	 */
	private int lerArquivo(File arquivo, IdwLogger log, int idLog) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			return -1;
		}
		String linha = null;
		List<OpIntegracaoDTO> ops = new ArrayList<>();

		try {
			while ((linha = br.readLine()) != null) {
				LinhaArquivoOP op = new LinhaArquivoOP(linha);
				OpIntegracaoDTO dto = op.getOpIntegracaoDTO();
				ops.add(dto);
				log.info(idLog, 0, "Leu do txt op " + dto.getNrop());
				if (dto.getPostos() != null && dto.getPostos().isEmpty() == false) {
					for (PtDTO ptdto : dto.getPostos()) {
						log.info(idLog, 5, "Definido para posto " + ptdto.getPt().getCdPt());
					}
				} else {
					log.info(idLog, 5, "Sem postos definidos");
				}
				if (dto.getProdutos() != null && dto.getProdutos().isEmpty() == false) {
					for (ProdutoDTO prodto : dto.getProdutos()) {
						log.info(idLog, 5, "Definido produto " + prodto.getProduto().getCdProduto());
					}
				} else {
					log.info(idLog, 5, "Sem produtos definidos");
				}
			}
		} catch (IOException e) {
			return -2; // nao mudar o log
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}

		// Chama RN para salvar a op
		int retorno = salvar(ops, log, idLog);

		return retorno;
	}

	/*
	 * Envia as dtos com as ops para o banco de dados
	 * 
	 */
	private int salvar(List<OpIntegracaoDTO> ops, IdwLogger log, int idLog) {
		Map<String, ListaCPDTO> listacpdto = new HashMap<>();

		GTRN gtrn = new GTRN();
		gtrn.setDao(daoP);
		gtrn.setSessionStateless(daoP.getSessionStateless());

		OmObjDAO orn = new OmObjDAO(daoP.getSessionStateless());
		
		CpRN cprn = new CpRN(daoP);
		FolhaRN frn = new FolhaRN(daoP);
		ProdutoRN prn = new ProdutoRN(daoP);
		
		OmCfg omcfg = Util.getConfigGeral(daoP.getSessionStateless());

		int retorno = _ResultadoIntegracao.SUCESSO.getValue();

		// Apenas as OPs que tiverem PTs definidos serao importados
		for (OpIntegracaoDTO dto : ops) {
			int contador = 1;
			if (dto.getGrupos() != null && dto.getGrupos().isEmpty() == false) {
				for (OmGt omgtAux : dto.getGrupos()) {

					// Pesquisar GT pelo de para
					OmGt omgt = gtrn.getOmGtByDepara(omgtAux.getDepara());

					if (omgt == null) {
						// Gerar um novo log para cada OP importada
						OmJobdetlog detlogop = new OmJobdetlog();
						detlogop.setDthrIexecucao(detlog.getDthrIexecucao());
						detlogop.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
						detlogop.setIdJobdetlog(null);
						detlogop.setOmJobdet(detlog.getOmJobdet());
						detlogop.setOmJoblog(detlog.getOmJoblog());
						detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
						detlogop.setDsExecucao("GT desconhecido " + omgtAux.getDepara() + " para OP " + dto.getNrop());
						detlogop.setUrlOrigem(detlog.getUrlOrigem());
						daoP.makePersistent(detlogop);
						retorno = _ResultadoIntegracao.ERRO.getValue();

						log.info(idLog, 0, detlogop.getDsExecucao());
						continue;
					}
					
					/* obter os objs do gt */
					List<OmObj> objs = orn.pesquisarOmObsByOmGt(omgt);
					for (OmObj omobj : objs) {
						if (omobj.getOmPt() != null) {
							/*
							 * Antes de incluir verificar se ja existe a OP no cadastro
							 * 
							 */
							log.info(idLog, 0, "Vou pesquisar ppcp para op=" + dto.getNrop() + " pt=" + omobj.getOmPt().getCdPt());
							PpCp ppcp = cprn.pesquisarPpCpByNrDocCdPt(dto.getNrop(), omobj.getOmPt().getCdPt());
							log.info(idLog, 0, "Pesquisando ppcp para op " + dto.getNrop() + " para pt " + omobj.getOmPt().getCdPt() + " encontrou? " + (ppcp != null));
							if (ppcp != null) {
								/*
								 * Se a OP ainda nao foi iniciada, verificar se o produto / producao planejada mudaram Se sim, entao
								 * atualizar esses dados
								 */
								String cdProdutoAnterior = "";
								BigDecimal producaoPlanejadaAnterior = null;
								
								String cdProduto = "";
								BigDecimal producaoPlanejada = null;
								for (ProdutoDTO produtodto : dto.getProdutos()) {
									cdProduto = produtodto.getProduto().getCdProduto();
									producaoPlanejada = produtodto.getAproduzir();
									log.info(idLog, 0, "Produto " + cdProduto + " PPlanejada=" + producaoPlanejada + " será incluida em ppcpproduto.");
								}
								// Estamos considerando apenas 1 produto por OP
								boolean isProdutoAlterado = false;
								boolean isProducaoPlanejadaAlterada = false;
								for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()) {
									// Pesquisa produto
									OmProduto omproduto = prn.getOmProduto(ppcpproduto.getOmProduto().getIdProduto());
									
									cdProdutoAnterior = omproduto.getCdProduto();
									producaoPlanejadaAnterior = ppcpproduto.getPcsProducaoplanejada();
									
									// Verificar se o produto ou a producao planejada foram alteradas
									if (omproduto.getCdProduto().equals(cdProduto) == false)
										isProdutoAlterado = true;
									if (ppcpproduto.getPcsProducaoplanejada().compareTo(producaoPlanejada) != 0)
										isProducaoPlanejadaAlterada = true;
								}
								for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()) {
									if (isProducaoPlanejadaAlterada) {
										/* Atualizar a producao planejada */
										ppcpproduto.setPcsProducaoplanejada(producaoPlanejada);
									}
									if (isProdutoAlterado) {
										// Pesquisar novo produto
										DwFolha dwfolha;
										dwfolha = encontrarFolhaOuIncluir(frn, omcfg, omobj, cdProduto, dto.getNrop(), log, idLog);
										if (dwfolha == null) {
											OmJobdetlog detlogop = new OmJobdetlog();
											detlogop.setDthrIexecucao(detlog.getDthrIexecucao());
											detlogop.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
											detlogop.setIdJobdetlog(null);
											detlogop.setOmJobdet(detlog.getOmJobdet());
											detlogop.setOmJoblog(detlog.getOmJoblog());
											detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
											detlogop.setDsExecucao("NAO encontrou folha para produto " + cdProduto + " para OP " + dto.getNrop() + " para PT " + ppcp.getOmPt().getCdPt() + " op permanece com produto original.");
											detlogop.setUrlOrigem(detlog.getUrlOrigem());
											daoP.makePersistent(detlogop);
											retorno = _ResultadoIntegracao.ERRO.getValue();
											isProdutoAlterado = false;
											log.info(idLog, 0, detlogop.getDsExecucao());
											break;
										} else {
											ppcp.setDwFolha(dwfolha);
											
											// Alterar o produto em ppcpproduto
											OmProduto omproduto = null;
											try {
												DwFolhaiac iac = frn.getFolhaiac(dwfolha);
												omproduto = iac.getOmProduto();
											} catch (RegistroDesconhecidoException e) {
												omproduto = null;
											}
											
											if (omproduto != null) {
												ppcpproduto.setOmProduto(omproduto);
												daoP.makePersistent(ppcpproduto);
											}
											
											daoP.makePersistent(ppcp);
										}
									}
								}

								if (isProdutoAlterado || isProducaoPlanejadaAlterada) {
									OmJobdetlog detlogop = new OmJobdetlog();
									detlogop.setDthrIexecucao(detlog.getDthrIexecucao());
									detlogop.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
									detlogop.setIdJobdetlog(null);
									detlogop.setOmJobdet(detlog.getOmJobdet());
									detlogop.setOmJoblog(detlog.getOmJoblog());
									detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
									detlogop.setDsExecucao("OP " + dto.getNrop() + " atualizada para PT " + omobj.getOmPt().getCdPt() + " produto anterior=" + cdProdutoAnterior + " para " + cdProduto + " producao plan. ant=" + producaoPlanejadaAnterior + " para " + producaoPlanejada);
									detlogop.setUrlOrigem(detlog.getUrlOrigem());
									daoP.makePersistent(detlogop);
									retorno = _ResultadoIntegracao.ERRO.getValue();
									log.info(idLog, 0, detlogop.getDsExecucao());

								} else {
									/*
									 * Se continua o mesmo produto e producao entao criar o log abaixo
									 * 
									 */
									OmJobdetlog detlogop = new OmJobdetlog();
									detlogop.setDthrIexecucao(detlog.getDthrIexecucao());
									detlogop.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
									detlogop.setIdJobdetlog(null);
									detlogop.setOmJobdet(detlog.getOmJobdet());
									detlogop.setOmJoblog(detlog.getOmJoblog());
									detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
									detlogop.setDsExecucao("OP " + dto.getNrop() + " ja existe para PT " + omobj.getOmPt().getCdPt());
									detlogop.setUrlOrigem(detlog.getUrlOrigem());
									daoP.makePersistent(detlogop);
									retorno = _ResultadoIntegracao.ERRO.getValue();
									log.info(idLog, 0, detlogop.getDsExecucao());
									daoP.evict(ppcp);
								}

								// Apesar da OP já existir no banco comentei o continue abaixo para um novo ppcp ser gerado e entrar na
								// lista
								// isso pq na hora de salvar a RN ve que ja esta repetido e atualiza a producao planejada e as datas
								// Alessandre em 06-09-2017 voltei o continue pq esta consumindo muito recurso para na importacao da op
								// avaliar ser vai ter provlema acima
								continue;
							}

							// Uma nova OP será incluida
							ppcp = new PpCp();
							// Chamar a RN para inclusao das OPs
							ppcp.setCdCp(dto.getNrop() + contador);
							ppcp.setDthrInicio(dto.getDthrIplanejada());
							ppcp.setDthrFinal(dto.getDthrFplanejada());
							ppcp.setOmPt(omobj.getOmPt());
							ppcp.setOmUsrByIdUsrrevisao(IdwFacade.getInstancia().getConfiguracaoAtual().getOmUsrimpprog());
							ppcp.setOmUsrByIdUsrstativo(ppcp.getOmUsrByIdUsrrevisao());

							log.info(idLog, 0, "Novo PPCP com nrop=" + ppcp.getCdCp());
							
							String cdProduto = "";
							for (ProdutoDTO produtodto : dto.getProdutos()) {
								PpCpproduto cpproduto = new PpCpproduto();
								cpproduto.setNrDoc(dto.getNrop());
								OmProduto omproduto = new OmProduto();
								omproduto.setCdProduto(produtodto.getProduto().getCdProduto());
								cpproduto.setOmProduto(omproduto);
								cpproduto.setPcsProducaoplanejada(produtodto.getAproduzir());
								ppcp.getPpCpprodutos().add(cpproduto);
								cdProduto = omproduto.getCdProduto();
								log.info(idLog, 5, "usando produto "+omproduto.getCdProduto() + " para OP " + cpproduto.getNrDoc() );
							}

							// Localiza a folha, se não existir AVISAR NO LOG
							// que folha desconhecida
							DwFolha dwfolha;
							log.info(idLog, 0, "Pesquisando folha");
							dwfolha = encontrarFolhaOuIncluir(frn, omcfg, omobj, cdProduto, dto.getNrop(), log, idLog);

							if (dwfolha == null) {
								log.info(idLog, 0, "Folha não encontrada, incluindo omjobdetlog");
								OmJobdetlog detlogop = new OmJobdetlog();
								detlogop.setDthrIexecucao(detlog.getDthrIexecucao());
								detlogop.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
								detlogop.setIdJobdetlog(null);
								detlogop.setOmJobdet(detlog.getOmJobdet());
								detlogop.setOmJoblog(detlog.getOmJoblog());
								detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
								detlogop.setDsExecucao("Não foi possivel cadastrar a folha para produto " + cdProduto + " para OP " + dto.getNrop() + " para PT " + ppcp.getOmPt().getCdPt());
								detlogop.setUrlOrigem(detlog.getUrlOrigem());
								daoP.makePersistent(detlogop);
								retorno = _ResultadoIntegracao.ERRO.getValue();
								log.info(idLog, 0, detlogop.getDsExecucao());
								continue;
							}

							ppcp.setDwFolha(dwfolha);

							CpDTO cpdto = new CpDTO();
							cpdto.setCp(ppcp);

							ListaCPDTO cpdtomap = null;
							if (listacpdto.containsKey(dto.getNrop())) {
								cpdtomap = listacpdto.get(dto.getNrop());
							} else {
								cpdtomap = new ListaCPDTO();
								listacpdto.put(dto.getNrop(), cpdtomap);
							}

							cpdtomap.getListaCps().add(cpdto);

							contador++;
						}
						
						UtilsThreads.pausaNaThread(50);
					}
				}
			}
		}

		// Salvar ops
		try {
			if (listacpdto != null && listacpdto.isEmpty() == false) {

				for (String nrop : listacpdto.keySet()) {
					ListaCPDTO listasalvar = listacpdto.get(nrop);
					ListaCPDTO lista = cprn.salvarPpCpOrdemProducao(listasalvar);
					/*
					 * Gera log das ops salvas
					 * 
					 */
					for (CpDTO cpdto : lista.getListaCps()) {

						OmJobdetlog detlogop = new OmJobdetlog();
						detlogop.setDthrIexecucao(detlog.getDthrIexecucao());
						detlogop.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
						detlogop.setIdJobdetlog(null);
						detlogop.setOmJobdet(detlog.getOmJobdet());
						detlogop.setOmJoblog(detlog.getOmJoblog());
						if (cpdto.getResultadoDTO().getIdmensagem() == cpdto.getResultadoDTO().getCOM_SUCESSO()) {
							detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.SUCESSO.getValue());
							detlogop.setDsExecucao("OP " + cpdto.getCp().getNrop() + " para o posto " + cpdto.getCp().getOmPt().getCdPt() + " importada. Folha " + cpdto.getCp().getDwFolha().getCdFolha());
							if (retorno == _ResultadoIntegracao.ERRO.getValue())
								retorno = _ResultadoIntegracao.SUCESSO_COM_ADVERTENCIA.getValue();
						} else {
							detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.ERRO.getValue());
							detlogop.setDsExecucao("OP " + cpdto.getCp().getNrop() + " para o posto " + cpdto.getCp().getOmPt().getCdPt() + " com erro " + cpdto.getResultadoDTO().getDescricaoMensagem());
						}
						detlogop.setUrlOrigem(detlog.getUrlOrigem());
						log.info(idLog, 0, detlogop.getDsExecucao());
						daoP.makePersistent(detlogop);
					}
				}
			} else
				return -3;
		} catch (Exception e) {
			e.printStackTrace();
			return -3;
		}

		return retorno;
	}

	private DwFolha encontrarFolhaOuIncluir(FolhaRN frn, OmCfg omcfg, OmObj omobj, String cdProduto, String nrop, IdwLogger log, int idLog) {
		DwFolha dwfolha;
		dwfolha = frn.pesquisarDwFolhaByCdProduto(cdProduto, omobj.getOmPt().getCdPt());

		// se nao exitir incluir uma nova
		if (dwfolha == null) {
			// se nao existe a folha entao vou criar uma
			dwfolha = new DwFolha();
			dwfolha.setIdFolha(null);
			
			OmTppt omtppt = daoP.findById(OmTppt.class, omobj.getOmPt().getOmTppt().getIdTppt(), false);
			
			dwfolha.setCdFolha(cdProduto + "-" + omtppt.getCdTppt());
			dwfolha.setDtRevisao(DataHoraRN.getDataHoraAtual());
			dwfolha.setDtStativo(DataHoraRN.getDataHoraAtual());
			if (omobj.getOmPt().getOmGt() != null)
				dwfolha.setOmGt(omobj.getOmPt().getOmGt());
			else
				dwfolha.setOmGt(omcfg.getOmGtimpcic());
			dwfolha.setOmTppt(omobj.getOmPt().getOmTppt());
			dwfolha.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			dwfolha.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
			dwfolha.setRevisao(1l);
			dwfolha.setSegCiclominimo(new BigDecimal(0));
			dwfolha.setSegCiclopadrao(new BigDecimal(60));
			dwfolha.setSegCiclotimeout(new BigDecimal(200));
			dwfolha.setSegSetup(3600);
			dwfolha.setStAtivo((byte) 1);
			dwfolha.setTpFolha((byte) 6); // Por enquanto o
											// tipo criado
											// eh Programa
											// IAC

			// Incluir em dwfolhaiac o produto com a
			// producao por ciclo = 1
			ProdutoRN pRN = new ProdutoRN(daoP);
			OmProduto omproduto;
			try {
				omproduto = pRN.getOmProduto(cdProduto.trim());
			} catch (RegistroDesconhecidoException e1) {
				omproduto =  null;
			}
			if (omproduto == null) {
				omproduto = new OmProduto();
				omproduto.setCdProduto(cdProduto.trim());
				omproduto.setDsProduto("Incluido automaticamente integracao OP " + nrop);
				omproduto.setDtRevisao(DataHoraRN.getDataHoraAtual());
				omproduto.setDtStativo(DataHoraRN.getDataHoraAtual());
				omproduto.setRevisao(1l);
				omproduto.setTpProduto((byte) 3); // Semiacabado
				omproduto.setTpProducao(BigDecimal.ZERO);
				omproduto.setStAtivo((byte) 1);
				omproduto.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
				omproduto.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				daoP.makePersistent(omproduto);
			}
			dwfolha.setDsFolha("Cadastro automático:" + omproduto.getCdProduto());

			DwFolhaiac dwfolhaiac = new DwFolhaiac();
			dwfolhaiac.setIdFolhaiac(null);
			dwfolhaiac.setDwFolha(dwfolha);
			dwfolhaiac.setOmPrg(null);
			dwfolhaiac.setOmProduto(omproduto);
			dwfolhaiac.setQtAtiva(BigDecimal.ONE);
			dwfolhaiac.setQtMpporciclo(null);

			dwfolha.setDwFolhaiacs(new HashSet<DwFolhaiac>());
			dwfolha.getDwFolhaiacs().add(dwfolhaiac);

			OmJobdetlog detlogop = new OmJobdetlog();
			detlogop.setDthrIexecucao(detlog.getDthrIexecucao());
			detlogop.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
			detlogop.setIdJobdetlog(null);
			detlogop.setOmJobdet(detlog.getOmJobdet());
			detlogop.setOmJoblog(detlog.getOmJoblog());
			detlogop.setStExecucao(OmJobdetlogTemplate._StExecucao.SUCESSO.getValue());
			detlogop.setDsExecucao("Cadastrando folha " + dwfolha.getCdFolha() + " para tipo posto " + omtppt.getCdTppt());
			detlogop.setUrlOrigem(detlog.getUrlOrigem());
			daoP.makePersistent(detlogop);

			log.info(idLog, 0, detlogop.getDsExecucao());
			
			try {
				dwfolha = daoP.makePersistent(dwfolha);
				log.info(idLog, 0, "Nova folha salva " + dwfolha.getCdFolha() + " com id " + dwfolha.getIdFolha());
				/* Como a sessao é stateless o dwfolhaiac nao foi salvo por cascade. Assim, salva individualmente e colocar em dwfolha
				 * 
				 */
				dwfolhaiac = daoP.makePersistent(dwfolhaiac);
				dwfolha.getDwFolhaiacs().add(dwfolhaiac);
				log.info(idLog, 5, "salvo tb dwfolhaiac com id " + dwfolhaiac.getIdFolhaiac());
			} catch (Exception e) {
				e.printStackTrace();
				dwfolha = null;
			}

		}
		return dwfolha;
	}
}
