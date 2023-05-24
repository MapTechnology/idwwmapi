package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmGt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.analiseturno.AnaliseTurnoRN;
import idw.model.rn.web.vf.AbstractWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorRN.IndicadoresValorPadrao;
import idw.webservices.dto.DetalheAnaliseTurnoDTO;
import idw.webservices.dto.DetalheAnaliseTurnoGtDTO;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.IndicadoresDTO;
import idw.webservices.dto.ListaDetalheAnaliseTurnoDTO;
import idw.webservices.rest.dto.monitorizacao.AnaliseTurnoDTO;
import idw.webservices.rest.dto.monitorizacao.AnaliseTurnoGtDTO;
import idw.webservices.rest.dto.monitorizacao.AnaliseTurnoPostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.IndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import ms.util.ConversaoTipos;

public class AnaliseTurnoWebRN extends AbstractWebRN {
	
	private FiltroMonitorizacaoDTO filtro;
	private List<FiltroDetalhePostoDTO> listaFiltroPosto;
	private List<MetaIndicadorDTO> metaIndicadores;

	private DetalheMonitorizacaoWebIndicadorRN indicadorRN;
	
	private static Comparator<IndicadorDTO> COMPARATOR_DECRESCENTE = new Comparator<IndicadorDTO>() {
		@Override
		public int compare(final IndicadorDTO o1, final IndicadorDTO o2) {
			final IndicadorDTO item1 = o1;
			final IndicadorDTO item2 = o2;
			return ConversaoTipos.converteParaBigDecimal(item1.getValor())
					.compareTo(ConversaoTipos.converteParaBigDecimal(item2.getValor())) * -1;
		}
	};

	private static Comparator<IndicadorDTO> COMPARATOR_CRESCENTE = new Comparator<IndicadorDTO>() {
		@Override
		public int compare(final IndicadorDTO o1, final IndicadorDTO o2) {
			final IndicadorDTO item1 = o1;
			final IndicadorDTO item2 = o2;
			return ConversaoTipos.converteParaBigDecimal(item1.getValor())
					.compareTo(ConversaoTipos.converteParaBigDecimal(item2.getValor()));
		}
	};
	
	public AnaliseTurnoWebRN(String formatoData, String formatoDataHora) {
        super(formatoData, formatoDataHora);
    }

