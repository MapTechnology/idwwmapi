package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsolperdamplog;
import idw.model.pojos.OmProduto;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.GTRN;
import idw.model.rn.PTRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.detalhemonitorizacao.GraficoPerdaMateriaPrimaRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.util.Cor;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.ListaPerdasmpDTO;
import idw.webservices.dto.PerdasmpDTO;
import idw.webservices.rest.dto.monitorizacao.ChaveValorDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMpDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPerdasMpDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRecorrenciaPerdaMateriaPrimaDTO;
import idw.webservices.rest.dto.monitorizacao.ItemRecorrenciaDetalhePerdaMateriaPrimaDTO;
import idw.webservices.rest.dto.monitorizacao.ItemRecorrenciaPerdaMateriaPrimaDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDataHoraDTO;
import idw.webservices.rest.dto.monitorizacao.MpBrutaPostoDTO;
import idw.webservices.rest.dto.monitorizacao.PerdasFerramentaDTO;
import idw.webservices.rest.dto.monitorizacao.PerdasProdutoDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebMateriaPrimaRN extends AbstractRN<DAOGenerico> {

	public static final Color COR_LEGENDA_VERDE = Color.green;
	public static final Color COR_LEGENDA_AMARELO = Color.yellow;
	public static final Color COR_LEGENDA_LARANJA = Color.orange;
	public static final Color COR_LEGENDA_VERMELHO = Color.red;

	private final String formatoData;
	private final String formatoDataHora;

	private FiltroMpDTO filtro;

	public DetalheMonitorizacaoWebMateriaPrimaRN(String formatoData, String formatoDataHora) {
		this(new DAOGenerico(), formatoData, formatoDataHora);
	}

	public DetalheMonitorizacaoWebMateriaPrimaRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
		super(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
	}

	/*
	 * Metodo chamado pelo VF-WEB para montar o grafico de perda de materia-prima
	 * 
	 */
	public GraficoPerdasMpDTO getPerdasMateriaPrima(FiltroMpDTO filtro) throws RegistroDesconhecidoException {
		IdwLogger log = new IdwLogger("getPerdasMateriaPrima-" + filtro.getFiltro().getCdGt() + "-" + filtro.getFiltro().getCdPosto());
		int idLog = log.getIdAleatorio();

		log.iniciaAvaliacao("getPerdasMateriaPrima");
		this.filtro = filtro;

		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN(getDao());
		// GraficoPerdaMateriaPrimaRN rng = new GraficoPerdaMateriaPrimaRN(getDao());
		FiltroGraficoDetalhePtDTO filtroConvertido = getFiltroConvertido(filtro.getFiltro());

		ListaPerdasmpDTO dto = new ListaPerdasmpDTO();
		if (filtroConvertido.getOmProduto() == null && filtroConvertido.getDwRap() == null) {
			dto = rn.getGraficoPerdasMateriaPrima(filtroConvertido);

			// dto = rng.getGraficoPerdasMateriaPrima(filtroConvertido);
		} else {
			if (filtroConvertido.getOmProduto() != null) {
				dto = rn.getGraficoPerdaFerrmantaPorProduto(filtroConvertido);
			}

			if (filtroConvertido.getDwRap() != null) {
				dto = rn.getGraficoPerdaMpPorRap(filtroConvertido);
			}
		}

		if (dto.getPerdasmpDTOs() == null) {
			dto.setPerdasmpDTOs(new ArrayList<PerdasmpDTO>());
		}

		if (dto.getPerdasmpRapDTOs() == null) {
			dto.setPerdasmpRapDTOs(new ArrayList<PerdasmpDTO>());
		}

		GraficoPerdasMpDTO retorno = new GraficoPerdasMpDTO();
		retorno.setPerdasMateriaPrima(getPerdasMateriaPrima(dto.getPerdasmpDTOs()));

		// TODO: avaliar essas perdas com analise de gargalo (qdo grafico eh montado em rotina diferente de getGraficoPerdasMateriaPrima
		// ocorria erro
		// retorno.setPerdasMateriaPrimaOP(getPerdasMateriaPrima(dto.getPerdasmpOPDTOs()));
		// retorno.setPerdasMateriaPrimaAlim(getPerdasMateriaPrima(dto.getPerdasmpAlimDTOs()));

		retorno.setPerdasFerramenta(getPerdasFerramenta(dto));
		retorno.setLegendasMateriaPrima(getLegendasMateriaPrima(dto));
		retorno.setLegendasFerramenta(getLegendasFerramenta(dto));
		retorno.setGraficoDropRate(getGraficoDropRate(dto, filtro.getListaMpBruta()));
		retorno.setGraficoCustoPorPerda(getGraficoCustoPorPerdas(dto));

		log.mostrarAvaliacaoCompleta(idLog, 0);

		return retorno;
	}

	/*
	 * Metodo chamado pelo WM para a perda de materia-prima
	 * 
	 */
	public GraficoPerdasMpDTO getPerdasMateriaPrimaWM(FiltroMpDTO filtro) throws RegistroDesconhecidoException {
		IdwLogger log = new IdwLogger("getPerdasMateriaPrimaWM-" + filtro.getFiltro().getCdGt() + "-" + filtro.getFiltro().getCdPosto());
		int idLog = log.getIdAleatorio();

		log.iniciaAvaliacao("getPerdasMateriaPrima");
		this.filtro = filtro;

		GraficoPerdaMateriaPrimaRN rng = new GraficoPerdaMateriaPrimaRN(getDao());
		FiltroGraficoDetalhePtDTO filtroConvertido = getFiltroConvertido(filtro.getFiltro());

		ListaPerdasmpDTO dto = new ListaPerdasmpDTO();
		dto = rng.getGraficoPerdasMateriaPrima(filtroConvertido);

		if (dto.getPerdasmpDTOs() == null) {
			dto.setPerdasmpDTOs(new ArrayList<PerdasmpDTO>());
		}

		if (dto.getPerdasmpRapDTOs() == null) {
			dto.setPerdasmpRapDTOs(new ArrayList<PerdasmpDTO>());
		}

		GraficoPerdasMpDTO retorno = new GraficoPerdasMpDTO();

		retorno.setPerdasMateriaPrima(getPerdasMateriaPrima(dto.getPerdasmpDTOs()));
		retorno.setPerdasFerramenta(getPerdasFerramenta(dto));

		log.mostrarAvaliacaoCompleta(idLog, 0);

		return retorno;
	}

	public GraficoRecorrenciaPerdaMateriaPrimaDTO getPerdasMateriaPrimaOcorrencia(FiltroMpDTO filtro) throws RegistroDesconhecidoException {
		this.filtro = filtro;

		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN(getDao());
		FiltroGraficoDetalhePtDTO filtroConvertido = getFiltroConvertido(filtro.getFiltro());

		List<DwConsolperdamplog> dwConsolperdamplogs = rn.pesquisarMateriaPrima(filtroConvertido);

		Map<Integer, List<DwConsolperdamplog>> mapPorHora = new HashMap<Integer, List<DwConsolperdamplog>>();

		Date dtHrInicio = null;
		Date dtHrFim = null;

		for (DwConsolperdamplog dwConsolperdamplog : dwConsolperdamplogs) {

			if (dwConsolperdamplog == null) {
				continue;
			}

			if (dtHrInicio == null || dtHrFim == null) {
				dtHrInicio = dwConsolperdamplog.getDwConsolpempocos().iterator().next().getDwConsolpemp().getDwConsol().getDwConsolid()
						.getDthrIturno();
				dtHrFim = dwConsolperdamplog.getDwConsolpempocos().iterator().next().getDwConsolpemp().getDwConsol().getDwConsolid()
						.getDthrFturno();
			}

			Integer horaPerda = DataHoraRN.getApenasHoras(dwConsolperdamplog.getDthrPerdamp());

			List<DwConsolperdamplog> listaPorHora = mapPorHora.get(horaPerda);

			if (listaPorHora == null) {
				listaPorHora = new ArrayList<DwConsolperdamplog>();
				mapPorHora.put(horaPerda, listaPorHora);
			}

			listaPorHora.add(dwConsolperdamplog);
		}

		List<ItemRecorrenciaPerdaMateriaPrimaDTO> itens = new ArrayList<ItemRecorrenciaPerdaMateriaPrimaDTO>();

		BigDecimal quantidadePerdaTotal = BigDecimal.ZERO;

		if (dtHrInicio != null && dtHrFim != null && DataHoraRN.before(dtHrInicio, dtHrFim)) {

			Date horaSelecionada = dtHrInicio;
			while (DataHoraRN.before(horaSelecionada, dtHrFim)) {

				BigDecimal quantidadePerdaNaHoraSelecionada = BigDecimal.ZERO;

				Integer horaPerda = DataHoraRN.getApenasHoras(horaSelecionada);
				List<DwConsolperdamplog> logs = mapPorHora.get(horaPerda);
				List<ItemRecorrenciaDetalhePerdaMateriaPrimaDTO> perdas = new ArrayList<ItemRecorrenciaDetalhePerdaMateriaPrimaDTO>();
				if (logs != null) {
					for (DwConsolperdamplog log : logs) {
						BigDecimal quantidadePerda = log.getQtAutoPerdamp();
						quantidadePerda = quantidadePerda.add(log.getQtManuPerdamp());

						quantidadePerdaNaHoraSelecionada = quantidadePerdaNaHoraSelecionada.add(quantidadePerda);

						ItemRecorrenciaDetalhePerdaMateriaPrimaDTO perda = new ItemRecorrenciaDetalhePerdaMateriaPrimaDTO();
						perda.setDtHrPerda(DataHoraRN.dateToString(log.getDthrPerdamp(), formatoDataHora));
						perda.setQuantidadePerda(ConversaoTipos.converteParaString(quantidadePerda, 0));
						perda.setTurno(filtroConvertido.getDwTurno().getDsTurno());
						perda.setPosto(filtro.getFiltro().getCdPosto());
						perda.setFerramenta(log.getDwRap().getCdRap());
						perda.setProduto(log.getOmProduto().getCdProduto());

						perdas.add(perda);
					}
				}

				quantidadePerdaTotal = quantidadePerdaTotal.add(quantidadePerdaNaHoraSelecionada);

				ItemRecorrenciaPerdaMateriaPrimaDTO item = new ItemRecorrenciaPerdaMateriaPrimaDTO();
				item.setDtHrInicio(DataHoraRN.dateToString(horaSelecionada, formatoDataHora));
				horaSelecionada = DataHoraRN.adicionaHorasDaData(horaSelecionada, 1);
				item.setDtHrFim(DataHoraRN.dateToString(horaSelecionada, formatoDataHora));
				item.setFerramenta(filtroConvertido.getDwRap() == null ? "-" : filtroConvertido.getDwRap().getCdRap());
				item.setProduto(filtroConvertido.getOmProduto() == null ? "-" : filtroConvertido.getOmProduto().getCdProduto());
				item.setQuantidadePerda(ConversaoTipos.converteParaString(quantidadePerdaNaHoraSelecionada, 0));
				item.setIndice("");
				item.setIndiceCor("");
				item.setPerdas(perdas);
				itens.add(item);
			}
		}

		GraficoRecorrenciaPerdaMateriaPrimaDTO retorno = new GraficoRecorrenciaPerdaMateriaPrimaDTO();
		retorno.setDtHrInicio(DataHoraRN.dateToString(dtHrInicio, formatoDataHora));
		retorno.setDtHrFim(DataHoraRN.dateToString(dtHrFim, formatoDataHora));
		retorno.setPosto(filtro.getFiltro().getCdPosto());
		retorno.setFerramenta(filtroConvertido.getDwRap() == null ? "-" : filtroConvertido.getDwRap().getCdRap());
		retorno.setProduto(filtroConvertido.getOmProduto() == null ? "-" : filtroConvertido.getOmProduto().getCdProduto());
		retorno.setIndice("");
		retorno.setPerdaTotal(ConversaoTipos.converteParaString(quantidadePerdaTotal, 0));
		retorno.setIndicador(null);
		retorno.setItens(itens);
		return retorno;
	}

	public FiltroGraficoDetalhePtDTO getFiltroConvertido(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
		FiltroGraficoDetalhePtDTO retorno = new FiltroGraficoDetalhePtDTO();

		if (filtro.getCdPosto() != null && !filtro.getCdPosto().equals("")) {
			PTRN ptRN = new PTRN(getDao());
			retorno.setOmPt(ptRN.getOmPt(filtro.getCdPosto()));
		}

		if (filtro.getCdGt() != null && !filtro.getCdGt().equals("")) {
			GTRN gtRN = new GTRN();
			gtRN.setSession(getDaoSession());
			retorno.setOmGt(gtRN.getOmGtPorIdOuCd(null, filtro.getCdGt()));
		}

		TurnoRN turnoRN = new TurnoRN(getDao());
		retorno.setDwTurno(turnoRN.pesquisarTurnoById(filtro.getIdTurno()));

		// retorno.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
		/* Alan - 29/08/2018: XGH para poder entregar logo rest pedido por Manuel/Lajos */
		if (filtro.getDtReferencia().equals("01/01/1900")) {
			retorno.setDtReferencia(null);
		} else {
			retorno.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
		}
		retorno.setTpId(filtro.getTpId());

		if (filtro.getIdProduto() > 0l) {
			ProdutoRN produtoRN = new ProdutoRN(getDao());
			OmProduto produto = produtoRN.getOmProduto(filtro.getIdProduto());
			retorno.setOmProduto(produto);
		}

		if (filtro.getIdRap() > 0l) {
			DwRapRN rapRN = new DwRapRN(getDao());
			rapRN.setIdRap(filtro.getIdRap());
			retorno.setDwRap(rapRN.pesquisarDwRapById());
		}

		return retorno;
	}

	private List<PerdasProdutoDTO> getPerdasMateriaPrima(List<PerdasmpDTO> listaPerdasDTO) {
		List<PerdasProdutoDTO> perdasMateriaPrima = new ArrayList<>();

		boolean isVisaoGT = this.filtro.getFiltro().getCdGt() != null && !this.filtro.getFiltro().getCdGt().equals("");

		for (PerdasmpDTO perda : listaPerdasDTO) {
			PerdasProdutoDTO perdaProduto = new PerdasProdutoDTO();

			perdaProduto.setIdProduto(perda.getOmproduto().getIdProduto());
			if (isVisaoGT) {
				perdaProduto.setCdProduto(perda.getCdUP() + " - " + perda.getOmproduto().getCdProduto());
			} else {
				perdaProduto.setCdProduto(perda.getOmproduto().getCdProduto());
			}

			perdaProduto.setQuantidadeUtilizada(ConversaoTipos.converteParaString(perda.getQuantidadeUtilizada(), 1, true));
			perdaProduto.setQuantidadePerdida(ConversaoTipos.converteParaString(perda.getQuantidade(), 1, true));
			perdaProduto.setPorcentagemPerda(ConversaoTipos.converteParaString(perda.getIndiceDePerda(), 4, true));

			perdaProduto.setQuantidadeAlimentada(ConversaoTipos.converteParaString(perda.getQuantidadeAlimentacao(), 1, true));
			perdaProduto.setPorcentagemPerdaAlimentacao(ConversaoTipos.converteParaString(perda.getIndiceDePerdaAlimentacao(), 4, true));

			perdaProduto.setQuantidadePrevistaOP(ConversaoTipos.converteParaString(perda.getQuantidadePrevistaOP(), 1, true));
			perdaProduto.setPorcentagemPerdaOP(ConversaoTipos.converteParaString(perda.getIndiceDePerdaOP(), 4, true));

			try {
				perdaProduto.setCorOcorrencia(Cor.transformarColorParaCodigoHexadecimal(perda.getCorBarra()));
			} catch (NumberFormatException e) {
				System.out.println("deb " + perda.getCorBarra());
			}
			FiltroMpDTO filtroDetalhe = new FiltroMpDTO();
			filtroDetalhe.setFiltro(filtro.getFiltro().getCopia());
			filtroDetalhe.getFiltro().setCdGt(null);
			filtroDetalhe.getFiltro().setCdPosto(perda.getOmPt().getCdPt());
			filtroDetalhe.getFiltro().setIdRap(0l);
			filtroDetalhe.getFiltro().setIdProduto(perda.getOmproduto().getIdProduto());
			filtroDetalhe.setListaMpBruta(new ArrayList<MpBrutaPostoDTO>());

			perdaProduto.setFiltro(filtroDetalhe);

			perdasMateriaPrima.add(perdaProduto);
		}
		return perdasMateriaPrima;
	}

	private List<PerdasFerramentaDTO> getPerdasFerramenta(ListaPerdasmpDTO dto) {
		List<PerdasFerramentaDTO> perdasFerramenta = new ArrayList<>();
		for (PerdasmpDTO perda : dto.getPerdasmpRapDTOs()) {
			PerdasFerramentaDTO perdaFerramenta = new PerdasFerramentaDTO();
			perdaFerramenta.setCdFerramenta(perda.getDwRap().getCdRap());
			perdaFerramenta.setQuantidadePerdida(ConversaoTipos.converteParaString(perda.getQuantidade(), 1, true));
			try {
				perdaFerramenta.setCorOcorrencia(Cor.transformarColorParaCodigoHexadecimal(perda.getCorBarra()));
			} catch (NumberFormatException e) {
				System.out.println("deb " + perda.getCorBarra());
			}

			FiltroMpDTO filtroDetalhe = new FiltroMpDTO();
			filtroDetalhe.setFiltro(filtro.getFiltro().getCopia());
			filtroDetalhe.getFiltro().setCdGt(null);
			filtroDetalhe.getFiltro().setCdPosto(perda.getOmPt().getCdPt());
			filtroDetalhe.getFiltro().setIdProduto(0l);
			filtroDetalhe.getFiltro().setIdRap(perda.getDwRap().getIdRap());
			filtroDetalhe.setListaMpBruta(new ArrayList<MpBrutaPostoDTO>());

			perdaFerramenta.setFiltro(filtroDetalhe);

			perdasFerramenta.add(perdaFerramenta);
		}
		return perdasFerramenta;
	}

	private List<ChaveValorDTO> getGraficoDropRate(ListaPerdasmpDTO dto, List<MpBrutaPostoDTO> listaMpBruta) {
		List<ChaveValorDTO> retorno = new ArrayList<>();

		Map<String, Double> perdaPorMaquina = new HashMap<>();
		Map<Double, String> auxSort = new HashMap<>();

		for (PerdasmpDTO perdas : dto.getPerdasmpDTOs()) {
			if (perdaPorMaquina.containsKey(perdas.getCdUP())) {
				Double auxPerdas = perdaPorMaquina.get(perdas.getCdUP());
				perdaPorMaquina.remove(perdas.getCdUP());
				auxPerdas = auxPerdas + perdas.getQuantidade();
				perdaPorMaquina.put(perdas.getCdUP(), auxPerdas);
			} else {
				perdaPorMaquina.put(perdas.getCdUP(), perdas.getQuantidade());
			}
		}

		for (Map.Entry<String, Double> p1 : perdaPorMaquina.entrySet()) {
			auxSort.put(p1.getValue(), p1.getKey());
		}

		Map<Double, String> mapSorted = new TreeMap<>(new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				return o2.compareTo(o1);
			}
		});

		mapSorted.putAll(auxSort);

		if (listaMpBruta != null) {
			for (Map.Entry<Double, String> maqPerda : mapSorted.entrySet()) {
				for (MpBrutaPostoDTO mpBrutaMaq : listaMpBruta) {
					if (mpBrutaMaq.getPosto().equals(maqPerda.getValue())) {

						BigDecimal mpBruta = new BigDecimal(mpBrutaMaq.getMateriaPrimaBruta());
						if (mpBruta.doubleValue() != 0d && maqPerda.getKey() != 0d) {
							Double aux = (1 - (maqPerda.getKey() / mpBruta.doubleValue())) * 100;

							ChaveValorDTO valor = new ChaveValorDTO();
							valor.setChave(maqPerda.getValue());
							valor.setValor(ConversaoTipos.converteParaString(aux, 3, true));

							retorno.add(valor);
						}
					}
				}
			}
		}

		return retorno;
	}

	private List<ChaveValorDTO> getGraficoCustoPorPerdas(ListaPerdasmpDTO dto) {
		List<ChaveValorDTO> retorno = new ArrayList<>();

		Map<Double, String> produtoValor = new HashMap<>();

		for (PerdasmpDTO perdas : dto.getPerdasmpDTOs()) {
			if (perdas.getPreco() != null) {
				produtoValor.put(
						perdas.getPreco()
								.multiply(
										BigDecimal.valueOf(perdas
												.getQuantidade()))
								.doubleValue(),
						perdas.getOmproduto()
								.getCdProduto());
			} else {
				produtoValor.put(0d, perdas.getOmproduto().getCdProduto());
			}
		}

		Map<Double, String> treeMap = new TreeMap<>(new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				return o2.compareTo(o1);
			}
		});

		treeMap.putAll(produtoValor);

		for (Map.Entry<Double, String> custoProd : treeMap.entrySet()) {
			if (custoProd.getKey() != 0d) {
				ChaveValorDTO valor = new ChaveValorDTO();
				valor.setChave(custoProd.getValue());
				valor.setValor(ConversaoTipos.converteParaString(custoProd.getKey(), 3, true));

				retorno.add(valor);
			}
		}

		return retorno;
	}

	private List<LegendaDataHoraDTO> getLegendasMateriaPrima(ListaPerdasmpDTO datas) {
		List<LegendaDataHoraDTO> legendas = new ArrayList<LegendaDataHoraDTO>();

		LegendaDataHoraDTO legendaVerde = getLegenda(datas.getCorVerde());
		legendaVerde.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERDE));
		legendas.add(legendaVerde);

		LegendaDataHoraDTO legendaAmarelo = getLegenda(datas.getCorAmarela());
		legendaAmarelo.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_AMARELO));
		legendas.add(legendaAmarelo);

		LegendaDataHoraDTO legendaLaranja = getLegenda(datas.getCorLaranja());
		legendaLaranja.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_LARANJA));
		legendas.add(legendaLaranja);

		LegendaDataHoraDTO legendaVermelho = getLegenda(datas.getCorVermelho());
		legendaVermelho.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERMELHO));
		legendas.add(legendaVermelho);

		return legendas;
	}

	private List<LegendaDataHoraDTO> getLegendasFerramenta(ListaPerdasmpDTO datas) {
		List<LegendaDataHoraDTO> legendas = new ArrayList<LegendaDataHoraDTO>();

		LegendaDataHoraDTO legendaVerde = getLegenda(datas.getCorVerdeRap());
		legendaVerde.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERDE));
		legendas.add(legendaVerde);

		LegendaDataHoraDTO legendaAmarelo = getLegenda(datas.getCorAmarelaRap());
		legendaAmarelo.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_AMARELO));
		legendas.add(legendaAmarelo);

		LegendaDataHoraDTO legendaLaranja = getLegenda(datas.getCorLaranjaRap());
		legendaLaranja.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_LARANJA));
		legendas.add(legendaLaranja);

		LegendaDataHoraDTO legendaVermelho = getLegenda(datas.getCorVermelhoRap());
		legendaVermelho.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERMELHO));
		legendas.add(legendaVermelho);

		return legendas;
	}

	private LegendaDataHoraDTO getLegenda(DatasDTO data) {
		LegendaDataHoraDTO legendaDTO = new LegendaDataHoraDTO();
		if (data == null) {
			return legendaDTO;
		}
		legendaDTO.setDataHoraInicio(DataHoraRN.dateToString(data.getDtIAtendimento(), formatoDataHora));
		legendaDTO.setDataHoraFim(DataHoraRN.dateToString(data.getDtFAtendimento(), formatoDataHora));
		return legendaDTO;
	}

}
