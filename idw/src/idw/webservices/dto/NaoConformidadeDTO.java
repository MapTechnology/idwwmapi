package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
//tppt
//0 - Desconhecido
//1 = Posto de montagem
//2 = Posto de teste funcional
//3 = Posto de teste passa n�o passa
//4 = Posto de teste passa / codigo defeito
//5 = Posto de teste reprocesso
//6 = Posto de passagem
@XmlRootElement(name="naoconformidadedto")
public class NaoConformidadeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tppt;
	private String dsNaoConformidade;
	private String cdPt;
	private String dsPt;
	private String dsCurta;
	private long idPassagem;
	private long idPassdef;
	private Date dthrNC;
	private Long idTDefeito;
	private String areaResponsavel;
	private String posicoes;
	private String cb;
	
	public Date getDthrNC() {
		return dthrNC;
	}
	public void setDthrNC(Date dthrNC) {
		this.dthrNC = dthrNC;
	}
	public long getIdPassdef() {
		return idPassdef;
	}
	public void setIdPassdef(long idPassdef) {
		this.idPassdef = idPassdef;
	}
	public long getIdPassagem() {
		return idPassagem;
	}
	public void setIdPassagem(long idPassagem) {
		this.idPassagem = idPassagem;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public int getTppt() {
		return tppt;
	}
	public void setTppt(int tppt) {
		this.tppt = tppt;
	}
	public String getDsNaoConformidade() {
		return dsNaoConformidade;
	}
	public void setDsNaoConformidade(String dsNaoConformidade) {
		this.dsNaoConformidade = dsNaoConformidade;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsCurta() {
		return dsCurta;
	}
	public void setDsCurta(String dsCurta) {
		this.dsCurta = dsCurta;
	}
	public Long getIdTDefeito() {
		return idTDefeito;
	}
	public void setIdTDefeito(Long idTDefeito) {
		this.idTDefeito = idTDefeito;
	}
	public String getAreaResponsavel() {
		return areaResponsavel;
	}
	public void setAreaResponsavel(String areaResponsavel) {
		this.areaResponsavel = areaResponsavel;
	}
	public String getPosicoes() {
		return posicoes;
	}
	public void setPosicoes(String posicoes) {
		this.posicoes = posicoes;
	}
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	
}
