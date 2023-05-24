package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DefeitoDTO implements Serializable {
	
	private long idTDefeito;
	private String cb; // codigo de barras
	private long idTppt;
	private long idPt;
	private ResultadoDTO resultado = new ResultadoDTO();
	private long idTAcao;
	private long idOrigem;
	private long idNserie;
	private long idPassagem;
	private long idPassdef;
	
	private String cdPt;
	private String cdAcao;
	private String cdOrigem;
	private String cdDefeito;
	private Date dthrDefeito;
	private Date dthrAcao;
	private String login;
	private String dsTppt;
	private String cdAreaResponsavel; // sera usado pelo posto de reprocesso para infomar qual a area do defeito
	private String posicoes;
	
	public long getIdPassagem() {
		return idPassagem;
	}
	public void setIdPassagem(long idPassagem) {
		this.idPassagem = idPassagem;
	}
	public long getIdPassdef() {
		return idPassdef;
	}
	public void setIdPassdef(long idPassdef) {
		this.idPassdef = idPassdef;
	}
	public long getIdNserie() {
		return idNserie;
	}
	public void setIdNserie(long idNserie) {
		this.idNserie = idNserie;
	}
	public long getIdTAcao() {
		return idTAcao;
	}
	public void setIdTAcao(long idTAcao) {
		this.idTAcao = idTAcao;
	}
	public long getIdOrigem() {
		return idOrigem;
	}
	public void setIdOrigem(long idOrigem) {
		this.idOrigem = idOrigem;
	}
	public long getIdTDefeito() {
		return idTDefeito;
	}
	public void setIdTDefeito(long idTDefeito) {
		this.idTDefeito = idTDefeito;
	}
	
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	
	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdAcao() {
		return cdAcao;
	}
	public void setCdAcao(String cdAcao) {
		this.cdAcao = cdAcao;
	}
	public String getCdOrigem() {
		return cdOrigem;
	}
	public void setCdOrigem(String cdOrigem) {
		this.cdOrigem = cdOrigem;
	}
	public String getCdDefeito() {
		return cdDefeito;
	}
	public void setCdDefeito(String cdDefeito) {
		this.cdDefeito = cdDefeito;
	}
	public Date getDthrDefeito() {
		return dthrDefeito;
	}
	public void setDthrDefeito(Date dthrDefeito) {
		this.dthrDefeito = dthrDefeito;
	}
	public Date getDthrAcao() {
		return dthrAcao;
	}
	public void setDthrAcao(Date dthrAcao) {
		this.dthrAcao = dthrAcao;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getDsTppt() {
		return dsTppt;
	}
	public void setDsTppt(String dsTppt) {
		this.dsTppt = dsTppt;
	}
	public String getCdAreaResponsavel() {
		return cdAreaResponsavel;
	}
	public void setCdAreaResponsavel(String cdAreaResponsavel) {
		this.cdAreaResponsavel = cdAreaResponsavel;
	}
	public String getPosicoes() {
		return posicoes;
	}
	public void setPosicoes(String posicoes) {
		this.posicoes = posicoes;
	}
	
}
