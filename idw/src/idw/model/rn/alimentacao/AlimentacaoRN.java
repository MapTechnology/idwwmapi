package idw.model.rn.alimentacao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmAlimDAO;
import idw.model.dao.OmAlimreaDAO;
import idw.model.dao.OmMapaDAO;
import idw.model.dao.OmMapapaDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.dao.OmpaproDao;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemFeedersException;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmMapapaproalt;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPapro;
import idw.model.pojos.OmProaltglo;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmReel;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.OmAlimTemplate;
import idw.model.pojos.template.OmAlimreaTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.estoque.EntradaNaoEncontradaException;
import idw.model.rn.estoque.LocalDestinoNaoEncontradoException;
import idw.model.rn.estoque.LocalEstoquePaRN;
import idw.model.rn.estoque.LocalOrigemNaoEncontradoException;
import idw.model.rn.estoque.MovimentacaoLocalEstoque;
import idw.model.rn.estoque.SaidaMaiorQueTotalException;
import idw.model.rn.produto.ProdutoInvalidoException;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.AlimentacaoDTO;
import idw.webservices.dto.AlimentacoesDTO;
import idw.webservices.dto.LeituraCODTO;
import idw.webservices.dto.LeiturasCODTO;
import idw.webservices.dto.MapaCODTO;
import idw.webservices.dto.MonitorizacaoAlimDTO;
import idw.webservices.dto.MonitorizacoesAlimsDTO;
import idw.webservices.dto.PosicaoCODTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.dto.UsuarioCODTO;
import ms.excessao.UsuarioDesconhecidoException;
import ms.util.ConversaoTipos;

//@SuppressWarnings("unchecked")
public class AlimentacaoRN extends DAOGenerico {

	/**
	 * @param filtroAlimentacaoDTO
	 * @return
	 */
	public AlimentacoesDTO getAlimentacoesDTO(AlimentacaoDTO filtroAlimentacaoDTO) {

		OmAlimDAO obtendoOmAlim = new OmAlimDAO(getSession());

		List<OmAlim> listaOmAlim = null;

		listaOmAlim = obtendoOmAlim.getAlimentacoesDTO(filtroAlimentacaoDTO);

		List<AlimentacaoDTO> listaAlimentacaoDTO = new ArrayList<AlimentacaoDTO>();

		for (OmAlim omalim : listaOmAlim) {
			AlimentacaoDTO alimentacaoCorrente = new AlimentacaoDTO();

			OmAlim omAlimClonado = (OmAlim) omalim.clone();
			omAlimClonado.getOmMapa().setOmProduto(omalim.getOmMapa().getOmProduto().clone(false));
			alimentacaoCorrente.setAlimentacao(omAlimClonado);

			alimentacaoCorrente.getAlimentacao().setOmAlimreas(new HashSet<OmAlimrea>());
			for (OmAlimrea item : omalim.getOmAlimreas()) {

				OmAlimrea clone = (OmAlimrea) item.clone();
				clone.setOmUsr(item.getOmUsr().clone());
				alimentacaoCorrente.getAlimentacao().getOmAlimreas().add(clone);

			}

			alimentacaoCorrente.setResultadoEvento(0);
			listaAlimentacaoDTO.add(alimentacaoCorrente);
		}

		AlimentacoesDTO alimentacoesEfetuadas = new AlimentacoesDTO();
		alimentacoesEfetuadas.setAlimentacoes(listaAlimentacaoDTO);

		listaOmAlim = null;
		obtendoOmAlim = null;
		listaAlimentacaoDTO = null;

		return alimentacoesEfetuadas;
	}

	public AlimentacaoDTO clearAlimentacaoDTO() {
		AlimentacaoDTO alimentacao = new AlimentacaoDTO();
		alimentacao.setAlimentacao(new OmAlim());
		alimentacao.setResultadoEvento(0);
		alimentacao.getAlimentacao().setStAlim((byte) 4);
		alimentacao.getAlimentacao().setTpAlim((byte) 4);
		alimentacao.getAlimentacao().setOmMapa(new OmMapa());
		alimentacao.getAlimentacao().getOmMapa().setOmPt(new OmPt());

		return alimentacao;
	}

	/*
	 * Esse metodo tem como objetivo acumular a leitura no PA (omPaPro) que servir� para a monitorizacao
	 */
	private void insereProdutoNoPontoAlimentacao(IdwLogger log, int idLog, OmPt omPt, OmMapapa omMapapa, OmProduto omProduto,
			BigDecimal qtd) {

		OmPapro omPapro = null;

		// Pesquisar se ja existe um registro em omPaPro para o PT, PA e MapaPA. Se existir entao acumular, se nao existir, incluir
		OmpaproDao daoesp = new OmpaproDao(getDao().getSession());
		omPapro = daoesp.getOmPapro(omPt, omMapapa.getOmPa().getCdPa());

		if (omPapro == null) {
			log.info(idLog, 0, "incluindo ompapro com qtd=" + qtd);
			omPapro = new OmPapro();
			omPapro.setIdPapro(0l);
			omPapro.setOmMapapa(omMapapa);
			omPapro.setOmPa(omMapapa.getOmPa());
			omPapro.setOmProduto(omProduto);
			omPapro.setOmPt(omPt);
			omPapro.setQtAtual(qtd);
		} else {
			log.info(idLog, 0, "Alterando a qtde de " + omPapro.getQtAtual() + " para " + omPapro.getQtAtual().add(qtd));
			omPapro.setQtAtual(omPapro.getQtAtual().add(qtd));
		}

		getDao().makePersistent(omPapro);
	}

