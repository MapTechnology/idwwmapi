package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TtSapEstmppa;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.dto.SapEstoqueDTO;
import idw.webservices.dto.UsuarioDTO;

public class ImportacaoPlanilhaProducaoRN implements IDao {

	/**
	 * 
	 */
	private transient DAOGenerico dao; // para MapQuery
	private List<SapEstoqueDTO> sapestoques = new ArrayList<SapEstoqueDTO>();
	private IdwLogger log;
	private int idLog;
	private int identacao;
	private MapQuery qEstoquePt = null;
	private MapQuery qEstoqueGt = null;
	private MapQuery qEstoqueAjuste = null;
	private MapQuery qRotaPasso = null;
	private MapQuery qRota = null;

	public ImportacaoPlanilhaProducaoRN() {
		this.dao = new DAOGenerico();
	}

	public ImportacaoPlanilhaProducaoRN(DAOGenerico dao) {
		this.dao = dao;
	}

	/*
	 * Metodo principal de importacao da planilha de producao
	 */
	public DwConsolidDTOs importarPlanilha(DwConsolidDTOs apontamentosAcomp, UsuarioDTO usrlogadodto) {
		DwConsolidDTOs retorno = new DwConsolidDTOs();
		// List<DwConsolidDTO> listadwconsoliddtoFilho = new
		// ArrayList<DwConsolidDTO>();
		retorno.setListaDwConsolidDTO(new ArrayList<DwConsolidDTO>());
		retorno.setResultadoDTO(new ResultadoDTO());
		retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getCOM_SUCESSO());

		UsuarioRN usuarioRN = new UsuarioRN(dao);
		OmUsr omusr = usuarioRN.getUsuarioByCdEStAtivo(usrlogadodto.getUsuario().getCdUsr());

		log = new IdwLogger("importacaoPlanilhaProducao");
		idLog = log.getIdAleatorio();
		identacao = 0;

		log.iniciaAvaliacao(idLog, "importarPlanilhaProducao");
		log.info(idLog, identacao, "Iniciando importacaoProducao");

		// Inicializa consulta para verifica se a producao ja foi lancada como
		// estoque
		qEstoquePt = new MapQuery(dao.getSession());

		qEstoquePt.append("select distinct dwestmov");
		qEstoquePt.append("from DwEstmov dwestmov");
		qEstoquePt.append("join dwestmov.dwEstpro dwestpro");
		qEstoquePt.append("join dwestpro.omProduto omproduto");
		qEstoquePt.append("where omproduto.cdProduto = :cdproduto and omproduto.stAtivo = 1");
		qEstoquePt.append("and dwestmov.dthrMov = :dt");
		qEstoquePt.append("and dwestmov.omPt = :ompt");
		qEstoquePt.append("and dwestmov.dwTurno = :dwturno");

		qEstoqueGt = new MapQuery(dao.getSession());

		qEstoqueGt.append("select distinct dwestmov");
		qEstoqueGt.append("from DwEstmov dwestmov");
		qEstoqueGt.append("join dwestmov.dwEstpro dwestpro");
		qEstoqueGt.append("join dwestpro.omProduto omproduto");
		qEstoqueGt.append("where omproduto.cdProduto = :cdproduto and omproduto.stAtivo = 1");
		qEstoqueGt.append("and dwestmov.dthrMov = :dt");
		qEstoqueGt.append("and dwestmov.omGt = :omgt");
		qEstoqueGt.append("and dwestmov.dwTurno = :dwturno");

		qEstoqueAjuste = new MapQuery(dao.getSession());

		qEstoqueAjuste.append("from DwEstpro dwestpro");
		qEstoqueAjuste.append("join dwestpro.dwEstmovs dwestmov");
		qEstoqueAjuste.append("join dwestpro.omProduto omproduto");
		qEstoqueAjuste.append("where omproduto.cdProduto = :cdproduto and omproduto.stAtivo = 1");
		qEstoqueAjuste.append("and dwestmov.lancamento = :lancamento");

