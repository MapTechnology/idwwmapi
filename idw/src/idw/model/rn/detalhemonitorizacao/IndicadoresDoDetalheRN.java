package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmMapaDAO;
import idw.model.dao.OmObjDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolal;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolaloco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolmooco;
import idw.model.pojos.DwConsolpemp;
import idw.model.pojos.DwConsolpempoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwPepro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.consolidacao.planejamento.ConsolidacaoPlanejamento;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.monitorizacao.injet.ConfiguracoesInjetRN;
import idw.model.rn.monitorizacao.injet.IndicadoresDoDetalheUltimaParadaInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.monitorizacao.injet.TempoRealInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.AlertaDTO;
import idw.webservices.dto.AlertasDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoCicloDTO;
import idw.webservices.dto.GraficoTempoDTO;
import idw.webservices.dto.ListaDwConsolPorDataDTO;
import idw.webservices.dto.ListaDwConsolPorPtDTO;
import idw.webservices.dto.ListaOperadoresDTO;
import idw.webservices.dto.ListaPerdasDTO;
import idw.webservices.dto.MpBrutaPorMaquinaDTO;
import idw.webservices.dto.OperadorDTO;
import idw.webservices.dto.PerdasDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutoResumoBIDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.PtRapResumoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.ProjecaoPCIDTO;
import ms.util.ConversaoTipos;

public class IndicadoresDoDetalheRN extends AbstractRN<DAOGenerico> {

	private OmCfg omcfg;
	private IdwLogger log;
	private List<DwConsolid> listaDwconsolid;
	private Boolean isRecuperarListaProdutos;
	private Boolean isRecuperarListaOperadores;
	private Boolean isRecuperarListaAlertas;
	private Boolean isRecuperarListaResumoDatas;
	private Boolean isRecuperarListaResumoTurnos;
	private DetalheMonitorizacaoPTInjetDTO retorno;
	private Map<DwFolha, Long> producaoPorCiclo = new HashMap<>();
	private Map<Long, Map<Long, Double>> estururaProduto = new HashMap<>();

	private FiltroDetalhePTInjetDTO filtro;

	private BigDecimal tempoCicloProdutivoSum = BigDecimal.ZERO;
	private BigDecimal qtAutoCicloprodutivoSum = BigDecimal.ZERO;
	private BigDecimal segAutoTempoparadaSpSum = BigDecimal.ZERO;
	private Double producaoPorCicloAtivo = 0d;
	private Double producaoPorCicloTotal = 0d;
	
	private BigDecimal qtTestes = BigDecimal.ZERO;
	private BigDecimal qtDefeitos = BigDecimal.ZERO;	
	private BigDecimal indiceDefeitos = BigDecimal.ZERO;

	Map<Long, String> mapIndPcsCiclo = new HashMap<Long, String>();

	// quantidades e indicadores
	private Double tempoativo = 0d;
	private Double tempoparadacp = 0d;
	private Double indiceparadas = 0d;
	private Double indiceParadasSemPeso = 0d;
	private Double indicerefugos = 0d;
	private Double indicerefugosGr = 0d;
	private Double indicePCI = 0d;
	private Double indiceperdas = 0d;
	private Double indiceperdasGr = 0d;
	private Double eficienciarealizacao = 0d;
	private Double eficienciarealizacaoGr = 0d;
	private Double eficienciaciclo = 0d;
	private Double eficienciaciclopond = 0d;

	private BigDecimal ciclopadrao = BigDecimal.ONE;
	private BigDecimal cavidadesAtivasMolde = BigDecimal.ZERO;
	private BigDecimal cavidadesTotalMolde = BigDecimal.ZERO;

	private Double tempoRitmoAutoItem;
	private Double tempoRitmoManuItem;
	private Double tempoAtivoAutoItem;
	private Double tempoAtivoManuItem;

	private Double perdaparadacp = 0d;
	private Double perdaParadaSP = 0d;
	private BigDecimal perdaParadaKg = BigDecimal.ZERO;
	private BigDecimal perdaParadaTn = BigDecimal.ZERO;

	private Double perdaPCI = 0d;
	private BigDecimal perdaPCIKg = BigDecimal.ZERO;
	private BigDecimal perdaPCITn = BigDecimal.ZERO;

	private Double perdaciclo = 0d;
	private BigDecimal perdaCicloKg = BigDecimal.ZERO;
	private BigDecimal perdaCicloTn = BigDecimal.ZERO;

	private BigDecimal prodprev = BigDecimal.ZERO;
	private BigDecimal producaoPrevistaKg = BigDecimal.ZERO;
	private BigDecimal producaoPrevistaTn = BigDecimal.ZERO;

	private BigDecimal producaoBruta = BigDecimal.ZERO;
	private BigDecimal producaoBrutaKg = BigDecimal.ZERO;
	private BigDecimal producaoBrutaTn = BigDecimal.ZERO;

	private BigDecimal prodref = BigDecimal.ZERO;
	private BigDecimal producaoRefKg = BigDecimal.ZERO;
	private BigDecimal producaoRefTn = BigDecimal.ZERO;

	private BigDecimal prodboa = BigDecimal.ZERO;
	private BigDecimal producaoLiquidaKg = BigDecimal.ZERO;
	private BigDecimal producaoLiquidaTn = BigDecimal.ZERO;

	private BigDecimal consumoMPProducaoBruta = BigDecimal.ZERO;
	private BigDecimal consumoMPProducaoLiquida = BigDecimal.ZERO;
	private BigDecimal consumoMPProducaoRefugada = BigDecimal.ZERO;

	private BigDecimal custoMPTotalDeInsercao = BigDecimal.ZERO;
	private BigDecimal custoMPTotalDePerdas = BigDecimal.ZERO;
	private BigDecimal custoMPTotalDeInsercaoLiquida = BigDecimal.ZERO;

	private Double segCicloMedio = 0d;
	private Double segTempoCiclosProdutivos = 0d;
	private Double qtCicloProdutivos = 0d;
	private Double qtCicloProdutivosPosto = 0d;

	private Double segcicloPadrao = 0d;
	private Double segUltCic = 0d;
	private Double segUltCicloPadrao = 0d;
	private Double segcicloPadraoSum = 0d;
	private Double segcicloMedioSum = 0d;
	private Integer qtdItensCicPadrao = 0;

	// tempos
	private Double tempoparadasp = 0d;
	private Double tempocicloimprodutivo = 0d;
	private Double temporefugo = 0d;
	private Double temporitmo = 0d;
	private Double tempoPCI = 0d;
	private Double tempotrabalhado = 0d;
	private Double tempoboas = 0d;
	private Double tempoprodutivas = 0d;
	private Double tempototal = 0d;
	private Integer tempoCalendario = 0;
	private Integer tempoSemColeta = 0;
	private Integer tempoDuplicadoColeta = 0;

	private Double oee = 0d;
	private Double oeeCapital = 0d;
	private Double utilizacao = 0d;
	private Double eficiencia = 0d;

	// aba ciclos
	private Long ciclosAExecutar = 0l;
	private Long ciclosExecutados = 0l;
	private Long qtPcsCiclo = 0l;

	private Long qtdItensFolha = 0l;
	private Long qtPcsCicloSum = 0l;
	private Long producaoPlanejadaOP = 0l;
	private Long producaoBrutaOP = 0l;
	private Long producaoRefugadaOP = 0l;

	// paradas
	private Integer qtdeParadaMTBF = 0;

	private Double segMTBF = 0d;
	private Double segMTTR = 0d;
	private Double segTempoparadamtbf = 0d;
	private BigDecimal segTempoparadaCpVr = BigDecimal.ZERO;
	private BigDecimal segTempoparadaSpVr = BigDecimal.ZERO;

	private FolhaRN folhaRN = new FolhaRN(this.getDao());
	private ConsolidacaoPlanejamento consolidacaoPlanejamento = new ConsolidacaoPlanejamento(getDao());

	// lista de produtos
	private List<ProdutoDTO> listaprodutos = new ArrayList<ProdutoDTO>();
	private ProdutosDTO produtosParaAndroid = new ProdutosDTO();

	// operadores
	private List<OperadorDTO> listaoperadores = new ArrayList<OperadorDTO>();
	private ListaOperadoresDTO operadoresandroidDTO = new ListaOperadoresDTO();

	// alertas
	private List<AlertaDTO> listaalertas = new ArrayList<AlertaDTO>();
	private AlertasDTO alertasandroidDTO = new AlertasDTO();

	// perdas
	private List<PerdasDTO> listaperdas = new ArrayList<PerdasDTO>();
	private ListaPerdasDTO perdasAndroidDTO = new ListaPerdasDTO();

	// resumo por data
	private Map<Date, ListaDwConsolPorDataDTO> listaagrupadaDT = new HashMap<Date, ListaDwConsolPorDataDTO>();

	// resumo por máquina
	private Map<String, ListaDwConsolPorPtDTO> listaagrupadaPT = new HashMap<String, ListaDwConsolPorPtDTO>();

	// resumo por produto - conjunto
	private Map<String, ProdutoResumoBIDTO> listaProdutosBI = new HashMap<String, ProdutoResumoBIDTO>();

	// resumo por produto - filtro de produto
	private Map<String, PtRapResumoDTO> listaIndicadoresPt = new HashMap<String, PtRapResumoDTO>();
	private Map<String, PtRapResumoDTO> listaIndicadoresPtRap = new HashMap<String, PtRapResumoDTO>();

	// resumo por turno
	private Map<Long, DetalheMonitorizacaoPTInjetDTO> listaTurnos = new HashMap<Long, DetalheMonitorizacaoPTInjetDTO>();

	// listaDatas serve apenas para evitar de usar o mesmo turno no calculo do
	// tempo do calendario
	private List<Date> listaDatas = new ArrayList<Date>();

	/*
	 * Construtor
	 */
	public IndicadoresDoDetalheRN(DAOGenerico dao, IdwLogger log, OmCfg omcfg, List<DwConsolid> listaDwconsolid,
			Boolean isRecuperarListaProdutos, Boolean isRecuperarListaOperadores, Boolean isRecuperarListaAlertas,
			Boolean isRecuperarListaPerdas, Boolean isRecuperarListaResumoDatas, Boolean isRecuperarListaResumoTurnos,
			DetalheMonitorizacaoPTInjetDTO retorno, FiltroDetalhePTInjetDTO filtro) {

		super(dao);

		this.log = log;
		this.omcfg = omcfg;
		this.listaDwconsolid = listaDwconsolid;
		this.isRecuperarListaAlertas = isRecuperarListaAlertas;
		this.isRecuperarListaOperadores = isRecuperarListaOperadores;

		this.isRecuperarListaProdutos = isRecuperarListaProdutos;
		this.isRecuperarListaResumoDatas = isRecuperarListaResumoDatas;
		this.isRecuperarListaResumoTurnos = isRecuperarListaResumoTurnos;
		this.retorno = retorno;
		this.filtro = filtro;
	}

	/*
	 * Metodo principal para setar os indicadores principais
	 */
	public void setResumoIndicadores() {
		Map<String, String> mapOPs = new HashMap<String, String>();
		
		retorno.setPeriodo(getPeriodo());

		retorno.setProduto(getProduto());
		retorno.setProdutoDs(getProdutoDescricao());

		retorno.setMaquina(getMaquina(listaDwconsolid));

		retorno.setDsPt(getDsPt(listaDwconsolid));


		// Marcos Sardinha: VFWEB - Injet
		if (IdwFacade.IS_IDW_ATIVO) {
			retorno.setOrdemproducao(getOrdemProducao(listaDwconsolid));
		} else {
			// listaDwconsolid.get(0).getDwFolha().getIdFolha() == null
			PlanejamentoInjetRN pRN = new PlanejamentoInjetRN();
			pRN.getDao().iniciaSessao();
			String nrOPExibicao = pRN.getNrOpExibicao(pRN.getDao(), pRN.getUltimaOP(pRN.getDao(), listaDwconsolid));
			pRN.getDao().finalizaSessao();
			retorno.setOrdemproducao(nrOPExibicao);
		}

		retorno.setDtinicioOP(getDtinicioOP(listaDwconsolid));
		retorno.setIdentificacaomolde(getIdentificacaoMolde(listaDwconsolid));
		retorno.setMolde(retorno.getIdentificacaomolde());

		log.info("setResumoIndicadores - loop principal em dwconsolid. qtde=" + listaDwconsolid.size());
		
		// Interage na lista de DwConsolid para calcular os indicadores
		// principais
		boolean isApenasPara1oDwConsolid = true;

		OmPt omptCalculoCicloMedio = null;

		// DwFolha abaixo deve ser a com maior idFolha, logo ter� os dados da
		// ultima atualizacao na folha
		// Sera usada para retorno das cavidades atuais
		DwFolha dwfolhaUltima = null;

		log.info("qtde de dwconsolids = " + listaDwconsolid.size());

		// Marcos Sardinha: 2018-04-03 >> Defeito 4887 (valor da meta/hora diferente nas guias producao e ciclo)
		// A meta precisa ser calculada com base na ultima versao do ciclo
		Long ultimoid = -1l;
		BigDecimal cicloPadraoMetaHora = BigDecimal.ZERO;

		
		// Defeito #5769 - a lista de alertas estava vindo multiplicada por n, onde n era a quantidade de diferentes validades de ciclo/estrutura para uma maq, op, turno, produto
		//                 Em ijalertas não tem informacao da validade de ciclo... vai ter que ser via pog  (Map com ChaveAlerta)
		Map<String, Boolean> mapChaveAlerta = new HashMap<String, Boolean>();
		
		int contadorid = 0;
		for (DwConsolid dwci : listaDwconsolid) {
		
			if (IdwFacade.IS_IDW_ATIVO == false) {
				if (mapOPs.containsKey(dwci.getPpCp().getCdCp())==false) {
					mapOPs.put(dwci.getPpCp().getCdCp(), dwci.getPpCp().getCdCp());
				}
			}
			
			
			contadorid++;
			log.info("dwconsolid " + contadorid + " de " + listaDwconsolid.size());

			// Obter a ultima folha

			// Marcos Sardinha: VFWEB - Injet
			if (IdwFacade.IS_IDW_ATIVO) {
				if (dwfolhaUltima == null || (dwfolhaUltima != null && dwfolhaUltima.getIdFolha() < dwci.getDwFolha().getIdFolha())) {
					dwfolhaUltima = dwci.getDwFolha();
				}
			} else {
				// dwci.getDwFolha().getIdFolha() == null
				if (dwfolhaUltima == null
						|| (dwfolhaUltima != null && dwfolhaUltima.getDtRevisao().before(dwci.getDwFolha().getDtRevisao()))) {
					dwfolhaUltima = dwci.getDwFolha();
				}
			}

			omptCalculoCicloMedio = dwci.getOmPt();

			if (isApenasPara1oDwConsolid == true) {
				retorno.setOmPt(dwci.getOmPt().clone(false));
				retorno.setDwFolha(dwci.getDwFolha().clone(false));
				retorno.setDwTurno(dwci.getDwTurno().clone(false));
				if (dwci.getDwRt() != null)
					retorno.setIdrt(dwci.getDwRt().getIdRt());
				if (dwci.getDtReferencia() != null)
					retorno.setDtReferencia(DataHoraRN.dateToString(dwci.getDtReferencia(), "dd/MM/yyyy"));
				else
					retorno.setDtReferencia(DataHoraRN.dateToString(DataHoraRN.getDataHoraAtual(), "dd/MM/yyyy"));

				if (dwci.getPpCp() != null && dwci.getPpCp().getDthrInicio() != null) {
					retorno.setDtInicioPlanejado(DataHoraRN.dateToString(dwci.getPpCp().getDthrInicio(), "dd/MM/yyyy HH:mm:ss"));
				}
				if (dwci.getPpCp() != null && dwci.getPpCp().getDthrFinal() != null) {
					retorno.setDtFimPlanejado(
							DataHoraRN.dateToString(dwci.getPpCp().getDthrFinal(), "dd/MM/yyyy HH:mm:ss"));
				}

				isApenasPara1oDwConsolid = false;
			}
			qtdItensCicPadrao += dwci.getDwConsols().size();

			// Calcula o tempo do calendario, para isso foi criada a listaDatas
			if (listaDatas.contains(dwci.getDthrIturno()) == false) {
				tempoCalendario += DataHoraRN.getQuantidadeSegundosNoPeriodo(dwci.getDthrIturno(), dwci.getDthrFturno());
				listaDatas.add(dwci.getDthrIturno());
			}

			// Se nao existir dwConsol entar passar pro proximo registro
			if (dwci.getDwConsols() == null) {
				continue;
			}

			DwConsolid idClone = dwci.clone(false);
			idClone.setOmPt(dwci.getOmPt().clone(false));
			idClone.setPpCp(dwci.getPpCp().clone(false));
			if (dwci.getPpCp().getPpCliente() != null)
				idClone.getPpCp().setPpCliente(dwci.getPpCp().getPpCliente().clone(false));
			idClone.getPpCp().setPpCpprodutos(new HashSet<PpCpproduto>());
			for (PpCpproduto ppcpproduto : dwci.getPpCp().getPpCpprodutos()) {
				idClone.getPpCp().getPpCpprodutos().add(ppcpproduto.clone(false));
			}

			idClone.setDwTurno(dwci.getDwTurno().clone(false));
			// Clona realtime
			if (dwci.getDwRt() != null) {
				idClone.setDwRt(dwci.getDwRt().clone(false));
				if (dwci.getDwRt().getDwConsolpalog() != null) {
					idClone.getDwRt().setDwConsolpalog(dwci.getDwRt().getDwConsolpalog().clone(true));
				}
			}

			// Clona afolha e folha iac e folha rap
			idClone.setDwFolha(dwci.getDwFolha().clone(false));
			idClone.getDwFolha().setDwFolhaiacs(new HashSet<DwFolhaiac>());
			for (DwFolhaiac iac : dwci.getDwFolha().getDwFolhaiacs()) {
				idClone.getDwFolha().getDwFolhaiacs().add(iac.clone(false));
			}
			if (dwci.getDwFolha().getDwFolharaps() != null) {
				for (DwFolharap rap : dwci.getDwFolha().getDwFolharaps()) {
					idClone.getDwFolha().getDwFolharaps().add(rap.clone());
				}
			}

			// Varre a lista de dwConsol para calcular os indicadores
			for (DwConsol dwconsol : dwci.getDwConsols()) {

				// Marcos Sardinha: 2018-04-03 >> Defeito 4887 (valor da meta/hora diferente nas guias producao e ciclo)
				// A meta precisa ser calculada com base na ultima versao do ciclo
				if (dwconsol.getIdConsol() > ultimoid) {
					ultimoid = dwconsol.getIdConsol();
					cicloPadraoMetaHora = dwconsol.getSegAutoCiclopadrao();
				}

				ciclopadrao = dwconsol.getSegAutoCiclopadrao();

				calcularPrimeirosIndicadores(dwconsol);

				if (isRecuperarListaProdutos) {

					recuperarListaProdutos(dwconsol, idClone);

				}

				if (isRecuperarListaOperadores) {

					recuperarListaOperadores(dwconsol, idClone);

				}

				if (isRecuperarListaAlertas) {

					if (IdwFacade.IS_IDW_ATIVO) {
						recuperarListaAlertas(dwconsol, dwci.getDthrIturno(), dwci.getDthrFturno(), idClone);
					} else {						
						MonitorizacaoInjetRN rnij = new MonitorizacaoInjetRN();
						
						// alertas
						String chaveAlerta = "";
						chaveAlerta = chaveAlerta.concat(dwci.getOmPt().getCdPt());
						chaveAlerta = chaveAlerta.concat(dwci.getPpCp().getCdCp());
						chaveAlerta = chaveAlerta.concat(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwci.getDtReferencia()));
						chaveAlerta = chaveAlerta.concat(dwci.getDwTurno().getCdTurno());
						
						Set<DwConsolal> listaAlertas = new HashSet<DwConsolal>();
						if (mapChaveAlerta.containsKey(chaveAlerta) == false){
							rnij.getDao().iniciaSessao();							
							listaAlertas = rnij.getAlertas(dwci.getDtReferencia(), dwci.getDwTurno().getCdTurno(), dwci.getOmPt().getCdPt(), dwci.getPpCp().getCdCp());							
							rnij.getDao().finalizaSessao();
							
							mapChaveAlerta.put(chaveAlerta, true);
						} 
						
						dwconsol.setDwConsolals(listaAlertas);
						
						recuperarListaAlertasInjet(dwconsol, dwci.getDthrIturno(), dwci.getDthrFturno(), idClone);
					}

				}

				if (isRecuperarListaResumoDatas) {

					recuperarListaResumoDatas(dwconsol);

				}

				// recuperar lista de maquinas
				String cdPt = dwci.getOmPt().getCdPt();
				if (listaagrupadaPT.containsKey(cdPt) == true) {
					ListaDwConsolPorPtDTO dwconsolporPt = listaagrupadaPT.get(cdPt);
					dwconsolporPt.getListaDwConsol().add(dwconsol);
				} else {
					ListaDwConsolPorPtDTO dwconsolporPt = new ListaDwConsolPorPtDTO();
					dwconsolporPt.setCdPt(cdPt);
					dwconsolporPt.setDsPt(dwci.getOmPt().getDsPt());
					dwconsolporPt.setListaDwConsol(new ArrayList<DwConsol>());
					dwconsolporPt.getListaDwConsol().add(dwconsol);
					listaagrupadaPT.put(cdPt, dwconsolporPt);
				}

				if (isRecuperarListaResumoTurnos) {
					recuperarListaResumoTurnos(dwconsol, idClone);

				}
			}

			// Pega consolidaÃ§Ã£o de produto
			DwConsol dwconsolClone;
			if (idClone.getDwConsols() != null && idClone.getDwConsols().size() > 0) {
				dwconsolClone = idClone.getDwConsols().iterator().next();
			} else {
				log.info("dwConsolid = " + idClone.getIdConsolid() + " nao tem dwconsol");
				return;
			}
			dwconsolClone.setDwConsolid(null);
			dwconsolClone.setDwConsolprs(new HashSet<DwConsolpr>());
			for (DwConsolpr dwConsolpr : dwci.getDwConsols().iterator().next().getDwConsolprs()) {
				DwConsolpr clone = dwConsolpr.clone(false);
				dwconsolClone.getDwConsolprs().add(clone);
			}

			// Pega cosolidacao dos alertas
			for (DwConsolal alerta : dwci.getDwConsols().iterator().next().getDwConsolals()) {
				DwConsolal clone = alerta.clone(false);
				dwconsolClone.getDwConsolals().add(clone);
			}
			if (retorno.getListaDwConsolId() == null) {
				retorno.setListaDwConsolId(new ArrayList<DwConsolid>());
			}
			retorno.getListaDwConsolId().add(idClone);
			getDao().evict(dwci);

		} // fim do for em dwconsolid

