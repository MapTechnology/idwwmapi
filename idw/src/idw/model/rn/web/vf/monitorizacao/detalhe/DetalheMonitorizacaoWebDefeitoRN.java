package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ms.util.ConversaoTipos;
import idw.model.dao.DAOGenerico;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.monitorizacao.detalhes.OcorrenciaParettoDefeitoComponenteRN;
import idw.model.rn.monitorizacao.detalhes.OcorrenciaParettoDefeitoRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitoComponenteDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitoDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitosComponentesDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitosDTO;
import idw.util.Cor;
import idw.webservices.dto.DetalhamentoDefeitoDTO;
import idw.webservices.dto.FiltroDetalheDefeito;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoComponenteDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoComponenteDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaDetalheDefeitoDTO;

public class DetalheMonitorizacaoWebDefeitoRN extends AbstractRN<DAOGenerico> {

	private final String formatoData;
	private final String formatoDataHora;
	
	public DetalheMonitorizacaoWebDefeitoRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebDefeitoRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public GraficoDefeitoDTO getGraficosDefeitos(FiltroDetalhePTInjetDTO filtro) {
    	OcorrenciaParettoDefeitoRN rn = new OcorrenciaParettoDefeitoRN(getDao());
    	GraficoParettoDefeitosDTO dtoConsulta = rn.getGraficoParettoDefeito(converterParaFiltroDetalheDefeito(filtro));
    	
    	GraficoDefeitoDTO dto = new GraficoDefeitoDTO();
    	dto.setDefeitos(getListaDefeitos(dtoConsulta));
    	dto.setLegenda(getListaLegenda(dtoConsulta));
    	return dto;
    }
    
    public GraficoDefeitoComponenteDTO getGraficosDefeitosComponentes(FiltroDetalheDefeitoDTO filtro) {
    	
    	FiltroWebRN filtroWebRN = new FiltroWebRN(getDao(), formatoData, formatoDataHora);
    	
    	OcorrenciaParettoDefeitoComponenteRN rn = new OcorrenciaParettoDefeitoComponenteRN(getDao());
    	
    	GraficoParettoDefeitosComponentesDTO dtoConsulta = rn.getGraficoParettoDefeitoComponente(filtroWebRN.converterParaFiltroDetalheDefeito(filtro));
    	
    	GraficoDefeitoComponenteDTO dto = new GraficoDefeitoComponenteDTO();
    	
    	dto.setComponentes(getListaDefeitosComponentes(dtoConsulta));
    	dto.setLegenda(getListaLegenda(dtoConsulta));
    	
    	return dto;
    
    }
    
    public List<TabelaDetalheDefeitoDTO> getDetalheDefeitoTabela(FiltroDetalheDefeitoDTO filtro) {
    	FiltroWebRN filtroWebRN = new FiltroWebRN(getDao(), formatoData, formatoDataHora);
    	
    	OcorrenciaParettoDefeitoRN rn = new OcorrenciaParettoDefeitoRN(getDao());
    	DetalhamentoDefeitoDTO consultaDTO = rn.getOcorrenciaParettoDefeito(filtroWebRN.converterParaFiltroDetalheDefeito(filtro));
    	
    	List<TabelaDetalheDefeitoDTO> defeitos = new ArrayList<TabelaDetalheDefeitoDTO>();
    	for(DetalhamentoDefeitoDTO item : consultaDTO.getListaResultadoPesquisa()) {
    		TabelaDetalheDefeitoDTO defeito = new TabelaDetalheDefeitoDTO();
    		
    		defeito.setPosto(item.getPosto());
    		defeito.setFerramenta(item.getFerramenta());
    		defeito.setDefeito(item.getCodigoDefeito() + " - " + item.getDescricaoDefeito());
    		defeito.setProduto(item.getCodigoProduto() + " - " + item.getDescricaoProduto());
    		defeito.setQuantidade(ConversaoTipos.converteParaString(item.getQuantidade(), 0));
    		defeito.setAreaResponsavel(item.getArea());
    		defeito.setDataReferencia(DataHoraRN.dateToString(item.getDtReferencia(), formatoData));
    		defeito.setTurno(item.getTurno());
    		
    		defeitos.add(defeito);
    	}
    	
    	return defeitos;
    }
    
