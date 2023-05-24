package injetws.webservices.dto;


import java.io.Serializable;
import java.util.Date;

public class IwsParadaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 98L;

	private String idParada;
	private String cdParada = "";
	private Integer idRevisao;
	private String dsParada;
	private Boolean isParadaAutomatica;
	private Boolean isPesaCalculo;
	private Boolean isPesaMeanTime;
	private Boolean isTecnicoArea;
	private Boolean isPersistente;
	private Boolean isPedeJust;
	private Boolean isPedeCausa;
	private Boolean isPedeAcao;
	private Boolean isPedeFechamento;
	private Boolean isPedeLocal;
	private Boolean isPodeAlterarCdPar;	
	private Integer stMovimentoMolde;
	private Integer qtMinimaTecnicos = 0;
	private Integer stParadaCausa;
	private Boolean isExcessoPesa;
    private Integer idParadaObr;
    private Integer teTimeout;
    private Integer idGrupoUsu;
    private Boolean isRegulagem = false;
    private Boolean isPeriodoSemConexao;
    
    private Date dthrIparada;
    private Date dthrFparada;

    private String cdCausa;
    private String cdAcao;
    private String cdJustificativa;
    private String cdTecnicoResponsavel;
    private String cdTecnicoUm;
    private String cdTecnicoDois;
    private String cdLocal;
    private String txtAnotacao;
    
    private Boolean isPedeAnotacao = false;
    
	public String getCdParada() {
		return cdParada;
	}

	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	
	public String getTxtAnotacao() {
		return txtAnotacao;
	}

	public void setTxtAnotacao(String txtAnotacao) {
		this.txtAnotacao = txtAnotacao;
	}
	
	public String getCdLocal() {
		return cdLocal;
	}

	public void setCdLocal(String cdLocal) {
		this.cdLocal = cdLocal;
	}

	public String getIdParada() {
		return idParada;
	}

	public void setIdParada(String idParada) {
		this.idParada = idParada;
	}

	public Integer getIdRevisao() {
		return idRevisao;
	}

	public void setIdRevisao(Integer idRevisao) {
		this.idRevisao = idRevisao;
	}

	public Boolean getIsParadaAutomatica() {
		return isParadaAutomatica;
	}

	public void setIsParadaAutomatica(Boolean isParadaAutomatica) {
		this.isParadaAutomatica = isParadaAutomatica;
	}

	public Boolean getIsPedeAcao() {
		return isPedeAcao;
	}

	public void setIsPedeAcao(Boolean isPedeAcao) {
		this.isPedeAcao = isPedeAcao;
	}

	public Boolean getIsPedeCausa() {
		return isPedeCausa;
	}

	public void setIsPedeCausa(Boolean isPedeCausa) {
		this.isPedeCausa = isPedeCausa;
	}

	public Boolean getIsPedeFechamento() {
		return isPedeFechamento;
	}

	public void setIsPedeFechamento(Boolean isPedeFechamento) {
		this.isPedeFechamento = isPedeFechamento;
	}

	public Boolean getIsPedeJust() {
		return isPedeJust;
	}

	public void setIsPedeJust(Boolean isPedeJust) {
		this.isPedeJust = isPedeJust;
	}

	public Boolean getIsPedeLocal() {
		return isPedeLocal;
	}

	public void setIsPedeLocal(Boolean isPedeLocal) {
		this.isPedeLocal = isPedeLocal;
	}
	
	public Boolean getIsPesaCalculo() {
		return isPesaCalculo;
	}

	public void setIsPesaCalculo(Boolean isPesaCalculo) {
		this.isPesaCalculo = isPesaCalculo;
	}

	public Boolean getIsPesaMeanTime() {
		return isPesaMeanTime;
	}

	public void setIsPesaMeanTime(Boolean isPesaMeanTime) {
		this.isPesaMeanTime = isPesaMeanTime;
	}

	public Boolean getIsPodeAlterarCdPar() {
		return isPodeAlterarCdPar;
	}

	public void setIsPodeAlterarCdPar(Boolean isPodeAlterarCdPar) {
		this.isPodeAlterarCdPar = isPodeAlterarCdPar;
	}

	public Boolean getIsTecnicoArea() {
		return isTecnicoArea;
	}

	public void setIsTecnicoArea(Boolean isTecnicoArea) {
		this.isTecnicoArea = isTecnicoArea;
	}
	
	public Boolean getIsPeriodoSemConexao() {
		return isPeriodoSemConexao;
	}

	public void setIsPeriodoSemConexao(Boolean isPeriodoSemConexao) {
		this.isPeriodoSemConexao = isPeriodoSemConexao;
	}	

	public Integer getQtMinimaTecnicos() {
		return qtMinimaTecnicos;
	}

	public void setQtMinimaTecnicos(Integer qtMinimaTecnicos) {
		this.qtMinimaTecnicos = qtMinimaTecnicos;
	}

	public Integer getStMovimentoMolde() {
		return stMovimentoMolde;
	}

	public void setStMovimentoMolde(Integer stMovimentoMolde) {
		this.stMovimentoMolde = stMovimentoMolde;
	}

	public Integer getStParadaCausa() {
		return stParadaCausa;
	}

	public void setStParadaCausa(Integer stParadaCausa) {
		this.stParadaCausa = stParadaCausa;
	}

	public Boolean getIsPersistente() {
		return isPersistente;
	}

	public void setIsPersistente(Boolean isPersistente) {
		this.isPersistente = isPersistente;
	}

	public Boolean getIsExcessoPesa() {
		return isExcessoPesa;
	}

	public void setIsExcessoPesa(Boolean isExcessoPesa) {
		this.isExcessoPesa = isExcessoPesa;
	}

	public Integer getIdParadaObr() {
		return idParadaObr;
	}

	public void setIdParadaObr(Integer idParadaObr) {
		this.idParadaObr = idParadaObr;
	}

	public Integer getIdGrupoUsu() {
		return idGrupoUsu;
	}

	public void setIdGrupoUsu(Integer idGrupoUsu) {
		this.idGrupoUsu = idGrupoUsu;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getTeTimeout() {
		return teTimeout;
	}

	public void setTeTimeout(Integer teTimeout) {
		this.teTimeout = teTimeout;
	}

	/**
	 * @return the dsParada
	 */
	public String getDsParada() {
		return dsParada;
	}

	/**
	 * @param dsParada the dsParada to set
	 */
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}

	/**
	 * @return the dthrIparada
	 */
	public Date getDthrIparada() {
		return dthrIparada;
	}

	/**
	 * @param dthrIparada the dthrIparada to set
	 */
	public void setDthrIparada(Date dthrIparada) {
		this.dthrIparada = dthrIparada;
	}

	/**
	 * @return the dthrFparada
	 */
	public Date getDthrFparada() {
		return dthrFparada;
	}

	/**
	 * @param dthrFparada the dthrFparada to set
	 */
	public void setDthrFparada(Date dthrFparada) {
		this.dthrFparada = dthrFparada;
	}
	

	/**
	 * @return the cdCausa
	 */
	public String getCdCausa() {
		return cdCausa;
	}

	/**
	 * @param cdCausa the cdCausa to set
	 */
	public void setCdCausa(String cdCausa) {
		this.cdCausa = cdCausa;
	}

	/**
	 * @return the cdAcao
	 */
	public String getCdAcao() {
		return cdAcao;
	}

	/**
	 * @param cdAcao the cdAcao to set
	 */
	public void setCdAcao(String cdAcao) {
		this.cdAcao = cdAcao;
	}

	/**
	 * @return the cdJustificativa
	 */
	public String getCdJustificativa() {
		return cdJustificativa;
	}

	/**
	 * @param cdJustificativa the cdJustificativa to set
	 */
	public void setCdJustificativa(String cdJustificativa) {
		this.cdJustificativa = cdJustificativa;
	}

	/**
	 * @return the cdTecnicoResponsavel
	 */
	public String getCdTecnicoResponsavel() {
		return cdTecnicoResponsavel;
	}

	/**
	 * @param cdTecnicoResponsavel the cdTecnicoResponsavel to set
	 */
	public void setCdTecnicoResponsavel(String cdTecnicoResponsavel) {
		this.cdTecnicoResponsavel = cdTecnicoResponsavel;
	}

	/**
	 * @return the cdTecnicoUm
	 */
	public String getCdTecnicoUm() {
		return cdTecnicoUm;
	}

	/**
	 * @param cdTecnicoUm the cdTecnicoUm to set
	 */
	public void setCdTecnicoUm(String cdTecnicoUm) {
		this.cdTecnicoUm = cdTecnicoUm;
	}

	/**
	 * @return the cdTecnicoDois
	 */
	public String getCdTecnicoDois() {
		return cdTecnicoDois;
	}

	/**
	 * @param cdTecnicoDois the cdTecnicoDois to set
	 */
	public void setCdTecnicoDois(String cdTecnicoDois) {
		this.cdTecnicoDois = cdTecnicoDois;
	}

	/**
	 * @return the isRegulagem
	 */
	public Boolean getIsRegulagem() {
		return isRegulagem;
	}

	/**
	 * @param isRegulagem the isRegulagem to set
	 */
	public void setIsRegulagem(Boolean isRegulagem) {
		this.isRegulagem = isRegulagem;
	}

	public Boolean getIsPedeAnotacao() {
		return isPedeAnotacao;
	}

	public void setIsPedeAnotacao(Boolean isPedeAnotacao) {
		this.isPedeAnotacao = isPedeAnotacao;
	}
}
