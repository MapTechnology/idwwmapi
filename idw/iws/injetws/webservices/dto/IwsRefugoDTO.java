package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;



public class IwsRefugoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date DthrUltRefugo;
	private Integer idRefugo;
	private String cdRefugo;
	private String idReduzidaProd;
	private Integer idRevisao;
	private Boolean PedeJust;
	private Boolean PedeCausa;
	private Boolean PedeAcao;
	private Short stRefugoCau;
	private Boolean isAbate;
	private Boolean isConverte;	
	private Boolean isRefugoValido;
	private long Milissegundos;
	private String dsRefugo;
	
	public long getMilissegundos() {
		return Milissegundos;
	}	

	public void setMilissegundos(long Valor) {
		this.Milissegundos = Valor;
	}
	
	public String getCdRefugo() {
		return cdRefugo;
	}	

	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	
	public String getIdReduzidaProd() {
		return idReduzidaProd;
	}	

	public void setIdReduzidaProd(String Idreduzida) {
		this.idReduzidaProd = Idreduzida;
	}

	public Integer getIdRefugo() {
		return idRefugo;
	}

	public void setIdRefugo(Integer idRefugo) {
		this.idRefugo = idRefugo;
	}

	public Integer getIdRevisao() {
		return idRevisao;
	}

	public void setIdRevisao(Integer idRevisao) {
		this.idRevisao = idRevisao;
	}

	public Boolean getPedeAcao() {
		return PedeAcao;
	}

	public void setPedeAcao(Boolean pedeAcao) {
		PedeAcao = pedeAcao;
	}

	public Boolean getPedeCausa() {
		return PedeCausa;
	}

	public void setPedeCausa(Boolean pedeCausa) {
		PedeCausa = pedeCausa;
	}

	public Boolean getPedeJust() {
		return PedeJust;
	}

	public void setPedeJust(Boolean pedeJust) {
		PedeJust = pedeJust;
	}

	public Short getStRefugoCau() {
		return stRefugoCau;
	}

	public void setStRefugoCau(Short stRefugoCau) {
		this.stRefugoCau = stRefugoCau;
	}

	public Boolean getIsAbate() {
		return isAbate;
	}

	public void setIsAbate(Boolean isAbate) {
		this.isAbate = isAbate;
	}

	public Boolean getIsConverte() {
		return isConverte;
	}

	public void setIsConverte(Boolean isConverte) {
		this.isConverte = isConverte;
	}
	public Boolean getIsRefugoValido() {
		return isRefugoValido;
	}

	public void setIsRefugoValido(Boolean isRefugoValido) {
		this.isRefugoValido = isRefugoValido;
	}
	
	/**
	 * @return the DthrUltRefugo
	 */
	public Date getDthrUltRefugo() {
		return DthrUltRefugo;
	}
	/**
	 * @param DthrUltRefugo the DthrUltRefugo to set
	 */
	public void setDthrUltRefugo(Date DthrUltRefugo) {
		this.DthrUltRefugo = DthrUltRefugo;
	}

	public String getDsRefugo() {
		return dsRefugo;
	}

	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}

}
