package injetws.webservices.dto;

import injetws.model.pojos.PrUp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.injet.Ijtbinj;

@SuppressWarnings("serial")
public class IwsUpDTO  implements Serializable{

	public static int TIPO_CP_MOLDE = 1;
	public static int TIPO_CP_OP = 2;
	public static int TIPO_CP_PRODUTO = 3;
	public static int TIPO_CP_MOLDE_ESTRUTURA_COM_OPCRIACAONOMASTER = 4;
	public static int TIPO_CP_PRODUTO_ESTRUTURA_COM_OPCRIACAONOMASTER = 5;
	public static int TIPO_CP_PRODUTO_MONTAGEM = 6;
	public static int TIPO_CP_PRODUTO_OP_COM_OPCRIACAOMASTER = 7;
	public static int TIPO_CP_MOLDE_PRODUTO_QTCICLOS = 8;
	public static int TIPO_CP_MOLDE_PRODUTO_QTDCARTOES = 9;
	public static int TIPO_CP_SESSAO_CDM = 10;
	public static int TIPO_CP_OP_11 = 11;
	public static int TIPO_CP_OP_MOLDE_ESTRUTURA_OPT = 12;
	public static int TIPO_CP_OP_QTD_INCREMNTAL = 13;
	public static int TIPO_CP_OP_ESTRUTURA = 14;

	private String idUP;
	private String ct;
	private String up;
	private String cdMaquina;
	private Boolean isSemPrograma = false;
	private Boolean isParadaEmAberto = false;
	private Boolean isEmRegulagem = false;
	private Integer stCriacaoCP;

	private Integer filtroSinalAlto;
	private Integer filtroSinalBaixo;
	private Integer idCPAtual;
	private Integer idSubColetor;
	private BigDecimal numeroDeCiclos;
	private Double producaoLiquida;    
	private IwsCpDTO cp;
	private IwsParadaDTO paradaAtualOuUltimaParada;
	private Boolean isUpAtiva = true;
	private Boolean isReiniciarUP = false; // Setado true pelo heart-beat qdo detecta evento 22 enviado pelo BC
	private Boolean isfechaLogins = false; // Setado true pelo heart-beat qdo detecta evento 32 enviado pelo BC
	private Boolean isParadaFechaCiclo = true;	
	private IwsDadosCIPDTO dadosCIP =null;
	private Boolean isOpConcluida = false;

	private Double vleficultciclo;
	
	private IwsReleDTO Rele01;
	private IwsReleDTO Rele02;
	private IwsReleDTO Rele03;
	private IwsReleDTO Rele04;
	private IwsReleDTO Rele05;
	
	private IwsInspecaoManualDTO inspmanual;

	private IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO;
	private boolean stAndonProcessoft = false;
	private boolean stAndonConfiguravel = false;
	private List<IwsAndonDTO> listaAndonDTO = new ArrayList<IwsAndonDTO>();
	private List<IwsModDTO> listaLoginsEmAberto = null;
	private List<IwsAlertaDTO> listaAlertasEmAberto = null;
	private List<IwsAlertaDTO> listaAlertasDiariodeBordo = null;
	
	private Boolean isEmAlertaProbQuali = false;
	private Boolean isComInspecaoPendente = false;
	private Integer resultadoUltimaInspecao = 0; 
	//vlauria 20100404
	/*	A vari�vel resultadoUltimaInspecao segue a seguinte l�gica:
	 *		0 - n�o h� resultado 
	 *		1 - aprovado
	 *		2 - reprovado
	 *		3 - aprovado com restri��o
	 *		4 - usado apenas para determinar que esta vari�vel n�o foi modificada  
	 */
	private String isApntSapAtivo = null;
	private String stApntSap = null;
	private String txtMsg = null;
	private boolean stIntegracaoDoal = false;
	private boolean stAlimIntegracaoDoal = false;
	private boolean isVisualizaTelaIntegDOal = false;
	private IwsProdMateriaPrimaDTO materiaPrimaAtualOuUltima;
	private IwsVariacaoRitmoDTO variacaoRitmoDTO;
	private int cavidadesativas;
	private boolean isCicloAberto=false;
	private boolean temOperadorLogado =false;
	private boolean isInjOuLiner=false;
	
