package idw.model.rn.folhainspecaorap;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class QqFolhaInsRapDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFolhainsrap;
	private String cdFolhainsrap;
	private Long revisao;
	private String dsFolhainsrap;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	
	
	private String cdproduto;
	
	private List<QqFolhaInsAtivDTO> atividades;
	
	public Long getIdFolhainsrap() {
		return idFolhainsrap;
	}
	public void setIdFolhainsrap(Long idFolhainsrap) {
		this.idFolhainsrap = idFolhainsrap;
	}
	public String getCdFolhainsrap() {
		return cdFolhainsrap;
	}
	public void setCdFolhainsrap(String cdFolhainsrap) {
		this.cdFolhainsrap = cdFolhainsrap;
	}
	public Long getRevisao() {
		return revisao;
	}
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}
	public String getDsFolhainsrap() {
		return dsFolhainsrap;
	}
	public void setDsFolhainsrap(String dsFolhainsrap) {
		this.dsFolhainsrap = dsFolhainsrap;
	}
	public Date getDtRevisao() {
		return dtRevisao;
	}
	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}
	public Date getDtStativo() {
		return dtStativo;
	}
	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}
	public Byte getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}
	public String getCdproduto() {
		return cdproduto;
	}
	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}
	public List<QqFolhaInsAtivDTO> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<QqFolhaInsAtivDTO> atividades) {
		this.atividades = atividades;
	}
}
