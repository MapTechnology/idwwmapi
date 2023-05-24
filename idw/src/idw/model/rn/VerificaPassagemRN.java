package idw.model.rn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwLogvalroteiroDAO;
import idw.model.dao.DwPassagemDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwFolhateste;
import idw.model.pojos.DwLogvalroteiro;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgptdetcoleta;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmHomopt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpnserie;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.PpCpTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.FolhaDTO;
import idw.webservices.dto.FolhasDTO;
import idw.webservices.dto.LoginDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.NaoConformidadeDTO;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.PassagensDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.dto.SessaoDTO;
import idw.webservices.dto.TpptAnteriorDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class VerificaPassagemRN extends PostoPassagemRN {

	public VerificaPassagemRN() {
		super(new DAOGenerico());
	}

	public VerificaPassagemRN(DAOGenerico dao) {
		super(dao);
	}

	public PassagemDTO verificaPassagem(PassagemDTO passagem) throws NumeroSerieIrregularException {
		PassagemDTO retorno = new PassagemDTO();
		NumeroSerieRN rn = new NumeroSerieRN();
		rn.setDaoSession(getDaoSession());

		retorno.setCb(passagem.getCb());
		retorno.setTppt(passagem.getTppt());

		if (passagem.getCb() == null || passagem.getCb().equals("")) { // se nao
																		// for
																		// um
																		// cracha
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_DESCONHECIDO());
			return retorno;
		}
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getDaoSession());
		if (oOmCfg == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getSEM_CONFIGURACAO());
			return (retorno);
		}

		retorno.setOmcfg(oOmCfg);

		
		FolhaRN frn = new FolhaRN();
		frn.getDao().setSession(getDaoSession());
		CpRN rncp = new CpRN(getDao());
		PTRN ptrn = new PTRN();
		ptrn.setDaoSession(this.getDaoSession());
		
		PpCp ppcp = null;
		OmPt ompt = null;
		
		// instancia o ProdutoRN
		ProdutoRN oProdutoRN = new ProdutoRN(getDao());
		// oProdutoRN.getDao().setSession(this.getSession());
		// instancia o UsuarioRN
		UsuarioRN oUsuarioRN = new UsuarioRN(getDao());
		// instancia o LoginRN
		LoginRN oLoginRN = new LoginRN();
		oLoginRN.setSession(getDaoSession());
		// instancia o ConsolidaRN
		// ConsolidaRN oConsolidaRN = new ConsolidaRN();
		// oConsolidaRN.setSession(this.getSession());

		// extrai codigo do produto do codigo de barras
		String cdProduto = Util.extraiPorMascara(passagem.getCb(), oOmCfg.getMascaracdprodutoCB());
		// verifica se o produto existe
		OmProduto oOmProduto = null;
		oOmProduto = oProdutoRN.getProdutoByCdEStAtivo(cdProduto);

		// Se o conteudo extraido nao for um produto valido, entao avaliar se uma plataforma valida
		if (oOmProduto == null) {
			// Verificar se exsite o cadastro de plataforma. Se existir obter o produto atraves do numero de serie
			GrupoProdutoRN grn = new GrupoProdutoRN();
			grn.setDao(getDao());
			grn.setSession(getDaoSession());
			OmProgrp omprogrp = grn.pesquisarOmProgrpByCdStAtivo(cdProduto.trim());
			if (omprogrp != null) {
				// Pesquisar o numero de serie e obter de la o produto
				// obtem o id do numero de serie
				DwNserie oDwNserie = rn.getDwNserieCb(passagem.getCb());
				if (oDwNserie != null)
					oOmProduto = oDwNserie.getOmProduto();

			}
		}

		// Ailton 17/03/17
		// TODO: Validar os impactos deste trecho em outras aplicacoes
		// Modificacao para ficar igual ao caso do EventosRN.savemsevt
		// Se o coletor informar qual o produto acoplado entao usar o informado
		if (oOmProduto == null && passagem.getIdProduto() > 0l) {
			oOmProduto = getDao().findById(OmProduto.class, passagem.getIdProduto(), false);
			cdProduto = oOmProduto.getCdProduto();
		}

		// Se nao for um produto ou plataforma validos verificar se os produtos esperados na OP estao contidos no CB
		if (oOmProduto == null) {
			if (passagem.getIdPt() != 0)
				ompt = ptrn.getDao().findById(OmPt.class, passagem.getIdPt(), false);
			else {
				try {
					ompt = ptrn.getOmPt(passagem.getCdPt());
					passagem.setIdPt(ompt.getIdPt());
					passagem.setIdGt(ompt.getOmGt().getIdGt());
				} catch (RegistroDesconhecidoException e1) {

				}
			}
			// Pesquisar a OP e pegar a folha da OP
			ppcp = rncp.pesquisarPpCpByNrDocCdPt(passagem.getCdOp(), ompt.getCdPt());
			for (PpCpproduto cpproduto : ppcp.getPpCpprodutos()) {
				if (passagem.getCb().contains(cpproduto.getOmProduto().getCdProduto())) {
					oOmProduto = cpproduto.getOmProduto();
				}
			}
		}

		// Verifica se existe o ns. Se existir usar o produto q esta nele
		// List<OmPt> listaOmPt = null;
		DwNserie oDwNserie = null;
		// obtem o id do numero de serie
		oDwNserie = rn.getDwNserieCb(passagem.getCb());
		if (oDwNserie != null)
			oOmProduto = oDwNserie.getOmProduto();

		if (oOmProduto == null) { // se n�o existir registro de produto
			// verifica se o CB lido � de um cracha
			OmUsr oOmUsr = null;
			oOmUsr = oUsuarioRN.getUsuarioByCdEStAtivo(passagem.getCb());

			if (oOmUsr == null) { // se nao for um cracha
				retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_DESCONHECIDO());
			} else { // se for cracha
				DwConsolmolog oDwConsolmolog = null;

				// verifica se eh operador ou supervisor
				if (oOmUsr.getOmUsrgrp().getIdUsrgrp() == passagem.getIdGrpUsrSupervisor()) { // se
																								// supervisor
					// (om_usr.id_grpusr =
					// passagem.id_grpusrSupervisor)
					// verifica se est� logado no GT
					oDwConsolmolog = oLoginRN.getDwConsolmologGt(oOmUsr.getIdUsr(), passagem.getIdGt());

					if (oDwConsolmolog == null) { // se nao tiver logado no GT
						retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGON_DE_SUPERVISOR());
					} else { // se estiver logado no GT
						retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGOFF_DE_SUPERVISOR());
					}
				} else { // se operador, aferidor ou tecnico manutencao
					LoginDTO login = new LoginDTO();
					login.setIdPt(passagem.getIdPt());
					login.setIdUsr(oOmUsr.getIdUsr());
					LoginRN lrn = new LoginRN();
					lrn.setSession(getDaoSession());
					OmHomopt oOmUsrPt = null;
					oOmUsrPt = lrn.getOmUsrPt(login);

					if (oOmUsrPt == null || oOmUsrPt.getTpHomopt() == null) {
						// System.out.println("Nao encontrou homologacao pt=" +
						// login.getIdPt() + " usuario=" + login.getIdUsr());
						retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGIN_NAO_HOMOLOGADO());
						return retorno;
					}
					// Se o direito de acesso for tecnico de manuten��o ERRO
					// ABAIXO NULL POINTER
					if (oOmUsrPt.getTpHomopt() == (byte) 2) /* manutencao */ {
						retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGIN_MANUTENCAO());
						return retorno;
					}
					// Se o direito de acesso for aferidor
					if (oOmUsrPt.getTpHomopt() == (byte) 1) /* afericao */ {
						retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGIN_AFERICAO());
						return retorno;
					}

					// verifica se est� logado no PT
					oDwConsolmolog = oLoginRN.getDwConsolmologPt(oOmUsr.getIdUsr(), passagem.getIdPt());

					if (oDwConsolmolog == null) { // se nao tiver logado no PT
						retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGON_DE_OPERADOR());
					} else { // se estiver logado (om_usr.id_usr =
								// passagem.id_usr) {
						retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGOFF_DE_OPERADOR());
					}
				}
			}

			return (retorno);
		} else { // se existir produto
			retorno.setIdProduto(oOmProduto.getIdProduto());
			retorno.setCdproduto(oOmProduto.getCdProduto());
		}

		DwFolha oDwFolha = null;
		List<DwFolha> lDwFolha = null;
		// verifica se cumpriu o roteiro com sucesso
		// obtem o roteiro para o produto e fabrica avaliado
		DwRotapasso oDwRotapasso = null;
		DwRota oDwRota = null;
		oDwRota = this.getRotaProduto(passagem.getIdGt(), retorno.getIdProduto());

		// se nao existir Rota para esse produto
		if (oDwRota == null && oOmProduto.getIsRequerroteiro() != null && oOmProduto.getIsRequerroteiro()) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getROTEIRO_INCONSISTENTE());
			return (retorno);
		} else if (oDwRota == null) {
			if (ompt == null) {
				if (passagem.getIdPt() != 0)
					ompt = ptrn.getDao().findById(OmPt.class, passagem.getIdPt(), false);
				else {
					try {
						ompt = ptrn.getOmPt(passagem.getCdPt());
					} catch (RegistroDesconhecidoException e1) {

					}
				}
			}
			if (ppcp == null)
				ppcp = rncp.pesquisarPpCpByNrDocCdPt(passagem.getCdOp(), ompt.getCdPt());
			// se nao tiver roteiro e realmente nao for exigido
			// entao devemos retornar apenas os defeitos
			oDwFolha = frn.getDwFolhaAtiva(ppcp); 
		} else { // se achou rota
			if (oDwRota.getIsPassaadiante() != null)
				retorno.setPassaadiante(oDwRota.getIsPassaadiante());
			else
				retorno.setPassaadiante(true);

			// obtem folha que deveria ser usada no posto de passagem
			lDwFolha = this.getFolhaPosto(passagem.getIdTppt(), passagem.getIdGt(), oDwRota.getIdRota());

			// varias folhas ser�o obtidas, descobrir qual delas est� sendo
			// usada no roteiro
			// pegar rotapasso

			if (lDwFolha == null || lDwFolha.size() <= 0) { // se n�o encontrar
				// System.out.println("Nao encontrou folha para idGt=" +
				// passagem.getIdGt() + " tppt=" + passagem.getIdTppt() + " da
				// rota=" + oDwRota.getIdRota());
				retorno.getResultado().setIdmensagem(retorno.getResultado().getROTEIRO_INCONSISTENTE());
				return (retorno);
			}
			oDwFolha = lDwFolha.get(0);

			lDwFolha = null;

			// Se mais de um rotapasso existir para a folha encontrada e para o
			// roteiro, entao retornar roteiro inconsistente
			if (oDwFolha.getDwRotapassos().size() > 1) {
				// System.out.println("Mais de um passo para a folha " +
				// oDwFolha.getIdFolha());
				retorno.getResultado().setIdmensagem(retorno.getResultado().getROTEIRO_INCONSISTENTE());
				return (retorno);
			}
			for (DwRotapasso temp : oDwFolha.getDwRotapassos()) {
				oDwRotapasso = temp;
			}
		}
		
		
		// obtem os postos predecessores
		// List<DwRpPredecessora> listaDwRpPredecessora = null;
		// listaDwRpPredecessora =
		// this.getDwRpPredecessoraRotaPasso(oDwRotapasso.getIdRotapasso());
		if (oDwNserie == null) { // se n�o existir, incluir
			oDwNserie = new DwNserie();

			oDwNserie.setCb(Util.extraiPorMascara(passagem.getCb(), oOmCfg.getMascaracb()));

			// ns eh igual a substring da posicao 11 ateh a posicao 19,
			// inclusive
			if (passagem.getCb() == null || oOmCfg.getMascaracb() == null || passagem.getCb().length() < oOmCfg.getMascaracb().length()) {
				// oDwNserie.setNs(passagem.getCb());
				throw new NumeroSerieIrregularException();
			} else {
				oDwNserie.setNs(passagem.getCb()); // aqui tah ateh 20, pois a
													// funcao substring, para a
													// ultima posicao, eh
													// exclusiva
			}

			oDwNserie.setOmProduto(oOmProduto);

			NumeroSerieRN nrn = new NumeroSerieRN(getDao());
			oDwNserie.setSequencial(nrn.getProximoSequencial(oOmProduto));

			// insert into dw_nserie (cb, ns, id_produto) values (passagem.cb,
			// ns, retorno.id_produto)
			this.getDaoSession().save(oDwNserie);
			// TODO: se der erro no insert?????????
		}

		PassagemDTO pnc;
		if (oDwRota != null) {
			pnc = obtemNaoConformidadesAtuais(passagem.getCb(), oDwRota.getIdRota(), passagem.getTppt(), passagem.getCdOp(), ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()));
		} else {
			pnc = obtemNaoConformidadesAtuais(passagem.getCb(), 0, passagem.getTppt(), passagem.getCdOp(), ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()));
		}

		// Remover as nao-conformidades dos passos posterioes ao passo analisado
		// eh o mesmo que ficar apenas com as nao-conformidades anterior ao
		// passo atual
		// 1o - Montar a lista de tppt anteriores
		// 2o - Remover os tppt diferentes dos tppts anteriores encontrados da
		// lista de nao conformidade
		boolean isNC = false;
		for (Integer tppt : pnc.getTpptAnterioes()) {
			for (NaoConformidadeDTO nco : pnc.getNaoConformidadesAtuais()) {
				if (nco.getTppt() == tppt)
					isNC = true;
			}
		}
		// Se ainda existirem nao-conformidades, retornar que produto entrou no
		// pt nao conforme
		if (isNC == true) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_ENTROU_NAO_CONFORME());
		} else {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());
		}

		// O retorno recebe a lista de nao conformidades para qdo for o teste
		// eletrico nao salvar o estoque configurado no roteiro
		// se existir alguma nao conformidade
		retorno.setNaoConformidadesAtuais(new ArrayList<NaoConformidadeDTO>());
		for (NaoConformidadeDTO nco : pnc.getNaoConformidadesAtuais()) {
			for (Integer tppt : pnc.getTpptAnterioes()) {
				if (nco.getTppt() == tppt) {
					retorno.getNaoConformidadesAtuais().add(nco);
				}
			}
		}

		// Ate aqui eh a verificacao da passagem

		retorno.setDwfolha(oDwFolha);
		retorno.setDwnserie(oDwNserie);
		retorno.setDwrotapasso(oDwRotapasso);
		retorno.setIdFolha(oDwFolha.getIdFolha());
		retorno.setIdNSerie(oDwNserie.getIdNserie());

		// Se for um posto de montagem, retorna a lista de montagem
		SessaoDTO ses = new SessaoDTO();
		if (passagem.getTppt() == ses.PT_MONTAGEM) {
			// Inicializa a composicao da montagem se existir
			retorno.setSegTempoParafusadeira(oDwFolha.getSegCiclopadrao());
			retorno.getListaMontagem().clear();
			for (DwFolhamon dwfolhamon : oDwFolha.getDwFolhamons()) {
				for (DwFolhamoncomp dwfolhamoncomp : dwfolhamon.getDwFolhamoncomps()) {
					MontagemDTO mon = new MontagemDTO();
					mon.setCb(dwfolhamoncomp.getOmProduto().getCdProduto());
					mon.setDsProdutoEsperado(dwfolhamoncomp.getOmProduto().getOmProdutoByIdProdutoagru().getDsProduto());
					mon.setIdProdutoEsperado(dwfolhamoncomp.getOmProduto().getIdProduto());
					mon.setOrdem(dwfolhamoncomp.getOrdem());
					mon.setIdProdutoAgrupador(dwfolhamoncomp.getOmProduto().getOmProdutoByIdProdutoagru().getIdProduto());

					// Verifica se agrupado do item para montagem ja existe no
					// ListaMontagem. Se existir, nao inserir novamente
					boolean isExiste = false;
					for (MontagemDTO m : retorno.getListaMontagem()) {
						if (m.getIdProdutoAgrupador() == mon.getIdProdutoAgrupador()) {
							isExiste = true;
						}
					}
					if (isExiste == false)
						retorno.getListaMontagem().add(mon);
				}
			}
			// Ordena a lista de montagem
			Collections.sort(retorno.getListaMontagem(), new Comparator<MontagemDTO>() {
				@Override
				public int compare(MontagemDTO o1, MontagemDTO o2) {
					MontagemDTO p1 = (MontagemDTO) o1;
					MontagemDTO p2 = (MontagemDTO) o2;
					return p1.getOrdem() < p2.getOrdem() ? -1 : (p1.getOrdem() > p2.getOrdem() ? +1 : 0);
				}
			});
		}

		// Se for um posto de teste funcional, retorna a receita de testes
		if (passagem.getTppt() == ses.PT_TESTE_FUNCIONAL) {


			FolhaDTO folha = new FolhaDTO();
			DwFolha dwf = new DwFolha();
			dwf.setIdFolha(oDwFolha.getIdFolha());
			folha.setFolha(dwf);
			folha.setPesquisaEtapasRevisao(false);
			FolhasDTO folhas = frn.getFolhasDTO(folha);
			folha = folhas.getFolhas().get(0);
			folha.setMensagemTensaoAbaixoMinima(oOmCfg.getDsMensagemsubtensao());
			folha.setMensagemTensaoAcimaMaxima(oOmCfg.getDsMensagemsobretensao());
			folha.setSalvarDetalhe(false);
			Set<OmCfgptdetcoleta> clpsColetaTotal = oOmCfg.getOmCfgptdetcoletas();
			for (OmCfgptdetcoleta o : clpsColetaTotal) {
				if (o.getOmPt().getIdPt() == passagem.getIdPt()) {
					folha.setSalvarDetalhe(true);
					break;
				}
			}
			retorno.setReceitaTeste(folha);
		}

		// Se for um reprocesso, entao obter a receita de testes do produto para
		// o gt fabrica
		if (passagem.getTppt() == ses.PT_TESTE_REPROCESSO) {
			FolhaDTO folha = new FolhaDTO();

			DwFolha dwf = new DwFolha();
			OmGt gt = new OmGt();
			gt.setIdGt(passagem.getIdGt());
			dwf.setOmGt(gt);
			dwf.setStAtivo((byte) 1);
			DwFolhateste dwft = new DwFolhateste();
			dwft.setOmProduto(oOmProduto);
			dwf.getDwFolhatestes().add(dwft);
			folha.setFolha(dwf);
			folha.setPesquisaEtapasRevisao(true);

			FolhasDTO folhas = frn.getFolhasDTO(folha);
			// Se nao encontrar uma folha
			if (folhas.getFolhas().size() <= 0) {
				retorno.getResultado().setIdmensagem(retorno.getResultado().getROTEIRO_INCONSISTENTE());
				return (retorno);
			}
			folha = folhas.getFolhas().get(0);
			folha.setMensagemTensaoAbaixoMinima(oOmCfg.getDsMensagemsubtensao());
			folha.setMensagemTensaoAcimaMaxima(oOmCfg.getDsMensagemsobretensao());
			folha.setSalvarDetalhe(false);
			Set<OmCfgptdetcoleta> clpsColetaTotal = oOmCfg.getOmCfgptdetcoletas();
			for (OmCfgptdetcoleta o : clpsColetaTotal) {
				if (o.getOmPt().getIdPt() == passagem.getIdPt()) {
					folha.setSalvarDetalhe(true);
					break;
				}
			}
			retorno.setReceitaTeste(folha);
		}

		if (retorno.getDwfolha().getIdFolha() == 0) {
			// System.out.println("Folha nula");
		}
		return (retorno);
	}

	public static void main(String[] args) {
		VerificaPassagemRN rn = new VerificaPassagemRN();
		rn.iniciaConexaoBanco();
		String cdpt = "EMB_LIN04";
		String cb = "C03DD94A4CB8"; // "A433D797FF40";

		PassagensDTO ret = rn.getPassagens(cdpt, cb);
		System.out.println("NCs");
		for (NaoConformidadeDTO ncdto : ret.getNcs()) {
			System.out.println(ncdto.getDsNaoConformidade());
		}
		System.out.println("passagens");
		for (PassagemDTO dto : ret.getListaPessagem()) {
			System.out.println(dto.getCdPt() + " dthr " + dto.getDtHrEvento() + " result:" + dto.getResultado().getIdmensagem());
		}
		rn.finalizaConexaoBanco();
	}

	/* Metodo para obtencao das nao confirmidades a partir do PassagemDTO. Esse metodo chama o metodo principal que recebe Roteiro, cb e tipo posto */
	public PassagemDTO obtemNaoConformidadesAtuais(PassagemDTO passagem) {
		// instancia o ProdutoRN
		ProdutoRN oProdutoRN = new ProdutoRN();
		oProdutoRN.getDao().setSession(this.getDaoSession());

		DwRota oDwRota = null;

		String cdProduto = passagem.getCb(); // Util.extraiPorMascara(passagem.getCb(), omcfg.getMascaracdprodutoCB());
		OmPt ompt = null;

		if (passagem.getCdPt() != null && passagem.getCdPt().equals("") == false) {
			PTRN rn = new PTRN(getDao());
			try {
				ompt = rn.getOmPt(passagem.getCdPt());
			} catch (RegistroDesconhecidoException e) {
				return passagem;
			}
			passagem.setIdGt(ompt.getOmGt().getIdGt());
			passagem.setIdTppt(ompt.getOmTppt().getIdTppt());

		}
		// verifica se o produto existe
		OmProduto oOmProduto = null;
		oOmProduto = oProdutoRN.getProdutoByCdEStAtivo(cdProduto);

		if (oOmProduto == null) {
			// Obtem o produto a partir da OP carregada no posto
			if (ompt != null && ompt.getPpCp() != null)
				oOmProduto = ompt.getPpCp().obtemPrimeiroProduto();
		}

		if (oOmProduto != null)
			oDwRota = this.getRotaProduto(passagem.getIdGt(), oOmProduto.getIdProduto());// oOmProduto.

		PassagemDTO retorno = null;

		if (passagem.getIsAvaliarRoteiro()) {
			if (oDwRota == null) {
				retorno = new PassagemDTO();
				retorno.setResultado(new ResultadoDTO());
				retorno.getResultado().setIdmensagem(retorno.getResultado().ROTEIRO_INCONSISTENTE);
			} else {
				retorno = obtemNaoConformidadesAtuais(
						passagem.getCb(),
						oDwRota.getIdRota(),
						(int) passagem.getIdTppt(),
						ompt.getPpCp().getNrop(),
						ompt.getPpCp().getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue())
						);
			}
		} else {
			retorno = obtemNaoConformidadesAtuais(
					passagem.getCb(),
					0 /* oDwRota.getIdRota() nesse ponto roteiro nao existe */,
					0/* (int) passagem.getIdTppt() */,
					passagem.getCdOp(),
					false
					);
		}
		return retorno;
	}

	private List<Integer> obtemRecursivamenteTpptAnteriores(List<TpptAnteriorDTO> listaTpptAnteriores, int tppt) {
		List<Integer> retorno = new ArrayList<Integer>();
		if (listaTpptAnteriores == null)
			return retorno;

		for (TpptAnteriorDTO tpptAnteriorDTO : listaTpptAnteriores) {
			if (tpptAnteriorDTO.getTppt() == tppt)
				for (Integer tpptPredecessora : tpptAnteriorDTO.getTpptImediatamenteAnterior()) {
					retorno.add(tpptPredecessora);
					retorno.addAll(obtemRecursivamenteTpptAnteriores(listaTpptAnteriores, tpptPredecessora));
				}
		}
		return retorno;
	}

	private List<OmTppt> obtemRecursivamenteOmTppt(List<OmTppt> omtpptAnteriores, List<DwRotapasso> listaDwrotapasso) {
		List<OmTppt> retorno = new ArrayList<>();
		for (OmTppt omtppt : omtpptAnteriores) {
			for (DwRotapasso passo : listaDwrotapasso) {
				if (passo.getDwFolha().getOmTppt().getIdTppt() == omtppt.getIdTppt()) {
					for (DwRpPredecessora pre : passo.getDwRpPredecessorasForIdRotapassoPai()) {
						retorno.add(pre.getDwRotapassoByIdRotapassoFilho().getDwFolha().getOmTppt());
					}
				}
			}
		}
		if (retorno.isEmpty() == false) {
			retorno.addAll(obtemRecursivamenteOmTppt(retorno, listaDwrotapasso));
		}
		return retorno;
	}

	private DwNserie obtemPlaca(DwNserie ns) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select c");
		q.append("from DwPassagem a");
		q.append("join a.dwNserie b");
		q.append("join a.dwPassmons c");
		q.append("where b.cb = :cb");
		q.append("and c.ordem = 1");
		q.append("and c.dsMon is null");
		q.append("order by c.idPassmon");

		q.setMaxResults(1);
		q.defineParametro("cb", ns.getCb());

		DwPassmon passmon = (DwPassmon) q.uniqueResult();

		DwNserie retorno = null;
		if (passmon != null) {
			NumeroSerieRN rn = new NumeroSerieRN(getDao());
			try {
				retorno = rn.getDwNserieCb(passmon.getCb());
			} catch (NumeroSerieIrregularException e) {
				retorno = null;
			}
		}
		return retorno;
	}

	/*
	 * Metodo para identificar quais as não conformidades de determinado NS considerando o roteiro e o tipo do posto
	 * 
	 */
	public PassagemDTO obtemNaoConformidadesAtuais(String cb, long idRota, int tpptPasso, String nrop, boolean isRetrabalho) {
		PassagemDTO retorno = new PassagemDTO();
		if (cb == null || cb.equals("")) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCB_NULO());
			return retorno;
		}
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getDaoSession());
		if (oOmCfg == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getSEM_CONFIGURACAO());
			return (retorno);
		}

		NumeroSerieRN rn = new NumeroSerieRN();
		rn.setDaoSession(getDaoSession());

		DwNserie oDwNserie = null;

		// obtem o id do numero de serie
		try {
			oDwNserie = rn.getDwNserieCb(cb);
		} catch (NumeroSerieIrregularException e) {
			oDwNserie = null;
		}

		if (oDwNserie == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_DESCONHECIDO());

			NaoConformidadeDTO nc = new NaoConformidadeDTO();
			nc.setDsCurta("desconhecido");
			nc.setDsNaoConformidade("CB " + cb + " desconhecido. Sem teste.");
			nc.setCdPt("");
			nc.setDthrNC(DataHoraRN.getDataHoraAtual());
			retorno.getNaoConformidadesAtuais().add(nc);

			return retorno;
		}

		// Se for um posto de reprocesso, retorna as ultimas nao conformidades
		// Obter os defeitos atuais do numero de serie avaliado
		// Os defeitos atuais s�o todos aqueles ocorridos depois da ultima
		// passagem pelo reprocesso do produto
		// Se nunca passou pelo reprocesso ent�o todos os defeitos serao
		// considerados. Alem disso, apenas a ultima passagem
		// por tipo de posto deve ser considerada.
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select distinct dwpassagem ");
		q.append("from DwPassagem dwpassagem ");
		q.append("join fetch dwpassagem.omPt ompt ");
		q.append("join fetch ompt.omTppt omtppt ");
		q.append("left join fetch dwpassagem.dwPassdefs dwpassdef ");
		q.append("left join fetch dwpassdef.dwTDefeito dwtdefeito ");
		q.append("left join fetch dwpassagem.dwPasstfs dwpasstf ");
		
		if (isRetrabalho) {
			q.append("join dwpassagem.dwConsolid dwconsolid");
			q.append("join dwconsolid.ppCp ppcp");
			q.append("join ppcp.ppCpprodutos ppcpproduto");
		}
		
		q.append("where dwpassagem.dwNserie.idNserie in (:idnserie) ");
		
		if (isRetrabalho) {
			q.append("and ppcpproduto.nrDoc = :nrdoc");
		}
		q.append("order by omtppt.idTppt asc, dwpassagem.idPassagem desc"); 

		if (isRetrabalho) {
			q.defineParametro("nrdoc", nrop);
		}
		
		List<Object> ids = new ArrayList<>();
		ids.add(oDwNserie.getIdNserie());

		DwNserie placa = obtemPlaca(oDwNserie);
		if (placa != null)
			ids.add(placa.getIdNserie());

		q.defineListaParametro("idnserie", ids);

		List<DwPassagem> lista = q.list();

		/*
		 * Para cada tipo de posto salvar o maior idPassagem. Nesse caso o idPassagem maior representa a ultima passagem do NS nesse tipo de
		 * posto Logo se essa ultima passagem tiver conforme as NAO CONFORMIDADES anteriores nesse tipo de posto devem ser descartadas Nao
		 * se pode usar o campo dwpassagem.dthr pois pode haver falta de sincronia de hroarios entre os coletores das passagens
		 */
		Map<OmTppt, DwPassagem> ultimasPassagensPorTipoPosto = new HashMap<>();

		List<NaoConformidadeDTO> listaNaoConformidades = new ArrayList<>();
		List<DwPassagem> listaConformidade = new ArrayList<>();

		for (DwPassagem dp : lista) {

			// Salva ultima passagem por tipo do posto
			DwPassagem ultimaPassagem = dp;
			if (ultimasPassagensPorTipoPosto.containsKey(dp.getOmPt().getOmTppt())) {
				ultimaPassagem = ultimasPassagensPorTipoPosto.get(dp.getOmPt().getOmTppt());
//				if (dp.getOmPt().getOmTppt().getCdTppt().equals("PKFT"))
//					System.out.println(dp.getIdPassagem() + " - ultimaPassagem para " + dp.getOmPt().getOmTppt().getCdTppt() + " na data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dp.getDthr()) + " result:" + dp.getStNserie());
			}

			// Se a passagem atual for maior que a ultima salva, entao a ultima salva passa a ser a atual
			if (dp.getIdPassagem() >= ultimaPassagem.getIdPassagem() ) {
				ultimasPassagensPorTipoPosto.put(dp.getOmPt().getOmTppt(), dp);
//				if (dp.getOmPt().getOmTppt().getCdTppt().equals("PKFT"))
//					System.out.println(dp.getIdPassagem() + " - OMTTPT ultimaPassagem para " + dp.getOmPt().getOmTppt().getCdTppt() + " na data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dp.getDthr())  + " result:" + dp.getStNserie());
				
			}

			if (dp.getStNserie().equals((byte) 0)) {

				/*
				 * Se existe uma dwPassagem maior que essa em avaliação, e a maior está CONFORME, então devemos desconsiderar essa passagem
				 * 
				 */
				if (ultimaPassagem.getIdPassagem() > dp.getIdPassagem() && ultimaPassagem.getStNserie().equals((byte) 1))
					continue;

				if (dp.getDwPassdefs() != null && dp.getDwPassdefs().isEmpty() == false) {
					for (DwPassdef dwpassdef : dp.getDwPassdefs()) {
						NaoConformidadeDTO dto = new NaoConformidadeDTO();
						dto.setCdPt(dp.getOmPt().getCdPt());
						dto.setDsCurta(dp.getOmPt().getDsCurta());
						dto.setDsNaoConformidade(dwpassdef.getDwTDefeito().getCdTdefeito() + " - " + dwpassdef.getDwTDefeito().getDsTdefeito());
						dto.setDthrNC(dp.getDthr());
						dto.setIdPassagem(dp.getIdPassagem());
						dto.setIdPassdef(dwpassdef.getIdPassdef());
						dto.setTppt(dp.getOmPt().getOmTppt().getIdTppt().intValue());
						dto.setIdTDefeito(dwpassdef.getDwTDefeito().getIdTdefeito());
						dto.setPosicoes(dwpassdef.getDsPosicaomecanica());
						dto.setCb(dp.getDwNserie().getCb());

						if (dwpassdef.getDwTArea() != null)
							dto.setAreaResponsavel(dwpassdef.getDwTArea().getCdArea() + "-" + dwpassdef.getDwTArea().getDsArea());
						else
							dto.setAreaResponsavel("");

						listaNaoConformidades.add(dto);
					}
				} else {
					NaoConformidadeDTO dto = new NaoConformidadeDTO();
					dto.setCdPt(dp.getOmPt().getCdPt());
					dto.setDsCurta(dp.getOmPt().getDsCurta());
					dto.setDsNaoConformidade("Teste falhou");
					dto.setDthrNC(dp.getDthr());
					dto.setIdPassagem(dp.getIdPassagem());
					dto.setIdPassdef(0l);
					dto.setIdTDefeito(null);
					dto.setTppt(dp.getOmPt().getOmTppt().getIdTppt().intValue());
					dto.setCb(dp.getDwNserie().getCb());
					listaNaoConformidades.add(dto);
				}
			} else {
				// Nesse ponto a passagem está conforme

				listaConformidade.add(dp);

			}
		}
		retorno.setNaoConformidadesAtuais(listaNaoConformidades);

		// Verifica por quais tipos de postos deveria ter passado e n�o passou
		// Os postos pelos quais passou estao relacionados em
		// retorno.getnaoConformidadesAtuais e listaConformidades
		// Os postos que deveria passar e n�o passou devem ser incluidos em
		// retorno.getNaoConformidadesAtuais
		if (idRota > 0l) {
			q = null;
			q = new MapQuery(getDaoSession());

			q.append("select dwrotapasso ");
			q.append("from DwRotapasso dwrotapasso ");
			q.append("join fetch dwrotapasso.dwFolha dwfolha ");
			q.append("join fetch dwfolha.omTppt omtppt ");
			q.append("left join fetch dwrotapasso.dwRpPredecessorasForIdRotapassoPai dwrotapassopredecessora ");
			q.append("where dwrotapasso.dwRota.idRota = :idrota and ");
			q.append(
					"(exists (from DwRpPredecessora dwrppredecessora where dwrppredecessora.dwRotapassoByIdRotapassoPai.idRotapasso = dwrotapasso.idRotapasso) ");
			q.append("or ");
			q.append(
					"exists (from DwRpPredecessora dwrppredecessora where dwrppredecessora.dwRotapassoByIdRotapassoFilho.idRotapasso = dwrotapasso.idRotapasso) ");
			q.append(") ");

			q.defineParametro("idrota", idRota);

			List<DwRotapasso> listaDwrotapasso = q.list();

			List<TpptAnteriorDTO> listaTpptAnterioresAoTpptAvaliado = new ArrayList<TpptAnteriorDTO>();

			// Testar se listaDwrotapasso for null
			if (listaDwrotapasso != null) {

				// Primeira coisa eh atraves do roteiro obter a relacao dos tppt anteriores ao tppt que está em avaliacao. Para isso
				// localizamos a folha do tppt em avaliacao e pegamos as predecessoras
				// Com base na lista das predecessoras obtemos recursivamente os omttpt dessas predecessoras
				List<OmTppt> omtpptAnteriores = new ArrayList<>();

				for (DwRotapasso rp : listaDwrotapasso) {
					if (rp.getDwFolha().getOmTppt().getIdTppt() == tpptPasso) {
						for (DwRpPredecessora dwrpp : rp.getDwRpPredecessorasForIdRotapassoPai()) {
							omtpptAnteriores.add(dwrpp.getDwRotapassoByIdRotapassoFilho().getDwFolha().getOmTppt());
						}

						// Apos montar a lista com os omTpptAnteriores obter recursivamente os predecessores dos mesmos
						List<OmTppt> aux = obtemRecursivamenteOmTppt(omtpptAnteriores, listaDwrotapasso);
						omtpptAnteriores.addAll(aux);
					}
				}

				// Para cada passo anterior verificar se passou ou se passou com nao conformidade
				for (OmTppt omtppt : omtpptAnteriores) {
					// Procura se o tipo do posto esta presente na
					// listaConformidade ou em retorno.getNaoConformidades
					boolean isExiste = false;
					for (NaoConformidadeDTO nc : listaNaoConformidades) {
						if (nc.getTppt() == omtppt.getIdTppt())
							isExiste = true;
					}
					// isExiste == false == o Tppt NAO esta presente na lista de
					// CONFORMIDADE
					if (isExiste == false) {
						for (DwPassagem nc : listaConformidade) {
							if (nc.getDwConsolid().getDwFolha().getOmTppt().getIdTppt() == omtppt.getIdTppt())
								isExiste = true;
						}
					}
					// Se nao existir nem na lista de CONFORMIDADE nem na lista
					// de NAO-CONFORMIDADES, incluir como nao conformidade
					if (isExiste == false) {
						NaoConformidadeDTO nc = new NaoConformidadeDTO();
						nc.setDsNaoConformidade("Não passou " + omtppt.getCdTppt());
						nc.setDsCurta("Não passou");
						nc.setDsPt(omtppt.getDsTppt());
						nc.setCdPt(omtppt.getCdTppt());
						nc.setTppt(omtppt.getIdTppt().intValue());
						retorno.getNaoConformidadesAtuais().add(nc);
					}
				}
			}
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());

			// Finaliza montando a lista dos tpptsAnteriores
			retorno.setTpptAnterioes(obtemRecursivamenteTpptAnteriores(listaTpptAnterioresAoTpptAvaliado, tpptPasso));
		}

		return retorno;
	}

	public PassagensDTO getPassagens(String cdPt, String cb) {
		IdwLogger log = new IdwLogger(cdPt + "getPassagens");
		int idLog = log.getIdAleatorio();

		PassagensDTO retorno = new PassagensDTO();
		log.iniciaAvaliacao(idLog, "getPassagens");

		if (cb == null || cb.trim().equals("")) {
			log.mostrarAvaliacaoCompleta();
			return retorno;
		}

		try {
			log.iniciaAvaliacao(idLog, "obtendo rastreabilidade pt " + cdPt + " cb=" + cb);
			DwPassagemDAO dwPassagemDAO = new DwPassagemDAO(getDaoSession());
			List<DwPassagem> lista = dwPassagemDAO.getPassagens(cb);
			retorno.setListaPessagem(new ArrayList<PassagemDTO>());

			OmPt ompt1o = null;
			boolean isPrimeiro = true;
			int contador = 0;
			for (DwPassagem dwpassagem : lista) {
				if (isPrimeiro) {
					ompt1o = dwpassagem.getOmPt();
					isPrimeiro = false;
				}
				contador++;
				if (contador <= 50) {
					PassagemDTO dto = new PassagemDTO();
					dto.setCb(dwpassagem.getDwNserie().getCb());
					dto.setCdPt(dwpassagem.getOmPt().getCdPt());
					dto.setDtHrEvento(dwpassagem.getDthr());
					dto.setCdOp(dwpassagem.getDwConsolid().getPpCp().getNrop());
					dto.setCdproduto(dwpassagem.getDwConsolid().getPpCp().obtemPrimeiroProduto().getCdProduto());
					dto.getResultado().setIdmensagem(dwpassagem.getStNserie().intValue());
					dto.setDiarioBordo(dwpassagem.getDsDiariobordo());
					
					// Se a passagem houver sido cancelada, acrescentar uma nao conformidade
					if (dwpassagem.getStAtivo() != null && dwpassagem.getStAtivo().equals((byte) 0)) {
						dto.getResultado().setIdmensagem(-1);
						NaoConformidadeDTO nc = new NaoConformidadeDTO();
						nc.setDsNaoConformidade(dwpassagem.getDsDiariobordo());
						dto.getNaoConformidadesAtuais().add(nc);
					} else if (dwpassagem.getStNserie().equals((byte) 0)) {
						NaoConformidadeDTO nc = new NaoConformidadeDTO();
						StringBuilder ds = new StringBuilder();
						if (dwpassagem.getDwPassdefs().isEmpty() == false) {
							DwPassdef dwpassdef = dwpassagem.getDwPassdefs().iterator().next();
							ds.append(dwpassdef.getDwTDefeito().getCdTdefeito());
							ds.append(" - ");
							ds.append(dwpassdef.getDwTDefeito().getDsTdefeito());
						} else {
							ds.append("desconhecido");
						}
						nc.setDsNaoConformidade(ds.toString());
						dto.getNaoConformidadesAtuais().add(nc);
					}
					
					retorno.getListaPessagem().add(dto);
					dto.setListaMontagem(new ArrayList<MontagemDTO>());
					for (DwPassmon dwpassmon : dwpassagem.getDwPassmons()) {
						MontagemDTO montagemdto = new MontagemDTO();
						
						montagemdto.setCb(dwpassmon.getCb());
						
						dto.getListaMontagem().add(montagemdto);
					}
				}
				
			}
			log.mostrarAvaliacaoCompleta();

			// Obter as nao conformidades do cb passado
			PassagemDTO filtroNC = new PassagemDTO();
			if (cdPt != null && cdPt.trim().equals("") == false)
				filtroNC.setCdPt(cdPt);
			else if (ompt1o != null){
				filtroNC.setCdPt(ompt1o.getCdPt());
				cdPt = filtroNC.getCdPt();
			} else {
				throw new RegistroDesconhecidoException();
			}
			
			filtroNC.setCb(cb);
			
			// Se nao existe nenhuma passagem, entao retornar vazio
			if (filtroNC.getCdPt() == null) {
				return retorno;
			}

			// Verificar se existe um roteiro definido para o GT ao qual o posto pertence
			// e se esse roteiro eh referente ao produto que está sendo produzido pela OP
			RoteiroRN rrn = new RoteiroRN(getDao());
			DwRota dwrotaGtProduto = rrn.getDwRotaByGtProduto(filtroNC.getCdPt());
			// if (cdPt.contains("LIN01") ||
			// cdPt.contains("LIN02") ||
			// cdPt.contains("LIN03") ||
			// cdPt.contains("LIN04") ||
			// // ompt.getCdPt().contains("LIN06") ||
			// cdPt.contains("LIN07") ||
			// cdPt.contains("LIN08")
			// // ompt.getCdPt().contains("LIN16")
			// ) {
			if (dwrotaGtProduto != null) {
				filtroNC.setIsAvaliarRoteiro(true);
			}

			log.iniciaAvaliacao(idLog, "obtendo nao conformidades");

			PassagemDTO nc = obtemNaoConformidadesAtuais(filtroNC);
			retorno.setNcs(nc.getNaoConformidadesAtuais());
			
			

			if (!cdPt.contains("EMB")) { // NÃO salva logs para "EMB"alagens. TODO: classificar usado TipoPT (não agora devido evitar-se
											// outro acesso a banco - o cdTpPt não está sendo trazido das consultas anteriores)
				// Salva Log de Validação do Roteiro
				if (retorno != null && retorno.getListaPessagem() != null && retorno.getListaPessagem().size() > 0) {
					PassagemDTO retornoSalvaLog = null;

					long idTdefeito = 0L;
					String cdptdef = null;
					if (
							retorno.getNcs() != null && 
							retorno.getNcs().size() > 0 && 
							retorno.getNcs().get(0) != null && 
							retorno.getNcs().get(0).getIdTDefeito() != null) {
						idTdefeito = retorno.getNcs().get(0).getIdTDefeito().longValue();
					}
					if (
							retorno.getNcs() != null && 
							retorno.getNcs().size() > 0 && 
							retorno.getNcs().get(0) != null && 
							retorno.getNcs().get(0).getCdPt() != null && 
							!retorno.getNcs().get(0).getCdPt().equals("")) {
						cdptdef = retorno.getNcs().get(0).getCdPt();
					}

					retornoSalvaLog = salvaLogValidacaoRoteiro(cdPt, cb, idTdefeito, cdptdef);
					if (retornoSalvaLog != null) {
						retornoSalvaLog = null;
					}
				}
			}
			log.mostrarAvaliacaoCompleta();

			PTRN prn = new PTRN(getDao());
			OmPt ompt = prn.getOmPt(cdPt);

			// se nao existir o pt retornar essa situacao para o solicitante
			if (ompt == null) {
				retorno.setOpAtualPosto("SEMPT");
			} else if (ompt.getPpCp() != null) {
				retorno.setOpAtualPosto(ompt.getPpCp().getNrop());
				
				
				
				
				
				
				
				/* Alessandre em 10-07-20 na implementacao da ordem de retrabalho, a nao conformidade abaixo foi acrescentada para a ordem de retrabalho e de producao
				 * Se houver uma relacao de numero de series para a OP entao eh verificado se o CB em avaliacao esta nessa relacao. Se nao estiver um nao conformidade eh gerada
				 */
				if (ompt.getPpCp().getPpCpnseries().isEmpty() == false) {
					CpRN cprn = new CpRN(getDao());
					PpCpnserie cpns = cprn.getPpCpnserie(ompt.getPpCp(), cb);
					
					if (cpns == null) {
						NaoConformidadeDTO ncAux = new NaoConformidadeDTO();
						ncAux.setDsCurta("NS fora do esperado");
						ncAux.setDsNaoConformidade("CB " + cb + " não está na lista da OP.");
						ncAux.setCdPt("");
						ncAux.setDthrNC(DataHoraRN.getDataHoraAtual());
						retorno.getNcs().add(ncAux);
					}
				} else if (ompt.getPpCp().getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()) ){
					// Avaliar se o NS tem registro de produção anterior. Se não tiver levantar nao conformidade que 
					// produto da OP de retrabalho deve ter sido produzido anteriormente
					
					if (lista.isEmpty()) {
						NaoConformidadeDTO ncAux = new NaoConformidadeDTO();
						ncAux.setDsCurta("NS desconhecido");
						ncAux.setDsNaoConformidade("CB " + cb + " não pode ser reprocessado, pois não foi produzido.");
						ncAux.setCdPt("");
						ncAux.setDthrNC(DataHoraRN.getDataHoraAtual());
						retorno.getNcs().add(ncAux);
					}
				}
				
				
				
				
				
				
				
				
			} else {
				retorno.setOpAtualPosto("SEMOP");
			}
			
			
			
			
			
			
			
		} catch (RegistroDesconhecidoException e) {
			retorno.setOpAtualPosto("SEMPT");
		} catch (Exception e) {
			log.info(idLog, 0, "Excessao", e);
			e.printStackTrace();
		} finally {
			log.mostrarAvaliacaoCompleta();
		}

		return retorno;

	}

	public PassagemDTO salvaLogValidacaoRoteiro(String cdPt, String cb, long idTdefeitoeventual, String cdPtDef)
			throws NumeroSerieIrregularException {
		// instancia o ProdutoRN

		PassagemDTO retorno = null;
		if (cdPt != null && cb != null) {
			retorno = new PassagemDTO();
			retorno.setCdPt(cdPt);
			retorno.setCb(cb);
		} else {
			return retorno;
		}

		Calendar cal = new GregorianCalendar();
		Date dt = cal.getTime();

		// OFF4PERFORMANCE: ProdutoRN oProdutoRN = new ProdutoRN();
		// OFF4PERFORMANCE: oProdutoRN.getDao().setSession(this.getDaoSession());
		TurnoRN rnTurno = new TurnoRN();
		rnTurno.getDao().setSession(this.getDaoSession());

		/*
		 * OFF4PERFORMANCE: em nome da performance da Validação Poka-yoke, trecho comentado: caso necessário nos relaórios, a identificar
		 * depois OmCfg omcfg = Util.getConfigGeral(getDaoSession()); String cdProduto = Util.extraiPorMascara(cb,
		 * omcfg.getMascaracdprodutoCB());
		 */

		OmPt ompt = null;
		if (cdPt != null && cdPt.equals("") == false) {
			PTRN rn = new PTRN(getDao());
			try {
				ompt = rn.getOmPt(cdPt);
			} catch (RegistroDesconhecidoException e) {
				rn = null;
				return retorno;
			}
			if (ompt != null) {
				retorno.setIdGt(ompt.getOmGt().getIdGt());
				retorno.setIdTppt(ompt.getOmTppt().getIdTppt());
				retorno.setIdPt(ompt.getIdPt());
			}
			rn = null;

		}

		DwTurno dwTurno = new DwTurno();
		TurnoAtualDTO turnoatualdto = new TurnoAtualDTO();
		if (ompt != null) {
			try {
				turnoatualdto = rnTurno.getTurnoAtualDTO(ompt, dt);
			} catch (Exception e) {

				// OFF4PERFORMANCE: oProdutoRN = null;
				rnTurno = null;
				cal = null;
				dt = null;
				// OFF4PERFORMANCE: omcfg = null;
				// OFF4PERFORMANCE: cdProduto = null;
				ompt = null;
				dwTurno = null;
				turnoatualdto = null;

				return retorno;
			}
		} else {
			// OFF4PERFORMANCE: oProdutoRN = null;
			rnTurno = null;
			cal = null;
			dt = null;
			// OFF4PERFORMANCE: omcfg = null;
			// OFF4PERFORMANCE: cdProduto = null;
			ompt = null;
			dwTurno = null;
			turnoatualdto = null;

			return retorno;
		}
		if (turnoatualdto != null) {
			dwTurno.setIdTurno(turnoatualdto.getIdTurno());
		}

		// OFF4PERFORMANCE: // verifica se o produto existe
		// OFF4PERFORMANCE: OmProduto oOmProduto = null;
		// OFF4PERFORMANCE: oOmProduto = oProdutoRN.getProdutoByCdEStAtivo(cdProduto);

		/*
		 * //OFF4PERFORMANCE:
		 * 
		 * if (oOmProduto == null) { // Obtem o produto a partir da OP carregada no posto if (ompt != null && ompt.getPpCp() != null)
		 * oOmProduto = ompt.getPpCp().obtemPrimeiroProduto(); } NumeroSerieRN rnNS = new NumeroSerieRN();
		 * rnNS.setDaoSession(this.getDaoSession()); DwNserie oDwNserie = rnNS.getDwNserieCb(cb); if (oDwNserie != null){
		 * retorno.setIdNSerie(oDwNserie.getIdNserie()); if (oDwNserie.getOmProduto()!=null && (oOmProduto==null) ){ oOmProduto =
		 * oDwNserie.getOmProduto(); }
		 * 
		 * }
		 * 
		 * if (oOmProduto != null ){ retorno.setIdProduto(oOmProduto.getIdProduto()); }
		 */

		/*
		 * if (retorno == null) { retorno = new PassagemDTO(); retorno.setResultado(new ResultadoDTO());
		 * retorno.getResultado().setIdmensagem(retorno.getResultado().TIPO_PT_DESCONHECIDO); }
		 */

		DwLogvalroteiro dwlogvrot = null;
		// OFF4PERFORMANCE: DwNserie dwNserie = new DwNserie();
		// OFF4PERFORMANCE: OmProduto omProduto = new OmProduto();
		OmPt omPt = new OmPt();
		dwlogvrot = new DwLogvalroteiro();
		dwlogvrot.setCb(cb);
		dwlogvrot.setDthrLog(dt);

		/*
		 * //OFF4PERFORMANCE:
		 * 
		 * if (retorno.getIdNSerie()!=0L){ dwNserie.setIdNserie(retorno.getIdNSerie()); dwlogvrot.setDwNserie(dwNserie); }
		 * if(retorno.getIdProduto()!=0L){ if (oOmProduto!=null){ omProduto = oOmProduto.clone(false); }
		 * omProduto.setIdProduto(retorno.getIdProduto()); dwlogvrot.setOmProduto(omProduto); }
		 */
		if (retorno.getIdPt() != 0L) {
			omPt.setIdPt(retorno.getIdPt());
			dwlogvrot.setOmPt(omPt);
		}
		if (dwTurno != null && dwTurno.getIdTurno() != 0L) {
			dwlogvrot.setDwTurno(dwTurno);
		}
		DwTDefeito dwtdef = new DwTDefeito();
		if (idTdefeitoeventual != 0L) {
			dwtdef.setIdTdefeito(idTdefeitoeventual);
			dwlogvrot.setDwTDefeito(dwtdef);
		}
		if (cdPtDef != null && (!cdPtDef.equals(""))) {
			dwlogvrot.setCdPtDef(cdPtDef);
		}
		dwlogvrot = this.getDao().makePersistent(dwlogvrot);

		dwtdef = null;
		// OFF4PERFORMANCE: oProdutoRN = null;
		rnTurno = null;
		cal = null;
		dt = null;
		// OFF4PERFORMANCE: omcfg = null;
		// OFF4PERFORMANCE: cdProduto = null;
		ompt = null;
		dwTurno = null;
		turnoatualdto = null;
		// OFF4PERFORMANCE: oOmProduto = null;
		// OFF4PERFORMANCE: rnNS = null;
		// OFF4PERFORMANCE: oDwNserie = null;
		// OFF4PERFORMANCE: dwNserie = null;
		// OFF4PERFORMANCE: omProduto = null;
		omPt = null;

		return retorno;
	}

	// getPassagensQC - diferenças entre este e o getPassagens:
	// - este aqui NAO salva Log Validacao; Usado para pesquisar a partir do QC, que não devem gerar log (por enquanto).
	// - este aqui obtem lista de logs de validação de roteiro para o CB informado no parâmetro
	// - este aqui junta as duas listas: a original de passsagem e a de logs.
	//
	public PassagensDTO getPassagensQC(String cdPt, String cb) {
		PassagensDTO retorno = new PassagensDTO();

		PassagensDTO passagenslogsDTO = new PassagensDTO();
		//// PassagensDTO retornoauxDTO = new PassagensDTO();

		if (cb == null || cb.trim().equals(""))
			return retorno;

		try {
			DwPassagemDAO dwPassagemDAO = new DwPassagemDAO(getDaoSession());
			List<DwPassagem> lista = dwPassagemDAO.getPassagens(cb);
			retorno.setListaPessagem(new ArrayList<PassagemDTO>());

			int contador = 0;
			for (DwPassagem dwpassagem : lista) {
				contador++;
				if (contador <= 50) {
					PassagemDTO dto = new PassagemDTO();
					dto.setCb(dwpassagem.getDwNserie().getCb());
					dto.setCdPt(dwpassagem.getOmPt().getCdPt());
					dto.setDtHrEvento(dwpassagem.getDthr());
					dto.getResultado().setIdmensagem(dwpassagem.getStNserie().intValue());
					retorno.getListaPessagem().add(dto);
				}
			}

			// Obter as nao conformidades do cb passado
			PassagemDTO filtroNC = new PassagemDTO();
			filtroNC.setCdPt(cdPt);
			filtroNC.setCb(cb);

			// quebra galho para habilitar a avaliacao do roteiro apenas pra linha 2
			if (cdPt.contains("LIN01")
			// cdPt.contains("LIN02") ||
			// cdPt.contains("LIN03") ||
			// cdPt.contains("LIN04")
			// cdPt.contains("LIN06") ||
			// cdPt.contains("LIN07") ||
			// cdPt.contains("LIN08") ||
			// cdPt.contains("LIN16")
			)
				filtroNC.setIsAvaliarRoteiro(true);
			PassagemDTO nc = obtemNaoConformidadesAtuais(filtroNC);
			retorno.setNcs(nc.getNaoConformidadesAtuais());

			// este NÃO Salva Log de Validação do Roteiro

			// if (filtroNC.getIsAvaliarRoteiro() && retorno!=null && retorno.getListaPessagem()!=null &&
			// retorno.getListaPessagem().size()>0){
			if (retorno != null && retorno.getListaPessagem() != null && retorno.getListaPessagem().size() > 0) {

				DwLogvalroteiroDAO dwlogvalroteiroDAO = new DwLogvalroteiroDAO(getDaoSession());
				List<DwLogvalroteiro> listalogs = dwlogvalroteiroDAO.getLogsvalroteiro(cb);
				passagenslogsDTO.setListaPessagem(new ArrayList<PassagemDTO>());

				if (listalogs != null && listalogs.size() > 0) {

					contador = 0;
					for (DwLogvalroteiro dwlog : listalogs) {
						contador++;
						if (contador <= 50) {
							PassagemDTO dto = new PassagemDTO();
							dto.setCb(dwlog.getCb());
							dto.setCdPt(dwlog.getOmPt().getCdPt());
							dto.setDtHrEvento(dwlog.getDthrLog());
							dto.getResultado().setIdmensagem(999);// sinaliza que é um Log de Validação Roteiro
							passagenslogsDTO.getListaPessagem().add(dto);
						}
					}

					retorno.getListaPessagem().addAll(passagenslogsDTO.getListaPessagem());

					Collections.sort(retorno.getListaPessagem(), new Comparator<PassagemDTO>() {
						@Override
						public int compare(PassagemDTO o1, PassagemDTO o2) {
							Date c1 = o1.getDtHrEvento();
							Date c2 = o2.getDtHrEvento();
							return c1.compareTo(c2) * -1;
						}
					});

				}

				listalogs = null;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;

	}

}
