package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbfresh;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.injet.SenhaRN;
import idw.webservices.rest.dto.monitorizacao.injet.CfgUnidadeMedidaInjetDTO;
import ms.util.ConversaoTipos;



public class ConfiguracoesInjetRN extends DAOGenericoInjet {
	private static ConfiguracoesInjetRN instancia = null;

	private static final int UNIDADE_BASICA_PECA = 1;
	private static final int UNIDADE_BASICA_METRO = 2;
	private static final int UNIDADE_BASICA_FOLHA = 3;
	private static final int UNIDADE_BASICA_KG = 4;
	private static final int UNIDADE_BASICA_PECA_DECIMAL = 5;
	private static final int UNIDADE_BASICA_TONELADA = 6;
	private static final int UNIDADE_BASICA_METRO_QUADRADO = 7;

	private static final String IJTBFRESH_UNIDADE_MEDIDA_PECA = "PECAS";
	private static final String IJTBFRESH_UNIDADE_MEDIDA_METRO = "METROS";
	private static final String IJTBFRESH_UNIDADE_MEDIDA_FOLHA = "FOLHAS";
	private static final String IJTBFRESH_UNIDADE_MEDIDA_KG = "QUILOGRAMAS";
	private static final String IJTBFRESH_UNIDADE_MEDIDA_PECA_DECIMAL = "PECAS_DECIMAL";
	private static final String IJTBFRESH_UNIDADE_MEDIDA_TONELADA = "TONELADAS";
	private static final String IJTBFRESH_UNIDADE_MEDIDA_METRO_QUADRADO = "METRO_QUADRADO²";
	
	private static final String SIGLA_UNIDADE_MEDIDA_PECA = "Pç";
	private static final String SIGLA_UNIDADE_MEDIDA_METRO = "m";
	private static final String SIGLA_UNIDADE_MEDIDA_FOLHA = "fl";
	private static final String SIGLA_UNIDADE_MEDIDA_KG = "Kg";
	private static final String SIGLA_UNIDADE_MEDIDA_PECA_DECIMAL = "Pç";
	private static final String SIGLA_UNIDADE_MEDIDA_TONELADA = "Ton";
	private static final String SIGLA_UNIDADE_MEDIDA_METRO_QUADRADO = "m²";

	private static CfgUnidadeMedidaInjetDTO cfgUBInjet = null;
	private static Ijtbfresh ijtbfresh = null;
	private static BigDecimal qtdCiclosMonitorar = null;
	
	private ConfiguracoesInjetRN() {
		DiversosInjetRN rnINJ = new DiversosInjetRN();
		rnINJ.getDao().iniciaSessao();
		ijtbfresh = rnINJ.getIjtbfresh().get(0);
		qtdCiclosMonitorar  = rnINJ.getQtdCiclosMonitorar();
		rnINJ.getDao().finalizaSessao();
	}

	public static ConfiguracoesInjetRN getInstancia() {
		if (instancia == null) {
			instancia = new ConfiguracoesInjetRN();
		}

		return instancia;
	}

	public static CfgUnidadeMedidaInjetDTO getCfsgUnidadeMedida(){
		CfgUnidadeMedidaInjetDTO cfg = new CfgUnidadeMedidaInjetDTO();
		
		getInstancia();
		
		String unidadeMedida = SenhaRN.descriptografarSenha(ijtbfresh.getPk().getCampo14().trim());
		
		if (unidadeMedida.equals(IJTBFRESH_UNIDADE_MEDIDA_PECA)) {
			cfg.setUnidadeContagemBasica(UNIDADE_BASICA_PECA);
			cfg.setFormatoContagemBasica("");
			cfg.setDivisorContagemBasica(1);
			cfg.setSiglaContagemBasica(SIGLA_UNIDADE_MEDIDA_PECA);
		}

		if (unidadeMedida.equals(IJTBFRESH_UNIDADE_MEDIDA_FOLHA)) {
			cfg.setUnidadeContagemBasica(UNIDADE_BASICA_FOLHA);
			cfg.setFormatoContagemBasica("");
			cfg.setDivisorContagemBasica(1);
			cfg.setSiglaContagemBasica(SIGLA_UNIDADE_MEDIDA_FOLHA);			
		}

		
		if (unidadeMedida.equals(IJTBFRESH_UNIDADE_MEDIDA_METRO)) {
			cfg.setUnidadeContagemBasica(UNIDADE_BASICA_METRO);
			cfg.setFormatoContagemBasica("#0.000");
			cfg.setDivisorContagemBasica(1000);
			cfg.setSiglaContagemBasica(SIGLA_UNIDADE_MEDIDA_METRO);

		}
		
		if (unidadeMedida.equals(IJTBFRESH_UNIDADE_MEDIDA_KG)) {
			cfg.setUnidadeContagemBasica(UNIDADE_BASICA_PECA);
			cfg.setFormatoContagemBasica("#0.000");
			cfg.setDivisorContagemBasica(1000);
			cfg.setSiglaContagemBasica(SIGLA_UNIDADE_MEDIDA_KG);			
		}
		
		if (unidadeMedida.equals(IJTBFRESH_UNIDADE_MEDIDA_TONELADA)) {
			cfg.setUnidadeContagemBasica(UNIDADE_BASICA_TONELADA);
			cfg.setFormatoContagemBasica("#0.00");
			cfg.setDivisorContagemBasica(1000000);
			cfg.setSiglaContagemBasica(SIGLA_UNIDADE_MEDIDA_TONELADA);			
		}
		
		
		if (unidadeMedida.equals(IJTBFRESH_UNIDADE_MEDIDA_PECA_DECIMAL)) {
			cfg.setUnidadeContagemBasica(UNIDADE_BASICA_PECA_DECIMAL);
			cfg.setFormatoContagemBasica("#0.00");
			cfg.setDivisorContagemBasica(100);
			cfg.setSiglaContagemBasica(SIGLA_UNIDADE_MEDIDA_PECA_DECIMAL);			
		}
		
		if (unidadeMedida.equals(IJTBFRESH_UNIDADE_MEDIDA_METRO_QUADRADO)) {
			cfg.setUnidadeContagemBasica(UNIDADE_BASICA_METRO_QUADRADO);
			cfg.setFormatoContagemBasica("#,##0.0");
			cfg.setDivisorContagemBasica(1);
			cfg.setSiglaContagemBasica(SIGLA_UNIDADE_MEDIDA_METRO_QUADRADO);			
		}
		
		return cfg;
	}

