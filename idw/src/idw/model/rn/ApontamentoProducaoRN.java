package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.apontamentoproducao.ProdutoAlteradoDTO;
import idw.model.rn.consolidacao.refugo.ConsolidacaoRefugoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;

public class ApontamentoProducaoRN extends ConsolidacaoRefugoRN {

	/*
	 * Esse metodo tem como objetivo salvar o apontamento manual em dwconsol e
	 * dwconsolpr
		 * 
	 */
	public void salvarApontamentoProducao(DwConsolidDTOs dtos) {
		IdwLogger log = new IdwLogger("ApontamentoProducaoRN");
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0, "Iniciando apontamentoproducao");
		
		// Ppcps sera usada para armazenar as OPs envolvidas e atualiza-las apos a atualizacao da hora, turno e acumulado
		List<PpCp> ppcps = new ArrayList<>();
		
		// Interage sobre todos os ids do TURNO
		for (DwConsolidDTO idTurnoDTO : dtos.getListaDwConsolidDTO()) {
			
			// Interage sobre todos os ids da HORA
			for (DwConsolidDTO idHoraDTO : idTurnoDTO.getIdsHoraAHora()) {
				DwConsolid idHora = idHoraDTO.getDwConsolid();
				
				// Se a PPCP ainda nao foi para a lista, inclui-la
				if (ppcps.contains(idHora.getPpCp()) == false) {
					ppcps.add(idHora.getPpCp());
				}
				
				// Atualiza producaoBruta em PR e CONSOL da hora
				alterarProducaoBrutaNaHora(idHora, log, idLog);
				
			}
			
			// Apos alterar os dados da HOra, alterar do turno e acumulado
			DwConsolid idTurno = idTurnoDTO.getDwConsolid();

			// Atualizar producaoBruta em PR e CONSOL do TURNO
			alterarProducaoBrutaNoTurno(idTurno, log, idLog);
			
			
			// Atualizar producaoBruta em PR e CONSOL do ACUMULADO
			alterarProducaoBrutaNoAcumulado(idTurno, log, idLog);
			

		}
		
