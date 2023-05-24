package idw.webservices.rest.idw.v2.dto;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
 
import idw.util.Cor;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;

public class PtMonitDTO {
	
	public enum StFuncionamentoPt {
		OFF_LINE(0), PARADA(1), TRABALHANDO_FORA_DA_META(2), TRABALHANDO_NA_META(3);
		
		private final int valor;

		private StFuncionamentoPt(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}


	public enum StCorFundoPt{
		SEM_FUNDO(0), EM_ALERTA(1), SEM_PLANEJAMENTO(2), OP_XXX_CONCLUIDA(3), OP_CONCLUIDA(4), IND_REF_ACIMA_XXX(5), COM_PAR_NAO_INF(6), COM_PAR_SEM_PESO(7), EM_CIP(8);
		
		private final int valor;

		private StCorFundoPt(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}
	
	public enum TipoPostoNIDW{
		SEM_USO(0), 
		EMBALADORA(1), ENVASADORA(2), FURADEIRA(3), GALVANOPLASTIA(4), INJETORA(5), LINER(6), 
		LINHA(7), NAVIO(8), PRENSA(9), ROBO(10), ROTULADORA(11), SLITTER(12), 
		SOPRADORA(13), TOP(14), TORNO(15), USINAGEM(16), SMD(17), FORNO(18);
		
		private final int valor;

		private TipoPostoNIDW(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}
	
	public static final String COR_BORDA_PAR_COM_PESO =  "#353C4A";
		
	public static final String COR_ST_FUNC_PT_OFF =  "#727272";
	public static final String COR_ST_FUNC_PT_PARADA = "#E9494E";
	public static final String COR_ST_FUNC_PT_FORA_META = "#F7B232";
	public static final String COR_ST_FUNC_PT_NA_META = "#46A756";
		
	
	public static final String COR_FUNDO_SEM_COR = "#FFFFFF"; 
	public static final String COR_FUNDO_EM_ALERTA = "#FF9300";
	public static final String COR_FUNDO_SEM_PLANO = "#7F91FF";
	public static final String COR_FUNDO_OP_XXX_CONCLUIDA = "#7F85BF";
	public static final String COR_FUNDO_OP_CONCLUIDA = "#7FFFFF";
	public static final String COR_FUNDO_IND_REF_ACIMA_XXX ="#CDCDCD";
	public static final String COR_FUNDO_PAR_SEM_PESO = "#FF22FF";
	public static final String COR_FUNDO_PAR_NAO_INF = "#7F7F7F";
	public static final String COR_FUNDO_EM_CIP = "#A9FEA9";
	
	
	
	// id do pt
	private String cdPt;
	private String dsPt;
	
	private String cdCp = "";
	private String cdFolha = "";
	private String cdRap = "";
	
	// tipo do pt e posicao na tela
	private Integer idImg = 0;
	private Integer x = 0;
	private Integer y = 0;
	
	// indicadores do monitoramento
	private BigDecimal efiRea = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal efiCic = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal efiInst = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal indPar = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal indRef = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal indPCI = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal indProd = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal indOEE = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	
	
	// status de funcionamento (define a cor do pt)
	private Integer stFuncionamentoPt = 0 ;
	private String corHexaIconePt = "";
	
	// situações que definem a cor de fundo
	private Boolean ptEmAlerta = false;
	private Boolean ptSemPlano = false;
	private Boolean ptComOPXXConcluida = false;
	private Boolean ptComOPConcluida = false;
	private Boolean ptComIndRefAcimaCfg = false;
	private Boolean ptComParNaoInf = false;
	private Boolean ptComParSemPeso = false;
	private Boolean ptComCIP = false;
	
	private Integer idStCorFundoIcone = 0;
	private String corHexaFundoIcone = "";
	
	// outras situações (imagens adicionais)
	private Boolean ptComConsolEmAtraso = false;
	private Boolean ptComPerdaSinc = false;
	private Boolean ptComParManutencao = false;
	private Boolean ptComOperadorLogado = false;
	private Boolean ptComAlertaVidaUtil = false;
	private Boolean ptComManutPrev = false;