		// log do loop principal

		if (this.filtro != null) {
			if (this.filtro.getOmGt() != null && this.filtro.getOmPt() == null) {
				int quantidadePts = 0;
				OmObjDAO objDAO = new OmObjDAO(getDaoSession());
				List<OmObj> listaobj = objDAO.pesquisarOmObsByOmGt(this.filtro.getOmGt());
				for (OmObj obj : listaobj) {
					if (obj.getTpObj().equals(obj.getTIPO_OBJ_PT())) {
						quantidadePts++;
					}
				}
				if (quantidadePts == 0)
					quantidadePts = 1;

				tempoCalendario = tempoCalendario * quantidadePts;
			}
		}

		// calcular indicadores da lista de produtos
		for (ProdutoResumoBIDTO produto : listaProdutosBI.values()) {
			IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, omptCalculoCicloMedio,
					new BigDecimal(produto.getSegCiclosProdutivos()), new BigDecimal(produto.getQtdCiclosProdutivos()),
					new BigDecimal(produto.getSegTempoParadaSemPeso()));

			produto.setCicloMedio(cmRN.calcularCicloMedio().doubleValue());
			produto.setCicloPadrao(
					produto.getQtdCiclosProdutivos() > 0 ? (produto.getCicloPadraoSUM() / produto.getCicloPadraoCOUNT()) : 0d);
			produto.setQtPcsCicloAtiva(
					produto.getQtdCiclosProdutivos() > 0 ? (produto.getQtPcsCicloAtivaSUM() / produto.getQtdCiclosProdutivos()) : 0d);
			produto.setQtPcsCicloTotal(
					produto.getQtdCiclosProdutivos() > 0 ? (produto.getQtPcsCicloTotalSUM() / produto.getQtdCiclosProdutivos()) : 0d);

			produto.setEfiRea(FormulasInjet
					.calcularEficienciaRealizacao(new BigDecimal(produto.getQtLiquida()), new BigDecimal(produto.getQtPrevista()))
					.doubleValue());
			produto.setEfiCic(
					FormulasInjet.calcularEficienciaCiclo(new BigDecimal(produto.getCicloPadrao()), new BigDecimal(produto.getCicloMedio()))
							.doubleValue());
			produto.setIndRef(FormulasInjet
					.calcularIndiceRefugo(new BigDecimal(produto.getQtRefugada()), new BigDecimal(produto.getQtBruta())).doubleValue());
			produto.setIndPar(FormulasInjet
					.calcularIndiceParada(new BigDecimal(produto.getSegTempoParadasComPeso()), new BigDecimal(produto.getSegTempoAtivo()))
					.doubleValue());
			produto.setIndPer(FormulasInjet
					.calcularIndicePerda(new BigDecimal(produto.getQtPerdas()), new BigDecimal(produto.getQtPrevista())).doubleValue());
			produto.setIndPCI(FormulasInjet.calcularIndicePcsPorCicloAtivas(new BigDecimal(produto.getQtPcsCicloTotal().doubleValue()),
					new BigDecimal(produto.getQtPcsCicloAtiva().doubleValue())).doubleValue());
			produto.setOee(
					FormulasInjet.calcularOEE(new BigDecimal(produto.getSegTempoProdutivas()), new BigDecimal(produto.getSegTempoAtivo()))
							.doubleValue());
		}

		// Trouxe pra ca o trecho abaixo que estava em recuperarListaProdutos,
		// pois o trecho era executado varias vezes pra cada dwconsolid gerando
		// um reprocesso desnecessario

		// calcular indicadores PT
		for (PtRapResumoDTO itemLista : listaIndicadoresPt.values()) {
			/*
			 * Alessandre em 09/11/16 nao eh possivel usar a classe IndicadorCicloMedioRN pois o ciclo medio deve ser desconsiderado quando
			 * nao houver producao
			 * 
			 */
			itemLista.setCicloMedio(itemLista.getCicloMedio());
			itemLista.setCicloPadrao(itemLista.getCicloPadraoSUM() / itemLista.getQtCicloPadraoSUM());
			itemLista.setQtPcsCicloAtiva(itemLista.getQtdCiclosProdutivos() > 0 ? (itemLista.getQtPcsCicloAtivaSUM() / itemLista.getQtdCiclosProdutivos()) : 0d);
			itemLista.setQtPcsCicloTotal(itemLista.getQtdCiclosProdutivos() > 0 ? (itemLista.getQtPcsCicloTotalSUM() / itemLista.getQtdCiclosProdutivos()) : 0d);

			itemLista.setEfiRea(FormulasInjet.calcularEficienciaRealizacao(new BigDecimal(itemLista.getQtLiquida()), new BigDecimal(itemLista.getQtPrevista())).doubleValue());

			itemLista.setEfiCic(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(itemLista.getCicloPadrao()), new BigDecimal(itemLista.getCicloMedio())).doubleValue());

			itemLista.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(itemLista.getQtRefugada()), new BigDecimal(itemLista.getQtBruta())).doubleValue());
			itemLista.setIndPar(FormulasInjet.calcularIndiceParada(new BigDecimal(itemLista.getSegTempoParadasComPeso()), new BigDecimal(itemLista.getSegTempoAtivo())).doubleValue());
			itemLista.setIndPer(FormulasInjet.calcularIndicePerda(new BigDecimal(itemLista.getQtPerdas()), new BigDecimal(itemLista.getQtPrevista())).doubleValue());
			itemLista.setIndPCI(FormulasInjet.calcularIndicePcsPorCicloAtivas(new BigDecimal(itemLista.getQtPcsCicloTotal().doubleValue()), new BigDecimal(itemLista.getQtPcsCicloAtiva().doubleValue())).doubleValue());
			itemLista.setOee(FormulasInjet.calcularOEE(new BigDecimal(itemLista.getSegTempoProdutivas()), new BigDecimal(itemLista.getSegTempoAtivo())).doubleValue());
		}
		// calcular indicadores PT + RAP
		for (PtRapResumoDTO itemLista : listaIndicadoresPtRap.values()) {
			/*
			 * Alessandre em 09/11/16 nao eh possivel usar a classe IndicadorCicloMedioRN pois o ciclo medio deve ser desconsiderado quando
			 * nao houver producao
			 * 
			 */
			itemLista.setCicloMedio(itemLista.getCicloMedio());
			itemLista.setCicloPadrao(itemLista.getCicloPadraoSUM() / itemLista.getQtCicloPadraoSUM());
			itemLista.setQtPcsCicloAtiva(itemLista.getQtdCiclosProdutivos() > 0 ? (itemLista.getQtPcsCicloAtivaSUM() / itemLista.getQtdCiclosProdutivos()) : 0d);
			itemLista.setQtPcsCicloTotal(itemLista.getQtdCiclosProdutivos() > 0 ? (itemLista.getQtPcsCicloTotalSUM() / itemLista.getQtdCiclosProdutivos()) : 0d);

			itemLista.setEfiRea(FormulasInjet.calcularEficienciaRealizacao(new BigDecimal(itemLista.getQtLiquida()), new BigDecimal(itemLista.getQtPrevista())).doubleValue());
			itemLista.setEfiCic(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(itemLista.getCicloPadrao()), new BigDecimal(itemLista.getCicloMedio())).doubleValue());

			itemLista.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(itemLista.getQtRefugada()), new BigDecimal(itemLista.getQtBruta())).doubleValue());
			itemLista.setIndPar(FormulasInjet.calcularIndiceParada(new BigDecimal(itemLista.getSegTempoParadasComPeso()), new BigDecimal(itemLista.getSegTempoAtivo())).doubleValue());

			itemLista.setIndPer(FormulasInjet.calcularIndicePerda(new BigDecimal(itemLista.getQtPerdas()), new BigDecimal(itemLista.getQtPrevista())).doubleValue());
			itemLista.setIndPCI(FormulasInjet.calcularIndicePcsPorCicloAtivas(new BigDecimal(itemLista.getQtPcsCicloTotal()), new BigDecimal(itemLista.getQtPcsCicloAtiva())).doubleValue());
			itemLista.setOee(FormulasInjet.calcularOEE(new BigDecimal(itemLista.getSegTempoProdutivas()), new BigDecimal(itemLista.getSegTempoAtivo())).doubleValue());

		}

		// Ã­ndice de paradads
		indiceparadas = FormulasInjet.calcularIndiceParada(BigDecimal.valueOf(tempoparadacp), BigDecimal.valueOf(tempoativo)).doubleValue();
		indiceParadasSemPeso = FormulasInjet.calcularIndiceParada(BigDecimal.valueOf(tempoparadasp), BigDecimal.valueOf(tempoativo)).doubleValue();

		// Ã­ndice de refugos
		indicerefugos = FormulasInjet.calcularIndiceRefugo(prodref.longValue(), producaoBruta.longValue()).doubleValue();
		indicerefugosGr = FormulasInjet.calcularIndiceRefugo(producaoRefKg.longValue(), producaoBrutaKg.longValue()).doubleValue();

		// Indice de cavidades
		indicePCI = (double) FormulasInjet.calcularIndiceCavidades(new BigDecimal(producaoPorCicloAtivo), new BigDecimal(producaoPorCicloTotal));

		// Ã­ndice de perdas
		indiceperdas = FormulasInjet.calcularIndicePerda(perdaciclo, perdaparadacp, prodref.doubleValue(), perdaPCI, prodprev.doubleValue()).doubleValue();

		indiceperdasGr = FormulasInjet.calcularIndicePerda(perdaCicloKg, perdaParadaKg, producaoRefKg, perdaPCIKg, producaoPrevistaKg).doubleValue();

		// eficiÃªncia de realizaÃ§Ã£o
		eficienciarealizacao = FormulasInjet.calcularEficienciaRealizacao(prodboa, prodprev).doubleValue();

		eficienciarealizacaoGr = FormulasInjet.calcularEficienciaRealizacao(producaoLiquidaKg, producaoPrevistaKg).doubleValue();

		Double segcicloPadraoMedio = 0d;
//		Double segcicloMedioMedio = 0d;
		

		// Calcular o ciclo medio global de todos os dwconsolid
		IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, null, tempoCicloProdutivoSum, qtAutoCicloprodutivoSum, segAutoTempoparadaSpSum);

		retorno.setCiclosCicMedio(cmRN.calcularCicloMedio().doubleValue());

		if (retorno.getCiclosCicMedio() > 0d) {
			// cÃ¡lculo do ciclo padrÃ£o mÃ©dio
			segcicloPadraoMedio = segcicloPadraoSum / qtdItensCicPadrao;

			// cÃ¡lculo da eficiÃªncia de ciclo
			eficienciaciclopond = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(segcicloPadraoMedio),
					new BigDecimal(retorno.getCiclosCicMedio())).doubleValue();

			// EficiÃªncia de ciclo baseada no Ãºltimo ciclo padrÃ£o
			eficienciaciclo = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(segcicloPadraoMedio),
					new BigDecimal(retorno.getCiclosCicMedio())).doubleValue();