    public AnaliseTurnoWebRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao, formatoData, formatoDataHora);
        indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(dao, formatoData, formatoDataHora);
    }
    
    public AnaliseTurnoDTO getAnaliseTurno(FiltroMonitorizacaoDTO filtro) {
    	this.filtro = filtro;
    	this.listaFiltroPosto = filtro.getListaFiltroPosto();
    	if(this.listaFiltroPosto == null) {
    		this.listaFiltroPosto = new ArrayList<FiltroDetalhePostoDTO>();
    	}
    	
    	AnaliseTurnoDTO analiseTurnoDTO = new AnaliseTurnoDTO();
    	
    	FiltroWebRN filtroWebRN = new FiltroWebRN(getDao(), formatoData, formatoDataHora);
    	FiltroProducaoDTO filtroAnaliseTurno = filtroWebRN.getFiltroAnaliseTurno(filtro);
    	
    	AnaliseTurnoRN analiseTurnoRN = new AnaliseTurnoRN(getDao());
    	ListaDetalheAnaliseTurnoDTO consultaDTO = new ListaDetalheAnaliseTurnoDTO();
    	
    	if(filtro.getListaFiltroPosto().size() > 0) {
    		consultaDTO = analiseTurnoRN.getDetalheAnaliseTurno(filtroAnaliseTurno);
    	} else {
    		consultaDTO = analiseTurnoRN.getDetalheAnaliseTurnoPorGt(
    				filtroAnaliseTurno.getDwTurno(),
    				filtroAnaliseTurno.getDtReferencia(),
    				filtro.getListaFiltroIdGt());
    	}
    	
    	this.metaIndicadores = DetalheMonitorizacaoWebIndicadorRN.getMetaIndicadoresAnaliseTurno();
    	
    	if(consultaDTO.getAnaliseTurnoTodasMaquinas() != null) {
    		IndicadoresDTO indicadores = consultaDTO.getAnaliseTurnoTodasMaquinas().getIndicadoresDTO();
        	preencherIndicadoresTotais(indicadores, analiseTurnoDTO);
    	}
    	
    	analiseTurnoDTO.setMetaIndicadores(this.metaIndicadores);
    	analiseTurnoDTO.setPostos(getListaPostoIndicador(consultaDTO));
    	analiseTurnoDTO.setGts(getListaGtIndicador(consultaDTO));
    	
    	this.prepararListaIndicadores(analiseTurnoDTO);
    	
    	return analiseTurnoDTO;
    }
    
    private void preencherIndicadoresTotais(IndicadoresDTO indicadores, AnaliseTurnoDTO analiseTurnoDTO) {
    	analiseTurnoDTO.setEficienciaRealizacao(ConversaoTipos.converteParaString(indicadores.getEficienciaRealizacao(), 2));
    	analiseTurnoDTO.setProducaoPlanejada(ConversaoTipos.converteParaString(indicadores.getProducaoPlanejada(), 0));
    	analiseTurnoDTO.setProducaoPrevista(ConversaoTipos.converteParaString(indicadores.getProducaoPrevista(), 0));
    	analiseTurnoDTO.setProducaoTotal(ConversaoTipos.converteParaString(indicadores.getProducaoBruta(), 0));
    	analiseTurnoDTO.setPerdasTotais(ConversaoTipos.converteParaString(indicadores.getPerdaTotal(), 0));
    	analiseTurnoDTO.setIndicePerda(ConversaoTipos.converteParaString(indicadores.getIndicePerda(), 2));
    	analiseTurnoDTO.setProdutividadeOee(ConversaoTipos.converteParaString(indicadores.getOee(), 2));
    	
    	analiseTurnoDTO.setIndiceParadas(ConversaoTipos.converteParaString(indicadores.getIndiceParada(), 2));
    	analiseTurnoDTO.setPerdasPorParadas(ConversaoTipos.converteParaString(indicadores.getPerdaParada(), 0));
    	analiseTurnoDTO.setTempoTotalParadas(DataHoraRN.formatSegundosParaHHMMSS(indicadores.getTempoParadaCp()));
    	
    	analiseTurnoDTO.setIndiceCavidadesAtivas(ConversaoTipos.converteParaString(indicadores.getIndiceCavidadesAtivas(), 2));
    	
    	analiseTurnoDTO.setIndiceRefugos(ConversaoTipos.converteParaString(indicadores.getIndiceRefugo(), 2));
    	analiseTurnoDTO.setRefugos(ConversaoTipos.converteParaString(indicadores.getProducaoRefugada(), 0));
    	
    	analiseTurnoDTO.setEficienciaCiclo(ConversaoTipos.converteParaString(indicadores.getEficienciaCiclo(), 2));
    	analiseTurnoDTO.setPerdasIneficienciaCiclo(ConversaoTipos.converteParaString(indicadores.getPerdaCiclo(), 0));
    	analiseTurnoDTO.setEficienciaInstantanea(ConversaoTipos.converteParaString(indicadores.getEficienciaInstantanea(), 2));
    }
    
    private List<AnaliseTurnoPostoDTO> getListaPostoIndicador(ListaDetalheAnaliseTurnoDTO lista) {
    	List<AnaliseTurnoPostoDTO> postos = new ArrayList<AnaliseTurnoPostoDTO>();
    	
    	if(lista.getAnaliseTurnoPorMaquina() != null) {
    		for(DetalheAnaliseTurnoDTO detalhe : lista.getAnaliseTurnoPorMaquina()) {
        		IndicadoresDTO indicadores = detalhe.getIndicadoresDTO();
        		String cdPt = detalhe.getOmPt().getCdPt();
        		AnaliseTurnoPostoDTO posto = new AnaliseTurnoPostoDTO();
        		posto.setPosto(cdPt);
        		posto.setIndicadores(getPtIndicadorDTO(indicadores));
        		posto.setFiltro(getFiltro(cdPt));
        		postos.add(posto);
        	}
    	}
    	
    	return postos;
    }
    
    private List<AnaliseTurnoGtDTO> getListaGtIndicador(ListaDetalheAnaliseTurnoDTO lista) {
    	List<AnaliseTurnoGtDTO> gts = new ArrayList<AnaliseTurnoGtDTO>();
    	
    	if(lista.getAnaliseTurnoPorGt() != null) {
    		for(DetalheAnaliseTurnoGtDTO detalhe : lista.getAnaliseTurnoPorGt()) {
        		IndicadoresDTO indicadores = detalhe.getIndicadoresDTO();
        		String cdGt = detalhe.getOmGt().getCdGt() + " - " + detalhe.getOmGt().getDsGt();
        		AnaliseTurnoGtDTO gt = new AnaliseTurnoGtDTO();
        		gt.setGt(cdGt);
        		gt.setIndicadores(getPtIndicadorDTO(indicadores));
        		gt.setFiltro(getFiltroGt(detalhe.getOmGt()));
        		gts.add(gt);
        	}
    	}
    	
    	return gts;
    }
    
    private PtIndicadorDTO getPtIndicadorDTO(IndicadoresDTO indicadores) {
		
		PtIndicadorDTO indicador = new PtIndicadorDTO();
		indicador.setEficienciaRealizacao(ConversaoTipos.converteParaString(indicadores.getEficienciaRealizacao().doubleValue(), 2, true));
		indicador.setEficienciaCiclo(ConversaoTipos.converteParaString(indicadores.getEficienciaCiclo().doubleValue(), 2, true));
		indicador.setEficienciaInstantanea(ConversaoTipos.converteParaString(indicadores.getEficienciaInstantanea().doubleValue(), 2, true));
		indicador.setIndiceRefugo(ConversaoTipos.converteParaString(indicadores.getIndiceRefugo().doubleValue(), 2, true));
		indicador.setIndiceParada(ConversaoTipos.converteParaString(indicadores.getIndiceParada().doubleValue(), 2, true));
		indicador.setIndicePerdaOuNR(ConversaoTipos.converteParaString(indicadores.getIndicePerda().doubleValue(), 2, true));
		indicador.setIndiceCavidadesAtivas(ConversaoTipos.converteParaString(indicadores.getIndiceCavidadesAtivas().doubleValue(), 2, true));
		indicador.setIndiceProdutividadeOEE(ConversaoTipos.converteParaString(indicadores.getOee().doubleValue(), 2, true));
		
		indicador.setEficienciaRealizacaoCor(indicadorRN.identificarCorDoIndicador(
    			IndicadoresValorPadrao.EFICIENCIA_DE_REALIZACAO.getCdIndicador(),
    			metaIndicadores,
    			indicador.getEficienciaRealizacao()));
		indicador.setEficienciaCicloCor(indicadorRN.identificarCorDoIndicador(
    			IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.getCdIndicador(),
    			metaIndicadores,
    			indicador.getEficienciaCiclo()));
		indicador.setEficienciaInstantaneaCor(indicadorRN.identificarCorDoIndicador(
    			DetalheMonitorizacaoWebIndicadorRN.getIndicadorPadraoEficienciaInstantanea().getCdIndicador(),
    			metaIndicadores,
    			indicador.getEficienciaInstantanea()));
		indicador.setIndiceRefugoCor(indicadorRN.identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_DE_REFUGO.getCdIndicador(),
    			metaIndicadores,
    			indicador.getIndiceRefugo()));
		indicador.setIndiceParadaCor(indicadorRN.identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_DE_PARADA.getCdIndicador(),
    			metaIndicadores,
    			indicador.getIndiceParada()));
		indicador.setIndicePerdaCor(indicadorRN.identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_DE_PERDA.getCdIndicador(),
    			metaIndicadores,
    			indicador.getIndicePerdaOuNR()));
		indicador.setIndiceCavidadesAtivasCor(indicadorRN.identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_CAVIDADES_ATIVAS.getCdIndicador(),
    			metaIndicadores,
    			indicador.getIndiceCavidadesAtivas()));
		indicador.setIndiceProdutividadeOEECor(indicadorRN.identificarCorDoIndicador(
    			IndicadoresValorPadrao.PRODUTIVIDADE_OEE.getCdIndicador(),
    			metaIndicadores,
    			indicador.getIndiceProdutividadeOEE()));
		
		return indicador;
    }
    
    private void prepararListaIndicadores(AnaliseTurnoDTO analiseTurnoDTO) {
    	List<IndicadorDTO> listaEficienciaRealizacao = new ArrayList<IndicadorDTO>();
    	List<IndicadorDTO> listaEficienciaCiclo = new ArrayList<IndicadorDTO>();
    	List<IndicadorDTO> listaIndiceRefugos = new ArrayList<IndicadorDTO>();
    	List<IndicadorDTO> listaIndiceParadas = new ArrayList<IndicadorDTO>();
    	List<IndicadorDTO> listaIndicePerdas = new ArrayList<IndicadorDTO>();
    	List<IndicadorDTO> listaIndiceCavidadesAtivas = new ArrayList<IndicadorDTO>();
    	List<IndicadorDTO> listaProdutividadeOee = new ArrayList<IndicadorDTO>();
    	List<IndicadorDTO> listaEficienciaInstantanea = new ArrayList<IndicadorDTO>();
    	
    	for(AnaliseTurnoPostoDTO posto : analiseTurnoDTO.getPostos()) {
    		IndicadorDTO eficienciaRealizacao = new IndicadorDTO();
    		eficienciaRealizacao.setChave(posto.getPosto());
    		eficienciaRealizacao.setValor(posto.getIndicadores().getEficienciaRealizacao());
    		eficienciaRealizacao.setValorCor(posto.getIndicadores().getEficienciaRealizacaoCor());
    		listaEficienciaRealizacao.add(eficienciaRealizacao);
    		
    		IndicadorDTO eficienciaCiclo = new IndicadorDTO();
    		eficienciaCiclo.setChave(posto.getPosto());
    		eficienciaCiclo.setValor(posto.getIndicadores().getEficienciaCiclo());
    		eficienciaCiclo.setValorCor(posto.getIndicadores().getEficienciaCicloCor());
    		listaEficienciaCiclo.add(eficienciaCiclo);
    		
    		IndicadorDTO indiceRefugos = new IndicadorDTO();
    		indiceRefugos.setChave(posto.getPosto());
    		indiceRefugos.setValor(posto.getIndicadores().getIndiceRefugo());
    		indiceRefugos.setValorCor(posto.getIndicadores().getIndiceRefugoCor());
    		listaIndiceRefugos.add(indiceRefugos);
    		
    		IndicadorDTO indiceParadas = new IndicadorDTO();
    		indiceParadas.setChave(posto.getPosto());
    		indiceParadas.setValor(posto.getIndicadores().getIndiceParada());
    		indiceParadas.setValorCor(posto.getIndicadores().getIndiceParadaCor());
    		listaIndiceParadas.add(indiceParadas);
    		
    		IndicadorDTO indicePerdas = new IndicadorDTO();
    		indicePerdas.setChave(posto.getPosto());
    		indicePerdas.setValor(posto.getIndicadores().getIndicePerdaOuNR());
    		indicePerdas.setValorCor(posto.getIndicadores().getIndicePerdaCor());
    		listaIndicePerdas.add(indicePerdas);
    		
    		IndicadorDTO indiceCavidadesAtivas = new IndicadorDTO();
    		indiceCavidadesAtivas.setChave(posto.getPosto());
    		indiceCavidadesAtivas.setValor(posto.getIndicadores().getIndiceCavidadesAtivas());
    		indiceCavidadesAtivas.setValorCor(posto.getIndicadores().getIndiceCavidadesAtivasCor());
    		listaIndiceCavidadesAtivas.add(indiceCavidadesAtivas);
    		
    		IndicadorDTO produtividadeOee = new IndicadorDTO();
    		produtividadeOee.setChave(posto.getPosto());
    		produtividadeOee.setValor(posto.getIndicadores().getIndiceProdutividadeOEE());
    		produtividadeOee.setValorCor(posto.getIndicadores().getIndiceProdutividadeOEECor());
    		listaProdutividadeOee.add(produtividadeOee);
    		
    		IndicadorDTO eficienciaInstantanea = new IndicadorDTO();
    		eficienciaInstantanea.setChave(posto.getPosto());
    		eficienciaInstantanea.setValor(posto.getIndicadores().getEficienciaInstantanea());
    		eficienciaInstantanea.setValorCor(posto.getIndicadores().getEficienciaInstantaneaCor());
    		listaEficienciaInstantanea.add(eficienciaInstantanea);
    	}
    	
    	for(AnaliseTurnoGtDTO gt : analiseTurnoDTO.getGts()) {
    		IndicadorDTO eficienciaRealizacao = new IndicadorDTO();
    		eficienciaRealizacao.setChave(gt.getGt());
    		eficienciaRealizacao.setValor(gt.getIndicadores().getEficienciaRealizacao());
    		eficienciaRealizacao.setValorCor(gt.getIndicadores().getEficienciaRealizacaoCor());
    		listaEficienciaRealizacao.add(eficienciaRealizacao);
    		
    		IndicadorDTO eficienciaCiclo = new IndicadorDTO();
    		eficienciaCiclo.setChave(gt.getGt());
    		eficienciaCiclo.setValor(gt.getIndicadores().getEficienciaCiclo());
    		eficienciaCiclo.setValorCor(gt.getIndicadores().getEficienciaCicloCor());
    		listaEficienciaCiclo.add(eficienciaCiclo);
    		
    		IndicadorDTO indiceRefugos = new IndicadorDTO();
    		indiceRefugos.setChave(gt.getGt());
    		indiceRefugos.setValor(gt.getIndicadores().getIndiceRefugo());
    		indiceRefugos.setValorCor(gt.getIndicadores().getIndiceRefugoCor());
    		listaIndiceRefugos.add(indiceRefugos);
    		
    		IndicadorDTO indiceParadas = new IndicadorDTO();
    		indiceParadas.setChave(gt.getGt());
    		indiceParadas.setValor(gt.getIndicadores().getIndiceParada());
    		indiceParadas.setValorCor(gt.getIndicadores().getIndiceParadaCor());
    		listaIndiceParadas.add(indiceParadas);
    		
    		IndicadorDTO indicePerdas = new IndicadorDTO();
    		indicePerdas.setChave(gt.getGt());
    		indicePerdas.setValor(gt.getIndicadores().getIndicePerdaOuNR());
    		indicePerdas.setValorCor(gt.getIndicadores().getIndicePerdaCor());
    		listaIndicePerdas.add(indicePerdas);
    		
    		IndicadorDTO indiceCavidadesAtivas = new IndicadorDTO();
    		indiceCavidadesAtivas.setChave(gt.getGt());
    		indiceCavidadesAtivas.setValor(gt.getIndicadores().getIndiceCavidadesAtivas());
    		indiceCavidadesAtivas.setValorCor(gt.getIndicadores().getIndiceCavidadesAtivasCor());
    		listaIndiceCavidadesAtivas.add(indiceCavidadesAtivas);
    		
    		IndicadorDTO produtividadeOee = new IndicadorDTO();
    		produtividadeOee.setChave(gt.getGt());
    		produtividadeOee.setValor(gt.getIndicadores().getIndiceProdutividadeOEE());
    		produtividadeOee.setValorCor(gt.getIndicadores().getIndiceProdutividadeOEECor());
    		listaProdutividadeOee.add(produtividadeOee);
    		
    		IndicadorDTO eficienciaInstantanea = new IndicadorDTO();
    		eficienciaInstantanea.setChave(gt.getGt());
    		eficienciaInstantanea.setValor(gt.getIndicadores().getEficienciaInstantanea());
    		eficienciaInstantanea.setValorCor(gt.getIndicadores().getEficienciaInstantaneaCor());
    		listaEficienciaInstantanea.add(eficienciaInstantanea);
    	}
    	
    	Collections.sort(listaEficienciaRealizacao, COMPARATOR_CRESCENTE);
    	Collections.sort(listaEficienciaCiclo, COMPARATOR_CRESCENTE);
    	Collections.sort(listaIndiceCavidadesAtivas, COMPARATOR_CRESCENTE);
    	Collections.sort(listaProdutividadeOee, COMPARATOR_CRESCENTE);
    	Collections.sort(listaEficienciaInstantanea, COMPARATOR_CRESCENTE);
    	
    	Collections.sort(listaIndiceRefugos, COMPARATOR_DECRESCENTE);
    	Collections.sort(listaIndiceParadas, COMPARATOR_DECRESCENTE);
    	Collections.sort(listaIndicePerdas, COMPARATOR_DECRESCENTE);
    	
    	analiseTurnoDTO.setListaEficienciaRealizacao(listaEficienciaRealizacao);
    	analiseTurnoDTO.setListaEficienciaCiclo(listaEficienciaCiclo);
    	analiseTurnoDTO.setListaIndiceRefugos(listaIndiceRefugos);
    	analiseTurnoDTO.setListaIndiceParadas(listaIndiceParadas);
    	analiseTurnoDTO.setListaIndicePerdas(listaIndicePerdas);
    	analiseTurnoDTO.setListaIndiceCavidadesAtivas(listaIndiceCavidadesAtivas);
    	analiseTurnoDTO.setListaProdutividadeOee(listaProdutividadeOee);
    	analiseTurnoDTO.setListaEficienciaInstantanea(listaEficienciaInstantanea);
    }
    
    private FiltroDetalhePostoDTO getFiltro(String cdPosto) {
    	for(FiltroDetalhePostoDTO posto : this.listaFiltroPosto) {
    		if(posto.getCdPosto().equals(cdPosto)) {
    			return posto;
    		}
    	}
    	return null;
    }
    
    private FiltroMonitorizacaoDTO getFiltroGt(OmGt gt) {
    	FiltroMonitorizacaoDTO filtroGt = this.filtro.getCopia();
    	filtroGt.setCdGt(gt.getCdGt());
    	return filtroGt;
    }
}