	public static BigDecimal converterCavidadesUnidadeBasicaInjet(BigDecimal qtPcsPorCiclo)
	{	
		getInstancia();
		
		if (cfgUBInjet == null) {
			cfgUBInjet = getCfsgUnidadeMedida();
		}
		
		BigDecimal retorno = null;
		
		if (cfgUBInjet.getUnidadeContagemBasica() == UNIDADE_BASICA_PECA_DECIMAL || cfgUBInjet.getUnidadeContagemBasica() == UNIDADE_BASICA_TONELADA || cfgUBInjet.getUnidadeContagemBasica() == UNIDADE_BASICA_METRO_QUADRADO)
		{
			//Estas unidades apresentam a entrada de "cavidades" no formato final. Temos que aplicar FormatoPadrao
			retorno = converterParaUnidadeBasicaInjet(qtPcsPorCiclo);
		} else {
			retorno = qtPcsPorCiclo;
		}
		
		return retorno;
	}

	
	public static BigDecimal converterParaUnidadeBasicaInjet(BigDecimal quantidade)
	{	
		BigDecimal valorRetorno = null;
		
		getInstancia();
		
		if (cfgUBInjet == null) {
			cfgUBInjet = getCfsgUnidadeMedida();
		}
		
		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_PECA || cfgUBInjet.getUnidadeContagemBasica() == UNIDADE_BASICA_FOLHA) {
			// Defeito #5451 - Gráfico de Produção - Aba Perdas - algumas colunas estão com valores diferente do Injet 
			// Virtual Factory » INJET WEB

			if (quantidade.abs().doubleValue() <= 0.5d) {
				valorRetorno = BigDecimal.ZERO;
			} else {
				valorRetorno = quantidade.divide(new BigDecimal(cfgUBInjet.getDivisorContagemBasica())).setScale(0, BigDecimal.ROUND_HALF_UP);
			}
		}

		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_PECA_DECIMAL || cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_TONELADA) {
			valorRetorno = quantidade.divide(new BigDecimal(cfgUBInjet.getDivisorContagemBasica())).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_KG || cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_METRO) {
			valorRetorno = quantidade.divide(new BigDecimal(cfgUBInjet.getDivisorContagemBasica())).setScale(3, BigDecimal.ROUND_HALF_UP);
		}

		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_METRO_QUADRADO) {
			valorRetorno = quantidade.divide(new BigDecimal(cfgUBInjet.getDivisorContagemBasica())).setScale(1, BigDecimal.ROUND_UNNECESSARY);
		}
		
		return valorRetorno;
	}

	public static String aplicarFormatoUnidadeBasicaInjet(BigDecimal quantidade)
	{	
		BigDecimal valorRetorno = null;
		String valorRetornoStr = null;
		int numDecimais = 0;
		
		getInstancia();
		
		if (cfgUBInjet == null) {
			cfgUBInjet = getCfsgUnidadeMedida();
		}
		
		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_PECA || cfgUBInjet.getUnidadeContagemBasica() == UNIDADE_BASICA_FOLHA) {
			numDecimais = 0;
			
			if (quantidade.abs().doubleValue() <= 0.5d) {
				valorRetorno = BigDecimal.ZERO;
			} else {
				valorRetorno = quantidade.divide(BigDecimal.ONE).setScale(0, BigDecimal.ROUND_HALF_UP);
			}
		}

		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_PECA_DECIMAL || cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_TONELADA) {
			numDecimais = 2;
			valorRetorno = quantidade.divide(BigDecimal.ONE).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_KG || cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_METRO) {
			numDecimais = 3;
			valorRetorno = quantidade.divide(BigDecimal.ONE).setScale(3, BigDecimal.ROUND_HALF_UP);
		}

		if (cfgUBInjet.getUnidadeContagemBasica() ==  UNIDADE_BASICA_METRO_QUADRADO) {
			numDecimais = 1;
			valorRetorno = quantidade.divide(BigDecimal.ONE).setScale(1, BigDecimal.ROUND_UNNECESSARY);
			
		}		
		valorRetornoStr = ConversaoTipos.converteParaString(valorRetorno, numDecimais);
		
		return valorRetornoStr;
	}
	
	public static boolean getIsPcsPrevistaPelasCavTotais(){
		getInstancia();
		
		String unidadeMedida = ijtbfresh.getPk().getCampo23().trim();		
		if (unidadeMedida.equals("¬¬ª¿±·¿½­")) {
			return true;			
		} else {			
			return false;
		}					
	}
	
	public static BigDecimal getQtdCiclosMonitorar(){
		getInstancia();
		return qtdCiclosMonitorar;		
	}	
	
}
