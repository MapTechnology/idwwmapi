package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import ms.util.ConversaoTipos;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.model.rn.PTRN;
import idw.model.rn.indicador.IndicadorRN;
import idw.util.Cor;
import idw.util.Util;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroIndCfg;
import idw.webservices.dto.IndicadorMinMetaMaxDTO;
import idw.webservices.dto.IndicadoresMinMetaMaxDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import idw.webservices.rest.idw.v2.dto.MetaIndicadorDTO2;

public class DetalheMonitorizacaoWebIndicadorRN extends AbstractRN<DAOGenerico> {
	
	public static final Color COR_INDICADOR_SUPERIOR = new Color(51, 255, 51);
	public static final Color COR_INDICADOR_META = new Color(255, 255, 51);
	public static final Color COR_INDICADOR_INFERIOR = new Color(255, 51, 51);
	
	public enum IndicadoresValorPadrao {
		EFICIENCIA_DE_REALIZACAO("ER", "LISTA_MONITORIZACAO_ER", "70", "85", "90", true),
		EFICIENCIA_DE_CICLO("EC", "LISTA_MONITORIZACAO_EC", "95", "99", "100", true),
		INDICE_DE_REFUGO("IR", "LISTA_MONITORIZACAO_IR", "5", "8", "10", false),
		INDICE_DE_PARADA("IP", "LISTA_MONITORIZACAO_IP", "2", "4", "5", false),
		INDICE_DE_PERDA("IPD", "LISTA_MONITORIZACAO_IPD_IPERDA", "2", "4", "8", false),
		INDICE_CAVIDADES_ATIVAS("CI", "LISTA_MONITORIZACAO_ICA", "2", "4", "8", true),
		PRODUTIVIDADE_OEE("OEE", "LISTA_MONITORIZACAO_OEE_IPOEE", "70", "80", "100", true),
		LISTA_MONITORIZACAO_EI("EI", "LISTA_MONITORIZACAO_EI", "70", "80", "100", true),
		LISTA_MONITORIZACAO_IPADRAO("IP", "LISTA_MONITORIZACAO_IPADRAO", "70", "80", "100", true);

		/*
		 * 
		    "LISTA_MONITORIZACAO_ER": "Eficiência de realização",
		    "LISTA_MONITORIZACAO_EC": "Eficiência de ciclo",
		    "LISTA_MONITORIZACAO_IR": "Índice de refugo",
		    "LISTA_MONITORIZACAO_IP": "Índice de parada",
		    "LISTA_MONITORIZACAO_EI": "Eficiência instântanea",
		    "LISTA_MONITORIZACAO_IPR": "Índice de produção",
		    "LISTA_MONITORIZACAO_ICA": "Índice de cavidades ativas",
		    "LISTA_MONITORIZACAO_OEE": "Índice de produtividade (OEE)",
		    "LISTA_MONITORIZACAO_OPERADOR": "Operador",
		    "LISTA_MONITORIZACAO_PRODUTO": "Produto",
		    "LISTA_MONITORIZACAO_UTILIZACAO": "Utilização"
		    
		    "": "Índice de Perdas",
		    "": "Produtividade (OEE)",
		 * 
		 */

		
		private final String cdIndicador;
		private final String dsIndicador;
		private final BigDecimal valorInferior;
		private final BigDecimal valorMeta;
		private final BigDecimal valorSuperior;
		private final boolean isMelhorAcimaMeta;
		
		private IndicadoresValorPadrao(
				String cdIndicador, 
				String dsIndicador, 
				String valorInferior,
				String valorMeta, 
				String valorSuperior,
				boolean isMelhorAcimaMeta) {
			this.cdIndicador = cdIndicador;
			this.dsIndicador = dsIndicador;
			this.valorInferior = new BigDecimal(valorInferior);
			this.valorMeta = new BigDecimal(valorMeta);
			this.valorSuperior = new BigDecimal(valorSuperior);
			this.isMelhorAcimaMeta = isMelhorAcimaMeta;
		}