		// ALterar referencia da producao refugada nas ordens
		for (PpCp ppcp : ppcps) {
			alterarReferenciaDePpCp(ppcp, log, idLog);
		}
	}

	private void alterarProducaoBrutaNaHora(DwConsolid idHora, IdwLogger log, int idLog) {
		
		// idHora possue o idConsolid vindo da GUI que alterou determinada hora de determinado produto
		for (DwConsol dwconsolHora : idHora.getDwConsols()) {
			
			// Interage sobre o consolpr. Tanto dwconsol quanto dwconsolpr ja devem vim com os valores corretos
			// Se tiver mais de um ConsolPr aqui vai aparecer apenas 1, pois a GUI altera por produto
			boolean isAlteracaoEmPr = false;
			for (DwConsolpr dwconsolpr : dwconsolHora.getDwConsolprs()) {
				// Vincula o id ao banco
				DwConsolpr dwconsolprAlterar = getDao().findById(DwConsolpr.class, dwconsolpr.getIdConsolpr(), true);
				if (dwconsolpr.getPcsManuProducaobruta() != null) {
					log.info(idLog, 0, "HORA...idConsolpr=" + dwconsolprAlterar.getIdConsolpr() + " manuProdBruta=" + dwconsolprAlterar.getPcsManuProducaobruta() + " para " + dwconsolpr.getPcsManuProducaobruta());
					dwconsolprAlterar.setPcsManuProducaobruta(dwconsolpr.getPcsManuProducaobruta());
					getDao().makePersistent(dwconsolprAlterar);
					isAlteracaoEmPr = true;
				}
			}
			
			if (isAlteracaoEmPr) {
				// Somar os produtos para depois alterar dwconsol
				DwConsol dwConsolAlterar = getDao().findById(DwConsol.class, dwconsolHora.getIdConsol(), true);
				BigDecimal producaoBrutaManuTodosOsProdutos = BigDecimal.ZERO;
				for (DwConsolpr dwconsolpr : dwConsolAlterar.getDwConsolprs()) {
					log.info(idLog, 0, "avaliando idConsolpr=" + dwconsolpr.getIdConsolpr() + " pcsManuProducaoBruta=" + dwconsolpr.getPcsManuProducaobruta());
					if (dwconsolpr.getPcsManuProducaobruta() != null)
						producaoBrutaManuTodosOsProdutos = producaoBrutaManuTodosOsProdutos.add(dwconsolpr.getPcsManuProducaobruta());
				}
				
	
				// Salvar em DwConsol a soma MANU de todos os produtos produtos
				// Encontra o registro no banco para em seguida alterar o manu
				log.info(idLog, 0, "valor manuProducaoBruta=" + producaoBrutaManuTodosOsProdutos);
				if (producaoBrutaManuTodosOsProdutos.compareTo(BigDecimal.ZERO) > 0) {
					log.info(idLog, 0, "HORA...idConsol=" + dwConsolAlterar.getIdConsol() + " manuProdBruta=" + dwConsolAlterar.getPcsManuProducaobruta() + " para " + dwConsolAlterar.getPcsManuProducaobruta());
					dwConsolAlterar.setPcsManuProducaobruta(producaoBrutaManuTodosOsProdutos);
					getDao().makePersistent(dwConsolAlterar);
				}
			}
		}
	}

	private void alterarProducaoBrutaNoTurno(DwConsolid idTurno, IdwLogger log, int idLog) {
		for (DwConsol dwconsolTurno : idTurno.getDwConsols()) {

			// Interage sobre o consolpr. Tanto dwconsol quanto dwconsolpr ja devem vim com os valores corretos
			boolean isAlteracaoEmPr = false;
			for (DwConsolpr dwconsolpr : dwconsolTurno.getDwConsolprs()) {
				// Vincula o id ao banco
				DwConsolpr dwconsolprAlterar = getDao().findById(DwConsolpr.class, dwconsolpr.getIdConsolpr(), true);
				if (dwconsolpr.getPcsManuProducaobruta() != null) {
					log.info(idLog, 0, "TURNO idConsolpr=" + dwconsolprAlterar.getIdConsolpr() + " manuProdBruta=" + dwconsolprAlterar.getPcsManuProducaobruta() + " para " + dwconsolpr.getPcsManuProducaobruta());
					dwconsolprAlterar.setPcsManuProducaobruta(dwconsolpr.getPcsManuProducaobruta());
					getDao().makePersistent(dwconsolprAlterar);
					isAlteracaoEmPr = true;
				}
			}
			
			if (isAlteracaoEmPr) {
				// Alterar em dwconsol no turno com base em todos os produtos no turno
				// Encontra o registro no banco para em seguida alterar o manu
				DwConsol dwConsolAlterar = getDao().findById(DwConsol.class, dwconsolTurno.getIdConsol(), true);
				BigDecimal producaoBrutaManuTodosOsProdutos = BigDecimal.ZERO;
				for (DwConsolpr dwconsolpr : dwConsolAlterar.getDwConsolprs()) {
					if (dwconsolpr.getPcsManuProducaobruta() != null)
						producaoBrutaManuTodosOsProdutos = producaoBrutaManuTodosOsProdutos.add(dwconsolpr.getPcsManuProducaobruta());
				}
				
	
				// Salvar em DwConsol a soma MANU de todos os produtos produtos
				// Encontra o registro no banco para em seguida alterar o manu
				if (producaoBrutaManuTodosOsProdutos.compareTo(BigDecimal.ZERO) > 0) {
					log.info(idLog, 0, "TURNO...idConsol=" + dwConsolAlterar.getIdConsol() + " manuProdBruta=" + dwConsolAlterar.getPcsManuProducaobruta() + " para " + dwConsolAlterar.getPcsManuProducaobruta());
					dwConsolAlterar.setPcsManuProducaobruta(producaoBrutaManuTodosOsProdutos);
					getDao().makePersistent(dwConsolAlterar);
				}
			}
		}
	}

	// Alterar a producao nos registros acumulados
	private void alterarProducaoBrutaNoAcumulado(DwConsolid idTurno, IdwLogger log, int idLog) {
		

		MapQuery qAcumulado = new MapQuery(getDaoSession());

		// Alterar a producao acumulada
		qAcumulado.novaConsulta();
		qAcumulado.append("select a");
		qAcumulado.append("from DwConsolid a");
		qAcumulado.append("join a.dwConsols b");
		qAcumulado.append("join b.dwConsolprs c");
		qAcumulado.append("where a.tpId = :tpid");
		qAcumulado.append("and a.stAtivo is null");
		qAcumulado.append("and a.ppCp = :ppcp");
		qAcumulado.append("and a.dwFolha = :dwfolha");
		qAcumulado.append("and a.dwCal = :dwcal");
		qAcumulado.append("and a.omPt.idPt = :idpt");

		
		qAcumulado.defineParametro("tpid", DwConsolidTemplate.TpId.ACUMULADO.getValue());
		qAcumulado.defineParametro("ppcp", idTurno.getPpCp());
		qAcumulado.defineParametro("dwfolha", idTurno.getDwFolha());
		qAcumulado.defineParametro("dwcal", idTurno.getDwCal());
		qAcumulado.defineParametro("idpt", idTurno.getOmPt().getIdPt());
		
		List<DwConsolid> idsAcumulado = qAcumulado.list();

		log.info(idLog, 0, "ACUMULADO ids no ACUMULADO - Para ppcp.idCp=" + idTurno.getPpCp().getIdCp() + " idPt=" + idTurno.getOmPt().getIdPt() + " idFolha=" + idTurno.getDwFolha().getIdFolha() + " idCal=" + idTurno.getDwCal().getIdCal() + " size=" + idsAcumulado.size());

		for (DwConsolid idAcumulado : idsAcumulado) {
			

			// Pesquisar dados para o idAcumulado especifico
			Map<String, ProdutoAlteradoDTO> producao = obtemDadosProducaoNoTurno(idAcumulado, log, idLog);

			
			for (DwConsol cAcumulado : idAcumulado.getDwConsols()) {
				BigDecimal producaoManuParaConsol = BigDecimal.ZERO;
				BigDecimal producaoAutoParaConsol = BigDecimal.ZERO;
				for (DwConsolpr prAcumulado : cAcumulado.getDwConsolprs()) {
					if (producao.containsKey(prAcumulado.getOmProduto().getCdProduto())) {
						ProdutoAlteradoDTO dto = producao.get(prAcumulado.getOmProduto().getCdProduto());
						BigDecimal producaoManu = dto.getPcsManuProducaobruta();
						BigDecimal producaoAuto = dto.getPcsAutoProducaobruta();
						
						log.info(idLog, 0, "ACUMULADO idConsolpr=" + prAcumulado.getIdConsolpr() + " manuProdBruta=" + prAcumulado.getPcsManuProducaobruta() + " para " + producaoManu);

						prAcumulado.setPcsManuProducaobruta(producaoManu);
						prAcumulado.setPcsAutoProducaobruta(producaoAuto);
						
						getDao().makePersistent(prAcumulado);
					}
					producaoManuParaConsol = producaoManuParaConsol.add(prAcumulado.getPcsManuProducaobruta());
					producaoAutoParaConsol = producaoAutoParaConsol.add(prAcumulado.getPcsAutoProducaobruta());
				}
				log.info(idLog, 0, "ACUMULADO idConsol=" + cAcumulado.getIdConsol() + " manuProdBruta=" + cAcumulado.getPcsManuProducaobruta() + " para " + producaoManuParaConsol);

				cAcumulado.setPcsAutoProducaobruta(producaoAutoParaConsol);
				cAcumulado.setPcsManuProducaobruta(producaoManuParaConsol);
				
				getDao().makePersistent(cAcumulado);
			}
		}
	}
	
	
	
	private void alterarReferenciaDePpCp(PpCp ppcp, IdwLogger log, int idLog) {
		ppcp = getDao().findById(PpCp.class, ppcp.getIdCp(), false);
		// Pesquisar em dwconsolid para acumulado e atualizar o MANU
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct a");
		q.append("from DwConsolid a");
		q.append("join fetch a.dwConsols b");
		q.append("join fetch b.dwConsolprs c");
		q.append("where a.tpId = :tpid");
		q.append("and a.stAtivo is null");
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

				if (dto.getPcsAutoProducaobruta() == null)
					dto.setPcsAutoProducaobruta(BigDecimal.ZERO);
				if (pr.getPcsAutoProducaobruta() != null)
					dto.setPcsAutoProducaobruta(dto.getPcsAutoProducaobruta().add(pr.getPcsAutoProducaobruta()));
				
				if (dto.getPcsManuProducaobruta() == null)
					dto.setPcsManuProducaobruta(BigDecimal.ZERO);
				if (pr.getPcsManuProducaobruta() != null)
					dto.setPcsManuProducaobruta(dto.getPcsManuProducaobruta().add(pr.getPcsManuProducaobruta()));
				
				producao.put(pr.getOmProduto().getCdProduto(), dto);
			}
		}
		
		// Altera na OP
		for (PpCpproduto cpprod : ppcp.getPpCpprodutos()) {
			if (producao.containsKey(cpprod.getOmProduto().getCdProduto())) {
				ProdutoAlteradoDTO dto = producao.get(cpprod.getOmProduto().getCdProduto());
				
				BigDecimal producaoBruta = dto.getPcsAutoProducaobruta();
				if (producaoBruta == null)
					producaoBruta = BigDecimal.ZERO;
				
				if (dto.getPcsManuProducaobruta() != null)
					producaoBruta = producaoBruta.add(dto.getPcsManuProducaobruta());
				
				cpprod.setPcsProducaobruta(producaoBruta);
				
				getDao().makePersistent(cpprod);
			}
		}
	}
	
	private Map<String, ProdutoAlteradoDTO> obtemDadosProducaoNoTurno(DwConsolid idAcumulado, IdwLogger log, int idLog) {
		MapQuery qTurno = new MapQuery(getDaoSession());
		
		qTurno.append("select distinct a");
		qTurno.append("from DwConsolid a");
		qTurno.append("join fetch a.dwConsols b");
		qTurno.append("join fetch b.dwConsolprs c");
		qTurno.append("where a.tpId = :tpid");
		qTurno.append("and a.stAtivo is null");
		qTurno.append("and a.omPt.idPt = :idpt");
		qTurno.append("and a.ppCp = :ppcp");
		qTurno.append("and a.dwFolha = :dwfolha");
		qTurno.append("and a.dwCal = :dwcal");
		
		qTurno.defineParametro("tpid", DwConsolidTemplate.TpId.TURNO.getValue());
		qTurno.defineParametro("ppcp", idAcumulado.getPpCp());
		qTurno.defineParametro("idpt", idAcumulado.getOmPt().getIdPt());
		qTurno.defineParametro("dwfolha", idAcumulado.getDwFolha());
		qTurno.defineParametro("dwcal", idAcumulado.getDwCal());
		
		List<DwConsolid> idsTurno = qTurno.list();
		
		log.info(idLog, 0, "ACUMULADO ids no TURNO - Para ppcp.idCp=" + idAcumulado.getPpCp().getIdCp() + " idPt=" + idAcumulado.getOmPt().getIdPt() + " idFolha=" + idAcumulado.getDwFolha().getIdFolha() + " idCal=" + idAcumulado.getDwCal().getIdCal() + " size=" + idsTurno.size());
		
		Map<String, ProdutoAlteradoDTO> producao = new HashMap<>();
		
		for (DwConsolid id : idsTurno) {
			DwConsol consol = id.getDwConsol();
			for (DwConsolpr pr : consol.getDwConsolprs()) {
				ProdutoAlteradoDTO dto = null;
				if (producao.containsKey(pr.getOmProduto().getCdProduto()))
					dto = producao.get(pr.getOmProduto().getCdProduto());
				else {
					dto = new ProdutoAlteradoDTO();
				}
				
				// Acumula producao manual
				if (dto.getPcsManuProducaobruta() == null)
					dto.setPcsManuProducaobruta(BigDecimal.ZERO);
				if (pr.getPcsManuProducaobruta() != null)
					dto.setPcsManuProducaobruta(dto.getPcsManuProducaobruta().add(pr.getPcsManuProducaobruta()));
				
				// Acumula producao automatica
				if (dto.getPcsAutoProducaobruta() == null)
					dto.setPcsAutoProducaobruta(BigDecimal.ZERO);
				if (pr.getPcsAutoProducaobruta() != null)
					dto.setPcsAutoProducaobruta(dto.getPcsAutoProducaobruta().add(pr.getPcsAutoProducaobruta()));

				producao.put(pr.getOmProduto().getCdProduto(), dto);
			}
		}
		return producao;
	}
}	