	private boolean isInovaMini = false;
	
	public Boolean getIsOpConcluida() {
		return isOpConcluida;
	}

	public void setIsOpConcluida(Boolean isOpConcluida) {
		this.isOpConcluida = isOpConcluida;
	}
	
	public boolean getIsInjOuLiner(){
	   return this.isInjOuLiner;
	}
	
	public void setIsInjOuLiner (boolean val){
		this.isInjOuLiner=val;
	}
	/**
	 * @return the cavidadesativas
	 */
	public int getCavidadesAtivas() {
		return this.cavidadesativas;
	}

	/**
	 * @param cavidadesativas the cavidadesativas to set
	 */
	public void setCavidadesAtivas(int cavidadesativas) {
		this.cavidadesativas = cavidadesativas;
	}	
	
	/**
	 * @return the isCicloAberto
	 */
	public boolean getIsCicloAberto() {
		return isCicloAberto;
	}

	/**
	 * @param isCicloAberto the isCicloAberto to set
	 */
	public void setIsCicloAberto(boolean isCicloAberto) {
		this.isCicloAberto = isCicloAberto;
	}
	
	/**
	 * @return the temOperadorLogado
	 */
	public boolean getTemOperadorLogado() {
		return temOperadorLogado;
	}

	/**
	 * @param temOperadorLogado the temOperadorLogado to set
	 */
	public void setTemOperadorLogado(boolean temOperadorLogado) {
		this.temOperadorLogado = temOperadorLogado;
	}
	/**
	 * @return the numeroDeCiclos
	 */
	public BigDecimal getNumeroDeCiclos() {
		return numeroDeCiclos;
	}

	/**
	 * @param numeroDeCiclos the numeroDeCiclos to set
	 */
	public void setNumeroDeCiclos(BigDecimal numeroDeCiclos) {
		this.numeroDeCiclos = numeroDeCiclos;
	}/**
	 * @return the producaoLiquida
	 */
	public Double getProducaoLiquida() {
		return producaoLiquida;
	}

	/**
	 * @param producaoLiquida the producaoLiquida to set
	 */
	public void setProducaoLiquida(Double producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	/**
	 * @return the idUP
	 */
	public String getIdUP() {
		return idUP;
	}

	/**
	 * @param idUP the idUP to set
	 */
	public void setIdUP(String idUP) {
		this.idUP = idUP;
	}

	/**
	 * @return the ct
	 */
	public String getCt() {
		return ct;
	}

	/**
	 * @param ct the ct to set
	 */
	public void setCt(String ct) {
		this.ct = ct;
	}
	
	/**
	 * @return the cdMaquina
	 */
	public String getCdMaquina() {
		return cdMaquina;
	}

	/**
	 * @param cdMaquina the cdMaquina to set
	 */
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}	

	/**
	 * @return the up
	 */
	public String getUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(String up) {
		this.up = up;
	}

	/**
	 * @return the stCriacaoCP
	 */
	public Integer getStCriacaoCP() {
		return stCriacaoCP;
	}

	/**
	 * @param stCriacaoCP the stCriacaoCP to set
	 */
	public void setStCriacaoCP(Integer stCriacaoCP) {
		this.stCriacaoCP = stCriacaoCP;
	}

	/**
	 * @return the filtroSinalAlto
	 */
	public Integer getFiltroSinalAlto() {
		return filtroSinalAlto;
	}

	/**
	 * @param filtroSinalAlto the filtroSinalAlto to set
	 */
	public void setFiltroSinalAlto(Integer filtroSinalAlto) {
		this.filtroSinalAlto = filtroSinalAlto;
	}

	/**
	 * @return the filtroSinalBaixo
	 */
	public Integer getFiltroSinalBaixo() {
		return filtroSinalBaixo;
	}

	/**
	 * @param filtroSinalBaixo the filtroSinalBaixo to set
	 */
	public void setFiltroSinalBaixo(Integer filtroSinalBaixo) {
		this.filtroSinalBaixo = filtroSinalBaixo;
	}