	// define se ícone tem borda
	private Boolean iconeComBorda = false;
	private String corHexaBorda = "";
	
	// define se ícone pisca
	private Boolean iconePisca = false;
	


	private String produto;
	private List<UsrDTO> operadores;
	 
	
	// info do monit por tabela
	private BigDecimal metaInstantanea = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal prodBruta = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal prodRef = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal prodLiq = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal prodSaldo = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP); 
	
	private BigDecimal prodPrevUltOP = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal prodSaldoUltOP = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal prodPlanUltOP = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP); 
	

	
	private String dtHrIniUltPar = ""; //ymdhms
	private String dtHrFimUlPar = "";
	private String duracaoUltPar = ""; //hms
	private String parada = "";
	private String areaResp = "";
	private String tempoParadas = ""; //hms
	private String tempoDisp = ""; //hms

	private BigDecimal cicloPadrao = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal ultimoCicloLido = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal cicloMedio = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

	private FiltroDetalhePostoDTO filtroClickPt;
	

	
	public BigDecimal getProdBruta() {
		return prodBruta;
	}



	public BigDecimal getProdSaldoUltOP() {
		return prodSaldoUltOP;
	}



	public void setProdSaldoUltOP(BigDecimal prodSaldoUltOP) {
		this.prodSaldoUltOP = prodSaldoUltOP;
	}



	public BigDecimal getProdPlanUltOP() {
		return prodPlanUltOP;
	}



	public void setProdPlanUltOP(BigDecimal prodPlanUltOP) {
		this.prodPlanUltOP = prodPlanUltOP;
	}



	public void setProdBruta(BigDecimal prodBruta) {
		this.prodBruta = prodBruta;
	}



	public BigDecimal getProdRef() {
		return prodRef;
	}



	public void setProdRef(BigDecimal prodRef) {
		this.prodRef = prodRef;
	}


 


	public BigDecimal getMetaInstantanea() {
		return metaInstantanea;
	}



	public void setMetaInstantanea(BigDecimal metaInstantanea) {
		this.metaInstantanea = metaInstantanea;
	}



	public BigDecimal getProdSaldo() {
		return prodSaldo;
	}



	public void setProdSaldo(BigDecimal prodSaldo) {
		this.prodSaldo = prodSaldo;
	}


	public String getDtHrIniUltPar() {
		return dtHrIniUltPar;
	}



	public void setDtHrIniUltPar(String dtHrIniUltPar) {
		this.dtHrIniUltPar = dtHrIniUltPar;
	}



	public String getDtHrFimUlPar() {
		return dtHrFimUlPar;
	}



	public void setDtHrFimUlPar(String dtHrFimUlPar) {
		this.dtHrFimUlPar = dtHrFimUlPar;
	}



	public String getDuracaoUltPar() {
		return duracaoUltPar;
	}



	public void setDuracaoUltPar(String duracaoUltPar) {
		this.duracaoUltPar = duracaoUltPar;
	}



	public String getParada() {
		return parada;
	}



	public void setParada(String parada) {
		this.parada = parada;
	}



	public String getAreaResp() {
		return areaResp;
	}



	public void setAreaResp(String areaResp) {
		this.areaResp = areaResp;
	}



	public String getTempoParadas() {
		return tempoParadas;
	}



	public void setTempoParadas(String tempoParadas) {
		this.tempoParadas = tempoParadas;
	}



	public String getTempoDisp() {
		return tempoDisp;
	}



	public void setTempoDisp(String tempoDisp) {
		this.tempoDisp = tempoDisp;
	}



	public BigDecimal getUltimoCicloLido() {
		return ultimoCicloLido;
	}



	public void setUltimoCicloLido(BigDecimal ultimoCicloLido) {
		this.ultimoCicloLido = ultimoCicloLido;
	}



	public BigDecimal getCicloMedio() {
		return cicloMedio;
	}



