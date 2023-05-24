package idw.relatorio.analiseproducaoeficiencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolidDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.producao.TpContagemProducao;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioAnaliseEficienciaDTO;
import ms.util.ConversaoTipos;

public final class AnaliseProducaoEficienciaHoraAHoraRN extends AbstractRN<DAOGenerico> {

	private static final Comparator<AnaliseProducaoEficienciaHoraAHoraDTO> COMPARE_HORA_INICIAL_PRODUTO =
			new Comparator<AnaliseProducaoEficienciaHoraAHoraDTO>() {
				@Override
				public int compare(AnaliseProducaoEficienciaHoraAHoraDTO o1, AnaliseProducaoEficienciaHoraAHoraDTO o2) {
					AnaliseProducaoEficienciaHoraAHoraDetalheDTO detalhe1 =
							o1.getItensProducaoEficienciaHoraAHora().get(0);
					AnaliseProducaoEficienciaHoraAHoraDetalheDTO detalhe2 =
							o2.getItensProducaoEficienciaHoraAHora().get(0);
					return DataHoraRN.compareTo(detalhe1.getDthrIRef(), detalhe2.getDthrIRef());
				}
			};

	private static final Comparator<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> COMPARE_HORA =
			new Comparator<AnaliseProducaoEficienciaHoraAHoraDetalheDTO>() {
				@Override
				public int compare(AnaliseProducaoEficienciaHoraAHoraDetalheDTO o1, AnaliseProducaoEficienciaHoraAHoraDetalheDTO o2) {
					int retorno = DataHoraRN.compareTo(o1.getDthrIRef(), o2.getDthrIRef());
					if (retorno == 0) {
						if (o1.getIsParada() != null && o2.getIsParada() != null)
							retorno = o1.getIsParada().compareTo(o2.getIsParada()) * -1;
						if (retorno == 0){
							if (o1.getParadaRefugo() != null && o2.getParadaRefugo() != null)
								retorno = o1.getParadaRefugo().compareTo(o2.getParadaRefugo());
						}
					}
					return retorno;
				}
			};

	private FiltroRelatorioAnaliseEficienciaDTO filtro;
	private final FolhaRN folhaRN;
	private TrataOperadoresLogadosPeriodo trataOperadoresLogadosPeriodo;
	private Cache cache;
	private TrataIndicadores indicadores;

	public AnaliseProducaoEficienciaHoraAHoraRN() {
		this(null);
	}

