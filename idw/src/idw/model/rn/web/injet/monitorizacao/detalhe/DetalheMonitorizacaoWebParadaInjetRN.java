package idw.model.rn.web.injet.monitorizacao.detalhe;

//TODO: 201804 A confirmar se usa mesmo este (e OUTROS semelhantes) [DetalheMonitorizacaoWebIndicadorRN do vf] ou [DetalheMonitorizacaoWebIndicadorInjetRN do injet]


import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.IdwFacade;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoParadaDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
import idw.model.rn.monitorizacao.injet.GraficoParettoParadaInjetRN;
import idw.model.rn.monitorizacao.injet.GraficoRecorrenciaInjetFactory;
import idw.model.rn.monitorizacao.injet.GraficoRecorrenciaParadaInjetRN;
import idw.model.rn.monitorizacao.injet.OcorrenciaParettoParadaInjetRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.FiltroWebRN;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.webservices.dto.DetalhamentoParadaDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DetalheParadaDTO;
import idw.webservices.dto.DetalheRecorrenciaParadaDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIItemRecorrenciaDTO;
import idw.webservices.dto.GraficoBIRecorrenciaDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheOcorrenciasDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheParadaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoParadaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoParadaDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRecorrenciaDTO;
import idw.webservices.rest.dto.monitorizacao.ItemRecorrenciaDTO;
import idw.webservices.rest.dto.monitorizacao.ItemRecorrenciaParadaDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDataHoraDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaParadaHoraDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebParadaInjetRN extends AbstractRN<DAOGenericoInjet> {
	
	public static final Color COR_LEGENDA_VERDE = Color.green;
	public static final Color COR_LEGENDA_AMARELO = Color.yellow;
	public static final Color COR_LEGENDA_LARANJA = Color.orange;
	public static final Color COR_LEGENDA_VERMELHO = Color.red;

	private final String formatoData;
	private final String formatoDataHora;
	
	public static final Comparator<GraficoParettoParadaDTO> comparaPorTempo = new Comparator<GraficoParettoParadaDTO>() {
		@Override
        public int compare(GraficoParettoParadaDTO o1, GraficoParettoParadaDTO o2) {
			return o1.getTempo().compareTo(o2.getTempo()) * -1;
        }
    };
	
	public DetalheMonitorizacaoWebParadaInjetRN(String formatoData, String formatoDataHora) {
        this(new DAOGenericoInjet(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebParadaInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public GraficoParadaDTO getParadas(FiltroDetalheParadaDTO filtro) throws RegistroDesconhecidoException {
    	GraficoParadaDTO paradasDTO = new GraficoParadaDTO();
    	
    	GraficoParettoParadaInjetRN rn = new GraficoParettoParadaInjetRN(getDao());
    	GraficosParettoParadaDTO consultaDTO = 
    			rn.getGraficoParettoParadaDTO(
    					DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData), 
    					new BigDecimal(filtro.getIdTurno()),
    					filtro.getCdPosto(),
    					filtro.isMostrarParadaComPeso(),
    					filtro.isMostrarParadaSemPeso(),
    					BigDecimal.ZERO,
    					"",              
    					filtro.getFiltroOp() == 0,
    					filtro.getCdCp());
    	
    	paradasDTO.setDetalhes(getDetalhes(consultaDTO));
    	paradasDTO.setLegendas(getLegendas(consultaDTO));
    	paradasDTO.setLimiteParadas(5);
    	if(consultaDTO.getParadas() == null) {
    		paradasDTO.setQuantidadeTotalParadas(0);
    	} else {
    		paradasDTO.setQuantidadeTotalParadas(consultaDTO.getParadas().size());
    	}
    	    	
    	return paradasDTO;
    }
    
    private List<GraficoParadaDetalheDTO> getDetalhes(GraficosParettoParadaDTO dto) {
    	List<GraficoParadaDetalheDTO> detalhes = new ArrayList<GraficoParadaDetalheDTO>();
    	
    	Collections.sort(dto.getParadas(), comparaPorTempo);
    	
    	List<GraficoParettoParadaDTO> listaParcial = getParadasMostraParcial(5, dto.getParadas());
    	
    	Double tempoTotal = 0d;
    	for (GraficoParettoParadaDTO parada : listaParcial) {
    		tempoTotal += parada.getTempo();
    	}
    	
    	for (GraficoParettoParadaDTO parada : listaParcial) {
    		GraficoParadaDetalheDTO paradaDTO = new GraficoParadaDetalheDTO();
    		paradaDTO.setCdParada(parada.getCdParada());
    		paradaDTO.setDsParada(parada.getDsParada());
    		paradaDTO.setTempoParada(DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(parada.getTempo()));
    		paradaDTO.setIndiceParada(ConversaoTipos.converteParaString(
    				AritmeticaUtil.calcularPorcentagem(
    						new BigDecimal(parada.getTempo()),
    						new BigDecimal(tempoTotal)),
    						2));
    		paradaDTO.setIndiceParadaCor(Cor.transformarColorParaCodigoHexadecimal(parada.getCorBarra()));
    		
    		detalhes.add(paradaDTO);
    	}
    	
    	
		Collections.sort(detalhes,
				new Comparator<GraficoParadaDetalheDTO>() {
					@Override
					public int compare(final GraficoParadaDetalheDTO o1,
							final GraficoParadaDetalheDTO o2) {
						final GraficoParadaDetalheDTO item1 = o1;
						final GraficoParadaDetalheDTO item2 = o2;

						return -(ConversaoTipos.converteParaDouble(item1.getIndiceParada()).compareTo(ConversaoTipos.converteParaDouble(item2.getIndiceParada())));
					}
				});
    	
    	
    	return detalhes;
    }
    
    private List<LegendaDataHoraDTO> getLegendas(GraficosParettoParadaDTO datas) {
    	List<LegendaDataHoraDTO> legendas = new ArrayList<LegendaDataHoraDTO>();
    	
    	if(datas.getCorVerde() != null) {
    		LegendaDataHoraDTO legendaVerde = getLegenda(datas.getCorVerde());
        	legendaVerde.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERDE));
        	legendas.add(legendaVerde);
    	}
    	
    	if(datas.getCorAmarela() != null) {
    		LegendaDataHoraDTO legendaAmarelo = getLegenda(datas.getCorAmarela());
        	legendaAmarelo.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_AMARELO));
        	legendas.add(legendaAmarelo);
    	}
    	
    	if(datas.getCorLaranja() != null) {
    		LegendaDataHoraDTO legendaLaranja = getLegenda(datas.getCorLaranja());
        	legendaLaranja.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_LARANJA));
        	legendas.add(legendaLaranja);
    	}
    	
    	if(datas.getCorVermelho() != null) {
    		LegendaDataHoraDTO legendaVermelho = getLegenda(datas.getCorVermelho());
        	legendaVermelho.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERMELHO));
        	legendas.add(legendaVermelho);
    	}
    	
    	return legendas;
    }
    
    private LegendaDataHoraDTO getLegenda(DatasDTO data) {
    	LegendaDataHoraDTO legendaDTO = new LegendaDataHoraDTO();
    	legendaDTO.setDataHoraInicio(DataHoraRN.dateToString(data.getDtIAtendimento(), formatoDataHora));
    	legendaDTO.setDataHoraFim(DataHoraRN.dateToString(data.getDtFAtendimento(), formatoDataHora));
    	return legendaDTO;
    }
    
    private List<GraficoParettoParadaDTO> getParadasMostraParcial(int limite, List<GraficoParettoParadaDTO> lista) {
        List<GraficoParettoParadaDTO> paradas = new ArrayList<>();
        
        int quantidadeDeParadasTotal = lista == null ? 0 : lista.size();
        if(quantidadeDeParadasTotal > limite) {
            quantidadeDeParadasTotal = limite;
        }
        
        int contador = 0;
        for(GraficoParettoParadaDTO dto : lista) {
            contador++;
            paradas.add(dto);
            if(contador == quantidadeDeParadasTotal) {
                break;
            }
        }
        
        return paradas;
    }
    

    // fonte Netbeans: DetalheProducaoMain.gerarGraficoIndiceParada()
    public GraficoParadaDTO getParadasHora(FiltroDetalheParadaDTO filtro) throws RegistroDesconhecidoException {
    	GraficoParadaDTO paradasDTO = new GraficoParadaDTO();
    	
    	GraficoParettoParadaInjetRN paradaRN = new GraficoParettoParadaInjetRN(getDao());
    	GraficosParettoParadaDTO consultaDTO = paradaRN.getGraficoParettoParadaBIDTO(
    			converter(filtro), 
				filtro.isMostrarParadaComPeso(),
				filtro.isMostrarParadaSemPeso(),
				new BigDecimal(filtro.getHorasParadas()));    	
    	paradasDTO.setDetalhes(getDetalhes(consultaDTO));
    	paradasDTO.setLegendas(getLegendas(consultaDTO));
    	
    	return paradasDTO;
    }
    
    public DetalheOcorrenciasDTO getParadaOcorrencia(FiltroDetalheParadaDTO filtro) throws RegistroDesconhecidoException {
		List<TabelaParadaHoraDTO> lista = new ArrayList<TabelaParadaHoraDTO>();
		
		/*
		Date dataHoraFim =  DataHoraRN.getDataHoraAtual();
		dataHoraFim = DataHoraRN.setHoraNaData(dataHoraFim, DataHoraRN.getApenasHoras(dataHoraFim), 0, 0);
		dataHoraFim = DataHoraRN.adicionaHorasDaData(dataHoraFim, 1);
		Date dataHoraInicio = DataHoraRN.subtraiDiasDaData(dataHoraFim, 1);
		*/
		
		FiltroWebInjetRN filtroRN = new FiltroWebInjetRN(getDao(), formatoData, formatoDataHora);
		DetalheMonitorizacaoWebInjetRN detalheRN = new DetalheMonitorizacaoWebInjetRN(getDao(), formatoData, formatoDataHora);
		DetalheMonitorizacaoPTInjetDTO detalhe = detalheRN.getDetalheMonitorizacaoPTInjetDTO(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro, filtro.isMostrarParadaComPeso(), filtro.isMostrarParadaSemPeso()));		
		
		
		PeriodoDTO periodo = detalheRN.getInicioFimPeriodo(detalhe.getListaDwConsolId());		
		Date dataHoraInicio = periodo.getDtHrInicio(); 
		Date dataHoraFim =  periodo.getDtHrFim();
		dataHoraFim = DataHoraRN.adicionaHorasDaData(dataHoraFim, 1);
		
		FiltroWebRN.completarHorasDasDatas(filtro);
		
		OcorrenciaParettoParadaInjetRN rn = new OcorrenciaParettoParadaInjetRN(getDao());

		DetalhamentoParadaDTO consultaDTO = rn.getOcorrenciaParetoParadaFichaMaqDTO(
				filtro.getTpId(),
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora),
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora),
				new BigDecimal(filtro.getIdTurno()),
				filtro.getCdPosto(),
				filtro.getCdGt(),
				filtro.getCdCp(),
				filtro.isMostrarParadaComPeso(),
				filtro.isMostrarParadaSemPeso(),
				filtro.getCdParada(),
				filtro.getCdArea(),
				filtro.getFiltroOp());

		
		DetalhamentoParadaDTO consultaTodasDTO = rn.getOcorrenciaParetoParadaFichaMaqDTO(
				filtro.getTpId(),
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora),
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora),
				new BigDecimal(filtro.getIdTurno()),
				filtro.getCdPosto(),
				filtro.getCdGt(),
				filtro.getCdCp(),
				filtro.isMostrarParadaComPeso(),
				filtro.isMostrarParadaSemPeso(),
				null,
				filtro.getCdArea(),
				filtro.getFiltroOp());
		
		Map<String, Double> mapDuracaoParada = new HashMap<String, Double>();
		Map<String, Double> mapPerdasParada = new HashMap<String, Double>();

		Map<String, Double> mapDuracaoParadaSelecionada = new HashMap<String, Double>();
		Map<String, Double> mapPerdasParadaSelecionada = new HashMap<String, Double>();
		
		Double duracaoTotalComPeso = 0d;
		Double duracaoTotalSemPeso = 0d;
		for(DetalheParadaDTO parada : consultaTodasDTO.getListaparadas()) {
			BigDecimal duracaoParadaHoras = ConversaoTipos.converteHoraParaBigDecimal(parada.getDuracao());
			
			this.add(parada.getParada(), duracaoParadaHoras.doubleValue(), mapDuracaoParada);
			this.add(parada.getParada(), parada.getPerdas_paradas(), mapPerdasParada);
			

			if (parada.isComPeso()) {
				duracaoTotalComPeso += duracaoParadaHoras.doubleValue();
			}
			if (!parada.isComPeso()) {
				duracaoTotalSemPeso += duracaoParadaHoras.doubleValue();
			}				
		}

		Double duracaoParada = 0d;
		for(DetalheParadaDTO parada : consultaDTO.getListaparadas()) {
			BigDecimal duracaoParadaHoras = ConversaoTipos.converteHoraParaBigDecimal(parada.getDuracao());
			
			this.add(parada.getParada(), duracaoParadaHoras.doubleValue(), mapDuracaoParadaSelecionada);
			this.add(parada.getParada(), parada.getPerdas_paradas(), mapPerdasParadaSelecionada);
			
			duracaoParada += duracaoParadaHoras.doubleValue();			
		}
		
		for(DetalheParadaDTO parada : consultaDTO.getListaparadas()) {
			TabelaParadaHoraDTO dto = new TabelaParadaHoraDTO();
			dto.setPosto(parada.getDsPt());
			dto.setFolha(parada.getFolha());
			dto.setFerramenta(parada.getFerramenta());
			dto.setParada(parada.getParada());
			dto.setInicio(DataHoraRN.dateToString(parada.getInicio(), formatoDataHora));
			dto.setFim(DataHoraRN.dateToString(parada.getFim(), formatoDataHora));
			dto.setDuracao(parada.getDuracao());
			dto.setAreaResponsavel(parada.getArea_resp() != null ? parada.getArea_resp().getCdArea() + "-" + parada.getArea_resp().getDsArea() : "");
			dto.setCausa(parada.getCausa());
			dto.setAcao(parada.getAcao());
			dto.setJustificativa(parada.getJustificativa());
			dto.setTecnico1(parada.getTecnico1());
			dto.setTecnico2(parada.getTecnico2());
			dto.setTecnicoResponsavel(parada.getTecnico_responsavel());
			dto.setPerdasParada(ConversaoTipos.converteParaString(parada.getPerdas_paradas(), 2));
			dto.setTurno(parada.getTurno());
			
			FiltroDetalheParadaDTO filtroDetalheParada = new FiltroDetalheParadaDTO();
			FiltroWebRN.duplicar(filtro, filtroDetalheParada);
			
			// filtro = 0 para ficar igual a versao desktop que não utiliza o turno como filtro.
			filtroDetalheParada.setIdTurno(0);
			
			filtroDetalheParada.setDtHrReferenciaInicial(DataHoraRN.dateToString(dataHoraInicio, formatoDataHora));
			filtroDetalheParada.setDtHrReferenciaFinal(DataHoraRN.dateToString(dataHoraFim, formatoDataHora));
			filtroDetalheParada.setTpId(TpId.HORA.getValue());
			
			filtroDetalheParada.setCdParada(parada.getParada());
			filtroDetalheParada.setHorasParadas(ConversaoTipos.converteParaString(mapDuracaoParada.get(parada.getParada()), 0));
			filtroDetalheParada.setPerdasParada(ConversaoTipos.converteParaString(mapPerdasParada.get(parada.getParada()), 2));
			filtroDetalheParada.setHorasTodasParadas(ConversaoTipos.converteParaString((parada.isComPeso() ? duracaoTotalComPeso : duracaoTotalSemPeso), 0));
			filtroDetalheParada.setMostrarParadaComPeso(parada.isComPeso());
			filtroDetalheParada.setMostrarParadaSemPeso(!parada.isComPeso());
			
			
			dto.setFiltro(filtroDetalheParada);
			lista.add(dto);
		}
		
		DetalheOcorrenciasDTO retorno = new DetalheOcorrenciasDTO();
		retorno.setParadas(lista);
		retorno.setTempoTotalParadaView(DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(duracaoParada));
		
		return retorno;
	}
    
    public GraficoRecorrenciaDTO getParadaRecorrenciaPareto(FiltroDetalheParadaDTO filtro) {
		GraficoRecorrenciaDTO graficoDTO = new GraficoRecorrenciaDTO();
		
		DetalheMonitorizacaoWebIndicadorInjetRN indicadorRN = new DetalheMonitorizacaoWebIndicadorInjetRN(getDao(), formatoData, formatoDataHora);
		MetaIndicadorDTO indicador = DetalheMonitorizacaoWebIndicadorRN.getIndicadorPadraoGraficoRecorrenciaParada();
		
		List<ItemRecorrenciaDTO> itens = new ArrayList<ItemRecorrenciaDTO>();
		
		FiltroWebInjetRN filtroRN = new FiltroWebInjetRN(getDao(), formatoData, formatoDataHora);
		GraficoRecorrenciaParadaInjetRN rn = new GraficoRecorrenciaParadaInjetRN(getDao());
		GraficoBIRecorrenciaDTO consultaDTO = rn.getGraficoBIParetoRecorrencia(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro, filtro.isMostrarParadaComPeso(), filtro.isMostrarParadaSemPeso()), GraficoRecorrenciaInjetFactory.RECORRENCIA_PARADA, filtro.getCdParada());
		
		for(GraficoBIItemRecorrenciaDTO grafico : consultaDTO.getGrafico()) {
			
			ItemRecorrenciaDTO itemDTO = new ItemRecorrenciaDTO();
			
			itemDTO.setDtHrInicio(DataHoraRN.dateToString(grafico.getDthrIni(), formatoDataHora));
			itemDTO.setDtHrFim(DataHoraRN.dateToString(grafico.getDthrFim(), formatoDataHora));
			itemDTO.setParada(filtro.getCdParada());
			itemDTO.setTempoParadas(DataHoraRN.formatSegundosParaHHMMSSmmm(grafico.getSegTempoParadas()));
			itemDTO.setIndice(ConversaoTipos.converteParaString(grafico.getIndItem(), 2));
			itemDTO.setIndiceCor(indicadorRN.identificarCorDoIndicador(
        			indicador,
        			itemDTO.getIndice()));
			itemDTO.setPecas(ConversaoTipos.converteParaString(grafico.getQtdPerdida(), 2));
			itemDTO.setPecasKg(ConversaoTipos.converteParaString(grafico.getQtdPerdidaKg(), 4));
			itemDTO.setPecasTon(ConversaoTipos.converteParaString(grafico.getQtdPerdidaTon(), 4));
			
			List<ItemRecorrenciaParadaDTO> paradas = new ArrayList<ItemRecorrenciaParadaDTO>();
			for(DetalheRecorrenciaParadaDTO parada : grafico.getListaParadas()) {
				
				ItemRecorrenciaParadaDTO paradaDTO = new ItemRecorrenciaParadaDTO();
				paradaDTO.setDtHrInicio(DataHoraRN.dateToString(parada.getDtHrIniPar(), formatoDataHora));
				paradaDTO.setDtHrFim(DataHoraRN.dateToString(parada.getDtHrFimPar(), formatoDataHora));
				paradaDTO.setDuracao(DataHoraRN.formatSegundosParaHHMMSSmmm(parada.getDuracao()));
				paradaDTO.setTurno(parada.getCdTurno() + " - " + parada.getDsTurno());
				paradaDTO.setPosto(parada.getCdPt());
				paradaDTO.setFolha(parada.getCdFolha());
				paradaDTO.setProduto(parada.getCdProduto());

				paradas.add(paradaDTO);
			}
			
			itemDTO.setParadas(paradas);
			itens.add(itemDTO);
		}
		
		DetalheMonitorizacaoWebRefugoInjetRN refugoRN = new DetalheMonitorizacaoWebRefugoInjetRN(getDao(), formatoData, formatoDataHora);
		
		List<ItemRecorrenciaDTO> itensPeriodoCompleto = refugoRN.completarPeriodoComValoresVazio(
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora),
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora),
				itens);
		graficoDTO.setIndicador(indicador);
		graficoDTO.setItens(itensPeriodoCompleto);
		
		graficoDTO.setDtHrInicio(filtro.getDtHrReferenciaInicial());
		graficoDTO.setDtHrFim(filtro.getDtHrReferenciaFinal());
		graficoDTO.setTempoTotal(DataHoraRN.formatSegundosParaHHMMSS(Integer.parseInt(filtro.getHorasParadas())));
		graficoDTO.setIndice(ConversaoTipos.converteParaString(
				AritmeticaUtil.calcularPorcentagem(
				new BigDecimal(filtro.getHorasParadas()),
				new BigDecimal(filtro.getHorasTodasParadas())),
				2));
		
		if (filtro.isMostrarParadaSemPeso() == true && filtro.isMostrarParadaComPeso() == false){
			graficoDTO.setPerdaTotal("0.00");
		} else {
			graficoDTO.setPerdaTotal(filtro.getPerdasParada());
		}
		
		return graficoDTO;
	}
    
    private FiltroDetalhePTInjetDTO converter(FiltroDetalheParadaDTO filtro) {
    	FiltroDetalhePTInjetDTO filtroConvertido = new FiltroDetalhePTInjetDTO();
    	
    	DwTurno turno = new DwTurno();
    	turno.setIdTurno(filtro.getIdTurno());
    	
    	OmPt posto = new OmPt();
    	posto.setCdPt(filtro.getCdPosto());
    	
    	filtroConvertido.setOmPt(posto);
    	filtroConvertido.setOmptParaPesquisa(posto);
    	filtroConvertido.setDwTurno(turno);
    	filtroConvertido.setDthrIhora(DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora));
    	filtroConvertido.setDthrFhora(DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora));
    	filtroConvertido.setTpId(DwConsolidTemplate.TpId.HORA.getValue());
    	filtroConvertido.setIdDwConsolId(0);
    	
    	if (IdwFacade.IS_IDW_ATIVO == false) {
    		filtroConvertido.setIdDwConsolId(filtro.getIdConsolid());
    	}
    	
    	return filtroConvertido;
    }
    
    private void add(String chave, Double valor, Map<String, Double> map) {
    	Double valorAtual = map.get(chave);
    	if(valorAtual == null) {
    		valorAtual = 0d;
    	}
    	Double novoValor = valorAtual + valor;
    	map.put(chave, novoValor);
    }
}