	/**
	 * @return the idCPAtual
	 */
	public Integer getIdCPAtual() {
		return idCPAtual;
	}

	/**
	 * @param idCPAtual the idCPAtual to set
	 */
	public void setIdCPAtual(Integer idCPAtual) {
		this.idCPAtual = idCPAtual;
	}

	/**
	 * @return the idSubColetor
	 */
	public Integer getIdSubColetor() {
		return idSubColetor;
	}

	/**
	 * @param idSubColetor the idSubColetor to set
	 */
	public void setIdSubColetor(Integer idSubColetor) {
		this.idSubColetor = idSubColetor;
	}
	/**
	 * @return the isUpAtiva
	 */
	public Boolean getIsUpAtiva() {
		return isUpAtiva;
	}

	/**
	 * @param isUpAtiva the isUpAtiva to set
	 */
	public void setIsUpAtiva(Boolean isUpAtiva) {
		this.isUpAtiva = isUpAtiva;
	}
	
	/**
	 * @return the isfechaLogins
	 */
	public Boolean getIsfechaLogins() {
		return isfechaLogins;
	}

	/**
	 * @param isfechaLogins the isfechaLogins to set
	 */
	public void setIsfechaLogins(Boolean isfechaLogins) {
		this.isfechaLogins = isfechaLogins;
	}
	
	
	/**
	 * @return the isSemPrograma
	 */
	public Boolean getIsSemPrograma() {
		return isSemPrograma;
	}

	/**
	 * @param isSemPrograma the isSemPrograma to set
	 */
	public void setIsSemPrograma(Boolean isSemPrograma) {
		this.isSemPrograma = isSemPrograma;
	}
	
	/**
	 * @return the isEmRegulagem
	 */
	public Boolean getIsEmRegulagem() {
		return isEmRegulagem;
	}

	/**
	 * @param isEmRegulagem the isEmRegulagem to set
	 */
	public void setIsEmRegulagem(Boolean isEmRegulagem) {
		this.isEmRegulagem = isEmRegulagem;
	}

	/**
	 * @return the isParadaEmAberto
	 */
	public Boolean getIsParadaEmAberto() {
		return isParadaEmAberto;
	}

	/**
	 * @param isParadaEmAberto the isParadaEmAberto to set
	 */
	public void setIsParadaEmAberto(Boolean isParadaEmAberto) {
		this.isParadaEmAberto = isParadaEmAberto;
	}
	
	/**
	 * @return the variacaoRitmoDTO
	 */
	public IwsVariacaoRitmoDTO getVariacaoRitmoDTO() {
		return variacaoRitmoDTO;
	}

	/**
	 * @param variacaoRitmoDTO the variacaoRitmoDTO to set
	 */
	public void setVariacaoRitmoDTO(IwsVariacaoRitmoDTO variacaoRitmoDTO) {
		this.variacaoRitmoDTO = variacaoRitmoDTO;
	}
	
	public void setListaAndonDTO(List<IwsAndonDTO> listaAndonDTOtoCopy) {
		this.listaAndonDTO.addAll(listaAndonDTOtoCopy);	
	}

	public List<IwsAndonDTO> getListaAndonDTO() {
		return listaAndonDTO;
	}		

