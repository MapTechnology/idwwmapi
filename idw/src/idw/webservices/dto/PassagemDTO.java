package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmCfg;

@XmlRootElement
@SuppressWarnings("serial")
public class PassagemDTO implements Serializable {
	
	private String cdPt;
	private int enviarRefugo;
	private long idPt;
	private long idGt;
	private long idUsr;
	private long idTppt;
	private Date dtHrEventoAnterior;
	private Date dtHrEvento;
	private String cb; // codigo de barras lido
	//private int resultadoPassagem;
	private long idGrpUsrSupervisor;
	private long idGrpUsrOperador;
	private long idProduto;
	private String mascaraCdProdutoPai;
	private List<DefeitoDTO> listaDefeitos = new ArrayList<DefeitoDTO>();
	private List<AcaoDTO> listaAcoes = new ArrayList<AcaoDTO>();
	private List<OrigemDTO> listaOrigens = new ArrayList<OrigemDTO>();
	private List<MontagemDTO> listaMontagem = new ArrayList<MontagemDTO>();
	private ResultadoDTO resultado = new ResultadoDTO();
	private DwFolha dwfolha = new DwFolha();
	private DwNserie dwnserie = new DwNserie();
	private DwRotapasso dwrotapasso = new DwRotapasso();
	private long idFolha;
	private List<NaoConformidadeDTO> naoConformidadesAtuais = new ArrayList<NaoConformidadeDTO>();
	private int tppt;
	private long idNSerie;
	private OmCfg omcfg;
	private String reSupervisor;
	private FolhaDTO receitaTeste;
	private ResultadoTesteDTO resultadoTesteFuncional;
	private boolean isDeveSerPassagemNova = true; // qdo for false, significica que nao se deve inserir uma nova passagem. isso ocorre nos casos dos envios parciais da receita
	private boolean isPassaadiante = true;
	private List<Integer> tpptAnterioes = new ArrayList<Integer>();
	private BigDecimal segTempoParafusadeira;
	private Boolean isAvaliarRoteiro = false;
	private String cdOp;
	private String cdproduto;
	private String posicoesMecanicas;
	private String cdRefugo;
	private String cdCausa;
	
	private String diarioBordo;
	
