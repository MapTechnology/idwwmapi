package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class SessaoDTO implements Serializable {
	
	/**
	 * tipo de posto
	 */
	public final int PT_DESCONHECIDO = 0;
	public final int PT_MONTAGEM = 1;
	public final int PT_TESTE_FUNCIONAL = 2;
	public final int PT_TESTE_PASSA_NAO_PASSA = 3;
	public final int PT_TESTE_PASSA_COD_DEFEITO = 4;
	public final int PT_TESTE_REPROCESSO = 5;
	public final int PT_PASSAGEM = 6;
	
	private long idPt;
	private long idGt;
	private String dsPt;
	private String dsGt;
	private String mac;
	//SessaoDTO.porta
	private Date dthrParasincronia;
	private Date dthrUltimoHeartBeat;
	private BigDecimal segFeedbacklogin;
	private BigDecimal segHeartbeat;
	private BigDecimal segLogoutauto;
	private String cdUsr;
	private long idUsr;
	private String ds_apelido;
	private long idGrpUsrSupervisor;
	private long idGrpUsrOperador;
	private boolean isLogonObrigatorio = true;
	private boolean isConexao;
	private Date dthrevento;
	private long idTppt;
	private long idCal;
	private int tppt;
	
	private ResultadoDTO resultado = new ResultadoDTO();
	private String mascaraCdProdutoPai;
	private String mascaraCdProdutoFilho;
	private long idFolha;
	private BigDecimal segX;
	private BigDecimal segY;
	private BigDecimal segZ;
	private boolean isPrimeiraLevaTesteFuncional = true; // valido apenas para o reprocesso controlar qdo vai inserir nova passagem
	
	public boolean isPrimeiraLevaTesteFuncional() {
		return isPrimeiraLevaTesteFuncional;
	}

	public void setPrimeiraLevaTesteFuncional(boolean isPrimeiraLevaTesteFuncional) {
		this.isPrimeiraLevaTesteFuncional = isPrimeiraLevaTesteFuncional;
	}

	public BigDecimal getSegX() {
		return segX;
	}

	public void setSegX(BigDecimal segX) {
		this.segX = segX;
	}

	public BigDecimal getSegY() {
		return segY;
	}

	public void setSegY(BigDecimal segY) {
		this.segY = segY;
	}

	public BigDecimal getSegZ() {
		return segZ;
	}

	public void setSegZ(BigDecimal segZ) {
		this.segZ = segZ;
	}

	public long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}
	public String getMascaraCdProdutoFilho() {
		return mascaraCdProdutoFilho;
	}
	public void setMascaraCdProdutoFilho(String mascaraCdProdutoFilho) {
		this.mascaraCdProdutoFilho = mascaraCdProdutoFilho;
	}
	public String getMascaraCdProdutoPai() {
		return mascaraCdProdutoPai;
	}
	public void setMascaraCdProdutoPai(String mascaraCdProdutoPai) {
		this.mascaraCdProdutoPai = mascaraCdProdutoPai;
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
	
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	
	public String getDsGt() {
		return dsGt;
	}
	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public BigDecimal getSegFeedbacklogin() {
		return segFeedbacklogin;
	}
	public void setSegFeedbacklogin(BigDecimal segFeedbacklogin) {
		this.segFeedbacklogin = segFeedbacklogin;
	}
	
	public BigDecimal getSegHeartbeat() {
		return segHeartbeat;
	}
	public void setSegHeartbeat(BigDecimal segHeartbeat) {
		this.segHeartbeat = segHeartbeat;
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
	
	public boolean isConexao() {
		return isConexao;
	}
	public void setConexao(boolean isConexao) {
		this.isConexao = isConexao;
	}
	
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	
	public long getIdCal() {
		return idCal;
	}
	public void setIdCal(long idCal) {
		this.idCal = idCal;
	}
	
	public int getTppt() {
		return tppt;
	}
	public void setTppt(int tppt) {
		this.tppt = tppt;
	}
	
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public Date getDthrParasincronia() {
		return dthrParasincronia;
	}
	public void setDthrParasincronia(Date dthrParasincronia) {
		this.dthrParasincronia = dthrParasincronia;
	}
	public BigDecimal getSegLogoutauto() {
		return segLogoutauto;
	}
	public void setSegLogoutauto(BigDecimal segLogoutauto) {
		this.segLogoutauto = segLogoutauto;
	}
	public boolean isLogonObrigatorio() {
		return isLogonObrigatorio;
	}
	public void setLogonObrigatorio(boolean isLogonObrigatorio) {
		this.isLogonObrigatorio = isLogonObrigatorio;
	}
	public String getDs_apelido() {
		return ds_apelido;
	}
	public void setDs_apelido(String dsApelido) {
		this.ds_apelido = dsApelido;
	}
	public Date getDthrevento() {
		return dthrevento;
	}
	public void setDthrevento(Date dthrevento) {
		this.dthrevento = dthrevento;
	}
	public String getCdUsr() {
		return cdUsr;
	}
	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}
	public long getIdUsr() {
		return idUsr;
	}
	public void setIdUsr(long idUsr) {
		this.idUsr = idUsr;
	}
	public int getPT_DESCONHECIDO() {
		return PT_DESCONHECIDO;
	}
	public int getPT_MONTAGEM() {
		return PT_MONTAGEM;
	}
	public int getPT_TESTE_FUNCIONAL() {
		return PT_TESTE_FUNCIONAL;
	}
	public int getPT_TESTE_PASSA_NAO_PASSA() {
		return PT_TESTE_PASSA_NAO_PASSA;
	}
	public int getPT_TESTE_PASSA_COD_DEFEITO() {
		return PT_TESTE_PASSA_COD_DEFEITO;
	}
	public int getPT_TESTE_REPROCESSO() {
		return PT_TESTE_REPROCESSO;
	}
	public int getPT_PASSAGEM() {
		return PT_PASSAGEM;
	}
	public Date getDthrUltimoHeartBeat() {
		return dthrUltimoHeartBeat;
	}

	public void setDthrUltimoHeartBeat(Date dthrUltimoHeartBeat) {
		this.dthrUltimoHeartBeat = dthrUltimoHeartBeat;
	}

}
