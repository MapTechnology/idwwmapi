package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FiltroAnalisePeriodoInjetDTO implements Serializable{

	public final static int GRAFICO_INDICADORES_DATA = 1;
	public final static int GRAFICO_INDICADORES_DATA_AVALIAR = 2;
	
	private Date dtInicio;
	private Date dtFim;
	private String cdTurno;
	private String cdMaquina;
	private String cdMaquinaGrupo;
	private String cdGalpao;
	private String nrop;
	private String cdMolde;
	private String cdMoldeGrupo;
	private String cdProduto;
	private int graficoId;
	
	private boolean isObterParadasPorMotivo = false;
	private boolean isObterParadasPorArea = false;
	
	/**
	 * @return the dtInicio
	 */
	public Date getDtInicio() {
		return dtInicio;
	}
	/**
	 * @param dtInicio the dtInicio to set
	 */
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	/**
	 * @return the dtFim
	 */
	public Date getDtFim() {
		return dtFim;
	}
	/**
	 * @param dtFim the dtFim to set
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	/**
	 * @return the cdTurno
	 */
	public String getCdTurno() {
		return cdTurno;
	}
	/**
	 * @param cdTurno the cdTurno to set
	 */
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
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
	 * @return the cdMaquinaGrupo
	 */
	public String getCdMaquinaGrupo() {
		return cdMaquinaGrupo;
	}
	/**
	 * @param cdMaquinaGrupo the cdMaquinaGrupo to set
	 */
	public void setCdMaquinaGrupo(String cdMaquinaGrupo) {
		this.cdMaquinaGrupo = cdMaquinaGrupo;
	}
	/**
	 * @return the cdMolde
	 */
	public String getCdMolde() {
		return cdMolde;
	}
	/**
	 * @param cdMolde the cdMolde to set
	 */
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	/**
	 * @return the cdMoldeGrupo
	 */
	public String getCdMoldeGrupo() {
		return cdMoldeGrupo;
	}
	/**
	 * @param cdMoldeGrupo the cdMoldeGrupo to set
	 */
	public void setCdMoldeGrupo(String cdMoldeGrupo) {
		this.cdMoldeGrupo = cdMoldeGrupo;
	}
	/**
	 * @return the cdProduto
	 */
	public String getCdProduto() {
		return cdProduto;
	}
	/**
	 * @param cdProduto the cdProduto to set
	 */
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	/**
	 * @return the graficoId
	 */
	public int getGraficoId() {
		return graficoId;
	}
	/**
	 * @param graficoId the graficoId to set
	 */
	public void setGraficoId(int graficoId) {
		this.graficoId = graficoId;
	}
	/**
	 * @return the cdGalpao
	 */
	public String getCdGalpao() {
		return cdGalpao;
	}
	/**
	 * @param cdGalpao the cdGalpao to set
	 */
	public void setCdGalpao(String cdGalpao) {
		this.cdGalpao = cdGalpao;
	}
	/**
	 * @return the nrop
	 */
	public String getNrop() {
		return nrop;
	}
	/**
	 * @param nrop the nrop to set
	 */
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	/**
	 * @return the isObterParadasPorMotivo
	 */
	public boolean isObterParadasPorMotivo() {
		return isObterParadasPorMotivo;
	}
	/**
	 * @param isObterParadasPorMotivo the isObterParadasPorMotivo to set
	 */
	public void setObterParadasPorMotivo(boolean isObterParadasPorMotivo) {
		this.isObterParadasPorMotivo = isObterParadasPorMotivo;
	}
	/**
	 * @return the isObterParadasPorArea
	 */
	public boolean isObterParadasPorArea() {
		return isObterParadasPorArea;
	}
	/**
	 * @param isObterParadasPorArea the isObterParadasPorArea to set
	 */
	public void setObterParadasPorArea(boolean isObterParadasPorArea) {
		this.isObterParadasPorArea = isObterParadasPorArea;
	}
}
