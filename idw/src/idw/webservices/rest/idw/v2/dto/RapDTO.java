package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rap")
public class RapDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idFerramenta;
	private String cdFerramenta;
	private String dsFerramenta;
	private BigDecimal qtTotal;
	private BigDecimal qtAlocada;
	private String cdGrupoFerramenta;
	private String dsGrupoFerramenta;
	private String cdCliente;
	private String dsCliente;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdFerramenta() {
		return idFerramenta;
	}
	public void setIdFerramenta(Long idFerramenta) {
		this.idFerramenta = idFerramenta;
	}
	public String getCdFerramenta() {
		return cdFerramenta;
	}
	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}
	public String getDsFerramenta() {
		return dsFerramenta;
	}
	public void setDsFerramenta(String dsFerramenta) {
		this.dsFerramenta = dsFerramenta;
	}
	public BigDecimal getQtTotal() {
		return qtTotal;
	}
	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}
	public BigDecimal getQtAlocada() {
		return qtAlocada;
	}
	public void setQtAlocada(BigDecimal qtAlocada) {
		this.qtAlocada = qtAlocada;
	}
	public String getCdGrupoFerramenta() {
		return cdGrupoFerramenta;
	}
	public void setCdGrupoFerramenta(String cdGrupoFerramenta) {
		this.cdGrupoFerramenta = cdGrupoFerramenta;
	}
	public String getDsGrupoFerramenta() {
		return dsGrupoFerramenta;
	}
	public void setDsGrupoFerramenta(String dsGrupoFerramenta) {
		this.dsGrupoFerramenta = dsGrupoFerramenta;
	}
	public String getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(String cdCliente) {
		this.cdCliente = cdCliente;
	}
	public String getDsCliente() {
		return dsCliente;
	}
	public void setDsCliente(String dsCliente) {
		this.dsCliente = dsCliente;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	
}