		// busca na tabela DwRotaPasso
		qRota = new MapQuery(dao.getSession());
		qRota.append("Select dwrota.idRota");
		qRota.append("from DwRotapasso dwrotapasso");
		qRota.append("join dwrotapasso.dwRota dwrota");
		qRota.append("join dwrotapasso.dwFolha dwfolha");
		qRota.append("where dwfolha.idFolha =:idfolha ");
		qRota.append("and dwfolha.stAtivo = 1 ");
		qRota.append("and dwrota.stAtivo = 1");

		qRotaPasso = new MapQuery(dao.getSession());
		qRotaPasso.append("Select dwrotapasso");
		qRotaPasso.append("from DwRotapasso dwrotapasso");
		qRotaPasso.append("left join fetch dwrotapasso.dwFolha dwfolha");
		qRotaPasso.append("left join fetch dwfolha.dwFolhaiacs folhaiacs");
		qRotaPasso.append("left join fetch folhaiacs.omProduto prod");
		qRotaPasso.append("left join fetch dwrotapasso.dwRota dwrota");
		qRotaPasso.append("where dwrota.idRota = :idrota ");
		qRotaPasso.append("and dwrota.stAtivo = 1 ");
		qRotaPasso.append("and dwfolha.stAtivo = 1");

		// Le configuracao geral do sistema
		OmCfg omcfg = Util.getConfigGeral(dao.getSession());

		// Armazena na lista de apontamentos
		DwConsolidDTOs apontamentos = null;

		if (omcfg != null && omcfg.getIsCompensaapont() == true) {
			apontamentos = apontamentosExtras(apontamentosAcomp, retorno);
		} else {
			apontamentos = apontamentosAcomp;
		}

		// Interage sobre as informacoes enviadas
		int i = 0;
		for (DwConsolidDTO dwconsoliddto : apontamentos.getListaDwConsolidDTO()) {
			DwConsolid dwconsolid = dwconsoliddto.getDwConsolid();

			log.info(idLog, identacao, dwconsolid.getDwFolha().getCdFolha());

			if(dwconsolid.getDwFolha().getCdFolha().toString().equals("498094")){
				log.info( i + "DEBUG");
			}
			i++;
			// Se o PT n�o está identificado, entao ajustar apenas o estoque
			OmPt ompt = dwconsolid.getOmPt();
			log.info(idLog, identacao, ompt.getDepara());

			if (ompt.getDepara().equals("AJUSTE") == true) {
				DwConsol dwconsolP = dwconsolid.getDwConsols().iterator().next();
				atualizarEstoque(dwconsolid, dwconsolP.getPcsManuProducaobruta(), true);
			} else {
				atualizarProducao(omusr, retorno, dwconsolid);
			}
		}

		// Atualiza estoques. Sapestoques deve ter valor
		importarParaEstoques(usrlogadodto);
		
		//Retira Elementos Repetidos
		retorno = retiraElementosRepetidos(retorno);
		
		log.paraAvaliacao(dao);
		log.info(idLog, 0, log.getAvaliacaoCompleta());
		log.info(idLog, identacao, "Finalizando importacaoProducao");