	public void setCicloMedio(BigDecimal cicloMedio) {
		this.cicloMedio = cicloMedio;
	}


	
	
	public String getCdPt() {
		return cdPt;
	}



	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}



	public String getDsPt() {
		return dsPt;
	}



	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}



	public Integer getIdImg() {
		return idImg;
	}



	public void setIdImg(Integer idImg) {
		this.idImg = idImg;
	}



	public Integer getX() {
		return x;
	}



	public void setX(Integer x) {
		this.x = x;
	}



	public Integer getY() {
		return y;
	}



	public void setY(Integer y) {
		this.y = y;
	}



	public BigDecimal getEfiRea() {
		return efiRea;
	}



	public void setEfiRea(BigDecimal efiRea) {
		this.efiRea = efiRea;
	}



	public BigDecimal getEfiCic() {
		return efiCic;
	}



	public void setEfiCic(BigDecimal efiCic) {
		this.efiCic = efiCic;
	}



	public BigDecimal getEfiInst() {
		return efiInst;
	}



	public void setEfiInst(BigDecimal efiInst) {
		this.efiInst = efiInst;
	}



	public BigDecimal getIndPar() {
		return indPar;
	}



	public void setIndPar(BigDecimal indPar) {
		this.indPar = indPar;
	}



	public BigDecimal getIndRef() {
		return indRef;
	}



	public void setIndRef(BigDecimal indRef) {
		this.indRef = indRef;
	}



	public BigDecimal getIndPCI() {
		return indPCI;
	}



	public void setIndPCI(BigDecimal indPCI) {
		this.indPCI = indPCI;
	}



	public BigDecimal getIndProd() {
		return indProd;
	}



	public void setIndProd(BigDecimal indProd) {
		this.indProd = indProd;
	}



	public BigDecimal getIndOEE() {
		return indOEE;
	}



	public void setIndOEE(BigDecimal indOEE) {
		this.indOEE = indOEE;
	}


	public Boolean getPtEmAlerta() {
		return ptEmAlerta;
	}



	public void setPtEmAlerta(Boolean ptEmAlerta) {
		this.ptEmAlerta = ptEmAlerta;
	}



	public Boolean getPtSemPlano() {
		return ptSemPlano;
	}



	public void setPtSemPlano(Boolean ptSemPlano) {
		this.ptSemPlano = ptSemPlano;
	}



	public Boolean getPtComOPXXConcluida() {
		return ptComOPXXConcluida;
	}



	public void setPtComOPXXConcluida(Boolean ptComOPXXConcluida) {
		this.ptComOPXXConcluida = ptComOPXXConcluida;
	}



	public Boolean getPtComOPConcluida() {
		return ptComOPConcluida;
	}



	public void setPtComOPConcluida(Boolean ptComOPConcluida) {
		this.ptComOPConcluida = ptComOPConcluida;
	}



	public Boolean getPtComIndRefAcimaCfg() {
		return ptComIndRefAcimaCfg;
	}



	public void setPtComIndRefAcimaCfg(Boolean ptComIndRefAcimaCfg) {
		this.ptComIndRefAcimaCfg = ptComIndRefAcimaCfg;
	}



	public Boolean getPtComParNaoInf() {
		return ptComParNaoInf;
	}



	public void setPtComParNaoInf(Boolean ptComParNaoInf) {
		this.ptComParNaoInf = ptComParNaoInf;
	}



	public Boolean getPtComParSemPeso() {
		return ptComParSemPeso;
	}



	public void setPtComParSemPeso(Boolean ptComParSemPeso) {
		this.ptComParSemPeso = ptComParSemPeso;
	}



	public Boolean getPtComCIP() {
		return ptComCIP;
	}



	public void setPtComCIP(Boolean ptComCIP) {
		this.ptComCIP = ptComCIP;
	}


	public Boolean getPtComParManutencao() {
		return ptComParManutencao;
	}



	public void setPtComParManutencao(Boolean ptComParManutencao) {
		this.ptComParManutencao = ptComParManutencao;
	}



	public Boolean getPtComConsolEmAtraso() {
		return ptComConsolEmAtraso;
	}



	public void setPtComConsolEmAtraso(Boolean ptComConsolEmAtraso) {
		this.ptComConsolEmAtraso = ptComConsolEmAtraso;
	}


	public String getCorHexaBorda() {
		return corHexaBorda;
	}



	public void setCorHexaBorda(String corHexaBorda) {
		this.corHexaBorda = corHexaBorda;
	}

 
	public Boolean getPtComOperadorLogado() {
		return ptComOperadorLogado;
	}



	public void setPtComOperadorLogado(Boolean ptComOperadorLogado) {
		this.ptComOperadorLogado = ptComOperadorLogado;
	}



	public Boolean getPtComPerdaSinc() {
		return ptComPerdaSinc;
	}



	public void setPtComPerdaSinc(Boolean ptComPerdaSinc) {
		this.ptComPerdaSinc = ptComPerdaSinc;
	}



	public Boolean getPtComAlertaVidaUtil() {
		return ptComAlertaVidaUtil;
	}



	public void setPtComAlertaVidaUtil(Boolean ptComAlertaVidaUtil) {
		this.ptComAlertaVidaUtil = ptComAlertaVidaUtil;
	}



	public Boolean getPtComManutPrev() {
		return ptComManutPrev;
	}



	public void setPtComManutPrev(Boolean ptComManutPrev) {
		this.ptComManutPrev = ptComManutPrev;
	}



	public String getCdCp() {
		return cdCp;
	}



	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}



	public String getCdFolha() {
		return cdFolha;
	}



	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}



	public String getCdRap() {
		return cdRap;
	}



	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}



	public BigDecimal getProdLiq() {
		return prodLiq;
	}



	public void setProdLiq(BigDecimal prodLiq) {
		this.prodLiq = prodLiq;
	}



	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}



	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}



	public BigDecimal getProdPrevUltOP() {
		return prodPrevUltOP;
	}



	public void setProdPrevUltOP(BigDecimal prodPrevUltOP) {
		this.prodPrevUltOP = prodPrevUltOP;
	}



	public Integer getStFuncionamentoPt() {
		return stFuncionamentoPt;
	}



	public void setStFuncionamentoPt(Integer stFuncionamentoPt) {
		this.stFuncionamentoPt = stFuncionamentoPt;
	}



	public String getCorHexaIconePt() {
		return corHexaIconePt;
	}



	public void setCorHexaIconePt(String corHexaIconePt) {
		this.corHexaIconePt = corHexaIconePt;
	}



	public String getCorHexaFundoIcone() {
		return corHexaFundoIcone;
	}



	public void setCorHexaFundoIcone(String corHexaFundoIcone) {
		this.corHexaFundoIcone = corHexaFundoIcone;
	}



	public Integer getIdStCorFundoIcone() {
		return idStCorFundoIcone;
	}



	public void setIdStCorFundoIcone(Integer idStCorFundoIcone) {
		this.idStCorFundoIcone = idStCorFundoIcone;
	}



	public Boolean getIconeComBorda() {
		return iconeComBorda;
	}



	public void setIconeComBorda(Boolean iconeComBorda) {
		this.iconeComBorda = iconeComBorda;
	}



	public Boolean getIconePisca() {
		return iconePisca;
	}



	public void setIconePisca(Boolean iconePisca) {
		this.iconePisca = iconePisca;
	}



	public String getProduto() {
		return produto;
	}



	public void setProduto(String produto) {
		this.produto = produto;
	}



	public List<UsrDTO> getOperadores() {
		return operadores;
	}



	public void setOperadores(List<UsrDTO> operadores) {
		this.operadores = operadores;
	}



	public FiltroDetalhePostoDTO getFiltroClickPt() {
		return filtroClickPt;
	}



	public void setFiltroClickPt(FiltroDetalhePostoDTO filtroClickPt) {
		this.filtroClickPt = filtroClickPt;
	}
	
}