		public String getCdIndicador() {
			return cdIndicador;
		}

		public String getDsIndicador() {
			return dsIndicador;
		}

		public BigDecimal getValorInferior() {
			return valorInferior;
		}

		public BigDecimal getValorMeta() {
			return valorMeta;
		}

		public BigDecimal getValorSuperior() {
			return valorSuperior;
		}

		public boolean isMelhorAcimaMeta() {
			return isMelhorAcimaMeta;
		}				
		
	}
	
	private final String formatoData;
	private final String formatoDataHora;
	
	public DetalheMonitorizacaoWebIndicadorRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebIndicadorRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public static List<MetaIndicadorDTO> getMetaIndicadoresAnaliseTurno() {
    	List<MetaIndicadorDTO> retorno = new ArrayList<MetaIndicadorDTO>();
    	
    	for(IndicadoresValorPadrao indicador : IndicadoresValorPadrao.values()) {
    		MetaIndicadorDTO dto = new MetaIndicadorDTO();
    		dto.setCdIndicador(indicador.getCdIndicador());
    		dto.setDsIndicador(indicador.getDsIndicador());
    		dto.setValorLegendaSuperior("85");
    		dto.setValorLegendaMeta("");
    		dto.setValorLegendaInferior("50");
    		dto.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_SUPERIOR));
    		dto.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META));
    		dto.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_INFERIOR));
    		dto.setMelhorAcimaMeta(indicador.isMelhorAcimaMeta());
    		retorno.add(dto);
    	}
    	
		retorno.add(getIndicadorPadraoEficienciaInstantanea());
    	
    	return retorno;
    }
    
    public List<MetaIndicadorDTO> getMetaIndicadores(FiltroDetalhePTInjetDTO filtro) {
    	List<MetaIndicadorDTO> retorno = new ArrayList<MetaIndicadorDTO>();
    	
    	for(IndicadoresValorPadrao indicador : IndicadoresValorPadrao.values()) {
    		MetaIndicadorDTO dto = new MetaIndicadorDTO();
    		dto.setCdIndicador(indicador.getCdIndicador());
    		dto.setDsIndicador(indicador.getDsIndicador());
    		dto.setValorLegendaSuperior(ConversaoTipos.converteParaString(indicador.getValorSuperior(), 2));
    		dto.setValorLegendaMeta(ConversaoTipos.converteParaString(indicador.getValorMeta(), 2));
    		dto.setValorLegendaInferior(ConversaoTipos.converteParaString(indicador.getValorInferior(), 2));
    		dto.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_SUPERIOR));
    		dto.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META));
    		dto.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_INFERIOR));
    		dto.setMelhorAcimaMeta(indicador.isMelhorAcimaMeta());
    		retorno.add(dto);
    	}
    	
    	IndicadoresMinMetaMaxDTO indicadores = getIndicadores(filtro.getOmPt().getCdPt());
    	for(MetaIndicadorDTO dto : retorno) {
    		IndicadorMinMetaMaxDTO indicador = extrairIndicador(dto.getCdIndicador(), indicadores);
    		if(indicador != null) {
    			dto.setValorLegendaSuperior(ConversaoTipos.converteParaString(indicador.getIndSuperior(), 2));
	    		dto.setValorLegendaMeta(ConversaoTipos.converteParaString(indicador.getIndMeta(), 2));
	    		dto.setValorLegendaInferior(ConversaoTipos.converteParaString(indicador.getIndInferior(), 2));
    		}
    	}

    	return retorno;
    }
    
    public IndicadoresMinMetaMaxDTO getIndicadores(String cdPt) {
    	PTRN ptrn = new PTRN(getDao());
    	OmPt pt;
    	try {
			pt = ptrn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}
    	FiltroIndCfg filtroIndicadores = new FiltroIndCfg();
    	filtroIndicadores.setOmGt(pt.getOmGt());
    	filtroIndicadores.setOmPt(pt);
    	
    	IndicadorRN indicadorRN = new IndicadorRN(getDao());
    	return indicadorRN.buscaIndicadoresMinMetaMax(filtroIndicadores);
    }
    
    public IndicadorMinMetaMaxDTO extrairIndicador(String cdIndicador, IndicadoresMinMetaMaxDTO indicadores) {
    	for(IndicadorMinMetaMaxDTO indicador : indicadores.getListaIndicadorMinMetaMexDTOs()) {
			if(indicador.getOmInd().getCdInd().equals(cdIndicador)) {
				return indicador;
    		}
    	}
    	return null;
    }
    
    public void preencherCamposDeCores(PtIndicadorDTO indicadorDTO, List<MetaIndicadorDTO> listaMetaIndicadores) {
    	indicadorDTO.setEficienciaRealizacaoCor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.EFICIENCIA_DE_REALIZACAO.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getEficienciaRealizacao()));
    	indicadorDTO.setEficienciaCicloCor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getEficienciaCiclo()));
    	indicadorDTO.setIndiceRefugoCor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_DE_REFUGO.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getIndiceRefugo()));
    	indicadorDTO.setIndiceParadaCor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_DE_PARADA.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getIndiceParada()));
    	indicadorDTO.setIndicePerdaCor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_DE_PERDA.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getIndicePerdaOuNR()));
    	indicadorDTO.setIndiceCavidadesAtivasCor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.INDICE_CAVIDADES_ATIVAS.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getIndiceCavidadesAtivas()));
    	indicadorDTO.setIndiceProdutividadeOEECor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.PRODUTIVIDADE_OEE.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getIndiceProdutividadeOEE()));
    }
    
    public String identificarCorDoIndicador(MetaIndicadorDTO indicador, String valorString) {
    	List<MetaIndicadorDTO> listaIndicadores = new ArrayList<MetaIndicadorDTO>();
    	listaIndicadores.add(indicador);
    	return identificarCorDoIndicador(indicador.getCdIndicador(), listaIndicadores, valorString);
    }
    
    public String identificarCorDoIndicador(String cdIndicador, List<MetaIndicadorDTO> listaIndicadores, String valorString) {
    	if(valorString.equals("")) {
    		return "";
    	}
    	
    	BigDecimal valor = ConversaoTipos.converteParaBigDecimal(valorString);
    	if (valor == null) {
    		valor = BigDecimal.ZERO;
    	}
    	
    	MetaIndicadorDTO indicadorSelecionado = getMetaIndicador(cdIndicador, listaIndicadores);
    	
    	if(indicadorSelecionado == null) {
    		return "";
    	}
    	
    	BigDecimal maiorValorMeta;
    	BigDecimal menorValorMeta;
    	boolean isPossuiValorMeta = !(indicadorSelecionado.getValorLegendaMeta() == null || indicadorSelecionado.getValorLegendaMeta().equals(""));
    	
    	if(indicadorSelecionado.isMelhorAcimaMeta()) {
    		
    		if(isPossuiValorMeta) {
    			maiorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaMeta());
    		} else {
    			maiorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaSuperior());
    		}
        	menorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaInferior());
        	
    	} else {
    		
    		maiorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaSuperior());
    		if(isPossuiValorMeta) {
    			menorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaMeta());
    		} else {
    			menorValorMeta = new BigDecimal(indicadorSelecionado.getValorLegendaInferior());
    		}
        	
    	}
    	
    	Color corSuperior = indicadorSelecionado.isMelhorAcimaMeta() ? COR_INDICADOR_SUPERIOR : COR_INDICADOR_INFERIOR;
    	Color corInferior = indicadorSelecionado.isMelhorAcimaMeta() ? COR_INDICADOR_INFERIOR : COR_INDICADOR_SUPERIOR;
    	    	
    	boolean isValorEhMaiorQueOIndicadorSuperior = valor.compareTo(maiorValorMeta) == 1;
    	if(isValorEhMaiorQueOIndicadorSuperior) {
    		return Cor.transformarParaCodigoHexadecimal(corSuperior);
    	}
    	
    	boolean isValorEhMenorQueOIndicadorInferior = valor.compareTo(menorValorMeta) == -1;
    	if(isValorEhMenorQueOIndicadorInferior) {
    		return Cor.transformarParaCodigoHexadecimal(corInferior);
    	}
    	
    	return Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META);
    }
    
    public MetaIndicadorDTO getMetaIndicador(String cdIndicador, List<MetaIndicadorDTO> listaIndicadores) {
    	for(MetaIndicadorDTO dto : listaIndicadores) {
    		if(dto.getCdIndicador().equals(cdIndicador)) {
    			return dto;
    		}
    	}
    	return null;
    }
    
    public static String identificarCor(BigDecimal valor, BigDecimal valorSuperior, BigDecimal valorInferior, BigDecimal valorMeta) {
    	boolean isValorEhMaiorQueOIndicadorSuperior = valor.compareTo(valorSuperior) == 1;
    	if(isValorEhMaiorQueOIndicadorSuperior) {
    		return Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_SUPERIOR);
    	}
    	
    	boolean isValorEhMenorQueOIndicadorInferior = valor.compareTo(valorInferior) == -1;
    	if(isValorEhMenorQueOIndicadorInferior) {
    		return Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_INFERIOR);
    	}
    	
    	return Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META);
    }
    
    public static MetaIndicadorDTO getIndicadorPadraoDosUltimosCiclos() {
    	MetaIndicadorDTO eficienciaCiclo = new MetaIndicadorDTO();
    	
    	eficienciaCiclo.setCdIndicador(IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.cdIndicador);
    	eficienciaCiclo.setDsIndicador(IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.dsIndicador);
    	eficienciaCiclo.setValorLegendaSuperior("90");
    	eficienciaCiclo.setValorLegendaMeta("");
    	eficienciaCiclo.setValorLegendaInferior("50");
    	eficienciaCiclo.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR));
    	eficienciaCiclo.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META));
    	eficienciaCiclo.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR));
    	eficienciaCiclo.setMelhorAcimaMeta(true);
    	
    	return eficienciaCiclo;
    }
    
    public static MetaIndicadorDTO getIndicadorPadraoGraficoRecorrenciaRefugo() {
    	MetaIndicadorDTO indicador = new MetaIndicadorDTO();
    	
    	indicador.setCdIndicador(IndicadoresValorPadrao.INDICE_DE_REFUGO.cdIndicador);
    	indicador.setDsIndicador(IndicadoresValorPadrao.INDICE_DE_REFUGO.dsIndicador);
    	indicador.setValorLegendaSuperior("3");
    	indicador.setValorLegendaMeta("");
    	indicador.setValorLegendaInferior("2");
    	indicador.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR));
    	indicador.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META));
    	indicador.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR));
    	indicador.setMelhorAcimaMeta(IndicadoresValorPadrao.INDICE_DE_REFUGO.isMelhorAcimaMeta);
    	
    	return indicador;
    }
    
    public static MetaIndicadorDTO getIndicadorPadraoGraficoRecorrenciaParada() {
    	MetaIndicadorDTO indicador = new MetaIndicadorDTO();
    	
    	indicador.setCdIndicador(IndicadoresValorPadrao.INDICE_DE_PARADA.cdIndicador);
    	indicador.setDsIndicador(IndicadoresValorPadrao.INDICE_DE_PARADA.dsIndicador);
    	indicador.setValorLegendaSuperior("50");
    	indicador.setValorLegendaMeta("");
    	indicador.setValorLegendaInferior("10");
    	indicador.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR));
    	indicador.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META));
    	indicador.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR));
    	indicador.setMelhorAcimaMeta(IndicadoresValorPadrao.INDICE_DE_PARADA.isMelhorAcimaMeta);
    	
    	return indicador;
    }
    
    public static MetaIndicadorDTO getIndicadorPadraoEficienciaInstantanea() {
    	MetaIndicadorDTO indicador = new MetaIndicadorDTO();
    	
    	indicador.setCdIndicador(IndicadoresValorPadrao.LISTA_MONITORIZACAO_EI.cdIndicador);
		indicador.setDsIndicador(IndicadoresValorPadrao.LISTA_MONITORIZACAO_EI.dsIndicador);
		indicador.setValorLegendaSuperior("85");
		indicador.setValorLegendaMeta("");
		indicador.setValorLegendaInferior("50");
		indicador.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_SUPERIOR));
		indicador.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META));
		indicador.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_INFERIOR));
		indicador.setMelhorAcimaMeta(true);
    	
    	return indicador;
    }
    
    public static MetaIndicadorDTO gerarIndicador(String valorSuperior, String valorInferior, boolean isMelhorAcimaMeta) {
    	MetaIndicadorDTO indicador = new MetaIndicadorDTO();
    	
    	indicador.setCdIndicador(IndicadoresValorPadrao.LISTA_MONITORIZACAO_IPADRAO.cdIndicador);
		indicador.setDsIndicador(IndicadoresValorPadrao.LISTA_MONITORIZACAO_IPADRAO.dsIndicador);
    	indicador.setValorLegendaSuperior(valorSuperior);
    	indicador.setValorLegendaMeta("");
    	indicador.setValorLegendaInferior(valorInferior);
    	indicador.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR));
    	indicador.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META));
    	indicador.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR));
    	indicador.setMelhorAcimaMeta(isMelhorAcimaMeta);
    	
    	return indicador;
    }
    
    
    
    public static List<MetaIndicadorDTO> getMetaIndicadores(DAOGenerico dao) {
    	OmCfg omCfg = Util.getConfigGeral(dao.getSession());
    	
    	List<MetaIndicadorDTO> retorno = new ArrayList<MetaIndicadorDTO>();
    	
    	for(IndicadoresValorPadrao indicador : IndicadoresValorPadrao.values()) {
    		if (indicador.getCdIndicador() != null) {
        		MetaIndicadorDTO dto = new MetaIndicadorDTO();
        		dto.setCdIndicador(indicador.getCdIndicador());
        		dto.setDsIndicador(indicador.getDsIndicador());
        		dto.setValorLegendaSuperior(ConversaoTipos.converteParaString(indicador.getValorSuperior(), 2));
        		dto.setValorLegendaMeta(ConversaoTipos.converteParaString(indicador.getValorMeta(), 2));
        		dto.setValorLegendaInferior(ConversaoTipos.converteParaString(indicador.getValorInferior(), 2));
        		dto.setMelhorAcimaMeta(indicador.isMelhorAcimaMeta());

        		dto.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_SUPERIOR));
        		dto.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META));
        		dto.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_INFERIOR));

        		
        		if (dto.isMelhorAcimaMeta()) {
            		dto.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_SUPERIOR));
            		dto.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META));
            		dto.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_INFERIOR));
        			
        		} else {
            		dto.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_INFERIOR));
            		dto.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_META));
            		dto.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(COR_INDICADOR_SUPERIOR));    			
        		}
        		
        		retorno.add(dto);    			
    		}

    	}
    	

		if (omCfg != null) {
			for (OmCfgind cfgInd : omCfg.getOmCfginds()) {
				MetaIndicadorDTO metaDTO = new MetaIndicadorDTO(); 
				metaDTO.setValorLegendaSuperior(ConversaoTipos.converteParaString(cfgInd.getIndSuperior(), 2));
				metaDTO.setValorLegendaMeta(ConversaoTipos.converteParaString(cfgInd.getIndMeta(), 2));
				metaDTO.setValorLegendaInferior(ConversaoTipos.converteParaString(cfgInd.getIndInferior(), 2)); 				
 				retorno.add(metaDTO);
			}
		}
    	return retorno;
    }
    
}
