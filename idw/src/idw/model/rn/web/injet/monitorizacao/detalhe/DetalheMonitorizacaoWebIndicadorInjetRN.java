package idw.model.rn.web.injet.monitorizacao.detalhe;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmInd;
import idw.model.rn.AbstractRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorRN;
import idw.util.Cor;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebIndicadorInjetRN extends AbstractRN<DAOGenericoInjet> {
	
	public static final Color COR_INDICADOR_SUPERIOR = new Color(51, 255, 51);
	public static final Color COR_INDICADOR_META = new Color(255, 255, 51);
	public static final Color COR_INDICADOR_INFERIOR = new Color(255, 51, 51);
	
	public enum IndicadoresValorPadrao {
		EFICIENCIA_DE_REALIZACAO("ER", "Eficiência de realização", "10", "20", "30", true),
		EFICIENCIA_DE_CICLO("EC", "Eficiência de ciclo", "10", "20", "30", true),
		INDICE_DE_REFUGO("IR", "Índice de refugo", "5", "8", "10", false),
		INDICE_DE_PARADA("IP", "Índice de parada", "5", "8", "10", false),
		PRODUTIVIDADE_OEE("OEE", "Produtividade (OEE)", "10", "20", "30", true),
		CICLO_MEDIO("CM", "Ciclo médio", "10", "20", "30", true),
		INDICE_DE_PERDA("IPD", "Índice de perda", "5", "8", "10", false),
		INDICE_DE_PERDA_PRODUTO("IPP", "Índice de perdas por produto", "5", "8", "10", false),
		INDICE_PCS_CICLO_ATIVAS("IPCA", "Índice de pcs/ciclo ativas", "10", "20", "30", true),
		INDICE_PCS_CICLO_INATIVAS("IPCI", "Índice de pcs/ciclo inativas", "5", "8", "10", false),
		EFICIENCIA_INSTANTANEA("EI", "Eficiência instantânea", "10", "20", "30", true);
		
		
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
	private static List<MetaIndicadorDTO> listaMetasIndicadores; 
	
	public DetalheMonitorizacaoWebIndicadorInjetRN(String formatoData, String formatoDataHora) {
        this(new DAOGenericoInjet(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebIndicadorInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;       
        listaMetasIndicadores = getMetaIndicadores(dao);
    }
        
    
    public static List<MetaIndicadorDTO> getMetaIndicadores(DAOGenericoInjet dao) {
    	List<MetaIndicadorDTO> retorno = new ArrayList<MetaIndicadorDTO>();
    	
    	for(IndicadoresValorPadrao indicador : IndicadoresValorPadrao.values()) {
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
    	
		MonitorizacaoInjetRN rnM = new MonitorizacaoInjetRN();
		List<OmInd> listaCfgInd = rnM.getCfgIndInjet(dao);    	
    	
    	
    	for(OmInd indicador : listaCfgInd ) {
    		for(MetaIndicadorDTO dto : retorno) {
    			if(indicador.getCdInd() .equals(dto.getCdIndicador())) {
    				OmCfgind cfgInd = indicador.getOmCfginds().iterator().next();    				
    				dto.setValorLegendaSuperior(ConversaoTipos.converteParaString(cfgInd.getIndSuperior(), 2));
    	    		dto.setValorLegendaMeta(ConversaoTipos.converteParaString(cfgInd.getIndMeta(), 2));
    	    		dto.setValorLegendaInferior(ConversaoTipos.converteParaString(cfgInd.getIndInferior(), 2));
        		}
    		}
    	}
    	return retorno;
    }
    

    @SuppressWarnings("unchecked")
	public static List<MetaIndicadorDTO> getMetaIndicadoresGraficoPontos(DAOGenericoInjet dao) {
    	List<MetaIndicadorDTO> retorno = new ArrayList<MetaIndicadorDTO>();
    	
    	int _codigo = 0;
    	int _minimo = _codigo + 1;
    	int _maximo = _minimo + 1;
    	int _meta = _maximo + 1;
    	
    	class Registro {
    		String codigo;
    		BigDecimal maximo = BigDecimal.ZERO;
    		BigDecimal minimo = BigDecimal.ZERO;
    		BigDecimal meta = BigDecimal.ZERO;
    	}
    	
    	String strSQL = "SELECT Codigo, Min, Max, Meta FROM IjTbConfigPlot";
		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = dao.getSession().createSQLQuery(strSQL);
		
		lista = q.list();		
		for (Object reg : lista) {
			Registro registro = new Registro();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.codigo = (String) registroLido[_codigo];
			registro.minimo = ConversaoTipos.converterParaBigDecimal(registroLido[_minimo]);
			registro.maximo = ConversaoTipos.converterParaBigDecimal(registroLido[_maximo]);
			registro.meta = ConversaoTipos.converterParaBigDecimal(registroLido[_meta]);
			
			MetaIndicadorDTO dto = new MetaIndicadorDTO();
			if (registro.codigo.equals("01")) {
				dto.setCdIndicador(IndicadoresValorPadrao.EFICIENCIA_DE_REALIZACAO.cdIndicador);
				dto.setDsIndicador(IndicadoresValorPadrao.EFICIENCIA_DE_REALIZACAO.dsIndicador);
			}
			if (registro.codigo.equals("02")) {
				dto.setCdIndicador(IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.cdIndicador);
				dto.setDsIndicador(IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.dsIndicador);
			}
			if (registro.codigo.equals("03")) {
				dto.setCdIndicador(IndicadoresValorPadrao.INDICE_DE_REFUGO.cdIndicador);
				dto.setDsIndicador(IndicadoresValorPadrao.INDICE_DE_REFUGO.dsIndicador);
			}
			if (registro.codigo.equals("04")) {
				dto.setCdIndicador(IndicadoresValorPadrao.INDICE_DE_PARADA.cdIndicador);
				dto.setDsIndicador(IndicadoresValorPadrao.INDICE_DE_PARADA.dsIndicador);
			}
			if (registro.codigo.equals("05")) {
				dto.setCdIndicador(IndicadoresValorPadrao.INDICE_DE_PERDA.cdIndicador);
				dto.setDsIndicador(IndicadoresValorPadrao.INDICE_DE_PERDA.dsIndicador);
			}
			if (registro.codigo.equals("06")) {
				dto.setCdIndicador(IndicadoresValorPadrao.INDICE_PCS_CICLO_ATIVAS.cdIndicador);
				dto.setDsIndicador(IndicadoresValorPadrao.INDICE_PCS_CICLO_ATIVAS.dsIndicador);
			}
			if (registro.codigo.equals("07")) {
				dto.setCdIndicador(IndicadoresValorPadrao.PRODUTIVIDADE_OEE.cdIndicador);
				dto.setDsIndicador(IndicadoresValorPadrao.PRODUTIVIDADE_OEE.dsIndicador);
			}
			
			dto.setValorLegendaSuperior(ConversaoTipos.converteParaString(registro.maximo, 2));
    		dto.setValorLegendaMeta(ConversaoTipos.converteParaString(registro.meta, 2));
    		dto.setValorLegendaInferior(ConversaoTipos.converteParaString(registro.minimo, 2));
    		dto.setCorLegendaSuperior("");
    		dto.setCorLegendaMeta("");
    		dto.setCorLegendaInferior("");
    		dto.setMelhorAcimaMeta(false);
    		
    		retorno.add(dto);						
		}
    	
    	return retorno;
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
    	indicadorDTO.setIndiceProdutividadeOEECor(identificarCorDoIndicador(
    			IndicadoresValorPadrao.PRODUTIVIDADE_OEE.cdIndicador, 
    			listaMetaIndicadores, 
    			indicadorDTO.getIndiceProdutividadeOEE()));

    	if (indicadorDTO.getEficienciaCicloMedio() != null) {
	    	indicadorDTO.setEficienciaCicloMedioCor(identificarCorDoIndicador(
	    			IndicadoresValorPadrao.CICLO_MEDIO.cdIndicador, 
	    			listaMetaIndicadores, 
	    			indicadorDTO.getEficienciaCicloMedio()));    
    	}
    	
    	if (indicadorDTO.getIndicePerdaOuNR() != null) {
	    	indicadorDTO.setIndicePerdaCor(identificarCorDoIndicador(
	    			IndicadoresValorPadrao.INDICE_DE_PERDA.cdIndicador, 
	    			listaMetaIndicadores, 
	    			indicadorDTO.getIndicePerdaOuNR()));    
	    	indicadorDTO.setIndicePerdaOuNRCor(indicadorDTO.getIndicePerdaCor()); 
    	}
    	
    	if (indicadorDTO.getIndicePerdaProduto() != null) {
	    	indicadorDTO.setIndicePerdaProdutoCor(identificarCorDoIndicador(
	    			IndicadoresValorPadrao.INDICE_DE_PERDA_PRODUTO.cdIndicador, 
	    			listaMetaIndicadores, 
	    			indicadorDTO.getIndicePerdaProduto()));    	
    	}
    	if (indicadorDTO.getIndiceCavidadesAtivas() != null) {
	    	indicadorDTO.setIndiceCavidadesAtivasCor(identificarCorDoIndicador(
	    			IndicadoresValorPadrao.INDICE_PCS_CICLO_ATIVAS.cdIndicador, 
	    			listaMetaIndicadores, 
	    			indicadorDTO.getIndiceCavidadesAtivas()));   
    	}
    	if (indicadorDTO.getIndiceCavidadesInativas() != null) {
	    	indicadorDTO.setIndiceCavidadesInativasCor(identificarCorDoIndicador(
	    			IndicadoresValorPadrao.INDICE_PCS_CICLO_INATIVAS.cdIndicador, 
	    			listaMetaIndicadores, 
	    			indicadorDTO.getIndiceCavidadesInativas())); 
    	}    	
    	if (indicadorDTO.getEficienciaInstantanea() != null) {
	    	indicadorDTO.setIndiceCavidadesInativasCor(identificarCorDoIndicador(
	    			IndicadoresValorPadrao.EFICIENCIA_INSTANTANEA.cdIndicador, 
	    			listaMetaIndicadores, 
	    			indicadorDTO.getEficienciaInstantanea())); 
    	}
    	
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
    	BigDecimal valor = new BigDecimal(valorString);
    	
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
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.ordinal());
    	return metaIndicador;
    }

    public static MetaIndicadorDTO getIndicadorCicloMedio() {
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.CICLO_MEDIO.ordinal());
    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO getIndicadorPadraoGraficoRecorrenciaRefugo() {
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.INDICE_DE_REFUGO.ordinal());
    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO getIndicadorPadraoGraficoRecorrenciaParada() {
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.INDICE_DE_PARADA.ordinal());
    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO getIndicadorPadraoEficienciaInstantanea() {
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.EFICIENCIA_INSTANTANEA.ordinal());
    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO getIndicadorPerdasProduto() {
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.INDICE_DE_PERDA_PRODUTO.ordinal());
    	return metaIndicador;
    }

    public static MetaIndicadorDTO getIndicadorOEE() {
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.PRODUTIVIDADE_OEE.ordinal());
    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO getIndicadorEficienciaRealizacao() {
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.EFICIENCIA_DE_REALIZACAO.ordinal());
    	return metaIndicador;
    }

    public static MetaIndicadorDTO getIndicadorPcsCicloAtivas(){
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.INDICE_PCS_CICLO_ATIVAS.ordinal());
    	return metaIndicador;
    }

    public static MetaIndicadorDTO getIndicadorPerdas(){
    	MetaIndicadorDTO metaIndicador = listaMetasIndicadores.get(IndicadoresValorPadrao.INDICE_DE_PERDA.ordinal());
    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO getIndicadorUtilizacao() {
    	MetaIndicadorDTO metaIndicadorEfiRea = listaMetasIndicadores.get(IndicadoresValorPadrao.EFICIENCIA_DE_REALIZACAO.ordinal());
    	MetaIndicadorDTO metaIndicador = new MetaIndicadorDTO();
    	metaIndicador.setCdIndicador("U");
    	metaIndicador.setDsIndicador("Utilização");
    	
    	metaIndicador.setCorLegendaInferior(metaIndicadorEfiRea.getCorLegendaInferior());
    	metaIndicador.setCorLegendaMeta(metaIndicadorEfiRea.getCorLegendaMeta());
    	metaIndicador.setCorLegendaSuperior(metaIndicadorEfiRea.getCorLegendaSuperior());
    	metaIndicador.setMelhorAcimaMeta(metaIndicadorEfiRea.isMelhorAcimaMeta());
    	metaIndicador.setValorLegendaInferior(metaIndicadorEfiRea.getValorLegendaInferior());
    	metaIndicador.setValorLegendaMeta(metaIndicadorEfiRea.getValorLegendaMeta());
    	metaIndicador.setValorLegendaSuperior(metaIndicadorEfiRea.getValorLegendaSuperior());

    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO getIndicadorProducaoLiquida() {
    	MetaIndicadorDTO metaIndicadorEfiRea = listaMetasIndicadores.get(IndicadoresValorPadrao.EFICIENCIA_DE_REALIZACAO.ordinal());
    	MetaIndicadorDTO metaIndicador = new MetaIndicadorDTO();
    	
    	metaIndicador.setCdIndicador("PL");
    	metaIndicador.setDsIndicador("Produção líquida");
    	
    	metaIndicador.setCorLegendaInferior(metaIndicadorEfiRea.getCorLegendaInferior());
    	metaIndicador.setCorLegendaMeta(metaIndicadorEfiRea.getCorLegendaMeta());
    	metaIndicador.setCorLegendaSuperior(metaIndicadorEfiRea.getCorLegendaSuperior());
    	metaIndicador.setMelhorAcimaMeta(metaIndicadorEfiRea.isMelhorAcimaMeta());
    	metaIndicador.setValorLegendaInferior(metaIndicadorEfiRea.getValorLegendaInferior());
    	metaIndicador.setValorLegendaMeta(metaIndicadorEfiRea.getValorLegendaMeta());
    	metaIndicador.setValorLegendaSuperior(metaIndicadorEfiRea.getValorLegendaSuperior());
    	
    	return metaIndicador;
    }
    
    public static MetaIndicadorDTO gerarIndicador(String valorSuperior, String valorInferior, boolean isMelhorAcimaMeta) {
    	MetaIndicadorDTO indicador = new MetaIndicadorDTO();
    	
    	indicador.setCdIndicador("IP");
		indicador.setDsIndicador("Indicador Padrão");
    	indicador.setValorLegendaSuperior(valorSuperior);
    	indicador.setValorLegendaMeta("");
    	indicador.setValorLegendaInferior(valorInferior);
    	indicador.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR));
    	indicador.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META));
    	indicador.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR));
    	indicador.setMelhorAcimaMeta(isMelhorAcimaMeta);    	
    	return indicador;
    }
    
}