	public boolean setConferenciaOuPre(LeiturasCODTO leituras)
			throws LocalOrigemNaoEncontradoException,
			LocalDestinoNaoEncontradoException, ProdutoInvalidoException,
			UsuarioDesconhecidoException, SaidaMaiorQueTotalException,
			EntradaNaoEncontradaException, SemCalendarioException {

		// Se a alimentacao foi feita de forma exclusiva, entao salvar as
		// alimentacoes
		if (leituras.getIsExclusividade().equals("sim")) {
			setCorrente(leituras);
		}

		OmPt omPt = null;

		// Obtem a identificacao do PT
		try {
			String cdMaquina = leituras.getCdMaquina();

			OmPtDAO obtendoOmPt = new OmPtDAO(getSession());

			omPt = obtendoOmPt.getOmPtAtivoComUltimaRevisao(cdMaquina);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		OmAlim omalim = omPt.getOmAlimByIdAlimcorrente();

		if (omalim != null) {
			omalim.setTpAlim(leituras.getTpLeitura());
			omalim.setStAlim(leituras.getStatus());
			getSession().saveOrUpdate(omalim);
		}

		// Se for uma CONFERENCIA COM SUCESSO
		if (leituras.getTpLeitura() == 2 && leituras.getStatus() == 1) {
			// Se for um preconferencia (tpAlim == 2 e stAlim == 1)
			omPt.setOmAlimByIdAlimpre(omalim);
			omPt.setOmAlimByIdAlimcorrente(null);
			omPt.setIsAlimcorexc(leituras.getMapa().getIsAlimentacaoCorrenteExclusiva());
			// omPt.setOmAlimByIdAlim(null); Nao se deve limpar a conferencia se
			// uma pre-conferencia for feita
			getSession().saveOrUpdate(omPt);
		}

		// Se for uma ALIMETNACAO COM SUCESSO (tpAlim == 1 e stAlim == 1)
		if (leituras.getTpLeitura() == 3 && leituras.getStatus() == 1) {
			omPt.setOmAlimByIdAlim(omalim);
			omPt.setOmAlimByIdAlimpre(null);
			omPt.setOmAlimByIdAlimcorrente(null);
			omPt.setIsAlimcorexc(leituras.getMapa().getIsAlimentacaoCorrenteExclusiva());
			getSession().saveOrUpdate(omPt);
		}

		// Se tiver sido abortada a conferencia ou alimentacao ebtai limpar a alimentacao corrente e corrente exclusiva
		if (leituras.getStatus() == 2) {
			// Abort
			omPt.setOmAlimByIdAlimcorrente(null);
			omPt.setIsAlimcorexc(leituras.getMapa().getIsAlimentacaoCorrenteExclusiva());
			getSession().saveOrUpdate(omPt);
		}

		return true;
	}

	public boolean setRealimentacao(LeiturasCODTO leituras)
			throws LocalOrigemNaoEncontradoException,
			LocalDestinoNaoEncontradoException, ProdutoInvalidoException,
			UsuarioDesconhecidoException, SaidaMaiorQueTotalException,
			EntradaNaoEncontradaException {

		IdwLogger log = new IdwLogger("setRealimentacao" + leituras.getCdMaquina());
		int idLog = log.getIdAleatorio();
		OmCfg omcfg = Util.getConfigGeral(getSession());

		log.info(idLog, 0, "REALIMENTANDO maquina=" + leituras.getCdMaquina());

		OmAlimDAO obtendoOmAlim = new OmAlimDAO(getSession());

		List<OmAlim> listaDeOmAlim = obtendoOmAlim.getRealimentacoes(leituras);

		OmAlim omAlim = null;

		if (listaDeOmAlim != null && listaDeOmAlim.size() > 0) {
			omAlim = listaDeOmAlim.get(0);
		}

		if (omAlim == null) {
			log.info(idLog, 0, "omAlim nao encontrada");
			return false;
		}

		// Encontra a maior data das leituras enviadas a fim de usa-la como
		// referencia para recalculo da data de registro da realimentacao
		Date dataHoraAtual = DataHoraRN.getDataHoraAtual();

		Date dataHoraMaior = setDataHoraParaAsLeituras(leituras, dataHoraAtual);

		for (LeituraCODTO leitura : leituras.getLeituras()) {
			log.info(idLog, 0, "Realimentando " + leitura.getCdLidoProduto() + "qtAlim=" + leitura.getQtAlimentada() + " status="
					+ leitura.isLeituraOk() + " isRealimentacao=" + leitura.isRealimentacao());
			// Alessandre 29-01-14. Usar como referencia a data do servidor ao
			// inves da dt leitura do coletor
			// Recalcula a data e hora da leitura usando a dt e hora atual
			Date dataHoraLeitura = setDataHoraLeitura(leitura);

			int segDiff = DataHoraRN.getQuantidadeSegundosNoPeriodo(dataHoraLeitura, dataHoraMaior);

			dataHoraLeitura = DataHoraRN.subtraiSegundosDaData(dataHoraAtual, segDiff);

			OmPtDAO obtendoOmPt = new OmPtDAO(getSession());

			OmPt omPt = obtendoOmPt.getOmPtbyCdMaquina(leituras);

			ProdutoRN produto = new ProdutoRN(getDao());

			OmAlimrea omAlimrea = incluirOmAlimrea(log, idLog, leitura, leituras.getStatus(), omAlim, dataHoraLeitura, true, omPt);

			OmMapapa omMapapa = null;

			try {
				OmMapapaDAO obtendoOmMapaPa = new OmMapapaDAO(getSession());

				List<OmMapapa> listamapapa = obtendoOmMapaPa.setRealimentacao(leitura);

				if (listamapapa == null || listamapapa.size() <= 0) {
					continue;
				}
				omMapapa = listamapapa.get(0);

				omAlimrea.setOmMapapa(omMapapa);

			} catch (Exception e) {
				e.printStackTrace();
				// Mostra as leituras que chegaram

				continue;
			}

			// esse trecho serve apenas para a SEMP, o certo seria importar
			// a mascara de configuracao
			String cdLido = leitura.getCdLidoProduto();

			if (cdLido != null) {

				OmProduto omProduto = produto.getProdutoByCdEStAtivo(cdLido);

				OmUsrDAO obtendoIdOmUsr = new OmUsrDAO(getSession());
				OmUsr omUsrStAtivo = obtendoIdOmUsr.getOmUsrPorId(leitura.getIdUsuario());
				omAlimrea.setOmUsr(omUsrStAtivo);
				log.info(idLog, 0, "salvando alimrea");
				getSession().saveOrUpdate(omAlimrea);

				// O metodo abaixo é chamado para garantir a inclusao em OmReel
				pesquisarOuIncluirOmReel(omAlimrea, log, idLog, omAlim);

				if (omProduto != null) {
					// Lancar o consumo da materia-prima apenas se a leitura foi feita com sucesso e se o produto requer consumo
					if (omProduto.getIsConsumido() == null || omProduto.getIsConsumido() == true
							&& omAlimrea.getStLeitura().equals(OmAlimreaTemplate.StLeitura.SUCESSO.getId())) {

						log.info(idLog, 0, "Quantidade realimentada " + leitura.getQtAlimentada());
						BigDecimal qtdAlimentada = new java.math.BigDecimal(String.valueOf(leitura.getQtAlimentada()));

						/*
						 * Se a quantidade usada no componente for zerada entao deve-se colocar a qtde em outro omalimrea que tena a
						 * quantidade por placa definida
						 * 
						 */
						if (omMapapa.getQtUsada() != null && omMapapa.getQtUsada().compareTo(BigDecimal.ZERO) == 0) {
							log.info(idLog, 0, "Vou realimentar no feeder principal, pois qtUsada=" + omMapapa.getQtUsada() + " para cdPa="
									+ omMapapa.getOmPa().getCdPa() + " para mapa " + omMapapa.getOmMapa().getIdMapa());
							alocarQtEmAlimreaComQtUsada(omAlimrea, log, idLog);
						}

						// Inserir na tabela de monitorizacao de componente a quantidade realimentada
						insereProdutoNoPontoAlimentacao(log, idLog, omPt, omMapapa, omProduto, qtdAlimentada);
						try {

							if (omcfg.getIsNivelfeeder() != null && omcfg.getIsNivelfeeder()) {
								movimentarProdutoDeLocalAlimOrigemParaLocalDoPA(log, idLog, omPt, omMapapa, omProduto, qtdAlimentada,
										dataHoraLeitura, omUsrStAtivo);
							}

						} catch (Exception e) {
							log.info(idLog, 0, "N�o foi poss�vel salvar a realimenta��o porque o usu�rio n�o existe ", e);
							e.printStackTrace();
							continue;
						}

					} else {
						log.info(idLog, 0, "Nao atualizou estou pois stLeitura = " + omAlimrea.getStLeitura() + " omproduto.isConsumido="
								+ omProduto.getIsConsumido());
					}

				}

			}
		}
		return true;
	}

	/*
	 * Objetivo desse metodo é alocar a qtd alimentada em omAlimrea que tem o qtUsada igual a zero em outra omAlimrea do mesmo componente
	 * que tenha qtUsada > 0
	 * 
	 */
	private void alocarQtEmAlimreaComQtUsada(OmAlimrea omAlimrea, IdwLogger log, int idLog) {

		/*
		 * Alessandre em 08-05-19 se o pa tiver o flag isDesagruparAlimentacao marcado, entao o PA em hipotese alguma deve alocar a
		 * quantidade alimentada ou realimentada para o pa que tenha qtusada > 0. Em geral as bandeijas devem ter esse fleag marcado
		 */
		if (omAlimrea.getOmMapapa().getOmPa().getIsDesagruparAlimentacao() != null
				&& omAlimrea.getOmMapapa().getOmPa().getIsDesagruparAlimentacao())
			return;

		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from OmAlimrea a");
		q.append("join a.omMapapa b");
		q.append("where a.omAlim = :omalim");
		q.append("and b.omProduto = :omproduto");
		q.append("and b.qtUsada > 0");
		q.append("and a.tpLeitura between 1 and 2"); // alimnetacao ou realimentacao
		q.append("and a.stLeitura = 1"); // sucesso

		q.setMaxResults(1);
		q.defineParametro("omalim", omAlimrea.getOmAlim());
		q.defineParametro("omproduto", omAlimrea.getOmMapapa().getOmProduto());

		OmAlimrea alimreaQt = (OmAlimrea) q.uniqueResult();
		if (alimreaQt != null) {
			Integer qt = alimreaQt.getQtAlimentada();
			if (qt == null)
				qt = 0;
			qt = qt + omAlimrea.getQtAlimentada();

			log.info(idLog, 0, "Alterando qtAlimentada de " + alimreaQt.getQtAlimentada() + " para " + qt + " em idAlimrea = "
					+ alimreaQt.getIdAlimrea());
			alimreaQt.setQtAlimentada(qt);
			getDao().makePersistent(alimreaQt);
		}

	}

	private void movimentarProdutoDeLocalAlimOrigemParaLocalDoPA(IdwLogger log, int idLog, OmPt omPt,
			OmMapapa omMapapa, OmProduto omProduto, BigDecimal qtd, Date data,
			OmUsr usr) throws LocalOrigemNaoEncontradoException,
			LocalDestinoNaoEncontradoException, ProdutoInvalidoException,
			UsuarioDesconhecidoException, SaidaMaiorQueTotalException,
			EntradaNaoEncontradaException, SemCalendarioException {

		OmCfg omCfg = Util.getConfigGeral(getSession());

		LocalEstoquePaRN localEstoquePaRN = new LocalEstoquePaRN(getDao());

		DwEstlocal dwEstlocalDestino = localEstoquePaRN.getDwEstlocalAlimentacaoCriaSenaoExistir(
				omCfg.getDwEstByIdEstAlimentacao(),
				omPt,
				omMapapa.getOmPa(),
				usr,
				data);

		MovimentacaoLocalEstoque movLocalEst = new MovimentacaoLocalEstoque(getDao());

		movLocalEst.movimentarQtdEntreLocaisProdutosFazAjusteSeSaidaMaiorQueTotal(
				log, idLog,
				omCfg.getDwEstlocalorigalim(),
				omProduto,
				dwEstlocalDestino,
				qtd.intValue(),
				omCfg.getOmUsrimpprog(), data);
	}

	public static void main(String[] args) {
		AlimentacaoRN rn = new AlimentacaoRN();
		rn.iniciaConexaoBanco();

		// OmAlimrea omalimrea = new OmAlimrea();
		// OmProduto omproduto = new OmProduto();
		// omproduto.setIdProduto(23315);
		// omproduto.setCdProduto("11-300-023217B");
		//
		// OmAlim omalim = new OmAlim();
		// omalim.setIdAlim(26796);
		// omalimrea.setOmAlim(omalim);
		//
		// OmMapapa ommapapa = new OmMapapa();
		// ommapapa.setOmProduto(omproduto);
		// omalimrea.setOmMapapa(ommapapa);
		// omalimrea.setQtAlimentada(1000);
		// omalimrea.setCb("00336,1830,6806DD900ZZ,504336");
		//
		// omalim.getOmAlimreas().add(omalimrea);

//		IdwLogger log = new IdwLogger("teste");
//		int idLog = log.getIdAleatorio();

		PosicaoCODTO posicaoASerLida = new PosicaoCODTO();
		posicaoASerLida.setCdFeeder("Z1006");

		LeituraCODTO leitura = new LeituraCODTO();

		leitura.setLeituraOk(true);
		leitura.setCdLidoProduto("61M147-1");
		leitura.setRealimentacao(false);
		leitura.setQtAlimentada(1000);
		leitura.setCbRap("Z1006");
		leitura.setCbInformacoes(null);
		leitura.setPosicaoASerLida(posicaoASerLida);

		MapaCODTO mapa = new MapaCODTO();
		mapa.setCdMapa("24M014-0_SAMSUNG_15W_TL3");

		UsuarioCODTO usuario = new UsuarioCODTO();
		usuario.setIdUsuario(1);

		LeiturasCODTO leituras = new LeiturasCODTO();
		leituras.setStatus((byte) 1);
		leituras.setCdMaquina("NXTL3A");
		leituras.setMapa(mapa);
		leituras.setUsuario(usuario);

		List<LeituraCODTO> lista = new ArrayList<>();
		lista.add(leitura);

		leituras.setLeituras(lista);
		leituras.setTpLeitura((byte) 3);

		try {
//			System.out.println("iniciando setCorrente");
			rn.setCorrente(leituras);
//			System.out.println("finalizando setCorrente");
		} catch (LocalOrigemNaoEncontradoException | LocalDestinoNaoEncontradoException | ProdutoInvalidoException
				| UsuarioDesconhecidoException | SaidaMaiorQueTotalException | EntradaNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rn.finalizaConexaoBanco();
	}

	public LeiturasCODTO setCorrente(LeiturasCODTO leituras)
			throws LocalOrigemNaoEncontradoException,
			LocalDestinoNaoEncontradoException, ProdutoInvalidoException,
			UsuarioDesconhecidoException, SaidaMaiorQueTotalException,
			EntradaNaoEncontradaException, SemCalendarioException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss.mmm");
		String cdAlimentacao = formatter.format(new Date());

		OmCfg omcfg = Util.getConfigGeral(getSession());
		LeiturasCODTO retorno = new LeiturasCODTO();

		// Obtem a identificacao do usuario
		OmUsr omUsrStAtivo = null;

		OmUsrDAO obtendoIdOmUsr = new OmUsrDAO(getSession());

		omUsrStAtivo = obtendoIdOmUsr.getOmUsrPorId(leituras.getUsuario().getIdUsuario());

		// Se nao enocontrar o usuario utilizar o da 1a leitura
		if (omUsrStAtivo == null) {
//			System.out.println("nao encontrou o usuario " + leituras.getUsuario().getIdUsuario());
//			System.out.println("qtde de leituras " + leituras.getLeituras().size());
			omUsrStAtivo = obtendoIdOmUsr.getOmUsrPorId(leituras.getLeituras().get(0));
		}

		if (omUsrStAtivo == null) {
//			System.out.println("nao encontrou usuario id = " + leituras.getUsuario().getIdUsuario());
			throw new UsuarioDesconhecidoException();
		}

		// Obtem a identificacao do PT
		OmPt omPt = null;

		try {
			OmPtDAO obtendoOmPtPorCdMaquina = new OmPtDAO(getSession());

			omPt = obtendoOmPtPorCdMaquina.getOmPtbyCdMaquina(leituras);

			if (omPt == null) {
				return retorno;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
		}

		if (leituras.getLeituras() == null) {

			return retorno;

		}

		IdwLogger log = new IdwLogger("setCorrente-" + omPt.getCdPt());
		int idLog = log.getIdAleatorio();

		// Obtem o mapa que esta sendo alimentado
		OmMapa omMapa = null;

		try {
			OmMapaDAO obtemOmMapaAlimentadoByCdAndStAtivoAndIdPt = new OmMapaDAO(getSession());

			List<OmMapa> listaMapaAlimenta = obtemOmMapaAlimentadoByCdAndStAtivoAndIdPt.setCorrente(leituras, omPt);

			if (listaMapaAlimenta == null || listaMapaAlimenta.size() <= 0) {
				throw new Exception();
			}

			omMapa = (OmMapa) obtemOmMapaAlimentadoByCdAndStAtivoAndIdPt.setCorrente(leituras, omPt).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
		}

		// Verifica se existe uma alimentacao corrente para o PT em questao
		// Se nao existir OU se existir mas de um mapa diferente, incluir uma,
		// Se existir, utilizar a que existe.

		OmAlim omAlim = new OmAlim();

		if (omPt.getOmAlimByIdAlimcorrente() == null || (omPt.getOmAlimByIdAlimcorrente() != null
				&& omPt.getOmAlimByIdAlimcorrente().getOmMapa().getIdMapa() != omMapa.getIdMapa())) {

			omAlim.setCdAlim(cdAlimentacao);
			omAlim.setDtStativo(new Date()); // leituras.getMinDtHrLeitura()));
			omAlim.setDsAlim(leituras.getMapa().getCdMapa());
			omAlim.setTpAlim(leituras.getTpLeitura()); // Usa o tipo q veio em leituras
			omAlim.setStAlim(leituras.getStatus()); // Usa o status q veio em leituras
			omAlim.setOmUsr(omUsrStAtivo);
			omAlim.setOmMapa(omMapa);

			getSession().saveOrUpdate(omAlim);

			omPt.setOmAlimByIdAlimcorrente(omAlim);
			omPt.setIsAlimcorexc(leituras.getMapa().getIsAlimentacaoCorrenteExclusiva());

			getSession().saveOrUpdate(omPt);
		} else {
			omAlim = omPt.getOmAlimByIdAlimcorrente();
			log.info(idLog, 0, "Pesquisei alimentacao " + omAlim.getIdAlim());
		}

		if (leituras.getLeituras() != null) {
			OmMapapa omMapapa = null;

			// Alessandre> 31-7-13 em geral o leitor esta com a data e hora
			// desatualizada. Nesse caso irei pegar
			// a maior dt e hora das leituras e parea-la com a data e hora atual
			// e recalcular todas as outras datas e horas usando
			// o pareamento
			Date dataHoraAtual = DataHoraRN.getDataHoraAtual();

			Date dataHoraMaior = setDataHoraParaAsLeituras(leituras, dataHoraAtual);

			// Varre todas as leituras para salvar a alimenta��o
			for (LeituraCODTO leitura : leituras.getLeituras()) {
				// Recalcula a data e hora da leitura usando a dt e hora atual
				Date dataHoraLeitura = setDataHoraLeitura(leitura);

				int segDiff = DataHoraRN.getQuantidadeSegundosNoPeriodo(dataHoraLeitura, dataHoraMaior);

				dataHoraLeitura = DataHoraRN.subtraiSegundosDaData(dataHoraAtual, segDiff);

				OmAlimrea omAlimrea = incluirOmAlimrea(log, idLog, leitura, leituras.getStatus(), omAlim, dataHoraLeitura, false, omPt);

				// Pesquisa usuario da leitura
				OmUsr omUsrLeituraCorrente = obtendoIdOmUsr.getOmUsrPorId(leitura.getIdUsuario()); // omusr

				if (omUsrLeituraCorrente == null) {
					omUsrLeituraCorrente = omUsrStAtivo;
				}

				omAlimrea.setOmUsr(omUsrLeituraCorrente);

				try {
					OmMapapaDAO obtemOmMapaPaLeituraCorrente = new OmMapapaDAO(getSession());

					List<OmMapapa> listaOmMapaPaLeituraCorrente = obtemOmMapaPaLeituraCorrente.getOmMapaPA(leitura, omMapa);

					if (listaOmMapaPaLeituraCorrente == null || listaOmMapaPaLeituraCorrente.size() <= 0) {
						omAlimrea.setOmMapapa(null);
						continue; // Alessandre> 30-10-13 descartando o feeder,
									// passando para o proximo. isso foi feito
									// pq estao fechando a app no x e lendo
									// leituras.txt
					} else {
						omMapapa = listaOmMapaPaLeituraCorrente.get(0);
						omAlimrea.setOmMapapa(omMapapa);
					}

				} catch (Exception e) {
					e.printStackTrace();
					return retorno;
				}

				ProdutoRN produto = new ProdutoRN(getDao());

				// esse trecho serve apenas para a SEMP, o certo seria importar
				// a mascara de configuracao
				// Alessandre em 09-08-16 comentei a linha abaixo pois na Palladium os codigos sao maiores que 6
				// String cdLido = StringUtils.left(leitura.getCdLidoProduto(), 6);
				String cdLido = leitura.getCdLidoProduto();

				if (cdLido != null) {
					OmProduto omProduto = produto.getProdutoByCdEStAtivo(cdLido);

					if (omProduto != null) {

						if (omProduto.getIsConsumido() == null || omProduto.getIsConsumido() == true) {
							// Somente as leituras com sucesso devem ser consideradas e somente as alimentacoes que NAO foram abortadas

							if (leituras.getStatus() != 2 && omAlim.getStAlim().equals((byte) 2) == false) {
								// Somente as alimenta�oes devem ser consideradas, as conferencias descartadas
								// Inicialmente estava se considerando o if abaixo para isso. Mas por algum motivo o
								// isConferenciaOuAlimentacao vem como 2 (conferencia)
								// Substitui o if pelo trecho seguinte
								// if (leitura.getIsConferenciaOuAlimentacao() == 1) {
								if (leitura.getQtAlimentada() > 0) {
									BigDecimal qtdBig = new BigDecimal(leitura.getQtAlimentada());

									/*
									 * Se a quantidade usada no componente for zerada entao deve-se colocar a qtde em outro omalimrea que
									 * tena a quantidade por placa definida
									 * 
									 */
									if (omMapapa.getQtUsada() != null && omMapapa.getQtUsada().compareTo(BigDecimal.ZERO) == 0) {
										log.info(idLog, 0,
												"Vou ALIMENTAR no feeder principal, pois qtUsada=" + omMapapa.getQtUsada() + " para cdPa="
														+ omMapapa.getOmPa().getCdPa() + " para mapa " + omMapapa.getOmMapa().getIdMapa());
										alocarQtEmAlimreaComQtUsada(omAlimrea, log, idLog);
									}

									insereProdutoNoPontoAlimentacao(log, idLog, omPt, omMapapa, omProduto, qtdBig);

									if (omcfg.getIsNivelfeeder() != null && omcfg.getIsNivelfeeder()) {
										movimentarProdutoDeLocalAlimOrigemParaLocalDoPA(
												log, idLog,
												omPt, omMapapa, omProduto,
												qtdBig, dataHoraLeitura,
												omUsrLeituraCorrente);
									}
								} else {
									log.info(idLog, 0, "Nao salvei om_papro pois qtdeAlimentada = 0");
								}
								// } else {
								// log.info(idLog, 0, "Nao salvei om_papro pois leitura.getIsConferenciaOuAlimentacao <> 1. " + " para
								// alimentacao " + cdAlimentacao);
								// }
							} else {
								log.info(idLog, 0,
										"Nao salvei om_papro pois leituras.getStatus <> 2 para cdProduto " + omProduto.getCdProduto());
							}

						} else {
							log.info(idLog, 0, "Nao salvei om_papro pois omProduto.getIsConsumido = " + omProduto.getIsConsumido()
									+ " para o produto " + omProduto.getCdProduto());
						}
					} else {
						log.info(idLog, 0, "Nao salvei om_papro pois omProduto is null e cbLido = " + cdLido);
					}
				} else {
					log.info(idLog, 0, "Nao salvei om_papro pois cdLido is null");
				}

				getSession().saveOrUpdate(omAlimrea);

				// Metodo chamado para garantir a inclusao de omreel
				pesquisarOuIncluirOmReel(omAlimrea, log, idLog, omAlim);

				log.info(idLog, 0, "Salvando om_alimrea " + omAlimrea.toString(omAlimrea));
			}
		}

		flushReiniciandoTransacao();

		// Obtem todas as leituras para retorno
		retorno = getCorrente(omPt.getOmAlimByIdAlimcorrente().getIdAlim());
		retorno.setCdMaquina(omPt.getCdPt());

		return retorno;
	}

	public LeiturasCODTO getCorrente(Long idAlimCorrente) {
		LeiturasCODTO retorno = new LeiturasCODTO();

		OmAlimDAO obtendoOmAlimDAOByIdAlimCorrente = new OmAlimDAO(getSession());

		OmAlim omAlimCorrente = (OmAlim) obtendoOmAlimDAOByIdAlimCorrente
				.getCorrente(idAlimCorrente);

		OmPtDAO obtendoOmPtDAOByIdAlimCorrente = new OmPtDAO(getSession());

		OmPt omPtCorrente = obtendoOmPtDAOByIdAlimCorrente
				.getOmPtPorAlim(idAlimCorrente);

		if (omPtCorrente == null) {
			// System.out
			// .println("N�o foi poss�vel encontrar o PT com a alimenta��o corrente = "
			// + idAlimCorrente);
		} else {
			retorno.setCdMaquina(omPtCorrente.getCdPt());
		}

		retorno.setIdAlim(idAlimCorrente);

		OmAlimreaDAO obtendoOmAlimreaDAOByIdAlimCorrente = new OmAlimreaDAO(
				getSession());

		List<OmAlimrea> listaOmAlimreaCorrente = obtendoOmAlimreaDAOByIdAlimCorrente
				.getOmAlimreaPorIdAlim(idAlimCorrente);

		List<LeituraCODTO> leituras = new ArrayList<LeituraCODTO>();

		for (OmAlimrea omAlimreaLeituraCorrente : listaOmAlimreaCorrente) {
			if (omAlimreaLeituraCorrente.getOmMapapa() == null)
				continue;

			LeituraCODTO leitura = new LeituraCODTO();

			leitura.setCdLidoProduto(omAlimreaLeituraCorrente.getCdLido());
			leitura.setCbRap(omAlimreaLeituraCorrente.getCbRap());
			leitura.setDthrLeitura(DataHoraRN
					.dateToStringYYYYMMDDHHMMSS(omAlimreaLeituraCorrente
							.getDthrLeitura()));
			leitura.setIdUsuario(omAlimreaLeituraCorrente.getOmUsr().getIdUsr());
			leitura.setLeituraOk(omAlimreaLeituraCorrente.getStLeitura() == OmAlimreaTemplate.StLeitura.SUCESSO.getId());
			leitura.setQtAlimentada(omAlimreaLeituraCorrente.getQtAlimentada());
			leitura.setRealimentacao(omAlimreaLeituraCorrente.getTpLeitura() == OmAlimreaTemplate.TpLeitura.REALIMENTACAO.getId());

			PosicaoCODTO posicaoASerLida = new PosicaoCODTO();

			posicaoASerLida.setCdFeeder(omAlimreaLeituraCorrente.getOmMapapa()
					.getOmPa().getCdPa());
			posicaoASerLida.setCdProduto(omAlimreaLeituraCorrente.getOmMapapa()
					.getOmProduto().getCdProduto());
			posicaoASerLida.setDesvio(omAlimreaLeituraCorrente.getOmMapapa()
					.getOmPa().getDesvio());
			posicaoASerLida.setIdFeeder(omAlimreaLeituraCorrente.getOmMapapa()
					.getOmPa().getIdPa());
			posicaoASerLida.setIdMapapa(omAlimreaLeituraCorrente.getOmMapapa()
					.getIdMapapa());
			posicaoASerLida.setIdProduto(omAlimreaLeituraCorrente.getOmMapapa()
					.getOmProduto().getIdProduto());
			posicaoASerLida
					.setLido(omAlimreaLeituraCorrente.getStLeitura() == OmAlimreaTemplate.StLeitura.SUCESSO
							.getId());
			posicaoASerLida.setCdRap(omAlimreaLeituraCorrente.getCbRap());

			leitura.setPosicaoASerLida(posicaoASerLida);

			leituras.add(leitura);
		}

		retorno.setLeituras(leituras);

		MapaCODTO mapa = new MapaCODTO();
		mapa.setCdMapa(omAlimCorrente.getOmMapa().getCdMapa());
		mapa.setIdMapa(omAlimCorrente.getOmMapa().getIdMapa());

		retorno.setMapa(mapa);
		retorno.setStatus(omAlimCorrente.getStAlim());
		retorno.setTpLeitura(omAlimCorrente.getTpAlim());

		UsuarioCODTO usuario = new UsuarioCODTO();
		usuario.setApelido(omAlimCorrente.getOmUsr().getDsApelido());
		usuario.setIdUsuario(omAlimCorrente.getOmUsr().getIdUsr());
		usuario.setMatricula(omAlimCorrente.getOmUsr().getCdUsr());
		retorno.setUsuario(usuario);

		return retorno;
	}

	public void tratarTerminoConsumo(OmPt omPt, OmPa omPa, OmMapapa omMapapa,
			Date dthrTermino, OmProduto omProduto) {

		OmCfg omCfg = Util.getConfigGeral(getSession());

		OmAlim omAlim = omPt.getOmAlimByIdAlimcorrente();

		if (omAlim == null) {
			// System.out
			// .println("Terminou o consumo da embalagem, mas n�o existe omAlim para o PT "
			// + omPt.getCd()
			// + " em "
			// + dthrTermino
			// + "."
			// + " Ocorr�ncia n�o ser� registrada.");
		} else {

			OmAlimrea omAlimrea = new OmAlimrea();

			omAlimrea.setOmAlim(omAlim);
			omAlimrea.setDthrLeitura(dthrTermino);
			omAlimrea.setStLeitura(OmAlimreaTemplate.StLeitura.SUCESSO.getId());
			omAlimrea.setCdLido(omProduto.getCdProduto());
			omAlimrea.setCbRap(omPa.getCdPa());
			omAlimrea.setTpLeitura(OmAlimreaTemplate.TpLeitura.TERMINO_CONSUMO.getId());
			omAlimrea.setQtAlimentada(0);
			omAlimrea.setOmUsr(omCfg.getOmUsrimpprog());
			omAlimrea.setOmMapapa(omMapapa);
			omAlimrea.setIdAlimrea(null);

			getSession().saveOrUpdate(omAlimrea);
		}

	}

	private Date setDataHoraParaAsLeituras(LeiturasCODTO leituras,
			Date dataHoraAtual) {
		Date dataHoraMaior = null;

		for (LeituraCODTO leitura : leituras.getLeituras()) {
			Date dataHoraLeitura = setDataHoraLeitura(leitura);

			if (dataHoraMaior == null)
				dataHoraMaior = dataHoraLeitura;

			if (DataHoraRN.after(dataHoraLeitura, dataHoraMaior) == true)
				dataHoraMaior = dataHoraLeitura;
		}

		return dataHoraMaior;
	}
	
	private Date getMaiorDthrDaAlimentacao(idw.model.rn.alimentacao.AlimentacaoDTO alimentacaodto) {
		Date retorno = null;
		for (RealimentacaoDTO dto : alimentacaodto.getAlimentacoes()) {
			if (retorno == null)
				retorno = dto.getDthrLeitura();
			if (DataHoraRN.after(dto.getDthrLeitura(), retorno))
				retorno = dto.getDthrLeitura();
		}
		return retorno;
	}

	private Date setDataHoraLeitura(LeituraCODTO leitura) {
		return DataHoraRN.stringToDate(leitura.getDthrLeitura(),
				"yyyy-mm-dd HH:mm:ss");
	}

	private OmAlimrea incluirOmAlimrea(
			IdwLogger log,
			int idLog,
			LeituraCODTO leitura,
			byte leiturasStatus, 
			OmAlim omAlim, Date dataHoraLeitura,
			boolean realimentacao, OmPt ompt) {

		OmAlimrea omAlimrea = new OmAlimrea();
		omAlimrea.setOmAlim(omAlim);
		omAlimrea.setDthrLeitura(dataHoraLeitura);

		TurnoAtualDTO dwt = IdwFacade.getInstancia().getTurnoAtualDTO(ompt, dataHoraLeitura);

		if (dwt != null) {
			omAlimrea.setDwTurno(dwt.getDwturno());
			omAlimrea.setDtReferencia(dwt.getDtReferencia());
		}

		if (realimentacao) {
			log.info(idLog, 0, "realimentacao = true");
			omAlimrea.setStLeitura((byte) (leitura.isLeituraOk() && leiturasStatus == 1 ? OmAlimreaTemplate.StLeitura.SUCESSO.getId()
					: OmAlimreaTemplate.StLeitura.FALHOU.getId()));
		} else {
			log.info(idLog, 0, "realimentacao = false");
			omAlimrea.setStLeitura((byte) (leitura.isLeituraOk() ? OmAlimreaTemplate.StLeitura.SUCESSO.getId()
					: OmAlimreaTemplate.StLeitura.FALHOU.getId()));
		}

		omAlimrea.setCdLido(leitura.getCdLidoProduto());
		omAlimrea.setCbRap(leitura.getCbRap());
		omAlimrea.setTpLeitura((byte) (leitura.isRealimentacao() ? OmAlimreaTemplate.TpLeitura.REALIMENTACAO.getId()
				: OmAlimreaTemplate.TpLeitura.CONFERENCIA_OU_ALIMENTACAO.getId()));

		if (leitura.getCbInformacoes() != null && leitura.getCbInformacoes().length() > 0) {
			omAlimrea.setCb(leitura.getCbInformacoes());
		}

		if ((leitura.getCbNumeroLote() != null) && (leitura.getCbNumeroLote().length() > 0)) {
			omAlimrea.setLoteFab(leitura.getCbNumeroLote());
		}

		if (!realimentacao)
			omAlimrea.setIdAlimrea(null);

		omAlimrea.setQtAlimentada(leitura.getQtAlimentada());

		// Verifica se ja existe uma alimentacao com o reelid, que tenha qtde alimentada e qtde por placa no mesmo OmPa. Se sim, entao zerar
		// qtde alimentada
		boolean isReelJaAlimentado = isReelIdJaAlimentado(omAlimrea, omAlim);

		if (isReelJaAlimentado) {
			log.info(idLog, 0, "incluirOmAlimrea zerando qtAlimentada pois reelid já alimentado." + omAlimrea.getCb());
			omAlimrea.setQtAlimentada(0);
		} else if (omAlimrea.getCb() != null) { // <> null pois na conferencia o reelid eh null
			// Verificar se o reelJaUtilizado anteriormente. Se sim, entao utilizar o saldo do reelid
			OmReel omreel = pesquisarEstoqueReelIdOuIncluir(log, idLog, omAlimrea);
			if (omreel != null && omreel.obtemQtAtual().compareTo(BigDecimal.ZERO) > 0) {
				log.info(idLog, 0, "incluirOmAlimrea utilizando SALDO de OMREEL para " + omreel.getCdReelid());
				omAlimrea.setQtAlimentada(omreel.obtemQtAtual().intValue());
			}
		}

		return omAlimrea;
	}

	/*
	 * Metodo para pesquisasr ou incluir omReel
	 * 
	 */
	private OmReel pesquisarOuIncluirOmReel(OmAlimrea omalimrea, IdwLogger log, int idLog, OmAlim omalim) {
		/*
		 * Alessandre em 7-5-19 verificar se o ReelId já foi utilizado nesse feeder. Se sim então a qtAlimentada será zerada
		 * 
		 */
		OmReel omreel = null;
		boolean isReelIdJaAlimentado = isReelIdJaAlimentado(omalimrea, omalim); // pesquisa feita com base no cb do reel e nao do idalim
		if (isReelIdJaAlimentado) {

			// verifica estoque atual da reel id. Entretanto, nao devemos usar esse estoque caso o reel id faca parte da alimentacao
			// corrente
			omreel = pesquisarEstoqueReelIdOuIncluir(log, idLog, omalimrea);

		}

		return omreel;

	}

	/*
	 * metodo com objetivo de identificar se o idreel ja foi alimentado no mesmo feeder e na mesma idAlim
	 * 
	 */
	private boolean isReelIdJaAlimentado(OmAlimrea omalimrea, OmAlim omalim) {
		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from OmAlimrea a");
		q.append("where a.cb = :cb");
		q.append("and a.cbRap = :cdrap");
		q.append("and a.omAlim = :omalim");

		q.defineParametro("omalim", omalim);
		q.defineParametro("cb", omalimrea.getCb());
		q.defineParametro("cdrap", omalimrea.getCbRap());

		q.setMaxResults(1);

		OmAlimrea result = (OmAlimrea) q.uniqueResult();

		return result != null;
	}

	public OmReel pesquisarEstoqueReelIdOuIncluir(IdwLogger log, int idLog, OmAlimrea omalimrea) {
		OmReel retorno;

		MapQuery q = new MapQuery(getSession());

		q.append("select a");
		q.append("from OmReel a");
		q.append("where a.cdReelid = :cd");

		q.defineParametro("cd", omalimrea.getCb());

		retorno = (OmReel) q.uniqueResult();

		if (retorno == null) {
			log.info(idLog, 0, "Incluindo omreel com cd = " + omalimrea.getCb());

			retorno = new OmReel();

			retorno.setIdReel(null);
			retorno.setCdReelid(omalimrea.getCb());
			retorno.setDthrCadastro(DataHoraRN.getDataHoraAtual());

			// Quando o metodo eh chamado por incluirOmAlimrea o omalimrea ainda nao foi salvo. Nesse caso, deixaxremos como null
			// para ser salvo posteriormente
			if (omalimrea != null && omalimrea.getIdAlimrea() != null && omalimrea.getIdAlimrea() > 0)
				retorno.setOmAlimrea(omalimrea);
			else
				retorno.setOmAlimrea(null);

			if (omalimrea.getQtAlimentada() != null)
				retorno.setQtAlimentada(new BigDecimal(omalimrea.getQtAlimentada()));
			else
				retorno.setQtAlimentada(BigDecimal.ZERO);

			getDao().makePersistent(retorno);
		} else {
			/*
			 * Alesssandre em 18-10-19 comentei o trecho abaixo pois nao ficou entendido a necessidade do exists e na semp nunca encontra o
			 * reelid q.novaConsulta();
			 * 
			 * q.append("select a"); q.append("from OmReel a"); q.append("where a.cdReelid = :cd");
			 * q.append("and not exists (select b from OmAlimrea b where b.omAlim = :omalim and b.cb = a.cdReelid)");
			 * 
			 * q.defineParametro("cd", omalimrea.getCb()); q.defineParametro("omalim", omalimrea.getOmAlim());
			 * 
			 * retorno = (OmReel) q.uniqueResult();
			 */
		}

		return retorno;
	}

	/*
	 * public static void main(String[] args) { AlimentacaoRN rn = new AlimentacaoRN(); rn.iniciaConexaoBanco();
	 * 
	 * try { List<OmMapapa> sa = rn.obtemPaSemAlimentacao("AOIL12"); System.out.println("qtde sa: " + sa.size()); for(OmMapapa pa : sa) {
	 * System.out.println( " pt:" + pa.getOmMapa().getOmPt().getCdPt() + " mapa " + pa.getOmMapa().getCdMapa() + " = pa sem estoque:" +
	 * pa.getOmPa().getCdPa() + " produto=" + pa.getOmProduto().getCdProduto() + " grupo=" + pa.getOmProduto().getOmProgrp().getCdProgrp());
	 * 
	 * } } catch (SemFeedersException e) { // TODO Auto-generated catch block e.printStackTrace(); } catch (PostoSemDadoException e) {
	 * System.out.println(e.getComplemento()); }
	 * 
	 * rn.finalizaConexaoBanco(); }
	 */

	/*
	 * Metodo responsavel em identificar quais PAs estão sem alimentacao.
	 * 
	 */
	public List<OmMapapa> obtemPaSemAlimentacao(String cdup) throws SemFeedersException, PostoSemDadoException {

		IdwLogger log = new IdwLogger("obtemPaSemAlimentacao-" + cdup);
		int idLog = log.getIdAleatorio();

		List<OmMapapa> retorno = new ArrayList<>();

		// Obtem a lista de PTs para analise da alimentacao
		MapQuery qpt = new MapQuery(getDao().getSession());
		qpt.append("select distinct c");
		qpt.append("from OmPt a");
		qpt.append("join a.omPtcncsForIdPt b");
		qpt.append("join b.omPtByIdPtFilho c");
		qpt.append("where a.cdPt = :cdpt");
		qpt.append("and a.stAtivo = 1");

		qpt.defineParametro("cdpt", cdup);
		List<OmPt> pts = qpt.list();
		List<String> cdpts = new ArrayList<>();
		for (OmPt ompt : pts) {
			cdpts.add(ompt.getCdPt());
		}
		cdpts.add(cdup);

		// Obtem o id da ultima alimentacao
		MapQuery qAlim = new MapQuery(getDao().getSession());
		qAlim.append("select distinct a");
		qAlim.append("from OmAlim a");
		qAlim.append("join a.omMapa b");
		qAlim.append("join b.omPt c");
		qAlim.append("where c.cdPt = :cdpt");
		qAlim.append("and c.stAtivo = 1");
		qAlim.append("and a.tpAlim = 3"); // alimnetacao
		qAlim.append("and a.stAlim = 1"); // sucesso
		qAlim.append("order by a.idAlim desc");

		qAlim.setMaxResults(1);

		// Obtem a ultima alimentação
		MapQuery qUltimaAlimentacao = new MapQuery(getDao().getSession());

		// Obtem a ultima alimentacao
		qUltimaAlimentacao.append("select distinct a");
		qUltimaAlimentacao.append("from OmAlim a");
		qUltimaAlimentacao.append("join fetch a.omAlimreas s");
		qUltimaAlimentacao.append("join fetch a.omMapa b");
		qUltimaAlimentacao.append("join fetch b.omPt c");
		qUltimaAlimentacao.append("join fetch s.omMapapa d");
		qUltimaAlimentacao.append("join fetch d.omProduto e");
		qUltimaAlimentacao.append("join fetch e.omProgrp f");
		qUltimaAlimentacao.append("where a.idAlim = :idalim");
		qUltimaAlimentacao.append("and s.qtAlimentada > 0");
		// qUltimaAlimentacao.append("and s.qtPorplaca > 0"); Alessandre: comitei pois na virada dos reelid estava enviando email dizendo q
		// nao tinha saldo, pois o select nao estava retornando nessa condicao
		qUltimaAlimentacao.append("and f.cdProgrp is not null");
		qUltimaAlimentacao.append("and f.cdProgrp <> '0'");
		qUltimaAlimentacao.append("order by a.idAlim desc");

		qUltimaAlimentacao.setMaxResults(1);

		// Obtem os PAs sem estoque de compoenetes
		// cria uma lista com os pas sem estoque
		// conforme a varredura das alimentacoes e realimentacoes forem idnetificando os pas com estoque, a lista deve ser atualizada
		// ao final a lista deve ter realmente os pas sem estoque
		// nao esquecer que alguns pas nunca vao ter estoque pois o mesmo vai para o pa principal

		String cdMapaAlimentado = null;
		String cdPtMapaAlimentado = null;

		for (String cdpt : cdpts) {
			qAlim.defineParametro("cdpt", cdpt);
			qUltimaAlimentacao.defineParametro("cdpt", cdpt);

			OmAlim omalimUlt = (OmAlim) qAlim.uniqueResult();
			if (omalimUlt == null) {
				continue;
			}

			qUltimaAlimentacao.defineParametro("idalim", omalimUlt.getIdAlim());

			OmAlim omalim = (OmAlim) qUltimaAlimentacao.uniqueResult();
			if (omalim == null) {
				// SE nao encontrar pode ser pq na alimentacao nao tenha nenhum item do blockchain
				// verifica se ao menos eh diferente do mapa das outras linhas
				if (cdMapaAlimentado != null && cdMapaAlimentado.equals(omalimUlt.getOmMapa().getCdMapa()) == false) {
					PostoSemDadoException ex = new PostoSemDadoException();
					ex.setComplemento(cdpt + " com mapa diferente de " + cdPtMapaAlimentado);
					throw ex;
				}
				continue;
			}

			if (cdMapaAlimentado == null) {
				cdMapaAlimentado = omalim.getOmMapa().getCdMapa();
				cdPtMapaAlimentado = omalim.getOmMapa().getOmPt().getCdPt();
			}

			// Verifica se o mapa eh diferente dos outros mapas
			if (cdMapaAlimentado.equals(omalim.getOmMapa().getCdMapa()) == false) {
				PostoSemDadoException ex = new PostoSemDadoException();
				ex.setComplemento(cdpt + " com mapa diferente de " + cdPtMapaAlimentado);
				throw ex;
			}

			Map<OmPa, BigDecimal> paSemEstoque = new HashMap<>();
			Map<OmPa, BigDecimal> paComEstoque = new HashMap<>();

			List<OmAlimrea> lista = new ArrayList<>();
			lista.addAll(omalim.getOmAlimreas());
			// Ordenar as alimentacoes de forma crescente para avaliar o que esta sem alimentacao
			Collections.sort(lista, new Comparator<OmAlimrea>() {
				@Override
				public int compare(OmAlimrea arg0, OmAlimrea arg1) {
					return arg0.getIdAlimrea().compareTo(arg1.getIdAlimrea());
				}
			});

			// Determina quais pas tem ou nao estoque
			for (OmAlimrea alimrea : lista) {

				// Se o omalimrea nao tiver qtde alimentada ou a qtde por placa estiver zerada, entao desconsiderar o omalimrea pois não tem
				// impacto na alimentacao
				if (alimrea.getQtAlimentada() == null ||
						(alimrea.getQtAlimentada() != null && alimrea.getQtAlimentada() <= 0) ||
						(alimrea.getQtPorplaca() != null && alimrea.getQtPorplaca().compareTo(BigDecimal.ZERO) <= 0)) {
//					System.out.println("cdfeeder=" + alimrea.getOmMapapa().getOmPa().getCdPa() + " idALimrea=" + alimrea.getIdAlimrea()
//							+ " - ignorando omalimrea " + alimrea.getIdAlimrea() + " qtalimentada=" + alimrea.getQtAlimentada()
//							+ " qtporplaca=" + alimrea.getQtPorplaca());
					continue;
				}
				// Se nao houver estoque entao acrescentar no MAP sem estoque
				if (alimrea.getQtAtual() != null && alimrea.getQtAtual().compareTo(BigDecimal.ZERO) == 0) {
					// Se ja estiver na lista, nao incluir mais
					if (paSemEstoque.containsKey(alimrea.getOmMapapa().getOmPa())) {
//						System.out.println(alimrea.getIdAlimrea() + " - descartando omalimrea pois ja esta em sem estoque "
//								+ alimrea.getOmMapapa().getOmPa().getCdPa() + " idpa:" + alimrea.getOmMapapa().getOmPa().getIdPa());
						continue;
					}

					// Se nao houver qt no estoque verificar se o pa ja tem registro no com estoque
					if (paComEstoque.containsKey(alimrea.getOmMapapa().getOmPa()) == false) {
//						System.out.println(alimrea.getIdAlimrea() + " - add SemEstoque " + alimrea.getOmMapapa().getOmPa().getCdPa()
//								+ " qtde=" + alimrea.getQtAtual() + " idPa:" + alimrea.getOmMapapa().getOmPa().getIdPa());
						paSemEstoque.put(alimrea.getOmMapapa().getOmPa(), alimrea.getQtAtual());
					}
				} else {
					// Se ja estiver na lista, desconsiderar
					if (paComEstoque.containsKey(alimrea.getOmMapapa().getOmPa())) {
//						System.out.println(alimrea.getIdAlimrea() + " - descartando pois ja esta em Com Estque "
//								+ alimrea.getOmMapapa().getOmPa().getCdPa() + " qtde=" + alimrea.getQtAtual());
						continue;
					}

					// iNCLUI NA lista
//					System.out.println(alimrea.getIdAlimrea() + " - add ComEstoque " + alimrea.getOmMapapa().getOmPa().getCdPa() + " qtde="
//							+ alimrea.getQtAtual() + " idPa:" + alimrea.getOmMapapa().getOmPa().getIdPa());
					paComEstoque.put(alimrea.getOmMapapa().getOmPa(), alimrea.getQtAtual());

					// remove da lista sem estoque
//					System.out.println("remove SemEstoque " + alimrea.getOmMapapa().getOmPa().getCdPa() + " qtde=" + alimrea.getQtAtual()
//							+ " idPa:" + alimrea.getOmMapapa().getOmPa().getIdPa());
					paSemEstoque.remove(alimrea.getOmMapapa().getOmPa());
				}
			}

			// Inicializar retorno
			Date inicio = DataHoraRN.getDataHoraAtual();

			log.info(idLog, 0, "********* ini - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(inicio) + " para PT " + cdpt
					+ " qtde alimentacoes=" + omalim.getOmAlimreas().size() + " id.Alim=" + omalim.getIdAlim());

			List<OmPa> retornado = new ArrayList<>();
			for (OmAlimrea omalimrea : omalim.getOmAlimreas()) {
				if (omalimrea.getQtAlimentada() == null ||
						(omalimrea.getQtAlimentada() != null && omalimrea.getQtAlimentada() <= 0) ||
						(omalimrea.getQtPorplaca() != null && omalimrea.getQtPorplaca().compareTo(BigDecimal.ZERO) <= 0))
					continue;

				for (OmPa ompa : paSemEstoque.keySet()) {

					if (retornado.contains(ompa))
						continue;

					// Se tem qtalimentada e qtde por ciclo e o PA esta na lista entao adicionar como retorno
					if (omalimrea.getOmMapapa().getOmPa().equals(ompa)) {

						// Incluir para retorno apenas os produtos do blockchain
						if (omalimrea.getOmMapapa().getOmProduto().getOmProgrp() != null &&
								omalimrea.getOmMapapa().getOmProduto().getOmProgrp().getCdProgrp() != null &&
								omalimrea.getOmMapapa().getOmProduto().getOmProgrp().getCdProgrp().equals("0") == false) {

							retornado.add(ompa);

							OmMapapa ommapapaclone = (OmMapapa) omalimrea.getOmMapapa().clone();
							ommapapaclone.setOmMapa((OmMapa) omalimrea.getOmMapapa().getOmMapa().clone());

							StringBuilder msgEmail = new StringBuilder();
							msgEmail.append("Posto: ");
							msgEmail.append(omalimrea.getOmMapapa().getOmMapa().getOmPt().getCdPt());
							msgEmail.append(" Mapa: ");
							msgEmail.append(omalimrea.getOmMapapa().getOmMapa().getCdMapa());
							msgEmail.append(" PA: ");
							msgEmail.append(omalimrea.getOmMapapa().getOmPa().getCdPa());
							msgEmail.append(" idPa: ");
							msgEmail.append(omalimrea.getOmMapapa().getOmPa().getIdPa());
							msgEmail.append(" Produto: ");
							msgEmail.append(omalimrea.getOmMapapa().getOmProduto().getCdProduto());
							msgEmail.append(" Grupo= ");
							msgEmail.append(omalimrea.getOmMapapa().getOmProduto().getOmProgrp().getCdProgrp());
							msgEmail.append(" idAlimrea= ");
							msgEmail.append(omalimrea.getIdAlimrea());
							msgEmail.append(" qtAlimentacao= ");
							msgEmail.append(omalimrea.getQtAlimentada());
							msgEmail.append(" qtPorNS= ");
							msgEmail.append(omalimrea.getQtPorplaca());
							msgEmail.append(" qtUsada= ");
							msgEmail.append(omalimrea.getQtUsada());
							msgEmail.append(" saldo= ");
							msgEmail.append(omalimrea.getQtAtual());

							log.info(idLog, 5, msgEmail.toString());

							retorno.add(ommapapaclone);

						}
					}
				}
			}
			log.info(idLog, 0, "********* fim - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(inicio));

		}

		return retorno;
	}

	/*
	 * Metodo retorna para o CF em flutter o que é esperado na realimentação.
	 * 
	 */
	public RealimentacaoDTO getRealimentacaoDTO(String cdpt, String cdmapa, String cdpa) {
		RealimentacaoDTO retorno = new RealimentacaoDTO();

		retorno.setCdPt(cdpt);
		retorno.setCdPa(cdpa);
		
		// Obtem a ultima alimentacao para pegar o mapa
		OmAlim omalim = null;
		OmMapapa ommapapa = null;
		if (cdmapa.equals("")) {
			omalim = pesquisarUltimasAlimentacoesSomenteOmAlim(cdpt);
			if (omalim != null)
				cdmapa = omalim.getOmMapa().getCdMapa();
			
		}

		// Obter a ultima alimnetação com base no cdpt e pegar o cdproduto esperado no cdpa passado
		if (cdmapa.compareTo("") != 0)
			ommapapa = pesquisarMapapaByCdPtCdPa(cdpt, cdmapa, cdpa);

		if (ommapapa != null) {
			retorno.setCdProduto(ommapapa.getOmProduto().getCdProduto());
			retorno.setCdMapa(cdmapa);

			// Atualizar a lista com produtos alternativos para o PA
			retorno.setCdProdutoAlternativo(new ArrayList<String>());
			for (OmMapapaproalt alternativos : ommapapa.getOmMapapaproalts()) {
				retorno.getCdProdutoAlternativo().add(alternativos.getOmProduto().getCdProduto());
			}
			
			// Se a lista de alternativos estiver vazia, entao obter a lista global de alternativos
			if (ommapapa.getOmMapapaproalts().isEmpty()) {
				// obtem a lista de alternativos para dto.cdProduto
				for (OmProaltglo alt : ommapapa.getOmProduto().getOmProaltglosForIdProdutoMae()) {
//					if (alt.getOmProdutoByIdProdutoFilho().getStAtivo() == (byte) 1) {
						retorno.getCdProdutoAlternativo().add(alt.getOmProdutoByIdProdutoFilho().getCdProduto());
//					}
				}
			}

			
			
		} else {
			// caso nao existe um PA para o mapa, entao retornar isso
			retorno.setStatus("300");
			retorno.setTitle("Ponto alimentação desconhecido");
			retorno.setCdProduto("");
			retorno.setCdProdutoAlternativo(new ArrayList<String>());
			retorno.setCdMapa(cdmapa);
		}

		return retorno;
	}

	private OmMapapa pesquisarMapapaByCdPtCdPa(String cdPt, String cdMapa, String cdPa) {
		OmMapapa retorno;

		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from OmMapapa a");
		q.append("join a.omMapa b");
		q.append("join b.omPt ompt");
		q.append("join a.omProduto c");
		q.append("join a.omPa d");
		q.append("left join a.omMapapaproalts e");
		q.append("where ");
		q.append("b.stAtivo = 1");
		q.append("and ompt.stAtivo = 1");
		q.append("and ompt.cdPt = :cd");
		q.append("and b.cdMapa = :cdmapa");
		q.append("and d.cdPa = :cdpa");
		q.append("and d.stAtivo = 1");

		q.defineParametro("cd", cdPt);
		q.defineParametro("cdmapa", cdMapa);
		q.defineParametro("cdpa", cdPa);
		q.setMaxResults(1);

		retorno = (OmMapapa) q.uniqueResult();

		return retorno;

	}

	/*
	 * Metodo para registrar a realimentacao vinda do android
	 * 
	 */
	public RealimentacaoDTO setRealimentacaoDTO(String cdpt, String cdmapa, String cdpa, String cdproduto, String cbLido, Double quantidade,
			Boolean isSucesso, String matricula) {
		IdwLogger log = new IdwLogger("realimentacao-resource");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		RealimentacaoDTO retorno = new RealimentacaoDTO();

		log.iniciaAvaliacao("setRealimentacaoDTO");

		try {

			log.iniciaAvaliacao("getUltimaAlimentacao");
			Date dataHoraLeitura = DataHoraRN.getDataHoraAtual();

			// Encontrar a ultima alimentação feita
			OmAlim omalim = pesquisarUltimasAlimentacoesSomenteOmAlim(cdpt);

			log.mostrarAvaliacaoCompleta(idLog, 5);
			// Avaliar se a ultima alimentacao feita é para o mapa passado aqui
			if (omalim == null) {
				// retornar erro de deivergencia de mapas
				retorno.setStatus("400");
				retorno.setTitle("Mapa desconhecido");
				return retorno;
			}
			if (omalim.getOmMapa().getCdMapa().equals(cdmapa) == false) {
				retorno.setStatus("400");
				retorno.setTitle("Mapa não está alimentado");
				return retorno;
			}

			// Encontra o PT
			PTRN ptrn = new PTRN(getDao());
			OmPt omPt;
			try {
				omPt = ptrn.getOmPt(cdpt);
			} catch (RegistroDesconhecidoException e) {
				omPt = null;
			}
			if (omPt == null) {
				// retorna o erro informando que pt nao existe
				retorno.setStatus("400");
				retorno.setTitle("Posto desconhecido");
				return retorno;
			}
			
			// Convencionei que o nro do lote será o cb completo, menos o produto e qtde
			String nroLote = cbLido.replaceAll(cdproduto, "");
			nroLote = nroLote.replaceAll(ConversaoTipos.converteParaString(quantidade, 0), "");

			// Inicializa DTOs para poder reutilizar as funcoes existentes
			LeiturasCODTO leituras = new LeiturasCODTO();
			leituras.setStatus((byte) 1);
			LeituraCODTO leitura = new LeituraCODTO();
			leitura.setLeituraOk(isSucesso);
			leitura.setCdLidoProduto(cdproduto);
			leitura.setCbRap(cdpa);
			leitura.setRealimentacao(true);
			leitura.setCbNumeroLote(nroLote);
			leitura.setQtAlimentada(quantidade.intValue());
			leitura.setCbInformacoes(cbLido);

			// Inserir em OmAlimrea
			OmAlimrea omAlimrea = incluirOmAlimrea(log, idLog, leitura, leituras.getStatus(), omalim, dataHoraLeitura, true, omPt);
			OmMapapa omMapapa = pesquisarMapapaByCdPtCdPa(cdpt, cdmapa, cdpa);
			if (omMapapa == null) {
				retorno.setStatus("400");
				retorno.setTitle("PA desconhecido");
				return retorno;
			}
			omAlimrea.setOmMapapa(omMapapa);

			// Pesquisar usuario que alimentou
			UsuarioRN urn = new UsuarioRN(getDao());
			OmUsr omusr;
			try {
				omusr = urn.getOmUsr(matricula);
			} catch (RegistroDesconhecidoException e) {
				omusr = null;
			}
			if (omusr == null) {
				retorno.setStatus("400");
				retorno.setTitle("Usuario desconhecido");
				return retorno;
			}
			omAlimrea.setOmUsr(omusr);

			// Calcula o saldo disponivel
			BigDecimal qtAtual = new BigDecimal(omAlimrea.getQtAlimentada());
			if (omAlimrea.getQtUsada() != null)
				qtAtual = qtAtual.subtract(omAlimrea.getQtUsada());
			if (omAlimrea.getQtPerdida() != null)
				qtAtual = qtAtual.subtract(omAlimrea.getQtPerdida());
			omAlimrea.setQtAtual(qtAtual);

			
			getDao().makePersistent(omAlimrea);

			// Se tudo certo, inserir em om_reel se nao existir
//			pesquisarOuIncluirOmReel(omAlimrea, log, idLog, omalim);

			// Preparar o retorno da alimentação
			retorno.setStatus("300");
			retorno.setTitle("Realimentação realizada com suscesso");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Excessao", e);
		} finally {
			log.mostrarAvaliacaoCompleta(idLog, identacao);
		}
		return retorno;
	}

	/*
	 * Metodo para encontrar ultima OmAlim do posto rapidamente
	 */
	public OmAlim pesquisarUltimasAlimentacoesSomenteOmAlim(String cdPt) {
		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from OmAlim a");
		q.append("join fetch a.omMapa b");
		q.append("join fetch b.omPt ompt");
		q.append("where a.tpAlim = 3");
		q.append("and a.stAlim = 1");
		q.append("and ompt.stAtivo = 1");
		q.append("and ompt.cdPt = :cd");
		q.append("order by a.idAlim desc");
		
		
		q.defineParametro("cd", cdPt);
		q.setMaxResults(1);
		
		return (OmAlim) q.uniqueResult();
		
	}





	public MonitorizacoesAlimsDTO setAlimentacaoDTO(idw.model.rn.alimentacao.AlimentacaoDTO alimentacaodto) throws LocalOrigemNaoEncontradoException, LocalDestinoNaoEncontradoException, ProdutoInvalidoException, UsuarioDesconhecidoException, SaidaMaiorQueTotalException, EntradaNaoEncontradaException, SemCalendarioException {
		return setAlimentacaoConferencia(alimentacaodto, OmAlimTemplate.TpAlim.ALIMENTACAO.getId());
	}

	public MonitorizacoesAlimsDTO setConferenciaDTO(idw.model.rn.alimentacao.AlimentacaoDTO alimentacaodto) throws LocalOrigemNaoEncontradoException, LocalDestinoNaoEncontradoException, ProdutoInvalidoException, UsuarioDesconhecidoException, SaidaMaiorQueTotalException, EntradaNaoEncontradaException, SemCalendarioException {
		return setAlimentacaoConferencia(alimentacaodto, OmAlimTemplate.TpAlim.CONFERENCIA.getId());
	}

	private MonitorizacoesAlimsDTO setAlimentacaoConferencia(idw.model.rn.alimentacao.AlimentacaoDTO alimentacaodto, byte tipoAlimentacao) throws LocalOrigemNaoEncontradoException, LocalDestinoNaoEncontradoException, ProdutoInvalidoException, UsuarioDesconhecidoException, SaidaMaiorQueTotalException, EntradaNaoEncontradaException, SemCalendarioException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss.mmm");
		String cdAlimentacao = formatter.format(new Date());

		OmCfg omcfg = Util.getConfigGeral(getSession());
		MonitorizacoesAlimsDTO retorno = new MonitorizacoesAlimsDTO();

		// Obtem a identificacao do usuario
		OmUsr omUsrStAtivo = null;

		OmUsrDAO obtendoIdOmUsr = new OmUsrDAO(getSession());

		omUsrStAtivo = obtendoIdOmUsr.getOmUsrPorCdAtivo(alimentacaodto.getCdUsr());

		// Se nao enocontrar o usuario utilizar o da 1a leitura
		if (omUsrStAtivo == null) {
			throw new UsuarioDesconhecidoException();
		}

		// Obtem a identificacao do PT
		OmPt omPt = null;

		try {
			OmPtDAO obtendoOmPtPorCdMaquina = new OmPtDAO(getSession());

			omPt = obtendoOmPtPorCdMaquina.getConsultaOmPtbyCdMaquina(alimentacaodto.getCdPt());

			if (omPt == null) {
				return retorno;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
		}

		if (alimentacaodto.getAlimentacoes().isEmpty()) {

			return retorno;

		}

		IdwLogger log = new IdwLogger("setAlimentacao-" + omPt.getCdPt());
		int idLog = log.getIdAleatorio();

		// Obtem o mapa que esta sendo alimentado
		OmMapa omMapa = null;
		OmMapaDAO rnmap = new OmMapaDAO(getSession());

		try {
			omMapa = rnmap.getMapaDeAlimentacao(alimentacaodto.getCdMapa(), omPt);
			if (omMapa == null)
				return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
		}


		OmAlim omAlim = new OmAlim();

		omAlim.setCdAlim(cdAlimentacao);
		omAlim.setDtStativo(new Date()); // leituras.getMinDtHrLeitura()));
		omAlim.setDsAlim(alimentacaodto.getCdMapa());
		omAlim.setTpAlim(tipoAlimentacao); // Usa o tipo q veio em leituras
		omAlim.setStAlim(OmAlimTemplate.StAlim.SUCESSO.getId()); // Usa o status q veio em leituras
		omAlim.setOmUsr(omUsrStAtivo);
		omAlim.setOmMapa(omMapa);

		getSession().saveOrUpdate(omAlim);

		omPt.setOmAlimByIdAlimcorrente(omAlim);
		omPt.setIsAlimcorexc(true);

		getSession().saveOrUpdate(omPt);

		// Salva as leituras
		if (alimentacaodto.getAlimentacoes().isEmpty() == false) {
			OmMapapa omMapapa = null;

			// Alessandre> 31-7-13 em geral o leitor esta com a data e hora
			// desatualizada. Nesse caso irei pegar
			// a maior dt e hora das leituras e parea-la com a data e hora atual
			// e recalcular todas as outras datas e horas usando
			// o pareamento
			Date dataHoraAtual = DataHoraRN.getDataHoraAtual();

			Date dataHoraMaior = getMaiorDthrDaAlimentacao(alimentacaodto);

			// Varre todas as leituras para salvar a alimenta��o
			for (RealimentacaoDTO leitura : alimentacaodto.getAlimentacoes()) {
				// Recalcula a data e hora da leitura usando a dt e hora atual
				Date dataHoraLeitura = leitura.getDthrLeitura();

				int segDiff = DataHoraRN.getQuantidadeSegundosNoPeriodo(dataHoraLeitura, dataHoraMaior);

				dataHoraLeitura = DataHoraRN.subtraiSegundosDaData(dataHoraAtual, segDiff);
				
				LeituraCODTO leituracodto = new LeituraCODTO();
				leituracodto.setCbInformacoes(leitura.getReelId());
				leituracodto.setCbRap(leitura.getCdPa());
				leituracodto.setCdLidoProduto(leitura.getCdProdutoLido());
				leituracodto.setDthrLeitura(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dataHoraLeitura) );
				leituracodto.setLeituraOk(leitura.getIsSucesso());
				leituracodto.setRealimentacao(false);
				leituracodto.setQtAlimentada(leitura.getQtAlimentada().intValue());
				
				
				// Calcular o lote
				String nroLote = leitura.getReelId().replaceAll(leitura.getCdProdutoLido(), "");
				nroLote = nroLote.replaceAll(ConversaoTipos.converteParaString(leitura.getQtAlimentada(), 0), "");

				
				
				leituracodto.setCbNumeroLote(nroLote); // TODO calcular

				OmAlimrea omAlimrea = incluirOmAlimrea(
						log, 
						idLog, 
						leituracodto, 
						alimentacaodto.getIsSucesso() ? (byte) 1 : (byte)0, 
								omAlim, 
								dataHoraLeitura, 
								false, 
								omPt);

				omAlimrea.setOmUsr(omUsrStAtivo);

				try {
					OmMapapaDAO obtemOmMapaPaLeituraCorrente = new OmMapapaDAO(getSession());

					omMapapa = obtemOmMapaPaLeituraCorrente.getPosicaoValida(alimentacaodto.getCdPt(), alimentacaodto.getCdMapa(), leitura.getCdPa(), leitura.getCdProduto());
					omAlimrea.setOmMapapa(omMapapa);

				} catch (Exception e) {
					e.printStackTrace();
					return retorno;
				}

				ProdutoRN produto = new ProdutoRN(getDao());

				// esse trecho serve apenas para a SEMP, o certo seria importar
				// a mascara de configuracao
				// Alessandre em 09-08-16 comentei a linha abaixo pois na Palladium os codigos sao maiores que 6
				// String cdLido = StringUtils.left(leitura.getCdLidoProduto(), 6);
				String cdLido = leitura.getCdProdutoLido();

				if (cdLido != null) {
					OmProduto omProduto = produto.getProdutoByCdEStAtivo(cdLido);

					if (omProduto != null) {

						if (omProduto.getIsConsumido() == null || omProduto.getIsConsumido() == true) {

							// Somente as leituras com sucesso devem ser consideradas e somente as alimentacoes que NAO foram abortadas
							if (alimentacaodto.getIsSucesso() && leitura.getIsSucesso()) {
								// Somente as alimenta�oes devem ser consideradas, as conferencias descartadas
								// Inicialmente estava se considerando o if abaixo para isso. Mas por algum motivo o
								// isConferenciaOuAlimentacao vem como 2 (conferencia)
								// Substitui o if pelo trecho seguinte
								// if (leitura.getIsConferenciaOuAlimentacao() == 1) {
								if (leitura.getQtAlimentada() > 0) {
									BigDecimal qtdBig = new BigDecimal(leitura.getQtAlimentada());

									/*
									 * Se a quantidade usada no componente for zerada entao deve-se colocar a qtde em outro omalimrea que
									 * tena a quantidade por placa definida
									 * 
									 */
									if (omMapapa.getQtUsada() != null && omMapapa.getQtUsada().compareTo(BigDecimal.ZERO) == 0) {
										log.info(idLog, 0,
												"Vou ALIMENTAR no feeder principal, pois qtUsada=" + omMapapa.getQtUsada() + " para cdPa="
														+ omMapapa.getOmPa().getCdPa() + " para mapa " + omMapapa.getOmMapa().getIdMapa());
										alocarQtEmAlimreaComQtUsada(omAlimrea, log, idLog);
									}

									insereProdutoNoPontoAlimentacao(log, idLog, omPt, omMapapa, omProduto, qtdBig);

									if (omcfg.getIsNivelfeeder() != null && omcfg.getIsNivelfeeder()) {
										movimentarProdutoDeLocalAlimOrigemParaLocalDoPA(
												log, idLog,
												omPt, omMapapa, omProduto,
												qtdBig, dataHoraLeitura,
												omUsrStAtivo);
									}
								} else {
									log.info(idLog, 0, "Nao salvei om_papro pois qtdeAlimentada = 0");
								}
								// } else {
								// log.info(idLog, 0, "Nao salvei om_papro pois leitura.getIsConferenciaOuAlimentacao <> 1. " + " para
								// alimentacao " + cdAlimentacao);
								// }
							} else {
								log.info(idLog, 0,
										"Nao salvei om_papro pois leituras.getStatus <> 2 para cdProduto " + omProduto.getCdProduto());
							}

						} else {
							log.info(idLog, 0, "Nao salvei om_papro pois omProduto.getIsConsumido = " + omProduto.getIsConsumido()
									+ " para o produto " + omProduto.getCdProduto());
						}
					} else {
						log.info(idLog, 0, "Nao salvei om_papro pois omProduto is null e cbLido = " + cdLido);
					}
				} else {
					log.info(idLog, 0, "Nao salvei om_papro pois cdLido is null");
				}

				getSession().saveOrUpdate(omAlimrea);

				// Metodo chamado para garantir a inclusao de omreel
				pesquisarOuIncluirOmReel(omAlimrea, log, idLog, omAlim);

				log.info(idLog, 0, "Salvando om_alimrea " + omAlimrea.toString(omAlimrea));
			}
		}


		// Obtem todas as leituras para retorno
		retorno.setCdMapa(alimentacaodto.getCdMapa());
		retorno.setCdPt(alimentacaodto.getCdPt());
		retorno.setLista(new ArrayList<MonitorizacaoAlimDTO>());

		return retorno;
	}




	public ReelidDTO getReelidDTO(String reelid) {
		ReelidDTO retorno = new ReelidDTO();
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select a");
		q.append("from OmReel a");
		q.append("where a.cdReelid = :cd");
		
		q.defineParametro("cd", reelid);
		q.setMaxResults(1);
		
		OmReel omreelid = (OmReel) q.uniqueResult();
		if (omreelid != null) {
			retorno.setStatus("200");
			retorno.setReelid(omreelid.getCdReelid());
			retorno.setSaldo(omreelid.obtemQtAtual().doubleValue());
		} else {
			retorno.setStatus("400");
			retorno.setTitle("Reelid desconhecido");
		}
		return retorno;
	}

}