    private List<GraficoDefeitoDetalheDTO> getListaDefeitos(GraficoParettoDefeitosDTO dto) {
    	List<GraficoDefeitoDetalheDTO> lista = new ArrayList<GraficoDefeitoDetalheDTO>();
    	
    	for(GraficoParettoDefeitoDTO defeito : dto.getDefeitos()) {
    		GraficoDefeitoDetalheDTO defeitoDTO = new GraficoDefeitoDetalheDTO();
    		defeitoDTO.setCdDefeito(defeito.getDefeito().getCodigoDefeito());
    		defeitoDTO.setAreaResponsavel(defeito.getDefeito().getArea());
    		defeitoDTO.setQuantidade(ConversaoTipos.converteParaString(defeito.getDefeito().getQuantidade().doubleValue(), 1, true));
    		defeitoDTO.setCor(getCor(defeito.getIndice(), dto));
    		defeitoDTO.setDefeito(defeito.getDefeito().getCodigoDefeito()+"-"+defeito.getDefeito().getDescricaoDefeito());
    		defeitoDTO.setIndice(ConversaoTipos.converteParaString(defeito.getIndice().doubleValue(), 2, true));
    		lista.add(defeitoDTO);
    	}
    	
		Collections.sort(lista, new Comparator<GraficoDefeitoDetalheDTO>(){

			@Override
			public int compare(GraficoDefeitoDetalheDTO defeito1, GraficoDefeitoDetalheDTO defeito2) {
				
				BigDecimal qtd1 = ConversaoTipos.converteParaBigDecimal(defeito1.getQuantidade());
				BigDecimal qtd2 = ConversaoTipos.converteParaBigDecimal(defeito2.getQuantidade());
				
				return (-1 * qtd1.compareTo(qtd2));
			
			}
			
		});
    	
    	
    	return lista;
    }
    
    private List<GraficoDefeitoComponenteDetalheDTO> getListaDefeitosComponentes(GraficoParettoDefeitosComponentesDTO dto) {
    	
    	List<GraficoDefeitoComponenteDetalheDTO> lista = new ArrayList<GraficoDefeitoComponenteDetalheDTO>();
    	
    	for(GraficoParettoDefeitoComponenteDTO defeitoComponente : dto.getDefeitosComponentes()) {
    		
    		GraficoDefeitoComponenteDetalheDTO defeitoComponenteDTO = new GraficoDefeitoComponenteDetalheDTO();
    		
    		defeitoComponenteDTO.setCdComponente(defeitoComponente.getDefeitoComponente().getCdComponente());
    		defeitoComponenteDTO.setDsPosicaoMecanica(defeitoComponente.getDefeitoComponente().getDsPosicaoMecanica());
    		defeitoComponenteDTO.setQuantidade(ConversaoTipos.converteParaString(defeitoComponente.getDefeitoComponente().getQuantidade().doubleValue(), 1, true));
    		defeitoComponenteDTO.setCor(getCor(defeitoComponente.getIndice(), dto));
    		defeitoComponenteDTO.setIndice(ConversaoTipos.converteParaString(defeitoComponente.getIndice().doubleValue(), 2, true));
    		defeitoComponenteDTO.setCdComponenteView(defeitoComponente.getDefeitoComponente().getCdComponente()+"-"+defeitoComponente.getDefeitoComponente().getDsPosicaoMecanica());
    		
    		lista.add(defeitoComponenteDTO);
    	
    	}
    	
		Collections.sort(lista, new Comparator<GraficoDefeitoComponenteDetalheDTO>(){

			@Override
			public int compare(GraficoDefeitoComponenteDetalheDTO componente1, GraficoDefeitoComponenteDetalheDTO componente2) {
				
				BigDecimal qtd1 = ConversaoTipos.converteParaBigDecimal(componente1.getQuantidade());
				BigDecimal qtd2 = ConversaoTipos.converteParaBigDecimal(componente2.getQuantidade());
				
				return (-1 * qtd1.compareTo(qtd2));
			
			}
			
		});
    	
    	return lista;
    
    }
    
