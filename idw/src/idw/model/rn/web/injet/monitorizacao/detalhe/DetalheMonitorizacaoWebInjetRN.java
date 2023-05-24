package idw.model.rn.web.injet.monitorizacao.detalhe;

//TODO: 201804 A confirmar se usa mesmo este (e OUTROS semelhantes) [DetalheMonitorizacaoWebIndicadorRN do vf] ou [DetalheMonitorizacaoWebIndicadorInjetRN do injet]


import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.EnergiaConsumidaProducaoDTO;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.monitorizacao.injet.DetalheMonitorizacaoPTInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoCicloDTO;
import idw.webservices.dto.GraficoTempoDTO;
import idw.webservices.dto.MpBrutaPorMaquinaDTO;
import idw.webservices.dto.PerdasDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.rest.dto.AlertaDTO;
import idw.webservices.rest.dto.OpDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.MpBrutaPostoDTO;
import idw.webservices.rest.dto.monitorizacao.OperadorDTO;
import idw.webservices.rest.dto.monitorizacao.PerdaProducaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtCicloDTO;
import idw.webservices.rest.dto.monitorizacao.PtEnergiaDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtMateriaPrimaResumo;
import idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtParadaResumoDTO;
import idw.webservices.rest.dto.monitorizacao.PtProducaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtProdutoDTO;
import idw.webservices.rest.dto.monitorizacao.PtTemposDTO;
import idw.webservices.rest.dto.monitorizacao.TurnoIndicadorDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebInjetRN extends AbstractRN<DAOGenericoInjet> {

	public static final Color COR_TEMPO_COLETA = new Color(51, 0, 255);
	public static final Color COR_TEMPO_DISPONIVEL = new Color(0, 153, 153);
	public static final Color COR_TEMPO_TRABALHADO = new Color(0, 153, 153);
	public static final Color COR_TEMPO_CICLOS_PRODUTIVOS = new Color(0, 153, 153);
	public static final Color COR_TEMPO_PRODUCAO_LIQUIDA = new Color(0, 153, 153);
	public static final Color COR_TEMPO_PRODUTIVAS = new Color(0, 153, 153);

	public static final Color COR_TEMPO_RITMO = new Color(255, 204, 255);
	public static final Color COR_TEMPO_BLANK_INATIVO = new Color(255, 255, 255);
	public static final Color COR_TEMPO_REFUGOS = new Color(255, 255, 102);
	public static final Color COR_TEMPO_CICLOS_IMPRODUTIVOS = new Color(51, 51, 255);
	public static final Color COR_TEMPO_PARADAS = new Color(255, 51, 51);
	public static final Color COR_TEMPO_NAO_DISPONIVEL = new Color(153, 153, 153);
	public static final Color COR_TEMPO_PRODUTIVAS_GRAFICO = new Color(255, 153, 102);

	public enum FiltroOp {
		ULTIMA_OP_NO_TURNO(0), TODAS_AS_OPS_NO_TURNO(1), ULTIMA_OP_ACUMULADO(2);

		private final int valor;

		private FiltroOp(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}

	private final String formatoData;
	private final String formatoDataHora;
	DetalheMonitorizacaoWebIndicadorInjetRN indicadorRN;
	private List<MetaIndicadorDTO> listaMetaIndicadores;

	public DetalheMonitorizacaoWebInjetRN(String formatoData, String formatoDataHora) {
		this(new DAOGenericoInjet(), formatoData, formatoDataHora);
	}

	public DetalheMonitorizacaoWebInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
		super(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
	}
	
	public PtMonitorizacaoDTO getDetalheLista(FiltroDetalhePTInjetDTO filtro) throws PostoSemDadoException {
		PtMonitorizacaoDTO ptDTO = new PtMonitorizacaoDTO();
		listaMetaIndicadores = new ArrayList<MetaIndicadorDTO>();

		DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(getDao());
		DetalheMonitorizacaoPTInjetDTO consultaDTO = rn.getDetalheMonitorizacaoPtInjetDTO(filtro);

		if (consultaDTO.getListaDwConsolId() == null || consultaDTO.getListaDwConsolId().size() == 0) {
			return null;
		}

		// Marcos Sardinha: VFWEB - Injet
		indicadorRN = new DetalheMonitorizacaoWebIndicadorInjetRN(getDao(), formatoData, formatoDataHora);
		
		if(indicadorRN.getMetaIndicadores(getDao()) == null){
			
			System.out.println("Item Nulo");
		}
		listaMetaIndicadores = indicadorRN.getMetaIndicadores(getDao());

		ptDTO.setCdPt(consultaDTO.getOmPt().getCdPt());
		ptDTO.setDsPt(consultaDTO.getOmPt().getDsPt());
		ptDTO.setDsView(consultaDTO.getOmPt().getDsCurta());
		ptDTO.setData(consultaDTO.getDtReferencia());

		ptDTO.setFerramenta(consultaDTO.getMolde());

		ptDTO.setFiltroQuantidadeRefugada(ConversaoTipos.converteParaString(consultaDTO.getQtdRefugadas(), 2));
		ptDTO.setOpSelecionada(consultaDTO.getOrdemproducao());

		ptDTO.setCdFolha(consultaDTO.getDwFolha().getCdFolha());
		ptDTO.setMetaHora(ConversaoTipos.converteParaString(consultaDTO.getMetaHora(), 0));
		ptDTO.setCavidadesAtivasView(consultaDTO.getCav_ativas());
		
		if (consultaDTO.getDwTurno() != null) {
			ptDTO.setTurno(consultaDTO.getDwTurno().getDsTurno());
		} else {
			ptDTO.setTurno("Todos os turnos");
		}

		ptDTO.setMetaIndicadores(listaMetaIndicadores);
		ptDTO.setTurnoIndicadores(getTurnoIndicadores(consultaDTO));
		ptDTO.setGraficoIndicadores(getListaGraficoIndicadores(consultaDTO));
		ptDTO.setIndicadores(getIndicadores(consultaDTO));
		ptDTO.setTempos(getTempos(consultaDTO));
		ptDTO.setProducao(getProducao(consultaDTO));
		ptDTO.setParadaResumo(getParadaResumo(consultaDTO));
		ptDTO.setCiclo(getCiclo(consultaDTO));
		ptDTO.setMateriaPrimaResumo(getMateriaPrimaResumo(consultaDTO));
		ptDTO.setOperadores(getOperadores(consultaDTO));
		ptDTO.setAlertas(getAlertas(consultaDTO));
		ptDTO.setPerdasProducao(getPerdasProducao(consultaDTO));
		ptDTO.setGraficoPerdas(getGraficoPerdasProducao(consultaDTO));
		ptDTO.setGraficoInsercoesMp(getGraficoInsercoesMp(consultaDTO));
		ptDTO.setProdutos(getProdutos(consultaDTO));
		ptDTO.setOps(getOps(consultaDTO));
		
		//estava OFF ptDTO.setEnergiaConsumidaProducao(getEnergiaConsumidaProducao(consultaDTO));//20180814-ON-TESTES
		if (consultaDTO.getEnergiaConsumidaProducao()!=null && consultaDTO.getEnergiaConsumidaProducao().size()>0){
			List<PtEnergiaDTO> listaPtEnergiaDTO =  new  ArrayList<PtEnergiaDTO>();
			for (EnergiaConsumidaProducaoDTO dtoorigem : consultaDTO.getEnergiaConsumidaProducao() ){
				PtEnergiaDTO dtodestino = new PtEnergiaDTO();
				dtodestino.setCustoKwhProducaoBruta( String.valueOf( dtoorigem.getProducaoBrutaValormonetario()) );
				dtodestino.setCustoKwhProducaoLiquida( String.valueOf( dtoorigem.getProducaoLiquidaValormonetario()));
				dtodestino.setCustoKwhProducaoRefugada( String.valueOf( dtoorigem.getProducaoRefugadaValormonetario()));
				dtodestino.setEnergiaConsumidaKwh( String.valueOf( dtoorigem.getKwh()));
				dtodestino.setOrdemProducao(dtoorigem.getNrop());
				dtodestino.setProducaoBruta( String.valueOf( dtoorigem.getProducaoBruta()));
				dtodestino.setProducaoBrutaKwh( String.valueOf( dtoorigem.getProducaoBrutaKwh()));
				dtodestino.setProducaoLiquida( String.valueOf( dtoorigem.getProducaoLiquida()));
				dtodestino.setProducaoLiquidaKwh(  String.valueOf( dtoorigem.getProducaoLiquidaKwh() ));
				dtodestino.setProducaoRefugada( String.valueOf( dtoorigem.getProducaoRefugada()));
				dtodestino.setProducaoRefugadaKwh( String.valueOf( dtoorigem.getProducaoRefugadaKwh()));
				listaPtEnergiaDTO.add(dtodestino);
			}
			ptDTO.setEnergiaConsumidaProducao( listaPtEnergiaDTO   );//20180814-ON-TESTES
		}
		
		
		return ptDTO;
	}

	public PtMonitorizacaoDTO getDetalhe(FiltroDetalhePTInjetDTO filtro) throws PostoSemDadoException {
		PtMonitorizacaoDTO ptDTO = new PtMonitorizacaoDTO();
		listaMetaIndicadores = new ArrayList<MetaIndicadorDTO>();

		DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(getDao());
		DetalheMonitorizacaoPTInjetDTO consultaDTO = rn.getDetalheMonitorizacaoPtInjetDTO(filtro);

		if (consultaDTO.getListaDwConsolId() == null || consultaDTO.getListaDwConsolId().size() == 0) {
			throw new PostoSemDadoException();
		}

		// Marcos Sardinha: VFWEB - Injet
		indicadorRN = new DetalheMonitorizacaoWebIndicadorInjetRN(getDao(), formatoData, formatoDataHora);
		listaMetaIndicadores = indicadorRN.getMetaIndicadores(getDao());

		ptDTO.setCdPt(consultaDTO.getOmPt().getCdPt());
		ptDTO.setDsPt(consultaDTO.getOmPt().getDsPt());
		ptDTO.setDsView(consultaDTO.getOmPt().getDsCurta());
		ptDTO.setData(consultaDTO.getDtReferencia());

		ptDTO.setFerramenta(consultaDTO.getMolde());

		ptDTO.setFiltroQuantidadeRefugada(ConversaoTipos.converteParaString(consultaDTO.getQtdRefugadas(), 2));
		ptDTO.setOpSelecionada(consultaDTO.getOrdemproducao());

		ptDTO.setCdFolha(consultaDTO.getDwFolha().getCdFolha());
		ptDTO.setMetaHora(ConversaoTipos.converteParaString(consultaDTO.getMetaHora(), 0));
		ptDTO.setCavidadesAtivasView(consultaDTO.getCav_ativas());
		
		if (consultaDTO.getDwTurno() != null) {
			ptDTO.setTurno(consultaDTO.getDwTurno().getDsTurno());
		} else {
			ptDTO.setTurno("Todos os turnos");
		}

		ptDTO.setMetaIndicadores(listaMetaIndicadores);
		ptDTO.setTurnoIndicadores(getTurnoIndicadores(consultaDTO));
		ptDTO.setGraficoIndicadores(getListaGraficoIndicadores(consultaDTO));
		ptDTO.setIndicadores(getIndicadores(consultaDTO));
		ptDTO.setTempos(getTempos(consultaDTO));
		ptDTO.setProducao(getProducao(consultaDTO));
		ptDTO.setParadaResumo(getParadaResumo(consultaDTO));
		ptDTO.setCiclo(getCiclo(consultaDTO));
		ptDTO.setMateriaPrimaResumo(getMateriaPrimaResumo(consultaDTO));
		ptDTO.setOperadores(getOperadores(consultaDTO));
		ptDTO.setAlertas(getAlertas(consultaDTO));
		ptDTO.setPerdasProducao(getPerdasProducao(consultaDTO));
		ptDTO.setGraficoPerdas(getGraficoPerdasProducao(consultaDTO));
		ptDTO.setGraficoInsercoesMp(getGraficoInsercoesMp(consultaDTO));
		ptDTO.setProdutos(getProdutos(consultaDTO));
		ptDTO.setOps(getOps(consultaDTO));
		
		//estava OFF ptDTO.setEnergiaConsumidaProducao(getEnergiaConsumidaProducao(consultaDTO));//20180814-ON-TESTES
		if (consultaDTO.getEnergiaConsumidaProducao()!=null && consultaDTO.getEnergiaConsumidaProducao().size()>0){
			List<PtEnergiaDTO> listaPtEnergiaDTO =  new  ArrayList<PtEnergiaDTO>();
			for (EnergiaConsumidaProducaoDTO dtoorigem : consultaDTO.getEnergiaConsumidaProducao() ){
				PtEnergiaDTO dtodestino = new PtEnergiaDTO();
				dtodestino.setCustoKwhProducaoBruta( String.valueOf( dtoorigem.getProducaoBrutaValormonetario()) );
				dtodestino.setCustoKwhProducaoLiquida( String.valueOf( dtoorigem.getProducaoLiquidaValormonetario()));
				dtodestino.setCustoKwhProducaoRefugada( String.valueOf( dtoorigem.getProducaoRefugadaValormonetario()));
				dtodestino.setEnergiaConsumidaKwh( String.valueOf( dtoorigem.getKwh()));
				dtodestino.setOrdemProducao(dtoorigem.getNrop());
				dtodestino.setProducaoBruta( String.valueOf( dtoorigem.getProducaoBruta()));
				dtodestino.setProducaoBrutaKwh( String.valueOf( dtoorigem.getProducaoBrutaKwh()));
				dtodestino.setProducaoLiquida( String.valueOf( dtoorigem.getProducaoLiquida()));
				dtodestino.setProducaoLiquidaKwh(  String.valueOf( dtoorigem.getProducaoLiquidaKwh() ));
				dtodestino.setProducaoRefugada( String.valueOf( dtoorigem.getProducaoRefugada()));
				dtodestino.setProducaoRefugadaKwh( String.valueOf( dtoorigem.getProducaoRefugadaKwh()));
				listaPtEnergiaDTO.add(dtodestino);
			}
			ptDTO.setEnergiaConsumidaProducao( listaPtEnergiaDTO   );//20180814-ON-TESTES
		}
		
		
		return ptDTO;
	}

	private PtTemposDTO getTempos(DetalheMonitorizacaoPTInjetDTO dto) {
		PtTemposDTO temposDTO = new PtTemposDTO();

		temposDTO.setTempoCalendario(DataHoraRN.formatSegundosParaHHMMSS(dto.getTempoCalendario()));
		temposDTO.setTempoColeta(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoTotais()));
		temposDTO.setTempoSemColeta(DataHoraRN.formatSegundosParaHHMMSS(dto.getTempoSemColeta()));
		temposDTO.setTempoDisponivel(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoDisponiveis()));
		temposDTO.setTempoTrabalhado(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoTrabalhadas()));
		temposDTO.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoCiclosProdutivos()));
		temposDTO.setTempoProduzidoLiquido(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoBoas()));
		temposDTO.setTempoProdutivo(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoProdutivas()));
		temposDTO.setTempoDuplicadoColeta(DataHoraRN.formatSegundosParaHHMMSS(dto.getTempoDuplicadoColeta()));
		temposDTO.setTempoParadas(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoParadas()));
		temposDTO.setTempoNaoDisponivel(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoNaoDisponivel()));
		temposDTO.setCiclosImprodutivo(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoCiclosImprodutivos()));
		temposDTO.setTempoProducaoRefugada(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoRefugos()));
		temposDTO.setRitmo(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoRitmo()));
		temposDTO.setBlankInativo(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoCavIsoladas()));
		
		List<GraficoTempoDTO> listaTemposGraficoPizza = dto.getListaGraficoTempoDTO();
		for (GraficoTempoDTO dtoGrafico : listaTemposGraficoPizza) {
			temposDTO.setRitmoSegundos(ConversaoTipos.converteParaString(dtoGrafico.getTemporitmo(), 3));
			temposDTO.setBlankInativoSegundos(ConversaoTipos.converteParaString(dtoGrafico.getTempoacurisoladas(), 3));
			temposDTO.setTempoProducaoRefugadaSegundos(ConversaoTipos.converteParaString(dtoGrafico.getTemporefugos(), 3));
			temposDTO.setCiclosImprodutivoSegundos(ConversaoTipos.converteParaString(dtoGrafico.getTempocicloimprodutivos(), 3));
			temposDTO.setTempoParadasSegundos(ConversaoTipos.converteParaString(dtoGrafico.getTempoparadas(), 3));
			temposDTO.setTempoNaoDisponivelSegundos(ConversaoTipos.converteParaString(dtoGrafico.getTemponaodisponivel(), 3));
			temposDTO.setTempoProdutivoSegundos(ConversaoTipos.converteParaString(dtoGrafico.getTempoprodutivas(), 3));
			break;
		}

		temposDTO.setTempoColetaCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_COLETA));
		temposDTO.setTempoDisponivelCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_DISPONIVEL));
		temposDTO.setTempoTrabalhadoCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_TRABALHADO));
		temposDTO.setCiclosProdutivosCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_CICLOS_PRODUTIVOS));
		temposDTO.setTempoProduzidoLiquidoCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_PRODUCAO_LIQUIDA));
		temposDTO.setTempoProdutivoCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_PRODUTIVAS));

		temposDTO.setRitmoCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_RITMO));
		temposDTO.setBlankInativoCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_BLANK_INATIVO));
		temposDTO.setTempoProducaoRefugadaCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_REFUGOS));
		temposDTO.setCiclosImprodutivoCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_CICLOS_IMPRODUTIVOS));
		temposDTO.setTempoParadasCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_PARADAS));
		temposDTO.setTempoNaoDisponivelCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_NAO_DISPONIVEL));
		temposDTO.setTempoProdutivoGraficoCor(Cor.transformarParaCodigoHexadecimal(COR_TEMPO_PRODUTIVAS_GRAFICO));

		return temposDTO;
	}

	private PtProducaoDTO getProducao(DetalheMonitorizacaoPTInjetDTO dto) {
		PtProducaoDTO producaoDTO = new PtProducaoDTO();

		producaoDTO.setProducaoPrevista(ConversaoTipos.converteParaString(dto.getQtdPrevista(), 2));
		producaoDTO.setProducaoBruta(ConversaoTipos.converteParaString(dto.getQtdProduzida(), 2));
		producaoDTO.setProducaoLiquida(ConversaoTipos.converteParaString(dto.getQtdPecasBoas(), 2));
		producaoDTO.setProducaoRefugada(ConversaoTipos.converteParaString(dto.getQtdRefugadas(), 2));
		producaoDTO.setProducaoNRParada(ConversaoTipos.converteParaString(dto.getPerdasParadas(), 0));
		producaoDTO.setProducaoNRBI(ConversaoTipos.converteParaString(dto.getPci(), 0));
		producaoDTO.setProducaoNRCiclo(ConversaoTipos.converteParaString(dto.getPerdasCiclos(), 0));
		producaoDTO.setTotalProducaoNR(ConversaoTipos.converteParaString(dto.getTotalPerdas(), 0));

		return producaoDTO;
	}

	private PtIndicadorDTO getIndicadores(DetalheMonitorizacaoPTInjetDTO dto) {
		PtIndicadorDTO indicadoresDTO = new PtIndicadorDTO();

		indicadoresDTO.setEficiencia(ConversaoTipos.converteParaString(dto.getEficiencia(), 2, true));
		indicadoresDTO.setUtilizacao(ConversaoTipos.converteParaString(dto.getUtilizacao(), 2, true));
		indicadoresDTO.setEficienciaRealizacao(ConversaoTipos.converteParaString(dto.getEfiRealizacao(), 2, true));
		indicadoresDTO.setEficienciaCiclo(ConversaoTipos.converteParaString(dto.getEfiCiclos(), 2, true));
		indicadoresDTO.setIndiceParada(ConversaoTipos.converteParaString(dto.getIndiceParadas(), 2, true));
		indicadoresDTO.setIndiceRefugo(ConversaoTipos.converteParaString(dto.getIndiceRefugos(), 2, true));
		indicadoresDTO.setIndiceCavidadesAtivas(ConversaoTipos.converteParaString(dto.getIndiceCavAtivas(), 2, true));
		indicadoresDTO.setIndiceProdutividadeOEE(ConversaoTipos.converteParaString(dto.getProdutividadeOEE(), 2, true));
		indicadoresDTO.setIndiceProdutividadeOEECapital(ConversaoTipos.converteParaString(dto.getProdutividadeOEECapital(), 2, true));
		indicadoresDTO.setIndicePerdaOuNR(ConversaoTipos.converteParaString(dto.getIndicePerdas(), 2, true));
		indicadoresDTO.setEficienciaCiclosPond(ConversaoTipos.converteParaString(dto.getEficiclosPond(), 2, true));

		indicadorRN.preencherCamposDeCores(indicadoresDTO, listaMetaIndicadores);

		return indicadoresDTO;
	}

	private List<GraficoIndicadorDTO> getListaGraficoIndicadores(DetalheMonitorizacaoPTInjetDTO dto) {
		List<GraficoIndicadorDTO> dtos = new ArrayList<GraficoIndicadorDTO>();

		List<GraficoCicloDTO> listaCiclos = dto.getListaCiclos();

		Collections.sort(listaCiclos, new Comparator<GraficoCicloDTO>() {
			@Override
			public int compare(GraficoCicloDTO o1, GraficoCicloDTO o2) {
				Date data1 = o1.getDtReferencia();
				Date data2 = o2.getDtReferencia();
				return data1.compareTo(data2);
			}
		});

		for (GraficoCicloDTO i : listaCiclos) {
			dtos.add(getGraficoIndicadores(i));
		}

		return dtos;
	}

	private GraficoIndicadorDTO getGraficoIndicadores(GraficoCicloDTO dto) {
		PtIndicadorDTO indicadoresDTO = new PtIndicadorDTO();

		indicadoresDTO.setEficienciaRealizacao(ConversaoTipos.converteParaString(dto.getEficRealizacao(), 2, true));
		indicadoresDTO.setEficienciaCiclo(ConversaoTipos.converteParaString(dto.getEficVel(), 2, true));
		indicadoresDTO.setIndiceParada(ConversaoTipos.converteParaString(dto.getIndParadas(), 2, true));
		indicadoresDTO.setIndiceRefugo(ConversaoTipos.converteParaString(dto.getIndRefugos(), 2, true));
		indicadoresDTO.setIndicePerdaOuNR(ConversaoTipos.converteParaString(dto.getIndPerdas(), 2, true));
		indicadoresDTO.setIndiceCavidadesAtivas(ConversaoTipos.converteParaString(dto.getIndAcurAtivas(), 2, true));
		indicadoresDTO.setIndiceProdutividadeOEE(ConversaoTipos.converteParaString(dto.getProdutividadeOEE(), 2, true));

		indicadoresDTO.setIndiceProdutividadeOEECapital("");
		indicadoresDTO.setEficienciaCiclosPond("");

		indicadorRN.preencherCamposDeCores(indicadoresDTO, listaMetaIndicadores);

		GraficoIndicadorDTO graficoIndicadorDTO = new GraficoIndicadorDTO();
		graficoIndicadorDTO.setData(DataHoraRN.dateToString(dto.getDtReferencia(), formatoData));
		graficoIndicadorDTO.setIndicadores(indicadoresDTO);

		return graficoIndicadorDTO;
	}

	private List<TurnoIndicadorDTO> getTurnoIndicadores(DetalheMonitorizacaoPTInjetDTO dto) {
		List<TurnoIndicadorDTO> dtos = new ArrayList<TurnoIndicadorDTO>();

		for (DetalheMonitorizacaoPTInjetDTO turno : dto.getListaTurnos()) {
			TurnoIndicadorDTO turnoDTO = new TurnoIndicadorDTO();
			turnoDTO.setDsTurno(turno.getDwTurno().getDsTurno());
			turnoDTO.setIndicadores(getIndicadores(turno));
			dtos.add(turnoDTO);
		}

		return dtos;
	}

	private PtCicloDTO getCiclo(DetalheMonitorizacaoPTInjetDTO dto) {
		PtCicloDTO cicloDTO = new PtCicloDTO();

		cicloDTO.setEficienciaDeCiclo(ConversaoTipos.converteParaString(dto.getCiclosEficienciaCic(), 2, true));
		cicloDTO.setCicloPadrao(ConversaoTipos.converteParaString(dto.getCiclosCicPadrao(), 3, true));
		cicloDTO.setCicloMedio(ConversaoTipos.converteParaString(dto.getCiclosCicMedio(), 3, true));
		cicloDTO.setUltimoCiclo(ConversaoTipos.converteParaString(dto.getCiclosUltimoCic(), 3, true));
		cicloDTO.setEficienciaUltimoCiclo(ConversaoTipos.converteParaString(dto.getCiclosEficienciaUltCic(), 2, true));
		cicloDTO.setQuantidadeCiclosExecutar(ConversaoTipos.converteParaString(dto.getQtdeCiclosExecutar(), 0, true));
		cicloDTO.setProjecaoPCI(DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(dto.getProjPCIHoras()));
		cicloDTO.setIndiceCicloAtualCompleto("0");

		return cicloDTO;
	}

	private List<OpDTO> getOps(DetalheMonitorizacaoPTInjetDTO dto) {
		List<OpDTO> opsDTO = new ArrayList<OpDTO>();

		for (PpCp ppCp : dto.getOpsNoTurno()) {
			OpDTO opDTO = new OpDTO();
			opDTO.setCdCp(ppCp.getCdCp());
			opDTO.setNrDoc(ppCp.getNrop());

			String opView = opDTO.getNrDoc();
			if (opView.equals("")) {
				opView = opDTO.getCdCp();
			}
			String opDataHoraView = opView + " - " + DataHoraRN.dateToString(ppCp.getDthrInicioreal(), formatoDataHora);
			opDTO.setDataHoraIni(ppCp.getDthrInicioreal());
			
			opDTO.setOpView(opView);
			opDTO.setOpDataHoraView(opDataHoraView);

			opsDTO.add(opDTO);
		}

		Collections.sort(opsDTO,
				new Comparator<OpDTO>() {
					@Override
					public int compare(final OpDTO o1,
							final OpDTO o2) {
						final OpDTO item1 = o1;
						final OpDTO item2 = o2;

						return (item1.getDataHoraIni().compareTo(item2.getDataHoraIni()));
					}
				});
		
		return opsDTO;
	}

	private List<PtProdutoDTO> getProdutos(DetalheMonitorizacaoPTInjetDTO dto) {
		List<PtProdutoDTO> listaRetorno = new ArrayList<PtProdutoDTO>();

		List<ProdutoDTO> listaProdutos = dto.getListaProdutos();
		for (ProdutoDTO produto : listaProdutos) {
			PtProdutoDTO produtoDTO = new PtProdutoDTO();

			produtoDTO.setDtReferencia(DataHoraRN.dateToString(produto.getDtReferencia(), formatoData));

			if (produto.getMaquina().getDwFolha() != null) {
				produtoDTO.setFolha(produto.getMaquina().getDwFolha().getCdFolha());
			} else {
				produtoDTO.setFolha("");
			}

			if (produto.getDsTurno() != null) {
				produtoDTO.setTurno(produto.getDsTurno());
			} else {
				produtoDTO.setTurno("");
			}

			produtoDTO.setPosto(produto.getMaquina().getCdPt());

			if (produto.getOrdemproducao() != null) {
				if (!produto.getOrdemproducao().getNrop().equals("")) {
					produtoDTO.setCp(produto.getOrdemproducao().getNrop());
				} else {
					produtoDTO.setCp(produto.getOrdemproducao().getCdCp());
				}

				PlanejamentoInjetRN pRN = new PlanejamentoInjetRN(getDao());
				produtoDTO.setCp(pRN.getNrOpExibicao(getDao(), produtoDTO.getCp()));

			} else {
				produtoDTO.setCp("");
			}

			produtoDTO.setDtInicioProducao(produto.getDtInicioProducao());
			produtoDTO.setProduto(produto.getProduto().getCdProduto() + "/" + produto.getProduto().getDsProduto());

			if (produto.getTempoAtivo() != null && produto.getTempoAtivo().doubleValue() > 0) {
				produtoDTO.setTempoDisponivel(DataHoraRN.formatSegundosParaHHMMSS(produto.getTempoAtivo().intValue()));
			} else {
				produtoDTO.setTempoDisponivel(DataHoraRN.ZERADO_HHMMSS);
			}

			if (produto.getMetaInstantanea().longValue() < 0l) {
				produtoDTO.setProducaoPrevista("");
			} else {
				produtoDTO.setProducaoPrevista(ConversaoTipos.converteParaStringCasasOpcionais(produto.getMetaInstantanea(), 2));
			}

			produtoDTO.setProducaoBruta(ConversaoTipos.converteParaStringCasasOpcionais(produto.getPcsProducaobruta(), 2));
			produtoDTO.setProducaoLiquida(ConversaoTipos.converteParaStringCasasOpcionais(produto.getPcsProducaoliquida(), 2));
			if (produto.getMetaInstantanea().longValue() < 0l) {
				produtoDTO.setSaldoAProduzir("0");
			} else {
				produtoDTO.setSaldoAProduzir(ConversaoTipos.converteParaStringCasasOpcionais(produto.getAproduzir(), 2));
			}
			produtoDTO.setProducaoRefugada(ConversaoTipos.converteParaStringCasasOpcionais(produto.getPcsProducaoRefugada(), 2));
			produtoDTO.setEficienciaRealizacao(ConversaoTipos.converteParaString(produto.getEficiencia(), 2, true));
			produtoDTO.setCicloPadrao(ConversaoTipos.converteParaString(produto.getCicloPadrao(), 2, true));
			produtoDTO.setCicloMedio(ConversaoTipos.converteParaString(produto.getCicloMedio(), 2, true));
			produtoDTO.setUltimoCiclo(ConversaoTipos.converteParaString(produto.getUltimoCiclo(), 2, true));
			produtoDTO.setDtRevisaoFolha(DataHoraRN.dateToString(produto.getDtRevisaoFolha(), formatoDataHora));

			if (produto.getQtdAtiva() != null) {
				produtoDTO.setProducaoOuCiclo(ConversaoTipos.converteParaString(produto.getQtdAtiva(), 0));
			} else {
				produtoDTO.setProducaoOuCiclo("");
			}

			if (produto.getCalendario() != null) {
				produtoDTO.setCalendario(produto.getCalendario().getCdCal() + "/" + produto.getCalendario().getRevisao());
			} else {
				produtoDTO.setCalendario("");
			}

			produtoDTO.setPeriodoProdutivo("NORMAL"); // no injet sempre serah normal

			listaRetorno.add(produtoDTO);
		}

		// ordena com base na data de ini da produção
		Collections.sort(listaRetorno, new Comparator<PtProdutoDTO>() {
			@Override
			public int compare(PtProdutoDTO o1, PtProdutoDTO o2) {
				String FORMATO_DATA = "dd/MM/yyyy HH:mm:ss";
				Date data1 = DataHoraRN.stringToDate(o1.getDtInicioProducao(), FORMATO_DATA);
				Date data2 = DataHoraRN.stringToDate(o2.getDtInicioProducao(), FORMATO_DATA);
				return data1.compareTo(data2);
			}
		});

		return listaRetorno;
	}

	private PtParadaResumoDTO getParadaResumo(DetalheMonitorizacaoPTInjetDTO dto) {
		PtParadaResumoDTO paradaResumoDTO = new PtParadaResumoDTO();

		paradaResumoDTO.setIndiceParada(ConversaoTipos.converteParaString(dto.getIndiceParadas(), 2, true));
		paradaResumoDTO.setTempoParada(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTempoParadas()));
		paradaResumoDTO.setUltimaParada(dto.getParadaAtualUltParada());
		paradaResumoDTO.setTempoUltimaParada(dto.getTempoParadaAtualUltParada());
		paradaResumoDTO.setDataInicio(dto.getParadaDtInicio());
		paradaResumoDTO.setHoraInicio(dto.getParadaHrIncio());
		paradaResumoDTO.setAreaResponsavel(dto.getParadaAreaResponsavel());
		paradaResumoDTO.setMtbf(ConversaoTipos.converteParaString(dto.getParadaMTBF(), 2, true));
		paradaResumoDTO.setMttr(ConversaoTipos.converteParaString(dto.getParadaMTTR(), 2, true));

		return paradaResumoDTO;
	}

	private List<OperadorDTO> getOperadores(DetalheMonitorizacaoPTInjetDTO dto) {
		List<OperadorDTO> operadores = new ArrayList<OperadorDTO>();

		for (idw.webservices.dto.OperadorDTO operador : dto.getListaOperadores()) {
			OperadorDTO operadorDTO = new OperadorDTO();
			operadorDTO.setCdUsr(operador.getOmUsr().getCdUsr());
			operadorDTO.setDsNome(operador.getOmUsr().getDsNome());
			operadorDTO.setDsApelido(operador.getOmUsr().getDsApelido());
			operadorDTO.setDtHrLogin(DataHoraRN.dateToString(operador.getDthrIlogin(), formatoDataHora));
			operadorDTO.setDtHrLogout(DataHoraRN.dateToString(operador.getDthrFlogin(), formatoDataHora));

			operadores.add(operadorDTO);
		}

		return operadores;
	}

	private List<AlertaDTO> getAlertas(DetalheMonitorizacaoPTInjetDTO dto) {
		List<AlertaDTO> alertas = new ArrayList<AlertaDTO>();

		for (idw.webservices.dto.AlertaDTO alerta : dto.getListaAlertas()) {
			AlertaDTO alertaDTO = new AlertaDTO();
			alertaDTO.setCdAlerta(alerta.getDwTAlerta().getCdTalerta());
			alertaDTO.setDsAlerta(alerta.getDwTAlerta().getDsTalerta());
			alertaDTO.setDtHrInicio(DataHoraRN.dateToString(alerta.getDthrIalerta(), formatoDataHora));
			alertaDTO.setDtHrFim(DataHoraRN.dateToString(alerta.getDthrFalerta(), formatoDataHora));

			alertas.add(alertaDTO);
		}

		return alertas;
	}

	private List<PerdaProducaoDTO> getPerdasProducao(DetalheMonitorizacaoPTInjetDTO dto) {
		List<PerdaProducaoDTO> listaPerdas = new ArrayList<PerdaProducaoDTO>();

		for (PerdasDTO perdas : dto.getListaPerdas()) {
			PerdaProducaoDTO perdaDTO = new PerdaProducaoDTO();
			perdaDTO.setViewProduto(perdas.getProduto().getCdProduto() + "-" + perdas.getProduto().getDsProduto());
			perdaDTO.setEficienciaCiclo(ConversaoTipos.converteParaString(perdas.getEficienciaciclo(), 2));
			perdaDTO.setPerdasIneficienciaCiclo(ConversaoTipos.converteParaString(perdas.getPerdasineficienciaciclo(), 2));
			perdaDTO.setIndiceParada(ConversaoTipos.converteParaString(perdas.getIndiceparadas(), 2));
			perdaDTO.setPerdasPorParada(ConversaoTipos.converteParaString(perdas.getPerdasparada(), 2));
			perdaDTO.setIndiceRefugo(ConversaoTipos.converteParaString(perdas.getIndicerefugos(), 2));
			perdaDTO.setPerdasPorRefugo(ConversaoTipos.converteParaString(perdas.getPerdasrefugos(), 2));
			perdaDTO.setIndiceCavidadesAtivas(ConversaoTipos.converteParaString(perdas.getIndicecavativas(), 2));
			perdaDTO.setPerdasPorCavidadesInativas(ConversaoTipos.converteParaString(perdas.getPerdascavativas(), 2));
			perdaDTO.setTotalPerdas(ConversaoTipos.converteParaString(perdas.getTotalperdas(), 2));

			listaPerdas.add(perdaDTO);
		}

		return listaPerdas;
	}

	private List<GraficoPizzaDTO> getGraficoPerdasProducao(DetalheMonitorizacaoPTInjetDTO dto) {
		List<GraficoPizzaDTO> listaPerdas = new ArrayList<>();

		BigDecimal perdaCicloValor = BigDecimal.ZERO; //new BigDecimal(dto.getPerdasCiclos());
		BigDecimal perdaRefugoValor = BigDecimal.ZERO; //new BigDecimal(dto.getQtdRefugadas());
		BigDecimal perdaParadaValor = BigDecimal.ZERO; //new BigDecimal(dto.getPerdasParadas());
		BigDecimal perdaCIValor = BigDecimal.ZERO; //new BigDecimal(dto.getPci());

		for (PerdasDTO perda : dto.getListaPerdas()) {
			perdaCicloValor = AritmeticaUtil.somar(perdaCicloValor, perda.getPerdasineficienciaciclo());
			perdaRefugoValor = AritmeticaUtil.somar(perdaRefugoValor, perda.getPerdasrefugos());
			perdaParadaValor = AritmeticaUtil.somar(perdaParadaValor, perda.getPerdasparada());
			perdaCIValor = AritmeticaUtil.somar(perdaCIValor, perda.getPerdascavativas());
		}
		
		BigDecimal perdaTotal = BigDecimal.ZERO;
		perdaTotal = perdaTotal.add(perdaCicloValor);
		perdaTotal = perdaTotal.add(perdaRefugoValor);
		perdaTotal = perdaTotal.add(perdaParadaValor);
		perdaTotal = perdaTotal.add(perdaCIValor);

		GraficoPizzaDTO perdaCiclo = new GraficoPizzaDTO();
		GraficoPizzaDTO perdaRefugo = new GraficoPizzaDTO();
		GraficoPizzaDTO perdaParada = new GraficoPizzaDTO();
		GraficoPizzaDTO perdaCavidadesInativas = new GraficoPizzaDTO();
		
		if (perdaTotal.doubleValue() > 0) {			
			if (perdaCicloValor.doubleValue() > 0) {
						
				perdaCiclo.setCodigo("Ciclo");
				perdaCiclo.setValor(ConversaoTipos.converteParaString(perdaCicloValor, 2));
				perdaCiclo.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaCicloValor, perdaTotal), 2));
				perdaCiclo.setCor(Cor.transformarParaCodigoHexadecimal(new Color(51, 255, 51)));
			} else {
				// desconsiderar o ganho por ciclo 
				perdaTotal = perdaTotal.add(perdaCicloValor.abs());
			}
			
			perdaRefugo.setCodigo("Refugo");
			perdaRefugo.setValor(ConversaoTipos.converteParaString(perdaRefugoValor, 2));
			perdaRefugo.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaRefugoValor, perdaTotal), 2));
			perdaRefugo.setCor(Cor.transformarParaCodigoHexadecimal(new Color(255, 153, 153)));
	
			
			perdaParada.setCodigo("Parada");
			perdaParada.setValor(ConversaoTipos.converteParaString(perdaParadaValor, 2));
			perdaParada.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaParadaValor, perdaTotal), 2));
			perdaParada.setCor(Cor.transformarParaCodigoHexadecimal(new Color(255, 51, 51)));
	
			
			perdaCavidadesInativas.setCodigo("Cav. Inativas");
			perdaCavidadesInativas.setValor(ConversaoTipos.converteParaString(perdaCIValor, 2));
			perdaCavidadesInativas
					.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaCIValor, perdaTotal), 2));
			perdaCavidadesInativas.setCor(Cor.transformarParaCodigoHexadecimal(new Color(102, 153, 255)));

			if (perdaCicloValor.doubleValue() > 0) {
				listaPerdas.add(perdaCiclo);
			}
			listaPerdas.add(perdaRefugo);
			listaPerdas.add(perdaParada);
			listaPerdas.add(perdaCavidadesInativas);
		}
		
		return listaPerdas;
	}

	private PtMateriaPrimaResumo getMateriaPrimaResumo(DetalheMonitorizacaoPTInjetDTO dto) {
		PtMateriaPrimaResumo mpResumo = new PtMateriaPrimaResumo();
		mpResumo.setConsumoProducaoBruta(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoBruta().doubleValue(), 0, true));
		mpResumo.setConsumoProducaoLiquida(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoLiquira().doubleValue(), 0, true));
		mpResumo.setConsumoProducaoRefugada(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoRefugada().doubleValue(), 0, true));
		mpResumo.setCustoTotalInsercao(ConversaoTipos.converteParaString(dto.getCustoMPTotalDeInsercao().doubleValue(), 2, true));
		mpResumo.setCustoTotalPerda(ConversaoTipos.converteParaString(dto.getCustoMPTotalDePerdas().doubleValue(), 2, true));
		mpResumo.setCustoTotalInsercaoLiquida(
				ConversaoTipos.converteParaString(dto.getCustoMPTotalDeInsercaoLiquida().doubleValue(), 2, true));
		mpResumo.setQuantidadeTotalInsercoes(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoBruta().doubleValue(), 0, true));

		return mpResumo;
	}

	private List<MpBrutaPostoDTO> getGraficoInsercoesMp(DetalheMonitorizacaoPTInjetDTO dto) {
		List<MpBrutaPostoDTO> graficoInsercoesMp = new ArrayList<>();
		for (MpBrutaPorMaquinaDTO mp : dto.getListaMpBrutaPorMaquina()) {
			MpBrutaPostoDTO mpDTO = new MpBrutaPostoDTO();
			mpDTO.setPosto(mp.getMaquina());
			mpDTO.setMateriaPrimaBruta(ConversaoTipos.converteParaString(mp.getMateriaPrimaBruta().doubleValue(), 0, true));
			graficoInsercoesMp.add(mpDTO);
		}
		return graficoInsercoesMp;
	}

	public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPTInjetDTO(FiltroDetalhePTInjetDTO filtro) {
		DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(getDao());
		return rn.getDetalheMonitorizacaoPtInjetDTO(filtro);
	}

	@SuppressWarnings("unchecked")
	public PeriodoDTO getInicioFimPeriodo(List<DwConsolid> listaIds) {
		PeriodoDTO retorno = new PeriodoDTO();

		Date inicio = null;
		Date fim = null;
		
		int _dthrMin = 0;
		int _dthrMax = _dthrMin + 1;

		class RegistroLido {
			Date dthrMin;
			Date dthrMax;
		}

		for (DwConsolid dwci : listaIds) {
			
			int _dthrIniHora_id = 0;
			int _dthrFimHora_id = _dthrIniHora_id + 1;
			int _dtTurno_id = 0;
			int _cdTurno_id = _dtTurno_id + 1;
			int _nrOP_id = (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue()) ? _dthrFimHora_id : _cdTurno_id) + 1;
			int _cdMaquina_id = _nrOP_id + 1;
			int _cdMolde_id = _cdMaquina_id + 1;
			int _cdEstrutura_id = _cdMolde_id + 1;
			int _dthrIValEstru_id = _cdEstrutura_id + 1;
			int _dthrIValCic_id = _dthrIValEstru_id + 1;

			class IdRegistro {
				Date dthrIniHora;
				Date dthrFimHora;
				Date dtTurno;
				String cdTurno;
				String nrOP;
				String cdMaquina;
				String cdMolde;
				String cdEstrutura;
				Date dthrIValEstru;
				Date dthrIValCic;
			}

			String strSQL = "";
			if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				strSQL = strSQL
						.concat("SELECT a.dthriniintervalo, a.dthrfimintervalo, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic ");
			} else {
				strSQL = strSQL.concat(
						"SELECT a.dtturno, a.cdturno, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic ");
			}

			if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				strSQL = strSQL.concat("  FROM ijCnsUT a ");
			} else {
				strSQL = strSQL.concat("  FROM ijCnsTurno a ");
			}

			// qdo houver filtro de id de ijcnsUT / ijcnsturno
			if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				strSQL = strSQL.concat(" JOIN ijcnsut cns ON (     cns.dthriniintervalo = a.dthriniintervalo ");
				strSQL = strSQL.concat("                       AND cns.cdinjetora = a.cdinjetora ");
				strSQL = strSQL.concat("                       AND cns.nrop = a.nrop ");
				strSQL = strSQL.concat("                       AND cns.cdmolde = a.cdmolde ");
				strSQL = strSQL.concat("                       AND cns.cdestrutura = a.cdestrutura ");
				strSQL = strSQL.concat("                       AND cns.dthrivalestru = a.dthrivalestru ");
				strSQL = strSQL.concat("                       AND cns.dthrivalcic = a.dthrivalcic) ");
			} else {
				strSQL = strSQL.concat(" JOIN ijcnsturno cns ON (    cns.dtturno = a.dtturno ");
				strSQL = strSQL.concat("                         AND cns.cdturno = a.cdturno ");
				strSQL = strSQL.concat("                         AND cns.cdinjetora = a.cdinjetora ");
				strSQL = strSQL.concat("                         AND cns.nrop = a.nrop ");
				strSQL = strSQL.concat("                         AND cns.cdmolde = a.cdmolde ");
				strSQL = strSQL.concat("                         AND cns.cdestrutura = a.cdestrutura ");
				strSQL = strSQL.concat("                         AND cns.dthrivalestru = a.dthrivalestru ");
				strSQL = strSQL.concat("                         AND cns.dthrivalcic = a.dthrivalcic) ");
			}

			strSQL = strSQL.concat("  WHERE cns.idregistro = :idregistro ");

			List<Object> listaSQN = new ArrayList<Object>();
			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
			q.setLong("idregistro", dwci.getIdConsolid());
			listaSQN = q.list();
			
			if (listaSQN.size() > 0) {
				Object reg = listaSQN.get(0);

				IdRegistro registroId = new IdRegistro();

				Object[] registroL = null;
				Object registroLux = (Object) reg;
				registroL = (Object[]) registroLux;

				Date dthrIni = null;
				Date dthrFim = null;

				if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
					registroId.dthrIniHora = (Date) registroL[_dthrIniHora_id];
					registroId.dthrIniHora = (Date) registroL[_dthrFimHora_id];

					dthrIni = registroId.dthrIniHora;
					dthrFim = registroId.dthrFimHora;

				} else {
					registroId.dtTurno = (Date) registroL[_dtTurno_id];
					registroId.cdTurno = (String) registroL[_cdTurno_id];

					try {
						dthrIni = FuncoesApoioInjet.calcularInicioTurno(getDao(), registroId.dtTurno, registroId.cdTurno);
						dthrFim = FuncoesApoioInjet.calcularFimTurno(getDao(), registroId.dtTurno, registroId.cdTurno);
					} catch (SemCalendarioException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				registroId.cdMaquina = (String) registroL[_cdMaquina_id];
				registroId.cdMolde = (String) registroL[_cdMolde_id];
				registroId.cdEstrutura = (String) registroL[_cdEstrutura_id];
				registroId.dthrIValEstru = (Date) registroL[_dthrIValEstru_id];
				registroId.dthrIValCic = (Date) registroL[_dthrIValCic_id];
				registroId.nrOP = (String) registroL[_nrOP_id];

				// procurar pelo menor e maior ini/fim de evento dentro do intervalo
				strSQL = "";
				strSQL = strSQL.concat("SELECT MIN(t.dthrMin) as dthrMin, MAX(t.dthrMax) as dthrMax ");
				strSQL = strSQL.concat("  FROM (");

				// ciclos
				strSQL = strSQL.concat("        SELECT MIN(a.DtHrICiclo) as dthrMin, MAX(a.DtHrFCiclo) as dthrMax ");
				strSQL = strSQL.concat("          FROM IJreaCICOP a ");
				strSQL = strSQL.concat("         WHERE a.cdinjetora = :cdinjetora ");
				strSQL = strSQL.concat("           AND a.cdmolde = :cdmolde ");
				strSQL = strSQL.concat("           AND a.cdestrutura = :cdestrutura ");
				strSQL = strSQL.concat("           AND a.dthrivalestru = :dthrivalestru ");
				strSQL = strSQL.concat("           AND a.dthrivalcic = :dthrivalcic ");
				strSQL = strSQL.concat("           AND a.nrop = :nrop ");
				strSQL = strSQL.concat("		   AND (    (a.DtHrICiclo BETWEEN :dthrini     AND :dthrfim) ");
				strSQL = strSQL.concat("		         OR (a.DtHrFCiclo BETWEEN :dthrini     AND :dthrfim) ");
				strSQL = strSQL.concat("		         OR (:dthrini     BETWEEN a.DtHrICiclo AND a.DtHrFCiclo) ");
				strSQL = strSQL.concat("		       ) ");

				// refugos
				strSQL = strSQL.concat("      UNION ");
				strSQL = strSQL.concat("        SELECT MIN(a.dthrirefugo) as dthrMin, MAX(a.dthrirefugo) as dthrMax ");
				strSQL = strSQL.concat("          FROM IJrearef a ");
				strSQL = strSQL.concat("         WHERE a.cdinjetora = :cdinjetora ");
				strSQL = strSQL.concat("           AND a.cdmolde = :cdmolde ");
				strSQL = strSQL.concat("           AND a.cdestrutura = :cdestrutura ");
				strSQL = strSQL.concat("           AND a.dthrivalestru = :dthrivalestru ");
				strSQL = strSQL.concat("           AND a.dthrivalcic = :dthrivalcic ");
				strSQL = strSQL.concat("           AND a.nrop = :nrop ");
				strSQL = strSQL.concat("           AND a.lcancelado = 0 ");
				strSQL = strSQL.concat("		   AND a.dthrirefugo BETWEEN :dthrini AND :dthrfim ");

				// paradas
				strSQL = strSQL.concat("      UNION ");
				strSQL = strSQL.concat("        SELECT MIN(a.dthripar) as dthrMin, MAX(a.dthrfpar) as dthrMax ");
				if (dwci.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
					strSQL = strSQL.concat("          FROM IJreaparcnsocorUT a ");
				} else {
					strSQL = strSQL.concat("          FROM IJreaparcnsocorTUR a ");	
				}
				
				strSQL = strSQL.concat("         WHERE a.cdinjetora = :cdinjetora ");
				strSQL = strSQL.concat("           AND a.cdmolde = :cdmolde ");
				strSQL = strSQL.concat("           AND a.cdestrutura = :cdestrutura ");
				strSQL = strSQL.concat("           AND a.dthrivalestru = :dthrivalestru ");
				strSQL = strSQL.concat("           AND a.dthrivalcic = :dthrivalcic ");
				strSQL = strSQL.concat("           AND a.nrop = :nrop ");
				strSQL = strSQL.concat("		   AND (    (a.dthripar BETWEEN :dthrini   AND :dthrfim) ");
				strSQL = strSQL.concat("		         OR (a.dthrfpar BETWEEN :dthrini   AND :dthrfim) ");
				strSQL = strSQL.concat("		         OR (:dthrini   BETWEEN a.dthripar AND a.dthrfpar) ");
				strSQL = strSQL.concat("		       ) ");

				strSQL = strSQL.concat("        ) t ");

				List<Object> lista = new ArrayList<Object>();
				SQLQuery qr = this.getDaoSession().createSQLQuery(strSQL);

				// definicao de parametros
				qr.setString("cdinjetora", registroId.cdMaquina);
				qr.setString("cdmolde", registroId.cdMolde);
				qr.setString("cdestrutura", registroId.cdEstrutura);
				qr.setTimestamp("dthrivalestru", registroId.dthrIValEstru);
				qr.setTimestamp("dthrivalcic", registroId.dthrIValCic);
				qr.setString("nrop", registroId.nrOP);
				qr.setTimestamp("dthrini", dthrIni);
				qr.setTimestamp("dthrfim", dthrFim);

				lista = qr.list();

				if (lista.size() >  0) {				
					Object regL = lista.get(0);
					RegistroLido registro = new RegistroLido();

					Object[] registroLido = null;
					Object registroLidoAux = (Object) regL;
					registroLido = (Object[]) registroLidoAux;

					if (!registroLido[_dthrMin].equals(null)) {
						registro.dthrMin = (Date) registroLido[_dthrMin];
						registro.dthrMax = (Date) registroLido[_dthrMax];

						retorno.setDtHrInicio(registro.dthrMin);
						retorno.setDtHrFim(registro.dthrMax);
						
			    		if(inicio == null) {
			    			inicio = registro.dthrMin;
			    		} else {
			    			if(registro.dthrMin.before(inicio)) {
			    				inicio = registro.dthrMin;
			    			}
			    		}				
			    		
			    		if(fim == null) {
			    			fim = registro.dthrMax;
			    		} else {
			    			if(registro.dthrMax.after(fim)) {
			    				fim = registro.dthrMax;
			    			}
			    		}
					}
					
					if (DataHoraRN.before(inicio, dthrIni)) {
						inicio = dthrIni;
					}
					
					if (DataHoraRN.after(fim, dthrFim)) {
						fim = dthrFim;
					}					
				}

			}

		}
		
		retorno.setDtHrInicio(DataHoraRN.setHoraNaData(inicio, DataHoraRN.getApenasHoras(inicio), 0, 0));
		retorno.setDtHrFim(DataHoraRN.setHoraNaData(fim, DataHoraRN.getApenasHoras(fim), 0, 0));
		return retorno;
	}

}
