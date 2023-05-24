package ms.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsMsicupProduto;
import idw.model.pojos.OmPt;
import ms.coleta.ic.inovastandalone.DadosLocaisCCK;

public class IcUpDTO {

	public static final int _COLETA_TUDO = 0;
	public static final int _COLETA_EXCLUSIVAMENTECICLO = 1;
	public static final int _COLETA_EXCLUSIVAMENTEPARADA = 2;


	private Integer idIcUp;
	private UpDTO up;
	private IcDTO ic;
	private String urlConexao;	
	private String urlAuxiliar;	
	private Integer tpConexao;
	private String atributo;
	private Date lastCicloDtHr = null;
	private boolean isParada =false;	
	private List<DadosLocaisCCK> dadosLocaisCCK=null;
	private Date refUpdateDadosLocaisCCK=null;

	private boolean isUpSendotratada = false;
	
	private Boolean isColetaAtiva = true;
	
	private List<MsMsicupProduto> urlsProduto = new ArrayList<>();
	
	// Contem o script completo de teste quando o mesmo existir
	private StringBuilder scriptTeste = new StringBuilder();
	private String nomeArquivoScript;
	private String extensaoArquivoScript;
	
	public IcUpDTO() {
		super();
	}
	public IcUpDTO(int idicup){
		super();
		this.setIdIcUp(idicup);
	}
	public IcUpDTO(MsMsicup msmsicup, OmPt ompt){
		super();
		
		this.setIdIcUp(msmsicup.getIdMsicup().intValue());
		
		this.setIc(new IcDTO(msmsicup.getMsIc()));
		this.setUpDTO(new UpDTO(msmsicup.getMsUp(), ompt));
		this.setTpConexao(msmsicup.getTpConexao().intValue());
		this.setUrlConexao(msmsicup.getUrlConexao());
		this.setColetaAtiva(msmsicup.getIsAtivo());
		this.setUrlAuxiliar(msmsicup.getUrlAuxiliar());
		
		this.urlsProduto = new ArrayList<MsMsicupProduto>();
		
		for (MsMsicupProduto url : msmsicup.getMsMsicupProdutos()) {
			this.urlsProduto.add(url.clone(false));
		}
	}
	public Date getRefUpdateDadosLocaisCCK() {
		return refUpdateDadosLocaisCCK;
	}
	public void setRefUpdateDadosLocaisCCK(Date refUpdateDadosLocaisCCK) {
		this.refUpdateDadosLocaisCCK = refUpdateDadosLocaisCCK;
	}
	public Integer getIdIcUp() {
		return idIcUp;
	}
	public void setIdIcUp(Integer idIcUp) {
		this.idIcUp = idIcUp;
	}
	public UpDTO getUpDTO() {
		return up;
	}
	public void setUpDTO(UpDTO up) {
		this.up = up;
	}
	public IcDTO getIc() {
		return ic;
	}
	public void setIc(IcDTO ic) {
		this.ic = ic;
	}
	public String getUrlConexao() {
		return urlConexao;
	}
	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}
	public Integer getTpConexao() {
		return tpConexao;
	}
	public void setTpConexao(Integer tpConexao) {
		this.tpConexao = tpConexao;
	}	
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	public boolean getIsUpSendoTratada() {		
		return isUpSendotratada;
	}
	public void setIsUpSendoTratada(boolean isUpSendotratada) {
		this.isUpSendotratada = isUpSendotratada;
	}	

	public boolean isThreadExclusivaParaColetarOIC() {
		return true; // No momento dever� sempre existir uma thread exclusiva
		// para tratar cada IC. Nao se conhece um IC que possa
		// ser tratado por mais de uma thread simultamente.
	}

	public void setValorEficienciaUltimoCiclo(Double eficiencia) {
		this.up.setVlEficienciaUltimoCiclo(eficiencia);
	}

	public void setLastCicloDthr(Date lastCicloDtHr){
		this.lastCicloDtHr=lastCicloDtHr;
	}
	public Date getLastCicloDthr(){
		return this.lastCicloDtHr;
	}

	public void setisParada(boolean isParada){
		this.isParada=isParada;
	}
	public boolean getisParada(){
		return this.isParada;
	}
	public String getUrlAuxiliar() {
		return urlAuxiliar;
	}
	public void setUrlAuxiliar(String urlAuxiliar) {
		this.urlAuxiliar = urlAuxiliar;
	}
	public List<DadosLocaisCCK> getDadosLocaisCCK() {
		return dadosLocaisCCK;
	}
	public void setDadosLocaisCCK(List<DadosLocaisCCK> dadosLocaisCCK) {
		this.dadosLocaisCCK = dadosLocaisCCK;
	}
	public Boolean isColetaAtiva() {
		return isColetaAtiva;
	}
	public void setColetaAtiva(Boolean isColetaAtiva) {
		this.isColetaAtiva = isColetaAtiva;
	}
	public List<MsMsicupProduto> getUrlsProduto() {
		return urlsProduto;
	}
	public void setUrlsProduto(List<MsMsicupProduto> urlsProduto) {
		this.urlsProduto = urlsProduto;
	}
	public StringBuilder getScriptTeste() {
		return scriptTeste;
	}
	public void setScriptTeste(StringBuilder scriptTeste) {
		this.scriptTeste = scriptTeste;
	}
	public String getNomeArquivoScript() {
		return nomeArquivoScript;
	}
	public void setNomeArquivoScript(String nomeArquivoScript) {
		this.nomeArquivoScript = nomeArquivoScript;
	}
	public String getExtensaoArquivoScript() {
		return extensaoArquivoScript;
	}
	public void setExtensaoArquivoScript(String extensaoArquivoScript) {
		this.extensaoArquivoScript = extensaoArquivoScript;
	}
	
}
