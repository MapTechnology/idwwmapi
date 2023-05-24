package idw.model.rn.web.injet.bi;

import java.awt.Color;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;

import idw.model.IdwFacade;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.web.injet.bi.BiWebInjetRN.TipoAgrupamentoParetoBI;
import idw.model.rn.web.injet.bi.BiWebInjetRN.TipoParetoPerdasBI;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.webservices.dto.GraficoBIParetoDTO;
import idw.webservices.dto.GraficoBIParetoPerdasDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiResumoGanhoPerdaDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.GraficoBIWebParetoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.GraficoBIWebParetoPerdasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.GraficosBIWebParetoPerdasDTO;
import ms.util.ConversaoTipos;

public class BiWebGraficoPerdasInjetRN extends AbstractRN<DAOGenericoInjet> {

	private final String formatoData;
	private final String formatoDataHora;

	private List<MetaIndicadorDTO> listaMetaIndicadores = new ArrayList<MetaIndicadorDTO>();

	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasMaquinasTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosMaquinasTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasProdutosTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosProdutosTodas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasMaquinas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosMaquinas = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIPerdasProdutos = null;
	private List<GraficoBIParetoPerdasDTO> graficoParetoBIGanhosProdutos = null;

	private GraficoBIParetoPerdasDTO itemGraficoProduto = null;
	private GraficoBIParetoPerdasDTO itemGraficoMaquina = null;

	private BiFiltroDTO filtroBI;
	private TipoParetoPerdasBI tipoParetoPerda;

	private String cdRefugo = "";

	private String cdParada = "";
	private String cdAreaResp = "";
	private Boolean isParadasCP;

	private BigDecimal qtGanhoCiclosUB = BigDecimal.ZERO;
	private BigDecimal qtGanhoCiclosGr = BigDecimal.ZERO;
	private BigDecimal qtSaldoCiclosUB = BigDecimal.ZERO;
	private BigDecimal qtSaldoCiclosGr = BigDecimal.ZERO;
	private BigDecimal qtSaldoUB = BigDecimal.ZERO;
	private BigDecimal qtSaldoGr = BigDecimal.ZERO;

	
	private class RegistroPerda {
		String codigo;
		String descricao;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal tempoPar = BigDecimal.ZERO;
		Boolean isParComPeso;
		BigDecimal ganhoCicUB = BigDecimal.ZERO;
		BigDecimal ganhoCicGr = BigDecimal.ZERO;
	}

	// comparator
	private static final Comparator<GraficoBIWebParetoPerdasDTO> comparaQtd = new Comparator<GraficoBIWebParetoPerdasDTO>() {
		@Override
		public int compare(GraficoBIWebParetoPerdasDTO o1, GraficoBIWebParetoPerdasDTO o2) {
			return -(o1.getQtd().compareTo(o2.getQtd()));
		}
	};


	public BiWebGraficoPerdasInjetRN(String formatoData, String formatoDataHora) {
		this(new DAOGenericoInjet(), formatoData, formatoDataHora);
	}

	public BiWebGraficoPerdasInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
	}

	private GraficoBIWebParetoDTO converteGraficoBIParetoDtoToGraficoBIWebParetoDTO(GraficoBIParetoDTO origem) {
		GraficoBIWebParetoDTO retorno = new GraficoBIWebParetoDTO();
		retorno.setMetaIndicadorPerdaProduto(origem.getMetaIndicadorPerdaProduto());
		retorno.setGrafBIMaquinaGanhos(converteGraficoBIParetoPerdasDtoToGraficosBIWebParetoPerdasDTO(origem.getGrafBIMaquinaGanhos()));
		retorno.setGrafBIMaquinaPerdas(converteGraficoBIParetoPerdasDtoToGraficosBIWebParetoPerdasDTO(origem.getGrafBIMaquinaPerdas()));
		retorno.setGrafBIProdutoGanhos(converteGraficoBIParetoPerdasDtoToGraficosBIWebParetoPerdasDTO(origem.getGrafBIProdutoGanhos()));
		retorno.setGrafBIProdutoPerdas(converteGraficoBIParetoPerdasDtoToGraficosBIWebParetoPerdasDTO(origem.getGrafBIProdutoPerdas()));
				
		ordenarDetalheBIPorQtdeDecrescente(retorno.getGrafBIMaquinaGanhos());
		ordenarDetalheBIPorQtdeDecrescente(retorno.getGrafBIMaquinaPerdas());
		ordenarDetalheBIPorQtdeDecrescente(retorno.getGrafBIProdutoGanhos());
		ordenarDetalheBIPorQtdeDecrescente(retorno.getGrafBIProdutoPerdas());
		
		return retorno;
	}

	private GraficosBIWebParetoPerdasDTO converteGraficoBIParetoPerdasDtoToGraficosBIWebParetoPerdasDTO(List<GraficoBIParetoPerdasDTO> origem) {
		GraficosBIWebParetoPerdasDTO retorno = new GraficosBIWebParetoPerdasDTO();
		
		retorno.setGrafBIParetoPerdaUB(new ArrayList<GraficoBIWebParetoPerdasDTO>());
		retorno.setGrafBIParetoPerdaKg(new ArrayList<GraficoBIWebParetoPerdasDTO>());
		retorno.setGrafBIParetoPerdaTon(new ArrayList<GraficoBIWebParetoPerdasDTO>());
		retorno.setGrafBIParetoPerdaUM(new ArrayList<GraficoBIWebParetoPerdasDTO>());

		if (origem != null) {
			for (GraficoBIParetoPerdasDTO itemOrigem : origem) {
				//UB
				GraficoBIWebParetoPerdasDTO itemUB = new GraficoBIWebParetoPerdasDTO();
				itemUB.setCdItemPareto(itemOrigem.getCdItemPareto());
				itemUB.setDsItemPareto(itemOrigem.getDsItemPareto());
				
				itemUB.setIsParadaSemPeso(itemOrigem.getIsParadaSemPeso());				
				if (itemOrigem.getSegTempo() != null) {
					itemUB.setSegTempoFormatado(DataHoraRN.formatSegundosParaHHMMSS(new BigDecimal(itemOrigem.getSegTempo())));	
				} 	
				
				itemUB.setCorIndItem(getCor(new BigDecimal(itemOrigem.getIndItem())));
				itemUB.setIndItem(ConversaoTipos.converteParaString(itemOrigem.getIndItem(), 2));
				itemUB.setQtdItem(ConversaoTipos.converteParaString(itemOrigem.getQtdItem(), 2));
				itemUB.setQtd(new BigDecimal(itemOrigem.getQtdItem()));
	
				
				// peso - Kg
				GraficoBIWebParetoPerdasDTO itemKg = new GraficoBIWebParetoPerdasDTO();
				itemKg.setCdItemPareto(itemOrigem.getCdItemPareto());
				itemKg.setDsItemPareto(itemOrigem.getDsItemPareto());
				
				itemKg.setIsParadaSemPeso(itemOrigem.getIsParadaSemPeso());
				if (itemOrigem.getSegTempo() != null) {
					itemKg.setSegTempoFormatado(DataHoraRN.formatSegundosParaHHMMSS(new BigDecimal(itemOrigem.getSegTempo())));
				}
				
				itemKg.setCorIndItem(getCor(new BigDecimal(itemOrigem.getIndItemEmKg())));
				itemKg.setIndItem(ConversaoTipos.converteParaString(itemOrigem.getIndItemEmKg(), 2));
				itemKg.setQtdItem(ConversaoTipos.converteParaString(itemOrigem.getQtdItemEmKg(), 3));
				itemKg.setQtd(new BigDecimal(itemOrigem.getQtdItemEmKg()));
	
				
				// peso - ton
				GraficoBIWebParetoPerdasDTO itemTon = new GraficoBIWebParetoPerdasDTO();
				itemTon.setCdItemPareto(itemOrigem.getCdItemPareto());
				itemTon.setDsItemPareto(itemOrigem.getDsItemPareto());
				
				itemTon.setIsParadaSemPeso(itemOrigem.getIsParadaSemPeso());
				if (itemOrigem.getSegTempo() != null) {
					itemTon.setSegTempoFormatado(DataHoraRN.formatSegundosParaHHMMSS(new BigDecimal(itemOrigem.getSegTempo())));
				}
				
				itemTon.setCorIndItem(getCor(new BigDecimal(itemOrigem.getIndItemEmTon())));
				itemTon.setIndItem(ConversaoTipos.converteParaString(itemOrigem.getIndItemEmTon(), 2));
				itemTon.setQtdItem(ConversaoTipos.converteParaString(itemOrigem.getQtdItemEmTon(), 3));
				itemTon.setQtd(new BigDecimal(itemOrigem.getQtdItemEmTon()));
	
				// Custo - $$$
				GraficoBIWebParetoPerdasDTO itemUM = new GraficoBIWebParetoPerdasDTO();
				itemUM.setCdItemPareto(itemOrigem.getCdItemPareto());
				itemUM.setDsItemPareto(itemOrigem.getDsItemPareto());
				
				itemUM.setIsParadaSemPeso(itemOrigem.getIsParadaSemPeso());
				if (itemOrigem.getSegTempo() != null) {
					itemUM.setSegTempoFormatado(DataHoraRN.formatSegundosParaHHMMSS(new BigDecimal(itemOrigem.getSegTempo())));
				}
				
				itemUM.setCorIndItem(getCor(new BigDecimal(itemOrigem.getIndItemEmUnidadeMonetaria())));
				itemUM.setIndItem(ConversaoTipos.converteParaString(itemOrigem.getIndItemEmUnidadeMonetaria(), 2));
				itemUM.setQtdItem(ConversaoTipos.converteParaString(itemOrigem.getQtdItemEmUnidadeMonetaria(), 2));
				itemUM.setQtd(new BigDecimal(itemOrigem.getQtdItemEmUnidadeMonetaria()));
	
				retorno.getGrafBIParetoPerdaUB().add(itemUB);
				retorno.getGrafBIParetoPerdaKg().add(itemKg);
				retorno.getGrafBIParetoPerdaTon().add(itemTon);
				retorno.getGrafBIParetoPerdaUM().add(itemUM);
			}
		}

		return retorno;
	}

	private String getCor(BigDecimal valor) {
		MetaIndicadorDTO indicadorSelecionado = listaMetaIndicadores.get(DetalheMonitorizacaoWebIndicadorInjetRN.IndicadoresValorPadrao.INDICE_DE_PERDA_PRODUTO.ordinal());

		BigDecimal maiorValorMeta;
		BigDecimal menorValorMeta;
		boolean isPossuiValorMeta = !(indicadorSelecionado.getValorLegendaMeta() == null || indicadorSelecionado.getValorLegendaMeta().equals(""));

		if (indicadorSelecionado.isMelhorAcimaMeta()) {
			if (isPossuiValorMeta) {
				maiorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaMeta());
			} else {
				maiorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaSuperior());
			}
			menorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaInferior());

		} else {

			maiorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaSuperior());
			if (isPossuiValorMeta) {
				menorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaMeta());
			} else {
				menorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaInferior());
			}
		}

		Color corSuperior = indicadorSelecionado.isMelhorAcimaMeta() ? DetalheMonitorizacaoWebIndicadorInjetRN.COR_INDICADOR_SUPERIOR : DetalheMonitorizacaoWebIndicadorInjetRN.COR_INDICADOR_INFERIOR;
		Color corInferior = indicadorSelecionado.isMelhorAcimaMeta() ? DetalheMonitorizacaoWebIndicadorInjetRN.COR_INDICADOR_INFERIOR : DetalheMonitorizacaoWebIndicadorInjetRN.COR_INDICADOR_SUPERIOR;

		boolean isValorEhMaiorQueOIndicadorSuperior = valor.compareTo(maiorValorMeta) == 1;
		if (isValorEhMaiorQueOIndicadorSuperior) {
			return Cor.transformarParaCodigoHexadecimal(corSuperior);
		}

		boolean isValorEhMenorQueOIndicadorInferior = valor.compareTo(menorValorMeta) == -1;
		if (isValorEhMenorQueOIndicadorInferior) {
			return Cor.transformarParaCodigoHexadecimal(corInferior);
		}

		return Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorInjetRN.COR_INDICADOR_META);
	}

	public GraficoBIWebParetoDTO getGrafBIParetoPerdas(
			BiFiltroDTO filtroBI) {

		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), formatoData, formatoDataHora);
		this.filtroBI = biRN.filtroBiTransformado(filtroBI);
		this.tipoParetoPerda = TipoParetoPerdasBI.PARETO_TODAS;
		this.isParadasCP = true;
		GraficoBIWebParetoDTO graficos = getGrafBIParetoPerdasDet();

		return graficos;
	}

	public GraficoBIWebParetoDTO getGrafBIParetoPerdasRefugo(
			BiFiltroDTO filtroBI,
			String cdRefugo) {

		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), formatoData, formatoDataHora);
		this.filtroBI = biRN.filtroBiTransformado(filtroBI);
		this.cdRefugo = cdRefugo;
		this.tipoParetoPerda = TipoParetoPerdasBI.PARETO_REFUGOS;

		GraficoBIWebParetoDTO graficos = getGrafBIParetoPerdasDet();

		return graficos;
	}

	public GraficoBIWebParetoDTO getGrafBIParetoPerdasParada(
			BiFiltroDTO filtroBI,
			Boolean isParadasCP,
			String cdAreaResp,
			String cdParada) {

		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), formatoData, formatoDataHora);
		this.filtroBI = biRN.filtroBiTransformado(filtroBI);
		this.cdParada = cdParada;
		this.cdAreaResp = cdAreaResp;
		this.tipoParetoPerda = TipoParetoPerdasBI.PARETO_PARADAS;
		this.isParadasCP = isParadasCP;

		GraficoBIWebParetoDTO graficos = getGrafBIParetoPerdasDet();

		return graficos;
	}

	public GraficoBIWebParetoDTO getGrafBIParetoPerdasPCI(
			BiFiltroDTO filtroBI) {

		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), formatoData, formatoDataHora);
		this.filtroBI = biRN.filtroBiTransformado(filtroBI);
		this.tipoParetoPerda = TipoParetoPerdasBI.PARETO_PCI;

		GraficoBIWebParetoDTO graficos = getGrafBIParetoPerdasDet();

		return graficos;
	}

	private GraficoBIWebParetoDTO getGrafBIParetoPerdasDet() {
		GraficoBIParetoDTO graficos = new GraficoBIParetoDTO();
		GraficoBIWebParetoDTO graficosWeb = new GraficoBIWebParetoDTO();

		// recupera metas dos indicadores
		listaMetaIndicadores = DetalheMonitorizacaoWebIndicadorInjetRN.getMetaIndicadores(getDao());
		graficos.setMetaIndicadorPerdaProduto(listaMetaIndicadores.get(DetalheMonitorizacaoWebIndicadorInjetRN.IndicadoresValorPadrao.INDICE_DE_PERDA_PRODUTO.ordinal()));

		prepararGraficoPerdasBI();

		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_TODAS) {
			graficos.setGrafBIMaquinaPerdas(graficoParetoBIPerdasMaquinasTodas);
			graficos.setGrafBIMaquinaGanhos(graficoParetoBIGanhosMaquinasTodas);
			graficos.setGrafBIProdutoPerdas(graficoParetoBIPerdasProdutosTodas);
			graficos.setGrafBIProdutoGanhos(graficoParetoBIGanhosProdutosTodas);
			
			

		} else {

			if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_CICLOS) {
				graficos.setGrafBIMaquinaPerdas(graficoParetoBIPerdasMaquinas);
				graficos.setGrafBIMaquinaGanhos(graficoParetoBIGanhosMaquinas);
				graficos.setGrafBIProdutoPerdas(graficoParetoBIPerdasProdutos);
				graficos.setGrafBIProdutoGanhos(graficoParetoBIGanhosProdutos);
				
			} else {
				graficos.setGrafBIMaquinaPerdas(graficoParetoBIPerdasMaquinas);
				graficos.setGrafBIMaquinaGanhos(null);
				graficos.setGrafBIProdutoPerdas(graficoParetoBIPerdasProdutos);
				graficos.setGrafBIProdutoGanhos(null);
			}
		}
		
		graficosWeb = converteGraficoBIParetoDtoToGraficoBIWebParetoDTO(graficos);
		
		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_TODAS) {
			BiResumoGanhoPerdaDTO resumo = new BiResumoGanhoPerdaDTO();
			BigDecimal qtPerdaUB = AritmeticaUtil.somar(qtSaldoUB, Math.abs(qtGanhoCiclosUB.doubleValue())); 
			BigDecimal qtPerdaGr = AritmeticaUtil.somar(qtSaldoGr, Math.abs(qtGanhoCiclosGr.doubleValue()));
			
			resumo.setGanhoUB(ConversaoTipos.converteParaString(qtGanhoCiclosUB, 2));
			resumo.setPerdaUB(ConversaoTipos.converteParaString(qtPerdaUB, 2));
			resumo.setSaldoUB(ConversaoTipos.converteParaString(qtSaldoUB, 2));

			resumo.setGanhoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtGanhoCiclosGr, BiWebInjetRN.DIVISOR_KG), 3));
			resumo.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtPerdaGr, BiWebInjetRN.DIVISOR_KG), 3));
			resumo.setSaldoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtSaldoGr, BiWebInjetRN.DIVISOR_KG), 3));

			resumo.setGanhoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtGanhoCiclosGr, BiWebInjetRN.DIVISOR_TON), 3));
			resumo.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtPerdaGr, BiWebInjetRN.DIVISOR_TON), 3));
			resumo.setSaldoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtSaldoGr, BiWebInjetRN.DIVISOR_TON), 3));
			
			graficosWeb.setResumoTodas(resumo);
		} 
		
		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_CICLOS) {
			BiResumoGanhoPerdaDTO resumo = new BiResumoGanhoPerdaDTO();
			BigDecimal qtPerdaCiclosUB = AritmeticaUtil.somar(qtSaldoCiclosUB, Math.abs(qtGanhoCiclosUB.doubleValue()));
			BigDecimal qtPerdaCiclosGr = AritmeticaUtil.somar(qtSaldoCiclosGr, Math.abs(qtGanhoCiclosGr.doubleValue()));
			
			resumo.setGanhoUB(ConversaoTipos.converteParaString(qtGanhoCiclosUB, 2));
			resumo.setPerdaUB(ConversaoTipos.converteParaString(qtPerdaCiclosUB, 2));
			resumo.setSaldoUB(ConversaoTipos.converteParaString(qtSaldoCiclosUB, 2));

			resumo.setGanhoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtGanhoCiclosGr, BiWebInjetRN.DIVISOR_KG), 3));
			resumo.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtPerdaCiclosGr, BiWebInjetRN.DIVISOR_KG), 3));
			resumo.setSaldoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtSaldoCiclosGr, BiWebInjetRN.DIVISOR_KG), 3));

			resumo.setGanhoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtGanhoCiclosGr, BiWebInjetRN.DIVISOR_TON), 3));
			resumo.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtPerdaCiclosGr, BiWebInjetRN.DIVISOR_TON), 3));
			resumo.setSaldoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(qtSaldoCiclosGr, BiWebInjetRN.DIVISOR_TON), 3));
			
			graficosWeb.setResumoCiclo(resumo);
		}
		

		return graficosWeb;

	}

	public GraficoBIWebParetoDTO getGrafBIParetoPerdasGanhosCiclo(
			BiFiltroDTO filtroBI) {

		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), formatoData, formatoDataHora);
		this.filtroBI = biRN.filtroBiTransformado(filtroBI);
		this.tipoParetoPerda = TipoParetoPerdasBI.PARETO_CICLOS;

		GraficoBIWebParetoDTO graficos = getGrafBIParetoPerdasDet();

		return graficos;
	}

	private void prepararGraficoPerdasBI() {
		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_TODAS) {
			prepararGraficoPerdasBITodas();
			return;
		}

		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_CICLOS) {
			prepararGraficoPerdasBICiclos();
			return;
		}

		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_PARADAS) {
			prepararGraficoPerdasBIParadas();
			return;
		}

		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_REFUGOS) {
			prepararGraficoPerdasBIRefugos();
			return;
		}

		if (this.tipoParetoPerda == TipoParetoPerdasBI.PARETO_PCI) {
			prepararGraficoPerdasBIPCI();
			return;
		}

	}

	private void ordenarDetalheBIPorQtdeDecrescente(GraficosBIWebParetoPerdasDTO graficos) {
		Collections.sort(graficos.getGrafBIParetoPerdaUB(), comparaQtd);
		Collections.sort(graficos.getGrafBIParetoPerdaKg(), comparaQtd);
		Collections.sort(graficos.getGrafBIParetoPerdaTon(), comparaQtd);
		Collections.sort(graficos.getGrafBIParetoPerdaUM(), comparaQtd);
	}

	private void prepararGraficoPerdasBITodas() {
		graficoParetoBIPerdasProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutosTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();

		qtSaldoUB = BigDecimal.ZERO;
		qtSaldoGr = BigDecimal.ZERO;
		
		prepararGraficoPerdasBICiclos();
		atualizarGraficoPerdasBITodas();

		prepararGraficoPerdasBIParadas();
		atualizarGraficoPerdasBITodas();

		prepararGraficoPerdasBIRefugos();
		atualizarGraficoPerdasBITodas();

		prepararGraficoPerdasBIPCI();
		atualizarGraficoPerdasBITodas();

		atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasProdutosTodas, graficoParetoBIGanhosProdutosTodas, false, false);
		atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasMaquinasTodas, graficoParetoBIGanhosMaquinasTodas, true, false);

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutosTodas,
				TipoAgrupamentoParetoBI.PARETO_BI_PRODUTOS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosProdutosTodas,
				TipoAgrupamentoParetoBI.PARETO_BI_PRODUTOS);

		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinasTodas,
				TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosMaquinasTodas,
				TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS);
	}

	@SuppressWarnings("unchecked")
	private void prepararGraficoPerdasBICiclos() {
		String strSQL = "";

		int _codigo = 0;
		int _descricao = _codigo + 1;

		int _qtdUB = _descricao + 1;
		int _qtdGr = _qtdUB + 1;
		int _qtdUM = _qtdGr + 1;
		int _qtdGanhoUB = _qtdUM + 1;
		int _qtdGanhoGr = _qtdGanhoUB + 1;

		BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
		
		qtGanhoCiclosUB = BigDecimal.ZERO;
		qtGanhoCiclosGr = BigDecimal.ZERO;
		qtSaldoCiclosUB = BigDecimal.ZERO;
		qtSaldoCiclosGr = BigDecimal.ZERO;
		
		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		

		/// perdas por produto ////
		List<Object> lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasGanhosCicloProduto();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosCiclosPCINaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUM]);

			registro.ganhoCicUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGanhoUB]);
			registro.ganhoCicGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGanhoGr]);
						
			qtPerdasCicloKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPerdasCicloTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			qtGanhoCiclosUB = AritmeticaUtil.somar(qtGanhoCiclosUB, registro.ganhoCicUB);
			qtGanhoCiclosGr = AritmeticaUtil.somar(qtGanhoCiclosGr, registro.ganhoCicGr);
			qtSaldoCiclosUB = AritmeticaUtil.somar(qtSaldoCiclosUB, registro.perdaUB);
			qtSaldoCiclosGr = AritmeticaUtil.somar(qtSaldoCiclosGr, registro.perdaGr);
			

			itemGraficoProduto = new GraficoBIParetoPerdasDTO();
			itemGraficoProduto.setIdItemPareto(0L);
			itemGraficoProduto.setCdItemPareto(registro.codigo);
			itemGraficoProduto.setDsItemPareto(registro.descricao);

			if (registro.perdaUB.doubleValue() > 0d) {
				itemGraficoProduto.setQtdItem(registro.perdaUB.doubleValue());
				itemGraficoProduto.setQtdItemEmKg(qtPerdasCicloKg.doubleValue());
				itemGraficoProduto.setQtdItemEmTon(qtPerdasCicloTon.doubleValue());
				itemGraficoProduto.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());

				atualizarPerdasBI(itemGraficoProduto, graficoParetoBIPerdasProdutos);
			} else {
				itemGraficoProduto.setQtdItem(registro.perdaUB.abs().doubleValue());
				itemGraficoProduto.setQtdItemEmKg(qtPerdasCicloKg.abs().doubleValue());
				itemGraficoProduto.setQtdItemEmTon(qtPerdasCicloTon.abs().doubleValue());
				itemGraficoProduto.setQtdItemEmUnidadeMonetaria(registro.perdaUM.abs().doubleValue());

				atualizarGanhosBI(itemGraficoProduto, graficoParetoBIGanhosProdutos);
			}
		}

		/// perdas por pt ////
		lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasGanhosCicloMaquina();
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosCiclosPCINaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUM]);

			qtPerdasCicloKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPerdasCicloTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
			itemGraficoMaquina.setIdItemPareto(0L);
			itemGraficoMaquina.setCdItemPareto(registro.codigo);
			itemGraficoMaquina.setDsItemPareto(registro.descricao);

			if (registro.perdaUB.doubleValue() > 0d) {
				itemGraficoMaquina.setQtdItem(registro.perdaUB.doubleValue());
				itemGraficoMaquina.setQtdItemEmKg(qtPerdasCicloKg.doubleValue());
				itemGraficoMaquina.setQtdItemEmTon(qtPerdasCicloTon.doubleValue());
				itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());

				atualizarPerdasBI(itemGraficoMaquina, graficoParetoBIPerdasMaquinas);
			} else {
				itemGraficoMaquina.setQtdItem(registro.perdaUB.abs().doubleValue());
				itemGraficoMaquina.setQtdItemEmKg(qtPerdasCicloKg.abs().doubleValue());
				itemGraficoMaquina.setQtdItemEmTon(qtPerdasCicloTon.abs().doubleValue());
				itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(registro.perdaUM.abs().doubleValue());

				atualizarGanhosBI(itemGraficoMaquina, graficoParetoBIGanhosMaquinas);
			}
		}

		atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasProdutos, graficoParetoBIGanhosProdutos, false, true);
		atualizarParetosPerdaGanhoInjet(graficoParetoBIPerdasMaquinas, graficoParetoBIGanhosMaquinas, true, true);

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos, TipoAgrupamentoParetoBI.PARETO_BI_PRODUTOS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosProdutos, TipoAgrupamentoParetoBI.PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas, TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS);
		calcularIndiceGanhosBI(graficoParetoBIGanhosMaquinas, TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS);
	}

	private String getConsultaPerdasRefugoProduto() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT f.cdproduto, f.dsproduto, ");
		strSQL = strSQL.concat("       SUM(a.qtrefugada / dc.divisorUB) as qtdref, ");
		strSQL = strSQL.concat("       SUM((a.qtrefugada / dc.divisorUB) * e.pbrutomedio) as qtdrefGr, ");
		strSQL = strSQL.concat(
				"       SUM((a.qtrefugada / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdrefUM ");

		// tabelas
		strSQL = strSQL.concat("  FROM ijrearef a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru AND e.cdidentificacao = a.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = e.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dthrirefugo BETWEEN ht.dthrini AND ht.dthrfim ");
		strSQL = strSQL.concat("   AND (a.lcancelado = 0 OR a.lcancelado IS NULL) ");

		if (!this.cdRefugo.equals("")) {
			strSQL = strSQL.concat("   AND a.cdrefugo = :cdrefugo ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND ht.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND e.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY f.cdproduto, f.dsproduto ");

		return strSQL;
	}

	private String getConsultaPerdasRefugoMaquina() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, b.cdidentific, ");
		strSQL = strSQL.concat("       SUM(a.qtrefugada / dc.divisorUB) as qtdref, ");
		strSQL = strSQL.concat("       SUM((a.qtrefugada / dc.divisorUB) * e.pbrutomedio) as qtdrefGr, ");
		strSQL = strSQL.concat(
				"       SUM((a.qtrefugada / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdrefUM ");

		// tabelas
		strSQL = strSQL.concat("  FROM ijrearef a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru AND e.cdidentificacao = a.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = e.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dthrirefugo BETWEEN ht.dthrini AND ht.dthrfim ");
		strSQL = strSQL.concat("   AND (a.lcancelado = 0 OR a.lcancelado IS NULL) ");

		if (!this.cdRefugo.equals("")) {
			strSQL = strSQL.concat("   AND a.cdrefugo = :cdrefugo ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND ht.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND e.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY b.cdinjestendido, b.cdidentific ");

		return strSQL;
	}

	private String getConsultaPerdasParadaProduto() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT f.cdproduto, f.dsproduto, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat(
				"       SUM(((a.tmpparadas / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) as qtdperdasparCPUB,  ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadas / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * e.pbrutomedio) as qtdperdasparCPGr, ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadas / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasparCPUM, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat(
				"       SUM(((a.tmpparadassempeso / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) as qtdperdasparSPUB, ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadassempeso / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * e.pbrutomedio) as qtdperdasparSPGr, ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadassempeso / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasparSPUM ");

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL
				.concat("  JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = e.cdproduto) ");

		// area resp
		if (!this.cdAreaResp.equals("")) {
			strSQL = strSQL.concat(" JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		}

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!this.cdParada.equals("")) {
			strSQL = strSQL.concat("   AND a.cdParada = :cdparada ");
		}

		if (!this.cdAreaResp.equals("")) {
			strSQL = strSQL.concat("   AND p.cdArea = :cdarea ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND e.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY f.cdproduto, f.dsproduto ");

		return strSQL;
	}

	private String getConsultaPerdasParadaMaquinaQtds() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, b.cdidentific, ");
		strSQL = strSQL.concat(
				"       SUM(((a.tmpparadas / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) as qtdperdasparCPUB,  ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadas / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * e.pbrutomedio) as qtdperdasparCPGr, ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadas / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasparCPUM, ");
		strSQL = strSQL.concat(
				"       SUM(((a.tmpparadassempeso / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) as qtdperdasparSPUB, ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadassempeso / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * e.pbrutomedio) as qtdperdasparSPGr, ");
		strSQL = strSQL.concat(
				"       SUM((((a.tmpparadassempeso / d.ciclopadrao) * (e.qtcavativas * d.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasparSPUM ");

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL
				.concat("  JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = e.cdproduto) ");

		// area resp
		if (!this.cdAreaResp.equals("")) {
			strSQL = strSQL.concat(" JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		}

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!this.cdParada.equals("")) {
			strSQL = strSQL.concat("   AND a.cdParada = :cdparada ");
		}

		if (!this.cdAreaResp.equals("")) {
			strSQL = strSQL.concat("   AND p.cdArea = :cdarea ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		strSQL = strSQL.concat(" GROUP BY b.cdinjestendido, b.cdidentific ");

		return strSQL;

	}

	private String getConsultaPerdasParadaMaquinaTempos() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, b.cdidentific, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpparadasSP ");

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsTUR a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");

		// area resp
		if (!this.cdAreaResp.equals("")) {
			strSQL = strSQL.concat(" JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		}

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!this.cdParada.equals("")) {
			strSQL = strSQL.concat("   AND a.cdParada = :cdparada ");
		}

		if (!this.cdAreaResp.equals("")) {
			strSQL = strSQL.concat("   AND p.cdArea = :cdarea ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		strSQL = strSQL.concat(" GROUP BY b.cdinjestendido, b.cdidentific ");

		return strSQL;
	}

	private String getConsultaPerdasGanhosCicloProduto() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT f.cdproduto, f.dsproduto, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmo) as qtdperdasritmoUB, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmoGr) as qtdperdasritmoGr, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmo * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasritmoUM, ");
		strSQL = strSQL.concat("       SUM(CASE WHEN a.qtdritmo < 0 THEN a.qtdritmo ELSE 0 END) as qtdperdasGanhoUB, ");
		strSQL = strSQL.concat("       SUM(CASE WHEN a.qtdritmoGr < 0 THEN a.qtdritmoGr ELSE 0 END) as qtdperdasGanhoGr ");
		
		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = a.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND a.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY f.cdproduto, f.dsproduto ");
		strSQL = strSQL.concat(" HAVING SUM(a.qtdritmo) <> 0 ");

		return strSQL;
	}

	private String getConsultaPerdasGanhosCicloMaquina() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, b.cdidentific, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmo) as qtdperdasritmoUB, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmoGr) as qtdperdasritmoGr, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmo * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasritmoUM ");

		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = a.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND a.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY b.cdinjestendido, b.cdidentific ");
		strSQL = strSQL.concat(" HAVING SUM(a.qtdritmo) <> 0 ");

		return strSQL;
	}

	private String getConsultaPerdasPCIProduto() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT f.cdproduto, f.dsproduto, ");
		strSQL = strSQL.concat("       SUM(a.qtdPCI) as qtdPCIUB, ");
		strSQL = strSQL.concat("       SUM(a.qtdPCIGr) as qtdPCIGr, ");
		strSQL = strSQL.concat("       SUM(a.qtdPCI * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPCIUM ");

		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = a.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND a.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY f.cdproduto, f.dsproduto ");
		strSQL = strSQL.concat(" HAVING SUM(a.qtdPCI) > 0 ");

		return strSQL;
	}

	private String getConsultaPerdasPCIMaquina() {
		String strSQL = "";

		strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, b.cdidentific, ");
		strSQL = strSQL.concat("       SUM(a.qtdPCI) as qtdPCIUB, ");
		strSQL = strSQL.concat("       SUM(a.qtdPCIGr) as qtdPCIGr, ");
		strSQL = strSQL.concat("       SUM(a.qtdPCI * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPCIUM ");

		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = a.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND a.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY b.cdinjestendido, b.cdidentific ");
		strSQL = strSQL.concat(" HAVING SUM(a.qtdPCI) > 0 ");

		return strSQL;
	}

	@SuppressWarnings("unchecked")
	private void prepararGraficoPerdasBIParadas() {
		String strSQL = "";

		int _codigo = 0;
		int _descricao = _codigo + 1;

		int _tempoParCP = _descricao + 1;
		int _qtdUBCP = _tempoParCP + 1;
		int _qtdGrCP = _qtdUBCP + 1;
		int _qtdUMCP = _qtdGrCP + 1;

		int _tempoParSP = _qtdUMCP + 1;
		int _qtdUBSP = _tempoParSP + 1;
		int _qtdGrSP = _qtdUBSP + 1;
		int _qtdUMSP = _qtdGrSP + 1;

		int _tempoParCPMaq = _descricao + 1;
		int _tempoParSPMaq = _tempoParCPMaq + 1;

		int _qtdUBCPm = _descricao + 1;
		int _qtdGrCPm = _qtdUBCPm + 1;
		int _qtdUMCPm = _qtdGrCPm + 1;

		int _qtdUBSPm = _qtdUMCPm + 1;
		int _qtdGrSPm = _qtdUBSPm + 1;
		int _qtdUMSPm = _qtdGrSPm + 1;

		BigDecimal qtPcsParKg = BigDecimal.ZERO;
		BigDecimal qtPcsParTon = BigDecimal.ZERO;

		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();

		/// perdas por produto ////
		List<Object> lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasParadaProduto();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosParadaNaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			RegistroPerda registroCP = new RegistroPerda();
			registroCP.tempoPar = ConversaoTipos.converterParaBigDecimal(registroLido[_tempoParCP]);
			registroCP.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUBCP]);
			registroCP.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGrCP]);
			registroCP.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUMCP]);

			RegistroPerda registroSP = new RegistroPerda();
			registroSP.tempoPar = ConversaoTipos.converterParaBigDecimal(registroLido[_tempoParSP]);
			registroSP.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUBSP]);
			registroSP.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGrSP]);
			registroSP.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUMSP]);

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];

			if (this.isParadasCP) {
				registro.tempoPar = registroCP.tempoPar;
				registro.perdaUB = registroCP.perdaUB;
				registro.perdaGr = registroCP.perdaGr;
				registro.perdaUM = registroCP.perdaUM;
			} else {
				registro.tempoPar = registroSP.tempoPar;
				registro.perdaUB = registroSP.perdaUB;
				registro.perdaGr = registroSP.perdaGr;
				registro.perdaUM = registroSP.perdaUM;
			}

			itemGraficoProduto = new GraficoBIParetoPerdasDTO();

			itemGraficoProduto.setIdItemPareto(0L);
			itemGraficoProduto.setCdItemPareto(registro.codigo);
			itemGraficoProduto.setDsItemPareto(registro.descricao);

			if (registroSP.tempoPar.doubleValue() > 0d) {
				itemGraficoProduto.setIsParadaSemPeso(true);
			} else {
				itemGraficoProduto.setIsParadaSemPeso(false);
			}

			qtPcsParKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPcsParTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			if (registro.perdaUB.doubleValue() > 0d) {
				itemGraficoProduto.setSegTempo(registro.tempoPar.doubleValue());
				itemGraficoProduto.setQtdItem(registro.perdaUB.doubleValue());
				itemGraficoProduto.setQtdItemEmKg(qtPcsParKg.doubleValue());
				itemGraficoProduto.setQtdItemEmTon(qtPcsParTon.doubleValue());
				itemGraficoProduto.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());

				atualizarPerdasBI(itemGraficoProduto, graficoParetoBIPerdasProdutos);
			}
			
			qtSaldoUB = AritmeticaUtil.somar(qtSaldoUB, registro.perdaUB);
			qtSaldoGr = AritmeticaUtil.somar(qtSaldoGr, registro.perdaGr);
			
		}

		/// perdas por maquina //// -- não pode misturar tempo e qtd
		Map<String, RegistroPerda> mapPerdaMaq = new HashMap<String, RegistroPerda>();

		// quantidades
		lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasParadaMaquinaQtds();
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosParadaNaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			RegistroPerda registroCP = new RegistroPerda();
			registroCP.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUBCPm]);
			registroCP.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGrCPm]);
			registroCP.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUMCPm]);

			RegistroPerda registroSP = new RegistroPerda();
			registroSP.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUBSPm]);
			registroSP.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGrSPm]);
			registroSP.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUMSPm]);

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];

			if (this.isParadasCP) {
				registro.perdaUB = registroCP.perdaUB;
				registro.perdaGr = registroCP.perdaGr;
				registro.perdaUM = registroCP.perdaUM;
				registro.isParComPeso = true;
			} else {
				registro.perdaUB = registroSP.perdaUB;
				registro.perdaGr = registroSP.perdaGr;
				registro.perdaUM = registroSP.perdaUM;
				registro.isParComPeso = false;
			}

			mapPerdaMaq.put(registro.codigo, registro);
		}

		// tempos
		lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasParadaMaquinaTempos();
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosParadaNaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			RegistroPerda registroCP = new RegistroPerda();
			registroCP.tempoPar = ConversaoTipos.converterParaBigDecimal(registroLido[_tempoParCPMaq]);

			RegistroPerda registroSP = new RegistroPerda();
			registroSP.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_tempoParSPMaq]);

			registro = mapPerdaMaq.get((String) registroLido[_codigo]);

			if (registro.isParComPeso) {
				registro.tempoPar = registroCP.tempoPar;
			} else {
				registro.tempoPar = registroSP.tempoPar;
			}

			mapPerdaMaq.put(registro.codigo, registro);
		}

		Set<String> listaMaquinas = mapPerdaMaq.keySet();
		for (String keyMaq : listaMaquinas) {
			RegistroPerda registro = new RegistroPerda();
			registro = mapPerdaMaq.get(keyMaq);

			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();

			itemGraficoMaquina.setIdItemPareto(0L);
			itemGraficoMaquina.setCdItemPareto(registro.codigo);
			itemGraficoMaquina.setDsItemPareto(registro.descricao);

			if (registro.tempoPar.doubleValue() > 0d && !registro.isParComPeso) {
				itemGraficoMaquina.setIsParadaSemPeso(true);
			} else {
				itemGraficoMaquina.setIsParadaSemPeso(false);
			}

			qtPcsParKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPcsParTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			if (registro.perdaUB.doubleValue() > 0d) {
				itemGraficoMaquina.setSegTempo(registro.tempoPar.doubleValue());
				itemGraficoMaquina.setQtdItem(registro.perdaUB.doubleValue());
				itemGraficoMaquina.setQtdItemEmKg(qtPcsParKg.doubleValue());
				itemGraficoMaquina.setQtdItemEmTon(qtPcsParTon.doubleValue());
				itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());
			}

			atualizarPerdasBI(itemGraficoMaquina, graficoParetoBIPerdasMaquinas);
		}

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos, TipoAgrupamentoParetoBI.PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas, TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS);
	}

	private SQLQuery setFiltrosCiclosPCINaQuery(SQLQuery q) {		
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());


		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}

		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}

		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}

		return q;
	}

	private SQLQuery setFiltrosRefugoNaQuery(SQLQuery q) {
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());

		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}

		if (!this.cdRefugo.equals("")) {
			q.setString("cdrefugo", this.cdRefugo);
		}

		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}

		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}

		return q;
	}

	private SQLQuery setFiltrosParadaNaQuery(SQLQuery q) { 
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());


		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}

		if (!this.cdParada.equals("")) {
			q.setString("cdparada", this.cdParada);
		}

		if (!this.cdAreaResp.equals("")) {
			q.setString("cdarea", this.cdAreaResp);
		}

		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}

		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}

		return q;
	}

	@SuppressWarnings("unchecked")
	private void prepararGraficoPerdasBIRefugos() {
		String strSQL = "";

		int _codigo = 0;
		int _descricao = _codigo + 1;

		int _qtdUB = _descricao + 1;
		int _qtdGr = _qtdUB + 1;
		int _qtdUM = _qtdGr + 1;

		BigDecimal qtPcsRefKg = BigDecimal.ZERO;
		BigDecimal qtPcsRefTon = BigDecimal.ZERO;

		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();

		/// perdas por produto ////
		List<Object> lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasRefugoProduto();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosRefugoNaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUM]);

			itemGraficoProduto = new GraficoBIParetoPerdasDTO();

			itemGraficoProduto.setIdItemPareto(0L);
			itemGraficoProduto.setCdItemPareto(registro.codigo);
			itemGraficoProduto.setDsItemPareto(registro.descricao);

			qtPcsRefKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPcsRefTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			itemGraficoProduto.setQtdItem(registro.perdaUB.doubleValue());
			itemGraficoProduto.setQtdItemEmKg(qtPcsRefKg.doubleValue());
			itemGraficoProduto.setQtdItemEmTon(qtPcsRefTon.doubleValue());
			itemGraficoProduto.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());

			atualizarPerdasBI(itemGraficoProduto, graficoParetoBIPerdasProdutos);
			
			qtSaldoUB = AritmeticaUtil.somar(qtSaldoUB, registro.perdaUB);
			qtSaldoGr = AritmeticaUtil.somar(qtSaldoGr, registro.perdaGr);
		}

		/// perdas por pt ////
		lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasRefugoMaquina();
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosRefugoNaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUM]);

			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();

			itemGraficoMaquina.setIdItemPareto(0L);
			itemGraficoMaquina.setCdItemPareto(registro.codigo);
			itemGraficoMaquina.setDsItemPareto(registro.descricao);

			qtPcsRefKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPcsRefTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			itemGraficoMaquina.setQtdItem(registro.perdaUB.doubleValue());
			itemGraficoMaquina.setQtdItemEmKg(qtPcsRefKg.doubleValue());
			itemGraficoMaquina.setQtdItemEmTon(qtPcsRefTon.doubleValue());
			itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());

			atualizarPerdasBI(itemGraficoMaquina, graficoParetoBIPerdasMaquinas);
		}

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos, TipoAgrupamentoParetoBI.PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas, TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS);

	}

	@SuppressWarnings("unchecked")
	private void prepararGraficoPerdasBIPCI() {
		String strSQL = "";

		int _codigo = 0;
		int _descricao = _codigo + 1;

		int _qtdUB = _descricao + 1;
		int _qtdGr = _qtdUB + 1;
		int _qtdUM = _qtdGr + 1;

		BigDecimal qtPcsRefKg = BigDecimal.ZERO;
		BigDecimal qtPcsRefTon = BigDecimal.ZERO;

		graficoParetoBIPerdasProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosProdutos = new ArrayList<GraficoBIParetoPerdasDTO>();
		graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();

		/// perdas por produto ////
		List<Object> lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasPCIProduto();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosCiclosPCINaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUM]);

			itemGraficoProduto = new GraficoBIParetoPerdasDTO();

			itemGraficoProduto.setIdItemPareto(0L);
			itemGraficoProduto.setCdItemPareto(registro.codigo);
			itemGraficoProduto.setDsItemPareto(registro.descricao);

			qtPcsRefKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPcsRefTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			itemGraficoProduto.setQtdItem(registro.perdaUB.doubleValue());
			itemGraficoProduto.setQtdItemEmKg(qtPcsRefKg.doubleValue());
			itemGraficoProduto.setQtdItemEmTon(qtPcsRefTon.doubleValue());
			itemGraficoProduto.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());

			atualizarPerdasBI(itemGraficoProduto, graficoParetoBIPerdasProdutos);
			
			qtSaldoUB = AritmeticaUtil.somar(qtSaldoUB, registro.perdaUB);
			qtSaldoGr = AritmeticaUtil.somar(qtSaldoGr, registro.perdaGr);
		}

		/// perdas por pt ////
		lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasPCIMaquina();
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosCiclosPCINaQuery(q);

		lista = q.list();
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.codigo = (String) registroLido[_codigo];
			registro.descricao = (String) registroLido[_descricao];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdUM]);

			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();

			itemGraficoMaquina.setIdItemPareto(0L);
			itemGraficoMaquina.setCdItemPareto(registro.codigo);
			itemGraficoMaquina.setDsItemPareto(registro.descricao);

			qtPcsRefKg = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_KG);
			qtPcsRefTon = AritmeticaUtil.dividir(registro.perdaGr, BiWebInjetRN.DIVISOR_TON);

			itemGraficoMaquina.setQtdItem(registro.perdaUB.doubleValue());
			itemGraficoMaquina.setQtdItemEmKg(qtPcsRefKg.doubleValue());
			itemGraficoMaquina.setQtdItemEmTon(qtPcsRefTon.doubleValue());
			itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(registro.perdaUM.doubleValue());

			atualizarPerdasBI(itemGraficoMaquina, graficoParetoBIPerdasMaquinas);
		}

		calcularIndicePerdasBI(graficoParetoBIPerdasProdutos, TipoAgrupamentoParetoBI.PARETO_BI_PRODUTOS);
		calcularIndicePerdasBI(graficoParetoBIPerdasMaquinas, TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS);

	}

	private void atualizarGraficoPerdasBITodas() {
		Boolean existeItem = false;

		// perdas por produto
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIPerdasProdutos) {
			itemGraficoProduto = new GraficoBIParetoPerdasDTO();
			itemGraficoProduto.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoProduto.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoProduto.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoProduto.setIndItem(itemgraf.getIndItem());
			itemGraficoProduto.setQtdItem(itemgraf.getQtdItem());

			itemGraficoProduto.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoProduto.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoProduto.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoProduto.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoProduto.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoProduto.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica produto
			existeItem = false;
			if (graficoParetoBIPerdasProdutosTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIPerdasProdutosTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoProduto.getQtdItem());

						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoProduto.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoProduto.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoProduto
												.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIPerdasProdutosTodas.add(itemGraficoProduto);
			}
		}

		// perdas por mÃ¡quina
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIPerdasMaquinas) {
			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
			itemGraficoMaquina.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoMaquina.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoMaquina.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoMaquina.setIndItem(itemgraf.getIndItem());
			itemGraficoMaquina.setQtdItem(itemgraf.getQtdItem());

			itemGraficoMaquina.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoMaquina.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoMaquina.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoMaquina.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoMaquina.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica mÃ¡quina
			existeItem = false;
			if (graficoParetoBIPerdasMaquinasTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIPerdasMaquinasTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoMaquina.getQtdItem());
						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoMaquina.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoMaquina.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoMaquina
												.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIPerdasMaquinasTodas.add(itemGraficoMaquina);
			}
		}

		// ganhos por produto
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIGanhosProdutos) {
			itemGraficoProduto = new GraficoBIParetoPerdasDTO();
			itemGraficoProduto.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoProduto.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoProduto.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoProduto.setIndItem(itemgraf.getIndItem());
			itemGraficoProduto.setQtdItem(itemgraf.getQtdItem());

			itemGraficoProduto.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoProduto.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoProduto.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoProduto.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoProduto.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoProduto.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica produto
			existeItem = false;
			if (graficoParetoBIGanhosProdutosTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIGanhosProdutosTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoProduto.getQtdItem());
						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoProduto.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoProduto.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoProduto
												.getQtdItemEmUnidadeMonetaria());

						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIGanhosProdutosTodas.add(itemGraficoProduto);
			}
		}

		// ganhos por mÃ¡quina
		for (GraficoBIParetoPerdasDTO itemgraf : graficoParetoBIGanhosMaquinas) {
			itemGraficoMaquina = new GraficoBIParetoPerdasDTO();
			itemGraficoMaquina.setIdItemPareto(itemgraf.getIdItemPareto());
			itemGraficoMaquina.setCdItemPareto(itemgraf.getCdItemPareto());
			itemGraficoMaquina.setDsItemPareto(itemgraf.getDsItemPareto());
			itemGraficoMaquina.setIndItem(itemgraf.getIndItem());
			itemGraficoMaquina.setQtdItem(itemgraf.getQtdItem());

			itemGraficoMaquina.setIndItemEmKg(itemgraf.getIndItemEmKg());
			itemGraficoMaquina.setQtdItemEmKg(itemgraf.getQtdItemEmKg());

			itemGraficoMaquina.setIndItemEmTon(itemgraf.getIndItemEmTon());
			itemGraficoMaquina.setQtdItemEmTon(itemgraf.getQtdItemEmTon());

			itemGraficoMaquina.setIndItemEmUnidadeMonetaria(itemgraf
					.getIndItemEmUnidadeMonetaria());
			itemGraficoMaquina.setQtdItemEmUnidadeMonetaria(itemgraf
					.getQtdItemEmUnidadeMonetaria());

			// verifica mÃ¡quina
			existeItem = false;
			if (graficoParetoBIGanhosMaquinasTodas.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgrafTodas : graficoParetoBIGanhosMaquinasTodas) {
					if (itemgraf.getCdItemPareto().equals(
							itemgrafTodas.getCdItemPareto())) {
						// acumula
						itemgrafTodas.setQtdItem(itemgrafTodas.getQtdItem()
								+ itemGraficoMaquina.getQtdItem());

						itemgrafTodas.setIndItemEmKg(itemgrafTodas
								.getIndItemEmKg()
								+ itemGraficoMaquina.getIndItemEmKg());
						itemgrafTodas.setIndItemEmTon(itemgrafTodas
								.getIndItemEmTon()
								+ itemGraficoMaquina.getIndItemEmTon());
						itemgrafTodas
								.setQtdItemEmUnidadeMonetaria(itemgrafTodas
										.getQtdItemEmUnidadeMonetaria()
										+ itemGraficoMaquina
												.getQtdItemEmUnidadeMonetaria());

						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				graficoParetoBIGanhosMaquinasTodas.add(itemGraficoMaquina);
			}
		}

	}

	private void calcularIndicePerdasBI(List<GraficoBIParetoPerdasDTO> listaBI,
			TipoAgrupamentoParetoBI tipoPareto) {
		Double totalPerdas = 0d;
		Double indPerdas = 0d;

		Double totalPerdasKg = 0d;
		Double totalPerdasTon = 0d;
		Double totalPerdasUM = 0d;
		Double indPerdasKg = 0d;
		Double indPerdasTon = 0d;
		Double indPerdasUM = 0d;

		String toolTip = "";
		String toolTipKg = "";
		String toolTipTon = "";
		String toolTipUnidadeMonetaria = "";

		// necessario por causa do Injet VF / empresas eventualmente sem perdas decimais
		List<GraficoBIParetoPerdasDTO> listaExcluir = new ArrayList<>();

		for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
			if (IdwFacade.IS_IDW_ATIVO == false) {
				Double valorConvertidoUBInjet = ConversaoTipos.converterParaBigDecimal(itemgraf.getQtdItem()).doubleValue();
				itemgraf.setQtdItem(valorConvertidoUBInjet);
				if (itemgraf.getQtdItem() > 0) {
					itemgraf.setQtdItem(valorConvertidoUBInjet);
					totalPerdas = totalPerdas + itemgraf.getQtdItem();
					totalPerdasKg = totalPerdasKg + itemgraf.getQtdItemEmKg();
					totalPerdasTon = totalPerdasTon + itemgraf.getQtdItemEmTon();
					totalPerdasUM = totalPerdasUM + itemgraf.getQtdItemEmUnidadeMonetaria();
				} else {
					listaExcluir.add(itemgraf);
				}

			} else {
				totalPerdas = totalPerdas + itemgraf.getQtdItem();
				totalPerdasKg = totalPerdasKg + itemgraf.getQtdItemEmKg();
				totalPerdasTon = totalPerdasTon + itemgraf.getQtdItemEmTon();
				totalPerdasUM = totalPerdasUM + itemgraf.getQtdItemEmUnidadeMonetaria();
			}
		}

		if (listaExcluir.size() > 0) {
			for (GraficoBIParetoPerdasDTO itemgraf : listaExcluir) {
				listaBI.remove(itemgraf);
			}
		}

		if (totalPerdas > 0) {
			// calcula o Ã­ndice de perdas por mÃ¡quina
			for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
				indPerdas = 0d;
				indPerdasKg = 0d;
				indPerdasTon = 0d;
				indPerdasUM = 0d;

				if (totalPerdas > 0) {
					indPerdas = (itemgraf.getQtdItem() / totalPerdas) * 100;
					indPerdasKg = (itemgraf.getQtdItemEmKg() / totalPerdasKg) * 100;
					indPerdasTon = (itemgraf.getQtdItemEmTon() / totalPerdasTon) * 100;
					indPerdasUM = (itemgraf.getQtdItemEmUnidadeMonetaria() / totalPerdasUM) * 100;
				}
				itemgraf.setIndItem(indPerdas);
				itemgraf.setIndItemEmKg(indPerdasKg);
				itemgraf.setIndItemEmTon(indPerdasTon);
				itemgraf.setIndItemEmUnidadeMonetaria(indPerdasUM);

				if (tipoPareto == TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS) {
					toolTip = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTip = toolTip
								+ "Perdas: "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItem(), 2)
								+ "<br>";
					}

					toolTip = toolTip
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItem(), 2) + "%" + "</html>";

					toolTipKg = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipKg = toolTipKg
								+ "Perdas (Kg): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmKg(), 4)
								+ "<br>";
					}

					toolTipKg = toolTipKg
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItemEmKg(), 2) + "%" + "</html>";

					toolTipTon = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipTon = toolTipTon
								+ "Perdas (Ton): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmTon(), 4)
								+ "<br>";
					}

					toolTipTon = toolTipTon
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItemEmTon(), 2) + "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "Máquina: "
							+ itemgraf.getDsItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
								+ "Perdas ($): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
								+ "<br>";
					}

					toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";

				} else {
					toolTip = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTip = toolTip
								+ "Perdas: "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItem(), 2)
								+ "<br>";
					}

					toolTip = toolTip
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItem(), 2)
							+ "%" + "</html>";

					toolTipKg = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipKg = toolTipKg
								+ "Perdas (Kg): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmKg(), 4);

					}

					toolTipKg = toolTipKg
							+ "<br>"
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmKg(), 2)
							+ "%" + "</html>";

					toolTipTon = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipTon = toolTipTon
								+ "Perdas (Ton): "
								+ ConversaoTipos.converteParaString(
										itemgraf.getQtdItemEmTon(), 4)
								+ "<br>";
					}

					toolTipTon = toolTipTon
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmTon(), 2)
							+ "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>";

					if (itemgraf.getIsParadaSemPeso() == false) {
						toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
								+ "Perdas ($): "
								+ ConversaoTipos.converteParaString(itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
								+ "<br>";
					}

					toolTipUnidadeMonetaria = toolTipUnidadeMonetaria
							+ "Ind.Perda: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";
				}

				itemgraf.setToolTipItem(toolTip);
				itemgraf.setToolTipItemKg(toolTipKg);
				itemgraf.setToolTipItemTon(toolTipTon);
				itemgraf.setToolTipItemUnidadeMonetaria(toolTipUnidadeMonetaria);
			}
		}
	}

	private void calcularIndiceGanhosBI(List<GraficoBIParetoPerdasDTO> listaBI,
			TipoAgrupamentoParetoBI tipoPareto) {
		Double totalItem = 0d;
		Double indItem = 0d;

		Double totalKg = 0d;
		Double totalTon = 0d;
		Double totalUM = 0d;
		Double indKg = 0d;
		Double indTon = 0d;
		Double indUM = 0d;

		String toolTip = "";
		String toolTipKg = "";
		String toolTipTon = "";
		String toolTipUnidadeMonetaria = "";

		// necessario por causa do Injet VF / empresas eventualmente sem perdas decimais
		List<GraficoBIParetoPerdasDTO> listaExcluir = new ArrayList<>();

		for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
			if (IdwFacade.IS_IDW_ATIVO == false) {
				Double valorConvertidoUBInjet = ConversaoTipos.converterParaBigDecimal(itemgraf.getQtdItem()).doubleValue();
				itemgraf.setQtdItem(valorConvertidoUBInjet);
				if (itemgraf.getQtdItem() > 0) {
					totalItem = totalItem + itemgraf.getQtdItem();
					totalKg = totalKg + itemgraf.getQtdItemEmKg();
					totalTon = totalTon + itemgraf.getQtdItemEmTon();
					totalUM = totalUM + itemgraf.getQtdItemEmUnidadeMonetaria();
				} else {
					listaExcluir.add(itemgraf);
				}

			} else {
				totalItem = totalItem + itemgraf.getQtdItem();
				totalKg = totalKg + itemgraf.getQtdItemEmKg();
				totalTon = totalTon + itemgraf.getQtdItemEmTon();
				totalUM = totalUM + itemgraf.getQtdItemEmUnidadeMonetaria();
			}
		}

		if (listaExcluir.size() > 0) {
			for (GraficoBIParetoPerdasDTO itemgraf : listaExcluir) {
				listaBI.remove(itemgraf);
			}
		}

		if (totalItem > 0) {
			// calcula o Ã­ndice de perdas por mÃ¡quina
			for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
				indItem = 0d;
				indKg = 0d;
				indTon = 0d;
				indUM = 0d;

				if (totalItem > 0) {
					indItem = (itemgraf.getQtdItem() / totalItem) * 100;
					indKg = (itemgraf.getQtdItemEmKg() / totalKg) * 100;
					indTon = (itemgraf.getQtdItemEmTon() / totalTon) * 100;
					indUM = (itemgraf.getQtdItemEmUnidadeMonetaria() / totalUM) * 100;
				}
				itemgraf.setIndItem(indItem);
				itemgraf.setIndItemEmKg(indKg);
				itemgraf.setIndItemEmTon(indTon);
				itemgraf.setIndItemEmUnidadeMonetaria(indUM);

				if (tipoPareto == TipoAgrupamentoParetoBI.PARETO_BI_MAQUINAS) {
					toolTip = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItem(), 2)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItem(), 2)
							+ "%" + "</html>";

					toolTipKg = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos (Kg): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmKg(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmKg(), 2)
							+ "%" + "</html>";

					toolTipTon = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos (Ton): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmTon(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmTon(), 2)
							+ "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "MÃ¡quina: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos ($): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";

				} else {
					toolTip = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItem(), 2)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItem(), 2)
							+ "%" + "</html>";

					toolTipKg = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos (Kg): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmKg(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmKg(), 2)
							+ "%" + "</html>";

					toolTipTon = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Perdas (Ton): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmTon(), 4)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmTon(), 2)
							+ "%"
							+ "</html>";

					toolTipUnidadeMonetaria = "<html>"
							+ "Produto: "
							+ itemgraf.getCdItemPareto()
							+ "<br>"
							+ "Ganhos ($): "
							+ ConversaoTipos.converteParaString(
									itemgraf.getQtdItemEmUnidadeMonetaria(), 3)
							+ "<br>"
							+ "Ind.Ganhos: "
							+ ConversaoTipos.converteParaString(
									itemgraf.getIndItemEmUnidadeMonetaria(), 2)
							+ "%" + "</html>";
				}

				itemgraf.setToolTipItem(toolTip);
				itemgraf.setToolTipItemKg(toolTipKg);
				itemgraf.setToolTipItemTon(toolTipTon);
				itemgraf.setToolTipItemUnidadeMonetaria(toolTipUnidadeMonetaria);
			}
		}

	}

	private void atualizarPerdasBI(GraficoBIParetoPerdasDTO itemLista,
			List<GraficoBIParetoPerdasDTO> listaBI) {
		Boolean existeItem = false;

		if (itemLista.getQtdItem() > 0) {
			if (listaBI.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
					if (itemLista.getCdItemPareto().equals(
							itemgraf.getCdItemPareto())) {

						// acumula
						if (itemgraf.getSegTempo() != null) {
							itemgraf.setSegTempo(itemgraf.getSegTempo()
									+ itemLista.getSegTempo());
						}
						itemgraf.setQtdItem(itemgraf.getQtdItem()
								+ itemLista.getQtdItem());
						itemgraf.setQtdItemEmKg(itemgraf.getQtdItemEmKg()
								+ itemLista.getQtdItemEmKg());
						itemgraf.setQtdItemEmTon(itemgraf.getQtdItemEmTon()
								+ itemLista.getQtdItemEmTon());
						itemgraf.setQtdItemEmUnidadeMonetaria(itemgraf
								.getQtdItemEmUnidadeMonetaria()
								+ itemLista.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				listaBI.add(itemLista);
			}
		}

	}

	private void atualizarGanhosBI(GraficoBIParetoPerdasDTO itemLista,
			List<GraficoBIParetoPerdasDTO> listaBI) {
		Boolean existeItem = false;

		if (itemLista.getQtdItem() > 0) {
			if (listaBI.size() > 0) {
				for (GraficoBIParetoPerdasDTO itemgraf : listaBI) {
					if (itemLista.getCdItemPareto().equals(
							itemgraf.getCdItemPareto())) {
						// acumula
						if (itemgraf.getSegTempo() != null) {
							itemgraf.setSegTempo(itemgraf.getSegTempo()
									+ itemLista.getSegTempo());
						}
						itemgraf.setQtdItem(itemgraf.getQtdItem()
								+ itemLista.getQtdItem());
						itemgraf.setQtdItemEmKg(itemgraf.getQtdItemEmKg()
								+ itemLista.getQtdItemEmKg());
						itemgraf.setQtdItemEmTon(itemgraf.getQtdItemEmTon()
								+ itemLista.getQtdItemEmTon());
						itemgraf.setQtdItemEmUnidadeMonetaria(itemgraf
								.getQtdItemEmUnidadeMonetaria()
								+ itemLista.getQtdItemEmUnidadeMonetaria());
						existeItem = true;
						break;
					}
				}
			}

			if (!existeItem) {
				listaBI.add(itemLista);
			}
		}
	}

	private void atualizarParetosPerdaGanhoInjet(List<GraficoBIParetoPerdasDTO> grafPerdas, List<GraficoBIParetoPerdasDTO> grafGanhos,
			Boolean isMaquina, Boolean isCiclo) {
		GraficoBIParetoPerdasDTO itemGrafico = new GraficoBIParetoPerdasDTO();

		if (grafPerdas != null && grafGanhos != null) {

			Map<String, String> mapMaquina = new HashMap<String, String>();

			List<GraficoBIParetoPerdasDTO> grafBIPerdas = new ArrayList<GraficoBIParetoPerdasDTO>();
			List<GraficoBIParetoPerdasDTO> grafBIGanhos = new ArrayList<GraficoBIParetoPerdasDTO>();

			for (GraficoBIParetoPerdasDTO perda : grafPerdas) {
				if (!mapMaquina.containsKey(perda.getCdItemPareto())) {
					mapMaquina.put(perda.getCdItemPareto(), null);
				}
			}
			for (GraficoBIParetoPerdasDTO ganho : grafGanhos) {
				if (!mapMaquina.containsKey(ganho.getCdItemPareto())) {
					mapMaquina.put(ganho.getCdItemPareto(), null);
				}
			}

			Set<String> keysMaquinas = mapMaquina.keySet();
			GraficoBIParetoPerdasDTO itemPerda = null;
			GraficoBIParetoPerdasDTO itemGanho = null;

			for (String maq : keysMaquinas) {
				// MAQ - ver se o resultado de cada item eh perda ou ganho
				itemPerda = null;
				itemGanho = null;
				for (GraficoBIParetoPerdasDTO perda : grafPerdas) {
					if (perda.getCdItemPareto().equals(maq)) {
						itemPerda = new GraficoBIParetoPerdasDTO();
						itemPerda = perda;
						break;
					}
				}

				for (GraficoBIParetoPerdasDTO ganho : grafGanhos) {
					if (ganho.getCdItemPareto().equals(maq)) {
						itemGanho = new GraficoBIParetoPerdasDTO();
						itemGanho = ganho;
						break;
					}
				}

				if (itemPerda != null && itemGanho == null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico = itemPerda;
					grafBIPerdas.add(itemGrafico);
				}

				if (itemGanho != null && itemPerda == null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico = itemGanho;
					grafBIGanhos.add(itemGrafico);
				}

				if (itemPerda != null && itemGanho != null) {
					itemGrafico = new GraficoBIParetoPerdasDTO();
					itemGrafico.setIdItemPareto(itemPerda.getIdItemPareto());
					itemGrafico.setCdItemPareto(itemPerda.getCdItemPareto());
					itemGrafico.setDsItemPareto(itemPerda.getDsItemPareto());
					itemGrafico.setSegTempo(itemPerda.getSegTempo());

					itemGrafico.setIndItem(0d);
					itemGrafico.setIndItemEmKg(0d);
					itemGrafico.setIndItemEmTon(0d);
					itemGrafico.setIndItemEmUnidadeMonetaria(0d);

					itemGrafico.setToolTipItem("");
					itemGrafico.setToolTipItemKg("");
					itemGrafico.setToolTipItemTon("");
					itemGrafico.setToolTipItemUnidadeMonetaria("");

					itemGrafico.setQtdItem(itemPerda.getQtdItem() - itemGanho.getQtdItem());

					itemGrafico.setQtdItem(ConversaoTipos.converterParaBigDecimal(itemGrafico.getQtdItem()).doubleValue());
					itemGrafico.setQtdItemEmKg(itemPerda.getQtdItemEmKg() - itemGanho.getQtdItemEmKg());
					itemGrafico.setQtdItemEmTon(itemPerda.getQtdItemEmTon() - itemGanho.getQtdItemEmTon());
					itemGrafico.setQtdItemEmUnidadeMonetaria(
							itemPerda.getQtdItemEmUnidadeMonetaria() - itemGanho.getQtdItemEmUnidadeMonetaria());

					if (itemGrafico.getQtdItem() < 0) {
						// ganho
						itemGrafico.setQtdItem(itemGrafico.getQtdItem() * -1);
						itemGrafico.setQtdItemEmKg(itemGrafico.getQtdItemEmKg() * -1);
						itemGrafico.setQtdItemEmTon(itemGrafico.getQtdItemEmTon() * -1);
						itemGrafico.setQtdItemEmUnidadeMonetaria(itemGrafico.getQtdItemEmUnidadeMonetaria() * -1);

						grafBIGanhos.add(itemGrafico);

					} else {
						if (itemGrafico.getQtdItem() > 0) {
							// perda
							grafBIPerdas.add(itemGrafico);

						} else {
							// ignorar - perdas e ganhos se anularam
						}
					}
				}
			}

			/*
			 * if (isCiclo) { if (isMaquina) { graficoParetoBIPerdasMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
			 * graficoParetoBIPerdasMaquinas = grafBIPerdas; graficoParetoBIGanhosMaquinas = new ArrayList<GraficoBIParetoPerdasDTO>();
			 * graficoParetoBIGanhosMaquinas = grafBIGanhos; } else { graficoParetoBIPerdasProdutos = new
			 * ArrayList<GraficoBIParetoPerdasDTO>(); graficoParetoBIPerdasProdutos = grafBIPerdas; graficoParetoBIGanhosProdutos = new
			 * ArrayList<GraficoBIParetoPerdasDTO>(); graficoParetoBIGanhosProdutos = grafBIGanhos; } } else { if (isMaquina) {
			 * graficoParetoBIPerdasMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>(); graficoParetoBIPerdasMaquinasTodas =
			 * grafBIPerdas; graficoParetoBIGanhosMaquinasTodas = new ArrayList<GraficoBIParetoPerdasDTO>();
			 * graficoParetoBIGanhosMaquinasTodas = grafBIGanhos; } else { graficoParetoBIPerdasProdutosTodas = new
			 * ArrayList<GraficoBIParetoPerdasDTO>(); graficoParetoBIPerdasProdutosTodas = grafBIPerdas; graficoParetoBIGanhosProdutosTodas
			 * = new ArrayList<GraficoBIParetoPerdasDTO>(); graficoParetoBIGanhosProdutosTodas = grafBIGanhos; } }
			 */
		}
	}


}