	public String getCdOp() {
		return cdOp;
	}
	public void setCdOp(String cdOp) {
		this.cdOp = cdOp;
	}
	public BigDecimal getSegTempoParafusadeira() {
		return segTempoParafusadeira;
	}
	public void setSegTempoParafusadeira(BigDecimal segTempoParafusadeira) {
		this.segTempoParafusadeira = segTempoParafusadeira;
	}
	public List<Integer> getTpptAnterioes() {
		return tpptAnterioes;
	}
	public void setTpptAnterioes(List<Integer> tpptAnterioes) {
		this.tpptAnterioes = tpptAnterioes;
	}
	public boolean isPassaadiante() {
		return isPassaadiante;
	}
	public void setPassaadiante(boolean isPassaadiante) {
		this.isPassaadiante = isPassaadiante;
	}
	public boolean isDeveSerPassagemNova() {
		return isDeveSerPassagemNova;
	}
	public void setDeveSerPassagemNova(boolean isDeveSerPassagemNova) {
		this.isDeveSerPassagemNova = isDeveSerPassagemNova;
	}
	public ResultadoTesteDTO getResultadoTesteFuncional() {
		return resultadoTesteFuncional;
	}
	public void setResultadoTesteFuncional(ResultadoTesteDTO resultadoTesteFuncional) {
		this.resultadoTesteFuncional = resultadoTesteFuncional;
	}
	public FolhaDTO getReceitaTeste() {
		return receitaTeste;
	}
	public void setReceitaTeste(FolhaDTO receitaTeste) {
		this.receitaTeste = receitaTeste;
	}
	public String getReSupervisor() {
		return reSupervisor;
	}
	public void setReSupervisor(String reSupervisor) {
		this.reSupervisor = reSupervisor;
	}
	public OmCfg getOmcfg() {
		return omcfg;
	}
	public void setOmcfg(OmCfg omcfg) {
		this.omcfg = omcfg;
	}
	public long getIdNSerie() {
		return idNSerie;
	}
	public void setIdNSerie(long idNSerie) {
		this.idNSerie = idNSerie;
	}
	public int getTppt() {
		return tppt;
	}
	public void setTppt(int tppt) {
		this.tppt = tppt;
	}
	public List<NaoConformidadeDTO> getNaoConformidadesAtuais() {
		return naoConformidadesAtuais;
	}
	public void setNaoConformidadesAtuais(
			List<NaoConformidadeDTO> naoConformidadesAtuais) {
		this.naoConformidadesAtuais = naoConformidadesAtuais;
	}
	public long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}
	public DwFolha getDwfolha() {
		return dwfolha;
	}
	public void setDwfolha(DwFolha dwfolha) {
		this.dwfolha = dwfolha;
	}
	public DwNserie getDwnserie() {
		return dwnserie;
	}
	public void setDwnserie(DwNserie dwnserie) {
		this.dwnserie = dwnserie;
	}
	public DwRotapasso getDwrotapasso() {
		return dwrotapasso;
	}
	public void setDwrotapasso(DwRotapasso dwrotapasso) {
		this.dwrotapasso = dwrotapasso;
	}
	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	
	public long getIdGt() {
		return idGt;
	}
	public void setIdGt(long idGt) {
		this.idGt = idGt;
	}
	
	public long getIdUsr() {
		return idUsr;
	}
	public void setIdUsr(long idUsr) {
		this.idUsr = idUsr;
	}
	
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	
	public Date getDtHrEventoAnterior() {
		return dtHrEventoAnterior;
	}
	public void setDtHrEventoAnterior(Date dtHrEventoAnterior) {
		this.dtHrEventoAnterior = dtHrEventoAnterior;
	}
	
	public Date getDtHrEvento() {
		return dtHrEvento;
	}
	public void setDtHrEvento(Date dtHrEvento) {
		this.dtHrEvento = dtHrEvento;
	}
	
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	
	public long getIdGrpUsrSupervisor() {
		return idGrpUsrSupervisor;
	}
	public void setIdGrpUsrSupervisor(long idGrpUsrSupervisor) {
		this.idGrpUsrSupervisor = idGrpUsrSupervisor;
	}
	
	public long getIdGrpUsrOperador() {
		return idGrpUsrOperador;
	}
	public void setIdGrpUsrOperador(long idGrpUsrOperador) {
		this.idGrpUsrOperador = idGrpUsrOperador;
	}
	
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	
	
	public String getMascaraCdProdutoPai() {
		return mascaraCdProdutoPai;
	}
	public void setMascaraCdProdutoPai(String mascaraCdProdutoPai) {
		this.mascaraCdProdutoPai = mascaraCdProdutoPai;
	}
	
	
	public List<DefeitoDTO> getListaDefeitos() {
		return listaDefeitos;
	}
	public void setListaDefeitos(List<DefeitoDTO> listaDefeitos) {
		this.listaDefeitos = listaDefeitos;
	}
	
	public List<MontagemDTO> getListaMontagem() {
		return listaMontagem;
	}
	public void setListaMontagem(List<MontagemDTO> listaMontagem) {
		this.listaMontagem = listaMontagem;
	}
	
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public List<AcaoDTO> getListaAcoes() {
		return listaAcoes;
	}
	public void setListaAcoes(List<AcaoDTO> listaAcoes) {
		this.listaAcoes = listaAcoes;
	}
	public List<OrigemDTO> getListaOrigens() {
		return listaOrigens;
	}
	public void setListaOrigens(List<OrigemDTO> listaOrigens) {
		this.listaOrigens = listaOrigens;
	}
	public int getEnviarRefugo() {
		return enviarRefugo;
	}
	public void setEnviarRefugo(int enviarRefugo) {
		this.enviarRefugo = enviarRefugo;
	}
	public Boolean getIsAvaliarRoteiro() {
		return isAvaliarRoteiro;
	}
	public void setIsAvaliarRoteiro(Boolean isAvaliarRoteiro) {
		this.isAvaliarRoteiro = isAvaliarRoteiro;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getPosicoesMecanicas() {
		return posicoesMecanicas;
	}
	public void setPosicoesMecanicas(String posicoesMecanicas) {
		this.posicoesMecanicas = posicoesMecanicas;
	}
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getCdCausa() {
		return cdCausa;
	}
	public void setCdCausa(String cdCausa) {
		this.cdCausa = cdCausa;
	}
	public String getDiarioBordo() {
		return diarioBordo;
	}
	public void setDiarioBordo(String diarioBordo) {
		this.diarioBordo = diarioBordo;
	}
	public String getCdproduto() {
		return cdproduto;
	}
	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

}
