package idw.webservices.dto;

public class LicencaIDWDTO {
	private Long idEmpresa;
	private Long idModulo;
	private Boolean isLicenciado;
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	public Boolean getIsLicenciado() {
		return isLicenciado;
	}
	public void setIsLicenciado(Boolean isLicenciado) {
		this.isLicenciado = isLicenciado;
	}
}