//			segcicloMedioMedio = segcicloMedioSum / qtdItensCicPadrao;
			
			if (IdwFacade.IS_IDW_ATIVO == false) {
				IndicadoresDoDetalheCiclosRN irn = new IndicadoresDoDetalheCiclosRN(getDao());
				Double segCicPadraoMedioInjet =  irn.calcularCicloPadraoInjet(retorno.getListaDwConsolId(), filtro);
				Double segCicMedioMedioInjet =  irn.calcularCicloMedioInjet(retorno.getListaDwConsolId(), filtro);
				eficienciaciclo = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(segCicPadraoMedioInjet),
						new BigDecimal(segCicMedioMedioInjet)).doubleValue();				
			}
		}

		// eficiencia de ciclo ponderada
		eficienciaciclopond = eficienciaciclo;

		// horas totais
		tempototal = FormulasInjet.calcularTempoTotal(BigDecimal.valueOf(tempoparadasp), BigDecimal.valueOf(tempoativo)).doubleValue();

		
		// Recalcula tempo produtivo. Obtem os dados corretos, caso tenha sido
		// consolidado errado no passado
		// Alessandre em 08-06-15 mudei para ca o calculo do tempo produtivo
		// pois onde estava estava sendo impactado por 2 ops no turno com ritmo
		// - outra +
		Double tempoProdutivoAutoItem = FormulasInjet.calcularTempoprodutivas(new BigDecimal(tempoboas), BigDecimal.ZERO, new BigDecimal(temporitmo)).doubleValue();

		if (IdwFacade.IS_IDW_ATIVO == false) {
			tempoProdutivoAutoItem = FormulasInjet.calcularTempoprodutivas(new BigDecimal(tempoboas), new BigDecimal(tempoPCI), new BigDecimal(temporitmo)).doubleValue();		
		}
		
		tempoprodutivas = tempoProdutivoAutoItem;
		if (producaoBruta == null || producaoBruta.doubleValue() <= 0d) {
			tempoprodutivas = 0d;
		}

		// utilizaÃ§Ã£o
		utilizacao = FormulasInjet
				.calcularUtilizacao(BigDecimal.valueOf(tempotrabalhado), BigDecimal.valueOf(tempoativo)).doubleValue();

		// eficiÃªncia
		eficiencia = FormulasInjet
				.calcularEficiencia(BigDecimal.valueOf(tempoprodutivas), BigDecimal.valueOf(tempotrabalhado))
				.doubleValue();

		// pcs por ciclo (mÃ©dia)
		qtdItensFolha = (long) listaDwconsolid.size();

		if (qtdItensFolha > 0) {
			// cÃ¡lculo de pcs por ciclo mÃ©dia
			qtPcsCiclo = qtPcsCicloSum / qtdItensFolha;
		}

		// Alessandre: em 23-5-13 qtPcdsCiclo nao tera valor qdo nao exitir
		// dwconsolid para dwrt
		if (qtPcsCiclo != null && qtPcsCiclo > 0l) {
			// ciclos a executar
			ciclosExecutados = (producaoBrutaOP - producaoRefugadaOP) / qtPcsCiclo;
			ciclosAExecutar = producaoPlanejadaOP / qtPcsCiclo;
		}

		if ((ciclosAExecutar - ciclosExecutados) < 0) {
			ciclosAExecutar = 0l;
		} else {
			ciclosAExecutar = ciclosAExecutar - ciclosExecutados;
		}

		// MTBF e MTTR
		segMTBF = FormulasInjet.calcularMTBF(new BigDecimal(tempoativo), qtdeParadaMTBF).doubleValue();
		segMTTR = FormulasInjet.calcularMTTR(new BigDecimal(segTempoparadamtbf), qtdeParadaMTBF).doubleValue();

		/*
		 * Inicializar cavidades a partir da ultima folha encontrada
		 */
		cavidadesAtivasMolde = BigDecimal.ZERO;
		cavidadesTotalMolde = BigDecimal.ZERO;
		if (dwfolhaUltima != null && dwfolhaUltima.getDwFolharaps() != null) {
			for (DwFolharap rap : dwfolhaUltima.getDwFolharaps()) {
				if (rap.getDwFolharapcoms() != null) {
					for (DwFolharapcom com : rap.getDwFolharapcoms()) {
						cavidadesAtivasMolde = cavidadesAtivasMolde.add(com.getQtAtiva());
						cavidadesTotalMolde = cavidadesTotalMolde.add(com.getQtTotal());
					}
				}
			}
		}
		if (cavidadesAtivasMolde == null || cavidadesAtivasMolde.intValue() <= 0) {
			if (dwfolhaUltima != null && dwfolhaUltima.getDwFolhaiacs() != null) {
				for (DwFolhaiac iac : dwfolhaUltima.getDwFolhaiacs()) {
					cavidadesAtivasMolde = iac.getQtAtiva();
					cavidadesTotalMolde = iac.getQtAtiva();
				}
			}
		}
		if (cavidadesAtivasMolde == null || cavidadesAtivasMolde.intValue() <= 0) {
			cavidadesAtivasMolde = BigDecimal.ONE;
			cavidadesTotalMolde = BigDecimal.ONE;
		}

		if (ciclopadrao != null && cavidadesAtivasMolde != null) {
			try {
				// Marcos Sardinha: 2018-04-03 >> Defeito 4887 (valor da meta/hora diferente nas guias producao e ciclo)
				// A meta precisa ser calculada com base na ultima versao do ciclo

				// retorno.setMetaHora(FormulasInjet.calcularMetaHora(ciclopadrao, cavidadesAtivasMolde.longValue()).doubleValue());
				
				retorno.setMetaHora(FormulasInjet.calcularMetaHora(cicloPadraoMetaHora, cavidadesAtivasMolde ).doubleValue());	
				if (IdwFacade.IS_IDW_ATIVO == false  && dwfolhaUltima != null ) {					
					retorno.setMetaHora(FormulasInjet.calcularMetaHora(cicloPadraoMetaHora, AritmeticaUtil.multiplicar(cavidadesAtivasMolde, dwfolhaUltima.getQtFatorcontagem())).doubleValue());
					if (ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais()) {
						retorno.setMetaHora(FormulasInjet.calcularMetaHora(cicloPadraoMetaHora, AritmeticaUtil.multiplicar(cavidadesTotalMolde, dwfolhaUltima.getQtFatorcontagem())).doubleValue());
					}
				}
				
			} catch (NumberFormatException e) {
				retorno.setMetaHora(0d);
			}
		}

		if (cavidadesAtivasMolde != null && cavidadesAtivasMolde.intValue() > 0) {
			// Obtem a quantidade de cavidade ativas e total para o molde da
			// folha
			retorno.setCav_ativas(String.valueOf(cavidadesAtivasMolde.intValue()) + "/"
					+ String.valueOf(cavidadesTotalMolde.intValue()));
			retorno.setPcsPorCicloAtivas(cavidadesAtivasMolde.doubleValue()); // getPcsPorCicloTotais(listaDwconsolid)
			retorno.setPcsPorCicloTotais(cavidadesTotalMolde.doubleValue()); // getPcsPorCicloTotais(listaDwconsolid)

		} else
			retorno.setCav_ativas("");

		if (tempototal > tempoCalendario && tempoCalendario > 0)
			tempototal = tempoCalendario.doubleValue();

		tempoSemColeta = tempoCalendario - tempototal.intValue();
		if (tempoSemColeta < 0) {
			tempoSemColeta = 0;
		}

		tempoDuplicadoColeta = tempototal.intValue() - tempoCalendario;
		if (tempoDuplicadoColeta < 0) {
			tempoDuplicadoColeta = 0;
		}

		// quantidades e indicadores
		retorno.setTempoAtivo(tempoativo);

		retorno.setIndiceParadas(indiceparadas);
		retorno.setIndiceParadasSemPeso(indiceParadasSemPeso);

		retorno.setPerdasParadas(perdaparadacp.doubleValue());
		retorno.setPerdasParadasSemPeso(perdaParadaSP.doubleValue());
		retorno.setPerdaParadaKg(perdaParadaKg);
		retorno.setPerdaParadaTn(perdaParadaTn);

		retorno.setPci(perdaPCI);
		retorno.setPciKg(perdaPCIKg);
		retorno.setPciTn(perdaPCITn);

		retorno.setPerdasCiclos(perdaciclo.doubleValue());
		retorno.setPerdaCicloKg(perdaCicloKg);
		retorno.setPerdaCicloTn(perdaCicloTn);

		retorno.setQtdRefugadas(prodref.doubleValue());
		retorno.setProducaoRefugadaKg(producaoRefKg);
		retorno.setProducaoRefugadaTn(producaoRefTn);

		retorno.setQtdPrevista(prodprev.doubleValue());
		retorno.setProducaoPrevistaKg(producaoPrevistaKg);
		retorno.setProducaoPrevistaTn(producaoPrevistaTn);

		retorno.setQtdPecasBoas(prodboa.doubleValue());
		retorno.setProducaoLiquidaKg(producaoLiquidaKg);
		retorno.setProducaoLiquidaTn(producaoLiquidaTn);

		retorno.setQtdProduzida(producaoBruta.doubleValue());
		retorno.setProducaoBrutaKg(producaoBrutaKg);
		retorno.setProducaoBrutaTn(producaoBrutaTn);

		retorno.setIndiceRefugos(indicerefugos);
		retorno.setIndiceRefugoGr(indicerefugosGr);
		retorno.setIndiceCavAtivas(indicePCI);
		retorno.setIndicePerdas(indiceperdas);
		retorno.setIndicePerdasGr(indiceperdasGr);
		retorno.setEfiRealizacao(eficienciarealizacao);
		retorno.setEfiRealizacaoGr(eficienciarealizacaoGr);
		retorno.setEfiCiclos(eficienciaciclo);
		retorno.setEficiclosPond(eficienciaciclopond);
		retorno.setTotalPerdas(getTotalPerdas());

		// tempos

		retorno.setTempoParadas(tempoparadacp);

		if (tempoparadasp < 0d)
			retorno.setTempoNaoDisponivel(0d);
		else
			retorno.setTempoNaoDisponivel(tempoparadasp);
		retorno.setTempoCiclosImprodutivos(tempocicloimprodutivo);
		retorno.setTempoRefugos(temporefugo);

		// Se o ritmo for negativo mas o inteiro do tempo em segundos for zero, entao
		// zera-lo como positivo, pois no chamado 3846 apareceu zerado negativo devido os milisegundos
		// que não sao apresentados
		if (temporitmo != null && temporitmo.intValue() != 0) {
			retorno.setTempoRitmo(temporitmo);
		} else {
			// Alex 01/06/2017 #3824
			retorno.setTempoRitmo(0d);
			// retorno.setTempoRefugos(0d);
		}

		retorno.setTempoCavIsoladas(tempoPCI);
		retorno.setTempoDisponiveis(tempoativo);
		retorno.setTempoTrabalhadas(tempotrabalhado);

		retorno.setTempoBoas(tempoboas);
		retorno.setTempoProdutivas(tempoprodutivas);
		retorno.setTempoTotais(tempototal);
		retorno.setTempoCalendario(tempoCalendario);
		retorno.setTempoSemColeta(tempoSemColeta);
		retorno.setTempoDuplicadoColeta(tempoDuplicadoColeta);

		retorno.setUtilizacao(utilizacao);
		retorno.setEficiencia(eficiencia);

		Double segTempoCiclosProdutivosSemParadasVariacaoRitmo = new BigDecimal(segTempoCiclosProdutivos)
				.subtract(segTempoparadaCpVr).subtract(segTempoparadaSpVr).doubleValue();

		if (segTempoCiclosProdutivosSemParadasVariacaoRitmo < 0)
			segTempoCiclosProdutivosSemParadasVariacaoRitmo = 0d;

		if (producaoBruta == null || producaoBruta.doubleValue() <= 0d) {
			segTempoCiclosProdutivosSemParadasVariacaoRitmo = 0d;
		}
		// Alessandre me 17-06-15 tenho que rever a consolidacao geral focando
		// nesses campos de variacao de ritmo, por enquanto igualei o ciclos
		// produtivos
		// ao tempo trabahado para a SEMP.
		// Em 11-11-15 comentei a linha abaixo para nao usar mais os ciclos
		// produtivos sem as paradas de variacao de ritmo
		// retorno.setTempoCiclosProdutivos(segTempoCiclosProdutivosSemParadasVariacaoRitmo.doubleValue());
		retorno.setTempoCiclosProdutivos(segTempoCiclosProdutivos.doubleValue());

		/*
		 * GAMBI removi abaixo pra teste do chile retorno.setTempoCiclosProdutivos(tempotrabalhado); retorno.setTempoBoas(tempotrabalhado);
		 * retorno.setTempoProdutivas(FormulasInjet.calcularTempoprodutivas( new BigDecimal(tempotrabalhado), BigDecimal.ZERO, new
		 * BigDecimal(temporitmo)).doubleValue());
		 */
		//

		oee = FormulasInjet
				.calcularOEE(BigDecimal.valueOf(retorno.getTempoProdutivas()), BigDecimal.valueOf(tempoativo))
				.doubleValue();

		// OEE capital
		oeeCapital = FormulasInjet
				.calcularOEECapital(BigDecimal.valueOf(tempoprodutivas), BigDecimal.valueOf(tempototal)).doubleValue();

		retorno.setProdutividadeOEE(oee);
		retorno.setProdutividadeOEECapital(oeeCapital);

		// guia ciclos
		retorno.setCiclosEficienciaCic(eficienciaciclo);

		retorno.setCiclosCicPadrao(segcicloPadraoMedio);

		if (listaDwconsolid.size() > 0 && listaDwconsolid.get(listaDwconsolid.size() - 1).getDwRt() != null) {
			// Marcos Sardinha: VFWEB - Injet
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno.setCiclosUltimoCic(listaDwconsolid.get(listaDwconsolid.size() - 1).getDwRt());
				retorno.setCiclosEficienciaUltCic(
						FormulasInjet.calcularEficienciaCiclo(BigDecimal.valueOf(retorno.getCiclosCicPadrao()),
								BigDecimal.valueOf(retorno.getCiclosUltimoCic())).doubleValue());
			} else {
				// listaDwconsolid.get(0).getIdConsolid() == 0
				DAOGenericoInjet daoInj = new DAOGenericoInjet();
				daoInj.iniciaSessao();
				TempoRealInjetRN rnij = new TempoRealInjetRN(daoInj);
				retorno.setCiclosUltimoCic(rnij.getUltimoCiclo(true, listaDwconsolid, filtro).doubleValue());
				daoInj.finalizaSessao();
			}
		}
		retorno.setQtdeCiclosExecutar(ciclosAExecutar.doubleValue());

		// produtos
		retorno.setListaProdutos(listaprodutos);
		produtosParaAndroid.setProdutos(listaprodutos);
		retorno.setProdutosandroidDTO(produtosParaAndroid);

		// operadores
		operadoresandroidDTO.setListaOperadoresDTO(listaoperadores);
		retorno.setOperadoresandroidDTO(operadoresandroidDTO);
		retorno.setListaOperadores(listaoperadores);

		// alertas
		alertasandroidDTO.setListaAlertasDTO(listaalertas);
		retorno.setAlertasandroidDTO(alertasandroidDTO);
		retorno.setListaAlertas(listaalertas);

		// lista de perdas
		perdasAndroidDTO.setListaperdasDTO(listaperdas);
		retorno.setPerdasandroidDTO(perdasAndroidDTO);
		retorno.setListaPerdas(listaperdas);

		// resumo exibidos quando existe filtro de produto
		retorno.setListaIndicadoresPt(new ArrayList<PtRapResumoDTO>(listaIndicadoresPt.values()));
		retorno.setListaIndicadoresPtRap(new ArrayList<PtRapResumoDTO>(listaIndicadoresPtRap.values()));

		/*
		 * Separando o calculo do ciclo padrao e do ciclo medio a parte do codigo principal, focando a interacao na lista de dwconsolid
		 */
		IndicadoresDoDetalheCiclosRN irn = new IndicadoresDoDetalheCiclosRN(getDao());
		retorno.setCiclosCicPadrao(irn.calcularCicloPadrao(listaDwconsolid, filtro));
		retorno.setCiclosCicMedio(irn.calcularCicloMedio(listaDwconsolid, filtro));
		retorno.setCiclosEficienciaCic((double) FormulasInjet.calcularEficienciaCiclo(
				new BigDecimal(retorno.getCiclosCicPadrao()), new BigDecimal(retorno.getCiclosCicMedio())));

		// Marcos Sardinha: VFWEB - Injet
		if (IdwFacade.IS_IDW_ATIVO) {
			
			// Alessandre em 09-06-22 chamado #7984 o calculo desse ciclo para a OP sempre retorna 0,mas ele eh calculado acima, entao se ja tiver um valor
			// nao calcular mais
			if (retorno.getCiclosUltimoCic() == null || retorno.getCiclosUltimoCic() <= 0)
				retorno.setCiclosUltimoCic(irn.getUltimoCiclo(listaDwconsolid, filtro));
		} else {
			retorno.setCiclosEficienciaCic(eficienciaciclo);
			
			TempoRealInjetRN rnij = new TempoRealInjetRN();
			rnij.getDao().iniciaSessao();
			retorno.setCiclosUltimoCic(rnij.getUltimoCiclo(true, listaDwconsolid, filtro).doubleValue());
			rnij.getDao().finalizaSessao();
		}

		retorno.setCiclosEficienciaUltCic((double) FormulasInjet.calcularEficienciaCiclo(new BigDecimal(retorno.getCiclosCicPadrao()), new BigDecimal(retorno.getCiclosUltimoCic())));
		retorno.setEfiCiclos(retorno.getCiclosEficienciaCic());
		retorno.setEficiclosPond(retorno.getCiclosEficienciaCic()); // por
																	// enquanto
																	// o
																	// ponderado
																	// eh igual
																	// ao medio
		
		retorno.setQtTestes(qtTestes);
		retorno.setQtDefeitos(qtDefeitos);
		retorno.setIndiceDefeito(indiceDefeitos.doubleValue());

		/*
		 * Separando o calculo do tempo da ultima parada do loop principal. O objetivo eh simplificar o codigo para analise das variaveis
		 * calculadas Com o tempo essa separacao deveria ser feita para todos os indicadores ou grupo de indicadores
		 */
		// Marcos Sardinha: VFWEB - Injet
		if (IdwFacade.IS_IDW_ATIVO) {
			IndicadoresDoDetalheUltimaParadaRN uprn = new IndicadoresDoDetalheUltimaParadaRN(getDao(), listaDwconsolid);

			Integer segTempoUltimaParada = uprn.calcularTempoUltimaParada();
			// Atualiza o retorno com os dados da ulitma parada
			if (segTempoUltimaParada == null)
				retorno.setTempoParadaAtualUltParada("");
			else
				retorno.setTempoParadaAtualUltParada(DataHoraRN.formatSegundosParaHHMMSS(segTempoUltimaParada));
			retorno.setParadaAtualUltParada(uprn.getParadaAtualUltParada());
			retorno.setParadaDtInicio(uprn.getDataInicioUltimaParada());
			retorno.setParadaHrIncio(uprn.getHoraInicioUltimaParada());
			retorno.setParadaAreaResponsavel(uprn.getAreaResponsavel());

		} else {
			DAOGenericoInjet daoInj = new DAOGenericoInjet();
			daoInj.iniciaSessao();
			IndicadoresDoDetalheUltimaParadaInjetRN uprn = new IndicadoresDoDetalheUltimaParadaInjetRN(daoInj, listaDwconsolid);

			Integer segTempoUltimaParada = uprn.calcularTempoUltimaParada();
			// Atualiza o retorno com os dados da ulitma parada
			if (segTempoUltimaParada == null)
				retorno.setTempoParadaAtualUltParada("");
			else
				retorno.setTempoParadaAtualUltParada(DataHoraRN.formatSegundosParaHHMMSS(segTempoUltimaParada));
			retorno.setParadaAtualUltParada(uprn.getParadaAtualUltParada());
			retorno.setParadaDtInicio(uprn.getDataInicioUltimaParada());
			retorno.setParadaHrIncio(uprn.getHoraInicioUltimaParada());
			retorno.setParadaAreaResponsavel(uprn.getAreaResponsavel());

			daoInj.finalizaSessao();
		}

		retorno.setParadaMTBF(segMTBF);
		retorno.setParadaMTTR(segMTTR);

		// Calculo usado pelo injet numProjPCIHrs = ((numQtdInj *
		// numCicloPadrao) / numCavidades) * (numCavidades - numCavAtivas)
		// Alessandre em 14-07-16 implementando o
		// projecao = qtde de injecoes * ciclo padrao / total de cavidades
		// projecao = projecao * (total cavidades - cavidades ativas)
		double projecao = 0d;
		projecao = (qtCicloProdutivos * segcicloPadrao) / cavidadesTotalMolde.doubleValue();
		projecao *= (cavidadesTotalMolde.subtract(cavidadesAtivasMolde)).doubleValue();
		
		if (IdwFacade.IS_IDW_ATIVO == false) {
			MonitorizacaoInjetRN rnij = new MonitorizacaoInjetRN();
			rnij.getDao().iniciaSessao();
			ProjecaoPCIDTO proj = rnij.getProjecaoPCI(mapOPs);			
			rnij.getDao().finalizaSessao();
			
			projecao = proj.getSegProjPCI().doubleValue();
			retorno.setQtdeCiclosExecutar(proj.getQtdCiclosExec().doubleValue());
		}
		
		retorno.setProjPCIHoras(projecao);

		
		// Defeito #6554 - Web: Gráfico de pizza no web está exibindo valores de cavidades isoladas e produtivas diferente do injet
		if (IdwFacade.IS_IDW_ATIVO == false) {
			retorno.setTempoCavIsoladas(new BigDecimal(tempoPCI.intValue()).doubleValue());
			retorno.setTempoProdutivas(new BigDecimal(tempoprodutivas.intValue()).doubleValue());			
		}  
	}

	private OmMapa getMapaDeAlimentacao(String op, OmPt pt) {
		if (pt == null || pt.getCdPt() == null || op == null) {
			return null;
		}

		OmMapaDAO mapaDAO = new OmMapaDAO(getDao().getSession());
		return mapaDAO.getMapaDeAlimentacao(op, pt);
	}

	/*
	 * Acredito que esses indicadores s�o adicionais, mas ainda nao entendi o motivo deles estarem sendo gerados no momento da geracao dos
	 * indicadores Verifiquei que esses indicadores dizem respeito aos calculos por data e turno que aparecem nos graficos do BI
	 */
	public void setIndicadoresAdicionais() {
		// resumo por data

		log.iniciaAvaliacao("listaagrupada");
		List<GraficoCicloDTO> listaCiclos = new ArrayList<GraficoCicloDTO>();
		Map<String, BigDecimal> prodBrutaMaquina = new HashMap<>();
		List<MpBrutaPorMaquinaDTO> listaMpBrutaPorMaquina = new ArrayList<>();

		for (ListaDwConsolPorDataDTO dwconsolpordata : listaagrupadaDT.values()) {

			GraficoCicloDTO graficoCicloDTO = new GraficoCicloDTO();
			IndicadoresPorConjuntoConsolRN rn =
					new IndicadoresPorConjuntoConsolRN(getDao(), dwconsolpordata.getListaDwConsol(), omcfg, filtro);

			graficoCicloDTO.setDtReferencia(dwconsolpordata.getDtReferencia());

			graficoCicloDTO.setEficRealizacao(rn.getEr().doubleValue());
			graficoCicloDTO.setEficVel(rn.getEc().doubleValue());
			graficoCicloDTO.setIndAcurAtivas(rn.getIcavinat().doubleValue());
			graficoCicloDTO.setIndParadas(rn.getIp().doubleValue());
			graficoCicloDTO.setIndPerdas(rn.getIpd().doubleValue());
			graficoCicloDTO.setIndRefugos(rn.getIr().doubleValue());
			graficoCicloDTO.setProdutividadeOEE(rn.getOee().doubleValue());

			// quantidades perdidas: utilizadas na ficha da mÃ¡quina das maq
			// ciclicas
			graficoCicloDTO.setQtdPerdasCiclo(rn.getProducaoRNCiclo().doubleValue());
			graficoCicloDTO.setQtdPerdasParada(rn.getProducaoNRParada().doubleValue());
			graficoCicloDTO.setQtdPerdasRefugo(rn.getProducaoRefugada().doubleValue());
			graficoCicloDTO.setQtdPerdasPcsCicInativas(rn.getProducaoNRci().doubleValue());

			graficoCicloDTO.setQtdPerdasTotais(FormulasInjet.calcularTotalPerdas(
					graficoCicloDTO.getQtdPerdasCiclo(), graficoCicloDTO.getQtdPerdasParada(),
					graficoCicloDTO.getQtdPerdasRefugo(),
					graficoCicloDTO.getQtdPerdasPcsCicInativas()).doubleValue());

			listaCiclos.add(graficoCicloDTO);
		}
		log.mostrarAvaliacaoCompleta();

		// resumo por pt
		List<GraficoCicloDTO> listaPT = new ArrayList<GraficoCicloDTO>();

		log.iniciaAvaliacao("listaagrupadaPT");
		for (ListaDwConsolPorPtDTO dwconsolporPT : listaagrupadaPT.values()) {
			GraficoCicloDTO graficoCicloDTO = new GraficoCicloDTO();

			IndicadoresPorConjuntoConsolRN rn = new IndicadoresPorConjuntoConsolRN(getDao(),
					dwconsolporPT.getListaDwConsol(), omcfg, filtro);

			graficoCicloDTO.setCdPt(dwconsolporPT.getCdPt());
			graficoCicloDTO.setDsPt(dwconsolporPT.getDsPt());

			graficoCicloDTO.setEficRealizacao(rn.getEr().doubleValue());
			graficoCicloDTO.setEficVel(rn.getEc().doubleValue());
			graficoCicloDTO.setIndAcurAtivas(rn.getIcavinat().doubleValue());
			graficoCicloDTO.setIndParadas(rn.getIp().doubleValue());
			graficoCicloDTO.setIndPerdas(rn.getIpd().doubleValue());
			graficoCicloDTO.setIndRefugos(rn.getIr().doubleValue());
			graficoCicloDTO.setProdutividadeOEE(rn.getOee().doubleValue());

			// quantidades perdidas: utilizadas na ficha da mÃ¡quina das maq
			// ciclicas
			graficoCicloDTO.setQtdPerdasCiclo(rn.getProducaoRNCiclo().doubleValue());
			graficoCicloDTO.setQtdPerdasParada(rn.getProducaoNRParada().doubleValue());
			graficoCicloDTO.setQtdPerdasRefugo(rn.getProducaoRefugada().doubleValue());
			graficoCicloDTO.setQtdPerdasPcsCicInativas(rn.getProducaoNRci().doubleValue());

			graficoCicloDTO.setQtdPerdasTotais(FormulasInjet.calcularTotalPerdas(
					graficoCicloDTO.getQtdPerdasCiclo(), graficoCicloDTO.getQtdPerdasParada(),
					graficoCicloDTO.getQtdPerdasRefugo(),
					graficoCicloDTO.getQtdPerdasPcsCicInativas()).doubleValue());

			listaPT.add(graficoCicloDTO);

			// O loop abaixo determina o consumo de materia prima com base no
			// mapa de alimentacao
			for (DwConsol dwconsolPT : dwconsolporPT.getListaDwConsol()) {

				// Alex 27/06/2017 #4029
				String op = dwconsolPT.getDwConsolid().getPpCp().getCdCp();
				OmMapa mapaDeAlimentacao = getMapaDeAlimentacao(op, dwconsolPT.getDwConsolid().getOmPt());
				if (mapaDeAlimentacao == null || mapaDeAlimentacao.getOmPrg() == null) {
					continue;
				}

				BigDecimal consumoBrutoProducaoAtual = BigDecimal.ZERO;

				BigDecimal custoMPPorProduto = BigDecimal.ZERO;
				BigDecimal consumoMPPorProduto = BigDecimal.ZERO;
				for (OmPrgpos prgpos : mapaDeAlimentacao.getOmPrg().getOmPrgposes()) {

					BigDecimal quantidadeUsada = prgpos.getQtUsada();
					if (quantidadeUsada == null) {
						quantidadeUsada = BigDecimal.ONE;
					}

					consumoMPPorProduto = consumoMPPorProduto.add(quantidadeUsada);

					if (prgpos.getOmProduto() != null && prgpos.getOmProduto().getVlCustounit() != null) {
						BigDecimal custo = prgpos.getOmProduto().getVlCustounit();
						custo = custo.multiply(quantidadeUsada);
						custoMPPorProduto = custoMPPorProduto.add(custo);
					}
				}

				// CONSUMOS
				BigDecimal consumoMPProducaoBrutaProduto = dwconsolPT.getPcsProducaoBruta();
				consumoMPProducaoBrutaProduto = consumoMPProducaoBrutaProduto.multiply(consumoMPPorProduto);
				consumoMPProducaoBruta = consumoMPProducaoBruta.add(consumoMPProducaoBrutaProduto);

				BigDecimal consumoMPProducaoLiquidaProduto = dwconsolPT.getPcsProducaoLiquida();
				consumoMPProducaoLiquidaProduto = consumoMPProducaoLiquidaProduto.multiply(consumoMPPorProduto);
				consumoMPProducaoLiquida = consumoMPProducaoLiquida.add(consumoMPProducaoLiquidaProduto);

				BigDecimal consumoMPProducaoRefugadaProduto = dwconsolPT.getPcsProducaoRefugada();
				consumoMPProducaoRefugadaProduto = consumoMPProducaoRefugadaProduto.multiply(consumoMPPorProduto);
				consumoMPProducaoRefugada = consumoMPProducaoRefugada.add(consumoMPProducaoRefugadaProduto);

				consumoBrutoProducaoAtual = consumoBrutoProducaoAtual.add(consumoMPProducaoBrutaProduto);

				// CUSTOS
				BigDecimal custoBruto = custoMPPorProduto.multiply(dwconsolPT.getPcsProducaoBruta());
				custoMPTotalDeInsercao = custoMPTotalDeInsercao.add(custoBruto);

				BigDecimal custoLiquido = custoMPPorProduto.multiply(dwconsolPT.getPcsProducaoLiquida());
				custoMPTotalDeInsercaoLiquida = custoMPTotalDeInsercaoLiquida.add(custoLiquido);

				try {
					for (DwConsolpemp pemp : dwconsolPT.getDwConsolpemps()) {
						for (DwConsolpempoco pempoco : pemp.getDwConsolpempocos()) {
							OmProduto produto = pempoco.getDwConsolperdamplog().getOmProduto();
							if (produto == null || produto.getVlCustounit() == null) {
								continue;
							}

							BigDecimal perda = BigDecimal.ZERO;

							if (pempoco.getDwConsolperdamplog().getQtAutoPerdamp() != null) {
								perda = perda.add(pempoco.getDwConsolperdamplog().getQtAutoPerdamp());
							}

							if (pempoco.getDwConsolperdamplog().getQtManuPerdamp() != null) {
								perda = perda.add(pempoco.getDwConsolperdamplog().getQtManuPerdamp());
							}

							BigDecimal custoPerda = perda.multiply(produto.getVlCustounit());
							custoMPTotalDePerdas = custoMPTotalDePerdas.add(custoPerda);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// Alex 06/06/2017 #3707
				// if (consumoMPPorCiclo == BigDecimal.ZERO) {
				// consumoMPPorCiclo = dwconsolPT.getDwConsolid().getDwFolha().totalMPConsumidaPorCiclo(log);
				// }

				String nomeMaquina = dwconsolPT.getDwConsolid().getOmPt().getCdPt();
				if (prodBrutaMaquina.size() <= 0) {
					prodBrutaMaquina.put(nomeMaquina, consumoBrutoProducaoAtual);
				} else if (prodBrutaMaquina.containsKey(nomeMaquina)) {
					BigDecimal auxMPBruto = prodBrutaMaquina.get(nomeMaquina);
					auxMPBruto = auxMPBruto.add(consumoBrutoProducaoAtual);
					prodBrutaMaquina.remove(nomeMaquina);
					prodBrutaMaquina.put(nomeMaquina, auxMPBruto);
				} else {
					prodBrutaMaquina.put(nomeMaquina, consumoBrutoProducaoAtual);
				}

			}
		}
		log.mostrarAvaliacaoCompleta();

		// resumo por produto

		log.iniciaAvaliacao("listaTurnos");
		// resumo por turno calcula indicadores percorrendo listaTurnos
		for (DetalheMonitorizacaoPTInjetDTO itemTur : listaTurnos.values()) {
			List<DwConsol> listadwconsol = new ArrayList<>();
			for (DwConsolidDTO dwci : itemTur.getListaDwConsolidTurno().getListaDwConsolidDTO()) {
				// Alessandre em 27-08-15 Removi o clone abaixo pois preciso
				// pegar a parada em aberto mais adiante
				// DwConsolid clone = dwci.getDwConsolid().clone(false);
				// clone.setDwFolha(dwci.getDwConsolid().getDwFolha().clone(false));
				// listadwconsolid.add(clone);
				for (DwConsol dwconsol : dwci.getDwConsolid().getDwConsols()) {
					dwconsol.setDwConsolid(dwci.getDwConsolid());
					listadwconsol.add(dwconsol);
				}
			}

			IndicadoresPorConjuntoConsolRN rn = new IndicadoresPorConjuntoConsolRN(getDao(), listadwconsol, omcfg,
					filtro);

			itemTur.setEfiRealizacao(rn.getEr().doubleValue());
			itemTur.setEfiCiclos(rn.getEc().doubleValue());
			itemTur.setIndiceRefugos(rn.getIr().doubleValue());

			itemTur.setIndiceParadas(rn.getIp().doubleValue());
			itemTur.setIndiceParadasSemPeso(rn.getIpSemPeso().doubleValue());
			itemTur.setIndicePerdas(rn.getIpd().doubleValue());
			itemTur.setIndiceCavAtivas(rn.getIcavinat().doubleValue());
			itemTur.setProdutividadeOEE(rn.getOee().doubleValue());

			itemTur.setListaDwConsolidTurno(null);

		}
		log.mostrarAvaliacaoCompleta();

		log.iniciaAvaliacao("final");
		// resumo por data
		retorno.setListaCiclos(listaCiclos);

		// resumo quantidade de MP por PT
		Set<String> maquinas = prodBrutaMaquina.keySet();
		for (String maq : maquinas) {
			MpBrutaPorMaquinaDTO mpBrutaMaquina = new MpBrutaPorMaquinaDTO();
			mpBrutaMaquina.setMaquina(maq);
			mpBrutaMaquina.setMateriaPrimaBruta(prodBrutaMaquina.get(maq));
			listaMpBrutaPorMaquina.add(mpBrutaMaquina);
		}
		retorno.setListaMpBrutaPorMaquina(listaMpBrutaPorMaquina);

		// resumo por PT
		retorno.setListaIndicadoresMaquinas(listaPT);

		// grÃ¡ficos
		retorno.setListaGraficoTempoDTO(getValoresGraficoTempos());

		// resumo por turno
		retorno.setListaTurnos(new ArrayList<DetalheMonitorizacaoPTInjetDTO>(listaTurnos.values()));

		// resumo por produto - conjunto
		retorno.setListaIndicadoresProdutoConjunto(new ArrayList<ProdutoResumoBIDTO>());

		/*
		 * Marcos Sardinha: 2017-01-06 - atribuir sempre a lista de produtos - necessário pra produtos injetados no turno e grafico de
		 * conjuntos
		 */

		// if (filtro != null && filtro.getCdProdutoPai() != null) {
		if (filtro != null) {
			retorno.setListaIndicadoresProdutoConjunto(new ArrayList<ProdutoResumoBIDTO>(listaProdutosBI.values()));
		}
		log.mostrarAvaliacaoCompleta();

		// Consumo de MP por producao
		retorno.setConsumoMPProducaoBruta(consumoMPProducaoBruta);
		retorno.setConsumoMPProducaoLiquira(consumoMPProducaoLiquida);
		retorno.setConsumoMPProducaoRefugada(consumoMPProducaoRefugada);

		retorno.setCustoMPTotalDeInsercao(custoMPTotalDeInsercao);
		retorno.setCustoMPTotalDePerdas(custoMPTotalDePerdas);
		retorno.setCustoMPTotalDeInsercaoLiquida(custoMPTotalDeInsercaoLiquida);
	}

	private void calcularPrimeirosIndicadores(DwConsol dwconsol) {
		log.iniciaAvaliacao("calc1");
		DwConsolid dwci = dwconsol.getDwConsolid();

		// tempoCIcloProdutivoDwConsol � usado para armazenar o valor vindo de
		// dwConsol. Se o tempo ativo, trbalhado estiverem zerados essa variavel
		// tambem
		// sera zerada mesmo que no banco tenha valor. Isso � necessario para
		// compnensar a consolidacao de tempos trabalhados que nao tem uma
		// producao bruta acima de 0
		// Em geral isso ocorre pq nao houve registro de parada no turno, nem
		// ciclo e o turno inteiro foi contabilizado como um ciclo sem producao.
		BigDecimal tempoCicloProdutivoDwConsol = dwconsol.getSegAutoCicloprodutivo();
		BigDecimal qtdCiclosProdutivosDwConsol = dwconsol.getQtAutoCicloprodutivo();
		
		
		// tempo ativo
		if (dwconsol.getSegAutoTempoativo() == null) {
			dwconsol.setSegAutoTempoativo(BigDecimal.ZERO);
		}
		if (dwconsol.getSegManuTempoativo() == null) {
			dwconsol.setSegManuTempoativo(BigDecimal.ZERO);
		}

		// Recalcula tempo ativo, mais serguro usar em casos em que o tempo foi
		// calculado errado
		// Tempo Ativo
		tempoAtivoAutoItem = FormulasInjet.calcularTempoAtivo(tempoCicloProdutivoDwConsol,
				dwconsol.getSegAutoTempoparadaCp(), dwconsol.getSegAutoCicloimprodutivo(),
				dwconsol.getSegAutoTempoparadaCpVr(), dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();
		// Tempo manual
		tempoAtivoManuItem = FormulasInjet.calcularTempoAtivo(dwconsol.getSegManuCicloprodutivo(),
				dwconsol.getSegManuTempoparadaCp(), dwconsol.getSegManuCicloimprodutivo(),
				dwconsol.getSegManuTempoparadaCpVr(), dwconsol.getSegManuTempoparadaSpVr()).doubleValue();

		tempoativo += tempoAtivoAutoItem + tempoAtivoManuItem;

		// Se n�o houver producao bruta, entao considerar o tempoAtivo zerado.
		// Exemplo: Na Semp em determinado turno n�o apareceu registro de
		// parada,
		// mas um ciclo improdutivo foi lancado para todo o turno
		// Alessandre em 08-09-15 entretando isso causou no chile um detalhe de
		// maquina com tempo ativo zerado e tempo de parada 4h em um calendario
		// de 4h
		// zerando o indice de parada naquele turno e no BI por um periodo maior
		// um indice de parada superior a 100%
		// Assim o if abaixo foi comentado
		if (dwconsol.getPcsProducaoBruta() == null || dwconsol.getPcsProducaoBruta().doubleValue() == 0d) {
			// tempoAtivoAutoItem = 0d;
			// tempoAtivoManuItem = 0d;
		} else {
			segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwconsol.getSegAutoTempoparadaCpVr());
			segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwconsol.getSegManuTempoparadaCpVr());
		}
		log.mostrarAvaliacaoCompleta();

		log.iniciaAvaliacao("calc2");
		// tempos de parada com peso
		if (dwconsol.getSegAutoTempoparadaCp() == null) {
			dwconsol.setSegAutoTempoparadaCp(BigDecimal.ZERO);
		}
		if (dwconsol.getSegManuTempoparadaCp() == null) {
			dwconsol.setSegManuTempoparadaCp(BigDecimal.ZERO);
		}
		
		double tempoParadaCpAux = dwconsol.getSegAutoTempoparadaCp().doubleValue() + dwconsol.getSegManuTempoparadaCp().doubleValue();;
		// O if abaixo foi acrescentado pq as vezes durante a correcao da parada de uma com peso para sem peso, o tempo fica negativo, nesse caso descartar o tempo
		if (tempoParadaCpAux > 0d)
			tempoparadacp += tempoParadaCpAux;
		
		// tempo das paradas sem peso
		tempoparadasp += dwconsol.getSegAutoTempoparadaSp() != null ? dwconsol.getSegAutoTempoparadaSp().doubleValue() : 0d;
		tempoparadasp += dwconsol.getSegManuTempoparadaSp() != null ? dwconsol.getSegManuTempoparadaSp().doubleValue() : 0d;

		// tempos de ciclos improdutivos
		tempocicloimprodutivo += dwconsol.getSegAutoCicloimprodutivo() != null ? dwconsol.getSegAutoCicloimprodutivo().longValue() : 0l;
		tempocicloimprodutivo += dwconsol.getSegManuCicloimprodutivo() != null ? dwconsol.getSegManuCicloimprodutivo().longValue() : 0l;

		// tempo dos refugos
		temporefugo += dwconsol.getSegAutoTemporefugadas() != null ? dwconsol.getSegAutoTemporefugadas().longValue() : 0l;
		temporefugo += dwconsol.getSegManuTemporefugadas() != null ? dwconsol.getSegManuTemporefugadas().longValue() : 0l;

		if (dwconsol.getQtAutoCicloprodutivo() != null)
			qtAutoCicloprodutivoSum = qtAutoCicloprodutivoSum.add(dwconsol.getQtAutoCicloprodutivo());

		if (tempoCicloProdutivoDwConsol != null)
			tempoCicloProdutivoSum = tempoCicloProdutivoSum.add(tempoCicloProdutivoDwConsol);

		if (dwconsol.getSegAutoTempoparadaSp() != null)
			segAutoTempoparadaSpSum = segAutoTempoparadaSpSum.add(dwconsol.getSegAutoTempoparadaSp());

		IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, dwci.getOmPt(), tempoCicloProdutivoDwConsol,
				dwconsol.getQtAutoCicloprodutivo(), dwconsol.getSegAutoTempoparadaSp());

		segCicloMedio = cmRN.calcularCicloMedio().doubleValue(); // (dwconsol.getSegAutoCiclomedio()
																	// !=
																	// null
																	// ?
																	// dwconsol.getSegAutoCiclomedio().doubleValue()
																	// :
																	// 0d);
		// recupera ciclo padrÃ£o
		if (dwconsol.getSegAutoCiclopadrao() != null && segCicloMedio > 0d) {
			segcicloPadrao += dwconsol.getSegAutoCiclopadrao().doubleValue();
			segUltCicloPadrao = dwconsol.getSegAutoCiclopadrao().doubleValue();
		}

		try {
			// Marcos Sardinha: VFWEB - Injet
			if (IdwFacade.IS_IDW_ATIVO) {
				segUltCic = dwci.getDwRt().getSegUltimociclo().doubleValue();
			} else {
				// listaDwconsolid.get(0).getDwFolha().getIdFolha() == null
				DAOGenericoInjet daoInj = new DAOGenericoInjet();
				daoInj.iniciaSessao();
				TempoRealInjetRN rnij = new TempoRealInjetRN(daoInj);

				List<DwConsolid> listaAuxiliar = new ArrayList<DwConsolid>();
				listaAuxiliar.add(dwci);
				segUltCic = rnij.getUltimoCiclo(true, listaAuxiliar, filtro).doubleValue();
				daoInj.finalizaSessao();
			}
		} catch (NullPointerException e) {
			segUltCic = 0d;
		}

		// acumula ciclos
		segcicloPadraoSum += segUltCicloPadrao;
		segcicloMedioSum += FormulasInjet.calcularCicloMedio(tempoCicloProdutivoDwConsol, qtdCiclosProdutivosDwConsol).doubleValue(); 

		
		
		// Recalcula tempo trabalhado ritmo. Obtem os dados corretos, caso tenha
		// sido consolidado errado no passado
		//
		tempoRitmoAutoItem = FormulasInjet.calcularRitmo(tempoCicloProdutivoDwConsol,
				dwconsol.getQtAutoCicloprodutivo(), new BigDecimal(segUltCicloPadrao),
				dwconsol.getSegAutoTempoparadaCpVr(), dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();

		tempoRitmoManuItem = FormulasInjet.calcularRitmo(dwconsol.getSegManuCicloprodutivo(),
				dwconsol.getQtManuCicloprodutivo(), new BigDecimal(segcicloPadrao),
				dwconsol.getSegManuTempoparadaCpVr(), dwconsol.getSegManuTempoparadaSpVr()).doubleValue();
		log.mostrarAvaliacaoCompleta();

		log.iniciaAvaliacao("calc3");
		// soma o ciclo somente se tiver producao
		// Marcos Sardinha: 2017-06-24 >> tem que somar sempre

		/*
		 * if (dwconsol.getPcsProducaoBruta() != null && dwconsol.getPcsProducaoBruta().compareTo(BigDecimal.ZERO) > 0) { temporitmo +=
		 * tempoRitmoAutoItem + tempoRitmoManuItem; } else { tempoRitmoAutoItem = 0d; tempoRitmoManuItem = 0d; }
		 */

		temporitmo += tempoRitmoAutoItem + tempoRitmoManuItem;

		BigDecimal axCavAtivas = new BigDecimal(0.0);
		BigDecimal axCavTotal = new BigDecimal(0.0);
		BigDecimal axAutoCicloPadrao = new BigDecimal(0.0);

		if (dwconsol.getPcsAutoCavAtivas() != null)
			axCavAtivas = new BigDecimal(dwconsol.getPcsAutoCavAtivas().doubleValue());
		if (dwconsol.getPcsAutoCavTotal() != null)
			axCavTotal = new BigDecimal(dwconsol.getPcsAutoCavTotal().doubleValue());
		if (dwconsol.getSegAutoCiclopadrao() != null)
			axAutoCicloPadrao = new BigDecimal(dwconsol.getSegAutoCiclopadrao().doubleValue());

		// tempo trabalhado
		if (dwconsol.getSegAutoTempotrabalhado() == null) {
			dwconsol.setSegAutoTempotrabalhado(BigDecimal.ZERO);
		}
		if (dwconsol.getSegManuTempotrabalhado() == null) {
			dwconsol.setSegManuTempotrabalhado(BigDecimal.ZERO);
		}

		// Recalcula tempo trabalhado. Obtem os dados corretos, caso tenha sido
		// consolidado errado no passado
		Double tempoTrabalhadoAutoItem = FormulasInjet
				.calcularTempoTrabalhado(new BigDecimal(tempoAtivoAutoItem), dwconsol.getSegAutoTempoparadaCp())
				.doubleValue();
		Double tempoTrabalhadoManuItem = FormulasInjet
				.calcularTempoTrabalhado(new BigDecimal(tempoAtivoManuItem), dwconsol.getSegManuTempoparadaCp())
				.doubleValue();
		if (dwconsol.getPcsProducaoBruta() == null || dwconsol.getPcsProducaoBruta().doubleValue() == 0d) {
			// Marcos Sardinha: 2017-07-22 >> tempos nao podem ser zerados... causariam inconsistencia ao analisar os tempos
			// tempoTrabalhadoAutoItem = 0d;
			// tempoTrabalhadoManuItem = 0d;
			// tempoCicloProdutivoDwConsol = BigDecimal.ZERO;
		}

		if (tempoTrabalhadoAutoItem > 0)
			tempotrabalhado += tempoTrabalhadoAutoItem;
		if (tempoTrabalhadoManuItem > 0)
			tempotrabalhado += tempoTrabalhadoManuItem;

		// Recalcula tempo boas. Obtem os dados corretos, caso tenha sido
		// consolidado errado no passado
		Double tempoBoasAutoItem = FormulasInjet
				.calcularTempoBoas(tempoCicloProdutivoDwConsol, dwconsol.getSegAutoTemporefugadas(),
						dwconsol.getSegAutoTempoparadaCpVr(), dwconsol.getSegAutoTempoparadaSpVr())
				.doubleValue();
		Double tempoBoasManuItem = FormulasInjet
				.calcularTempoBoas(dwconsol.getSegManuCicloprodutivo(), dwconsol.getSegManuTemporefugadas(),
						dwconsol.getSegManuTempoparadaCpVr(), dwconsol.getSegManuTempoparadaSpVr())
				.doubleValue();
		if (dwconsol.getPcsProducaoBruta() == null || dwconsol.getPcsProducaoBruta().doubleValue() == 0d) {
			// Marcos Sardinha: 2017-07-22 >> tempos nao podem ser zerados... causariam inconsistencia ao analisar os tempos
			// tempoBoasAutoItem = 0d;
			// tempoBoasManuItem = 0d;
		}

		tempoboas += tempoBoasAutoItem + tempoBoasManuItem;
		if (tempoboas < 0)
			tempoboas = 0d;

		/*
		 * 
		 * Marcos Sardinha: 2017-08-30 >> calcular convertido para peso estava bugado
		 * 
		 */

		DwFolha folhaId = dwconsol.getDwConsolid().getDwFolha();
		OmPt ptId = dwconsol.getDwConsolid().getOmPt();
		BigDecimal fatorContagem = BigDecimal.ONE;

		// Marcos Sardinha: VFWEB - Injet
		if (IdwFacade.IS_IDW_ATIVO) {
			try {
				fatorContagem = folhaRN.getFatorContagemFromDwFolha(folhaId, ptId);
			} catch (SemPacoteOuFatorException e1) {
				// TODO Auto-generated catch block
			}
		} else {
			// folhaId.getIdFolha() == null
			fatorContagem = folhaId.getQtFatorcontagem();
		}

		for (DwConsolpr dwconsolpr : dwconsol.getDwConsolprs()) {
			BigDecimal qtPcsCicloAtivas_pro = BigDecimal.ZERO;
			try {
				qtPcsCicloAtivas_pro = folhaRN.getPcsPorCicloAtivas(folhaId, dwconsolpr.getOmProduto());
			} catch (SemPcsPorCicloAtivasException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BigDecimal qtPcsCicloTotal_pro = BigDecimal.ZERO;
			try {
				qtPcsCicloTotal_pro = folhaRN.getPcsPorCicloTodas(folhaId, dwconsolpr.getOmProduto());
			} catch (SemPcsPorCicloAtivasException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BigDecimal qtdCicExec_pro = AritmeticaUtil.somar(
					(dwconsol.getQtAutoCicloprodutivo() == null ? BigDecimal.ZERO : dwconsol.getQtAutoCicloprodutivo()),
					(dwconsol.getQtManuCicloprodutivo() == null ? BigDecimal.ZERO : dwconsol.getQtManuCicloprodutivo()));

			BigDecimal segTempoCicloProdutivo_pro = AritmeticaUtil.somar(
					(dwconsol.getSegAutoCicloprodutivo() == null ? BigDecimal.ZERO : dwconsol.getSegAutoCicloprodutivo()),
					(dwconsol.getSegManuCicloprodutivo() == null ? BigDecimal.ZERO : dwconsol.getSegManuCicloprodutivo()));

			BigDecimal segTempoParCpVarRitmo_pro = AritmeticaUtil.somar(
					(dwconsol.getSegAutoTempoparadaCpVr() == null ? BigDecimal.ZERO : dwconsol.getSegAutoTempoparadaCpVr()),
					(dwconsol.getSegManuTempoparadaCpVr() == null ? BigDecimal.ZERO : dwconsol.getSegManuTempoparadaCpVr()));

			BigDecimal segTempoParSpVarRitmo_pro = AritmeticaUtil.somar(
					(dwconsol.getSegAutoTempoparadaSpVr() == null ? BigDecimal.ZERO : dwconsol.getSegAutoTempoparadaSpVr()),
					(dwconsol.getSegManuTempoparadaSpVr() == null ? BigDecimal.ZERO : dwconsol.getSegManuTempoparadaSpVr()));

			BigDecimal segTempoParadaCP_pro = AritmeticaUtil.somar(
					(dwconsol.getSegAutoTempoparadaCp() == null ? BigDecimal.ZERO : dwconsol.getSegAutoTempoparadaCp()),
					(dwconsol.getSegManuTempoparadaCp() == null ? BigDecimal.ZERO : dwconsol.getSegManuTempoparadaCp()));

			BigDecimal segTempoParadaSP_pro = AritmeticaUtil.somar(
					(dwconsol.getSegAutoTempoparadaSp() == null ? BigDecimal.ZERO : dwconsol.getSegAutoTempoparadaSp()),
					(dwconsol.getSegManuTempoparadaSp() == null ? BigDecimal.ZERO : dwconsol.getSegManuTempoparadaSp()));

			BigDecimal segTempoAtivo_pro =
					AritmeticaUtil.somar((dwconsol.getSegAutoTempoativo() == null ? BigDecimal.ZERO : dwconsol.getSegAutoTempoativo()),
							(dwconsol.getSegManuTempoativo() == null ? BigDecimal.ZERO : dwconsol.getSegManuTempoativo()));

			BigDecimal segRitmo_pro = FormulasInjet.calcularRitmo(segTempoCicloProdutivo_pro, qtdCicExec_pro,
					dwconsol.getSegAutoCiclopadrao(), segTempoParCpVarRitmo_pro, segTempoParSpVarRitmo_pro);

			// perdas por paradas CP
			BigDecimal pcsPerdaParadaCP_pro =
					FormulasInjet.calcularPcsPerdaParada(segTempoParadaCP_pro, dwconsol.getSegAutoCiclopadrao(), qtPcsCicloAtivas_pro);

			// Perda de parada SP
			BigDecimal pcsPerdaParadaSP_pro =
					FormulasInjet.calcularPcsPerdaParada(segTempoParadaSP_pro, dwconsol.getSegAutoCiclopadrao(), qtPcsCicloAtivas_pro);

			// perdas por pcs/ciclo inativas
			BigDecimal pcsPerdaPCI_pro = FormulasInjet.calcularPerdaCavidade(qtdCicExec_pro, qtPcsCicloTotal_pro, qtPcsCicloAtivas_pro);
			if (IdwFacade.IS_IDW_ATIVO == false) {
				BigDecimal ciclosPrevistos = AritmeticaUtil.dividir(dwconsol.getSegAutoTempoativo(), dwconsol.getSegAutoCiclopadrao());
				pcsPerdaPCI_pro = FormulasInjet.calcularPerdaCavidade(ciclosPrevistos, qtPcsCicloTotal_pro, qtPcsCicloAtivas_pro);
			}
			
			

			// perdas por ciclo
			BigDecimal pcsPerdaCic_pro =
					FormulasInjet.calcularPcsPerdaciclo(segRitmo_pro, dwconsol.getSegAutoCiclopadrao(), qtPcsCicloAtivas_pro);

			// quantidade prevista
			BigDecimal pcsProdPrev_pro = FormulasInjet.calcularProducaoPrevista(
					segTempoAtivo_pro, 
					dwconsol.getSegAutoCiclopadrao(),
					qtPcsCicloAtivas_pro, 
					fatorContagem,
					dwci.getOmPt().getIndOee());

			if (IdwFacade.IS_IDW_ATIVO == false) {
				if (ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais()) {
					pcsProdPrev_pro = FormulasInjet.calcularProducaoPrevista(
							segTempoAtivo_pro, 
							dwconsol.getSegAutoCiclopadrao(),
							qtPcsCicloTotal_pro, 
							fatorContagem,
							dwci.getOmPt().getIndOee());
				}				
			}

			// producao total
			BigDecimal pcsProdBruta_pro = AritmeticaUtil.somar(
					(dwconsolpr.getPcsAutoProducaobruta() == null ? BigDecimal.ZERO : dwconsolpr.getPcsAutoProducaobruta()),
					(dwconsolpr.getPcsManuProducaobruta() == null ? BigDecimal.ZERO : dwconsolpr.getPcsManuProducaobruta()));

			// producao refugada
			BigDecimal pcsProdRefugada_pro = AritmeticaUtil.somar(
					(dwconsolpr.getPcsAutoProducaorefugada() == null ? BigDecimal.ZERO : dwconsolpr.getPcsAutoProducaorefugada()),
					(dwconsolpr.getPcsManuProducaorefugada() == null ? BigDecimal.ZERO : dwconsolpr.getPcsManuProducaorefugada()));

			// Marcos Sardinha: VFWEB - Injet
			if (IdwFacade.IS_IDW_ATIVO == false) {
				pcsPerdaParadaCP_pro = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(pcsPerdaParadaCP_pro);
				pcsPerdaParadaSP_pro = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(pcsPerdaParadaSP_pro);
				pcsPerdaPCI_pro = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(pcsPerdaPCI_pro);
				pcsPerdaCic_pro = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(pcsPerdaCic_pro);
				pcsProdPrev_pro = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(pcsProdPrev_pro);
				pcsProdBruta_pro = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(pcsProdBruta_pro);
				pcsProdRefugada_pro = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(pcsProdRefugada_pro);
			}

			// acumula as perdas por peso
			Long pesoBruto = 0l;

			// Marcos Sardinha: VFWEB - Injet
			if (IdwFacade.IS_IDW_ATIVO) {
				OmProduto omproduto = getDao().findById(OmProduto.class, dwconsolpr.getOmProduto().getIdProduto(), false);
				if (omproduto != null && omproduto.getGPesoBruto() != null) {
					pesoBruto = omproduto.getGPesoBruto().longValue();
				}
			} else {
				// dwconsolpr.getOmProduto().getIdProduto() == 0
				pesoBruto = dwconsolpr.getOmProduto().getGPesoBruto().longValue();
			}

			// perdas por paradas CP
			Double perdaParadaAux = pcsPerdaParadaCP_pro.doubleValue();
			perdaparadacp += perdaParadaAux;
			Double perdaParadaKgAux = (perdaParadaAux * pesoBruto) / 1000d;
			perdaParadaKg = perdaParadaKg.add(new BigDecimal(perdaParadaKgAux));
			perdaParadaTn = perdaParadaTn.add(new BigDecimal(perdaParadaKgAux / 1000));

			// Perda de parada SP
			Double perdaParadaSPAux = pcsPerdaParadaSP_pro.doubleValue();
			perdaParadaSP += perdaParadaSPAux;

			// perdas por pÃ§s/ciclo inativas
			Double perdaPCIAux = pcsPerdaPCI_pro.doubleValue();
			perdaPCI += perdaPCIAux;

			Double prodPCIKg = (perdaPCIAux * pesoBruto) / 1000d;
			perdaPCIKg = perdaPCIKg.add(new BigDecimal(prodPCIKg));
			perdaPCITn = perdaPCITn.add(new BigDecimal(prodPCIKg / 1000));

			// perdas por ciclo
			Double perdaCicAux = pcsPerdaCic_pro.doubleValue();
			perdaciclo += perdaCicAux;

			Double prodCicKg = (perdaCicAux * pesoBruto) / 1000d;
			perdaCicloKg = perdaCicloKg.add(new BigDecimal(prodCicKg));
			perdaCicloTn = perdaCicloTn.add(new BigDecimal(prodCicKg / 1000));

			// quantidade prevista
			prodprev = AritmeticaUtil.somar(prodprev, pcsProdPrev_pro);

			Double prevKg = (pcsProdPrev_pro.doubleValue() * pesoBruto) / 1000d;
			producaoPrevistaKg = producaoPrevistaKg.add(new BigDecimal(prevKg));
			producaoPrevistaTn = producaoPrevistaTn.add(new BigDecimal(prevKg / 1000));

			// producao total
			BigDecimal prodBrutaAux = pcsProdBruta_pro;
			producaoBruta = producaoBruta.add(prodBrutaAux);
			Double brutaKg = (prodBrutaAux.doubleValue() * pesoBruto) / 1000d;
			producaoBrutaKg = producaoBrutaKg.add(new BigDecimal(brutaKg));
			producaoBrutaTn = producaoBrutaTn.add(new BigDecimal(brutaKg / 1000));

			// producao refugada
			BigDecimal prodRefAux = pcsProdRefugada_pro;
			prodref = prodref.add(prodRefAux);
			Double refKg = (prodRefAux.doubleValue() * pesoBruto) / 1000d;
			producaoRefKg = producaoRefKg.add(new BigDecimal(refKg));
			producaoRefTn = producaoRefTn.add(new BigDecimal(refKg / 1000));

			// producao boa
			BigDecimal prodBoaAux = prodBrutaAux.subtract(prodRefAux);
			//Defeito #5414 - %Eficiência de Realização da Máquina no Injet é de 114.28% e na Web é de 228.57% 
			//Producao deveria ser do produto, não de dwconsol (multiplicava a producao pela qtde de produtos da op)
			
			/*
			if (dwconsol.getPcsProducaoLiquida() != null && dwconsol.getPcsProducaoLiquida().equals(BigDecimal.ZERO) == false) {
				prodboa = prodboa.add(dwconsol.getPcsProducaoLiquida());
				prodBoaAux = dwconsol.getPcsProducaoLiquida();
			} else {
				prodboa = producaoBruta.subtract(prodref);
			}
			*/

			if (dwconsolpr.getPcsProducaoLiquida() != null && dwconsolpr.getPcsProducaoLiquida().equals(BigDecimal.ZERO) == false) {
				prodboa = prodboa.add(dwconsolpr.getPcsProducaoLiquida());
				prodBoaAux = dwconsolpr.getPcsProducaoLiquida();
			} else {
				prodboa = producaoBruta.subtract(prodref);
			}
			
			Double prodBoaKg = (prodBoaAux.doubleValue() * pesoBruto) / 1000d;
			producaoLiquidaKg = producaoLiquidaKg.add(new BigDecimal(prodBoaKg));
			producaoLiquidaTn = producaoLiquidaTn.add(new BigDecimal(prodBoaKg / 1000));

		}

		// acumula tempos e qtd necessÃ¡rias para calcular o ciclo
		// mÃ©dio
		qtCicloProdutivos += dwconsol.getQtAutoCicloprodutivo() != null ? dwconsol.getQtAutoCicloprodutivo().doubleValue() : 0d;
		qtCicloProdutivos += dwconsol.getQtManuCicloprodutivo() != null ? dwconsol.getQtManuCicloprodutivo().doubleValue() : 0d;

		qtCicloProdutivosPosto = dwconsol.getQtAutoCicloprodutivo() != null ? dwconsol.getQtAutoCicloprodutivo().doubleValue() : 0d;
		qtCicloProdutivosPosto += dwconsol.getQtManuCicloprodutivo() != null ? dwconsol.getQtManuCicloprodutivo().doubleValue() : 0d;

		segTempoCiclosProdutivos += tempoCicloProdutivoDwConsol != null ? tempoCicloProdutivoDwConsol.doubleValue() : 0d;
		segTempoCiclosProdutivos += dwconsol.getSegManuCicloprodutivo() != null ? dwconsol.getSegManuCicloprodutivo().doubleValue() : 0d;

		// produÃ§Ã£o planejada
		producaoPlanejadaOP += (long) dwci.getPpCp().getQtPecasProduzir();
		producaoBrutaOP += (long) dwci.getPpCp().getProducaoBruta();
		producaoRefugadaOP += (long) dwci.getPpCp().getProducaoRefugada();

		log.mostrarAvaliacaoCompleta();

		log.iniciaAvaliacao("calc4");

		// recupera producao por ciclo

		// Marcos Sardinha: VFWEB - Injet
		if (IdwFacade.IS_IDW_ATIVO) {
			try {
				if (producaoPorCiclo.containsKey(dwci.getDwFolha())) {
					qtPcsCiclo = producaoPorCiclo.get(dwci.getDwFolha());
				} else {
					qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha()).longValue();
					producaoPorCiclo.put(dwci.getDwFolha(), qtPcsCiclo);
				}
			} catch (SemPcsPorCicloAtivasException e) {
				qtPcsCiclo = 1l;
				producaoPorCiclo.put(dwci.getDwFolha(), qtPcsCiclo);
			}
		} else {
			// dwci.getDwFolha().getIdFolha() == null
			if (producaoPorCiclo.containsKey(dwci.getDwFolha())) {
				qtPcsCiclo = producaoPorCiclo.get(dwci.getDwFolha());
			} else {
				qtPcsCiclo =
						dwci.getDwFolha().getDwFolharaps().iterator().next().getDwFolharapcoms().iterator().next().getQtAtiva().longValue();
				producaoPorCiclo.put(dwci.getDwFolha(), qtPcsCiclo);
			}
		}
		log.mostrarAvaliacaoCompleta();

		// Marcos Sardinha: 2017-06-23 >> calcula de pcs por ciclo inativa deve considerar dados informados em dwconsolid
		// double axCaAtivas = (dwci.getDwConsol().getQtAutoCavativas() == null ? 0d :
		// dwci.getDwConsol().getQtAutoCavativas().doubleValue());
		// double axCaTot = (dwci.getDwConsol().getQtAutoCavtotal() == null ? 0d : dwci.getDwConsol().getQtAutoCavtotal().doubleValue());

		/*
		 * for (DwFolharap rap : dwci.getDwFolha().getDwFolharaps()) { for (DwFolharapcom rapcom : rap.getDwFolharapcoms()) { axCaAtivas +=
		 * rapcom.getQtAtiva().doubleValue(); axCaTot += rapcom.getQtTotal().doubleValue(); } }
		 * 
		 * producaoPorCicloAtivo += axCaAtivas; producaoPorCicloTotal += axCaTot;
		 * 
		 */

		// Marcos Sardinha: 2017-06-27 >> calcula de pcs por ciclo inativa deve considerar dados das diferentes folhas (somente assim bate
		// com consolidado)
		double axCaAtivas = (dwci.getDwConsol().getQtAutoCavativas() == null ? 0d : dwci.getDwConsol().getQtAutoCavativas().doubleValue());
		double axCaTot = (dwci.getDwConsol().getQtAutoCavtotal() == null ? 0d : dwci.getDwConsol().getQtAutoCavtotal().doubleValue());

		if (mapIndPcsCiclo.containsKey(dwci.getDwFolha().getIdFolha()) == false) {
			producaoPorCicloAtivo += axCaAtivas;
			producaoPorCicloTotal += axCaTot;

			mapIndPcsCiclo.put(dwci.getDwFolha().getIdFolha(), dwci.getDwFolha().getCdFolha());
		}

		/*
		 * No caso o ciclo padrao nao pode ser usado para multimplicar a perda por cavidade pq senao o tempo sera muito alto pois em um
		 * ciclo padra pode-se fazer varias pecas. O correto eh encontrar o ciclo padrao por peca e usar esse tempo para multiplicar.
		 */
		Double cicloPadraoUnitarioPorPeca = axAutoCicloPadrao.doubleValue();
		if (axCaTot > 0d)
			cicloPadraoUnitarioPorPeca = cicloPadraoUnitarioPorPeca / axCaTot;
		else
			cicloPadraoUnitarioPorPeca = cicloPadraoUnitarioPorPeca / qtPcsCiclo;

		if (IdwFacade.IS_IDW_ATIVO) {
			// Alessandre em 21-11-16 coloquei tempoPCI+= pois estava mostrando
			// apenas o ultimo tempo
			tempoPCI += (axCavTotal.subtract(axCavAtivas).doubleValue() * cicloPadraoUnitarioPorPeca);
		} else {
			// Defeito #6554 - Web: Gráfico de pizza no web está exibindo valores de cavidades isoladas e produtivas diferente do injet
			BigDecimal ciclosProdutivosCalcPCI = (tempoCicloProdutivoDwConsol != null ? tempoCicloProdutivoDwConsol: BigDecimal.ZERO);
			for (DwFolharapcom rapCom : dwci.getDwFolha().getDwFolharaps().iterator().next().getDwFolharapcoms()) {

				//190803 tempoPCI += FormulasInjet.calcularPerdaCavidade(ciclosProdutivosCalcPCI.divide(rapCom.getQtTotal()), rapCom.getQtTotal(),rapCom.getQtAtiva()).doubleValue();

				//190803 ..
				BigDecimal bdAux = new BigDecimal(0L);
				BigDecimal bd1 = new BigDecimal(0L);
				BigDecimal bd2 = new BigDecimal(0L);
				BigDecimal bd3 = new BigDecimal(0L);
				Double dAux = new Double(0L);
				bd1 = ciclosProdutivosCalcPCI;
				bd2 = rapCom.getQtTotal();
				if (bd2.doubleValue()>0d){
					bd3 = new BigDecimal( bd1.doubleValue() / bd2.doubleValue() );					
				}
				bdAux = FormulasInjet.calcularPerdaCavidade(bd3, rapCom.getQtTotal(),rapCom.getQtAtiva());
				dAux = bdAux.doubleValue();
				tempoPCI += dAux;
				//190803.
			}
			
			
		}
		// acumula
		qtPcsCicloSum += qtPcsCiclo;

		// paradas - MTBF e MTTR
		qtdeParadaMTBF += dwconsol.getQtAutoOcoparadamtbf() != null ? dwconsol.getQtAutoOcoparadamtbf().intValue() : 0;
		qtdeParadaMTBF += dwconsol.getQtManuOcoparadamtbf() != null ? dwconsol.getQtManuOcoparadamtbf().intValue() : 0;

		segTempoparadamtbf += dwconsol.getSegAutoTempoparadamtbf() != null ? dwconsol.getSegAutoTempoparadamtbf().longValue() : 0l;
		segTempoparadamtbf += dwconsol.getSegManuTempoparadamtbf() != null ? dwconsol.getSegManuTempoparadamtbf().longValue() : 0l;

		
		// calcular total de testes e defeitos
		qtTestes = qtTestes.add( (dwconsol.getQtAutoTestes() != null ? dwconsol.getQtAutoTestes() : BigDecimal.ZERO) );
		qtDefeitos = qtDefeitos.add( (dwconsol.getQtAutoDefeitos() != null ? dwconsol.getQtAutoDefeitos() : BigDecimal.ZERO) );
		indiceDefeitos = FormulasInjet.calcularIndiceDefeito(qtTestes, qtDefeitos, 2);
	}

	private void recuperarListaProdutos(DwConsol dwconsol, DwConsolid idClone) {
		DwConsolid dwci = dwconsol.getDwConsolid();
		Double segCicloPadraoAux = null;
		if (dwconsol.getSegAutoCiclopadrao() != null) {
			segCicloPadraoAux = dwconsol.getSegAutoCiclopadrao().doubleValue();
		}
		if (segCicloPadraoAux == null) {
			try {
				segCicloPadraoAux = folhaRN.getCicloPadrao(dwci.getDwFolha(), dwci.getOmPt()).doubleValue();
			} catch (SemCicloPadraoException e2) {
				segCicloPadraoAux = 0d;
			}
		}

		// lista de produtos
		if (dwconsol.getDwConsolprs() != null) {
			MapQuery query = new MapQuery(getDao().getSession());
			query.append("SELECT est.qtUsada");
			query.append("FROM OmProcomest est");
			query.appendWhere(MapQuery._NULL, "est.omProdutoByIdProduto.idProduto = :pai", true);
			query.appendWhere(MapQuery._AND, "est.omProdutoByIdProdutomp.idProduto = :filho", true);

			// aqui deve-se calcular o tempo de parada em aberto para todos os
			// produtos, pois sera o mesmo tempo

			for (DwConsolpr dwconsolpr : dwconsol.getDwConsolprs()) {

				log.iniciaAvaliacao("produto1");
				ProdutoDTO dto = new ProdutoDTO();

				dto.setProduto(dwconsolpr.getOmProduto().clone(false));
				dto.setDtReferencia(dwci.getDtReferencia());
				dto.setDsTurno(dwci.getDwTurno().getDsTurno());
				dto.setTempoAtivo(dwconsol.getSegAutoTempoativo());
				// alessandre o setCalendario abaixo eh necessario para aparecer
				// na gui na aba produtos
				if (dwci.getDwCal() != null)
					dto.setCalendario((DwCal) dwci.getDwCal().clone(false));

				if (dwci.getDwPepro() != null)
					dto.setDwpepro((DwPepro) dwci.getDwPepro().clone());

				if (dwci.getPpCp() != null && dwci.getPpCp().getDthrInicioreal() != null) {
					dto.setDtInicioProducao(
							DataHoraRN.dateToString(dwci.getPpCp().getDthrInicioreal(), "dd/MM/yyyy HH:mm:ss"));
				} else {
					dto.setDtInicioProducao("DESCONHECIDO");
				}

				dto.setCicloMedio(segCicloMedio);
				dto.setUltimoCiclo(segUltCic);

				// , aqui devo pegar o qt ativo do rap se nao tiver pegar
				// folhaiac
				// Alessandre em 10-3-15 eh melhor criar os campos em
				// dw_consolpr com a qtavitas e total mas por enquanto focando
				// nos MAPs

				try {
					// aqui
					dto.setQtdAtiva(folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwconsolpr.getOmProduto()));
				} catch (SemPcsPorCicloAtivasException e1) {
					dto.setQtdAtiva(BigDecimal.ONE);
				}
				try {
					dto.setQtdTotal(folhaRN.getPcsPorCicloTodas(dwci.getDwFolha(), dwconsolpr.getOmProduto()));
				} catch (SemPcsPorCicloAtivasException e1) {
					dto.setQtdTotal(BigDecimal.ONE);
				}

				if (dto.getQtdAtiva() == null)
					dto.setQtdAtiva(BigDecimal.ONE);
				if (dto.getQtdTotal() == null)
					dto.setQtdTotal(BigDecimal.ONE);

				dto.setMaquina(idClone.getOmPt()); // dwconsolpr.getDwConsol().getDwConsolid().getOmPt().clone(false));
				dto.getMaquina().setDwFolha(idClone.getDwFolha());

				PpCp ppcpClone = idClone.getPpCp();
				// sardinha: necessário na ficha da máquina
				ppcpClone.setDwFolha(idClone.getDwFolha());

				dto.setOrdemproducao(ppcpClone); // dwconsolpr.getDwConsol().getDwConsolid().getPpCp().clone(false));

				BigDecimal prodrefproduto =
						dwconsolpr.getPcsAutoProducaorefugada() != null ? dwconsolpr.getPcsAutoProducaorefugada() : BigDecimal.ZERO;
				prodrefproduto = prodrefproduto
						.add(dwconsolpr.getPcsManuProducaorefugada() != null ? dwconsolpr.getPcsManuProducaorefugada() : BigDecimal.ZERO);

				BigDecimal prodbrutaproduto = dwconsolpr.getPcsProducaoBruta();

				dto.setPcsProducaoRefugada(prodrefproduto);
				dto.setPcsProducaobruta(prodbrutaproduto);
				dto.setPcsProducaoliquida(prodbrutaproduto.subtract(prodrefproduto));

				if (dwconsolpr.getPcsProducaoLiquida() != null)
					dto.setPcsProducaoliquida(dwconsolpr.getPcsProducaoLiquida());

				log.mostrarAvaliacaoCompleta();

				log.iniciaAvaliacao("produto2");

				BigDecimal qtPcsPorCicloProduto = dto.getQtdAtiva();
				BigDecimal qtPcsPorCicloProdutoTotais = dto.getQtdTotal();

				BigDecimal fatorContagem = BigDecimal.ONE;

				// Marcos Sardinha: VFWEB - Injet
				if (IdwFacade.IS_IDW_ATIVO) {
					try {
						fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwci.getDwFolha(), dwci.getOmPt());
					} catch (SemPacoteOuFatorException e1) {
						fatorContagem = BigDecimal.ONE;
					}
				} else {
					// dwci.getDwFolha().getIdFolha() == null
					fatorContagem = dwci.getDwFolha().getQtFatorcontagem();
				}

				BigDecimal metaInstantanea =
						FormulasInjet.calcularProducaoPrevista(
								dwconsol.getSegAutoTempoativo(),
								new BigDecimal(segCicloPadraoAux),
								qtPcsPorCicloProduto,
								fatorContagem,
								dwci.getOmPt().getIndOee());

				// Marcos Sardinha: VFWEB - Injet
				if (IdwFacade.IS_IDW_ATIVO == false) {
					if (ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais()) {
						metaInstantanea = FormulasInjet.calcularProducaoPrevista(
								dwconsol.getSegAutoTempoativo(),
								new BigDecimal(segCicloPadraoAux),
								qtPcsPorCicloProdutoTotais,
								fatorContagem,
								dwci.getOmPt().getIndOee());
					}
					metaInstantanea = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(metaInstantanea);
				}

				dto.setMetaInstantanea(metaInstantanea);
				dto.setEficiencia(FormulasInjet.calcularEficienciaRealizacao(prodbrutaproduto.subtract(prodrefproduto), metaInstantanea).doubleValue());

				BigDecimal saldoProduzir = prodbrutaproduto.subtract(prodrefproduto);
				saldoProduzir = metaInstantanea.subtract(saldoProduzir);
				dto.setAproduzir(saldoProduzir);
				dto.setCicloPadrao(segCicloPadraoAux);

				dto.setDtRevisaoFolha(dwci.getDwFolha().getDtRevisao());

				listaprodutos.add(dto);

				// perdas por produto
				double qtcicloprod = 0d;
				double segcicloprod = 0d;
				double segcicloimprod = 0d;
				double qtperdapar = 0d;
				double tempodisponivel = 0d;
				double tempoparadaCP = 0d;
				double tempoparadaSP = 0d;
				double tempoparadaCpVarRitmo = 0d;
				double tempoparadaSpVarRitmo = 0d;

				qtcicloprod = 0d;
				segcicloprod = 0d;
				segcicloimprod = 0d;
				qtperdapar = 0d;
				tempodisponivel = 0d;
				tempoparadaCP = 0d;
				tempoparadaSP = 0d;

				qtcicloprod += dwconsol.getQtAutoCicloprodutivo() != null
						? dwconsol.getQtAutoCicloprodutivo().doubleValue() : 0d;
				qtcicloprod += dwconsol.getQtManuCicloprodutivo() != null
						? dwconsol.getQtManuCicloprodutivo().doubleValue() : 0d;

				segcicloprod += dwconsol.getSegAutoCicloprodutivo() != null
						? dwconsol.getSegAutoCicloprodutivo().doubleValue() : 0d;
				segcicloprod += dwconsol.getSegManuCicloprodutivo() != null
						? dwconsol.getSegManuCicloprodutivo().doubleValue() : 0d;

				segcicloimprod += dwconsol.getSegAutoCicloimprodutivo() != null
						? dwconsol.getSegAutoCicloimprodutivo().doubleValue() : 0d;
				segcicloimprod += dwconsol.getSegManuCicloimprodutivo() != null
						? dwconsol.getSegManuCicloimprodutivo().doubleValue() : 0d;

				tempoparadaCP += dwconsol.getSegAutoTempoparadaCp() != null
						? dwconsol.getSegAutoTempoparadaCp().doubleValue() : 0d;
				tempoparadaCP += dwconsol.getSegManuTempoparadaCp() != null
						? dwconsol.getSegManuTempoparadaCp().doubleValue() : 0d;

				tempoparadaSP += dwconsol.getSegAutoTempoparadaSp() != null
						? dwconsol.getSegAutoTempoparadaSp().doubleValue() : 0d;
				tempoparadaSP += dwconsol.getSegManuTempoparadaSp() != null
						? dwconsol.getSegManuTempoparadaSp().doubleValue() : 0d;

				tempoparadaCpVarRitmo += ObjectUtils
						.defaultIfNull(dwconsol.getSegAutoTempoparadaCpVr(), BigDecimal.ZERO).doubleValue();
				tempoparadaCpVarRitmo += ObjectUtils
						.defaultIfNull(dwconsol.getSegManuTempoparadaCpVr(), BigDecimal.ZERO).doubleValue();

				tempoparadaSpVarRitmo += ObjectUtils
						.defaultIfNull(dwconsol.getSegAutoTempoparadaSpVr(), BigDecimal.ZERO).doubleValue();
				tempoparadaSpVarRitmo += ObjectUtils
						.defaultIfNull(dwconsol.getSegManuTempoparadaSpVr(), BigDecimal.ZERO).doubleValue();

				tempodisponivel += FormulasInjet.calcularTempoAtivo(new BigDecimal(segcicloprod),
						new BigDecimal(tempoparadaCP), new BigDecimal(segcicloimprod),
						new BigDecimal(tempoparadaCpVarRitmo), new BigDecimal(tempoparadaSpVarRitmo)).doubleValue();

				BigDecimal ciclomedio = FormulasInjet.calcularCicloMedio(new BigDecimal(segTempoCiclosProdutivos),
						new BigDecimal(qtCicloProdutivos));

				PerdasDTO perdasDTO = new PerdasDTO();
				perdasDTO.setProduto(dto.getProduto());
				perdasDTO.setMaquina(idClone.getOmPt()); // dwconsolpr.getDwConsol().getDwConsolid().getOmPt().clone(false));
				perdasDTO.setOrdemproducao(idClone.getPpCp()); // dwconsolpr.getDwConsol().getDwConsolid().getPpCp().clone(false));

				try {
					qtperdapar = getPerdasParada(segCicloPadraoAux.doubleValue(),
							qtPcsPorCicloProduto.doubleValue(), new BigDecimal(tempoparadaCP));

					if (IdwFacade.IS_IDW_ATIVO == false) {
						//qtperdapar = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(qtperdapar)).doubleValue();
						qtperdapar = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(qtperdapar).setScale(0, RoundingMode.FLOOR)).doubleValue();
					}
					perdasDTO.setPerdasparada(qtperdapar);
				} catch (Exception e) {
					perdasDTO.setPerdasparada(0d);
				}

				log.mostrarAvaliacaoCompleta();

				log.iniciaAvaliacao("produto3");

				perdasDTO.setIndiceparadas(FormulasInjet
						.calcularIndiceParada(new BigDecimal(tempoparadaCP), BigDecimal.valueOf(tempodisponivel))
						.doubleValue());

				perdasDTO.setIndicerefugos(FormulasInjet
						.calcularIndiceRefugo(dwconsolpr.getPcsProducaoRefugada(), dwconsolpr.getPcsProducaoBruta()).doubleValue());
				perdasDTO.setPerdasrefugos(dwconsolpr.getPcsProducaoRefugada().doubleValue());
				try {
					perdasDTO.setEficienciaciclo(FormulasInjet
							.calcularEficienciaCiclo(new BigDecimal(segCicloPadraoAux), ciclomedio).doubleValue());
				} catch (Exception e) {
					perdasDTO.setEficienciaciclo(0d);
				}

				BigDecimal segRitmo = FormulasInjet.calcularRitmo(new BigDecimal(segcicloprod),
						new BigDecimal(qtcicloprod), new BigDecimal(segCicloPadraoAux),
						new BigDecimal(tempoparadaCpVarRitmo), new BigDecimal(tempoparadaSpVarRitmo));

				try {
					perdasDTO.setPerdasineficienciaciclo(FormulasInjet
							.calcularPcsPerdaciclo(segRitmo, new BigDecimal(segCicloPadraoAux), qtPcsPorCicloProduto)
							.doubleValue());
					
					if (IdwFacade.IS_IDW_ATIVO == false) {
						perdasDTO.setPerdasineficienciaciclo(FormulasInjet
								.calcularPcsPerdaciclo(segRitmo, new BigDecimal(segCicloPadraoAux), qtPcsPorCicloProduto).setScale(0, RoundingMode.FLOOR)
								.doubleValue());						
					}
				} catch (Exception e) {
					perdasDTO.setPerdasineficienciaciclo(0d);
				}

				BigDecimal perdaPorCiclo = qtPcsPorCicloProdutoTotais.subtract(qtPcsPorCicloProduto);
				Double perdaPCI = qtcicloprod * perdaPorCiclo.doubleValue();

				// Marcos Sardinha: VFWEB - Injet
				if (IdwFacade.IS_IDW_ATIVO == false) {
					BigDecimal qtdCiclosPrevistos = AritmeticaUtil.dividir(dwconsol.getSegAutoTempoativo(), dwconsol.getSegAutoCiclopadrao()); 
					perdaPCI = AritmeticaUtil.multiplicar(qtdCiclosPrevistos, perdaPorCiclo).doubleValue();					
					
					perdaPorCiclo = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(perdaPorCiclo);
					perdaPCI = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(new BigDecimal(perdaPCI)).doubleValue();
					perdasDTO.setPerdasineficienciaciclo(ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(new BigDecimal(perdasDTO.getPerdasineficienciaciclo())).doubleValue());
				}

				try {
					perdasDTO.setPerdascavativas(perdaPCI);
					perdasDTO.setIndicecavativas(FormulasInjet
							.calcularIndicePcsPorCicloAtivas(qtPcsPorCicloProdutoTotais, qtPcsPorCicloProduto)
							.doubleValue());
				} catch (Exception e) {
					e.printStackTrace();
					perdasDTO.setPerdascavativas(0d);
					perdasDTO.setIndicecavativas(0d);
				}

				try {
					perdasDTO.setTotalperdas(
							FormulasInjet.calcularTotalPerdas(perdasDTO.getPerdasineficienciaciclo(),
									perdasDTO.getPerdasparada(), perdasDTO.getPerdasrefugos(),
									perdasDTO.getPerdascavativas()).doubleValue());
				} catch (Exception e) {
					perdasDTO.setTotalperdas(0d);
				}

				listaperdas.add(perdasDTO);

				// resumo por produto
				BigDecimal tempoRefugadaProdutoAuto = FormulasInjet.calcularTempoRefugo(
						dwconsolpr.getPcsAutoProducaorefugada() != null ? dwconsolpr.getPcsAutoProducaorefugada() : BigDecimal.ZERO,
						new BigDecimal(segCicloMedio), dto.getQtdAtiva());
				BigDecimal tempoRefugadaProdutoManu = FormulasInjet.calcularTempoRefugo(
						dwconsolpr.getPcsManuProducaorefugada() != null ? dwconsolpr.getPcsManuProducaorefugada() : BigDecimal.ZERO,
						new BigDecimal(segCicloMedio), dto.getQtdAtiva());

				Double tempoBoaProduto = FormulasInjet
						.calcularTempoBoas(dwconsol.getSegAutoCicloprodutivo(), tempoRefugadaProdutoAuto,
								dwconsol.getSegAutoTempoparadaCpVr(), dwconsol.getSegAutoTempoparadaSpVr())
						.doubleValue()
						+ FormulasInjet
								.calcularTempoBoas(dwconsol.getSegManuCicloprodutivo(), tempoRefugadaProdutoManu,
										dwconsol.getSegManuTempoparadaCpVr(), dwconsol.getSegManuTempoparadaSpVr())
								.doubleValue();

				Double tempoPerdaCav = FormulasInjet
						.calcularCavidadesInativaSeg(dto.getQtdTotal(), dto.getQtdAtiva(), new BigDecimal(segcicloprod))
						.doubleValue();
				Double tempoProdutivasProduto = FormulasInjet.calcularTempoprodutivas(new BigDecimal(tempoBoaProduto),
						new BigDecimal(tempoPerdaCav), new BigDecimal(tempoRitmoAutoItem + tempoRitmoManuItem))
						.doubleValue();

				ProdutoResumoBIDTO produtoResumo = new ProdutoResumoBIDTO();
				produtoResumo.setIdProduto(perdasDTO.getProduto().getIdProduto());
				produtoResumo.setCdProduto(perdasDTO.getProduto().getCdProduto());
				produtoResumo.setDsProduto(perdasDTO.getProduto().getDsProduto());

				// recuperar qtde de itens do conjunto
				// Esse trecho gera um consumo alto no tempo de processamento
				Double qtdUsada = 1d;
				try {
					boolean isExiste = false;
					Map<Long, Double> valor = null;
					if (estururaProduto.containsKey(this.filtro.getIdProdutoPai())) {
						valor = estururaProduto.get(this.filtro.getIdProdutoPai());
						if (valor.containsKey(produtoResumo.getIdProduto())) {
							qtdUsada = valor.get(produtoResumo.getIdProduto());
							isExiste = true;
						}
					}
					if (isExiste == false) {
						query.defineParametro("pai", this.filtro.getIdProdutoPai());
						query.defineParametro("filho", produtoResumo.getIdProduto());
						query.setMaxResults(1);
						List<Object> lista = query.list();

						for (Object reg : lista) {
							Object[] registro = (Object[]) reg;
							qtdUsada = (Double) registro[0];
							break;
						}
						if (valor == null) {
							valor = new HashMap<Long, Double>();
							estururaProduto.put(this.filtro.getIdProdutoPai(), valor);
						}

						valor.put(produtoResumo.getIdProduto(), qtdUsada);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				produtoResumo.setQtdPorConjunto(qtdUsada);

				produtoResumo.setCicloPadrao(segCicloPadraoAux);
				produtoResumo.setCicloMedio(segCicloMedio);
				produtoResumo.setQtPcsCicloTotal(dto.getQtdTotal().doubleValue());
				produtoResumo.setQtPcsCicloAtiva(dto.getQtdAtiva().doubleValue());

				produtoResumo.setSegCiclosProdutivos((dwconsol.getSegAutoCicloprodutivo() != null
						? dwconsol.getSegAutoCicloprodutivo().doubleValue() : 0d)
						+ (dwconsol.getSegManuCicloprodutivo() != null
								? dwconsol.getSegManuCicloprodutivo().doubleValue() : 0d));

				produtoResumo.setQtdCiclosProdutivos((dwconsol.getQtAutoCicloprodutivo() != null
						? dwconsol.getQtAutoCicloprodutivo().doubleValue() : 0d)
						+ (dwconsol.getQtManuCicloprodutivo() != null ? dwconsol.getQtManuCicloprodutivo().doubleValue()
								: 0d));

				produtoResumo.setCicloPadraoSUM(produtoResumo.getCicloPadrao());
				produtoResumo.setCicloPadraoCOUNT(1d);
				produtoResumo.setQtPcsCicloTotalSUM(produtoResumo.getQtPcsCicloTotal());
				produtoResumo.setQtPcsCicloAtivaSUM(produtoResumo.getQtPcsCicloAtiva());

				produtoResumo.setQtBruta(dto.getPcsProducaobruta().doubleValue());
				produtoResumo.setQtRefugada(prodrefproduto.doubleValue());
				produtoResumo.setQtLiquida(produtoResumo.getQtBruta() - produtoResumo.getQtRefugada());
				produtoResumo.setQtPrevista(metaInstantanea.doubleValue());
				produtoResumo.setQtPerdas(perdasDTO.getTotalperdas());

				produtoResumo.setSegTempoAtivo(tempodisponivel);
				// Marcos Sardinha: 2017-02-03 - tempos devem vir de DwCsonsol
				// produtoResumo.setSegTempoParadasComPeso(tempoparadacp);
				// produtoResumo.setSegTempoParadaSemPeso(tempoparadasp);
				// + (dwconsol.getSegManuCicloprodutivo() != null ?
				// dwconsol.getSegManuCicloprodutivo().doubleValue() : 0d));

				// Marcos Sardinha: 25017-07-19 >> linhas abaixo comentadas... tempos devem vir das variaveis que acumulas paradas + paradas
				// abertas

				/*
				 * produtoResumo.setSegTempoParadasComPeso((dwconsol.getSegAutoTempoparadaCp() != null ?
				 * dwconsol.getSegAutoTempoparadaCp().doubleValue() : 0d) + (dwconsol.getSegManuTempoparadaCp() != null ?
				 * dwconsol.getSegManuTempoparadaCp().doubleValue() : 0d));
				 * produtoResumo.setSegTempoParadaSemPeso((dwconsol.getSegAutoTempoparadaSp() != null ?
				 * dwconsol.getSegAutoTempoparadaSp().doubleValue() : 0d) + (dwconsol.getSegManuTempoparadaSp() != null ?
				 * dwconsol.getSegManuTempoparadaSp().doubleValue() : 0d));
				 */

				produtoResumo.setSegTempoParadasComPeso(tempoparadaCP);
				produtoResumo.setSegTempoParadaSemPeso(tempoparadaSP);
				produtoResumo.setSegTempoProdutivas(tempoProdutivasProduto);

				produtoResumo.setEfiRea(0d);
				produtoResumo.setEfiCic(0d);
				produtoResumo.setIndRef(0d);
				produtoResumo.setIndPar(0d);
				produtoResumo.setIndPer(0d);
				produtoResumo.setIndPCI(0d);
				produtoResumo.setOee(0d);

				log.mostrarAvaliacaoCompleta();

				log.iniciaAvaliacao("produto4");

				if (listaProdutosBI.containsKey(produtoResumo.getCdProduto())) {
					ProdutoResumoBIDTO produto = listaProdutosBI.get(produtoResumo.getCdProduto());
					// acumula
					produto.setQtBruta(produto.getQtBruta() + produtoResumo.getQtBruta());
					produto.setQtLiquida(produto.getQtLiquida() + produtoResumo.getQtLiquida());
					produto.setQtRefugada(produto.getQtRefugada() + produtoResumo.getQtRefugada());
					produto.setQtPerdas(produto.getQtPerdas() + produtoResumo.getQtPerdas());
					produto.setQtPrevista(produto.getQtPrevista() + produtoResumo.getQtPrevista());

					produto.setSegTempoAtivo(produto.getSegTempoAtivo() + produtoResumo.getSegTempoAtivo());
					produto.setSegTempoParadasComPeso(
							produto.getSegTempoParadasComPeso() + produtoResumo.getSegTempoParadasComPeso());
					produto.setSegTempoParadaSemPeso(
							produto.getSegTempoParadaSemPeso() + produtoResumo.getSegTempoParadaSemPeso());
					produto.setSegTempoProdutivas(
							produto.getSegTempoProdutivas() + produtoResumo.getSegTempoProdutivas());

					// ciclo médio e cavidades ativas: acumular???
					produto.setSegCiclosProdutivos(
							produto.getSegCiclosProdutivos() + produtoResumo.getSegCiclosProdutivos());
					produto.setQtdCiclosProdutivos(
							produto.getQtdCiclosProdutivos() + produtoResumo.getQtdCiclosProdutivos());
					produto.setCicloMedio(
							FormulasInjet.calcularCicloMedio(new BigDecimal(produto.getSegCiclosProdutivos()),
									new BigDecimal(produto.getQtdCiclosProdutivos())).doubleValue());
					produto.setCicloPadraoSUM(produto.getCicloPadraoSUM() + produtoResumo.getCicloPadrao());
					produto.setCicloPadraoCOUNT(produto.getCicloPadraoCOUNT() + 1d);

					produto.setQtPcsCicloAtivaSUM(produto.getQtPcsCicloAtiva() + produtoResumo.getQtPcsCicloAtiva());
					produto.setQtPcsCicloTotalSUM(produto.getQtPcsCicloTotal() + produtoResumo.getQtPcsCicloTotal());
				} else {
					listaProdutosBI.put(produtoResumo.getCdProduto(), produtoResumo);
				}

				/*
				 * lista consolidada por pt e pt/rap - necessárias para BI filtrando por produto - janela similar ao Injet
				 */
				Double qtProdPrevItem = 0d;
				Double segTempoParCPItem = 0d;
				Double segTempoParSPItem = 0d;

				// inicializa
				PtRapResumoDTO resumoPT = new PtRapResumoDTO();
				PtRapResumoDTO resumoPTRap = new PtRapResumoDTO();

				// identifica PT
				resumoPT.setCdPt(dwci.getOmPt().getCdPt());
				resumoPT.setDsPt(dwci.getOmPt().getDsPt());
				resumoPT.setCicloPadrao(segCicloPadraoAux);
				resumoPT.setQtPcsCicloAtiva(dto.getQtdAtiva().doubleValue());
				resumoPT.setQtPcsCicloTotal(dto.getQtdTotal().doubleValue());
				resumoPT.setCicloPadraoSUM(resumoPT.getCicloPadrao());
				resumoPT.setQtCicloPadraoSUM(1);
				resumoPT.setQtPcsCicloAtivaSUM(resumoPT.getQtPcsCicloAtiva());
				resumoPT.setQtPcsCicloTotalSUM(resumoPT.getQtPcsCicloTotal());
				resumoPT.setSegTempoAtivo(tempoAtivoAutoItem + tempoAtivoManuItem);

				segTempoParCPItem = (dwconsol.getSegAutoTempoparadaCp() == null ? BigDecimal.ZERO
						: dwconsol.getSegAutoTempoparadaCp()).doubleValue()
						+ (dwconsol.getSegManuTempoparadaCp() == null ? BigDecimal.ZERO
								: dwconsol.getSegManuTempoparadaCp()).doubleValue();
				segTempoParSPItem = (dwconsol.getSegAutoTempoparadaSp() == null ? BigDecimal.ZERO
						: dwconsol.getSegAutoTempoparadaSp()).doubleValue()
						+ (dwconsol.getSegManuTempoparadaSp() == null ? BigDecimal.ZERO
								: dwconsol.getSegManuTempoparadaSp()).doubleValue();

				qtProdPrevItem = FormulasInjet.calcularProducaoPrevista(
						new BigDecimal(resumoPT.getSegTempoAtivo()),
						new BigDecimal(resumoPT.getCicloPadrao()),
						new BigDecimal(resumoPT.getQtPcsCicloAtiva()),
						fatorContagem,
						idClone.getOmPt().getIndOee()).doubleValue();

				// lista consolidada por pt

				resumoPT.setSegTempoParadasComPeso(segTempoParCPItem);
				resumoPT.setSegTempoParadasSemPeso(segTempoParSPItem);
				resumoPT.setSegTempoParadas(
						resumoPT.getSegTempoParadasComPeso() + resumoPT.getSegTempoParadasSemPeso());
				resumoPT.setSegTempoProdutivas(produtoResumo.getSegTempoProdutivas());

				resumoPT.setSegCiclosProdutivos(produtoResumo.getSegCiclosProdutivos());
				resumoPT.setQtdCiclosProdutivos(qtCicloProdutivosPosto.doubleValue());

				resumoPT.setQtPerdasPar(perdasDTO.getPerdasparada());
				resumoPT.setQtRefugada(perdasDTO.getPerdasrefugos());
				resumoPT.setQtPerdasCic(perdasDTO.getPerdasineficienciaciclo());
				resumoPT.setQtPerdasPCI(perdasDTO.getPerdascavativas());
				resumoPT.setQtPerdas(perdasDTO.getTotalperdas());
				resumoPT.setQtBruta(dto.getPcsProducaobruta().doubleValue());
				resumoPT.setQtLiquida(dto.getPcsProducaoliquida().doubleValue());
				resumoPT.setQtPrevista(qtProdPrevItem);

				// Calcular o ciclo medio global de todos os dwconsolid
				IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, dwci.getOmPt(),
						new BigDecimal(resumoPT.getSegCiclosProdutivos()),
						new BigDecimal(resumoPT.getQtdCiclosProdutivos()),
						new BigDecimal(resumoPT.getSegTempoParadasSemPeso()));

				resumoPT.setCicloMedio(cmRN.calcularCicloMedio().doubleValue());

				if (listaIndicadoresPt.containsKey(resumoPT.getCdPt())) {
					PtRapResumoDTO itemLista = listaIndicadoresPt.get(resumoPT.getCdPt());
					itemLista.setSegTempoAtivo(itemLista.getSegTempoAtivo() + resumoPT.getSegTempoAtivo());
					itemLista.setSegTempoParadasComPeso(
							itemLista.getSegTempoParadasComPeso() + resumoPT.getSegTempoParadasComPeso());
					itemLista.setSegTempoParadasSemPeso(
							itemLista.getSegTempoParadasSemPeso() + resumoPT.getSegTempoParadasSemPeso());
					itemLista.setSegTempoParadas(
							itemLista.getSegTempoParadasComPeso() + itemLista.getSegTempoParadasSemPeso());
					itemLista.setSegCiclosProdutivos(
							itemLista.getSegCiclosProdutivos() + resumoPT.getSegCiclosProdutivos());

					itemLista.setQtPerdasPar(itemLista.getQtPerdasPar() + resumoPT.getQtPerdasPar());
					itemLista.setQtRefugada(itemLista.getQtRefugada() + resumoPT.getQtRefugada());
					itemLista.setQtPerdasCic(itemLista.getQtPerdasCic() + resumoPT.getQtPerdasCic());
					itemLista.setQtPerdasPCI(itemLista.getQtPerdasPCI() + resumoPT.getQtPerdasPCI());
					itemLista.setQtPerdas(itemLista.getQtPerdasPar() + itemLista.getQtRefugada()
							+ itemLista.getQtPerdasCic() + itemLista.getQtPerdasPCI());

					itemLista.setQtBruta(itemLista.getQtBruta() + resumoPT.getQtBruta());
					itemLista.setQtLiquida(itemLista.getQtLiquida() + resumoPT.getQtLiquida());
					itemLista.setQtPrevista(itemLista.getQtPrevista() + resumoPT.getQtPrevista());

					// ciclo médio e cavidades ativas: acumular???
					itemLista.setSegCiclosProdutivos(
							itemLista.getSegCiclosProdutivos() + resumoPT.getSegCiclosProdutivos());
					itemLista.setQtdCiclosProdutivos(
							itemLista.getQtdCiclosProdutivos() + resumoPT.getQtdCiclosProdutivos());

					if (resumoPT.getCicloMedio() > 0d) {
						IndicadorCicloMedioRN cmRN2 = new IndicadorCicloMedioRN(omcfg, dwci.getOmPt(),
								new BigDecimal(itemLista.getSegCiclosProdutivos()),
								new BigDecimal(itemLista.getQtdCiclosProdutivos()),
								new BigDecimal(itemLista.getSegTempoParadasSemPeso()));

						itemLista.setCicloMedio(cmRN2.calcularCicloMedio().doubleValue());
					}

					itemLista.setCicloPadraoSUM(itemLista.getCicloPadraoSUM() + resumoPT.getCicloPadrao());
					itemLista.setQtCicloPadraoSUM(itemLista.getQtCicloPadraoSUM() + 1);
					itemLista.setQtPcsCicloAtivaSUM(itemLista.getQtPcsCicloAtivaSUM() + resumoPT.getQtPcsCicloAtiva());
					itemLista.setQtPcsCicloTotalSUM(itemLista.getQtPcsCicloTotalSUM() + resumoPT.getQtPcsCicloTotal());

				} else {
					listaIndicadoresPt.put(resumoPT.getCdPt(), resumoPT);
				}

				// inicializa RAP
				resumoPTRap.setCdPt(dwci.getOmPt().getCdPt());
				resumoPTRap.setDsPt(dwci.getOmPt().getDsPt());
				resumoPTRap.setCdFolha(dwci.getDwFolha().getCdFolha() + " (" + dwci.getDwFolha().getIdFolha() + ")");
				DwFolharap rap = dwci.getDwFolha().obtemPrimeiroRap();
				if (rap != null)
					resumoPTRap.setCdRap(rap.getDwRap().getCdRap());
				else
					resumoPTRap.setCdRap("---");

				resumoPTRap.setCicloPadrao(segCicloPadraoAux);
				resumoPTRap.setQtPcsCicloAtiva(resumoPT.getQtPcsCicloAtiva());
				resumoPTRap.setQtPcsCicloTotal(resumoPT.getQtPcsCicloTotal());

				resumoPTRap.setCicloMedio(resumoPT.getCicloMedio());
				resumoPTRap.setCicloPadraoSUM(resumoPT.getCicloPadrao());
				resumoPTRap.setQtCicloPadraoSUM(1);
				resumoPTRap.setQtPcsCicloAtivaSUM(resumoPTRap.getQtPcsCicloAtiva());
				resumoPTRap.setQtPcsCicloTotalSUM(resumoPTRap.getQtPcsCicloTotal());

				// lista consolidada por pt/rap
				resumoPTRap.setSegTempoAtivo(resumoPT.getSegTempoAtivo());
				resumoPTRap.setSegTempoParadasComPeso(resumoPT.getSegTempoParadasComPeso());
				resumoPTRap.setSegTempoParadasSemPeso(resumoPT.getSegTempoParadasSemPeso());
				resumoPTRap.setSegTempoParadas(
						resumoPTRap.getSegTempoParadasComPeso() + resumoPTRap.getSegTempoParadasSemPeso());
				resumoPTRap.setSegTempoProdutivas(resumoPT.getSegTempoProdutivas());

				resumoPTRap.setSegCiclosProdutivos(resumoPT.getSegCiclosProdutivos());
				resumoPTRap.setQtdCiclosProdutivos(resumoPT.getQtdCiclosProdutivos());

				resumoPTRap.setQtPerdasPar(resumoPT.getQtPerdasPar());
				resumoPTRap.setQtRefugada(resumoPT.getQtRefugada());
				resumoPTRap.setQtPerdasCic(resumoPT.getQtPerdasCic());
				resumoPTRap.setQtPerdasPCI(resumoPT.getQtPerdasPCI());
				resumoPTRap.setQtPerdas(resumoPT.getQtPerdas());
				resumoPTRap.setQtBruta(resumoPT.getQtBruta());
				resumoPTRap.setQtLiquida(resumoPT.getQtLiquida());
				resumoPTRap.setQtPrevista(resumoPT.getQtPrevista());

				String ptrap = resumoPTRap.getCdPt() + "-" + resumoPTRap.getCdRap();
				if (listaIndicadoresPtRap.containsKey(ptrap)) {
					PtRapResumoDTO itemLista = listaIndicadoresPtRap.get(ptrap);

					itemLista.setSegTempoAtivo(itemLista.getSegTempoAtivo() + resumoPTRap.getSegTempoAtivo());
					itemLista.setSegTempoParadasComPeso(
							itemLista.getSegTempoParadasComPeso() + resumoPTRap.getSegTempoParadasComPeso());
					itemLista.setSegTempoParadasSemPeso(
							itemLista.getSegTempoParadasSemPeso() + resumoPTRap.getSegTempoParadasSemPeso());
					itemLista.setSegTempoParadas(
							itemLista.getSegTempoParadasComPeso() + itemLista.getSegTempoParadasSemPeso());
					itemLista.setSegCiclosProdutivos(
							itemLista.getSegCiclosProdutivos() + resumoPTRap.getSegCiclosProdutivos());

					// calculo das perdas
					itemLista.setQtPerdasPar(itemLista.getQtPerdasPar() + resumoPTRap.getQtPerdasPar());
					itemLista.setQtRefugada(itemLista.getQtRefugada() + resumoPTRap.getQtRefugada());
					itemLista.setQtPerdasCic(itemLista.getQtPerdasCic() + resumoPTRap.getQtPerdasCic());
					itemLista.setQtPerdasPCI(itemLista.getQtPerdasPCI() + resumoPTRap.getQtPerdasPCI());
					itemLista.setQtPerdas(itemLista.getQtPerdasPar() + itemLista.getQtRefugada()
							+ itemLista.getQtPerdasCic() + itemLista.getQtPerdasPCI());

					itemLista.setQtBruta(itemLista.getQtBruta() + resumoPTRap.getQtBruta());
					itemLista.setQtLiquida(itemLista.getQtLiquida() + resumoPTRap.getQtLiquida());
					itemLista.setQtPrevista(itemLista.getQtPrevista() + resumoPTRap.getQtPrevista());

					// ciclo m�dio e cavidades ativas: acumular???
					itemLista.setSegCiclosProdutivos(
							itemLista.getSegCiclosProdutivos() + resumoPTRap.getSegCiclosProdutivos());
					itemLista.setQtdCiclosProdutivos(
							itemLista.getQtdCiclosProdutivos() + resumoPTRap.getQtdCiclosProdutivos());

					if (resumoPT.getCicloMedio() > 0d) {
						IndicadorCicloMedioRN cmRN2 = new IndicadorCicloMedioRN(omcfg, dwci.getOmPt(),
								new BigDecimal(itemLista.getSegCiclosProdutivos()),
								new BigDecimal(itemLista.getQtdCiclosProdutivos()),
								new BigDecimal(itemLista.getSegTempoParadasSemPeso()));

						itemLista.setCicloMedio(cmRN2.calcularCicloMedio().doubleValue());
					}

					itemLista.setCicloPadraoSUM(itemLista.getCicloPadraoSUM() + resumoPTRap.getCicloPadrao());
					itemLista.setQtCicloPadraoSUM(itemLista.getQtCicloPadraoSUM() + 1);
					itemLista.setQtPcsCicloAtivaSUM(
							itemLista.getQtPcsCicloAtivaSUM() + resumoPTRap.getQtPcsCicloAtiva());
					itemLista.setQtPcsCicloTotalSUM(
							itemLista.getQtPcsCicloTotalSUM() + resumoPTRap.getQtPcsCicloTotal());

				} else {
					listaIndicadoresPtRap.put(ptrap, resumoPTRap);
				}

				log.mostrarAvaliacaoCompleta();

			}

			// aqui tinha o trecho de recalculo

		}
	}

	private void recuperarListaOperadores(DwConsol dwconsol, DwConsolid idClone) {
		// lista de operadores
		if (dwconsol.getDwConsolmos() != null) {
			for (DwConsolmo dwConsolmo : dwconsol.getDwConsolmos()) {
				for (DwConsolmooco dwConsolmooco : dwConsolmo.getDwConsolmoocos()) {
					OperadorDTO operadorDTO = new OperadorDTO();

					operadorDTO.setMaquina(idClone.getOmPt());
					operadorDTO.setOrdemproducao(idClone.getPpCp());
					operadorDTO.setDthrFlogin(dwConsolmooco.getDwConsolmolog().getDthrFlogin());
					operadorDTO.setDthrIlogin(dwConsolmooco.getDwConsolmolog().getDthrIlogin());
					operadorDTO.setMsDthrflogin(dwConsolmooco.getDwConsolmolog().getMsDthrflogin());
					operadorDTO.setMsDthrilogin(dwConsolmooco.getDwConsolmolog().getMsDthrilogin());
					operadorDTO.setOmUsr(dwConsolmooco.getDwConsolmolog().getOmUsr().clone(false));
					listaoperadores.add(operadorDTO);
				}
			}
		}
	}

	private void recuperarListaAlertas(DwConsol dwconsol, Date iperiodo, Date fperiodo, DwConsolid idClone) {
		DwConsolid dwci = dwconsol.getDwConsolid();
		OmPt omptClonado = idClone.getOmPt();
		PpCp ppcpClonado = null;
		if (dwci.getPpCp() != null)
			ppcpClonado = idClone.getPpCp();

		// lista de alertas - Obter os alertas fechados do turno
		if (dwconsol.getDwConsolals() != null) {

			for (DwConsolal dwConsolal : dwconsol.getDwConsolals()) {
				for (DwConsolaloco dwConsolaloco : dwConsolal.getDwConsolalocos()) {
					if (dwConsolaloco.getDthrFalerta() == null)
						continue;

					AlertaDTO alertaDTO = new AlertaDTO();
					alertaDTO.setDwTAlerta(dwConsolal.getDwTAlerta().clone(false));
					if (alertaDTO.getDwTAlerta().getIsAutomatico() == null)
						alertaDTO.getDwTAlerta().setIsAutomatico(false);

					alertaDTO.setMaquina(omptClonado); // dwConsolaloco.getDwConsolal().getDwConsol().getDwConsolid().getOmPt().clone(false));

					alertaDTO.setOrdemproducao(ppcpClonado); // dwConsolaloco.getDwConsolal().getDwConsol().getDwConsolid().getPpCp().clone(false));

					alertaDTO.setDthrFalerta(dwConsolaloco.getDthrFalerta());
					alertaDTO.setDthrIalerta(dwConsolaloco.getDthrIalerta());
					alertaDTO.setMsDthrfalerta(dwConsolaloco.getMsDthrfalerta());
					alertaDTO.setMsDthrialerta(dwConsolaloco.getMsDthrialerta());
					alertaDTO.setDthrFinal(
							DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwConsolaloco.getDwConsolallog().getDthrFalerta()));
					alertaDTO.setObservacao(dwConsolaloco.getDwConsolallog().getObs());
					alertaDTO.setDwConsolallog(dwConsolaloco.getDwConsolallog().clone(false));
					if (dwConsolaloco.getDwConsolallog().getOmUsr() != null) {
						alertaDTO.setUsuario(dwConsolaloco.getDwConsolallog().getOmUsr().getDsNome());
					}
					listaalertas.add(alertaDTO);
				}
			}
		}
		
		
		// Obter os alertas ainda abertos para a maquina
		ConsolidaRN rn = new ConsolidaRN();
		rn.setDao(getDao());

		List<DwConsolallog> listaabertos = rn.getDwConsolalComAlertaAberto(dwci.getOmPt());

		for (DwConsolallog aberto : listaabertos) {
			// Verificar se existe intersecao entre os alertas abertas e o
			// periodo avaliado
			Date fim = aberto.getDthrFalerta();
			if (fim == null)
				fim = DataHoraRN.getDataHoraAtual();

			// Se for acumulado o if abaixo nao tem efeito
			if (dwci.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue()) == false && iperiodo != null
					&& fperiodo != null
					&& DataHoraRN.isIntersecao(iperiodo, fperiodo, aberto.getDthrIalerta(), fim) == false)
				continue;

			AlertaDTO alertaDTO = new AlertaDTO();
			alertaDTO.setDwTAlerta(aberto.getDwTAlerta().clone(false));
			if (alertaDTO.getDwTAlerta().getIsAutomatico() == null)
				alertaDTO.getDwTAlerta().setIsAutomatico(false);
			alertaDTO.setMaquina(omptClonado); // dwConsolaloco.getDwConsolal().getDwConsol().getDwConsolid().getOmPt().clone(false));
			alertaDTO.setOrdemproducao(ppcpClonado); // dwConsolaloco.getDwConsolal().getDwConsol().getDwConsolid().getPpCp().clone(false));
			alertaDTO.setDthrFalerta(aberto.getDthrFalerta());
			alertaDTO.setDthrIalerta(aberto.getDthrIalerta());
			alertaDTO.setMsDthrfalerta((byte) 0);
			alertaDTO.setMsDthrialerta((byte) 0);
			alertaDTO.setDwConsolallog(aberto.clone(false));

			boolean isExiste = false;
			for (AlertaDTO dto : listaalertas) {
				if (dto.getDwTAlerta().equals(alertaDTO.getDwTAlerta())
						&& DataHoraRN.equals(dto.getDthrIalerta(), alertaDTO.getDthrIalerta()))
					isExiste = true;
			}
			if (isExiste == false)
				listaalertas.add(alertaDTO);
		}
		return;
	}

	/*
	 * Metodo para calcular os indicadores por data
	 * 
	 */
	private void recuperarListaResumoDatas(DwConsol dwconsol) {
		/*
		 * Alessandre em 12-09-16 comentei o trecho abaixo pois alguns dwconsol nao estavam sendo incluidos na lista de consol para a data
		 * causando divergencia entre o indicador fora e da barra por data
		 * 
		 * 
		 * BigDecimal tempoCicloProdutivoDwConsol = dwconsol.getSegAutoCicloprodutivo();
		 * 
		 * Double tempoAtivoAutoItem = FormulasInjet.calcularTempoAtivo( tempoCicloProdutivoDwConsol, dwconsol.getSegAutoTempoparadaCp(),
		 * dwconsol.getSegAutoCicloimprodutivo(), dwconsol.getSegAutoTempoparadaCpVr(), dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();
		 * // Tempo manual Double tempoAtivoManuItem = FormulasInjet.calcularTempoAtivo( dwconsol.getSegManuCicloprodutivo(),
		 * dwconsol.getSegManuTempoparadaCp(), dwconsol.getSegManuCicloimprodutivo(), dwconsol.getSegManuTempoparadaCpVr(),
		 * dwconsol.getSegManuTempoparadaSpVr()).doubleValue();
		 * 
		 * Double tempoTrabalhadoAutoItem = FormulasInjet.calcularTempoTrabalhado(new BigDecimal(tempoAtivoAutoItem),
		 * dwconsol.getSegAutoTempoparadaCp()).doubleValue(); Double tempoTrabalhadoManuItem = FormulasInjet.calcularTempoTrabalhado(new
		 * BigDecimal(tempoAtivoManuItem), dwconsol.getSegManuTempoparadaCp()).doubleValue();
		 * 
		 * // Nao considerar o dwconsol se o tempo trabalhado for zerado if (tempoTrabalhadoAutoItem <= 0d && tempoTrabalhadoManuItem <= 0d)
		 * { return; }
		 */

		DwConsolid dwci = dwconsol.getDwConsolid();
		// resumo por data --- preparacao da colecao

		Date dtreferencia = dwci.getDtReferencia();

		if (filtro.getAnoInicial() != null) {
			// altera data para primeiro dia do mes/ano
			dtreferencia = DataHoraRN.setDiaNaData(dtreferencia, 1);
		}

		if (listaagrupadaDT.containsKey(dtreferencia) == true) {
			ListaDwConsolPorDataDTO dwconsolpordataDTO = listaagrupadaDT.get(dtreferencia);
			dwconsolpordataDTO.getListaDwConsol().add(dwconsol);
		} else {
			ListaDwConsolPorDataDTO dwconsolpordataDTO = new ListaDwConsolPorDataDTO();
			dwconsolpordataDTO.setDtReferencia(dtreferencia);
			dwconsolpordataDTO.setListaDwConsol(new ArrayList<DwConsol>());
			dwconsolpordataDTO.getListaDwConsol().add(dwconsol);
			listaagrupadaDT.put(dtreferencia, dwconsolpordataDTO);
		}
	}

	private void recuperarListaResumoTurnos(DwConsol dwconsol, DwConsolid idClone) {
		/*
		 * Alessandre> comentei em 11-8-13 para averiguar um xml infinito no ws for (DwConsol dwc : itemDwConsolid.getDwConsols()) {
		 * dwc.setDwConsolid(itemDwConsolid.clone(false)); }
		 */

		DwConsolidDTO itemDwConsolidDTO = new DwConsolidDTO();
		itemDwConsolidDTO.setDwConsolid(idClone);

		DetalheMonitorizacaoPTInjetDTO itemTurno;

		if (listaTurnos.containsKey(idClone.getDwTurno().getIdTurno()) == true) {
			itemTurno = listaTurnos.get(idClone.getDwTurno().getIdTurno());
		} else {
			itemTurno = new DetalheMonitorizacaoPTInjetDTO();
			itemTurno.setDwTurno(idClone.getDwTurno());
			listaTurnos.put(idClone.getDwTurno().getIdTurno(), itemTurno);
		}
		DwConsolidDTOs listaDwConsolidTurno = new DwConsolidDTOs();
		listaDwConsolidTurno.setListaDwConsolidDTO(new ArrayList<DwConsolidDTO>());
		if (itemTurno.getListaDwConsolidTurno() != null) {
			listaDwConsolidTurno.setListaDwConsolidDTO(itemTurno.getListaDwConsolidTurno().getListaDwConsolidDTO());
		}
		listaDwConsolidTurno.getListaDwConsolidDTO().add(itemDwConsolidDTO);
		itemTurno.setListaDwConsolidTurno(listaDwConsolidTurno);

	}

	private Double getTotalPerdas() {
		return FormulasInjet
				.calcularTotalPerdas(retorno.getPerdasCiclos(), retorno.getPerdasParadas(),
						retorno.getQtdRefugadas(), retorno.getPci())
				.doubleValue();
	}

	/*
	 * Pega informaÃ§Ã£o, do grÃ¡fico de tempos
	 */
	private List<GraficoTempoDTO> getValoresGraficoTempos() {
		GraficoTempoDTO graficoDTO = new GraficoTempoDTO();

		graficoDTO.setTempoacurisoladas(retorno.getTempoCavIsoladas());
		graficoDTO.setTempocicloimprodutivos(retorno.getTempoCiclosImprodutivos());
		graficoDTO.setTemponaodisponivel(retorno.getTempoNaoDisponivel());
		graficoDTO.setTempoparadas(retorno.getTempoParadas());
		// Alessandre: em 5-2-14 removi o ritmo do grafico de pizza do bi. A
		// ideia eh implementar depois a possibilidade do usuairo escolher se
		// aparece ou nao
		/*
		 * Alessandre em 02-06-17 comentei a linha abaixo e voltei a apresentar o tempoProdutivas pois na sony o grafico de pizza de
		 * produtividade estava mostarndo um produtivas diferente do grafico diagrama de produtividade. Como houve correcoes no ritmo essa
		 * alteracao de 2014 ficou obsoleta
		 */
		// graficoDTO.setTempoprodutivas(retorno.getTempoBoas()); // (retorno.getTempoProdutivas());
		// mudei para
		// boas pq
		// removi o
		// ritmo
		graficoDTO.setTempoprodutivas(retorno.getTempoProdutivas());

		graficoDTO.setTemporefugos(retorno.getTempoRefugos());
		if (retorno.getTempoRitmo() != null && retorno.getTempoRitmo() > 0d)
			graficoDTO.setTemporitmo(retorno.getTempoRitmo()); // removi o tempo
																// do ciclo
		else
			graficoDTO.setTemporitmo(0d); // removi o tempo do ciclo

		graficoDTO.setTempototal(retorno.getTempoTotais());

		List<GraficoTempoDTO> listaGrafico = new ArrayList<GraficoTempoDTO>();
		listaGrafico.add(graficoDTO);
		return listaGrafico;
	}

	private String getPeriodo() {
		if (filtro.getAnoInicial() != null) {
			return DataHoraRN.getNomeResumidoMes(filtro.getMesInicial()) + "/" + filtro.getAnoInicial() + " - "
					+ DataHoraRN.getNomeResumidoMes(filtro.getMesFinal()) + "/" + filtro.getAnoFinal();
		}

		if (filtro.getDtReferencia() != null) {
			return DataHoraRN.dateToString(filtro.getDtReferencia(), "dd/MM/yyyy");
		}

		if (filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null) {
			return DataHoraRN.dateToString(filtro.getDtReferenciaInicial(), "dd/MM/yyyy") + " - "
					+ DataHoraRN.dateToString(filtro.getDtReferenciaFinal(), "dd/MM/yyyy");
		}

		return "";
	}

	private String getMaquina(List<DwConsolid> listaDwconsolid) {
		try {
			if (filtro.getOmptParaPesquisa() != null) {
				OmPt ompt = null;
				PTRN rn = new PTRN(getDao());
				ompt = rn.pesquisarPtByCdPtStAtivo(filtro.getOmptParaPesquisa().getCdPt());
				return ompt.getCdPt() + " - " + ompt.getDsPt();
			}

			if (filtro.getOmGt() != null) {
				StringBuilder retorno = new StringBuilder();
				retorno.append(filtro.getOmGt().getCdGt());
				if (filtro.getOmGt().getDsGt() != null) {
					retorno.append(" - ");
					retorno.append(filtro.getOmGt().getDsGt());
				}
				return retorno.toString();
			}

			for (DwConsolid dwconsolid : listaDwconsolid) {
				if (dwconsolid.getOmPt() != null) {
					return dwconsolid.getOmPt().getCdPt() + " - " + dwconsolid.getOmPt().getDsPt();
				}

				if (dwconsolid.getOmGt() != null) {
					return dwconsolid.getOmGt().getCdGt() + " - " + dwconsolid.getOmGt().getDsGt();
				}
				break;
			}
			return "";
		} catch (Exception e) {
			return "";
		}

	}

	private String getDsPt(List<DwConsolid> listaDwconsolid) {
		try {
			if (filtro.getOmPt() != null) {
				return filtro.getOmPt().getDsPt();
			}

			if (filtro.getOmGt() != null) {
				return filtro.getOmGt().getDsGt();
			}

			for (DwConsolid dwconsolid : listaDwconsolid) {
				if (dwconsolid.getOmPt() != null) {
					return dwconsolid.getOmPt().getDsPt();
				}

				if (dwconsolid.getOmGt() != null) {
					return dwconsolid.getOmGt().getDsGt();
				}
				break;
			}
			return "";
		} catch (Exception e) {
			return "";
		}

	}

	/*
	 * retorna se hÃ¡ produtos ou nÃ£o
	 */

	private String getProduto() {
		if (filtro.getOmProduto() != null) {
			return filtro.getOmProduto().getCdProduto();
		} else {
			return "SEM FILTRO";
		}
	}

	private String getProdutoDescricao() {
		if (filtro.getOmProduto() != null && filtro.getOmProduto().getDsProduto() != null) {
			return filtro.getOmProduto().getDsProduto();
		} else {
			return "";
		}
	}

	private String getDtinicioOP(List<DwConsolid> listaDwconsolid) {
		List<DwConsolid> listaDwconsolidAux = new ArrayList<DwConsolid>();
		listaDwconsolidAux.addAll(listaDwconsolid);
		// colocando lista em ordem decrescente por id
		Collections.sort(listaDwconsolidAux, new Comparator<DwConsolid>() {
			@Override
			public int compare(final DwConsolid o1, final DwConsolid o2) {
				return Long.valueOf(o1.getIdConsolid()).compareTo(Long.valueOf(o2.getIdConsolid())) * -1;
			}
		});

		for (DwConsolid dwconsolid : listaDwconsolidAux) {
			PpCp ppcp = dwconsolid.getPpCp();
			if (ppcp != null && ppcp.getDthrInicioreal() != null) {
				return DataHoraRN.dateToStringYYYYMMDDHHMMSS(ppcp.getDthrInicioreal());
			}
		}
		return "DESCONHECIDA";
	}

	private String getOrdemProducao(List<DwConsolid> listaDwconsolid) {
		return consolidacaoPlanejamento.getUltimaOP(listaDwconsolid);
	}

	private String getIdentificacaoMolde(List<DwConsolid> listaDwconsolid) {
		Collections.sort(listaDwconsolid, new Comparator<DwConsolid>() {
			@Override
			public int compare(DwConsolid o1, DwConsolid o2) {
				Long id1 = o1.getIdConsolid();
				Long id2 = o2.getIdConsolid();
				return id1.compareTo(id2) * -1;
			}
		});
		for (DwConsolid dwconsolid : listaDwconsolid) {
			DwFolha dwfolha = dwconsolid.getDwFolha();

			if (dwfolha != null) {
				if (dwfolha.getDwFolharaps() != null) {
					for (DwFolharap dwfolharap : dwfolha.getDwFolharaps()) {
						if (dwfolharap.getDwRap() != null) {
							if (IdwFacade.IS_IDW_ATIVO) {
								return dwfolharap.getDwRap().getCdRap() + "/" + dwfolharap.getDwRap().getDsRap();
							} else {
								return dwfolharap.getDwRap().getCdRap();
							}
						}
					}
				}
			}
		}
		return "DESCONHECIDO";
	}

	private double getPerdasParada(double ciclopadrao, double cavativas, BigDecimal segautotempoparadaCP) {
		if (ciclopadrao == 0 || cavativas == 0) {
			return 0d;
		}
		double tempoparada = segautotempoparadaCP != null ? segautotempoparadaCP.doubleValue() : 0d;

		return (tempoparada / ciclopadrao) * cavativas;
	}

	public boolean isMaquinaDentroDaMetaER(IdwLogger log, OmPt ompt, OmCfg omCfg, Double eficienciaRealizacao) {

		/**
		 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e direta, onde ciclo padrao esta para 100 assim como ciclo
		 * medio esta para x
		 */

		// TODO verificar indice dentro do OmPt
		if (ompt.getOmIndpts() != null && ompt.getOmIndpts().isEmpty() == false) {

			for (OmIndpt indPt : ompt.getOmIndpts()) {

				// testa EficienciaRealizacao
				if (indPt.getIdIndpt() == 1) {

					if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaRealizacao) {
						return false;
					}

				}
			}
		} else if (ompt.getOmTppt().getOmIndtppts() != null && ompt.getOmTppt().getOmIndtppts().isEmpty() == false) {

			// TODO verificar indice dentro do OmTppt
			for (OmIndtppt indTppt : ompt.getOmTppt().getOmIndtppts()) {
				// testa realizacao
				if (indTppt.getIdIndtppt() == 1) {
					if (indTppt.getNumMeta() == null || indTppt.getNumMeta().doubleValue() > eficienciaRealizacao) {
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
			}
		}
		return true;
	}

	public boolean isMaquinaDentroDaMetaEC(IdwLogger log, OmPt ompt, OmCfg omCfg, Double eficienciaCiclomedio) {

		/**
		 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e direta, onde ciclo padrao esta para 100 assim como ciclo
		 * medio esta para x
		 */

		// TODO verificar indice dentro do OmPt
		if (ompt.getOmIndpts() != null && ompt.getOmIndpts().isEmpty() == false) {

			for (OmIndpt indPt : ompt.getOmIndpts()) {

				// testa EficienciaCiclomedio
				if (indPt.getIdIndpt() == 2) {

					if (indPt.getIndMeta() == null || indPt.getIndMeta().doubleValue() > eficienciaCiclomedio) {
						return false;
					}
				}

			}
		} else if (ompt.getOmTppt().getOmIndtppts() != null && ompt.getOmTppt().getOmIndtppts().isEmpty() == false) {

			// TODO verificar indice dentro do OmTppt
			for (OmIndtppt indTppt : ompt.getOmTppt().getOmIndtppts()) {
				// testa Eficiencia ciclo medio

				if (indTppt.getIdIndtppt() == 2) {

					if (indTppt.getNumMeta() == null || indTppt.getNumMeta().doubleValue() > eficienciaCiclomedio) {
						return false;
					}
				}

			}
		} else if (omCfg.getOmCfginds() != null && omCfg.getOmCfginds().isEmpty() == false) {

			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				/*
				 * 1 ER 2 EC 3 IR 4 IP
				 */
				if (omCfgInd.getOmInd().getIdInd() == 2) {
					if (eficienciaCiclomedio < omCfgInd.getIndMeta().longValue()) {
						return false;
					}

				}
			}
		}
		return true;
	}

	public boolean isMaquinaDentroDaMetaIR(IdwLogger log, OmPt ompt, OmCfg omCfg, Double indice_refugo) {

		/**
		 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e direta, onde ciclo padrao esta para 100 assim como ciclo
		 * medio esta para x
		 */

		// TODO verificar indice dentro do OmPt
		if (ompt.getOmIndpts() != null && ompt.getOmIndpts().isEmpty() == false) {
		} else if (ompt.getOmTppt().getOmIndtppts() != null && ompt.getOmTppt().getOmIndtppts().isEmpty() == false) {
		} else if (omCfg.getOmCfginds() != null && omCfg.getOmCfginds().isEmpty() == false) {
			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				/*
				 * 1 ER 2 EC 3 IR 4 IP
				 */
				if (omCfgInd.getOmInd().getIdInd() == 3) {
					if (indice_refugo > omCfgInd.getIndMeta().longValue()) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isMaquinaDentroDaMetaIP(IdwLogger log, OmPt ompt, OmCfg omCfg, Double indice_parada) {

		/**
		 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e direta, onde ciclo padrao esta para 100 assim como ciclo
		 * medio esta para x
		 */

		// TODO verificar indice dentro do OmPt
		if (ompt.getOmIndpts() != null && ompt.getOmIndpts().isEmpty() == false) {
		} else if (ompt.getOmTppt().getOmIndtppts() != null && ompt.getOmTppt().getOmIndtppts().isEmpty() == false) {
		} else if (omCfg.getOmCfginds() != null && omCfg.getOmCfginds().isEmpty() == false) {

			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				/*
				 * 1 ER 2 EC 3 IR 4 IP
				 */
				if (omCfgInd.getOmInd().getIdInd() == 4) {
					if (indice_parada > omCfgInd.getIndMeta().longValue()) {
						return false;
					}
				}

			}
		}
		return true;
	}

	public boolean isMaquinaDentroDaMetaEI(IdwLogger log, OmPt ompt, OmCfg omCfg, Double eficienciaUltimoCiclo) {

		/**
		 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e direta, onde ciclo padrao esta para 100 assim como ciclo
		 * medio esta para x
		 */

		// TODO verificar indice dentro do OmPt
		if (ompt.getOmIndpts() != null && ompt.getOmIndpts().isEmpty() == false) {

			for (OmIndpt indPt : ompt.getOmIndpts()) {
				// testa EficienciaCiclomedio
				if (indPt.getIdIndpt() == 2) {
					if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficienciaUltimoCiclo) {
						return false;
					}
				}
			}
		} else if (ompt.getOmTppt().getOmIndtppts() != null && ompt.getOmTppt().getOmIndtppts().isEmpty() == false) {

			// TODO verificar indice dentro do OmTppt
			for (OmIndtppt indTppt : ompt.getOmTppt().getOmIndtppts()) {
				// testa EficienciaUltimoCiclo
				if (indTppt.getIdIndtppt() == 2) {
					if (indTppt.getNumMeta() == null || indTppt.getNumMeta().longValue() > eficienciaUltimoCiclo) {
						return false;
					}
				}

			}
		} else if (omCfg.getOmCfginds() != null && omCfg.getOmCfginds().isEmpty() == false) {

			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				/*
				 * 1 ER 2 EC 3 IR 4 IP
				 */
				if (omCfgInd.getOmInd().getIdInd() == 2) {
					if (eficienciaUltimoCiclo < omCfgInd.getIndMeta().longValue()) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private void recuperarListaAlertasInjet(DwConsol dwconsol, Date iperiodo, Date fperiodo, DwConsolid idClone) {
		DwConsolid dwci = dwconsol.getDwConsolid();
		OmPt omptClonado = idClone.getOmPt();
		PpCp ppcpClonado = null;
		if (dwci.getPpCp() != null)
			ppcpClonado = idClone.getPpCp();

		// lista de alertas - Obter os alertas fechados do turno
		if (dwconsol.getDwConsolals() != null) {

			for (DwConsolal dwConsolal : dwconsol.getDwConsolals()) {
				for (DwConsolaloco dwConsolaloco : dwConsolal.getDwConsolalocos()) {
					AlertaDTO alertaDTO = new AlertaDTO();
					alertaDTO.setDwTAlerta(dwConsolal.getDwTAlerta().clone(false));
					if (alertaDTO.getDwTAlerta().getIsAutomatico() == null)
						alertaDTO.getDwTAlerta().setIsAutomatico(false);

					alertaDTO.setMaquina(omptClonado);

					alertaDTO.setOrdemproducao(ppcpClonado);

					if (dwConsolaloco.getDthrFalerta() != null) {
						alertaDTO.setDthrFalerta(dwConsolaloco.getDthrFalerta());
					}

					alertaDTO.setDthrIalerta(dwConsolaloco.getDthrIalerta());
					alertaDTO.setMsDthrfalerta((byte) 0);
					alertaDTO.setMsDthrialerta((byte) 0);

					if (dwConsolaloco.getDwConsolallog().getDthrFalerta() != null) {
						alertaDTO.setDthrFinal(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwConsolaloco.getDwConsolallog().getDthrFalerta()));
					}

					alertaDTO.setObservacao(dwConsolaloco.getDwConsolallog().getObs());
					alertaDTO.setDwConsolallog(dwConsolaloco.getDwConsolallog().clone(false));
					if (dwConsolaloco.getDwConsolallog().getOmUsr() != null) {
						alertaDTO.setUsuario(dwConsolaloco.getDwConsolallog().getOmUsr().getDsNome());
					}
					listaalertas.add(alertaDTO);
				}
			}
		}

		// ordenar alertas
		Collections.sort(listaalertas, new Comparator<AlertaDTO>() {
			@Override
			public int compare(final AlertaDTO o1,final AlertaDTO o2) {
				final AlertaDTO item1 = o1;
				final AlertaDTO item2 = o2;
				return (item1.getDthrIalerta()).compareTo(item2.getDthrIalerta());
			}
		});

		
				
		
		return;
	}
	
	
	

}