	public void copyPrUp(PrUp prup) {
		this.setCt("Maquina");
		this.setVariacaoRitmoDTO(prup.obtemVariacaoRitmoDTO());
		this.setUp(prup.getCdmaqestendido());
		this.setCdMaquina(prup.getCdmaquina());
		this.setIdUP(prup.getIdup().toString());		
		this.dadosCIP=prup.obtemDadosCIPDTO();	
		if(prup.getDthrinicic()!=null && prup.getDthrfimcic()==null){
			this.isCicloAberto=true;
		}else{
			this.isCicloAberto=false;
		}
		if(prup.getQtdciclosexecutados()!= null)
			this.setNumeroDeCiclos(prup.getQtdciclosexecutados());
		else
			this.setNumeroDeCiclos(new BigDecimal(0));		
		this.setIdSubColetor(prup.getPrSubColetor().getIdsubcoletor().intValue());
		this.setFiltroSinalAlto(0);
		this.setFiltroSinalBaixo(0);
		this.setIdCPAtual(0);
		if(prup.getCfgtpsessaoproducao()!= null)
			this.setStCriacaoCP(Integer.parseInt(prup.getCfgtpsessaoproducao()));
		else
			this.setStCriacaoCP(0);
		this.setIsSemPrograma(prup.obtemSemPrograma());		
		
		if(prup.getStparadaemaberto()!=null){
			if (prup.getStparadaemaberto() == '1'){
				this.setIsParadaEmAberto(true);				
			} else
				this.setIsParadaEmAberto(false);
		} else 
			this.setIsParadaEmAberto(false);
		
		this.setIsReiniciarUP(prup.obtemIsReiniciarUp());
		if(prup.getStativa()=='0')
			this.setIsUpAtiva(false);
		else
			this.setIsUpAtiva(true);		
		this.setvleficultciclo(prup.getvleficultciclo());
		if(prup.obtemDeveLiparUsuarios())this.isfechaLogins = true;
		else this.isfechaLogins =false;
		if ((prup.getCfginterrupcaociclo()!=null) && prup.getCfginterrupcaociclo().equals('1'))
			this.setIsParadaFechaCiclo(true);
		else
			this.setIsParadaFechaCiclo(false);	
		this.isEmRegulagem=prup.obtemIsEmRegulagem();	
		this.isEmAlertaProbQuali = prup.obtemIsAlertaProbQuali();
		this.isComInspecaoPendente = prup.obtemIsInspecaoPendente();
		this.resultadoUltimaInspecao = prup.obtemResultadoUltimaInspecao();
		if(prup.obtemIsComApntSAP() != null)
			this.isApntSapAtivo = prup.obtemIsComApntSAP();
		else
			this.isApntSapAtivo = null;
		if(prup.obtemStatusApntSAP() != null)
			this.stApntSap = prup.obtemStatusApntSAP();
		else
			this.stApntSap = null;
		if(prup.obtemTxtMessage() != null)
			this.txtMsg = prup.obtemTxtMessage();
		else
			this.txtMsg = null;
		this.listaLoginsEmAberto = prup.obtemListaLoginsEmAberto();
		if(listaLoginsEmAberto != null && listaLoginsEmAberto.size()>0)
			 this.temOperadorLogado = true;		
		else
			 this.temOperadorLogado = false;			
		if(prup.getStintegdoal() != null && prup.getStintegdoal().equals('1')) {
			this.setStIntegracaoDoal(true);
		} else {
			this.setStIntegracaoDoal(false);
		}
		
		if(prup.getStalimintegdoal() != null && prup.getStalimintegdoal().equals('1')) {
			this.setStAlimIntegracaoDoal(true);
		}
		else {
			this.setStAlimIntegracaoDoal(false);
		}
		
		if(prup.getStvertelaintegdoal() != null && prup.getStvertelaintegdoal().equals('1')) {
			this.setVisualizaTelaIntegDOal(true);
		} else {
			this.setVisualizaTelaIntegDOal(false);
		}		
		this.setListaAlertasEmAberto(prup.obtemListaAlertasEmAberto());			
		this.setListaAlertasDiariodeBordo(prup.obtemListaAlertasDiarioDeBordo());
		this.isInjOuLiner=prup.obtemIsInjOuLiner();
		this.isOpConcluida=prup.obtemIsOPConcluida();		
	}
	
	public void copyIjtbinj(Ijtbinj oIjtbinj) {
		
	}

	/**
	 * @return the cp
	 */
	public IwsCpDTO getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(IwsCpDTO cp) {
		this.cp = cp;
	}

	/**
	 * @return the paradaAtualOuUltimaParada
	 */
	public IwsParadaDTO getParadaAtualOuUltimaParada() {
		return paradaAtualOuUltimaParada;
	}

	/**
	 * @param paradaAtualOuUltimaParada the paradaAtualOuUltimaParada to set
	 */
	public void setParadaAtualOuUltimaParada(IwsParadaDTO paradaAtualOuUltimaParada) {
		this.paradaAtualOuUltimaParada = paradaAtualOuUltimaParada;
	}