		return retorno;
	}

	private DwFolha pesquisarIdFolha(DwConsolid dwconsolidApontamento,
			OmPt ompt, OmGt omgt) {

		String sufixoFolha = null;

		FolhaRN frn = new FolhaRN(dao);

		if (ompt == null) {
			if (omgt == null) {
				// log.info(idLog, 0, "PT e GT desconhecidos " +
				// dwconsolidApontamento.getOmPt().getDepara());
				return null;
			}
			sufixoFolha = "-" + omgt.getOmTpgt().getCdTpgt();
		} else {
			sufixoFolha = "-" + ompt.getOmTppt().getCdTppt();
		}

		String cd = dwconsolidApontamento.getDwFolha().getCdFolha()
				+ sufixoFolha;
		// log.info(cd);
		DwFolha dwfolha = frn.pesquisaFolhaByCdEStComRota(cd);

		return dwfolha;
	}

	// Pega os apontamento extras (que n�o está sendo apontado na lista de
	// apontamento). Por exemplo, o bottom eh apontado e o top nao.
	private DwConsolidDTOs apontamentosExtras(DwConsolidDTOs apontamentos, DwConsolidDTOs retorno) {
		log.info("Apontamentos Extras");

		PTRN ptrn = new PTRN(dao);
		ptrn.setDaoSession(dao.getSession());

		TurnoRN trn = new TurnoRN();
		trn.getDao().setSession(dao.getSession());

		OmGtDAO gtDAO = new OmGtDAO(dao.getSession());

		List<DwConsolidDTO> apontamentosExtras = new ArrayList<DwConsolidDTO>();

		for (DwConsolidDTO apontamento : apontamentos.getListaDwConsolidDTO()) {

			DwConsolid dwconsolidApontamento = apontamento.getDwConsolid();

			OmPt ompt = null;
			OmGt omgt = null;

			// O if abaixo ajusta o pt MS para MS1, correcao da planilha da panasonic
			if (dwconsolidApontamento.getOmPt().getDepara().equals("MS")) {
				ompt = ptrn.pesquisarPtByCdPtStAtivo("MS1");
			} else {
				ompt = ptrn.pesquisarPtByCdPtStAtivo(dwconsolidApontamento.getOmPt().getDepara());
			}

			omgt = gtDAO.getOmGtPorCdAtivo(dwconsolidApontamento.getOmPt().getDepara());

			if (dwconsolidApontamento.getDwFolha().getCdFolha().equals("1RE1T7730XBK-CO"))
				log.info("Debug do produto " + dwconsolidApontamento.getDwFolha().getCdFolha());

			DwFolha folhaApontamento = pesquisarIdFolha(dwconsolidApontamento, ompt, omgt);
			
			if (folhaApontamento == null) {
				log.info("Nao foi importada a producao pois a folha nao foi encontrada.");
				continue;
			}

			dwconsolidApontamento.setDwFolha(folhaApontamento);
			// log.info(folhaApontamento.getCdFolha() + " - " +
			// folhaApontamento.getIdFolha() + " - " +
			// folhaApontamento.getStAtivo());

			String cdProdutoApontamento = folhaApontamento.getCdFolha();

			qRota.defineParametro("idfolha", folhaApontamento.getIdFolha());

			List<Long> rota = qRota.list();

			if (rota.size() <= 0) {
				log.info("Nao importaou a producao pois nao encontrou a rota.");
				continue;
			}

			Long idRota = (Long) rota.get(0);

			qRotaPasso.defineParametro("idrota", idRota);

			List<DwRotapasso> listaRotaPasso = qRotaPasso.list();

			for (DwRotapasso rotaPasso : listaRotaPasso) {
				
				DwFolhaiac rotaPassoFolhaIAC = null;
				if(rotaPasso.getDwFolha().getDwFolhaiacs().size()>0){
					rotaPassoFolhaIAC = (DwFolhaiac) rotaPasso.getDwFolha().getDwFolhaiacs().iterator().next();
				}else{
					if(rotaPasso.getDwFolha().getCdFolha().equals("475901-SMD")){
						log.info("DEBUG");
					}
					DwConsolidDTO dwconsolidDTO = new DwConsolidDTO();
					dwconsolidDTO.setDwConsolid(dwconsolidApontamento.clone(false));
					dwconsolidDTO.getDwConsolid().setDwFolha(new DwFolha());
					dwconsolidDTO.getDwConsolid().getDwFolha().setCdFolha(rotaPasso.getDwFolha().getCdFolha());
					dwconsolidDTO.setResultado(dwconsolidDTO.getERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA());
					retorno.getListaDwConsolidDTO().add(dwconsolidDTO);
					retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getERRO_DESCONHECIDO());
					continue;
				}
				
				//DwFolhaiac rotaPassoFolhaIAC = (DwFolhaiac) rotaPasso.getDwFolha().getDwFolhaiacs().iterator().next();

				if (rotaPasso.getDwFolha().getCdFolha().equals(cdProdutoApontamento) == true)
					continue;

				boolean isPossuiApontamento = false;

				for (DwConsolidDTO bufferdwconsoliddtoFilho : apontamentos.getListaDwConsolidDTO()) {
					String cdProdutoFilho = bufferdwconsoliddtoFilho.getDwConsolid().getDwFolha().getCdFolha();

					if (cdProdutoFilho == null)
						log.info("cdProdutoFilho null " + bufferdwconsoliddtoFilho.getDwConsolid().getDwFolha().getCdFolha());
					
					if (rotaPassoFolhaIAC == null)
						log.info("rotaPassoFolhaIAC null");
					else if (rotaPassoFolhaIAC.getOmProduto() == null)
						log.info("rotaPassoFolhaIAC.getOmProduto null");
						
					if (cdProdutoFilho.equals(rotaPassoFolhaIAC.getOmProduto().getCdProduto()) == true) {
						isPossuiApontamento = true;
						break;
					}
				}

				if (isPossuiApontamento == false) {

					// log.info("Apontamento extra: Folha(id) - " +
					// folhaApontamento.getCdFolha());
					DwConsolidDTO novoConsolid = new DwConsolidDTO();
					DwConsolid dwConsolid = new DwConsolid();

					dwConsolid.setDtReferencia(dwconsolidApontamento.getDtReferencia());
					dwConsolid.setAno(dwconsolidApontamento.getAno());
					dwConsolid.setMes(dwconsolidApontamento.getMes());

					dwConsolid.setOmPt(dwconsolidApontamento.getOmPt());
					
					DwTurno dwturno = new DwTurno();
					dwturno = trn.pesquisarTurnoById(dwconsolidApontamento.getDwTurno().getIdTurno());
					dwConsolid.setDwTurno(dwturno);

					// DwFolha novaFolha = new DwFolha();
					// novaFolha.setCdFolha(cdProdutoApontamento);
					dwConsolid.setDwFolha(new DwFolha());
					dwConsolid.getDwFolha().setCdFolha(rotaPassoFolhaIAC.getOmProduto().getCdProduto());

					Set<DwConsol> dwConsols = new HashSet<DwConsol>(0);
					for (DwConsol dwConsol : dwconsolidApontamento.getDwConsols()) {
						DwConsol novoConsol = dwConsol.clone(false);
						dwConsols.add(novoConsol);
					}
					dwConsolid.setDwConsols(dwConsols);
					novoConsolid.setDwConsolid(dwConsolid);

					apontamentosExtras.add(novoConsolid);
				}
			}
		}

		apontamentos.getListaDwConsolidDTO().addAll(apontamentosExtras);
		return apontamentos;
	}


	private void atualizarEstoque(DwConsolid dwconsolid, BigDecimal producaoAAtualizar, boolean isAjuste) {

		SapEstoqueDTO sap = new SapEstoqueDTO();
		TtSapEstmppa est = new TtSapEstmppa();

		est.setCentro(null); // aparentemento nao esta sendo usado
		est.setDeposito(null); // aparentemento nao esta sendo usado
		// Alessandre: Nao posso comentar a linha abaixo pois no lancamento do
		// estoque eh verificado a data e hora
		// para saber se o estoque ja foi lancado ou nao
		est.setDthrReferencia(dwconsolid.getDtReferencia());

		// Quando for ajuste nao é necessario remover o sufixo da folha, pois
		// nesse caso a propria folha
		// sera o global code
		if (isAjuste == true) {
			est.setGlobalcode(dwconsolid.getDwFolha().getCdFolha());
		} else {
			log.info(idLog, identacao, "ANTES Globalcode para o estoque é " + dwconsolid.getDwFolha().getCdFolha());
			log.info(dwconsolid.getDwFolha().getCdFolha());
			est.setGlobalcode(dwconsolid.getDwFolha().getCdFolha().substring(0, dwconsolid.getDwFolha().getCdFolha().lastIndexOf("-")));
			log.info(idLog, identacao, "DEPOIS Globalcode para o estoque é " + est.getGlobalcode());
		}

		if (est.getGlobalcode().equals("S9LB-IR5"))
			log.info(idLog, identacao, "Debug");

		// Obtem a producao enviada pelo cliente
		est.setQtEstoque(producaoAAtualizar);

		sap.setSapestoque(est);
		sap.setAjustarEstoque(isAjuste);
		sap.setDwconsolid(dwconsolid);

		// Verificar se esse item a ser atualizado já nao existe como lancamento
		// do estoque
		// Se existir é porque está sendo reimportada a planilha de producao,
		// nesse caso nao é necessario atualizar esse estoque
		if (isAjuste == false) {
			if (dwconsolid.getOmPt() != null) {
				qEstoquePt.defineParametro("ompt", dwconsolid.getOmPt());
				qEstoquePt.defineParametroData("dt", est.getDthrReferencia());
				qEstoquePt.defineParametro("dwturno", dwconsolid.getDwTurno());
				qEstoquePt.defineParametro("cdproduto", est.getGlobalcode());

				try {
				log.info("Pt" + dwconsolid.getOmPt().getCdPt() + "Produto " + est.getGlobalcode() + " Data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(est.getDthrReferencia()) +  " turno " + dwconsolid.getDwTurno().getIdTurno() );
				} catch (NullPointerException e){
					//System.out.println("");
				}
				if (qEstoquePt.list().size() <= 0) {
					if (est.getGlobalcode().equals("TP7N4G508AG-ILH"))
						log.info(idLog, identacao + 5, "Adicionado na lista de atualizacao do estoque o item " + sap);
					
					this.sapestoques.add(sap);
				}
			} else {
				qEstoqueGt.defineParametro("omgt", dwconsolid.getOmGt());
				qEstoqueGt.defineParametro("dt", est.getDthrReferencia());
				qEstoqueGt.defineParametro("dwturno", dwconsolid.getDwTurno());
				qEstoqueGt.defineParametro("cdproduto", est.getGlobalcode());

				if (qEstoqueGt.list().size() <= 0) {
					if (est.getGlobalcode().equals("TP7N4G508AG-ILH"))
						log.info(idLog, identacao + 5, "Adicionado na lista de atualizacao do estoque o item " + sap);
					
					this.sapestoques.add(sap);
				}
			}
		} else {
			qEstoqueAjuste.defineParametro("dt", est.getDthrReferencia());
			qEstoqueAjuste.defineParametro("dwturno", dwconsolid.getDwTurno());
			qEstoqueAjuste.defineParametro("cdproduto", est.getGlobalcode());
			qEstoqueAjuste.defineParametro("lancamento", "AJUSTE");

			if (qEstoqueAjuste.list().size() <= 0) {
				this.sapestoques.add(sap);
			}
		}

	}

	/*
	 * Para o metodo importarParaEstoques funcionar adequadamente quem o chamou deverá providenciar que sapestoques tenha os valores
	 * adequados
	 */
	private void importarParaEstoques(UsuarioDTO usrlogadodto) {
		ImportacaoPlanilhaComMatPrimaSapRN rn = new ImportacaoPlanilhaComMatPrimaSapRN(dao);
		rn.setSapestoques(sapestoques);

		log.info(idLog, identacao + 5, "Inicio da importarPlanilha do Estoque");
		rn.importarPlanilha(usrlogadodto, false /*
												 * false para nao apagar o
												 * estoque antes de importar
												 */);
		log.info(idLog, identacao + 5, "Final da importarPlanilha do Estoque");

		// Coloca os erros de importacao no retorno
		// Na verdade a importacao gera apenas log em arquivo com o resultad
	}

	private void atualizarProducao(OmUsr omusr, DwConsolidDTOs retorno, DwConsolid dwconsolidParametro) {

		// Procura PT ou o PT para apontamento de producao do GT
		PTRN ptrn = new PTRN(dao);
		ptrn.setDaoSession(dao.getSession()); // para os metodos que nao utilizam o
		// dao

		TurnoRN trn = new TurnoRN();
		trn.getDao().setSession(dao.getSession());

		ConsolidaRN crn = new ConsolidaRN(dao);

		FolhaRN frn = new FolhaRN(dao);

		CalendarioRN calrn = new CalendarioRN();
		calrn.setSession(dao.getSession());
		
		OmGtDAO gtDAO = new OmGtDAO(dao.getSession());

		String sufixoFolha = null;

		OmPt ompt = null;
		OmGt omgt = null;

		// Ajuste no nome da maquina
		if (dwconsolidParametro.getOmPt().getDepara().equals("MS"))
			ompt = ptrn.pesquisarPtByCdPtStAtivo("MS1");
		else
			ompt = ptrn.pesquisarPtByCdPtStAtivo(dwconsolidParametro.getOmPt().getDepara());

		// Se pt null entao procurar pelo GT
		if (ompt == null) {

			String depara = dwconsolidParametro.getOmPt().getDepara();
			omgt = gtDAO.getOmGtPorCdAtivo(depara);

			if (omgt == null) {
				DwConsolidDTO dwconsolidDTO = new DwConsolidDTO();
				dwconsolidDTO.setDwConsolid(dwconsolidParametro.clone(false));
				dwconsolidDTO.getDwConsolid().setOmPt(new OmPt());
				dwconsolidDTO.getDwConsolid().getOmPt().setDepara(depara);
				dwconsolidDTO.setResultado(dwconsolidDTO.getERRO_PT_DESCONHECIDO());
				retorno.getListaDwConsolidDTO().add(dwconsolidDTO);
				retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getERRO_DESCONHECIDO());

				log.info(idLog, identacao + 5, "PT e GT desconhecidos " + dwconsolidParametro.getOmPt().getDepara());
				return;
			}
			sufixoFolha = "-" + omgt.getOmTpgt().getCdTpgt();
		} else {
			sufixoFolha = "-" + ompt.getOmTppt().getCdTppt();
		}

		// Pesquisa o turno
		DwTurno dwturno = trn.pesquisarTurnoById(dwconsolidParametro.getDwTurno().getIdTurno());

		// Obtem a producao enviada pelo cliente
		DwConsol dwconsolParametro = dwconsolidParametro.getDwConsols().iterator().next();

		// Pesquisa produto / Folha
		String cd = dwconsolidParametro.getDwFolha().getCdFolha() + sufixoFolha;
		if(cd.equals("491821")){
			log.info("DEBUG CDDDD");
		}
		DwFolha dwfolha;
		if (dwconsolidParametro.getDwFolha().getIdFolha() == null) {
			dwfolha = frn.pesquisaFolhaByCdEStSemRota(cd);
			dwconsolidParametro.setDwFolha(dwfolha);
		} else {
			dwfolha = dwconsolidParametro.getDwFolha();
		}

		dwconsolidParametro.setOmPt(ompt);
		dwconsolidParametro.setOmGt(omgt);
		dwconsolidParametro.setDwTurno(dwturno);

		if (dwfolha == null) {
			// Alessandre: As linhas abaixo foram comentadas pq eu preciso que a producao seja apontada mesmo
			// que nao tenha a folha, assim, usarei uma  folha qualquer para essa funcao. Na Semp estou recebendo apontamento
			// de producao que nao eh referente a nenhum pt cadastrado, cadastrei os pts, mas agora preciso definir uma folha qq
			// Incluir no log de retorno que a folha nao foi encontrada
//			DwConsolidDTO dwconsolidDTO = new DwConsolidDTO();
//			dwconsolidDTO.setDwConsolid(dwconsolidParametro.clone(false));
//			dwconsolidDTO.getDwConsolid().setDwFolha(new DwFolha());
//			dwconsolidDTO.getDwConsolid().getDwFolha().setCdFolha(cd);
//			dwconsolidDTO.setResultado(dwconsolidDTO.getERRO_FOLHA_DESCONHECIDA());
//			retorno.getListaDwConsolidDTO().add(dwconsolidDTO);
//
//			retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getERRO_DESCONHECIDO());
//			return;
			
			// Definir uma folha para o apontamento
			dwfolha = new DwFolha();
			dwfolha.setIdFolha(null);
			dwfolha.setCdFolha(cd);
			dwfolha.setDsFolha("Folha incluida na importacao da producao");
			dwfolha.setDtRevisao(DataHoraRN.getDataHoraAtual());
			dwfolha.setDtStativo(DataHoraRN.getDataHoraAtual());
			dwfolha.setOmTppt(ompt.getOmTppt());
			dwfolha.setOmUsrByIdUsrrevisao(omusr);
			dwfolha.setOmUsrByIdUsrstativo(omusr);
			dwfolha.setRevisao(1l);
			dwfolha.setSegCiclopadrao(new BigDecimal(60));
			dwfolha.setSegSetup(3600);
			dwfolha.setStAtivo((byte) 1);
			dwfolha.setTpFolha((byte) 6);
			dwfolha.setOmGt(ompt.getOmGt());
			
			dwfolha = dao.makePersistent(dwfolha);
		}

		// Verifica se dwconsolid já existe no cadastro
		DwConsolid dwconsolidPesquisada = crn.pesquisarDwConsolid(
				dwconsolidParametro.getDtReferencia(), dwturno.getIdTurno(),
				ompt, omgt, dwfolha);

		if (dwconsolidPesquisada == null) {
			// Encontra o calendario para poder incluir
			DwCal dwcal = null;

			if (ompt != null)
				dwcal = calrn.pesquisarDwCalByOmPt(ompt);
			else
				dwcal = calrn.pesquisarDwCalByOmGt(omgt);

			// Encontra periodo produtivo
			DwPepro dwpepro = Util.getConfigGeral(dao.getSession()).getDwPeproByIdPepronormal();

			dwconsolidParametro.setDwCal(dwcal);
			dwconsolidParametro.setDwPepro(dwpepro);
			dwconsolidParametro.setDwConsols(null);

			dwconsolidParametro.setStAtivo((byte) 1);
			dwconsolidParametro.setDthrCadastro(DataHoraRN.getDataHoraAtual());
			dwconsolidParametro.setTpId((byte) 1);
			dwconsolidParametro.setDwFolha(dwfolha);

			// Incluir novo dwconsolid
			dao.makePersistent(dwconsolidParametro);
		} else {
			dwconsolidParametro = dwconsolidPesquisada;
		}

		DwConsol dwconsol = null;
		if (dwconsolidPesquisada == null
				|| dwconsolidPesquisada.getDwConsols() == null
				|| dwconsolidPesquisada.getDwConsols().size() <= 0) {
			// Incluir novo dwconsol
			dwconsol = new DwConsol();
			dwconsol.setPcsManuProducaobruta(new BigDecimal(0));
			log.info(idLog, identacao, "Criando novo dwconsol");
		} else {
			dwconsol = dwconsolidPesquisada.getDwConsols().iterator().next();
			log.info(idLog, identacao, "Pesquisado um dwconsol com id "
					+ dwconsol.getIdConsol());
		}

		// Altera a producao para a nova
		dwconsol.setPcsManuProducaobruta(dwconsolParametro.getPcsManuProducaobruta());
		dwconsol.setDwConsolid(dwconsolidParametro);

		// salva dwconsolid
		dao.makePersistent(dwconsol);

		// Atualiza o estoque atual do produto
		atualizarEstoque(dwconsolidParametro, dwconsolParametro.getPcsManuProducaobruta(), false);
	}

	private DwConsolidDTOs retiraElementosRepetidos(DwConsolidDTOs lista){
		DwConsolidDTOs retorno = new DwConsolidDTOs();
		retorno.setListaDwConsolidDTO(new ArrayList<DwConsolidDTO>());
		retorno.setResultadoDTO(lista.getResultadoDTO());
		boolean isPossui = false;
		for(DwConsolidDTO consolidDTO : lista.getListaDwConsolidDTO()){
			for (DwConsolidDTO retornoDTO: retorno.getListaDwConsolidDTO()){
				if(consolidDTO.getResultado() != retornoDTO.getResultado())
					continue;
				
				if((((consolidDTO.getResultado()== consolidDTO.getERRO_FOLHA_DESCONHECIDA())||
						(consolidDTO.getResultado()== consolidDTO.getERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA())) &&
						(consolidDTO.getDwConsolid().getDwFolha().getCdFolha().equals(retornoDTO.getDwConsolid().getDwFolha().getCdFolha())))
					||((consolidDTO.getResultado()== consolidDTO.getERRO_PT_DESCONHECIDO())&&
							(consolidDTO.getDwConsolid().getOmPt().getDepara().equals(retornoDTO.getDwConsolid().getOmPt().getDepara())))){
					isPossui = true;
					break;
				}
				
			}
			if (isPossui==false)
				retorno.getListaDwConsolidDTO().add(consolidDTO);
			else isPossui = false;
		}
		
		
		return retorno;
		//new ArrayList<DwConsolidDTO>();
		//lista.addAll(retorno.getListaDwConsolidDTO());
		/*for(DwConsolidDTO consolidDTO:  retorno.getListaDwConsolidDTO() ){
			for(int j=i+1; j<lista.size(); j++){
				
				}
			}
		}*/
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}
}