	public AnaliseProducaoEficienciaHoraAHoraRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
		folhaRN = new FolhaRN(dao);
	}

	/* Metodo principal para emissao do relatorio R014
	 * 
	 */
	public ListaDTOAnaliseProducaoEficienciaHoraAHora getRelatorioEficienciaHoraAHora(final FiltroRelatorioAnaliseEficienciaDTO filtroConsulta) {
		   
		this.filtro = filtroConsulta;

		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "AnaliseProducaoEficienciaHoraAHoraRN.getRelatorioEficienciaHoraAHora");
		log.info( idLog , 0, "AnaliseProducaoEficienciaHoraAHoraRN.getRelatorioEficienciaHoraAHora filtro usado:" + filtro.toString());
		
		
		// removendo 1 segundo da hora final
		filtro.setDt_final(DataHoraRN.subtraiSegundosDaData(filtro.getDt_final(), 1));

		DwConsolidDAO dwConsolidDAO = new DwConsolidDAO(getDaoSession());
		List<DwConsolid> listaConsolid = dwConsolidDAO.getListaConsultaEficienciaHoraAHora(
				filtro.getDt_inicio(), filtro.getDt_final(),
				filtro.getOmpt().getId(), DwConsolidTemplate.TpId.HORA);

		cache = new Cache(folhaRN);
		indicadores = new TrataIndicadores(cache);
		trataOperadoresLogadosPeriodo = new TrataOperadoresLogadosPeriodo(getDaoSession(), filtro);

		ListaDTOAnaliseProducaoEficienciaHoraAHora retorno = new ListaDTOAnaliseProducaoEficienciaHoraAHora();
		retorno = montarRelatorio(listaConsolid, filtro.getOmpt());
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;//montarRelatorio(listaConsolid, filtro.getOmpt());

	}

	private ListaDTOAnaliseProducaoEficienciaHoraAHora montarRelatorio(List<DwConsolid> listaConsolid, OmPt ompt) {
		final ListaDTOAnaliseProducaoEficienciaHoraAHora relatorio = new ListaDTOAnaliseProducaoEficienciaHoraAHora();

		final TpContagemProducao tpContagemProducao;

		if (filtro.isPeca()) {
			tpContagemProducao = TpContagemProducao.PECA;
		} else if (filtro.isPeso()) {
			tpContagemProducao = (filtro.isUnidMedidaKg() ? TpContagemProducao.QUILO : TpContagemProducao.TONELADA);
		} else {
			throw new IllegalArgumentException("Contagem de produção não identificada. " + filtro);
		}

		for (DwConsolid dwConsolid : listaConsolid) {

			final Date dthrIHora = dwConsolid.getDthrIhora();
			final Date dtHrFHora = dwConsolid.getDthrFhora();
			final DwFolha dwFolha = dwConsolid.getDwFolha();

			for (DwConsol dwConsol : dwConsolid.getDwConsols()) {

				for (DwConsolpr dwConsolpr : dwConsol.getDwConsolprs()) {

					final OmProduto omProduto = dwConsolpr.getOmProduto();
					final String cdProduto = omProduto.getCdProduto();

					final List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> horaDetalhesDwConsolid =
							addHoraDetalhesProduto(dthrIHora, dtHrFHora, dwConsol);

					ProducaoHora producaoHora = new ProducaoHora(
							dwConsolid.getDthrIhora(), dwConsolid.getDthrFhora(), dwConsol, dwConsolpr,
							dwConsolid.getDwFolha(), horaDetalhesDwConsolid, dwConsolid.getDthrIconsol(), dwConsolid.getDthrFconsol());

					cache.agruparProducaoHora(cdProduto, dwFolha, producaoHora);
					
				}
			}

		}

		montarRelatorioProduto(relatorio, tpContagemProducao, ompt);

		return relatorio;

	}

	private void montarRelatorioProduto(
			final ListaDTOAnaliseProducaoEficienciaHoraAHora relatorio,
			final TpContagemProducao tpContagemProducao, OmPt ompt) {
		
		for (String cdProduto : cache.getProdutos()) {

			OmProduto omProduto = null;

			try {
				omProduto = getDao().findByCd(OmProduto.class, cdProduto, "cdProduto", false);
			} catch (RegistroDesconhecidoException e) {
				throw new RuntimeException("Produto " + cdProduto + " nao encontrado atraves de findByCd");
			}

			final AnaliseProducaoEficienciaHoraAHoraDTO relatorioProduto = createRelatorioProduto(omProduto);
			relatorio.getListaDTOs().add(relatorioProduto);

			montarRelatorioHora(tpContagemProducao, cdProduto, omProduto, relatorioProduto, ompt);

			indicadores.calculaIndicadoresProduto(relatorioProduto);
			
			Collections.sort(relatorioProduto.getItensProducaoEficienciaHoraAHora(), COMPARE_HORA);
			trataOperadoresLogadosPeriodo.ordenar(relatorioProduto);
		}
		
		Collections.sort(relatorio.getListaDTOs(), COMPARE_HORA_INICIAL_PRODUTO);
		
	}

	private void montarRelatorioHora(
			final TpContagemProducao tpContagemProducao, 
			String cdProduto, 
			OmProduto omProduto,
			final AnaliseProducaoEficienciaHoraAHoraDTO relatorioProduto,
			OmPt ompt) {
		
		FolhaRN frn = new FolhaRN(getDao());
		
		for (ProducaoHora producaoHora : cache.getProducoesHora(cdProduto)) {
			DwFolha dwFolha = producaoHora.getDwFolha();

			// aplica multiplicador nos indicadores de ProducaoHora
			final BigDecimal cavidadesAtivas = cache.getCavidadesAtivas(dwFolha, omProduto);
			final BigDecimal cavidadesTotais = cache.getCavidadesTotais(dwFolha, omProduto);
			
			BigDecimal fatorContagem;
			try {
				fatorContagem = frn.getFatorContagemFromDwFolha(dwFolha, ompt);
			} catch (SemPacoteOuFatorException e) {
				fatorContagem = BigDecimal.ONE;
			}

			final Double multiplicador = (filtro.isPeca() ? 1 : tpContagemProducao.aplicarDivisor(relatorioProduto.getgPesoLiquidoProduto()));
			
			// Guarda os indicadores da hora que serão repassados para as outras linhas da mesma hora
			final AnaliseProducaoEficienciaHoraAHoraDetalheDTO horaDetalheResumo =
					createHoraDetalheResumo(
							multiplicador, 
							producaoHora,
							cavidadesAtivas, 
							cavidadesTotais,
							fatorContagem,
							ompt);
			
			adicionaDetalheHoraQuandoNaoHaParadaNemRefugo(producaoHora);
			
			indicadores.setIndicadoresTodosDetalhesDaHora(horaDetalheResumo, producaoHora.getEventosHora());

			indicadores.acumulaRelatorioProduto(relatorioProduto, omProduto.getCdProduto(), horaDetalheResumo,
					dwFolha, cavidadesAtivas, cavidadesTotais);

			trataOperadoresLogadosPeriodo.addOperadoresLogadosDentroPeriodo(relatorioProduto, producaoHora);

			relatorioProduto.getItensProducaoEficienciaHoraAHora().addAll(producaoHora.getEventosHora());
			
			setDtHrIRefParaOrdenacaoProduto(producaoHora);

		}
	}

	private void adicionaDetalheHoraQuandoNaoHaParadaNemRefugo(ProducaoHora producaoHora) {
		// Quando não há itens dentro da hora, indica que não teve refugo nem parada dentro dela
		// Portanto, adiciona nova linha para o relatório
		if (producaoHora.getEventosHora().isEmpty()) {
			final AnaliseProducaoEficienciaHoraAHoraDetalheDTO horaDetalhe = createHoraProdutoDetalhe(producaoHora.getDthrIHora(), producaoHora.getDthrFHora());
			producaoHora.getEventosHora().add(horaDetalhe);
		}
	}

	private void setDtHrIRefParaOrdenacaoProduto(ProducaoHora producaoHora) {
		Date dthrIReferencia = ObjectUtils.defaultIfNull(producaoHora.getDthrIReferencia(), producaoHora.getDthrIHora());
		for (AnaliseProducaoEficienciaHoraAHoraDetalheDTO evento : producaoHora.getEventosHora()) {
			evento.setDthrIRef(dthrIReferencia);
		}
	}

	private List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> addHoraDetalhesProduto(final Date dthrIHora, final Date dtHrFHora,
			DwConsol dwConsol) {
		final List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> horaDetalhesDwConsolid =
				new ArrayList<AnaliseProducaoEficienciaHoraAHoraDetalheDTO>();

		addHoraDetalheProdutoParadas(dwConsol, horaDetalhesDwConsolid, dthrIHora, dtHrFHora);
		addHoraDetalheProdutoRefugos(dwConsol, horaDetalhesDwConsolid, dthrIHora, dtHrFHora);

		return horaDetalhesDwConsolid;
	}

	private AnaliseProducaoEficienciaHoraAHoraDetalheDTO createHoraDetalheResumo(
			Double multiplicador, 
			ProducaoHora producaoHora,
			BigDecimal cavidadesAtivas, 
			BigDecimal cavidadesTotais,
			BigDecimal fatorContagem,
			OmPt ompt) {

		final AnaliseProducaoEficienciaHoraAHoraDetalheDTO dto = new AnaliseProducaoEficienciaHoraAHoraDetalheDTO();

		indicadores.setIndicadores(multiplicador, producaoHora, cavidadesAtivas, cavidadesTotais, dto, fatorContagem, ompt);

		return dto;
	}

	// Metodo insere o refugo na lista de linhas do relatorio
	private boolean addHoraDetalheProdutoRefugos(DwConsol dwConsol, List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> horaDetalhes, Date dtHrIniHora, Date dtHrFimHora) {
		boolean isRelatorioProdutoHoraInserido = !dwConsol.getDwConsolres().isEmpty();
		for (DwConsolre dwConsolre : dwConsol.getDwConsolres()) {
			
			// Se a producao refugada for zerada, descartar
			if (dwConsolre.getPcsProducaorefugada().doubleValue() == 0d)
				continue;

			final String codigoDescricao = getCodigoDescricao(dwConsolre.getDwTRefugo().getCdTrefugo(), dwConsolre.getDwTRefugo().getDsTrefugo());

			final BigDecimal qtRefugada = dwConsolre.getPcsProducaorefugada();
			String qtRefugadaFormatada = ConversaoTipos.converteParaStringCasasOpcionais(dwConsolre.getPcsProducaorefugada(), 2);

			AnaliseProducaoEficienciaHoraAHoraDetalheDTO relatorioProdutoHora = null;
			
			for (AnaliseProducaoEficienciaHoraAHoraDetalheDTO linha : horaDetalhes) {
				if (DataHoraRN.equals(linha.getDthrIHora(), dtHrIniHora) && DataHoraRN.equals(linha.getDthrFHora(), dtHrFimHora) && linha.getParadaRefugo().equals(codigoDescricao))
					relatorioProdutoHora = linha;
			}
			if (relatorioProdutoHora == null) {
				relatorioProdutoHora = createHoraProdutoDetalhe(
						codigoDescricao, 
						qtRefugada.doubleValue(), 
						qtRefugadaFormatada, 
						dtHrIniHora, 
						dtHrFimHora);
				relatorioProdutoHora.setIsParada(false);
				horaDetalhes.add(relatorioProdutoHora);
			} else {
				// Se a linha ja existe no relatorio entao simplesmente adicionar o refugo
				relatorioProdutoHora.setProducaoRefugada(relatorioProdutoHora.getProducaoRefugada() + qtRefugada.doubleValue());
				relatorioProdutoHora.setTempoParadaOuQtRefugo(relatorioProdutoHora.getProducaoRefugada());
				relatorioProdutoHora.setTempoParadaOuQtRefugoFormatado(ConversaoTipos.converteParaString(relatorioProdutoHora.getProducaoRefugada(), 2));
				relatorioProdutoHora.setIsParada(false);
			}
			
		}
		return isRelatorioProdutoHoraInserido;
	}

	private boolean addHoraDetalheProdutoParadas(DwConsol dwConsol, List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> horaDetalhes,
			Date dtHrIniHora, Date dtHrFimHora) {
		boolean isRelatorioProdutoHoraInserido = false;
		for (DwConsolpa dwConsolpa : dwConsol.getDwConsolpas()) {

			if (!dwConsolpa.isRegistroInvalido()) {

				final String codigoDescricao = getCodigoDescricao(dwConsolpa.getDwTParada().getCdTparada(), dwConsolpa.getDwTParada().getDsTparada());

				for (DwConsolpaoco dwConsolpaoco : dwConsolpa.getDwConsolpaocos()) {
					final Date dtHrIniparada = dwConsolpaoco.getDthrIparada();
					final Date dtHrFimParada = dwConsolpaoco.getDthrFparada();
					if (dtHrFimParada != null) {
						final double duracaoParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrIniparada, dtHrFimParada);
						String duracaoParadaFormatada = DataHoraRN.formatSegundosParaHHMMSS((int) duracaoParada);

						AnaliseProducaoEficienciaHoraAHoraDetalheDTO relatorioProdutoHora = null;
						
						for (AnaliseProducaoEficienciaHoraAHoraDetalheDTO linha : horaDetalhes) {
							if (
									DataHoraRN.equals(linha.getDthrIHora(), dtHrIniHora) && 
									DataHoraRN.equals(linha.getDthrFHora(), dtHrFimHora) && 
									linha.getParadaRefugo().equals(codigoDescricao))
								relatorioProdutoHora = linha;
						}
						
						if (relatorioProdutoHora == null) {
							relatorioProdutoHora = createHoraProdutoDetalhe(codigoDescricao, duracaoParada, duracaoParadaFormatada, dtHrIniHora, dtHrFimHora);
							horaDetalhes.add(relatorioProdutoHora);
							isRelatorioProdutoHoraInserido = true;
							relatorioProdutoHora.setIsParada(true);
						} else {
							relatorioProdutoHora.setTempoParadaOuQtRefugo(relatorioProdutoHora.getTempoParadaOuQtRefugo() + duracaoParada);
							relatorioProdutoHora.setTempoParadaOuQtRefugoFormatado(DataHoraRN.formatSegundosParaHHMMSS(relatorioProdutoHora.getTempoParadaOuQtRefugo().intValue()));
							relatorioProdutoHora.setIsParada(true);
						}
					}
				}
			}
		}
		return isRelatorioProdutoHoraInserido;
	}

	public static String getCodigoDescricao(String codigo, String descricao) {
		return codigo + " - " + descricao;
	}

	static AnaliseProducaoEficienciaHoraAHoraDetalheDTO createHoraProdutoDetalhe(String codigoDescricao, Double tempoParadaOuQtRefugo,
			String tempoParadaOuQtRefugoFormatado, Date dtHrIniHora, Date dtHrFimHora) {

		AnaliseProducaoEficienciaHoraAHoraDetalheDTO relatorioProdutoHora = createHoraProdutoDetalhe(dtHrIniHora, dtHrFimHora);

		setParadaRefugo(codigoDescricao, tempoParadaOuQtRefugo, tempoParadaOuQtRefugoFormatado, relatorioProdutoHora);

		return relatorioProdutoHora;
	}

	private static AnaliseProducaoEficienciaHoraAHoraDetalheDTO createHoraProdutoDetalhe(Date dtHrIniHora, Date dtHrFimHora) {
		AnaliseProducaoEficienciaHoraAHoraDetalheDTO relatorioProdutoHora = new AnaliseProducaoEficienciaHoraAHoraDetalheDTO(
				DataHoraRN.ZERADO_HHMMSS);

		relatorioProdutoHora.setDthrIHora(dtHrIniHora);
		relatorioProdutoHora.setIntervaloHoraInicial(DataHoraRN.dateToStringDDMMHHMM(relatorioProdutoHora.getDthrIHora()));
		relatorioProdutoHora.setDthrFHora(dtHrFimHora);
		relatorioProdutoHora.setIntervaloHoraFinal(DataHoraRN.dateToStringDDMMHHMM(relatorioProdutoHora.getDthrFHora()));
		return relatorioProdutoHora;
	}
	
	static void setParadaRefugo(String codigoDescricao, Double tempoParadaOuQtRefugo, String tempoParadaOuQtRefugoFormatado,
			AnaliseProducaoEficienciaHoraAHoraDetalheDTO relatorioProdutoHora) {
		relatorioProdutoHora.setParadaRefugo(codigoDescricao);
		relatorioProdutoHora.setTempoParadaOuQtRefugo(tempoParadaOuQtRefugo);
		relatorioProdutoHora.setTempoParadaOuQtRefugoFormatado(tempoParadaOuQtRefugoFormatado);
	}

	public static AnaliseProducaoEficienciaHoraAHoraDTO createRelatorioProduto(OmProduto omProduto) {
		AnaliseProducaoEficienciaHoraAHoraDTO relatorioProduto = new AnaliseProducaoEficienciaHoraAHoraDTO();
		final BigDecimal pesoBruto = ObjectUtils.defaultIfNull(omProduto.getGPesoBruto(), BigDecimal.ONE);
		relatorioProduto.setItensProducaoEficienciaHoraAHora(new ArrayList<AnaliseProducaoEficienciaHoraAHoraDetalheDTO>());
		relatorioProduto.setCodigoProduto(omProduto.getCdProduto());
		relatorioProduto.setDescricaoProduto(omProduto.getDsProduto());
		relatorioProduto.setgPesoLiquidoProduto(pesoBruto.doubleValue());
		relatorioProduto.setTotalIndiceEficienciaRealizacao(0F);
		relatorioProduto.setTotalIndiceMAtivas(0F);
		relatorioProduto.setTotalIndiceParadas(0F);
		relatorioProduto.setTotalIndiceRefugo(0F);
		relatorioProduto.setTotalProducaoBruta(0d);
		relatorioProduto.setTotalProducaoLiquida(0d);
		relatorioProduto.setTotalProducaoPrevista(0d);
		relatorioProduto.setTotalProducaoRefugada(0d);
		relatorioProduto.setTotalTempoAtivo(0d);
		relatorioProduto.setTotalTempoAtivoFormatado(DataHoraRN.ZERADO_HHMMSS);
		relatorioProduto.setTotalTempoParadaCP(0d);
		relatorioProduto.setTotalTempoParadaCPFormatado(DataHoraRN.ZERADO_HHMMSS);
		relatorioProduto.setTotalCavidadesAtivas(0d);
		relatorioProduto.setTotalCavidadesTotais(0d);
		relatorioProduto.setListaOperadoresDTO(new ArrayList<OperadorLogDTO>());
		return relatorioProduto;
	}

}