	/**
	 * @return the isReiniciarUP
	 */
	public Boolean getIsReiniciarUP() {
		return isReiniciarUP;
	}

	/**
	 * @param isReiniciarUP the isReiniciarUP to set
	 */
	public void setIsReiniciarUP(Boolean isReiniciarUP) {
		this.isReiniciarUP = isReiniciarUP;
	}

	public Boolean getIsParadaFechaCiclo() {
		return isParadaFechaCiclo;
	}

	public void setIsParadaFechaCiclo(Boolean isParadaFechaCiclo) {
		this.isParadaFechaCiclo = isParadaFechaCiclo;
	}


	public Double getvleficultciclo() {
		return this.vleficultciclo;
	}

	public void setvleficultciclo(Double vleficultciclo) {
		this.vleficultciclo = vleficultciclo;
	}
	
	
	public IwsReleDTO getRele01() {
		return(this.Rele01);
	}

	public void setRele01(IwsReleDTO Rele01) {
		this.Rele01 = Rele01;
	}

	public IwsReleDTO getRele02() {
		return(this.Rele02);
	}

	public void setRele02(IwsReleDTO Rele02) {
		this.Rele02 = Rele02;
	}

	public IwsReleDTO getRele03() {
		return(this.Rele03);
	}

	public void setRele03(IwsReleDTO Rele03) {
		this.Rele03 = Rele03;
	}

	public IwsReleDTO getRele04() {
		return(this.Rele04);
	}

	public void setRele04(IwsReleDTO Rele04) {
		this.Rele04 = Rele04;
	}

	public IwsReleDTO getRele05() {
		return(this.Rele05);
	}

	public void setRele05(IwsReleDTO Rele05) {
		this.Rele05 = Rele05;
	}

	
	public IwsUpAndonPrcsftDTO getoUpAndonPrcsftDTO() {
		return(this.oUpAndonPrcsftDTO);
	}
	public void setoUpAndonPrcsftDTO(IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO) {
		this.oUpAndonPrcsftDTO = oUpAndonPrcsftDTO;
	}

	public void setInspmanual(IwsInspecaoManualDTO inspmanual) {
		this.inspmanual = inspmanual;
	}

	public IwsInspecaoManualDTO getInspmanual() {
		return inspmanual;
	}
	//vlauria 20100318
	public void setStAndonConfiguravel(boolean stAndonConfiguravel) {
		this.stAndonConfiguravel = stAndonConfiguravel;
	}

	public boolean getStAndonConfiguravel() {
		return stAndonConfiguravel;
	}
	//vlauria 20100318
	public void setStAndonProcessoft(boolean stAndonProcessoft) {
		this.stAndonProcessoft = stAndonProcessoft;
	}

	public boolean getStAndonProcessoft() {
		return stAndonProcessoft;
	}
	
	public void setIsComAlertaProbQuali(Boolean isAlertaProbQuali) {
		this.isEmAlertaProbQuali = isAlertaProbQuali;
	}
	public Boolean getIsComAlertaProbQuali() {
		return isEmAlertaProbQuali;
	}
	public void setResultadoUltimaInspecao(Integer resultadoUltimaInspecao) {
		this.resultadoUltimaInspecao = resultadoUltimaInspecao;
	}
	public Integer getResultadoUltimaInspecao() {
		return resultadoUltimaInspecao;
	}
	public void setIsComInspecaoPendente(Boolean isInspecaoPendente) {
		this.isComInspecaoPendente = isInspecaoPendente;
	}
	public Boolean getIsComInspecaoPendente() {
		return isComInspecaoPendente;
	}

	public void setIsApntSapAtivo(String isApntSapAtivo) {
		this.isApntSapAtivo = isApntSapAtivo;
	}

	public String getIsApntSapAtivo() {
		return isApntSapAtivo;
	}

	public void setStApntSap(String stApntSap) {
		this.stApntSap = stApntSap;
	}

	public String getStApntSap() {
		return stApntSap;
	}

	public void setTxtMsg(String txtMsg) {
		this.txtMsg = txtMsg;
	}