    private List<LegendaDTO> getListaLegenda(GraficoParettoDefeitosDTO dto) {
    	List<LegendaDTO> lista = new ArrayList<LegendaDTO>();
    	
    	lista.add(new LegendaDTO(
    			Cor.transformarParaCodigoHexadecimal(
    					DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR),
    					ConversaoTipos.converteParaString(
    	    					dto.getIndSuperior().doubleValue(), 2, true)));
    	
    	lista.add(new LegendaDTO(
    			Cor.transformarParaCodigoHexadecimal(
    					DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META),
    					ConversaoTipos.converteParaString(
    	    					dto.getIndMeta().doubleValue(), 2, true)));
    	
    	lista.add(new LegendaDTO(
    			Cor.transformarParaCodigoHexadecimal(
    					DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR),
    					ConversaoTipos.converteParaString(
    	    					dto.getIndInferior().doubleValue(), 2, true)));
    	
    	return lista;
    }
    
    private List<LegendaDTO> getListaLegenda(GraficoParettoDefeitosComponentesDTO dto) {
    	List<LegendaDTO> lista = new ArrayList<LegendaDTO>();
    	
    	lista.add(new LegendaDTO(
    			Cor.transformarParaCodigoHexadecimal(
    					DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR),
    					ConversaoTipos.converteParaString(
    	    					dto.getIndSuperior().doubleValue(), 2, true)));
    	
    	lista.add(new LegendaDTO(
    			Cor.transformarParaCodigoHexadecimal(
    					DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META),
    					ConversaoTipos.converteParaString(
    	    					dto.getIndMeta().doubleValue(), 2, true)));
    	
    	lista.add(new LegendaDTO(
    			Cor.transformarParaCodigoHexadecimal(
    					DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR),
    					ConversaoTipos.converteParaString(
    	    					dto.getIndInferior().doubleValue(), 2, true)));
    	
    	return lista;
    }
    
    private String getCor(BigDecimal valor, GraficoParettoDefeitosDTO dto) {
    	return DetalheMonitorizacaoWebIndicadorRN.identificarCor(
    			valor, 
    			dto.getIndSuperior(), 
    			dto.getIndInferior(), 
    			dto.getIndMeta());
    }
    
    private String getCor(BigDecimal valor, GraficoParettoDefeitosComponentesDTO dto) {
    	return DetalheMonitorizacaoWebIndicadorRN.identificarCor(
    			valor, 
    			dto.getIndSuperior(), 
    			dto.getIndInferior(), 
    			dto.getIndMeta());
    }
    
    @Deprecated
    private FiltroDetalheDefeito converterParaFiltroDetalheDefeito(FiltroDetalhePTInjetDTO filtro) {
    	FiltroDetalheDefeito retorno = new FiltroDetalheDefeito();
    	retorno.setTpId(filtro.getTpId());

    	
    	//20171121 ...
    	//TODO: talvez rever este trecho, arbitrando que deve mesmo ficar dtrefINI-FIM em vez de DTRef. Atualmente funciona com DTref pois só usado por enquanto (201711) na Monitoração; quando usado no BI será necessário passar as DUAS datas.
    	if(filtro!=null){
    		if (filtro.getDtReferenciaInicial()==null || filtro.getDtReferenciaFinal()==null ){
    	    	retorno.setDtReferenciaInicial(filtro.getDtReferencia() );
    	    	retorno.setDtReferenciaFinal(filtro.getDtReferencia());    			
    		}
    		else
    		{
    	    	retorno.setDtReferenciaInicial(filtro.getDtReferenciaInicial());
    	    	retorno.setDtReferenciaFinal(filtro.getDtReferenciaFinal());    			
    		}
    	}
    	//20171121.
    	
    	retorno.setDwTurno(filtro.getDwTurno());
    	retorno.setOmPt(filtro.getOmPt());
    	retorno.setPpCp(filtro.getPpCp());
    	retorno.setOmGt(filtro.getOmGt());
    	retorno.setDwtarea(filtro.getDwtarea());
    	retorno.setOmProduto(filtro.getOmProduto());
    	return retorno;
    }
    
}
