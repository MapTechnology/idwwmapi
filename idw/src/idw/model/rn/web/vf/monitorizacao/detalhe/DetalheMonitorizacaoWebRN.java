package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpentsai;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.detalhemonitorizacao.EnergiaConsumidaProducaoDTO;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.webservices.dto.CIPDTO;
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
import idw.webservices.rest.idw.v2.dto.AlertaFichaPtDTO;
import idw.webservices.rest.idw.v2.dto.CIPFichaPtDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebRN extends AbstractRN<DAOGenerico> {
	
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
	
	public static final String LISTA_DETALHE_SEMFILTRO = "SEM FILTRO";
	public static final String LISTA_DETALHE_TODOSOSTURNOS = "Todos os turnos";
	public static final String LISTA_DETALHE_CICLO = "Ciclo";
	public static final String LISTA_DETALHE_REFUGO = "Refugo";
	public static final String LISTA_DETALHE_PARADA = "Parada";
	public static final String LISTA_DETALHE_CAVINATIVAS = "Cav. Inativas";

			
	public enum FiltroOp {
		ULTIMA_OP_NO_TURNO(0),
		TODAS_AS_OPS_NO_TURNO(1),
		ULTIMA_OP_ACUMULADO(2);
		
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
	DetalheMonitorizacaoWebIndicadorRN indicadorRN;
	private List<MetaIndicadorDTO> listaMetaIndicadores;

	public DetalheMonitorizacaoWebRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public PtMonitorizacaoDTO getDetalhe(FiltroDetalhePTInjetDTO filtro) throws PostoSemDadoException {
    	PtMonitorizacaoDTO ptDTO = new PtMonitorizacaoDTO();
    	listaMetaIndicadores = new ArrayList<MetaIndicadorDTO>();
    	
    	DetalheMonitorizacaoPTInjetDTO consultaDTO = getDetalheMonitorizacaoPTInjetDTO(filtro);
    	
    	if(consultaDTO.getListaDwConsolId() == null || consultaDTO.getListaDwConsolId().size() == 0) {
    		throw new PostoSemDadoException();
    	}
    	
    	indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(getDao(), formatoData, formatoDataHora);
    	listaMetaIndicadores = indicadorRN.getMetaIndicadores(filtro);
    	
    	ptDTO.setCdPt(consultaDTO.getOmPt().getCdPt());
    	ptDTO.setDsPt(consultaDTO.getOmPt().getDsPt());
    	ptDTO.setDsView(consultaDTO.getOmPt().getDsCurta());
    	ptDTO.setData(consultaDTO.getDtReferencia());
    	
    	// no vf-desktop a ferramenta vem de FiltroDetalhePTInjetDTO.getDwRap().getCdRap()
    	// como eu não utilizo esse campo por enquanto no vf-web o valor de ferramenta é: SEM FILTRO
    	// talvez seja necessario alterar no futuro
    	ptDTO.setFerramenta(LISTA_DETALHE_SEMFILTRO);
    	
    	ptDTO.setFiltroQuantidadeRefugada(ConversaoTipos.converteParaString(consultaDTO.getQtdRefugadas(), 2));
    	ptDTO.setOpSelecionada(consultaDTO.getOrdemproducao());
    	
    	ptDTO.setCdFolha(consultaDTO.getDwFolha().getCdFolha());
    	
    	ptDTO.setMetaHora(ConversaoTipos.converteParaString(consultaDTO.getMetaHora(), 0));
    	ptDTO.setCavidadesAtivasView(consultaDTO.getCav_ativas());
    	
    	if(consultaDTO.getDwTurno() != null) {
    		ptDTO.setTurno(consultaDTO.getDwTurno().getDsTurno());
    	} else {
    		ptDTO.setTurno(LISTA_DETALHE_TODOSOSTURNOS);
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
    	ptDTO.setEnergiaConsumidaProducao(getEnergiaConsumidaProducao(consultaDTO));
    	
    	ptDTO.setAlertasManuais(getAlertasManuais(consultaDTO));
    	ptDTO.setAlertasAutomaticos(getAlertasAutomaticos(consultaDTO));
    	ptDTO.setCips(getCIPs(consultaDTO));
    	
    	return ptDTO;
    }
    
    public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPTInjetDTO(FiltroDetalhePTInjetDTO filtro) {
    	DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN(getDao());
    	return rn.getDetalheMonitorizacaoPtInjetDTO(filtro);
    }
    
    public Date getInicioPeriodo(List<DwConsolid> lista) {
    	Date inicio = null;
    	for(DwConsolid id : lista) {
    		if(inicio == null) {
    			inicio = id.getDthrCadastro();
    		} else {
    			if(id.getDthrCadastro().before(inicio)) {
    				inicio = id.getDthrCadastro();
    			}
    		}
    	}
    	return DataHoraRN.setHoraNaData(inicio, DataHoraRN.getApenasHoras(inicio), 0, 0);
    }
    
    public Date getFimPeriodo(List<DwConsolid> lista) {
    	Date fim = null;
    	for(DwConsolid id : lista) {
    		Date fimTemporario = id.getDthrFconsol() != null ? id.getDthrFconsol() : id.getDthrCadastro();
    		if(fim == null) {
    			fim = fimTemporario;
    		} else {
    			if(fimTemporario.after(fim)) {
    				fim = fimTemporario;
    			}
    		}
    	}
    	return DataHoraRN.setHoraNaData(fim, DataHoraRN.getApenasHoras(fim), 0, 0);
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
    	for(GraficoTempoDTO dtoGrafico : listaTemposGraficoPizza) {
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
    	
    	for(GraficoCicloDTO i : listaCiclos) {
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
    	
    	for(DetalheMonitorizacaoPTInjetDTO turno : dto.getListaTurnos()) {
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
    	
    	if(dto.getOpsNoTurno() != null) {
    		for(PpCp ppCp : dto.getOpsNoTurno()) {
        		OpDTO opDTO = new OpDTO();
        		opDTO.setCdCp(ppCp.getCdCp());
        		opDTO.setNrDoc(ppCp.getNrop());
        		
        		String opView = opDTO.getNrDoc();
        		if(opView.equals("")) {
        			opView = opDTO.getCdCp();
        		}    		
        		String opDataHoraView = opView + " - " + DataHoraRN.dateToString(ppCp.getDthrInicioreal(), formatoDataHora);
        		
        		opDTO.setOpView(opView);
        		opDTO.setOpDataHoraView(opDataHoraView);
        		
        		opsDTO.add(opDTO);
        	}
    	}
    	
    	return opsDTO;
    }
    
    private List<PtProdutoDTO> getProdutos(DetalheMonitorizacaoPTInjetDTO dto) {
    	List<PtProdutoDTO> listaRetorno = new ArrayList<PtProdutoDTO>();
    	
    	List<ProdutoDTO> listaProdutos = dto.getListaProdutos();
    	for(ProdutoDTO produto : listaProdutos) {
    		PtProdutoDTO produtoDTO = new PtProdutoDTO();
    		
    		produtoDTO.setDtReferencia(DataHoraRN.dateToString(produto.getDtReferencia(), formatoData));
    		
    		if(produto.getMaquina().getDwFolha() != null) {
    			produtoDTO.setFolha(produto.getMaquina().getDwFolha().getCdFolha());
    		} else {
    			produtoDTO.setFolha("");
    		}
    		
    		if(produto.getDsTurno() != null) {
    			produtoDTO.setTurno(produto.getDsTurno());
    		} else {
    			produtoDTO.setTurno("");
    		}
    		
    		produtoDTO.setPosto(produto.getMaquina().getCdPt());
    		
    		if(produto.getOrdemproducao() != null) {
    			if(!produto.getOrdemproducao().getNrop().equals("")) {
    				produtoDTO.setCp(produto.getOrdemproducao().getNrop());
    			} else {
    				produtoDTO.setCp(produto.getOrdemproducao().getCdCp());
    			}    			
    		} else {
    			produtoDTO.setCp("");
    		}   		
    		
    		produtoDTO.setDtInicioProducao(produto.getDtInicioProducao());    		
    		produtoDTO.setProduto(produto.getProduto().getCdProduto() + "/" + produto.getProduto().getDsProduto());    		
    		
    		if(produto.getTempoAtivo() != null && produto.getTempoAtivo().doubleValue() > 0) {
    			produtoDTO.setTempoDisponivel(DataHoraRN.formatSegundosParaHHMMSS(produto.getTempoAtivo().intValue()));
    		} else {
    			produtoDTO.setTempoDisponivel(DataHoraRN.ZERADO_HHMMSS);
    		}
    		
    		if(produto.getMetaInstantanea().longValue() < 0l) {
    			produtoDTO.setProducaoPrevista("");
    		} else {
    			produtoDTO.setProducaoPrevista(ConversaoTipos.converteParaString(produto.getMetaInstantanea(), 0));
    		}
    		
    		produtoDTO.setProducaoBruta(ConversaoTipos.converteParaStringCasasOpcionais(produto.getPcsProducaobruta(), 2));
    		produtoDTO.setProducaoLiquida(ConversaoTipos.converteParaStringCasasOpcionais(produto.getPcsProducaoliquida(), 2));
    		if(produto.getMetaInstantanea().longValue() < 0l) {
    			produtoDTO.setSaldoAProduzir("0");
    		} else {
    			produtoDTO.setSaldoAProduzir(ConversaoTipos.converteParaString(produto.getAproduzir(), 0));
    		}
    		produtoDTO.setProducaoRefugada(ConversaoTipos.converteParaStringCasasOpcionais(produto.getPcsProducaoRefugada(), 2));
    		produtoDTO.setEficienciaRealizacao(ConversaoTipos.converteParaString(produto.getEficiencia(), 2, true));
    		produtoDTO.setCicloPadrao(ConversaoTipos.converteParaString(produto.getCicloPadrao(), 2, true));
    		produtoDTO.setCicloMedio(ConversaoTipos.converteParaString(produto.getCicloMedio(), 2, true));
    		produtoDTO.setUltimoCiclo(ConversaoTipos.converteParaString(produto.getUltimoCiclo(), 2, true));
    		produtoDTO.setDtRevisaoFolha(DataHoraRN.dateToString(produto.getDtRevisaoFolha(), formatoDataHora));
    		
    		if(produto.getQtdAtiva() != null) {
    			produtoDTO.setProducaoOuCiclo(ConversaoTipos.converteParaString(produto.getQtdAtiva(), 0));
    		} else {
    			produtoDTO.setProducaoOuCiclo("");
    		}
    		
    		if(produto.getCalendario() != null) {
    			produtoDTO.setCalendario(produto.getCalendario().getCdCal() + "/" + produto.getCalendario().getRevisao());
    		} else {
    			produtoDTO.setCalendario("");
    		}
    		
    		if(produto.getDwpepro() != null) {
    			produtoDTO.setPeriodoProdutivo(produto.getDwpepro().getDsPepro()); 
    		} else {
    			produtoDTO.setPeriodoProdutivo(""); 
    		}
    		   		
    		
    		listaRetorno.add(produtoDTO);
    	}
    	
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
    	
    	for(idw.webservices.dto.OperadorDTO operador : dto.getListaOperadores()) {
    		OperadorDTO operadorDTO = new OperadorDTO();
    		operadorDTO.setCdUsr(operador.getOmUsr().getCdUsr());
    		operadorDTO.setLogin(operador.getOmUsr().getLogin());
    		operadorDTO.setDsApelido(operador.getOmUsr().getDsApelido());
    		operadorDTO.setDsNome(operador.getOmUsr().getDsNome());
    		operadorDTO.setDtHrLogin(DataHoraRN.dateToString(operador.getDthrIlogin(), formatoDataHora));
    		operadorDTO.setDtHrLogout(DataHoraRN.dateToString(operador.getDthrFlogin(), formatoDataHora));
    		
    		operadores.add(operadorDTO);
    	}
    	
    	return operadores;
    }
    
    private List<AlertaDTO> getAlertas(DetalheMonitorizacaoPTInjetDTO dto) {
    	List<AlertaDTO> alertas = new ArrayList<AlertaDTO>();
    	
    	for(idw.webservices.dto.AlertaDTO alerta : dto.getListaAlertas()) {
    		AlertaDTO alertaDTO = new AlertaDTO();
    		alertaDTO.setCdAlerta(alerta.getDwTAlerta().getCdTalerta());
    		alertaDTO.setDsAlerta(alerta.getDwTAlerta().getDsTalerta());
    		alertaDTO.setDtHrInicio(DataHoraRN.dateToString(alerta.getDthrIalerta(), formatoDataHora));
    		alertaDTO.setDtHrFim(DataHoraRN.dateToString(alerta.getDthrFalerta(), formatoDataHora));
    	
    		alertas.add(alertaDTO);
    	}
    	
    	return alertas;
    }
    
    
    private List<AlertaFichaPtDTO> getAlertasManuais(DetalheMonitorizacaoPTInjetDTO dto) {
    	List<AlertaFichaPtDTO> alertas = new ArrayList<AlertaFichaPtDTO>();
    	
    	for(idw.webservices.dto.AlertaDTO alerta : dto.getListaAlertas()) {
    	    if (alerta.getDwTAlerta() != null && alerta.getDwTAlerta().getIsAutomatico() != null && alerta.getDwTAlerta().getIsAutomatico() == false) {
    	           
        		AlertaFichaPtDTO alertaDTO = new AlertaFichaPtDTO();
        		alertaDTO.setCdPt(dto.getMaquina());
        		alertaDTO.setCdAlerta(alerta.getDwTAlerta().getCdTalerta());
        		alertaDTO.setDsAlerta(alerta.getDwTAlerta().getDsTalerta());
        		alertaDTO.setDthrIniAlerta(DataHoraRN.dateToString(alerta.getDthrIalerta(), formatoDataHora));
        		alertaDTO.setDthrFimAlerta(DataHoraRN.dateToString(alerta.getDthrFalerta(), formatoDataHora));	
        		
        		alertas.add(alertaDTO);
    		}
    		
    	}
    	
    	return alertas;
    }
    
    private List<AlertaFichaPtDTO> getAlertasAutomaticos(DetalheMonitorizacaoPTInjetDTO dto) {
    	List<AlertaFichaPtDTO> alertas = new ArrayList<AlertaFichaPtDTO>();
    	
    	for(idw.webservices.dto.AlertaDTO alerta : dto.getListaAlertas()) {
            if (alerta.getDwTAlerta() != null && alerta.getDwTAlerta().getIsAutomatico() != null && alerta.getDwTAlerta().getIsAutomatico() == true) {
                  	           
        		AlertaFichaPtDTO alertaDTO = new AlertaFichaPtDTO();
        		alertaDTO.setCdPt(dto.getMaquina());
        		alertaDTO.setCdAlerta(alerta.getDwTAlerta().getCdTalerta());
        		alertaDTO.setDsAlerta(alerta.getDwTAlerta().getDsTalerta());
        		alertaDTO.setDthrIniAlerta(DataHoraRN.dateToString(alerta.getDthrIalerta(), formatoDataHora));
        		alertaDTO.setDthrFimAlerta(DataHoraRN.dateToString(alerta.getDthrFalerta(), formatoDataHora));	
        		alertaDTO.setNmUsrResp(alerta.getUsuario());
        		alertaDTO.setObservacao(alerta.getObservacao());
        		        		
        		alertas.add(alertaDTO);
    		}
    		
    	}
    	
    	return alertas;
    }
    
    private List<CIPFichaPtDTO> getCIPs(DetalheMonitorizacaoPTInjetDTO dto) {
    	List<CIPFichaPtDTO> listaCIPs = new ArrayList<CIPFichaPtDTO>();
    	
    	for(CIPDTO itemCIP : dto.getListacips()) {
    		CIPFichaPtDTO cip = new CIPFichaPtDTO();
    		
            if (itemCIP.getInicioCIP() != null) {
            	cip.setDthrIniCIP(DataHoraRN.dateToStringDDMMYYYYHHMMSS(itemCIP.getInicioCIP()));
            }
            if (itemCIP.getFimCIP() != null) {
            	cip.setDthrFimCIP(DataHoraRN.dateToStringDDMMYYYYHHMMSS(itemCIP.getFimCIP()));
            }
            if (itemCIP.getInicioParada() != null) {
            	cip.setDthrIniParCIP(DataHoraRN.dateToStringDDMMYYYYHHMMSS(itemCIP.getInicioParada()));
            }
            if (itemCIP.getFimParada() != null) {
            	cip.setDthrFimCIP(DataHoraRN.dateToStringDDMMYYYYHHMMSS(itemCIP.getFimParada()));
            }
            if (itemCIP.getInicioUsuario() != null) {
            	cip.setCdUsrIniCiP(itemCIP.getInicioUsuario().getCdUsr());
            	cip.setNmUsrIniCiP(itemCIP.getInicioUsuario().getDsNome());
            }
            if (itemCIP.getFimUsuario() != null) {
            	cip.setCdUsrFimCiP(itemCIP.getFimUsuario().getCdUsr());
            	cip.setDthrFimCIP(itemCIP.getFimUsuario().getDsNome());
            }
            
            listaCIPs.add(cip);
    	}
    	
    	return listaCIPs;
    }
    
    private List<PerdaProducaoDTO> getPerdasProducao(DetalheMonitorizacaoPTInjetDTO dto) {
    	List<PerdaProducaoDTO> listaPerdas = new ArrayList<PerdaProducaoDTO>();
    	
    	for(PerdasDTO perdas : dto.getListaPerdas()) {
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
    	
    	BigDecimal perdaCicloValor = new BigDecimal(dto.getPerdasCiclos());
    	BigDecimal perdaRefugoValor = new BigDecimal(dto.getQtdRefugadas());
    	BigDecimal perdaParadaValor = new BigDecimal(dto.getPerdasParadas());
    	BigDecimal perdaCIValor = new BigDecimal(dto.getPci());
    	
    	boolean isConsiderarPerdaCiclo = dto.getPerdasCiclos() >= 0;
    	
    	BigDecimal perdaTotal = BigDecimal.ZERO;
    	if (isConsiderarPerdaCiclo) {
    		perdaTotal = perdaTotal.add(perdaCicloValor);
    	}
    	perdaTotal = perdaTotal.add(perdaRefugoValor);
    	perdaTotal = perdaTotal.add(perdaParadaValor);
    	perdaTotal = perdaTotal.add(perdaCIValor);
    	
    	GraficoPizzaDTO perdaCiclo = new GraficoPizzaDTO();
    	perdaCiclo.setCodigo(LISTA_DETALHE_CICLO);
    	perdaCiclo.setValor(ConversaoTipos.converteParaString(perdaCicloValor, 2));
    	if (isConsiderarPerdaCiclo) {
    		perdaCiclo.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaCicloValor, perdaTotal), 2));
    	} else {
    		perdaCiclo.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(BigDecimal.ZERO, perdaTotal), 2));
    	}
    	perdaCiclo.setCor(Cor.transformarParaCodigoHexadecimal(new Color(51,255,51)));
    	
    	GraficoPizzaDTO perdaRefugo = new GraficoPizzaDTO();
    	perdaRefugo.setCodigo(LISTA_DETALHE_REFUGO);
    	perdaRefugo.setValor(ConversaoTipos.converteParaString(perdaRefugoValor, 2));
    	perdaRefugo.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaRefugoValor, perdaTotal), 2));
    	perdaRefugo.setCor(Cor.transformarParaCodigoHexadecimal(new Color(255,153,153)));
    	
    	GraficoPizzaDTO perdaParada = new GraficoPizzaDTO();
    	perdaParada.setCodigo(LISTA_DETALHE_PARADA);
    	perdaParada.setValor(ConversaoTipos.converteParaString(perdaParadaValor, 2));
    	perdaParada.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaParadaValor, perdaTotal), 2));
    	perdaParada.setCor(Cor.transformarParaCodigoHexadecimal(new Color(255,51,51)));
    	
    	GraficoPizzaDTO perdaCavidadesInativas = new GraficoPizzaDTO();
    	perdaCavidadesInativas.setCodigo(LISTA_DETALHE_CAVINATIVAS);
    	perdaCavidadesInativas.setValor(ConversaoTipos.converteParaString(perdaCIValor, 2));
    	perdaCavidadesInativas.setIndice(ConversaoTipos.converteParaString(AritmeticaUtil.calcularPorcentagem(perdaCIValor, perdaTotal), 2));
    	perdaCavidadesInativas.setCor(Cor.transformarParaCodigoHexadecimal(new Color(102,153,255)));
    	
    	listaPerdas.add(perdaCiclo);
    	listaPerdas.add(perdaRefugo);
    	listaPerdas.add(perdaParada);
    	listaPerdas.add(perdaCavidadesInativas);
    	return listaPerdas;
    }
    
    private PtMateriaPrimaResumo getMateriaPrimaResumo(DetalheMonitorizacaoPTInjetDTO dto) {
    	PtMateriaPrimaResumo mpResumo = new PtMateriaPrimaResumo();
    	mpResumo.setConsumoProducaoBruta(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoBruta().doubleValue(), 0, true));
    	mpResumo.setConsumoProducaoLiquida(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoLiquira().doubleValue(), 0, true));
    	mpResumo.setConsumoProducaoRefugada(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoRefugada().doubleValue(), 0, true));
    	mpResumo.setCustoTotalInsercao(ConversaoTipos.converteParaString(dto.getCustoMPTotalDeInsercao().doubleValue(), 2, true));
    	mpResumo.setCustoTotalPerda(ConversaoTipos.converteParaString(dto.getCustoMPTotalDePerdas().doubleValue(), 2, true));
    	mpResumo.setCustoTotalInsercaoLiquida(ConversaoTipos.converteParaString(dto.getCustoMPTotalDeInsercaoLiquida().doubleValue(), 2, true));    	
    	mpResumo.setQuantidadeTotalInsercoes(ConversaoTipos.converteParaString(dto.getConsumoMPProducaoBruta().doubleValue(), 0, true));
    	
    	return mpResumo;
    }
    
    private List<MpBrutaPostoDTO> getGraficoInsercoesMp(DetalheMonitorizacaoPTInjetDTO dto) {
    	
    	List<MpBrutaPostoDTO> graficoInsercoesMp = new ArrayList<>();
    	for(MpBrutaPorMaquinaDTO mp : dto.getListaMpBrutaPorMaquina()) {
    		MpBrutaPostoDTO mpDTO = new MpBrutaPostoDTO();
    		mpDTO.setPosto(mp.getMaquina());
    		mpDTO.setMateriaPrimaBruta(ConversaoTipos.converteParaString(mp.getMateriaPrimaBruta().doubleValue(), 0, true));
    		graficoInsercoesMp.add(mpDTO);
    	}
    	return graficoInsercoesMp;
    }
    
    private List<PtEnergiaDTO> getEnergiaConsumidaProducao(DetalheMonitorizacaoPTInjetDTO dto) {
    	List<PtEnergiaDTO> retorno = new ArrayList<PtEnergiaDTO>();
    	
    	for(EnergiaConsumidaProducaoDTO itemDTO : dto.getEnergiaConsumidaProducao()) {
    		PtEnergiaDTO energia = new PtEnergiaDTO();
    		energia.setOrdemProducao(itemDTO.getNrop());
    		energia.setProducaoBrutaKwh(ConversaoTipos.converteParaString(itemDTO.getProducaoBrutaKwh(), 0));
    		energia.setProducaoLiquidaKwh(ConversaoTipos.converteParaString(itemDTO.getProducaoLiquidaKwh(), 0));
    		energia.setProducaoRefugadaKwh(ConversaoTipos.converteParaString(itemDTO.getProducaoRefugadaKwh(), 0));
    		energia.setCustoKwhProducaoBruta(ConversaoTipos.converteParaString(itemDTO.getProducaoBrutaValormonetario(), 0));
    		energia.setCustoKwhProducaoLiquida(ConversaoTipos.converteParaString(itemDTO.getProducaoLiquidaValormonetario(), 0));
    		energia.setCustoKwhProducaoRefugada(ConversaoTipos.converteParaString(itemDTO.getProducaoRefugadaValormonetario(), 0));
    		energia.setEnergiaConsumidaKwh(ConversaoTipos.converteParaString(itemDTO.getKwh(), 3));
    		energia.setProducaoBruta(ConversaoTipos.converteParaString(itemDTO.getProducaoBruta(), 0));
    		energia.setProducaoLiquida(ConversaoTipos.converteParaString(itemDTO.getProducaoLiquida(), 0));
    		energia.setProducaoRefugada(ConversaoTipos.converteParaString(itemDTO.getProducaoRefugada(), 0));
    		
    		retorno.add(energia);
    	}
    	
    	return retorno;
    }

}