	public String getTxtMsg() {
		return txtMsg;
	}

	public void setStIntegracaoDoal(boolean stIntegracaoDoal) {
		this.stIntegracaoDoal = stIntegracaoDoal;
	}

	public boolean isStIntegracaoDoal() {
		return stIntegracaoDoal;
	}

	public void setStAlimIntegracaoDoal(boolean stAlimIntegracaoDoal) {
		this.stAlimIntegracaoDoal = stAlimIntegracaoDoal;
	}

	public boolean isStAlimIntegracaoDoal() {
		return stAlimIntegracaoDoal;
	}

	public void setVisualizaTelaIntegDOal(boolean isVisualizaTelaIntegDOal) {
		this.isVisualizaTelaIntegDOal = isVisualizaTelaIntegDOal;
	}

	public boolean isVisualizaTelaIntegDOal() {
		return isVisualizaTelaIntegDOal;
	}

	public void setUltimaMateriaPrimaAtual(IwsProdMateriaPrimaDTO materiaPrimaAtualOuUltima) {
		if(materiaPrimaAtualOuUltima != null) {
			this.materiaPrimaAtualOuUltima = new IwsProdMateriaPrimaDTO();
			this.materiaPrimaAtualOuUltima.setCdMateriaPrima(materiaPrimaAtualOuUltima.getCdMateriaPrima());
			this.materiaPrimaAtualOuUltima.setDsMateriaPrima(materiaPrimaAtualOuUltima.getDsMateriaPrima());
			this.materiaPrimaAtualOuUltima.setCdProduto(materiaPrimaAtualOuUltima.getCdProduto());
			this.materiaPrimaAtualOuUltima.setDsProduto(materiaPrimaAtualOuUltima.getDsProduto());
			this.materiaPrimaAtualOuUltima.setIdUp(materiaPrimaAtualOuUltima.getIdUp());
			this.materiaPrimaAtualOuUltima.setUnidade(materiaPrimaAtualOuUltima.getUnidade());
			this.materiaPrimaAtualOuUltima.setLote(materiaPrimaAtualOuUltima.getLote());
			this.materiaPrimaAtualOuUltima.setEstoque(materiaPrimaAtualOuUltima.getEstoque());
			this.materiaPrimaAtualOuUltima.setControlalote(materiaPrimaAtualOuUltima.getControlalote());
		}
		else
			this.materiaPrimaAtualOuUltima = null;
	}

	public IwsProdMateriaPrimaDTO getUltimaMateriaPrimaAtual() {
		return materiaPrimaAtualOuUltima;
	}

	public void setListaLoginsEmAberto(List<IwsModDTO> listaLoginsEmAberto) {
		this.listaLoginsEmAberto = listaLoginsEmAberto;
	}

	public List<IwsModDTO> getListaLoginsEmAberto() {
		return listaLoginsEmAberto;
	}
	
	public void addModDTO(IwsModDTO modDTO) {
		this.listaLoginsEmAberto.add(modDTO);
	}

	public void setListaAlertasEmAberto(List<IwsAlertaDTO> listaAlertasEmAberto) {
			this.listaAlertasEmAberto = listaAlertasEmAberto;
	}

	public List<IwsAlertaDTO> getListaAlertasEmAberto() {
		return listaAlertasEmAberto;
	}

	public IwsDadosCIPDTO getDadosCIP() {
		return dadosCIP;
	}

	public void setDadosCIP(IwsDadosCIPDTO dadosCIP) {
		this.dadosCIP = dadosCIP;
	}

	public List<IwsAlertaDTO> getListaAlertasDiariodeBordo() {
		return listaAlertasDiariodeBordo;
	}

	public void setListaAlertasDiariodeBordo(
			List<IwsAlertaDTO> listaAlertasDiariodeBordo) {
		this.listaAlertasDiariodeBordo = listaAlertasDiariodeBordo;
	}

	public boolean isInovaMini() {
		return isInovaMini;
	}

	public void setInovaMini(boolean isInovaMini) {
		this.isInovaMini = isInovaMini;
	}
	
	
}
