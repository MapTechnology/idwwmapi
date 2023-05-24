package idw.model.rn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwPepro;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.apontamentoproducao.ProdutoAlteradoDTO;
import idw.model.rn.consolidacao.refugo.ConsolidacaoRefugoRN;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import injetws.model.excessoes.SemSGBDException;

public class ApontamentoRefugoRN extends ConsolidacaoRefugoRN {

	/*
	 * Esse metodo tem como objetivo salvar o apontamento manual em dwconsol e
	 * dwconsolpr
		 * 
	 */
	public void salvarApontamentoRefugo(DwConsolidDTOs dtos) {
										
		IdwLogger log = new IdwLogger("ApontamentoRefugoRN");
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0, "Iniciando apontamentoRefugo");
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		TurnoRN trn = new TurnoRN(getDao());
		
		List<PpCp> ppcps = new ArrayList<>();
		
		//compararRefugos(dtos, log, omcfg, trn, ppcps, false); // apenas alterar
		alterarOuIncluirRefugos(dtos, log, omcfg, trn, ppcps, false); // apenas alterar
		alterarOuIncluirRefugos(dtos, log, omcfg, trn, ppcps, true); // apenas incluir novos refugos
		
		// ALterar referencia da producao refugada nas ordens
		for (PpCp ppcp : ppcps) {
			alterarReferenciaDePpCp(ppcp);
		}
	}
	
	private void compararRefugos(DwConsolidDTOs dtos, IdwLogger log, OmCfg omcfg, TurnoRN trn, List<PpCp> ppcps, boolean isIncluir) {
		
		int contHoras = 0;
		int contDwConsolre = 0;
		int contDwConsolresocos = 0;
		int contProdutos = 0;
		
		PrintStream out;
		
		try {
			out = new PrintStream(new File("c://temp//LogPesquisa_Comparar.txt"));
			System.setOut(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (DwConsolidDTO idDTO : dtos.getListaDwConsolidDTO()) {
			
			for (DwConsolidDTO idHoraDTO : idDTO.getIdsHoraAHora()) {
				
				DwConsolid id = idHoraDTO.getDwConsolid();
				
				DwConsolpr dwconsolprClone = null;
				
				for (DwConsolpr dwconsolpr : id.getDwConsol().getDwConsolprs()) {
					dwconsolprClone = dwconsolpr.clone();
				}
				
				contHoras++; 
				
				//if (contHoras == 1) {
				System.out.println("##############################################################################################################################################################################");
				System.out.println("Hora                                                :" + StringUtils.leftPad(String.valueOf(contHoras),2,"0"));
				System.out.println("Produção Refugada Hora Auto                         :" + dwconsolprClone.getPcsAutoProducaorefugada());
				System.out.println("Produção Refugada Hora Manu                         :" + dwconsolprClone.getPcsManuProducaorefugada());
				System.out.println("Produção Refugada Hora Total                        :" + dwconsolprClone.getPcsAutoProducaorefugada().add(dwconsolprClone.getPcsManuProducaorefugada()));
				//}
				
				contDwConsolre = 0;
				
				for (DwConsol consol : id.getDwConsols()) {
					
					for (DwConsolre re : consol.getDwConsolres()) {
						
						contDwConsolre++;
					
						DwConsolre dwconsolreClone = re.clone();
						
						//if (dwconsolreClone.getIdConsolre() == 146829) {
						System.out.println("==============================================================================================================================================================================");
						System.out.println("contDwConsolre                                      :" + StringUtils.leftPad(String.valueOf(contDwConsolre),2,"0"));
						System.out.println("dwconsolreClone.getIdConsolre()                     :" + dwconsolreClone.getIdConsolre());
						System.out.println("dwconsolreClone.getDwTRefugo()                      :" + dwconsolreClone.getDwTRefugo().getCdTrefugo() + " - " + dwconsolreClone.getDwTRefugo().getDsTrefugo());				
						System.out.println("dwconsolreClone.getPcsAutoProducaorefugada()        :" + dwconsolreClone.getPcsAutoProducaorefugada());
						System.out.println("dwconsolreClone.getPcsManuProducaorefugada()        :" + dwconsolreClone.getPcsManuProducaorefugada());
						System.out.println("******************************************************************************************************************************************************************************");
						//}
						
						contDwConsolresocos = 0;
						
						for (DwConsolreoco reoco : re.getDwConsolreocos()) {
							
							DwConsolrelog relog = reoco.getDwConsolrelog();
							
							contDwConsolresocos++;
							
							//if (dwconsolreClone.getIdConsolre() == 146829) {
							System.out.println("contDwConsolresocos                                 :" + StringUtils.leftPad(String.valueOf(contDwConsolresocos),2,"0"));
							System.out.println("dwconsolreClone.getIdConsolre()                     :" + dwconsolreClone.getIdConsolre());
							System.out.println("oco.getDwConsolrelog().getPcsAutoProducaorefugada() :" + reoco.getDwConsolrelog().getPcsAutoProducaorefugada());
							System.out.println("oco.getDwConsolrelog().getPcsManuProducaorefugada() :" + reoco.getDwConsolrelog().getPcsManuProducaorefugada());
							System.out.println("******************************************************************************************************************************************************************************");
							//}
							
						}
						
						//if (dwconsolreClone.getIdConsolre() == 146829) {
						System.out.println("dwconsolreClone.getPcsAutoProducaorefugada()        :" + dwconsolreClone.getPcsAutoProducaorefugada());
						System.out.println("dwconsolreClone.getPcsManuProducaorefugada()        :" + dwconsolreClone.getPcsManuProducaorefugada());
							
						System.out.println("==============================================================================================================================================================================");
						System.out.println("");
						//}
						
					}
				
				}
			
				//if(contHoras == 1) {
				System.out.println("##############################################################################################################################################################################");			
				System.out.println("");
				//}
				
			}
		
		}
	
	}
	
	/* Esse metodo hora inclui hora altera os apontamentos de refugo
	 * 
	 */
	private void alterarOuIncluirRefugos(DwConsolidDTOs dtos, IdwLogger log, OmCfg omcfg, TurnoRN trn, List<PpCp> ppcps, boolean isIncluir) {
		
		for (DwConsolidDTO idDTO : dtos.getListaDwConsolidDTO()) {
			
			for (DwConsolidDTO idHoraDTO : idDTO.getIdsHoraAHora()) {
				
				DwConsolid id = idHoraDTO.getDwConsolid();
				
				if (ppcps.contains(id.getPpCp()) == false) {
					ppcps.add(id.getPpCp());
				}
				
				for (DwConsol consol : id.getDwConsols()) {
					
					for (DwConsolre re : consol.getDwConsolres()) {
						
						for (DwConsolreoco reoco : re.getDwConsolreocos()) {
							
							DwConsolrelog relog = reoco.getDwConsolrelog();
							// 1o Passo alterar os dwconsolrelog e incluir os
							// novos
							BigDecimal producaoRefugadaManu = relog.getPcsManuProducaorefugada();
							
							boolean isNovoRelog = relog.getIdConsolrelog() == 0l; 
							
							if (isNovoRelog == false) {
								// Se o metodo foi chamado para executar somente a inclusao de novos refugos entao nao se deve fazer nada
								if (isIncluir)
									continue;

								relog = getDao().findById(DwConsolrelog.class, relog.getIdConsolrelog(), true);
								// Se nao mudou nada entao passar pro proximo
								if (relog.getPcsManuProducaorefugada() != null && relog.getPcsManuProducaorefugada().equals(producaoRefugadaManu))
									continue;
								/* Alan: adicionado este trecho pois a validação de cima falha em vários momentos */
								if (relog.getPcsManuProducaorefugada() == null) {
									if((producaoRefugadaManu == null) || (producaoRefugadaManu.intValue() == 0))
										continue;
								}
								
								relog.setPcsManuProducaorefugada(producaoRefugadaManu);
							
							} else {
								// Se o metodo foi chamado para executar somente alterar refugos entao nao se deve
								if (isIncluir == false)
									continue;

								/* Como é um novo refugo, iremos chamar a consolidacao para novos refugos e essa consolidacação
								 * trabalha com o campo AUTO e não com o MANU.
								 */
								relog.setPcsAutoProducaorefugada(relog.getPcsManuProducaorefugada());
								relog.setPcsManuProducaorefugada(null);
								
								/* Como é inclusao de um novo refugo, podemmos ter as seguintes situações: a data e hora inicial pode
								 * ser menor que o inicio do turno. Nesse caso modificar a data e hora do refugo para inicio do turno
								 */
								if (DataHoraRN.before(relog.getDthrRefugo(), id.getDthrIturno()))
									relog.setDthrRefugo(id.getDthrIturno());
							
							}
							
							getDao().makePersistent(relog);
							
							if (isNovoRelog) {
							
								MsEvt msevt = new MsEvt();
								getDao().evict(msevt);
								msevt.setDthrEvento(relog.getDthrRefugo());
								msevt.setDwPepro((DwPepro) getDao().findById(DwPepro.class, id.getDwPepro().getIdPepro(), false));
								
								// Roda a consolidacao para o novo dwconsolrelog. So assim para criar nova consolidacao para TURNO, HORA e ACUMULADO
								try {
									// Alessandre em 30-06-16, Nao posso pesquisar o calendario atual, pois pode ser diferente do calendario
									// original do dwconsolid,
									//List<DwCalsem> dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(id.getOmPt(), relog.getDthrRefugo());
									DwCal dwcal = getDao().findById(DwCal.class, id.getDwCal().getIdCal(), false);
									List<DwCalsem> dwCalsems = trn.getCalendarioSemanalComTurnosIndefinidos(dwcal.getIdCal());
									consolidarRefugoTodosPeriodos_SONY(id.getOmPt(), /*dwConsolpt*/ null, dwCalsems, id.getPpCp(), id.getDwFolha(), relog, omcfg, log, id.getDwPepro());
									
								} catch (RegistroDesconhecidoException | SemCalendarioException | SemSGBDException | SemCicloPadraoException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
							} else {
								// Pesquisa novamente o relog para criar um vinculo com o banco mesmo ja tendo salvo
								relog = getDao().findById(DwConsolrelog.class, relog.getIdConsolrelog(), true);
								// 2o Passo consolidar os dwconsolrelogs salvos
								alterarReferenciasDeDwConsolreoco(relog);
							}	
						
						}
					
					}
				
				}
			
			}
		
		}
	
	}
	
	// Altera as referencias onde DwConsolrelog aparece
	private void alterarReferenciasDeDwConsolreoco(DwConsolrelog relog) {
		// Percorre totas as ocorrencias onde aparece o relog afim de recalcular o MANU de re, consol, consolpr
		// Mas esse recalculo deve considerar todos os relogs
		List<DwConsolreoco> lista = pesquisarDwConsolreoco(relog);
		for (DwConsolreoco oco : lista) {
			alterarReferenciaDeDwConsolre(oco.getDwConsolre(), relog);
		}
	}
	private void alterarReferenciaDeDwConsolre(DwConsolre re, DwConsolrelog relogOriginal) {
		BigDecimal producaoRefugada = BigDecimal.ZERO;
		List<DwConsolreoco> lista = pesquisarConsolreocoByConsolre(re);
		for (DwConsolreoco oco : lista) {
			BigDecimal prefAux = oco.getDwConsolrelog().getPcsAutoProducaorefugada();
			if (prefAux == null)
				prefAux = BigDecimal.ZERO;
			if (oco.getDwConsolrelog().getPcsManuProducaorefugada() != null)
				prefAux = prefAux.add(oco.getDwConsolrelog().getPcsManuProducaorefugada());
			
			producaoRefugada = producaoRefugada.add(prefAux);
		}
		
		// Calcula o MANU para o RE
		producaoRefugada = producaoRefugada.subtract(re.getPcsAutoProducaorefugada());
		re.setPcsManuProducaorefugada(producaoRefugada);
		getDao().makePersistent(re);
		
		DwConsol dwconsol = getDao().findById(DwConsol.class, re.getDwConsol().getIdConsol(), true);
		alterarReferenciaDeDwConsol(dwconsol, relogOriginal);
	}
	
	private void alterarReferenciaDeDwConsol(DwConsol consol, DwConsolrelog relogOriginal) {
		BigDecimal producaoRefugada = BigDecimal.ZERO;
		List<DwConsolre> lista = pesquisarDwConsolreByDwConsol(consol);
		for (DwConsolre re : lista) {
			BigDecimal prefAux = re.getPcsProducaorefugada();
			producaoRefugada = producaoRefugada.add(prefAux);
		}
		
		// Calcula o MANU para CONSOL
		producaoRefugada = producaoRefugada.subtract(consol.getPcsAutoProducaorefugada());
		consol.setPcsManuProducaorefugada(producaoRefugada);
		
		/* Calcular tempo do novo refugo 
		 * estou alterando o tempo auto por ser mais facil. Alterar o manu requer outros calculos
		 * */
		consol.setSegAutoTemporefugadas(FormulasInjet.calcularTempoRefugoComBaseNoCiclo(
				consol.getPcsProducaoBruta(), 
				consol.getPcsProducaoRefugada(), 
				consol.getSegAutoCicloprodutivo()));

		getDao().makePersistent(consol);
		
		alterarReferenciaDeDwConsolpr(consol, relogOriginal, lista);
		
	}
	
	// Deve corrigir apeas o produto em questao
	private void alterarReferenciaDeDwConsolpr(DwConsol consol, DwConsolrelog relogOriginal, List<DwConsolre> listaConsolre) {
		// Calcula a producao refugada do produto conforme os relog
		listaConsolre = pesquisarDwConsolreByDwConsol(consol);
		
		BigDecimal producaoRefugada = BigDecimal.ZERO;
		for (DwConsolre re : listaConsolre) {
			for (DwConsolreoco oco : re.getDwConsolreocos()) {
				if (oco.getDwConsolrelog().getOmProduto().getCdProduto().equals(relogOriginal.getOmProduto().getCdProduto())) {
					
					BigDecimal prefAux = oco.getDwConsolrelog().getPcsProducaorefugada();
					producaoRefugada = producaoRefugada.add(prefAux);
				}
			}
		}
		for (DwConsolpr consolpr : consol.getDwConsolprs()) {
			if (consolpr.getOmProduto().equals(relogOriginal.getOmProduto()) ) {
				
				producaoRefugada = producaoRefugada.subtract(consolpr.getPcsAutoProducaorefugada());
				


				consolpr.setPcsManuProducaorefugada(producaoRefugada);
				getDao().makePersistent(consolpr);
			}
		}
	}
	
	
	private void alterarReferenciaDePpCp(PpCp ppcp) {
		ppcp = getDao().findById(PpCp.class, ppcp.getIdCp(), false);
		// Pesquisar em dwconsolid para acumulado e atualizar o MANU
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct a");
		q.append("from DwConsolid a");
		q.append("join fetch a.dwConsols b");
		q.append("join fetch b.dwConsolprs c");
		q.append("where a.tpId = :tpid");
		q.append("and a.ppCp = :ppcp");
		q.defineParametro("tpid", DwConsolidTemplate.TpId.ACUMULADO.getValue());
		q.defineParametro("ppcp", ppcp);
		List<DwConsolid> ids = q.list();
		Map<String, ProdutoAlteradoDTO> producao = new HashMap<>();
		for (DwConsolid id : ids) {
			DwConsol consol = id.getDwConsol();
			for (DwConsolpr pr : consol.getDwConsolprs()) {
				ProdutoAlteradoDTO dto = null;
				if (producao.containsKey(pr.getOmProduto().getCdProduto()))
					dto = producao.get(pr.getOmProduto().getCdProduto());
				else {
					dto = new ProdutoAlteradoDTO();
				}
				if (dto.getPcsAutoProducaorefugada() == null)
					dto.setPcsAutoProducaorefugada(BigDecimal.ZERO);
				if (pr.getPcsAutoProducaorefugada() != null)
					dto.setPcsAutoProducaorefugada(dto.getPcsAutoProducaorefugada().add(pr.getPcsAutoProducaorefugada()));
				
				if (dto.getPcsManuProducaorefugada() == null)
					dto.setPcsManuProducaorefugada(BigDecimal.ZERO);
				if (pr.getPcsManuProducaorefugada() != null)
					dto.setPcsManuProducaorefugada(dto.getPcsManuProducaorefugada().add(pr.getPcsManuProducaorefugada()));
				
				producao.put(pr.getOmProduto().getCdProduto(), dto);
			}
		}
		
		// Altera na OP
		for (PpCpproduto cpprod : ppcp.getPpCpprodutos()) {
			if (producao.containsKey(cpprod.getOmProduto().getCdProduto())) {
				ProdutoAlteradoDTO dto = producao.get(cpprod.getOmProduto().getCdProduto());
				BigDecimal producaoRefugada = dto.getPcsAutoProducaorefugada();
				if (producaoRefugada == null)
					producaoRefugada = BigDecimal.ZERO;
				if (dto.getPcsManuProducaorefugada() != null)
					producaoRefugada = producaoRefugada.add(dto.getPcsManuProducaorefugada());
				
				cpprod.setPcsProducaorefugada(producaoRefugada);
				getDao().makePersistent(cpprod);
			}
		}
	}

	private List<DwConsolreoco> pesquisarDwConsolreoco(DwConsolrelog relog) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolreoco a");
		q.append("join fetch a.dwConsolre b");
		q.append("where a.dwConsolrelog = :relog");
		q.defineParametro("relog", relog);
		return q.list();
	}
	
	private List<DwConsolre> pesquisarDwConsolreByDwConsol(DwConsol consol) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolre a");
		q.append("where a.dwConsol = :dwconsol");
		q.defineParametro("dwconsol", consol);
		return q.list();
	}
	
	private List<DwConsolreoco> pesquisarConsolreocoByConsolre(DwConsolre re) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolreoco a");
		q.append("where a.dwConsolre = :consolre");
		q.defineParametro("consolre", re);
		return q.list();
	}
}	
