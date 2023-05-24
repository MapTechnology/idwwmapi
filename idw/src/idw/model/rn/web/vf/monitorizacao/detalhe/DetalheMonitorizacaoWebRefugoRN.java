package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.util.ConversaoTipos;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.AbstractRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoGraficoAreaResponsavelRN;
import idw.model.rn.detalhemonitorizacao.GraficoRecorrenciaFactory;
import idw.model.rn.detalhemonitorizacao.GraficoRecorrenciaRefugoRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.monitorizacao.detalhes.GraficoParetoRefugoRN;
import idw.model.rn.monitorizacao.detalhes.OcorrenciaParetoRefugoRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorRN.IndicadoresValorPadrao;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRN.FiltroOp;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.webservices.dto.DetalhamentoRefugoDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DetalheRecorrenciaRefugoDTO;
import idw.webservices.dto.DetalheRefugoDTO;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.GraficoBIItemRecorrenciaDTO;
import idw.webservices.dto.GraficoBIRecorrenciaDTO;
import idw.webservices.dto.GraficoDetalhePtDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroGraficoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRecorrenciaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRefugoDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.ItemRecorrenciaDTO;
import idw.webservices.rest.dto.monitorizacao.ItemRecorrenciaRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDataHoraDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaRefugoHora;

public class DetalheMonitorizacaoWebRefugoRN extends AbstractRN<DAOGenerico> {
	
	public static final Color COR_LEGENDA_VERDE = Color.green;
	public static final Color COR_LEGENDA_AMARELO = Color.yellow;
	public static final Color COR_LEGENDA_LARANJA = Color.orange;
	public static final Color COR_LEGENDA_VERMELHO = Color.red;

	private final String formatoData;
	private final String formatoDataHora;
	
	public static final Comparator<GraficoRefugoDetalheDTO> comparaParaOrdenarDoMaiorParaOMenor = new Comparator<GraficoRefugoDetalheDTO>() {
		@Override
        public int compare(GraficoRefugoDetalheDTO o1, GraficoRefugoDetalheDTO o2) {
			BigDecimal b1 = new BigDecimal(o1.getIndiceRefugo());
			BigDecimal b2 = new BigDecimal(o2.getIndiceRefugo());
			return b1.compareTo(b2) * -1;
        }
    };
	
	public DetalheMonitorizacaoWebRefugoRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebRefugoRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public GraficoRefugoDTO getDetalheRefugo(FiltroGraficoRefugoDTO filtro) {
    	GraficoRefugoDTO dto = new GraficoRefugoDTO();
    	dto.setDetalhes(new ArrayList<GraficoRefugoDetalheDTO>());
    	
    	String cdCp = filtro.getCdCp();
    	if(filtro.getFiltroOp() == FiltroWebRN.TODAS_OP) {
    		cdCp = "";
    	}
    	
    	GraficoParetoRefugoRN refugoRN = new GraficoParetoRefugoRN(getDao());
    	GraficosParetoRefugosDTO consultaDTO = refugoRN.getGraficoParetoRefugoDTO(
    			filtro.getTpId(), 
    			DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData),
    			DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData),
    			new BigDecimal(filtro.getIdTurno()), 
    			filtro.getCdPosto(), 
    			cdCp, 
    			new BigDecimal(filtro.getQuantidadeRefugada()), 
    			filtro.getCdProduto());
    	
    	Double quantidadeRefugadaTotal = 0D;
    	List<GraficoRefugoDetalheDTO> detalhes = new ArrayList<GraficoRefugoDetalheDTO>();
    	for(GraficoParetoRefugosDTO refugo : consultaDTO.getRefugos()) {
    		quantidadeRefugadaTotal += refugo.getQtdRefugada();
    		detalhes.add(getDetalheRefugo(refugo));
    	}
    	
    	Collections.sort(detalhes, comparaParaOrdenarDoMaiorParaOMenor);
    	dto.setDetalhes(detalhes);
    	dto.setQuantidadeRefugadaTotal(ConversaoTipos.converteParaString(quantidadeRefugadaTotal, 2));
    	dto.setLegendas(getLegendas(consultaDTO));
    	
    	return dto;
    }
    
    public GraficoRefugoDTO getDetalheRefugosHora(FiltroDetalhePostoDTO filtro, FiltroDetalhePTInjetDTO filtroConvertido) throws RegistroDesconhecidoException {
    	List<GraficoRefugoDetalheDTO> lista = new ArrayList<GraficoRefugoDetalheDTO>();
    	
    	DetalheMonitorizacaoWebIndicadorRN indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(getDao(), formatoData, formatoDataHora);
        List<MetaIndicadorDTO> listaMetaIndicadores = indicadorRN.getMetaIndicadores(filtroConvertido);
    	
    	DetalheMonitorizacaoGraficoAreaResponsavelRN rn = new DetalheMonitorizacaoGraficoAreaResponsavelRN(getDao());
    	GraficoDetalhePtDTO consultaDTO = rn.getGraficoDetalhePtDTO(getFiltroHora(filtro));
    	
    	DwConsolidDTOs dwconsoliddtos = consultaDTO.getDwConsolidDTOs();
        List<DwConsolidDTO> listaDTO = dwconsoliddtos.getListaDwConsolidDTO();
        for (DwConsolidDTO dto : listaDTO) {
            DwConsolid dwconsolid = dto.getDwConsolid();
            if (dwconsolid != null) {
                if (dwconsolid.getDwConsols() != null) {
                    for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                        for (DwConsolre dwconsolre : dwconsol.getDwConsolres()) {

                        	Long producaoRefugadaTotal = dwconsol.getPcsAutoProducaorefugada()!= null ? dwconsol.getPcsAutoProducaorefugada().longValue() : 0l;
                            producaoRefugadaTotal += dwconsol.getPcsManuProducaorefugada()!= null ? dwconsol.getPcsManuProducaorefugada().longValue() : 0l;

                            Long producaoRefugadaMotivo = dwconsolre.getPcsAutoProducaorefugada() != null ? dwconsolre.getPcsAutoProducaorefugada().longValue() : 0l;
                            producaoRefugadaMotivo += dwconsolre.getPcsManuProducaorefugada() != null ? dwconsolre.getPcsManuProducaorefugada().longValue() : 0l;

                            Float indicerefugo = FormulasInjet.calcularIndiceRefugo(producaoRefugadaMotivo, producaoRefugadaTotal);
                                                        
                            GraficoRefugoDetalheDTO refugoDTO = new GraficoRefugoDetalheDTO();
                            refugoDTO.setCdRefugo(dwconsolre.getDwTRefugo().getCdTrefugo());
                            refugoDTO.setDsRefugo(dwconsolre.getDwTRefugo().getDsTrefugo());
                            refugoDTO.setQuantidadeRefugada(ConversaoTipos.converteParaString(producaoRefugadaMotivo.doubleValue(), 2));
                            refugoDTO.setIndiceRefugo(ConversaoTipos.converteParaString(indicerefugo, 2));
                            refugoDTO.setIndiceRefugoCor(indicadorRN.identificarCorDoIndicador(
                        			IndicadoresValorPadrao.INDICE_DE_REFUGO.getCdIndicador(), 
                        			listaMetaIndicadores, 
                        			refugoDTO.getIndiceRefugo()));
                            refugoDTO.setIdTRefugo(dwconsolre.getDwTRefugo().getIdTrefugo());
                        
                            lista.add(refugoDTO);
                        }
                    }
                }
            }
        }
        
        GraficoRefugoDTO graficoDTO = new GraficoRefugoDTO();
        Collections.sort(lista, comparaParaOrdenarDoMaiorParaOMenor);
        graficoDTO.setDetalhes(lista);
        
        MetaIndicadorDTO indicadorRefugo = indicadorRN.getMetaIndicador(
			IndicadoresValorPadrao.INDICE_DE_REFUGO.getCdIndicador(),
			listaMetaIndicadores);
        indicadorRefugo.setValorLegendaMeta("");
        indicadorRefugo.setValorLegendaInferior("5");
        graficoDTO.setMetaIndicador(indicadorRefugo);
        
    	return graficoDTO;
    }
    
	public List<TabelaRefugoHora> getRefugoOcorrencia(FiltroDetalheRefugoDTO filtro) throws RegistroDesconhecidoException {
		List<TabelaRefugoHora> lista = new ArrayList<TabelaRefugoHora>();
		
		FiltroWebRN filtroRN = new FiltroWebRN(getDao(), formatoData, formatoDataHora);
		DetalheMonitorizacaoWebRN detalheRN = new DetalheMonitorizacaoWebRN(getDao(), formatoData, formatoDataHora);
		DetalheMonitorizacaoPTInjetDTO detalhe = detalheRN.getDetalheMonitorizacaoPTInjetDTO(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
		
		Date dataInicio = detalheRN.getInicioPeriodo(detalhe.getListaDwConsolId());
		Date dataFim =  detalheRN.getFimPeriodo(detalhe.getListaDwConsolId());
		dataFim = DataHoraRN.adicionaHorasDaData(dataFim, 1);
		
		FiltroWebRN.completarHorasDasDatas(filtro);
				
		OcorrenciaParetoRefugoRN rn = new OcorrenciaParetoRefugoRN(getDao());
		DetalhamentoRefugoDTO consultaDTO = rn.getOcorrenciaParetoRefugoFichaMaqDTO(
				filtro.getTpId(), 
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora), 
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora),
				new BigDecimal(filtro.getIdTurno()),
				filtro.getCdPosto(),
				filtro.getCdCp(),
				filtro.getCdRefugo(),
				filtro.getCdProduto());
		
		Double quantidadeTotalRefugo = 0d;
		Map<String, Double> quantidadeTotalPorRefugo = new HashMap<String, Double>();
		for(DetalheRefugoDTO refugo : consultaDTO.getListarefugos()) {
			quantidadeTotalRefugo += refugo.getQtde_refugo();
			
			String chave = refugo.getRefugo();
			Double quantidadeDoRefugo = quantidadeTotalPorRefugo.get(chave);
			if (quantidadeDoRefugo == null) {
				quantidadeTotalPorRefugo.put(chave, refugo.getQtde_refugo());
			} else {
				quantidadeDoRefugo += refugo.getQtde_refugo();
				quantidadeTotalPorRefugo.put(chave, quantidadeDoRefugo);
			}
		}
		
		for(DetalheRefugoDTO refugo : consultaDTO.getListarefugos()) {
			TabelaRefugoHora dto = new TabelaRefugoHora();
			dto.setPosto(refugo.getDsPt());
			dto.setFerramenta(refugo.getFerramenta());
			dto.setProduto(refugo.getProduto());
			dto.setRefugo(refugo.getRefugo());
			dto.setQuantidade(ConversaoTipos.converteParaString(refugo.getQtde_refugo(), 2));
			dto.setDtHrOcorrencia(DataHoraRN.dateToString(refugo.getDthrocorrencia(), formatoDataHora));
			dto.setCausa(refugo.getCausa());
			dto.setAcao(refugo.getAcao());
			
			FiltroDetalheRefugoDTO filtroDetalheRefugo = new FiltroDetalheRefugoDTO();
			FiltroWebRN.duplicar(filtro, filtroDetalheRefugo);
			filtroDetalheRefugo.setDtHrReferenciaInicial(DataHoraRN.dateToString(dataInicio, formatoDataHora));
			filtroDetalheRefugo.setDtHrReferenciaFinal(DataHoraRN.dateToString(dataFim, formatoDataHora));
			filtroDetalheRefugo.setTpId(TpId.HORA.getValue());
			filtroDetalheRefugo.setCdRefugo(refugo.getRefugo());
			filtroDetalheRefugo.setQuantidadeRefugo(ConversaoTipos.converteParaString(quantidadeTotalPorRefugo.get(refugo.getRefugo()), 2));
			filtroDetalheRefugo.setTotalRefugo(ConversaoTipos.converteParaString(quantidadeTotalRefugo, 2));
			filtroDetalheRefugo.setTotalRefugoPeriodo(filtro.getTotalRefugoPeriodo());
			
			dto.setFiltro(filtroDetalheRefugo);
			
			lista.add(dto);
		}
		
		return lista;
	}
	
	public GraficoRecorrenciaDTO getRefugoRecorrenciaPareto(FiltroDetalheRefugoDTO filtro) {
		GraficoRecorrenciaDTO graficoDTO = new GraficoRecorrenciaDTO();
		
		DetalheMonitorizacaoWebIndicadorRN indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(getDao(), formatoData, formatoDataHora);
		MetaIndicadorDTO indicador = DetalheMonitorizacaoWebIndicadorRN.getIndicadorPadraoGraficoRecorrenciaRefugo();
		
		List<ItemRecorrenciaDTO> itens = new ArrayList<ItemRecorrenciaDTO>();
		
		FiltroWebRN filtroRN = new FiltroWebRN(getDao(), formatoData, formatoDataHora);
		GraficoRecorrenciaRefugoRN rn = new GraficoRecorrenciaRefugoRN(getDao());
		GraficoBIRecorrenciaDTO consultaDTO = rn.getGraficoBIParetoRecorrencia(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro), GraficoRecorrenciaFactory.RECORRENCIA_REFUGO, filtro.getCdRefugo());
		
		for(GraficoBIItemRecorrenciaDTO grafico : consultaDTO.getGrafico()) {
			
			ItemRecorrenciaDTO itemDTO = new ItemRecorrenciaDTO();
			
			itemDTO.setDtHrInicio(DataHoraRN.dateToString(grafico.getDthrIni(), formatoDataHora));
			itemDTO.setDtHrFim(DataHoraRN.dateToString(grafico.getDthrFim(), formatoDataHora));
			itemDTO.setIndice(ConversaoTipos.converteParaString(grafico.getIndItem(), 2));
			itemDTO.setIndiceCor(indicadorRN.identificarCorDoIndicador(
        			indicador, 
        			itemDTO.getIndice()));
			itemDTO.setPecas(ConversaoTipos.converteParaString(grafico.getQtdPerdida(), 2));
			itemDTO.setPecasKg(ConversaoTipos.converteParaString(grafico.getQtdPerdidaKg(), 4));
			itemDTO.setPecasTon(ConversaoTipos.converteParaString(grafico.getQtdPerdidaTon(), 4));			
			
			List<ItemRecorrenciaRefugoDTO> refugos = new ArrayList<ItemRecorrenciaRefugoDTO>();
			for(DetalheRecorrenciaRefugoDTO refugo : grafico.getListaRefugos()) {
				
				ItemRecorrenciaRefugoDTO refugoDTO = new ItemRecorrenciaRefugoDTO();
				refugoDTO.setDtHrRefugo(DataHoraRN.dateToString(refugo.getDtHrRefugo(), formatoDataHora));
				refugoDTO.setQuantidadeRefugada(ConversaoTipos.converteParaString(refugo.getQtdRefugada(), 0));
				refugoDTO.setTurno(refugo.getCdTurno() + " - " + refugo.getDsTurno());
				refugoDTO.setPosto(refugo.getCdPt());
				refugoDTO.setFolha(refugo.getCdFolha());
				refugoDTO.setProduto(refugo.getCdProduto() + " - " + refugo.getDsProduto());
				
				refugos.add(refugoDTO);
			}
			
			itemDTO.setRefugos(refugos);
			itens.add(itemDTO);
		}
		
		List<ItemRecorrenciaDTO> itensPeriodoCompleto = completarPeriodoComValoresVazio(
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora),
				DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora),
				itens);
		graficoDTO.setIndicador(indicador);
		graficoDTO.setItens(itensPeriodoCompleto);
		
		graficoDTO.setDtHrInicio(filtro.getDtHrReferenciaInicial());
		graficoDTO.setDtHrFim(filtro.getDtHrReferenciaFinal());
		//graficoDTO.setPosto(filtro.getCdPosto());
		//graficoDTO.setFerramenta(ferramenta);
		//graficoDTO.setProduto(filtro.getCdProduto());
		graficoDTO.setTotal(filtro.getQuantidadeRefugo());
		graficoDTO.setIndice(ConversaoTipos.converteParaString(
				AritmeticaUtil.calcularPorcentagem(
				new BigDecimal(filtro.getQuantidadeRefugo()),
				new BigDecimal(filtro.getTotalRefugoPeriodo())),
				2));
		
		return graficoDTO;
	}
	
	public List<ItemRecorrenciaDTO> completarPeriodoComValoresVazio(Date inicio, Date fim, List<ItemRecorrenciaDTO> itens) {		
		List<ItemRecorrenciaDTO> listaFinal = new ArrayList<ItemRecorrenciaDTO>();
		
		Date horaSelecionada = inicio;
		outer: while(horaSelecionada.before(fim)) {
			
			for(ItemRecorrenciaDTO item : itens) {
				if(item.getDtHrInicio().equals(DataHoraRN.dateToString(horaSelecionada, formatoDataHora))) {
					listaFinal.add(item);
					horaSelecionada = DataHoraRN.adicionaHorasDaData(horaSelecionada, 1);
					continue outer;
				}
			}
			
			Date horafimSelecionada = new Date(horaSelecionada.getTime());
			horafimSelecionada = DataHoraRN.adicionaHorasDaData(horafimSelecionada, 1);
			
			ItemRecorrenciaDTO item = new ItemRecorrenciaDTO();
			item.setDtHrInicio(DataHoraRN.dateToString(horaSelecionada, formatoDataHora));
			item.setDtHrFim(DataHoraRN.dateToString(horafimSelecionada, formatoDataHora));
			item.setIndice("0");
			item.setPecas("0");
			item.setPecasKg("0");
			item.setPecasTon("0");
			
			listaFinal.add(item);
			horaSelecionada = DataHoraRN.adicionaHorasDaData(horaSelecionada, 1);
		}
		
		return listaFinal;
	}
    
	// fonte netbeans: DetalheProducaoMain.gerarGraficoIndiceRefugo()

	private FiltroGraficoDetalhePtDTO getFiltroHora(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {        
	    FiltroGraficoDetalhePtDTO filtroPorHora = new FiltroGraficoDetalhePtDTO();
	    
	    PTRN ptRN = new PTRN(getDao());
		OmPt omPt = ptRN.getOmPt(filtro.getCdPosto());
		filtroPorHora.setOmPt(omPt);
		
		if(filtro.getFiltroOp() != FiltroOp.TODAS_AS_OPS_NO_TURNO.getValor()) {
	    	CpRN cpRN = new CpRN(getDao());
	    	PpCp ppCp = cpRN.pesquisarPpCpByCdCpCdPt(filtro.getCdCp(), filtro.getCdPosto());    	
	    	filtroPorHora.setIdCp(ppCp.getIdCp());
	    }
		    	
		DwTurno turno = new DwTurno();
		turno.setIdTurno(filtro.getIdTurno());
		filtroPorHora.setDwTurno(turno);
	    
		filtroPorHora.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
	    filtroPorHora.setTpId(TpId.HORA.getValue());        
	    filtroPorHora.setDthrIhora(DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora));
	    
	    return filtroPorHora;
	}
    
    private GraficoRefugoDetalheDTO getDetalheRefugo(GraficoParetoRefugosDTO refugo) {
    	GraficoRefugoDetalheDTO dto = new GraficoRefugoDetalheDTO();
    	dto.setCdRefugo(refugo.getCdRefugo());
    	dto.setDsRefugo(refugo.getDsRefugo());
    	dto.setQuantidadeRefugada(ConversaoTipos.converteParaString(refugo.getQtdRefugada(), 2));
    	dto.setIndiceRefugo(ConversaoTipos.converteParaString(refugo.getIndiceRefugo(), 2));
    	dto.setIndiceRefugoCor(Cor.transformarColorParaCodigoHexadecimal(refugo.getCorBarra()));
    	dto.setIdTRefugo(refugo.getIdTRefugo());
    	return dto;
    }
    
    private List<LegendaDataHoraDTO> getLegendas(GraficosParetoRefugosDTO datas) {
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
    
    private LegendaDataHoraDTO getLegenda(DatasDTO data) {
    	LegendaDataHoraDTO legendaDTO = new LegendaDataHoraDTO();
    	legendaDTO.setDataHoraInicio(DataHoraRN.dateToString(data.getDtIAtendimento(), formatoDataHora));
    	legendaDTO.setDataHoraFim(DataHoraRN.dateToString(data.getDtFAtendimento(), formatoDataHora));
    	return legendaDTO;
    }
    
}
